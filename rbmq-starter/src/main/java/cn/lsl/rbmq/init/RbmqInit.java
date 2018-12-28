package cn.lsl.rbmq.init;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import cn.lsl.rbmq.properties.BindingQueueToExchange;
import cn.lsl.rbmq.properties.ExchangeBean;
import cn.lsl.rbmq.properties.ExchangeTypes;
import cn.lsl.rbmq.properties.QueueBean;
import cn.lsl.rbmq.properties.RbmqProperties;

@EnableConfigurationProperties({ RbmqProperties.class })
public class RbmqInit {

	private static final Logger logger = LoggerFactory.getLogger(RbmqInit.class);

	private ConnectionFactory factory;

	@Autowired
	private RbmqProperties rbmqProperties;

	/**
	 * 获取connection
	 * 
	 * @author liusonglin
	 * @date 2018年12月28日
	 * @return
	 * @throws IOException
	 * @throws TimeoutException
	 */
	@Bean
	public Connection getConnection() throws IOException, TimeoutException {
		logger.info("-----初始化连接工厂-----");
		if (null == factory) {
			factory = new ConnectionFactory();
		}
		factory.setPort(rbmqProperties.getPort());
		factory.setHost(rbmqProperties.getHost());
		factory.setVirtualHost(rbmqProperties.getVirtualHost());
		factory.setUsername(rbmqProperties.getUsername());
		factory.setPassword(rbmqProperties.getPassword());
		logger.info("-----初始化连接工厂成功-----");
		return factory.newConnection();
	}
	/**
	 * 注入交换机
	 * 
	 * @author liusonglin
	 * @date 2018年12月28日
	 * @return
	 */

	@Bean
	public ExchangeBean[] initExchange() {
		ExchangeBean[] e = new ExchangeBean[2];
		for (int i = 0; i < e.length; i++) {
			e[i] = new ExchangeBean("e" + i, ExchangeTypes.FANOUT);
		}
		return e;
	}

	/**
	 * 初始化queue
	 * 
	 * @author liusonglin
	 * @date 2018年12月28日
	 * @return
	 */

	@Bean
	public QueueBean[] initQueue() {
		QueueBean[] q = new QueueBean[2];
		for (int i = 0; i < q.length; i++) {
			q[i] = new QueueBean("q" + i);
		}
		return q;
	}

	@Bean
	public BindingQueueToExchange[] initBindingQueueToExchanges() {
		BindingQueueToExchange[] bindingQueueToExchanges = new BindingQueueToExchange[2];
		bindingQueueToExchanges[0] = new BindingQueueToExchange("e0", "q0", "path0");
		bindingQueueToExchanges[1] = new BindingQueueToExchange("e1", "q1", "path1");
		return bindingQueueToExchanges;
	}
	/**
	 * 获取channel
	 * 
	 * @author liusonglin
	 * @date 2018年12月28日
	 * @param conn
	 * @return
	 * @throws IOException
	 */

	@Bean
	public Channel getChannel(Connection conn, ExchangeBean[] exchanges, QueueBean[] queues,
			BindingQueueToExchange[] bindingQueueToExchanges) throws IOException {
		logger.info("-----初始化连接mq通道-----");
		Channel channel = conn.createChannel();
		if (null == channel) {
			logger.info("-----初始化连接mq通道失败-----");
			return null;
		}
		if (null != exchanges) {
			for (ExchangeBean exchange : exchanges) {
				channel.exchangeDeclare(exchange.getExchangeName(), exchange.getExchangeType());
			}
		}
		if (null != queues) {
			for (QueueBean queue : queues) {
				channel.queueDeclare(queue.getQueueName(), false, false, false, null);
			}
		}
		if (null != bindingQueueToExchanges) {
			for (BindingQueueToExchange bindingQueueToExchange : bindingQueueToExchanges) {
				channel.queueBind(bindingQueueToExchange.getQueue(), bindingQueueToExchange.getExchange(),
						bindingQueueToExchange.getRoutePath());
			}
		}
		logger.info("-----初始化连接mq通道成功-----");
		return conn.createChannel();
	}

	
}
