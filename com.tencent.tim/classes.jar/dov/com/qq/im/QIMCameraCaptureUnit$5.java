package dov.com.qq.im;

import awrq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class QIMCameraCaptureUnit$5
  implements Runnable
{
  public QIMCameraCaptureUnit$5(awrq paramawrq) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), this.this$0.cSo, 0).show();
    if (this.this$0.cAD) {
      this.this$0.eFk();
    }
    if (this.this$0.eCw == 5) {
      this.this$0.a.setVisibility(0);
    }
    for (;;)
    {
      this.this$0.eFm();
      return;
      this.this$0.cox();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.5
 * JD-Core Version:    0.7.0.1
 */