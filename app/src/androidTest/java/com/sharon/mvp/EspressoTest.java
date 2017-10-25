package com.sharon.mvp;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.sharon.mvp.login.LoginActivity;
import com.sharon.mvp.main.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by admin on 10/15/17.
 */
//The @Runwith annotation will tell the JUnit to run the tests in this class using the Android JUnit test runner.
@RunWith(AndroidJUnit4.class)

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EspressoTest {

    public static final int LOGIN_ID = R.id.username_et;
    public static final String PASSWORD_HINT_TEXT= "password";
    public static final String PASSWORD_TEXT="tesco";
//The Rule will make sure to launch the Login activity directly. This means that when testing an n-layer activity,
// you don’t need to do all the steps to start it. Simply define that in the rule and you are ready to go.
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);


    @Before
    public void setUp() throws Exception {
        //Before Test case execution
    }


    public void alogin() {
      onView(withId(LOGIN_ID)).perform(typeText("a"));
        Espresso.onView(withHint(PASSWORD_HINT_TEXT)).perform(typeText(PASSWORD_TEXT));
        Espresso.onView(withText("Log in")).check(matches(isEnabled()));
        Espresso.onView(withText("Log in")).perform(click());
        Espresso.onView((withText("Item 1"))).check(matches(isDisplayed()));

    }


    public void bitem1(){
        Espresso.onView(withText("Item 1")).perform(click());
    }

    @Test
    public void run(){
        alogin();
        bitem1();
    }

    public void login () {

    }




    @After
    public void tearDown() throws Exception {
        //After Test case Execution
    }
}
