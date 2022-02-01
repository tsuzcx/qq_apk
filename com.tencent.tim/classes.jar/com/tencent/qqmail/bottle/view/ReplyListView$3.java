package com.tencent.qqmail.bottle.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ReplyListView$3
  implements Animation.AnimationListener
{
  ReplyListView$3(ReplyListView paramReplyListView, boolean paramBoolean, boolean[] paramArrayOfBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$bWaitForRefreshing) {
      if (ReplyListView.access$400(this.this$0) != 4)
      {
        ReplyListView.access$402(this.this$0, 4);
        if (ReplyListView.access$500(this.this$0) != null) {
          ReplyListView.access$500(this.this$0).onExpandComplete();
        }
        ReplyListView.access$300(this.this$0, -2);
        this.val$run[0] = false;
      }
    }
    while (ReplyListView.access$400(this.this$0) == 0) {
      return;
    }
    ReplyListView.access$402(this.this$0, 0);
    ReplyListView.access$600(this.this$0, false);
    ReplyListView.access$700(this.this$0).onFoldComplete();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.ReplyListView.3
 * JD-Core Version:    0.7.0.1
 */