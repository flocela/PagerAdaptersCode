package flobee.myapplication;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class CharacterUTest {

  private static Character shmiS;
  private static Character shmiSame;
  private static Character shmiDiff;
  private static Character anakinS;
  private static Character leiaO;
  private static Character lukeS;

  @BeforeClass
  public static void initCharacters () {
    shmiS      = new Character("Shmi Skywalker");
    shmiSame   = new Character("Shmi Skywalker");
    shmiDiff   = new Character("Shmi Diff");
    anakinS    = new Character("Anakin Skywalker");

    leiaO      = new Character("Leia Organa");
    lukeS      = new Character("Luke Skywalker");
  }

  // tests getName()
  @Test
  public void returnsName () {
    assertEquals(shmiS.getName(), "Shmi Skywalker");
  }

  // tests setChildren(Character ...childs) and getChildren()
  @Test
  public void setAndGetChildren () {
    ArrayList<Character> twins = new ArrayList<>();
    twins.add(leiaO);
    twins.add(lukeS);
    anakinS.setChildren(leiaO, lukeS);
    assertTrue(twins.containsAll(anakinS.getChildren()));
    assertEquals(2, anakinS.getChildren().size());
  }

  // tests equals() when two characters are the same.
  @Test
  public void equalsPositive () {
    assertTrue(shmiS.equals(shmiSame));
  }

  // tests equals() when two characters are different.
  @Test
  public void equalsNegative () {
    assertFalse(shmiS.equals(shmiDiff));
  }

  // tests equals() when other character is null.
  @Test
  public void nullEquals () {
    assertFalse(shmiS.equals(null));
  }

  // TODO Test Parcelable
  // TODO Test hashCode()

}
