package dov.com.qq.im.ae.camera.core;

import aary;
import aath;
import awwa;
import awwa.b;
import com.tencent.mobileqq.qmcf.QmcfManager;

public class AECameraManager$3
  implements Runnable
{
  public AECameraManager$3(awwa paramawwa, awwa.b paramb) {}
  
  public void run()
  {
    awwa.a(this.this$0, false);
    aary localaary;
    if (awwa.a(this.this$0) == 1)
    {
      awwa.a(this.this$0, 2);
      aaqh.cix = awwa.a(this.this$0);
      if (awwa.a(this.this$0) != null)
      {
        localaary = awwa.a(this.this$0);
        if (awwa.a(this.this$0) != 1) {
          break label127;
        }
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localaary.setMirror(bool);
      awwa.a(this.this$0, false);
      QmcfManager.getInstance().setCameraMode(awwa.a(this.this$0));
      aath.a().Dd(true);
      awwa.a(this.this$0, this.b);
      return;
      awwa.a(this.this$0, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */