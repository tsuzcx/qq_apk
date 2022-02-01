package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$31
  implements com.tencent.moai.mailsdk.callback.SearchMailCallback
{
  QMMailProtocolJavaService$31(QMMailProtocolJavaService paramQMMailProtocolJavaService, QMProtocolRequest paramQMProtocolRequest, long paramLong, int[] paramArrayOfInt, Account paramAccount, SearchInfo paramSearchInfo, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.qqmail.model.mail.callback.SearchMailCallback paramSearchMailCallback, com.tencent.moai.mailsdk.model.Profile paramProfile1) {}
  
  public void onSearchError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "protocol search error:" + paramInt1 + ":" + paramInt2 + ":" + paramString);
    if (paramInt1 == 4) {
      PasswordErrHandler.saveStateAndShowErr(this.val$account.getId(), -1);
    }
    if (this.val$searchCallbacks != null) {
      this.val$searchCallbacks.onSearchError(this.val$searchInfo, new QMProtocolError(ProtocolResult.mapToProtocolResult(paramInt1), paramString));
    }
    if (this.val$searchCallbacks != null) {
      this.val$searchCallbacks.onSearchComplete(this.val$searchCount[1], this.val$searchCount);
    }
    QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "searchMail", paramInt2, paramString);
  }
  
  public void onSearchMail(Mail paramMail)
  {
    if (this.val$request.isAbort()) {
      QMLog.log(5, "QMMailProtocolJavaService", "protocol search request is aborted!!");
    }
    do
    {
      return;
      if (this.val$searchUtc < paramMail.getUtc())
      {
        QMLog.log(5, "QMMailProtocolJavaService", "protocol search duplicated!!");
        return;
      }
      if (this.val$searchCount[1] >= this.val$searchCount[0]) {
        break;
      }
      int[] arrayOfInt = this.val$searchCount;
      arrayOfInt[1] += 1;
      paramMail.setSearchMail(true);
      paramMail = QMMailProtocolJavaService.access$600(this.this$0, this.val$account.getId(), this.val$searchInfo.getFolderId(), paramMail, this.val$profile.protocolType);
    } while (this.val$searchCallbacks == null);
    this.val$searchCallbacks.onSearchMail(paramMail);
    return;
    QMLog.log(5, "QMMailProtocolJavaService", "protocol search, up to max:" + this.val$searchCount[1]);
  }
  
  public void onSearchSuccess(int paramInt1, int paramInt2)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "protocol search receivedCount:" + paramInt1 + ":" + paramInt2);
    if (this.val$searchCallbacks != null) {
      this.val$searchCallbacks.onSearchSuccess(paramInt1, this.val$searchCount);
    }
    if (this.val$searchCallbacks != null) {
      this.val$searchCallbacks.onSearchComplete(paramInt1, this.val$searchCount);
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "searchMail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.31
 * JD-Core Version:    0.7.0.1
 */