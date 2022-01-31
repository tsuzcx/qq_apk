import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class zgo
  implements Runnable
{
  public zgo(ChatApolloViewListener paramChatApolloViewListener) {}
  
  public void run()
  {
    if (this.a.a == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.a.a.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    ((SpriteScriptManager)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zgo
 * JD-Core Version:    0.7.0.1
 */