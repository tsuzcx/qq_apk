import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;

public class byj
  implements Runnable
{
  public byj(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    TroopNotificationHelper.a(this.a.b, this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byj
 * JD-Core Version:    0.7.0.1
 */