import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;

public class bxm
  implements Runnable
{
  public bxm(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    if (ChatActivity.a(this.a).e)
    {
      if (ChatActivity.a(this.a).g)
      {
        this.a.a(131078);
        return;
      }
      this.a.a(131077);
      return;
    }
    this.a.a(131075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxm
 * JD-Core Version:    0.7.0.1
 */