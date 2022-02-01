package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import java.util.Arrays;

public abstract class QMLocalHybirdMailListCursor
  extends QMMailListCursor
{
  protected AccountManager accountMgr = AccountManager.shareInstance();
  protected int[] mCacheColumnIndexOrigin = new int[100];
  protected QMMailManager mailMgr = QMMailManager.sharedInstance();
  
  public QMLocalHybirdMailListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    super(paramQMMailSQLiteHelper);
    Arrays.fill(this.mCacheColumnIndexOrigin, -2147483648);
  }
  
  protected abstract int getActualFolderId();
  
  protected abstract int getActualFolderType();
  
  public void loadMore() {}
  
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
    return this.accountMgr.getAccountList().size() > 0;
  }
  
  protected abstract Cursor queryHybirdRawCursor();
  
  public final Cursor queryRawCursor()
  {
    this.mCacheColumnIndex = this.mCacheColumnIndexOrigin;
    return queryHybirdRawCursor();
  }
  
  public void update()
  {
    this.mailMgr.syncAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMLocalHybirdMailListCursor
 * JD-Core Version:    0.7.0.1
 */