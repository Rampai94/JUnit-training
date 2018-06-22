package com.training.junit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ExamplePowerMock.class, ExamplePojo.class, ExampleUtil.class})
public class ExamplePowerMockTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	/*
	 * 
	 * Test private methods using spy and 
	 * check that it returns what is expected
	 */
    @Test 
    public void privateMethodCall() throws Exception {
    	ExamplePowerMock spyExamplePojo = PowerMockito.spy(new ExamplePowerMock());
        when(spyExamplePojo, method(ExamplePowerMock.class, "privateMethod", String.class)).withArguments(anyString()).thenReturn("test test");
        String result = spyExamplePojo.methodMakingPrivateMethodCall("test");
        assertEquals("test test", result);
    }
    
    /*
     * Test static non void method call and 
     * check for the return value
     * 
     */
    @Test
    public void staticNonVoidMethodCall() throws Exception {
        mockStatic(ExampleUtil.class);
        PowerMockito.when(ExampleUtil.getMessage(anyString())).thenReturn("test test");
        String result = new ExamplePowerMock().methodMakingStaticNonVoidMethodCall("test");
        assertEquals("test test", result);
    }
    
    /*
     * 
     * Test static void method call using doNothing.
     * doAnswer block can also be used to 
     * perform specific operation when void method is called.
     */
    @Test
    public void staticVoidMethodCall() throws Exception {
        mockStatic(ExampleUtil.class);
        PowerMockito.doNothing().when(ExampleUtil.class, "printMessage", (anyString()));
        new ExamplePowerMock().methodMakingStaticVoidMethodCall("test");
    }

}
