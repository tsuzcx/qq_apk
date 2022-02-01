package com.tencent.av.ui.funchat.record;

import amaf;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import jha;

public class QavVideoAudioRecorder$1
  implements Runnable
{
  public QavVideoAudioRecorder$1(jha paramjha, amaf paramamaf, HandlerThread paramHandlerThread) {}
  
  public void run()
  {
    if (this.b != null) {
      this.b.release();
    }
    try
    {
      if (VersionUtils.isJellyBeanMA2())
      {
        this.o.getLooper().quitSafely();
        QLog.i("QavVideoAudioRecorder", 1, "onDestroy quitSafely");
        return;
      }
      this.o.getLooper().quit();
      QLog.i("QavVideoAudioRecorder", 1, "onDestroy quit");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QavVideoAudioRecorder", 1, "onDestroy Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1
 * JD-Core Version:    0.7.0.1
 */