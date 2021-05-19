package com.example.pam_lab1.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.pam_lab1.R
import kotlinx.android.synthetic.main.activity_destiny_list.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DestinationListActivityTest{

    @get: Rule
    val activityRule = ActivityScenarioRule(DestinationListActivity::class.java)

    @Test
    fun test_isActivityInView(){
        onView(withId(R.id.destiny_recycler_view)).check(ViewAssertions.matches(isDisplayed()))
    }

}
