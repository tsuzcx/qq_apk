package dov.com.qq.im;

import awrq;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class QIMCameraCaptureUnit$8
  implements Runnable
{
  public QIMCameraCaptureUnit$8(awrq paramawrq, boolean paramBoolean1, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.drB)
    {
      this.this$0.b(this.this$0.c, this.val$info);
      if (!this.this$0.drt) {
        this.this$0.Xq(true);
      }
    }
    for (;;)
    {
      this.this$0.coy();
      if ((!this.drC) || (!this.this$0.drw)) {
        this.this$0.cox();
      }
      return;
      this.this$0.a.eNz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.8
 * JD-Core Version:    0.7.0.1
 */