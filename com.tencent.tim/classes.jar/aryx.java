import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

public abstract interface aryx
{
  public abstract void installSucceed(String paramString1, String paramString2);
  
  public abstract void onDownloadCancel(DownloadInfo paramDownloadInfo);
  
  public abstract void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2);
  
  public abstract void onDownloadFinish(DownloadInfo paramDownloadInfo);
  
  public abstract void onDownloadPause(DownloadInfo paramDownloadInfo);
  
  public abstract void onDownloadUpdate(List<DownloadInfo> paramList);
  
  public abstract void onDownloadWait(DownloadInfo paramDownloadInfo);
  
  public abstract void packageReplaced(String paramString1, String paramString2);
  
  public abstract void uninstallSucceed(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryx
 * JD-Core Version:    0.7.0.1
 */