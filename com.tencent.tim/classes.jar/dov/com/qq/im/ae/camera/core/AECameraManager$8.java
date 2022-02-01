package dov.com.qq.im.ae.camera.core;

import alwy;
import anhk;
import anim;
import awwa;
import awwc;

public class AECameraManager$8
  implements Runnable
{
  public AECameraManager$8(awwa paramawwa, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (awwa.a(this.this$0) == null) {
      return;
    }
    anhk localanhk = new anhk();
    localanhk.x = this.val$x;
    localanhk.y = this.val$y;
    localanhk.screenWidth = this.cFz;
    localanhk.dGb = this.cFA;
    localanhk.c = awwa.a(this.this$0);
    localanhk.mOrientation = alwy.iP(awwa.b(this.this$0));
    awwa.a(this.this$0).a(localanhk, new awwc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.8
 * JD-Core Version:    0.7.0.1
 */