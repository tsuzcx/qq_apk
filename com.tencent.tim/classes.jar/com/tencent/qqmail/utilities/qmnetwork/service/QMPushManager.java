package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.aba.PushWebAttach;
import com.tencent.qqmail.activity.media.MediaFolderSelectActivity;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.calendar.data.CreditCardBill;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.NotifyUtil;
import com.tencent.qqmail.utilities.QMBatteryUtils;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.keepalive.KeepAliveManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.report.QMPushReportManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Arrays;
import java.util.List;
import moai.oss.KvHelper;

public class QMPushManager
{
  private static final long FNV_32_INIT = 2166136261L;
  private static final int FNV_32_PRIME = 16777619;
  private static final String KEY_LOGINED = "logined";
  private static final String KEY_TOKEN = "token";
  private static final String KEY_TYPE = "type";
  public static final List<String> OWN_SOUND_LIST = Arrays.asList(new String[] { "BlowBubble", "Bubble", "Chirp", "Clank", "ElectronBeam", "Flute", "Frog", "Knock", "OpenBottle", "Piano", "Spring" });
  private static final String SP_NAME = "Push_info";
  private static final String TAG = "QMPushManager";
  public static final int TYPE_NOTIFICATION_ARRIVED = 0;
  public static final int TYPE_NOTIFICATION_CLICKED = 1;
  public static final int TYPE_PASS_THROUGH = 2;
  private static QMPushManagerImpl sImpl;
  private static boolean sIsMainProcess = QMApplicationContext.sharedInstance().isMainProcess();
  
  public static void clearAllNotification() {}
  
  public static void clearMailNotification(String paramString) {}
  
  private static void clearNotification(int paramInt, long paramLong) {}
  
  private static int getNotifyId(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    long l = 2166136261L;
    int j = paramString.length();
    while (i < j)
    {
      l = l * 16777619L ^ paramString.charAt(i);
      i += 1;
    }
    return (int)(0x7FFFFFFF & l);
  }
  
  @Nullable
  public static String getToken()
  {
    if (!sIsMainProcess) {}
    for (boolean bool = true;; bool = false) {
      return SPManager.getSp("Push_info", bool).getString("token", null);
    }
  }
  
  @Nullable
  public static String getTokenAndType()
  {
    String str = getToken();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    int i = getType();
    return str + ":" + i;
  }
  
  public static int getType()
  {
    if (!sIsMainProcess) {}
    for (boolean bool = true;; bool = false) {
      return SPManager.getSp("Push_info", bool).getInt("type", 0);
    }
  }
  
  private static void handleBottle(String paramString, JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    BottleManager localBottleManager = BottleManager.getInstance();
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultBottleAccount();
    Object localObject = new StringBuilder().append("handleBottle, bm: ");
    boolean bool;
    if (localBottleManager != null)
    {
      bool = true;
      StringBuilder localStringBuilder = ((StringBuilder)localObject).append(bool).append(", account: ");
      if (localQQMailAccount == null) {
        break label117;
      }
      localObject = localQQMailAccount.getEmail();
      label64:
      QMLog.log(4, "QMPushManager", (String)localObject + ", type: " + paramInt2 + ", foreground: " + AppStatusUtil.isAppOnForeground());
      if ((localBottleManager != null) && (localQQMailAccount != null)) {
        break label123;
      }
    }
    label117:
    label123:
    int i;
    do
    {
      return;
      bool = false;
      break;
      localObject = null;
      break label64;
      i = JSONReader.getInt(paramJSONObject, "a", 0);
      if (paramInt2 != 0) {
        break label185;
      }
    } while ((!AppStatusUtil.isAppOnForeground()) || (i != localQQMailAccount.getId()));
    clearNotification(paramInt1, 2000L);
    QMServiceManager.sharedInstance().mobileSync(i);
    paramJSONObject.put("notified", Integer.valueOf(1));
    QMNotification.postNotification("receivePushBottle", paramJSONObject);
    return;
    label185:
    if (paramInt2 == 1)
    {
      paramString = paramJSONObject.getString("pickkey");
      if (paramString != null) {}
      for (paramString = LaunchWebPush.createBottleNewPush(i, paramString);; paramString = LaunchWebPush.createBottleResponse(i, paramString))
      {
        paramString.addFlags(268435456);
        startActivity(paramString);
        return;
        paramString = paramJSONObject.getString("mailid");
        if (paramString == null) {
          break;
        }
      }
    }
    QMServiceManager.sharedInstance().handleReceivePush(156, paramString);
  }
  
