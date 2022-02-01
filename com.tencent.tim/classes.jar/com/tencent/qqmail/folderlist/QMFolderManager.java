package com.tencent.qqmail.folderlist;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.cache.QMAggrConvMailCache;
import com.tencent.qqmail.model.mail.QMFolderSQLite;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.QMUtilities;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;

public class QMFolderManager
{
  public static final String INVALID_STRINGS = "~!#$%^&*()=+|\\[]{};':\",?/<>";
  private static final String TAG = "QMFolderManager";
  private static volatile QMFolderManager _instance;
  private static Future<Void> _instanceWithCached;
  private SparseBooleanArray folderHasNewCache = new SparseBooleanArray();
  private SparseIntArray folderUnreadCache = new SparseIntArray();
  private HashMap<HashSet<String>, HashSet<Integer>> reservedMap;
  private QMMailSQLiteHelper sqliteHelper = null;
  
  private QMFolderManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    _instanceWithCached = Threads.submitTask(new QMFolderManager.1(this, paramQMMailSQLiteHelper));
  }
  
  private boolean allInboxesHasNewMail()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    boolean bool1 = false;
    int i;
    QMFolder localQMFolder;
    if (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      i = getInboxFolderId(localAccount.getId());
      localQMFolder = this.sqliteHelper.folder.getFolderById(i);
      boolean bool2 = QMSettingManager.sharedInstance().getAggregateSubject(localAccount.getId());
      if (localQMFolder == null) {
        break label119;
      }
      if (bool2) {
        i = localQMFolder.getCliConvUnreadCount();
      }
    }
    for (;;)
    {
      label85:
      if ((localQMFolder != null) && (i > 0)) {
        bool1 |= localQMFolder.hasNewMail();
      }
      for (;;)
      {
        break;
        i = localQMFolder.getCliUnreadCount();
        break label85;
        return bool1;
      }
      label119:
      i = 0;
    }
  }
  
  public static QMFolderManager createInstance(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    if (_instance == null) {}
    try
    {
      if (_instance == null) {
        _instance = new QMFolderManager(paramQMMailSQLiteHelper);
      }
      return _instance;
    }
    finally {}
  }
  
  public static List<String> getAllFolderLog()
  {
    ArrayList localArrayList = new ArrayList();
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i = 0;
    while (i < localAccountList.size())
    {
      Object localObject = localAccountList.get(i);
      if (localObject != null)
      {
        localObject = sharedInstance().getFoldersByAccountId(((Account)localObject).getId());
        if (localObject != null)
        {
          int j = 0;
          while (j < ((List)localObject).size())
          {
            QMFolder localQMFolder = (QMFolder)((List)localObject).get(j);
            if (localQMFolder != null) {
              localArrayList.add("aid:" + localQMFolder.getAccountId() + ",fldid:" + localQMFolder.getId() + ",fldname:" + localQMFolder.getName() + ",push:" + localQMFolder.isPush() + ",svrCount:" + localQMFolder.getSvrCount() + ",svrUnreadCount:" + localQMFolder.getSvrUnreadCount() + ",cliUnreadCount:" + localQMFolder.getCliUnreadCount() + ",parentid:" + localQMFolder.getParentId() + ",sequence:" + localQMFolder.getSequence() + ",synckey:" + localQMFolder.getSyncKey() + ",cliConvUnreadCount:" + localQMFolder.getCliConvUnreadCount() + ",syncState:" + localQMFolder.getSyncState() + ",ftnExpUnread:" + localQMFolder.getFtnExpUnread() + ",remoteid:" + localQMFolder.getRemoteId() + ",isVirtual:" + localQMFolder.isVirtual() + ",folderType:" + localQMFolder.getType() + ",since:" + localQMFolder.getSince());
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void initReservedMap()
  {
    this.reservedMap = new HashMap();
    HashSet localHashSet1 = new HashSet();
    localHashSet1.add("163.com");
    localHashSet1.add("126.com");
    HashSet localHashSet2 = new HashSet();
    localHashSet2.add(Integer.valueOf(2131693917));
    localHashSet2.add(Integer.valueOf(2131693918));
    localHashSet2.add(Integer.valueOf(2131693919));
    this.reservedMap.put(localHashSet1, localHashSet2);
    localHashSet1 = new HashSet();
    localHashSet1.add("gmail.com");
    localHashSet2 = new HashSet();
    localHashSet2.add(Integer.valueOf(2131693909));
    localHashSet2.add(Integer.valueOf(2131693910));
    localHashSet2.add(Integer.valueOf(2131693911));
    this.reservedMap.put(localHashSet1, localHashSet2);
    localHashSet1 = new HashSet();
    localHashSet1.add("tencent.com");
    localHashSet2 = new HashSet();
    localHashSet2.add(Integer.valueOf(2131693925));
    this.reservedMap.put(localHashSet1, localHashSet2);
  }
  
  public static boolean isAppFolder(QMFolder paramQMFolder)
  {
    if (paramQMFolder != null)
    {
      int i = paramQMFolder.getId();
      if ((i == -22) || (i == -5) || (i == -16) || (i == -4) || (i == -18) || (i == -23) || (paramQMFolder.getType() == 130)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isUniversalSection(QMFolder paramQMFolder)
  {
    int i = paramQMFolder.getId();
    int j = paramQMFolder.getType();
    return (i == -3) || (i == -9) || (i == -19) || (i == -2) || (j == 1);
  }
  
  private void setHybirdFolderUnreadCount(@NonNull QMFolder paramQMFolder, boolean paramBoolean, HybirdFolderCallback paramHybirdFolderCallback)
  {
    int i = paramQMFolder.getId();
    if (!paramBoolean)
    {
      int j = paramHybirdFolderCallback.getUnreadCount(i);
      paramBoolean = paramHybirdFolderCallback.hasNewMail();
      this.folderUnreadCache.put(i, j);
      this.folderHasNewCache.put(i, paramBoolean);
      paramQMFolder.setCliUnreadCount(j);
      paramQMFolder.setHasNewMail(paramBoolean);
    }
    do
    {
      return;
      paramQMFolder.setCliUnreadCount(this.folderUnreadCache.get(i));
      paramQMFolder.setHasNewMail(this.folderHasNewCache.get(i));
      paramQMFolder = "hybird_folder_unread_" + paramQMFolder.getId();
    } while (RequestFilter.isRequestOnRunning(paramQMFolder));
    RequestFilter.setRequestRunningState(paramQMFolder);
    Threads.runInBackground(new QMFolderManager.3(this, paramHybirdFolderCallback, i, paramQMFolder));
  }
  
  public static QMFolderManager sharedInstance()
  {
    createInstance(QMMailManager.sharedInstance().getSqliteHelper());
    try
    {
      _instanceWithCached.get();
      return _instance;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMFolderManager", "QMFolderManager future task failed", localException);
      }
    }
  }
  
  public boolean canConvFolderIds(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = getNoConvFolderIds(paramInt1);
    if (arrayOfInt != null)
    {
      int i = arrayOfInt.length;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        if (arrayOfInt[paramInt1] == paramInt2) {
          return false;
        }
        paramInt1 += 1;
      }
    }
    return true;
  }
  
  public void deleteAccountFolders(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.sqliteHelper.folder.deleteFoldersByAccountId(paramSQLiteDatabase, paramInt);
  }
  
  public ArrayList<QMFolder> getAllFoldersByAccountId(int paramInt)
  {
    return this.sqliteHelper.folder.getFoldersByAccountId(paramInt);
  }
  
  public int getDisplayUnreadCount(QMFolder paramQMFolder)
  {
    int j;
    if (paramQMFolder == null) {
      j = 0;
    }
    int k;
    int i;
    QMAggrConvMailCache localQMAggrConvMailCache;
    do
    {
      do
      {
        do
        {
          return j;
          switch (paramQMFolder.getType())
          {
          default: 
            k = paramQMFolder.getAccountId();
            if ((k <= 0) || (!QMSettingManager.sharedInstance().getAggregateSubject(k))) {
              break;
            }
          }
          for (i = paramQMFolder.getCliConvUnreadCount();; i = paramQMFolder.getCliUnreadCount())
          {
            localQMAggrConvMailCache = QMAggrConvMailCache.sharedInstance();
            if ((paramQMFolder.getId() != -1) || (!QMSettingManager.sharedInstance().getAggregateSubscribeMail())) {
              break;
            }
            return i + localQMAggrConvMailCache.getSubscribeConvUnreadCount(0);
            return 0;
          }
          j = i;
        } while (paramQMFolder.getType() != 1);
        j = i;
      } while (!QMSettingManager.sharedInstance().getAggregateSubscribeMail());
      paramQMFolder = AccountManager.shareInstance().getAccountList().getAccountById(k);
      if (paramQMFolder == null) {
        return 0;
      }
      j = i;
    } while (!paramQMFolder.isQQMail());
    return i + localQMAggrConvMailCache.getSubscribeConvUnreadCount(k);
  }
  
  public int getDraftFolderId(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return arrayOfInt[2];
    }
    return 0;
  }
  
  @Nullable
  public QMFolder getFolder(int paramInt)
  {
    return getFolder(paramInt, false);
  }
  
  @Nullable
  public QMFolder getFolder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt2 > 0) {
      localObject = this.sqliteHelper.folder.getFolderById(paramInt2);
    }
    QMFolder localQMFolder;
    do
    {
      return localObject;
      localQMFolder = this.sqliteHelper.folder.getHybirdFolder(paramInt2);
      localObject = localQMFolder;
    } while (localQMFolder == null);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      setHybirdFolderUnreadCount(localQMFolder, paramBoolean, new HybirdFolderCallback(this.sqliteHelper));
      return localQMFolder;
      setHybirdFolderUnreadCount(localQMFolder, paramBoolean, new QMFolderManager.2(this, this.sqliteHelper));
    }
  }
  
  @Nullable
  public QMFolder getFolder(int paramInt, boolean paramBoolean)
  {
    return getFolder(-1, paramInt, paramBoolean);
  }
  
  public int[] getFolderIds(int paramInt)
  {
    return this.sqliteHelper.folder.getFolderIds(paramInt);
  }
  
  public String getFolderNameByType(String paramString, int paramInt)
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    switch (paramInt)
    {
    case 2: 
    default: 
      return paramString;
    case 1: 
      return localQMApplicationContext.getString(2131693913);
    case 4: 
      return localQMApplicationContext.getString(2131693908);
    case 3: 
      return localQMApplicationContext.getString(2131693920);
    case 5: 
      return localQMApplicationContext.getString(2131693928);
    }
    return localQMApplicationContext.getString(2131693923);
  }
  
  public int getFolderSequenze(int paramInt1, int paramInt2)
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    switch (paramInt2)
    {
    default: 
      return paramInt1;
    case 1: 
      return Integer.valueOf(localQMApplicationContext.getString(2131719547)).intValue();
    case 16: 
      return Integer.valueOf(localQMApplicationContext.getString(2131719553)).intValue();
    case 4: 
      return Integer.valueOf(localQMApplicationContext.getString(2131719546)).intValue();
    case 3: 
      return Integer.valueOf(localQMApplicationContext.getString(2131719551)).intValue();
    case 5: 
      return Integer.valueOf(localQMApplicationContext.getString(2131719554)).intValue();
    }
    return Integer.valueOf(localQMApplicationContext.getString(2131719552)).intValue();
  }
  
  public String getFolderSyncKey(int paramInt)
  {
    return this.sqliteHelper.folder.getFolderSyncKey(paramInt);
  }
  
  public String getFolderSyncState(int paramInt)
  {
    return this.sqliteHelper.folder.getFolderSyncState(paramInt);
  }
  
  public int getFolderType(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return 0;
      Object localObject = QMApplicationContext.sharedInstance();
      String[] arrayOfString = ((QMApplicationContext)localObject).getString(2131720750).split(",");
      int j = arrayOfString.length;
      int i = 0;
      String str;
      while (i < j)
      {
        str = arrayOfString[i];
        if (paramString.toUpperCase().contains(str)) {
          return 1;
        }
        i += 1;
      }
      arrayOfString = ((QMApplicationContext)localObject).getString(2131720748).split(",");
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (paramString.toUpperCase().contains(str)) {
          return 4;
        }
        i += 1;
      }
      arrayOfString = ((QMApplicationContext)localObject).getString(2131720756).split(",");
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (paramString.toUpperCase().contains(str)) {
          return 3;
        }
        i += 1;
      }
      arrayOfString = ((QMApplicationContext)localObject).getString(2131720759).split(",");
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (paramString.toUpperCase().contains(str)) {
          return 5;
        }
        i += 1;
      }
      localObject = ((QMApplicationContext)localObject).getString(2131720757).split(",");
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        arrayOfString = localObject[i];
        if (paramString.toUpperCase().contains(arrayOfString)) {
          return 6;
        }
        i += 1;
      }
    }
  }
  
  public ArrayList<QMFolder> getFoldersByAccountAndType(int paramInt1, int paramInt2)
  {
    return this.sqliteHelper.folder.getFoldersByAccountAndType(paramInt1, paramInt2);
  }
  
  public ArrayList<QMFolder> getFoldersByAccountAndTypes(int paramInt, int[] paramArrayOfInt)
  {
    return this.sqliteHelper.folder.getFoldersByAccountAndTypes(paramInt, paramArrayOfInt);
  }
  
  public ArrayList<QMFolder> getFoldersByAccountId(int paramInt)
  {
    return this.sqliteHelper.folder.getFoldersByAccountIdExcludeVipAndUnread(paramInt);
  }
  
  public List<QMFolder> getFoldersByIds(int[] paramArrayOfInt)
  {
    return this.sqliteHelper.folder.getFoldersInIds(paramArrayOfInt);
  }
  
  public int getInboxFolderId(int paramInt)
  {
    int i = 0;
    int[] arrayOfInt = getFolderIds(paramInt);
    paramInt = i;
    if (arrayOfInt != null) {
      paramInt = arrayOfInt[0];
    }
    return paramInt;
  }
  
  public boolean getInboxHasNewMail(int paramInt)
  {
    return this.sqliteHelper.folder.getInboxHasNewMail(this.sqliteHelper.getReadableDatabase(), paramInt);
  }
  
  public int[] getNoConvFolderIds(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return new int[] { arrayOfInt[1], arrayOfInt[2], arrayOfInt[3], arrayOfInt[4] };
    }
    return null;
  }
  
  public int getQQMailGroupFolderId(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return arrayOfInt[5];
    }
    return 0;
  }
  
  public int getQQMailStarredFolderId(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return arrayOfInt[6];
    }
    return 0;
  }
  
  public int getQQMailSubFolderId(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return arrayOfInt[8];
    }
    return 0;
  }
  
  public int getQQMailUnreadFolderId(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return arrayOfInt[9];
    }
    return 0;
  }
  
  public int getQQMailVipFolderId(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return arrayOfInt[7];
    }
    return 0;
  }
  
  public int getQQUnreadCountByType(int paramInt)
  {
    return this.sqliteHelper.folder.getQQUnreadCountByType(paramInt);
  }
  
  public int getSentFolderId(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return arrayOfInt[1];
    }
    return 0;
  }
  
  public int getSpamFolderId(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return arrayOfInt[4];
    }
    return 0;
  }
  
  public int getTrashFolderId(int paramInt)
  {
    int[] arrayOfInt = getFolderIds(paramInt);
    if (arrayOfInt != null) {
      return arrayOfInt[3];
    }
    return 0;
  }
  
  public boolean hasNewMail(QMFolder paramQMFolder)
  {
    switch (paramQMFolder.getType())
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return paramQMFolder.hasNewMail();
    }
    return false;
  }
  
  public boolean isFolderNameReserved(Account paramAccount, String paramString)
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    boolean bool1;
    boolean bool2;
    label52:
    Object localObject;
    if (getFolderType(paramString) != 0)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1) {
        break label211;
      }
      bool2 = bool1;
      if (paramAccount == null) {
        break label211;
      }
      paramAccount = paramAccount.getEmail();
      Iterator localIterator1 = this.reservedMap.entrySet().iterator();
      if (!localIterator1.hasNext()) {
        break label207;
      }
      localObject = (Map.Entry)localIterator1.next();
      Iterator localIterator2 = ((HashSet)((Map.Entry)localObject).getKey()).iterator();
      String str;
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        str = (String)localIterator2.next();
      } while (!paramAccount.endsWith("@" + str));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = ((HashSet)((Map.Entry)localObject).getValue()).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.equals(localQMApplicationContext.getString(((Integer)((Iterator)localObject).next()).intValue()))) {
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        break label52;
        bool1 = false;
        break;
        label207:
        bool2 = bool1;
        label211:
        return bool2;
      }
    }
  }
  
  public boolean isFolderNameReserved(QMFolder paramQMFolder)
  {
    boolean bool1 = false;
    if (paramQMFolder == null) {
      return true;
    }
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramQMFolder.getAccountId());
    int i = paramQMFolder.getType();
    int j = paramQMFolder.getId();
    paramQMFolder = paramQMFolder.getName();
    if ((i != 12) && (i != 13) && (i != 14) && (i != 0))
    {
      i = 1;
      if ((j != -4) && (j != -5)) {
        break label110;
      }
    }
    label110:
    for (j = 1;; j = 0)
    {
      boolean bool2 = isFolderNameReserved(localAccount, paramQMFolder);
      if ((i != 0) || (j != 0) || (bool2)) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
    }
  }
  
  public int queryIncrementUnread()
  {
    return this.sqliteHelper.folder.queryIncrementUnread(this.sqliteHelper.getReadableDatabase());
  }
  
  public void resetFolderHasNew(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (paramInt == -1)
    {
      this.sqliteHelper.folder.resetAllInboxHasNew(localSQLiteDatabase);
      return;
    }
    this.sqliteHelper.folder.resetFolderHasNew(localSQLiteDatabase, paramInt);
  }
  
  public void resetFolders(int paramInt, int[] paramArrayOfInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    int[] arrayOfInt = this.sqliteHelper.folder.getExcludeFolderIds(paramInt, paramArrayOfInt);
    this.sqliteHelper.folder.resetFolders(localSQLiteDatabase, paramInt, paramArrayOfInt);
    if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
      this.sqliteHelper.mail.updateMailsFolderId(localSQLiteDatabase, paramArrayOfInt, 0, false);
    }
  }
  
  public void setAllHasNewMailToFalse()
  {
    this.sqliteHelper.folder.setAllHasNewMailToFalse(this.sqliteHelper.getWritableDatabase());
  }
  
  public void setFolderHasNew(int paramInt)
  {
    this.sqliteHelper.folder.setFolderHasNew(this.sqliteHelper.getWritableDatabase(), paramInt);
  }
  
  public void setOverdue(int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.sqliteHelper.folder.setOverdue(this.sqliteHelper.getWritableDatabase(), paramArrayOfInt, paramBoolean);
  }
  
  public void updateFolderPushStatus(int[] paramArrayOfInt, boolean[] paramArrayOfBoolean)
  {
    this.sqliteHelper.folder.updateFolderPushStatus(this.sqliteHelper.getWritableDatabase(), paramArrayOfInt, paramArrayOfBoolean);
  }
  
  public void updateFolderSvrCount(int paramInt1, int paramInt2)
  {
    this.sqliteHelper.folder.updateFolderSvrCount(this.sqliteHelper.getWritableDatabase(), paramInt1, paramInt2);
  }
  
  public void updateFolderSyncKey(int paramInt, String paramString)
  {
    this.sqliteHelper.folder.updateFolderSyncKey(this.sqliteHelper.getWritableDatabase(), paramInt, paramString);
  }
  
  public void updateFolderSyncState(int paramInt, String paramString)
  {
    this.sqliteHelper.folder.updateFolderSyncState(this.sqliteHelper.getWritableDatabase(), paramInt, paramString);
  }
  
  public void updateLatestUnread()
  {
    this.sqliteHelper.folder.updateLatestUnread(this.sqliteHelper.getWritableDatabase());
  }
  
  public void updateLocalMailUnreadCountIntoFolder(int paramInt)
  {
    try
    {
      this.sqliteHelper.folder.updateLocalMailUnreadCountIntoFolder(this.sqliteHelper.getWritableDatabase(), QMMailSQLite.sqlUpdateLocalMailUrCntIntoFolder, paramInt);
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "QMFolderManager", "updateLocalMailUnreadCountIntoFolder, folderId: " + paramInt, localException);
    }
  }
  
  public void updateProtocolMailServerCountIntoFolder(int paramInt1, int paramInt2, int paramInt3)
  {
    this.sqliteHelper.folder.updateProtocolMailServerCountIntoFolder(this.sqliteHelper.getWritableDatabase(), paramInt1, paramInt2, paramInt3);
  }
  
  public FolderNameValidationErrorCode validateFolderName(int paramInt, String paramString, boolean paramBoolean)
  {
    return validateFolderName(this.sqliteHelper, paramInt, paramString, paramBoolean);
  }
  
  public FolderNameValidationErrorCode validateFolderName(QMMailSQLiteHelper paramQMMailSQLiteHelper, int paramInt, String paramString, boolean paramBoolean)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (((localAccount != null) && (localAccount.isQQMail())) || (paramBoolean))
    {
      int j = QMUtilities.length(paramString);
      if (paramBoolean) {
        i = 50;
      }
      while (j > i) {
        if (paramBoolean)
        {
          return FolderNameValidationErrorCode.TAG_TOO_LONG;
          i = 80;
        }
        else
        {
          return FolderNameValidationErrorCode.TOO_LONG;
        }
      }
      String[] arrayOfString = "~!#$%^&*()=+|\\[]{};':\",?/<>".split("");
      j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((str.length() > 0) && (paramString.indexOf(str.charAt(0)) > -1)) {
          return FolderNameValidationErrorCode.INVALID_CHAR;
        }
        i += 1;
      }
    }
    if (paramQMMailSQLiteHelper.folder.getFoldersByName(paramInt, paramString, paramBoolean).size() > 0) {
      return FolderNameValidationErrorCode.EXISTS;
    }
    if ((!paramBoolean) && (isFolderNameReserved(localAccount, paramString))) {
      return FolderNameValidationErrorCode.RESERVE;
    }
    return FolderNameValidationErrorCode.VALID;
  }
  
  public static enum FolderNameValidationErrorCode
  {
    private static final int[] FolderNameValidationErrorMessage = { -1, 2131689781, 2131689778, 2131689782, 2131689779, 2131689780 };
    private static final int[] FolderNameValidationErrorReason;
    private int value = -1;
    
    static
    {
      TOO_LONG = new FolderNameValidationErrorCode("TOO_LONG", 1, 1);
      INVALID_CHAR = new FolderNameValidationErrorCode("INVALID_CHAR", 2, 2);
      EXISTS = new FolderNameValidationErrorCode("EXISTS", 3, 3);
      RESERVE = new FolderNameValidationErrorCode("RESERVE", 4, 4);
      TAG_TOO_LONG = new FolderNameValidationErrorCode("TAG_TOO_LONG", 5, 5);
      $VALUES = new FolderNameValidationErrorCode[] { VALID, TOO_LONG, INVALID_CHAR, EXISTS, RESERVE, TAG_TOO_LONG };
      FolderNameValidationErrorReason = new int[] { -1, 2131689784, 2131689783, -1, -1, 2131689784 };
    }
    
    private FolderNameValidationErrorCode(int paramInt)
    {
      this.value = paramInt;
    }
    
    public String getMessage()
    {
      if (this.value < 1) {}
      int i;
      do
      {
        return null;
        i = FolderNameValidationErrorMessage[this.value];
      } while (i == -1);
      return QMApplicationContext.sharedInstance().getString(i).replace("$invalidchar$", "~!#$%^&*()=+|\\[]{};':\",?/<>");
    }
    
    public String getReason()
    {
      if (this.value < 1) {}
      int i;
      do
      {
        return null;
        i = FolderNameValidationErrorReason[this.value];
      } while (i == -1);
      return QMApplicationContext.sharedInstance().getString(i);
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
  
  public static enum FolderOperationType
  {
    private static final int[] FolderOperationFailHints = { 2131689785, 2131718792, 2131692475, 2131692475, 2131689785, 2131718792, 2131692475 };
    private static final int[] FolderOperationSuccessHints;
    private int value = -1;
    
    static
    {
      REMOVE_FOLDER = new FolderOperationType("REMOVE_FOLDER", 2, 2);
      REMOVE_FOLDER_AND_MOVE_MAIL = new FolderOperationType("REMOVE_FOLDER_AND_MOVE_MAIL", 3, 3);
      ADD_TAG = new FolderOperationType("ADD_TAG", 4, 4);
      RENAME_TAG = new FolderOperationType("RENAME_TAG", 5, 5);
      REMOVE_TAG = new FolderOperationType("REMOVE_TAG", 6, 6);
      $VALUES = new FolderOperationType[] { ADD_FOLDER, RENAME_FOLDER, REMOVE_FOLDER, REMOVE_FOLDER_AND_MOVE_MAIL, ADD_TAG, RENAME_TAG, REMOVE_TAG };
      FolderOperationSuccessHints = new int[] { 2131689786, 2131718793, 2131692478, 2131692473, 2131689786, 2131718793, 2131692478 };
    }
    
    private FolderOperationType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int getErrorHint()
    {
      return FolderOperationFailHints[this.value];
    }
    
    public int getSuccessHint()
    {
      return FolderOperationSuccessHints[this.value];
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
  
  static class HybirdFolderCallback
  {
    private QMMailSQLiteHelper sqliteHelper;
    
    public HybirdFolderCallback(QMMailSQLiteHelper paramQMMailSQLiteHelper)
    {
      this.sqliteHelper = paramQMMailSQLiteHelper;
    }
    
    public int getUnreadCount(int paramInt)
    {
      return this.sqliteHelper.folder.getAllFolderUnreadCount(this.sqliteHelper.getReadableDatabase(), paramInt);
    }
    
    public boolean hasNewMail()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.QMFolderManager
 * JD-Core Version:    0.7.0.1
 */