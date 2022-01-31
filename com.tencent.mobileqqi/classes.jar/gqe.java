import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;

public class gqe
  extends Handler
{
  public gqe(GroupSystemMsgController paramGroupSystemMsgController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((GroupSystemMsgController.a(this.a)) && (GroupSystemMsgController.a(this.a) != null))
    {
      GroupSystemMsgController.a(this.a, false);
      GroupSystemMsgController.a(this.a).a().a(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gqe
 * JD-Core Version:    0.7.0.1
 */