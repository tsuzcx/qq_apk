package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.rule.ApplyRuleCallback;
import com.tencent.qqmail.model.mail.rule.MailRuleInfo;
import java.util.ArrayList;

class QMMailManager$6$1
  extends ApplyRuleCallback
{
  QMMailManager$6$1(QMMailManager.6 param6, ArrayList paramArrayList) {}
  
  public void onHandleHitMails(long[] paramArrayOfLong, MailRuleInfo paramMailRuleInfo)
  {
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      this.val$allMailIds.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.6.1
 * JD-Core Version:    0.7.0.1
 */