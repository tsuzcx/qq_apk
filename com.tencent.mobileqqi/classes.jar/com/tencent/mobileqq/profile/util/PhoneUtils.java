package com.tencent.mobileqq.profile.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class PhoneUtils
{
  public static int a(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.util.PhoneUtils
 * JD-Core Version:    0.7.0.1
 */