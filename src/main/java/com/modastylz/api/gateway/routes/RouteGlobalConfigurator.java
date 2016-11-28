package com.modastylz.api.gateway.routes;

import com.modastylz.api.gateway.constants.ConfigConstants;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class RouteGlobalConfigurator implements RouteConfigurator {

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        final long maxSizeInMb = config.getLong(ConfigConstants.MAX_REQ_BODY_SIZE, 5L);
        BodyHandler bodyHandler = BodyHandler.create().setBodyLimit(maxSizeInMb * 1024 * 1024);

        router.route().handler(bodyHandler);

    }

}
