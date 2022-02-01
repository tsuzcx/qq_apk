package com.tencent.mobileqq.activity.main;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import zju;

class MainAssistObserver$15$1
  implements Runnable
{
  MainAssistObserver$15$1(MainAssistObserver.15 param15, int paramInt) {}
  
  public void run()
  {
    this.a.this$0.f(32, 16, Integer.valueOf(this.cdD));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    this.a.m.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.15.1
 * JD-Core Version:    0.7.0.1
 */