package com.tencent.av.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class BitmapTools
{
  public static Drawable a(Context paramContext, int paramInt)
  {
    int i = UITools.a(paramContext);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (i >= 720) {
      return null;
    }
    if (i >= 480) {}
    for (localOptions.inSampleSize = 2;; localOptions.inSampleSize = 4) {
      try
      {
        paramContext = new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions));
        return paramContext;
      }
      catch (Exception paramContext) {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.utils.BitmapTools
 * JD-Core Version:    0.7.0.1
 */