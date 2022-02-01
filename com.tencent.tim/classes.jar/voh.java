import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.widget.XEditTextEx;

public class voh
  implements View.OnTouchListener
{
  public voh(QQLSActivity paramQQLSActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QQLSActivity.a(this.this$0).setCursorVisible(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     voh
 * JD-Core Version:    0.7.0.1
 */