package com.moneywise.core;


import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import com.moneywise.job.MyJob;




@ComponentScan("com.moneywise")
@EnableAutoConfiguration
public class Application {
	
	

	

    public static void main(String[] args) throws SchedulerException, InterruptedException {
    	
    	
    	
        SpringApplication.run(Application.class, args);
        
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        
        
       // System.out.println);
      
        JobDetail job= JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
   
     // Trigger the job to run on the next round minute
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").
        		withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();
        scheduler.scheduleJob(job, trigger);
        
        scheduler.start();
        
        Thread.sleep(90L * 1000L);
        
        
        scheduler.shutdown(true);
        
    }
}