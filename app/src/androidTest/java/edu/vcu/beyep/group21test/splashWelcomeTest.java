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

import static edu.vcu.beyep.group21test.splashWelcomeTest2.childAtPosition;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class splashWelcomeTest {

    @Rule
    public ActivityTestRule<splashWelcome> mActivityTestRule = new ActivityTestRule<>(splashWelcome.class);

    @Test
    public void splashWelcomeTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
            ViewInteraction textView = onView(
                    allOf(withText("Home Screen"),
                            childAtPosition(
                            childAtPosition(withId(R.id.drawer), 0), 0), isDisplayed()));
            textView.check(matches(withText("Home Screen")));
            System.out.println("Home Screen Works");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
        ViewInteraction textView = onView(
allOf(withText("Home Screen"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView.check(matches(withText("Home Screen")));
        
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
        
        ViewInteraction recyclerView = onView(
allOf(withId(R.id.design_navigation_view),
childAtPosition(
allOf(withId(R.id.nav_drawer),
childAtPosition(
withId(R.id.drawer),
1)),
0),
isDisplayed()));
        recyclerView.check(matches(isDisplayed()));
        
        ViewInteraction checkedTextView = onView(
allOf(withId(R.id.design_menu_item_text),
childAtPosition(
childAtPosition(
withId(R.id.design_navigation_view),
1),
0),
isDisplayed()));
        checkedTextView.check(matches(isDisplayed()));
        
        ViewInteraction checkedTextView2 = onView(
allOf(withId(R.id.design_menu_item_text),
childAtPosition(
childAtPosition(
withId(R.id.design_navigation_view),
2),
0),
isDisplayed()));
        checkedTextView2.check(matches(isDisplayed()));
        
        ViewInteraction checkedTextView3 = onView(
allOf(withId(R.id.design_menu_item_text),
childAtPosition(
childAtPosition(
withId(R.id.design_navigation_view),
3),
0),
isDisplayed()));
        checkedTextView3.check(matches(isDisplayed()));
        
        ViewInteraction checkedTextView4 = onView(
allOf(withId(R.id.design_menu_item_text),
childAtPosition(
childAtPosition(
withId(R.id.design_navigation_view),
4),
0),
isDisplayed()));
        checkedTextView4.check(matches(isDisplayed()));
        
        ViewInteraction checkedTextView5 = onView(
allOf(withId(R.id.design_menu_item_text),
childAtPosition(
childAtPosition(
withId(R.id.design_navigation_view),
4),
0),
isDisplayed()));
        checkedTextView5.check(matches(isDisplayed()));
        
        ViewInteraction appCompatImageButton2 = onView(
allOf(withContentDescription("Close"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        appCompatImageButton2.perform(click());
        
        ViewInteraction textView2 = onView(
allOf(withText("Home Screen"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView2.check(matches(withText("Home Screen")));
        
        ViewInteraction appCompatImageButton3 = onView(
allOf(withContentDescription("Open"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        appCompatImageButton3.perform(click());
        
        ViewInteraction navigationMenuItemView = onView(
allOf(childAtPosition(
allOf(withId(R.id.design_navigation_view),
childAtPosition(
withId(R.id.nav_drawer),
0)),
3),
isDisplayed()));
        navigationMenuItemView.perform(click());
        
        ViewInteraction textView3 = onView(
allOf(withText("Home Screen"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView3.check(matches(withText("Home Screen")));
        
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
        
        ViewInteraction navigationMenuItemView2 = onView(
allOf(childAtPosition(
allOf(withId(R.id.design_navigation_view),
childAtPosition(
withId(R.id.nav_drawer),
0)),
1),
isDisplayed()));
        navigationMenuItemView2.perform(click());
        
        ViewInteraction textView4 = onView(
allOf(withText("Swipes INFO Page"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView4.check(matches(withText("Swipes INFO Page")));
        
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
        
        ViewInteraction navigationMenuItemView3 = onView(
allOf(childAtPosition(
allOf(withId(R.id.design_navigation_view),
childAtPosition(
withId(R.id.nav_drawer),
0)),
1),
isDisplayed()));
        navigationMenuItemView3.perform(click());
        
        ViewInteraction textView5 = onView(
allOf(withText("Swipes INFO Page"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView5.check(matches(withText("Swipes INFO Page")));
        
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
2),
isDisplayed()));
        navigationMenuItemView4.perform(click());
        
        ViewInteraction textView6 = onView(
allOf(withText("Create Events Page"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView6.check(matches(withText("Create Events Page")));
        
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
        
        ViewInteraction textView7 = onView(
allOf(withText("Create Events Page"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView7.check(matches(withText("Create Events Page")));
        
        ViewInteraction appCompatImageButton8 = onView(
allOf(withContentDescription("Open"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        appCompatImageButton8.perform(click());
        
        ViewInteraction navigationMenuItemView6 = onView(
allOf(childAtPosition(
allOf(withId(R.id.design_navigation_view),
childAtPosition(
withId(R.id.nav_drawer),
0)),
3),
isDisplayed()));
        navigationMenuItemView6.perform(click());
        
        ViewInteraction appCompatImageButton9 = onView(
allOf(withContentDescription("Open"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        appCompatImageButton9.perform(click());
        
        ViewInteraction navigationMenuItemView7 = onView(
allOf(childAtPosition(
allOf(withId(R.id.design_navigation_view),
childAtPosition(
withId(R.id.nav_drawer),
0)),
3),
isDisplayed()));
        navigationMenuItemView7.perform(click());
        
        ViewInteraction textView8 = onView(
allOf(withText("Home Screen"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView8.check(matches(withText("Home Screen")));
        
        ViewInteraction appCompatImageButton10 = onView(
allOf(withContentDescription("Open"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        appCompatImageButton10.perform(click());
        
        ViewInteraction navigationMenuItemView8 = onView(
allOf(childAtPosition(
allOf(withId(R.id.design_navigation_view),
childAtPosition(
withId(R.id.nav_drawer),
0)),
4),
isDisplayed()));
        navigationMenuItemView8.perform(click());
        
        ViewInteraction textView9 = onView(
allOf(withText("Events Page"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView9.check(matches(withText("Events Page")));
        
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
        
        ViewInteraction appCompatImageButton11 = onView(
allOf(withContentDescription("Open"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        appCompatImageButton11.perform(click());
        
        ViewInteraction textView10 = onView(
allOf(withText("Events Page"),
childAtPosition(
childAtPosition(
withId(R.id.drawer),
0),
0),
isDisplayed()));
        textView10.check(matches(withText("Events Page")));
        
        ViewInteraction appCompatImageButton12 = onView(
allOf(withContentDescription("Open"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        appCompatImageButton12.perform(click());
        
        ViewInteraction imageButton2 = onView(
allOf(withContentDescription("Close"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
0),
isDisplayed()));
        imageButton2.check(matches(isDisplayed()));
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
*/