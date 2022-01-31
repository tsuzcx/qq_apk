package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.RequiresApi;
import android.view.MenuItem;

@RequiresApi(26)
class MenuItemCompat$MenuItemCompatApi26Impl
  extends MenuItemCompat.MenuItemCompatBaseImpl
{
  public int getAlphabeticModifiers(MenuItem paramMenuItem)
  {
    return paramMenuItem.getAlphabeticModifiers();
  }
  
  public CharSequence getContentDescription(MenuItem paramMenuItem)
  {
    return paramMenuItem.getContentDescription();
  }
  
  public ColorStateList getIconTintList(MenuItem paramMenuItem)
  {
    return paramMenuItem.getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode(MenuItem paramMenuItem)
  {
    return paramMenuItem.getIconTintMode();
  }
  
  public int getNumericModifiers(MenuItem paramMenuItem)
  {
    return paramMenuItem.getNumericModifiers();
  }
  
  public CharSequence getTooltipText(MenuItem paramMenuItem)
  {
    return paramMenuItem.getTooltipText();
  }
  
  public void setAlphabeticShortcut(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    paramMenuItem.setAlphabeticShortcut(paramChar, paramInt);
  }
  
  public void setContentDescription(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    paramMenuItem.setContentDescription(paramCharSequence);
  }
  
  public void setIconTintList(MenuItem paramMenuItem, ColorStateList paramColorStateList)
  {
    paramMenuItem.setIconTintList(paramColorStateList);
  }
  
  public void setIconTintMode(MenuItem paramMenuItem, PorterDuff.Mode paramMode)
  {
    paramMenuItem.setIconTintMode(paramMode);
  }
  
  public void setNumericShortcut(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    paramMenuItem.setNumericShortcut(paramChar, paramInt);
  }
  
  public void setShortcut(MenuItem paramMenuItem, char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    paramMenuItem.setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
  }
  
  public void setTooltipText(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    paramMenuItem.setTooltipText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat.MenuItemCompatApi26Impl
 * JD-Core Version:    0.7.0.1
 */