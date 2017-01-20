package flobee.myapplication;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPlainPagerAdapter extends PagerAdapter {

  CharacterAdapter characterAdapter;

  public MyPlainPagerAdapter(CharacterAdapter characterAdapter) {
    this.characterAdapter = characterAdapter;
  }

  @Override
  public int getCount() {
    return characterAdapter.getCount();
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    Character character = characterAdapter.getCharacterAt(position);
    Context context = container.getContext();
    CharacterView characterView = new CharacterView(context, null);
    characterView.setCharacter(character);
    container.addView(characterView);
    return character.getName();
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    //View is CharacterView added to container in instantiateItem()
    CharacterView characterView = (CharacterView)view;
    return (characterView.getName().equals(object));
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeViewAt(position);
  }
}
  /*AA
  @Override
  public int getCount() {
    return characterAdapter.getCount();
  }
  AA*/

  /*BB
    @Override
  public Object instantiateItem(ViewGroup container, int position) {
    Character character = characterAdapter.getCharacterAt(position);
    Context context = container.getContext();
    CharacterView characterView = new CharacterView(context, null);
    characterView.setCharacter(character);
    container.addView(characterView);
    return characterView;
  }
  BB*/

  /*CC
  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((CharacterView)object);
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }
  CC*/