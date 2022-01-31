import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class vyp
  implements Runnable
{
  public vyp(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)((QQAppInterface)localObject).getManager(12);
      if ((localObject != null) && (((WebProcessManager)localObject).e())) {
        ((WebProcessManager)localObject).a(-1, new vyq(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyp
 * JD-Core Version:    0.7.0.1
 */