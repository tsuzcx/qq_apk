import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arvh
{
  private static arvh jdField_a_of_type_Arvh;
  private arvg jdField_a_of_type_Arvg = new arvg();
  
  public static arvh a()
  {
    if (jdField_a_of_type_Arvh == null) {
      jdField_a_of_type_Arvh = new arvh();
    }
    return jdField_a_of_type_Arvh;
  }
  
  private DownloadInfo a(arvl paramarvl)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(paramarvl.appId, paramarvl.packageName);
    localDownloadInfo.urlStr = paramarvl.urlStr;
    localDownloadInfo.versionCode = paramarvl.versionCode;
    localDownloadInfo.ddi = paramarvl.ddi;
    localDownloadInfo.isAutoInstall = paramarvl.isAutoInstall;
    localDownloadInfo.pushTitle = paramarvl.appName;
    localDownloadInfo.updateType = paramarvl.updateType;
    localDownloadInfo.downloadType = paramarvl.downloadType;
    localDownloadInfo.elk = 0;
    localDownloadInfo.ddw = true;
    return localDownloadInfo;
  }
  
  private boolean zd()
  {
    return "com.tencent.mobileqq:tool".equals(arug.getProcessName());
  }
  
  public int B(List<arvl> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((arvl)paramList.next());
      localDownloadInfo.downloadType = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (arux.a().v(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public int a(Activity paramActivity, arvl paramarvl)
  {
    if (!zd()) {
      return 401;
    }
    if (paramarvl == null) {
      return 400;
    }
    if ((paramarvl.ddf) && (!"com.tencent.now".equals(paramarvl.appName))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(paramarvl);
    localDownloadInfo.ekZ = 2;
    localDownloadInfo.ddw = true;
    if ((jqc.getNetWorkType() != 1) && (paramActivity != null) && (paramarvl.ddj)) {
      a(paramActivity, localDownloadInfo, paramarvl);
    }
    for (;;)
    {
      return 200;
      arux.a().b(localDownloadInfo);
      this.jdField_a_of_type_Arvg.a(paramarvl);
    }
  }
  
  public int a(arvl paramarvl)
  {
    int j = -1;
    int i;
    if (!zd()) {
      i = 401;
    }
    int k;
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramarvl == null);
      paramarvl = a(paramarvl);
      paramarvl.ekZ = 13;
      paramarvl.downloadType = 0;
      k = arux.a().a(paramarvl);
      if (k == 1) {
        return 1;
      }
      i = j;
    } while (k != 0);
    return 0;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, arvl paramarvl)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, paramarvl, paramActivity));
  }
  
  public int ah(String paramString1, String paramString2)
  {
    if (!zd()) {
      return 401;
    }
    arux.a().iI(paramString1, paramString2);
    return 200;
  }
  
  public void c(arvh.a parama)
  {
    this.jdField_a_of_type_Arvg.a(parama);
    arux.a().a(this.jdField_a_of_type_Arvg);
  }
  
  public void d(arvh.a parama)
  {
    this.jdField_a_of_type_Arvg.elM();
    this.jdField_a_of_type_Arvg.b(parama);
    arux.a().b(this.jdField_a_of_type_Arvg);
  }
  
  public int fw(String paramString)
  {
    if (!zd()) {
      return 401;
    }
    this.jdField_a_of_type_Arvg.Xl(paramString);
    arux.a().pauseDownload(paramString);
    return 200;
  }
  
  public boolean isInstalled(String paramString)
  {
    return arxn.appIsExists(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void a(arvk paramarvk);
    
    public abstract void b(arvk paramarvk);
    
    public abstract void c(arvk paramarvk);
    
    public abstract void d(arvk paramarvk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvh
 * JD-Core Version:    0.7.0.1
 */