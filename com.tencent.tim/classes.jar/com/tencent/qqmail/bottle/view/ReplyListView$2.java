package com.tencent.qqmail.bottle.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ReplyListView$2
  extends Animation
{
  ReplyListView$2(ReplyListView paramReplyListView, boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.val$run[0] != 0) {
      ReplyListView.access$300(this.this$0, (int)((this.val$destination - this.val$originHeight) * paramFloat) + this.val$originHeight);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.ReplyListView.2
 * JD-Core Version:    0.7.0.1
 */