package flobee.myapplication;


import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

public class SkywalkerAdapter implements CharacterAdapter {

  private static Integer DISPLAYED     = 1;
  private static Integer NOT_DISPLAYED = 2;
  private ArrayList<Integer> displayInfos = new ArrayList<>();

  int currLineIndex;
  private ArrayList<ArrayList<Character>> characters     = new ArrayList<>();

  //assume parent is never null!!
  @Override
  public void changeChildTo (String parent, String child) {
    moveToNewLine(child);
  }

  private void moveToNewLine (String child) {
    int indexOfChildInCurrLine = findIndexOfCharacter(currLineIndex, child);
    // Actually, if child is in current line, I don't have to move to a new line.
    // Only if indexOfChildInCurrLine is -2 do I move to new line.
    if (indexOfChildInCurrLine == -2) {
      int oldLineIndex = currLineIndex;
      int newLineIndex = findLineWithCharacter(child);
      if (newLineIndex == -2)
        return;
      else {
        currLineIndex = newLineIndex;
        updateDisplayInfoSize();
        updateDisplayInfoWithOldLine(oldLineIndex);
        int characterIndex = findIndexOfCharacter(currLineIndex, child);
        charactersAfterAndIncludingHaveNotBeenDisplayed(characterIndex);
      }
    }
  }

  @Override
  public void addCharacters(ArrayList<Character> characters) {
    this.characters.add(characters);
    if (displayInfos.isEmpty()) {
      for (int ii=0; ii<characters.size(); ii++) {
        displayInfos.add(NOT_DISPLAYED);
      }
    }
  }

  @Override
  public Character getCharacterAt (int position) {
    if (displayInfos.size() > position) {
      return getCharacter(currLineIndex, position);
    }
    return null;
  }

  @Override
  public void gotCharacterAt (int position) {
    displayInfos.set(position, DISPLAYED);
  }

  public int getCount () {
    return displayInfos.size();
  }

  @Override
  public int getItemPosition(Character character) {
    int indexOfCharacter = findIndexOfCharacter(currLineIndex, character);
    if (indexOfCharacter == -2)
      return PagerAdapter.POSITION_NONE;
    if (displayInfos.get(indexOfCharacter) == DISPLAYED)
      return PagerAdapter.POSITION_UNCHANGED;
    return indexOfCharacter;
  }

  private Character getCharacter (int line, int index) {
    return characters.get(line).get(index);
  }

  private int findIndexOfCharacter (int lineIdx, String characterName) {
    ArrayList<Character> line = characters.get(lineIdx);
    for (int ii = 0; ii< line.size(); ii++) {
      if (line.get(ii).getName().equals(characterName))
        return ii;
    }
    return -2;
  }

  private int findLineWithCharacter (String characterName) {
    for (int ii=0; ii<characters.size(); ii++) {
      int indexFromCurrLine = findIndexOfCharacter(ii, characterName);
      if (indexFromCurrLine != -2)
        return ii;
    }
    return -2;
  }

  private void updateDisplayInfoSize () {
    int correctInfoSize = characters.get(currLineIndex).size();
    while (displayInfos.size() < correctInfoSize) {
      displayInfos.add(NOT_DISPLAYED);
    }
    while (displayInfos.size() > correctInfoSize) {
      displayInfos.remove(displayInfos.size()-1);
    }
  }

  private void updateDisplayInfoWithOldLine (int oldLineIndex) {
    ArrayList<Character> currentLine = characters.get(currLineIndex);
    ArrayList<Character> oldLine = characters.get(oldLineIndex);
    for (int ii=0; ii<currentLine.size(); ii++) {
      if (oldLine.size() > ii) {
        Character oldCharacter = oldLine.get(ii);
        Character newCharacter = currentLine.get(ii);
        if (!oldCharacter.equals(newCharacter))
          displayInfos.set(ii, NOT_DISPLAYED);
      }
      else {
        if (displayInfos.size() > ii)
          displayInfos.set(ii, NOT_DISPLAYED);
        else
          displayInfos.add(NOT_DISPLAYED);
      }
    }
  }

  private void charactersAfterAndIncludingHaveNotBeenDisplayed(int index) {
    for (int ii = index; ii< displayInfos.size(); ii++) {
      displayInfos.set(ii, NOT_DISPLAYED);
    }
  }

  private int findIndexOfCharacter (int lineIdx, Character character) {
    if (lineIdx < characters.size()) {
      ArrayList<Character> line = characters.get(lineIdx);
      for (int ii = 0; ii < line.size(); ii++) {
        if (line.get(ii).equals(character))
          return ii;
      }
    }
    return -2;
  }

