package com.example.pam_lab1.view

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
import com.example.pam_lab1.R
import kotlinx.android.synthetic.main.fragment_first.view.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button)).check(matches(isDisplayed()))
    }
    @Test
    fun test_navSecondActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.Activity_List)).check(matches(isDisplayed()))
    }
    @Test
    fun test_navFirstActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.Activity_List)).check(matches(isDisplayed()))

        pressBack()

        onView(withId(R.id.Activity_Welcome)).check(matches(isDisplayed()))
    }
}