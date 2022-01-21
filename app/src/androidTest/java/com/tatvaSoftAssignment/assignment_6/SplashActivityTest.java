package com.tatvaSoftAssignment.assignment_6;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4ClassRunner.class)
public class SplashActivityTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<SplashActivity>(SplashActivity.class, true, false) {
        @Override
        protected void afterActivityLaunched() {
            super.afterActivityLaunched();
        }
    };

    @Rule
    public IntentsTestRule<SplashActivity> intentsTestRule = new IntentsTestRule<>(SplashActivity.class);


    @Test
    public void viewTest() {

        onView(allOf(withId(R.id.imageView), isDisplayed()));
        onView(allOf(withId(R.id.relativeSplash), isDisplayed()));
        onView(allOf(withId(R.id.uiSignIn), isDisplayed()));

        ViewInteraction materialButton = onView(allOf(withId(R.id.btnSignUp), isDisplayed()));
        materialButton.perform(click());
    }
}
