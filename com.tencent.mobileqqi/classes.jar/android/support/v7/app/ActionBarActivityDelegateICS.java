package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.internal.view.ActionModeWrapper;
import android.support.v7.internal.view.ActionModeWrapper.CallbackWrapper;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;

class ActionBarActivityDelegateICS
  extends ActionBarActivityDelegate
{
  Menu mMenu;
  
  ActionBarActivityDelegateICS(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mActivity.superAddContentView(paramView, paramLayoutParams);
  }
  
  public ActionBar createSupportActionBar()
  {
    return new ActionBarImplICS(this.mActivity, this.mActivity);
  }
  
  Window.Callback createWindowCallbackWrapper(Window.Callback paramCallback)
  {
    return new ActionBarActivityDelegateICS.WindowCallbackWrapper(this, paramCallback);
  }
  
  public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return null;
  }
  
  public void onActionModeFinished(android.view.ActionMode paramActionMode)
  {
    this.mActivity.onSupportActionModeFinished(new ActionModeWrapper(getActionBarThemedContext(), paramActionMode));
  }
  
  public void onActionModeStarted(android.view.ActionMode paramActionMode)
  {
    this.mActivity.onSupportActionModeStarted(new ActionModeWrapper(getActionBarThemedContext(), paramActionMode));
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onContentChanged()
  {
    this.mActivity.onSupportContentChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if ("splitActionBarWhenNarrow".equals(getUiOptionsFromMetadata())) {
      this.mActivity.getWindow().setUiOptions(1, 1);
    }
    super.onCreate(paramBundle);
    if (this.mHasActionBar) {
      this.mActivity.requestWindowFeature(8);
    }
    if (this.mOverlayActionBar) {
      this.mActivity.requestWindowFeature(9);
    }
    paramBundle = this.mActivity.getWindow();
    paramBundle.setCallback(createWindowCallbackWrapper(paramBundle.getCallback()));
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if ((paramInt == 0) || (paramInt == 8))
    {
      if (this.mMenu == null) {
        this.mMenu = MenuWrapperFactory.createMenuWrapper(paramMenu);
      }
      return this.mActivity.superOnCreatePanelMenu(paramInt, this.mMenu);
    }
    return this.mActivity.superOnCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return null;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    MenuItem localMenuItem = paramMenuItem;
    if (paramInt == 0) {
      localMenuItem = MenuWrapperFactory.createMenuItemWrapper(paramMenuItem);
    }
    return this.mActivity.superOnMenuItemSelected(paramInt, localMenuItem);
  }
  
  public void onPostResume() {}
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) || (paramInt == 8)) {
      return this.mActivity.superOnPreparePanel(paramInt, paramView, this.mMenu);
    }
    return this.mActivity.superOnPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onStop() {}
  
  public void onTitleChanged(CharSequence paramCharSequence) {}
  
  public void setContentView(int paramInt)
  {
    this.mActivity.superSetContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    this.mActivity.superSetContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mActivity.superSetContentView(paramView, paramLayoutParams);
  }
  
  void setSupportProgress(int paramInt)
  {
    this.mActivity.setProgress(paramInt);
  }
  
  void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
    this.mActivity.setProgressBarIndeterminate(paramBoolean);
  }
  
  void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    this.mActivity.setProgressBarIndeterminateVisibility(paramBoolean);
  }
  
  void setSupportProgressBarVisibility(boolean paramBoolean)
  {
    this.mActivity.setProgressBarVisibility(paramBoolean);
  }
  
  public android.support.v7.view.ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    Context localContext = getActionBarThemedContext();
    ActionModeWrapper.CallbackWrapper localCallbackWrapper = new ActionModeWrapper.CallbackWrapper(localContext, paramCallback);
    paramCallback = null;
    android.view.ActionMode localActionMode = this.mActivity.startActionMode(localCallbackWrapper);
    if (localActionMode != null)
    {
      paramCallback = new ActionModeWrapper(localContext, localActionMode);
      localCallbackWrapper.setLastStartedActionMode(paramCallback);
    }
    return paramCallback;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    this.mMenu = null;
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    return this.mActivity.requestWindowFeature(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateICS
 * JD-Core Version:    0.7.0.1
 */