package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;

public class PluginRuntime
  extends AppRuntime
{
  private static final String CRASH_ACTION = "com.tencent.qqlite.ACTION_PLUGIN_CRASH";
  private static final String INDEX_PLUGINID = "pluginsdk_carsh_pluginID";
  private static final String INDEX_THROWABLE = "pluginsdk_carsh_throwable";
  private static final boolean SUPPORT_CRASH_REPORT = false;
  private IClickEventReportor mReportor;
  
  public static PluginRuntime getRuntime()
  {
    Object localObject2 = null;
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    Object localObject1 = localObject2;
    if (localAppRuntime != null)
    {
      localObject1 = localObject2;
      if ((localAppRuntime instanceof PluginRuntime)) {
        localObject1 = (PluginRuntime)localAppRuntime;
      }
    }
    return localObject1;
  }
  
  public static PluginRuntime getRuntime(String paramString)
  {
    return getRuntime();
  }
  
  public static void handleCrash(Throwable paramThrowable, String paramString, Context paramContext) {}
  
  public Manager getManager(int paramInt)
  {
    Object localObject = super.getManager(paramInt);
    if (localObject != null) {
      return localObject;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        addManager(paramInt, (Manager)localObject);
      }
      return localObject;
      localObject = new WtloginManagerImpl(this);
    }
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (this.mReportor != null) {
      this.mReportor.reportClickEvent(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    }
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (this.mReportor != null) {
      this.mReportor.reportClickEventRuntime(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    }
  }
  
  public void sendAppDataIncerment(String paramString, String[] paramArrayOfString, long paramLong)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginRuntime.sendAppDataIncerment:" + paramArrayOfString);
    }
    super.sendAppDataIncermentMsg(paramString, paramArrayOfString, paramLong);
  }
  
  public void setClickEventReportor(IClickEventReportor paramIClickEventReportor)
  {
    this.mReportor = paramIClickEventReportor;
  }
  
  public static abstract interface IClickEventReportor
  {
    public abstract void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
    
    public abstract void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRuntime
 * JD-Core Version:    0.7.0.1
 */