package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Window.Callback;

final class AppCompatDelegateImplV9$ActionMenuPresenterCallback
  implements MenuPresenter.Callback
{
  AppCompatDelegateImplV9$ActionMenuPresenterCallback(AppCompatDelegateImplV9 paramAppCompatDelegateImplV9) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    this.this$0.checkCloseActionMenu(paramMenuBuilder);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    Window.Callback localCallback = this.this$0.getWindowCallback();
    if (localCallback != null) {
      localCallback.onMenuOpened(108, paramMenuBuilder);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.ActionMenuPresenterCallback
 * JD-Core Version:    0.7.0.1
 */