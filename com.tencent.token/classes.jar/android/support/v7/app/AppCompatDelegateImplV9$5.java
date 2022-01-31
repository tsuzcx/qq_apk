package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.ActionBarContextView;
import android.widget.PopupWindow;

class AppCompatDelegateImplV9$5
  implements Runnable
{
  AppCompatDelegateImplV9$5(AppCompatDelegateImplV9 paramAppCompatDelegateImplV9) {}
  
  public void run()
  {
    this.this$0.mActionModePopup.showAtLocation(this.this$0.mActionModeView, 55, 0, 0);
    this.this$0.endOnGoingFadeAnimation();
    if (this.this$0.shouldAnimateActionModeView())
    {
      this.this$0.mActionModeView.setAlpha(0.0F);
      this.this$0.mFadeAnim = ViewCompat.animate(this.this$0.mActionModeView).alpha(1.0F);
      this.this$0.mFadeAnim.setListener(new AppCompatDelegateImplV9.5.1(this));
      return;
    }
    this.this$0.mActionModeView.setAlpha(1.0F);
    this.this$0.mActionModeView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.5
 * JD-Core Version:    0.7.0.1
 */