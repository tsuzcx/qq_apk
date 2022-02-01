package androidx.appcompat.app;

import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

class AppCompatDelegateImpl$6
  implements Runnable
{
  AppCompatDelegateImpl$6(AppCompatDelegateImpl paramAppCompatDelegateImpl) {}
  
  public void run()
  {
    this.this$0.mActionModePopup.showAtLocation(this.this$0.mActionModeView, 55, 0, 0);
    this.this$0.endOnGoingFadeAnimation();
    if (this.this$0.shouldAnimateActionModeView())
    {
      this.this$0.mActionModeView.setAlpha(0.0F);
      this.this$0.mFadeAnim = ViewCompat.animate(this.this$0.mActionModeView).alpha(1.0F);
      this.this$0.mFadeAnim.setListener(new AppCompatDelegateImpl.6.1(this));
      return;
    }
    this.this$0.mActionModeView.setAlpha(1.0F);
    this.this$0.mActionModeView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.6
 * JD-Core Version:    0.7.0.1
 */