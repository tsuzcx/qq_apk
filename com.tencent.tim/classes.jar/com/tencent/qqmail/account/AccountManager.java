package com.tencent.qqmail.account;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.UpdateHook;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.AccountStateWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.badge.BadgeUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushStartUpReason;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.ShortcutUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;

public class AccountManager
{
  private static final String KEY_ABNORMAL_ACCOUNT_NOTIFY_LAST_TIME = "abnormal_account_notify_last_time_";
  private static final String SP_NAME = "account_manager_info";
  private static String TAG = "AccountManager";
  public static final String TIMELINE_TYPE_APP = "APP";
  public static final String TIMELINE_TYPE_CGI = "CGI";
  public static final String TIMELINE_TYPE_OTHER = "OTHER";
  public static final String TIMELINE_TYPE_SDK = "SDK";
  public static final String TIMELINE_TYPE_UMA = "UMA";
  private static AccountManager _instance = new AccountManager(QMApplicationContext.sharedInstance());
  private static Future<Void> initFuture = Threads.submitTask(new AccountManager.1());
  private volatile boolean accountChanged;
  private volatile AccountList accountList;
  private Object accountListLock = new Object[0];
  private final SQLiteDatabase.UpdateHook dbUpdate = new AccountManager.2(this);
  private NotifyAbnormalAccountTask mNotifyAbnormalAccountTask = new NotifyAbnormalAccountTask(null);
  private final QMAccountSQLiteHelper sqliteHelper = new QMAccountSQLiteHelper(paramContext, this.dbUpdate);
  
  private AccountManager(Context paramContext) {}
  
