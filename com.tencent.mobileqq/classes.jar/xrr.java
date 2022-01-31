import android.os.Handler;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class xrr
  implements Runnable
{
  xrr(xrq paramxrq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit,run start");
    }
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.f())
    {
      RMVideoStateMgr.b(null);
      if (localRMVideoStateMgr.f()) {}
    }
    for (;;)
    {
      return;
      File localFile = new File(GloableValue.b + File.separator + ".nomedia");
      if (!localFile.exists()) {}
      try
      {
        localFile.createNewFile();
        label84:
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] delayInit, post timeout runnable");
        }
        localRMVideoStateMgr.a.postDelayed(this.a.a, 10000L);
        localRMVideoStateMgr.l();
        localRMVideoStateMgr.m();
        localRMVideoStateMgr.k();
        try
        {
          AVCodec.get().init();
          this.a.c = true;
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
            this.a.c = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrr
 * JD-Core Version:    0.7.0.1
 */