package com.tencent.qqmail.model.mail.rule;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;

public class RuleReject
  extends Rule
{
  private MailRuleInfo rule;
  private QMMailSQLiteHelper sqliteHelper;
  
  public RuleReject(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
  }
  
  public MailRuleInfo createRuleInfo(Object... paramVarArgs)
  {
    MailRuleInfo localMailRuleInfo = new MailRuleInfo();
    localMailRuleInfo.setAlias("reject");
    localMailRuleInfo.setFieldName(0);
    localMailRuleInfo.setOperator(0);
    localMailRuleInfo.setAction(0);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      int i = Integer.parseInt(paramVarArgs[0] + "");
      localMailRuleInfo.setAccountId(i);
      localMailRuleInfo.setVal(paramVarArgs[1] + "");
      localMailRuleInfo.setParam(QMFolderManager.sharedInstance().getTrashFolderId(i) + "");
    }
    localMailRuleInfo.setId(localMailRuleInfo.generateId());
    return localMailRuleInfo;
  }
  
  protected MailRuleInfo getRuleInfo()
  {
    return this.rule;
  }
  
  protected QMMailSQLiteHelper getSQLiteHelper()
  {
    return this.sqliteHelper;
  }
  
  public boolean hit(Mail paramMail)
  {
    boolean bool = true;
    if (!paramMail.getInformation().getFrom().getAddress().equals(this.rule.getVal())) {
      bool = false;
    }
    if (paramMail.getInformation().getAccountId() != this.rule.getAccountId()) {
      bool = false;
    }
    int i = QMFolderManager.sharedInstance().getInboxFolderId(this.rule.getAccountId());
    if (paramMail.getInformation().getFolderId() != i) {
      return false;
    }
    return bool;
  }
  
  protected void setRuleInfo(MailRuleInfo paramMailRuleInfo)
  {
    this.rule = paramMailRuleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.rule.RuleReject
 * JD-Core Version:    0.7.0.1
 */