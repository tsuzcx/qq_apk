import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class alkj
  implements View.OnTouchListener
{
  public alkj(QCallDetailActivity paramQCallDetailActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      QCallDetailActivity.a(this.this$0).setPressed(true);
    }
    while (1 != paramMotionEvent.getAction()) {
      return false;
    }
    QCallDetailActivity.a(this.this$0).setPressed(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkj
 * JD-Core Version:    0.7.0.1
 */