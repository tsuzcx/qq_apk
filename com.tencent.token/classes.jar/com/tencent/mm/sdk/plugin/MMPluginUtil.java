package com.tencent.mm.sdk.plugin;

import android.content.Context;

public class MMPluginUtil
{
  public static IMMPluginAPI queryPluginMgr(Context paramContext)
  {
    return new MMPluginAPIImpl(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginUtil
 * JD-Core Version:    0.7.0.1
 */