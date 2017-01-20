package flobee.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.ViewGroup;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

@RunWith(PowerMockRunner.class) // PowerMockRunner is required calling whenNew
@PrepareForTest({CharacterFragment.class})
public class MyFragStatePagerAdapterKinkedUTest {

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
  int    position     = 2;
  int    itemPosition = 10;
  String leiaOName = "Leia Organa";
  AttributeSet mockAttributeSet = null;
  /*LL
  @Before
  public void init () {
    //suppress(constructorsDeclaredIn(FragmentPagerAdapter.class) should
    // have been enough, but required (methodsDeclaredIn())
    suppress(methodsDeclaredIn(FragmentPagerAdapter.class));
    when(mockLeiaO.getName()).thenReturn(leiaOName);
    mockStatic(CharacterFragment.class);

  }

  // Tests getCount()
  // Gets count from mockCharacterAdapter and returns that count.
  @Test
  public void returnsCountFromDataAdapter () {
    int count = 5;
    when(mockCharacterAdapter.getCount()).thenReturn(count);

    PagerAdapter pagerAdapter =
      new MyFragStatePagerAdapter(mockFragmentManager, mockCharacterAdapter);

    assertEquals(count, pagerAdapter.getCount());
  }

  // Tests getItem(int position)
  // Gets mockLeiaO from mockCharacterAdapter, uses mockLeiaO to make a fragment
  // Returns that fragment, which is mockCharacterFragment.
  @Test
  public void returnsFragmentWithCorrectAttributes () {
    when(mockCharacterAdapter.getCharacterAt(position)).thenReturn(mockLeiaO);
    when(CharacterFragment.newInstance(mockLeiaO)).thenReturn(mockLeiaFragment);

    MyFragStatePagerAdapter fPagerAdapter =
      new MyFragStatePagerAdapter(mockFragmentManager, mockCharacterAdapter);

    Fragment fragment = fPagerAdapter.getItem(position);
    verify(mockCharacterAdapter).gotCharacterAt(position);
    assertEquals(mockLeiaFragment, fragment);
  }

  // Tests getItemPosition(Object object)
  // Gets Character from object, which is a CharacterFragment.
  // Get position of that character from mockCharacterAdapter,
  // then return that position.
  @Test
  public void askDataAdapterWithCharacterFromFragment () {
    when(mockAnakinFragment.getCharacter()).thenReturn(mockAnankinS);
    when(mockCharacterAdapter.getItemPosition(mockAnankinS)).thenReturn(itemPosition);

    MyFragStatePagerAdapter fPagerAdapter =
      new MyFragStatePagerAdapter(mockFragmentManager, mockCharacterAdapter);
    int returnedItemPosition = fPagerAdapter.getItemPosition(mockAnakinFragment);

    verify(mockCharacterAdapter).getItemPosition(mockAnankinS);
    assertEquals(itemPosition, returnedItemPosition);
  }

  // Test changeChildTo(String parent, String nextChild)
  @Test
  public void atCharacterChangeNextTo () {
    MyFragStatePagerAdapter adapter =
      new MyFragStatePagerAdapter(mockFragmentManager, mockCharacterAdapter);
    adapter.changeChildTo("Anakin Skywalker", "Leia Organa");
    verify(mockCharacterAdapter).changeChildTo("Anakin Skywalker", "Leia Organa");
  }
  LL*/
}
