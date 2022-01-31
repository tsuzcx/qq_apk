import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class wdn
  implements Runnable
{
  public wdn(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    TroopBarAssistantManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdn
 * JD-Core Version:    0.7.0.1
 */