  /*DD
  public void addCharacters (ArrayList<Character> characters) {
    this.characters = characters;
  }

  public Character getCharacterAt (int position) {
    if (position < characters.size())
      return characters.get(position);
    else
      return null;
  }

  @Override
  public int getCount() {
    return characters.size();
  }
  DD*/

  /*JJ
  @Override
  private static Integer DISPLAYED     = 1;
  private static Integer NOT_DISPLAYED = 2;
  private ArrayList<Integer> displayInfos = new ArrayList<>();

  int currLineIndex;
  private ArrayList<ArrayList<Character>> characters     = new ArrayList<>();

  //assume parent is never null!!
  @Override
  public void changeChildTo (String parent, String child) {
    moveToNewLine(child);
  }

  private void moveToNewLine (String child) {
    int indexOfChildInCurrLine = findIndexOfCharacter(currLineIndex, child);
    // Actually, if child is in current line, I don't have to move to a new line.
    // Only if indexOfChildInCurrLine is -2 do I move to new line.
    if (indexOfChildInCurrLine == -2) {
      int oldLineIndex = currLineIndex;
      int newLineIndex = findLineWithCharacter(child);
      if (newLineIndex == -2)
        return;
      else {
        currLineIndex = newLineIndex;
        updateDisplayInfoSize();
        updateDisplayInfoWithOldLine(oldLineIndex);
        int characterIndex = findIndexOfCharacter(currLineIndex, child);
        charactersAfterAndIncludingHaveNotBeenDisplayed(characterIndex);
      }
    }
  }

  @Override
  public void addCharacters(ArrayList<Character> characters) {
    this.characters.add(characters);
    if (displayInfos.isEmpty()) {
      for (int ii=0; ii<characters.size(); ii++) {
        displayInfos.add(NOT_DISPLAYED);
      }
    }
  }

  @Override
  public Character getCharacterAt (int position) {
    if (displayInfos.size() > position) {
      return getCharacter(currLineIndex, position);
    }
    return null;
  }

  @Override
  public void gotCharacterAt (int position) {
    displayInfos.set(position, DISPLAYED);
  }

  public int getCount () {
    return displayInfos.size();
  }

  @Override
  public int getItemPosition(Character character) {
    int indexOfCharacter = findIndexOfCharacter(currLineIndex, character);
    if (indexOfCharacter == -2)
      return PagerAdapter.POSITION_NONE;
    if (displayInfos.get(indexOfCharacter) == DISPLAYED)
      return PagerAdapter.POSITION_UNCHANGED;
    return indexOfCharacter;
  }

  private Character getCharacter (int line, int index) {
    return characters.get(line).get(index);
  }

  private int findIndexOfCharacter (int lineIdx, String characterName) {
    ArrayList<Character> line = characters.get(lineIdx);
    for (int ii = 0; ii< line.size(); ii++) {
      if (line.get(ii).getName().equals(characterName))
        return ii;
    }
    return -2;
  }

  private int findLineWithCharacter (String characterName) {
    for (int ii=0; ii<characters.size(); ii++) {
      int indexFromCurrLine = findIndexOfCharacter(ii, characterName);
      if (indexFromCurrLine != -2)
        return ii;
    }
    return -2;
  }

  private void updateDisplayInfoSize () {
    int correctInfoSize = characters.get(currLineIndex).size();
    while (displayInfos.size() < correctInfoSize) {
      displayInfos.add(NOT_DISPLAYED);
    }
    while (displayInfos.size() > correctInfoSize) {
      displayInfos.remove(displayInfos.size()-1);
    }
  }

  private void updateDisplayInfoWithOldLine (int oldLineIndex) {
    ArrayList<Character> currentLine = characters.get(currLineIndex);
    ArrayList<Character> oldLine = characters.get(oldLineIndex);
    for (int ii=0; ii<currentLine.size(); ii++) {
      if (oldLine.size() > ii) {
        Character oldCharacter = oldLine.get(ii);
        Character newCharacter = currentLine.get(ii);
        if (!oldCharacter.equals(newCharacter))
          displayInfos.set(ii, NOT_DISPLAYED);
      }
      else {
        if (displayInfos.size() > ii)
          displayInfos.set(ii, NOT_DISPLAYED);
        else
          displayInfos.add(NOT_DISPLAYED);
      }
    }
  }

  private void charactersAfterAndIncludingHaveNotBeenDisplayed(int index) {
    for (int ii = index; ii< displayInfos.size(); ii++) {
      displayInfos.set(ii, NOT_DISPLAYED);
    }
  }

  private int findIndexOfCharacter (int lineIdx, Character character) {
    if (lineIdx < characters.size()) {
      ArrayList<Character> line = characters.get(lineIdx);
      for (int ii = 0; ii < line.size(); ii++) {
        if (line.get(ii).equals(character))
          return ii;
      }
    }
    return -2;
  }

  JJ*/
}
