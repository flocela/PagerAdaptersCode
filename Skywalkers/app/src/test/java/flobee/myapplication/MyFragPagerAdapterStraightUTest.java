package flobee.myapplication;


import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class) // PowerMockRunner is required calling when(Static.method)
@PrepareForTest({CharacterFragment.class})
public class MyFragPagerAdapterStraightUTest {

  @Mock FragmentManager   mockFragmentManager;
  @Mock CharacterAdapter  mockCharacterAdapter;
  @Mock CharacterFragment mockFragment;
  @Mock Character      mockLeiaO;

  int    count     = 5;
  int    position  = 2;
  String leiaOName = "Leia Organa";
  AttributeSet mockAttributeSet = null;
/*FF
  @Before
  public void init () {
    //suppress(constructorsDeclaredIn(FragmentPagerAdapter.class) should
    // have been enough, but required (methodsDeclaredIn())
    //FF suppress(methodsDeclaredIn(FragmentPagerAdapter.class));
    //FF when(mockLeiaO.getName()).thenReturn(leiaOName);

  }

  // tests getCount()
  @Test
  public void returnsCountFromDataAdapter () {
    when(mockCharacterAdapter.getCount()).thenReturn(count);
    PagerAdapter pagerAdapter = new MyFragPagerAdapter(mockFragmentManager, mockCharacterAdapter);
    assertEquals(count, pagerAdapter.getCount());
  }

  // tests getItem(int position)
  @Test
  public void returnsFragmentWithCorrAttributes () {
    when(mockCharacterAdapter.getCharacterAt(position)).thenReturn(mockLeiaO);
    mockStatic(CharacterFragment.class);
    when(CharacterFragment.newInstance(mockLeiaO)).thenReturn(mockFragment);

    FragmentPagerAdapter fPagerAdapter =
      new MyFragPagerAdapter(mockFragmentManager, mockCharacterAdapter);
    Fragment fragment = fPagerAdapter.getItem(position);

    assertEquals(mockFragment, fragment);
  }
FF*/
}
