package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMFolderSQLite;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.network.filter.RequestFilter;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class QMQQMailFlagHybridMailListCursor
  extends QMHybridMailListCursor
{
  private boolean isOverdue = true;
  
  public QMQQMailFlagHybridMailListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, AccountList paramAccountList)
  {
    super(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager, paramAccountList);
  }
  
  private void loadList(int paramInt)
  {
    QMQQMailFlagHybridMailListCursor.1 local1 = new QMQQMailFlagHybridMailListCursor.1(this);
    this.cgiMgr.loadList(paramInt, local1);
  }
  
  public void beforeRefresh()
  {
    super.beforeRefresh();
    Iterator localIterator = this.qqFolders.iterator();
    while (localIterator.hasNext()) {
      if (((QMFolder)localIterator.next()).isOverdue()) {
        this.isOverdue = true;
      }
    }
  }
  
  protected int getActualFolderId()
  {
    return 0;
  }
  
  protected int getFolderType()
  {
    return 0;
  }
  
  protected int getQQMailFolderId(int paramInt)
  {
    return 0;
  }
  
  public int getState()
  {
    int i = AccountManager.shareInstance().getAccountList().get(0).getId();
    if (RequestFilter.isRequestOnRunning("load_list_all_" + i)) {}
    do
    {
      return 1;
      if (RequestFilter.isRequestOnRunning("update_list_all_" + i)) {
        return -1;
      }
      i = getQQMailFolderId(i);
    } while (RequestFilter.isRequestOnRunning("load_list_" + i));
    if (RequestFilter.isRequestOnRunning("update_list_" + i)) {
      return -1;
    }
    return 0;
  }
  
  public boolean isOverdue()
  {
    return this.isOverdue;
  }
  
  protected boolean isQQMailOnly()
  {
    return (this.accounts != null) && (this.accounts.size() == 1) && ((this.accounts.get(0).isQQMail()) || (this.accounts.get(0).isBizMail()));
  }
  
  public boolean queryCanUpdate()
  {
    return isQQMailOnly();
  }
  
  public void reload()
  {
    int i = 0;
    if (isQQMailOnly())
    {
      int j = getQQMailFolderId(this.accounts.get(0).getId());
      if (QMFolderManager.sharedInstance().getFolder(j).getSvrCount() == -1) {
        i = 1;
      }
      if (i == 0) {
        break label51;
      }
      loadList(j);
    }
    label51:
    do
    {
      return;
      if ((canLoadMore()) && (getCount() < 20)) {
        loadMore();
      }
    } while ((!canUpdate()) || (!isOverdue()));
    update();
  }
  
  public void update()
  {
    if (isQQMailOnly())
    {
      int i = getQQMailFolderId(this.accounts.get(0).getId());
      this.cgiMgr.updateList(this.sqliteHelper.folder.getFolderById(i), false);
      return;
    }
    QMMailManager.sharedInstance().syncAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMQQMailFlagHybridMailListCursor
 * JD-Core Version:    0.7.0.1
 */