package com.tencent.qqmail.download;

import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.download.model.BigAttachDownloadError;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import moai.oss.OssHelper;

class AttachDownloadManager$3
  implements DownloadTaskListener
{
  AttachDownloadManager$3(AttachDownloadManager paramAttachDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void onAbort(long paramLong, String arg3)
  {
    QMLog.log(6, "AttachDownloadManager", "attach download abort:" + ???);
    if (paramLong == DownloadUtil.getDownloadTaskId(this.val$info.getKey()))
    {
      this.val$info.setStatus(6);
      if (this.val$info.isShouldUpdateInfo()) {
        AttachDownloadManager.access$100(this.this$0).updateDownloadInfo(this.val$info);
      }
      if (this.val$info.isNotify())
      {
        this.val$info.setIsNotify(false);
        AttachDownloadManager.access$600(this.this$0).cancel(this.val$info.getNotificationId());
      }
    }
    synchronized (AttachDownloadManager.access$300(this.this$0))
    {
      AttachDownloadManager.access$300(this.this$0).remove(Long.valueOf(paramLong));
      AttachDownloadManager.access$700(this.this$0).remove(Long.valueOf(paramLong));
      return;
    }
  }
  
  public void onFail(long paramLong, String arg3, DownloadTaskError paramDownloadTaskError)
  {
    QMLog.log(6, "AttachDownloadManager", "attach download fail:" + ??? + ", path:" + this.val$info.getFilePath() + ", type:" + this.val$info.getAttachType() + ", error:" + paramDownloadTaskError.getErrorCode() + "," + paramDownloadTaskError.getMessage());
    if (paramLong == DownloadUtil.getDownloadTaskId(this.val$info.getKey()))
    {
      QMLog.log(6, "AttachDownloadManager", "downloadSize:" + this.val$info.getDownloadSize() + ", fileSize:" + this.val$info.getFileSize());
      if (paramDownloadTaskError != null)
      {
        if (paramDownloadTaskError.getErrorCode() != 1) {
          break label294;
        }
        this.val$info.setStatus(3);
      }
    }
    Object localObject2;
    for (;;)
    {
      if (this.val$info.isShouldUpdateInfo()) {
        AttachDownloadManager.access$100(this.this$0).updateDownloadInfo(this.val$info);
      }
      if (this.val$info.isNotify()) {}
      synchronized (AttachDownloadManager.access$300(this.this$0))
      {
        localObject2 = (ArrayList)AttachDownloadManager.access$300(this.this$0).get(Long.valueOf(paramLong));
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break label524;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        ((AttachDownloadListener)((Iterator)localObject2).next()).onError(this.val$info.getUrl(), paramDownloadTaskError);
      }
      label294:
      this.val$info.setStatus(5);
      if ((paramDownloadTaskError.getErrorCode() == 6) && (this.val$info.getAttachType() == 0))
      {
        ??? = AttachDownloadManager.access$800(this.this$0, this.val$info, paramDownloadTaskError.getMessage());
        if (??? != null)
        {
          QMLog.log(6, "AttachDownloadManager", "download cgi error:" + ((QMCGIError)???).getCode() + "," + ((QMCGIError)???).getMessage());
          if (((QMCGIError)???).isSessionTimeouted()) {
            synchronized (AttachDownloadManager.access$900(this.this$0))
            {
              AttachDownloadManager.access$900(this.this$0).put(Integer.valueOf(this.val$info.getAccountId()), Boolean.valueOf(true));
              this.this$0.addDownloadInfoIntoWait(this.val$info);
              this.this$0.autoLoginForDownload(this.val$info.getAccountId());
              return;
            }
          }
        }
      }
      else if (paramDownloadTaskError.getErrorCode() == 5)
      {
        this.val$info.setStatus(5);
        DataCollector.logDetailEvent("DetailEvent_SSL_Error", 0L, -1L, paramDownloadTaskError.getMessage());
        QMSettingManager.sharedInstance().setSSLErrorTime(System.currentTimeMillis());
      }
    }
    AttachDownloadManager.access$300(this.this$0).remove(Long.valueOf(paramLong));
    label524:
    if (this.val$info.isShouldUpdateInfo()) {
      QMWatcherCenter.triggerDownloadError(this.val$info.getId(), this.val$info.getAttachId(), paramDownloadTaskError);
    }
    AttachDownloadManager.access$700(this.this$0).remove(Long.valueOf(paramLong));
    if ((this.val$info.getAttachType() == 1) || (this.val$info.getAttachType() == 2))
    {
      localObject2 = (BigAttachDownloadError)AttachDownloadManager.access$000(this.this$0).get(???);
      AttachDownloadManager.access$000(this.this$0).remove(???);
      if (localObject2 != null)
      {
        ??? = ((BigAttachDownloadError)localObject2).getSvrIp();
        if (localObject2 == null) {
          break label923;
        }
        localObject2 = ((BigAttachDownloadError)localObject2).getSvrCode();
        label645:
        ??? = (String)??? + ":" + (String)localObject2 + ":" + paramDownloadTaskError.getErrorCode() + ":" + paramDownloadTaskError.getMessage();
        QMLog.log(6, "AttachDownloadManager", (String)???);
        if (this.val$info.getAttachType() != 1) {
          break label931;
        }
        OssHelper.bigattachDownloadFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachDownloadManager", FileUtil.getFileNameSuffix(this.val$info.getFileName()), ??? });
      }
    }
    for (;;)
    {
      OssHelper.errorReport(new Object[] { Integer.valueOf(1), Long.valueOf(40264L), "", Integer.valueOf(1), "attach_download_fail", Integer.valueOf(78502587), Integer.valueOf(1), "attach", Uri.parse(???).getPath(), Integer.valueOf(0), Integer.valueOf(paramDownloadTaskError.getErrorCode()), paramDownloadTaskError.getMessage(), ??? });
      return;
      ??? = "";
      break;
      label923:
      localObject2 = "";
      break label645;
      label931:
      OssHelper.ftnattachDownloadFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachDownloadManager", FileUtil.getFileNameSuffix(this.val$info.getFileName()), ??? });
      continue;
      if (this.val$info.getAttachType() == 0) {
        OssHelper.attachDownloadFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachDownloadManager", FileUtil.getFileNameSuffix(this.val$info.getFileName()), paramDownloadTaskError.getErrorCode() + ":" + paramDownloadTaskError.getMessage() });
      }
    }
  }
  
  public void onProgress(long paramLong1, String arg3, long paramLong2, long paramLong3)
  {
    if (paramLong1 == DownloadUtil.getDownloadTaskId(this.val$info.getKey()))
    {
      if (!this.val$info.isFixProcess()) {
        break label265;
      }
      long l = (paramLong2 * 0.75D);
      paramLong2 = l;
      if (l >= paramLong3) {
        paramLong2 = paramLong3;
      }
    }
    label265:
    for (;;)
    {
      this.val$info.setDownloadSize(paramLong2);
      if ((this.val$info.getStatus() != 2) && (this.val$info.getStatus() != 6))
      {
        this.val$info.setStatus(2);
        if (this.val$info.isShouldUpdateInfo()) {
          AttachDownloadManager.access$100(this.this$0).updateDownloadInfoStatus(this.val$info);
        }
      }
      if (this.val$info.isNotify()) {
        AttachDownloadManager.access$200(this.this$0, this.val$info);
      }
      synchronized (AttachDownloadManager.access$300(this.this$0))
      {
        Object localObject1 = (ArrayList)AttachDownloadManager.access$300(this.this$0).get(Long.valueOf(paramLong1));
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          if (((Iterator)localObject1).hasNext()) {
            ((AttachDownloadListener)((Iterator)localObject1).next()).onProgress(this.val$info.getUrl(), paramLong2, paramLong3);
          }
        }
      }
      if (this.val$info.isShouldUpdateInfo()) {
        QMWatcherCenter.triggerDownloadProgress(this.val$info.getId(), this.val$info.getAttachId(), paramLong2, paramLong3);
      }
      return;
    }
  }
  
  public void onStart(long paramLong, String paramString)
  {
    QMLog.log(4, "AttachDownloadManager", "attach download beforeSend:" + paramString + ", path:" + this.val$info.getFilePath());
    if (paramLong == DownloadUtil.getDownloadTaskId(this.val$info.getKey()))
    {
      this.val$info.setStatus(1);
      if (this.val$info.isShouldUpdateInfo()) {
        AttachDownloadManager.access$100(this.this$0).updateDownloadInfo(this.val$info);
      }
      if (this.val$info.getAttachDownloadListener() != null) {
        this.val$info.getAttachDownloadListener().onBeforeSend(paramString);
      }
    }
  }
  
  public void onSuccess(long paramLong, String paramString1, String arg4)
  {
    QMLog.log(4, "AttachDownloadManager", "attach download complete:" + paramString1 + ", path:" + ???);
    Object localObject;
    if ((paramLong == DownloadUtil.getDownloadTaskId(this.val$info.getKey())) && (!StringExtention.isNullOrEmpty(???)))
    {
      localObject = new File(???);
      QMLog.log(4, "AttachDownloadManager", "file size:" + ((File)localObject).length() + ", svr size:" + this.val$info.getFileSize());
      if (((File)localObject).exists()) {
        break label172;
      }
      QMLog.log(6, "AttachDownloadManager", "attach download file disappear:" + ???);
      onFail(paramLong, paramString1, new DownloadTaskError(-1000, "download error:file not exist"));
    }
    label172:
    label722:
    label733:
    label748:
    do
    {
      return;
      if ((DownloadUtil.isDownloadFileSizeError(((File)localObject).length(), this.val$info.getFileSize())) && (AttachDownloadManager.access$400(this.this$0, this.val$info.getAttachType())))
      {
        QMLog.log(6, "AttachDownloadManager", "attach download file size error:" + ((File)localObject).length() + ", server:" + this.val$info.getFileSize());
        this.val$info.setDownloadSize(0L);
        Threads.runInBackground(new AttachDownloadManager.3.1(this, (File)localObject));
        onFail(paramLong, paramString1, new DownloadTaskError(-1000, "download file size error local:" + ((File)localObject).length() + " server:" + this.val$info.getFileSize() + ", detail:" + FileUtil.readString(???, 64L, Charset.forName("ISO-8859-1"))));
        return;
      }
      QMLog.log(4, "AttachDownloadManager", "attach download size: " + ((File)localObject).length());
      this.val$info.setFilePath(???);
      this.val$info.setStatus(4);
      this.val$info.setDisplayName(((File)localObject).getName());
      paramString1 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(this.val$info.getFilePath())));
      QMApplicationContext.sharedInstance().sendBroadcast(paramString1);
      if ((this.val$info.getAttachType() != 2) || (this.val$info.isShouldUpdateInfo()))
      {
        AttachDownloadManager.access$100(this.this$0).updateDownloadInfo(this.val$info);
        if (this.val$info.getAttachType() == 2) {
          AttachDownloadManager.access$100(this.this$0).updateFtnDisk(this.val$info.getFid(), this.val$info.getFilePath());
        }
      }
      else
      {
        if (this.val$info.isNotify()) {
          AttachDownloadManager.access$500(this.this$0, this.val$info);
        }
        AttachDownloadManager.access$600(this.this$0).cancel(this.val$info.getNotificationId());
        if (!StringExtention.isNullOrEmpty(this.val$info.getSaveAsPath())) {
          break label722;
        }
      }
      for (paramString1 = "";; paramString1 = this.val$info.getFilePath())
      {
        synchronized (AttachDownloadManager.access$300(this.this$0))
        {
          localObject = (ArrayList)AttachDownloadManager.access$300(this.this$0).get(Long.valueOf(paramLong));
          if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
            break label748;
          }
          localObject = ((ArrayList)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label733;
          }
          ((AttachDownloadListener)((Iterator)localObject).next()).onSuccess(this.val$info.getUrl(), new File(this.val$info.getFilePath()), paramString1);
        }
        AttachDownloadManager.access$100(this.this$0).updateAttachDisk(this.val$info.getAttachId(), this.val$info.getAttachType(), this.val$info.getDisplayName(), this.val$info.getFilePath());
        break;
      }
      AttachDownloadManager.access$300(this.this$0).remove(Long.valueOf(paramLong));
      if (this.val$info.isShouldUpdateInfo()) {
        QMWatcherCenter.triggerDownloadSuccess(this.val$info.getId(), this.val$info.getAttachId(), this.val$info.getFilePath(), paramString1);
      }
      AttachDownloadManager.access$700(this.this$0).remove(Long.valueOf(paramLong));
      if (this.val$info.getAttachType() == 1)
      {
        OssHelper.bigattachDownloadSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachDownloadManager", FileUtil.getFileNameSuffix(this.val$info.getFileName()), "" });
        return;
      }
      if (this.val$info.getAttachType() == 0)
      {
        OssHelper.attachDownloadSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachDownloadManager", FileUtil.getFileNameSuffix(this.val$info.getFileName()), "" });
        return;
      }
    } while (this.val$info.getAttachType() != 2);
    OssHelper.ftnattachDownloadSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachDownloadManager", FileUtil.getFileNameSuffix(this.val$info.getFileName()), "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.AttachDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */