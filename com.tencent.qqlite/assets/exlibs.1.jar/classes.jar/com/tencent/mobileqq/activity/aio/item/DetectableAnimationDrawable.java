package com.tencent.mobileqq.activity.aio.item;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import bun;

public abstract class DetectableAnimationDrawable
  extends AnimationDrawable
{
  Handler a;
  
  public DetectableAnimationDrawable(AnimationDrawable paramAnimationDrawable)
  {
    int i = 0;
    while (i < paramAnimationDrawable.getNumberOfFrames())
    {
      addFrame(paramAnimationDrawable.getFrame(i), paramAnimationDrawable.getDuration(i));
      i += 1;
    }
  }
  
  private int a()
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
  
  public abstract void a();
  
  public void start()
  {
    super.start();
    this.a = new Handler();
    this.a.postDelayed(new bun(this), a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */