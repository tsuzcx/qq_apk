package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuItem;

public class ActionModeWrapper$CallbackWrapper
  implements android.view.ActionMode.Callback
{
  final Context mContext;
  private ActionModeWrapper mLastStartedActionMode;
  final android.support.v7.view.ActionMode.Callback mWrappedCallback;
  
  public ActionModeWrapper$CallbackWrapper(Context paramContext, android.support.v7.view.ActionMode.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.mWrappedCallback = paramCallback;
  }
  
  private android.support.v7.view.ActionMode getActionModeWrapper(android.view.ActionMode paramActionMode)
  {
    if ((this.mLastStartedActionMode != null) && (this.mLastStartedActionMode.mWrappedObject == paramActionMode)) {
      return this.mLastStartedActionMode;
    }
    return new ActionModeWrapper(this.mContext, paramActionMode);
  }
  
  public boolean onActionItemClicked(android.view.ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(paramActionMode), MenuWrapperFactory.createMenuItemWrapper(paramMenuItem));
  }
  
  public boolean onCreateActionMode(android.view.ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(paramActionMode), MenuWrapperFactory.createMenuWrapper(paramMenu));
  }
  
  public void onDestroyActionMode(android.view.ActionMode paramActionMode)
  {
    this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(paramActionMode));
  }
  
  public boolean onPrepareActionMode(android.view.ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(paramActionMode), MenuWrapperFactory.createMenuWrapper(paramMenu));
  }
  
  public void setLastStartedActionMode(ActionModeWrapper paramActionModeWrapper)
  {
    this.mLastStartedActionMode = paramActionModeWrapper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.ActionModeWrapper.CallbackWrapper
 * JD-Core Version:    0.7.0.1
 */