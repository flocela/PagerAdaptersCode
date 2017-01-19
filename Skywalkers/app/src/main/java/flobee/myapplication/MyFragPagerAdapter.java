package flobee.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragPagerAdapter extends FragmentPagerAdapter {

  CharacterAdapter characterAdapter;

  MyFragPagerAdapter(FragmentManager fragmentManager, CharacterAdapter adapter) {
    super(fragmentManager);
    characterAdapter = adapter;
  }

  @Override
  public Fragment getItem(int position) {
    return null;
  }

  @Override
  public int getCount() {
    return 0;
  }
}

  /*GG
  @Override
  public int getCount() {
    GG return characterAdapter.getCount();
  }

    @Override
  public Fragment getItem(int position) {
    return CharacterFragment.newInstance(characterAdapter.getCharacterAt(position));
  }
  GG*/

  /*JJ
  public void changeChildTo(String parent, String nextChild) {
     Log.i("ATAG", "MyFSP changeChildTo() (parent, child): (" + parent +", " +nextChild +")");
     characterAdapter.changeChildTo(parent, nextChild);
  }

  @Override
  public Fragment getItem(int position) {
    Log.i("ATAG", "MyFSP getItem(position)      position: " + position + " char: " + characterAdapter.getCharacterAt(position).getName());
    Character character = characterAdapter.getCharacterAt(position);
    if (character != null) {
      characterAdapter.gotCharacterAt(position);
      return CharacterFragment.newInstance(character);
    }
    return null;
  }

  @Override
  public int getItemPosition(Object object) {
    CharacterFragment characterFragment = (CharacterFragment)object;
    Character character = characterFragment.getCharacter();
    Log.i("ATAG", "MyFSP getObject       getItemPosition: " + character.getName());
    return characterAdapter.getItemPosition(character);
  }

  @Override
  public long getItemId(int position) {
    Character character = characterAdapter.getCharacterAt(position);
    if (character != null)
      return character.getCharacterNameHashCode();
    return -1;
  }
  JJ*/