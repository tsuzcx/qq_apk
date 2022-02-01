package com.tencent.qqmail.model;

import com.tencent.qqmail.model.qmnote.storage.QMNoteTask;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.List;

class NoteManager$14
  implements QMCallback.IErrorCallback
{
  NoteManager$14(NoteManager paramNoteManager, List paramList, boolean paramBoolean) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    paramQMNetworkResponse = this.this$0.getNoteTask();
    List localList = this.val$clouds;
    if (this.val$star) {}
    for (paramQMNetworkRequest = "1";; paramQMNetworkRequest = "0")
    {
      paramQMNetworkResponse.addTasks(localList, 5, paramQMNetworkRequest);
      QMNotification.postNotification("NOTE_LIST_UPDATE", null);
      QMNotification.postNotification("N_STARNOTE_ERROR", paramQMNetworkError);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.14
 * JD-Core Version:    0.7.0.1
 */