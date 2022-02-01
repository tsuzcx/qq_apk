package com.tencent.mobileqq.activity.richmedia.state;

import aasz;
import android.os.Handler;
import anhm;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class RMVideoInitState$1
  implements Runnable
{
  public RMVideoInitState$1(aasz paramaasz) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit,run start");
    }
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.WV())
    {
      RMVideoStateMgr.AR(null);
      if (localRMVideoStateMgr.WV()) {}
    }
    for (;;)
    {
      return;
      File localFile = new File(anhm.cdR + File.separator + ".nomedia");
      if (!localFile.exists()) {}
      try
      {
        localFile.createNewFile();
        label84:
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] delayInit, post timeout runnable");
        }
        localRMVideoStateMgr.mHandler.postDelayed(this.this$0.fk, 10000L);
        localRMVideoStateMgr.cyl();
        localRMVideoStateMgr.cym();
        localRMVideoStateMgr.stopWatching();
        try
        {
          AVCodec.get().init();
          this.this$0.mIsInited = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RMVideoInitState", 2, "[@] delayInit,run finish");
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            localUnsatisfiedLinkError.printStackTrace();
            this.this$0.mIsInited = false;
          }
        }
      }
      catch (IOException localIOException)
      {
        break label84;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.1
 * JD-Core Version:    0.7.0.1
 */