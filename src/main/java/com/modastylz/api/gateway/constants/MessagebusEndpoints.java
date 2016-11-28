package com.modastylz.api.gateway.constants;

/**
 * It contains the definition for the "Message Bus End Points" which are
 * addresses on which the consumers are listening. Note that these definitions
 * are for gateway, and each end point would be defined in their own component
 * as well. This means that if there is any change here, there must be a
 * corresponding change in the consumer as well.
 */
public class MessagebusEndpoints {
	public static final String MBEP_PRODUCT = "com.modastylz.api.message.bus.product";
	
	public static final String MBEP_COLOR = "com.modastylz.api.message.bus.color";

	public static final String MBEP_METRICS = "com.modastylz.api.message.bus.metrics";
}
