package com.tencent.token.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SmsActitivity
  extends Activity
{
  Button btnCancel;
  Button btnVerfiy;
  ScaleAnimation closeAnimation;
  ImageView ivDismiss;
  ImageView ivMid;
  ImageView iv_icon;
  private Dialog mDialog;
  Handler mHandler = new aak(this);
  View.OnClickListener onClick = new aal(this);
  ScaleAnimation openAnimation;
  TextView tv_content;
  TextView tv_title;
  View view;
  View viewRoot;
  View viewTitle;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    }
    for (;;)
    {
      return super.dispatchKeyEvent(paramKeyEvent);
      Intent localIntent = new Intent("com.tencent.token.action.dualsms");
      localIntent.putExtra("flag", 3);
      sendBroadcast(localIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903072);
    this.mHandler.sendEmptyMessageDelayed(0, 500L);
    this.viewRoot = findViewById(2131296501);
    this.tv_title = ((TextView)findViewById(2131296508));
    this.tv_content = ((TextView)findViewById(2131296509));
    try
    {
      paramBundle = getIntent().getStringExtra("title");
      String str = getIntent().getStringExtra("content");
      this.tv_title.setText(paramBundle);
      this.tv_content.setText(str);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SmsActitivity
 * JD-Core Version:    0.7.0.1
 */