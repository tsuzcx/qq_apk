package com.tencent.qqmail.utilities.qmnetwork.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.LoginUser;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.aba.PushWebAttach;
import com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.calendar.data.CreditCardBill;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.media.QMUploadImageManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.trd.guava.Ints;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.NotifyUtil;
import com.tencent.qqmail.utilities.UninstallWatcherHelper;
import com.tencent.qqmail.utilities.abtest.QMABTestManager;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.services.QMNotifyService;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import moai.oss.KvHelper;

public class QMServiceManager
{
  public static final boolean DEBUG = false;
  public static final boolean DEBUG_IP = true;
  public static final boolean DEBUG_TIME = false;
  private static final File DISABLE_PUSH_FLAG_FILE = new File(QMApplicationContext.sharedInstance().getFilesDir(), "disable_push");
  private static final String KEY_ENABLE_PUSH = "enable_push";
  private static final String KEY_NEED_UMA_LOGIN = "need_uma_login";
  private static final String KEY_PUSH_NEED_RECONNECT = "push_need_reconnect";
  public static final int NOTIFICATION_TYPE_DEVICE_ERROR = 2;
  public static final int NOTIFICATION_TYPE_PASSWORD_ERROR = 1;
  public static final String RECV_PUSH_ADVERTISE = "receivePushAdvertise";
  public static final String RECV_PUSH_ATTACHFOLDER = "receivePushAttachFolder";
  public static final String RECV_PUSH_BOTTLE = "receivePushBottle";
  public static final String RECV_PUSH_FTN = "receivePushFTN";
  public static final String RECV_PUSH_LOGIN = "receivePushLogin";
  public static final String RECV_PUSH_NOTE = "receivePushNote";
  private static final String SHARED_PREF_FILENAME = "webpush_main_info";
  private static final String TAG = "QMServiceManager";
  private static final String TYPE_PUSH_CONFIG_ADVERTISE = "7";
  public static final String WEBPUSH_TAG = "webpush";
  private static QMServiceManager _instance = new QMServiceManager();
  private BackgroundPreloadMailTask mBgPreloadMailTask = new BackgroundPreloadMailTask(null);
  private MobileSyncTask mMobileSyncTask = new MobileSyncTask(null);
  private SyncTask mSyncTask = new SyncTask(null);
  
  public static boolean getPushNeedReconnect()
  {
    return SPManager.getSp("webpush_main_info", true).getBoolean("push_need_reconnect", false);
  }
  
