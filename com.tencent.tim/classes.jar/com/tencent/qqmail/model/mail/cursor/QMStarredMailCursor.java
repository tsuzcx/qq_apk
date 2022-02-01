package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;
import java.util.Iterator;
import rx.Observable;

public class QMStarredMailCursor
  extends QMQQMailFlagHybridMailListCursor
{
  private int accountId;
  private boolean cache = true;
  private int folderId;
  private ArrayList<Account> mQQMailAccts = null;
  
  public QMStarredMailCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, AccountList paramAccountList, int paramInt1, int paramInt2)
  {
    super(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager, paramAccountList);
    this.folderId = paramInt2;
    this.accountId = paramInt1;
  }
  
  private boolean canQQMailStarredLoadMore(int paramInt)
  {
    if (isQQMailAcc(paramInt))
    {
      QMFolder localQMFolder = getQQMailStarFolder(paramInt);
      if (localQMFolder != null)
      {
        SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
        return this.sqliteHelper.mail.canStarredLoadMore(localSQLiteDatabase, localQMFolder);
      }
    }
    return false;
  }
  
  private ArrayList<Account> getQQMailAccts()
  {
    if (this.mQQMailAccts == null)
    {
      this.mQQMailAccts = new ArrayList();
      Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
      while (localIterator.hasNext())
      {
        Account localAccount = (Account)localIterator.next();
        if (localAccount.isQQMail()) {
          this.mQQMailAccts.add(localAccount);
        }
      }
    }
    return this.mQQMailAccts;
  }
  
  private QMFolder getQQMailStarFolder(int paramInt)
  {
    ArrayList localArrayList = QMFolderManager.sharedInstance().getFoldersByAccountAndType(paramInt, 16);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (QMFolder)localArrayList.get(0);
    }
    return null;
  }
  
  private boolean isQQMailAcc(int paramInt)
  {
    boolean bool2 = false;
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    boolean bool1 = bool2;
    if (localAccount != null) {
      if (!localAccount.isQQMail())
      {
        bool1 = bool2;
        if (!localAccount.isBizMail()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private Observable<Integer> load(QMFolder paramQMFolder)
  {
    return Observable.create(new QMStarredMailCursor.11(this, paramQMFolder.getId()));
  }
  
  private Observable<ArrayList<Long>> loadMore(QMFolder paramQMFolder)
  {
    return Observable.create(new QMStarredMailCursor.10(this, paramQMFolder));
  }
  
  private <T> Observable<? extends T> resumeError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof QMNetworkError)) {}
    for (paramThrowable = (QMNetworkError)paramThrowable;; paramThrowable = new QMNetworkError(7, -1, paramThrowable.getMessage()))
    {
      QMWatcherCenter.triggerLoadListError(getActualFolderId(), paramThrowable);
      return Observable.empty();
    }
  }
  
  private Observable<Integer> update(QMFolder paramQMFolder)
  {
    return Observable.create(new QMStarredMailCursor.12(this, paramQMFolder));
  }
  
  public void afterRefresh()
  {
    this.cache = true;
  }
  
  protected boolean canCacheCursor()
  {
    return this.cache;
  }
  
  protected int getActualFolderId()
  {
    return this.folderId;
  }
  
  protected int getFolderType()
  {
    return 16;
  }
  
  protected int getQQMailFolderId(int paramInt)
  {
    return QMFolderManager.sharedInstance().getQQMailStarredFolderId(paramInt);
  }
  
  public int getState()
  {
    if (this.isLoadingMore) {
      return 1;
    }
    return super.getState();
  }
  
  public void loadMore()
  {
    if (!canLoadMore()) {}
    while (this.qqFolders.size() == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qqFolders.iterator();
    while (localIterator.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)localIterator.next();
      if (canQQMailStarredLoadMore(localQMFolder.getAccountId())) {
        localArrayList.add(loadMore(localQMFolder));
      }
    }
    this.isLoadingMore = true;
    Observable.merge(localArrayList).doOnNext(new QMStarredMailCursor.9(this)).onErrorResumeNext(new QMStarredMailCursor.8(this)).doOnCompleted(new QMStarredMailCursor.7(this)).subscribe();
  }
  
  public boolean queryCanLoadMore()
  {
    if (this.folderId != -2) {
      return canQQMailStarredLoadMore(this.accountId);
    }
    Iterator localIterator = getQQMailAccts().iterator();
    while (localIterator.hasNext()) {
      if (canQQMailStarredLoadMore(((Account)localIterator.next()).getId())) {
        return true;
      }
    }
    return super.queryCanLoadMore();
  }
  
  public boolean queryCanUpdate()
  {
    return isQQMailAcc(this.accountId);
  }
  
  protected Cursor queryHybirdRawCursor()
  {
    if (this.folderId == -2) {
      return this.sqliteHelper.mail.getStarredMailListCursor(this.sqliteHelper.getReadableDatabase());
    }
    return this.sqliteHelper.mail.getStarredMailListCursor(this.sqliteHelper.getReadableDatabase(), this.accountId);
  }
  
  public void reload()
  {
    if (this.qqFolders.size() == 0) {
      return;
    }
    this.cache = false;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qqFolders.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(load((QMFolder)localIterator.next()));
    }
    Observable.merge(localArrayList).doOnNext(new QMStarredMailCursor.6(this)).onErrorResumeNext(new QMStarredMailCursor.5(this)).doOnCompleted(new QMStarredMailCursor.4(this)).subscribe();
  }
  
  public void update()
  {
    if (this.qqFolders.size() == 0) {
      return;
    }
    this.cache = false;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qqFolders.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(update((QMFolder)localIterator.next()));
    }
    Observable.merge(localArrayList).doOnNext(new QMStarredMailCursor.3(this)).onErrorResumeNext(new QMStarredMailCursor.2(this)).doOnCompleted(new QMStarredMailCursor.1(this)).subscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor
 * JD-Core Version:    0.7.0.1
 */