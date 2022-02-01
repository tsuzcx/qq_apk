package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.List;

class NoteManager$10
  implements QMCallback.ISuccessCallback
{
  NoteManager$10(NoteManager paramNoteManager, List paramList) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    this.this$0.purgeNoteIds(this.val$pendingDeleteIds);
    NoteManager.access$000(this.this$0, paramQMNetworkResponse, this.this$0.mCurAccountId);
    QMNotification.postNotification("NOTE_LIST_UPDATE", "network");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.10
 * JD-Core Version:    0.7.0.1
 */