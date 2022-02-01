package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NoteManager$27
  implements QMCallback.ISuccessCallback
{
  NoteManager$27(NoteManager paramNoteManager, String paramString, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = NoteManager.access$300(this.this$0, this.val$name, paramQMNetworkResponse);
    QMNotification.postNotification("NOTE_CATEGORY_UPDATE", paramQMNetworkRequest);
    if (this.val$fn != null) {
      this.val$fn.handleSuccess(paramQMNetworkRequest, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.27
 * JD-Core Version:    0.7.0.1
 */