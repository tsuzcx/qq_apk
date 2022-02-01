package com.tencent.viola.ui.view.list;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class DefaultRecycleItemAnimator
  extends DefaultItemAnimator
{
  public static final String TAG = "DefaultRecycleItemAnimator";
  private DefaultAnimatorListener mDefaultAnimatorListener;
  private Handler mHandler = new Handler();
  private boolean mIsDoingCheck = false;
  private Runnable mRunnable = new DefaultRecycleItemAnimator.1(this);
  
  public static void startSpecialRemoveAnimation(View paramView, onSpecialRemoveAnimationListener paramonSpecialRemoveAnimationListener)
  {
    if (paramonSpecialRemoveAnimationListener != null) {
      paramonSpecialRemoveAnimationListener.onAnimStart();
    }
    int i = paramView.getMeasuredHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(120L);
    localValueAnimator.addUpdateListener(new DefaultRecycleItemAnimator.2(paramView));
    localValueAnimator.addListener(new DefaultRecycleItemAnimator.3(i, paramView, paramonSpecialRemoveAnimationListener));
    localValueAnimator.start();
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mIsDoingCheck)
    {
      this.mIsDoingCheck = true;
      this.mHandler.post(this.mRunnable);
    }
    return super.animateMove(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void destroy()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
  }
  
  public void setDefaultAnimatorListener(DefaultAnimatorListener paramDefaultAnimatorListener)
  {
    this.mDefaultAnimatorListener = paramDefaultAnimatorListener;
  }
  
  public static abstract interface DefaultAnimatorListener
  {
    public abstract void onAnimFinish();
  }
  
  public static abstract interface onSpecialRemoveAnimationListener
  {
    public abstract void onAnimFinash();
    
    public abstract void onAnimStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator
 * JD-Core Version:    0.7.0.1
 */