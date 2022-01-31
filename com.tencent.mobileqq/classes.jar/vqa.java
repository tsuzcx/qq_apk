import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;

public class vqa
  implements Runnable
{
  public vqa(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    if (!MsgProxyUtils.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).e(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
    do
    {
      return;
      FriendChatPie.a(this.a, SystemClock.uptimeMillis());
      ((ChatContext)FriendChatPie.a(this.a).a).a(FriendChatPie.b(this.a));
      FriendChatPie.b(this.a).e = false;
      FriendChatPie.c(this.a).f = true;
    } while (FriendChatPie.d(this.a).c != 0);
    QQMessageFacade.RefreshMessageContext localRefreshMessageContext = FriendChatPie.e(this.a);
    localRefreshMessageContext.c += 1;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, FriendChatPie.f(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqa
 * JD-Core Version:    0.7.0.1
 */