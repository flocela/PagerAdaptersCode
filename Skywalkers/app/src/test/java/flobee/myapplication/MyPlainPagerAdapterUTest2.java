package flobee.myapplication;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.ViewGroup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

///*BB
@RunWith(PowerMockRunner.class) // need PowerMockRunner so add testCompile('org.powermock:powermock-module-junit4:1.6.2)
@PrepareForTest({MyPlainPagerAdapter.class, NamedDrawable.class, CharacterView.class}) // whenNew is called from inside these classes. PrepareForTest requires @RunWith(PowerMockRunner.class).
//B*/
public class MyPlainPagerAdapterUTest2 {

  @Mock CharacterAdapter mockCharacterAdapter;
  @Mock Context          mockContext;
  @Mock CharacterView    mockCharacterView;
  @Mock CharacterView    mockBadCharacterView;
  @Mock ViewGroup        mockContainerView;
  @Mock Character        mockLeia;
  AttributeSet           mockAttributeSet = null;
  int                    position         = 2;
  ///*BB
  @Before
  public void initCharacters () {
    when(mockCharacterAdapter.getCharacterAt(position)).thenReturn(mockLeia);
    when(mockContainerView.getContext()).thenReturn(mockContext);
  }

  // Tests instantiateView(ViewGroup container, int position)
  // Tests that Character View is made and is added to ViewGroup container.
  @Test
  public void characterViewAttributesAddedToCharacterView () throws Exception {
    int position = 2;

    whenNew(CharacterView.class).withAnyArguments().thenReturn(mockCharacterView);

    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    pagerAdapter.instantiateItem(mockContainerView, position);

    verify(mockContainerView).addView(mockCharacterView);
  }

  // Tests instantiateView(View container, int position)
  // Tests that Leia's character is added to CharacterView.
  @Test
  public void addsViewToCollection () throws Exception {
    int position = 2;

    whenNew(CharacterView.class).withArguments(mockContext, mockAttributeSet).
      thenReturn(mockCharacterView);

    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    pagerAdapter.instantiateItem(mockContainerView, position);

    verify(mockCharacterView).setCharacter(mockLeia);
  }
  //BB */

  ///*CC
  // Tests destroyItem(View container, int position, Object view)
  // Tests that view is removed from its container
  @Test
  public void testRemovesViewFromContainer () {
    int position = 2;

    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    pagerAdapter.destroyItem(mockContainerView, position, mockCharacterView);

    verify(mockContainerView).removeView(mockCharacterView);
  }

  // Tests isViewFromObject(View view, Object object)
  // Returns true if object is view (refers to same object)
  @Test
  public void testViewIsFromObject() {
    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);

    assertTrue(pagerAdapter.isViewFromObject(mockCharacterView, mockCharacterView));
  }

  // Tests isViewFromObject(View view, Object object)
  // Returns true if object is view (refers to same object)
  @Test
  public void testViewIsNotFromObject() {
    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);

    assertFalse(pagerAdapter.isViewFromObject(mockBadCharacterView, mockCharacterView));
  } //CC */

  /*BB@RunWith(PowerMockRunner.class) // need PowerMockRunner so add testCompile('org.powermock:powermock-module-junit4:1.6.2)
  @PrepareForTest({MyPlainPagerAdapter.class, NamedDrawable.class, CharacterView.class}) // whenNew is called from inside these classes. PrepareForTest requires @RunWith(PowerMockRunner.class).
  */

}
