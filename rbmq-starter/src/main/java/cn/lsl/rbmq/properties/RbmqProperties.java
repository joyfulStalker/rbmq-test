package cn.lsl.rbmq.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * rabbitmq conf
 * 
 * @author liusonglin
 * @date 2018年12月27日
 */

@ConfigurationProperties(prefix = "rbmq.rabbitmq")
public class RbmqProperties {

	/**
	 * mq地址
	 */
	private String host;

	/**
	 * 虚拟主机名称
	 */
	private String virtualHost;

	/**
	 * mq端口
	 */
	private int port;

	/**
	 * 登录名
	 */
	private String username;

	/**
	 * 登录密码
	 */
	private String password;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getVirtualHost() {
		return virtualHost;
	}

	public void setVirtualHost(String virtualHost) {
		this.virtualHost = virtualHost;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
