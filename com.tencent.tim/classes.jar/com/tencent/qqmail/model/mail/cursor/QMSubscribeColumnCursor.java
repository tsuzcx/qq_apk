package com.tencent.qqmail.model.mail.cursor;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;

public class QMSubscribeColumnCursor
  extends QMSubscribeListCursor
{
  private static final String TAG = "QMSubscribeColumnCursor";
  private final int COUNT_DIRTY = -1;
  private int accountId = 0;
  private SparseArray<SubscribeMail> cacheList = null;
  private int cache_col_count = -1;
  private int cache_count = -1;
  private final QMMailCGIManager cgiMgr;
  private boolean isChanged = false;
  private long[] listItemIds;
  private int load_count = SubscribeMail.LOAD_MORE_PER_COUNT;
  private int load_count_offset = 0;
  private int loadingLock = 0;
  private String mailIdsForDiff = null;
  
  public QMSubscribeColumnCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, int paramInt)
  {
    super(paramQMMailSQLiteHelper, paramInt);
    this.cgiMgr = paramQMMailCGIManager;
    this.accountId = paramInt;
  }
  
  private void checkDirty()
  {
    Cursor localCursor = getCursor();
    if (this.cacheList == null) {
      this.cacheList = new SparseArray();
    }
    if ((localCursor != null) && (!localCursor.isClosed()) && (this.cache_count != getCount()))
    {
      this.cacheList.clear();
      this.cache_count = getCount();
      this.cache_col_count = -1;
      this.listItemIds = null;
    }
  }
  
  private void doLoadMore()
  {
    Threads.runInBackground(new QMSubscribeColumnCursor.1(this));
  }
  
  private void recaculateSubscribeCount()
  {
    int j;
    if (canLoadMore())
    {
      j = getColCount();
      i = j;
      if (j <= this.load_count) {
        this.load_count_offset = (this.load_count - j);
      }
    }
    for (int i = j;; i = -1)
    {
      if (this.load_count < SubscribeMail.LOAD_MORE_PER_COUNT)
      {
        this.load_count = SubscribeMail.LOAD_MORE_PER_COUNT;
        return;
      }
      j = i;
      if (i == -1) {
        j = getColCount();
      }
      this.load_count = (j + (SubscribeMail.LOAD_MORE_PER_COUNT - j % SubscribeMail.LOAD_MORE_PER_COUNT) + this.load_count_offset);
      return;
    }
  }
  
  public void afterRefresh()
  {
    boolean bool = false;
    if (this.mailIdsForDiff == null) {
      return;
    }
    Object localObject = super.getItemIds();
    Object[] arrayOfObject = new Object[localObject.length];
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = Long.valueOf(localObject[i]);
      i += 1;
    }
    localObject = StringExtention.join(arrayOfObject, ",");
    if (!this.mailIdsForDiff.equals(localObject)) {
      bool = true;
    }
    this.isChanged = bool;
  }
  
  public void beforeRefresh()
  {
    long[] arrayOfLong = super.getItemIds();
    Object[] arrayOfObject = new Object[arrayOfLong.length];
    int i = 0;
    int j = arrayOfLong.length;
    while (i < j)
    {
      arrayOfObject[i] = Long.valueOf(arrayOfLong[i]);
      i += 1;
    }
    this.mailIdsForDiff = StringExtention.join(arrayOfObject, ",");
  }
  
  public void close()
  {
    try
    {
      super.close();
      this.listItemIds = null;
      if (this.cacheList != null)
      {
        this.cacheList.clear();
        this.cacheList = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getColCount()
  {
    checkDirty();
    if (this.cache_col_count != -1) {
      return this.cache_col_count;
    }
    int i = this.sqliteHelper.mail.getSubscribeMailsCnt(this.sqliteHelper.getReadableDatabase(), this.accountId, this.load_count);
    this.cache_col_count = i;
    return i;
  }
  
  public long[] getItemIds()
  {
    if (this.listItemIds == null)
    {
      ArrayList localArrayList = this.sqliteHelper.mail.getSubscribeMailListIds(this.sqliteHelper.getReadableDatabase(), this.accountId);
      this.listItemIds = new long[localArrayList.size()];
      int i = 0;
      while (i < this.listItemIds.length)
      {
        this.listItemIds[i] = ((Long)localArrayList.get(i)).longValue();
        i += 1;
      }
    }
    return this.listItemIds;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public SubscribeMail getSubscribeItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    checkDirty();
    if (this.cacheList.get(paramInt) != null) {
      return (SubscribeMail)this.cacheList.get(paramInt);
    }
    if ((localCursor == null) || (localCursor.isClosed()) || (getCount() == 0)) {
      return null;
    }
    localCursor.moveToPosition(paramInt);
    SubscribeMail localSubscribeMail = new SubscribeMail();
    QMMailSQLite.fillSubscribeMail(localCursor, localSubscribeMail);
    this.cacheList.put(paramInt, localSubscribeMail);
    return localSubscribeMail;
  }
  
  public boolean isChanged()
  {
    return this.isChanged;
  }
  
  public boolean isLoading()
  {
    return this.loadingLock > 0;
  }
  
  public void loadMore()
  {
    recaculateSubscribeCount();
    if (!isLoading()) {
      doLoadMore();
    }
  }
  
  public boolean queryCanLoadMore()
  {
    if ((this.cache_col_count <= 0) && (this.cache_count <= 0)) {}
    int i;
    do
    {
      return true;
      i = getColCount();
    } while (getItemIds().length - i > 0);
    return false;
  }
  
  public Cursor queryRawCursor()
  {
    if (this.accountId == 0) {
      return null;
    }
    return this.sqliteHelper.mail.getSubscribeMails(this.sqliteHelper.getReadableDatabase(), this.accountId, this.load_count);
  }
  
  public void releaseLock(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.loadingLock = -1;
      return;
    }
    this.loadingLock -= 1;
  }
  
  public void reload()
  {
    if (getColCount() == 0) {
      loadMore();
    }
  }
  
  public static class Util
  {
    public static String getMailSnapUrl(int paramInt, String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://shot.mail.qq.com/cgi-bin/MailSnapShort?inputf=userdef&type=1");
      localStringBuilder.append("&mailid=" + paramString);
      return localStringBuilder.toString();
    }
    
    public static boolean isSnapUrl(String paramString)
    {
      return (paramString != null) && (paramString.startsWith("http://shot.mail.qq.com/cgi-bin/MailSnapShort?inputf=userdef&type=1"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor
 * JD-Core Version:    0.7.0.1
 */