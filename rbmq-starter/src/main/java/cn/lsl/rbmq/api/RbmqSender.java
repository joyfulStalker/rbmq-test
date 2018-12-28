package cn.lsl.rbmq.api;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabbitmq.client.Channel;

public class RbmqSender {
	private static final Logger logger = LoggerFactory.getLogger(RbmqSender.class);

	@Autowired
	private Channel channel;

	/**
	 * TODO description
	 * 
	 * @author liusonglin
	 * @date 2018年12月28日
	 * @param exchange
	 *            交换机名称
	 * @param queue
	 *            队列名称
	 * @param jsonMsg
	 *            json数据 包含 to_url和发送数据
	 * @return
	 * @throws IOException
	 */

	public boolean sendMsgToMq(String exchange, String queue, String routingKey, String jsonMsg) throws IOException {

		if (null == channel) {
			logger.info("----无法获取mq连接--------");
			return false;
		}
		logger.info("----mq连接成功--------");

		// 开启事物
		channel.txSelect();
		channel.basicPublish(exchange, routingKey, null, jsonMsg.getBytes("utf-8"));
		// 提交事物
		channel.txCommit();

		logger.info("----进入发送mq消息----");
		return true;
	}

}
