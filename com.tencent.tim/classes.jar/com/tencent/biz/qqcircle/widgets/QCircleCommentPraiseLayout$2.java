package com.tencent.biz.qqcircle.widgets;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

class QCircleCommentPraiseLayout$2
  implements Runnable
{
  QCircleCommentPraiseLayout$2(QCircleCommentPraiseLayout paramQCircleCommentPraiseLayout, View paramView1, int paramInt, View paramView2) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    this.val$view.getHitRect(localRect);
    localRect.top -= this.bie;
    localRect.bottom += this.bie;
    localRect.left -= this.bie;
    localRect.right += this.bie;
    this.val$parentView.setTouchDelegate(new TouchDelegate(localRect, this.val$view));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout.2
 * JD-Core Version:    0.7.0.1
 */