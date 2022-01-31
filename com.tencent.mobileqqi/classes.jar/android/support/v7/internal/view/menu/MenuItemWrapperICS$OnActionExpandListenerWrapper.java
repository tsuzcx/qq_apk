package android.support.v7.internal.view.menu;

import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemWrapperICS$OnActionExpandListenerWrapper
  extends BaseWrapper
  implements MenuItem.OnActionExpandListener
{
  MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    super(paramOnActionExpandListener);
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return ((MenuItemCompat.OnActionExpandListener)this.mWrappedObject).onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return ((MenuItemCompat.OnActionExpandListener)this.mWrappedObject).onMenuItemActionExpand(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.OnActionExpandListenerWrapper
 * JD-Core Version:    0.7.0.1
 */