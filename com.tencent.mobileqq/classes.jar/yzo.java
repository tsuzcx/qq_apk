import com.tencent.open.downloadnew.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.List;

class yzo
  implements bdko
{
  private WeakReference<yzl> a;
  
  yzo(yzl paramyzl)
  {
    this.a = new WeakReference(paramyzl);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    yzl localyzl = (yzl)this.a.get();
    if (localyzl != null) {
      localyzl.a(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    yzl localyzl = (yzl)this.a.get();
    if (localyzl != null) {
      localyzl.d(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    yzl localyzl = (yzl)this.a.get();
    if (localyzl != null) {
      localyzl.a(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    yzl localyzl = (yzl)this.a.get();
    if (localyzl != null) {
      localyzl.c(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    yzl localyzl = (yzl)this.a.get();
    if (localyzl != null) {
      localyzl.a(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    yzl localyzl = (yzl)this.a.get();
    if (localyzl != null) {
      localyzl.a(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    yzl localyzl = (yzl)this.a.get();
    if (localyzl != null) {
      localyzl.b(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    yzl localyzl = (yzl)this.a.get();
    if (localyzl != null) {
      localyzl.c(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    yzl localyzl = (yzl)this.a.get();
    if (localyzl != null) {
      localyzl.b(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzo
 * JD-Core Version:    0.7.0.1
 */