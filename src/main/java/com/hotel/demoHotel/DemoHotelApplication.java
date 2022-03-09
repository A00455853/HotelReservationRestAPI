package com.hotel.demoHotel;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHotelApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(DemoHotelApplication.class, args);
	}

}
