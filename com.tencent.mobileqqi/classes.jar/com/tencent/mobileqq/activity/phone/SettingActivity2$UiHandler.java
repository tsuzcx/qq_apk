package com.tencent.mobileqq.activity.phone;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class SettingActivity2$UiHandler
  extends Handler
{
  private WeakReference a;
  
  public SettingActivity2$UiHandler(SettingActivity2 paramSettingActivity2)
  {
    this.a = new WeakReference(paramSettingActivity2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((SettingActivity2)this.a.get() == null) {
      return;
    }
    switch (paramMessage.what)
    {
    }
    throw new RuntimeException("Unknown message: " + paramMessage.what);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.UiHandler
 * JD-Core Version:    0.7.0.1
 */