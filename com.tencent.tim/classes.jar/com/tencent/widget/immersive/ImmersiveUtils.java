package com.tencent.widget.immersive;

import aafz;
import acej;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import aqfo;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ImmersiveUtils
{
  public static int FLAG_TRANSLUCENT_STATUS;
  public static String TAG;
  private static float density;
  public static boolean dlw;
  public static boolean dlx;
  public static volatile boolean dly;
  private static boolean dlz;
  public static boolean iT;
  public static int i_support_immersive;
  private static boolean sHasNotch;
  private static int screenHeight;
  private static int screenWidth;
  public static int statusHeight;
  
  static
  {
    String str;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("ImmersiveUtils escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.sImmersiveUtilsEscapedMsg = str + "\n" + QLog.getStackTraceString(localThrowable);
        QLog.e("DexLoad", 1, "ImmersiveUtils escapes!");
      }
    }
    for (;;)
    {
      TAG = "ImmersiveUtils";
      density = -1.0F;
      screenWidth = -1;
      screenHeight = -1;
      i_support_immersive = -1;
      dlw = true;
      FLAG_TRANSLUCENT_STATUS = 67108864;
      statusHeight = -1;
      str = Build.MANUFACTURER + "-" + Build.MODEL;
      if (str.equalsIgnoreCase("smartisan-sm705")) {
        dlx = true;
      }
      if (str.equalsIgnoreCase("vivo-vivo Y35A")) {
        dlx = true;
      }
      iT = true;
      return;
      BaseApplicationImpl.sImmersiveUtilsEscapedMsg = "";
    }
  }
  
  public static int a(Window paramWindow, Context paramContext)
  {
    int i = 2;
    if (paramWindow == null) {
      return 0;
    }
    if (Build.MANUFACTURER.toUpperCase().endsWith("SAMSUNG")) {
      if (paramWindow.getDecorView().getSystemUiVisibility() == 0) {
        break label66;
      }
    }
    for (;;)
    {
      return i;
      int[] arrayOfInt = new int[2];
      paramWindow.getDecorView().getLayoutParams();
      paramWindow.getDecorView().getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] <= getStatusBarHeight(paramContext) * 2) {
        label66:
        i = 0;
      }
    }
  }
  
  public static boolean a(Window paramWindow)
  {
    Rect localRect = new Rect();
    paramWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
    if ((localRect.top <= 0) || (localRect.top > 200))
    {
      QLog.w(TAG, 2, "invalid status height: " + localRect.top);
      return false;
    }
    if (Math.abs(localRect.top - statusHeight) > 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "correct status bar height: " + statusHeight + ", top = " + localRect.top);
      }
      statusHeight = localRect.top;
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0).edit().putInt("status_bar_height", statusHeight).apply();
      dly = true;
      return true;
    }
    return false;
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    if (!VersionUtils.isKITKAT()) {}
    do
    {
      return false;
      if ((iT) && (aqfo.isMIUI())) {
        return b(paramWindow, paramBoolean);
      }
    } while (!aqfo.isFlyme());
    return setStatusBarDarkModeForFlyme(paramWindow, paramBoolean);
  }
  
  public static boolean aJW()
  {
    boolean bool1 = false;
    boolean bool2 = aafz.isMIUI();
    boolean bool3 = aafz.isFlymeOS();
    if (Build.VERSION.SDK_INT >= 23) {}
    for (int i = 1;; i = 0)
    {
      if ((bool2) || (bool3) || (i != 0)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  private static boolean b(Window paramWindow, boolean paramBoolean)
  {
    if ((paramWindow != null) && (iT))
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
        iT = false;
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "setStatusBarDarkModeForMIUI: failed");
        }
      }
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
        paramWindow.setStatusBarColor(0);
      }
      return;
    }
    catch (Exception paramWindow)
    {
      QLog.e(TAG, 1, paramWindow, new Object[0]);
    }
  }
  
  public static void clearCoverForStatus(Window paramWindow, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = Build.MANUFACTURER + Build.MODEL;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
      }
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
  
  public static int dpToPx(float paramFloat)
  {
    return Math.round(getDensity() * paramFloat);
  }
  
  public static boolean eB()
  {
    return (VersionUtils.isKITKAT()) && (((iT) && (aqfo.isMIUI())) || (aqfo.isFlyme()));
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
    SharedPreferences localSharedPreferences;
    float f1;
    if (statusHeight == -1)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      statusHeight = localSharedPreferences.getInt("status_bar_height", -1);
      if (statusHeight == -1)
      {
        Resources localResources = paramContext.getResources();
        int j = localResources.getIdentifier("status_bar_height", "dimen", "android");
        if (j > 0) {
          i = localResources.getDimensionPixelSize(j);
        }
        f1 = acej.k.density;
        if (QLog.isColorLevel()) {
          QLog.d("systembar", 2, "getStatusBarHeight org=" + i + ", sys density=" + f1 + ", cur density=" + paramContext.getResources().getDisplayMetrics().density);
        }
        f1 /= paramContext.getResources().getDisplayMetrics().density;
        if (i > 0) {
          break label251;
        }
        if (f1 > 0.0F) {
          break label248;
        }
        f1 = 1.0F;
      }
    }
    label248:
    for (;;)
    {
      i = dpToPx(f1 * 25.0F);
      statusHeight = i;
      localSharedPreferences.edit().putInt("status_bar_height", statusHeight).apply();
      if (QLog.isColorLevel()) {
        QLog.i("systembar", 2, "height=" + statusHeight);
      }
      return statusHeight;
    }
    label251:
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
  
  public static boolean hasNotchInScreen(Activity paramActivity)
  {
    if (!dlz)
    {
      sHasNotch = ayxa.hasNotchInScreenByVersion(paramActivity);
      dlz = true;
    }
    return sHasNotch;
  }
  
  private static void init()
  {
    DisplayMetrics localDisplayMetrics;
    if (density == -1.0F)
    {
      localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
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
  
  public static int isSupporImmersive()
  {
    if (i_support_immersive != -1) {
      return i_support_immersive;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      i_support_immersive = 0;
      return i_support_immersive;
    }
    String str1 = Build.MANUFACTURER.toUpperCase();
    String str2 = str1 + "-" + Build.MODEL;
    if (((!str1.endsWith("BBK")) && (!str1.endsWith("VIVO"))) || ((Build.VERSION.SDK_INT < 20) || (str2.equals("OPPO-3007")))) {}
    for (i_support_immersive = 0;; i_support_immersive = 1) {
      return i_support_immersive;
    }
  }
  
  public static boolean isVivoAndLOLLIPOP()
  {
    return ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
  }
  
  public static void l(Window paramWindow)
  {
    if (VersionUtils.isLOLLIPOP())
    {
      paramWindow.clearFlags(67108864);
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
    }
    while (!VersionUtils.isKITKAT()) {
      return;
    }
    paramWindow.addFlags(67108864);
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
  
  @TargetApi(11)
  public static void setAlpha(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(paramFloat);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  @TargetApi(14)
  public static void setFitsSystemWindows(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      paramView.setFitsSystemWindows(paramBoolean);
      paramView.setPadding(0, getStatusBarHeight(paramView.getContext()), 0, 0);
    }
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
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(TAG, 2, "setStatusBarDarkModeForFlyme: failed");
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
    if (aafz.isFlymeOS()) {
      return setStatusBarDarkModeForFlyme(paramWindow, paramBoolean);
    }
    if (aafz.isMIUI()) {
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
      while (!QLog.isColorLevel()) {}
      QLog.i(TAG, 2, "反射修改状态栏颜色失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.widget.immersive.ImmersiveUtils
 * JD-Core Version:    0.7.0.1
 */