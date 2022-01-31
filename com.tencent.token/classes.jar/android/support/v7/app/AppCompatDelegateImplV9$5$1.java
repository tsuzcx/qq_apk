package android.support.v7.app;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;

class AppCompatDelegateImplV9$5$1
  extends ViewPropertyAnimatorListenerAdapter
{
  AppCompatDelegateImplV9$5$1(AppCompatDelegateImplV9.5 param5) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.5.1
 * JD-Core Version:    0.7.0.1
 */