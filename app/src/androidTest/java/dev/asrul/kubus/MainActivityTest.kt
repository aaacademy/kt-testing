package dev.asrul.kubus

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class MainActivityTest{
    private val dummyPanjang = "1.5"
    private val dummyLebar = "2.0"
    private val dummyTinggi = "2.5"

    private val dummyVolume = "7.5"
    private val dummyKeliling = "24.0"
    private val dummyLuas = "23.5"

    private val dummyEmpty = ""
    private val dummyMessagePanjang = "Kolom panjang harus diisi"
    private val dummyMessageLebar = "Kolom lebar harus diisi"
    private val dummyMessageTinggi = "Kolom tinggi harus diisi"

    @Before
    fun persiapan() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun assertGetVolume() {
        onView(withId(R.id.edt_panjang)).perform(typeText(dummyPanjang), closeSoftKeyboard())
        onView(withId(R.id.edt_lebar)).perform(typeText(dummyLebar), closeSoftKeyboard())
        onView(withId(R.id.edt_tinggi)).perform(typeText(dummyTinggi), closeSoftKeyboard())

        // check ada atau tidak tombol save
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_volume)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_volume)).perform(click())

        onView(withId(R.id.tv_hasil)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_hasil)).check(matches(withText(dummyVolume)))
    }

    @Test
    fun assertGetKeliling() {
        onView(withId(R.id.edt_panjang)).perform(typeText(dummyPanjang), closeSoftKeyboard())
        onView(withId(R.id.edt_lebar)).perform(typeText(dummyLebar), closeSoftKeyboard())
        onView(withId(R.id.edt_tinggi)).perform(typeText(dummyTinggi), closeSoftKeyboard())

        // check ada atau tidak tombol save
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_keliling)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_keliling)).perform(click())

        onView(withId(R.id.tv_hasil)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_hasil)).check(matches(withText(dummyKeliling)))
    }

    @Test
    fun assertGetLuas() {
        onView(withId(R.id.edt_panjang)).perform(typeText(dummyPanjang), closeSoftKeyboard())
        onView(withId(R.id.edt_lebar)).perform(typeText(dummyLebar), closeSoftKeyboard())
        onView(withId(R.id.edt_tinggi)).perform(typeText(dummyTinggi), closeSoftKeyboard())

        // check ada atau tidak tombol save
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_luas)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_luas)).perform(click())

        onView(withId(R.id.tv_hasil)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_hasil)).check(matches(withText(dummyLuas)))
    }

    @Test
    fun assertEmptyField() {
        onView(withId(R.id.edt_panjang)).perform(typeText(dummyEmpty), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.edt_panjang)).check(matches(hasErrorText(dummyMessagePanjang)))
        onView(withId(R.id.edt_panjang)).perform(typeText(dummyPanjang), closeSoftKeyboard())

        onView(withId(R.id.edt_lebar)).perform(typeText(dummyEmpty), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.edt_lebar)).check(matches(hasErrorText(dummyMessageLebar)))
        onView(withId(R.id.edt_lebar)).perform(typeText(dummyLebar), closeSoftKeyboard())

        onView(withId(R.id.edt_tinggi)).perform(typeText(dummyEmpty), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.edt_tinggi)).check(matches(hasErrorText(dummyMessageTinggi)))
        onView(withId(R.id.edt_tinggi)).perform(typeText(dummyTinggi), closeSoftKeyboard())
    }
}