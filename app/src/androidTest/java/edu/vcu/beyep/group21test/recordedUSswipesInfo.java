package edu.vcu.beyep.group21test;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import edu.vcu.beyep.group21test.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class recordedUSswipesInfo {

    @Rule
    public ActivityTestRule<splashWelcome> mActivityTestRule = new ActivityTestRule<>(splashWelcome.class);

    @Test
    public void recordedUSswipesInfo() {
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
try {
 Thread.sleep(4000);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
        
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
        
        ViewInteraction navigationMenuItemView = onView(
allOf(childAtPosition(
allOf(withId(R.id.design_navigation_view),
childAtPosition(
withId(R.id.nav_drawer),
0)),
1),
isDisplayed()));
        navigationMenuItemView.perform(click());
        
        ViewInteraction linearLayout = onView(
allOf(childAtPosition(
allOf(withId(R.id.drawer),
childAtPosition(
withId(android.R.id.content),
0)),
0),
isDisplayed()));
        linearLayout.check(matches(isDisplayed()));
        
        ViewInteraction scrollView = onView(
allOf(childAtPosition(
allOf(withId(R.id.drawer),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        scrollView.check(matches(isDisplayed()));
        
        ViewInteraction appCompatButton = onView(
allOf(withId(R.id.Au_bon_pain), withText("Au Bon Pain"),
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
        
        ViewInteraction button = onView(
allOf(withId(R.id.back),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        button.check(matches(isDisplayed()));
        
        ViewInteraction appCompatButton2 = onView(
allOf(withId(R.id.back), withText("back"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatButton2.perform(click());
        
        ViewInteraction scrollView2 = onView(
allOf(childAtPosition(
allOf(withId(R.id.drawer),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        scrollView2.check(matches(isDisplayed()));
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
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
