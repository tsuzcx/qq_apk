import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class tlv
  implements aryx
{
  tlv(tlu paramtlu) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((tlu.a(this.b) == null) || (tlu.a(this.b).getAppId() == null) || (tlu.a(this.b).getAppPackageName() == null) || (!tlu.a(this.b).getAppId().equals(paramString1)) || (!tlu.a(this.b).getAppPackageName().equals(paramString2)))
    {
      tkw.e("GdtDownloadReportManager", "no ad or not the same ad");
      return;
    }
    paramString2 = tlu.a(this.b, paramString2);
    ThreadManager.getFileThreadHandler().post(new GdtDownloadReportManager.1.1(this, paramString2, paramString1));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.appId))) {}
    do
    {
      return;
      tkw.d("GdtDownloadReportManager", "onDownloadFinish: infos:" + paramDownloadInfo.progress);
      if ((tlu.a(this.b).containsKey(paramDownloadInfo.appId)) && (tlu.a(this.b).get(paramDownloadInfo.appId) != null))
      {
        tlg.a((Ad)tlu.a(this.b).get(paramDownloadInfo.appId), 274);
        return;
      }
    } while (!tlu.a(this.b, paramDownloadInfo, tlu.a(this.b)));
    tlg.a(tlu.a(this.b), 274);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.appId))) {}
    do
    {
      return;
      tkw.d("GdtDownloadReportManager", "onDownloadPause: infos:" + paramDownloadInfo.progress);
      if ((tlu.a(this.b).containsKey(paramDownloadInfo.appId)) && (tlu.a(this.b).get(paramDownloadInfo.appId) != null))
      {
        tlg.a((Ad)tlu.a(this.b).get(paramDownloadInfo.appId), 273);
        tlu.b(this.b).put(paramDownloadInfo.appId, tlu.a(this.b).get(paramDownloadInfo.appId));
        return;
      }
    } while (!tlu.a(this.b, paramDownloadInfo, tlu.a(this.b)));
    tlg.a(tlu.a(this.b), 273);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      tkw.d("GdtDownloadReportManager", "onDownloadUpdate: infos:" + paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ((localDownloadInfo != null) && (!TextUtils.isEmpty(localDownloadInfo.appId)))
        {
          tkw.d("GdtDownloadReportManager", "onDownloadUpdate: progress:" + localDownloadInfo.progress);
          if ((tlu.b(this.b).containsKey(localDownloadInfo.appId)) && (tlu.b(this.b).get(localDownloadInfo.appId) != null))
          {
            tlg.a((Ad)tlu.b(this.b).get(localDownloadInfo.appId), 271);
            tlu.b(this.b).remove(localDownloadInfo.appId);
          }
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlv
 * JD-Core Version:    0.7.0.1
 */