package com.tencent.android.tpush.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class BroadcastAgent
{
  private static String a(Context paramContext)
  {
    return paramContext.getPackageName() + ".permission.XGPUSH_RECEIVE";
  }
  
  public static void registerReceiver(Context paramContext, BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    try
    {
      paramContext.getApplicationContext().registerReceiver(paramBroadcastReceiver, paramIntentFilter, a(paramContext), null);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void sendBroadcast(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.sendBroadcast(paramIntent, a(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void unregisterReceiver(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    try
    {
      paramContext.getApplicationContext().unregisterReceiver(paramBroadcastReceiver);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.BroadcastAgent
 * JD-Core Version:    0.7.0.1
 */