package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Window.Callback;

final class AppCompatDelegateImplV9$PanelMenuPresenterCallback
  implements MenuPresenter.Callback
{
  AppCompatDelegateImplV9$PanelMenuPresenterCallback(AppCompatDelegateImplV9 paramAppCompatDelegateImplV9) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuBuilder localMenuBuilder = paramMenuBuilder.getRootMenu();
    if (localMenuBuilder != paramMenuBuilder) {}
    for (int i = 1;; i = 0)
    {
      AppCompatDelegateImplV9 localAppCompatDelegateImplV9 = this.this$0;
      if (i != 0) {
        paramMenuBuilder = localMenuBuilder;
      }
      paramMenuBuilder = localAppCompatDelegateImplV9.findMenuPanel(paramMenuBuilder);
      if (paramMenuBuilder != null)
      {
        if (i == 0) {
          break;
        }
        this.this$0.callOnPanelClosed(paramMenuBuilder.featureId, paramMenuBuilder, localMenuBuilder);
        this.this$0.closePanel(paramMenuBuilder, true);
      }
      return;
    }
    this.this$0.closePanel(paramMenuBuilder, paramBoolean);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if ((paramMenuBuilder == null) && (this.this$0.mHasActionBar))
    {
      Window.Callback localCallback = this.this$0.getWindowCallback();
      if ((localCallback != null) && (!this.this$0.isDestroyed())) {
        localCallback.onMenuOpened(108, paramMenuBuilder);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.PanelMenuPresenterCallback
 * JD-Core Version:    0.7.0.1
 */