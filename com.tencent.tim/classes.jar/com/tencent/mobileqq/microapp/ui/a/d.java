package com.tencent.mobileqq.microapp.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public final class d
{
  static
  {
    float f = Resources.getSystem().getDisplayMetrics().density;
  }
  
  public static DisplayMetrics a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static int b(Context paramContext)
  {
    return a(paramContext).widthPixels;
  }
  
  public static int c(Context paramContext)
  {
    return a(paramContext).heightPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ui.a.d
 * JD-Core Version:    0.7.0.1
 */