import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;

public class bch
  extends Client.onRemoteRespObserver
{
  public bch(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void onBindedToClient()
  {
    QQBrowserActivity.a(this.a);
    WebIPCOperator.getInstance().unRegisterObserver(this);
    QQBrowserActivity.a(this.a, null);
  }
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bch
 * JD-Core Version:    0.7.0.1
 */