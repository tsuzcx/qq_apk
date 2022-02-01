package com.tencent.util;

import android.content.Context;
import android.os.Bundle;

public abstract interface IPlatformInterface
{
  public abstract String getQTProxyServiceName();
  
  public abstract void onEnter(Context paramContext, long paramLong, Bundle paramBundle);
  
  public abstract void onPluginManagerCreate(Context paramContext, IPlatformCallback paramIPlatformCallback);
  
  public abstract void onPluginManagerDestory();
  
  public abstract String pluginProcessName(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.IPlatformInterface
 * JD-Core Version:    0.7.0.1
 */