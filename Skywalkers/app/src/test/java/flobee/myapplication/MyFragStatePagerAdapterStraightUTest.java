package flobee.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class) // PowerMockRunner is required calling when(Static.method)
@PrepareForTest({CharacterFragment.class})
public class MyFragStatePagerAdapterStraightUTest {

  @Mock FragmentManager   mockFragmentManager;
  @Mock CharacterAdapter  mockCharacterAdapter;
  @Mock CharacterFragment mockFragment;
  @Mock Character         mockLeiaO;
  @Mock int               mockCount = 5;
  @Mock int               mockPosition = 2;
  @Mock String            mockLeiaString;
  AttributeSet mockAttributeSet = null;

  @Before
  public void init () {
    //suppress(constructorsDeclaredIn(FragmentPagerAdapter.class) should
    // have been enough, but required (methodsDeclaredIn())
    ///*KK suppress(methodsDeclaredIn(FragmentPagerAdapter.class));
    when(mockLeiaO.getName()).thenReturn(mockLeiaString);
    //KK*/
  }

  // tests getCount()
  @Test
  public void returnsCountFromDataAdapter () {
    when(mockCharacterAdapter.getCount()).thenReturn(mockCount);
    PagerAdapter pagerAdapter = new MyFragStatePagerAdapter(mockFragmentManager, mockCharacterAdapter);
    assertEquals(mockCount, pagerAdapter.getCount());
  }

  // tests getItem(int position)
  @Test
  public void returnsFragmentWithCorrAttributes () {
    when(mockCharacterAdapter.getCharacterAt(mockPosition)).thenReturn(mockLeiaO);
    mockStatic(CharacterFragment.class);
    when(CharacterFragment.newInstance(mockLeiaO)).thenReturn(mockFragment);

    MyFragStatePagerAdapter fPagerAdapter =
      new MyFragStatePagerAdapter(mockFragmentManager, mockCharacterAdapter);
    Fragment fragment = fPagerAdapter.getItem(mockPosition);

    assertEquals(mockFragment, fragment);
  }

}
