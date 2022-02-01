import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.proxy.ProxyObserver;

public class cbv
  extends ProxyObserver
{
  public cbv(ChatHistory paramChatHistory) {}
  
  public void b()
  {
    this.a.runOnUiThread(new cbw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbv
 * JD-Core Version:    0.7.0.1
 */