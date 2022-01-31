import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class vqf
  implements Runnable
{
  public vqf(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    AVNotifyCenter localAVNotifyCenter = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
        try
        {
          long l = Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          if (localAVNotifyCenter.a(l))
          {
            this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, localAVNotifyCenter.a(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue()));
            localAVNotifyCenter.a(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), false, -1);
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqf
 * JD-Core Version:    0.7.0.1
 */