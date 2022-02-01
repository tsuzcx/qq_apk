package com.tencent.token.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.rt;

public class SerialNumberActivity
  extends BaseActivity
{
  Button button;
  TextView text;
  
  public void initialize()
  {
    this.text = ((TextView)findViewById(2131165513));
    String str = rt.a().b();
    if (str != null) {
      this.text.setText(str);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296450);
    initialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SerialNumberActivity
 * JD-Core Version:    0.7.0.1
 */