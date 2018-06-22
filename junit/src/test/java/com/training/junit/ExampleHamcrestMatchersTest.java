package com.training.junit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExampleHamcrestMatchersTest {

	@InjectMocks
	private ExampleHamcrestMatchers hmcrstMtchrs;

	private ExamplePojo expected;

	@Before
	public void setUp() throws Exception {
		expected = new ExamplePojo();
		expected.setCondition(false);
		expected.setNumber(10);
		expected.setValue(0.95f);
		expected.setWord("Sample");
	}

	@After
	public void tearDown() throws Exception {
		expected = null;
	}

	@Test
	public void getUpdatedPojo() {

		ExamplePojo actual = hmcrstMtchrs.getUpdatedPojo();
		assertThat(actual, samePropertyValuesAs(expected));

	}

}
