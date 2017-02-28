package com.spd.config;

import com.spd.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SampleApplication {

	private static final Logger logger = LoggerFactory.getLogger(SampleApplication.class);
	
	public static void main(String[] args){

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);

		BankService service = (BankService) context.getBean("bankService");
		
		logger.info("Inform ->" + service.getByName("CANADA"));
		logger.info("Inform ->" + service.getByName("AMERICA"));
		logger.info("Inform ->" + service.getByName("CHINA"));
		logger.info("Refreshing all banks");
		service.refreshAllBanks();
		logger.info("Inform [after refresh]->" + service.getByName("UKRAINE"));
		logger.info("Inform [after refresh]->" + service.getByName("TURKEY"));
		logger.info("Inform [after refresh]->" + service.getByName("FREEDOM"));
		
		context.close();

	}
}
