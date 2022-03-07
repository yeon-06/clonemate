package com.ndex.clonemate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClonemateApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(ClonemateApplication.class, args);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
