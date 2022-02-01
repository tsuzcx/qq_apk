package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NoteManager$32
  implements QMCallback.IErrorCallback
{
  NoteManager$32(NoteManager paramNoteManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if ((paramQMNetworkError != null) && ((paramQMNetworkError instanceof QMCGIError)))
    {
      paramQMNetworkRequest = (QMCGIError)paramQMNetworkError;
      QMLog.log(5, "NoteManager", "getCatalogList appcode:" + paramQMNetworkRequest.appCode + ", desp:" + paramQMNetworkError.desp);
    }
    if (this.val$fn != null) {
      this.val$fn.handleError(paramQMNetworkError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.32
 * JD-Core Version:    0.7.0.1
 */