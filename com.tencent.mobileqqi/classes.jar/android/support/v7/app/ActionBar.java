package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.SpinnerAdapter;

public abstract class ActionBar
{
  public static final int DISPLAY_HOME_AS_UP = 4;
  public static final int DISPLAY_SHOW_CUSTOM = 16;
  public static final int DISPLAY_SHOW_HOME = 2;
  public static final int DISPLAY_SHOW_TITLE = 8;
  public static final int DISPLAY_USE_LOGO = 1;
  public static final int NAVIGATION_MODE_LIST = 1;
  public static final int NAVIGATION_MODE_STANDARD = 0;
  public static final int NAVIGATION_MODE_TABS = 2;
  
  public abstract void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener);
  
  public abstract void addTab(ActionBar.Tab paramTab);
  
  public abstract void addTab(ActionBar.Tab paramTab, int paramInt);
  
  public abstract void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean);
  
  public abstract void addTab(ActionBar.Tab paramTab, boolean paramBoolean);
  
  public abstract View getCustomView();
  
  public abstract int getDisplayOptions();
  
  public abstract int getHeight();
  
  public abstract int getNavigationItemCount();
  
  public abstract int getNavigationMode();
  
  public abstract int getSelectedNavigationIndex();
  
  public abstract ActionBar.Tab getSelectedTab();
  
  public abstract CharSequence getSubtitle();
  
  public abstract ActionBar.Tab getTabAt(int paramInt);
  
  public abstract int getTabCount();
  
  public Context getThemedContext()
  {
    return null;
  }
  
  public abstract CharSequence getTitle();
  
  public abstract void hide();
  
  public abstract boolean isShowing();
  
  public abstract ActionBar.Tab newTab();
  
  public abstract void removeAllTabs();
  
  public abstract void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener);
  
  public abstract void removeTab(ActionBar.Tab paramTab);
  
  public abstract void removeTabAt(int paramInt);
  
  public abstract void selectTab(ActionBar.Tab paramTab);
  
  public abstract void setBackgroundDrawable(Drawable paramDrawable);
  
  public abstract void setCustomView(int paramInt);
  
  public abstract void setCustomView(View paramView);
  
  public abstract void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams);
  
  public abstract void setDisplayHomeAsUpEnabled(boolean paramBoolean);
  
  public abstract void setDisplayOptions(int paramInt);
  
  public abstract void setDisplayOptions(int paramInt1, int paramInt2);
  
  public abstract void setDisplayShowCustomEnabled(boolean paramBoolean);
  
  public abstract void setDisplayShowHomeEnabled(boolean paramBoolean);
  
  public abstract void setDisplayShowTitleEnabled(boolean paramBoolean);
  
  public abstract void setDisplayUseLogoEnabled(boolean paramBoolean);
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public abstract void setIcon(int paramInt);
  
  public abstract void setIcon(Drawable paramDrawable);
  
  public abstract void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener);
  
  public abstract void setLogo(int paramInt);
  
  public abstract void setLogo(Drawable paramDrawable);
  
  public abstract void setNavigationMode(int paramInt);
  
  public abstract void setSelectedNavigationItem(int paramInt);
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable) {}
  
  public abstract void setSubtitle(int paramInt);
  
  public abstract void setSubtitle(CharSequence paramCharSequence);
  
  public abstract void setTitle(int paramInt);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public abstract void show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBar
 * JD-Core Version:    0.7.0.1
 */