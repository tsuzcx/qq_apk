import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ypx
  implements bcgn
{
  ypx(ypw paramypw) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString2 = ypw.a(this.a, paramString2);
    String str = (String)ypw.c(this.a).get(paramString1);
    ThreadManager.getFileThreadHandler().post(new GdtDownloadReportManager.1.1(this, paramString2, str, paramString1));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    yny.a("GdtDownloadReportManager", "onDownloadFinish: infos:" + paramDownloadInfo.f);
    if (!ypw.c(this.a).containsKey(paramDownloadInfo.c)) {
      ypw.c(this.a).put(paramDownloadInfo.c, paramDownloadInfo.l);
    }
    if ((ypw.a(this.a).containsKey(paramDownloadInfo.c)) && (ypw.a(this.a).get(paramDownloadInfo.c) != null)) {
      yoo.a((GdtAd)ypw.a(this.a).get(paramDownloadInfo.c), 274);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    yny.a("GdtDownloadReportManager", "onDownloadPause: infos:" + paramDownloadInfo.f);
    if ((ypw.a(this.a).containsKey(paramDownloadInfo.c)) && (ypw.a(this.a).get(paramDownloadInfo.c) != null))
    {
      yoo.a((GdtAd)ypw.a(this.a).get(paramDownloadInfo.c), 273);
      ypw.b(this.a).put(paramDownloadInfo.c, ypw.a(this.a).get(paramDownloadInfo.c));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    yny.a("GdtDownloadReportManager", "onDownloadUpdate: infos:" + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      yny.a("GdtDownloadReportManager", "onDownloadUpdate: progress:" + localDownloadInfo.f);
      if ((ypw.b(this.a).containsKey(localDownloadInfo.c)) && (ypw.b(this.a).get(localDownloadInfo.c) != null))
      {
        yoo.a((GdtAd)ypw.b(this.a).get(localDownloadInfo.c), 271);
        ypw.b(this.a).remove(localDownloadInfo.c);
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
 * Qualified Name:     ypx
 * JD-Core Version:    0.7.0.1
 */