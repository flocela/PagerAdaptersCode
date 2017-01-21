package flobee.myapplication;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.api.support.membermodification.MemberMatcher.methodsDeclaredIn;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

//@RunWith(MockitoJUnitRunner.class) allows me to use when(), which is helpful
// when I need to mock an androidClass
// mock for example when(mockActivity.getSystemService(...).thenReturn(...)
//@RunWith(PowerMockRunner.class) allows me to use when() method with a static class.
@RunWith(PowerMockRunner.class)
@PrepareForTest({NamedDrawable.class, CharacterView.class})
public class CharacterViewUTest {

  @Mock Context         mockContext;
  @Mock TextView        mockNameView;
  @Mock ImageView       mockImageView;
  @Mock LayoutInflater  mockInflater;
  @Mock Drawable        mockDrawable;
  @Mock Drawable        mockBadDrawable;
  @Mock LinearLayout    mockLinearLayout;
  @Mock OffspringButton mockOffspringButton;
  private String        anakin = SkyWalker.anakinSkywalker.getName();

  @Before
  public void init () throws Exception {
    suppress(methodsDeclaredIn(LayoutInflater.class));
    when(mockContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).
      thenReturn(mockInflater);
    mockStatic(NamedDrawable.class);
    when(NamedDrawable.getDrawableFromName(mockContext, anakin)).thenReturn(mockDrawable);
    whenNew(OffspringButton.class).withAnyArguments().thenReturn(mockOffspringButton);
  }

  @Test
  public void setViewsFromCharacter () throws Exception  {
    CharacterView characterView = new CharacterView(mockContext, null);
    CharacterView spyCharView   = spy(characterView);
    // view.findViewById() is an Android method, the Android testing library will throw an
    // exception when called. So add testingOptions {unitTests.returnDefaultValues=true}
    // inside android{} in app's gradle file.
    // Also don't forget to add @RunWith(MockitoJUnitRunner.class)
    // Also requires inside gradle file,
    // dependencies{ testCompile 'org.mockito:mockito-core:1.10.19'}
    when(spyCharView.findViewById(R.id.character_name)).thenReturn(mockNameView);
    when(spyCharView.findViewById(R.id.character_pict)).thenReturn(mockImageView);
    when(spyCharView.findViewById(R.id.children_buttons)).thenReturn(mockLinearLayout);
    when(spyCharView.getContext()).thenReturn(mockContext);

    spyCharView.setCharacter(SkyWalker.getCharacter(anakin));

    verify(mockNameView).setText(anakin);
    verify(mockImageView).setImageDrawable(mockDrawable);
  }

  /*HH
   verify(mockLinearLayout, times(2)).addView(mockOffspringButton);
   when(spyCharView.findViewById(R.id.children_buttons)).thenReturn(mockLinearLayout);
   whenNew(OffspringButton.class).withAnyArguments().thenReturn(mockOffspringButton);
   */

}
