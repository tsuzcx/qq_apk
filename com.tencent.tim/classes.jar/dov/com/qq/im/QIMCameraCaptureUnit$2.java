package dov.com.qq.im;

import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import aqju;
import awrq;
import aycb;
import com.tencent.qphone.base.util.QLog;

public class QIMCameraCaptureUnit$2
  implements Runnable
{
  public QIMCameraCaptureUnit$2(awrq paramawrq, String paramString) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.a.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    try
    {
      this.this$0.eFa();
      if (!awrq.a(this.this$0).isShowing())
      {
        awrq.a(this.this$0).setCancelable(false);
        awrq.a(this.this$0).show();
      }
      QLog.e("QIMCameraCaptureUnit", 2, "onCameraStarted error = " + this.val$errorMsg);
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMCameraCaptureUnit", 2, "", localBadTokenException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */