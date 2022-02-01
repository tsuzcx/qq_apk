package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NoteManager$28
  implements QMCallback.IErrorCallback
{
  NoteManager$28(NoteManager paramNoteManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if (paramQMNetworkError != null)
    {
      paramQMNetworkResponse = new StringBuilder().append("addNoteCatalog appcode:");
      if (!(paramQMNetworkError instanceof QMCGIError)) {
        break label77;
      }
    }
    label77:
    for (paramQMNetworkRequest = Integer.valueOf(((QMCGIError)paramQMNetworkError).appCode);; paramQMNetworkRequest = "")
    {
      QMLog.log(5, "NoteManager", paramQMNetworkRequest + ", desp:" + paramQMNetworkError.desp);
      if (this.val$fn != null) {
        this.val$fn.handleError(paramQMNetworkError);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.28
 * JD-Core Version:    0.7.0.1
 */