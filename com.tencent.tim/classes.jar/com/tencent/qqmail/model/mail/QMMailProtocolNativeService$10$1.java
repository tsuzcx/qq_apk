package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.mail.callback.RefreshTokenCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$10$1
  implements RefreshTokenCallback
{
  QMMailProtocolNativeService$10$1(QMMailProtocolNativeService.10 param10) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "QMMailProtocolNativeService", "fetchFolderList refreshAccessToken error");
    if (this.this$1.val$folderListCallback != null) {
      this.this$1.val$folderListCallback.onError((QMProtocolError)paramQMNetworkError);
    }
  }
  
  public void onSuccess(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    paramString1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    this.this$1.this$0.fetchFolderList(paramString1, this.this$1.val$folderListCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.10.1
 * JD-Core Version:    0.7.0.1
 */