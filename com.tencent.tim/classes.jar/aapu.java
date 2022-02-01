import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

public class aapu
  implements View.OnTouchListener
{
  public aapu(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.this$0.bwW) {}
    while (((!this.this$0.bwR) && (!this.this$0.bwP)) || (paramView.getId() != 2131367247)) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "[@]onTouch ACTION_DOWN, event = " + paramMotionEvent);
      }
      if (!this.this$0.ff.isLongClickable()) {
        this.this$0.c.cyg();
      }
      this.this$0.ff.setText(null);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "[@]onTouch ACTION_UP, event = " + paramMotionEvent);
    }
    if (this.this$0.c != null) {
      this.this$0.c.Xf();
    }
    if (this.this$0.ff != null) {
      this.this$0.ff.setText(2131693781);
    }
    FlowCameraActivity2.a(this.this$0, SystemClock.uptimeMillis());
    FlowCameraActivity2.a(this.this$0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapu
 * JD-Core Version:    0.7.0.1
 */