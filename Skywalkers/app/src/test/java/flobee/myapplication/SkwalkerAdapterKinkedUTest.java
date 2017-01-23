package flobee.myapplication;

import android.support.v4.view.PagerAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SkwalkerAdapterKinkedUTest {

  private static ArrayList<Character> shmiToAlana;
  private static ArrayList<Character> shmiToJaina;
  private static ArrayList<Character> shmiToBen;
  private static ArrayList<Character> shmiToAnakinSolo;
  private static Character shmiS;
  private static Character anakinS;
  private static Character leiaO;
  private static Character lukeS;
  private static Character benS;
  private static Character jacenS;
  private static Character jainaS;
  private static Character allanaS;
  private static Character anakinSolo;
  private static SkywalkerAdapter skywalkerAdapter;
///*JJ
  @Before
  public void initCharacters () {
    skywalkerAdapter = new SkywalkerAdapter();

    shmiS      = new Character("Shmi Skywalker");
    anakinS    = new Character("Anakin Skywalker");
    lukeS      = new Character("Luke Skywalker");
    benS       = new Character("Ben Skywalker");
    leiaO      = new Character("Leia Organa");
    jacenS     = new Character("Jacen Solo");
    jainaS     = new Character ("Jaina Solo");
    allanaS    = new Character("Allana Solo");
    anakinSolo = new Character("Anankin Solo");

    shmiToAlana = new ArrayList<>();
    shmiToAlana.add(shmiS);
    shmiToAlana.add(anakinS);
    shmiToAlana.add(leiaO);
    shmiToAlana.add(jacenS);
    shmiToAlana.add(allanaS);
    skywalkerAdapter.addCharacters(shmiToAlana);

    shmiToBen = new ArrayList<>();
    shmiToBen.add(shmiS);
    shmiToBen.add(anakinS);
    shmiToBen.add(lukeS);
    shmiToBen.add(benS);
    skywalkerAdapter.addCharacters(shmiToBen);

    shmiToJaina = new ArrayList<>();
    shmiToJaina.add(shmiS);
    shmiToJaina.add(anakinS);
    shmiToJaina.add(leiaO);
    shmiToJaina.add(jainaS);
    skywalkerAdapter.addCharacters(shmiToJaina);

    shmiToAnakinSolo = new ArrayList<>();
    shmiToAnakinSolo.add(shmiS);
    shmiToAnakinSolo.add(anakinS);
    shmiToAnakinSolo.add(leiaO);
    shmiToAnakinSolo.add(anakinSolo);
    skywalkerAdapter.addCharacters(shmiToAnakinSolo);
  }

  @Test
  public void returnsCharacterAtPosition0 () {
    assertEquals(shmiS, skywalkerAdapter.getCharacterAt(0));
  }

  @Test
  public void getCount () {
    assertEquals(shmiToAlana.size(), skywalkerAdapter.getCount());
  }

  // test getItemPosition(Character character)
  // when item mockPosition has not been changed.
  @Test
  public void itemPositionIsUnchanged () {
    int returnedInt = skywalkerAdapter.getItemPosition(anakinS);
    assertEquals(1, returnedInt);

    skywalkerAdapter.getCharacterAt(1);
    skywalkerAdapter.gotCharacterAt(1);
    returnedInt = skywalkerAdapter.getItemPosition(anakinS);
    assertEquals(PagerAdapter.POSITION_UNCHANGED, returnedInt);
  }

  // test getItemPosition(Character character)
  // when item is not in the list
  @Test
  public void intPositionIsNone () {
    assertEquals(PagerAdapter.POSITION_NONE, skywalkerAdapter.getItemPosition(benS));
  }

  // test changeChildTo(String parentName, String childName)
  // character is no longer on the list.
  @Test
  public void intPositionIsNoneAfterChange () {
    skywalkerAdapter.getCharacterAt(2);
    skywalkerAdapter.gotCharacterAt(2);
    int returnedShouldBeUnchanged = skywalkerAdapter.getItemPosition(leiaO);
    assertEquals(PagerAdapter.POSITION_UNCHANGED, returnedShouldBeUnchanged);

    skywalkerAdapter.changeChildTo(anakinS.getName(),
      lukeS.getName());
    assertEquals(PagerAdapter.POSITION_NONE, skywalkerAdapter.getItemPosition(leiaO));
  }

  // test changeChildTo(String parentName, String childName)
  // test positions of new lineage.
  @Test
  public void testPositionsOfNewLineage () {
    assertEquals(shmiS, skywalkerAdapter.getCharacterAt(0));
    skywalkerAdapter.gotCharacterAt(0);
    assertEquals(anakinS, skywalkerAdapter.getCharacterAt(1));
    skywalkerAdapter.gotCharacterAt(1);
    assertEquals(leiaO, skywalkerAdapter.getCharacterAt(2));
    skywalkerAdapter.gotCharacterAt(2);

    skywalkerAdapter.changeChildTo("Anakin Skywalker", "Luke Skywalker");
    assertEquals(PagerAdapter.POSITION_UNCHANGED, skywalkerAdapter.getItemPosition(shmiS));
    assertEquals(PagerAdapter.POSITION_UNCHANGED, skywalkerAdapter.getItemPosition(anakinS));
    assertEquals(2, skywalkerAdapter.getItemPosition(lukeS));
    assertEquals(3, skywalkerAdapter.getItemPosition(benS));
  }
//JJ*/
  //TODO add test for when child does not exist in any line.

}
