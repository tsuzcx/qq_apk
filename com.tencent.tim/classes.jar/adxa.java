import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager.1;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class adxa
  implements Manager
{
  private QQAppInterface app;
  
  public adxa(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    ThreadManagerV2.executeOnFileThread(new RockDownloaderManager.1(this));
  }
  
  private void cUT()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = adwx.c().query(RockDownloadInfo.class);
    RockDownloadInfo localRockDownloadInfo;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localRockDownloadInfo = (RockDownloadInfo)((Iterator)localObject1).next();
        Object localObject2;
        if (localRockDownloadInfo.endTime + 604800L < l / 1000L)
        {
          localObject2 = new VFSFile(localRockDownloadInfo.localPath);
          if (((VFSFile)localObject2).exists()) {
            ((VFSFile)localObject2).delete();
          }
          adwx.c().remove(localRockDownloadInfo);
          if (QLog.isColorLevel()) {
            QLog.d("RockDownloaderManager", 2, new Object[] { "remove info because has overdue", localRockDownloadInfo });
          }
        }
        else
        {
          localObject2 = aqiz.R(this.app.getApp(), localRockDownloadInfo.getPackageName());
          try
          {
            i = Integer.parseInt((String)localObject2);
            if ((localRockDownloadInfo.realVersionCode <= 0) || (i < localRockDownloadInfo.realVersionCode)) {
              continue;
            }
            localObject2 = new VFSFile(localRockDownloadInfo.localPath);
            if (((VFSFile)localObject2).exists()) {
              ((VFSFile)localObject2).delete();
            }
            adwx.c().remove(localRockDownloadInfo);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("RockDownloaderManager", 2, new Object[] { "remove info because has install", localRockDownloadInfo });
          }
          catch (NumberFormatException localNumberFormatException) {}
          if (QLog.isColorLevel()) {
            QLog.d("RockDownloaderManager", 2, new Object[] { "get install info error", localRockDownloadInfo, " error=", localNumberFormatException.getMessage() });
          }
        }
      }
    }
    localObject1 = new VFSFile(adwx.sY());
    if (((VFSFile)localObject1).exists())
    {
      localObject1 = ((VFSFile)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localRockDownloadInfo = localObject1[i];
          if (localRockDownloadInfo.lastModified() + 604800000L < l)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RockDownloaderManager", 2, new Object[] { "remove file", localRockDownloadInfo.getAbsolutePath() });
            }
            localRockDownloadInfo.delete();
          }
          i += 1;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.app = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxa
 * JD-Core Version:    0.7.0.1
 */