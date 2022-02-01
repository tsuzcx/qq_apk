package com.tencent.moai.nativepages.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Window;

public class UIUtil
{
  private static float density = -1.0F;
  private static int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
  private static int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
  
  public static int fromDPToPix(Context paramContext, int paramInt)
  {
    return Math.round(getDensity(paramContext) * paramInt);
  }
  
  public static int fromPixToDP(Context paramContext, int paramInt)
  {
    return Math.round(paramInt / getDensity(paramContext));
  }
  
  public static void fullScreen(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  private static float getDensity(Context paramContext)
  {
    if (density < 0.0F) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    return density;
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static int safeParseIntPxFromFloat(float paramFloat)
  {
    int j = (int)paramFloat;
    int i = j;
    if (paramFloat - j > 0.001D) {
      i = j + 1;
    }
    return i;
  }
  
  public static int screenHeight()
  {
    return screenHeight;
  }
  
  public static int screenWidth()
  {
    return screenWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.UIUtil
 * JD-Core Version:    0.7.0.1
 */