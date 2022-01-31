package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@RequiresApi(19)
class WrappedDrawableApi19
  extends WrappedDrawableApi14
{
  WrappedDrawableApi19(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  WrappedDrawableApi19(WrappedDrawableApi14.DrawableWrapperState paramDrawableWrapperState, Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }
  
  public boolean isAutoMirrored()
  {
    return this.mDrawable.isAutoMirrored();
  }
  
  @NonNull
  WrappedDrawableApi14.DrawableWrapperState mutateConstantState()
  {
    return new WrappedDrawableApi19.DrawableWrapperStateKitKat(this.mState, null);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    this.mDrawable.setAutoMirrored(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.drawable.WrappedDrawableApi19
 * JD-Core Version:    0.7.0.1
 */