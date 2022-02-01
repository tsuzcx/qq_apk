package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qqmail.utilities.thread.Threads;

class QMComposeNoteView$8
  implements View.OnLayoutChangeListener
{
  QMComposeNoteView$8(QMComposeNoteView paramQMComposeNoteView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    QMComposeNoteView.access$500(this.this$0, paramView);
    Threads.runOnMainThread(new QMComposeNoteView.8.1(this, paramView), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeNoteView.8
 * JD-Core Version:    0.7.0.1
 */