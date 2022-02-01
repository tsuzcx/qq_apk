package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;

class QQAppInterface$19
  implements Runnable
{
  QQAppInterface$19(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.this$0.getApp()).edit();
    localEditor.putString("LastScreenShotUri", "");
    localEditor.commit();
    this.this$0.cLy();
    try
    {
      QQAppInterface.i(this.this$0).unregisterReceiver(QQAppInterface.c(this.this$0));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.19
 * JD-Core Version:    0.7.0.1
 */