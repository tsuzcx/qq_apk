import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.widget.PopupMenuDialog;

public class ubo
  implements View.OnTouchListener
{
  public ubo(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ubo
 * JD-Core Version:    0.7.0.1
 */