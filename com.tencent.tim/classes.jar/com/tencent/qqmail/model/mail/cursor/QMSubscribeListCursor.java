package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.Mail;

public class QMSubscribeListCursor
  extends QMMailListCursor
{
  private int accountId = 0;
  
  public QMSubscribeListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int paramInt)
  {
    super(paramQMMailSQLiteHelper);
    this.accountId = paramInt;
    refresh();
  }
  
  public Mail getRecentSubscribeMail()
  {
    return this.sqliteHelper.mail.getRecentSubscribeMail(this.sqliteHelper.getReadableDatabase(), this.accountId);
  }
  
  public void loadMore() {}
  
  public void markAllSubscribeAsRead()
  {
    QMMailManager.sharedInstance().markSubscribeAllAsUnread(this.accountId, false);
  }
  
  public void markSubscribeConvAsRead()
  {
    this.sqliteHelper.mail.markSubscribeConvReadStat(this.sqliteHelper.getWritableDatabase(), this.accountId, false);
  }
  
  public boolean queryCanLoadMore()
  {
    return false;
  }
  
  public boolean queryCanPopIn()
  {
    return false;
  }
  
  public boolean queryCanUpdate()
  {
    return false;
  }
  
  public Cursor queryRawCursor()
  {
    return this.sqliteHelper.mail.getSubscribeMailList(this.sqliteHelper.getReadableDatabase(), this.accountId);
  }
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSubscribeListCursor
 * JD-Core Version:    0.7.0.1
 */