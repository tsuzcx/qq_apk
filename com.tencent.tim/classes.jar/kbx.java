import android.os.Bundle;
import com.tencent.biz.pubaccount.QualityReporter.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoReq;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoRsp;

public class kbx
{
  public static void a(mhu parammhu)
  {
    ThreadManager.excute(new QualityReporter.1(parammhu), 16, null, true);
  }
  
  private static void a(cc_sso_report_svr.ReportInfoReq paramReportInfoReq)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), kbs.class);
    localNewIntent.putExtra("cmd", "FeedsContentCenter.QualityReport");
    localNewIntent.putExtra("data", paramReportInfoReq.toByteArray());
    localNewIntent.setObserver(new kbx.a(localNewIntent));
    kxm.getAppRuntime().startServlet(localNewIntent);
  }
  
  static class a
    implements BusinessObserver
  {
    private NewIntent g;
    
    a(NewIntent paramNewIntent)
    {
      this.g = paramNewIntent;
    }
    
    private void onError(int paramInt, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QualityReporter", 2, "onError: code=" + paramInt + ", msg=" + paramString);
      }
    }
    
    private void onSuccess()
    {
      if (QLog.isColorLevel()) {
        QLog.d("QualityReporter", 2, "onSuccess: ");
      }
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      this.g.setObserver(null);
      if (paramBoolean)
      {
        cc_sso_report_svr.ReportInfoRsp localReportInfoRsp;
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null)
          {
            onError(-123, "data null");
            return;
          }
          localReportInfoRsp = new cc_sso_report_svr.ReportInfoRsp();
          localReportInfoRsp.mergeFrom(paramBundle);
          if ((localReportInfoRsp.ret_code.has()) && (localReportInfoRsp.ret_code.get() == 0))
          {
            onSuccess();
            return;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
        onError(localReportInfoRsp.ret_code.get(), localReportInfoRsp.ret_msg.get());
        return;
      }
      onError(-123, "success=false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbx
 * JD-Core Version:    0.7.0.1
 */