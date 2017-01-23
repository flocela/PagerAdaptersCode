package flobee.myapplication;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SkyWalkerAdapterStraightUTest {
  private static ArrayList<Character> shmiToAlana;
  private static Character shmiS;
  private static Character anakinS;
  private static Character leiaO;
  private static Character jacenS;
  private static Character allanaS;
  private static SkywalkerAdapter characterAdapter;

  ///*DD
  @BeforeClass
  public static void initCharacters () {
    shmiS   = new Character("Shmi Skywalker");
    anakinS = new Character("Anakin Skywalker");
    leiaO   = new Character("Leia Organa");
    jacenS  = new Character("Jacen Solo");
    allanaS = new Character("Allana Solo");
    shmiToAlana = new ArrayList<Character>();
    shmiToAlana.add(shmiS);

    shmiToAlana.add(anakinS);
    shmiToAlana.add(leiaO);
    shmiToAlana.add(jacenS);
    shmiToAlana.add(allanaS);
    characterAdapter = new SkywalkerAdapter();
    characterAdapter.addCharacters(shmiToAlana);
  }

  @Test
  public void returnsCharacterAtPosition0 () {
    assertEquals(shmiS, characterAdapter.getCharacterAt(0));
  }

  @Test
  public void getCount () {
    assertEquals(shmiToAlana.size(), characterAdapter.getCount());
  }
//DD*/
}