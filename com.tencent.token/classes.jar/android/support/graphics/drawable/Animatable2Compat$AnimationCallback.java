package android.support.graphics.drawable;

import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

public abstract class Animatable2Compat$AnimationCallback
{
  Animatable2.AnimationCallback mPlatformCallback;
  
  @RequiresApi(23)
  Animatable2.AnimationCallback getPlatformCallback()
  {
    if (this.mPlatformCallback == null) {
      this.mPlatformCallback = new Animatable2Compat.AnimationCallback.1(this);
    }
    return this.mPlatformCallback;
  }
  
  public void onAnimationEnd(Drawable paramDrawable) {}
  
  public void onAnimationStart(Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.Animatable2Compat.AnimationCallback
 * JD-Core Version:    0.7.0.1
 */