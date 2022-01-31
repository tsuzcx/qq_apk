package android.support.v7.app;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

class ActionBarImplHC$CallbackWrapper
  implements ActionMode.Callback
{
  private final ActionMode.Callback mWrappedCallback;
  
  ActionBarImplHC$CallbackWrapper(ActionBarImplHC paramActionBarImplHC, ActionMode.Callback paramCallback)
  {
    this.mWrappedCallback = paramCallback;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mWrappedCallback.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    boolean bool = this.mWrappedCallback.onCreateActionMode(paramActionMode, paramMenu);
    if (bool)
    {
      ActionBarImplHC.access$002(this.this$0, paramActionMode);
      this.this$0.showForActionMode();
    }
    return bool;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mWrappedCallback.onDestroyActionMode(paramActionMode);
    this.this$0.hideForActionMode();
    ActionBarImplHC.access$002(this.this$0, null);
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrappedCallback.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarImplHC.CallbackWrapper
 * JD-Core Version:    0.7.0.1
 */