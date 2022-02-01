package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

public final class agf
{
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext == null) {
        return -1;
      }
      if (!TextUtils.equals(paramContext.getAction(), "android.intent.action.BATTERY_CHANGED")) {
        return -1;
      }
      int i = paramContext.getIntExtra("level", 0);
      int j = paramContext.getIntExtra("scale", 100);
      if (j == 0) {
        return -1;
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
    finally {}
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agf
 * JD-Core Version:    0.7.0.1
 */