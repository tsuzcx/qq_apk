package com.tencent.mobileqq.gamecenter.web;

import ahvf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class QQGameIPCModule$1
  implements Runnable
{
  public QQGameIPCModule$1(ahvf paramahvf, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.val$app.b().a(this.p.frienduin, this.p.istroop, this.p.uniseq, "extStr", this.p.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameIPCModule.1
 * JD-Core Version:    0.7.0.1
 */