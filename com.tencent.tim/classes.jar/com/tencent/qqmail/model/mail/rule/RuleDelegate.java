package com.tencent.qqmail.model.mail.rule;

import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.Mail;

public class RuleDelegate
{
  private RuleMoveTo moveTo;
  private RuleReject reject;
  
  public RuleDelegate(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.reject = new RuleReject(paramQMMailSQLiteHelper);
    this.moveTo = new RuleMoveTo(paramQMMailSQLiteHelper);
  }
  
  private IRule getHandler(MailRuleInfo paramMailRuleInfo)
  {
    if (paramMailRuleInfo.getAlias().equals("reject"))
    {
      this.reject.setRuleInfo(paramMailRuleInfo);
      return this.reject;
    }
    if (paramMailRuleInfo.getAlias().equals("moveto"))
    {
      this.moveTo.setRuleInfo(paramMailRuleInfo);
      return this.moveTo;
    }
    return null;
  }
  
  private IRule getHandler(String paramString)
  {
    if (paramString == "reject") {
      return this.reject;
    }
    if (paramString == "moveto") {
      return this.moveTo;
    }
    return null;
  }
  
  public void create(MailRuleInfo paramMailRuleInfo)
  {
    getHandler(paramMailRuleInfo).create();
  }
  
  public MailRuleInfo createRuleInfo(String paramString, Object... paramVarArgs)
  {
    return getHandler(paramString).createRuleInfo(paramVarArgs);
  }
  
  public boolean hit(Mail paramMail, MailRuleInfo paramMailRuleInfo)
  {
    return getHandler(paramMailRuleInfo).hit(paramMail);
  }
  
  public void remove(MailRuleInfo paramMailRuleInfo)
  {
    getHandler(paramMailRuleInfo).remove();
  }
  
  public void run(MailRuleInfo paramMailRuleInfo, ApplyRuleCallback paramApplyRuleCallback)
  {
    getHandler(paramMailRuleInfo).run(paramApplyRuleCallback);
  }
  
  public void run(MailRuleInfo paramMailRuleInfo, Mail paramMail, ApplyRuleCallback paramApplyRuleCallback)
  {
    getHandler(paramMailRuleInfo).run(paramMail, paramApplyRuleCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.rule.RuleDelegate
 * JD-Core Version:    0.7.0.1
 */