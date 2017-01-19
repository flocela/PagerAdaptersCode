package flobee.myapplication;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  ChildListener childListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    /* STARTCharacterView characterView = (CharacterView)findViewById(R.id.character_view);
    characterView.setCharacter(SkyWalker.shmiSkywalker); START*/

    ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
    CharacterAdapter characterAdapter = new SkywalkerAdapter();
    characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.allanaSolo));
    characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.benSkywalker));
    characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.jainaSolo));
    characterAdapter.addCharacters(SkyWalker.getLineageFor(SkyWalker.anakinSolo));
    PagerAdapter myFragStatePagerAdapter =
      new MyFragStatePagerAdapter(this.getSupportFragmentManager(),characterAdapter);
    viewPager.setAdapter(myFragStatePagerAdapter);

  }

  public ChildListener getChildListener () {
    return new ChildListener() {
      @Override
      public void changeChildTo(String parent, String nextChild) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        MyFragStatePagerAdapter adapter = (MyFragStatePagerAdapter) viewPager.getAdapter();
        adapter.changeChildTo(parent, nextChild);
        adapter.notifyDataSetChanged();
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
      }
    };
  }
}

    /*AA MyPlainPagerAdapter implementation /*
    ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
    CharacterAdapter characterAdapter = new SkywalkerAdapter();
    ArrayList<Character> allanaSoloFamily = SkyWalker.getLineageFor(SkyWalker.allanaSolo);
    characterAdapter.addCharacters(allanaSoloFamily);
    PagerAdapter plainAdapter = new MyPlainPagerAdapter(characterAdapter);
    viewPager.setAdapter(plainAdapter);
    //AA */

  /*FF
  public ChildListener getChildListener () {
    if (null != childListener) {
      childListener = new CharacterView.ChildListener() {
      @Override
      public void changeChildTo(String parent, String nextChild) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        SwitcherAdapter adapter = (SwitcherAdapter) viewPager.getAdapter();
        adapter.changeChildTo(parent, nextChild);
        adapter.notifyDataSetChanged();
        if (parent != null)
          viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
      }
     }
     return childListener;
    };
  }FF*/

/*JJ
  public ChildListener getChildListener () {
    return new ChildListener() {
      @Override
      public void changeChildTo(String parent, String nextChild) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        MyFragPagerAdapter adapter = (MyFragPagerAdapter) viewPager.getAdapter();
        adapter.changeChildTo(parent, nextChild);
        adapter.notifyDataSetChanged();
        if (parent != null)
          viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
      }
    };
  }

  MyFragPagerAdapter implementation
    ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
    CharacterAdapter characterAdapter = new SkywalkerAdapter();
    ArrayList<Character> allanaSoloFamily = SkyWalker.getLineageFor(SkyWalker.allanaSolo);
    characterAdapter.addCharacters(allanaSoloFamily);
    PagerAdapter myFragPagerAdapter =
      new MyFragPagerAdapter(this.getSupportFragmentManager(),characterAdapter);
    viewPager.setAdapter(myFragPagerAdapter);
 JJ */

/*MM
getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
 */