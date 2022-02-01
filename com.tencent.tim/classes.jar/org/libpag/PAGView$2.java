package org.libpag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class PAGView$2
  extends AnimatorListenerAdapter
{
  PAGView$2(PAGView paramPAGView1, PAGView paramPAGView2) {}
  
  public void onAnimationCancel(Animator arg1)
  {
    super.onAnimationCancel(???);
    synchronized (this.val$pagView)
    {
      Iterator localIterator = PAGView.access$300(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(this.val$pagView);
      }
    }
  }
  
  public void onAnimationEnd(Animator arg1)
  {
    super.onAnimationEnd(???);
    synchronized (this.val$pagView)
    {
      Iterator localIterator = PAGView.access$300(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(this.val$pagView);
      }
    }
  }
  
  public void onAnimationRepeat(Animator arg1)
  {
    super.onAnimationRepeat(???);
    synchronized (this.val$pagView)
    {
      Iterator localIterator = PAGView.access$300(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(this.val$pagView);
      }
    }
  }
  
  public void onAnimationStart(Animator arg1)
  {
    super.onAnimationStart(???);
    synchronized (this.val$pagView)
    {
      Iterator localIterator = PAGView.access$300(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(this.val$pagView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.PAGView.2
 * JD-Core Version:    0.7.0.1
 */