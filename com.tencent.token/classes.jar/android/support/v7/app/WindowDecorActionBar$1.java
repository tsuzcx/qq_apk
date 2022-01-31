package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarContainer;
import android.view.View;

class WindowDecorActionBar$1
  extends ViewPropertyAnimatorListenerAdapter
{
  WindowDecorActionBar$1(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public void onAnimationEnd(View paramView)
  {
    if ((this.this$0.mContentAnimations) && (this.this$0.mContentView != null))
    {
      this.this$0.mContentView.setTranslationY(0.0F);
      this.this$0.mContainerView.setTranslationY(0.0F);
    }
    this.this$0.mContainerView.setVisibility(8);
    this.this$0.mContainerView.setTransitioning(false);
    this.this$0.mCurrentShowAnim = null;
    this.this$0.completeDeferredDestroyActionMode();
    if (this.this$0.mOverlayLayout != null) {
      ViewCompat.requestApplyInsets(this.this$0.mOverlayLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.WindowDecorActionBar.1
 * JD-Core Version:    0.7.0.1
 */