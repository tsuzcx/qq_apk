import android.os.Handler;
import com.tencent.mobileqq.activity.ChatActivity;

public class cez
  implements Runnable
{
  public cez(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    ChatActivity.a(this.a);
    this.a.a.postDelayed(new cfa(this), 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cez
 * JD-Core Version:    0.7.0.1
 */