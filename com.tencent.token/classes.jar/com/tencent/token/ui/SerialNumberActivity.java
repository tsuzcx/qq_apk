package com.tencent.token.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.qz;

public class SerialNumberActivity
  extends BaseActivity
{
  Button button;
  TextView text;
  
  public void initialize()
  {
    this.text = ((TextView)findViewById(2131165498));
    String str = qz.a().b();
    if (str != null) {
      this.text.setText(str);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296437);
    initialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SerialNumberActivity
 * JD-Core Version:    0.7.0.1
 */