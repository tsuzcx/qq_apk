package dov.com.qq.im.ae;

import awtq;
import awzz;
import axgi;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$33
  implements Runnable
{
  public AEPituCameraUnit$33(awtq paramawtq) {}
  
  public void run()
  {
    boolean bool = true;
    if (awtq.a(this.this$0) != null) {
      awtq.a(this.this$0).dLb();
    }
    axgi localaxgi;
    if (awtq.a(this.this$0) != null)
    {
      localaxgi = awtq.a(this.this$0);
      if (awtq.b(this.this$0) != AECaptureMode.GIF) {
        break label87;
      }
    }
    for (;;)
    {
      localaxgi.p(196611, new Object[] { Boolean.valueOf(bool) });
      awtq.a(this.this$0).p(327685, new Object[0]);
      return;
      label87:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.33
 * JD-Core Version:    0.7.0.1
 */