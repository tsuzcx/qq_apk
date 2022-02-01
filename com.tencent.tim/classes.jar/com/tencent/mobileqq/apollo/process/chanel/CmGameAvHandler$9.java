package com.tencent.mobileqq.apollo.process.chanel;

import abnq;
import abny;
import abvy;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.common.app.BaseApplicationImpl;

public class CmGameAvHandler$9
  implements Runnable
{
  public CmGameAvHandler$9(abnq paramabnq, int paramInt, long paramLong) {}
  
  public void run()
  {
    abvy.a(BaseApplicationImpl.getContext()).a().getVideoCtrl().switchCamera(this.cqm, new abny(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.9
 * JD-Core Version:    0.7.0.1
 */