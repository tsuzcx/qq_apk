package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface WrappedDrawable
{
  public abstract Drawable getWrappedDrawable();
  
  public abstract void setWrappedDrawable(Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.drawable.WrappedDrawable
 * JD-Core Version:    0.7.0.1
 */