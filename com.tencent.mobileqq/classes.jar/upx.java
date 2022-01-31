import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.ptt.PttVoiceChangePreSender;

public class upx
  implements Runnable
{
  public upx(ListenChangeVoicePanel paramListenChangeVoicePanel) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)ListenChangeVoicePanel.a(this.a).getManager(50);
    int i;
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m())
    {
      localObject = ((FriendsManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int, true);
      if (localObject == null) {
        break label142;
      }
      i = ((NoC2CExtensionInfo)localObject).pttChangeVoiceType;
    }
    for (;;)
    {
      if (i != -1)
      {
        ListenChangeVoicePanel.a(this.a, i);
        ListenChangeVoicePanel.a(this.a)[i] = 1;
      }
      if (ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender == null) {
        ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender = new PttVoiceChangePreSender();
      }
      return;
      localObject = ((FriendsManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, true);
      if (localObject != null) {
        i = ((ExtensionInfo)localObject).pttChangeVoiceType;
      } else {
        label142:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upx
 * JD-Core Version:    0.7.0.1
 */