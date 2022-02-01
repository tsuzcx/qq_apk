package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.WindowDecorActionBar.2
 * JD-Core Version:    0.7.0.1
 */