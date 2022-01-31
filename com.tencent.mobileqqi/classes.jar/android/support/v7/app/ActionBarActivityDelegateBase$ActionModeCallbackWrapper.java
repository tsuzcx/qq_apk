package android.support.v7.app;

import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

class ActionBarActivityDelegateBase$ActionModeCallbackWrapper
  implements ActionMode.Callback
{
  private ActionMode.Callback mWrapped;
  
  public ActionBarActivityDelegateBase$ActionModeCallbackWrapper(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase, ActionMode.Callback paramCallback)
  {
    this.mWrapped = paramCallback;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrapped.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mWrapped.onDestroyActionMode(paramActionMode);
    this.this$0.mActivity.onSupportActionModeFinished(paramActionMode);
    ActionBarActivityDelegateBase.access$102(this.this$0, null);
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.ActionModeCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */