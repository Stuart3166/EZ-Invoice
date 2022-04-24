//package com.example.ezinvoicecustomer;
//
//import static org.junit.Assert.assertTrue;
//
//import android.app.Instrumentation;
//import android.content.Context;
//import android.content.Intent;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.test.core.app.ApplicationProvider;
//import androidx.test.platform.app.InstrumentationRegistry;
//
//import junit.framework.TestCase;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito.*;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import javax.annotation.meta.When;
//
////public class LoginUnitTests{
////    private static final String hi = "";
////    @Test
////}
//////public class RegisterActivityTest extends TestCase {
//////
//////}
//
//@RunWith(MockitoJUnitRunner.class)
//public class LoginUnitTest {
//
//    private static final String FAKE_STRING = "Login was successful";
//    InstrumentationRegistry.getContext();
//    @Before
//    public void setup() {
//        //Initialize UiDevice instance
//        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
//        mDevice = UiDevice.getInstance(instrumentation);
//
//        mDevice.pressHome();
//
//        Intent intent = new Intent("com.REDACTED.auto.diagnostics.dealer.MAIN");
//        intent.setClassName("com.REDACTED.auto.diagnostics", "com.REDACTED.auto.diagnostics.dealer.MainActivity");
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        Context context = InstrumentationRegistry.getContext();
//        context.startActivity(intent);
//    }
//
//    @Mock
//    AppCompatActivity LoginActivity;
//
//    @Test
//    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
//        assertTrue(LoginActivity.getClass().isValidEmail("name@email.com"));
//        InstrumentationRegistry.getContext();
//        assertTrue(LoginActivity.getClass().isValidEmail("name@email.com"));
//    }
//
//}