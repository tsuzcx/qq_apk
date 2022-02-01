package com.tencent.mobileqq.richmedia.segment;

import ambv;
import ambw;
import aolt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoSend$3
  implements Runnable
{
  public VideoSend$3(ambw paramambw, aolt paramaolt) {}
  
  public void run()
  {
    this.this$0.a = this.b;
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "processor is ready,addToSendQuene , mWaitForSubmitToProcessorInfos " + this.this$0.zh.size());
    }
    Iterator localIterator = this.this$0.zh.iterator();
    while (localIterator.hasNext())
    {
      ambv localambv = (ambv)localIterator.next();
      this.this$0.a.f(localambv);
    }
    this.this$0.zh.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.VideoSend.3
 * JD-Core Version:    0.7.0.1
 */