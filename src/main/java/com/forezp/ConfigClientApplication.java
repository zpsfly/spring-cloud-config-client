package com.forezp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * client 工程启动的时候，会根据配置文件的配置访问server,server会根据访问git上文件名spring.application.name-spring.cloud.config.profile
 * 的文件，然后把配置文件的值赋值给@Value注解
 * http://localhost:8881/imageurl
 * @author Administrator
 *
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;
	
	
	@RequestMapping(value = "/hi")
	public String hi(){
		return foo;
	}
	
	@Value("${image.url}")
	String imageurl;
	
	
	@RequestMapping(value = "/imageurl")
	public String imageUrl(){
		return imageurl;
	}
	
	
}
