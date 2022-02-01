package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.OnFocusChangeListener;
import com.tencent.qqmail.utilities.thread.Threads;

class QMComposeMailView$1
  implements QMUIRichEditor.OnFocusChangeListener
{
  QMComposeMailView$1(QMComposeMailView paramQMComposeMailView) {}
  
  public void focus(boolean paramBoolean)
  {
    QMComposeMailView.access$102(this.this$0, paramBoolean);
    Threads.replaceCallbackOnMainThread(QMComposeMailView.access$200(this.this$0), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeMailView.1
 * JD-Core Version:    0.7.0.1
 */