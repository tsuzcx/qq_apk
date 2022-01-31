import android.os.Bundle;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.bnr.BnrReport.BNRConfigMsg;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfigRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class bnu
  implements BusinessObserver
{
  public bnu(AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BnrReport", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        BnrReport.BNRConfigMsg localBNRConfigMsg = new BnrReport.BNRConfigMsg();
        localBNRConfigMsg.mergeFrom(paramBundle);
        BnrReport.a((BnrReport.BNReportConfigRsp)localBNRConfigMsg.msg_rsp_body.get());
        BnrReport.a(this.a, 74);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
    BnrReport.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bnu
 * JD-Core Version:    0.7.0.1
 */