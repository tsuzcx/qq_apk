package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.rule.ApplyRuleCallback;
import com.tencent.qqmail.model.mail.rule.MailRuleInfo;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import java.util.HashSet;

class QMMailProtocolManager$19$1
  extends ApplyRuleCallback
{
  QMMailProtocolManager$19$1(QMMailProtocolManager.19 param19, int paramInt1, int paramInt2, int paramInt3, MailInformation paramMailInformation) {}
  
  public void onHandleHitMails(long[] paramArrayOfLong, MailRuleInfo paramMailRuleInfo)
  {
    if (this.val$folderId == this.val$inboxFolderId)
    {
      if (!paramMailRuleInfo.getAlias().equals("reject")) {
        break label65;
      }
      QMMailProtocolManager.access$200(this.this$1.this$0).moveMails(this.val$inboxFolderId, this.val$trashFolderId, paramArrayOfLong);
      this.this$1.val$ruleAppliedMailIds.add(this.val$mailInfo.getRemoteId());
    }
    label65:
    while (!paramMailRuleInfo.getAlias().equals("moveto")) {
      return;
    }
    QMMailProtocolManager.access$200(this.this$1.this$0).moveMails(this.val$inboxFolderId, Integer.parseInt(paramMailRuleInfo.getParam()), paramArrayOfLong);
    this.this$1.val$ruleAppliedMailIds.add(this.val$mailInfo.getRemoteId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.19.1
 * JD-Core Version:    0.7.0.1
 */