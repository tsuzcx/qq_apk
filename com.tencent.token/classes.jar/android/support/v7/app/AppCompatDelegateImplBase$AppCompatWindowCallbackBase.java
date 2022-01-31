package android.support.v7.app;

import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class AppCompatDelegateImplBase$AppCompatWindowCallbackBase
  extends WindowCallbackWrapper
{
  AppCompatDelegateImplBase$AppCompatWindowCallbackBase(AppCompatDelegateImplBase paramAppCompatDelegateImplBase, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this.this$0.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (this.this$0.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
  }
  
  public void onContentChanged() {}
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if ((paramInt == 0) && (!(paramMenu instanceof MenuBuilder))) {
      return false;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    super.onMenuOpened(paramInt, paramMenu);
    this.this$0.onMenuOpened(paramInt, paramMenu);
    return true;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
    this.this$0.onPanelClosed(paramInt, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    MenuBuilder localMenuBuilder;
    boolean bool1;
    if ((paramMenu instanceof MenuBuilder))
    {
      localMenuBuilder = (MenuBuilder)paramMenu;
      if ((paramInt != 0) || (localMenuBuilder != null)) {
        break label34;
      }
      bool1 = false;
    }
    label34:
    boolean bool2;
    do
    {
      return bool1;
      localMenuBuilder = null;
      break;
      if (localMenuBuilder != null) {
        localMenuBuilder.setOverrideVisibleItems(true);
      }
      bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
      bool1 = bool2;
    } while (localMenuBuilder == null);
    localMenuBuilder.setOverrideVisibleItems(false);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplBase.AppCompatWindowCallbackBase
 * JD-Core Version:    0.7.0.1
 */