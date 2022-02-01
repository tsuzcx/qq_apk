package com.tencent.qqmail.utilities.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qqmail.view.QMRefreshingView;

class PtrListView$3
  extends AnimatorListenerAdapter
{
  PtrListView$3(PtrListView paramPtrListView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.val$bWaitForRefreshing) {
      if (PtrListView.access$000(this.this$0) != 5)
      {
        PtrListView.access$002(this.this$0, 5);
        PtrListView.access$100(this.this$0).rotate(true);
        PtrListView.access$400(this.this$0).onRefresh();
      }
    }
    do
    {
      do
      {
        return;
      } while (PtrListView.access$000(this.this$0) == 0);
      PtrListView.access$002(this.this$0, 0);
    } while (PtrListView.access$500(this.this$0) == null);
    PtrListView.access$500(this.this$0).onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.PtrListView.3
 * JD-Core Version:    0.7.0.1
 */