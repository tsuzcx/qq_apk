package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;

class QMMailProtocolService$2
  implements IListStatusCallback
{
  QMMailProtocolService$2(QMMailProtocolService paramQMMailProtocolService, IListStatusCallback paramIListStatusCallback, Profile paramProfile, Account paramAccount, QMFolder paramQMFolder) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    int i;
    if (paramQMNetworkError != null)
    {
      i = paramQMNetworkError.code;
      if (!QMMailProtocolService.access$000(this.this$0, this.val$profile, i)) {
        break label49;
      }
      this.this$0.syncFolderStatus(this.val$account, this.val$folder, this.val$listStatusCallback);
    }
    label49:
    while (this.val$listStatusCallback == null)
    {
      return;
      i = 0;
      break;
    }
    this.val$listStatusCallback.error(paramQMNetworkError);
  }
  
  public void process()
  {
    if (this.val$listStatusCallback != null) {
      this.val$listStatusCallback.process();
    }
  }
  
  public void success(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QMProxyUtil.noNeedProxy(this.val$profile);
    if (this.val$listStatusCallback != null) {
      this.val$listStatusCallback.success(paramBoolean, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolService.2
 * JD-Core Version:    0.7.0.1
 */