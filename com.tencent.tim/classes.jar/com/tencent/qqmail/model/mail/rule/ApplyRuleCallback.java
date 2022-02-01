package com.tencent.qqmail.model.mail.rule;

import com.tencent.qqmail.model.qmdomain.Mail;

public class ApplyRuleCallback
  implements IApplyRuleCallback
{
  public boolean needAction()
  {
    return false;
  }
  
  public boolean onAction(Mail paramMail, MailRuleInfo paramMailRuleInfo)
  {
    return true;
  }
  
  public void onHandleHitMails(long[] paramArrayOfLong, MailRuleInfo paramMailRuleInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.rule.ApplyRuleCallback
 * JD-Core Version:    0.7.0.1
 */