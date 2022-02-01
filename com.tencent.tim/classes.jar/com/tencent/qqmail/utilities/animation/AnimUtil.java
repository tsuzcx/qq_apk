package com.tencent.qqmail.utilities.animation;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.BaseInterpolator;
import android.view.animation.TranslateAnimation;

public class AnimUtil
{
  public static void animateViewAlphaToHide(View paramView, int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    if (paramAnimationListener != null) {
      localAlphaAnimation.setAnimationListener(paramAnimationListener);
    }
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void animateViewAlphaToShow(View paramView, int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    if (paramAnimationListener != null) {
      localAlphaAnimation.setAnimationListener(paramAnimationListener);
    }
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void animateViewTranslationY(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, BaseInterpolator paramBaseInterpolator, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat1, paramFloat2 });
    paramView.setDuration(paramInt1);
    paramView.setStartDelay(paramInt2);
    paramView.setInterpolator(paramBaseInterpolator);
    if (paramAnimatorListenerAdapter != null) {
      paramView.addListener(paramAnimatorListenerAdapter);
    }
    paramView.start();
  }
  
  public static void animateViewTranslationYWithoutFillAfter(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, BaseInterpolator paramBaseInterpolator, Animation.AnimationListener paramAnimationListener)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, paramFloat1, paramFloat2);
    localTranslateAnimation.setStartOffset(paramInt2);
    localTranslateAnimation.setDuration(paramInt1);
    localTranslateAnimation.setInterpolator(paramBaseInterpolator);
    localTranslateAnimation.setFillAfter(false);
    if (paramAnimationListener != null) {
      localTranslateAnimation.setAnimationListener(paramAnimationListener);
    }
    paramView.startAnimation(localTranslateAnimation);
  }
  
  public static Animation getOrientationReviseAnimation(Context paramContext, int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt != 0)
    {
      return AnimationUtils.loadAnimation(paramContext, paramInt);
      paramInt = 2130772398;
      continue;
      paramInt = 2130772396;
      continue;
      paramInt = 2130772397;
    }
    return null;
  }
  
  public static void playAlphaBackgroundColor(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AnimUtil.1 local1 = new AnimUtil.1(paramInt1 >> 24 & 0xFF, paramInt2 >> 24 & 0xFF, paramInt1 >> 16 & 0xFF, paramInt2 >> 16 & 0xFF, paramInt1 >> 8 & 0xFF, paramInt2 >> 8 & 0xFF, paramInt1 & 0xFF, paramInt2 & 0xFF, paramView);
    local1.setDuration(paramInt3);
    paramView.startAnimation(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.animation.AnimUtil
 * JD-Core Version:    0.7.0.1
 */