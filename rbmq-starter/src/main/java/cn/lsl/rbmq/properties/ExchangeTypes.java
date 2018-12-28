package cn.lsl.rbmq.properties;
public abstract class ExchangeTypes {

	/**
	 * Direct exchange.
	 */
	public static final String DIRECT = "direct";

	/**
	 * Topic exchange.
	 */
	public static final String TOPIC = "topic";

	/**
	 * Fanout exchange.
	 */
	public static final String FANOUT = "fanout";

	/**
	 * Headers exchange.
	 */
	public static final String HEADERS = "headers";

	/**
	 * System exchange.
	 */
	public static final String SYSTEM = "system";

}