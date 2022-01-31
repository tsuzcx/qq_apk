import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;

public class cdu
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private float b;
  
  public cdu(SystemMsgListView paramSystemMsgListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(paramMotionEvent.getRawY()))
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
        this.b = paramMotionEvent.getRawY();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a.removeMessages(1013);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a.sendEmptyMessageDelayed(1013, 500L);
      }
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a.removeMessages(1013);
      continue;
      if (paramMotionEvent.getAction() == 2)
      {
        if ((Math.abs(paramMotionEvent.getRawX() - this.jdField_a_of_type_Float) > 60.0F) || (Math.abs(paramMotionEvent.getRawY() - this.b) > 60.0F)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a.removeMessages(1013);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a.removeMessages(1013);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cdu
 * JD-Core Version:    0.7.0.1
 */