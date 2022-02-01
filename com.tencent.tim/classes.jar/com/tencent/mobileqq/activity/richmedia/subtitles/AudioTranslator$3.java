package com.tencent.mobileqq.activity.richmedia.subtitles;

import aath;
import aaun;
import alyj;
import amby;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class AudioTranslator$3
  implements Runnable
{
  public AudioTranslator$3(aath paramaath, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    synchronized (this.this$0)
    {
      long l;
      if (aath.a(this.this$0) != null)
      {
        l = System.currentTimeMillis();
        if (l - aath.a(this.this$0).MF >= this.cjO) {
          break label69;
        }
      }
      label69:
      String str1;
      do
      {
        aath.a(this.this$0, aath.a(this.this$0), true, this.cjO);
        return;
        aath.a(this.this$0).MF = l;
        str1 = "";
        if (aath.a(this.this$0).ME != -1L) {
          str1 = String.valueOf(aath.a(this.this$0).ME);
        }
        amby localamby = (amby)QQStoryContext.c().getBusinessHandler(0);
        String str2 = "";
        if (aath.a(this.this$0).a != null)
        {
          str2 = aath.a(this.this$0).a.host;
          i = aath.a(this.this$0).a.port;
        }
        localamby.a(str1, "TransInfo.HeartBeat", str2, i, null, 0, 0, false, 2);
      } while (!QLog.isColorLevel());
      QLog.d(aath.access$000(), 2, "send heartbeat. sessionid:" + str1 + "，nDuration =" + this.cjO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator.3
 * JD-Core Version:    0.7.0.1
 */