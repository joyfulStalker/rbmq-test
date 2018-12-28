package cn.lsl.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class Consumer01 {
	@RabbitListener(queues = "q1")
	public void handleMessage5(String message) {
		// 处理消息
		String[] split = message.split(",");
		byte[] b = new byte[split.length];
		for (int i = 0; i < split.length; i++) {
			b[i] = Byte.parseByte(split[i]);
		}
		String msg = new String(b);
		System.out.println("q1接收到的数据：" + msg);

	}

	@RabbitListener(queues = "test01Queue")
	public void handleMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag)
			throws Exception {
		// 处理消息
		try {
			System.out.println("1接收到的数据：" + message);
			int i = 1 / 0;
			Thread.sleep(1000);

			channel.basicAck(tag, false);

		} catch (Exception e) {

			channel.basicAck(tag, true);

		}
	}

	@RabbitListener(queues = "test01Queue")
	public void handleMessage1(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag)
			throws Exception {
		// 处理消息
		try {
			// int i = 1/0;
			System.out.println("2接收到的数据：" + message);

			channel.basicAck(tag, false);

		} catch (Exception e) {

			channel.basicAck(tag, true);

		}
	}

	@RabbitListener(queues = "test01Queue")
	public void handleMessage2(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag)
			throws Exception {
		// 处理消息
		try {
			// int i = 1/0;
			System.out.println("3接收到的数据：" + message);

			channel.basicAck(tag, false);

		} catch (Exception e) {

			channel.basicAck(tag, true);

		}
	}
}
