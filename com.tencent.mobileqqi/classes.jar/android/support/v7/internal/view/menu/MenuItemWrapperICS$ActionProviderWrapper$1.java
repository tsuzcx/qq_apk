package android.support.v7.internal.view.menu;

import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.VisibilityListener;

class MenuItemWrapperICS$ActionProviderWrapper$1
  implements ActionProvider.VisibilityListener
{
  MenuItemWrapperICS$ActionProviderWrapper$1(MenuItemWrapperICS.ActionProviderWrapper paramActionProviderWrapper, MenuItemWrapperICS paramMenuItemWrapperICS) {}
  
  public void onActionProviderVisibilityChanged(boolean paramBoolean)
  {
    if ((this.this$1.mInner.overridesItemVisibility()) && (MenuItemWrapperICS.access$100(this.this$1.this$0))) {
      this.this$1.this$0.wrappedSetVisible(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.ActionProviderWrapper.1
 * JD-Core Version:    0.7.0.1
 */