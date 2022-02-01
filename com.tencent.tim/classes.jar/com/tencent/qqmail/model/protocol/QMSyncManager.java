package com.tencent.qqmail.model.protocol;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.protocol.UMA.EmailAccountState;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QMSyncManager
{
  private static final String CONFIG_SYNC_MAIL_COUNT = "config_sync_mail_count";
  private static final String CONFIG_SYNC_METHOD = "config_sync_method_v2";
  public static final int POLLING_INTERVAL_HIGH = 1800;
  public static final int POLLING_INTERVAL_LOW = 7200;
  public static final int POLLING_INTERVAL_MIDDLE = 3600;
  public static final int SYNC_HIT_TIME = 86400000;
  public static final int SYNC_MAIL_COUNT_HIGH = 500;
  public static final int SYNC_MAIL_COUNT_LOW = 100;
  public static final int SYNC_MAIL_COUNT_MIDDLE = 200;
  public static final int SYNC_MAIL_DAY_ALL = 20000;
  public static final int SYNC_MAIL_DAY_MONTH = 10003;
  public static final int SYNC_MAIL_DAY_ONE = 10000;
  public static final int SYNC_MAIL_DAY_THREE = 10001;
  public static final int SYNC_MAIL_DAY_WEEK = 10002;
  public static final int SYNC_METHOD_LOCAL = 2;
  public static final int SYNC_METHOD_PULL = 3;
  public static final int SYNC_METHOD_PUSH = 1;
  public static final String TAG = "QMSyncManager";
  private static QMSyncManager instance = new QMSyncManager();
  
  private int getPollingIntervalByAccState(int paramInt)
  {
    EmailAccountState[] arrayOfEmailAccountState = QMPrivateProtocolManager.sharedInstance().getEmailAccountStateList();
    int j = arrayOfEmailAccountState.length;
    int i = 0;
    while (i < j)
    {
      EmailAccountState localEmailAccountState = arrayOfEmailAccountState[i];
      if (localEmailAccountState.account_id == paramInt) {
        return localEmailAccountState.polling_interval;
      }
      i += 1;
    }
    return 1800;
  }
  
  private boolean isAccountAccessible(int paramInt)
  {
    boolean bool2 = false;
    EmailAccountState[] arrayOfEmailAccountState = QMPrivateProtocolManager.sharedInstance().getEmailAccountStateList();
    int j = arrayOfEmailAccountState.length;
    int i = 0;
    boolean bool1 = bool2;
    if (i < j)
    {
      EmailAccountState localEmailAccountState = arrayOfEmailAccountState[i];
      if (localEmailAccountState == null) {}
      while (localEmailAccountState.account_id != paramInt)
      {
        i += 1;
        break;
      }
      bool1 = bool2;
      if (localEmailAccountState.state_code == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static QMSyncManager sharedInstance()
  {
    return instance;
  }
  
  public void deleteAccount(int paramInt)
  {
    String str = SPManager.getSp("user_info").getString("config_sync_mail_count", null);
    if (!TextUtils.isEmpty(str))
    {
      str = Pattern.compile(paramInt + ":.*?;").matcher(str).replaceFirst("");
      SPManager.getEditor("user_info").putString("config_sync_mail_count", str).apply();
    }
    str = SPManager.getSp("user_info").getString("config_sync_method_v2", "");
    if (!TextUtils.isEmpty(str))
    {
      str = Pattern.compile(paramInt + ":.*?:.*?;").matcher(str).replaceFirst("");
      SPManager.getEditor("user_info").putString("config_sync_method_v2", str).apply();
    }
  }
  
  public void deleteAccountOverdueMail(int paramInt, boolean paramBoolean)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localObject == null) {
      return;
    }
    if (((Account)localObject).isActiveSyncMail())
    {
      i = getSyncMailDay(paramInt);
      localObject = Calendar.getInstance();
      long l;
      switch (i)
      {
      default: 
        l = 0L;
      }
      while (l != 0L)
      {
        QMMailManager.sharedInstance().deleteActiveSyncOverdueMailsByAccount(paramInt, l);
        return;
        l = 0L;
        continue;
        ((Calendar)localObject).add(5, -1);
        l = ((Calendar)localObject).getTimeInMillis();
        continue;
        ((Calendar)localObject).add(5, -3);
        l = ((Calendar)localObject).getTimeInMillis();
        continue;
        ((Calendar)localObject).add(5, -7);
        l = ((Calendar)localObject).getTimeInMillis();
        continue;
        ((Calendar)localObject).add(2, -1);
        l = ((Calendar)localObject).getTimeInMillis();
      }
    }
    int i = getSyncMailCount(paramInt);
    QMMailManager.sharedInstance().deleteAccountOverdueMails(paramInt, i, paramBoolean);
  }
  
  public void deleteFolderOverdueMail(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    if (localObject == null) {
      return;
    }
    if (((Account)localObject).isActiveSyncMail())
    {
      i = getSyncMailDay(paramInt1);
      localObject = Calendar.getInstance();
      long l;
      switch (i)
      {
      default: 
        l = 0L;
      }
      while (l != 0L)
      {
        QMMailManager.sharedInstance().deleteActiveSyncOverdueMailsByFolder(paramInt1, paramInt2, l);
        return;
        l = 0L;
        continue;
        ((Calendar)localObject).add(5, -1);
        l = ((Calendar)localObject).getTimeInMillis();
        continue;
        ((Calendar)localObject).add(5, -3);
        l = ((Calendar)localObject).getTimeInMillis();
        continue;
        ((Calendar)localObject).add(5, -7);
        l = ((Calendar)localObject).getTimeInMillis();
        continue;
        ((Calendar)localObject).add(2, -1);
        l = ((Calendar)localObject).getTimeInMillis();
      }
    }
    int i = getSyncMailCount(paramInt1);
    QMMailManager.sharedInstance().deleteFolderOverdueMails(paramInt1, paramInt2, i, paramBoolean);
  }
  
  public int getActiveSyncAccFilterType(int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localAccount != null) && (localAccount.isActiveSyncMail())) {}
    switch (getSyncMailDay(paramInt))
    {
    case 10002: 
    default: 
      return 3;
    case 10000: 
      return 1;
    case 10001: 
      return 2;
    case 10003: 
      return 5;
    }
    return 0;
  }
  
  public int getPollingInterval(int paramInt)
  {
    int k = 0;
    int i = 0;
    Object localObject1 = SPManager.getSp("user_info").getString("config_sync_method_v2", "");
    Object localObject2 = localObject1;
    String str;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      String[] arrayOfString1 = ((String)localObject1).split(";");
      int m = arrayOfString1.length;
      int j = 0;
      for (;;)
      {
        k = i;
        localObject2 = localObject1;
        if (j >= m) {
          break;
        }
        String[] arrayOfString2 = arrayOfString1[j].split(":");
        k = i;
        localObject2 = localObject1;
        if (arrayOfString2.length == 3)
        {
          k = i;
          localObject2 = localObject1;
          try
          {
            if (Integer.parseInt(arrayOfString2[0]) == paramInt)
            {
              i = Integer.parseInt(arrayOfString2[1]);
              return i;
            }
          }
          catch (Exception localException)
          {
            QMLog.log(5, "QMSyncManager", "getPollingInterval failed", localException);
            str = Pattern.compile(paramInt + ":.*?:.*?;").matcher((CharSequence)localObject1).replaceFirst("");
            k = 1;
          }
        }
        j += 1;
        i = k;
        localObject1 = str;
      }
    }
    if (k != 0) {
      SPManager.getEditor("user_info").putString("config_sync_method_v2", str).apply();
    }
    return getPollingIntervalByAccState(paramInt);
  }
  
  public int getSyncMailCount(int paramInt)
  {
    int k = 0;
    int i = 0;
    Object localObject1 = SPManager.getSp("user_info").getString("config_sync_mail_count", null);
    Object localObject2 = localObject1;
    String str;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      String[] arrayOfString1 = ((String)localObject1).split(";");
      int m = arrayOfString1.length;
      int j = 0;
      for (;;)
      {
        k = i;
        localObject2 = localObject1;
        if (j >= m) {
          break;
        }
        String[] arrayOfString2 = arrayOfString1[j].split(":");
        k = i;
        localObject2 = localObject1;
        if (arrayOfString2.length == 2)
        {
          k = i;
          localObject2 = localObject1;
          try
          {
            if (Integer.parseInt(arrayOfString2[0]) == paramInt)
            {
              i = Integer.parseInt(arrayOfString2[1]);
              return i;
            }
          }
          catch (Exception localException)
          {
            QMLog.log(5, "QMSyncManager", "getSyncMailCount failed", localException);
            str = Pattern.compile(paramInt + ":.*?;").matcher((CharSequence)localObject1).replaceAll("");
            k = 1;
          }
        }
        j += 1;
        i = k;
        localObject1 = str;
      }
    }
    if (k != 0) {
      SPManager.getEditor("user_info").putString("config_sync_mail_count", str).apply();
    }
    return 500;
  }
  
  public int getSyncMailDay(int paramInt)
  {
    int k = 0;
    int i = 0;
    Object localObject1 = SPManager.getSp("user_info").getString("config_sync_mail_count", null);
    Object localObject2 = localObject1;
    String str;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      String[] arrayOfString1 = ((String)localObject1).split(";");
      int m = arrayOfString1.length;
      int j = 0;
      for (;;)
      {
        localObject2 = localObject1;
        k = i;
        if (j >= m) {
          break;
        }
        String[] arrayOfString2 = arrayOfString1[j].split(":");
        localObject2 = localObject1;
        k = i;
        if (arrayOfString2.length == 2)
        {
          localObject2 = localObject1;
          k = i;
          try
          {
            if (Integer.parseInt(arrayOfString2[0]) == paramInt)
            {
              i = Integer.parseInt(arrayOfString2[1]);
              return i;
            }
          }
          catch (Exception localException)
          {
            QMLog.log(5, "QMSyncManager", "getSyncMailDay failed", localException);
            str = Pattern.compile(paramInt + ":.*?;").matcher((CharSequence)localObject1).replaceAll("");
            k = 1;
          }
        }
        j += 1;
        localObject1 = str;
        i = k;
      }
    }
    if (k != 0) {
      SPManager.getEditor("user_info").putString("config_sync_mail_count", str).apply();
    }
    return 10002;
  }
  
  public int getSyncMethod(int paramInt)
  {
    int m = 1;
    int j = 0;
    int i = 0;
    Object localObject1 = SPManager.getSp("user_info").getString("config_sync_method_v2", null);
    Object localObject2 = localObject1;
    int k;
    String[] arrayOfString2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      String[] arrayOfString1 = ((String)localObject1).split(";");
      int n = arrayOfString1.length;
      k = 0;
      localObject2 = localObject1;
      j = i;
      if (k < n)
      {
        arrayOfString2 = arrayOfString1[k].split(":");
        localObject2 = localObject1;
        j = i;
        if (arrayOfString2.length == 3)
        {
          localObject2 = localObject1;
          j = i;
        }
      }
    }
    for (;;)
    {
      String str;
      try
      {
        if (Integer.parseInt(arrayOfString2[0]) == paramInt)
        {
          j = Integer.parseInt(arrayOfString2[2]);
          k = j;
          j = i;
          i = k;
          if ((i >= 1) && (i <= 3)) {
            break label237;
          }
          if (!isAccountAccessible(paramInt)) {
            break label232;
          }
          paramInt = m;
          if (j != 0) {
            SPManager.getEditor("user_info").putString("config_sync_method_v2", (String)localObject1).apply();
          }
          return paramInt;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(5, "QMSyncManager", "getSyncMethod failed", localException);
        str = Pattern.compile(paramInt + ":.*?:.*?;").matcher((CharSequence)localObject1).replaceFirst("");
        j = 1;
      }
      k += 1;
      localObject1 = str;
      i = j;
      break;
      label232:
      paramInt = 2;
      continue;
      label237:
      paramInt = i;
      continue;
      i = -1;
      localObject1 = str;
    }
  }
  
  public ArrayList<Integer> getSyncMethodList(int paramInt)
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    EmailAccountState[] arrayOfEmailAccountState = QMPrivateProtocolManager.sharedInstance().getEmailAccountStateList();
    int m = arrayOfEmailAccountState.length;
    int i = 0;
    int j = k;
    if (i < m)
    {
      EmailAccountState localEmailAccountState = arrayOfEmailAccountState[i];
      if (localEmailAccountState == null) {}
      while (localEmailAccountState.account_id != paramInt)
      {
        i += 1;
        break;
      }
      j = k;
      if (localEmailAccountState.state_code == 2) {
        j = 1;
      }
    }
    switch (j)
    {
    default: 
      return localArrayList;
    case 1: 
      localArrayList.add(Integer.valueOf(1));
    }
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    return localArrayList;
  }
  
  public void setSyncMailCountOrDay(int paramInt1, int paramInt2)
  {
    String str = SPManager.getSp("user_info").getString("config_sync_mail_count", "");
    Matcher localMatcher = Pattern.compile(paramInt1 + ":.*?;").matcher(str);
    if (localMatcher.find()) {}
    for (str = localMatcher.replaceFirst(paramInt1 + ":" + paramInt2 + ";");; str = str + paramInt1 + ":" + paramInt2 + ";")
    {
      SPManager.getEditor("user_info").putString("config_sync_mail_count", str).apply();
      return;
    }
  }
  
  public void setSyncMethod(int paramInt1, int paramInt2)
  {
    setSyncMethod(paramInt1, 1800, paramInt2);
  }
  
  public void setSyncMethod(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    String str1 = SPManager.getSp("user_info").getString("config_sync_method_v2", "");
    int i;
    if (paramInt3 >= 1)
    {
      i = paramInt3;
      if (paramInt3 <= 3) {}
    }
    else
    {
      if (!isAccountAccessible(paramInt1)) {
        break label152;
      }
      paramInt3 = j;
      i = paramInt3;
    }
    String str2 = paramInt1 + ":" + paramInt2 + ":" + i + ";";
    Matcher localMatcher = Pattern.compile(paramInt1 + ":.*?:.*?;").matcher(str1);
    if (localMatcher.find()) {}
    for (str1 = localMatcher.replaceFirst(str2);; str1 = str1 + str2)
    {
      SPManager.getEditor("user_info").putString("config_sync_method_v2", str1).apply();
      return;
      label152:
      paramInt3 = 2;
      break;
    }
  }
  
  int transformMailCountFromServer(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 500;
    case 0: 
      return 100;
    }
    return 200;
  }
  
  public int transformMailCountORMailTimeToServer(int paramInt)
  {
    switch (paramInt)
    {
    case 500: 
    case 10001: 
    default: 
      return 2;
    case 100: 
    case 20000: 
      return 0;
    case 200: 
    case 10000: 
      return 1;
    case 10002: 
      return 3;
    }
    return 4;
  }
  
  int transformMailDayFromServer(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 10002;
    case 0: 
      return 20000;
    case 1: 
      return 10000;
    case 2: 
      return 10001;
    }
    return 10003;
  }
  
  int transformNewMailRateFromServer(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1800;
    case 1: 
      return 3600;
    }
    return 7200;
  }
  
  public int transformNewMailRateToServer(int paramInt)
  {
    switch (paramInt)
    {
    case 1800: 
    default: 
      return 0;
    case 3600: 
      return 1;
    }
    return 2;
  }
  
  int transformSyncMethodFromServer(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public int transformSyncMethodToServer(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMSyncManager
 * JD-Core Version:    0.7.0.1
 */