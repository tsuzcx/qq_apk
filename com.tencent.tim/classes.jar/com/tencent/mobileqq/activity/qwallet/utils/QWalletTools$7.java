package com.tencent.mobileqq.activity.qwallet.utils;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public final class QWalletTools$7
  implements Runnable
{
  public QWalletTools$7(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.val$app.b().a(this.p.frienduin, this.p.istroop, this.p.uniseq, "extStr", this.p.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.7
 * JD-Core Version:    0.7.0.1
 */