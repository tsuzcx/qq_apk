import com.tencent.open.downloadnew.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.List;

class ypu
  implements bcgn
{
  private WeakReference<ypr> a;
  
  ypu(ypr paramypr)
  {
    this.a = new WeakReference(paramypr);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    ypr localypr = (ypr)this.a.get();
    if (localypr != null) {
      localypr.a(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    ypr localypr = (ypr)this.a.get();
    if (localypr != null) {
      localypr.d(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    ypr localypr = (ypr)this.a.get();
    if (localypr != null) {
      localypr.a(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ypr localypr = (ypr)this.a.get();
    if (localypr != null) {
      localypr.c(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    ypr localypr = (ypr)this.a.get();
    if (localypr != null) {
      localypr.a(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    ypr localypr = (ypr)this.a.get();
    if (localypr != null) {
      localypr.a(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    ypr localypr = (ypr)this.a.get();
    if (localypr != null) {
      localypr.b(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    ypr localypr = (ypr)this.a.get();
    if (localypr != null) {
      localypr.c(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    ypr localypr = (ypr)this.a.get();
    if (localypr != null) {
      localypr.b(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ypu
 * JD-Core Version:    0.7.0.1
 */