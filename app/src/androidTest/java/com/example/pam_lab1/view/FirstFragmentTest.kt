package com.example.pam_lab1.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.pam_lab1.R
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FirstFragmentTest{
    @Test
    fun test_firstFragment(){
        val scenario = launchFragmentInContainer<FirstFragment>()
        Espresso.onView(withId(R.id.textView)).check(matches(withText("MemoLab")))
    }
}