package com.modastylz.api.gateway.constants;

public class RouteConstants {

	// Helper constants
	private static final String API_VERSION = "v1";
	private static final String API_BASE_ROUTE = "/api/" + API_VERSION + "/";
	public static final long DEFAULT_TIMEOUT = 30000L;

	// Helper: Entity name constants

	// Helper: Operations
	private static final String PRODUCTS = "products";
	private static final String COLORS = "colors";

	private static final String ID = ":id";

	// Misc helpers
	private static final String SEP = "/";

	public static final String EP_PRODUCTS = API_BASE_ROUTE + PRODUCTS;
	
	public static final String EP_COLORS= API_BASE_ROUTE + COLORS;

	public static final String EP_COLOR= API_BASE_ROUTE + COLORS+ SEP + ID;;
	
	public static final String EP_PRODUCT = API_BASE_ROUTE + PRODUCTS+ SEP + ID;

}
