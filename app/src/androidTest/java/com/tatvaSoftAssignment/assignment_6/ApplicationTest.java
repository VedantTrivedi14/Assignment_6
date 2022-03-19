package com.tatvaSoftAssignment.assignment_6;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void applicationTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnSignUp), withText("Sign Up"),
                        childAtPosition(
                                allOf(withId(R.id.relativeSplash),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.etName),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.uiSignIn),
                                        0),
                                0)));
        appCompatEditText.perform(scrollTo(), replaceText("ved"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.etEmail),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.uiSignIn),
                                        0),
                                1)));
        appCompatEditText2.perform(scrollTo(), replaceText("ved@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.etPhone),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.uiSignIn),
                                        0),
                                2)));
        appCompatEditText3.perform(scrollTo(), replaceText("9904441108"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.etAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.uiSignIn),
                                        0),
                                3)));
        appCompatEditText4.perform(scrollTo(), replaceText("bvn"), closeSoftKeyboard());

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.spinnerCountry),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.uiSignIn),
                                        0),
                                4)));
        appCompatSpinner.perform(scrollTo(), click());

        DataInteraction materialTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(0);
        materialTextView.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.etDate),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.uiSignIn),
                                        0),
                                5)));
        appCompatEditText5.perform(scrollTo(), click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton2.perform(scrollTo(), click());

        ViewInteraction materialCheckBox = onView(
                allOf(withId(R.id.checkReading), withText("Reading"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        8),
                                0)));
        materialCheckBox.perform(scrollTo(), click());

        ViewInteraction materialCheckBox2 = onView(
                allOf(withId(R.id.checkChess), withText("Chess"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        8),
                                1)));
        materialCheckBox2.perform(scrollTo(), click());

        ViewInteraction materialCheckBox3 = onView(
                allOf(withId(R.id.checkDrawing), withText("Drawing"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        8),
                                2)));
        materialCheckBox3.perform(scrollTo(), click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.rbFemale), withText("female"),
                        childAtPosition(
                                allOf(withId(R.id.rgButton),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                1)));
        materialRadioButton.perform(scrollTo(), click());

        ViewInteraction materialRadioButton2 = onView(
                allOf(withId(R.id.rbMale), withText("male"),
                        childAtPosition(
                                allOf(withId(R.id.rgButton),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                0)));
        materialRadioButton2.perform(scrollTo(), click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btnSignIn), withText("Sign_In"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.uiSignIn),
                                        0),
                                9)));
        materialButton3.perform(scrollTo(), click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
