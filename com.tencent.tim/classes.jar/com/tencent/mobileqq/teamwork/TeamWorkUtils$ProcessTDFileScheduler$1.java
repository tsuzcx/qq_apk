package com.tencent.mobileqq.teamwork;

import aobw;
import aobw.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TeamWorkUtils$ProcessTDFileScheduler$1
  implements Runnable
{
  public TeamWorkUtils$ProcessTDFileScheduler$1(aobw.a parama, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = aobw.a.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      aobw.i((MessageRecord)localIterator.next(), this.val$app);
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler.1
 * JD-Core Version:    0.7.0.1
 */