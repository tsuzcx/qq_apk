package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

public final class aeu
{
  public static int a = -1;
  
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext == null) {
        return a;
      }
      if (!TextUtils.equals(paramContext.getAction(), "android.intent.action.BATTERY_CHANGED")) {
        return a;
      }
    }
    catch (Throwable paramContext)
    {
      int i;
      int j;
      label92:
      label96:
      break label96;
    }
    try
    {
      i = paramContext.getIntExtra("level", 0);
      j = paramContext.getIntExtra("scale", 100);
      if (j == 0) {
        return a;
      }
      j = i * 100 / j;
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i > 100) {
        j = 100;
      }
      return j;
    }
    catch (Throwable paramContext)
    {
      break label92;
    }
    return a;
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aeu
 * JD-Core Version:    0.7.0.1
 */