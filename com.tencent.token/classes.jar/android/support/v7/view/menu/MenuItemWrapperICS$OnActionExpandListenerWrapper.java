package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemWrapperICS$OnActionExpandListenerWrapper
  extends BaseWrapper
  implements MenuItem.OnActionExpandListener
{
  MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    super(paramOnActionExpandListener);
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)this.mWrappedObject).onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)this.mWrappedObject).onMenuItemActionExpand(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperICS.OnActionExpandListenerWrapper
 * JD-Core Version:    0.7.0.1
 */