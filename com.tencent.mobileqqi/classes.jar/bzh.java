import android.os.Handler;
import com.tencent.mobileqq.activity.ChatActivity;

public class bzh
  implements Runnable
{
  public bzh(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    ChatActivity.a(this.a);
    this.a.a.postDelayed(new bzi(this), 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzh
 * JD-Core Version:    0.7.0.1
 */