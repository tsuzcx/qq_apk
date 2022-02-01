package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.tencent.androidqqmail.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InCallWaveAnimLayout
  extends ObservableRelativeLayout
  implements WaveViewHolder.IWaveAnimatorListener
{
  private static final int MSG_ANIM_START = 0;
  private static final int MSG_ANIM_STOP = 1;
  private static final String TAG = "tagorewang:InCallWaveAnimLayout";
  private int mAnchorId;
  private long mAnimDuration = 1500L;
  private Handler mAnimHandler = new InCallWaveAnimLayout.1(this);
  private int mCurrentWaveCount = 0;
  private WaveViewHolder[] mToLeftHolders;
  private WaveViewHolder[] mToRightHolders;
  private int mWaveCount = 3;
  
  public InCallWaveAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InCallWaveAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.InCallWaveAnimLayout, paramInt, 0);
    this.mAnchorId = paramContext.getResourceId(R.styleable.InCallWaveAnimLayout_anchorId, 0);
    if (this.mAnchorId == 0) {
      throw new IllegalArgumentException("The mAnchorId attribute is required and must refer to a valid View.");
    }
    paramContext.recycle();
  }
  
  private void addView(WaveViewHolder paramWaveViewHolder)
  {
    paramWaveViewHolder.setWaveAnimatorListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    switch (paramWaveViewHolder.type)
    {
    }
    for (;;)
    {
      addView(paramWaveViewHolder.waveView, localLayoutParams);
      return;
      localLayoutParams.addRule(1, this.mAnchorId);
      continue;
      localLayoutParams.addRule(0, this.mAnchorId);
    }
  }
  
  private long getAnimInterval(int paramInt)
  {
    paramInt = this.mWaveCount - 1 - paramInt;
    if (paramInt < 0) {
      return 0L;
    }
    return paramInt * this.mAnimDuration / 2L;
  }
  
  private long getAnimOffset(int paramInt)
  {
    return paramInt * this.mAnimDuration / 2L;
  }
  
  private void startRingAnimInternal()
  {
    int j = 0;
    if ((this.mToLeftHolders == null) || (this.mToRightHolders == null)) {}
    for (;;)
    {
      return;
      int i = j;
      if (this.mToLeftHolders.length > 0)
      {
        if (!this.mToLeftHolders[0].isRunning()) {
          i = j;
        }
      }
      else {
        while (i != this.mWaveCount)
        {
          this.mToLeftHolders[i].startAnim();
          this.mToRightHolders[i].startAnim();
          i += 1;
        }
      }
    }
  }
  
  private void stopRingAnimInternal()
  {
    if ((this.mToLeftHolders == null) || (this.mToRightHolders == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i != this.mWaveCount)
      {
        this.mToLeftHolders[i].stopAnim();
        this.mToRightHolders[i].stopAnim();
        i += 1;
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.mCurrentWaveCount -= 1;
    if (this.mCurrentWaveCount <= 0) {
      this.mAnimHandler.sendEmptyMessage(0);
    }
  }
  
  protected void onFinishInflate()
  {
    int j = 0;
    super.onFinishInflate();
    Object localObject = new ArrayList();
    int k = getChildCount();
    int i = 0;
    while (i != k)
    {
      ((List)localObject).add(getChildAt(i));
      i += 1;
    }
    this.mToLeftHolders = new WaveViewHolder[this.mWaveCount];
    i = 0;
    while (i != this.mWaveCount)
    {
      this.mToLeftHolders[i] = new WaveViewHolder(getContext(), 0L, this.mAnimDuration, getAnimOffset(i), getAnimInterval(i));
      addView(this.mToLeftHolders[i]);
      i += 1;
    }
    this.mToRightHolders = new WaveViewHolder[this.mWaveCount];
    i = j;
    while (i != this.mWaveCount)
    {
      this.mToRightHolders[i] = new WaveViewHolder(getContext(), 180L, this.mAnimDuration, getAnimOffset(i), getAnimInterval(i));
      addView(this.mToRightHolders[i]);
      i += 1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).bringToFront();
    }
  }
  
  public void startRingAnim()
  {
    if (this.mAnimHandler.hasMessages(0)) {
      return;
    }
    this.mAnimHandler.sendEmptyMessage(0);
  }
  
  public void stopRingAnim()
  {
    this.mAnimHandler.removeMessages(0);
    this.mAnimHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.InCallWaveAnimLayout
 * JD-Core Version:    0.7.0.1
 */