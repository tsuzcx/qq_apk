package com.tencent.mm.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.plugin.IMMPluginAPI;
import com.tencent.mm.sdk.plugin.MMPluginUtil;

public final class MMAppMgr
{
  public static void activate(boolean paramBoolean) {}
  
  public static IMMPluginAPI getPluginMgr(Context paramContext)
  {
    return MMPluginUtil.queryPluginMgr(paramContext);
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, int paramInt)
  {
    return new MMSharedPreferences(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.MMAppMgr
 * JD-Core Version:    0.7.0.1
 */