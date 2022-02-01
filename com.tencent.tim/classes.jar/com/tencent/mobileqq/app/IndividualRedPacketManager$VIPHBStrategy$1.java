package com.tencent.mobileqq.app;

import acgn;
import acgn.c;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

public class IndividualRedPacketManager$VIPHBStrategy$1
  implements Runnable
{
  public IndividualRedPacketManager$VIPHBStrategy$1(acgn.c paramc, acgn paramacgn, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      acgn.a(acgn.c.a(this.this$0), this.c, this.val$info);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(acgn.access$000(), 1, "dealRedPacketToShow failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy.1
 * JD-Core Version:    0.7.0.1
 */