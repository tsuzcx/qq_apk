import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import java.util.concurrent.atomic.AtomicBoolean;

public class alxm
  implements View.OnTouchListener
{
  public alxm(CameraCaptureButtonLayout paramCameraCaptureButtonLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.a.dE.get() + ", actionUp:" + this.a.dF.get() + ", isOver:" + CameraCaptureButtonLayout.a(this.a));
    }
    this.a.dKJ();
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.a.wr, CameraCaptureButtonLayout.a(this.a));
    if (CameraCaptureButtonLayout.a(this.a)) {}
    do
    {
      return false;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        return false;
      }
    } while (CameraCaptureButtonLayout.b(this.a));
    if ((CameraCaptureButtonLayout.a(this.a) != null) && (!CameraCaptureButtonLayout.a(this.a).auP())) {
      return true;
    }
    this.a.reset();
    if ((CameraCaptureButtonLayout.a(this.a) == 3) || (CameraCaptureButtonLayout.a(this.a) == 1)) {
      CameraCaptureButtonLayout.a(this.a).sendEmptyMessageDelayed(1, 100L);
    }
    CameraCaptureButtonLayout.a(this.a, true);
    return true;
    CameraCaptureButtonLayout.b(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxm
 * JD-Core Version:    0.7.0.1
 */