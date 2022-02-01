package com.tencent.mobileqq.activity.richmedia;

import aaqn;
import aniu;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class FlowSendTask$1
  implements Runnable
{
  public FlowSendTask$1(aaqn paramaaqn) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.bdJ, 2, "FlowSendTask(): isPTV:" + this.this$0.bxm + ", mVideoFileDir:" + this.this$0.bdG + ",is to call AVideoCodec.recordSubmit()");
      }
      aniu.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        this.this$0.ciE = -6;
        synchronized (this.this$0.d.cb)
        {
          this.this$0.d.cb.set(true);
          this.this$0.d.cb.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(this.this$0.bdJ, 2, "FlowSendTask(): isPTV:" + this.this$0.bxm + ", mVideoFileDir:" + this.this$0.bdG + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowSendTask.1
 * JD-Core Version:    0.7.0.1
 */