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
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/*
* This test verifies the following USER scenario
*
*
* Given that I am a student.
* When I click on a swipe location on the swipes page.
* I should see details regarding the swiping option related to the amount of swipes required to get food.
* */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class SwipeInformationS2 {

    @Rule
    public ActivityTestRule<splashWelcome> mActivityTestRule = new ActivityTestRule<>(splashWelcome.class);

    @Test
    public void swipeInformationS2() {

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4000); // Sleeps on user level thread.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {

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

            appCompatImageButton = onView(
                    allOf(withContentDescription("Open"),
                            childAtPosition(
                                    allOf(withId(R.id.action_bar),
                                            childAtPosition(
                                                    withId(R.id.action_bar_container),
                                                    0)),
                                    1),
                            isDisplayed()));
            appCompatImageButton.perform(click());

            // Testing navigation bar.
            ViewInteraction navigationMenuItemView = onView(
                    allOf(childAtPosition(
                            allOf(withId(R.id.design_navigation_view),
                                    childAtPosition(
                                            withId(R.id.nav_drawer),
                                            0)),
                            1),
                            isDisplayed()));
            navigationMenuItemView.perform(click());

            // Test interaction with Au Bon Pain button from activity_food_swipes page.
            ViewInteraction appCompatButton = onView(
                    allOf(withId(R.id.button1), withText("Au Bon Pain"),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("android.widget.ScrollView")),
                                            0),
                                    2)));
            appCompatButton.perform(scrollTo(), click());

            ViewInteraction viewGroup = onView(
                    allOf(childAtPosition(
                            allOf(withId(android.R.id.content),
                                    childAtPosition(
                                            withId(R.id.decor_content_parent),
                                            1)),
                            0),
                            isDisplayed()));
            viewGroup.check(matches(isDisplayed()));

        } catch (Exception e){
            System.out.println(e);
        }

    }

    // Test matcher defined by expresso
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
