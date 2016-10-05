package com.eric.java.coherence.impl;

import com.eric.java.coherence.LoggerConfigMBean;

public class LoggerConfig implements LoggerConfigMBean{
	private String name;
	private String level;
	
	public LoggerConfig(String name, String level){
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public void report(){
		System.out.println("Logger: " + name + ", level: " + level);
	}
}
