package dov.com.qq.im.ae;

import awtq;
import awwp;
import axbr;
import axov;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$24
  implements Runnable
{
  public AEPituCameraUnit$24(awtq paramawtq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager begin");
    }
    Object localObject = awtq.a(this.this$0);
    if (awtq.b(this.this$0) == AECaptureMode.NORMAL) {}
    for (boolean bool = true;; bool = false)
    {
      ((awwp)localObject).XS(bool);
      localObject = (axbr)axov.a(18);
      axpa.eGt = 0;
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraUnit", 2, "onResourceDownload update filterpager end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.24
 * JD-Core Version:    0.7.0.1
 */