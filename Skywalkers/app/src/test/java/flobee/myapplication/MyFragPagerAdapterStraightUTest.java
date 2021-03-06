package flobee.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.methodsDeclaredIn;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

@RunWith(PowerMockRunner.class) // PowerMockRunner is required calling when(Static.method)
@PrepareForTest({CharacterFragment.class})
public class MyFragPagerAdapterStraightUTest {

  @Mock FragmentManager   mockFragmentManager;
  @Mock CharacterAdapter  mockCharacterAdapter;
  @Mock CharacterFragment mockFragment;
  @Mock Character         mockLeiaO;
  @Mock int               mockPosition;

  int    count     = 5;
  int    position  = 2;
  String leiaOName = "Leia Organa";
  AttributeSet mockAttributeSet = null;
///*FF
  @Before
  public void init () {
    //suppress(constructorsDeclaredIn(FragmentPagerAdapter.class) should
    // have been enough, but required (methodsDeclaredIn())
    suppress(methodsDeclaredIn(FragmentPagerAdapter.class));
    when(mockLeiaO.getName()).thenReturn(leiaOName);

  }

  // tests getCount()
  @Test
  public void returnsCountFromDataAdapter () {
    when(mockCharacterAdapter.getCount()).thenReturn(count);

    PagerAdapter pagerAdapter = new MyFragPagerAdapter(mockFragmentManager, mockCharacterAdapter);

    assertEquals(count, pagerAdapter.getCount());
  }

  // tests getItem(int mockPosition)
  @Test
  public void returnsFragmentWithCorrAttributes () {
    when(mockCharacterAdapter.getCharacterAt(mockPosition)).thenReturn(mockLeiaO);
    mockStatic(CharacterFragment.class);
    when(CharacterFragment.newInstance(mockLeiaO)).thenReturn(mockFragment);

    FragmentPagerAdapter fPagerAdapter =
      new MyFragPagerAdapter(mockFragmentManager, mockCharacterAdapter);
    Fragment fragment = fPagerAdapter.getItem(mockPosition);

    assertEquals(mockFragment, fragment);
  }
//FF*/
}
