package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.view.MenuItem;

class ActionMenuView$MenuBuilderCallback
  implements MenuBuilder.Callback
{
  ActionMenuView$MenuBuilderCallback(ActionMenuView paramActionMenuView) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (this.this$0.mOnMenuItemClickListener != null) && (this.this$0.mOnMenuItemClickListener.onMenuItemClick(paramMenuItem));
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if (this.this$0.mMenuBuilderCallback != null) {
      this.this$0.mMenuBuilderCallback.onMenuModeChange(paramMenuBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView.MenuBuilderCallback
 * JD-Core Version:    0.7.0.1
 */