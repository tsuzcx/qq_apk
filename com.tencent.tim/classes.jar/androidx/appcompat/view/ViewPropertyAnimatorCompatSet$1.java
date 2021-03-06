package androidx.appcompat.view;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;

class ViewPropertyAnimatorCompatSet$1
  extends ViewPropertyAnimatorListenerAdapter
{
  private int mProxyEndCount = 0;
  private boolean mProxyStarted = false;
  
  ViewPropertyAnimatorCompatSet$1(ViewPropertyAnimatorCompatSet paramViewPropertyAnimatorCompatSet) {}
  
  public void onAnimationEnd(View paramView)
  {
    int i = this.mProxyEndCount + 1;
    this.mProxyEndCount = i;
    if (i == this.this$0.mAnimators.size())
    {
      if (this.this$0.mListener != null) {
        this.this$0.mListener.onAnimationEnd(null);
      }
      onEnd();
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    if (this.mProxyStarted) {}
    do
    {
      return;
      this.mProxyStarted = true;
    } while (this.this$0.mListener == null);
    this.this$0.mListener.onAnimationStart(null);
  }
  
  void onEnd()
  {
    this.mProxyEndCount = 0;
    this.mProxyStarted = false;
    this.this$0.onAnimationsEnded();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1
 * JD-Core Version:    0.7.0.1
 */