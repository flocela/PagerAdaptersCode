package flobee.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.methodsDeclaredIn;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class) // PowerMockRunner is required calling whenNew
@PrepareForTest({CharacterFragment.class})
public class MyFragPagerAdapterKinkedUTest {

  private static ArrayList<Character> shmiToAlana;

  @Mock Context           mockContext;
  @Mock FragmentManager   mockFragmentManager;
  @Mock CharacterView     mockCharacterView;
  @Mock CharacterView     mockBadCharacterView;
  @Mock CharacterAdapter  mockCharacterAdapter;
  @Mock ViewGroup         mockContainerView;
  @Mock Drawable          mockDrawable;
  @Mock CharacterFragment mockLeiaFragment;
  @Mock CharacterFragment mockAnakinFragment;
  @Mock Character         mockShmiS;
  @Mock Character         mockAnankinS;
  @Mock Character         mockLeiaO;
  @Mock Character         mockJacenS;
  @Mock Character         mockAllanaS;

  @Mock long mockAnakinHash;
  @Mock int  mockPosition;
  int    itemPosition = 10;
  String leiaOName = "Leia Organa";

 // /*JJ
  @Before
  public void init () {
    //suppress(constructorsDeclaredIn(FragmentPagerAdapter.class) should
    // have been enough, but required (methodsDeclaredIn())
    suppress(methodsDeclaredIn(FragmentPagerAdapter.class));
    when(mockLeiaO.getName()).thenReturn(leiaOName);
    mockStatic(CharacterFragment.class);

  }

  // tests getCount()
  // gets count from mockCharacterAdapter and returns that count.
  @Test
  public void returnsCountFromDataAdapter () {
    int count = 5;
    when(mockCharacterAdapter.getCount()).thenReturn(count);

    PagerAdapter pagerAdapter =
      new MyFragPagerAdapter(mockFragmentManager, mockCharacterAdapter);

    assertEquals(count, pagerAdapter.getCount());
  }

  // tests getItem(int mockPosition)
  // gets mockLeiaO from mockCharacterAdapter, uses mockLeiaO to make a fragment
  // returns that fragment, which is mockCharacterFragment.
  @Test
  public void returnsFragmentWithCorrectAttributes () {
    when(mockCharacterAdapter.getCharacterAt(mockPosition)).thenReturn(mockLeiaO);
    when(CharacterFragment.newInstance(mockLeiaO)).thenReturn(mockLeiaFragment);

    MyFragPagerAdapter fPagerAdapter =
      new MyFragPagerAdapter(mockFragmentManager, mockCharacterAdapter);

    Fragment fragment = fPagerAdapter.getItem(mockPosition);
    verify(mockCharacterAdapter).gotCharacterAt(mockPosition);
    assertEquals(mockLeiaFragment, fragment);
  }

  // test getItemPosition(Object object)
  // gets Character from object, which is a CharacterFragment.
  // get mockPosition of that character from mockCharacterAdapter,
  // then return that mockPosition.
  @Test
  public void askDataAdapterWithCharacterFromFragment () {
    when(mockAnakinFragment.getCharacter()).thenReturn(mockAnankinS);
    when(mockCharacterAdapter.getItemPosition(mockAnankinS)).thenReturn(itemPosition);

    MyFragPagerAdapter fPagerAdapter =
      new MyFragPagerAdapter(mockFragmentManager, mockCharacterAdapter);
    int returnedItemPosition = fPagerAdapter.getItemPosition(mockAnakinFragment);

    verify(mockCharacterAdapter).getItemPosition(mockAnankinS);
    assertEquals(itemPosition, returnedItemPosition);
  }

  // test changeChildTo(String parent, String nextChild)
  @Test
  public void atCharacterChangeNextTo () {
    MyFragPagerAdapter adapter =
      new MyFragPagerAdapter(mockFragmentManager, mockCharacterAdapter);
    adapter.changeChildTo("Anakin Skywalker", "Leia Organa");
    verify(mockCharacterAdapter).changeChildTo("Anakin Skywalker", "Leia Organa");
  }

  // Test getItemId()
  // ItemID doesn't change from initial instantiation of fragment, so
  // create a new fragment and get id from it.
  @Test
  public void getItemIDFromCharacterAdapter () throws Exception {
    when(mockCharacterAdapter.getCharacterAt(mockPosition)).thenReturn(mockAnankinS);
    when(CharacterFragment.newInstance(mockAnankinS)).thenReturn(mockAnakinFragment);
    when(mockAnakinFragment.getNameHash()).thenReturn(mockAnakinHash);
    MyFragPagerAdapter adapter =
      new MyFragPagerAdapter(mockFragmentManager, mockCharacterAdapter);
    assertEquals(mockAnakinHash, adapter.getItemId(mockPosition));
  }
 //JJ*/
}
