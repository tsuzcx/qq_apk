package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class AnimatedVectorDrawableCompat$1
  implements Drawable.Callback
{
  AnimatedVectorDrawableCompat$1(AnimatedVectorDrawableCompat paramAnimatedVectorDrawableCompat) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.this$0.invalidateSelf();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.this$0.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.this$0.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.1
 * JD-Core Version:    0.7.0.1
 */