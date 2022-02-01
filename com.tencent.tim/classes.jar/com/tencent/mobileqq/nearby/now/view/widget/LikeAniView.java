package com.tencent.mobileqq.nearby.now.view.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import java.util.Random;
import jll;

public class LikeAniView
  extends FrameLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private int dmb = 180;
  private int dmc = 180;
  private ImageView mIconView;
  private Interpolator n = new LinearInterpolator();
  private Interpolator p = new DecelerateInterpolator(1.5F);
  
  public LikeAniView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LikeAniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LikeAniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.dmb = ((int)jll.dp2px(getContext(), 90.0F));
    this.dmc = ((int)jll.dp2px(getContext(), 90.0F));
    this.mIconView = new ImageView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.dmb, this.dmc);
    addView(this.mIconView, localLayoutParams);
    this.mIconView.setImageResource(2130842168);
    this.mIconView.setVisibility(8);
  }
  
  public void iT(int paramInt1, int paramInt2)
  {
    int i = new Random().nextInt(40);
    this.mIconView.setX(paramInt1 - this.dmb / 2);
    this.mIconView.setY(paramInt2 - this.dmc / 2);
    this.mIconView.setRotation(i - 20);
    Object localObject1 = ValueAnimator.ofFloat(new float[] { 1.3F, 0.85F });
    ((ValueAnimator)localObject1).setDuration(300L);
    ((ValueAnimator)localObject1).addUpdateListener(this);
    Object localObject2 = ValueAnimator.ofFloat(new float[] { 0.85F, 1.0F });
    ((ValueAnimator)localObject2).setDuration(150L);
    ((ValueAnimator)localObject2).addUpdateListener(this);
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.95F });
    localValueAnimator1.setDuration(150L);
    localValueAnimator1.addUpdateListener(this);
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.95F, 1.0F });
    localValueAnimator2.setDuration(150L);
    localValueAnimator2.addUpdateListener(this);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localObject1, localObject2, localValueAnimator1, localValueAnimator2 });
    localAnimatorSet.addListener(this);
    localObject1 = ObjectAnimator.ofFloat(this.mIconView, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject1).setDuration(1500L);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether(new Animator[] { localAnimatorSet, localObject1 });
    ((AnimatorSet)localObject2).start();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.mIconView.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.mIconView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.mIconView.setVisibility(0);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.mIconView.setScaleX(paramValueAnimator.floatValue());
    this.mIconView.setScaleY(paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.LikeAniView
 * JD-Core Version:    0.7.0.1
 */