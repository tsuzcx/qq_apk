package com.tencent.token.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

public class AppGuidActivity
  extends Activity
{
  private void initview()
  {
    setContentView(2130903056);
    an localan = new an(this);
    ((ImageButton)findViewById(2131296434)).setOnClickListener(localan);
    ((ImageButton)findViewById(2131296435)).setOnClickListener(localan);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    initview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AppGuidActivity
 * JD-Core Version:    0.7.0.1
 */