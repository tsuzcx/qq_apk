package com.tencent.mobileqq.imaxad;

import aibd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class ImaxAdPresenter$1
  implements Runnable
{
  public ImaxAdPresenter$1(aibd paramaibd, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.val$app.b().a(this.k.frienduin, this.k.msgtype, this.k.uniseq, "extStr", this.k.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdPresenter.1
 * JD-Core Version:    0.7.0.1
 */