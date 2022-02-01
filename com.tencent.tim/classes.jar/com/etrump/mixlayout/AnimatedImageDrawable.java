package com.etrump.mixlayout;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

public class AnimatedImageDrawable
  extends AnimationDrawable
{
  private a a;
  private int mCurrentIndex;
  private View mView;
  
  public int av()
  {
    return getDuration(this.mCurrentIndex);
  }
  
  public Drawable getDrawable()
  {
    return getFrame(this.mCurrentIndex);
  }
  
  public void nextFrame()
  {
    this.mCurrentIndex = ((this.mCurrentIndex + 1) % getNumberOfFrames());
    if (this.a != null) {
      this.a.update(this.mView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void update(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.AnimatedImageDrawable
 * JD-Core Version:    0.7.0.1
 */