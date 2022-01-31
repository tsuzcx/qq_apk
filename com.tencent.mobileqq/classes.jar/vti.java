import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class vti
  implements View.OnClickListener
{
  public vti(FriendChatPie paramFriendChatPie) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendChatPie", 2, "mQimStatusOnClickListener.onClick: invoked. info: v = " + paramView);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80087E6");
    QIMUserManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vti
 * JD-Core Version:    0.7.0.1
 */