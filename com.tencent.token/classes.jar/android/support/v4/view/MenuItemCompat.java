package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;

public final class MenuItemCompat
{
  static final MenuVersionImpl IMPL = new MenuItemCompatBaseImpl();
  @Deprecated
  public static final int SHOW_AS_ACTION_ALWAYS = 2;
  @Deprecated
  public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
  @Deprecated
  public static final int SHOW_AS_ACTION_IF_ROOM = 1;
  @Deprecated
  public static final int SHOW_AS_ACTION_NEVER = 0;
  @Deprecated
  public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
  private static final String TAG = "MenuItemCompat";
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      IMPL = new MenuItemCompatApi26Impl();
      return;
    }
  }
  
  @Deprecated
  public static boolean collapseActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.collapseActionView();
  }
  
  @Deprecated
  public static boolean expandActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.expandActionView();
  }
  
  public static ActionProvider getActionProvider(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getSupportActionProvider();
    }
    Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
    return null;
  }
  
  @Deprecated
  public static View getActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.getActionView();
  }
  
  public static int getAlphabeticModifiers(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getAlphabeticModifiers();
    }
    return IMPL.getAlphabeticModifiers(paramMenuItem);
  }
  
  public static CharSequence getContentDescription(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getContentDescription();
    }
    return IMPL.getContentDescription(paramMenuItem);
  }
  
  public static ColorStateList getIconTintList(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getIconTintList();
    }
    return IMPL.getIconTintList(paramMenuItem);
  }
  
  public static PorterDuff.Mode getIconTintMode(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getIconTintMode();
    }
    return IMPL.getIconTintMode(paramMenuItem);
  }
  
  public static int getNumericModifiers(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getNumericModifiers();
    }
    return IMPL.getNumericModifiers(paramMenuItem);
  }
  
  public static CharSequence getTooltipText(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getTooltipText();
    }
    return IMPL.getTooltipText(paramMenuItem);
  }
  
  @Deprecated
  public static boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    return paramMenuItem.isActionViewExpanded();
  }
  
  public static MenuItem setActionProvider(MenuItem paramMenuItem, ActionProvider paramActionProvider)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).setSupportActionProvider(paramActionProvider);
    }
    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    return paramMenuItem;
  }
  
  @Deprecated
  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    return paramMenuItem.setActionView(paramInt);
  }
  
  @Deprecated
  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    return paramMenuItem.setActionView(paramView);
  }
  
  public static void setAlphabeticShortcut(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setAlphabeticShortcut(paramChar, paramInt);
      return;
    }
    IMPL.setAlphabeticShortcut(paramMenuItem, paramChar, paramInt);
  }
  
  public static void setContentDescription(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setContentDescription(paramCharSequence);
      return;
    }
    IMPL.setContentDescription(paramMenuItem, paramCharSequence);
  }
  
  public static void setIconTintList(MenuItem paramMenuItem, ColorStateList paramColorStateList)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setIconTintList(paramColorStateList);
      return;
    }
    IMPL.setIconTintList(paramMenuItem, paramColorStateList);
  }
  
  public static void setIconTintMode(MenuItem paramMenuItem, PorterDuff.Mode paramMode)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setIconTintMode(paramMode);
      return;
    }
    IMPL.setIconTintMode(paramMenuItem, paramMode);
  }
  
  public static void setNumericShortcut(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setNumericShortcut(paramChar, paramInt);
      return;
    }
    IMPL.setNumericShortcut(paramMenuItem, paramChar, paramInt);
  }
  
  @Deprecated
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, OnActionExpandListener paramOnActionExpandListener)
  {
    paramMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener()
    {
      public boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
      {
        return this.val$listener.onMenuItemActionCollapse(paramAnonymousMenuItem);
      }
      
      public boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
      {
        return this.val$listener.onMenuItemActionExpand(paramAnonymousMenuItem);
      }
    });
  }
  
  public static void setShortcut(MenuItem paramMenuItem, char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
      return;
    }
    IMPL.setShortcut(paramMenuItem, paramChar1, paramChar2, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem.setShowAsAction(paramInt);
  }
  
  public static void setTooltipText(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setTooltipText(paramCharSequence);
      return;
    }
    IMPL.setTooltipText(paramMenuItem, paramCharSequence);
  }
  
  @RequiresApi(26)
  static class MenuItemCompatApi26Impl
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
  
  static class MenuItemCompatBaseImpl
    implements MenuItemCompat.MenuVersionImpl
  {
    public int getAlphabeticModifiers(MenuItem paramMenuItem)
    {
      return 0;
    }
    
    public CharSequence getContentDescription(MenuItem paramMenuItem)
    {
      return null;
    }
    
    public ColorStateList getIconTintList(MenuItem paramMenuItem)
    {
      return null;
    }
    
    public PorterDuff.Mode getIconTintMode(MenuItem paramMenuItem)
    {
      return null;
    }
    
    public int getNumericModifiers(MenuItem paramMenuItem)
    {
      return 0;
    }
    
    public CharSequence getTooltipText(MenuItem paramMenuItem)
    {
      return null;
    }
    
    public void setAlphabeticShortcut(MenuItem paramMenuItem, char paramChar, int paramInt) {}
    
    public void setContentDescription(MenuItem paramMenuItem, CharSequence paramCharSequence) {}
    
    public void setIconTintList(MenuItem paramMenuItem, ColorStateList paramColorStateList) {}
    
    public void setIconTintMode(MenuItem paramMenuItem, PorterDuff.Mode paramMode) {}
    
    public void setNumericShortcut(MenuItem paramMenuItem, char paramChar, int paramInt) {}
    
    public void setShortcut(MenuItem paramMenuItem, char paramChar1, char paramChar2, int paramInt1, int paramInt2) {}
    
    public void setTooltipText(MenuItem paramMenuItem, CharSequence paramCharSequence) {}
  }
  
  static abstract interface MenuVersionImpl
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
  
  @Deprecated
  public static abstract interface OnActionExpandListener
  {
    public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);
    
    public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat
 * JD-Core Version:    0.7.0.1
 */