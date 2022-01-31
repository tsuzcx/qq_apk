import android.os.Handler;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.systemmsg.SystemMsgController;

public class aaf
  implements Runnable
{
  public aaf(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    BaseChatPie.a(this.a, this.a.c());
    BaseChatPie.c(this.a, BaseChatPie.b(this.a));
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711689, 300000L);
    if (BaseChatPie.b(this.a)) {
      ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      try
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
          SystemMsgController.a().a(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null))
        {
          return;
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long != -1L) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
        }
        SystemMsgController.a().a(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aaf
 * JD-Core Version:    0.7.0.1
 */