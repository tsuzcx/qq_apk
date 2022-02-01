import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

final class ugz
  extends ugw
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (!ugx.b()) {
      return;
    }
    ugx.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    upe.c("WeishiDownloadUtil", "qzone onDownloadCancel info = " + paramDownloadInfo);
    if (ugx.a(paramDownloadInfo))
    {
      ugx.a();
      int i = ugx.b();
      WSPublicAccReport.getInstance().reportDownload(ugx.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    upe.d("WeishiDownloadUtil", "qzone onDownloadError info = " + paramDownloadInfo);
    if (ugx.a(paramDownloadInfo))
    {
      ugx.a();
      paramInt2 = ugx.b();
      WSPublicAccReport.getInstance().reportDownload(ugx.a(), paramInt2, 3, 2, 0);
      upe.d("WeishiDownloadUtil", "qzone  errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      ugx.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ugx.a();
    upe.a("WeishiDownloadUtil", "qzone onDownloadFinish~~~");
    int i = ugx.a();
    int j = ugx.b();
    if (j != 3)
    {
      upe.c("WeishiDownloadUtil", "onDownloadFinish return!qzone只有主动下载");
      return;
    }
    if (!ugx.b())
    {
      upe.d("WeishiDownloadUtil", "这是Qzone的监听器，不响应qq onDownloadFinish eventId:" + i + ",eventType:" + j);
      return;
    }
    ugx.a(paramDownloadInfo, i, j, "Qzone");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    upe.d("WeishiDownloadUtil", "qzone onDownloadPause info = " + paramDownloadInfo);
    if (ugx.a(paramDownloadInfo)) {
      ugx.a();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if (!ugx.b()) {}
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    upe.d("WeishiDownloadUtil", "qzone onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    upe.d("WeishiDownloadUtil", "qzone packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ugz
 * JD-Core Version:    0.7.0.1
 */