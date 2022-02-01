package dov.com.qq.im;

import android.widget.Button;
import awrq;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;

public class QIMCameraCaptureUnit$11
  implements Runnable
{
  public QIMCameraCaptureUnit$11(awrq paramawrq, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.this$0.drq)
    {
      if (!this.cLy) {
        break label80;
      }
      if (!awrq.a(this.this$0))
      {
        if (awrq.b(this.this$0)) {
          this.this$0.hS.setVisibility(0);
        }
        this.this$0.hS.setSelected(true);
        this.this$0.b.Or(true);
        awrq.b(this.this$0, false);
      }
    }
    return;
    label80:
    this.this$0.hS.setVisibility(8);
    this.this$0.hS.setSelected(false);
    this.this$0.b.Or(false);
    awrq.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.11
 * JD-Core Version:    0.7.0.1
 */