import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class wdm
  implements Runnable
{
  public wdm(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdm
 * JD-Core Version:    0.7.0.1
 */