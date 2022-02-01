package com.tencent.qqmail.movenote;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMTips;

class MoveNoteActivity$1
  implements ICallBack
{
  MoveNoteActivity$1(MoveNoteActivity paramMoveNoteActivity) {}
  
  public void callback(Object paramObject)
  {
    if (MoveNoteActivity.access$000(this.this$0) != null) {
      MoveNoteActivity.access$000(this.this$0).hide();
    }
    QMNotification.postNotification("NOTE_MOVE", null);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.MoveNoteActivity.1
 * JD-Core Version:    0.7.0.1
 */