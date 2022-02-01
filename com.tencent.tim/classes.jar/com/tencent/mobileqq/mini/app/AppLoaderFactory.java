package com.tencent.mobileqq.mini.app;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.util.MiniAppDexLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AppLoaderFactory
{
  public static final String BASE_LIB_PATH_DIR = PATH_WXAPKG_ROOT + ".baseLib";
  public static final String PATH_WXAPKG_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/";
  public static final String TAG = "miniapp-start";
  public static final String TAG_CHROMIUM = "miniapp-chromium";
  public static final String TAG_JS = "miniapp-JS";
  public static final String TAG_PROCESSOR = "miniapp-process";
  private static volatile BaseAppLoaderManager sAppLoaderManager;
  private static volatile IAppUIProxy sAppUIProxy;
  private static int sLaunchMode = -1;
  
  public static IAppUIProxy createAppUIProxy()
  {
    if (sAppUIProxy == null) {}
    try
    {
      if (sAppUIProxy == null) {
        sAppUIProxy = MiniAppDexLoader.getInstance().createAppUIProxy("com.tencent.mobileqq.mini.app.AppUIProxy");
      }
      return sAppUIProxy;
    }
    finally {}
  }
  
  public static IAppUIProxy createInternalAppUIProxy()
  {
    if (sAppUIProxy == null) {}
    try
    {
      if (sAppUIProxy == null) {
        sAppUIProxy = MiniAppDexLoader.getInstance().createAppUIProxy("com.tencent.mobileqq.mini.app.InternalAppUIProxy");
      }
      return sAppUIProxy;
    }
    finally {}
  }
  
  public static BaseAppLoaderManager getAppLoaderManager()
  {
    if (sAppLoaderManager == null) {}
    try
    {
      if (sAppLoaderManager == null) {
        sAppLoaderManager = MiniAppDexLoader.getInstance().createAppLoaderManager("com.tencent.mobileqq.mini.app.AppLoaderManager");
      }
      return sAppLoaderManager;
    }
    finally {}
  }
  
  public static IAppUIProxy getAppUIProxy()
  {
    return sAppUIProxy;
  }
  
  public static void initLaunchMode(Intent paramIntent)
  {
    int i = 1;
    if (sLaunchMode >= 0) {
      return;
    }
    String str = BaseApplicationImpl.getApplication().getQQProcessName();
    if ((!"com.tencent.tim:mini".equals(str)) && (!"com.tencent.tim:mini1".equals(str)) && (!"com.tencent.tim:mini2".equals(str)))
    {
      sLaunchMode = 0;
      QLog.w("miniapp-start", 1, "initLaunchMode in process=" + str + ", sLaunchMode=" + sLaunchMode);
      return;
    }
    if (paramIntent == null)
    {
      sLaunchMode = 0;
      QLog.w("miniapp-start", 1, "initLaunchMode with intent is null, sLaunchMode=" + sLaunchMode);
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("sdk_mode", false);
    QLog.w("miniapp-start", 1, "initLaunchMode with intent param SDKMode " + bool);
    if (bool) {}
    for (;;)
    {
      sLaunchMode = i;
      return;
      i = 0;
    }
  }
  
  public static boolean isSDKMode()
  {
    return sLaunchMode == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppLoaderFactory
 * JD-Core Version:    0.7.0.1
 */