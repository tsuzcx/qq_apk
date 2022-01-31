import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.appreport.AppReport;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.io.File;

public class hrk
  implements Runnable
{
  public hrk(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    Context localContext = CommonDataAdapter.a().a();
    boolean bool = localContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false);
    SimpleAccount localSimpleAccount = BaseApplicationImpl.a().getFirstSimpleAccount();
    String str = "";
    if (localSimpleAccount != null) {
      str = localSimpleAccount.getUin();
    }
    if (!bool)
    {
      LogUtility.c(DownloadManager.a, "getUpdateApp will do full report");
      AppReport.a(localContext, null, null, str);
    }
    while (!new File(localContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists()) {
      return;
    }
    LogUtility.c(DownloadManager.a, "getUpdateApp will do incremental report");
    AppReport.a(localContext, null, 0, null, null, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hrk
 * JD-Core Version:    0.7.0.1
 */