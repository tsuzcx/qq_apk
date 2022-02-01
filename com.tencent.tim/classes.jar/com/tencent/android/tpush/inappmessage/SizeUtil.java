package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.android.tpush.logging.TLogger;

public class SizeUtil
{
  public static final int TEXT_SIZE_0 = 20;
  public static final int TEXT_SIZE_0_1 = 18;
  public static final int TEXT_SIZE_0_2 = 16;
  public static final int TEXT_SIZE_1 = 22;
  public static final int TEXT_SIZE_2 = 24;
  private static boolean a = false;
  public static int dp10;
  public static int dp100;
  public static int dp14;
  public static int dp16;
  public static int dp18;
  public static int dp180;
  public static int dp2;
  public static int dp20;
  public static int dp200;
  public static int dp250;
  public static int dp30;
  public static int dp48;
  public static int dp5;
  public static int dp50;
  public static int dp606;
  public static int dp7;
  public static int dp846;
  public static int dp96;
  
  public static int dipTopx(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, Float.valueOf(paramFloat).floatValue(), paramContext.getResources().getDisplayMetrics());
  }
  
  public static int dpToPx(Context paramContext, int paramInt)
  {
    init(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramInt;
    return Math.round(paramContext.xdpi / 160.0F * f);
  }
  
  public static Point getDisplaySize(Activity paramActivity)
  {
    Point localPoint = new Point();
    if (paramActivity == null) {
      return localPoint;
    }
    try
    {
      paramActivity.getWindowManager().getDefaultDisplay().getSize(localPoint);
      return localPoint;
    }
    catch (Throwable paramActivity)
    {
      TLogger.e("SizeUtil", "", paramActivity);
    }
    return localPoint;
  }
  
  public static int getStatusBarHeight(Activity paramActivity)
  {
    init(paramActivity);
    int i;
    if ((paramActivity.getWindow().getAttributes().flags & 0x400) == 1024)
    {
      i = 1;
      if (i == 0) {
        break label37;
      }
    }
    label37:
    do
    {
      return 0;
      i = 0;
      break;
      i = paramActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
    } while (i <= 0);
    return paramActivity.getResources().getDimensionPixelSize(i);
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    init(paramContext);
    int i = 0;
    try
    {
      int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
      if (j > 0) {
        i = paramContext.getResources().getDimensionPixelSize(j);
      }
      return i;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("SizeUtil", "", paramContext);
    }
    return 0;
  }
  
  public static void init(Context paramContext)
  {
    if (a) {
      return;
    }
    a = true;
    dp96 = dpToPx(paramContext, 96);
    dp48 = dpToPx(paramContext, 48);
    dp30 = dpToPx(paramContext, 30);
    dp5 = dpToPx(paramContext, 5);
    dp20 = dpToPx(paramContext, 20);
    dp10 = dpToPx(paramContext, 10);
    dp7 = dpToPx(paramContext, 7);
    dp18 = dpToPx(paramContext, 18);
    dp16 = dpToPx(paramContext, 16);
    dp14 = dpToPx(paramContext, 14);
    dp100 = dpToPx(paramContext, 100);
    dp200 = dpToPx(paramContext, 200);
    dp250 = dpToPx(paramContext, 250);
    dp2 = dpToPx(paramContext, 2);
    dp50 = dpToPx(paramContext, 50);
    dp180 = dpToPx(paramContext, 180);
    dp606 = dpToPx(paramContext, 606);
    dp846 = dpToPx(paramContext, 846);
  }
  
  public static int pxToDp(Context paramContext, int paramInt)
  {
    init(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    return Math.round(paramInt / (paramContext.xdpi / 160.0F));
  }
  
  public static int pxToSp(Context paramContext, int paramInt)
  {
    init(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    return (int)(paramInt / paramContext.scaledDensity);
  }
  
  public static int spToPx(Context paramContext, int paramInt)
  {
    init(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(paramContext.scaledDensity * f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.SizeUtil
 * JD-Core Version:    0.7.0.1
 */