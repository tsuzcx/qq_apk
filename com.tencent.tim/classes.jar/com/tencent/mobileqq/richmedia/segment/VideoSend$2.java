package com.tencent.mobileqq.richmedia.segment;

import ambv;
import ambw;
import aolt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class VideoSend$2
  implements Runnable
{
  public VideoSend$2(ambw paramambw, ambv paramambv) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "addToWaitQuene, info:" + this.d + " mWaitForSubmitToProcessorInfos:" + this.this$0.zh.size());
      }
      if (this.d.avl())
      {
        this.this$0.zh.add(0, this.d);
        return;
      }
      this.this$0.zh.add(this.d);
      return;
    }
    this.this$0.a.f(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.VideoSend.2
 * JD-Core Version:    0.7.0.1
 */