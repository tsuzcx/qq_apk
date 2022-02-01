package com.tencent.mobileqq.activity.richmedia;

import aniu;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class NewFlowCameraActivity$EncodeTask$1
  implements Runnable
{
  NewFlowCameraActivity$EncodeTask$1(NewFlowCameraActivity.b paramb, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.b.bdG + ",is to call AVideoCodec.recordSubmit()");
      }
      aniu.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        synchronized (this.b.cb)
        {
          this.b.cb.set(true);
          this.b.cb.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PTV.NewFlowCameraActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.b.bdG + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.EncodeTask.1
 * JD-Core Version:    0.7.0.1
 */