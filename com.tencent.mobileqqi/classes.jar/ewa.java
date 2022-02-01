import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class ewa
  implements View.OnTouchListener
{
  public ewa(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = new int[2];
      VoipDialInterfaceActivity.k(this.a).getLocationInWindow(paramView);
      paramMotionEvent = new int[2];
      VoipDialInterfaceActivity.k(this.a).getLocationOnScreen(paramMotionEvent);
      paramMotionEvent = new int[2];
      VoipDialInterfaceActivity.c(this.a).getLocationInWindow(paramMotionEvent);
      VoipDialInterfaceActivity.n(this.a).offsetTopAndBottom(paramView[1] - paramMotionEvent[1] + VoipDialInterfaceActivity.k(this.a).getHeight() / 2 - VoipDialInterfaceActivity.n(this.a).getHeight() / 2);
      VoipDialInterfaceActivity.n(this.a).offsetLeftAndRight(paramView[0] + VoipDialInterfaceActivity.k(this.a).getWidth() / 2 - VoipDialInterfaceActivity.n(this.a).getWidth() / 2);
      VoipDialInterfaceActivity.n(this.a).setVisibility(0);
    }
    while (paramMotionEvent.getAction() != 1) {
      return false;
    }
    paramView = new int[2];
    VoipDialInterfaceActivity.k(this.a).getLocationInWindow(paramView);
    paramMotionEvent = new int[2];
    VoipDialInterfaceActivity.c(this.a).getLocationInWindow(paramMotionEvent);
    VoipDialInterfaceActivity.n(this.a).offsetTopAndBottom(-(paramView[1] - paramMotionEvent[1] + VoipDialInterfaceActivity.k(this.a).getHeight() / 2 - VoipDialInterfaceActivity.n(this.a).getHeight() / 2));
    VoipDialInterfaceActivity.n(this.a).offsetLeftAndRight(-(paramView[0] + VoipDialInterfaceActivity.k(this.a).getWidth() / 2 - VoipDialInterfaceActivity.n(this.a).getWidth() / 2));
    VoipDialInterfaceActivity.n(this.a).setVisibility(4);
    VoipDialInterfaceActivity.c(this.a).invalidate();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewa
 * JD-Core Version:    0.7.0.1
 */