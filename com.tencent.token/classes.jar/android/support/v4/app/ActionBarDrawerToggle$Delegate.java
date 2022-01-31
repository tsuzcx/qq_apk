package android.support.v4.app;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

@Deprecated
public abstract interface ActionBarDrawerToggle$Delegate
{
  @Nullable
  public abstract Drawable getThemeUpIndicator();
  
  public abstract void setActionBarDescription(@StringRes int paramInt);
  
  public abstract void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle.Delegate
 * JD-Core Version:    0.7.0.1
 */