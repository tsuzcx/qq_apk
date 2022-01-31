package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MenuItemWrapperICS$OnMenuItemClickListenerWrapper
  extends BaseWrapper
  implements MenuItem.OnMenuItemClickListener
{
  MenuItemWrapperICS$OnMenuItemClickListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    super(paramOnMenuItemClickListener);
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnMenuItemClickListener)this.mWrappedObject).onMenuItemClick(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperICS.OnMenuItemClickListenerWrapper
 * JD-Core Version:    0.7.0.1
 */