package com.tencent.qqmail.model.mail.loader;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.model.mail.watcher.DownloadImgWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.task.QMInlineImgDownloadTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MailContentLoader$2
  implements Runnable
{
  MailContentLoader$2(MailContentLoader paramMailContentLoader, ArrayList paramArrayList) {}
  
  public void run()
  {
    MailContentLoader.access$202(this.this$0, new ArrayList());
    DownloadImgWatcher localDownloadImgWatcher = MailContentLoader.access$300(this.this$0);
    int i = 0;
    Object localObject3;
    String str;
    label211:
    Object localObject4;
    if (i < MailContentLoader.access$400(this.this$0).size())
    {
      localObject3 = (String)MailContentLoader.access$400(this.this$0).get(i);
      str = MailContentLoader.transformUrl((String)localObject3);
      localObject1 = MailContentLoader.access$500(this.this$0, str);
      if (!"".equals(localObject1))
      {
        QMLog.log(4, MailContentLoader.TAG, "downloaded:" + str + ", path:" + (String)localObject1);
        MailContentLoader.access$100(this.this$0, (String)localObject3, str, (String)localObject1, true);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!str.startsWith("file://")) {
          break label211;
        }
        QMLog.log(4, MailContentLoader.TAG, "local:" + str);
        if (this.this$0.mCallback != null) {
          this.this$0.mCallback.onSuccess((String)localObject3, str.replace("file://localhost", ""));
        }
      }
      if (str.startsWith("cid:"))
      {
        if (this.val$attachList == null) {
          break label699;
        }
        localObject1 = this.val$attachList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject4 = ((Iterator)localObject1).next();
        } while ((!(localObject4 instanceof Attach)) || (!MailContentLoader.sameCid((Attach)localObject4, str)));
      }
    }
    label699:
    Object localObject2;
    for (Object localObject1 = (Attach)localObject4;; localObject2 = null)
    {
      if (localObject1 != null)
      {
        if (((Attach)localObject1).isExist())
        {
          QMLog.log(4, MailContentLoader.TAG, "cid inline: " + str + ", path:" + ((Attach)localObject1).getPreview().getMyDisk());
          MailContentLoader.access$100(this.this$0, (String)localObject3, str, ((Attach)localObject1).getPreview().getMyDisk(), false);
          break;
        }
        QMLog.log(4, MailContentLoader.TAG, "new download cid inline:" + str);
        localObject4 = MailContentLoader.access$600(this.this$0, this.this$0.mTaskMgr, str);
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = new QMInlineImgDownloadTask(str, MailContentLoader.access$700(this.this$0), (Attach)localObject1);
        }
        if (localDownloadImgWatcher != null) {
          ((QMInlineImgDownloadTask)localObject3).bindDownloadImageWatcher(localDownloadImgWatcher);
        }
        MailContentLoader.access$200(this.this$0).add(localObject3);
        break;
      }
      QMLog.log(6, MailContentLoader.TAG, "not found cid:" + str);
      if (this.this$0.mCallback == null) {
        break;
      }
      this.this$0.mCallback.onError((String)localObject3, "not found cid!");
      break;
      if (str.startsWith("data:image/"))
      {
        QMLog.log(4, MailContentLoader.TAG, "data:image");
        break;
      }
      QMLog.log(4, MailContentLoader.TAG, "http inline:" + str);
      localObject3 = MailContentLoader.access$600(this.this$0, this.this$0.mTaskMgr, str);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new QMInlineImgDownloadTask(str, MailContentLoader.access$700(this.this$0).getInformation().getAccountId(), MailContentLoader.access$700(this.this$0).getInformation().getId());
      }
      if (localDownloadImgWatcher != null) {
        ((QMInlineImgDownloadTask)localObject1).bindDownloadImageWatcher(localDownloadImgWatcher);
      }
      MailContentLoader.access$200(this.this$0).add(localObject1);
      break;
      if (MailContentLoader.access$200(this.this$0).size() > 0) {}
      try
      {
        this.this$0.mTaskMgr.setTaskList(Lists.newArrayList(MailContentLoader.access$200(this.this$0)));
        this.this$0.mTaskMgr.startMainLoop();
        return;
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.MailContentLoader.2
 * JD-Core Version:    0.7.0.1
 */