package cn.lsl.rbmq.properties;

/**
 * 用于queue注入
 * 
 * @author liusonglin
 * @date 2018年12月28日
 */

public class QueueBean {

	public QueueBean(String queueName) {
		this.queueName = queueName;
	}

	private String queueName;

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

}
