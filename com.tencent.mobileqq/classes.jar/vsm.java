import android.os.Message;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import java.util.List;
import mqq.os.MqqHandler;

public class vsm
  implements Runnable
{
  public vsm(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void run()
  {
    List localList = MultiMsgManager.a().a(this.a.a, this.a.h);
    Message localMessage = this.a.b.obtainMessage(0);
    localMessage.obj = localList;
    this.a.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsm
 * JD-Core Version:    0.7.0.1
 */