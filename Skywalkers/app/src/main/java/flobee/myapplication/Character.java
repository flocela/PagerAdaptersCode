package flobee.myapplication;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

public class Character implements Parcelable {
  private String name;
  private ArrayList<Character> children = new ArrayList<>();

  public Character(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setChildren(Character...childs) {
    children = new ArrayList<>();
    children.addAll(Arrays.asList(childs));
  }

  public ArrayList<Character> getChildren () {
    return children;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;
    if (obj == null || obj.getClass() != this.getClass())
      return false;
    Character other = (Character)obj;
    return (name == other.name || (name != null && name.equals(other.name)));
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  public Character(Parcel in) {
    name = in.readString();
  }

  public static final Creator<Character> CREATOR = new Creator<Character>() {
    @Override
    public Character createFromParcel(Parcel in) {
      return new Character(in);
    }

    @Override
    public Character[] newArray(int size) {
      return new Character[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(name);
  }

  public long getCharacterNameHashCode () {
    return name.hashCode();
  }
}
