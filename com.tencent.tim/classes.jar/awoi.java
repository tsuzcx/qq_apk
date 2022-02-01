import android.os.Bundle;
import mqq.observer.BusinessObserver;

class awoi
  implements BusinessObserver
{
  awoi(awof paramawof, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("extra_result_code");
    String str = paramBundle.getString("extra_result_err_msg");
    paramBundle = paramBundle.getString("extra_cmd");
    if (!paramBoolean)
    {
      asbt.e("WadlProxyServiceManager", "onReportDownloadEvent fail operId=" + this.cRQ + ",cmd=" + paramBundle + ",errCode=" + paramInt + ",errMsg=" + str);
      return;
    }
    asbt.i("WadlProxyServiceManager", "onReportDownloadEvent success operId=" + this.cRQ + ",cmd=" + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awoi
 * JD-Core Version:    0.7.0.1
 */