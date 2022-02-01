package com.tencent.mobileqq.mini.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;

public class ScreenOffOnListener
{
  private static volatile ScreenOffOnListener instance;
  private final BroadcastReceiver mReceiver = new ScreenOffOnListener.1(this);
  private ReceiveListener receiveListener;
  
  public static ScreenOffOnListener getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ScreenOffOnListener();
      }
      return instance;
    }
    finally {}
  }
  
  public void registListener(ReceiveListener paramReceiveListener)
  {
    this.receiveListener = paramReceiveListener;
    paramReceiveListener = new IntentFilter();
    paramReceiveListener.addAction("android.intent.action.SCREEN_ON");
    paramReceiveListener.addAction("android.intent.action.SCREEN_OFF");
    BaseApplication.getContext().registerReceiver(this.mReceiver, paramReceiveListener);
  }
  
  public void unRegistListener()
  {
    if ((this.mReceiver != null) && (this.receiveListener != null))
    {
      BaseApplication.getContext().unregisterReceiver(this.mReceiver);
      this.receiveListener = null;
    }
  }
  
  public static abstract interface ReceiveListener
  {
    public abstract void onReceiveListener(Context paramContext, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ScreenOffOnListener
 * JD-Core Version:    0.7.0.1
 */