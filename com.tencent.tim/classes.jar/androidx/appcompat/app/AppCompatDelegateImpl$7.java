package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class AppCompatDelegateImpl$7
  extends ViewPropertyAnimatorListenerAdapter
{
  AppCompatDelegateImpl$7(AppCompatDelegateImpl paramAppCompatDelegateImpl) {}
  
  public void onAnimationEnd(View paramView)
  {
    this.this$0.mActionModeView.setAlpha(1.0F);
    this.this$0.mFadeAnim.setListener(null);
    this.this$0.mFadeAnim = null;
  }
  
  public void onAnimationStart(View paramView)
  {
    this.this$0.mActionModeView.setVisibility(0);
    this.this$0.mActionModeView.sendAccessibilityEvent(32);
    if ((this.this$0.mActionModeView.getParent() instanceof View)) {
      ViewCompat.requestApplyInsets((View)this.this$0.mActionModeView.getParent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.7
 * JD-Core Version:    0.7.0.1
 */