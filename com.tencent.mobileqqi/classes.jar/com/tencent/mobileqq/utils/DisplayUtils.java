package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class DisplayUtils
{
  public static float a(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F * paramFloat;
  }
  
  public static int a(Context paramContext)
  {
    int i = Math.min(paramContext.getResources().getDisplayMetrics().heightPixels, paramContext.getResources().getDisplayMetrics().widthPixels);
    if (i <= 240) {
      return 36;
    }
    if (i <= 320) {
      return 48;
    }
    if (i <= 640) {
      return 72;
    }
    return 96;
  }
  
  public static int b(Context paramContext)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      i = ((ActivityManager)paramContext.getSystemService("activity")).getLauncherLargeIconSize();
    }
    int j = (int)paramContext.getResources().getDimension(17104896);
    if (QLog.isColorLevel()) {
      QLog.d("DisplayUtils", 2, "launcher icon size = " + i + " , app icon size = " + j);
    }
    return Math.max(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DisplayUtils
 * JD-Core Version:    0.7.0.1
 */