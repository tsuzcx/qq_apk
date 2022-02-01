package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.download.watcher.ProtocolAttachDownloadWatcher;
import com.tencent.qqmail.model.mail.callback.LoadMailAttachCallBack;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import moai.core.watcher.Watchers;
import moai.oss.OssHelper;

class QMMailProtocolManager$31
  implements LoadMailAttachCallBack
{
  QMMailProtocolManager$31(QMMailProtocolManager paramQMMailProtocolManager, long paramLong1, long paramLong2, Profile paramProfile, Attach paramAttach) {}
  
  public void onError(QMProtocolError paramQMProtocolError)
  {
    OssHelper.protocolAttachDownloadFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "QMMailProtocolManager", FileUtil.getFileNameSuffix(this.val$attach.getName()), paramQMProtocolError.getCode() + ":" + paramQMProtocolError.getMessage() });
    QMWatcherCenter.triggerDownloadAttachError(this.val$mailId, this.val$attachId, "", paramQMProtocolError.getMessage(), this.val$profile.protocolType, paramQMProtocolError);
    paramQMProtocolError = (ProtocolAttachDownloadWatcher)QMWatcherCenter.getDownloadWatcherById(this.val$attachId);
    if (paramQMProtocolError != null)
    {
      Watchers.bind(paramQMProtocolError, false);
      QMWatcherCenter.bindDownloadAttachListener(paramQMProtocolError, false);
    }
  }
  
  public boolean onProgress(long paramLong1, long paramLong2)
  {
    ProtocolAttachDownloadWatcher localProtocolAttachDownloadWatcher = (ProtocolAttachDownloadWatcher)QMWatcherCenter.getDownloadWatcherById(this.val$attachId);
    if ((localProtocolAttachDownloadWatcher == null) || (localProtocolAttachDownloadWatcher.isAbort())) {
      return true;
    }
    QMWatcherCenter.triggerDownloadAttachProgress(this.val$mailId, this.val$attachId, paramLong2, paramLong1, this.val$profile.protocolType);
    return false;
  }
  
  public void onSuccess(String paramString, Attach paramAttach)
  {
    if (paramAttach != null) {
      OssHelper.protocolAttachDownloadSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "QMMailProtocolManager", FileUtil.getFileNameSuffix(paramAttach.getName()), "" });
    }
    QMWatcherCenter.triggerDownloadAttachSuccess(this.val$mailId, this.val$attachId, paramString, "", this.val$profile.protocolType);
    paramString = (ProtocolAttachDownloadWatcher)QMWatcherCenter.getDownloadWatcherById(this.val$attachId);
    if (paramString != null)
    {
      Watchers.bind(paramString, false);
      QMWatcherCenter.bindDownloadAttachListener(paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.31
 * JD-Core Version:    0.7.0.1
 */