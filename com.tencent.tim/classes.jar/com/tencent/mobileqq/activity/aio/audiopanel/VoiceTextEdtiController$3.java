package com.tencent.mobileqq.activity.aio.audiopanel;

import aooi;
import aool;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVadSeg;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import wqb;
import wqc;
import wqc.a;
import wqp;

public class VoiceTextEdtiController$3
  implements Runnable
{
  public VoiceTextEdtiController$3(wqp paramwqp, String paramString) {}
  
  public void run()
  {
    wqp.a(this.this$0, true);
    byte b = this.this$0.c(this.val$path);
    QLog.d("VoiceTextEdtiController", 2, "fsType =" + b);
    wqp.a(this.this$0, wqp.a(this.this$0), this.val$path, b);
    wqp.a(this.this$0, new wqb());
    wqp.a(this.this$0).setPath(wqp.a(this.this$0));
    wqp.a(this.this$0).caD();
    wqp.a(this.this$0).caE();
    wqp.a(this.this$0).release();
    if (wqp.a(this.this$0).rH.size() == 0)
    {
      wqp.a(this.this$0).caG();
      wqp.a(this.this$0).set(true);
    }
    for (;;)
    {
      return;
      wqp.a(this.this$0).set(wqp.a(this.this$0).rH.size());
      wqp.a(this.this$0, new wqc.a[wqp.a(this.this$0).rH.size()]);
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper size=" + wqp.a(this.this$0).rH.size() + " unFinishSeg=" + wqp.a(this.this$0).get() + " isSttFinish=" + wqp.a(this.this$0).get());
      }
      int i = 0;
      while (i < wqp.a(this.this$0).rH.size())
      {
        wqp.a(this.this$0, wqp.a(this.this$0).a());
        wqp.a(this.this$0).a(wqp.a(this.this$0));
        aool localaool = new aool();
        localaool.cNy = true;
        localaool.dOM = 68;
        localaool.dQ = this.val$path;
        localaool.mUniseq = ((Math.random() * 1000000.0D));
        localaool.mPeerUin = wqp.b(this.this$0);
        localaool.mFileType = 327696;
        localaool.ckW = "pttSliceToText";
        localaool.aLy = wqp.a(this.this$0);
        localaool.dQM = wqp.a(this.this$0).rH.size();
        localaool.dQN = i;
        localaool.a = ((WXVadSeg)wqp.a(this.this$0).rH.get(i));
        localaool.chatType = wqp.a(this.this$0);
        wqp.a(this.this$0).a(localaool);
        wqp.a(this.this$0).add(Long.valueOf(localaool.mUniseq));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEdtiController.3
 * JD-Core Version:    0.7.0.1
 */