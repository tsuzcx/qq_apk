import com.tencent.open.downloadnew.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.List;

class yzl
  implements bdld
{
  private WeakReference<yzi> a;
  
  yzl(yzi paramyzi)
  {
    this.a = new WeakReference(paramyzi);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    yzi localyzi = (yzi)this.a.get();
    if (localyzi != null) {
      localyzi.a(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    yzi localyzi = (yzi)this.a.get();
    if (localyzi != null) {
      localyzi.d(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    yzi localyzi = (yzi)this.a.get();
    if (localyzi != null) {
      localyzi.a(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    yzi localyzi = (yzi)this.a.get();
    if (localyzi != null) {
      localyzi.c(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    yzi localyzi = (yzi)this.a.get();
    if (localyzi != null) {
      localyzi.a(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    yzi localyzi = (yzi)this.a.get();
    if (localyzi != null) {
      localyzi.a(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    yzi localyzi = (yzi)this.a.get();
    if (localyzi != null) {
      localyzi.b(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    yzi localyzi = (yzi)this.a.get();
    if (localyzi != null) {
      localyzi.c(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    yzi localyzi = (yzi)this.a.get();
    if (localyzi != null) {
      localyzi.b(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzl
 * JD-Core Version:    0.7.0.1
 */