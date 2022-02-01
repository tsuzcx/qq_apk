package com.tencent.qqmail.model.mail.rule;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;

public abstract class Rule
  implements IRule
{
  public void create()
  {
    QMMailSQLiteHelper localQMMailSQLiteHelper = getSQLiteHelper();
    SQLiteDatabase localSQLiteDatabase = localQMMailSQLiteHelper.getWritableDatabase();
    localQMMailSQLiteHelper.mail.insertMailRule(localSQLiteDatabase, getRuleInfo());
  }
  
  protected abstract MailRuleInfo getRuleInfo();
  
  protected abstract QMMailSQLiteHelper getSQLiteHelper();
  
  public void remove()
  {
    QMMailSQLiteHelper localQMMailSQLiteHelper = getSQLiteHelper();
    SQLiteDatabase localSQLiteDatabase = localQMMailSQLiteHelper.getWritableDatabase();
    localQMMailSQLiteHelper.mail.removeMailRule(localSQLiteDatabase, new int[] { getRuleInfo().getId() });
  }
  
  public void run(ApplyRuleCallback paramApplyRuleCallback)
  {
    Object localObject = getSQLiteHelper();
    MailRuleInfo localMailRuleInfo = getRuleInfo();
    localObject = ((QMMailSQLiteHelper)localObject).mail.getMailRuleHits(((QMMailSQLiteHelper)localObject).getReadableDatabase(), localMailRuleInfo);
    if (localObject != null)
    {
      if (paramApplyRuleCallback.needAction())
      {
        int i = 0;
        while (i < localObject.length)
        {
          paramApplyRuleCallback.onAction(QMMailManager.sharedInstance().readMailInfo(localObject[i], false), localMailRuleInfo);
          i += 1;
        }
      }
      paramApplyRuleCallback.onHandleHitMails((long[])localObject, localMailRuleInfo);
    }
  }
  
  public void run(Mail paramMail, ApplyRuleCallback paramApplyRuleCallback)
  {
    if (paramApplyRuleCallback.needAction()) {
      paramApplyRuleCallback.onAction(paramMail, getRuleInfo());
    }
    long l = paramMail.getInformation().getId();
    paramMail = getRuleInfo();
    paramApplyRuleCallback.onHandleHitMails(new long[] { l }, paramMail);
  }
  
  protected abstract void setRuleInfo(MailRuleInfo paramMailRuleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.rule.Rule
 * JD-Core Version:    0.7.0.1
 */