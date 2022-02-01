import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.TeamWorkFileExportHandler.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.manager.TicketManager;

public class aoam
  extends accg
  implements Handler.Callback
{
  private String[] hg = { "docs.qq.com" };
  
  public aoam(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void am(Runnable paramRunnable)
  {
    if (this.app == null) {}
    while (((TicketManager)this.app.getManager(2)).GetPskey(this.app.getCurrentAccountUin(), 16L, this.hg, new aoan(this, paramRunnable)) == null) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void P(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    am(new TeamWorkFileExportHandler.1(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aoak.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoam
 * JD-Core Version:    0.7.0.1
 */