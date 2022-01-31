import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.qphone.base.util.QLog;

public class vyk
  implements Runnable
{
  public vyk(PublicAccountChatPie paramPublicAccountChatPie, FrameLayout paramFrameLayout) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "hor anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.p != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.p.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.p = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyk
 * JD-Core Version:    0.7.0.1
 */