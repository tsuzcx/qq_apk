package com.tencent.qqmail.utilities.syncadapter;

import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.PeriodicSync;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils.NetworkType;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.report.QMPushReportManager;
import com.tencent.qqmail.utilities.schedule.QMJobService;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;
import com.tencent.qqmail.utilities.services.QMNotifyService;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.timer.QMAlarmManager;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class QMSyncAdapterManager
{
  private static final String ACCOUNT_TYPE = QMApplicationContext.sharedInstance().getString(2131720681);
  private static final String AUTHORITY = QMApplicationContext.sharedInstance().getString(2131720680);
  private static final long DEFAULT_JOBSCHEDULER_PERIOD = 60L;
  private static final long DEFAULT_LOCAL_SYNC_LIMIT = 120L;
  private static final long DEFAULT_NORMAL_LIMIT = 240L;
  private static final long DEFAULT_PERIOD = 60L;
  private static final int DEFAULT_SYNC_TYPE = 3;
  public static final String INTENT_KEY_SELF_INITIATED = "self_initiated";
  private static final String KEY_ADAPTER_SYNC_LIMIT = "_adapter_sync_limit";
  private static final String KEY_JOBSCHEDULER_PERIOD = "jobscheduler_period";
  private static final String KEY_LAST_TIME = "_last_time";
  private static final String KEY_LOCAL_SYNC_LIMIT = "local_sync_limit";
  private static final String KEY_NORMAL_LIMIT = "normal_limit";
  private static final String KEY_PERIOD = "period";
  private static final String KEY_SELF_STOP_AUTO_SYNC = "self_set_auto_sync";
  private static final String KEY_SET_SYNC_AUTO_ONCE = "set_sync_auto_once_v4";
  private static final String KEY_SYNC_TYPE = "sync_type";
  private static final String KEY_USER_REMOVE_ACCOUNT = "user_remove_account_v3";
  public static final String SP_NAME = "qmsyncadapter_info";
  private static final String TAG = "QMSyncAdapterManager";
  private static final String TRIGGER_TYPE_FLEX_JOBSCHEDULER = "flex_jobscheduler";
  private static final String TRIGGER_TYPE_FLEX_SYNCADAPTER = "flex_syncdapter";
  private static final String TRIGGER_TYPE_FLEX_SYNCADAPTER_DEPRECATED = "flex";
  public static final String TRIGGER_TYPE_IDLE = "idle";
  private static final String TRIGGER_TYPE_MANUAL = "manual";
  private static final String TRIGGER_TYPE_OTHER = "other";
  private static final String TRIGGER_TYPE_PERIODIC = "periodic";
  public static final String TRIGGER_TYPE_PUSH_LOCAL_SYNC = "push_local_sync";
  private static Object sConnection = new Object();
  private static Handler sHandler;
  private static long sJobSchedulerPeriod;
  private static long sLocalSyncLimit;
  private static long sNormalLimit;
  private static long sPeriod;
  private static volatile boolean sSelfDeleting;
  private static int sSyncType;
  private static Thread.UncaughtExceptionHandler sUncaughtExceptionHandler = new QMSyncAdapterManager.1();
  private static WorkingObj sWaiter;
  
  static
  {
    initTime();
    initThread();
  }
  
  private static void acquireConnection(WorkingObj paramWorkingObj)
  {
    for (;;)
    {
      try
      {
        if (sConnection != null)
        {
          paramWorkingObj.connection = sConnection;
          sConnection = null;
          return;
        }
        if (sWaiter == null)
        {
          QMLog.log(5, "QMSyncAdapterManager", "no connection available to sync accounts, enqueue as waiter#1: " + paramWorkingObj);
          sWaiter = paramWorkingObj;
          continue;
        }
        str = paramWorkingObj.type;
      }
      finally {}
      String str;
      Object localObject2 = sWaiter;
      if (!str.equals(((WorkingObj)localObject2).type))
      {
        Object localObject1 = sWaiter.next;
        int i = 2;
        for (;;)
        {
          if (localObject1 == null) {
            break label133;
          }
          if (str.equals(((WorkingObj)localObject1).type)) {
            break;
          }
          WorkingObj localWorkingObj = ((WorkingObj)localObject1).next;
          i += 1;
          localObject2 = localObject1;
          localObject1 = localWorkingObj;
        }
        label133:
        QMLog.log(5, "QMSyncAdapterManager", "no connection available to sync accounts, enqueue as waiter#" + i + ": " + paramWorkingObj);
        ((WorkingObj)localObject2).next = paramWorkingObj;
      }
    }
  }
  
  public static void activeSyncAccountInterval(com.tencent.qqmail.account.model.Account paramAccount)
  {
    if ((paramAccount == null) || (paramAccount.isQQMail())) {
      return;
    }
    QMLog.log(4, "QMSyncAdapterManager", "activeSyncAccountInterval, account: " + paramAccount.getEmail());
    paramAccount = paramAccount.getEmail() + "_adapter_sync_limit";
    SPManager.getEditor("qmsyncadapter_info").putLong(paramAccount, 300000L).apply();
    alarmForSyncAccount(300000L);
  }
  
  private static void addDefaultAccount(boolean paramBoolean)
  {
    sHandler.postDelayed(new QMSyncAdapterManager.2(paramBoolean), 3000L);
  }
  
  private static void alarmForSyncAccount(long paramLong)
  {
    QMLog.log(4, "QMSyncAdapterManager", "alarmForSyncAccount, interval: " + paramLong + "ms");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("from", QMScheduledJobs.FromType.ALARM_SYNC_ACCOUNT);
    localBundle.putBoolean("exclude_from_limit_interval", true);
    QMAlarmManager.registerSingleInexactlyAlarm(paramLong, PendingIntent.getService(QMApplicationContext.sharedInstance(), 42723, QMNotifyService.createScheduledJobsIntent(localBundle), 268435456));
  }
  
  public static void checkAccount()
  {
    checkAccount(false);
  }
  
  public static void checkAccount(boolean paramBoolean) {}
  
  private static void checkAccountStatus(android.accounts.Account paramAccount)
  {
    boolean bool1 = ContentResolver.getSyncAutomatically(paramAccount, AUTHORITY);
    int i = ContentResolver.getIsSyncable(paramAccount, AUTHORITY);
    boolean bool2 = ContentResolver.getMasterSyncAutomatically();
    QMLog.log(4, "QMSyncAdapterManager", "checkAccountStatus, account: " + paramAccount.name + ", master: " + bool2 + ", syncAuto: " + bool1 + ", syncable: " + i);
    QMPushReportManager.masterSync(bool2);
    QMPushReportManager.autoSync(bool1);
  }
  
  private static void checkSyncDone(WorkingObj paramWorkingObj)
  {
    int i = paramWorkingObj.syncCount.decrementAndGet();
    QMLog.log(3, "QMSyncAdapterManager", "checkSyncDone, wc: " + i);
    if (i == 0)
    {
      i = paramWorkingObj.mailNum.get();
      if (i == 0) {
        QMPushMailNotify.getInstance().showMailNotification();
      }
      if (paramWorkingObj.sync) {
        QMPushReportManager.syncAdaptper(paramWorkingObj.type, i);
      }
      QMLog.log(4, "QMSyncAdapterManager", "syncAllAccount done, type: " + paramWorkingObj.type + ", sync: " + paramWorkingObj.sync + ", mailNum: " + i);
      releaseConnection(paramWorkingObj);
    }
  }
  
  private static void clearAllSystemAccount()
  {
    try
    {
      android.accounts.Account[] arrayOfAccount = android.accounts.AccountManager.get(QMApplicationContext.sharedInstance()).getAccountsByType(ACCOUNT_TYPE);
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        deleteAccount(arrayOfAccount[i].name);
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private static void deleteAccount(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    sHandler.post(new QMSyncAdapterManager.3(paramString));
  }
  
  public static void ensureJobScheduler()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 21) {
      label323:
      for (;;)
      {
        try
        {
          JobScheduler localJobScheduler = (JobScheduler)QMApplicationContext.sharedInstance().getSystemService("jobscheduler");
          Object localObject = localJobScheduler.getAllPendingJobs();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            StringBuilder localStringBuilder = new StringBuilder("jobList, size: " + ((List)localObject).size());
            localObject = ((List)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              JobInfo localJobInfo = (JobInfo)((Iterator)localObject).next();
              localStringBuilder.append(", [id: ").append(localJobInfo.getId()).append(", interval: ").append(localJobInfo.getIntervalMillis()).append(", backoffPolicy: ").append(localJobInfo.getBackoffPolicy()).append(", backoffMillis: ").append(localJobInfo.getInitialBackoffMillis()).append("]");
              if ((localJobInfo.getId() != 0) || (localJobInfo.getIntervalMillis() != sJobSchedulerPeriod) || (localJobInfo.getBackoffPolicy() != 1) || (localJobInfo.getInitialBackoffMillis() != 3600000L)) {
                break label323;
              }
              i = 1;
              break label323;
            }
            QMLog.log(4, "QMSyncAdapterManager", localStringBuilder.toString());
            if (i != 0) {
              return;
            }
          }
          QMLog.log(4, "QMSyncAdapterManager", "create job to jobscheduler, interval: " + sJobSchedulerPeriod + "ms");
          localJobScheduler.schedule(new JobInfo.Builder(0, new ComponentName(QMApplicationContext.sharedInstance(), QMJobService.class)).setPeriodic(sJobSchedulerPeriod).setRequiredNetworkType(1).setPersisted(true).setBackoffCriteria(3600000L, 1).build());
          return;
        }
        catch (Throwable localThrowable)
        {
          QMLog.log(5, "QMSyncAdapterManager", "ensureJobScheduler error", localThrowable);
          return;
        }
      }
    }
  }
  
  private static String getDefaultNickName()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    com.tencent.qqmail.account.model.Account localAccount = com.tencent.qqmail.account.AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localAccount == null)
    {
      localObject1 = localObject2;
      return localObject1;
    }
    int i = localAccount.getId();
    if (localAccount.isQQMail())
    {
      localObject2 = QMComposeDataManager.sharedInstance().getQMDefaultAlias(i);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = QMComposeDataManager.sharedInstance().getQMDefaultNick(i);
        if (!QMComposeDataManager.sharedInstance().getQMAliasIndep((String)localObject2, i)) {
          break label125;
        }
        localObject2 = QMComposeDataManager.sharedInstance().getQMAliasNick((String)localObject2, i);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label125;
        }
        localObject1 = localObject2;
      }
    }
    label125:
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = localAccount.getName();
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      return localAccount.getEmail();
      localObject1 = QMSettingManager.sharedInstance().getAccountNick(i);
    }
  }
  
  private static Bundle getDeprecatedFlexSyncExtras()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("self_initiated", "flex");
    return localBundle;
  }
  
  private static Bundle getFlexSyncExtras()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("self_initiated", "flex_syncdapter");
    return localBundle;
  }
  
  public static String getInfo()
  {
    return "period: " + String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf((float)sPeriod / 60.0F) }) + "min, normalLimit: " + String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf((float)sNormalLimit / 60.0F / 1000.0F) }) + "min, jobSchedulerPeriod: " + String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf((float)sJobSchedulerPeriod / 60.0F / 1000.0F) }) + "min";
  }
  
  @NonNull
  private static String getInitiatedType(@Nullable Bundle paramBundle)
  {
    String str1;
    if (paramBundle == null)
    {
      str2 = "other";
      str1 = str2;
      if (str2 == null) {
        if (!paramBundle.getBoolean("force", false)) {
          break label68;
        }
      }
    }
    label68:
    for (String str2 = "manual";; str2 = null)
    {
      str1 = str2;
      if (str2 == null)
      {
        paramBundle = paramBundle.get("from");
        if (!(paramBundle instanceof QMScheduledJobs.FromType)) {
          break label73;
        }
        str1 = ((QMScheduledJobs.FromType)paramBundle).name();
      }
      return str1;
      str2 = paramBundle.getString("self_initiated");
      break;
    }
    label73:
    return "other";
  }
  
  public static long getJobSchedulerPeriod()
  {
    return sJobSchedulerPeriod / 60L / 1000L;
  }
  
  public static long getNormalLimit()
  {
    return sNormalLimit / 60L / 1000L;
  }
  
  public static long getPeriod()
  {
    return sPeriod / 60L;
  }
  
  private static Bundle getPeriodicSyncExtras()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("self_initiated", "periodic");
    return localBundle;
  }
  
  public static void handleSchemaPush(String paramString)
  {
    try
    {
      String str1 = new String(StringExtention.decode(paramString));
      QMLog.log(4, "QMSyncAdapterManager", "handleSchemaPush, decode config: " + str1 + ", origin config: " + paramString);
      if (str1 == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      String str2;
      for (;;)
      {
        QMLog.log(5, "QMSyncAdapterManager", "decode config error!", localException);
        str2 = null;
      }
      paramString = (JSONObject)JSONReader.parse(str2);
      if (paramString == null)
      {
        QMLog.log(5, "QMSyncAdapterManager", "json parse error!");
        return;
      }
      SPManager.getEditor("qmsyncadapter_info").putLong("period", JSONReader.getLong(paramString, "p", 60L)).putLong("normal_limit", JSONReader.getLong(paramString, "n", 240L)).putLong("jobscheduler_period", JSONReader.getLong(paramString, "j", 60L)).putInt("sync_type", JSONReader.getInt(paramString, "st", 1)).putLong("local_sync_limit", JSONReader.getLong(paramString, "ls", 120L)).apply();
      initTime();
      updateAccountSyncPeriod();
      ensureJobScheduler();
    }
  }
  
  private static void initThread()
  {
    HandlerThread localHandlerThread = new HandlerThread("sync_adapter_thread");
    localHandlerThread.start();
    sHandler = new Handler(localHandlerThread.getLooper());
    localHandlerThread.setUncaughtExceptionHandler(sUncaughtExceptionHandler);
  }
  
  private static void initTime()
  {
    SharedPreferences localSharedPreferences = SPManager.getSp("qmsyncadapter_info");
    sPeriod = localSharedPreferences.getLong("period", 60L) * 60L;
    sNormalLimit = localSharedPreferences.getLong("normal_limit", 240L) * 60L * 1000L;
    sLocalSyncLimit = localSharedPreferences.getLong("local_sync_limit", 120L) * 60L * 1000L;
    sJobSchedulerPeriod = localSharedPreferences.getLong("jobscheduler_period", 60L) * 60L * 1000L;
    sSyncType = localSharedPreferences.getInt("sync_type", 3);
    if (sPeriod < 1800L)
    {
      l = 3600L;
      sPeriod = l;
      if (sNormalLimit >= 1800000L) {
        break label264;
      }
      l = 14400000L;
      label134:
      sNormalLimit = l;
      if (sJobSchedulerPeriod >= 1800000L) {
        break label271;
      }
      l = 3600000L;
      label152:
      sJobSchedulerPeriod = l;
      if (sLocalSyncLimit >= 1800000L) {
        break label278;
      }
    }
    label264:
    label271:
    label278:
    for (long l = 7200000L;; l = sLocalSyncLimit)
    {
      sLocalSyncLimit = l;
      QMLog.log(4, "QMSyncAdapterManager", "initTime, period: " + sPeriod + "s, normalLimit: " + sNormalLimit + "ms, jobSchedulerPeriod: " + sJobSchedulerPeriod + "ms, syncType: " + sSyncType + ", localSyncLimit: " + sLocalSyncLimit + "ms");
      return;
      l = sPeriod;
      break;
      l = sNormalLimit;
      break label134;
      l = sJobSchedulerPeriod;
      break label152;
    }
  }
  
  public static boolean isMasterSyncAutomatically()
  {
    return ContentResolver.getMasterSyncAutomatically();
  }
  
  static boolean isSelfDeleting()
  {
    return sSelfDeleting;
  }
  
  public static boolean isSyncAutomatically()
  {
    boolean bool2 = false;
    android.accounts.Account[] arrayOfAccount = android.accounts.AccountManager.get(QMApplicationContext.sharedInstance()).getAccountsByType(ACCOUNT_TYPE);
    boolean bool1 = bool2;
    if (arrayOfAccount.length > 0)
    {
      bool1 = bool2;
      if (ContentResolver.getSyncAutomatically(arrayOfAccount[0], AUTHORITY)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void releaseConnection(WorkingObj paramWorkingObj)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        localWorkingObj = sWaiter;
        String str = paramWorkingObj.type;
        if (localWorkingObj == null) {
          break;
        }
        if ((str.equals(localWorkingObj.type)) && (!"manual".equals(localWorkingObj.type)) && (!"push_local_sync".equals(localWorkingObj.type)))
        {
          if (localObject != null)
          {
            localObject.next = localWorkingObj.next;
            localWorkingObj = localWorkingObj.next;
          }
          else
          {
            sWaiter = localWorkingObj.next;
          }
        }
        else {
          localObject = localWorkingObj;
        }
      }
      finally {}
    }
    WorkingObj localWorkingObj = sWaiter;
    if (localWorkingObj == null)
    {
      sConnection = paramWorkingObj.connection;
      return;
    }
    sWaiter = localWorkingObj.next;
    localWorkingObj.next = null;
    localWorkingObj.connection = paramWorkingObj.connection;
    sHandler.post(new QMSyncAdapterManager.4(localWorkingObj));
  }
  
  public static void removeJobScheduler()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ((JobScheduler)QMApplicationContext.sharedInstance().getSystemService("jobscheduler")).cancelAll();
    }
  }
  
  public static void reportSyncAccountState()
  {
    try
    {
      android.accounts.Account[] arrayOfAccount = android.accounts.AccountManager.get(QMApplicationContext.sharedInstance()).getAccountsByType(ACCOUNT_TYPE);
      if (arrayOfAccount.length > 0) {
        checkAccountStatus(arrayOfAccount[0]);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setAutoSync(boolean paramBoolean)
  {
    try
    {
      android.accounts.Account[] arrayOfAccount = android.accounts.AccountManager.get(QMApplicationContext.sharedInstance()).getAccountsByType(ACCOUNT_TYPE);
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        android.accounts.Account localAccount = arrayOfAccount[i];
        if ((ContentResolver.getSyncAutomatically(localAccount, AUTHORITY)) && (!paramBoolean)) {
          SPManager.getEditor("qmsyncadapter_info").putBoolean("self_set_auto_sync", true).commit();
        }
        ContentResolver.setSyncAutomatically(localAccount, AUTHORITY, paramBoolean);
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setJobschedulerPeriod(long paramLong)
  {
    sJobSchedulerPeriod = 60L * paramLong * 1000L;
    SPManager.getEditor("qmsyncadapter_info").putLong("jobscheduler_period", paramLong).apply();
  }
  
  public static void setMasterSync(boolean paramBoolean)
  {
    ContentResolver.setMasterSyncAutomatically(paramBoolean);
  }
  
  public static void setNormalLimit(long paramLong)
  {
    sNormalLimit = 60L * paramLong * 1000L;
    SPManager.getEditor("qmsyncadapter_info").putLong("normal_limit", paramLong).apply();
  }
  
  public static void setPeriod(long paramLong)
  {
    sPeriod = 60L * paramLong;
    SPManager.getEditor("qmsyncadapter_info").putLong("period", paramLong).apply();
    updateAccountSyncPeriod();
  }
  
  static void setUserRemoved(boolean paramBoolean)
  {
    SPManager.getEditor("qmsyncadapter_info").putBoolean("user_remove_account_v3", paramBoolean).apply();
  }
  
  public static void syncAllAccount(Bundle paramBundle)
  {
    paramBundle = new WorkingObj(paramBundle);
    acquireConnection(paramBundle);
    if (paramBundle.connection != null) {
      syncAllAccountInternal(paramBundle);
    }
  }
  
  private static void syncAllAccountInternal(WorkingObj paramWorkingObj)
  {
    String str = paramWorkingObj.type;
    Object localObject2 = paramWorkingObj.extras;
    Object localObject3 = com.tencent.qqmail.account.AccountManager.shareInstance().getAccountList();
    Object localObject1 = android.accounts.AccountManager.get(QMApplicationContext.sharedInstance()).getAccountsByType(ACCOUNT_TYPE);
    if ((localObject1 != null) && (localObject1.length > 0)) {}
    for (localObject1 = localObject1[0];; localObject1 = null)
    {
      Bundle localBundle = getFlexSyncExtras();
      if ((localObject1 != null) && ("flex_syncdapter".equals(str))) {
        ContentResolver.removePeriodicSync((android.accounts.Account)localObject1, AUTHORITY, localBundle);
      }
      if ((localObject1 != null) && ("flex".equals(str))) {
        ContentResolver.removePeriodicSync((android.accounts.Account)localObject1, AUTHORITY, getDeprecatedFlexSyncExtras());
      }
      long l5 = System.currentTimeMillis();
      int k = Calendar.getInstance().get(12);
      int m = Calendar.getInstance().get(11);
      Object localObject4 = QMNetworkUtils.getActiveNetworkType();
      boolean bool3;
      int i;
      label157:
      boolean bool4;
      StringBuilder localStringBuilder;
      long l3;
      label245:
      int n;
      Object localObject5;
      long l6;
      int i1;
      long l1;
      long l2;
      if (!QMServiceManager.isPushEnable())
      {
        bool3 = true;
        if (localObject4 == QMNetworkUtils.NetworkType.DISCONNECTED) {
          break label1162;
        }
        i = 1;
        bool4 = false;
        localStringBuilder = new StringBuilder(1024);
        localStringBuilder.append("syncAllAccount, accountSize: ").append(((AccountList)localObject3).size()).append(", extras: ").append(localObject2).append(", type: ").append(str).append(", exitPush: ").append(bool3).append(", network: ").append(localObject4);
        localObject2 = ((AccountList)localObject3).iterator();
        l3 = 9223372036854775807L;
        if (!((Iterator)localObject2).hasNext()) {
          break label1445;
        }
        localObject4 = (com.tencent.qqmail.account.model.Account)((Iterator)localObject2).next();
        n = ((com.tencent.qqmail.account.model.Account)localObject4).getId();
        localObject3 = ((com.tencent.qqmail.account.model.Account)localObject4).getEmail();
        localObject5 = (String)localObject3 + "_last_time";
        l6 = l5 - SPManager.getSp("qmsyncadapter_info").getLong((String)localObject5, 0L);
        i1 = QMSyncManager.sharedInstance().getSyncMethod(n);
        l1 = QMSyncManager.sharedInstance().getPollingInterval(n) * 1000L;
        if (!((com.tencent.qqmail.account.model.Account)localObject4).isQQMail()) {
          break label1168;
        }
        l2 = sNormalLimit;
        label359:
        if ((i1 != 1) || (!((com.tencent.qqmail.account.model.Account)localObject4).isQQMail())) {
          break label1175;
        }
        l1 = sNormalLimit;
      }
      for (;;)
      {
        label378:
        double d2 = l6;
        double d1;
        label400:
        label416:
        long l4;
        boolean bool1;
        label527:
        boolean bool2;
        if ("periodic".equals(str))
        {
          d1 = l1 * 0.9D;
          if ((d2 < d1) && (l6 >= 0L)) {
            break label1266;
          }
          j = 1;
          l4 = l3;
          if (j == 0)
          {
            l4 = l3;
            if (l1 > l6) {
              l4 = Math.min(l3, l1 - l6);
            }
          }
          if ((!"manual".equals(str)) && (!"push_local_sync".equals(str)) && ((bool3) || (j == 0) || ((!"periodic".equals(str)) && (!"other".equals(str)) && (!"flex_syncdapter".equals(str)) && (!"flex_jobscheduler".equals(str)) && (i == 0)))) {
            break label1272;
          }
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (((com.tencent.qqmail.account.model.Account)localObject4).isQQMail())
            {
              bool2 = bool1;
              if (!"manual".equals(str))
              {
                bool2 = bool1;
                if (!"flex_jobscheduler".equals(str))
                {
                  bool2 = bool1;
                  if (!"flex_syncdapter".equals(str))
                  {
                    bool2 = bool1;
                    if (!"push_local_sync".equals(str)) {
                      if ((m < 5) || (m > 8))
                      {
                        bool2 = bool1;
                        if (m >= 2)
                        {
                          bool2 = bool1;
                          if (m > 3) {}
                        }
                      }
                      else if ((k < 58) && (k > 2))
                      {
                        bool2 = bool1;
                        if (k >= 28)
                        {
                          bool2 = bool1;
                          if (k > 32) {}
                        }
                      }
                      else
                      {
                        bool2 = bool1;
                        if (new Random().nextInt(2) == 1)
                        {
                          l3 = new Random().nextInt(1500);
                          if (Build.VERSION.SDK_INT < 21) {
                            break label1278;
                          }
                          localObject4 = (JobScheduler)QMApplicationContext.sharedInstance().getSystemService("jobscheduler");
                          localObject5 = ((JobScheduler)localObject4).getAllPendingJobs();
                          if ((localObject5 == null) || (((List)localObject5).size() <= 0)) {
                            break label1507;
                          }
                          localObject5 = ((List)localObject5).iterator();
                          while (((Iterator)localObject5).hasNext()) {
                            if (((JobInfo)((Iterator)localObject5).next()).getId() == 1) {
                              QMLog.log(5, "QMSyncAdapterManager", "has been flexed by jobscheduler before");
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label1162:
        label1168:
        label1175:
        label1445:
        label1501:
        label1507:
        for (int j = 1;; j = 0)
        {
          if (j == 0)
          {
            localObject5 = new PersistableBundle();
            ((PersistableBundle)localObject5).putString("self_initiated", "flex_jobscheduler");
            ((JobScheduler)localObject4).schedule(new JobInfo.Builder(1, new ComponentName(QMApplicationContext.sharedInstance(), QMJobService.class)).setMinimumLatency(1000L * l3).setRequiredNetworkType(1).setBackoffCriteria(3600000L, 1).setExtras((PersistableBundle)localObject5).build());
            QMLog.log(5, "QMSyncAdapterManager", "flex schedule by jobscheduler, name: " + (String)localObject3 + ", flex: " + l3 + "s");
          }
          bool2 = false;
          localStringBuilder.append(", [").append((String)localObject3).append(", sync: ").append(bool2).append(", method: ").append(i1).append(", interval: ").append(l6).append("/").append(l1).append("ms]");
          if (bool2)
          {
            paramWorkingObj.syncCount.getAndIncrement();
            if (AppStatusUtil.isAppOnForeground())
            {
              l3 = 10000L;
              label1012:
              sHandler.postDelayed(new SyncTask((String)localObject3, n, paramWorkingObj), l3);
              localObject4 = (String)localObject3 + "_adapter_sync_limit";
              l2 = Math.min(2L * l1, l2);
              QMLog.log(4, "QMSyncAdapterManager", "update next limit, account: " + (String)localObject3 + ", cur: " + l1 + "ms, next: " + l2 + "ms");
              SPManager.getEditor("qmsyncadapter_info").putLong((String)localObject4, l2).apply();
            }
          }
          else
          {
            bool4 |= bool2;
            l3 = l4;
            break label245;
            bool3 = false;
            break;
            i = 0;
            break label157;
            l2 = l1;
            break label359;
            if (i1 == 3)
            {
              l1 = 9223372036854775807L;
              break label378;
            }
            if (sSyncType == 1) {
              break label378;
            }
            if (sSyncType == 2)
            {
              l1 = sLocalSyncLimit;
              break label378;
            }
            if (sSyncType != 3) {
              break label1513;
            }
            localObject5 = (String)localObject3 + "_adapter_sync_limit";
            l1 = SPManager.getSp("qmsyncadapter_info").getLong((String)localObject5, l2);
            break label378;
            d1 = l1;
            break label400;
            label1266:
            j = 0;
            break label416;
            label1272:
            bool1 = false;
            break label527;
            label1278:
            if (localObject1 != null)
            {
              localObject4 = ContentResolver.getPeriodicSyncs((android.accounts.Account)localObject1, AUTHORITY);
              if (((List)localObject4).size() <= 0) {
                break label1501;
              }
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (PeriodicSync)((Iterator)localObject4).next();
                if ((((PeriodicSync)localObject5).extras != null) && ("flex_syncdapter".equals(((PeriodicSync)localObject5).extras.getString("self_initiated")))) {
                  QMLog.log(5, "QMSyncAdapterManager", "has been flexed by syncadapter before");
                }
              }
            }
          }
          for (j = 1;; j = 0)
          {
            if (j == 0)
            {
              ContentResolver.addPeriodicSync((android.accounts.Account)localObject1, AUTHORITY, localBundle, l3);
              QMLog.log(5, "QMSyncAdapterManager", "flex schedule by syncadapter, name: " + (String)localObject3 + ", flex: " + l3 + "s");
            }
            bool2 = false;
            break;
            l3 = 0L;
            break label1012;
            localStringBuilder.append(", hasSync: ").append(bool4);
            QMLog.log(4, "QMSyncAdapterManager", localStringBuilder.toString());
            paramWorkingObj.sync = bool4;
            checkSyncDone(paramWorkingObj);
            if (l3 != 9223372036854775807L) {
              alarmForSyncAccount(Math.max(300000L, l3));
            }
            return;
          }
        }
        label1513:
        l1 = l2;
      }
    }
  }
  
  private static void updateAccountSyncPeriod()
  {
    try
    {
      android.accounts.Account[] arrayOfAccount = android.accounts.AccountManager.get(QMApplicationContext.sharedInstance()).getAccountsByType(ACCOUNT_TYPE);
      Bundle localBundle = getPeriodicSyncExtras();
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        android.accounts.Account localAccount = arrayOfAccount[i];
        ContentResolver.removePeriodicSync(localAccount, AUTHORITY, localBundle);
        ContentResolver.addPeriodicSync(localAccount, AUTHORITY, localBundle, sPeriod);
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void updateSyncTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString + "_last_time";
    SPManager.getEditor("qmsyncadapter_info").putLong(paramString, System.currentTimeMillis()).apply();
  }
  
  static class SyncTask
    implements Runnable
  {
    private int accountId;
    private String name;
    private String type;
    private QMSyncAdapterManager.WorkingObj wo;
    
    SyncTask(String paramString, int paramInt, QMSyncAdapterManager.WorkingObj paramWorkingObj)
    {
      this.name = paramString;
      this.accountId = paramInt;
      this.wo = paramWorkingObj;
      this.type = paramWorkingObj.type;
    }
    
    public void run()
    {
      AtomicBoolean localAtomicBoolean = new AtomicBoolean();
      QMMailManager.sharedInstance().checkMail(this.accountId, true, new QMSyncAdapterManager.SyncTask.1(this, localAtomicBoolean));
    }
  }
  
  static class WorkingObj
  {
    Object connection;
    Bundle extras;
    AtomicInteger mailNum = new AtomicInteger();
    WorkingObj next;
    boolean sync;
    AtomicInteger syncCount = new AtomicInteger(1);
    @NonNull
    String type;
    
    WorkingObj(Bundle paramBundle)
    {
      this.extras = paramBundle;
      this.type = QMSyncAdapterManager.getInitiatedType(paramBundle);
    }
    
    public String toString()
    {
      return "[extras: " + this.extras + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager
 * JD-Core Version:    0.7.0.1
 */