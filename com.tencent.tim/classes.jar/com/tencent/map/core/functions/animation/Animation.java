package com.tencent.map.core.functions.animation;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;

public abstract class Animation
{
  private boolean a = false;
  protected InnerAnimationListener animationListener = null;
  protected SetAnimatePropertyListener animationProperty = null;
  private boolean b = false;
  private boolean c = false;
  private Interpolator d = new LinearInterpolator();
  protected long iDuration = 1500L;
  protected long ltimeStart = 0L;
  
  public void drawAnimation()
  {
    if (!this.a)
    {
      if ((!this.c) && (this.animationListener != null)) {
        this.animationListener.onAnimationFinish();
      }
      return;
    }
    float f = (float)(SystemClock.uptimeMillis() - this.ltimeStart) / (float)this.iDuration;
    if (f > 1.0F)
    {
      this.a = false;
      performAnimation(1.0F, this.d);
      if (this.animationListener != null) {
        this.animationListener.onAnimationFinish();
      }
      this.c = true;
      return;
    }
    performAnimation(f, this.d);
  }
  
  public Interpolator getInterpolator()
  {
    return this.d;
  }
  
  public boolean isEnded()
  {
    return this.c;
  }
  
  public boolean isRunning()
  {
    return this.a;
  }
  
  public boolean isStarted()
  {
    return this.b;
  }
  
  protected abstract void performAnimation(float paramFloat, Interpolator paramInterpolator);
  
  public void setAnimationListener(InnerAnimationListener paramInnerAnimationListener)
  {
    this.animationListener = paramInnerAnimationListener;
  }
  
  public void setAnimationProperty(SetAnimatePropertyListener paramSetAnimatePropertyListener)
  {
    this.animationProperty = paramSetAnimatePropertyListener;
  }
  
  public void setDuration(long paramLong)
  {
    this.iDuration = paramLong;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
  }
  
  public boolean startAnimation()
  {
    boolean bool = true;
    if (this.iDuration <= 0L) {
      bool = false;
    }
    do
    {
      return bool;
      this.b = true;
      this.ltimeStart = SystemClock.uptimeMillis();
      this.a = true;
    } while (this.animationListener == null);
    this.animationListener.onAnimationStart();
    return true;
  }
  
  public void stopAnimation()
  {
    this.a = false;
  }
  
  public static abstract interface InnerAnimationListener
  {
    public abstract void onAnimationFinish();
    
    public abstract void onAnimationStart();
  }
  
  public static abstract interface SetAnimatePropertyListener
  {
    public abstract void setAlpha(float paramFloat);
    
    public abstract void setPosition_(GeoPoint paramGeoPoint);
    
    public abstract void setRatio(float paramFloat);
    
    public abstract void setRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public abstract void setScale(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.Animation
 * JD-Core Version:    0.7.0.1
 */