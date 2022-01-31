import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class evr
  implements View.OnTouchListener
{
  public evr(SelectMemberActivity paramSelectMemberActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a.g();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evr
 * JD-Core Version:    0.7.0.1
 */