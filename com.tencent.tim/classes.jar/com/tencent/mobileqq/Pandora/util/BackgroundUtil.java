package com.tencent.mobileqq.Pandora.util;

import android.content.Context;
import android.text.TextUtils;

public class BackgroundUtil
{
  public static boolean isOnBackgroud(Context paramContext)
  {
    paramContext = SharedPreferencesManager.getData(paramContext, "onApplicationBackground");
    if ((TextUtils.isEmpty(paramContext)) || (paramContext.equals("data is null"))) {}
    while (!paramContext.equals("onbackground_true")) {
      return false;
    }
    Log.e("Pandora.Background", "isOnBackground update Pandora", new Throwable());
    return true;
  }
  
  public static void onApplicationBackground(Context paramContext)
  {
    SharedPreferencesManager.save(paramContext, "onApplicationBackground", "onbackground_true");
  }
  
  public static void onApplicationForeground(Context paramContext)
  {
    SharedPreferencesManager.save(paramContext, "onApplicationBackground", "onbackground_false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.util.BackgroundUtil
 * JD-Core Version:    0.7.0.1
 */