package com.tencent.qqmail.model.mail.rule;

import com.tencent.qqmail.model.qmdomain.Mail;

public abstract interface IRule
{
  public abstract void create();
  
  public abstract MailRuleInfo createRuleInfo(Object... paramVarArgs);
  
  public abstract boolean hit(Mail paramMail);
  
  public abstract void remove();
  
  public abstract void run(ApplyRuleCallback paramApplyRuleCallback);
  
  public abstract void run(Mail paramMail, ApplyRuleCallback paramApplyRuleCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.rule.IRule
 * JD-Core Version:    0.7.0.1
 */