package com.tencent.qqmail.model;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NoteManager$29
  implements QMCallback.ISuccessCallback
{
  NoteManager$29(NoteManager paramNoteManager, String paramString, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
    if (paramQMNetworkRequest != null) {
      NoteStorage.setDefaultCatId(paramQMNetworkRequest.getId(), this.val$catid);
    }
    QMWatcherCenter.triggerChangeNoteDefaultCategorySuccess(this.val$catid);
    if (this.val$fn != null) {
      this.val$fn.handleSuccess(paramQMNetworkResponse, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.29
 * JD-Core Version:    0.7.0.1
 */