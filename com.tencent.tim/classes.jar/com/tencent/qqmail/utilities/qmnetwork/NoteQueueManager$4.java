package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class NoteQueueManager$4
  implements MailManagerDelegate.MailErrorCallback
{
  NoteQueueManager$4(NoteQueueManager paramNoteQueueManager, String paramString) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "algerconflict onerror", "onerror " + this.val$originalNoteId);
    NoteQueueManager.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.NoteQueueManager.4
 * JD-Core Version:    0.7.0.1
 */