package dov.com.tencent.biz.qqstory.takevideo;

import ayiq;
import azbb;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicBoolean;

public class EditWebVideoPartManager$3
  implements Runnable
{
  public EditWebVideoPartManager$3(ayiq paramayiq, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditWebVideoActivity", 2, "stopRecord(): Async, mVideoCacheDir:" + this.a.bdG + ",is to call AVideoCodec.recordSubmit()");
      }
      azbb.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        synchronized (this.a.cb)
        {
          this.a.cb.set(true);
          this.a.cb.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("EditWebVideoActivity", 2, "stopRecord(): Async, mVideoCacheDir:" + this.a.bdG + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.3
 * JD-Core Version:    0.7.0.1
 */