package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

class AppCompatDelegateImplV9$ActionModeCallbackWrapperV9
  implements ActionMode.Callback
{
  private ActionMode.Callback mWrapped;
  
  public AppCompatDelegateImplV9$ActionModeCallbackWrapperV9(AppCompatDelegateImplV9 paramAppCompatDelegateImplV9, ActionMode.Callback paramCallback)
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
    if (this.this$0.mActionModePopup != null) {
      this.this$0.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
    }
    if (this.this$0.mActionModeView != null)
    {
      this.this$0.endOnGoingFadeAnimation();
      this.this$0.mFadeAnim = ViewCompat.animate(this.this$0.mActionModeView).alpha(0.0F);
      this.this$0.mFadeAnim.setListener(new AppCompatDelegateImplV9.ActionModeCallbackWrapperV9.1(this));
    }
    if (this.this$0.mAppCompatCallback != null) {
      this.this$0.mAppCompatCallback.onSupportActionModeFinished(this.this$0.mActionMode);
    }
    this.this$0.mActionMode = null;
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.ActionModeCallbackWrapperV9
 * JD-Core Version:    0.7.0.1
 */