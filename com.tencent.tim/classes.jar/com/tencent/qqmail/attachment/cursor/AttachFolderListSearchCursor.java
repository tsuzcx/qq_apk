package com.tencent.qqmail.attachment.cursor;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.attachment.QMAttachSQLite;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMMailListCursor.DefaultRunOnMainThreadContext;
import com.tencent.qqmail.model.mail.QMMailListCursor.IRunOnMainThreadWithContext;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.search.model.SearchAttachInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

public class AttachFolderListSearchCursor
  implements IAttachFolderListCursor
{
  private static final String REMARK_EMPTY = "empty";
  public static final String TAG = "SearchAttachFolderListCursor";
  protected Cursor localCursor;
  private String mSearchRemark = "empty";
  private long[] mSearchResult;
  private SearchAttachInfo mUsingInfo;
  private final QMMailSQLiteHelper sqliteHelper;
  private QMMailListCursor.IRunOnMainThreadWithContext threadWrapper = new QMMailListCursor.DefaultRunOnMainThreadContext();
  
  public AttachFolderListSearchCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
  }
  
  private boolean canRefresh()
  {
    return (this.localCursor == null) || (this.localCursor.isClosed()) || (this.mSearchRemark != getSearchRemark());
  }
  
  private Cursor getCursor(int paramInt)
  {
    if ((this.localCursor != null) && (!this.localCursor.isClosed()))
    {
      this.localCursor.moveToPosition(paramInt);
      return this.localCursor;
    }
    return null;
  }
  
  private Cursor getLocalCursorByIds(long[] paramArrayOfLong, boolean paramBoolean)
  {
    boolean bool = false;
    long[] arrayOfLong = paramArrayOfLong;
    if (paramArrayOfLong == null) {
      arrayOfLong = new long[0];
    }
    paramArrayOfLong = this.sqliteHelper.attach;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    if (!paramBoolean) {
      bool = true;
    }
    return paramArrayOfLong.getSearchAttachFolderListCursor(localSQLiteDatabase, arrayOfLong, bool);
  }
  
  private String getSearchRemark()
  {
    if (this.mUsingInfo == null) {
      return "empty";
    }
    return this.mUsingInfo.getSearchType() + "_" + this.mUsingInfo.getKeyword();
  }
  
  private void queryLocal()
  {
    Cursor localCursor1 = this.localCursor;
    QMCursorCollector.retain(localCursor1);
    long[] arrayOfLong1;
    if ((canRefresh()) && (this.mUsingInfo != null))
    {
      if ((this.mUsingInfo.getKeyword() != null) && (!this.mUsingInfo.getKeyword().equals(""))) {
        break label109;
      }
      if (this.mSearchResult != null) {
        break label101;
      }
      arrayOfLong1 = this.mUsingInfo.getAttachIds();
      int i = Math.min(10, arrayOfLong1.length);
      long[] arrayOfLong2 = new long[i];
      System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, i);
      setLocalCursor(getLocalCursorByIds(arrayOfLong2, false));
    }
    for (;;)
    {
      QMCursorCollector.release(localCursor1);
      return;
      label101:
      arrayOfLong1 = this.mSearchResult;
      break;
      label109:
      setLocalCursor(getLocalCursorByIds(this.mSearchResult, true));
    }
  }
  
  private void querySearchCursor(Runnable paramRunnable)
  {
    queryLocal();
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  private void setLocalCursor(Cursor paramCursor)
  {
    this.localCursor = paramCursor;
  }
  
  public void asyncSearch(boolean paramBoolean, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (paramRunnable1 != null) {
      paramRunnable1.run();
    }
    if ((this.mSearchRemark == getSearchRemark()) || ((paramBoolean) && (this.mUsingInfo != null) && (this.mUsingInfo.getKeyword().equals(""))))
    {
      querySearchCursor(paramRunnable2);
      return;
    }
    Threads.runInBackground(new AttachFolderListSearchCursor.1(this, paramRunnable2));
  }
  
  public void close()
  {
    QMCursorCollector.release(this.localCursor);
    this.localCursor = null;
    this.mSearchResult = null;
    this.mSearchRemark = "empty";
  }
  
  public int getCount()
  {
    if (this.localCursor == null) {
      return 0;
    }
    return this.localCursor.getCount();
  }
  
  public Attach getItem(int paramInt)
  {
    Object localObject;
    if (paramInt <= getCount() - 1)
    {
      localObject = getCursor(paramInt);
      if ((localObject != null) && (!((Cursor)localObject).isClosed()) && (getCount() != 0)) {}
    }
    else
    {
      return null;
    }
    try
    {
      localObject = QMAttachSQLite.fillAttach(this.sqliteHelper.getReadableDatabase(), (Cursor)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "SearchAttachFolderListCursor", "Make sure the Cursor is initialized correctly before accessing data from it! " + localException.getMessage());
    }
    return null;
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
  
  public SearchAttachInfo getSearchInfo()
  {
    return this.mUsingInfo;
  }
  
  public int getState()
  {
    return 0;
  }
  
  public void refresh(QMRefreshCallback paramQMRefreshCallback) {}
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void setSearchInfo(int paramInt1, int paramInt2, String paramString, long[] paramArrayOfLong)
  {
    this.mUsingInfo = new SearchAttachInfo(paramInt2);
    this.mUsingInfo.setKeyword(paramString);
    this.mUsingInfo.setAttachIds(paramArrayOfLong);
  }
  
  public void setThreadWrapper(QMMailListCursor.IRunOnMainThreadWithContext paramIRunOnMainThreadWithContext)
  {
    this.threadWrapper = paramIRunOnMainThreadWithContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.cursor.AttachFolderListSearchCursor
 * JD-Core Version:    0.7.0.1
 */