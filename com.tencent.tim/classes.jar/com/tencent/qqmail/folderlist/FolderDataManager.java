package com.tencent.qqmail.folderlist;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.QMAccountHelper;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.trd.guava.Joiner;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

public class FolderDataManager
{
  public static final String ACCCOUNT_PREFERENCE = "accounts_info";
  public static final String DEFAULT_FOLDER_KEY = "default_folder_key2";
  public static final String ENTER_APPFOLDER_FIRST = "enter_appfolder_first";
  public static final String HAS_SYNC_FOLDER = "has_sync_folder";
  public static final String HAS_SYNC_NON_QQDOMAIN_FOLDER = "has_sync_non_qqdomain_folder";
  public static final String HAS_SYNC_QQDOMAIN_FOLDER = "has_sync_qqdomain_folder";
  public static final String HOME_APPFOLDER_CHECK_NOT_SHOW = "home_appfolder_check_not_show";
  public static final String HOME_APPFOLDER_ID_LIST = "home_appfolder_id_list";
  public static final String INBOX_FOLDER_KEY = "inbox_folder_key2";
  public static final String INNER_APPFOLDER_ID_LIST = "inner_appfolder_id_list";
  public static final String LINE_SEP = "\n";
  private static final String TAG = "FolderDataManager";
  public static final String VERSION = "2";
  private static FolderDataManager _instance;
  private static Future<Void> instanceWithCached;
  public static final String splite = ",";
  private final String INNER_BOTTLE_UNREAD_COUNT = "inner_bottle_unread_count";
  private final String INNER_FTN_UNREAD_COUNT = "inner_ftn_unread_count";
  private QMMailSQLiteHelper sqliteHelper = null;
  
