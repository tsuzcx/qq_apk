package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public abstract interface Animatable2Compat
  extends Animatable
{
  public abstract void clearAnimationCallbacks();
  
  public abstract void registerAnimationCallback(@NonNull AnimationCallback paramAnimationCallback);
  
  public abstract boolean unregisterAnimationCallback(@NonNull AnimationCallback paramAnimationCallback);
  
  public static abstract class AnimationCallback
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.Animatable2Compat
 * JD-Core Version:    0.7.0.1
 */