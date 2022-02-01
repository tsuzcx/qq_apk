import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout.a;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class alxn
  extends Handler
{
  public alxn(CameraCaptureButtonLayout paramCameraCaptureButtonLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.a.dE.get());
    }
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            CameraCaptureButtonLayout.c(this.a);
            return;
          } while (CameraCaptureButtonLayout.a(this.a) == null);
          CameraCaptureButtonLayout.a(this.a).coA();
          return;
        } while (!this.a.dE.get());
        if (CameraCaptureButtonLayout.a(this.a) != null) {
          CameraCaptureButtonLayout.a(this.a).coB();
        }
        this.a.dE.set(false);
        CameraCaptureButtonLayout.d(this.a);
        return;
        if (CameraCaptureButtonLayout.a(this.a) != null) {
          CameraCaptureButtonLayout.a(this.a).dKK();
        }
        CameraCaptureButtonLayout.d(this.a);
        return;
      } while (!this.a.dE.get());
      CameraCaptureButtonLayout.e(this.a);
      CameraCaptureButtonLayout.a(this.a).sendEmptyMessageDelayed(5, 50L);
      return;
    }
    this.a.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxn
 * JD-Core Version:    0.7.0.1
 */