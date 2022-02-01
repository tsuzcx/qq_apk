package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.Future;

public class ContactBlackWhiteListCursor
  extends ContactBaseListCursor
{
  private final String TAG = "ContactBlackWhiteListCursor";
  private int[] accountIds;
  protected int[] cacheColumnIndex = new int[100];
  protected int[] cacheRecentSenderColumnIndex = new int[100];
  private Future<Cursor> contactListCursor;
  private boolean isChooseRecentSender;
  private Cursor latestContactCursor;
  private Cursor latestRecentSenderCursor;
  private int nameListType;
  private Future<Cursor> nextContactListCursor;
  private Future<Cursor> nextRecentSenderCursor;
  private Runnable onRefresh = null;
  private Future<Cursor> recentSenderCursor;
  private String selfEmail;
  private IRunOnMainThreadWithContext threadWrapper = new DefaultRunOnMainThreadContext();
  
  public ContactBlackWhiteListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt, int paramInt, String paramString, boolean paramBoolean)
  {
    super(paramQMMailSQLiteHelper, paramArrayOfInt);
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.accountIds = paramArrayOfInt;
    this.nameListType = paramInt;
    this.selfEmail = paramString;
    this.isChooseRecentSender = paramBoolean;
    Arrays.fill(this.cacheRecentSenderColumnIndex, -2147483648);
    Arrays.fill(this.cacheColumnIndex, -2147483648);
  }
  
  private int getContactListCount()
  {
    try
    {
      if (this.contactListCursor != null)
      {
        Cursor localCursor = (Cursor)this.contactListCursor.get();
        if ((localCursor != null) && (!localCursor.isClosed()))
        {
          int i = localCursor.getCount();
          return i + 0;
        }
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "ContactBlackWhiteListCursor", "getContactListCount: " + Log.getStackTraceString(localException));
    }
    return 0;
  }
  
  private int getRecentSenderCount()
  {
    try
    {
      if ((this.recentSenderCursor != null) && (!((Cursor)this.recentSenderCursor.get()).isClosed()))
      {
        int i = ((Cursor)this.recentSenderCursor.get()).getCount();
        return i + 0;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "ContactBlackWhiteListCursor", "getRecentSenderCount: " + Log.getStackTraceString(localException));
    }
    return 0;
  }
  
  private void getRecentSenderCursor()
  {
    try
    {
      if (this.recentSenderCursor != null) {
        this.latestRecentSenderCursor = ((Cursor)this.recentSenderCursor.get());
      }
      return;
    }
    catch (Exception localException)
    {
      this.latestRecentSenderCursor = null;
      QMLog.log(6, "ContactBlackWhiteListCursor", "getRecentSenderCursor: " + Log.getStackTraceString(localException));
    }
  }
  
  private void nextCursor()
  {
    try
    {
      if (this.nextContactListCursor != null) {
        this.nextContactListCursor.get();
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "ContactBlackWhiteListCursor", "nextContactListCursor: " + Log.getStackTraceString(localException));
    }
  }
  
  private void nextRecentSenderCursor()
  {
    try
    {
      if (this.nextRecentSenderCursor != null) {
        this.nextRecentSenderCursor.get();
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "ContactBlackWhiteListCursor", "nextRecentSenderCursor: " + Log.getStackTraceString(localException));
    }
  }
  
  private Cursor queryRecentSenderCursor()
  {
    QMContactSQLite localQMContactSQLite = this.sqliteHelper.contact;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    int[] arrayOfInt = getAccountIds();
    int i = this.nameListType;
    String str = this.selfEmail;
    return localQMContactSQLite.queryAccountContactToBlackWhiteListRecentSender(localSQLiteDatabase, arrayOfInt, new int[] { i }, str);
  }
  
  private void refresh()
  {
    int k = 0;
    Cursor localCursor1 = getRecentSender();
    Cursor localCursor2 = getCursor();
    QMCursorCollector.retain(localCursor1);
    QMCursorCollector.retain(localCursor2);
    int i;
    if ((this.recentSenderCursor != null) || (this.contactListCursor != null))
    {
      i = 1;
      int j;
      if ((this.recentSenderCursor == null) || (getCount() != 0))
      {
        j = k;
        if (this.contactListCursor != null)
        {
          j = k;
          if (getCount() != 0) {}
        }
      }
      else
      {
        j = 1;
      }
      if ((i != 0) && (j == 0)) {
        break label149;
      }
      if (!this.isChooseRecentSender) {
        break label131;
      }
      this.recentSenderCursor = Threads.submitTask(new ContactBlackWhiteListCursor.3(this));
    }
    for (;;)
    {
      this.threadWrapper.runOnMainThreadWithContext(new ContactBlackWhiteListCursor.5(this, localCursor1, localCursor2));
      return;
      i = 0;
      break;
      label131:
      this.contactListCursor = Threads.submitTask(new ContactBlackWhiteListCursor.4(this));
    }
    label149:
    if ((this.nextRecentSenderCursor != null) && (!this.nextRecentSenderCursor.isDone())) {
      this.nextRecentSenderCursor.cancel(true);
    }
    if ((this.nextContactListCursor != null) && (!this.nextContactListCursor.isDone())) {
      this.nextContactListCursor.cancel(true);
    }
    if (this.isChooseRecentSender)
    {
      this.nextRecentSenderCursor = Threads.submitTask(new ContactBlackWhiteListCursor.6(this, localCursor1, localCursor2));
      return;
    }
    this.nextContactListCursor = Threads.submitTask(new ContactBlackWhiteListCursor.7(this, localCursor1, localCursor2));
  }
  
  public void close()
  {
    QMCursorCollector.release(this.latestRecentSenderCursor);
    QMCursorCollector.release(this.latestContactCursor);
    QMCursorCollector.cleanup();
    Threads.cancelTask(this.recentSenderCursor);
    Threads.cancelTask(this.contactListCursor);
  }
  
  public int[] getAccountIds()
  {
    return this.accountIds;
  }
  
  public String getCategory(MailContact paramMailContact)
  {
    String str = null;
    if (this.isChooseRecentSender) {
      paramMailContact = QMApplicationContext.sharedInstance().getString(2131690892);
    }
    do
    {
      return paramMailContact;
      if (!StringExtention.isNullOrEmpty(paramMailContact.getPinyin())) {
        str = paramMailContact.getPinyin().substring(0, 1).toUpperCase();
      }
      paramMailContact = str;
    } while (str != null);
    return "#";
  }
  
  public int getCount()
  {
    if (this.isChooseRecentSender) {
      return 0 + getRecentSenderCount();
    }
    return 0 + getContactListCount();
  }
  
  public Cursor getCursor()
  {
    try
    {
      if (this.contactListCursor != null) {
        this.latestContactCursor = ((Cursor)this.contactListCursor.get());
      }
      return this.latestContactCursor;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.latestContactCursor = null;
        QMLog.log(6, "ContactBlackWhiteListCursor", "getContactList: " + Log.getStackTraceString(localException));
      }
    }
  }
  
  public Cursor getCursor(int paramInt)
  {
    try
    {
      if ((this.isChooseRecentSender) && (this.recentSenderCursor != null) && (paramInt < ((Cursor)this.recentSenderCursor.get()).getCount())) {
        return (Cursor)this.recentSenderCursor.get();
      }
      if (this.contactListCursor != null)
      {
        Cursor localCursor = (Cursor)this.contactListCursor.get();
        return localCursor;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "ContactBlackWhiteListCursor", "getCursor: " + Log.getStackTraceString(localException));
    }
    return null;
  }
  
  public MailContact getItem(int paramInt)
  {
    Cursor localCursor = getCursor(paramInt);
    localCursor.moveToPosition(paramInt);
    if (this.isChooseRecentSender) {
      return getRecentSenderItem(localCursor);
    }
    return getItem(localCursor);
  }
  
  protected MailContact getItem(Cursor paramCursor)
  {
    return QMContactSQLite.fillContact(paramCursor, this.cacheColumnIndex);
  }
  
  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor(paramInt);
    localCursor.moveToPosition(paramInt);
    return localCursor.getLong(0);
  }
  
  public Cursor getRecentSender()
  {
    try
    {
      if (this.recentSenderCursor != null) {
        this.latestRecentSenderCursor = ((Cursor)this.recentSenderCursor.get());
      }
      return this.latestRecentSenderCursor;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.latestRecentSenderCursor = null;
        QMLog.log(6, "ContactBlackWhiteListCursor", "getRecentSender: " + Log.getStackTraceString(localException));
      }
    }
  }
  
  protected MailContact getRecentSenderItem(Cursor paramCursor)
  {
    return QMContactSQLite.fillContactRecentSender(paramCursor, this.cacheRecentSenderColumnIndex);
  }
  
  protected Cursor queryRawCursor()
  {
    QMContactSQLite localQMContactSQLite = this.sqliteHelper.contact;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    int[] arrayOfInt = getAccountIds();
    int i = this.nameListType;
    String str = this.selfEmail;
    return localQMContactSQLite.queryAccountContactToBlackWhiteList(localSQLiteDatabase, arrayOfInt, new int[] { i }, str);
  }
  
  public LinkedHashMap<String, Integer> querySectionMap()
  {
    if (this.isChooseRecentSender) {
      return null;
    }
    QMContactSQLite localQMContactSQLite = this.sqliteHelper.contact;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    int[] arrayOfInt = getAccountIds();
    int i = this.nameListType;
    String str = this.selfEmail;
    return localQMContactSQLite.getBlackWhiteListContactSectionMap(localSQLiteDatabase, arrayOfInt, new int[] { i }, str);
  }
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback)
  {
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new ContactBlackWhiteListCursor.1(this, paramQMRefreshCallback));
    }
    refresh();
    if (paramBoolean) {
      reload();
    }
    if (this.isChooseRecentSender)
    {
      nextRecentSenderCursor();
      getRecentSenderCursor();
    }
    for (;;)
    {
      if (paramQMRefreshCallback != null) {
        this.threadWrapper.runOnMainThreadWithContext(new ContactBlackWhiteListCursor.2(this, paramQMRefreshCallback));
      }
      return;
      nextCursor();
      getCursor();
    }
  }
  
  protected void reload() {}
  
  public void setAccountIds(int[] paramArrayOfInt)
  {
    this.accountIds = paramArrayOfInt;
  }
  
  public void setOnRefresh(Runnable paramRunnable)
  {
    this.onRefresh = paramRunnable;
  }
  
  public void setThreadWrapper(IRunOnMainThreadWithContext paramIRunOnMainThreadWithContext)
  {
    this.threadWrapper = paramIRunOnMainThreadWithContext;
  }
  
  public static final class DefaultRunOnMainThreadContext
    implements ContactBlackWhiteListCursor.IRunOnMainThreadWithContext
  {
    public void runOnMainThreadWithContext(Runnable paramRunnable)
    {
      Threads.runOnMainThread(paramRunnable);
    }
  }
  
  public static abstract interface IRunOnMainThreadWithContext
  {
    public abstract void runOnMainThreadWithContext(Runnable paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBlackWhiteListCursor
 * JD-Core Version:    0.7.0.1
 */