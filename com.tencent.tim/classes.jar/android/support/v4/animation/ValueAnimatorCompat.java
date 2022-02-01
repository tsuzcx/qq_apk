package android.support.v4.animation;

import android.view.View;

public abstract interface ValueAnimatorCompat
{
  public abstract void addListener(AnimatorListenerCompat paramAnimatorListenerCompat);
  
  public abstract void addUpdateListener(AnimatorUpdateListenerCompat paramAnimatorUpdateListenerCompat);
  
  public abstract void cancel();
  
  public abstract float getAnimatedFraction();
  
  public abstract void setDuration(long paramLong);
  
  public abstract void setTarget(View paramView);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.animation.ValueAnimatorCompat
 * JD-Core Version:    0.7.0.1
 */