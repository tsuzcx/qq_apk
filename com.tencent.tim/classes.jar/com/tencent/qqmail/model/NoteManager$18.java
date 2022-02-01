package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NoteManager$18
  implements QMCallback.IErrorCallback
{
  NoteManager$18(NoteManager paramNoteManager, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMNotification.postNotification("N_LOADNOTE_ERROR", this.val$noteId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.18
 * JD-Core Version:    0.7.0.1
 */