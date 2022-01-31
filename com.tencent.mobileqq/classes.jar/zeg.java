import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class zeg
  implements Runnable
{
  public zeg(MessageRoamManager paramMessageRoamManager) {}
  
  public void run()
  {
    MqqHandler localMqqHandler = this.a.a.getHandler(ChatHistoryForC2C.class);
    if (MessageRoamManager.a(this.a)) {}
    for (Message localMessage = localMqqHandler.obtainMessage(19);; localMessage = localMqqHandler.obtainMessage(20))
    {
      localMqqHandler.sendMessage(localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zeg
 * JD-Core Version:    0.7.0.1
 */