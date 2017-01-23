package flobee.myapplication;


import java.util.ArrayList;

public interface CharacterAdapter {
  int       getCount();
  void      addCharacters(ArrayList<Character> additionalCharacters);
  Character getCharacterAt (int position);
}
  /*BB


  BB*/

  /*II
  void      gotCharacterAt(int position);
  int       getItemPosition (Character character);
  void      changeChildTo (String parent, String child);
  II*/