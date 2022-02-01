package com.tencent.qqmail.activity.compose;

import android.util.Log;

class QMComposeNoteView$3
  implements Runnable
{
  QMComposeNoteView$3(QMComposeNoteView paramQMComposeNoteView) {}
  
  public void run()
  {
    Log.i("QMComposeNoteView", "Execute focus change " + QMComposeNoteView.access$000(this.this$0));
    if (QMComposeNoteView.access$000(this.this$0))
    {
      this.this$0.showformatToolbar(true);
      return;
    }
    this.this$0.hideformatToolbar(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeNoteView.3
 * JD-Core Version:    0.7.0.1
 */