import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;

public class afve
  implements View.OnTouchListener
{
  public afve(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      ExtendFriendProfileEditFragment.a(this.this$0).setVisibility(0);
    }
    while ((i != 1) && (i != 3)) {
      return false;
    }
    ExtendFriendProfileEditFragment.a(this.this$0).setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afve
 * JD-Core Version:    0.7.0.1
 */