  private FolderDataManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    instanceWithCached = Threads.submitTask(new FolderDataManager.1(this, paramQMMailSQLiteHelper));
  }
  
  public static FolderData generateAccountFolderData(int paramInt)
  {
    return generateFolderData(paramInt, 0, null, 3, -1, 0, false, true, false);
  }
  
  public static FolderData generateFolderData(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    FolderData localFolderData = new FolderData();
    localFolderData.setAccountId(paramInt1);
    localFolderData.setFolderId(paramInt2);
    localFolderData.setSection(paramInt3);
    localFolderData.setSequence(paramInt4);
    localFolderData.setType(paramInt5);
    localFolderData.setShouldShow(paramBoolean1);
    localFolderData.setName(paramString);
    localFolderData.setProcessing(paramBoolean3);
    localFolderData.setPersistence(paramBoolean2);
    localFolderData.setId(FolderData.generateId(paramInt2, paramInt1));
    return localFolderData;
  }
  
  public static FolderData generateUnOrderFolderData(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return generateFolderData(paramInt1, paramInt2, paramString, paramInt3, -1, paramInt4, paramBoolean1, paramBoolean2, false);
  }
  
  private static ArrayList<Integer> getAppIdList(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0);
    ArrayList localArrayList = new ArrayList();
    paramString = localSharedPreferences.getString(paramString, "");
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        while (i < j)
        {
          localArrayList.add(Integer.valueOf(Integer.parseInt(paramString[i])));
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<Integer> getHomeAppCheckIdList()
  {
    return getAppIdList("home_appfolder_check_not_show");
  }
  
  public static ArrayList<Integer> getHomeAppIdList()
  {
    return getAppIdList("home_appfolder_id_list");
  }
  
  public static ArrayList<Integer> getInnerAppIdList()
  {
    return getAppIdList("inner_appfolder_id_list");
  }
  
  public static ArrayList<Integer> moveAppFromHomeToInner(int paramInt)
  {
    Object localObject2 = getHomeAppIdList();
    ArrayList localArrayList = getInnerAppIdList();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = localArrayList;
    if (localArrayList == null) {
      localObject2 = new ArrayList();
    }
    if (((ArrayList)localObject1).indexOf(Integer.valueOf(paramInt)) != -1)
    {
      ((ArrayList)localObject1).remove(Integer.valueOf(paramInt));
      if (((ArrayList)localObject1).size() == 0) {
        ((ArrayList)localObject1).add(Integer.valueOf(-20));
      }
    }
    if (((ArrayList)localObject2).indexOf(Integer.valueOf(paramInt)) == -1) {
      ((ArrayList)localObject2).add(Integer.valueOf(paramInt));
    }
    setHomeAppIdList((ArrayList)localObject1);
    setInnerAppIdList((ArrayList)localObject2);
    return localObject1;
  }
  
  public static void moveAppFromHomeToInnerAndSendToServer(int paramInt)
  {
    ArrayList localArrayList = moveAppFromHomeToInner(paramInt);
    sharedInstance().sendApplicationShowInHome(localArrayList);
  }
  
  public static ArrayList<Integer> moveAppFromInnerToHome(int paramInt)
  {
    ArrayList localArrayList1 = getHomeAppIdList();
    ArrayList localArrayList3 = getInnerAppIdList();
    if (localArrayList1 == null) {
      localArrayList1 = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList2 = localArrayList3;
      if (localArrayList3 == null) {
        localArrayList2 = new ArrayList();
      }
      if (localArrayList2.indexOf(Integer.valueOf(paramInt)) != -1) {
        localArrayList2.remove(Integer.valueOf(paramInt));
      }
      if ((localArrayList1 != null) && (localArrayList1.size() > 0) && (localArrayList1.indexOf(Integer.valueOf(paramInt)) == -1)) {
        if (localArrayList1.indexOf(Integer.valueOf(-20)) == -1) {
          break label120;
        }
      }
      label120:
      for (int i = localArrayList1.size() - 1;; i = localArrayList1.size())
      {
        localArrayList1.add(i, Integer.valueOf(paramInt));
        setHomeAppIdList(localArrayList1);
        setInnerAppIdList(localArrayList2);
        return localArrayList1;
      }
    }
  }
  
  public static void moveAppFromInnerToHomeAndSendToServer(int paramInt)
  {
    ArrayList localArrayList = moveAppFromInnerToHome(paramInt);
    sharedInstance().sendApplicationShowInHome(localArrayList);
  }
  
  private static void setAppIdList(ArrayList<Integer> paramArrayList, String paramString)
  {
    SharedPreferences.Editor localEditor = QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).edit();
    if (paramArrayList != null) {
      localEditor.putString(paramString, Joiner.on(",").skipNulls().join(paramArrayList)).commit();
    }
  }
  
  public static void setHomeAppIdList(ArrayList<Integer> paramArrayList)
  {
    setAppIdList(paramArrayList, "home_appfolder_id_list");
  }
  
  public static void setHomeAppfolderCheckNotShow(ArrayList<Integer> paramArrayList)
  {
    setAppIdList(paramArrayList, "home_appfolder_check_not_show");
  }
  
  public static void setInnerAppIdList(ArrayList<Integer> paramArrayList)
  {
    setAppIdList(paramArrayList, "inner_appfolder_id_list");
  }
  
  public static boolean setSeqByFolderDataListOrder(ArrayList<FolderData> paramArrayList)
  {
    if (paramArrayList != null)
    {
      int i = 0;
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= paramArrayList.size()) {
          break;
        }
        if (((FolderData)paramArrayList.get(i)).getSequence() != i) {
          bool1 = true;
        }
        ((FolderData)paramArrayList.get(i)).setSequence(i);
        i += 1;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  /* Error */
  public static FolderDataManager sharedInstance()
  {
    // Byte code:
    //   0: getstatic 287	com/tencent/qqmail/folderlist/FolderDataManager:_instance	Lcom/tencent/qqmail/folderlist/FolderDataManager;
    //   3: ifnonnull +31 -> 34
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 287	com/tencent/qqmail/folderlist/FolderDataManager:_instance	Lcom/tencent/qqmail/folderlist/FolderDataManager;
    //   12: ifnonnull +19 -> 31
    //   15: new 2	com/tencent/qqmail/folderlist/FolderDataManager
    //   18: dup
    //   19: invokestatic 292	com/tencent/qqmail/model/mail/QMMailManager:sharedInstance	()Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   22: invokevirtual 296	com/tencent/qqmail/model/mail/QMMailManager:getSqliteHelper	()Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   25: invokespecial 298	com/tencent/qqmail/folderlist/FolderDataManager:<init>	(Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;)V
    //   28: putstatic 287	com/tencent/qqmail/folderlist/FolderDataManager:_instance	Lcom/tencent/qqmail/folderlist/FolderDataManager;
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 84	com/tencent/qqmail/folderlist/FolderDataManager:instanceWithCached	Ljava/util/concurrent/Future;
    //   37: invokeinterface 303 1 0
    //   42: pop
    //   43: getstatic 287	com/tencent/qqmail/folderlist/FolderDataManager:_instance	Lcom/tencent/qqmail/folderlist/FolderDataManager;
    //   46: areturn
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: astore_0
    //   54: bipush 6
    //   56: ldc 41
    //   58: aload_0
    //   59: invokestatic 309	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   62: invokestatic 315	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   65: goto -22 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject	Object
    //   53	6	0	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   9	31	47	finally
    //   31	34	47	finally
    //   48	51	47	finally
    //   34	43	53	java/lang/Exception
  }
  
  private ArrayList<Integer> transformFromConfig(LinkedList<Integer> paramLinkedList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext()) {
        switch (((Integer)paramLinkedList.next()).intValue())
        {
        default: 
          break;
        case 0: 
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(0));
          return localArrayList;
        case 1: 
          localArrayList.add(Integer.valueOf(-16));
          break;
        case 5: 
          localArrayList.add(Integer.valueOf(-18));
          break;
        case 2: 
          localArrayList.add(Integer.valueOf(-5));
          break;
        case 4: 
          localArrayList.add(Integer.valueOf(-22));
          break;
        case 3: 
          localArrayList.add(Integer.valueOf(-4));
          break;
        case 6: 
          localArrayList.add(Integer.valueOf(-23));
        }
      }
    }
    return localArrayList;
  }
  
  private LinkedList<Integer> transformToConfig(ArrayList<Integer> paramArrayList)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        switch (((Integer)paramArrayList.next()).intValue())
        {
        default: 
          break;
        case -23: 
          localLinkedList.add(Integer.valueOf(6));
          break;
        case -16: 
          localLinkedList.add(Integer.valueOf(1));
          break;
        case -18: 
          localLinkedList.add(Integer.valueOf(5));
          break;
        case -5: 
          localLinkedList.add(Integer.valueOf(2));
          break;
        case -22: 
          localLinkedList.add(Integer.valueOf(4));
          break;
        case -4: 
          localLinkedList.add(Integer.valueOf(3));
        }
      }
    }
    if (localLinkedList.size() == 0) {
      localLinkedList.add(Integer.valueOf(0));
    }
    return localLinkedList;
  }
  
  public void clearInnerUnreadCount(int paramInt)
  {
    if (paramInt == QMSettingManager.sharedInstance().getDefaultBottleAccountID()) {
      setInnerBottleUnreadCount(0);
    }
    if (paramInt == QMSettingManager.sharedInstance().getDefaultFtnAccountID()) {
      setInnerFtnUnreadCount(0);
    }
  }
  
  public void deleteAccountInboxByAccId(int paramInt)
  {
    this.sqliteHelper.folderData.deleteAccountInbox(this.sqliteHelper.getWritableDatabase(), paramInt);
  }
  
  public void deleteFolderDataById(FolderData paramFolderData)
  {
    if (paramFolderData != null)
    {
      this.sqliteHelper.folderData.deleteFolderData(this.sqliteHelper.getWritableDatabase(), paramFolderData);
      QMLog.log(4, "FolderDataManager", "delete FolderData by id:" + paramFolderData.getId());
      return;
    }
    QMLog.log(4, "FolderDataManager", "deleteFolderDataById FolderData null");
  }
  
  public void deleteFolderDataList()
  {
    this.sqliteHelper.folderData.deleteAllFolderData(this.sqliteHelper.getWritableDatabase());
    QMLog.log(4, "FolderDataManager", "delete FolderDataList");
  }
  
  public ArrayList<FolderData> getActiveFolderDataList()
  {
    return this.sqliteHelper.folderData.queryActiveFolderData();
  }
  
  public Set<Integer> getActiveFolderIdsByAccountId(int paramInt)
  {
    return this.sqliteHelper.folderData.queryActiveFolderIdsByAccountId(paramInt);
  }
  
  public FolderData getFolderDataByFolderId(int paramInt)
  {
    return this.sqliteHelper.folderData.queryFolderDataByFolderId(paramInt);
  }
  
  public ArrayList<FolderData> getFolderDataListBySection(int paramInt)
  {
    ArrayList localArrayList = this.sqliteHelper.folderData.queryFolderDataBySection(paramInt);
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public int getInnerBottleUnreadCount()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).getInt("inner_bottle_unread_count", 0);
  }
  
  public int getInnerFtnUnreadCount()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).getInt("inner_ftn_unread_count", 0);
  }
  
  public void insertFolderData(FolderData paramFolderData)
  {
    if (paramFolderData != null)
    {
      this.sqliteHelper.folderData.insertFolderData(this.sqliteHelper.getWritableDatabase(), paramFolderData);
      return;
    }
    QMLog.log(4, "FolderDataManager", "insert FolderData null");
  }
  
  public void insertFolderDataList(ArrayList<FolderData> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.sqliteHelper.folderData.insertFolderData(this.sqliteHelper.getWritableDatabase(), paramArrayList);
      QMLog.log(4, "FolderDataManager", "insert FolderData " + paramArrayList.size());
      return;
    }
    QMLog.log(4, "FolderDataManager", "insert FolderData null");
  }
  
  public boolean isEnterAppFolderFragmentFirst()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).getBoolean("enter_appfolder_first", true);
  }
  
  public boolean isShowInnerBottleUnread()
  {
    Object localObject = getInnerAppIdList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Integer)((Iterator)localObject).next()).intValue() != -16);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = BottleManager.getInstance();
        if (localObject != null)
        {
          localObject = ((BottleManager)localObject).getBottleListController();
          if ((localObject != null) && (((BottleListController)localObject).getBottleUnreadCount() > getInnerBottleUnreadCount()))
          {
            QMLog.log(4, "FolderDataManager", "plpUnread:" + ((BottleListController)localObject).getBottleUnreadCount() + ",appFolderPlpUnread:" + getInnerBottleUnreadCount());
            return true;
          }
        }
      }
      return false;
    }
  }
  
  public boolean isShowInnerFtnUnread()
  {
    Object localObject = getInnerAppIdList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Integer)((Iterator)localObject).next()).intValue() != -5);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = FtnManager.sharedInstance();
        if ((localObject != null) && (((FtnManager)localObject).isFtnExpUnreadNeedShow()) && (((FtnManager)localObject).getFtnExpUnreadCount() > getInnerFtnUnreadCount()))
        {
          QMLog.log(4, "FolderDataManager", "ftnUnread:" + ((FtnManager)localObject).getFtnExpUnreadCount() + ",appFolderFtnUnread:" + getInnerFtnUnreadCount());
          return true;
        }
      }
      return false;
    }
  }
  
  public void saveApplicationShowInHome(LinkedList<Integer> paramLinkedList)
  {
    boolean bool4 = true;
    int m = 0;
    QMLog.log(4, "FolderDataManager", "getApplicationShowHome from updateConfig" + paramLinkedList);
    Object localObject = AccountManager.shareInstance().getAccountList().iterator();
    int j = 0;
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      int k;
      if (((Account)((Iterator)localObject).next()).isQQMail())
      {
        k = j;
        j = i + 1;
      }
      for (i = k;; i = k)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = j + 1;
        j = i;
      }
    }
    localObject = QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0);
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("has_sync_qqdomain_folder", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("has_sync_non_qqdomain_folder", false);
    boolean bool3 = ((SharedPreferences)localObject).getBoolean("has_sync_folder", false);
    if ((i == 1) && (!bool1))
    {
      QMLog.log(4, "FolderDataManager", "sync ApplicationShowInHome for first QQDomain:" + paramLinkedList);
      i = 1;
      bool1 = bool2;
      bool2 = true;
      bool3 = bool4;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramLinkedList = transformFromConfig(paramLinkedList);
        QMLog.log(4, "FolderDataManager", "sync app folder:" + paramLinkedList);
        setHomeAppIdList(paramLinkedList);
        QMAccountHelper.getInnerAppFolders(paramLinkedList);
      }
      paramLinkedList = ((SharedPreferences)localObject).edit();
      paramLinkedList.putBoolean("has_sync_qqdomain_folder", bool2);
      paramLinkedList.putBoolean("has_sync_non_qqdomain_folder", bool1);
      paramLinkedList.putBoolean("has_sync_folder", bool3);
      QMLog.log(4, "FolderDataManager", "hasSyncQQDomain:" + bool2 + ",hasSyncNonQQDomain:" + bool1 + ",hasSync:" + bool3);
      paramLinkedList.commit();
      return;
      if ((j == 1) && (i == 0) && (!bool2))
      {
        QMLog.log(4, "FolderDataManager", "sync ApplicationShowInHome for first NonQQDomain:" + paramLinkedList);
        i = 1;
        bool3 = true;
        bool2 = bool1;
        bool1 = bool3;
        bool3 = bool4;
      }
      else if (!bool3)
      {
        QMLog.log(4, "FolderDataManager", "sync ApplicationShowInHome for multi accounts' upgrade:" + paramLinkedList);
        i = 1;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        bool3 = bool4;
      }
      else
      {
        bool4 = bool1;
        bool1 = bool2;
        bool2 = bool4;
        i = m;
      }
    }
  }
  
  public void sendApplicationShowInHome(ArrayList<Integer> paramArrayList)
  {
    Threads.runInBackground(new FolderDataManager.2(this, paramArrayList));
  }
  
  public void setHasSync(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).edit().putBoolean("has_sync_folder", paramBoolean).commit();
  }
  
  public void setHasSyncNonQQdomainFolder(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).edit().putBoolean("has_sync_non_qqdomain_folder", paramBoolean).commit();
  }
  
  public void setHasSyncQQdomainFolder(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).edit().putBoolean("has_sync_qqdomain_folder", paramBoolean).commit();
  }
  
  public void setInnerBottleUnreadCount(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).edit().putInt("inner_bottle_unread_count", paramInt).commit();
  }
  
  public void setInnerFtnUnreadCount(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).edit().putInt("inner_ftn_unread_count", paramInt).commit();
  }
  
  public void setIsEnterAppFolderFragmentFirst(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).edit().putBoolean("enter_appfolder_first", paramBoolean).commit();
  }
  
  public void syncInnerBottleUnreadCount()
  {
    Object localObject = BottleManager.getInstance();
    if (localObject != null)
    {
      localObject = ((BottleManager)localObject).getBottleListController();
      if (localObject != null) {
        setInnerBottleUnreadCount(((BottleListController)localObject).getBottleUnreadCount());
      }
    }
  }
  
  public void syncInnerFtnUnreadCount()
  {
    FtnManager localFtnManager = FtnManager.sharedInstance();
    if (localFtnManager != null) {
      setInnerFtnUnreadCount(localFtnManager.getFtnExpUnreadCount());
    }
  }
  
  public void updateActiveFolderProcessing(ArrayList<FolderData> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      FolderData localFolderData = (FolderData)paramArrayList.next();
      if (!localFolderData.isPersistence()) {
        this.sqliteHelper.folderData.updateActiveFolderDataProcessing(this.sqliteHelper.getWritableDatabase(), localFolderData.getId(), localFolderData.isProcessing());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataManager
 * JD-Core Version:    0.7.0.1
 */