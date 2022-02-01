package com.tencent.qqmail.download.util;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;

final class DownloadUtil$1
  implements Runnable
{
  DownloadUtil$1(Attach paramAttach, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.val$attach == null) || (StringExtention.isNullOrEmpty(this.val$attach.getPreview().getMyDisk())) || (StringExtention.isNullOrEmpty(this.val$saveAsPath))) {}
    String str;
    do
    {
      return;
      QMLog.log(4, "DownloadUtil", "existFile save from:" + this.val$attach.getPreview().getMyDisk() + ", to:" + this.val$saveAsPath);
      str = FileUtil.getParentPath(this.val$attach.getPreview().getMyDisk());
      Object localObject = FileUtil.getAttachDownloadDir();
      if (StringExtention.isFileDirEqual(str, this.val$saveAsPath))
      {
        QMLog.log(4, "DownloadUtil", "same path");
        return;
      }
      if (StringExtention.isFileDirEqual(str, (String)localObject))
      {
        str = DownloadUtil.access$000(this.val$attach.getPreview().getMyDisk(), this.val$saveAsPath, this.val$attach.getName());
        QMLog.log(4, "DownloadUtil", "save from default download dir to: " + str);
        if (!StringExtention.isNullOrEmpty(str))
        {
          this.val$attach.getPreview().setMyDisk(str);
          if (this.val$isFtn)
          {
            localObject = ((MailBigAttach)this.val$attach).getFid();
            DownloadInfoManager.shareInstance().updateDownloadInfoPathByFid((String)localObject, str);
            DownloadInfoManager.shareInstance().updateFtnDisk((String)localObject, str);
            QMWatcherCenter.triggerRenderAttach();
            return;
          }
          DownloadInfoManager.shareInstance().updateDownloadInfoPathByAttachId(this.val$attach.getHashId(), str);
          localObject = DownloadInfoManager.shareInstance();
          long l = this.val$attach.getHashId();
          if ((this.val$attach instanceof MailBigAttach)) {}
          for (int i = 1;; i = 0)
          {
            ((DownloadInfoManager)localObject).updateAttachDisk(l, i, this.val$attach.getDisplayName(), str);
            break;
          }
        }
        Threads.runOnMainThread(new DownloadUtil.1.1(this));
        return;
      }
      str = DownloadUtil.fileCopyTo(this.val$attach.getPreview().getMyDisk(), this.val$saveAsPath, this.val$attach.getName());
      QMLog.log(4, "DownloadUtil", "save from other dir to:" + str);
    } while (!StringExtention.isNullOrEmpty(str));
    Threads.runOnMainThread(new DownloadUtil.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.util.DownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */