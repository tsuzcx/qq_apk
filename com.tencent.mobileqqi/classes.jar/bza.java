import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.qphone.base.util.QLog;

public class bza
  implements Runnable
{
  public bza(ChatActivity paramChatActivity, FrameLayout paramFrameLayout) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "hor anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bza
 * JD-Core Version:    0.7.0.1
 */