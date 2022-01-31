package android.support.v7.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class MenuItemWrapperJB$ActionProviderWrapperJB
  extends MenuItemWrapperICS.ActionProviderWrapper
  implements android.view.ActionProvider.VisibilityListener
{
  android.support.v4.view.ActionProvider.VisibilityListener mListener;
  
  public MenuItemWrapperJB$ActionProviderWrapperJB(MenuItemWrapperJB paramMenuItemWrapperJB, Context paramContext, ActionProvider paramActionProvider)
  {
    super(paramMenuItemWrapperJB, paramContext, paramActionProvider);
  }
  
  public boolean isVisible()
  {
    return this.mInner.isVisible();
  }
  
  public void onActionProviderVisibilityChanged(boolean paramBoolean)
  {
    if (this.mListener != null) {
      this.mListener.onActionProviderVisibilityChanged(paramBoolean);
    }
  }
  
  public View onCreateActionView(MenuItem paramMenuItem)
  {
    return this.mInner.onCreateActionView(paramMenuItem);
  }
  
  public boolean overridesItemVisibility()
  {
    return this.mInner.overridesItemVisibility();
  }
  
  public void refreshVisibility()
  {
    this.mInner.refreshVisibility();
  }
  
  public void setVisibilityListener(android.support.v4.view.ActionProvider.VisibilityListener paramVisibilityListener)
  {
    this.mListener = paramVisibilityListener;
    ActionProvider localActionProvider = this.mInner;
    if (paramVisibilityListener != null) {}
    for (paramVisibilityListener = this;; paramVisibilityListener = null)
    {
      localActionProvider.setVisibilityListener(paramVisibilityListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperJB.ActionProviderWrapperJB
 * JD-Core Version:    0.7.0.1
 */