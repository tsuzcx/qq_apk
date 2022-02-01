package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import org.apache.commons.lang3.StringUtils;

class QMMailCGIManager$48
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$48(QMMailCGIManager paramQMMailCGIManager, String paramString, int paramInt1, int paramInt2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.get("errcode") != null) && (StringUtils.equals(paramQMNetworkRequest.get("errcode").toString(), "0")))
    {
      paramQMNetworkRequest = StringExtention.MD5With32Charactor(this.val$password);
      AccountManager.shareInstance().setAccountEncryptFolderPwd(this.val$accountId, paramQMNetworkRequest);
      QMLog.log(4, "QMMailCGIManager", "user unlock success");
      QMWatcherCenter.triggerUnlockFolderSucc(this.val$accountId, this.val$folderId);
      return;
    }
    QMLog.log(4, "QMMailCGIManager", "user unlock error");
    QMWatcherCenter.triggerUnlockFolderError(this.val$accountId, this.val$folderId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.48
 * JD-Core Version:    0.7.0.1
 */