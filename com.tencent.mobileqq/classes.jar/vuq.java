import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;

public class vuq
  implements Runnable
{
  public vuq(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    ConfigServlet.a(this.a.a, this.a.a.getAccount(), -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuq
 * JD-Core Version:    0.7.0.1
 */