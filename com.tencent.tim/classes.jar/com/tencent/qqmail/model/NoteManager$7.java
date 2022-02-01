package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NoteManager$7
  implements QMCallback.ISuccessCallback
{
  NoteManager$7(NoteManager paramNoteManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    this.this$0._loadSendConflictArraySuccess(paramQMNetworkResponse, null, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.7
 * JD-Core Version:    0.7.0.1
 */