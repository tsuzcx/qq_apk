package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;

public class BackwardSupportUtil$AnimationHelper
{
  public static void cancelAnimation(View paramView, Animation paramAnimation)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      new AnimationHelperImpl22().cancelAnimation(paramView, paramAnimation);
      return;
    }
    new AnimationHelperImpl21below().cancelAnimation(paramView, paramAnimation);
  }
  
  public static void overridePendingTransition(Activity paramActivity, int paramInt1, int paramInt2)
  {
    paramActivity.overridePendingTransition(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper
 * JD-Core Version:    0.7.0.1
 */