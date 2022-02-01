package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.LoadEmlCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;

class QMMailProtocolManager$35
  implements LoadEmlCallback
{
  QMMailProtocolManager$35(QMMailProtocolManager paramQMMailProtocolManager, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt) {}
  
  public void loadFail() {}
  
  public void loadSuccess(Mail paramMail)
  {
    QMMailProtocolManager.access$1600(this.this$0, paramMail, this.val$attachId, this.val$isBigAttach, this.val$isFtn, this.val$fid);
    QMWatcherCenter.triggerParseEmlSuccess(this.val$accountId, paramMail.getInformation().getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.35
 * JD-Core Version:    0.7.0.1
 */