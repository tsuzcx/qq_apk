package com.tencent.mobileqq.statistics;

import anpc;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class StatisticCollector$6
  implements Runnable
{
  public StatisticCollector$6(anpc paramanpc, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    MsfServiceSdk.get().sendMsg(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector.6
 * JD-Core Version:    0.7.0.1
 */