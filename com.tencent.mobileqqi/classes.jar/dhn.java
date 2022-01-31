import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.widget.XEditTextEx;

public class dhn
  implements View.OnTouchListener
{
  public dhn(QQLSActivity paramQQLSActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QQLSActivity.a(this.a).setCursorVisible(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhn
 * JD-Core Version:    0.7.0.1
 */