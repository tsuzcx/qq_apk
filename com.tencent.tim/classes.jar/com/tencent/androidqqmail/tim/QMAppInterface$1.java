package com.tencent.androidqqmail.tim;

import com.tencent.qqmail.account.AccountManager;

class QMAppInterface$1
  implements Runnable
{
  QMAppInterface$1(QMAppInterface paramQMAppInterface) {}
  
  public void run()
  {
    QMAppInterface.access$000(this.this$0, AccountManager.shareInstance().getAccountList(), 0);
    TimContactManager.getInstance().sync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.QMAppInterface.1
 * JD-Core Version:    0.7.0.1
 */