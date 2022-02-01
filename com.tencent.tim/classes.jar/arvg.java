import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class arvg
  implements arva
{
  private ArrayList<arvh.a> Dy = new ArrayList();
  private Map<String, arvl> oM = new HashMap();
  
  public void Xl(String paramString)
  {
    if ((this.oM != null) && (this.oM.containsKey(paramString))) {
      ((arvl)this.oM.get(paramString)).ddh = true;
    }
  }
  
  public void Zp(int paramInt)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadCallbackNativeImpl.1(this, paramInt), 3000L);
  }
  
  public void a(arvh.a parama)
  {
    if ((parama != null) && (this.Dy != null) && (!this.Dy.contains(parama))) {
      this.Dy.add(parama);
    }
  }
  
  public void a(arvl paramarvl)
  {
    if (this.oM == null) {
      this.oM = new HashMap();
    }
    if ((paramarvl == null) || (TextUtils.isEmpty(paramarvl.appId))) {}
    while (this.oM.containsKey(paramarvl.appId)) {
      return;
    }
    this.oM.put(paramarvl.appId, paramarvl);
  }
  
  public void b(arvh.a parama)
  {
    if (this.Dy != null) {
      this.Dy.remove(parama);
    }
  }
  
  public void e(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void elM()
  {
    if (this.oM != null) {
      this.oM.clear();
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (this.Dy != null)
    {
      arvk localarvk = new arvk();
      localarvk.appId = paramString1;
      localarvk.packageName = paramString2;
      localarvk.state = 7;
      paramString1 = this.Dy.iterator();
      while (paramString1.hasNext()) {
        ((arvh.a)paramString1.next()).a(localarvk);
      }
    }
  }
  
  public void nn(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      label4:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label4;
      }
      Object localObject = (DownloadInfo)paramList.next();
      if (localObject == null) {
        break;
      }
      arvk localarvk = new arvk();
      localarvk.a((DownloadInfo)localObject);
      localObject = this.Dy.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((arvh.a)((Iterator)localObject).next()).d(localarvk);
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((this.Dy != null) && (paramDownloadInfo != null))
    {
      arvk localarvk = new arvk();
      localarvk.a(paramDownloadInfo);
      paramDownloadInfo = this.Dy.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((arvh.a)paramDownloadInfo.next()).a(localarvk);
      }
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.Dy != null) && (paramDownloadInfo != null))
    {
      arvk localarvk = new arvk();
      localarvk.a(paramDownloadInfo);
      localarvk.state = localarvk.kM(paramDownloadInfo.getState());
      localarvk.errCode = localarvk.kN(paramInt1);
      localarvk.errMsg = paramString;
      paramString = this.Dy.iterator();
      while (paramString.hasNext()) {
        ((arvh.a)paramString.next()).b(localarvk);
      }
      if (localarvk.errCode == 201)
      {
        paramString = (arvl)this.oM.get(localarvk.appId);
        if ((paramString != null) && (!paramString.ddg)) {
          arux.a().b(paramDownloadInfo);
        }
      }
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((this.Dy != null) && (paramDownloadInfo != null))
    {
      arvk localarvk = new arvk();
      localarvk.a(paramDownloadInfo);
      Iterator localIterator = this.Dy.iterator();
      while (localIterator.hasNext()) {
        ((arvh.a)localIterator.next()).a(localarvk);
      }
      if (this.oM.containsKey(paramDownloadInfo.appId)) {
        this.oM.remove(paramDownloadInfo.appId);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((this.Dy != null) && (paramDownloadInfo != null))
    {
      arvk localarvk = new arvk();
      localarvk.a(paramDownloadInfo);
      paramDownloadInfo = this.Dy.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((arvh.a)paramDownloadInfo.next()).a(localarvk);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      label4:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label4;
      }
      Object localObject = (DownloadInfo)paramList.next();
      if (localObject == null) {
        break;
      }
      arvk localarvk = new arvk();
      localarvk.a((DownloadInfo)localObject);
      localObject = this.Dy.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((arvh.a)((Iterator)localObject).next()).c(localarvk);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((this.Dy != null) && (paramDownloadInfo != null))
    {
      arvk localarvk = new arvk();
      localarvk.a(paramDownloadInfo);
      paramDownloadInfo = this.Dy.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((arvh.a)paramDownloadInfo.next()).a(localarvk);
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (this.Dy != null)
    {
      arvk localarvk = new arvk();
      localarvk.appId = paramString1;
      localarvk.packageName = paramString2;
      localarvk.state = 9;
      paramString1 = this.Dy.iterator();
      while (paramString1.hasNext()) {
        ((arvh.a)paramString1.next()).a(localarvk);
      }
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (this.Dy != null)
    {
      arvk localarvk = new arvk();
      localarvk.appId = paramString1;
      localarvk.packageName = paramString2;
      localarvk.state = 8;
      paramString1 = this.Dy.iterator();
      while (paramString1.hasNext()) {
        ((arvh.a)paramString1.next()).a(localarvk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvg
 * JD-Core Version:    0.7.0.1
 */