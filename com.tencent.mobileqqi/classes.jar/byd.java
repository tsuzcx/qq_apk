import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.widget.UpScrollHideView.onViewHideListener;

public class byd
  implements UpScrollHideView.onViewHideListener
{
  public byd(ChatActivity paramChatActivity) {}
  
  public void a()
  {
    if (ChatActivity.c(this.a))
    {
      TroopAssistantManager.a().a(this.a.b, this.a.a.a);
      ChatActivity.c(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byd
 * JD-Core Version:    0.7.0.1
 */