import QQService.SvcDevLoginInfo;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity.10.1.1;
import com.tencent.mobileqq.activity.LoginInfoActivity.10.1.2;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;
import mqq.os.MqqHandler;

public class vgd
  extends SubAccountObserver
{
  vgd(vgc paramvgc, SvcDevLoginInfo paramSvcDevLoginInfo) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetKeyBack mainAccount=" + paramString1 + " subAccount=" + paramString2 + " key=" + paramString3);
    }
    if ((paramString3 == null) || (paramString3.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetKeyBack begin to kickOutDev");
      }
      if (afsf.a().a(this.a.this$0.app, this.b.iAppId, (byte)1, aqhs.hexStr2Bytes(paramString3), this.a.val$index))
      {
        LoginInfoActivity.a(this.a.this$0, 1);
        return;
      }
      LoginInfoActivity.a(this.a.this$0).post(new LoginInfoActivity.10.1.1(this));
      return;
    }
    LoginInfoActivity.a(this.a.this$0).post(new LoginInfoActivity.10.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgd
 * JD-Core Version:    0.7.0.1
 */