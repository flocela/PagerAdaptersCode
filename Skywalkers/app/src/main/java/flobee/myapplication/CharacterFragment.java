package flobee.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CharacterFragment extends Fragment {

  public static String CHARACTER_KEY = "CHARACTER_KEY";
  private Character character;

  public CharacterFragment() {
    // Required empty public constructor
  }

  public static CharacterFragment newInstance(Character character) {
    CharacterFragment fragment = new CharacterFragment();
    Bundle args = new Bundle();
    args.putParcelable(CHARACTER_KEY, character);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    character = (Character)args.get(CHARACTER_KEY);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    CharacterView characterView = new CharacterView(this.getContext(), null);
    characterView.setCharacter(character);
    return characterView;
  }

  public String getName () {
    return character.getName();
  }

  public Character getCharacter () {
    if (null != character)
      return character;
    else {
      Bundle bundle = getArguments();
      if (bundle != null)
       return bundle.getParcelable(CHARACTER_KEY);
    }
    return null;
  }

  public long getNameHash () {
    Character tempCharacter = this.character;
    if (tempCharacter == null) {
      return -1;
    }
    return getCharacter().getCharacterNameHashCode();
  }

  @Override
  public String toString() {
    Character tempCharacter = getCharacter();
    if (tempCharacter == null) {
      return "no character, "+super.toString();
    }
    else {
      return character.getName() + ", "+super.toString();
    }
  }

  /*II -add to onCreate(Bundle savedInstanceState)
  characterView.setChildListener(
  ((MainActivity)getActivity()).getChildListener())
  II */

  /*JJ
    public long getNameHash () {
   Character tempCharacter = this.character;
    if (tempCharacter == null) {
      return -1;
    }
    return getCharacter().getCharacterNameHashCode();
  }
  JJ*/

}
