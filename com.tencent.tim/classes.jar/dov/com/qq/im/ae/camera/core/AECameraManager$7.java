package dov.com.qq.im.ae.camera.core;

import aasq;
import android.graphics.Rect;
import anhk;
import anim;
import awwa;
import awwb;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.a;
import java.io.File;

public class AECameraManager$7
  implements Runnable
{
  public AECameraManager$7(awwa paramawwa, File paramFile, aasq paramaasq, CameraCover.a parama, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.aNZ())
    {
      awwa.a(this.this$0).a(new anhk(true), new awwb(this));
      return;
    }
    awwa.a(this.this$0).a(this.aJ, new Rect(0, 0, this.a.mWidth, this.a.mHeight), this.d, this.dzp, this.cAO, 1, awwa.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.7
 * JD-Core Version:    0.7.0.1
 */