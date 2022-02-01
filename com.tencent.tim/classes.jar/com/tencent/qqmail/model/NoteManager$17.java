package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NoteManager$17
  implements QMCallback.ISuccessCallback
{
  NoteManager$17(NoteManager paramNoteManager, String paramString1, String paramString2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    NoteManager.access$100(this.this$0, paramQMNetworkResponse, this.val$noteId, this.val$fromNetwork);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.17
 * JD-Core Version:    0.7.0.1
 */