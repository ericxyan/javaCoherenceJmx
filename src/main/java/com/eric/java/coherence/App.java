package com.eric.java.coherence;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;

import com.eric.java.coherence.impl.LoggerConfig;

public class App {
	public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException{
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		LoggerConfigMBean loggerConfigMBean = new LoggerConfig("App.class", "INFO");
		StandardMBean mbean = new StandardMBean(loggerConfigMBean, LoggerConfigMBean.class);
		ObjectName objectName = new ObjectName("com.eric.java.coherence.App:type=config,target=logger");
		mBeanServer.registerMBean(mbean, objectName);
		
		do{
			Thread.sleep(5000);
			System.out.println("Running: " + loggerConfigMBean.getName() + ": " + loggerConfigMBean.getLevel() + " in App");
		}while(loggerConfigMBean.getLevel().equals("INFO"));
	}
}
