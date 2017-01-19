package flobee.myapplication;


import java.util.ArrayList;

public class SkyWalker {
  private static ArrayList<ArrayList<Character>> lineages = new ArrayList<>();

  public static Character shmiSkywalker   = new Character("Shmi Skywalker");
  public static Character anakinSkywalker = new Character("Anakin Skywalker");
  public static Character leiaOrgana      = new Character("Leia Organa");
  public static Character jacenSolo       = new Character("Jacen Solo");
  public static Character allanaSolo      = new Character("Allana Solo");
  public static Character lukeSkywalker   = new Character("Luke Skywalker");
  public static Character benSkywalker    = new Character("Ben Skywalker");
  public static Character jainaSolo       = new Character("Jaina Solo");
  public static Character anakinSolo      = new Character("Anakin Solo");

  private static ArrayList<Character> endsWithAllana      = new ArrayList<>();
  private static ArrayList<Character> endsWithBen         = new ArrayList<>();
  private static ArrayList<Character> endsWithJaina       = new ArrayList<>();
  private static ArrayList<Character> endsWithAnankinSolo = new ArrayList<>();


  private SkyWalker() {}

  private static void init () {
    shmiSkywalker.setChildren(anakinSkywalker);
    anakinSkywalker.setChildren(leiaOrgana, lukeSkywalker);
    lukeSkywalker.setChildren(benSkywalker);
    leiaOrgana.setChildren(jainaSolo, jacenSolo, anakinSolo);
    jacenSolo.setChildren(allanaSolo);
    endsWithAllana.add(shmiSkywalker);
    endsWithAllana.add(anakinSkywalker);
    endsWithAllana.add(leiaOrgana);
    endsWithAllana.add(jacenSolo);
    endsWithAllana.add(allanaSolo);
    lineages.add(endsWithAllana);
    endsWithBen.add(shmiSkywalker);
    endsWithBen.add(anakinSkywalker);
    endsWithBen.add(lukeSkywalker);
    endsWithBen.add(benSkywalker);
    lineages.add(endsWithBen);
    endsWithJaina.add(shmiSkywalker);
    endsWithJaina.add(anakinSkywalker);
    endsWithJaina.add(leiaOrgana);
    endsWithJaina.add(jainaSolo);
    lineages.add(endsWithJaina);
    endsWithAnankinSolo.add(shmiSkywalker);
    endsWithAnankinSolo.add(anakinSkywalker);
    endsWithAnankinSolo.add(leiaOrgana);
    endsWithAnankinSolo.add(anakinSolo);
    lineages.add(endsWithAnankinSolo);
  }

  public static ArrayList<ArrayList<Character>> getLineages () {
    if (lineages.isEmpty())
      init();
    return lineages;
  }

  // character is at the end of the line. So Shmi Skywalker will return null.
  public static ArrayList<Character> getLineageFor(Character character) {
    if (lineages.isEmpty())
      init();
    for (ArrayList<Character> line : lineages) {
      if (line.get(line.size()-1).equals(character)) {
        return line;
      }
    }
    return null;
  }

  public static Character getCharacter (String name) {
    if (lineages.isEmpty())
      init();
    for (ArrayList<Character> list : lineages) {
      for (Character character : list) {
        if (character.getName().equals(name))
          return character;
      }
    }
    return null;
  }

}
