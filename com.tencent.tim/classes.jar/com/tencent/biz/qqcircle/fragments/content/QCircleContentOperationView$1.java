package com.tencent.biz.qqcircle.fragments.content;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.widget.FrameLayout;

class QCircleContentOperationView$1
  implements Runnable
{
  QCircleContentOperationView$1(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public void run()
  {
    if (QCircleContentOperationView.a(this.this$0) != null) {
      QCircleContentOperationView.a(this.this$0).setTouchDelegate(new TouchDelegate(new Rect(0, 0, QCircleContentOperationView.a(this.this$0).getMeasuredWidth(), QCircleContentOperationView.a(this.this$0).getMeasuredHeight()), this.this$0.mSeekBar));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.1
 * JD-Core Version:    0.7.0.1
 */