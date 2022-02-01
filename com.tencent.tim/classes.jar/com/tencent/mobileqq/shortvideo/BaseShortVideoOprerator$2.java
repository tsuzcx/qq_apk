package com.tencent.mobileqq.shortvideo;

import akxe;
import anfu;
import angb;
import angi;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, angi paramangi) {}
  
  public void run()
  {
    angb localangb = this.val$app.a();
    if (localangb.g.contains(this.c))
    {
      localangb.g.remove(this.c);
      localangb.bM.decrementAndGet();
      localangb.mp.remove(this.c.b.uuid);
      akxe.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.c.b.uniseq + ",curHandingNum:" + localangb.bM.get());
      this.val$app.a().dPl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */