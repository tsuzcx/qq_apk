package com.tencent.mobileqq.activity.aio.item;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

public abstract class DetectableAnimationDrawable
  extends AnimationDrawable
{
  Handler bT;
  
  public DetectableAnimationDrawable(AnimationDrawable paramAnimationDrawable)
  {
    int i = 0;
    while (i < paramAnimationDrawable.getNumberOfFrames())
    {
      addFrame(paramAnimationDrawable.getFrame(i), paramAnimationDrawable.getDuration(i));
      i += 1;
    }
    setOneShot(paramAnimationDrawable.isOneShot());
  }
  
  private int getTotalDuration()
  {
    int i = 0;
    int j = 0;
    while (i < getNumberOfFrames())
    {
      j += getDuration(i);
      i += 1;
    }
    return j;
  }
  
  public abstract void onAnimationFinish();
  
  public void start()
  {
    super.start();
    this.bT = new Handler();
    this.bT.postDelayed(new DetectableAnimationDrawable.1(this), getTotalDuration());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */