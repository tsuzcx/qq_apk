package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class QMInboxesCursor
  extends QMHybridMailListCursor
{
  private SparseArray<Account> accountsMap = new SparseArray();
  private final SparseBooleanArray inLoadingMore = new SparseBooleanArray();
  private int[] inboxIds = null;
  private ArrayList<Integer> popAccounts = new ArrayList();
  
  public QMInboxesCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, AccountList paramAccountList)
  {
    super(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager, paramAccountList);
    paramQMMailSQLiteHelper = this.accounts.iterator();
    while (paramQMMailSQLiteHelper.hasNext())
    {
      paramQMMailCGIManager = (Account)paramQMMailSQLiteHelper.next();
      if (paramQMMailCGIManager.isPopMail()) {
        this.popAccounts.add(Integer.valueOf(paramQMMailCGIManager.getId()));
      }
      this.accountsMap.put(paramQMMailCGIManager.getId(), paramQMMailCGIManager);
    }
  }
  
  private int[] expandQueryIds(int[] paramArrayOfInt)
  {
    int j = 0;
    Object localObject = new TreeSet();
    int k = paramArrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      ((TreeSet)localObject).add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    paramArrayOfInt = this.popAccounts.iterator();
    while (paramArrayOfInt.hasNext())
    {
      i = ((Integer)paramArrayOfInt.next()).intValue();
      int[] arrayOfInt = QMFolderManager.sharedInstance().getFolderIds(i);
      k = arrayOfInt.length;
      i = 0;
      while (i < k)
      {
        ((TreeSet)localObject).add(Integer.valueOf(arrayOfInt[i]));
        i += 1;
      }
    }
    paramArrayOfInt = new int[((TreeSet)localObject).size()];
    localObject = new ArrayList((Collection)localObject);
    i = j;
    while (i < ((ArrayList)localObject).size())
    {
      paramArrayOfInt[i] = ((Integer)((ArrayList)localObject).get(i)).intValue();
      i += 1;
    }
    return paramArrayOfInt;
  }
  
  private IListCallback getLoadMoreCallback(int paramInt1, int paramInt2)
  {
    return new QMInboxesCursor.1(this, paramInt2, paramInt1);
  }
  
  private boolean queryCanLoadMore(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = expandQueryIds(paramArrayOfInt);
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.mail.canFolderLoadMore(localSQLiteDatabase, arrayOfInt, paramArrayOfInt);
  }
  
  public final Cursor cloneCursor()
  {
    refreshFolders();
    return queryRawCursor();
  }
  
  protected int getActualFolderId()
  {
    return -1;
  }
  
  protected int getFolderType()
  {
    return 1;
  }
  
  public int getState()
  {
    return 0;
  }
  
  public void loadMore()
  {
    if (!canLoadMore()) {
      return;
    }
    int j = getActualFolderId();
    this.isLoadingMore = true;
    int i = 0;
    label20:
    QMFolder localQMFolder;
    if (i < this.allFolders.size())
    {
      localQMFolder = (QMFolder)this.allFolders.get(i);
      if (queryCanLoadMore(new int[] { localQMFolder.getId() })) {
        break label67;
      }
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label67:
      Account localAccount = (Account)this.accountsMap.get(localQMFolder.getAccountId());
      this.inLoadingMore.put(localQMFolder.getId(), true);
      switch (localAccount.getProtocol())
      {
      default: 
        this.protocolMgr.loadMore(localQMFolder, getLoadMoreCallback(localQMFolder.getId(), j));
        break;
      case 1: 
      case 2: 
        this.cgiMgr.loadMore(localQMFolder, getLoadMoreCallback(localQMFolder.getId(), j));
      }
    }
  }
  
  public boolean queryCanLoadMore()
  {
    return queryCanLoadMore(this.inboxIds);
  }
  
  public boolean queryCanPopIn()
  {
    return true;
  }
  
  public boolean queryCanUpdate()
  {
    return true;
  }
  
  protected Cursor queryHybirdRawCursor()
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.mail.getFoldersCursor(localSQLiteDatabase, this.inboxIds);
  }
  
  protected void refreshFolders()
  {
    super.refreshFolders();
    if (this.inboxIds == null)
    {
      this.inboxIds = new int[this.allFolders.size()];
      int i = 0;
      while (i < this.allFolders.size())
      {
        this.inboxIds[i] = ((QMFolder)this.allFolders.get(i)).getId();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMInboxesCursor
 * JD-Core Version:    0.7.0.1
 */