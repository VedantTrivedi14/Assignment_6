package com.tatvaSoftAssignment.assignment_6;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;

import org.junit.Test;

public class MainActivityTest {

    @Test
    public void mainActivityTest() {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(allOf(withId(R.id.uiSignIn),isDisplayed()));

        onView(allOf(withId(R.id.etName),isDisplayed())).perform(typeText("ved"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etEmail),isDisplayed())).perform(typeText("ved@gmail.com"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etPhone),isDisplayed())).perform(typeText("9904441108"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etAddress),isDisplayed())).perform(typeText("bhavnagar"),closeSoftKeyboard());

        onView(withId(R.id.spinnerCountry)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("India"))).perform(click());
        onView(withId(R.id.spinnerCountry)).check(matches(withSpinnerText(containsString("India"))));

        onView(allOf(withId(R.id.etDate),isDisplayed())).perform(click());
        onView(withText("OK")).perform(click());

        onView(allOf(withId(R.id.txtGender),isDisplayed()));
        onView(withId(R.id.rbMale)).perform(ViewActions.scrollTo(),click()).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.rbFemale)).perform(ViewActions.scrollTo(),click()).check(ViewAssertions.matches(isDisplayed()));

        onView(allOf(withId(R.id.txtHobbies),isDisplayed()));
        onView(withId(R.id.checkReading)).perform(ViewActions.scrollTo(),click()).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.checkDrawing)).perform(ViewActions.scrollTo(),click()).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.checkChess)).perform(ViewActions.scrollTo(),click()).check(ViewAssertions.matches(isDisplayed()));

        onView(withId(R.id.btnSignIn)).perform(ViewActions.scrollTo(),click()).check(ViewAssertions.matches(isDisplayed()));

        onView(withText("Sign In SuccessFully")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void validateTest(){
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(allOf(withId(R.id.etName))).check(ViewAssertions.matches(not("")));
        onView(allOf(withId(R.id.etEmail))).check(ViewAssertions.matches(not("")));
        onView(allOf(withId(R.id.etPhone))).check(ViewAssertions.matches(not("")));
        onView(allOf(withId(R.id.etAddress))).check(ViewAssertions.matches(not("")));
        onView(allOf(withId(R.id.spinnerCountry))).check(ViewAssertions.matches(not("")));
        onView(allOf(withId(R.id.etDate))).check(ViewAssertions.matches(not("")));
        onView(allOf(withId(R.id.rbMale))).check(ViewAssertions.matches(isChecked()));
        onView(allOf(withId(R.id.rbFemale))).check(ViewAssertions.matches(isNotChecked()));
        onView(allOf(withId(R.id.checkReading))).check(ViewAssertions.matches(isNotChecked()));
        onView(allOf(withId(R.id.checkChess))).check(ViewAssertions.matches(isNotChecked()));
        onView(allOf(withId(R.id.checkDrawing))).check(ViewAssertions.matches(isNotChecked()));
    }

}