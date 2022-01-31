import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.open.agent.GroupListOpenFrame;
import com.tencent.open.agent.SocialFriendChooser;

public class hnk
  implements View.OnTouchListener
{
  public hnk(GroupListOpenFrame paramGroupListOpenFrame) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.a.g();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hnk
 * JD-Core Version:    0.7.0.1
 */