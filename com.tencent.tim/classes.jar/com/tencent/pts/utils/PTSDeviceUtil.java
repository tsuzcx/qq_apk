package com.tencent.pts.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class PTSDeviceUtil
{
  private static final String TAG = "PTSDeviceUtil";
  private static float density;
  private static int densityDpi;
  private static int screenHeightPx;
  private static int screenWidthPx;
  private static float textHeightOffsetPerLine = 0.0F;
  
  static
  {
    init();
  }
  
  public static float dp2px(float paramFloat)
  {
    return density * paramFloat + 0.5F;
  }
  
  public static float getRPXScaling()
  {
    return getScreenWidthDp() / 750.0F;
  }
  
  public static float getScreenHeightDp()
  {
    return px2dp(screenHeightPx);
  }
  
  public static float getScreenScale()
  {
    return densityDpi / 160.0F;
  }
  
  public static float getScreenWidthDp()
  {
    return px2dp(screenWidthPx);
  }
  
  public static float getTextHeightOffsetPerLine()
  {
    return textHeightOffsetPerLine;
  }
  
  private static void init()
  {
    DisplayMetrics localDisplayMetrics = Resources.getSystem().getDisplayMetrics();
    if (localDisplayMetrics != null)
    {
      density = localDisplayMetrics.density;
      densityDpi = localDisplayMetrics.densityDpi;
      screenWidthPx = localDisplayMetrics.widthPixels;
      screenHeightPx = localDisplayMetrics.heightPixels;
      if (PTSLog.isColorLevel()) {
        PTSLog.i("PTSDeviceUtil", "[init] density = " + density + ", densityDpi = " + densityDpi + ", screenWidthPx = " + screenWidthPx + ", screenHeightPx = " + screenHeightPx);
      }
    }
  }
  
  public static void init(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null)) {}
    do
    {
      return;
      paramContext = paramContext.getResources().getDisplayMetrics();
    } while (paramContext == null);
    density = paramContext.density;
    densityDpi = paramContext.densityDpi;
    screenWidthPx = paramContext.widthPixels;
    screenHeightPx = paramContext.heightPixels;
  }
  
  public static float px2dp(float paramFloat)
  {
    return paramFloat / density + 0.5F;
  }
  
  public static void setTextHeightOffsetPerLine(float paramFloat)
  {
    textHeightOffsetPerLine = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.utils.PTSDeviceUtil
 * JD-Core Version:    0.7.0.1
 */