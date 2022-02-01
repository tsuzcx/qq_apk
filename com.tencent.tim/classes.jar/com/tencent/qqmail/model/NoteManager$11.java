package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class NoteManager$11
  implements QMCallback.IBeforeSendCallback
{
  NoteManager$11(NoteManager paramNoteManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    QMNotification.postNotification("N_STARNOTE_BEFORESEND", paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.11
 * JD-Core Version:    0.7.0.1
 */