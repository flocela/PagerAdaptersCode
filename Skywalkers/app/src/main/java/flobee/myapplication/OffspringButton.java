package flobee.myapplication;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;

public class OffspringButton extends FrameLayout {

  public OffspringButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater inflater = (LayoutInflater)context.
      getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.offspring_button, this, true);
  }

  public void setName (final String name) {
    Button button = (Button) findViewById(R.id.offspring_button);
    button.setText(name);
  }
}
