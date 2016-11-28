package com.modastylz.api.gateway.routes;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.dropwizard.MetricsService;
import io.vertx.ext.web.Router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.modastylz.api.gateway.constants.ConfigConstants;
import com.modastylz.api.gateway.constants.MessagebusEndpoints;

class RouteMetricsConfigurator implements RouteConfigurator {

    static final Logger LOG = LoggerFactory.getLogger("com.modastylz.api.gateway.bootstrap.ServerVerticle");

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

        final MetricsService metricsService = MetricsService.create(vertx);

        // Send a metrics events as per period defined, once we convert it to
        // milliseconds
        final int metricsPeriodicitySeconds = config.getInteger(ConfigConstants.METRICS_PERIODICITY);

        vertx.setPeriodic(metricsPeriodicitySeconds * 1000, t -> {
            JsonObject metrics = metricsService.getMetricsSnapshot(vertx);
            vertx.eventBus().publish(MessagebusEndpoints.MBEP_METRICS, metrics);
        });
    }

}
