package com.example.ezinvoicecustomer;

import android.app.Activity;
import android.widget.EditText;

import androidx.test.annotation.UiThreadTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

//    @Mock
//    FirebaseAuth auth;
//    @Mock
//    ProgressBar progressBar;
//    @Mock
//    Button btnSignup;
//    @Mock
//    Button btnLogin;
//    @Mock
//    Button btnReset;
//    @Mock
//    AppCompatDelegate mDelegate;
//    @Mock
//    Resources mResources;
//    @Mock
//    FragmentController mFragments;
//    @Mock
//    LifecycleRegistry mFragmentLifecycleRegistry;
//    //Field mContextAwareHelper of type ContextAwareHelper - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
//    @Mock
//    LifecycleRegistry mLifecycleRegistry;
//    //Field mSavedStateRegistryController of type SavedStateRegistryController - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
//    @Mock
//    ViewModelStore mViewModelStore;
//    @Mock
//    ViewModelProvider.Factory mDefaultFactory;
//    //Field mOnBackPressedDispatcher of type OnBackPressedDispatcher - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
//    @Mock
//    AtomicInteger mNextLocalRequestCode;
//    @Mock
//    ActivityResultRegistry mActivityResultRegistry;
//    @Mock
//    SimpleArrayMap<Class<? extends ComponentActivity.ExtraData>, ComponentActivity.ExtraData> mExtraDataMap;
//    @InjectMocks
//    LoginActivity loginActivity;

//    @Mock
//    LoginActivity loginActivity = new LoginActivity();


//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

@RunWith(MockitoJUnitRunner.class)
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "Feature"
//        ,glue={"stepDefinition"}
//)
public class LoginActivityTest {
    @Mock
    EditText inputEmail;
    EditText inputPassword;
    MainActivity mMockMainActivity;

    @UiThreadTest
    @Test
    public void testNoErrorInCapitalization() {
//        final String msg = "this is a sample";
//        mMessage.setText(msg);
//        mCapitalize.performClick();
//        final String actual = mMessage.getText().toString();
//        final String notExpectedRegexp = "(?i:ERROR)";
//        assertNotContainsRegex("Capitalization found error:",
//                notExpectedRegexp, actual);

//        final Activity activity = activityTestRule.getActivity();
        final Activity activity = mMockMainActivity;
        final EditText editText = activity.findViewById(R.id.password);

    }

//    @Test
//    public void testOnCreate() {
////        LoginActivity loginActivity = new LoginActivity();
////        loginActivity.onCreate(null);
////        inputEmail = findViewById(R.id.email);
////        onView(withId(R.id.myButton)).perform(ViewActions.click());
////        TouchUtils.clickView(this, mClickMeButton);
//
//        Button button = (Button) findViewByid(R.id.mybutton);
//        button.performClick();
//        inputPassword = inputPassword.findViewById(R.id.password);
////        inputEmail.setText("biggerstaff-s@ulster.ac.uk");
//        inputPassword.setText("password");
//        assertEquals(inputEmail.getText(), "biggerstaff-s@ulster.ac.uk");
//    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme