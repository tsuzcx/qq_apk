package android.support.v7.app;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarContainer;
import android.view.View;

class WindowDecorActionBar$2
  extends ViewPropertyAnimatorListenerAdapter
{
  WindowDecorActionBar$2(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public void onAnimationEnd(View paramView)
  {
    this.this$0.mCurrentShowAnim = null;
    this.this$0.mContainerView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.WindowDecorActionBar.2
 * JD-Core Version:    0.7.0.1
 */