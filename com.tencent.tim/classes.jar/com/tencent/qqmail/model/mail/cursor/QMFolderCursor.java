package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.concurrent.Future;

public class QMFolderCursor
  extends QMMailListCursor
{
  protected Account account = null;
  private int accountId;
  private int accountProtocol;
  protected boolean activeSyncEmptyListFirstLoad = true;
  private QMMailCGIManager cgiMgr;
  protected QMFolder folder = null;
  private int folderId = 0;
  private boolean isOverdue = true;
  protected ArrayList<long[]> loadMoreList = null;
  private QMMailProtocolManager protocolMgr;
  private Future<Boolean> shouldInitLoad;
  
  public QMFolderCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, int paramInt)
  {
    super(paramQMMailSQLiteHelper);
    this.cgiMgr = paramQMMailCGIManager;
    this.protocolMgr = paramQMMailProtocolManager;
    this.folderId = paramInt;
    this.loadMoreList = new ArrayList();
    this.folder = QMFolderManager.sharedInstance().getFolder(paramInt);
    this.accountId = this.folder.getAccountId();
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    this.accountProtocol = this.account.getProtocol();
    this.shouldInitLoad = Threads.submitTask(new QMFolderCursor.1(this, paramQMMailSQLiteHelper));
    QMLog.log(4, "QMMailListCursor", "init with folderId: " + paramInt + ", accountId: " + this.accountId);
  }
  
  private void initList()
  {
    QMMailManager.sharedInstance().initList(this.folder);
  }
  
  private boolean isFolderNull()
  {
    return this.folder == null;
  }
  
  private boolean isNotLoaded()
  {
    boolean bool = true;
    if (isFolderNull()) {
      return false;
    }
    int i = this.folder.getSvrCount();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.folder.getAccountId());
    if ((localAccount != null) && (localAccount.isActiveSyncMail()))
    {
      if (((getCount() != 0) || (!this.activeSyncEmptyListFirstLoad)) && (this.folder.getSyncKey() != null) && (!this.folder.getSyncKey().equals("0"))) {
        break label103;
      }
      this.activeSyncEmptyListFirstLoad = false;
    }
    for (;;)
    {
      return bool;
      if (i != -1)
      {
        bool = false;
        continue;
        label103:
        bool = false;
      }
    }
  }
  
  private void updateOverdueSubscribe()
  {
    if ((this.account != null) && (this.account.isQQMail()) && (this.folder.getType() == 1) && (QMSettingManager.sharedInstance().getAggregateSubscribeMail()))
    {
      int i = QMFolderManager.sharedInstance().getQQMailSubFolderId(this.accountId);
      QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(i);
      if ((localQMFolder != null) && (localQMFolder.isOverdue()))
      {
        QMMailManager.sharedInstance().updateList(localQMFolder, false, null);
        QMLog.log(4, "QMMailListCursor", "update overdue subscribe in inbox");
      }
    }
  }
  
  public void beforeRefresh()
  {
    if (isFolderNull())
    {
      QMLog.log(6, "QMMailListCursor", "folder is null with folderId: " + this.folderId + ", accountId: " + this.accountId);
      QMLogStream.logWithoutUma(-40011, "folder is null: " + this.folderId + ", accountId: " + this.accountId + "\n\r" + QMLog.getStackTrace(20), "Event_Error");
      return;
    }
    this.isOverdue = this.folder.isOverdue();
  }
  
  public int getState()
  {
    if (RequestFilter.isRequestOnRunning("load_list_all_" + this.accountId)) {}
    do
    {
      do
      {
        return 1;
        if (RequestFilter.isRequestOnRunning("update_list_all_" + this.accountId)) {
          return -1;
        }
        switch (this.accountProtocol)
        {
        }
      } while (RequestFilter.isRequestOnRunning("load_list_" + this.folderId));
      if (!RequestFilter.isRequestOnRunning("update_list_" + this.folderId)) {
        break;
      }
      return -1;
    } while (RequestFilter.isRequestOnRunning("load_list_" + this.folderId));
    if (RequestFilter.isRequestOnRunning("pop_list_" + this.accountId)) {
      return -1;
    }
    return 0;
  }
  
  public void initLoad(boolean paramBoolean)
  {
    if (isFolderNull()) {}
    while (this.folder.isVirtual()) {
      return;
    }
    if ((paramBoolean) || (isNotLoaded()))
    {
      initList();
      return;
    }
    if ((canLoadMore()) && (this.sqliteHelper.mail.getFolderMailCount(this.sqliteHelper.getReadableDatabase(), this.folder) < 20)) {
      loadMore();
    }
    if ((canUpdate()) && (isOverdue())) {
      update();
    }
    updateOverdueSubscribe();
  }
  
  public boolean isOverdue()
  {
    return this.isOverdue;
  }
  
  public void loadMore()
  {
    if (!canLoadMore()) {
      return;
    }
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.folder.getAccountId());
    QMFolderCursor.2 local2 = new QMFolderCursor.2(this);
    if (getCount() <= 0)
    {
      QMLog.log(4, "QMMailListCursor", "LoadList: getCount: " + getCount());
      initList();
      return;
    }
    switch (localAccount.getProtocol())
    {
    default: 
      this.protocolMgr.loadMore(this.folder, local2);
      return;
    }
    this.cgiMgr.loadMore(this.folder, local2);
  }
  
  public boolean queryCanLoadMore()
  {
    if (isFolderNull()) {}
    while ((this.folder.isVirtual()) || (this.account.isActiveSyncMail()) || ((this.account.isPopMail()) && (this.folder.getType() != 1))) {
      return false;
    }
    if (this.folder.getSvrCount() == -1) {
      return true;
    }
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    if (this.folder.getType() == 14) {
      return this.sqliteHelper.mail.canTagLoadMore(localSQLiteDatabase, this.folder.getId());
    }
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = this.folderId;
    if (this.account.isPopMail()) {}
    for (int[] arrayOfInt1 = QMFolderManager.sharedInstance().getFolderIds(this.accountId);; arrayOfInt1 = arrayOfInt2) {
      return this.sqliteHelper.mail.canFolderLoadMore(localSQLiteDatabase, arrayOfInt1, arrayOfInt2);
    }
  }
  
  public boolean queryCanPopIn()
  {
    if (isFolderNull()) {}
    while ((this.account.isQQMail()) || (this.account.isBizMail()) || (this.account.isActiveSyncMail()) || (this.account.isExchangeMail())) {
      return false;
    }
    return true;
  }
  
  public boolean queryCanUpdate()
  {
    if (isFolderNull()) {}
    while (this.folder.isVirtual()) {
      return false;
    }
    return true;
  }
  
  public Cursor queryRawCursor()
  {
    if (isFolderNull()) {
      return null;
    }
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.mail.getFolderMailListCursor(localSQLiteDatabase, this.folder);
  }
  
  public void reload()
  {
    if (isFolderNull()) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((((Boolean)this.shouldInitLoad.get()).booleanValue()) && (getCount() == 0))
        {
          bool = true;
          initLoad(bool);
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, "QMMailListCursor", "initLoad error: " + localException.toString());
        return;
      }
      boolean bool = false;
    }
  }
  
  public void update()
  {
    if (!canUpdate()) {
      return;
    }
    if (getCount() <= 0)
    {
      initList();
      return;
    }
    QMMailManager.sharedInstance().updateList(this.folder, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMFolderCursor
 * JD-Core Version:    0.7.0.1
 */