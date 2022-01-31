import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class vrn
  implements Runnable
{
  public vrn(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    ((HotChatHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrn
 * JD-Core Version:    0.7.0.1
 */