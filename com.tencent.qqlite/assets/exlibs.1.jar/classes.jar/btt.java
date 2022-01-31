import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;

public class btt
  implements Runnable
{
  public btt(ListenChangeVoicePanel paramListenChangeVoicePanel) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)ListenChangeVoicePanel.a(this.a).getManager(43);
    int i;
    if (!this.a.a.g())
    {
      localObject = ((FriendsManager)localObject).a(this.a.a.a.jdField_a_of_type_JavaLangString, this.a.a.a.jdField_a_of_type_Int, true);
      if (localObject == null) {
        break label141;
      }
      i = ((NoC2CExtensionInfo)localObject).pttChangeVoiceType;
    }
    for (;;)
    {
      if (i != -1)
      {
        ListenChangeVoicePanel.a(this.a, i);
        ListenChangeVoicePanel.b(this.a, i);
        ListenChangeVoicePanel.a(this.a)[ListenChangeVoicePanel.a(this.a)] = 1;
      }
      return;
      localObject = ((FriendsManager)localObject).a(this.a.a.a.jdField_a_of_type_JavaLangString, true);
      if (localObject != null) {
        i = ((ExtensionInfo)localObject).pttChangeVoiceType;
      } else {
        label141:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     btt
 * JD-Core Version:    0.7.0.1
 */