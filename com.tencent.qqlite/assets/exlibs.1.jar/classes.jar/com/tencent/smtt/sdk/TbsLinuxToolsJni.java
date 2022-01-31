package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni
{
  private static final String TAG = "TbsLinuxToolsJni";
  private static boolean gJniloaded = false;
  private static boolean mbIsInited = false;
  
  public TbsLinuxToolsJni(Context paramContext)
  {
    init(paramContext);
  }
  
  private native int ChmodInner(String paramString1, String paramString2);
  
  private void init(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (mbIsInited) {
          return;
        }
        mbIsInited = true;
      }
      finally {}
      try
      {
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label94;
        }
        paramContext = new File(TbsShareManager.getAvailableTbsCorePath(paramContext));
        if (paramContext != null)
        {
          System.load(paramContext.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
          gJniloaded = true;
        }
        ChmodInner("/checkChmodeExists", "700");
      }
      catch (Throwable paramContext)
      {
        label94:
        paramContext.printStackTrace();
        gJniloaded = false;
        continue;
      }
      return;
      paramContext = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
    }
  }
  
  public int Chmod(String paramString1, String paramString2)
  {
    if (!gJniloaded)
    {
      TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
      return -1;
    }
    return ChmodInner(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLinuxToolsJni
 * JD-Core Version:    0.7.0.1
 */