import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

final class uha
  extends ugy
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (ugz.b()) {
      return;
    }
    ugz.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    uqf.c("WeishiDownloadUtil", "qq onDownloadCancel info = " + paramDownloadInfo);
    if (ugz.a(paramDownloadInfo))
    {
      ugz.a();
      int i = ugz.b();
      WSPublicAccReport.getInstance().reportDownload(ugz.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    uqf.d("WeishiDownloadUtil", "qq onDownloadError info = " + paramDownloadInfo);
    if (ugz.a(paramDownloadInfo))
    {
      ugz.a();
      paramInt2 = ugz.b();
      WSPublicAccReport.getInstance().reportDownload(ugz.a(), paramInt2, 3, 2, 0);
      uqf.d("WeishiDownloadUtil", " errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      ugz.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ugz.a();
    int i = ugz.a();
    int j = ugz.b();
    if (ugz.b())
    {
      if (ugz.d()) {
        uqf.d("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
    }
    else
    {
      ugz.a(paramDownloadInfo, i, j, "QQ");
      return;
    }
    uqf.d("WeishiDownloadUtil", "这是qq的监听器，不响应qzone. onDownloadFinish eventId:" + i + ",eventType:" + j);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    uqf.d("WeishiDownloadUtil", "qq onDownloadPause info = " + paramDownloadInfo);
    if (ugz.a(paramDownloadInfo)) {
      ugz.a();
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
        uqf.c("WeishiDownloadUtil", "qq onDownloadUpdate progress = " + localDownloadInfo.f + ", url = " + localDownloadInfo.d);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    uqf.d("WeishiDownloadUtil", "qq onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    uqf.d("WeishiDownloadUtil", "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uha
 * JD-Core Version:    0.7.0.1
 */