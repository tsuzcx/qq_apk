import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jzi
  extends jzg
{
  private ArrayList<kka> callbacks = new ArrayList();
  private ArrayList<kjt> jI = new ArrayList();
  
  public jzi(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    super.a(paramDownloadInfo, paramInt);
    try
    {
      Iterator localIterator = this.fP.iterator();
      while (localIterator.hasNext())
      {
        mrm localmrm = (mrm)localIterator.next();
        if ((localmrm.mAppID != null) && (localmrm.mPackageName != null) && (localmrm.mPackageName.equals(paramDownloadInfo.packageName)) && (localmrm.a != null))
        {
          localmrm.a.downloadState = paramInt;
          localmrm.a.progress = paramDownloadInfo.progress;
          a(localmrm, paramInt, paramDownloadInfo.progress);
        }
      }
      return;
    }
    catch (Exception paramDownloadInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ADFeedsVideoAppDownlodManager", 2, "notifyState error " + paramDownloadInfo.getMessage());
    }
  }
  
  public void a(WadlResult paramWadlResult, int paramInt)
  {
    super.a(paramWadlResult, paramInt);
    try
    {
      Iterator localIterator = this.fP.iterator();
      while (localIterator.hasNext())
      {
        mrm localmrm = (mrm)localIterator.next();
        if ((localmrm.mAppID != null) && (localmrm.mPackageName != null) && (localmrm.mAppID.equals(paramWadlResult.a.appId)) && (localmrm.mPackageName.equals(paramWadlResult.a.packageName)) && (localmrm.a != null))
        {
          localmrm.a.downloadState = a(paramWadlResult);
          localmrm.a.progress = paramWadlResult.progress;
          if (!TextUtils.isEmpty(paramWadlResult.aJb)) {
            localmrm.ajH = paramWadlResult.aJb;
          }
          a(localmrm, paramInt, paramWadlResult.progress);
        }
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ADFeedsVideoAppDownlodManager", 2, "notifyState error " + paramWadlResult.getMessage());
    }
  }
  
  public void a(kka paramkka)
  {
    this.callbacks.add(paramkka);
  }
  
  public void a(mrm parammrm, int paramInt1, int paramInt2)
  {
    super.a(parammrm, paramInt1, paramInt2);
    if ((parammrm == null) || (parammrm.a == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((kka)localIterator.next()).a(parammrm, paramInt1, paramInt2);
      }
    }
  }
  
  protected boolean b(mrm parammrm)
  {
    if ((parammrm != null) && (parammrm.a != null) && (kmx.a(parammrm.a)) && (!TextUtils.isEmpty(parammrm.a.pkgName))) {
      return false;
    }
    return super.b(parammrm);
  }
  
  protected boolean c(mrm parammrm)
  {
    if ((parammrm != null) && (parammrm.a != null) && (kmx.a(parammrm.a))) {
      return false;
    }
    return super.c(parammrm);
  }
  
  public void doOnDestory()
  {
    super.doOnDestory();
    this.callbacks.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzi
 * JD-Core Version:    0.7.0.1
 */