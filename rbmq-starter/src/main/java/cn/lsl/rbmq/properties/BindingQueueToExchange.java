package cn.lsl.rbmq.properties;

/**
 * 绑定队列到交换机
 * 
 * @author liusonglin
 * @date 2018年12月28日
 */

public class BindingQueueToExchange {

	public BindingQueueToExchange(String exchange, String queue, String routePath) {
		this.exchange = exchange;
		this.queue = queue;
		this.routePath = routePath;
	}

	private String exchange;

	private String queue;

	private String routePath;

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getRoutePath() {
		return routePath;
	}

	public void setRoutePath(String routePath) {
		this.routePath = routePath;
	}

}
