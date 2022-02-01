package com.tencent.qqmail.model.task;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.marcos.CommonMatch;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.DownloadImgWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringEscapeUtils;

public class QMInlineImgDownloadTask
  extends QMDownloadTask
{
  private static final String TAG = "QMInlineImgDownloadTask";
  private ArrayList<DownloadImgWatcher> downloadImgWatchers = new ArrayList();
  private boolean isAbort = false;
  private boolean isProtocol = false;
  private int mAccountId;
  private Attach mAttach;
  private Mail mMail;
  private long mMailId;
  
  public QMInlineImgDownloadTask(String paramString, int paramInt, long paramLong)
  {
    super(paramString);
    this.mMailId = paramLong;
    this.mAccountId = paramInt;
    this.isProtocol = false;
  }
  
  public QMInlineImgDownloadTask(String paramString, Mail paramMail, Attach paramAttach)
  {
    super(paramString);
    this.mMail = paramMail;
    this.mAttach = paramAttach;
    this.isProtocol = true;
  }
  
  private void download()
  {
    if (this.isProtocol)
    {
      downloadProtocolInlineImg();
      return;
    }
    downloadQQInlineImg();
  }
  
  private void downloadProtocolInlineImg()
  {
    QMMailManager.sharedInstance().downloadProtocolInlineImg(this.mMail.getInformation(), this.mAttach, new QMInlineImgDownloadTask.2(this));
  }
  
  private void downloadQQInlineImg()
  {
    Object localObject2 = StringEscapeUtils.unescapeHtml4(getSrc());
    Object localObject1 = localObject2;
    if (CommonMatch.QQMAIL_CGI_PATTERN.matcher((CharSequence)localObject2).find()) {
      localObject1 = CGIManager.removeSid((String)localObject2);
    }
    localObject2 = new DownloadInfo();
    ((DownloadInfo)localObject2).setAccountId(this.mAccountId);
    ((DownloadInfo)localObject2).setUrl((String)localObject1);
    ((DownloadInfo)localObject2).setImageDownloadListener(new QMInlineImgDownloadTask.1(this));
    ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject2);
  }
  
  private void handleSuccess(String paramString1, String paramString2)
  {
    QMLog.log(4, "QMInlineImgDownloadTask", "inline image task download success:" + paramString2);
    triggerDownloadAttachSuccess(paramString1, paramString2);
    super.handleSucc(paramString1);
    handleComplete();
  }
  
  public void abort()
  {
    if (this.isProtocol)
    {
      this.isAbort = true;
      return;
    }
    String str2 = StringEscapeUtils.unescapeHtml4(getSrc());
    String str1 = str2;
    if (CommonMatch.QQMAIL_CGI_PATTERN.matcher(str2).find()) {
      str1 = CGIManager.removeSid(str2);
    }
    ImageDownloadManager.shareInstance().abort(str1);
  }
  
  public void bindDownloadImageWatcher(DownloadImgWatcher paramDownloadImgWatcher)
  {
    if (!this.downloadImgWatchers.contains(paramDownloadImgWatcher)) {
      this.downloadImgWatchers.add(paramDownloadImgWatcher);
    }
  }
  
  protected void handleError(Object paramObject)
  {
    QMLog.log(6, "QMInlineImgDownloadTask", "inline image task download error:" + getSrc());
    String str = "";
    if (paramObject != null) {
      str = paramObject.toString();
    }
    triggerDownloadAttachError(str, paramObject);
    super.handleError(paramObject);
    handleComplete();
  }
  
  protected void handleRunning(Long paramLong1, Long paramLong2)
  {
    triggerDownloadAttachProgress(paramLong2.longValue(), paramLong1.longValue());
    super.handleRunning(paramLong1, paramLong2);
  }
  
  public void release()
  {
    this.downloadImgWatchers.clear();
  }
  
  public void run()
  {
    download();
  }
  
  protected final void triggerDownloadAttachError(String paramString, Object paramObject)
  {
    Iterator localIterator = this.downloadImgWatchers.iterator();
    while (localIterator.hasNext()) {
      ((DownloadImgWatcher)localIterator.next()).onError(this.mMailId, getSrc(), paramString, paramObject);
    }
  }
  
  protected final void triggerDownloadAttachProgress(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.downloadImgWatchers.iterator();
    while (localIterator.hasNext()) {
      ((DownloadImgWatcher)localIterator.next()).onProcess(this.mMailId, getSrc(), paramLong1, paramLong2);
    }
  }
  
  protected final void triggerDownloadAttachSuccess(String paramString1, String paramString2)
  {
    paramString2 = this.downloadImgWatchers.iterator();
    while (paramString2.hasNext()) {
      ((DownloadImgWatcher)paramString2.next()).onSuccess(this.mMailId, getSrc(), paramString1);
    }
  }
  
  public void unbindDownloadImageWatcher(DownloadImgWatcher paramDownloadImgWatcher)
  {
    if (this.downloadImgWatchers.contains(paramDownloadImgWatcher)) {
      this.downloadImgWatchers.remove(paramDownloadImgWatcher);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMInlineImgDownloadTask
 * JD-Core Version:    0.7.0.1
 */