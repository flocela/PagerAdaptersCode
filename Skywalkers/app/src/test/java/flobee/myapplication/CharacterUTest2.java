package flobee.myapplication;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

//MockitoJUnitRunner.class allows me to mock objects.
@RunWith(MockitoJUnitRunner.class)
public class CharacterUTest2 {

  String          mockParentName;
  @Mock Character mockFirstBorn;
  @Mock Character mockSecondBorn;
  @Mock Character mockBadSon;

  @Test
  public void setChildren () {
    Character parent = new Character(mockParentName);
    parent.setChildren(mockFirstBorn, mockSecondBorn);
    ArrayList<Character> twins = parent.getChildren();

    assertEquals(2, twins.size());
    assertTrue(twins.contains(mockFirstBorn));
    assertTrue(twins.contains(mockSecondBorn));
    assertFalse(twins.contains(mockBadSon));
  }

}
