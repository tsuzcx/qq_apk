import android.util.Pair;
import com.tencent.ad.tangram.canvas.download.IAdDownloader.Callback;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tff
  implements aryx, IAdDownloader.Callback
{
  private WeakReference<AdAppDownloadManager> dt;
  
  public void a(AdAppDownloadManager paramAdAppDownloadManager)
  {
    this.dt = new WeakReference(paramAdAppDownloadManager);
  }
  
  public AdAppDownloadManager getDownloadManager()
  {
    if ((this.dt != null) && (this.dt.get() != null)) {
      return (AdAppDownloadManager)this.dt.get();
    }
    return null;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString2 = arvv.a().f(paramString2);
    if ((this.dt != null) && (this.dt.get() != null) && (paramString2 != null)) {
      ((AdAppDownloadManager)this.dt.get()).onDownloadStatusChanged(6, 0, new Pair(paramString2.urlStr, paramString2.packageName), paramString1);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((this.dt != null) && (this.dt.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.dt.get()).onDownloadStatusChanged(4, paramDownloadInfo.progress, new Pair(paramDownloadInfo.urlStr, paramDownloadInfo.packageName), paramDownloadInfo.appId);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.dt != null) && (this.dt.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.dt.get()).onDownloadStatusChanged(5, paramDownloadInfo.progress, new Pair(paramDownloadInfo.urlStr, paramDownloadInfo.packageName), paramDownloadInfo.appId);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((this.dt != null) && (this.dt.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.dt.get()).onDownloadStatusChanged(3, paramDownloadInfo.progress, new Pair(paramDownloadInfo.urlStr, paramDownloadInfo.packageName), paramDownloadInfo.appId);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((this.dt != null) && (this.dt.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.dt.get()).onDownloadStatusChanged(2, paramDownloadInfo.progress, new Pair(paramDownloadInfo.urlStr, paramDownloadInfo.packageName), paramDownloadInfo.appId);
    }
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1) {}
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((this.dt == null) || (this.dt.get() == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      DownloadInfo localDownloadInfo;
      if (paramList.hasNext())
      {
        localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo != null) {}
      }
      else
      {
        if ((localArrayList2.size() == 0) || (localArrayList1.size() == 0)) {
          break;
        }
        ((AdAppDownloadManager)this.dt.get()).onDownloadProgressUpdate(localArrayList1, localArrayList2);
        return;
      }
      localArrayList2.add(new Pair(localDownloadInfo.urlStr, localDownloadInfo.packageName));
      localArrayList1.add(localDownloadInfo);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    paramString2 = arvv.a().f(paramString2);
    if ((this.dt != null) && (this.dt.get() != null) && (paramString2 != null)) {
      ((AdAppDownloadManager)this.dt.get()).onDownloadStatusChanged(7, 0, new Pair(paramString2.urlStr, paramString2.packageName), paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tff
 * JD-Core Version:    0.7.0.1
 */