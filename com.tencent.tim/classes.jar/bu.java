import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteActivity.9.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class bu
  implements View.OnTouchListener
{
  public bu(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LiteActivity.TAG, 2, "ontouch--fcc----: " + paramMotionEvent.getAction());
    }
    this.this$0.aX();
    LiteActivity.a(this.this$0, false);
    this.this$0.a.postDelayed(new LiteActivity.9.1(this), 200L);
    this.this$0.a.onTouch(paramView, paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bu
 * JD-Core Version:    0.7.0.1
 */