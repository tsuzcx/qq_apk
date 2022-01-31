package android.support.v7.internal.view.menu;

import android.view.SubMenu;
import android.view.View;

class MenuItemWrapperICS$ActionProviderWrapper
  extends android.view.ActionProvider
{
  final android.support.v4.view.ActionProvider mInner;
  
  public MenuItemWrapperICS$ActionProviderWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, android.support.v4.view.ActionProvider paramActionProvider)
  {
    super(paramActionProvider.getContext());
    this.mInner = paramActionProvider;
    if (MenuItemWrapperICS.access$000(paramMenuItemWrapperICS)) {
      this.mInner.setVisibilityListener(new MenuItemWrapperICS.ActionProviderWrapper.1(this, paramMenuItemWrapperICS));
    }
  }
  
  public boolean hasSubMenu()
  {
    return this.mInner.hasSubMenu();
  }
  
  public View onCreateActionView()
  {
    if (MenuItemWrapperICS.access$000(this.this$0)) {
      this.this$0.checkActionProviderOverrideVisibility();
    }
    return this.mInner.onCreateActionView();
  }
  
  public boolean onPerformDefaultAction()
  {
    return this.mInner.onPerformDefaultAction();
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu)
  {
    this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(paramSubMenu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.ActionProviderWrapper
 * JD-Core Version:    0.7.0.1
 */