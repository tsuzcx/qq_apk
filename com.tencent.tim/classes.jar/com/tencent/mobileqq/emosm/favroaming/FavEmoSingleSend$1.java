package com.tencent.mobileqq.emosm.favroaming;

import aooi;
import axol;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class FavEmoSingleSend$1
  extends TimerTask
{
  FavEmoSingleSend$1(FavEmoSingleSend paramFavEmoSingleSend) {}
  
  public void run()
  {
    QLog.e("FavEmoSingleSend", 1, "doStep, upload not complete");
    ((QQAppInterface)axol.getAppInterface()).a().a(FavEmoSingleSend.a(this.this$0));
    this.this$0.j("failed", 0, 4, 0);
    synchronized (FavEmoSingleSend.a(this.this$0))
    {
      FavEmoSingleSend.a(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend.1
 * JD-Core Version:    0.7.0.1
 */