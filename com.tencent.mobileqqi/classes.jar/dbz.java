import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

public class dbz
  implements View.OnTouchListener
{
  public dbz(QQLSActivity paramQQLSActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (Build.VERSION.SDK_INT < 16) {
        if (QQLSActivity.a(this.a) != null) {
          QQLSActivity.a(this.a, QQLSActivity.a(this.a));
        }
      }
    }
    while (paramMotionEvent.getAction() != 1)
    {
      return false;
      if ((QQLSActivity.a(this.a) != null) && (QQLSActivity.b(this.a) != null) && (QQLSActivity.a(this.a, QQLSActivity.b(this.a), QQLSActivity.a(this.a), paramMotionEvent)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "singlelist  click doble");
        }
        if (QQLSActivity.a(this.a) != null)
        {
          QQLSActivity.a(this.a, QQLSActivity.a(this.a));
          QQLSActivity.a(this.a, true);
        }
      }
      for (;;)
      {
        QQLSActivity.a(this.a, MotionEvent.obtain(paramMotionEvent));
        return false;
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, "singlelist  click once");
        }
        paramView = QQLSActivity.a(this.a).obtainMessage(0);
        QQLSActivity.a(this.a).sendMessageDelayed(paramView, 500L);
      }
    }
    QQLSActivity.b(this.a, MotionEvent.obtain(paramMotionEvent));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dbz
 * JD-Core Version:    0.7.0.1
 */