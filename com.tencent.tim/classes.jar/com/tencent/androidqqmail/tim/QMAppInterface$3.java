package com.tencent.androidqqmail.tim;

import com.tencent.qqmail.account.AccountList;

class QMAppInterface$3
  implements TimMailLoginManager.GetTicketCallback
{
  QMAppInterface$3(QMAppInterface paramQMAppInterface, AccountList paramAccountList, int paramInt) {}
  
  public void onError(String paramString, int paramInt1, int paramInt2)
  {
    QMAppInterface.access$000(this.this$0, this.val$accountList, this.val$index + 1);
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    QMAppInterface.access$000(this.this$0, this.val$accountList, this.val$index + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.QMAppInterface.3
 * JD-Core Version:    0.7.0.1
 */