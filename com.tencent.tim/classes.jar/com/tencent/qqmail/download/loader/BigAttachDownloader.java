package com.tencent.qqmail.download.loader;

import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.activity.DownloadActivity;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import org.apache.http.impl.cookie.BasicClientCookie;

public class BigAttachDownloader
{
  private static final String TAG = "BigAttachLoader";
  private boolean isAbort;
  private MailBigAttach mAttach;
  private MailManagerDelegate mCallback;
  private String mCookie;
  private JSONObject mData;
  private String mDirectDownUrl;
  private boolean mIsNotify;
  private String mOriUrl;
  private String mSaveAsPath;
  private boolean mShouldUpdateInfo = true;
  
  public BigAttachDownloader(MailBigAttach paramMailBigAttach, String paramString, boolean paramBoolean)
  {
    this.mAttach = paramMailBigAttach;
    this.mSaveAsPath = paramString;
    this.mOriUrl = QMAttachUtils.removeIllegalString(this.mAttach.getPreview().getDownloadUrl());
    this.mIsNotify = paramBoolean;
  }
  
  public BigAttachDownloader(MailBigAttach paramMailBigAttach, boolean paramBoolean, MailManagerDelegate paramMailManagerDelegate)
  {
    this.mAttach = paramMailBigAttach;
    this.mCallback = paramMailManagerDelegate;
    this.mOriUrl = QMAttachUtils.removeIllegalString(this.mAttach.getPreview().getDownloadUrl());
    this.mIsNotify = false;
    this.mShouldUpdateInfo = paramBoolean;
  }
  
  private void doDownload(String paramString)
  {
    Object localObject = new BasicClientCookie("qm_ftn_key", this.mCookie);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).setAttachId(this.mAttach.getHashId());
    ((DownloadInfo)localObject).setAccountId(this.mAttach.getAccountId());
    ((DownloadInfo)localObject).setKey(this.mOriUrl);
    ((DownloadInfo)localObject).setUrl(paramString);
    ((DownloadInfo)localObject).setFileSize(StringExtention.sizeStrToLong(this.mAttach.getSize()));
    ((DownloadInfo)localObject).setFileName(this.mAttach.getName());
    ((DownloadInfo)localObject).setFilePath(this.mAttach.getPreview().getMyDisk());
    ((DownloadInfo)localObject).setSaveAsPath(this.mSaveAsPath);
    ((DownloadInfo)localObject).setIsNotify(this.mIsNotify);
    ((DownloadInfo)localObject).setIntent(DownloadActivity.createIntent());
    ((DownloadInfo)localObject).setNotificationId((int)this.mAttach.getHashId());
    ((DownloadInfo)localObject).setIsFixProcess(false);
    ((DownloadInfo)localObject).setCookies(localArrayList);
    ((DownloadInfo)localObject).setAttachType(1);
    ((DownloadInfo)localObject).setDownloadType(1);
    ((DownloadInfo)localObject).setShouldUpdateInfo(this.mShouldUpdateInfo);
    ((DownloadInfo)localObject).setAttachDownloadListener(new BigAttachDownloader.1(this));
    AttachDownloadManager.shareInstance().fetchAttach((DownloadInfo)localObject);
  }
  
  private QMCallback getCookieCallback()
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new BigAttachDownloader.3(this));
    localQMCallback.setOnError(new BigAttachDownloader.4(this));
    return localQMCallback;
  }
  
  private QMCallback getDownUrlCallback(boolean paramBoolean)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new BigAttachDownloader.5(this, paramBoolean));
    localQMCallback.setOnError(new BigAttachDownloader.6(this));
    return localQMCallback;
  }
  
  public void abort()
  {
    this.isAbort = true;
    AttachDownloadManager.shareInstance().abort(this.mOriUrl);
  }
  
  public void download()
  {
    this.isAbort = false;
    if ((this.mCookie != null) && (this.mData != null))
    {
      getInfoFromCGIDone();
      return;
    }
    AttachDownloadManager.shareInstance().fetchBigAttachData(this.mOriUrl, this.mAttach.getAccountId(), getCookieCallback(), getDownUrlCallback(false));
  }
  
  public void getInfoFromCGIDone()
  {
    String str1;
    if ((this.mCookie != null) && (this.mData != null))
    {
      str1 = (String)this.mData.get("errcode");
      this.mDirectDownUrl = ((String)this.mData.get("fileurl"));
      String str2 = (String)this.mData.get("errormsg");
      QMLog.log(4, "BigAttachLoader", "errorCode:" + str1 + ",errorMsg:" + str2 + ", dirUrl:" + this.mDirectDownUrl + ", cookie:" + this.mCookie);
      if (str1.equals("0")) {
        Threads.runOnMainThread(new BigAttachDownloader.2(this));
      }
    }
    else
    {
      return;
    }
    handleErrorCode(str1);
    if (this.mCallback != null) {
      this.mCallback.handleError(new DownloadTaskError(Integer.valueOf(str1).intValue()));
    }
    QMWatcherCenter.triggerDownloadError(0, this.mAttach.getHashId(), new DownloadTaskError(Integer.valueOf(str1).intValue()));
    abort();
  }
  
  public void handleErrorCode(String paramString)
  {
    if (paramString.equals("-6"))
    {
      QMLog.log(6, "BigAttachLoader", "big attach expire or delete");
      QMAttachManager.sharedInstance().updateBigAttachExpire(this.mAttach.getHashId(), -2L);
      QMNotification.postNotification("ftnfailexpired", QMNotification.createNotification(new Object[] { "ftnfailexpired", Long.valueOf(this.mAttach.getHashId()) }));
      return;
    }
    if (paramString.equals("-102"))
    {
      QMLog.log(6, "BigAttachLoader", "big attach download exceed limit");
      QMNotification.postNotification("ftn_fail_exceed_limit", QMNotification.createNotification(new Object[] { "ftn_fail_exceed_limit", Long.valueOf(this.mAttach.getHashId()) }));
      return;
    }
    QMLog.log(6, "BigAttachLoader", "big attach get info other error:" + paramString);
    QMNotification.postNotification("ftn_fail_get_information", QMNotification.createNotification(new Object[] { "ftn_fail_get_information", Long.valueOf(this.mAttach.getHashId()) }));
  }
  
  public void refreshBigAttach()
  {
    AttachDownloadManager.shareInstance().refreshBigAttach(this.mOriUrl, this.mAttach.getAccountId(), getDownUrlCallback(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.BigAttachDownloader
 * JD-Core Version:    0.7.0.1
 */