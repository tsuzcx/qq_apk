package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;

public final class MenuItemCompat
{
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
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getAlphabeticModifiers();
    }
    return 0;
  }
  
  public static CharSequence getContentDescription(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getContentDescription();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getContentDescription();
    }
    return null;
  }
  
  public static ColorStateList getIconTintList(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getIconTintList();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getIconTintList();
    }
    return null;
  }
  
  public static PorterDuff.Mode getIconTintMode(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getIconTintMode();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getIconTintMode();
    }
    return null;
  }
  
  public static int getNumericModifiers(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getNumericModifiers();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getNumericModifiers();
    }
    return 0;
  }
  
  public static CharSequence getTooltipText(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getTooltipText();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getTooltipText();
    }
    return null;
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
    if ((paramMenuItem instanceof SupportMenuItem)) {
      ((SupportMenuItem)paramMenuItem).setAlphabeticShortcut(paramChar, paramInt);
    }
    while (Build.VERSION.SDK_INT < 26) {
      return;
    }
    paramMenuItem.setAlphabeticShortcut(paramChar, paramInt);
  }
  
  public static void setContentDescription(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      ((SupportMenuItem)paramMenuItem).setContentDescription(paramCharSequence);
    }
    while (Build.VERSION.SDK_INT < 26) {
      return;
    }
    paramMenuItem.setContentDescription(paramCharSequence);
  }
  
  public static void setIconTintList(MenuItem paramMenuItem, ColorStateList paramColorStateList)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      ((SupportMenuItem)paramMenuItem).setIconTintList(paramColorStateList);
    }
    while (Build.VERSION.SDK_INT < 26) {
      return;
    }
    paramMenuItem.setIconTintList(paramColorStateList);
  }
  
  public static void setIconTintMode(MenuItem paramMenuItem, PorterDuff.Mode paramMode)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      ((SupportMenuItem)paramMenuItem).setIconTintMode(paramMode);
    }
    while (Build.VERSION.SDK_INT < 26) {
      return;
    }
    paramMenuItem.setIconTintMode(paramMode);
  }
  
  public static void setNumericShortcut(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      ((SupportMenuItem)paramMenuItem).setNumericShortcut(paramChar, paramInt);
    }
    while (Build.VERSION.SDK_INT < 26) {
      return;
    }
    paramMenuItem.setNumericShortcut(paramChar, paramInt);
  }
  
  @Deprecated
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, OnActionExpandListener paramOnActionExpandListener)
  {
    return paramMenuItem.setOnActionExpandListener(new MenuItemCompat.1(paramOnActionExpandListener));
  }
  
  public static void setShortcut(MenuItem paramMenuItem, char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      ((SupportMenuItem)paramMenuItem).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    }
    while (Build.VERSION.SDK_INT < 26) {
      return;
    }
    paramMenuItem.setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem.setShowAsAction(paramInt);
  }
  
  public static void setTooltipText(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      ((SupportMenuItem)paramMenuItem).setTooltipText(paramCharSequence);
    }
    while (Build.VERSION.SDK_INT < 26) {
      return;
    }
    paramMenuItem.setTooltipText(paramCharSequence);
  }
  
  @Deprecated
  public static abstract interface OnActionExpandListener
  {
    public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);
    
    public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.view.MenuItemCompat
 * JD-Core Version:    0.7.0.1
 */