package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class MenuItemCompat$1
  implements MenuItem.OnActionExpandListener
{
  MenuItemCompat$1(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener) {}
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return this.val$listener.onMenuItemActionCollapse(paramMenuItem);
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return this.val$listener.onMenuItemActionExpand(paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat.1
 * JD-Core Version:    0.7.0.1
 */