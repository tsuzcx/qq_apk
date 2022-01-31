package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;

class ForwardingListener$DisallowIntercept
  implements Runnable
{
  ForwardingListener$DisallowIntercept(ForwardingListener paramForwardingListener) {}
  
  public void run()
  {
    ViewParent localViewParent = this.this$0.mSrc.getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ForwardingListener.DisallowIntercept
 * JD-Core Version:    0.7.0.1
 */