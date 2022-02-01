package com.tencent.qqmail.model;

import com.tencent.qqmail.activity.watcher.AppStatusWatcher;
import com.tencent.qqmail.utilities.qmnetwork.NoteQueueManager;

class NoteManager$1
  implements AppStatusWatcher
{
  NoteManager$1(NoteManager paramNoteManager) {}
  
  public void gotoBackGround() {}
  
  public void gotoForGround()
  {
    NoteQueueManager localNoteQueueManager = NoteQueueManager.sharedInstance();
    if (localNoteQueueManager != null) {
      localNoteQueueManager.startSend();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.1
 * JD-Core Version:    0.7.0.1
 */