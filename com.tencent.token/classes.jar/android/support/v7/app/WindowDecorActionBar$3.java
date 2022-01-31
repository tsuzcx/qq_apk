package android.support.v7.app;

import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.widget.ActionBarContainer;
import android.view.View;

class WindowDecorActionBar$3
  implements ViewPropertyAnimatorUpdateListener
{
  WindowDecorActionBar$3(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public void onAnimationUpdate(View paramView)
  {
    ((View)this.this$0.mContainerView.getParent()).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.WindowDecorActionBar.3
 * JD-Core Version:    0.7.0.1
 */