  private static void handleCreditCardBillReminder(String paramString, JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    paramString = (JSONObject)JSONObject.parse(paramString);
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramString = CreditCardBill.parse((JSONObject)JSONObject.parse(paramString.getString("json").replace("\\x22", "\"")));
          QMLog.log(4, "QMPushManager", "creditCardBill " + paramString);
        } while (paramString == null);
        if (paramInt2 != 0) {
          break;
        }
      } while (!AppStatusUtil.isAppOnForeground());
      Threads.runOnMainThread(new QMPushManager.2(paramString));
      return;
    } while (paramInt2 != 1);
    paramString = CalendarFragmentActivity.createIntentForCreditCardBill(paramString);
    paramString.addFlags(268435456).addFlags(536870912).addFlags(2);
    startActivity(paramString);
  }
  
  private static void handleFtn(String paramString, JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    int i = JSONReader.getInt(paramJSONObject, "a", 0);
    int j = JSONReader.getInt(paramJSONObject, "n", 0);
    if (paramInt2 == 0)
    {
      if (AppStatusUtil.isAppOnForeground()) {
        clearNotification(paramInt1, 1000L);
      }
      do
      {
        do
        {
          return;
          paramString = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
        } while ((paramString == null) || (paramString.getId() != i));
        paramString = FtnManager.sharedInstance();
      } while (paramString == null);
      paramString.getList();
      return;
    }
    if (paramInt2 == 1)
    {
      startActivity(LaunchWebPush.createFtnIntent(i, "from_send_file", j).addFlags(268435456));
      return;
    }
    QMServiceManager.sharedInstance().handleReceivePush(150, paramString);
  }
  
  private static void handleImage(String paramString, int paramInt1, int paramInt2)
  {
    PushWebAttach localPushWebAttach = new PushWebAttach();
    localPushWebAttach.fromJson(paramString);
    if (paramInt2 == 0)
    {
      QMServiceManager.sharedInstance().startPushImage(localPushWebAttach);
      if (AppStatusUtil.isAppOnForeground()) {
        clearNotification(paramInt1, 1000L);
      }
      return;
    }
    if (paramInt2 == 1)
    {
      paramString = new Bundle();
      paramString.putBoolean("fromPush", true);
      paramString.putBoolean("fromBgPush", true);
      paramString.putParcelable("body", localPushWebAttach);
      startActivity(MediaFolderSelectActivity.createIntent(QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH, QMApplicationContext.sharedInstance().getString(2131695697)).addFlags(268435456).addFlags(536870912).addFlags(2).putExtras(paramString).setAction(String.valueOf(System.currentTimeMillis())));
      return;
    }
    QMServiceManager.sharedInstance().handleReceivePush(152, paramString);
  }
  
  private static void handleMail(String paramString, int paramInt1, int paramInt2)
  {
    PushMailBody localPushMailBody = new PushMailBody();
    localPushMailBody.fromJson(paramString);
    long l = localPushMailBody.recvTime - localPushMailBody.fromtime;
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(localPushMailBody.accountId);
    StringBuilder localStringBuilder = new StringBuilder().append("handleMail, account: ");
    if (localAccount != null)
    {
      paramString = localAccount.getEmail();
      QMLog.log(4, "QMPushManager", paramString + ",  mailBody: " + localPushMailBody + ", delay: " + l + "s, notifyId: " + paramInt1 + ", type: " + paramInt2 + ", foreground: " + AppStatusUtil.isAppOnForeground());
      if (localAccount != null) {
        break label152;
      }
      clearNotification(paramInt1, 0L);
    }
    label152:
    do
    {
      return;
      paramString = null;
      break;
      if (paramInt2 == 0)
      {
        paramString = localAccount.getEmail();
        if ((localPushMailBody.fromPush) && (!localAccount.isQQMail()))
        {
          QMLog.log(4, "QMPushManager", "handleMail, local sync: " + paramString);
          QMServiceManager.sharedInstance().localSync(paramString);
          return;
        }
        localPushMailBody.notified = true;
        if (QMServiceManager.sharedInstance().filterLocked(localPushMailBody)) {
          if (AppStatusUtil.isAppOnForeground())
          {
            clearNotification(paramInt1, 3000L);
            QMServiceManager.sharedInstance().mobileSync(localPushMailBody.accountId);
            QMSyncAdapterManager.activeSyncAccountInterval(localAccount);
            QMPushReportManager.receiveMail(localPushMailBody.uin, localPushMailBody.remoteId, "", l);
            KvHelper.notifyMail(new double[0]);
            KvHelper.mailDelay(new double[] { l });
            KeepAliveManager.markPushDelay(localAccount.isQQMail(), l);
          }
        }
        for (;;)
        {
          NotifyUtil.saveLatestMailId(localPushMailBody.accountId, localPushMailBody.nMailId);
          return;
          QMPushMailNotify.getInstance().notifyNewMail(localPushMailBody);
          if ((!QMNetworkUtils.isWifiConnected()) || (!QMBatteryUtils.isCharging()) || (!(AccountManager.shareInstance().getAccountList().getAccountById(localPushMailBody.accountId) instanceof QQMailAccount))) {
            break;
          }
          QMServiceManager.sharedInstance().preloadMail(localPushMailBody.accountId, localPushMailBody.remoteId);
          if (TextUtils.isEmpty(localPushMailBody.parentid)) {
            break;
          }
          QMServiceManager.sharedInstance().preloadMail(localPushMailBody.accountId, localPushMailBody.parentid);
          break;
          clearNotification(paramInt1, 0L);
        }
      }
      if (paramInt2 != 1) {
        break label449;
      }
    } while (NotifyUtil.isNotifiedMailId(localPushMailBody.accountId, localPushMailBody.nMailId));
    NotifyUtil.saveLatestMailId(localPushMailBody.accountId, localPushMailBody.nMailId);
    QMSyncAdapterManager.activeSyncAccountInterval(localAccount);
    return;
    label449:
    QMServiceManager.sharedInstance().handleReceivePushMail(localPushMailBody);
  }
  
  public static void handleMessage(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 = JSONReader.getInt((JSONObject)JSONReader.parse(paramString), "cid", 0);
    QMLog.log(4, "QMPushManager", "type = " + paramInt2 + " cmdid = " + paramInt1 + " msg = " + paramString);
    if (paramInt1 > 10000)
    {
      if (AppStatusUtil.isAppOnBackGround()) {
        QMPushMailNotify.getInstance().vibrate();
      }
      KvHelper.hwpushNotificationArrived(new double[0]);
    }
  }
  
  private static void handleNote(String paramString, JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    int i = JSONReader.getInt(paramJSONObject, "a", 0);
    paramJSONObject = paramJSONObject.getString("n");
    if (paramInt2 == 0)
    {
      if (AppStatusUtil.isAppOnForeground()) {
        clearNotification(paramInt1, 1000L);
      }
      do
      {
        do
        {
          return;
          paramString = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
        } while ((paramString == null) || (paramString.getId() != i));
        paramString = NoteManager.sharedInstance();
      } while (paramString == null);
      paramString.loadNoteList();
      return;
    }
    if (paramInt2 == 1)
    {
      startActivity(LaunchWebPush.createNoteIntent(i, paramJSONObject, "from_send_text", QMApplicationContext.sharedInstance().getString(2131690287)).addFlags(268435456));
      return;
    }
    QMServiceManager.sharedInstance().handleReceivePush(151, paramString);
  }
  
  public static void handleRegisterResult(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    int i;
    do
    {
      return;
      str = SPManager.getSp("Push_info").getString("token", null);
      i = SPManager.getSp("Push_info").getInt("logined", 0);
      QMLog.log(4, "QMPushManager", "logined: " + i + ", token: " + paramString + ", oldToken: " + str + ", vid: " + QMApplicationContext.sharedInstance().getVid());
    } while ((i >= 3) && (paramString.equals(str)));
    SPManager.getEditor("Push_info").putString("token", paramString).apply();
    Threads.runInBackground(new QMPushManager.1(i), 5000L);
  }
  
  private static void handleScanFile(String paramString, int paramInt1, int paramInt2) {}
  
  public static boolean isHwPushWorking()
  {
    return false;
  }
  
  public static boolean isMiPushWorking()
  {
    return false;
  }
  
  public static boolean isThirdPartyPushWorking()
  {
    return (sImpl != null) && (getToken() != null) && (SPManager.getSp("Push_info").getInt("logined", 0) >= 1);
  }
  
  public static void register()
  {
    if ((sIsMainProcess) && (QMServiceManager.isPushEnable()) && (sImpl != null) && (sImpl.enable())) {
      sImpl.register();
    }
  }
  
  private static void startActivity(Intent paramIntent)
  {
    try
    {
      QMApplicationContext.sharedInstance().startActivity(paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      QMLog.log(5, "QMPushManager", "start activity from mipush notification failed", paramIntent);
    }
  }
  
  public static void unregister(boolean paramBoolean)
  {
    if ((sIsMainProcess) && (sImpl != null))
    {
      sImpl.unregister();
      if (paramBoolean)
      {
        SPManager.getEditor("Push_info").clear().apply();
        QMServiceManager.setEnableUMAPush(true);
      }
    }
  }
  
  public static abstract interface QMPushManagerImpl
  {
    public abstract boolean enable();
    
    public abstract void register();
    
    public abstract void unregister();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager
 * JD-Core Version:    0.7.0.1
 */