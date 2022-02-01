package dov.com.qq.im.ae.camera.core;

import awwa;
import awwa.b;
import axiy;

public class AECameraManager$4
  implements Runnable
{
  public AECameraManager$4(awwa paramawwa, int paramInt, awwa.b paramb) {}
  
  public void run()
  {
    axiy.i("AECameraManager", "[cameraManagerHandler] changeCamera " + this.eDn);
    if ((this.eDn != 2) && (this.eDn != 1))
    {
      axiy.e("AECameraManager", "[cameraManagerHandler] changeCamera invalid camera: " + this.eDn);
      this.b.cv(awwa.a(this.this$0), awwa.a(this.this$0));
      return;
    }
    if ((awwa.a(this.this$0) != this.eDn) && (awwa.a(this.this$0)))
    {
      axiy.i("AECameraManager", "[cameraManagerHandler] changeCamera, firstly close last camera: " + awwa.a(this.this$0));
      awwa.a(this.this$0, false);
    }
    awwa.a(this.this$0, this.eDn);
    awwa.a(this.this$0, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */