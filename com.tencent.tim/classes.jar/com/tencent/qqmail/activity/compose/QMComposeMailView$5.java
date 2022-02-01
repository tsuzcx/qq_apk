package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qqmail.utilities.thread.Threads;

class QMComposeMailView$5
  implements View.OnLayoutChangeListener
{
  QMComposeMailView$5(QMComposeMailView paramQMComposeMailView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    QMComposeMailView.access$600(this.this$0, paramView);
    Threads.runOnMainThread(new QMComposeMailView.5.1(this, paramView), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeMailView.5
 * JD-Core Version:    0.7.0.1
 */