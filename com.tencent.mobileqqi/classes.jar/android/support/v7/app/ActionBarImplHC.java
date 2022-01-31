package android.support.v7.app;

import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.NativeActionModeAwareLayout.OnActionModeForChildListener;
import android.view.ActionMode;
import android.view.ActionMode.Callback;

class ActionBarImplHC
  extends ActionBarImplBase
  implements NativeActionModeAwareLayout.OnActionModeForChildListener
{
  private ActionMode mCurActionMode;
  final NativeActionModeAwareLayout mNativeActionModeAwareLayout;
  
  public ActionBarImplHC(ActionBarActivity paramActionBarActivity, ActionBar.Callback paramCallback)
  {
    super(paramActionBarActivity, paramCallback);
    this.mNativeActionModeAwareLayout = ((NativeActionModeAwareLayout)paramActionBarActivity.findViewById(2131230925));
    if (this.mNativeActionModeAwareLayout != null) {
      this.mNativeActionModeAwareLayout.setActionModeForChildListener(this);
    }
  }
  
  public void hide()
  {
    super.hide();
    if (this.mCurActionMode != null) {
      this.mCurActionMode.finish();
    }
  }
  
  boolean isShowHideAnimationEnabled()
  {
    return (this.mCurActionMode == null) && (super.isShowHideAnimationEnabled());
  }
  
  public ActionMode.Callback onActionModeForChild(ActionMode.Callback paramCallback)
  {
    return new ActionBarImplHC.CallbackWrapper(this, paramCallback);
  }
  
  public void show()
  {
    super.show();
    if (this.mCurActionMode != null) {
      this.mCurActionMode.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarImplHC
 * JD-Core Version:    0.7.0.1
 */