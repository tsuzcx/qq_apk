package dov.com.qq.im.ae;

import android.os.Process;
import awtq;
import axiy;
import java.util.concurrent.CountDownLatch;

public class AEPituCameraUnit$1
  implements Runnable
{
  public AEPituCameraUnit$1(awtq paramawtq) {}
  
  public void run()
  {
    try
    {
      axiy.i("AEPituCameraUnit", "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          axiy.i("AEPituCameraUnit", "[AEPituCameraUnit] unit init BEGIN");
          awtq.a(this.this$0);
          axiy.i("AEPituCameraUnit", "[AEPituCameraUnit] initAEKitReport-end");
          return;
        }
        finally
        {
          awtq.a(this.this$0).countDown();
        }
        localException = localException;
        axiy.e("AEPituCameraUnit", "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */