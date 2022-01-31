package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;
import android.widget.PopupWindow;

class AppCompatDelegateImplV9$ActionModeCallbackWrapperV9$1
  extends ViewPropertyAnimatorListenerAdapter
{
  AppCompatDelegateImplV9$ActionModeCallbackWrapperV9$1(AppCompatDelegateImplV9.ActionModeCallbackWrapperV9 paramActionModeCallbackWrapperV9) {}
  
  public void onAnimationEnd(View paramView)
  {
    this.this$1.this$0.mActionModeView.setVisibility(8);
    if (this.this$1.this$0.mActionModePopup != null) {
      this.this$1.this$0.mActionModePopup.dismiss();
    }
    for (;;)
    {
      this.this$1.this$0.mActionModeView.removeAllViews();
      this.this$1.this$0.mFadeAnim.setListener(null);
      this.this$1.this$0.mFadeAnim = null;
      return;
      if ((this.this$1.this$0.mActionModeView.getParent() instanceof View)) {
        ViewCompat.requestApplyInsets((View)this.this$1.this$0.mActionModeView.getParent());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.ActionModeCallbackWrapperV9.1
 * JD-Core Version:    0.7.0.1
 */