package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

public class QzoneModuleLoader
{
  public static final String TAG = "QzoneModuleLoader";
  
  public static boolean loadModuleDex(String paramString1, Context paramContext, ClassLoader paramClassLoader, String paramString2, boolean paramBoolean)
  {
    boolean bool = false;
    QMLog.d("QzoneModuleLoader", "classloader is: " + paramClassLoader + " , classloader class is: " + paramClassLoader.getClass());
    QMLog.d("QzoneModuleLoader", "load module: " + paramString1);
    if (TextUtils.isEmpty(paramString1)) {}
    while (!new File(paramString1).exists()) {
      return false;
    }
    long l = System.nanoTime();
    try
    {
      paramBoolean = QzoneModuleInjector.inject(paramContext, paramClassLoader, paramString1, paramString2, paramBoolean);
      l = (System.nanoTime() - l) / 1000000L;
      QMLog.d("QzoneModuleLoader", "loaded module success ? " + paramBoolean + " --module:  " + paramString1 + " , classloader: " + paramClassLoader + ", cost:" + l);
      return paramBoolean;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QMLog.e("QzoneModuleLoader", "inject failed, catch an exception:", paramContext);
        paramBoolean = bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.QzoneModuleLoader
 * JD-Core Version:    0.7.0.1
 */