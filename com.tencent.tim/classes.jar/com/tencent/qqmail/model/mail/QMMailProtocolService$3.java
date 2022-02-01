package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;

class QMMailProtocolService$3
  implements FolderListCallback
{
  QMMailProtocolService$3(QMMailProtocolService paramQMMailProtocolService, Profile paramProfile, FolderListCallback paramFolderListCallback, Account paramAccount) {}
  
  public void onError(QMProtocolError paramQMProtocolError)
  {
    int i = paramQMProtocolError.code;
    if (QMMailProtocolService.access$000(this.this$0, this.val$profile, i)) {
      this.this$0.fetchFolderList(this.val$account, this.val$folderListCallback);
    }
    while (this.val$folderListCallback == null) {
      return;
    }
    this.val$folderListCallback.onError(paramQMProtocolError);
  }
  
  public void onSuccess(QMFolder[] paramArrayOfQMFolder1, QMFolder[] paramArrayOfQMFolder2, QMFolder[] paramArrayOfQMFolder3)
  {
    QMProxyUtil.noNeedProxy(this.val$profile);
    if (this.val$folderListCallback != null) {
      this.val$folderListCallback.onSuccess(paramArrayOfQMFolder1, paramArrayOfQMFolder2, paramArrayOfQMFolder3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolService.3
 * JD-Core Version:    0.7.0.1
 */