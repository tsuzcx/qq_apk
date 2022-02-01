package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.SearchMailCallback;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.protocol.Mail;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$24
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$24(QMMailProtocolNativeService paramQMMailProtocolNativeService, QMProtocolRequest paramQMProtocolRequest, long paramLong, int[] paramArrayOfInt, Profile paramProfile, SearchMailCallback paramSearchMailCallback, SearchInfo paramSearchInfo, Account paramAccount) {}
  
  public void onSearchMail(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    if (this.val$request.isAbort()) {
      QMLog.log(5, "QMMailProtocolNativeService", "protocol search request is aborted!!");
    }
    do
    {
      return;
      if (this.val$searchUtc < paramMail.receivedUtc)
      {
        QMLog.log(5, "QMMailProtocolNativeService", "protocol search duplicated!!");
        return;
      }
      if (this.val$searchCount[1] >= this.val$searchCount[0]) {
        break;
      }
      int[] arrayOfInt = this.val$searchCount;
      arrayOfInt[1] += 1;
      paramMail.isSearchMail = true;
      paramMail = QMMailProtocolNativeService.access$400(this.this$0, paramMail, this.val$profile.protocolType);
      if (this.val$searchCallbacks != null) {
        this.val$searchCallbacks.onSearchMail(paramMail);
      }
    } while (this.val$profile.protocolType != 4);
    this.this$0.saveActiveSync(this.val$searchInfo.getAccountId(), paramProtocolResult);
    return;
    QMLog.log(5, "QMMailProtocolNativeService", "protocol search, up to max:" + this.val$searchCount[1]);
  }
  
  public void onSearchMailComplete(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "protocol search result " + paramProtocolResult.error_code_ + ":" + paramInt1 + ":" + paramInt2 + ":" + this.val$searchCount[1]);
    if (paramProtocolResult.error_code_ == 0)
    {
      if (this.val$searchCallbacks != null) {
        this.val$searchCallbacks.onSearchSuccess(paramInt1, this.val$searchCount);
      }
      if (this.val$profile.protocolType == 4) {
        this.this$0.saveActiveSync(this.val$searchInfo.getAccountId(), paramProtocolResult);
      }
    }
    for (;;)
    {
      if (this.val$searchCallbacks != null) {
        this.val$searchCallbacks.onSearchComplete(paramInt1, this.val$searchCount);
      }
      return;
      if (paramProtocolResult.error_code_ == 4)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "searchMail auth error : " + this.val$account.getId());
        PasswordErrHandler.saveStateAndShowErr(this.val$account.getId(), -1);
        if (this.val$searchCallbacks != null) {
          this.val$searchCallbacks.onSearchError(this.val$searchInfo, new QMProtocolError(paramProtocolResult.error_code_));
        }
      }
      else
      {
        QMLog.log(6, "QMMailProtocolNativeService", "searchMail error : " + this.val$account.getEmail() + "," + this.val$searchInfo.getAccountId() + "," + this.val$searchInfo.getFolderId());
        if (this.val$searchCallbacks != null) {
          this.val$searchCallbacks.onSearchError(this.val$searchInfo, new QMProtocolError(paramProtocolResult.error_code_));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.24
 * JD-Core Version:    0.7.0.1
 */