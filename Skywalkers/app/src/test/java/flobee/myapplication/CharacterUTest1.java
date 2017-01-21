package flobee.myapplication;


import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class CharacterUTest1 {

  private static Character shmiS;
  private static Character shmiSame;
  private static Character shmiDiff;

  @BeforeClass
  public static void initCharacters () {
    shmiS      = new Character("Shmi Skywalker");
    shmiSame   = new Character("Shmi Skywalker");
    shmiDiff   = new Character("Shmi Diff");
  }

  // tests getName()
  @Test
  public void getName () {
    String name = "JacenSolo";
    Character jacenSolo = new Character(name);
    assertEquals(jacenSolo, jacenSolo.getName());
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
