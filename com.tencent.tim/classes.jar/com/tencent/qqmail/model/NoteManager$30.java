package com.tencent.qqmail.model;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NoteManager$30
  implements QMCallback.IErrorCallback
{
  NoteManager$30(NoteManager paramNoteManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    paramQMNetworkResponse = null;
    paramQMNetworkRequest = paramQMNetworkResponse;
    if (paramQMNetworkError != null)
    {
      paramQMNetworkRequest = paramQMNetworkResponse;
      if ((paramQMNetworkError instanceof QMCGIError))
      {
        paramQMNetworkRequest = (QMCGIError)paramQMNetworkError;
        QMLog.log(5, "NoteManager", "changeDefaultCatalog appcode:" + paramQMNetworkRequest.appCode + ", desp:" + paramQMNetworkError.desp);
      }
    }
    QMWatcherCenter.triggerChangeNoteDefaultCategoryError(paramQMNetworkRequest);
    if (this.val$fn != null) {
      this.val$fn.handleError(paramQMNetworkError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.30
 * JD-Core Version:    0.7.0.1
 */