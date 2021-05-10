package com.example.pam_lab1

import android.content.Context
import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pam_lab1.view.DestinationListActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Before
     fun setup() {
//        val ctx = InstrumentationRegistry.getInstrumentation().context
//        val intent = Intent(DestinationListActivity(), DestinationListActivity::class.java)
//        assertEquals(ctx.startActivity(intent),)

    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.pam_lab1", appContext.packageName)
    }
}