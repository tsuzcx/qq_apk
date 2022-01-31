import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;

public class vqz
  extends Handler
{
  public vqz(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.p.isShown()) {
      this.a.p.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqz
 * JD-Core Version:    0.7.0.1
 */