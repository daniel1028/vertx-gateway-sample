package com.modastylz.api.gateway.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.modastylz.api.gateway.constants.CommandConstants;
import com.modastylz.api.gateway.constants.ConfigConstants;
import com.modastylz.api.gateway.constants.MessageConstants;
import com.modastylz.api.gateway.constants.MessagebusEndpoints;
import com.modastylz.api.gateway.constants.RouteConstants;
import com.modastylz.api.gateway.routes.utils.RouteRequestUtility;
import com.modastylz.api.gateway.routes.utils.RouteResponseUtility;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class RouteColorConfigurator implements RouteConfigurator {
	private static final Logger LOG = LoggerFactory.getLogger("com.modastylz.api.gateway.bootstrap.ServerVerticle");

	private EventBus eb = null;
	private long mbusTimeout;
	
	@Override
	public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
		eb = vertx.eventBus();
		mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, RouteConstants.DEFAULT_TIMEOUT);
		router.post(RouteConstants.EP_COLORS).handler(this::createColor);
		router.put(RouteConstants.EP_COLOR).handler(this::updateColor);

	}
	private void createColor (RoutingContext routingContext){
		DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout);
		options.addHeader(MessageConstants.MSG_HEADER_OP, CommandConstants.CREATE_COLOR);
		eb.send(MessagebusEndpoints.MBEP_COLOR, RouteRequestUtility.getBodyForMessage(routingContext), options,
				reply -> RouteResponseUtility.responseHandler(routingContext, reply, LOG));
	}
	
	private void updateColor (RoutingContext routingContext){
		DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout);
		options.addHeader(MessageConstants.MSG_HEADER_OP, CommandConstants.UPDATE_COLOR);
		eb.send(MessagebusEndpoints.MBEP_COLOR, RouteRequestUtility.getBodyForMessage(routingContext), options,
				reply -> RouteResponseUtility.responseHandler(routingContext, reply, LOG));
		
	}

}
