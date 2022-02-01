package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.os.Handler;
import ayvf;
import azam;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class RMVideoInitState$2
  implements Runnable
{
  public RMVideoInitState$2(ayvf paramayvf) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit,run start");
    }
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.WV())
    {
      RMVideoStateMgr.AR(null);
      if (!localRMVideoStateMgr.WV()) {
        return;
      }
    }
    File localFile = new File(azam.cdR + File.separator + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      label84:
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoInitState", 2, "[@] delayInit, post timeout runnable");
      }
      localRMVideoStateMgr.mHandler.postDelayed(this.this$0.fk, 20000L);
      localRMVideoStateMgr.cyl();
      localRMVideoStateMgr.cym();
      localRMVideoStateMgr.stopWatching();
      try
      {
        AVCodec.get().init();
        this.this$0.mIsInited = true;
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] delayInit,run finish");
        }
        this.this$0.dBl = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.2
 * JD-Core Version:    0.7.0.1
 */