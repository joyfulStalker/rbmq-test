package cn.lsl.rbmq.properties;

/**
 * 用于注入exchange
 * 
 * @author liusonglin
 * @date 2018年12月28日
 */

public class ExchangeBean {

	public ExchangeBean(String exchangeName, String exchangeType) {
		this.exchangeName = exchangeName;
		this.exchangeType = exchangeType;
	}

	private String exchangeName;

	private String exchangeType;

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

}
