package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;

public abstract interface ActionBarDrawerToggle$Delegate
{
  public abstract Context getActionBarThemedContext();
  
  public abstract Drawable getThemeUpIndicator();
  
  public abstract boolean isNavigationVisible();
  
  public abstract void setActionBarDescription(@StringRes int paramInt);
  
  public abstract void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle.Delegate
 * JD-Core Version:    0.7.0.1
 */