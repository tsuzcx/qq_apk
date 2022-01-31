package android.support.v7.internal.view.menu;

import android.graphics.drawable.Drawable;

public abstract interface MenuView$ItemView
{
  public abstract MenuItemImpl getItemData();
  
  public abstract void initialize(MenuItemImpl paramMenuItemImpl, int paramInt);
  
  public abstract boolean prefersCondensedTitle();
  
  public abstract void setCheckable(boolean paramBoolean);
  
  public abstract void setChecked(boolean paramBoolean);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setIcon(Drawable paramDrawable);
  
  public abstract void setShortcut(boolean paramBoolean, char paramChar);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public abstract boolean showsIcon();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuView.ItemView
 * JD-Core Version:    0.7.0.1
 */