package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMFolderSQLite;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public abstract class QMHybridMailListCursor
  extends QMMailListCursor
{
  protected AccountList accounts = null;
  protected ArrayList<QMFolder> allFolders = null;
  protected QMMailCGIManager cgiMgr;
  protected boolean isLoadingMore = false;
  protected ArrayList<ArrayList<Long>> loadMoreList = null;
  protected int[] mCacheColumnIndexCursorByCursor = new int[100];
  protected int[] mCacheColumnIndexOrigin = new int[100];
  protected QMMailProtocolManager protocolMgr;
  protected ArrayList<Account> qqAccounts = null;
  protected ArrayList<QMFolder> qqFolders = null;
  
  public QMHybridMailListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, AccountList paramAccountList)
  {
    super(paramQMMailSQLiteHelper);
    this.cgiMgr = paramQMMailCGIManager;
    this.protocolMgr = paramQMMailProtocolManager;
    if ((paramAccountList == null) || (paramAccountList.size() == 0)) {}
    for (this.accounts = AccountManager.shareInstance().getAccountList();; this.accounts = paramAccountList)
    {
      this.qqFolders = new ArrayList();
      this.qqAccounts = getQQAccounts();
      this.loadMoreList = new ArrayList();
      Arrays.fill(this.mCacheColumnIndexOrigin, -2147483648);
      Arrays.fill(this.mCacheColumnIndexCursorByCursor, -2147483648);
      return;
    }
  }
  
  protected static ArrayList<Long> convertArray(long[] paramArrayOfLong)
  {
    Object localObject;
    if (paramArrayOfLong == null)
    {
      localObject = new ArrayList();
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    int j = paramArrayOfLong.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
  }
  
  private ArrayList<Account> getQQAccounts()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if (localAccount.isQQMail()) {
        localArrayList.add(localAccount);
      }
    }
    return localArrayList;
  }
  
  public void beforeRefresh()
  {
    refreshFolders();
  }
  
  protected boolean canCacheCursor()
  {
    return this.isLoadingMore;
  }
  
  protected abstract int getActualFolderId();
  
  protected abstract int getFolderType();
  
  public void loadMore()
  {
    if (!canLoadMore()) {}
    do
    {
      return;
      this.isLoadingMore = true;
    } while (this.qqFolders.size() == 0);
    QMFolder localQMFolder = (QMFolder)this.qqFolders.get(0);
    this.cgiMgr.loadMore(localQMFolder, new QMHybridMailListCursor.1(this));
  }
  
  public boolean queryCanLoadMore()
  {
    boolean bool = true;
    if ((this.qqFolders.size() == 0) || (this.accounts.size() > 1) || (this.qqFolders.size() > 1)) {
      return false;
    }
    QMFolder localQMFolder = (QMFolder)this.qqFolders.get(0);
    if ((this.accounts.isAccountLocked(localQMFolder.getAccountId())) && (localQMFolder.getPersonalCount() > 0)) {
      return (localQMFolder.getSvrCount() != -1) && (getCount() < localQMFolder.getSvrCount() - localQMFolder.getPersonalCount());
    }
    if ((localQMFolder.getSvrCount() != -1) && (getCount() < localQMFolder.getSvrCount())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean queryCanPopIn()
  {
    return this.qqFolders.size() < this.accounts.size();
  }
  
  public boolean queryCanUpdate()
  {
    return this.accounts.size() > 0;
  }
  
  protected abstract Cursor queryHybirdRawCursor();
  
  public final Cursor queryRawCursor()
  {
    if ((canCacheCursor()) && (this.latestCursor != null) && (!this.latestCursor.isClosed()) && (this.latestCursor.getCount() > 0))
    {
      this.mCacheColumnIndex = this.mCacheColumnIndexCursorByCursor;
      Object localObject = this.sqliteHelper.getReadableDatabase();
      localObject = this.sqliteHelper.mail.getMailListCursorByCursor((SQLiteDatabase)localObject, this.latestCursor, this.loadMoreList);
      this.loadMoreList.clear();
      return localObject;
    }
    this.mCacheColumnIndex = this.mCacheColumnIndexOrigin;
    return queryHybirdRawCursor();
  }
  
  protected void refreshFolders()
  {
    int i = getFolderType();
    if (this.allFolders == null) {
      this.allFolders = this.sqliteHelper.folder.getFoldersByType(i);
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.allFolders.iterator();
    while (localIterator.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)localIterator.next();
      Account localAccount = this.accounts.getAccountById(localQMFolder.getAccountId());
      if ((localAccount != null) && (localQMFolder.getType() == i) && (localAccount.isQQMail())) {
        localArrayList.add(localQMFolder);
      }
    }
    this.qqFolders = localArrayList;
  }
  
  public void update()
  {
    QMMailManager.sharedInstance().syncAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMHybridMailListCursor
 * JD-Core Version:    0.7.0.1
 */