package flobee.myapplication;


import android.support.test.espresso.PerformException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.util.HumanReadables;
import android.support.test.espresso.util.TreeIterables;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class StraightLineWViewAction {

  private static final String shmi_s   = "Shmi Skywalker";
  private static final String anakin_s = "Anakin Skywalker";
  private static final String leia_o   = "Leia Organa";
  private static final String jacen_s  = "Jacen Solo";
  private static final String allana_s = "Allana Solo";
  private static final String flobee_s = "Flobee Solo";
  private static final String kevin_s  = "Kevin Solo";

  @Rule
  public ActivityTestRule mActivityRule = new ActivityTestRule(MainActivity.class);

  @Test
  public void oneSwipe () {
    onView(isRoot()).perform(swipeLeft());
    onView(isRoot())
      .perform(waitForMatch(
        allOf(isCompletelyDisplayed(), withText(anakin_s), withId(R.id.character_name)),
              2500));
    onView(isRoot())
      .perform(waitForMatch(
        allOf(not(isDisplayed()), withText(shmi_s), withId(R.id.character_name)),
        1500));
  }

  @Test
  public void sevenSwipes () {
    onView(isRoot()).perform(swipeLeft());
    onView(isRoot())
      .perform(waitForMatch(
        allOf(isCompletelyDisplayed(), withText(anakin_s), withId(R.id.character_name)),
        2500));
    onView(isRoot()).perform(swipeLeft());
    onView(isRoot())
      .perform(waitForMatch(
        allOf(isCompletelyDisplayed(), withText(leia_o), withId(R.id.character_name)),
        1500));

    onView(isRoot()).perform(swipeLeft());
    onView(isRoot())
      .perform(waitForMatch(
        allOf(isCompletelyDisplayed(), withText(jacen_s), withId(R.id.character_name)),
        1500));

    onView(isRoot()).perform(swipeLeft());
    onView(isRoot())
      .perform(waitForMatch(
        allOf(isCompletelyDisplayed(), withText(flobee_s), withId(R.id.character_name)),
        1500));

    onView(isRoot()).perform(swipeLeft());
    onView(isRoot())
      .perform(waitForMatch(
        allOf(isCompletelyDisplayed(), withText(kevin_s), withId(R.id.character_name)),
        1500));

    onView(isRoot()).perform(swipeLeft());
    onView(isRoot())
      .perform(waitForMatch(
        allOf(isCompletelyDisplayed(), withText(allana_s), withId(R.id.character_name)),
        1500));

    onView(isRoot()).perform(swipeLeft());
    onView(isRoot())
      .perform(waitForMatch(
        allOf(isCompletelyDisplayed(), withText(allana_s), withId(R.id.character_name)),
        1500));
  }

  public void waitForViewPagerResponse(long millis) {
    final long startTime = System.currentTimeMillis();
    final long endTime = startTime + millis;
    do {}
    while (System.currentTimeMillis() < endTime);
  }

  //an example of waitForMatch()
  //onView(isRoot())
  //.perform(waitForMatch(allOf(isDisplayed(), withText("apple 0b")),1500));
  public static ViewAction waitForMatch(final Matcher<View> matcher, final long millis) {
    return new ViewAction() {
      @Override
      public Matcher<View> getConstraints() {
        return isRoot(); // I only work on the root view!
      }

      @Override
      public String getDescription() {
        return "wait for a specific view with id <" + matcher.toString() + "> during " + millis +
          " millis.";
      }

      @Override
      public void perform(final UiController uiController, final View view) {
        Log.i("ATAG", "in perform");
        uiController.loopMainThreadUntilIdle();
        final long startTime = System.currentTimeMillis();
        final long endTime = startTime + millis;
        do {
          for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
            Log.i("ATAG", "iterating through tree");
            if (matcher.matches(child)) {
              Log.i("ATAG", "view");
              return;
            }
          }
          uiController.loopMainThreadForAtLeast(50);
        }
        while (System.currentTimeMillis() < endTime);

        throw new PerformException.Builder() // timeout happens
          .withActionDescription(this.getDescription())
          .withViewDescription(HumanReadables.describe(view))
          .withCause(new TimeoutException())
          .build();
      }
    };
  }
}
