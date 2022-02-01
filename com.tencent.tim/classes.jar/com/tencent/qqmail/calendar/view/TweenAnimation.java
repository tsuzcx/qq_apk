package com.tencent.qqmail.calendar.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TweenAnimation
  extends Animation
{
  private TweenAnimationCallback mCallback;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.mCallback != null) {
      this.mCallback.callback(paramFloat);
    }
  }
  
  public void setTweenAnimationCallback(TweenAnimationCallback paramTweenAnimationCallback)
  {
    this.mCallback = paramTweenAnimationCallback;
  }
  
  public static abstract interface TweenAnimationCallback
  {
    public abstract void callback(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.TweenAnimation
 * JD-Core Version:    0.7.0.1
 */