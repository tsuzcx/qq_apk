import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class eyv
  implements View.OnTouchListener
{
  public eyv(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = new int[2];
      paramView.getLocationInWindow(paramMotionEvent);
      paramView.getLocationOnScreen(new int[2]);
      arrayOfInt = new int[2];
      VoipDialInterfaceActivity.a(this.a).getLocationInWindow(arrayOfInt);
      VoipDialInterfaceActivity.b(this.a).offsetTopAndBottom(paramMotionEvent[1] - arrayOfInt[1] + paramView.getHeight() / 2 - VoipDialInterfaceActivity.b(this.a).getHeight() / 2);
      VoipDialInterfaceActivity.b(this.a).offsetLeftAndRight(paramMotionEvent[0] + paramView.getWidth() / 2 - VoipDialInterfaceActivity.b(this.a).getWidth() / 2);
      VoipDialInterfaceActivity.b(this.a).setVisibility(0);
    }
    while (paramMotionEvent.getAction() != 1) {
      return false;
    }
    paramMotionEvent = new int[2];
    paramView.getLocationInWindow(paramMotionEvent);
    int[] arrayOfInt = new int[2];
    VoipDialInterfaceActivity.a(this.a).getLocationInWindow(arrayOfInt);
    VoipDialInterfaceActivity.b(this.a).offsetTopAndBottom(-(paramMotionEvent[1] - arrayOfInt[1] + paramView.getHeight() / 2 - VoipDialInterfaceActivity.b(this.a).getHeight() / 2));
    VoipDialInterfaceActivity.b(this.a).offsetLeftAndRight(-(paramMotionEvent[0] + paramView.getWidth() / 2 - VoipDialInterfaceActivity.b(this.a).getWidth() / 2));
    VoipDialInterfaceActivity.b(this.a).setVisibility(4);
    VoipDialInterfaceActivity.a(this.a).invalidate();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eyv
 * JD-Core Version:    0.7.0.1
 */