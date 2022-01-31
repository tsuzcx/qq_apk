import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewPresenter.onMonitorUserOperationListener;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy;
import com.tencent.qphone.base.util.QLog;

public class zyn
  implements View.OnTouchListener
{
  public zyn(ARVideoRecordViewProxy paramARVideoRecordViewProxy) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return true;
        ARVideoRecordViewProxy.a(this.a).setAlpha(0.5F);
        return true;
        ARVideoRecordViewProxy.a(this.a).setAlpha(1.0F);
        if (!ARVideoRecordViewProxy.a(this.a))
        {
          ARRecordUtils.a(true);
          ARVideoRecordViewProxy.a(this.a, true);
          ARVideoRecordViewProxy.a(this.a).setVisibility(8);
          ARVideoRecordViewProxy.a(this.a).clearAnimation();
        }
      } while (ARVideoRecordViewProxy.a(this.a) == null);
      ARVideoRecordViewProxy.a(this.a).h();
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "onMonitorUserOperation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyn
 * JD-Core Version:    0.7.0.1
 */