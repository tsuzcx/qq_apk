package com.tencent.qqmini.sdk.launcher.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;

@MiniKeep
public class SharedPreferencesUtil
{
  public static final String PRE_MINI_APP = "pre_miniapp";
  private static SharedPreferences sPreMiniAppSp;
  
  public static SharedPreferences getPreference()
  {
    if (sPreMiniAppSp == null) {
      sPreMiniAppSp = AppLoaderFactory.g().getContext().getSharedPreferences("pre_miniapp", 4);
    }
    return sPreMiniAppSp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.SharedPreferencesUtil
 * JD-Core Version:    0.7.0.1
 */