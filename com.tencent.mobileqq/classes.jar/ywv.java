import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class ywv
  implements Runnable
{
  public ywv(ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (QQMessageFacade)((AppRuntime)localObject).getManager(19);
      if (localObject != null) {
        ((QQMessageFacade)localObject).a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywv
 * JD-Core Version:    0.7.0.1
 */