import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class cfq
  implements Runnable
{
  public cfq(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    this.a.b.a().d(true);
    ChatActivity.a(this.a, this.a.a.a, 0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfq
 * JD-Core Version:    0.7.0.1
 */