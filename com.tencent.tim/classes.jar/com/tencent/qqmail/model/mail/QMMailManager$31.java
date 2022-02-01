package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;

class QMMailManager$31
  implements MailManagerDelegate.DataCallback
{
  QMMailManager$31(QMMailManager paramQMMailManager, long paramLong, boolean paramBoolean, int paramInt) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    paramObject1 = this.this$0;
    long l = this.val$mailid;
    boolean bool = this.val$isUnread;
    paramObject1.unreadMails(new long[] { l }, bool, false);
    QMMailManager.access$400(this.this$0).resetFolderHasNew(this.val$folderId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.31
 * JD-Core Version:    0.7.0.1
 */