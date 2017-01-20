package flobee.myapplication;


import android.support.v4.view.PagerAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

///*AA
@RunWith(MockitoJUnitRunner.class)
//AA*/
public class MyPlainPagerAdapterUTest1 {
///*AA
  @Mock
CharacterAdapter mockCharacterAdapter;
  int   count = 5;

  //Tests getCount()
  @Test
  public void returnsCountFromDataAdapter () {
    when(mockCharacterAdapter.getCount()).thenReturn(count);

    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    assertEquals(count, pagerAdapter.getCount());
  }
//AA*/
}
