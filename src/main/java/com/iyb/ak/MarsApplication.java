package com.iyb.ak;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
//@RefreshScope
@Slf4j
public class MarsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MarsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>>>>>>>>>>>> sc-mars 启动完成<<<<<<<<<<<<<");
	}
}
