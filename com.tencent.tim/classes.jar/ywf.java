import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import mqq.os.MqqHandler;

public class ywf
  implements View.OnTouchListener
{
  protected float qQ;
  protected float qR;
  
  public ywf(NotificationView paramNotificationView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (this.this$0.h(paramMotionEvent.getRawY()))
      {
        this.qQ = paramMotionEvent.getRawX();
        this.qR = paramMotionEvent.getRawY();
        this.this$0.g.removeMessages(1013);
        this.this$0.g.sendEmptyMessageDelayed(1013, 500L);
      }
    }
    for (;;)
    {
      return false;
      this.this$0.g.removeMessages(1013);
      continue;
      if (paramMotionEvent.getAction() == 2)
      {
        if ((Math.abs(paramMotionEvent.getRawX() - this.qQ) > 60.0F) || (Math.abs(paramMotionEvent.getRawY() - this.qR) > 60.0F)) {
          this.this$0.g.removeMessages(1013);
        }
      }
      else {
        this.this$0.g.removeMessages(1013);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywf
 * JD-Core Version:    0.7.0.1
 */