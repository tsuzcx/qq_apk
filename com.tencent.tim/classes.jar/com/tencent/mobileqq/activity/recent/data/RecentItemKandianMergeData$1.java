package com.tencent.mobileqq.activity.recent.data;

import acbn;
import acxw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;

class RecentItemKandianMergeData$1
  implements Runnable
{
  RecentItemKandianMergeData$1(RecentItemKandianMergeData paramRecentItemKandianMergeData, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, long paramLong) {}
  
  public void run()
  {
    acxw localacxw = this.val$app.a().a();
    this.val$app.b().a(acbn.blx, 7220, this.a.uniseq, "time", Long.valueOf(this.Ma));
    localacxw.e(this.this$0.mUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData.1
 * JD-Core Version:    0.7.0.1
 */