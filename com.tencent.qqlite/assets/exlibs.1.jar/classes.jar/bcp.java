import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

public class bcp
  implements View.OnTouchListener
{
  public bcp(QQLSActivity paramQQLSActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
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
        QQLSActivity.a(this.a, MotionEvent.obtain(paramMotionEvent));
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "singlelist  click once");
      }
      if (QQLSActivity.a(this.a)) {
        QQLSActivity.b(this.a).setText(2131364420);
      }
      for (;;)
      {
        paramView = QQLSActivity.a(this.a).obtainMessage(5);
        QQLSActivity.a(this.a).sendMessageDelayed(paramView, 500L);
        break;
        QQLSActivity.b(this.a).setText(2131364419);
      }
      if (paramMotionEvent.getAction() == 1) {
        QQLSActivity.b(this.a, MotionEvent.obtain(paramMotionEvent));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcp
 * JD-Core Version:    0.7.0.1
 */