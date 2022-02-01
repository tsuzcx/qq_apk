package com.tencent.mobileqq.activity;

import android.provider.Settings.System;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class BaseChatPie$82
  implements Runnable
{
  BaseChatPie$82(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    try
    {
      Settings.System.putInt(this.this$0.app.getApp().getContentResolver(), "listview_oversroll", this.bEK);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.82
 * JD-Core Version:    0.7.0.1
 */