package com.tencent.qqmail.utilities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.app.ActivityCompat;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarUtil
{
  public static final int BLACK_COLOR = ActivityCompat.getColor(QMApplicationContext.sharedInstance(), 2131165374);
  public static final int GRAY_COLOR;
  public static final String TAG = "StatusBarUtil";
  public static final int WHITE_COLOR = ActivityCompat.getColor(QMApplicationContext.sharedInstance(), 2131167585);
  private static final String ZUKZ1 = "zuk z1";
  
  static
  {
    GRAY_COLOR = ActivityCompat.getColor(QMApplicationContext.sharedInstance(), 2131165859);
  }
  
  public static boolean availableVersion()
  {
    return (Build.VERSION.SDK_INT >= 19) && (SharedPreferenceUtil.isTranslucentBarEnable());
  }
  
  public static int getStatusBarHeight()
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    int i = 0;
    int j = localQMApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = localQMApplicationContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  private static View getStatusBarView(Activity paramActivity)
  {
    paramActivity = (FrameLayout)paramActivity.getWindow().getDecorView();
    int i = 0;
    while (i < paramActivity.getChildCount())
    {
      if (paramActivity.getChildAt(i).getId() == 2131378730) {
        return paramActivity.getChildAt(i);
      }
      i += 1;
    }
    return null;
  }
  
  public static void hideStatusBarView(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.findViewById(2131378730) != null)) {
      paramActivity.findViewById(2131378730).setVisibility(8);
    }
  }
  
  public static void immerseBlack(Activity paramActivity)
  {
    if (!availableVersion()) {}
    for (;;)
    {
      return;
      if (VersionUtils.hasLolipop())
      {
        Window localWindow = paramActivity.getWindow();
        localWindow.clearFlags(67108864);
        localWindow.addFlags(-2147483648);
        localWindow.getDecorView().setSystemUiVisibility(0);
        localWindow.setStatusBarColor(BLACK_COLOR);
      }
      while (isTargetMiuiVersion())
      {
        setIconDarkModeForMIUI(false, paramActivity);
        return;
        if (VersionUtils.hasKitKat())
        {
          paramActivity.getWindow().addFlags(67108864);
          setStatusBarColorCompat(paramActivity, BLACK_COLOR);
          setRootView(paramActivity);
        }
      }
    }
  }
  
  public static void immerseWhite(Activity paramActivity)
  {
    if (!availableVersion()) {}
    do
    {
      do
      {
        return;
        Window localWindow = paramActivity.getWindow();
        if (VersionUtils.hasLolipop())
        {
          localWindow.clearFlags(67108864);
          localWindow.addFlags(-2147483648);
          if ((VersionUtils.hasMarshmallow()) && (!isTargetMiuiVersion()))
          {
            localWindow.getDecorView().setSystemUiVisibility(8192);
            localWindow.setStatusBarColor(WHITE_COLOR);
            return;
          }
          if (isTargetMiuiVersion())
          {
            setIconDarkModeForMIUI(true, paramActivity);
            localWindow.setStatusBarColor(WHITE_COLOR);
            return;
          }
          if (BrandUtil.isFlyme())
          {
            setIconDarkModeForFlyme(true, paramActivity.getWindow());
            localWindow.setStatusBarColor(WHITE_COLOR);
            return;
          }
          localWindow.setStatusBarColor(GRAY_COLOR);
          return;
        }
      } while (!VersionUtils.hasKitKat());
      paramActivity.getWindow().addFlags(67108864);
      if ((isTargetMiuiVersion()) || (BrandUtil.isFlyme())) {}
      for (int i = WHITE_COLOR;; i = GRAY_COLOR)
      {
        setStatusBarColorCompat(paramActivity, i);
        setRootView(paramActivity);
        if (!isTargetMiuiVersion()) {
          break;
        }
        setIconDarkModeForMIUI(true, paramActivity);
        return;
      }
    } while (!BrandUtil.isFlyme());
    setIconDarkModeForFlyme(true, paramActivity.getWindow());
  }
  
  private static boolean isTargetMiuiVersion()
  {
    return (BrandUtil.isMiuiV6()) || (BrandUtil.isMiuiV7()) || (BrandUtil.isMiuiV8());
  }
  
  public static boolean isZUKZ1()
  {
    String str = Build.MODEL;
    if (str == null) {
      return false;
    }
    return str.toLowerCase().contains("zuk z1");
  }
  
  @TargetApi(21)
  public static void layoutUnderStatusBar(Activity paramActivity, int paramInt)
  {
    int i;
    if (VersionUtils.hasLolipop())
    {
      i = paramInt;
      if (paramInt == WHITE_COLOR)
      {
        i = paramInt;
        if (!VersionUtils.hasMarshmallow()) {
          i = GRAY_COLOR;
        }
      }
      paramActivity = paramActivity.getWindow();
      if ((!VersionUtils.hasMarshmallow()) || (i != WHITE_COLOR)) {
        break label67;
      }
      paramActivity.addFlags(-2147483648);
      paramActivity.getDecorView().setSystemUiVisibility(9472);
    }
    for (;;)
    {
      paramActivity.setStatusBarColor(i);
      return;
      label67:
      paramActivity.getDecorView().setSystemUiVisibility(1280);
    }
  }
  
  private static boolean setIconDarkModeForFlyme(boolean paramBoolean, Window paramWindow)
  {
    if (paramWindow != null) {
      try
      {
        WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
        Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        localField1.setAccessible(true);
        localField2.setAccessible(true);
        int i = localField1.getInt(null);
        int j = localField2.getInt(localLayoutParams);
        if (paramBoolean) {
          i |= j;
        }
        for (;;)
        {
          localField2.setInt(localLayoutParams, i);
          paramWindow.setAttributes(localLayoutParams);
          return true;
          i = (i ^ 0xFFFFFFFF) & j;
        }
        return false;
      }
      catch (Exception paramWindow)
      {
        return false;
      }
    }
  }
  
  private static void setIconDarkModeForMIUI(boolean paramBoolean, Activity paramActivity)
  {
    int i = 0;
    Object localObject = paramActivity.getWindow().getClass();
    try
    {
      Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
      int j = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
      localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
      paramActivity = paramActivity.getWindow();
      if (paramBoolean) {
        i = j;
      }
      ((Method)localObject).invoke(paramActivity, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  private static void setRootView(Activity paramActivity)
  {
    paramActivity = (ViewGroup)paramActivity.findViewById(16908290);
    int j = paramActivity.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramActivity.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        localView.setFitsSystemWindows(true);
        ((ViewGroup)localView).setClipToPadding(true);
      }
      i += 1;
    }
  }
  
  private static void setStatusBarColorCompat(Activity paramActivity, int paramInt)
  {
    Object localObject = getStatusBarView(paramActivity);
    if (localObject == null)
    {
      Log.i("StatusBarUtil", "setStatusBarColorCompat " + getStatusBarHeight());
      localObject = (FrameLayout)paramActivity.getWindow().getDecorView();
      paramActivity = new View(paramActivity);
      paramActivity.setId(2131378730);
      paramActivity.setBackgroundColor(paramInt);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, getStatusBarHeight());
      localLayoutParams.gravity = 48;
      paramActivity.setLayoutParams(localLayoutParams);
      ((FrameLayout)localObject).addView(paramActivity);
      return;
    }
    ((View)localObject).setBackgroundColor(paramInt);
    Log.i("StatusBarUtil", "setStatusBarColorCompat tatusBarView EXITST");
  }
  
  public static void showStatusBarView(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.findViewById(2131378730) != null)) {
      paramActivity.findViewById(2131378730).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.StatusBarUtil
 * JD-Core Version:    0.7.0.1
 */