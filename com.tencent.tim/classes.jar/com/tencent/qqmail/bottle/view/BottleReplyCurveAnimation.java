package com.tencent.qqmail.bottle.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

public class BottleReplyCurveAnimation
{
  private static final String TAG = BottleReplyCurveAnimation.class.getSimpleName();
  
  public static void animateCurve(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Runnable paramRunnable)
  {
    Object localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    localObject = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(paramInt1 - i, paramInt3 - i, 0.0F, 0.0F);
    localTranslateAnimation1.setInterpolator(new AccelerateInterpolator());
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, paramInt2 - j, paramInt4 - j);
    localTranslateAnimation2.setInterpolator(new LinearInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
    localAlphaAnimation.setInterpolator(new AlphaInterpolator());
    ((AnimationSet)localObject).addAnimation(localTranslateAnimation1);
    ((AnimationSet)localObject).addAnimation(localTranslateAnimation2);
    ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
    ((AnimationSet)localObject).setAnimationListener(new BottleReplyCurveAnimation.1(paramRunnable));
    ((AnimationSet)localObject).setDuration(600);
    paramView.startAnimation((Animation)localObject);
  }
  
  static class AlphaInterpolator
    implements Interpolator
  {
    public AlphaInterpolator() {}
    
    public AlphaInterpolator(Context paramContext, AttributeSet paramAttributeSet) {}
    
    public float getInterpolation(float paramFloat)
    {
      if (paramFloat <= 0.4D) {
        return paramFloat;
      }
      return 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.BottleReplyCurveAnimation
 * JD-Core Version:    0.7.0.1
 */