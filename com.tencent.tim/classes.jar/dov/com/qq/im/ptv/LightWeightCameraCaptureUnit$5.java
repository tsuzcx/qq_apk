package dov.com.qq.im.ptv;

import alvs;
import ayan;
import com.tencent.qphone.base.util.QLog;

public class LightWeightCameraCaptureUnit$5
  implements Runnable
{
  public void run()
  {
    boolean bool = ayan.a(this.this$0).a(250, -1, null);
    QLog.i("LightWeightCameraCaptureUnit", 1, "(NEW)LaunchActivity to mClient.sendToService success: " + bool);
    if (!bool) {
      throw new RuntimeException("mClient.sendToService false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.5
 * JD-Core Version:    0.7.0.1
 */