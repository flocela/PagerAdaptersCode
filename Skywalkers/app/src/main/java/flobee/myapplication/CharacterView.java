package flobee.myapplication;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CharacterView extends LinearLayout {

  private String characterName;
  private ChildListener listener;

  public CharacterView(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater inflater = (LayoutInflater)context.
      getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.character_w_kids, this, true);
  }

  public void setCharacter (Character character) {
    characterName = character.getName();
    setName(character.getName());
    setDrawable(NamedDrawable.getDrawableFromName(this.getContext(),
      character.getName()));
    setChildren(character.getChildren(), character.getName());
  }

  public Drawable getDrawable () {
    ImageView imageView = (ImageView)this.findViewById(R.id.character_pict);
    return imageView.getDrawable();
  }

  private void setDrawable (Drawable drawable) {
    ImageView imageView = (ImageView)this.findViewById(R.id.character_pict);
    imageView.setImageDrawable(drawable);
  }

  private void setName (String characterName) {
    TextView nameView = (TextView)this.findViewById(R.id.character_name);
    nameView.setText(characterName);
  }

  private void setChildren (List<Character> children, final String parentName) {
    LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.children_buttons);
    for (final Character character : children) {
      OffspringButton offspringButton = new OffspringButton(this.getContext(), null);
      offspringButton.setName(character.getName());
      offspringButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          if (null != listener)
            listener.changeChildTo(parentName, character.getName());
        }
      });
      offspringButton.setClickable(true);
      linearLayout.addView(offspringButton);
    }
  }

  public void setChildListener(ChildListener listener) {
    this.listener = listener;
    LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.children_buttons);
    for (int ii = 0; ii < linearLayout.getChildCount(); ii++) {
      View view = linearLayout.getChildAt(ii);
      if (view instanceof Button) {
        Button button = (Button) view;
        setListener((Button) view, characterName, button.getText().toString());
      }
    }
  }

  private void setListener(Button button, final String parent, final String child) {
    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        if (null != listener) {
          listener.changeChildTo(parent, child);
        }
      }
    });
  }


  
  /*HH

  R.layout.character_w_kids

  public void setCharacter (Character character) {
    characterName = character.getName();
    setName(character.getName());
    setDrawable(NamedDrawable.getDrawableFromName(this.getContext(),
      character.getName()));
    setChildren(character.getChildren(), character.getName());
  }

  private void setChildren (List<Character> children, final String parentName) {
    LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.children_buttons);
    for (final Character character : children) {
      OffspringButton offspringButton = new OffspringButton(this.getContext(), null);
      offspringButton.setName(character.getName());
      offspringButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          if (null != listener)
            listener.changeChildTo(parentName,
              character.getName());
        }
      });
      offspringButton.setClickable(true);
      linearLayout.addView(offspringButton);
    }
  }

  private ChildListener listener;
  HH*/

  /*II
  public void setChildListener(ChildListener listener) {
    this.listener = listener;
    LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.children_buttons);
    for (int ii=0; ii<linearLayout.getChildCount(); ii++) {
      View view = linearLayout.getChildAt(ii);
      if (view instanceof Button) {
        Button button = (Button)view;
        setListener((Button)view, characterName, button.getText().toString());
      }
    }
  }

  private void setListener(Button button, final String parent, final String child) {
    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        if (null != listener) {
          listener.changeChildTo(parent, child);
        }
      }
    });
  }
  } II*/

}
