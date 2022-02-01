package com.tencent.qqmail.utilities.ui;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import java.util.List;

class InsertionListView$1$2
  extends AnimatorListenerAdapter
{
  InsertionListView$1$2(InsertionListView.1 param1) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    InsertionListView.access$300(this.this$1.this$0).clear();
    InsertionListView.access$402(this.this$1.this$0, false);
    if (InsertionListView.access$500(this.this$1.this$0) != null) {
      InsertionListView.access$500(this.this$1.this$0).onRowAdditionAnimationEnd();
    }
    this.this$1.val$adapter.onRowAdditionAnimationEnd();
    this.this$1.this$0.setEnabled(true);
    this.this$1.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.InsertionListView.1.2
 * JD-Core Version:    0.7.0.1
 */