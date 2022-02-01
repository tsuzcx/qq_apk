import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.13.1;
import java.util.List;

public class asvd
  implements aryx
{
  asvd(asuz paramasuz) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((asuz.b(this.this$0) != null) && (asuz.c(this.this$0) != null) && (asuz.b(this.this$0).equals(paramString1)) && (asuz.c(this.this$0).equals(paramString2)))
    {
      QLog.d("MiniAppProxyImpl", 1, "installSucceed: " + paramString1 + "; pkgname : " + paramString2);
      InnerAppReportDc4239.innerAppReport(asuz.a(this.this$0), null, "launchapp", "installapp", "qqdownload");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((asuz.a(this.this$0) != null) && (paramDownloadInfo != null) && (asuz.a(this.this$0).equals(paramDownloadInfo.urlStr))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadCancel");
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((asuz.a(this.this$0) != null) && (paramDownloadInfo != null) && (asuz.a(this.this$0).equals(paramDownloadInfo.urlStr))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadError");
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((asuz.a(this.this$0) != null) && (paramDownloadInfo != null) && (asuz.a(this.this$0).equals(paramDownloadInfo.urlStr)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadFinish");
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.13.1(this));
      InnerAppReportDc4239.innerAppReport(asuz.a(this.this$0), null, "launchapp", "downloadappfinish", "qqdownload");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((asuz.a(this.this$0) != null) && (paramDownloadInfo != null) && (asuz.a(this.this$0).equals(paramDownloadInfo.urlStr)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadPause");
      InnerAppReportDc4239.innerAppReport(asuz.a(this.this$0), null, "launchapp", "downloadapppause", "qqdownload");
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList) {}
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((asuz.a(this.this$0) != null) && (paramDownloadInfo != null) && (asuz.a(this.this$0).equals(paramDownloadInfo.urlStr))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvd
 * JD-Core Version:    0.7.0.1
 */