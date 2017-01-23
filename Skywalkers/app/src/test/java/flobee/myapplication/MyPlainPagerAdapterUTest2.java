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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.mockito.Mockito.verify;


///*BB
@RunWith(PowerMockRunner.class) // need PowerMockRunner so add testCompile('org.powermock:powermock-module-junit4:1.6.2)
@PrepareForTest({MyPlainPagerAdapter.class, NamedDrawable.class, CharacterView.class}) // whenNew is called from inside these classes. PrepareForTest requires @RunWith(PowerMockRunner.class).
//BB*/
public class MyPlainPagerAdapterUTest2 {

  @Mock CharacterAdapter mockCharacterAdapter;
  @Mock Context          mockContext;
  @Mock CharacterView    mockCharacterView;
  @Mock CharacterView    mockBadCharacterView;
  @Mock ViewGroup        mockContainerView;
  @Mock Character        mockLeia;
  @Mock Character        mockCharacter;
  String                 leiaName = "Leia Organa";
  @Mock String           mockAName;
  AttributeSet           mockAttributeSet = null;
  @Mock int              mockPosition;
  ///*BB

  @Before
  public void initCharacters () throws Exception {
    when(mockCharacterAdapter.getCharacterAt(mockPosition)).thenReturn(mockLeia);
    when(mockLeia.getName()).thenReturn(leiaName);
    when(mockContainerView.getContext()).thenReturn(mockContext);
    whenNew(CharacterView.class).withArguments(mockContext, mockAttributeSet).
      thenReturn(mockCharacterView);
  }

  // Tests instantiateView(ViewGroup container, int mockPosition)
  // Character View is made and is added to ViewGroup container.
  @Test
  public void characterViewAttributesAddedToCharacterView () {
    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    pagerAdapter.instantiateItem(mockContainerView, mockPosition);

    verify(mockContainerView).addView(mockCharacterView);
  }

  // Tests instantiateView(ViewGroup container, int mockPosition)
  // Tests that Leia's character is added to CharacterView.
  @Test
  public void addsViewToCollection () {
    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    pagerAdapter.instantiateItem(mockContainerView, mockPosition);

    verify(mockCharacterView).setCharacter(mockLeia);
  }

  // Tests instantiateView(ViewGroup container, int mockPosition)
  // Leia's name is returned.
  @Test
  public void returnsCharacterName () {
    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    Object returnedObject = pagerAdapter.instantiateItem(mockContainerView, mockPosition);

    assertEquals(leiaName, returnedObject);
  }
  //BB */

  ///*CC
  // Tests destroyItem(View container, int mockPosition, Object view)
  // View is removed from its container
  @Test
  public void testRemovesViewFromContainer () {
    when(mockContainerView.getChildCount()).thenReturn(4);
    when(mockContainerView.getChildAt(0)).thenReturn(mockCharacterView);
    when(mockCharacterView.getName()).thenReturn(leiaName);

    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    pagerAdapter.destroyItem(mockContainerView, mockPosition, leiaName);

    verify(mockContainerView).removeView(mockCharacterView);
  }

  // Tests isViewFromObject(View view, Object object)
  // Object "Leia Organa" corresponds to mockCharacterView, should return true.
  @Test
  public void testViewIsFromObject() {
    when(mockCharacterView.getName()).thenReturn(leiaName);

    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    assertTrue(pagerAdapter.isViewFromObject(mockCharacterView, "Leia Organa"));
  }

  // Tests isViewFromObject(View view, Object object)
  // Object leiaName does not correspond to mockCharacterView, should return false.
  @Test
  public void testViewIsNotFromObject() {
    when(mockCharacterView.getName()).thenReturn("Luke");
    PagerAdapter pagerAdapter = new MyPlainPagerAdapter(mockCharacterAdapter);
    assertFalse(pagerAdapter.isViewFromObject(mockCharacterView, leiaName));
  } //CC */

}