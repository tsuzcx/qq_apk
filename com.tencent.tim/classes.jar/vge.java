import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class vge
  extends acfd
{
  public vge(LoginInfoActivity paramLoginInfoActivity) {}
  
  protected void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    LoginInfoActivity.d(this.this$0);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult success");
      }
      LoginInfoActivity.a(this.this$0, paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = LoginInfoActivity.a(this.this$0).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("LoginInfoActivity.AccDevSec", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("LoginInfoActivity.AccDevSec", 2, "------------------------------------------------------------------------------");
      }
      LoginInfoActivity.a(this.this$0, LoginInfoActivity.a(this.this$0));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult fail isSuccess=" + paramBoolean);
      if (paramSvcRspGetDevLoginInfo != null) {
        break label288;
      }
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult data is null");
    }
    for (;;)
    {
      QQToast.a(this.this$0.getActivity(), 1, this.this$0.getString(2131693213), 0).show(this.this$0.getTitleBarHeight());
      return;
      label288:
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
  
  protected void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onKickOutDevFResult isSuccess=" + paramBoolean + " appid=" + paramLong + " result=" + paramInt1 + " index=" + paramInt2);
    }
    LoginInfoActivity.d(this.this$0);
    if (paramBoolean)
    {
      if ((paramInt1 == 0) && (paramInt2 >= 1) && (paramInt2 < LoginInfoActivity.a(this.this$0).size()))
      {
        LoginInfoActivity.a(this.this$0).remove(paramInt2);
        LoginInfoActivity.a(this.this$0, LoginInfoActivity.a(this.this$0));
      }
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), this.this$0.getString(2131696148), 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vge
 * JD-Core Version:    0.7.0.1
 */