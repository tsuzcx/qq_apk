package com.tencent.qqmail.download;

import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqmail.account.callback.LoginCallback;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class AttachDownloadManager$4
  implements LoginCallback
{
  AttachDownloadManager$4(AttachDownloadManager paramAttachDownloadManager, int paramInt) {}
  
  public void loginFail()
  {
    QMLog.log(6, "AttachDownloadManager", "auto login for download fail");
    synchronized (AttachDownloadManager.access$900(this.this$0))
    {
      AttachDownloadManager.access$900(this.this$0).remove(Integer.valueOf(this.val$accountId));
      Object localObject1 = (ArrayList)AttachDownloadManager.access$1000(this.this$0).get(Integer.valueOf(this.val$accountId));
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          DownloadTask localDownloadTask = ((DownloadInfo)((Iterator)localObject1).next()).getDownloadTask();
          if (localDownloadTask.getListener() != null) {
            localDownloadTask.getListener().onFail(localDownloadTask.getId(), localDownloadTask.getUrl(), new DownloadTaskError(-1001, "auto login for download fail"));
          }
        }
      }
    }
    AttachDownloadManager.access$1000(this.this$0).remove(Integer.valueOf(this.val$accountId));
  }
  
  public void loginSuccess()
  {
    QMLog.log(4, "AttachDownloadManager", "auto login for download success");
    synchronized (AttachDownloadManager.access$900(this.this$0))
    {
      AttachDownloadManager.access$900(this.this$0).remove(Integer.valueOf(this.val$accountId));
      Object localObject1 = (ArrayList)AttachDownloadManager.access$1000(this.this$0).get(Integer.valueOf(this.val$accountId));
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject1).next();
          DownloadUtil.refreshDownloadCookie(localDownloadInfo);
          DownloadTask localDownloadTask = AttachDownloadManager.access$1100(this.this$0, localDownloadInfo);
          localDownloadInfo.setDownloadTask(localDownloadTask);
          localDownloadTask.start();
        }
      }
    }
    AttachDownloadManager.access$1000(this.this$0).remove(Integer.valueOf(this.val$accountId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.AttachDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */