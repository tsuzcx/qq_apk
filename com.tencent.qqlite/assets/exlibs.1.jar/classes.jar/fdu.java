import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.open.agent.GroupListOpenFrame;
import com.tencent.open.agent.SocialFriendChooser;

public class fdu
  implements View.OnTouchListener
{
  public fdu(GroupListOpenFrame paramGroupListOpenFrame) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.a.e();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fdu
 * JD-Core Version:    0.7.0.1
 */