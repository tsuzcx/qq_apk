package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.WindowDecorActionBar.1
 * JD-Core Version:    0.7.0.1
 */