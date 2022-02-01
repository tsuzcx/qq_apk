package com.tencent.mobileqq.qfix;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import dalvik.system.PathClassLoader;

public abstract class QFixApplication
  extends Application
{
  public ApplicationDelegate applicationLike;
  public String mApplicationDelegateName;
  
  public QFixApplication(String paramString)
  {
    this.mApplicationDelegateName = paramString;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    ClassLoader localClassLoader2 = super.getClassLoader();
    Object localObject = localClassLoader2;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = localClassLoader2;
      if (!isAndroidNPatchEnable()) {}
    }
    try
    {
      localObject = AndroidNClassLoader.inject((PathClassLoader)super.getClassLoader(), this);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.applicationLike = ((ApplicationDelegate)((ClassLoader)localObject).loadClass(this.mApplicationDelegateName).newInstance());
          this.applicationLike.proxyAttachBaseContext(paramContext, this);
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          ClassLoader localClassLoader1 = super.getClassLoader();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public boolean isAndroidNPatchEnable()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.applicationLike != null) {
      this.applicationLike.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.applicationLike.onCreate();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.applicationLike != null) {
      this.applicationLike.onLowMemory();
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    if (this.applicationLike != null) {
      this.applicationLike.onTerminate();
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (this.applicationLike != null) {
      this.applicationLike.onTrimMemory(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.QFixApplication
 * JD-Core Version:    0.7.0.1
 */