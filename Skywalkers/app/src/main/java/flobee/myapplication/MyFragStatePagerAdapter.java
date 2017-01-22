package flobee.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class MyFragStatePagerAdapter extends FragmentStatePagerAdapter2 {

  CharacterAdapter characterAdapter;

  public MyFragStatePagerAdapter(FragmentManager fm, CharacterAdapter characterAdapter) {
    super(fm);
    this.characterAdapter = characterAdapter;
  }

  @Override
  public Fragment getItem(int position) {
    Log.i("ATAG", "FSPA getItem(position)      position: " + position + " char: " + characterAdapter.getCharacterAt(position).getName());
    Character character = characterAdapter.getCharacterAt(position);
    if (character != null)
      characterAdapter.gotCharacterAt(position);
    return CharacterFragment.newInstance(character);
  }

  @Override
  public int getCount() {
    return characterAdapter.getCount();
  }

  public void changeChildTo(String parent, String nextChild) {
  }
}
  /*KK
  public MyFragStatePagerAdapter(FragmentManager fm, CharacterAdapter characterAdapter) {
    super(fm);
    this.characterAdapter = characterAdapter;
  }

  @Override
  public Fragment getItem(int position) {
    Log.i("ATAG", "FSPA getItem(position)      position: " + position + " char: " + characterAdapter.getCharacterAt(position).getName());
    Character character = characterAdapter.getCharacterAt(position);
    if (character != null)
      characterAdapter.gotCharacterAt(position);
    return CharacterFragment.newInstance(character);
  }

  @Override
  public int getCount() {
    return characterAdapter.getCount();
  }

  public void changeChildTo (String parent, String nextChild) {
  }

 KK*/

  /*LL
  public void changeChildTo(String parent, String nextChild) {
    Log.i("ATAG", "MyFSP changeChildTo() (parent, child): (" + parent +", " +nextChild +")");
    characterAdapter.changeChildTo(parent, nextChild);
  }

  @Override
  public int getItemPosition(Object object) {
    CharacterFragment characterFragment = (CharacterFragment)object;
    Character character = characterFragment.getCharacter();
    Log.i("ATAG", "MyFSP getObject       getItemPosition: " + character.getName());
    if (character != null)
      return characterAdapter.getItemPosition(character);
    else
      return PagerAdapter.POSITION_NONE;
  }


  LL*/
