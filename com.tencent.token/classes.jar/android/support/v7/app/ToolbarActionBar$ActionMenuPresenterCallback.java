package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.DecorToolbar;
import android.view.Window.Callback;

final class ToolbarActionBar$ActionMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private boolean mClosingActionMenu;
  
  ToolbarActionBar$ActionMenuPresenterCallback(ToolbarActionBar paramToolbarActionBar) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this.mClosingActionMenu) {
      return;
    }
    this.mClosingActionMenu = true;
    this.this$0.mDecorToolbar.dismissPopupMenus();
    if (this.this$0.mWindowCallback != null) {
      this.this$0.mWindowCallback.onPanelClosed(108, paramMenuBuilder);
    }
    this.mClosingActionMenu = false;
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if (this.this$0.mWindowCallback != null)
    {
      this.this$0.mWindowCallback.onMenuOpened(108, paramMenuBuilder);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.ToolbarActionBar.ActionMenuPresenterCallback
 * JD-Core Version:    0.7.0.1
 */