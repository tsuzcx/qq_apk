import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;

public class afuj
  implements View.OnTouchListener
{
  public afuj(ExtendFriendCampusFragment paramExtendFriendCampusFragment, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.eB.setAlpha(0.5F);
      this.eB.postInvalidate();
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.eB.setAlpha(1.0F);
        this.eB.postInvalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afuj
 * JD-Core Version:    0.7.0.1
 */