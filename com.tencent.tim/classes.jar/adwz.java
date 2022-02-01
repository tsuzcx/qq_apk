import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class adwz
  implements aryx
{
  adwz(RockDownloaderTask paramRockDownloaderTask, boolean paramBoolean) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "installSucceed: appid=", paramString1, " packageName=", paramString2 });
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo.packageName == null) || (!paramDownloadInfo.packageName.equals(this.a.getDownloadInfo().getPackageName()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadCancel: info=", paramDownloadInfo });
    }
    if (this.bRz)
    {
      this.a.getRockDownloadListener().onDownloadCancel(this.a.getDownloadInfo());
      this.a.getRockDownloadListener().onDownloadFinish(this.a.getDownloadInfo());
    }
    arvv.a().b(this);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo.packageName == null) || (!paramDownloadInfo.packageName.equals(this.a.getDownloadInfo().getPackageName()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadError: info=", paramDownloadInfo, " errorMsg=", paramString, " state=", Integer.valueOf(paramInt2) });
    }
    if (this.bRz)
    {
      if (paramInt1 != 6) {
        break label200;
      }
      this.a.getRockDownloadListener().onDownloadFail(this.a.getDownloadInfo(), acfp.m(2131713981), 10010);
    }
    for (;;)
    {
      this.a.getRockDownloadListener().onDownloadFinish(this.a.getDownloadInfo());
      paramString = (DownloadInfo)arvv.a().E().remove(paramDownloadInfo.ticket);
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "onDownloadError removedDownload=", paramString });
      }
      arvt.a().Xn(paramDownloadInfo.ticket);
      adwx.b(this.a, "0x800A1E6");
      arvv.a().b(this);
      return;
      label200:
      this.a.getRockDownloadListener().onDownloadFail(this.a.getDownloadInfo(), paramString, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo.packageName == null) || (!paramDownloadInfo.packageName.equals(this.a.getDownloadInfo().getPackageName()))) {
      return;
    }
    adwx.b(this.a, paramDownloadInfo, this.bRz);
    arvv.a().b(this);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo.packageName == null) || (!paramDownloadInfo.packageName.equals(this.a.getDownloadInfo().getPackageName()))) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RockDownloader", 2, new Object[] { "onDownloadPause: info=", paramDownloadInfo });
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (!this.bRz) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localDownloadInfo = (DownloadInfo)paramList.next();
    } while ((localDownloadInfo.packageName == null) || (!localDownloadInfo.packageName.equals(this.a.getDownloadInfo().getPackageName())));
    this.a.getRockDownloadListener().onDownloadProceedOn(this.a.getDownloadInfo(), localDownloadInfo.progress);
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo.packageName == null) || (!paramDownloadInfo.packageName.equals(this.a.getDownloadInfo().getPackageName()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "onDownloadWait: info=", paramDownloadInfo });
      }
    } while (!this.bRz);
    this.a.getRockDownloadListener().onDownloadWait(this.a.getDownloadInfo());
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "packageReplaced: appid=", paramString1, " packageName=", paramString2 });
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "uninstallSucceed: appid=", paramString1, " packageName=", paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adwz
 * JD-Core Version:    0.7.0.1
 */