import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;

public class glt
  extends Handler
{
  public glt(FriendSystemMsgController paramFriendSystemMsgController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((FriendSystemMsgController.a(this.a)) && (FriendSystemMsgController.a(this.a) != null))
    {
      FriendSystemMsgController.a(this.a, false);
      FriendSystemMsgController.a(this.a).a().a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     glt
 * JD-Core Version:    0.7.0.1
 */