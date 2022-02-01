import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

final class unr
  extends unp
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (unq.b()) {
      return;
    }
    unq.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    uya.c("WeishiDownloadUtil", "qq onDownloadCancel info = " + paramDownloadInfo);
    if (unq.a(paramDownloadInfo))
    {
      unq.a();
      int i = unq.b();
      WSPublicAccReport.getInstance().reportDownload(unq.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    uya.d("WeishiDownloadUtil", "qq onDownloadError info = " + paramDownloadInfo);
    if (unq.a(paramDownloadInfo))
    {
      unq.a();
      paramInt2 = unq.b();
      WSPublicAccReport.getInstance().reportDownload(unq.a(), paramInt2, 3, 2, 0);
      uya.d("WeishiDownloadUtil", " errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      unq.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    unq.a();
    int i = unq.a();
    int j = unq.b();
    if (unq.b())
    {
      if (unq.d()) {
        uya.d("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
    }
    else
    {
      unq.a(paramDownloadInfo, i, j, "QQ");
      return;
    }
    uya.d("WeishiDownloadUtil", "这是qq的监听器，不响应qzone. onDownloadFinish eventId:" + i + ",eventType:" + j);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    uya.d("WeishiDownloadUtil", "qq onDownloadPause info = " + paramDownloadInfo);
    if (unq.a(paramDownloadInfo)) {
      unq.a();
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
        uya.c("WeishiDownloadUtil", "qq onDownloadUpdate progress = " + localDownloadInfo.f + ", url = " + localDownloadInfo.d);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    uya.d("WeishiDownloadUtil", "qq onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    uya.d("WeishiDownloadUtil", "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unr
 * JD-Core Version:    0.7.0.1
 */