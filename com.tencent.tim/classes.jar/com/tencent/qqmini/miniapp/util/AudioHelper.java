package com.tencent.qqmini.miniapp.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Method;

public class AudioHelper
{
  private static final String CLASS_NAME_APPOPSMANAGER = "AppOpsManager";
  private static final int MODE_ALLOWED = 0;
  private static final int OP_CEMARE_BEFORE_MEIZU_API19 = 35;
  private static final int OP_CEMARE_IN_ANDROID_SDK_API19 = 26;
  private static final int[] OP_IN_ANDROID_SDK_API19 = { 26, 27 };
  private static final int[] OP_IN_ANDROID_SDK_BEFORE_API19 = { 35, 36 };
  private static final int OP_RECORD_AUDIO_BEFORE_MEIZU_API19 = 36;
  private static final int OP_RECORD_AUDIO_IN_ANDROID_SDK_API19 = 27;
  public static final int OP_TYPE_CEMARE = 0;
  public static final int OP_TYPE_RECORD = 1;
  private static final String TAG = "AudioHelper";
  
  public static boolean isForbidByRubbishMeizu(int paramInt)
  {
    return isForbidByRubbishMeizu(paramInt, AppLoaderFactory.g().getContext());
  }
  
  public static boolean isForbidByRubbishMeizu(int paramInt, Context paramContext)
  {
    if ((!isRubbishMeizuPhone()) || (Build.VERSION.SDK_INT < 17)) {}
    do
    {
      return false;
      paramContext = paramContext.getSystemService("appops");
    } while ((paramContext == null) || (!paramContext.getClass().getSimpleName().equals("AppOpsManager")));
    try
    {
      Method localMethod = paramContext.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
      int i = OP_IN_ANDROID_SDK_API19[paramInt];
      if (Build.VERSION.SDK_INT < 19) {
        i = OP_IN_ANDROID_SDK_BEFORE_API19[paramInt];
      }
      ApplicationInfo localApplicationInfo = AppLoaderFactory.g().getContext().getApplicationInfo();
      paramInt = ((Integer)localMethod.invoke(paramContext, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
      QMLog.d("AudioHelper", "isForbidByRubbishMeizu(), result = " + paramInt);
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      QMLog.e("AudioHelper", paramContext.toString());
    }
  }
  
  private static boolean isRubbishMeizuPhone()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.AudioHelper
 * JD-Core Version:    0.7.0.1
 */