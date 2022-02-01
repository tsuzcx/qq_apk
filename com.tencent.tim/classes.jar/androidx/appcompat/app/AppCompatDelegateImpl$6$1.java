package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class AppCompatDelegateImpl$6$1
  extends ViewPropertyAnimatorListenerAdapter
{
  AppCompatDelegateImpl$6$1(AppCompatDelegateImpl.6 param6) {}
  
  public void onAnimationEnd(View paramView)
  {
    this.this$1.this$0.mActionModeView.setAlpha(1.0F);
    this.this$1.this$0.mFadeAnim.setListener(null);
    this.this$1.this$0.mFadeAnim = null;
  }
  
  public void onAnimationStart(View paramView)
  {
    this.this$1.this$0.mActionModeView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.6.1
 * JD-Core Version:    0.7.0.1
 */