  private void deleteAccountById(int paramInt)
  {
    if (this.sqliteHelper.deleteAccount(this.sqliteHelper.getWritableDatabase(), paramInt))
    {
      getAccountList(true);
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "deleteAccountById. delAccount:" + paramInt);
    }
  }
  
  public static void init()
  {
    shareInstance();
  }
  
  private void initData()
  {
    getAccountList();
  }
  
  private void notifyAccountStateChange(int paramInt1, int paramInt2)
  {
    NotificationManager localNotificationManager = (NotificationManager)QMApplicationContext.sharedInstance().getSystemService("notification");
    if (paramInt2 != 0) {
      this.mNotifyAbnormalAccountTask.offer(paramInt1);
    }
    for (;;)
    {
      Threads.runInBackgroundIfNotExist(this.mNotifyAbnormalAccountTask, 5000L);
      return;
      localNotificationManager.cancel(20160418 + paramInt1);
    }
  }
  
  @NonNull
  public static AccountManager shareInstance()
  {
    try
    {
      initFuture.get();
      return _instance;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, TAG, Log.getStackTraceString(localException));
      }
    }
  }
  
  public final void bindAccountStateWatcher(AccountStateWatcher paramAccountStateWatcher, boolean paramBoolean)
  {
    Watchers.bind(paramAccountStateWatcher, paramBoolean);
  }
  
  public void deleteAccount(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = getAccountList();
    Account localAccount = ((AccountList)localObject1).getAccountById(paramInt);
    if (localAccount == null)
    {
      QMLog.log(5, TAG, "try del account acc is null");
      return;
    }
    Object localObject2 = localAccount.getEmail();
    QMLog.log(4, TAG, "del account:" + paramInt + "," + (String)localObject2);
    FolderDataManager.sharedInstance().deleteAccountInboxByAccId(paramInt);
    QMMailManager.sharedInstance().stopIdle(localAccount);
    DownloadInfoManager.shareInstance().deleteDownloadInfoByAccountId(paramInt);
    QMSyncManager.sharedInstance().deleteAccount(paramInt);
    Object localObject3 = QMTaskManager.sharedInstance(1);
    ((QMTaskManager)localObject3).cancelAll();
    Object localObject4 = ((QMTaskManager)localObject3).getTaskList();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (localObject4 != null)
    {
      i = 0;
      while (i < ((ArrayList)localObject4).size())
      {
        QMSendMailTask localQMSendMailTask = (QMSendMailTask)((ArrayList)localObject4).get(i);
        if (localQMSendMailTask.getAccountId() == paramInt)
        {
          localQMSendMailTask.getMail().deleteComposeCache();
          localArrayList.add(Integer.valueOf(localQMSendMailTask.getId()));
        }
        i += 1;
      }
    }
    if (localArrayList.size() > 0) {
      ((QMTaskManager)localObject3).deleteAllTask(localArrayList);
    }
    QMContactManager.sharedInstance().deleteCheckedAccountId(paramInt);
    if (localAccount.isActiveSyncMail())
    {
      localObject4 = QMFolderManager.sharedInstance().getFoldersByAccountId(paramInt);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((List)localObject4).size())
      {
        if (!((QMFolder)((List)localObject4).get(i)).isVirtual()) {
          ((List)localObject3).add(Integer.valueOf(((QMFolder)((List)localObject4).get(i)).getId()));
        }
        i += 1;
      }
      localObject4 = new int[((List)localObject3).size()];
      i = 0;
      while (i < localObject4.length)
      {
        localObject4[i] = ((Integer)((List)localObject3).get(i)).intValue();
        i += 1;
      }
      QMMailManager.sharedInstance().removeFolderSyncKey((int[])localObject4);
      QMMailManager.sharedInstance().removeFolderListSyncKey(localAccount.getId());
    }
    localObject3 = NoteManager.sharedInstance();
    localObject4 = ((AccountList)localObject1).getDefaultNoteAccount();
    boolean bool;
    if ((localObject4 != null) && (((QQMailAccount)localObject4).getId() == paramInt))
    {
      bool = ((NoteManager)localObject3).deleteDatabase();
      QMLog.log(4, TAG, "delete note " + bool);
      QMSettingManager.sharedInstance().deleteNoteDefaultCat(paramInt);
    }
    localObject3 = FtnManager.sharedInstance();
    localObject4 = ((AccountList)localObject1).getDefaultFtnAccount();
    if ((localObject4 != null) && (localObject3 != null))
    {
      if (((QQMailAccount)localObject4).getId() == paramInt)
      {
        bool = ((FtnManager)localObject3).deleteDatabase();
        QMSettingManager.sharedInstance().clearDefaultFtnAccountID();
        QMLog.log(4, TAG, "delete ftn " + bool);
      }
      ((FtnManager)localObject3).setFtnExpUnreadShow(((QQMailAccount)localObject4).getId(), true);
    }
    if (QMMailManager.sharedInstance().deleteAccountData(paramInt))
    {
      QMLog.log(4, TAG, "ClearUserLoginData:" + localAccount.getEmail());
      if (paramBoolean) {
        QMPrivateProtocolManager.sharedInstance().delAccount(paramInt, (String)localObject2);
      }
      deleteAccountById(paramInt);
      if (((AccountList)localObject1).size() == 0)
      {
        ShortcutUtility.deleteApplicationShortcut(QMApplicationContext.sharedInstance().getString(2131690401));
        ShortcutUtility.deleteApplicationShortcut(QMApplicationContext.sharedInstance().getString(2131690417));
        SharedPreferenceUtil.removeGesturePwd();
        QMMailManager.sharedInstance().deleteRestData(paramInt);
        break label717;
      }
    }
    else
    {
      label621:
      QMCalendarManager.getInstance().logout(localAccount);
      QMMailManager.sharedInstance().logout(localAccount.getProfile(), new AccountManager.4(this, localAccount));
      QMCardManager.shareInstance().syncBirthFriendList();
      QMPrivateProtocolManager.sharedInstance().updateConfig(true, 4, null);
      if (((AccountList)localObject1).size() != 0) {
        break label753;
      }
      QMSharedPreferenceManager.getInstance().setHasForeignAccount(false);
      FolderDataManager.sharedInstance().setHasSyncQQdomainFolder(false);
      FolderDataManager.sharedInstance().setHasSyncNonQQdomainFolder(false);
    }
    for (;;)
    {
      BadgeUtil.getInstance().setBadgeAccordingQMAccount();
      QMSyncAdapterManager.checkAccount();
      getAccountList(true);
      return;
      localObject2 = ((AccountList)localObject1).iterator();
      label717:
      if (!((Iterator)localObject2).hasNext()) {
        break label621;
      }
      if (!((Account)((Iterator)localObject2).next()).isQQMail()) {
        break;
      }
      QMMailManager.sharedInstance().syncAdRules(true);
      break label621;
      label753:
      localObject1 = ((AccountList)localObject1).iterator();
      i = 0;
      paramInt = 0;
      if (((Iterator)localObject1).hasNext())
      {
        if (!((Account)((Iterator)localObject1).next()).isQQMail())
        {
          QMSharedPreferenceManager.getInstance().setHasForeignAccount(true);
          paramInt = i;
          i = 1;
        }
        for (;;)
        {
          int j = i;
          i = paramInt;
          paramInt = j;
          break;
          j = 1;
          i = paramInt;
          paramInt = j;
        }
      }
      if (paramInt == 0)
      {
        QMSharedPreferenceManager.getInstance().setHasForeignAccount(false);
        FolderDataManager.sharedInstance().setHasSyncNonQQdomainFolder(false);
      }
      if (i == 0) {
        FolderDataManager.sharedInstance().setHasSyncQQdomainFolder(false);
      }
    }
  }
  
  @NonNull
  public AccountList getAccountList()
  {
    return getAccountList(false);
  }
  
  @NonNull
  public AccountList getAccountList(boolean paramBoolean)
  {
    Object localObject1;
    if ((paramBoolean) || (this.accountList == null) || (this.accountChanged))
    {
      localObject1 = this.accountListLock;
      if (paramBoolean) {}
    }
    try
    {
      if ((this.accountList == null) || (this.accountChanged))
      {
        ArrayList localArrayList = new ArrayList();
        this.sqliteHelper.getAccounts(this.sqliteHelper.getReadableDatabase(), new AccountManager.3(this, localArrayList));
        this.accountList = new AccountList(localArrayList);
      }
      this.accountChanged = false;
      return this.accountList;
    }
    finally {}
  }
  
  public void reloadAccounts()
  {
    getAccountList(true);
  }
  
  public boolean saveAccount(Account paramAccount)
  {
    return saveAccount(paramAccount, 0L);
  }
  
  public boolean saveAccount(Account paramAccount, long paramLong)
  {
    Account localAccount = getAccountList().getAccountByEmail(paramAccount.getEmail());
    if (localAccount != null) {
      deleteAccount(localAccount.getId(), true);
    }
    int i = paramAccount.getId();
    localAccount = getAccountList().getAccountById(i);
    long l1 = paramLong;
    if (localAccount != null)
    {
      long l2 = paramLong;
      if (paramLong == 0L) {
        l2 = localAccount.getSequence();
      }
      l1 = l2;
      if (paramAccount.isQQMail())
      {
        QQMailAccount localQQMailAccount = (QQMailAccount)paramAccount;
        l1 = l2;
        if (localQQMailAccount.getLoginUser() == null)
        {
          localQQMailAccount.setLoginUser(((QQMailAccount)localAccount).getLoginUser());
          l1 = l2;
        }
      }
    }
    if (l1 == 0L) {}
    for (paramLong = new Date().getTime();; paramLong = l1)
    {
      paramAccount.setSequence(paramLong);
      this.sqliteHelper.saveAccount(this.sqliteHelper.getWritableDatabase(), paramAccount, l1);
      QMContactManager.sharedInstance().addCheckedAccountId(i);
      QMServiceManager.startPushService(QMPushService.PushStartUpReason.OTHER);
      getAccountList(true);
      return true;
    }
  }
  
  public void saveAccountState(int paramInt1, int paramInt2)
  {
    if (getAccountList().getAccountById(paramInt1) == null)
    {
      QMLog.log(5, TAG, "acc not exist:" + paramInt1);
      return;
    }
    if (this.sqliteHelper.saveAccountState(this.sqliteHelper.getWritableDatabase(), paramInt1, paramInt2)) {
      QMLog.log(4, TAG, "markAccountState : " + paramInt1 + ", state:" + paramInt2 + ", acc  pwd hash:" + getAccountList().getHashAccountPwd(paramInt1));
    }
    getAccountList(true);
  }
  
  public void setAccountEncryptFolderPwd(int paramInt, String paramString)
  {
    Account localAccount = getAccountList().getAccountById(paramInt);
    if (localAccount != null) {
      localAccount.setEncryptedFolderPwd(paramString);
    }
    this.sqliteHelper.setAccountEncryptFolderPwd(this.sqliteHelper.getWritableDatabase(), paramInt, paramString);
  }
  
  public void setAccountLockState(int paramInt1, int paramInt2)
  {
    Account localAccount = getAccountList().getAccountById(paramInt1);
    if (localAccount != null) {
      localAccount.parseLockState(paramInt2);
    }
    this.sqliteHelper.setAccountLockState(this.sqliteHelper.getWritableDatabase(), paramInt1, paramInt2);
  }
  
  public void setDefaultMailAccount(int paramInt)
  {
    QMSettingManager.sharedInstance().setDefaultMailAccountID(paramInt);
  }
  
  public void triggerAccountStateChange(int paramInt1, int paramInt2, String paramString)
  {
    ((AccountStateWatcher)Watchers.of(AccountStateWatcher.class)).onStateChange(paramInt1, paramInt2, paramString);
    notifyAccountStateChange(paramInt1, paramInt2);
  }
  
  public void updateAccessTokenInfo(Account paramAccount)
  {
    this.sqliteHelper.updateAccessTokenInfo(this.sqliteHelper.getWritableDatabase(), paramAccount);
    paramAccount.resetProfile();
  }
  
  public void updateAccountAttr(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.sqliteHelper.updateAccountAttr(this.sqliteHelper.getWritableDatabase(), paramInt1, paramInt2, paramBoolean);
  }
  
  public void updateFolderListSyncKey(int paramInt, String paramString)
  {
    this.sqliteHelper.updateFolderListSyncKey(this.sqliteHelper.getWritableDatabase(), paramInt, paramString);
  }
  
  public boolean updateOrder(@NonNull List<Account> paramList)
  {
    AccountList localAccountList = getAccountList();
    if ((paramList.size() == 0) || (paramList.size() != localAccountList.size())) {
      return false;
    }
    int k = paramList.size();
    int[] arrayOfInt = new int[k];
    HashSet localHashSet = new HashSet();
    int j = 0;
    int i = 0;
    int m;
    if (j < k)
    {
      m = ((Account)paramList.get(j)).getId();
      if (m == localAccountList.get(j).getId()) {
        break label257;
      }
      i = 1;
    }
    label257:
    for (;;)
    {
      arrayOfInt[j] = m;
      if (localHashSet.contains(Integer.valueOf(m)))
      {
        QMLog.log(6, TAG, "updateOrder error repeated account:" + Arrays.toString(arrayOfInt));
        return false;
      }
      localHashSet.add(Integer.valueOf(m));
      j += 1;
      break;
      if (i == 0) {
        return false;
      }
      paramList = this.sqliteHelper.getWritableDatabase();
      try
      {
        paramList.beginTransactionNonExclusive();
        this.sqliteHelper.updateOrder(paramList, arrayOfInt);
        paramList.setTransactionSuccessful();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.log(6, TAG, "updateOrder : " + localException);
          paramList.endTransaction();
        }
      }
      finally
      {
        paramList.endTransaction();
      }
      getAccountList(true);
      return true;
    }
  }
  
  public void updateProfile(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.sqliteHelper.updateProfile(this.sqliteHelper.getWritableDatabase(), paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  class NotifyAbnormalAccountTask
    implements Runnable
  {
    private final SparseBooleanArray mAbnormalAccountArray = new SparseBooleanArray();
    
    private NotifyAbnormalAccountTask() {}
    
    void offer(int paramInt)
    {
      try
      {
        this.mAbnormalAccountArray.put(paramInt, Boolean.TRUE.booleanValue());
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void run() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.AccountManager
 * JD-Core Version:    0.7.0.1
 */