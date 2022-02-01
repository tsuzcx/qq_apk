package com.tencent.qqmini.sdk.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

@MiniKeep
public class ViewUtils
{
  private static float DEVICE_DENSITY = 0.0F;
  private static float density = -1.0F;
  private static int densityDPI;
  public static int densityDpi;
  public static float mDensity;
  private static int pixelPerCM;
  private static float scaleDensity = -1.0F;
  private static int screenHeight;
  private static double screenSizeCM;
  private static int screenWidth;
  
  static
  {
    densityDPI = -1;
    screenWidth = -1;
    screenHeight = -1;
    screenSizeCM = 0.0D;
    pixelPerCM = 0;
    DisplayMetrics localDisplayMetrics = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics();
    mDensity = localDisplayMetrics.density;
    densityDpi = localDisplayMetrics.densityDpi;
  }
  
  public static int PxToDp(float paramFloat)
  {
    return Math.round(paramFloat / getDensity());
  }
  
  @TargetApi(11)
  public static void changeTransparency(View paramView, int paramInt)
  {
    if (paramView.getBackground() != null) {
      paramView.getBackground().setAlpha(paramInt);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        changeTransparency(paramView.getChildAt(i), paramInt);
        i += 1;
      }
    }
  }
  
  public static int dip2px(float paramFloat)
  {
    return (int)(mDensity * paramFloat + 0.5F);
  }
  
  public static int dpToPx(float paramFloat)
  {
    return Math.round(getDensity() * paramFloat);
  }
  
  public static String getBreakString(Paint paramPaint, String paramString, float paramFloat)
  {
    float f2 = 0.0F;
    int i = 0;
    if (paramPaint == null) {
      return paramString;
    }
    for (;;)
    {
      float[] arrayOfFloat;
      float f1;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        arrayOfFloat = new float[paramString.length()];
        paramPaint.getTextWidths(paramString, arrayOfFloat);
        f1 = 0.0F;
        if (i < arrayOfFloat.length)
        {
          f1 += arrayOfFloat[i];
          if (f1 <= paramFloat) {
            break label154;
          }
        }
        if (i == arrayOfFloat.length) {
          break;
        }
        f1 = paramPaint.measureText("...");
        if (i <= 0) {
          return "";
        }
        paramFloat = f2;
        j = i;
        if (i > 1) {
          break label163;
        }
        return paramString.substring(0, i);
      }
      catch (Throwable paramPaint)
      {
        QMLog.e("getBreakString", "getBreakString", paramPaint);
        return paramString;
      }
      paramPaint = paramString.substring(0, i) + "...";
      return paramPaint;
      int j = i;
      if (i <= 0)
      {
        continue;
        label154:
        i += 1;
      }
      else
      {
        label163:
        i = j - 1;
        paramFloat += arrayOfFloat[i];
        if (paramFloat < f1) {}
      }
    }
  }
  
  public static void getChildPos(View paramView1, View paramView2, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {}
    label156:
    for (;;)
    {
      return;
      int i = 0;
      int j = 0;
      int k;
      int m;
      if (paramView1.getParent() != null)
      {
        j = paramView1.getLeft() + j;
        k = paramView1.getTop() + i;
        if (paramView1.getParent() == paramView2)
        {
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = k;
          i = k;
          m = j;
          if (paramArrayOfInt.length >= 4)
          {
            paramArrayOfInt[2] = paramView1.getMeasuredWidth();
            paramArrayOfInt[3] = paramView1.getMeasuredHeight();
            m = j;
            i = k;
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (paramView2 != null) {
            break label156;
          }
          paramArrayOfInt[0] = m;
          paramArrayOfInt[1] = i;
          return;
          try
          {
            paramView1 = (View)paramView1.getParent();
            if (paramArrayOfInt.length >= 4)
            {
              paramArrayOfInt[2] = paramView1.getMeasuredWidth();
              paramArrayOfInt[3] = paramView1.getMeasuredHeight();
            }
            i = k;
          }
          catch (ClassCastException paramView1)
          {
            i = k;
            m = j;
          }
        }
        continue;
        m = j;
      }
    }
  }
  
  public static Point getChildPositionInParent(View paramView, ViewGroup paramViewGroup)
  {
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    paramView.getGlobalVisibleRect(localRect1);
    paramViewGroup.getGlobalVisibleRect(localRect2);
    return new Point(localRect1.left - localRect2.left, localRect1.top - localRect2.top);
  }
  
  public static float getDensity()
  {
    if (density < 0.0F) {
      density = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().density;
    }
    return density;
  }
  
  public static float getDensity(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.getResources() == null)) {
      return getDensity();
    }
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics.density;
  }
  
  public static float getDensityDpi()
  {
    if (densityDPI < 0) {
      densityDPI = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().densityDpi;
    }
    return densityDPI;
  }
  
  public static int getPixelPerCM()
  {
    if (pixelPerCM <= 0) {
      pixelPerCM = (int)(AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().xdpi / 2.54D);
    }
    return pixelPerCM;
  }
  
  public static float getScaleDensity()
  {
    if (scaleDensity < 0.0F) {
      scaleDensity = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().scaledDensity;
    }
    return scaleDensity;
  }
  
  public static int getScreenHeight()
  {
    if (screenHeight < 0) {
      if (AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation != 2) {
        break label57;
      }
    }
    label57:
    for (screenHeight = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().widthPixels;; screenHeight = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().heightPixels) {
      return screenHeight;
    }
  }
  
  private static int getScreenHeightByConfig(Configuration paramConfiguration)
  {
    int i = 0;
    if (paramConfiguration != null)
    {
      if (paramConfiguration.orientation == 2) {
        i = dpToPx(paramConfiguration.screenWidthDp);
      }
    }
    else {
      return i;
    }
    return dpToPx(paramConfiguration.screenHeightDp);
  }
  
  public static double getScreenSizeCM()
  {
    if (screenSizeCM <= 0.0D)
    {
      DisplayMetrics localDisplayMetrics = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics();
      double d = Math.pow(localDisplayMetrics.widthPixels, 2.0D);
      screenSizeCM = Math.sqrt(Math.pow(localDisplayMetrics.heightPixels, 2.0D) + d) / getPixelPerCM();
    }
    return screenSizeCM;
  }
  
  public static int getScreenWidth()
  {
    if (screenWidth < 0) {
      if (AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation != 2) {
        break label57;
      }
    }
    label57:
    for (screenWidth = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().heightPixels;; screenWidth = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().widthPixels) {
      return screenWidth;
    }
  }
  
  private static int getScreenWidthByConfig(Configuration paramConfiguration)
  {
    int i = 0;
    if (paramConfiguration != null)
    {
      if (paramConfiguration.orientation == 2) {
        i = dpToPx(paramConfiguration.screenHeightDp);
      }
    }
    else {
      return i;
    }
    return dpToPx(paramConfiguration.screenWidthDp);
  }
  
  public static float getSpValue(float paramFloat)
  {
    if (DEVICE_DENSITY == 0.0F) {
      DEVICE_DENSITY = densityDpi;
    }
    return DEVICE_DENSITY * paramFloat / 160.0F;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getResources();
    int j = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static int getTextWidth(Paint paramPaint, CharSequence paramCharSequence)
  {
    int j = 0;
    int i = 0;
    int k = j;
    if (paramCharSequence != null)
    {
      k = j;
      if (paramCharSequence.length() > 0)
      {
        int m = paramCharSequence.length();
        float[] arrayOfFloat = new float[m];
        paramPaint.getTextWidths(paramCharSequence.toString(), arrayOfFloat);
        j = 0;
        for (;;)
        {
          k = i;
          if (j >= m) {
            break;
          }
          k = (int)Math.ceil(arrayOfFloat[j]);
          j += 1;
          i = k + i;
        }
      }
    }
    return k;
  }
  
  public static boolean isChildOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    if ((paramView2 instanceof ViewGroup))
    {
      int j = ((ViewGroup)paramView2).getChildCount();
      int i = 0;
      while (i < j)
      {
        if (isChildOf(paramView1, ((ViewGroup)paramView2).getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static int pxTosp(float paramFloat)
  {
    return (int)(paramFloat / AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static void resetScreenSize()
  {
    screenWidth = -1;
    screenHeight = -1;
  }
  
  @TargetApi(11)
  public static void setAlpha(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
    while (paramView.getBackground() == null) {
      return;
    }
    paramView.getBackground().setAlpha((int)(255.0F * paramFloat));
  }
  
  public static void setEnableForAllChild(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      paramView.setEnabled(paramBoolean);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          setEnableForAllChild(paramView.getChildAt(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  @TargetApi(11)
  public static void setPivotX(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setPivotX(paramFloat);
  }
  
  @TargetApi(11)
  public static void setPivotY(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setPivotY(paramFloat);
  }
  
  @TargetApi(11)
  public static void setRotation(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setRotation(paramFloat);
  }
  
  @TargetApi(11)
  public static void setScaleX(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setScaleX(paramFloat);
  }
  
  @TargetApi(11)
  public static void setScaleY(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setScaleY(paramFloat);
  }
  
  public static void setScreenSizeByConfig(Configuration paramConfiguration)
  {
    screenWidth = getScreenWidthByConfig(paramConfiguration);
    screenHeight = getScreenHeightByConfig(paramConfiguration);
  }
  
  @TargetApi(11)
  public static void setTranslationX(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setTranslationX(paramFloat);
  }
  
  @TargetApi(11)
  public static void setTranslationY(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setTranslationY(paramFloat);
  }
  
  @TargetApi(16)
  public static void setViewBackground(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
  
  public static boolean setViewVisibility(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView.setVisibility(paramInt);
      return true;
    }
    return false;
  }
  
  public static void setVisible(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
  }
  
  public static int spToPx(float paramFloat)
  {
    return (int)(AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ViewUtils
 * JD-Core Version:    0.7.0.1
 */