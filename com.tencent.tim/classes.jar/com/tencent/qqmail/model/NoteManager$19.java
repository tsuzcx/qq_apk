package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.List;

class NoteManager$19
  implements QMCallback.ISuccessCallback
{
  NoteManager$19(NoteManager paramNoteManager, String paramString, List paramList) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "NoteManager", "movenotesucc " + this.val$cid + ":" + (String)this.val$noteIds.get(0));
    this.this$0.parseAndSaveNewSeq(paramQMNetworkResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.19
 * JD-Core Version:    0.7.0.1
 */