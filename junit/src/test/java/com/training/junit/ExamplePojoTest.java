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
@PrepareForTest({ExampleUtil.class, ExamplePojo.class})
public class ExamplePojoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

    @Test
    public void testMethodMakingPrivateMethodCall() throws Exception {
        ExamplePojo spyExamplePojo = PowerMockito.spy(new ExamplePojo());
        when(spyExamplePojo, method(ExamplePojo.class, "privateMethod", String.class)).withArguments(anyString()).thenReturn("test test");
        String result = spyExamplePojo.methodMakingPrivateMethodCall("test");
        assertEquals("test test", result);
    }
 
    @Test
    public void testMethodMakingStaticNonVoidMethodCall() throws Exception {
        mockStatic(ExampleUtil.class);
        PowerMockito.when(ExampleUtil.sayHello(anyString())).thenReturn("test test");
        String result = new ExamplePojo().methodMakingStaticNonVoidMethodCall("test");
        assertEquals("test test", result);
    }
 
    @Test
    public void testMethodMakingStaticVoidMethodCall() throws Exception {
        mockStatic(ExampleUtil.class);
        PowerMockito.doNothing().when(ExampleUtil.class, "printHello", (anyString()));
        new ExamplePojo().methodMakingStaticVoidMethodCall("test");
    }

}
