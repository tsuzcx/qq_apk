package dov.com.qq.im.ae.camera.core;

import anim;
import awwa;
import axiy;
import java.util.concurrent.atomic.AtomicInteger;

public class AECameraManager$6
  implements Runnable
{
  public AECameraManager$6(awwa paramawwa) {}
  
  public void run()
  {
    axiy.i("AECameraManager", "cameraStopPreview---ENTER");
    if (!awwa.b(this.this$0))
    {
      axiy.e("AECameraManager", "cameraStopPreview---EXIT, is not previewing");
      return;
    }
    awwa.a(this.this$0).PQ(false);
    awwa.a(this.this$0).set(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.6
 * JD-Core Version:    0.7.0.1
 */