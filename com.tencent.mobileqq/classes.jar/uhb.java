import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

final class uhb
  extends ugy
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (!ugz.b()) {
      return;
    }
    ugz.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    uqf.c("WeishiDownloadUtil", "qzone onDownloadCancel info = " + paramDownloadInfo);
    if (ugz.a(paramDownloadInfo))
    {
      ugz.a();
      int i = ugz.b();
      WSPublicAccReport.getInstance().reportDownload(ugz.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    uqf.d("WeishiDownloadUtil", "qzone onDownloadError info = " + paramDownloadInfo);
    if (ugz.a(paramDownloadInfo))
    {
      ugz.a();
      paramInt2 = ugz.b();
      WSPublicAccReport.getInstance().reportDownload(ugz.a(), paramInt2, 3, 2, 0);
      uqf.d("WeishiDownloadUtil", "qzone  errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      ugz.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ugz.a();
    uqf.a("WeishiDownloadUtil", "qzone onDownloadFinish~~~");
    int i = ugz.a();
    int j = ugz.b();
    if (j != 3)
    {
      uqf.c("WeishiDownloadUtil", "onDownloadFinish return!qzone只有主动下载");
      return;
    }
    if (!ugz.b())
    {
      uqf.d("WeishiDownloadUtil", "这是Qzone的监听器，不响应qq onDownloadFinish eventId:" + i + ",eventType:" + j);
      return;
    }
    ugz.a(paramDownloadInfo, i, j, "Qzone");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    uqf.d("WeishiDownloadUtil", "qzone onDownloadPause info = " + paramDownloadInfo);
    if (ugz.a(paramDownloadInfo)) {
      ugz.a();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if (!ugz.b()) {}
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    uqf.d("WeishiDownloadUtil", "qzone onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    uqf.d("WeishiDownloadUtil", "qzone packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhb
 * JD-Core Version:    0.7.0.1
 */