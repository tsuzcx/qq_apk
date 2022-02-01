package com.tencent.mobileqq.troop.utils;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public final class TroopFileUtils$1
  implements Runnable
{
  public TroopFileUtils$1(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.val$app.b().b(this.a, this.val$app.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUtils.1
 * JD-Core Version:    0.7.0.1
 */