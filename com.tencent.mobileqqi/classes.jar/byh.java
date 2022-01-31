import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class byh
  implements Runnable
{
  public byh(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    Object localObject2 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    int i = ((List)localObject2).size();
    Object localObject1;
    if ((localObject2 != null) && (i > 0))
    {
      localObject1 = (ChatMessage)((List)localObject2).get(i - 1);
      if (localObject1 != null)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
          break label244;
        }
        this.a.jdField_a_of_type_Long = ((ChatMessage)localObject1).time;
        this.a.jdField_b_of_type_Long = ((ChatMessage)localObject1).uniseq;
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + this.a.c);
      }
      localObject1 = QQOperateManager.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject2 = ((QQOperateManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject2, true, this.a.c);
      if (((QQOperationRequestInfo)localObject2).jdField_a_of_type_Boolean)
      {
        localObject2 = ((QQOperationRequestInfo)localObject2).jdField_a_of_type_JavaUtilArrayList;
        ((QQOperateManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (ArrayList)localObject2, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.a.c = -1;
      return;
      label244:
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        this.a.jdField_a_of_type_Long = ((ChatMessage)localObject1).shmsgseq;
        this.a.jdField_b_of_type_Long = ((ChatMessage)localObject1).uniseq;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byh
 * JD-Core Version:    0.7.0.1
 */