import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class aal
  implements Runnable
{
  public aal(BaseChatPie paramBaseChatPie, FrameLayout paramFrameLayout) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "hor anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aal
 * JD-Core Version:    0.7.0.1
 */