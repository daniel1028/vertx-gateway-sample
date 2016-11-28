package com.modastylz.api.gateway.constants;

final public class CommandConstants {
    // Product command
	public final static String CREATE_PRODUCT = "create.product";
	public final static String DELETE_PRODUCT = "delete.product";
	public final static String UPDATE_PRODUCT = "update.product";
	public final static String FIND_PRODUCT = "find.product";
	
	//Color command
		public final static String CREATE_COLOR = "create.color";
		public final static String DELETE_COLOR = "delete.color";
		public final static String UPDATE_COLOR= "update.color";
		public final static String FIND_COLOR = "find.color";
	
    // Brand command

    // Style command
	
	private CommandConstants() {
		throw new AssertionError();
	}
}
