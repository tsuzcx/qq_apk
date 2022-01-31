package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.DecorToolbar;
import android.view.MenuItem;
import android.view.Window.Callback;

final class ToolbarActionBar$MenuBuilderCallback
  implements MenuBuilder.Callback
{
  ToolbarActionBar$MenuBuilderCallback(ToolbarActionBar paramToolbarActionBar) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if (this.this$0.mWindowCallback != null)
    {
      if (!this.this$0.mDecorToolbar.isOverflowMenuShowing()) {
        break label41;
      }
      this.this$0.mWindowCallback.onPanelClosed(108, paramMenuBuilder);
    }
    label41:
    while (!this.this$0.mWindowCallback.onPreparePanel(0, null, paramMenuBuilder)) {
      return;
    }
    this.this$0.mWindowCallback.onMenuOpened(108, paramMenuBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.ToolbarActionBar.MenuBuilderCallback
 * JD-Core Version:    0.7.0.1
 */