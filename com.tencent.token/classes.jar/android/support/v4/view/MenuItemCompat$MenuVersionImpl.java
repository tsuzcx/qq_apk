package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.MenuItem;

abstract interface MenuItemCompat$MenuVersionImpl
{
  public abstract int getAlphabeticModifiers(MenuItem paramMenuItem);
  
  public abstract CharSequence getContentDescription(MenuItem paramMenuItem);
  
  public abstract ColorStateList getIconTintList(MenuItem paramMenuItem);
  
  public abstract PorterDuff.Mode getIconTintMode(MenuItem paramMenuItem);
  
  public abstract int getNumericModifiers(MenuItem paramMenuItem);
  
  public abstract CharSequence getTooltipText(MenuItem paramMenuItem);
  
  public abstract void setAlphabeticShortcut(MenuItem paramMenuItem, char paramChar, int paramInt);
  
  public abstract void setContentDescription(MenuItem paramMenuItem, CharSequence paramCharSequence);
  
  public abstract void setIconTintList(MenuItem paramMenuItem, ColorStateList paramColorStateList);
  
  public abstract void setIconTintMode(MenuItem paramMenuItem, PorterDuff.Mode paramMode);
  
  public abstract void setNumericShortcut(MenuItem paramMenuItem, char paramChar, int paramInt);
  
  public abstract void setShortcut(MenuItem paramMenuItem, char paramChar1, char paramChar2, int paramInt1, int paramInt2);
  
  public abstract void setTooltipText(MenuItem paramMenuItem, CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat.MenuVersionImpl
 * JD-Core Version:    0.7.0.1
 */