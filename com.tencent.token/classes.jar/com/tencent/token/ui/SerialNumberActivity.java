package com.tencent.token.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.ag;

public class SerialNumberActivity
  extends BaseActivity
{
  Button button;
  TextView text;
  
  public void initialize()
  {
    this.text = ((TextView)findViewById(2131297063));
    if (ag.c().j() != null) {
      this.text.setText(ag.c().j());
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903193);
    initialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SerialNumberActivity
 * JD-Core Version:    0.7.0.1
 */