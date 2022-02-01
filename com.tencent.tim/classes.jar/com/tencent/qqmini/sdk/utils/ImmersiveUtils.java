package com.tencent.qqmini.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.OSUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MiniKeep
public class ImmersiveUtils
{
  public static final String TAG = "ImmersiveUtils";
  private static float density;
  private static int screenHeight = -1;
  private static int screenWidth;
  public static int statusHeight = -1;
  
  static
  {
    density = -1.0F;
    screenWidth = -1;
  }
  
  @TargetApi(23)
  private static void compatHighMIUI(Window paramWindow, boolean paramBoolean)
  {
    paramWindow = paramWindow.getDecorView();
    if (paramBoolean)
    {
      paramWindow.setSystemUiVisibility(9216);
      return;
    }
    paramWindow.setSystemUiVisibility(paramWindow.getSystemUiVisibility() & 0xFFFFDFFF);
  }
  
  private static boolean compatLowMIUI(Window paramWindow, boolean paramBoolean)
  {
    Object localObject = paramWindow.getClass();
    try
    {
      Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
      int j = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
      localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
      if (paramBoolean) {}
      for (int i = j;; i = 0)
      {
        ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        return true;
      }
      return false;
    }
    catch (Exception paramWindow)
    {
      paramWindow.printStackTrace();
    }
  }
  
  public static float getDensity()
  {
    init();
    return density;
  }
  
  public static int getScreenHeight()
  {
    init();
    return screenHeight;
  }
  
  public static int getScreenWidth()
  {
    init();
    return screenWidth;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    float f2 = 1.0F;
    int i = 0;
    float f1;
    if (statusHeight == -1)
    {
      Resources localResources = paramContext.getResources();
      int j = localResources.getIdentifier("status_bar_height", "dimen", "android");
      if (j > 0) {
        i = localResources.getDimensionPixelSize(j);
      }
      f1 = ViewUtils.getDensity();
      if (QMLog.isColorLevel()) {
        QMLog.d("systembar", "getStatusBarHeight org=" + i + ", sys density=" + f1 + ", cur density=" + paramContext.getResources().getDisplayMetrics().density);
      }
      f1 /= paramContext.getResources().getDisplayMetrics().density;
      if (i > 0) {
        break label154;
      }
      if (f1 > 0.0F) {
        break label151;
      }
      f1 = 1.0F;
    }
    label151:
    for (;;)
    {
      i = ViewUtils.dpToPx(f1 * 25.0F);
      statusHeight = i;
      return statusHeight;
    }
    label154:
    float f3 = i;
    if (f1 <= 0.0F) {
      f1 = f2;
    }
    for (;;)
    {
      i = (int)Math.ceil(f3 * f1 + 0.5F);
      break;
    }
  }
  
  private static void init()
  {
    DisplayMetrics localDisplayMetrics;
    if (density == -1.0F)
    {
      localDisplayMetrics = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
      density = localDisplayMetrics.density;
      if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
      {
        screenWidth = localDisplayMetrics.widthPixels;
        screenHeight = localDisplayMetrics.heightPixels;
      }
    }
    else
    {
      return;
    }
    screenHeight = localDisplayMetrics.widthPixels;
    screenWidth = localDisplayMetrics.heightPixels;
  }
  
  private static boolean processMIUI(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      compatHighMIUI(paramWindow, paramBoolean);
      return true;
    }
    return compatLowMIUI(paramWindow, paramBoolean);
  }
  
  private static boolean setStatusBarDarkModeForFlyme(Window paramWindow, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramWindow != null) {
      for (;;)
      {
        try
        {
          WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
          Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
          Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
          localField1.setAccessible(true);
          localField2.setAccessible(true);
          i = localField1.getInt(null);
          j = localField2.getInt(localLayoutParams);
          if (!paramBoolean) {
            continue;
          }
          i |= j;
          localField2.setInt(localLayoutParams, i);
          paramWindow.setAttributes(localLayoutParams);
        }
        catch (Exception localException)
        {
          int j;
          QMLog.e("ImmersiveUtils", "setStatusBarDarkModeForFlyme: failed");
          bool = false;
          continue;
          int i = j & 0xFFFFDFFF;
          continue;
        }
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramWindow = paramWindow.getDecorView();
          if (paramWindow != null)
          {
            j = paramWindow.getSystemUiVisibility();
            if (!paramBoolean) {
              continue;
            }
            i = j | 0x2000;
            if (i != j) {
              paramWindow.setSystemUiVisibility(i);
            }
          }
        }
        return bool;
        i = (i ^ 0xFFFFFFFF) & j;
      }
    }
    return false;
  }
  
  public static boolean setStatusTextColor(boolean paramBoolean, Window paramWindow)
  {
    if (OSUtils.isFlymeOS()) {
      return setStatusBarDarkModeForFlyme(paramWindow, paramBoolean);
    }
    if (OSUtils.isMIUI()) {
      return processMIUI(paramWindow, paramBoolean);
    }
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramWindow.getDecorView().setSystemUiVisibility(9216);
        return true;
      }
    }
    else if (Build.VERSION.SDK_INT >= 23)
    {
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ImmersiveUtils
 * JD-Core Version:    0.7.0.1
 */