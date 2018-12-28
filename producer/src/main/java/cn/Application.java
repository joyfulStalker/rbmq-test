package cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

/**
 * @MapperScan 用于扫描mapper
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