  public static Uri getSoundResId(String paramString, int paramInt)
  {
    boolean bool2 = false;
    QMContactManager localQMContactManager = QMContactManager.sharedInstance();
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (localQMContactManager.isVipAddressForAccount(paramInt, paramString)) {
        bool1 = true;
      }
    }
    return QMSettingManager.sharedInstance().getPushSoundUri(bool1);
  }
  
  public static SharedPreferences.Editor getWebPushEditor()
  {
    return SPManager.getEditor("webpush_main_info");
  }
  
  public static SharedPreferences getWebPushSP()
  {
    return SPManager.getSp("webpush_main_info");
  }
  
  private void handleCalendarPush(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    if (paramString == null)
    {
      QMLog.log(6, "webpush", "handleCalendarPush: json_null");
      return;
    }
    int i = JSONReader.getInt(paramString, "a", 0);
    QMLog.log(4, "webpush", "handleCalendarPush: " + i);
    paramString = AccountManager.shareInstance().getAccountList().getAccountById(i);
    if (paramString != null)
    {
      QMCalendarManager.getInstance().loadEventsByAccount(paramString);
      return;
    }
    QMLog.log(6, "webpush", "handleCalendarPush: account " + i + " is null.");
  }
  
  private void handleReceiveCreditCardBillPush(String paramString)
  {
    Log.i("QMServiceManager", "handleReceiveCreditCardBillPush body " + paramString);
    paramString = (JSONObject)JSONObject.parse(paramString);
    if (paramString == null) {}
    do
    {
      return;
      paramString = CreditCardBill.parse((JSONObject)JSONObject.parse(paramString.getString("json").replace("\\x22", "\"")));
      QMLog.log(4, "QMServiceManager", "creditCardBill " + paramString);
    } while (paramString == null);
    if (AppStatusUtil.isAppOnBackGround())
    {
      QMPushMailNotify.getInstance().notifyCreditCardBillReminder(paramString);
      KvHelper.creditCardBillRemingdPush(new double[0]);
      return;
    }
    Threads.runOnMainThread(new QMServiceManager.2(this, paramString));
  }
  
  private void handleReceivePushAttachFolder(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    if (paramString == null)
    {
      QMLog.log(6, "webpush", "handleReceivePushAttachFolder: json_null");
      return;
    }
    int i = JSONReader.getInt(paramString, "a", 0);
    String str = paramString.getString("q");
    paramString = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    StringBuilder localStringBuilder = new StringBuilder().append("receivePushAttachFolder:").append(i).append(",");
    if (paramString != null) {}
    for (paramString = Integer.valueOf(paramString.getId());; paramString = null)
    {
      QMLog.log(4, "webpush", paramString + "," + 157 + "," + str);
      QMNotification.postNotification("receivePushAttachFolder", QMNotification.createNotification(new Object[] { "push_attachfolder_accountid", Integer.valueOf(i) }));
      return;
    }
  }
  
  private void handleReceivePushConfig(String paramString)
  {
    try
    {
      String str = StringExtention.hexDecode(paramString);
      paramString = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        int j;
        int i;
        QMLog.log(6, "PushMailBody", "PushMailBody. hexDecode err:" + localUnsupportedEncodingException.toString());
      }
    }
    j = -1;
    paramString = (JSONObject)JSONReader.parse(paramString);
    i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.containsKey("t"))
      {
        i = j;
        if ("7".equals(paramString.get("t")))
        {
          i = 7;
          QMNotification.postNotification("receivePushAdvertise", QMNotification.EMPTY_NOTIFICATION);
        }
      }
    }
    QMLog.log(4, "webpush", "handleReceivePushConfig:" + i + ", json:" + paramString);
  }
  
  private void handleReceivePushDebugLog(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    if (paramString == null) {
      QMLog.log(6, "webpush", "handleReceivePushDebugLog: json_null");
    }
    int i;
    do
    {
      return;
      Integer.parseInt((String)paramString.get("l"));
      i = Integer.parseInt((String)paramString.get("d"));
      paramString = (String)paramString.get("p");
    } while (i <= 0);
    Threads.runInBackground(new QMServiceManager.5(this, i, paramString));
  }
  
  private void handleReceivePushFtn(String paramString)
  {
    Object localObject = (JSONObject)JSONReader.parse(paramString);
    if (localObject == null) {
      QMLog.log(6, "webpush", "handleReceivePushFtn: json_null");
    }
    int k;
    QQMailAccount localQQMailAccount;
    label215:
    do
    {
      return;
      int i = JSONReader.getInt((JSONObject)localObject, "m", 0);
      int j = JSONReader.getInt((JSONObject)localObject, "n", 0);
      k = JSONReader.getInt((JSONObject)localObject, "a", 0);
      localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
      StringBuilder localStringBuilder = new StringBuilder().append("receivePushFtn:").append(k).append(",");
      if (localQQMailAccount != null)
      {
        paramString = Integer.valueOf(localQQMailAccount.getId());
        QMLog.log(4, "webpush", paramString + "," + i + "," + j);
        if (i != 9) {
          continue;
        }
        QMPushMailNotify.getInstance().notifyGotoFtn(k, j);
        localObject = new StringBuilder().append("Ftn#count:").append(j);
        if (!AppStatusUtil.isAppOnBackGround()) {
          break label215;
        }
      }
      for (paramString = "#Background";; paramString = "#Active")
      {
        paramString = paramString;
        DataCollector.logDetailEvent("DetailEvent_RecvPush", localQQMailAccount.getId(), 0L, paramString);
        return;
        paramString = null;
        break;
      }
    } while ((localQQMailAccount == null) || (localQQMailAccount.getId() != k));
    paramString = FtnManager.sharedInstance();
    if (paramString != null) {
      paramString.getList();
    }
    localObject = new StringBuilder().append("Ftn#mailId:").append(((JSONObject)localObject).get("f"));
    if (AppStatusUtil.isAppOnBackGround()) {}
    for (paramString = "#Background";; paramString = "#Active")
    {
      paramString = paramString;
      DataCollector.logDetailEvent("DetailEvent_RecvPush", localQQMailAccount.getId(), 0L, paramString);
      return;
    }
  }
  
  private void handleReceivePushGmailAuthExpire(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    if (paramString == null)
    {
      QMLog.log(6, "webpush", "handleReceivePushGmailAuthExpire: json_null");
      return;
    }
    int i = JSONReader.getInt(paramString, "a", 0);
    QMPushMailNotify.getInstance().notifyGmailAuth(i);
    QMLog.log(4, "webpush", "handleReceivePushGmailAuthExpire: " + i + "," + 161);
  }
  
  private void handleReceivePushImage(String paramString)
  {
    PushWebAttach localPushWebAttach = new PushWebAttach();
    localPushWebAttach.fromJson(paramString);
    QMLog.log(4, "webpush", "receivePushImage:" + localPushWebAttach.getAccountId());
    QMPushMailNotify.getInstance().notifyImagePush(localPushWebAttach);
    startPushImage(localPushWebAttach);
  }
  
  private void handleReceivePushLogin(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    int i;
    if (paramString == null)
    {
      QMLog.log(6, "webpush", "handleReceivePushLogin json_null");
      i = 0;
      QMNotification.postNotification("receivePushLogin", paramString);
      if (!AppStatusUtil.isAppOnForeground())
      {
        QMLog.log(4, "QMServiceManager", "app not active. push notifycenter:" + i);
        if (i != 2) {
          break label258;
        }
        if (!paramString.containsKey("a")) {}
      }
    }
    label258:
    while ((i != 1) || (!paramString.containsKey("a")))
    {
      try
      {
        j = Integer.parseInt((String)paramString.get("a"));
        QMPushMailNotify.getInstance().notifyGotoLogin(j, i);
        return;
      }
      catch (Exception localException)
      {
        QMLog.log(6, "webpush", "handleReceivePushLogin a error:" + paramString.get("a"));
        return;
      }
      if ((paramString.containsKey("t")) && (paramString.get("t") != null) && (paramString.get("t").equals("devlock")))
      {
        QMLog.log(4, "webpush", "handleReceivePushLogin aid:" + paramString.get("a") + ", type:" + paramString.get("t"));
        i = 2;
        break;
      }
      QMLog.log(4, "webpush", "handleReceivePushLogin uin:" + paramString.get("uin"));
      i = 1;
      break;
    }
    int j = Integer.parseInt(String.valueOf(paramString.get("a")));
    paramString = AccountManager.shareInstance().getAccountList().getAccountById(j);
    if (paramString != null)
    {
      QMPushMailNotify.getInstance().notifyGotoLogin(j, i);
      QMLog.log(4, "QMServiceManager", "handleReceivePushLogin. set account state pwderr");
      AccountManager.shareInstance().saveAccountState(j, -1);
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "pushAccountPwdFail:" + paramString.getEmail());
      return;
    }
    QMLog.log(6, "QMServiceManager", "push aid:" + j + " pwd err.");
  }
  
  private void handleReceivePushMail(String paramString)
  {
    PushMailBody localPushMailBody = new PushMailBody();
    localPushMailBody.fromJson(paramString);
    if (AccountManager.shareInstance().getAccountList().getAccountById(localPushMailBody.accountId) == null)
    {
      QMLog.log(4, "webpush", "handleReceivePushMail account_null" + localPushMailBody.accountId);
      return;
    }
    localPushMailBody.hasSound = hasSound();
    localPushMailBody.hasVibrate = hasVibrate();
    handleReceivePushMail(localPushMailBody);
  }
  
  private void handleReceivePushNote(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    if (paramString == null) {
      QMLog.log(6, "webpush", "handleReceivePushNote: json_null");
    }
    int i;
    QQMailAccount localQQMailAccount;
    label198:
    do
    {
      return;
      i = JSONReader.getInt(paramString, "a", 0);
      int j = JSONReader.getInt(paramString, "o", 0);
      localObject = paramString.getString("n");
      localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
      StringBuilder localStringBuilder = new StringBuilder().append("receivePushNote:").append(i).append(",");
      if (localQQMailAccount != null)
      {
        paramString = Integer.valueOf(localQQMailAccount.getId());
        QMLog.log(4, "webpush", paramString + "," + j);
        if (j != 4) {
          continue;
        }
        QMPushMailNotify.getInstance().notifyGotoReadNote(i, (String)localObject);
        localObject = new StringBuilder().append("Note#mailId:").append((String)localObject);
        if (!AppStatusUtil.isAppOnBackGround()) {
          break label198;
        }
      }
      for (paramString = "#Background";; paramString = "#Active")
      {
        paramString = paramString;
        DataCollector.logDetailEvent("DetailEvent_RecvPush", localQQMailAccount.getId(), 0L, paramString);
        return;
        paramString = null;
        break;
      }
    } while ((localQQMailAccount == null) || (localQQMailAccount.getId() != i));
    paramString = NoteManager.sharedInstance();
    if (paramString != null) {
      paramString.loadNoteList();
    }
    Object localObject = new StringBuilder().append("Note#mailId:").append((String)localObject);
    if (AppStatusUtil.isAppOnBackGround()) {}
    for (paramString = "#Background";; paramString = "#Active")
    {
      paramString = paramString;
      DataCollector.logDetailEvent("DetailEvent_RecvPush", localQQMailAccount.getId(), 0L, paramString);
      return;
    }
  }
  
  private void handleReceivePushSaveToWeiYun(String paramString)
  {
    Object localObject = (JSONObject)JSONReader.parse(paramString);
    if (localObject == null) {
      QMLog.log(6, "webpush", "handleReceivePushSaveToWeiYun: json_null");
    }
    String str;
    do
    {
      return;
      paramString = ((JSONObject)localObject).getString("ret");
      if ((paramString != null) && (paramString.equals("0")))
      {
        QMLog.log(4, "webpush", "handleReceivePushSaveToWeiYun success");
        QMWatcherCenter.triggerForwardToWeiYunSuccess();
        return;
      }
      QMLog.log(6, "webpush", "handleReceivePushSaveToWeiYun error");
      QMWatcherCenter.triggerForwardToWeiYunError(-1);
      paramString = ((JSONObject)localObject).getString("taskid");
      localObject = Uri.decode(((JSONObject)localObject).getString("filename"));
      str = QMApplicationContext.sharedInstance().getString(2131690574);
    } while (!AppStatusUtil.isAppOnBackGround());
    Intent localIntent = AttachSaveToWeiYunActivity.createIntent(true, (String)localObject);
    localIntent.addFlags(67108864);
    int i = Integer.valueOf(paramString).intValue();
    QMNotificationConstructor.getInstance().notifySaveToWeiYun(i, (String)localObject, str, null, PendingIntent.getActivity(QMApplicationContext.sharedInstance(), i, localIntent, 134217728));
  }
  
  private void handleReceivePushScanFile(String paramString)
  {
    PushWebAttach localPushWebAttach = new PushWebAttach();
    localPushWebAttach.fromJson(paramString);
    QMLog.log(4, "webpush", "receivePushScanFile:" + localPushWebAttach.getAccountId());
    QMPushMailNotify.getInstance().notifyScanFilePush(localPushWebAttach);
    startPushScanFile(localPushWebAttach);
  }
  
  private void handleReceivePushSchema(String paramString)
  {
    if ((JSONObject)JSONReader.parse(paramString) == null)
    {
      QMLog.log(6, "webpush", "handleReceivePushSchema: json_null");
      return;
    }
    PushSchemaBody localPushSchemaBody = new PushSchemaBody();
    localPushSchemaBody.fromJson(paramString);
    QMLog.log(4, "webpush", "handleReceivePushSchema body" + localPushSchemaBody.toJson());
    QMPushMailNotify.getInstance().notifySchema(localPushSchemaBody);
    DataCollector.logDetailEvent("DetailEvent_Scheme_Push", 0L, 0L, paramString);
  }
  
  private void handleReceivePushSync(String paramString)
  {
    Object localObject = new PushSyncBody();
    ((PushSyncBody)localObject).fromJson(paramString);
    QMLog.log(4, "webpush", "handleReceivePushSync body" + ((PushSyncBody)localObject).toJson());
    paramString = ((PushSyncBody)localObject).getAddress();
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      localObject = AccountManager.shareInstance().getAccountList().getAddressMap();
      if ((localObject != null) && (((HashMap)localObject).size() > 0))
      {
        paramString = (Account)((HashMap)localObject).get(paramString);
        if (paramString != null)
        {
          localObject = QMFolderManager.sharedInstance().getFoldersByAccountAndType(paramString.getId(), 1);
          QMLog.log(4, "webpush", "handleReceivePushSync account:" + paramString.getEmail());
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            QMLog.log(4, "webpush", "handleReceivePushSync inbox:" + ((ArrayList)localObject).size());
            paramString = ((ArrayList)localObject).iterator();
            while (paramString.hasNext())
            {
              localObject = (QMFolder)paramString.next();
              QMMailManager.sharedInstance().updateList((QMFolder)localObject, false, null);
            }
          }
        }
      }
    }
  }
  
  private void handleReceivePushWipe(String paramString)
  {
    PushMailBody localPushMailBody = new PushMailBody();
    localPushMailBody.fromJson(paramString);
    if (String.valueOf(QMApplicationContext.sharedInstance().getVid()).equals(localPushMailBody.vid))
    {
      if (!AppStatusUtil.isAppOnBackGround()) {
        QMPrivateProtocolManager.sharedInstance().triggerWipeAppWatcher(0);
      }
    }
    else {
      return;
    }
    QMSettingManager.sharedInstance().setWipeAll(true);
    QMPrivateProtocolManager.sharedInstance().wipeEntireApp();
    LoginUser.stopPushAndKillProcess();
  }
  
  public static boolean hasSound()
  {
    boolean bool2 = QMSettingManager.sharedInstance().getEnableSoundPushNewMail();
    boolean bool3 = QMSettingManager.sharedInstance().getUseNightMode();
    boolean bool4 = isNowNight();
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean hasVibrate()
  {
    boolean bool1 = QMSettingManager.sharedInstance().getEnablePushNewMailVibrate();
    boolean bool2 = QMSettingManager.sharedInstance().getUseNightMode();
    return (bool1) && ((!bool2) || (!isNowNight()));
  }
  
  public static boolean isNotifyServiceCommand(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 160: 
    case 165: 
    case 168: 
    case 169: 
    default: 
      bool = false;
    }
    return bool;
  }
  
  private static boolean isNowNight()
  {
    if (QMSettingManager.sharedInstance().getUseNightMode())
    {
      int i = Calendar.getInstance().get(11);
      if ((i >= 22) || (i <= 7)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isPushEnable()
  {
    return !DISABLE_PUSH_FLAG_FILE.exists();
  }
  
  public static boolean isUMAPushEnable()
  {
    return SPManager.getSp("webpush_main_info", true).getBoolean("enable_push", true);
  }
  
  private void logPushMail(PushMailBody paramPushMailBody)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("NewMail#mailId:");
    if (paramPushMailBody.fromPush)
    {
      localObject = paramPushMailBody.remoteId;
      localStringBuilder = localStringBuilder.append(localObject).append("####");
      if (!paramPushMailBody.fromPush) {
        break label126;
      }
      localObject = "1";
      label49:
      localStringBuilder = localStringBuilder.append((String)localObject).append("####");
      if (!paramPushMailBody.fromPush) {
        break label133;
      }
      localObject = Integer.valueOf(paramPushMailBody.seqid);
      label76:
      localStringBuilder = localStringBuilder.append(localObject);
      if (!AppStatusUtil.isAppOnBackGround()) {
        break label140;
      }
    }
    label133:
    label140:
    for (Object localObject = "#Background";; localObject = "#Active")
    {
      localObject = (String)localObject;
      DataCollector.logDetailEvent("DetailEvent_RecvPush", paramPushMailBody.accountId, 0L, (String)localObject);
      return;
      localObject = Long.valueOf(paramPushMailBody.nMailId);
      break;
      label126:
      localObject = "0";
      break label49;
      localObject = "";
      break label76;
    }
  }
  
  public static void resetPushNeedReconnect()
  {
    SPManager.getEditorInMultiProcess("webpush_main_info").remove("push_need_reconnect").apply();
  }
  
  public static void setEnablePush(boolean paramBoolean)
  {
    boolean bool = false;
    int i = 0;
    File localFile;
    if (paramBoolean)
    {
      while ((i < 3) && (DISABLE_PUSH_FLAG_FILE.exists()) && (!DISABLE_PUSH_FLAG_FILE.delete()))
      {
        i += 1;
        QMLog.log(6, "QMServiceManager", "enable push, delete flag file failed, retry: " + i);
        SystemClock.sleep(100L);
      }
      localFile = new File(FileUtil.getExitPushFileDir());
      if ((localFile.exists()) && (!localFile.delete())) {
        QMLog.log(5, "QMServiceManager", "delete exitPushWatchFile failed!");
      }
    }
    for (;;)
    {
      return;
      if (!DISABLE_PUSH_FLAG_FILE.exists()) {
        localFile = null;
      }
      try
      {
        paramBoolean = DISABLE_PUSH_FLAG_FILE.createNewFile();
        if (!paramBoolean) {
          QMLog.log(5, "QMServiceManager", "disable push, create flag file failed", localFile);
        }
        localFile = new File(FileUtil.getExitPushFileDir());
        if (localFile.exists()) {
          continue;
        }
        if (!FileUtil.tryMkdirs(localFile.getParentFile())) {
          QMLog.log(6, "QMServiceManager", "exit push. parentDir mkdirs fail");
        }
        try
        {
          if (localFile.createNewFile()) {
            continue;
          }
          QMLog.log(4, "QMServiceManager", "create exitPushWatchFile fail");
          return;
        }
        catch (IOException localIOException)
        {
          QMLog.log(4, "QMServiceManager", "create exitPushWatchFile err:" + localIOException.toString());
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramBoolean = bool;
        }
      }
    }
  }
  
  public static void setEnableUMAPush(boolean paramBoolean)
  {
    getWebPushEditor().putBoolean("enable_push", paramBoolean).commit();
    if (paramBoolean)
    {
      getWebPushEditor().putBoolean("need_uma_login", true).putBoolean("push_need_reconnect", true).commit();
      startPushService(QMPushService.PushStartUpReason.OTHER);
      return;
    }
    QMApplicationContext.sharedInstance().startService(QMPushService.createStopServiceIntent());
  }
  
  public static QMServiceManager sharedInstance()
  {
    return _instance;
  }
  
  public static void startPushService(QMPushService.PushStartUpReason paramPushStartUpReason)
  {
    if (UninstallWatcherHelper.canStartWatchdog()) {
      UninstallWatcherHelper.initWatchDog(false);
    }
    if (!isPushEnable()) {}
    for (int i = 1; i != 0; i = 0)
    {
      QMLog.log(4, "QMServiceManager", "exit push, do not start");
      return;
    }
    if (getWebPushSP().getBoolean("need_uma_login", false)) {
      QMPrivateProtocolManager.sharedInstance().umaLogin(new QMServiceManager.1());
    }
    try
    {
      QMApplicationContext.sharedInstance().startService(QMPushService.createStartIntent(paramPushStartUpReason));
      return;
    }
    catch (Throwable paramPushStartUpReason) {}
  }
  
  public static void stopPushService()
  {
    QMLog.log(4, "webpush", "stopPushService");
    setEnablePush(false);
    QMApplicationContext.sharedInstance().cancelAlarmForWebpush();
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    try
    {
      localQMApplicationContext.startService(QMPushService.createStopServiceIntent());
    }
    catch (Exception localException2)
    {
      try
      {
        for (;;)
        {
          localQMApplicationContext.stopService(new Intent(localQMApplicationContext, QMWakeUpService.class));
          try
          {
            localQMApplicationContext.stopService(new Intent(localQMApplicationContext, QMNotifyService.class));
            return;
          }
          catch (Exception localException1)
          {
            QMLog.log(5, "webpush", "start StopServiceIntent exception when stopPushService", localException1);
          }
          localException2 = localException2;
          QMLog.log(5, "webpush", "start StopServiceIntent exception when stopPushService", localException2);
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          QMLog.log(5, "webpush", "start StopServiceIntent exception when stopPushService", localException3);
        }
      }
    }
  }
  
  public boolean filterLocked(PushMailBody paramPushMailBody)
  {
    if (!paramPushMailBody.hasAlert)
    {
      QMLog.log(5, "webpush", "filterLocked, no alert: " + paramPushMailBody);
      return false;
    }
    if (NotifyUtil.isNotifiedMailId(paramPushMailBody.accountId, paramPushMailBody.nMailId))
    {
      QMLog.log(5, "webpush", "filterLocked, has been notified: " + paramPushMailBody);
      return false;
    }
    if (!QMSettingManager.sharedInstance().getNotifyNewMail())
    {
      QMLog.log(5, "webpush", "filterLocked, NotifyNewMail disabled: " + paramPushMailBody);
      return false;
    }
    if (!QMSettingManager.sharedInstance().getNotifyAccountMail(paramPushMailBody.accountId))
    {
      QMLog.log(5, "webpush", "filterLocked, NotifyAccountMail disabled: " + paramPushMailBody);
      return false;
    }
    long l = paramPushMailBody.recvTime - paramPushMailBody.fromtime;
    if (l > 432000L)
    {
      QMLog.log(5, "webpush", "filterLocked, out of time, delay: " + l + "s, " + paramPushMailBody);
      return false;
    }
    int i;
    if (paramPushMailBody.fromPush)
    {
      localObject = QMMailManager.sharedInstance().readLocalMail(paramPushMailBody.nMailId);
      if (localObject != null)
      {
        if ((((Mail)localObject).getStatus() == null) || (((Mail)localObject).getStatus().isUnread()))
        {
          i = 1;
          if ((((Mail)localObject).getInformation() == null) || (((Mail)localObject).getInformation().getLastOptTime() == null)) {
            break label336;
          }
        }
        label336:
        for (l = ((Mail)localObject).getInformation().getLastOptTime().getTime();; l = 0L)
        {
          if ((i != 0) && (System.currentTimeMillis() - l <= 300000L)) {
            break label341;
          }
          QMLog.log(5, "webpush", "filterLocked, push repeat, do not notify: " + paramPushMailBody);
          return false;
          i = 0;
          break;
        }
      }
    }
    label341:
    if (paramPushMailBody.sender != null) {}
    for (Object localObject = paramPushMailBody.sender.address;; localObject = "")
    {
      i = QMMailManager.sharedInstance().getMailAdState(paramPushMailBody.accountId, (String)localObject, paramPushMailBody.subject);
      if ((QMSettingManager.sharedInstance().getNotifyAdMail()) || ((i != 2) && ((!paramPushMailBody.advertisement) || (i != 1)))) {
        break;
      }
      QMLog.log(5, "webpush", "filterLocked, do not notfiy ad mail, state: " + i + ", " + paramPushMailBody);
      return false;
    }
    if (QMSettingManager.sharedInstance().getOnlyNotifyVIP())
    {
      if (!QMContactManager.sharedInstance().isVipAddressForAccount(paramPushMailBody.accountId, (String)localObject))
      {
        QMLog.log(5, "webpush", "filterLocked, sender is not vip: " + paramPushMailBody);
        return false;
      }
    }
    else
    {
      localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramPushMailBody.accountId);
      if (localObject == null)
      {
        QMLog.log(5, "webpush", "filterLocked, no account: " + paramPushMailBody);
        return false;
      }
      if (((Account)localObject).isQQMail())
      {
        localObject = QMFolderManager.sharedInstance().getFolder(paramPushMailBody.folderid);
        if ((localObject == null) || (!((QMFolder)localObject).isPush()))
        {
          QMLog.log(5, "webpush", "filterLocked, folder disabled notify: " + localObject + ", " + paramPushMailBody);
          return false;
        }
        if ((!paramPushMailBody.fromPush) && (((QMFolder)localObject).getType() == 15) && (!QMABTestManager.isEnableNotifySub()))
        {
          QMLog.log(5, "webpush", "filterLocked, subscribe mails disabled notify: " + paramPushMailBody);
          return false;
        }
      }
      else
      {
        boolean bool = QMSettingManager.sharedInstance().getPushInboxOnly(paramPushMailBody.accountId);
        i = QMFolderManager.sharedInstance().getInboxFolderId(paramPushMailBody.accountId);
        if ((bool) && (i != paramPushMailBody.folderid))
        {
          QMLog.log(5, "webpush", "filterLocked, folder is not inbox: " + paramPushMailBody);
          return false;
        }
      }
    }
    if (!QMMailManager.sharedInstance().isMailUnRead(paramPushMailBody.nMailId))
    {
      QMLog.log(5, "webpush", "filterLocked, mail has read: " + paramPushMailBody);
      return false;
    }
    return true;
  }
  
  public int handleReceivePush(int paramInt, String paramString)
  {
    QMLog.log(4, "QMServiceManager", "handleReceivePush " + paramInt);
    switch (paramInt)
    {
    case 160: 
    case 163: 
    case 165: 
    case 168: 
    case 169: 
    default: 
      return paramInt;
    case 148: 
    case 155: 
      handleReceivePushMail(paramString);
      return paramInt;
    case 152: 
      handleReceivePushImage(paramString);
      return paramInt;
    case 170: 
      handleReceivePushScanFile(paramString);
      return paramInt;
    case 151: 
      handleReceivePushNote(paramString);
      return paramInt;
    case 150: 
      handleReceivePushFtn(paramString);
      return paramInt;
    case 154: 
      handleReceivePushConfig(paramString);
      return paramInt;
    case 157: 
      handleReceivePushAttachFolder(paramString);
      return paramInt;
    case 156: 
      handleReceivePushBottle(paramString);
      return paramInt;
    case 158: 
      handleCalendarPush(paramString);
      return paramInt;
    case 162: 
      handleReceivePushSchema(paramString);
      return paramInt;
    case 153: 
      handleReceivePushWipe(paramString);
      return paramInt;
    case 149: 
      handleReceivePushLogin(paramString);
      return paramInt;
    case 161: 
      handleReceivePushGmailAuthExpire(paramString);
      return paramInt;
    case 159: 
      handleReceivePushDebugLog(paramString);
      return paramInt;
    case 164: 
      handleReceivePushSaveToWeiYun(paramString);
      return paramInt;
    case 166: 
      handleReceivePushSync(paramString);
      return paramInt;
    case 167: 
      QMPrivateProtocolManager.sharedInstance().updateConfig(true, 2, null);
      return paramInt;
    }
    handleReceiveCreditCardBillPush(paramString);
    return paramInt;
  }
  
  public int handleReceivePush(ReceivePacket paramReceivePacket)
  {
    if (paramReceivePacket != null)
    {
      String str = paramReceivePacket.getBodyString();
      int i = paramReceivePacket.cmd_id;
      QMLog.log(4, "webpush", "receivePush: " + i + ", body: " + str);
      return handleReceivePush(i, str);
    }
    return 0;
  }
  
  public void handleReceivePushBottle(String paramString)
  {
    paramString = (JSONObject)JSONReader.parse(paramString);
    if (paramString == null)
    {
      QMLog.log(5, "QMServiceManager", "handleReceivePushBottle, json parse error!");
      return;
    }
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultBottleAccount();
    if ((localQQMailAccount == null) || (BottleManager.getInstance() == null))
    {
      QMLog.log(5, "QMServiceManager", "handleReceivePushBottle, no default bottle account");
      return;
    }
    int i = JSONReader.getInt(paramString, "a", 0);
    Object localObject = paramString.getString("mailid");
    QMLog.log(4, "webpush", "receivePushBottle: " + i + "/" + localQQMailAccount.getId() + ", " + (String)localObject);
    if (i == localQQMailAccount.getId())
    {
      mobileSync(i);
      QMNotification.postNotification("receivePushBottle", paramString);
    }
    localObject = new StringBuilder().append("Bottle#mailId:").append((String)localObject);
    if (AppStatusUtil.isAppOnBackGround()) {}
    for (paramString = "#Background";; paramString = "#Active")
    {
      paramString = paramString;
      DataCollector.logDetailEvent("DetailEvent_RecvPush", localQQMailAccount.getId(), 0L, paramString);
      return;
    }
  }
  
  public void handleReceivePushMail(PushMailBody paramPushMailBody) {}
  
  public void localSync(String paramString)
  {
    this.mSyncTask.offer(paramString);
    Threads.runInBackgroundIfNotExist(this.mSyncTask, 3000L);
  }
  
  public void mobileSync(int paramInt)
  {
    this.mMobileSyncTask.offer(paramInt);
    Threads.runInBackgroundIfNotExist(this.mMobileSyncTask, 500L);
  }
  
  public void preloadMail(int paramInt, String paramString)
  {
    this.mBgPreloadMailTask.offer(paramInt, paramString);
    Threads.runInBackgroundIfNotExist(this.mBgPreloadMailTask, 5000L);
  }
  
  public void startPushImage(PushWebAttach paramPushWebAttach)
  {
    Object localObject = QMApplicationContext.sharedInstance();
    if ((AppStatusUtil.isAppOnForeground()) && (!CommUtils.isOnAlbum((Context)localObject)) && (!CommUtils.isOnScanFile((Context)localObject)))
    {
      localQMUploadImageManager = QMUploadImageManager.sharedInstance();
      localQMUploadImageManager.init(paramPushWebAttach, false);
      if (FileUtil.hasSdcard()) {
        localQMUploadImageManager.goAlbum();
      }
    }
    while ((CommUtils.isOnAlbum((Context)localObject)) || (CommUtils.isOnScanFile((Context)localObject)))
    {
      QMUploadImageManager localQMUploadImageManager;
      return;
      Threads.runOnMainThread(new QMServiceManager.3(this, (Context)localObject));
      return;
    }
    localObject = QMUploadImageManager.sharedInstance();
    ((QMUploadImageManager)localObject).init(paramPushWebAttach, false);
    ((QMUploadImageManager)localObject).setAlbumCallback();
  }
  
  public void startPushScanFile(PushWebAttach paramPushWebAttach)
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    if ((AppStatusUtil.isAppOnForeground()) && (!CommUtils.isOnAlbum(localQMApplicationContext)) && (!CommUtils.isOnCompose(localQMApplicationContext)) && (!CommUtils.isOnScanFile(localQMApplicationContext)))
    {
      localQMUploadImageManager = QMUploadImageManager.sharedInstance();
      localQMUploadImageManager.init(paramPushWebAttach, true);
      if (FileUtil.hasSdcard())
      {
        localQMUploadImageManager.goScanFile();
        KvHelper.eventScanForegroundShow(new double[0]);
      }
    }
    while ((CommUtils.isOnAlbum(localQMApplicationContext)) || (CommUtils.isOnCompose(localQMApplicationContext)) || (CommUtils.isOnScanFile(localQMApplicationContext)))
    {
      QMUploadImageManager localQMUploadImageManager;
      return;
      Threads.runOnMainThread(new QMServiceManager.4(this, localQMApplicationContext));
      return;
    }
    QMUploadImageManager.sharedInstance().init(paramPushWebAttach, true);
  }
  
  class BackgroundPreloadMailTask
    implements Runnable
  {
    final Object REMOVED = new Object();
    SparseArray<Map<String, Object>> mRemoteIds = new SparseArray();
    
    private BackgroundPreloadMailTask() {}
    
    void offer(int paramInt, String paramString)
    {
      try
      {
        Map localMap = (Map)this.mRemoteIds.get(paramInt);
        Object localObject = localMap;
        if (localMap == null)
        {
          localObject = new HashMap();
          this.mRemoteIds.put(paramInt, localObject);
        }
        if (!((Map)localObject).containsKey(paramString)) {
          ((Map)localObject).put(paramString, Boolean.TRUE);
        }
        return;
      }
      finally {}
    }
    
    void remove(int paramInt, String paramString)
    {
      try
      {
        Map localMap = (Map)this.mRemoteIds.get(paramInt);
        Object localObject = localMap;
        if (localMap == null)
        {
          localObject = new HashMap();
          this.mRemoteIds.put(paramInt, localObject);
        }
        ((Map)localObject).put(paramString, this.REMOVED);
        return;
      }
      finally {}
    }
    
    public void run()
    {
      for (;;)
      {
        int i;
        try
        {
          int j = this.mRemoteIds.size();
          i = 0;
          if (i >= j) {
            break label161;
          }
          int k = this.mRemoteIds.keyAt(i);
          Map localMap = (Map)this.mRemoteIds.valueAt(i);
          if (localMap == null) {
            break label178;
          }
          bool = true;
          ValidateHelper.assertInDebug("remoteId list is null", bool);
          if (localMap == null) {
            break label171;
          }
          Iterator localIterator = localMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            if (((Map.Entry)localIterator.next()).getValue() != this.REMOVED) {
              continue;
            }
            localIterator.remove();
            continue;
          }
          QMMailManager.sharedInstance().preloadMails(k, (String[])localObject.keySet().toArray(new String[localObject.size()]), false);
        }
        finally {}
        break label171;
        label161:
        this.mRemoteIds.clear();
        return;
        label171:
        i += 1;
        continue;
        label178:
        boolean bool = false;
      }
    }
  }
  
  class MobileSyncTask
    implements Runnable
  {
    Set<Integer> mAccountIds = new HashSet();
    
    private MobileSyncTask() {}
    
    public void offer(int paramInt)
    {
      try
      {
        this.mAccountIds.add(Integer.valueOf(paramInt));
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void run()
    {
      try
      {
        Threads.removeCallbackInBackground(this);
        QMMailManager.sharedInstance().sync(Ints.toArray(this.mAccountIds));
        this.mAccountIds.clear();
        return;
      }
      finally {}
    }
  }
  
  class SyncTask
    implements Runnable
  {
    Set<String> mSyncAccounts = new HashSet();
    
    private SyncTask() {}
    
    void offer(String paramString)
    {
      try
      {
        this.mSyncAccounts.add(paramString);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public void run()
    {
      try
      {
        this.mSyncAccounts.clear();
        Bundle localBundle = new Bundle();
        localBundle.putString("self_initiated", "push_local_sync");
        QMSyncAdapterManager.syncAllAccount(localBundle);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager
 * JD-Core Version:    0.7.0.1
 */