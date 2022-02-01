package dov.com.qq.im.ptv;

import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import aqju;
import ayan;
import aycb;
import com.tencent.qphone.base.util.QLog;

public class LightWeightCameraCaptureUnit$2
  implements Runnable
{
  public LightWeightCameraCaptureUnit$2(ayan paramayan, String paramString) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.a.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    try
    {
      ayan.a(this.this$0);
      if (!ayan.a(this.this$0).isShowing())
      {
        ayan.a(this.this$0).setCancelable(false);
        ayan.a(this.this$0).show();
      }
      QLog.e("LightWeightCameraCaptureUnit", 2, "onCameraStarted error = " + this.val$errorMsg);
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LightWeightCameraCaptureUnit", 2, "", localBadTokenException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */