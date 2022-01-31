import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class euv
  implements View.OnTouchListener
{
  public euv(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = new int[2];
      VoipDialInterfaceActivity.a(this.a).getLocationInWindow(paramView);
      paramMotionEvent = new int[2];
      VoipDialInterfaceActivity.a(this.a).getLocationOnScreen(paramMotionEvent);
      paramMotionEvent = new int[2];
      VoipDialInterfaceActivity.c(this.a).getLocationInWindow(paramMotionEvent);
      VoipDialInterfaceActivity.d(this.a).offsetTopAndBottom(paramView[1] - paramMotionEvent[1] + VoipDialInterfaceActivity.a(this.a).getHeight() / 2 - VoipDialInterfaceActivity.d(this.a).getHeight() / 2);
      VoipDialInterfaceActivity.d(this.a).offsetLeftAndRight(paramView[0] + VoipDialInterfaceActivity.a(this.a).getWidth() / 2 - VoipDialInterfaceActivity.d(this.a).getWidth() / 2);
      VoipDialInterfaceActivity.d(this.a).setVisibility(0);
    }
    while (paramMotionEvent.getAction() != 1) {
      return false;
    }
    paramView = new int[2];
    VoipDialInterfaceActivity.a(this.a).getLocationInWindow(paramView);
    paramMotionEvent = new int[2];
    VoipDialInterfaceActivity.c(this.a).getLocationInWindow(paramMotionEvent);
    VoipDialInterfaceActivity.d(this.a).offsetTopAndBottom(-(paramView[1] - paramMotionEvent[1] + VoipDialInterfaceActivity.a(this.a).getHeight() / 2 - VoipDialInterfaceActivity.d(this.a).getHeight() / 2));
    VoipDialInterfaceActivity.d(this.a).offsetLeftAndRight(-(paramView[0] + VoipDialInterfaceActivity.a(this.a).getWidth() / 2 - VoipDialInterfaceActivity.d(this.a).getWidth() / 2));
    VoipDialInterfaceActivity.d(this.a).setVisibility(4);
    VoipDialInterfaceActivity.c(this.a).invalidate();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     euv
 * JD-Core Version:    0.7.0.1
 */