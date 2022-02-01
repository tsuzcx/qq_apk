package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.contact.ContactsHistoryMailSearchInfo;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.SearchMailQueueHandler;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Iterator;

public class ContactHistoryMailCursor
  extends QMSearchCursor
{
  private static final String TAG = ContactHistoryMailCursor.class.getSimpleName();
  protected Cursor localCursor;
  private long[] mSearchResult;
  protected Cursor remoteCursor;
  private ContactsHistoryMailSearchInfo usingInfo;
  
  public ContactHistoryMailCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager)
  {
    super(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager);
    this.folderType = 0;
  }
  
  private void querySearchCursor(Runnable paramRunnable)
  {
    refreshLocalContactHistoryCursor();
    refreshRemoteSearchCursor();
    paramRunnable.run();
  }
  
  public void asyncSearch(Runnable paramRunnable1, Runnable paramRunnable2, boolean paramBoolean)
  {
    paramRunnable1.run();
    Threads.runInBackground(new ContactHistoryMailCursor.1(this, paramRunnable2));
  }
  
  public boolean canPopIn()
  {
    return false;
  }
  
  public boolean canRefresh()
  {
    return (this.localCursor == null) || (this.localCursor.isClosed()) || (canLoadMore());
  }
  
  public void close()
  {
    QMCursorCollector.release(this.localCursor);
    QMCursorCollector.release(this.remoteCursor);
    QMCursorCollector.release(this.mDraftCursor);
    QMCursorCollector.cleanup();
    setCanLoadMore(true);
    this.localCursor = null;
    this.remoteCursor = null;
    this.mDraftCursor = null;
    this.usingInfo = null;
    this.mSearchResult = null;
  }
  
  public Mail getItem(int paramInt)
  {
    if (paramInt <= getCount() - 1)
    {
      Cursor localCursor1 = getCursor(paramInt);
      if ((localCursor1 == null) || (localCursor1.isClosed()) || (getCount() == 0))
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("cursor null:");
        if (localCursor1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          QMLog.log(4, (String)localObject, bool);
          if (localCursor1 != null) {
            QMLog.log(4, TAG, "cursor isClose:" + localCursor1.isClosed() + ",remoteCount:" + getRemoteCount() + ",localCount:" + getLocalCount());
          }
          return null;
        }
      }
      Object localObject = new Mail();
      ((Mail)localObject).setStatus(new MailStatus());
      ((Mail)localObject).setInformation(new MailInformation());
      try
      {
        QMMailSQLite.fillMail(localCursor1, (Mail)localObject);
        return localObject;
      }
      catch (Exception localException)
      {
        QMLog.log(6, TAG, "Make sure the Cursor is initialized correctly before accessing data from it");
        return null;
      }
    }
    return null;
  }
  
  public int getItemAccountId(Cursor paramCursor)
  {
    return paramCursor.getInt(1);
  }
  
  public long getItemId(int paramInt)
  {
    return getCursor(paramInt).getLong(0);
  }
  
  public long[] getItemIds()
  {
    int j = getCount();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = getItemId(i);
      i += 1;
    }
    return arrayOfLong;
  }
  
  public Mail getLastRemoteItem(int paramInt)
  {
    int i = getCount() - 1;
    while (i >= 0)
    {
      if (getItemAccountId(getCursor(i)) == paramInt) {
        return getItem(i);
      }
      i -= 1;
    }
    return null;
  }
  
  public ContactsHistoryMailSearchInfo getSearchInfo()
  {
    return this.usingInfo;
  }
  
  public int getState()
  {
    return 0;
  }
  
  public void loadMore()
  {
    if (!canLoadMore()) {}
    while (this.usingInfo == null) {
      return;
    }
    SearchMailQueueHandler localSearchMailQueueHandler = SearchMailQueueHandler.shareInstance();
    localSearchMailQueueHandler.getCarrier(new ContactHistoryMailCursor.2(this, this));
    localSearchMailQueueHandler.getFilter(new ContactHistoryMailCursor.3(this));
    localSearchMailQueueHandler.search(this.usingInfo);
  }
  
  public void popIn() {}
  
  public boolean queryCanSearchRemote(SearchInfo paramSearchInfo)
  {
    paramSearchInfo = (ContactsHistoryMailSearchInfo)paramSearchInfo;
    if (paramSearchInfo == null) {
      return false;
    }
    paramSearchInfo = paramSearchInfo.getAccounts().iterator();
    while (paramSearchInfo.hasNext()) {
      if (((Account)paramSearchInfo.next()).isQQMail()) {
        return true;
      }
    }
    return false;
  }
  
  public void refresh(QMRefreshCallback paramQMRefreshCallback) {}
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void refreshLocalContactHistoryCursor()
  {
    Cursor localCursor1 = this.localCursor;
    QMCursorCollector.retain(localCursor1);
    this.hasRemoteItem = false;
    this.hasRemoteItem = queryCanSearchRemote(this.usingInfo);
    String str;
    StringBuilder localStringBuilder;
    if (canRefresh())
    {
      str = TAG;
      localStringBuilder = new StringBuilder().append("result:").append(",");
      if (this.mSearchResult != null) {
        break label101;
      }
    }
    label101:
    for (Object localObject = "null";; localObject = Integer.valueOf(this.mSearchResult.length))
    {
      QMLog.log(3, str, localObject);
      setLocalCursor(getLocalCursorByIds(this.mSearchResult, true));
      QMCursorCollector.release(localCursor1);
      return;
    }
  }
  
  public void reloadAfterDeleteMailSyncRemote() {}
  
  public void setSearchInfo(long[] paramArrayOfLong, ArrayList<String> paramArrayList, ArrayList<Account> paramArrayList1)
  {
    this.usingInfo = new ContactsHistoryMailSearchInfo();
    this.usingInfo.setMailIds(paramArrayOfLong);
    this.usingInfo.setAccounts(paramArrayList1);
    this.usingInfo.setEmails(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactHistoryMailCursor
 * JD-Core Version:    0.7.0.1
 */