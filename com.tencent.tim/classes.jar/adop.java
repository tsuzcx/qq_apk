import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class adop
  implements aryx
{
  adop(adon paramadon) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (adon.a(this.this$0) != null) {
      adon.a(this.this$0).GH(this.this$0.a(paramString1, 6, paramString2).toString());
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (adon.a(this.this$0) != null)) {
      adon.a(this.this$0).GH(this.this$0.a(paramDownloadInfo).toString());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (adon.a(this.this$0) != null)) {
      adon.a(this.this$0).GH(this.this$0.a(paramDownloadInfo.cCL, paramDownloadInfo.getState(), paramDownloadInfo.progress, paramDownloadInfo.packageName, paramString, paramInt1, paramDownloadInfo.elm).toString());
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (adon.a(this.this$0) != null)) {
      adon.a(this.this$0).GH(this.this$0.a(paramDownloadInfo).toString());
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (adon.a(this.this$0) != null)) {
      adon.a(this.this$0).GH(this.this$0.a(paramDownloadInfo).toString());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((paramList != null) && (adon.a(this.this$0) != null))
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        localJSONArray.put(this.this$0.a(localDownloadInfo));
      }
      adon.a(this.this$0).GH(localJSONArray.toString());
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (adon.a(this.this$0) != null)) {
      adon.a(this.this$0).GH(this.this$0.a(paramDownloadInfo).toString());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (adon.a(this.this$0) != null) {
      adon.a(this.this$0).GH(this.this$0.a(paramString1, 13, paramString2).toString());
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (adon.a(this.this$0) != null) {
      adon.a(this.this$0).GH(this.this$0.a(paramString1, 9, paramString2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adop
 * JD-Core Version:    0.7.0.1
 */