package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.concurrent.Future;

public class QMConvMailCursor
  extends QMMailListCursor
{
  private Future<Account> account;
  private long convId = 0L;
  private int mailFlag;
  private Future<Mail> parentMail;
  
  public QMConvMailCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, long paramLong, int paramInt)
  {
    super(paramQMMailSQLiteHelper);
    this.convId = paramLong;
    this.mailFlag = paramInt;
  }
  
  private void updateParentStatus()
  {
    Threads.runInBackground(new QMConvMailCursor.3(this));
  }
  
  public void beforeRefresh()
  {
    this.parentMail = Threads.submitTask(new QMConvMailCursor.1(this));
    this.account = Threads.submitTask(new QMConvMailCursor.2(this));
  }
  
  public Mail getParentMail()
  {
    try
    {
      Mail localMail = (Mail)this.parentMail.get();
      return localMail;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMMailListCursor", "getParentMail exception: " + localException.toString());
    }
    return null;
  }
  
  public void loadMore()
  {
    update();
  }
  
  public boolean queryCanLoadMore()
  {
    return false;
  }
  
  public boolean queryCanPopIn()
  {
    try
    {
      Account localAccount = (Account)this.account.get();
      if (localAccount != null)
      {
        if ((!localAccount.isQQMail()) && (!localAccount.isBizMail()))
        {
          boolean bool = localAccount.isActiveSyncMail();
          if (!bool) {
            return true;
          }
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMMailListCursor", "get account exception: " + localException.toString());
    }
    return false;
  }
  
  public boolean queryCanUpdate()
  {
    try
    {
      Account localAccount = (Account)this.account.get();
      if ((localAccount != null) && (localAccount.isQQMail()))
      {
        i = getCount();
        if (i == 0) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        QMLog.log(6, "QMMailListCursor", "get account exception: " + localException.toString());
        localMail = null;
      }
      Mail localMail = getParentMail();
      if (localMail != null)
      {
        if ((!localMail.getStatus().isLoaded()) || (localMail.getInformation().getConvCount() != i)) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    }
    return false;
  }
  
  public final Cursor queryRawCursor()
  {
    if ((this.mailFlag & 0x80) != 0) {
      return this.sqliteHelper.mail.getSearchConvMailList(this.sqliteHelper.getReadableDatabase(), this.convId);
    }
    return this.sqliteHelper.mail.getConvMailList(this.sqliteHelper.getReadableDatabase(), this.convId);
  }
  
  public void reload()
  {
    updateParentStatus();
    update();
  }
  
  public void reloadAfterDeleteMailSyncRemote()
  {
    updateParentStatus();
    Mail localMail = getParentMail();
    if (localMail != null) {
      QMMailManager.sharedInstance().loadRemoteMail(localMail, this.mailFlag);
    }
  }
  
  public void update()
  {
    if (canUpdate())
    {
      Mail localMail = getParentMail();
      if (localMail != null) {
        QMMailManager.sharedInstance().loadRemoteMail(localMail, this.mailFlag);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMConvMailCursor
 * JD-Core Version:    0.7.0.1
 */