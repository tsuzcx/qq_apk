package com.tencent.qqmail.model.task;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.DownloadAttachWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;
import java.util.Iterator;

public class QMSendMailDownloadAttachTask
  extends QMDownloadTask
{
  private static final String TAG = "QMSendMailDownloadAttachTask";
  private Attach attach;
  private ArrayList<DownloadAttachWatcher> downloadAttachWatchers = new ArrayList();
  private Mail mail;
  
  public QMSendMailDownloadAttachTask(String paramString, Mail paramMail, Attach paramAttach)
  {
    super(paramString);
    this.mail = paramMail;
    this.attach = paramAttach;
    setAttachTaskId();
  }
  
  private void download()
  {
    if (this.mail == null) {
      return;
    }
    try
    {
      MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
      localMailManagerDelegate.setOnBeforeSend(new QMSendMailDownloadAttachTask.1(this));
      localMailManagerDelegate.setOnSuccess(new QMSendMailDownloadAttachTask.2(this));
      localMailManagerDelegate.setOnError(new QMSendMailDownloadAttachTask.3(this));
      localMailManagerDelegate.setOnComplete(new QMSendMailDownloadAttachTask.4(this));
      localMailManagerDelegate.setOnSendData(new QMSendMailDownloadAttachTask.5(this));
      QMMailManager.sharedInstance().downloadSendMailAttach(this.mail.getInformation(), this.attach, false, localMailManagerDelegate);
      return;
    }
    finally {}
  }
  
  private int getProtocolType()
  {
    int i = -1;
    if (this.attach.isProtocol()) {
      i = this.attach.getProtocol().getProtocolType();
    }
    return i;
  }
  
  private void setAttachTaskId()
  {
    if (this.attach.getHashId() != 0L) {
      setId(generateId("" + this.attach.getHashId()));
    }
  }
  
  public final void bindDownloadAttachListener(DownloadAttachWatcher paramDownloadAttachWatcher, boolean paramBoolean)
  {
    ArrayList localArrayList = this.downloadAttachWatchers;
    if (paramBoolean) {
      if (!localArrayList.contains(paramDownloadAttachWatcher)) {
        localArrayList.add(paramDownloadAttachWatcher);
      }
    }
    while (!localArrayList.contains(paramDownloadAttachWatcher)) {
      return;
    }
    localArrayList.remove(paramDownloadAttachWatcher);
  }
  
  protected void handleError(Object paramObject)
  {
    QMNetworkError localQMNetworkError = (QMNetworkError)paramObject;
    triggerDownloadAttachError(this.mail.getInformation().getId(), this.attach.getHashId(), localQMNetworkError.desp, getSrc(), getProtocolType(), localQMNetworkError);
    super.handleError(paramObject);
  }
  
  protected void handleRunning(Long paramLong1, Long paramLong2)
  {
    triggerDownloadAttachProgress(this.mail.getInformation().getId(), this.attach.getHashId(), paramLong2.longValue(), paramLong1.longValue(), getProtocolType());
    super.handleRunning(paramLong1, paramLong2);
  }
  
  protected void handleSucc(Object paramObject)
  {
    String str = (String)paramObject;
    this.attach.getPreview().setMyDisk(str);
    triggerDownloadAttachSuccess(this.mail.getInformation().getId(), this.attach.getHashId(), this.attach.getPreview().getMyDisk(), getSrc(), getProtocolType());
    super.handleSucc(paramObject);
  }
  
  public void release()
  {
    this.downloadAttachWatchers.clear();
  }
  
  public void run()
  {
    download();
  }
  
  protected final void triggerDownloadAttachError(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    Iterator localIterator = this.downloadAttachWatchers.iterator();
    while (localIterator.hasNext()) {
      ((DownloadAttachWatcher)localIterator.next()).onError(paramLong1, paramLong2, paramString2, paramString1, paramInt, paramObject);
    }
  }
  
  protected final void triggerDownloadAttachProgress(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    Iterator localIterator = this.downloadAttachWatchers.iterator();
    while (localIterator.hasNext()) {
      ((DownloadAttachWatcher)localIterator.next()).onProcess(paramLong1, paramLong2, paramLong3, paramLong4, paramInt);
    }
  }
  
  protected final void triggerDownloadAttachSuccess(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt)
  {
    Iterator localIterator = this.downloadAttachWatchers.iterator();
    while (localIterator.hasNext()) {
      ((DownloadAttachWatcher)localIterator.next()).onSuccess(paramLong1, paramLong2, paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailDownloadAttachTask
 * JD-Core Version:    0.7.0.1
 */