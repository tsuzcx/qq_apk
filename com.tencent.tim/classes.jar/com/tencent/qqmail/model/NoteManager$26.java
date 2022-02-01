package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class NoteManager$26
  implements QMCallback.IBeforeSendCallback
{
  NoteManager$26(NoteManager paramNoteManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    QMNotification.postNotification("searchnote_beforesend", paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.26
 * JD-Core Version:    0.7.0.1
 */