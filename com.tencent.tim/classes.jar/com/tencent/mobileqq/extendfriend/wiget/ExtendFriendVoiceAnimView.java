package com.tencent.mobileqq.extendfriend.wiget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ExtendFriendVoiceAnimView
  extends FrameLayout
{
  private View Cq;
  private View Cr;
  private long XT = 800L;
  private AnimatorSet mAnimatorSet;
  
  public ExtendFriendVoiceAnimView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ExtendFriendVoiceAnimView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ExtendFriendVoiceAnimView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.Cq = new View(paramContext);
    this.Cr = new View(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.Cq, paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.Cr, paramContext);
    this.Cq.setAlpha(0.0F);
    this.Cr.setAlpha(0.0F);
  }
  
  public void setCircleParams(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(paramInt1);
    this.Cq.setBackgroundDrawable(localGradientDrawable);
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(paramInt1);
    this.Cr.setBackgroundDrawable(localGradientDrawable);
    if (paramInt2 > 0) {
      this.XT = paramInt2;
    }
  }
  
  public void startAnimation(long paramLong)
  {
    if ((this.mAnimatorSet != null) && (this.mAnimatorSet.isRunning())) {
      this.mAnimatorSet.cancel();
    }
    this.Cq.setAlpha(0.0F);
    this.Cr.setAlpha(0.0F);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject = ObjectAnimator.ofFloat(this.Cq, "alpha", new float[] { 0.4F, 0.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Cq, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Cq, "scaleY", new float[] { 0.0F, 1.0F });
    localAnimatorSet.setDuration(this.XT);
    localAnimatorSet.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
    localObject = localAnimatorSet.clone();
    ((AnimatorSet)localObject).setTarget(this.Cr);
    ((AnimatorSet)localObject).setStartDelay(this.XT / 2L);
    this.mAnimatorSet = new AnimatorSet();
    this.mAnimatorSet.playTogether(new Animator[] { localAnimatorSet, localObject });
    if (paramLong > 0L) {
      this.mAnimatorSet.setStartDelay(paramLong);
    }
    this.mAnimatorSet.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceAnimView
 * JD-Core Version:    0.7.0.1
 */