package com.tencent.qqmail.model.mail.rule;

import com.tencent.qqmail.model.qmdomain.Mail;

public abstract interface IApplyRuleCallback
{
  public abstract boolean needAction();
  
  public abstract boolean onAction(Mail paramMail, MailRuleInfo paramMailRuleInfo);
  
  public abstract void onHandleHitMails(long[] paramArrayOfLong, MailRuleInfo paramMailRuleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.rule.IApplyRuleCallback
 * JD-Core Version:    0.7.0.1
 */