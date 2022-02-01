package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.maillist.MailListUtil;
import com.tencent.qqmail.maillist.MailListUtil.IDraftAlike;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMFolderSQLite;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.SearchMailQueueHandler;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.Future;

public class QMSearchCursor
  implements MailListUtil.IDraftAlike, IMailListCursor
{
  public static final String REMARK_EMPTY = "empty";
  private static final String TAG = "QMSearchCursor";
  private Runnable afterRefresh;
  private boolean canLoadMore = true;
  public final QMMailCGIManager cgiMgr;
  private boolean enableIncrementalSearch;
  protected int folderType;
  protected boolean hasRemoteItem = true;
  private boolean isForceUpdate;
  protected Cursor mDraftCursor;
  protected Cursor mLocalCursor;
  protected Cursor mRemoteCursor;
  private String mSearchRemark = "empty";
  private long[] mSearchResult;
  protected final QMMailProtocolManager protocolMgr;
  private final Runnable searchTask = new QMSearchCursor.1(this);
  public final QMMailSQLiteHelper sqliteHelper;
  private SearchInfo usingInfo;
  
  public QMSearchCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.cgiMgr = paramQMMailCGIManager;
    this.protocolMgr = paramQMMailProtocolManager;
  }
  
  private boolean canRefreshDraftCursor()
  {
    return this.mDraftCursor == null;
  }
  
  private boolean canRefreshLocalCursor()
  {
    return (canRefresh()) && (this.usingInfo != null);
  }
  
  private boolean isQQMail(Account paramAccount)
  {
    return (paramAccount != null) && (paramAccount.isQQMail());
  }
  
  private boolean isStarredFolder(int paramInt)
  {
    if (paramInt != 0)
    {
      QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(paramInt);
      if ((localQMFolder != null) && (localQMFolder.getType() == 16)) {
        return true;
      }
    }
    return false;
  }
  
  private int queryFolderType(SearchInfo paramSearchInfo)
  {
    if ((paramSearchInfo != null) && (paramSearchInfo.getFolderId() != 0))
    {
      paramSearchInfo = QMFolderManager.sharedInstance().getFolder(paramSearchInfo.getFolderId());
      if (paramSearchInfo != null) {
        return paramSearchInfo.getType();
      }
    }
    return 110;
  }
  
  private void refreshSearchCursor(Runnable paramRunnable)
  {
    boolean bool2 = canRefreshDraftCursor();
    Cursor localCursor2;
    if (bool2)
    {
      localCursor2 = queryForRelativeContacts();
      localCursor1 = localCursor2;
      if (localCursor2 != null) {
        localCursor2.getCount();
      }
    }
    for (Cursor localCursor1 = localCursor2;; localCursor1 = null)
    {
      this.hasRemoteItem = queryCanSearchRemote(this.usingInfo);
      this.folderType = queryFolderType(this.usingInfo);
      boolean bool3 = canRefreshLocalCursor();
      if (bool3) {}
      for (localCursor2 = queryLocalSearchCursor();; localCursor2 = null)
      {
        Object localObject = getSearchInfo();
        boolean bool1;
        if (localObject != null)
        {
          bool1 = true;
          if (!bool1) {
            break label133;
          }
        }
        label133:
        for (localObject = queryRemoteBySearchType(((SearchInfo)localObject).getSearchType());; localObject = null)
        {
          Threads.runOnMainThread(new QMSearchCursor.2(this, bool2, localCursor1, bool3, localCursor2, bool1, (Cursor)localObject, paramRunnable));
          return;
          bool1 = false;
          break;
        }
      }
    }
  }
  
  private void safeSetDraftCursor(Cursor paramCursor)
  {
    Cursor localCursor = this.mDraftCursor;
    QMCursorCollector.retain(localCursor);
    this.mDraftCursor = paramCursor;
    QMCursorCollector.release(localCursor);
  }
  
  private void safeSetLocalCursor(Cursor paramCursor)
  {
    Cursor localCursor = this.mLocalCursor;
    QMCursorCollector.retain(localCursor);
    setLocalCursor(paramCursor);
    QMCursorCollector.release(localCursor);
  }
  
  private void safeSetRemoteCursor(Cursor paramCursor)
  {
    Cursor localCursor = this.mRemoteCursor;
    QMCursorCollector.retain(localCursor);
    setRemoteCursor(paramCursor);
    QMCursorCollector.release(localCursor);
  }
  
  private void setRemoteCursor(Cursor paramCursor)
  {
    this.mRemoteCursor = paramCursor;
    if (!canSearchRemote()) {
      setCanLoadMore(false);
    }
  }
  
  public void asyncSearch(Runnable paramRunnable1, Runnable paramRunnable2, boolean paramBoolean)
  {
    paramRunnable1.run();
    this.isForceUpdate = paramBoolean;
    this.afterRefresh = paramRunnable2;
    Threads.replaceCallbackInBackground(this.searchTask, 100L);
  }
  
  public boolean canLoadMore()
  {
    return this.canLoadMore;
  }
  
  public boolean canPopIn()
  {
    return false;
  }
  
  public boolean canRefresh()
  {
    return (this.mLocalCursor == null) || (this.mLocalCursor.isClosed()) || (this.mSearchRemark != getSearchRemark());
  }
  
  public boolean canSearchRemote()
  {
    return this.hasRemoteItem;
  }
  
  public void cleanRemoteSearchMails()
  {
    Threads.runInBackground(new QMSearchCursor.3(this));
  }
  
  public void cleanSearchMailQueue()
  {
    SearchMailQueueHandler.shareInstance().sendEmptyMessage(-996);
    SearchMailQueueHandler.shareInstance().sendEmptyMessage(-990);
  }
  
  public void close()
  {
    QMCursorCollector.release(this.mLocalCursor);
    QMCursorCollector.release(this.mRemoteCursor);
    QMCursorCollector.release(this.mDraftCursor);
    QMCursorCollector.cleanup();
    setCanLoadMore(true);
    this.mLocalCursor = null;
    this.mRemoteCursor = null;
    this.mDraftCursor = null;
    this.usingInfo = null;
    this.mSearchResult = null;
    this.mSearchRemark = "empty";
  }
  
  public int getCount()
  {
    return 0 + getLocalCount() + getRemoteCount();
  }
  
  protected Cursor getCursor(int paramInt)
  {
    if ((this.mRemoteCursor != null) && (this.mLocalCursor != null) && (!this.mRemoteCursor.isClosed()) && (paramInt > this.mLocalCursor.getCount() - 1))
    {
      this.mRemoteCursor.moveToPosition(paramInt - this.mLocalCursor.getCount());
      return this.mRemoteCursor;
    }
    if ((this.mRemoteCursor != null) && (this.mLocalCursor == null) && (!this.mRemoteCursor.isClosed()))
    {
      this.mRemoteCursor.moveToPosition(paramInt);
      return this.mRemoteCursor;
    }
    if ((this.mLocalCursor != null) && (!this.mLocalCursor.isClosed()))
    {
      this.mLocalCursor.moveToPosition(paramInt);
      return this.mLocalCursor;
    }
    return null;
  }
  
  public int getFolderType()
  {
    return this.folderType;
  }
  
  public Mail getItem(int paramInt)
  {
    if (paramInt <= getCount() - 1)
    {
      Object localObject1 = getCursor(paramInt);
      Object localObject2;
      boolean bool;
      if ((localObject1 == null) || (((Cursor)localObject1).isClosed()) || (getCount() == 0))
      {
        localObject2 = new StringBuilder().append("cursor null:");
        if (localObject1 == null)
        {
          bool = true;
          QMLog.log(6, "QMSearchCursor", bool);
          if (localObject1 != null) {
            QMLog.log(4, "QMSearchCursor", "cursor isClose:" + ((Cursor)localObject1).isClosed() + "remoteCount:" + getRemoteCount() + "localCount:" + getLocalCount());
          }
          localObject1 = null;
        }
      }
      for (;;)
      {
        return localObject1;
        bool = false;
        break;
        localObject2 = new Mail();
        ((Mail)localObject2).setStatus(new MailStatus());
        ((Mail)localObject2).setInformation(new MailInformation());
        try
        {
          QMMailSQLite.fillMail((Cursor)localObject1, (Mail)localObject2);
          localObject1 = localObject2;
          if (getFolderType() == 4)
          {
            relateContact((Mail)localObject2);
            return localObject2;
          }
        }
        catch (Exception localException)
        {
          QMLog.log(6, "QMSearchCursor", "Make sure the Cursor is initialized correctly before accessing data from it");
          return null;
        }
      }
    }
    QMLog.log(6, "QMSearchCursor", "remoteCount:" + getRemoteCount() + ";LocalCount:" + getLocalCount() + ";" + paramInt + ";" + getCount());
    return null;
  }
  
  protected int getItemAccountId(Cursor paramCursor)
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
  
  public Future<long[]> getItemIdsInFuture()
  {
    return Threads.submitTask(new QMSearchCursor.6(this));
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
  
  public int getLocalCount()
  {
    int j = 0;
    int i = j;
    if (this.mLocalCursor != null)
    {
      i = j;
      if (!this.mLocalCursor.isClosed()) {
        i = 0 + this.mLocalCursor.getCount();
      }
    }
    return i;
  }
  
  protected Cursor getLocalCursorByIds(long[] paramArrayOfLong, boolean paramBoolean)
  {
    boolean bool = false;
    long[] arrayOfLong = paramArrayOfLong;
    if (paramArrayOfLong == null) {
      arrayOfLong = new long[0];
    }
    paramArrayOfLong = this.sqliteHelper.mail;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    if (!paramBoolean) {
      bool = true;
    }
    return paramArrayOfLong.getSearchListCursorByIds(localSQLiteDatabase, arrayOfLong, bool);
  }
  
  public int getRemoteCount()
  {
    int j = 0;
    int i = j;
    if (this.mRemoteCursor != null)
    {
      i = j;
      if (!this.mRemoteCursor.isClosed()) {
        i = 0 + this.mRemoteCursor.getCount();
      }
    }
    return i;
  }
  
  public SearchInfo getSearchInfo()
  {
    return this.usingInfo;
  }
  
  public String getSearchRemark()
  {
    if (this.usingInfo == null) {
      return "empty";
    }
    return this.usingInfo.getAccountId() + "_" + this.usingInfo.getFolderId() + "_" + this.usingInfo.getSearchType() + "_" + this.usingInfo.getKeyword();
  }
  
  public int getState()
  {
    return 0;
  }
  
  public int[] getUnreadItemPosition()
  {
    return null;
  }
  
  public boolean isUsable()
  {
    return (this.mLocalCursor != null) && (!this.mLocalCursor.isClosed());
  }
  
  public void loadMore()
  {
    if (this.usingInfo != null)
    {
      SearchMailQueueHandler localSearchMailQueueHandler = SearchMailQueueHandler.shareInstance();
      localSearchMailQueueHandler.getCarrier(new QMSearchCursor.4(this, this));
      localSearchMailQueueHandler.getFilter(new QMSearchCursor.5(this));
      localSearchMailQueueHandler.search(this.usingInfo);
    }
  }
  
  public void popIn() {}
  
  public boolean queryCanSearchRemote(SearchInfo paramSearchInfo)
  {
    Object localObject;
    if (paramSearchInfo != null)
    {
      i = paramSearchInfo.getAccountId();
      if (i == 0)
      {
        localObject = AccountManager.shareInstance().getAccountList().iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (((Account)((Iterator)localObject).next()).isPopMail());
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        return false;
        localObject = AccountManager.shareInstance().getAccountList().getAccountById(i);
        if ((localObject != null) && (((Account)localObject).isPopMail())) {
          return false;
        }
        if (isQQMail((Account)localObject))
        {
          if ((paramSearchInfo.getFlag() == -2) || (paramSearchInfo.getFlag() == -9) || (paramSearchInfo.getFlag() == -3) || (paramSearchInfo.getFolderId() == QMFolderManager.sharedInstance().getQQMailStarredFolderId(paramSearchInfo.getAccountId()))) {
            return false;
          }
        }
        else if (isStarredFolder(paramSearchInfo.getFolderId())) {
          return false;
        }
        if (paramSearchInfo.getFolderId() == QMFolderManager.sharedInstance().getDraftFolderId(paramSearchInfo.getAccountId())) {
          return false;
        }
      }
      return (paramSearchInfo.getFlag() == -1) || (paramSearchInfo.getFlag() == 0);
    }
  }
  
  public Cursor queryForRelativeContacts()
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    if (this.usingInfo == null) {
      return null;
    }
    if (this.usingInfo.getFlag() == -11) {
      return this.sqliteHelper.mail.queryForRelativeContacts(localSQLiteDatabase, null, 4);
    }
    return this.sqliteHelper.mail.queryForAllRelativeContacts(localSQLiteDatabase, new int[] { this.usingInfo.getFolderId() }, 0);
  }
  
  public Cursor queryLocalSearchCursor()
  {
    if ((this.usingInfo.getKeyword() == null) || (this.usingInfo.getKeyword().equals("")))
    {
      if ((this.usingInfo.getArea() == 4) || (this.usingInfo.getArea() == 2)) {
        return null;
      }
      i = Math.min(10, this.usingInfo.getMailIds().length);
      localObject1 = this.usingInfo.getMailIds();
      localObject2 = new long[i];
      System.arraycopy(localObject1, 0, localObject2, 0, i);
      QMLog.log(4, "QMSearchCursor", "copy:" + this.mSearchRemark + "," + localObject2.length);
      return getLocalCursorByIds((long[])localObject2, false);
    }
    Object localObject2 = getLocalCursorByIds(this.mSearchResult, true);
    int i = ((Cursor)localObject2).getCount();
    StringBuilder localStringBuilder = new StringBuilder().append("queryLocalResult:").append(this.mSearchRemark).append(",");
    if (this.mSearchResult == null) {}
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(this.mSearchResult.length))
    {
      QMLog.log(4, "QMSearchCursor", localObject1 + "," + i);
      return localObject2;
    }
  }
  
  public Cursor queryRemoteBySearchType(int paramInt)
  {
    Cursor localCursor = this.sqliteHelper.mail.getRemoteSearchMails(this.sqliteHelper.getReadableDatabase(), paramInt);
    paramInt = localCursor.getCount();
    QMLog.log(4, "QMSearchCursor", "remoteCursorCount: " + paramInt);
    return localCursor;
  }
  
  public void refresh(QMRefreshCallback paramQMRefreshCallback) {}
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void refreshRemoteSearchCursor()
  {
    SearchInfo localSearchInfo = getSearchInfo();
    if (localSearchInfo != null) {
      safeSetRemoteCursor(queryRemoteBySearchType(localSearchInfo.getSearchType()));
    }
  }
  
  public void relateContact(Mail paramMail)
  {
    MailListUtil.relateContact(this.mDraftCursor, paramMail);
  }
  
  public void release()
  {
    SearchMailQueueHandler.shareInstance();
    SearchMailQueueHandler.release();
  }
  
  public void reloadAfterDeleteMailSyncRemote() {}
  
  public void setCanLoadMore(boolean paramBoolean)
  {
    this.canLoadMore = paramBoolean;
  }
  
  public void setEnableIncrementalSearch(boolean paramBoolean)
  {
    this.enableIncrementalSearch = paramBoolean;
  }
  
  protected void setLocalCursor(Cursor paramCursor)
  {
    this.mLocalCursor = paramCursor;
    if (!canSearchRemote()) {
      setCanLoadMore(false);
    }
  }
  
  public void setSearchInfo(int paramInt1, int paramInt2, int paramInt3, String paramString, long[] paramArrayOfLong)
  {
    SearchInfo localSearchInfo = new SearchInfo(paramInt3);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localSearchInfo.setArea(2);
      if (localSearchInfo.getArea() != 8) {
        break label512;
      }
      localSearchInfo.setTagIds((String[])localArrayList2.toArray(new String[0]));
    }
    for (;;)
    {
      localSearchInfo.setKeyword(paramString);
      localSearchInfo.setAccountId(paramInt1);
      localSearchInfo.setFolderId(paramInt2);
      localSearchInfo.setMailIds(paramArrayOfLong);
      this.usingInfo = localSearchInfo;
      return;
      if ((paramInt1 != 0) && (paramInt2 == 0))
      {
        localSearchInfo.setArea(4);
        localObject = QMFolderManager.sharedInstance().getFoldersByAccountId(paramInt1);
        paramInt3 = 0;
        while (paramInt3 < ((ArrayList)localObject).size())
        {
          localArrayList1.add("" + ((QMFolder)((ArrayList)localObject).get(paramInt3)).getId());
          paramInt3 += 1;
        }
        break;
      }
      localSearchInfo.setArea(1);
      if (-1 == paramInt2) {
        localSearchInfo.setFlag(-1);
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label390;
        }
        localObject = this.sqliteHelper.folder.getFoldersByType(QMFolderManager.sharedInstance().getFolder(paramInt2).getType());
        paramInt3 = 0;
        while (paramInt3 < ((ArrayList)localObject).size())
        {
          localArrayList1.add("" + ((QMFolder)((ArrayList)localObject).get(paramInt3)).getId());
          paramInt3 += 1;
        }
        break;
        if (-2 == paramInt2) {
          localSearchInfo.setFlag(-2);
        } else if (-9 == paramInt2) {
          localSearchInfo.setFlag(-9);
        } else if (-14 == paramInt2) {
          localSearchInfo.setFlag(-14);
        } else if (-11 == paramInt2) {
          localSearchInfo.setFlag(-11);
        } else if (-13 == paramInt2) {
          localSearchInfo.setFlag(-13);
        } else if (-12 == paramInt2) {
          localSearchInfo.setFlag(-12);
        } else if (-3 == paramInt2) {
          localSearchInfo.setFlag(-3);
        }
      }
      label390:
      Object localObject = this.sqliteHelper.folder.getFolderById(paramInt2);
      if (localObject == null)
      {
        localArrayList1.add(paramInt2 + "");
        break;
      }
      if (((QMFolder)localObject).getType() == 14)
      {
        localSearchInfo.setArea(8);
        localArrayList2.add(paramInt2 + "");
        break;
      }
      localArrayList1.add(paramInt2 + "");
      break;
      label512:
      localSearchInfo.setFolderIds((String[])localArrayList1.toArray(new String[0]));
    }
  }
  
  public void update() {}
  
  public static class Util
  {
    public static void appendLockUrl(StringBuilder paramStringBuilder, int paramInt)
    {
      if (AccountManager.shareInstance().getAccountList().isAccountLocked(paramInt)) {}
      for (String str = "1";; str = "0")
      {
        paramStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&folderlock=$lock$", "lock", str));
        return;
      }
    }
    
    public static void appendPageUrl(StringBuilder paramStringBuilder, Mail paramMail)
    {
      String str2 = StringExtention.replaceWithEncodeURIValue("&page=0&topmails=0&position=2&cursor=$cur$&cursorutc=$utc$&cursorid=$id$", "cur", "max");
      String str1;
      if (paramMail == null)
      {
        str1 = "";
        str1 = StringExtention.replaceWithEncodeURIValue(str2, "id", str1);
        if (paramMail != null) {
          break label56;
        }
      }
      label56:
      for (paramMail = "";; paramMail = String.valueOf(paramMail.getInformation().getDate().getTime() / 1000L))
      {
        paramStringBuilder.append(StringExtention.replaceWithEncodeURIValue(str1, "utc", paramMail));
        return;
        str1 = paramMail.getInformation().getRemoteId();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSearchCursor
 * JD-Core Version:    0.7.0.1
 */