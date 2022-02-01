package com.tencent.qqmail.view;

import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class WaveViewHolder
{
  private static final float ANIM_WEIGHT_START_IN = 0.0F;
  private static final float FROM_SCALE = 1.0F;
  private static final int FROM_X_DELTA = QMUIKit.dpToPx(-16);
  public static final float ORIENTATION_LEFT = 0.0F;
  public static final float ORIENTATION_RIGHT = 180.0F;
  private static final String TAG = "tagorewang:WaveViewHolder";
  private static final int TO_X_DELTA = QMUIKit.dpToPx(64);
  private static final float TO_X_SCALE = 2.0F;
  private static final float TO_Y_SCALE = 2.0F;
  public long animDuration;
  public long animInterval;
  public long animStartDelay;
  private AnimatorSet mAnimSet;
  private IWaveAnimatorListener mListener;
  public float rotation;
  public int type;
  public ImageView waveView;
  
  public WaveViewHolder(Context paramContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    init(new ImageView(paramContext), (float)paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  public WaveViewHolder(ImageView paramImageView, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    init(paramImageView, (float)paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  private void init(ImageView paramImageView, float paramFloat, long paramLong1, long paramLong2, long paramLong3)
  {
    this.type = ((int)paramFloat / 180 % 2);
    switch (this.type)
    {
    }
    for (;;)
    {
      this.waveView = paramImageView;
      this.animDuration = paramLong1;
      this.animStartDelay = paramLong2;
      reset();
      return;
      this.rotation = 0.0F;
      paramImageView.setImageResource(2130851918);
      continue;
      this.rotation = 180.0F;
      paramImageView.setImageResource(2130851919);
    }
  }
  
  private void reset()
  {
    this.waveView.setVisibility(8);
    ViewHelper.setAlpha(this.waveView, 0.0F);
    ViewHelper.setScaleX(this.waveView, 1.0F);
    ViewHelper.setScaleY(this.waveView, 1.0F);
    setTranslateX(FROM_X_DELTA);
  }
  
  private static void setAnim(Animator paramAnimator, Interpolator paramInterpolator, long paramLong)
  {
    paramAnimator.setInterpolator(paramInterpolator);
    paramAnimator.setDuration(paramLong);
  }
  
  public boolean isRunning()
  {
    return (this.mAnimSet != null) && (this.mAnimSet.isRunning());
  }
  
  public void setTranslateX(int paramInt)
  {
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.waveView.getLayoutParams();
      if (localLayoutParams == null) {
        return;
      }
      switch (this.type)
      {
      }
      for (;;)
      {
        this.waveView.requestLayout();
        return;
        localLayoutParams.leftMargin = paramInt;
        continue;
        localLayoutParams.rightMargin = paramInt;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setWaveAnimatorListener(IWaveAnimatorListener paramIWaveAnimatorListener)
  {
    this.mListener = paramIWaveAnimatorListener;
  }
  
  public void startAnim()
  {
    if (isRunning()) {
      return;
    }
    if (this.mAnimSet == null)
    {
      long l1 = ((float)this.animDuration * 0.0F);
      long l2 = this.animDuration - l1 - this.animInterval;
      this.mAnimSet = new AnimatorSet();
      this.mAnimSet.setDuration(this.animDuration);
      this.mAnimSet.setStartDelay(this.animStartDelay);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.waveView, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator1.setDuration(l1);
      localObjectAnimator1.addListener(new WaveViewHolder.1(this));
      LinearInterpolator localLinearInterpolator = new LinearInterpolator();
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.waveView, "alpha", new float[] { 1.0F, 0.0F });
      setAnim(localObjectAnimator2, new AccelerateDecelerateInterpolator(), l2);
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.waveView, "scaleX", new float[] { 1.0F, 2.0F });
      setAnim(localObjectAnimator3, localLinearInterpolator, l2);
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.waveView, "scaleY", new float[] { 1.0F, 2.0F });
      setAnim(localObjectAnimator4, localLinearInterpolator, l2);
      ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofInt(this, "translateX", new int[] { FROM_X_DELTA, TO_X_DELTA });
      setAnim(localObjectAnimator5, localLinearInterpolator, l2);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      setAnim(localAnimatorSet, localLinearInterpolator, l2);
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5 });
      this.mAnimSet.playSequentially(new Animator[] { localObjectAnimator1, localAnimatorSet });
      this.mAnimSet.addListener(new WaveViewHolder.2(this));
    }
    this.mAnimSet.start();
  }
  
  public void stopAnim()
  {
    if (isRunning()) {
      this.mAnimSet.end();
    }
  }
  
  public class AnimatorAdapter
    implements Animator.AnimatorListener
  {
    public AnimatorAdapter() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  public static abstract interface IWaveAnimatorListener
  {
    public abstract void onAnimationEnd(Animator paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.WaveViewHolder
 * JD-Core Version:    0.7.0.1
 */