package com.tencent.mobileqq.portal;

import akzd;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class BreathEffectView
  extends ImageView
  implements Animation.AnimationListener
{
  ObjectAnimator bM;
  
  public BreathEffectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BreathEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void bno()
  {
    setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    localAlphaAnimation.setAnimationListener(this);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setDuration(1300L);
    localAlphaAnimation.setRepeatCount(-1);
    startAnimation(localAlphaAnimation);
  }
  
  public void dEf()
  {
    stop();
    setImageResource(2130846170);
    bno();
  }
  
  public void dEg()
  {
    stop();
    setImageResource(2130846171);
    bno();
  }
  
  public void dEh()
  {
    stop();
    setImageResource(2130847500);
    dEi();
  }
  
  public void dEi()
  {
    setVisibility(0);
    this.bM = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F, 0.5F, 1.0F, 0.0F });
    this.bM.setInterpolator(new AccelerateDecelerateInterpolator());
    this.bM.addUpdateListener(new akzd(this));
    this.bM.setDuration(4000L);
    this.bM.setRepeatCount(0);
    this.bM.start();
  }
  
  public void dEj()
  {
    if (this.bM != null)
    {
      this.bM.end();
      this.bM.cancel();
      this.bM = null;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    setVisibility(0);
  }
  
  public void stop()
  {
    Animation localAnimation = getAnimation();
    if (localAnimation != null)
    {
      localAnimation.setAnimationListener(null);
      setAnimation(null);
      clearAnimation();
    }
    setImageDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.BreathEffectView
 * JD-Core Version:    0.7.0.1
 */