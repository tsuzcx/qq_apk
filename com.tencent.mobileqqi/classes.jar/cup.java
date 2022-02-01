import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class cup
  extends FriendListObserver
{
  public cup(LoginInfoActivity paramLoginInfoActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.LoginInfoActivity", 2, "onKickOutDevFResult isSuccess=" + paramBoolean + " appid=" + paramLong + " result=" + paramInt1 + " index=" + paramInt2);
    }
    LoginInfoActivity.a(this.a);
    if (paramBoolean)
    {
      if ((paramInt1 == 0) && (paramInt2 >= 1) && (paramInt2 < LoginInfoActivity.a(this.a).size()))
      {
        LoginInfoActivity.a(this.a).remove(paramInt2);
        LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
      }
      return;
    }
    QQToast.a(this.a.getApplicationContext(), this.a.getString(2131561765), 0).b(this.a.d());
  }
  
  protected void b(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    LoginInfoActivity.a(this.a);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "onGetLoginDevResult success");
      }
      LoginInfoActivity.a(this.a, paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = LoginInfoActivity.a(this.a).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("Q.devlock.LoginInfoActivity", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("Q.devlock.LoginInfoActivity", 2, "------------------------------------------------------------------------------");
      }
      LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.LoginInfoActivity", 2, "onGetLoginDevResult fail isSuccess=" + paramBoolean);
      if (paramSvcRspGetDevLoginInfo != null) {
        break label288;
      }
      QLog.d("Q.devlock.LoginInfoActivity", 2, "onGetLoginDevResult data is null");
    }
    for (;;)
    {
      QQToast.a(this.a.a(), 1, this.a.getString(2131562570), 0).b(this.a.d());
      return;
      label288:
      QLog.d("Q.devlock.LoginInfoActivity", 2, "onGetLoginDevResult data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cup
 * JD-Core Version:    0.7.0.1
 */