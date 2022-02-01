package com.tencent.qqmail.model;

import com.tencent.qqmail.note.NoteListActivity.NoteDeleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.List;

class NoteManager$21
  implements QMCallback.ISuccessCallback
{
  NoteManager$21(NoteManager paramNoteManager, List paramList, NoteListActivity.NoteDeleteCallback paramNoteDeleteCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    NoteManager.access$200(this.this$0).deleteNotes(this.val$clouds);
    if (this.val$callback != null) {
      this.val$callback.onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.21
 * JD-Core Version:    0.7.0.1
 */