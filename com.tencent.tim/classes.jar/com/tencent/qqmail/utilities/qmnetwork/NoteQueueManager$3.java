package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;

class NoteQueueManager$3
  implements MailManagerDelegate.DataCallback
{
  NoteQueueManager$3(NoteQueueManager paramNoteQueueManager, QMComposeNote paramQMComposeNote, String paramString) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    NoteQueueManager.access$300(this.this$0, this.val$note, (QMNetworkResponse)paramObject1, this.val$originalNoteId);
    NoteQueueManager.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.NoteQueueManager.3
 * JD-Core Version:    0.7.0.1
 */