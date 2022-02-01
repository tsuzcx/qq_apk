package dov.com.qq.im.ae;

import awtq;
import aycb;
import ayxa;

public class AEPituCameraUnit$6
  implements Runnable
{
  public AEPituCameraUnit$6(awtq paramawtq) {}
  
  public void run()
  {
    ayxa.resetAllLiuHaiStatus();
    ayxa.initLiuHaiProperty(awtq.a(this.this$0).getActivity());
    if (ayxa.needCloseFullScreen()) {
      ayxa.closeFullScreen(awtq.a(this.this$0).getActivity());
    }
    for (;;)
    {
      awtq.c(this.this$0);
      awtq.d(this.this$0);
      return;
      ayxa.resetFullScreen(awtq.a(this.this$0).getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.6
 * JD-Core Version:    0.7.0.1
 */