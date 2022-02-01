package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.utilities.log.QMLog;

class NoteQueueManager$5
  implements MailManagerDelegate.EventCallback
{
  NoteQueueManager$5(NoteQueueManager paramNoteQueueManager, String paramString, QMComposeNote paramQMComposeNote) {}
  
  public void run(Object paramObject)
  {
    if (paramObject == null) {
      QMLog.log(6, "algerconflict oncomplete", "oncomplete " + this.val$originalNoteId + "  and object is null!!!");
    }
    for (;;)
    {
      this.this$0.responseComplete(this.val$note);
      return;
      QMLog.log(4, "algerconflict oncomplete", "oncomplete " + this.val$originalNoteId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.NoteQueueManager.5
 * JD-Core Version:    0.7.0.1
 */