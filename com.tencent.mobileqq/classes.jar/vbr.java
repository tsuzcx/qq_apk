import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

final class vbr
  extends vbp
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (vbq.b()) {
      return;
    }
    vbq.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    vmp.c("WeishiDownloadUtil", "qq onDownloadCancel info = " + paramDownloadInfo);
    if (vbq.a(paramDownloadInfo))
    {
      vbq.a();
      int i = vbq.b();
      WSPublicAccReport.getInstance().reportDownload(vbq.a(), i, 3, 2, 0, vbq.c());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    vmp.d("WeishiDownloadUtil", "qq onDownloadError info = " + paramDownloadInfo);
    if (vbq.a(paramDownloadInfo))
    {
      vbq.a();
      paramInt2 = vbq.b();
      WSPublicAccReport.getInstance().reportDownload(vbq.a(), paramInt2, 3, 2, 0, vbq.c());
      vmp.d("WeishiDownloadUtil", " errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      vbq.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    vbq.a();
    int i = vbq.a();
    int j = vbq.b();
    if (vbq.b())
    {
      if (vbq.d()) {
        vmp.d("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
    }
    else
    {
      vbq.a(paramDownloadInfo, i, j, "QQ");
      return;
    }
    vmp.d("WeishiDownloadUtil", "这是qq的监听器，不响应qzone. onDownloadFinish eventId:" + i + ",eventType:" + j);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    vmp.d("WeishiDownloadUtil", "qq onDownloadPause info = " + paramDownloadInfo);
    if (vbq.a(paramDownloadInfo)) {
      vbq.a();
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
        vmp.c("WeishiDownloadUtil", "qq onDownloadUpdate progress = " + localDownloadInfo.f + ", url = " + localDownloadInfo.d);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    vmp.d("WeishiDownloadUtil", "qq onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    vmp.d("WeishiDownloadUtil", "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbr
 * JD-Core Version:    0.7.0.1
 */