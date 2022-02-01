package dov.com.qq.im;

import android.app.Activity;
import android.graphics.Bitmap;
import aqhu;
import aqnm;
import awrq;
import awry;
import aycb;

public class QIMCameraCaptureUnit$1
  implements Runnable
{
  public QIMCameraCaptureUnit$1(awrq paramawrq) {}
  
  public void run()
  {
    try
    {
      this.this$0.er = awry.a(this.this$0.a.getActivity(), true);
      if ((this.this$0.er != null) && (!this.this$0.er.isRecycled())) {
        this.this$0.er = aqhu.c(this.this$0.er, aqnm.dip2px(3.0F), this.this$0.er.getWidth(), this.this$0.er.getHeight());
      }
      this.this$0.a.getActivity().runOnUiThread(new QIMCameraCaptureUnit.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */