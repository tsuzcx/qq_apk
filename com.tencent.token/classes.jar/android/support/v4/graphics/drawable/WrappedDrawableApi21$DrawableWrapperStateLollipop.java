package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class WrappedDrawableApi21$DrawableWrapperStateLollipop
  extends WrappedDrawableApi14.DrawableWrapperState
{
  WrappedDrawableApi21$DrawableWrapperStateLollipop(@Nullable WrappedDrawableApi14.DrawableWrapperState paramDrawableWrapperState, @Nullable Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }
  
  @NonNull
  public Drawable newDrawable(@Nullable Resources paramResources)
  {
    return new WrappedDrawableApi21(this, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.drawable.WrappedDrawableApi21.DrawableWrapperStateLollipop
 * JD-Core Version:    0.7.0.1
 */