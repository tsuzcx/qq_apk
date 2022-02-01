package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ViewSwitcher;

public class PttTipSwitchView
  extends ViewSwitcher
{
  private Context mContext;
  private AnimationSet o;
  private AnimationSet p;
  private AnimationSet q;
  private AnimationSet r;
  
  public PttTipSwitchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PttTipSwitchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  private AnimationSet a(float paramFloat1, float paramFloat2)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, paramFloat1, 2, paramFloat2);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    localAnimationSet.addAnimation(localTranslateAnimation);
    return localAnimationSet;
  }
  
  private void init()
  {
    this.o = a(1.0F, 0.0F);
    this.p = a(0.0F, -1.0F);
    this.q = a(-1.0F, 0.0F);
    this.r = a(0.0F, 1.0F);
    setInAnimation(this.o);
    setOutAnimation(this.p);
  }
  
  public void next()
  {
    if (getInAnimation() != this.o) {
      setInAnimation(this.o);
    }
    if (getOutAnimation() != this.p) {
      setOutAnimation(this.p);
    }
    showNext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PttTipSwitchView
 * JD-Core Version:    0.7.0.1
 */