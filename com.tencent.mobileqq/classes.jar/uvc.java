import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.Callback;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder;
import com.tencent.mobileqq.data.MessageForArkFlashChat;

public class uvc
  implements ArkAppView.Callback
{
  public uvc(ArkFlashChatItemBubbleBuilder paramArkFlashChatItemBubbleBuilder, MessageForArkFlashChat paramMessageForArkFlashChat) {}
  
  public void a()
  {
    ArkDispatchTask.getInstance().post(new uvd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvc
 * JD-Core Version:    0.7.0.1
 */