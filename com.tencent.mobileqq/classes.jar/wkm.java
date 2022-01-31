import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import mqq.os.MqqHandler;

public class wkm
  implements View.OnTouchListener
{
  protected float a;
  protected float b;
  
  public wkm(NotificationView paramNotificationView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a(paramMotionEvent.getRawY()))
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
        this.b = paramMotionEvent.getRawY();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.removeMessages(1013);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.sendEmptyMessageDelayed(1013, 500L);
      }
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.removeMessages(1013);
      continue;
      if (paramMotionEvent.getAction() == 2)
      {
        if ((Math.abs(paramMotionEvent.getRawX() - this.jdField_a_of_type_Float) > 60.0F) || (Math.abs(paramMotionEvent.getRawY() - this.b) > 60.0F)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.removeMessages(1013);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.removeMessages(1013);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wkm
 * JD-Core Version:    0.7.0.1
 */