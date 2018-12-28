package cn.lsl.producer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lsl.rbmq.api.RbmqSender;

@Controller
@RequestMapping("test")
public class Producer01 {

	@Autowired
	private RbmqSender sender;

	/**
	 * 发送消息
	 * 
	 * @param uuid
	 * @param message
	 *            消息
	 * @throws IOException
	 */
	@GetMapping("test01")
	public void send() throws IOException {
		sender.sendMsgToMq("e1", "q1", "path1", "我写的。。");
		System.out.println("发送结束。。。");
	}

}
