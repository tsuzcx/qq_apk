import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.mobileqq.widget.CameraFrameLayout;
import com.tencent.mobileqq.widget.CameraFrameLayoutProxy;
import com.tencent.mobileqq.widget.CameraFrameLayoutProxy.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;

public class hjw
  extends CameraFrameLayoutProxy.OnDoubleClick
{
  public hjw(CameraFrameLayoutProxy paramCameraFrameLayoutProxy)
  {
    super(paramCameraFrameLayoutProxy);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (QQAppInterface)((BaseActivity)CameraFrameLayoutProxy.a(this.a)).getAppRuntime();
    if (!CameraUtil.a(paramMotionEvent, CameraFrameLayoutProxy.a(this.a))) {}
    while ((!CameraUtil.b(paramMotionEvent)) || ((CameraFrameLayoutProxy.a(this.a) != null) && (!CameraFrameLayoutProxy.a(this.a).a()))) {
      return false;
    }
    boolean bool = CameraUtil.a(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("CameraFrameLayoutProxy", 2, "onDoubleTap isOpen:" + bool);
    }
    if (bool)
    {
      ReportController.b(paramMotionEvent, "CliOper", "", "", "background", "bkground_shut", 0, 0, "0", "", "", "");
      CameraUtil.b(paramMotionEvent);
      return false;
    }
    ReportController.b(paramMotionEvent, "CliOper", "", "", "background", "bkground_open", 0, 0, "", "", "", "");
    CameraUtil.a(paramMotionEvent);
    CameraFrameLayoutProxy.a(this.a).setDoubleClickFlag(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hjw
 * JD-Core Version:    0.7.0.1
 */