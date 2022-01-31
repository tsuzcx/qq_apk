import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.mobileqq.widget.CameraFrameLayout;
import com.tencent.mobileqq.widget.CameraFrameLayoutProxy;
import com.tencent.mobileqq.widget.CameraFrameLayoutProxy.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;
import mqq.app.permission.PermissionManager;

public class hfp
  extends CameraFrameLayoutProxy.OnDoubleClick
{
  public hfp(CameraFrameLayoutProxy paramCameraFrameLayoutProxy)
  {
    super(paramCameraFrameLayoutProxy);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (BaseActivity)CameraFrameLayoutProxy.a(this.a);
    Object localObject = (QQAppInterface)paramMotionEvent.getAppRuntime();
    if (!paramMotionEvent.permissionManager.checkPermission("android.permission.CAMERA"))
    {
      localObject = new PermissionsDialog();
      localhfq = new hfq(this, paramMotionEvent);
      ((PermissionsDialog)localObject).a(paramMotionEvent, new String[] { "android.permission.CAMERA" }, localhfq);
    }
    while ((!CameraUtil.a((QQAppInterface)localObject, CameraFrameLayoutProxy.a(this.a))) || (!CameraUtil.b((QQAppInterface)localObject)) || ((CameraFrameLayoutProxy.a(this.a) != null) && (!CameraFrameLayoutProxy.a(this.a).a())))
    {
      hfq localhfq;
      return false;
    }
    boolean bool = CameraUtil.a((QQAppInterface)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("CameraFrameLayoutProxy", 2, "onDoubleTap isOpen:" + bool);
    }
    if (bool)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "background", "bkground_shut", 0, 0, "0", "", "", "");
      CameraUtil.b((QQAppInterface)localObject);
      return false;
    }
    ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "background", "bkground_open", 0, 0, "", "", "", "");
    CameraUtil.a((QQAppInterface)localObject);
    CameraFrameLayoutProxy.a(this.a).setDoubleClickFlag(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfp
 * JD-Core Version:    0.7.0.1
 */