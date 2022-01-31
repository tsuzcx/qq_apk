import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class yzr
  implements bdko
{
  yzr(yzq paramyzq) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString2 = yzq.a(this.a, paramString2);
    String str = (String)yzq.c(this.a).get(paramString1);
    ThreadManager.getFileThreadHandler().post(new GdtDownloadReportManager.1.1(this, paramString2, str, paramString1));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    yxs.a("GdtDownloadReportManager", "onDownloadFinish: infos:" + paramDownloadInfo.f);
    if (!yzq.c(this.a).containsKey(paramDownloadInfo.c)) {
      yzq.c(this.a).put(paramDownloadInfo.c, paramDownloadInfo.l);
    }
    if ((yzq.a(this.a).containsKey(paramDownloadInfo.c)) && (yzq.a(this.a).get(paramDownloadInfo.c) != null)) {
      yyh.a((GdtAd)yzq.a(this.a).get(paramDownloadInfo.c), 274);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    yxs.a("GdtDownloadReportManager", "onDownloadPause: infos:" + paramDownloadInfo.f);
    if ((yzq.a(this.a).containsKey(paramDownloadInfo.c)) && (yzq.a(this.a).get(paramDownloadInfo.c) != null))
    {
      yyh.a((GdtAd)yzq.a(this.a).get(paramDownloadInfo.c), 273);
      yzq.b(this.a).put(paramDownloadInfo.c, yzq.a(this.a).get(paramDownloadInfo.c));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    yxs.a("GdtDownloadReportManager", "onDownloadUpdate: infos:" + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      yxs.a("GdtDownloadReportManager", "onDownloadUpdate: progress:" + localDownloadInfo.f);
      if ((yzq.b(this.a).containsKey(localDownloadInfo.c)) && (yzq.b(this.a).get(localDownloadInfo.c) != null))
      {
        yyh.a((GdtAd)yzq.b(this.a).get(localDownloadInfo.c), 271);
        yzq.b(this.a).remove(localDownloadInfo.c);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    installSucceed(paramString1, paramString2);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzr
 * JD-Core Version:    0.7.0.1
 */