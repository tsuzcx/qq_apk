import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;

public class byx
  extends Handler
{
  public byx(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (BusinessCmrTmpChatPie.a(this.a).isShown()) {
      BusinessCmrTmpChatPie.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byx
 * JD-Core Version:    0.7.0.1
 */