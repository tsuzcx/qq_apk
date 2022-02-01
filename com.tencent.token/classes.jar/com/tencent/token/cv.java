package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

public class cv
{
  private static final Object a = new Object();
  private static TypedValue b;
  
  public static int a(Context paramContext, String paramString)
  {
    if (paramString != null) {
      return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
    }
    throw new IllegalArgumentException("permission is null");
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getDrawable(paramInt);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return paramContext.getResources().getDrawable(paramInt);
    }
    synchronized (a)
    {
      if (b == null) {
        b = new TypedValue();
      }
      paramContext.getResources().getValue(paramInt, b, true);
      paramInt = b.resourceId;
      return paramContext.getResources().getDrawable(paramInt);
    }
  }
  
  public static boolean a(Context paramContext, Intent[] paramArrayOfIntent)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.startActivities(paramArrayOfIntent, null);
    } else {
      paramContext.startActivities(paramArrayOfIntent);
    }
    return true;
  }
  
  public static File[] a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalFilesDirs(null);
    }
    return new File[] { paramContext.getExternalFilesDir(null) };
  }
  
  public static ColorStateList b(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static File[] b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalCacheDirs();
    }
    return new File[] { paramContext.getExternalCacheDir() };
  }
  
  public static int c(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cv
 * JD-Core Version:    0.7.0.1
 */