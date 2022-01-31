package android.support.v7.app;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

class ActionBarActivityDelegateICS$WindowCallbackWrapper
  implements Window.Callback
{
  final Window.Callback mWrapped;
  
  public ActionBarActivityDelegateICS$WindowCallbackWrapper(ActionBarActivityDelegateICS paramActionBarActivityDelegateICS, Window.Callback paramCallback)
  {
    this.mWrapped = paramCallback;
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.mWrapped.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.mWrapped.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.mWrapped.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.mWrapped.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mWrapped.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.mWrapped.dispatchTrackballEvent(paramMotionEvent);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    this.mWrapped.onActionModeFinished(paramActionMode);
    this.this$0.onActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    this.mWrapped.onActionModeStarted(paramActionMode);
    this.this$0.onActionModeStarted(paramActionMode);
  }
  
  public void onAttachedToWindow()
  {
    this.mWrapped.onAttachedToWindow();
  }
  
  public void onContentChanged()
  {
    this.mWrapped.onContentChanged();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.mWrapped.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return this.mWrapped.onCreatePanelView(paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    this.mWrapped.onDetachedFromWindow();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.mWrapped.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.mWrapped.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.mWrapped.onPanelClosed(paramInt, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.mWrapped.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public boolean onSearchRequested()
  {
    return this.mWrapped.onSearchRequested();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    this.mWrapped.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.mWrapped.onWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.mWrapped.onWindowStartingActionMode(paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateICS.WindowCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */