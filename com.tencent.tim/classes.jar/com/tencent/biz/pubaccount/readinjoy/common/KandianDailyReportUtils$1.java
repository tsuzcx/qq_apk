package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public final class KandianDailyReportUtils$1
  implements Runnable
{
  public KandianDailyReportUtils$1(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.extLong = 0;
    this.val$app.b().a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extLong", Integer.valueOf(this.a.extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils.1
 * JD-Core Version:    0.7.0.1
 */