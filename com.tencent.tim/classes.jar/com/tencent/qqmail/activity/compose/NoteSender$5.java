package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.utilities.qmnetwork.NoteQueueManager;

class NoteSender$5
  implements Runnable
{
  NoteSender$5(NoteSender paramNoteSender, QMComposeNote paramQMComposeNote) {}
  
  public void run()
  {
    this.val$note.compressAndReplaceAllLocalImages();
    NoteManager.getSharedInstance().saveUnsendNote(this.val$note);
    NoteQueueManager localNoteQueueManager = NoteQueueManager.sharedInstance();
    if (localNoteQueueManager != null) {
      localNoteQueueManager.startSend();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.NoteSender.5
 * JD-Core Version:    0.7.0.1
 */