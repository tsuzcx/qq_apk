import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class yqv
  implements Runnable
{
  public yqv(ApolloManager paramApolloManager, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a != null)) {
        ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "C2CAIO");
      }
      for (;;)
      {
        ApolloMsgPlayController.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a != null)) {
          ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a.getManager(152)).f();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloManager", 2, "doAfterOpenAIO error", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqv
 * JD-Core Version:    0.7.0.1
 */