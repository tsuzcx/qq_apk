package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class BaseActivity$3
  implements Runnable
{
  BaseActivity$3(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.this$0.getSharedPreferences("screen_shot", 4).edit();
    localEditor.putString("currentactivity", getClass().getName());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.3
 * JD-Core Version:    0.7.0.1
 */