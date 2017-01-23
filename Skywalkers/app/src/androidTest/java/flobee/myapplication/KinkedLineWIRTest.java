package flobee.myapplication;


import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.view.ViewPager;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.Espresso.unregisterIdlingResources;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class KinkedLineWIRTest {
  private ViewPagerIdlingResource idlingResource;

  private static final String shmi_s        = "Shmi Skywalker";
  private static final String anakin_s      = "Anakin Skywalker";
  private static final String luke_s        = "Luke Skywalker";
  private static final String ben_skywalker = "Ben Skywalker";
  private static final String leia_o        = "Leia Organa";
  private static final String allana_s      = "Allana Solo";

  @Rule
  public ActivityTestRule<MainActivity> mActivityRule =
    new ActivityTestRule<>(
      MainActivity.class,
      true,     // initialTouchMode
      false);   // launchActivity. False to customize the intent

  @After
  public void tearDownIdlingResource () {
    unregisterIdlingResources(idlingResource);
  }


  @Test
  public void oneSwipe () {
///*HH
    Activity activity = startActivity();

    idlingResource = new ViewPagerIdlingResource((ViewPager)activity.
      findViewById(R.id.view_pager), "VPIR_0");
    registerIdlingResources(idlingResource);

    onView(isRoot()).perform(swipeLeft());
    onView(allOf(withId(R.id.character_name),withText(anakin_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(shmi_s))).
      check(matches(not(isDisplayed())));
     // HH*/
  }

  // KinkedLineWIRTest toBenThenToAllana fails half the time when
  // NoPageTransformer is not added even when Developer Animations are off.
  // When this happened ViewPager.SimpleOnPageChangeListener 's methods in
  // idling resource were never not called after first perform(swipeLeft()).
  // Since setting viewPager.setPageTransformer, this has failed twice.
  @Test
  public void toBenThenToAllana () {
    ///*HH
    Activity activity = startActivity();

    idlingResource = new ViewPagerIdlingResource((ViewPager)activity.
      findViewById(R.id.view_pager), "VPIR_0");
    registerIdlingResources(idlingResource);

    onView(isRoot()).perform(swipeLeft());
    onView(allOf(withId(R.id.offspring_button), withText(luke_s), isDisplayed())).perform(click());
    onView(allOf(withId(R.id.character_name),withText(luke_s))).
      check(matches(isCompletelyDisplayed()));

    onView(isRoot()).perform(swipeLeft());
    onView(allOf(withId(R.id.character_name),withText(ben_skywalker))).
      check(matches(isDisplayed()));

    onView(isRoot()).perform(swipeRight());
    onView(isRoot()).perform(swipeRight());
    onView(allOf(withId(R.id.character_name),withText(anakin_s))).
      check(matches(isCompletelyDisplayed()));

    onView(allOf(withId(R.id.offspring_button), withText(leia_o), isDisplayed())).perform(click());
    onView(allOf(withId(R.id.character_name),withText(leia_o))).
      check(matches(isCompletelyDisplayed()));
    onView(isRoot()).perform(swipeLeft());
    onView(isRoot()).perform(swipeLeft());
    onView(isRoot()).perform(swipeLeft());
    onView(isRoot()).perform(swipeLeft());
    onView(allOf(withId(R.id.character_name),withText(allana_s))).
      check(matches(isDisplayed()));
     // HH*/
  }

  private MainActivity startActivity() {
    return mActivityRule.launchActivity(null);
  }

  public void waitForViewPagerResponse(long millis) {
    final long startTime = System.currentTimeMillis();
    final long endTime = startTime + millis;
    do {}
    while (System.currentTimeMillis() < endTime);
  }
}
