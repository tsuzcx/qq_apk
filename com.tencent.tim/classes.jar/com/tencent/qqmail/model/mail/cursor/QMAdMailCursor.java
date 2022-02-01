package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

public class QMAdMailCursor
  extends QMMailListCursor
{
  private int mAccId;
  
  public QMAdMailCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int paramInt)
  {
    super(paramQMMailSQLiteHelper);
    this.mAccId = paramInt;
  }
  
  public void loadMore() {}
  
  public void markAdConvAsRead()
  {
    this.sqliteHelper.mail.markAdConvReadStat(this.sqliteHelper.getWritableDatabase(), this.mAccId, false);
  }
  
  public void markAllAdAsRead()
  {
    this.sqliteHelper.mail.markAdConvReadStat(this.sqliteHelper.getWritableDatabase(), this.mAccId, false);
    long[] arrayOfLong = this.sqliteHelper.mail.getAdMailByReadStat(this.sqliteHelper.getWritableDatabase(), this.mAccId, true);
    if (arrayOfLong.length > 0) {
      QMMailManager.sharedInstance().unreadMails(arrayOfLong, false, false, true);
    }
  }
  
  public boolean queryCanLoadMore()
  {
    return false;
  }
  
  public boolean queryCanPopIn()
  {
    return true;
  }
  
  public boolean queryCanUpdate()
  {
    return false;
  }
  
  public final Cursor queryRawCursor()
  {
    return this.sqliteHelper.mail.getAdvertiseMailList(this.sqliteHelper.getReadableDatabase(), this.mAccId);
  }
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMAdMailCursor
 * JD-Core Version:    0.7.0.1
 */