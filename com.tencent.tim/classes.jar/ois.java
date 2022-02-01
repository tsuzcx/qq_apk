import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

final class ois
  extends oiq
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (oir.isQzoneProcess()) {
      return;
    }
    oir.m(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    ooz.w("WeishiDownloadUtil", "qq onDownloadCancel info = " + paramDownloadInfo);
    if (oir.c(paramDownloadInfo))
    {
      oir.beX();
      int i = oir.getEventType();
      WSPublicAccReport.getInstance().reportDownload(oir.rk(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    ooz.e("WeishiDownloadUtil", "qq onDownloadError info = " + paramDownloadInfo);
    if (oir.c(paramDownloadInfo))
    {
      oir.beX();
      paramInt2 = oir.getEventType();
      WSPublicAccReport.getInstance().reportDownload(oir.rk(), paramInt2, 3, 2, 0);
      ooz.e("WeishiDownloadUtil", " errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      oir.c(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    oir.beX();
    int i = oir.rk();
    int j = oir.getEventType();
    if (oir.isQzoneProcess())
    {
      if (oir.GU()) {
        ooz.e("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
    }
    else
    {
      oir.b(paramDownloadInfo, i, j, "QQ");
      return;
    }
    ooz.e("WeishiDownloadUtil", "这是qq的监听器，不响应qzone. onDownloadFinish eventId:" + i + ",eventType:" + j);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    ooz.e("WeishiDownloadUtil", "qq onDownloadPause info = " + paramDownloadInfo);
    if (oir.c(paramDownloadInfo)) {
      oir.beX();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        ooz.w("WeishiDownloadUtil", "qq onDownloadUpdate progress = " + localDownloadInfo.progress + ", url = " + localDownloadInfo.urlStr);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    ooz.e("WeishiDownloadUtil", "qq onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    ooz.e("WeishiDownloadUtil", "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ois
 * JD-Core Version:    0.7.0.1
 */