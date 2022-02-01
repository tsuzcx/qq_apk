import android.os.Bundle;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class arse
  implements asbh.a
{
  public arse(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void J(String paramString, Bundle paramBundle)
  {
    QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket onFail");
    if (OpenSelectPermissionFragment.b(this.this$0))
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket onFail Activity Finishing");
      return;
    }
    OpenSelectPermissionFragment.a(this.this$0);
  }
  
  public void a(asav paramasav)
  {
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success info.uin=" + artw.qx(paramasav.uin));
    if (OpenSelectPermissionFragment.b(this.this$0))
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success Activity Finishing");
      return;
    }
    OpenSelectPermissionFragment.a(this.this$0).a().b(OpenSelectPermissionFragment.a(this.this$0), paramasav);
    OpenSelectPermissionFragment.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arse
 * JD-Core Version:    0.7.0.1
 */