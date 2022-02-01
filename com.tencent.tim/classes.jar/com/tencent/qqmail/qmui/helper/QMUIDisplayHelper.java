package com.tencent.qqmail.qmui.helper;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public class QMUIDisplayHelper
{
  public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
  private static final String TAG = "Devices";
  public static float sDensity = 0.0F;
  private static Boolean sHasCamera = null;
  
  public static void cancelFullScreen(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      WindowManager.LayoutParams localLayoutParams = paramContext.getWindow().getAttributes();
      localLayoutParams.flags &= 0xFFFFFBFF;
      paramContext.getWindow().setAttributes(localLayoutParams);
      paramContext.getWindow().addFlags(512);
    }
  }
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    return (int)(getDensity(paramContext) * paramInt + 0.5D);
  }
  
  public static int dpToPx(int paramInt)
  {
    return (int)(paramInt * DENSITY + 0.5F);
  }
  
  public static int getActionBarHeight(Context paramContext)
  {
    int i = 0;
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true)) {
      i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
    }
    return i;
  }
  
  public static String getCurCountryLan(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.getLanguage() + "-" + paramContext.getResources().getConfiguration().locale.getCountry();
  }
  
  public static float getDensity(Context paramContext)
  {
    if (sDensity == 0.0F) {
      sDensity = getDisplayMetrics(paramContext).density;
    }
    return sDensity;
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static int getNavMenuHeight(Context paramContext)
  {
    return getRealScreenSize(paramContext)[1] - getScreenHeight(paramContext);
  }
  
  public static int[] getRealScreenSize(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject = new DisplayMetrics();
    paramContext.getMetrics((DisplayMetrics)localObject);
    i = ((DisplayMetrics)localObject).widthPixels;
    j = ((DisplayMetrics)localObject).heightPixels;
    try
    {
      k = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      i = k;
      m = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      i = m;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m;
        int k = i;
        i = j;
      }
    }
    j = k;
    try
    {
      localObject = new Point();
      j = k;
      Display.class.getMethod("getRealSize", new Class[] { Point.class }).invoke(paramContext, new Object[] { localObject });
      j = k;
      k = ((Point)localObject).x;
      j = k;
      m = ((Point)localObject).y;
      j = k;
      i = m;
    }
    catch (Exception paramContext)
    {
      label165:
      break label165;
    }
    return new int[] { j, i };
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return getDisplayMetrics(paramContext).heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return getDisplayMetrics(paramContext).widthPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static final boolean hasCamera(Context paramContext)
  {
    if (sHasCamera == null)
    {
      paramContext = paramContext.getPackageManager();
      bool1 = paramContext.hasSystemFeature("android.hardware.camera.front");
      boolean bool2 = paramContext.hasSystemFeature("android.hardware.camera");
      if ((!bool1) && (!bool2)) {
        break label51;
      }
    }
    label51:
    for (boolean bool1 = true;; bool1 = false)
    {
      sHasCamera = Boolean.valueOf(bool1);
      return sHasCamera.booleanValue();
    }
  }
  
  public static boolean hasHardwareMenuKey(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return true;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return ViewConfiguration.get(paramContext).hasPermanentMenuKey();
    }
    return false;
  }
  
  public static boolean hasInternet(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo() != null;
  }
  
  public static boolean hasStatusBar(Context paramContext)
  {
    return (!(paramContext instanceof Activity)) || ((((Activity)paramContext).getWindow().getAttributes().flags & 0x400) != 1024);
  }
  
  public static boolean isFullScreen(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramContext instanceof Activity))
    {
      bool1 = bool2;
      if ((((Activity)paramContext).getWindow().getAttributes().flags & 0x400) == 1024) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isPackageExist(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean isSdcardReady()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static boolean isZhCN(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.getCountry().equalsIgnoreCase("CN");
  }
  
  public static int px2dp(Context paramContext, int paramInt)
  {
    return (int)(paramInt / getDensity(paramContext) + 0.5D);
  }
  
  public static int pxToDp(float paramFloat)
  {
    return (int)(paramFloat / DENSITY + 0.5F);
  }
  
  public static void setFullScreen(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      WindowManager.LayoutParams localLayoutParams = paramContext.getWindow().getAttributes();
      localLayoutParams.flags |= 0x400;
      paramContext.getWindow().setAttributes(localLayoutParams);
      paramContext.getWindow().addFlags(512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.helper.QMUIDisplayHelper
 * JD-Core Version:    0.7.0.1
 */