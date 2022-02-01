package com.tencent.qqmini.sdk.launcher.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@MiniKeep
public class DisplayUtil
{
  private static final String NAVIGATION = "navigationBarBackground";
  private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
  private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
  private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
  public static final String STATUS_BAR_HEIGHT = "status_bar_height";
  public static final String TAG = "DisplayUtil";
  private static float density;
  public static final boolean isImmersiveSupported;
  private static boolean mInPortrait;
  private static int mhasNavBar;
  private static String sNavBarOverride;
  public static int statusHeight = -1;
  
  static
  {
    mInPortrait = true;
    mhasNavBar = -1;
    if (VersionUtil.isKITKAT()) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      sNavBarOverride = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      if (Build.VERSION.SDK_INT < 19)
      {
        isImmersiveSupported = false;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        sNavBarOverride = null;
      }
      String str1 = Build.MANUFACTURER.toUpperCase();
      String str2 = str1 + "-" + Build.MODEL;
      if ((str1.endsWith("BBK")) || ((str1.endsWith("VIVO")) && (Build.VERSION.SDK_INT < 20)) || (str2.equals("OPPO-3007")))
      {
        isImmersiveSupported = false;
        return;
      }
      isImmersiveSupported = true;
    }
  }
  
  private static void checkImmersiveStatusBar(Window paramWindow)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 23) || (isVivoAndLOLLIPOP()))
      {
        paramWindow.clearFlags(67108864);
        paramWindow.getDecorView().setSystemUiVisibility(1280);
        paramWindow.addFlags(-2147483648);
        if (Build.VERSION.SDK_INT >= 21) {
          paramWindow.setStatusBarColor(0);
        }
      }
      return;
    }
    catch (Exception paramWindow)
    {
      QMLog.e("DisplayUtil", "", paramWindow);
    }
  }
  
  public static boolean checkNavigationBarShow(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
    if (i > 0) {}
    for (boolean bool1 = ((Resources)localObject).getBoolean(i);; bool1 = false)
    {
      try
      {
        localObject = Class.forName("android.os.SystemProperties");
        localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "qemu.hw.mainkeys" });
        if (Build.VERSION.SDK_INT < 21) {}
        for (i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);; i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0))
        {
          if ("1".equals(localObject)) {
            break label146;
          }
          if (1 != i) {
            break;
          }
          break label146;
        }
        boolean bool2 = "0".equals(localObject);
        if (bool2) {
          return true;
        }
      }
      catch (Exception paramContext)
      {
        return bool1;
      }
      return bool1;
    }
    label146:
    return false;
  }
  
  public static void clearCoverForStatus(Window paramWindow, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = Build.MANUFACTURER + Build.MODEL;
      QMLog.i("DisplayUtil", "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
      if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C")))) {
        setTranslucentStatus(paramWindow);
      }
    }
    else
    {
      return;
    }
    checkImmersiveStatusBar(paramWindow);
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
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private static boolean enableXiaoMiNotch(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow();
      Window.class.getMethod("addExtraFlags", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(1792) });
      if (QMLog.isColorLevel()) {
        QMLog.i("Window", "enableXiaoMiNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QMLog.isColorLevel()) {
        QMLog.e("Window", "enableXiaoMiNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  public static float getDensity(Context paramContext)
  {
    if (density != 0.0F) {
      return density;
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("");
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    density = paramContext.density;
    return paramContext.density;
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    return paramContext.getResources().getDisplayMetrics();
  }
  
  private static int getInternalDimensionSize(Resources paramResources, String paramString)
  {
    int i = 0;
    int j = paramResources.getIdentifier(paramString, "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static int getNavigationBarHeight(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = 0;
    if (Build.VERSION.SDK_INT >= 14) {
      if (!mInPortrait) {
        break label32;
      }
    }
    label32:
    for (paramContext = "navigation_bar_height";; paramContext = "navigation_bar_height_landscape")
    {
      i = getInternalDimensionSize(localResources, paramContext);
      return i;
    }
  }
  
  public static int getRealHeight(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return ((DisplayMetrics)localObject).heightPixels;
      }
      localObject = Display.class.getMethod("getRawHeight", new Class[0]);
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        return i;
      }
      catch (IllegalArgumentException paramContext)
      {
        QMLog.e("DisplayUtil", paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        QMLog.e("DisplayUtil", paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        QMLog.e("DisplayUtil", paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        QMLog.e("DisplayUtil", paramContext.getMessage());
      }
    }
    return -1;
  }
  
  public static int getScreenHeight(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      if (((!hasNavBar(paramActivity)) || (!isNavigationBarExist(paramActivity))) && (!isFlymeOS7NavBarShow())) {
        break label92;
      }
    }
    label92:
    for (int i = 1;; i = 0)
    {
      int k = localDisplayMetrics.heightPixels;
      int j = k;
      if (i != 0) {
        j = k - getNavigationBarHeight(paramActivity);
      }
      return j;
      localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
      break;
    }
  }
  
  public static int getScreenRefreshRate(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = ((DisplayManager)paramContext.getSystemService("display")).getDisplays();
      if ((paramContext != null) && (paramContext.length > 0)) {
        return (int)paramContext[0].getRefreshRate();
      }
    }
    return 60;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().orientation == 2) {
      return paramContext.getResources().getDisplayMetrics().heightPixels;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    float f3;
    float f1;
    if (statusHeight == -1)
    {
      i = 0;
      paramContext = paramContext.getResources();
      int j = paramContext.getIdentifier("status_bar_height", "dimen", "android");
      if (j > 0) {
        i = paramContext.getDimensionPixelSize(j);
      }
      f3 = paramContext.getDisplayMetrics().density;
      float f2 = f3 / paramContext.getDisplayMetrics().density;
      f1 = f2;
      if (f2 <= 0.0F) {
        f1 = 1.0F;
      }
      if (i > 0) {
        break label95;
      }
    }
    label95:
    for (int i = Math.round(25.0F * f1 * f3);; i = (int)Math.ceil(i * f1 + 0.5F))
    {
      statusHeight = i;
      return statusHeight;
    }
  }
  
  public static String getSystemProperty(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static boolean hasNavBar(Context paramContext)
  {
    if (mhasNavBar != -1) {
      return mhasNavBar == 1;
    }
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool;
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if ("1".equals(sNavBarOverride)) {
        bool = false;
      }
    }
    for (;;)
    {
      QMLog.d("XPanelContainer", "hasNavbar=" + bool);
      if (bool) {}
      for (mhasNavBar = 1;; mhasNavBar = 0)
      {
        return bool;
        if (!"0".equals(sNavBarOverride)) {
          break;
        }
        bool = true;
        break;
        if (Build.VERSION.SDK_INT < 14) {
          break label144;
        }
        if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey())
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      label144:
      bool = false;
    }
  }
  
  public static boolean isFlymeOS7NavBarShow()
  {
    String str = getSystemProperty("ro.build.display.id", "");
    if (("Flyme 7.1.1.4A".equals(str)) || ("Flyme 7.3.0.0A".equals(str)))
    {
      if (("1".equals(getSystemProperty("persist.sys.mz_mback_nav", "0"))) && ("0".equals(getSystemProperty("persist.sys.mz_mainkeys", "0")))) {}
      while (("0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0"))) && ("0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0")))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isNavigationBarExist(Activity paramActivity)
  {
    boolean bool2 = false;
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    boolean bool1 = bool2;
    int i;
    if (localViewGroup != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId())))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isNavigationBarShow(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      paramActivity.getSize(localPoint1);
      paramActivity.getRealSize(localPoint2);
      if (localPoint2.y == localPoint1.y) {}
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return true;
      return false;
      bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
      bool2 = KeyCharacterMap.deviceHasKey(4);
    } while ((!bool1) && (!bool2));
    return false;
  }
  
  public static boolean isVivoAndLOLLIPOP()
  {
    return ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
  }
  
  public static float mpx2px(double paramDouble)
  {
    return (float)(density * paramDouble);
  }
  
  public static int mpx2pxInt(double paramDouble)
  {
    return (int)(density * paramDouble + 0.5D);
  }
  
  public static int parseColor(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (paramString.length() == 4)
      {
        str1 = paramString;
        if (paramString.substring(0, 1).equals("#"))
        {
          str1 = paramString.substring(1, 2);
          String str2 = paramString.substring(2, 3);
          paramString = paramString.substring(3, 4);
          str1 = "#" + str1 + str1 + str2 + str2 + paramString + paramString;
        }
      }
      int i = Color.parseColor(str1);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
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
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static float px2mpx(double paramDouble)
  {
    return (float)(paramDouble / density);
  }
  
  public static void setActivityFullScreen(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(23075586);
      }
    }
  }
  
  public static void setActivityTransparent(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFormat(-2);
    LiuHaiUtils.initLiuHaiProperty(paramActivity);
    if (LiuHaiUtils.isLiuHaiUseValid())
    {
      if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27))) {
        enableXiaoMiNotch(paramActivity);
      }
    }
    else {
      return;
    }
    LiuHaiUtils.enableNotch(paramActivity);
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
          QMLog.e("DisplayUtil", "setStatusBarDarkModeForFlyme: failed");
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
  
  public static void setSystemUIVisible(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
      localLayoutParams.flags &= 0xFFFFFBFF;
      paramActivity.getWindow().setAttributes(localLayoutParams);
      paramActivity.getWindow().clearFlags(512);
      return;
    }
    LiuHaiUtils.initLiuHaiProperty(paramActivity);
    if (LiuHaiUtils.isLiuHaiUseValid())
    {
      if ((!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) || ((Build.VERSION.SDK_INT != 26) && (Build.VERSION.SDK_INT != 27))) {
        break label100;
      }
      enableXiaoMiNotch(paramActivity);
    }
    for (;;)
    {
      paramActivity.getWindow().setFlags(1024, 1024);
      return;
      label100:
      LiuHaiUtils.enableNotch(paramActivity);
    }
  }
  
  public static void setTranslucentStatus(Window paramWindow)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Field localField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
      localField.setAccessible(true);
      localField.setInt(paramWindow.getDecorView(), 0);
      return;
    }
    catch (Exception paramWindow)
    {
      QMLog.i("DisplayUtil", "反射修改状态栏颜色失败");
    }
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public static void updatePortrait(Activity paramActivity)
  {
    boolean bool = true;
    if (paramActivity != null) {
      if (paramActivity.getWindow().getContext().getResources().getConfiguration().orientation != 1) {
        break label31;
      }
    }
    for (;;)
    {
      mInPortrait = bool;
      return;
      label31:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */