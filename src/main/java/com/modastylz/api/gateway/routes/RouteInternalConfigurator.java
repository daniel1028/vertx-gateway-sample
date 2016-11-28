package com.modastylz.api.gateway.routes;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.dropwizard.MetricsService;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RouteInternalConfigurator implements RouteConfigurator {

    static final Logger LOG = LoggerFactory.getLogger("com.modastylz.api.gateway.bootstrap.ServerVerticle");

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        router.route("/banner").handler(
            routingContext -> {
                JsonObject result =
                    new JsonObject().put("Organisation", "modastylz.com").put("Product", "api")
                        .put("purpose", "API gateway server");
                routingContext.response().end(result.toString());
            });

        final MetricsService metricsService = MetricsService.create(vertx);
        router.route("/metrics").handler(routingContext -> {
            JsonObject ebMetrics = metricsService.getMetricsSnapshot(vertx);
            routingContext.response().end(ebMetrics.toString());
        });
    }
}
