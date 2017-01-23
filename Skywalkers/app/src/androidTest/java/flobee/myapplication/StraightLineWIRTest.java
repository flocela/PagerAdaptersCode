package flobee.myapplication;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.unregisterIdlingResources;

@RunWith(AndroidJUnit4.class)
public class StraightLineWIRTest {
  private ViewPagerIdlingResource idlingResource;

  private static final String shmi_s   = "Shmi Skywalker";
  private static final String anakin_s = "Anakin Skywalker";
  private static final String leia_o   = "Leia Organa";
  private static final String jacen_s  = "Jacen Solo";
  private static final String allana_s = "Allana Solo";
  private static final String flobee_s = "Flobee Solo";
  private static final String kevin_s  = "Kevin Solo";

  // launch flag should be false so that it is not lazily instantiated. Instead I
  // launch the activity in startActivity().
  @Rule
  public IntentsTestRule<MainActivity> mActivityRule =
    new IntentsTestRule(MainActivity.class, true, false);

  @After
  public void tearDownIdlingResource () {
    unregisterIdlingResources(idlingResource);
  }

  @Test
  public void firstSwipe () {
    /*AA
    Activity activity = startActivity();

    idlingResource = new ViewPagerIdlingResource((ViewPager)activity.
      findViewById(R.id.view_pager), "VPIR_0");
    registerIdlingResources(idlingResource);

    onView(isRoot()).perform(swipeLeft());
    onView(allOf(withId(R.id.character_name),withText(anakin_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(shmi_s))).
      check(matches(not(isCompletelyDisplayed())));
      AA*/
  }

  @Test
  public void seventhSwipe () {
    /*AA
    Activity activity = startActivity();

    idlingResource = new ViewPagerIdlingResource((ViewPager)activity.
      findViewById(R.id.view_pager), "VPIR_0");
    registerIdlingResources(idlingResource);

    onView(isRoot()).perform(swipeLeft());
    onView(allOf(withId(R.id.character_name),withText(anakin_s))).
      check(matches(isCompletelyDisplayed()));

    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(leia_o))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(anakin_s))).
      check(matches(not(isDisplayed())));

    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(jacen_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(leia_o))).
      check(matches(not(isDisplayed())));

    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(flobee_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(jacen_s))).
      check(matches(not(isDisplayed())));

    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(kevin_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(flobee_s))).
      check(matches(not(isDisplayed())));

    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(allana_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(kevin_s))).
      check(matches(not(isDisplayed())));

    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(allana_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(kevin_s))).
      check(matches(not(isDisplayed())));
      AA*/
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