import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class yzo
  implements bdld
{
  yzo(yzn paramyzn) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString2 = yzn.a(this.a, paramString2);
    String str = (String)yzn.c(this.a).get(paramString1);
    ThreadManager.getFileThreadHandler().post(new GdtDownloadReportManager.1.1(this, paramString2, str, paramString1));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    yxp.a("GdtDownloadReportManager", "onDownloadFinish: infos:" + paramDownloadInfo.f);
    if (!yzn.c(this.a).containsKey(paramDownloadInfo.c)) {
      yzn.c(this.a).put(paramDownloadInfo.c, paramDownloadInfo.l);
    }
    if ((yzn.a(this.a).containsKey(paramDownloadInfo.c)) && (yzn.a(this.a).get(paramDownloadInfo.c) != null)) {
      yye.a((GdtAd)yzn.a(this.a).get(paramDownloadInfo.c), 274);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    yxp.a("GdtDownloadReportManager", "onDownloadPause: infos:" + paramDownloadInfo.f);
    if ((yzn.a(this.a).containsKey(paramDownloadInfo.c)) && (yzn.a(this.a).get(paramDownloadInfo.c) != null))
    {
      yye.a((GdtAd)yzn.a(this.a).get(paramDownloadInfo.c), 273);
      yzn.b(this.a).put(paramDownloadInfo.c, yzn.a(this.a).get(paramDownloadInfo.c));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    yxp.a("GdtDownloadReportManager", "onDownloadUpdate: infos:" + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      yxp.a("GdtDownloadReportManager", "onDownloadUpdate: progress:" + localDownloadInfo.f);
      if ((yzn.b(this.a).containsKey(localDownloadInfo.c)) && (yzn.b(this.a).get(localDownloadInfo.c) != null))
      {
        yye.a((GdtAd)yzn.b(this.a).get(localDownloadInfo.c), 271);
        yzn.b(this.a).remove(localDownloadInfo.c);
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
 * Qualified Name:     yzo
 * JD-Core Version:    0.7.0.1
 */