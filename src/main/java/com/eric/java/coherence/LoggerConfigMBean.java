package com.eric.java.coherence;

public interface LoggerConfigMBean {
	public String getName();

	public void setName(String name);

	public String getLevel();

	public void setLevel(String level);
	
	public void report();
}
