import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class arok
  implements asbh.a
{
  public arok(AgentActivity paramAgentActivity, String paramString1, Bundle paramBundle, String paramString2, long paramLong, int paramInt) {}
  
  public void J(String paramString, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, "--> getTicketNoPasswd onFail");
    ahlw.N("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
    AgentActivity.a(this.this$0, this.cBm, this.val$bundle, this.val$appid, false);
  }
  
  public void a(asav paramasav)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " getTicketNoPasswd onSuccess", Long.valueOf(System.currentTimeMillis() - this.awe) });
    ahlw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramasav);
    this.this$0.a.a().b(this.val$appid, paramasav);
    AgentActivity.b(this.this$0, this.cBm, this.val$bundle, this.val$appid, false);
    long l1 = ForwardUtils.parseLong(this.val$appid);
    long l2 = ForwardUtils.parseLong(this.val$bundle.getString("key_proxy_appid"));
    preAuth.PreAuthRequest localPreAuthRequest = this.this$0.a.a().a(paramasav, AgentActivity.a(this.this$0), l1, l2, this.val$bundle);
    this.this$0.a.a().a(localPreAuthRequest, this.this$0, paramasav, new arol(this), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     arok
 * JD-Core Version:    0.7.0.1
 */