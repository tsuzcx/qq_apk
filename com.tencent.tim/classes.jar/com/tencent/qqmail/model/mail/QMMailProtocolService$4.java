package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.MailListCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import java.util.ArrayList;

class QMMailProtocolService$4
  implements MailListCallback
{
  QMMailProtocolService$4(QMMailProtocolService paramQMMailProtocolService, MailListCallback paramMailListCallback, Profile paramProfile, Account paramAccount, QMFolder paramQMFolder, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onRetrieveError(QMProtocolError paramQMProtocolError)
  {
    int i = paramQMProtocolError.code;
    if (QMMailProtocolService.access$000(this.this$0, this.val$profile, i)) {
      this.this$0.fetchMailList(this.val$account, this.val$folder, this.val$remoteMailIds, this.val$isUpdate, this.val$withoutSession, this.val$callback);
    }
    while (this.val$callback == null) {
      return;
    }
    this.val$callback.onRetrieveError(paramQMProtocolError);
  }
  
  public void onRetrieveMail(Mail paramMail)
  {
    if (this.val$callback != null) {
      this.val$callback.onRetrieveMail(paramMail);
    }
  }
  
  public void onRetrieveStatus(Mail[] paramArrayOfMail)
  {
    if (this.val$callback != null) {
      this.val$callback.onRetrieveStatus(paramArrayOfMail);
    }
  }
  
  public void onRetrieveSuccess(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    QMProxyUtil.noNeedProxy(this.val$profile);
    if (this.val$callback != null) {
      this.val$callback.onRetrieveSuccess(paramInt, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3);
    }
  }
  
  public void process()
  {
    if (this.val$callback != null) {
      this.val$callback.process();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolService.4
 * JD-Core Version:    0.7.0.1
 */