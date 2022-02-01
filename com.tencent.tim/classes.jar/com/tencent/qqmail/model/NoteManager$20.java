package com.tencent.qqmail.model;

import com.tencent.qqmail.model.qmnote.storage.QMNoteTask;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.List;

class NoteManager$20
  implements QMCallback.IErrorCallback
{
  NoteManager$20(NoteManager paramNoteManager, List paramList, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    this.this$0.getNoteTask().addTasks(this.val$clouds, 6, this.val$cid);
    QMNotification.postNotification("N_MOVENOTE_ERROR", paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.20
 * JD-Core Version:    0.7.0.1
 */