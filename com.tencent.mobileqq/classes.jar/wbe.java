import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.StringUtil;

public class wbe
  implements Runnable
{
  public wbe(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    try
    {
      Card localCard = ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (localCard == null)
      {
        if (StringUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
          ((CardHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (byte)1, 0);
        }
      }
      else if ((localCard != null) && (localCard.strCertificationInfo != null) && (!localCard.strCertificationInfo.equals("")))
      {
        ChatActivityFacade.f(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbe
 * JD-Core Version:    0.7.0.1
 */