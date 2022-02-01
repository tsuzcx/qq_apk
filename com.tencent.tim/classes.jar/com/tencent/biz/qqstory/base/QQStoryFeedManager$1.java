package com.tencent.biz.qqstory.base;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;
import plz;

public class QQStoryFeedManager$1
  implements Runnable
{
  public QQStoryFeedManager$1(plz paramplz, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = plz.a(this.this$0).b().b(this.val$uin, 0, new int[] { -2061 }).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      plz.a(this.this$0).b().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      plz.a(this.this$0).b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryFeedManager.1
 * JD-Core Version:    0.7.0.1
 */