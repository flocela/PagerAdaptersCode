package flobee.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  ChildButtonListener listener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
    CharacterAdapter characterAdapter = new SkywalkerAdapter();
    characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.allanaSolo));
    PagerAdapter myFragPagerAdapter =
      new MyFragPagerAdapter(this.getSupportFragmentManager(),characterAdapter);
    viewPager.setAdapter(myFragPagerAdapter);

    //For posting number of fragments in Activity.
    viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
      @Override
      public void onPageSelected(int position) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
          @Override
          public void run() {
            int numOfFragments = MainActivity.this
              .getSupportFragmentManager().getFragments().size();
            TextView fragmentCountView = (TextView) MainActivity.this
              .findViewById(R.id.num_of_fragments);
            if (fragmentCountView != null)
              fragmentCountView.setText("" + numOfFragments);
          }
        });
      }
    });
  }

  public ChildButtonListener getChildListener () {
    return null;
  }

}

/**START
   CharacterView characterView = (CharacterView)findViewById(R.id.character_view);
   characterView.setCharacter(SkyWalker.shmiSkywalker);
 START*/

  /*AA
  //MyPlainPagerAdapter
  ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
  CharacterAdapter characterAdapter = new SkywalkerAdapter();
  //ArrayList<Character> allanaSoloFamily = SkyWalker.getLineageFor(SkyWalker.allanaSolo);
  //characterAdapter.addCharacters(allanaSoloFamily);
  PagerAdapter plainAdapter = new MyPlainPagerAdapter(characterAdapter);
  viewPager.setAdapter(plainAdapter);
  AA*/

  /*EE1
  //MyFragPagerAdapter
  ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
  CharacterAdapter characterAdapter = new SkywalkerAdapter();
  ArrayList<Character> allanaSoloFamily = SkyWalker.getLineageFor(SkyWalker.allanaSolo);
  characterAdapter.addCharacters(allanaSoloFamily);
  PagerAdapter myFragPagerAdapter =
    new MyFragPagerAdapter(this.getSupportFragmentManager(),characterAdapter);
  viewPager.setAdapter(myFragPagerAdapter);

  //For posting number of fragments in Activity.
  viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
    @Override
    public void onPageSelected (int position) {
      new Handler(Looper.getMainLooper()).post(new Runnable() {
        @Override
        public void run() {
          int numOfFragments = MainActivity.this
            .getSupportFragmentManager().getFragments().size();
          TextView fragmentCountView = (TextView)MainActivity.this
            .findViewById(R.id.num_of_fragments);
          if (fragmentCountView != null)
            fragmentCountView.setText("" + numOfFragments);
        }
      });
    }
  });

  public ChildButtonListener getChildListener () {
    return null;
  }
  EE1*/

  /*EE2
  public ChildButtonListener getChildListener () {
   if (listener != null)
      return listener;
    else {
      return new ChildButtonListener() {
        @Override
        public void changeChildTo(String parent, String nextChild) {
          ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
          if (viewPager!= null) {
            MyFragPagerAdapter adapter = (MyFragPagerAdapter)viewPager.getAdapter();
            adapter.changeChildTo(parent, nextChild);
            adapter.notifyDataSetChanged();
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
          }
        }
      };
    }
  }
  EE2*/

/*JJ
   characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.allanaSolo));
    characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.benSkywalker));
    characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.jainaSolo));
    characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.anakinSolo));
 JJ*/


  /*KK
  //MyFragStatePagerAdapter
  ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
  CharacterAdapter characterAdapter = new SkywalkerAdapter();
  characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.allanaSolo));
  characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.benSkywalker));
  characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.jainaSolo));
  characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.anakinSolo));
  PagerAdapter myFragStatePagerAdapter =
    new MyFragStatePagerAdapter(this.getSupportFragmentManager(),characterAdapter);
  viewPager.setAdapter(myFragStatePagerAdapter);

  and in ChildButtonListener change FragPagerAdapter to FragStatePagerAdapter
  KK*/

  /*LL add to onCreate() method
  getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
  LL*/

