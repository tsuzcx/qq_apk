import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aruz
  implements aryx
{
  aruz(arux paramarux) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = arux.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((arva)localIterator.next()).installSucceed(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = arux.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((arva)localIterator.next()).onDownloadCancel(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = arux.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((arva)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (aifg.r(paramDownloadInfo.filePath, paramDownloadInfo.appId, paramDownloadInfo.packageName))
    {
      if (!aifg.wS().equals(paramDownloadInfo.filePath))
      {
        aifg.delete(paramDownloadInfo.filePath);
        paramDownloadInfo.filePath = aifg.wS();
      }
      aryy.a().j(paramDownloadInfo);
    }
    Iterator localIterator = arux.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((arva)localIterator.next()).onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = arux.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((arva)localIterator.next()).onDownloadPause(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Iterator localIterator = arux.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((arva)localIterator.next()).onDownloadUpdate(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = arux.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((arva)localIterator.next()).onDownloadWait(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Iterator localIterator = arux.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((arva)localIterator.next()).packageReplaced(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = arux.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((arva)localIterator.next()).uninstallSucceed(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aruz
 * JD-Core Version:    0.7.0.1
 */