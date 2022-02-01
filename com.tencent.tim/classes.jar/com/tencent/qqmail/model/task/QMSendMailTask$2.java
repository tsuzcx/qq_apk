package com.tencent.qqmail.model.task;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.LoadMailWatcher;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;
import moai.core.watcher.Watchers;

class QMSendMailTask$2
  implements LoadMailWatcher
{
  QMSendMailTask$2(QMSendMailTask paramQMSendMailTask) {}
  
  public void onConvChildSuccess(long paramLong1, long paramLong2) {}
  
  public void onError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "QMSendMailTask", "readMailWatcher error:" + paramQMNetworkError.getMessage());
    Watchers.bind(QMSendMailTask.access$700(this.this$0), false);
    QMSendMailTask.access$1100(this.this$0);
  }
  
  public void onLocalSuccess(Mail paramMail) {}
  
  public void onProcess(long paramLong1, long paramLong2, long paramLong3)
  {
    double d = paramLong2 / paramLong2 * 0.5D;
    QMSendMailTask localQMSendMailTask = this.this$0;
    if (d > QMSendMailTask.access$500(this.this$0)) {}
    for (;;)
    {
      QMSendMailTask.access$502(localQMSendMailTask, d);
      QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(this.this$0.getId()));
      QMSendMailTask.access$600(this.this$0, QMSendMailTask.access$500(this.this$0));
      return;
      d = QMSendMailTask.access$500(this.this$0);
    }
  }
  
  public void onSuccess(long paramLong)
  {
    QMLog.log(4, "QMSendMailTask", "readMailWatcher onSuccess:" + paramLong);
    Watchers.bind(QMSendMailTask.access$700(this.this$0), false);
    QMSendMailTask.access$800(this.this$0).setOriginContentComplete(true);
    Object localObject4 = QMSendMailTask.access$800(this.this$0).getContent();
    Object localObject2 = QMSendMailTask.access$800(this.this$0).getInformation();
    Object localObject1 = QMSendMailTask.access$800(this.this$0).getAddAttachInfoList();
    if (localObject1 == null)
    {
      localObject1 = new ArrayList();
      QMSendMailTask.access$800(this.this$0).setAddAttachInfoList((ArrayList)localObject1);
    }
    for (;;)
    {
      Object localObject3 = QMMailManager.sharedInstance().readMailOrSearchMail(paramLong);
      localObject4 = ((MailContent)localObject4).getBody();
      Object localObject5 = ((Mail)localObject3).getContent().getBody();
      QMSendMailTask.access$800(this.this$0).getContent().setBody(((String)localObject4).replace(QMSendMailTask.access$900(this.this$0), (CharSequence)localObject5));
      localObject4 = ((Mail)localObject3).getInformation().getAttachList();
      int i;
      if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
      {
        ((MailInformation)localObject2).setAttachList((ArrayList)localObject4);
        i = 0;
        if (i < ((ArrayList)localObject4).size())
        {
          localObject5 = (Attach)((ArrayList)localObject4).get(i);
          String str1;
          String str2;
          if ((((Attach)localObject5).getProtocol() == null) || (!"inline".equals(((Attach)localObject5).getProtocol().getType())))
          {
            str1 = ((Attach)localObject5).getSize();
            str2 = ((Attach)localObject5).getName();
            if (((str2 != null) && (!str2.equals(""))) || ((str1 != null) && (!str1.equals("0.00B")))) {
              break label294;
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label294:
            String str3 = FileUtil.getFileNameSuffix(str2);
            AttachInfo localAttachInfo = new AttachInfo();
            localAttachInfo.setHashId(((Attach)localObject5).getHashId());
            localAttachInfo.setProtocolAttach(((Attach)localObject5).isProtocol());
            localAttachInfo.setProcessed(true);
            localAttachInfo.setForwardAttach(true);
            localAttachInfo.setAttach(localObject5);
            localAttachInfo.setAttachName(str2);
            localAttachInfo.setAttachSize(str1);
            localAttachInfo.setFileType(AttachType.valueOf(QMAttachUtils.attachFileType(str3)));
            localAttachInfo.setPreviewPath(((Attach)localObject5).getPreview().getDownloadUrl());
            ((ArrayList)localObject1).add(localAttachInfo);
          }
        }
      }
      localObject3 = ((Mail)localObject3).getInformation().getBigAttachList();
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        ((MailInformation)localObject2).setBigAttachList((ArrayList)localObject3);
        i = 0;
        while (i < ((ArrayList)localObject3).size())
        {
          localObject2 = (MailBigAttach)((ArrayList)localObject3).get(i);
          if (!QMSendMailTask.access$1000((ArrayList)localObject1, (MailBigAttach)localObject2))
          {
            localObject4 = new AttachInfo();
            ((AttachInfo)localObject4).setProcessed(true);
            ((AttachInfo)localObject4).setForwardAttach(true);
            ((AttachInfo)localObject4).setAttach(localObject2);
            ((AttachInfo)localObject4).setAttachName(((MailBigAttach)localObject2).getName());
            ((AttachInfo)localObject4).setBigAttach(true);
            ((AttachInfo)localObject4).setAttachSize(((MailBigAttach)localObject2).getSize());
            ((ArrayList)localObject1).add(localObject4);
          }
          i += 1;
        }
      }
      double d = 0.5D;
      localObject1 = this.this$0;
      if (0.5D > QMSendMailTask.access$500(this.this$0)) {}
      for (;;)
      {
        QMSendMailTask.access$502((QMSendMailTask)localObject1, d);
        QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(this.this$0.getId()));
        QMSendMailTask.access$600(this.this$0, QMSendMailTask.access$500(this.this$0));
        Watchers.bind(QMSendMailTask.access$700(this.this$0), false);
        this.this$0.run();
        return;
        d = QMSendMailTask.access$500(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.2
 * JD-Core Version:    0.7.0.1
 */