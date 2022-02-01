package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

public class ch
{
  public static int a = -1;
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = 100;
    for (;;)
    {
      try
      {
        paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (paramContext == null)
        {
          j = a;
          return j;
        }
        if (!TextUtils.equals(paramContext.getAction(), "android.intent.action.BATTERY_CHANGED")) {
          return a;
        }
        int k;
        try
        {
          k = paramContext.getIntExtra("level", 0);
          int m = paramContext.getIntExtra("scale", 100);
          if (m == 0) {
            return a;
          }
          k = k * 100 / m;
          if (k < 0)
          {
            if (i > 100) {
              continue;
            }
            return i;
          }
        }
        catch (Throwable paramContext)
        {
          return a;
        }
        i = k;
      }
      catch (Throwable paramContext)
      {
        return a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ch
 * JD-Core Version:    0.7.0.1
 */