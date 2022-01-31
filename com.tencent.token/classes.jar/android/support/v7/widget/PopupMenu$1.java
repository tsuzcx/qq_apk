package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.view.MenuItem;

class PopupMenu$1
  implements MenuBuilder.Callback
{
  PopupMenu$1(PopupMenu paramPopupMenu) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    if (this.this$0.mMenuItemClickListener != null) {
      return this.this$0.mMenuItemClickListener.onMenuItemClick(paramMenuItem);
    }
    return false;
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.PopupMenu.1
 * JD-Core Version:    0.7.0.1
 */