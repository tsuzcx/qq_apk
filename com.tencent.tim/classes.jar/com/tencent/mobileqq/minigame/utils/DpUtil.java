package com.tencent.mobileqq.minigame.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DpUtil
{
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.DpUtil
 * JD-Core Version:    0.7.0.1
 */