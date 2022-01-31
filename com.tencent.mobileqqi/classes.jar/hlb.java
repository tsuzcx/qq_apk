import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.widget.MicroPhoneDialog;
import com.tencent.qphone.base.util.QLog;

public class hlb
  implements View.OnTouchListener
{
  public hlb(MicroPhoneDialog paramMicroPhoneDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.MicroPhone", 2, "enableRotate true, refuse onTouch..");
      }
      return true;
    }
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      MicroPhoneDialog.d(this.a);
      return true;
    }
    if ((i == 3) || (i == 1))
    {
      this.a.g();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hlb
 * JD-Core Version:    0.7.0.1
 */