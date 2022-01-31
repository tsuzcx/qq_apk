import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class yng
  implements Runnable
{
  public yng(ChatPieApolloViewController paramChatPieApolloViewController, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (ApolloActionHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a) != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatPieApolloViewController", 2, "Apollo switch NOT open.");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().obtainMessage(62).sendToTarget();
      return;
    }
    ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().obtainMessage(65).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yng
 * JD-Core Version:    0.7.0.1
 */