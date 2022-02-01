import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

final class vbs
  extends vbp
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (!vbq.b()) {
      return;
    }
    vbq.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    vmp.c("WeishiDownloadUtil", "qzone onDownloadCancel info = " + paramDownloadInfo);
    if (vbq.a(paramDownloadInfo))
    {
      vbq.a();
      int i = vbq.b();
      WSPublicAccReport.getInstance().reportDownload(vbq.a(), i, 3, 2, 0, vbq.c());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    vmp.d("WeishiDownloadUtil", "qzone onDownloadError info = " + paramDownloadInfo);
    if (vbq.a(paramDownloadInfo))
    {
      vbq.a();
      paramInt2 = vbq.b();
      WSPublicAccReport.getInstance().reportDownload(vbq.a(), paramInt2, 3, 2, 0, vbq.c());
      vmp.d("WeishiDownloadUtil", "qzone  errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      vbq.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    vbq.a();
    vmp.a("WeishiDownloadUtil", "qzone onDownloadFinish~~~");
    int i = vbq.a();
    int j = vbq.b();
    if (j != 3)
    {
      vmp.c("WeishiDownloadUtil", "onDownloadFinish return!qzone只有主动下载");
      return;
    }
    if (!vbq.b())
    {
      vmp.d("WeishiDownloadUtil", "这是Qzone的监听器，不响应qq onDownloadFinish eventId:" + i + ",eventType:" + j);
      return;
    }
    vbq.a(paramDownloadInfo, i, j, "Qzone");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    vmp.d("WeishiDownloadUtil", "qzone onDownloadPause info = " + paramDownloadInfo);
    if (vbq.a(paramDownloadInfo)) {
      vbq.a();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if (!vbq.b()) {}
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    vmp.d("WeishiDownloadUtil", "qzone onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    vmp.d("WeishiDownloadUtil", "qzone packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbs
 * JD-Core Version:    0.7.0.1
 */