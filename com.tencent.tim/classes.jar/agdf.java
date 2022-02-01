import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.1;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.2;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.3;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.4;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class agdf
  implements aryx
{
  public agdf(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ("1101070898".equals(paramString1))
    {
      paramString1 = UniformDownloadActivity.a(this.this$0);
      UniformDownloadActivity.a(this.this$0, paramString1);
      paramString1 = UniformDownloadActivity.a(this.this$0, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d(UniformDownloadActivity.TAG, 2, "tmastUrl=" + paramString1);
      }
      UniformDownloadActivity.a(this.this$0, paramString1);
      this.this$0.finish();
      this.this$0.overridePendingTransition(0, 0);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.TAG, 2, "onDownloadCancel " + paramDownloadInfo.packageName);
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
    {
      this.this$0.finish();
      this.this$0.overridePendingTransition(0, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.TAG, 2, "onDownloadError " + paramDownloadInfo.packageName);
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
    {
      this.this$0.finish();
      this.this$0.overridePendingTransition(0, 0);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.TAG, 2, "onDownloadFinish " + paramDownloadInfo.packageName);
    }
    anot.a(null, "dc00898", "", "", "0X8008F88", "0X8008F88", 1, 0, "", "", "", "");
    this.this$0.runOnUiThread(new UniformDownloadActivity.10.4(this));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.TAG, 2, "onDownloadPause " + paramDownloadInfo.packageName);
    }
    if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898"))) {
      this.this$0.runOnUiThread(new UniformDownloadActivity.10.3(this));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d(UniformDownloadActivity.TAG, 2, "onDownloadUpdate " + localDownloadInfo.packageName);
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.appId.equals("1101070898"))) {
        this.this$0.runOnUiThread(new UniformDownloadActivity.10.2(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    this.this$0.runOnUiThread(new UniformDownloadActivity.10.1(this));
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agdf
 * JD-Core Version:    0.7.0.1
 */