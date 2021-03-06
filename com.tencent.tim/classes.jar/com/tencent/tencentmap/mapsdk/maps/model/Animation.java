package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.core.functions.animation.GlAnimation.InnerAnimationListener;

public abstract class Animation
{
  public GlAnimation glAnimation = null;
  protected GlAnimation.InnerAnimationListener mAnimationListener;
  
  public void setAnimationListener(AnimationListener paramAnimationListener)
  {
    this.mAnimationListener = new a(paramAnimationListener);
    if (this.glAnimation != null) {
      this.glAnimation.setAnimationListener(this.mAnimationListener);
    }
  }
  
  public abstract void setDuration(long paramLong);
  
  public abstract void setInterpolator(Interpolator paramInterpolator);
  
  static final class a
    implements GlAnimation.InnerAnimationListener
  {
    private AnimationListener a;
    
    public a(AnimationListener paramAnimationListener)
    {
      this.a = paramAnimationListener;
    }
    
    public final void onAnimationFinish()
    {
      if (this.a != null) {
        this.a.onAnimationEnd();
      }
    }
    
    public final void onAnimationStart()
    {
      if (this.a != null) {
        this.a.onAnimationStart();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Animation
 * JD-Core Version:    0.7.0.1
 */