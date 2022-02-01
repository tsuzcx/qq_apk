package com.tencent.token.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.cc;

public class SerialNumberActivity
  extends BaseActivity
{
  Button button;
  TextView text;
  
  public void initialize()
  {
    this.text = ((TextView)findViewById(2131165494));
    if (cc.c().j() != null) {
      this.text.setText(cc.c().j());
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296436);
    initialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SerialNumberActivity
 * JD-Core Version:    0.7.0.1
 */