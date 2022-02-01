import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class vqu
  extends acfd
{
  public vqu(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
  protected void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onDelHistoryDevResult isSuccess=" + paramBoolean + " errorMsg=" + paramString + " index=" + paramInt);
    }
    RecentLoginDevActivity.b(this.this$0);
    if (paramBoolean)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "My_eq", "Delete_eq", 0, 0, "", "", "", "");
      if ((paramInt > -1) && (RecentLoginDevActivity.a(this.this$0) != null) && (paramInt < RecentLoginDevActivity.a(this.this$0).size()))
      {
        RecentLoginDevActivity.a(this.this$0).remove(paramInt);
        RecentLoginDevActivity.a(this.this$0, RecentLoginDevActivity.a(this.this$0));
      }
      QQToast.a(this.this$0.getApplicationContext(), 2, this.this$0.getString(2131693197), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.this$0.getApplicationContext(), 1, this.this$0.getString(2131696145), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), 1, paramString, 0).show(this.this$0.getTitleBarHeight());
  }
  
  protected void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    RecentLoginDevActivity.b(this.this$0);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult success");
      }
      RecentLoginDevActivity.a(this.this$0, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = RecentLoginDevActivity.a(this.this$0).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("Q.devlock.RecentLoginDevActivity", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "------------------------------------------------------------------------------");
      }
      RecentLoginDevActivity.a(this.this$0, RecentLoginDevActivity.a(this.this$0));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed isSuccess=" + paramBoolean);
      if (paramSvcRspGetDevLoginInfo != null) {
        break label288;
      }
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed data is null");
    }
    for (;;)
    {
      QQToast.a(this.this$0.getActivity(), 1, this.this$0.getString(2131693213), 0).show(this.this$0.getTitleBarHeight());
      return;
      label288:
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqu
 * JD-Core Version:    0.7.0.1
 */