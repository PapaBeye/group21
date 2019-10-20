package edu.vcu.beyep.group21test;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class splashWelcomeTest2 {

    @Rule
    public ActivityTestRule<splashWelcome> mActivityTestRule = new ActivityTestRule<>(splashWelcome.class);

    @Test
    public void splashWelcomeTest2() throws InterruptedException {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        ViewInteraction textView = onView(
                allOf(withText("Home Screen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.drawer),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Home Screen")));

        Thread.sleep(1000);
        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Open"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        Thread.sleep(1000);

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        Thread.sleep(1000);

        ViewInteraction checkedTextView = onView(
                allOf(withId(R.id.design_menu_item_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        1),
                                0),
                        isDisplayed()));
        checkedTextView.check(matches(isDisplayed()));

        Thread.sleep(1000);
        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_drawer),
                                        0)),
                        1),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        Thread.sleep(1000);

        ViewInteraction textView2 = onView(
                allOf(withText("Swipes INFO Page"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.drawer),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Swipes INFO Page")));

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Open"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Close"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Open"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());
        Thread.sleep(1000);
        ViewInteraction navigationMenuItemView2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_drawer),
                                        0)),
                        3),
                        isDisplayed()));
        navigationMenuItemView2.perform(click());

        Thread.sleep(1000);
        ViewInteraction textView3 = onView(
                allOf(withText("Home Screen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.drawer),
                                        0),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("Home Screen")));

        Thread.sleep(1000);
        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("Open"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        Thread.sleep(1000);

        ViewInteraction navigationMenuItemView3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_drawer),
                                        0)),
                        4),
                        isDisplayed()));
        navigationMenuItemView3.perform(click());

        ViewInteraction scrollView = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.drawer),
                                0),
                        0),
                        isDisplayed()));
        scrollView.check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withContentDescription("Open"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction navigationMenuItemView4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_drawer),
                                        0)),
                        1),
                        isDisplayed()));
        navigationMenuItemView4.perform(click());

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withContentDescription("Open"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        ViewInteraction navigationMenuItemView5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_drawer),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView5.perform(click());

        ViewInteraction textView4 = onView(
                allOf(withText("Create Events Page"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.drawer),
                                        0),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("Create Events Page")));
    }

    public static Matcher<View> childAtPosition(
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
