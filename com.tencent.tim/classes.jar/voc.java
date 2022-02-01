import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

public class voc
  implements View.OnTouchListener
{
  public voc(QQLSActivity paramQQLSActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if ((QQLSActivity.a(this.this$0) != null) && (QQLSActivity.b(this.this$0) != null) && (QQLSActivity.a(this.this$0, QQLSActivity.b(this.this$0), QQLSActivity.a(this.this$0), paramMotionEvent)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "singlelist  click doble");
        }
        if (QQLSActivity.a(this.this$0) != null)
        {
          QQLSActivity.a(this.this$0, QQLSActivity.a(this.this$0));
          QQLSActivity.a(this.this$0, true);
        }
        QQLSActivity.a(this.this$0, MotionEvent.obtain(paramMotionEvent));
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "singlelist  click once");
      }
      if (QQLSActivity.a(this.this$0)) {
        QQLSActivity.b(this.this$0).setText(2131701311);
      }
      for (;;)
      {
        paramView = QQLSActivity.a(this.this$0).obtainMessage(5);
        QQLSActivity.a(this.this$0).sendMessageDelayed(paramView, 500L);
        break;
        QQLSActivity.b(this.this$0).setText(2131701310);
      }
      if (paramMotionEvent.getAction() == 1) {
        QQLSActivity.b(this.this$0, MotionEvent.obtain(paramMotionEvent));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     voc
 * JD-Core Version:    0.7.0.1
 */