package com.training.junit;

public class ExampleHamcrestMatchers {
	
	public ExamplePojo getUpdatedPojo() {
		ExamplePojo bean = new ExamplePojo();
		bean.setCondition(false);
		bean.setNumber(10);
		bean.setValue(0.95f);
		bean.setWord("Sample");
		return bean;
	}
}
