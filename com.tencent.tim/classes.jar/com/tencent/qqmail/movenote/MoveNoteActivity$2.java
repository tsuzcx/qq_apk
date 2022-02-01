package com.tencent.qqmail.movenote;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.QMNotification;

class MoveNoteActivity$2
  implements ICallBack
{
  MoveNoteActivity$2(MoveNoteActivity paramMoveNoteActivity) {}
  
  public void callback(Object paramObject)
  {
    QMNotification.postNotification("QMTIP_STATUS", "移动失败");
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.MoveNoteActivity.2
 * JD-Core Version:    0.7.0.1
 */