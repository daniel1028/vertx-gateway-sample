package com.modastylz.api.gateway.responses.writers;

import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.Message;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.modastylz.api.gateway.constants.HttpConstants;
import com.modastylz.api.gateway.responses.auth.transformers.ResponseTransformer;
import com.modastylz.api.gateway.responses.auth.transformers.ResponseTransformerBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpServerResponseWriter implements ResponseWriter {
    static final Logger LOG = LoggerFactory.getLogger(ResponseWriter.class);
    private final RoutingContext routingContext;
    private final AsyncResult<Message<Object>> message;

    public HttpServerResponseWriter(RoutingContext routingContext, AsyncResult<Message<Object>> message) {
        this.routingContext = routingContext;
        this.message = message;
    }

    @Override
    public void writeResponse() {
        ResponseTransformer transformer = new ResponseTransformerBuilder().build(message.result());
        final HttpServerResponse response = routingContext.response();
        // First set the status code
        response.setStatusCode(transformer.transformedStatus());
        // Then set the headers
        Map<String, String> headers = transformer.transformedHeaders();
        if (headers != null && !headers.isEmpty()) {
            // Never accept content-length from others, we do that
            headers.keySet().stream()
                .filter(headerName -> !headerName.equalsIgnoreCase(HttpConstants.HEADER_CONTENT_LENGTH))
                .forEach(headerName -> response.putHeader(headerName, headers.get(headerName)));
        }
        // Then it is turn of the body to be set and ending the response
        final String responseBody =
            ((transformer.transformedBody() != null) && (!transformer.transformedBody().isEmpty())) ? transformer
                .transformedBody().toString() : null;
        if (responseBody != null) {
            response.putHeader(HttpConstants.HEADER_CONTENT_LENGTH, Integer.toString(responseBody.getBytes(StandardCharsets.UTF_8).length));
            response.end(responseBody);
        } else {
            response.end();
        }
    }
}
