package com.spd;


import com.spd.service.AtmService;
import com.spd.service.WorkerService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
        public static void main(String[] args) throws Exception {
                AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

                WorkerService workerService = (WorkerService) context.getBean("workerService");

                workerService.getExtensionCount("C:\\Windows\\System32");
                workerService.getExtensionCount("C:\\Windows\\");
                workerService.getEmployeeEfficiency();

                AtmService atmService = (AtmService) context.getBean("atmService");
                atmService.enterPinCode(0);

                context.close();
        }
}
