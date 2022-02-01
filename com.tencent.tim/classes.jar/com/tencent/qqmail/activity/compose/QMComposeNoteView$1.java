package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.OnFocusChangeListener;
import com.tencent.qqmail.utilities.thread.Threads;

class QMComposeNoteView$1
  implements QMUIRichEditor.OnFocusChangeListener
{
  QMComposeNoteView$1(QMComposeNoteView paramQMComposeNoteView) {}
  
  public void focus(boolean paramBoolean)
  {
    QMComposeNoteView.access$002(this.this$0, paramBoolean);
    Threads.replaceCallbackOnMainThread(QMComposeNoteView.access$100(this.this$0), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeNoteView.1
 * JD-Core Version:    0.7.0.1
 */