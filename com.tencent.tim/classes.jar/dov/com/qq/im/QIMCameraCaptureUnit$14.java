package dov.com.qq.im;

import awrq;
import aycb;
import ayxa;

public class QIMCameraCaptureUnit$14
  implements Runnable
{
  public QIMCameraCaptureUnit$14(awrq paramawrq) {}
  
  public void run()
  {
    ayxa.resetAllLiuHaiStatus();
    ayxa.initLiuHaiProperty(this.this$0.a.getActivity());
    if (ayxa.needCloseFullScreen()) {
      ayxa.closeFullScreen(this.this$0.a.getActivity());
    }
    for (;;)
    {
      this.this$0.eFs();
      return;
      ayxa.resetFullScreen(this.this$0.a.getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.14
 * JD-Core Version:    0.7.0.1
 */