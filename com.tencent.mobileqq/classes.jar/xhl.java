import VACDReport.ReportRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import mqq.observer.BusinessObserver;

public class xhl
  implements BusinessObserver
{
  public xhl(VACDReportMgr paramVACDReportMgr) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBundle.containsKey("rsp")) {}
    for (paramBundle = ((ReportRsp)paramBundle.getSerializable("rsp")).headers;; paramBundle = null)
    {
      VACDReportMgr.a(this.a, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xhl
 * JD-Core Version:    0.7.0.1
 */