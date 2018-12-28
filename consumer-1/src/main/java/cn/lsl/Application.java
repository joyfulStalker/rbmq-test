package cn.lsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

/**
 * @author liusonglin
 * @date 2018年10月31日
 */

@Controller
@SpringBootApplication
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
