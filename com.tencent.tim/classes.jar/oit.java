import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

final class oit
  extends oiq
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (!oir.isQzoneProcess()) {
      return;
    }
    oir.m(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    ooz.w("WeishiDownloadUtil", "qzone onDownloadCancel info = " + paramDownloadInfo);
    if (oir.c(paramDownloadInfo))
    {
      oir.beX();
      int i = oir.getEventType();
      WSPublicAccReport.getInstance().reportDownload(oir.rk(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    ooz.e("WeishiDownloadUtil", "qzone onDownloadError info = " + paramDownloadInfo);
    if (oir.c(paramDownloadInfo))
    {
      oir.beX();
      paramInt2 = oir.getEventType();
      WSPublicAccReport.getInstance().reportDownload(oir.rk(), paramInt2, 3, 2, 0);
      ooz.e("WeishiDownloadUtil", "qzone  errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      oir.c(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    oir.beX();
    ooz.i("WeishiDownloadUtil", "qzone onDownloadFinish~~~");
    int i = oir.rk();
    int j = oir.getEventType();
    if (j != 3)
    {
      ooz.w("WeishiDownloadUtil", "onDownloadFinish return!qzone只有主动下载");
      return;
    }
    if (!oir.isQzoneProcess())
    {
      ooz.e("WeishiDownloadUtil", "这是Qzone的监听器，不响应qq onDownloadFinish eventId:" + i + ",eventType:" + j);
      return;
    }
    oir.b(paramDownloadInfo, i, j, "Qzone");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    ooz.e("WeishiDownloadUtil", "qzone onDownloadPause info = " + paramDownloadInfo);
    if (oir.c(paramDownloadInfo)) {
      oir.beX();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if (!oir.isQzoneProcess()) {}
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    ooz.e("WeishiDownloadUtil", "qzone onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    ooz.e("WeishiDownloadUtil", "qzone packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oit
 * JD-Core Version:    0.7.0.1
 */