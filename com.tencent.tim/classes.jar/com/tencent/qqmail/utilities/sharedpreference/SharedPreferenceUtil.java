package com.tencent.qqmail.utilities.sharedpreference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SharedPreferenceUtil
{
  private static final String ACTIVE_SYNC_ALIVE_TIME = "activesyncalivetime";
  private static final String CREATE_CONTEXT_TIME = "create_context_time";
  private static final String DEFAULT_PREF_NAME = "default_preference_name";
  private static final String FOLDER_TOP_SP_NAME = "foldertop";
  private static final String LOCAL_SYNC_ALIVE_TIME = "localsyncalivetime";
  private static final String MAIN_PID = "downloadpid";
  private static final String PREF_NAME_TIME_SUM = "time_sum_prefs";
  private static String TAG = "SharedPreferenceUtil";
  private static final SharedPreferences defaultSharePreference = QMApplicationContext.sharedInstance().getSharedPreferences("default_preference_name", 0);
  
  public static void clearDebuglogStatus()
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().remove("sendrequestend_http").remove("sendrequestend_https").commit();
  }
  
  public static void enableRichEditMode(boolean paramBoolean)
  {
    defaultSharePreference.edit().putBoolean("enable_rich_edit_mode", paramBoolean).apply();
  }
  
  public static void enableTranslucentBar(boolean paramBoolean)
  {
    defaultSharePreference.edit().putBoolean("enable_translucent_bar", paramBoolean).apply();
  }
  
  public static boolean getAccountListChanged()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getBoolean("accountListChanged", true);
  }
  
  public static int getAccountPasswordState()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getInt("accountpwdstate", 0);
  }
  
  public static long getActiveSyncAliveTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("time_sum_prefs", 0).getLong("activesyncalivetime", 0L);
  }
  
  public static int getAppWidgetSize(int paramInt)
  {
    QMLog.log(4, TAG, "getAppWidgetSize appWidgetId = " + paramInt);
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getInt("" + paramInt, 4);
  }
  
  public static long getAutoSubmitUmaLogTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getLong("autoSubmitUmaLogTime", 0L);
  }
  
  public static int getCalendarEnterCount()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getInt("calendarEnterCount", 0);
  }
  
  public static int getCalendarWidgetMonth()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getInt("calendar_widget_month", Calendar.getInstance().get(2));
  }
  
  public static int getCalendarWidgetYear()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getInt("calendar_widget_year", Calendar.getInstance().get(1));
  }
  
  public static ConcurrentHashMap<String, Long> getCardSendContactHashMap()
  {
    Object localObject1 = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localObject1 = ((SharedPreferences)localObject1).getString("cardSendContact", null);
    if (localObject1 == null) {
      return localConcurrentHashMap;
    }
    localObject1 = ((String)localObject1).split(";");
    int j = localObject1.length;
    int i = 0;
    label46:
    Object localObject2;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if (!"".equals(localObject2)) {
        break label73;
      }
    }
    for (;;)
    {
      i += 1;
      break label46;
      break;
      label73:
      localObject2 = ((String)localObject2).split(",");
      localConcurrentHashMap.put(localObject2[0], Long.valueOf(Long.valueOf(localObject2[1]).longValue()));
    }
  }
  
  public static int getCrashCountOfCompose()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("compose_crash", 0).getInt("crash_count_of_compose", 0);
  }
  
  public static long getCreateContextTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getLong("create_context_time", 0L);
  }
  
  public static String getCreditCardBillDetail(String paramString)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).getString(paramString, "");
  }
  
  public static int getCreditCardBillRemindDate(String paramString)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).getInt(paramString, -1);
  }
  
  public static boolean getCreditCardBillRemindInnerRedPoint()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).getBoolean("inner_redpoint", false);
  }
  
  public static boolean getCreditCardBillRemindOutterRedPoint()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).getBoolean("outter_redpoint", false);
  }
  
  public static boolean getCreditCardDialogAccept(int paramInt)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).getBoolean("credit_accept" + paramInt, true);
  }
  
  public static boolean getCreditCardDialogShown(int paramInt)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).getBoolean("credit_dialog" + paramInt, false);
  }
  
  public static int getDeviceLockState()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getInt("devicelock", 0);
  }
  
  public static int getEnterFolderCnt(int paramInt1, int paramInt2)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("foldertop", 0).getInt("enterFolder" + paramInt1 + "_" + paramInt2, 0);
  }
  
  public static int getEnterFolderCntWhenMultiAccount(int paramInt1, int paramInt2)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("foldertop", 0).getInt("enterFolderWhenMultiAccount" + paramInt1 + "_" + paramInt2, 0);
  }
  
  public static long getFingerprintLastFailTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("fingerprint", 0).getLong("fingerprint_last_fail_mill", -1L);
  }
  
  public static int getFingerprintRetryTimes()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("fingerprint", 0).getInt("fingerprint_retry", 0);
  }
  
  public static long getFingerprintUnlockTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("fingerprint", 0).getLong("fingerprint_unlock_mill", -1L);
  }
  
  public static boolean getFolderLongClicTipHasShow()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getBoolean("folderLongClicTipHasShow", false);
  }
  
  public static boolean getFolderShowHomeHaveTip()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("foldertop", 0).getBoolean("folder_show_home_havetip", false);
  }
  
  public static boolean getFolderTopHaveTip()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("foldertop", 0).getBoolean("folder_top_havetip", false);
  }
  
  public static String getGesturePwd()
  {
    String str2 = QMApplicationContext.sharedInstance().getSharedPreferences("gesturesetting", 0).getString("gesturepwd", null);
    String str1 = str2;
    if (str2 != null) {
      str1 = Aes.decode(str2, Aes.getIMEIKey());
    }
    QMLog.log(4, TAG, "getGesturePwd:" + str1);
    return str1;
  }
  
  public static boolean getHasCheckBadgeSupport()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).getBoolean("has_check_Badge_Support", false);
  }
  
  public static boolean getHasLastPushAdvertiseImage()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("advertise", 0).getBoolean("last_push_advertise_image", false);
  }
  
  public static long getInitUninstallWatchProcessTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getLong("inituninstalltime", -1L);
  }
  
  public static boolean getJourneyDialogAccept(int paramInt)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("journey", 0).getBoolean("journey_accept" + paramInt, true);
  }
  
  public static boolean getJourneyDialogShown(int paramInt)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).getBoolean("journey_dialog" + paramInt, false);
  }
  
  public static int getJourneyRemindDate(String paramString)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("journey", 0).getInt(paramString, -1);
  }
  
  public static long getLastCollectPreviewTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("image_scan", 0).getLong("last_image_collect_time", -1L);
  }
  
  public static ConcurrentHashMap<String, List<String>> getLocalHostIp()
  {
    Object localObject1 = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localObject1 = ((SharedPreferences)localObject1).getString("localHostIp", null);
    if (localObject1 == null) {
      return localConcurrentHashMap;
    }
    localObject1 = ((String)localObject1).split(";");
    int i = 0;
    if (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      if ("".equals(localObject2)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((String)localObject2).split(",");
        Object localObject3 = localObject2[0];
        ArrayList localArrayList = new ArrayList();
        int j = 1;
        while (j < localObject2.length)
        {
          localArrayList.add(localObject2[j]);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          localConcurrentHashMap.put(localObject3, localArrayList);
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  public static long getLocalSyncAliveTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("time_sum_prefs", 0).getLong("localsyncalivetime", 0L);
  }
  
  public static long getLoginSvrUtc()
  {
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    long l1 = localSharedPreferences.getLong("loginsvrutcsavetime", -1L);
    long l2 = localSharedPreferences.getLong("loginsvrutc", -1L);
    long l3 = new Date().getTime() / 1000L;
    if (l1 == -1L)
    {
      QMLog.log(5, TAG, "svrutc not exist. use local");
      return l3;
    }
    long l4 = l3 - l1 + l2;
    QMLog.log(4, TAG, "svrutc exist. calculate svr time:" + l3 + "," + l2 + "," + l1 + "," + l4);
    return l4;
  }
  
  public static int getMainPid()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getInt("downloadpid", 0);
  }
  
  public static int getNightModeEndTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).getInt("night_mode_endtime", 700);
  }
  
  public static boolean getNightModeHaveTip()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).getBoolean("night_mode_havetip", false);
  }
  
  public static int getNightModeStartTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).getInt("night_mode_starttime", 2200);
  }
  
  public static int getNightModeTemperature()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).getInt("night_mode_temperature", 70);
  }
  
  public static boolean getNormalCreditCardBill(String paramString)
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).getBoolean("normal_credit_card_bill" + paramString, false);
  }
  
  public static int getNoteEnterCount()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getInt("noteEnterCount", 0);
  }
  
  public static String getOutOfSightHasNewIdentify()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("outOfSightHasNew", 0).getString("outOfSight_Has_New", "");
  }
  
  public static String getPullAdertiseImageMd5()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("advertise", 0).getString("push_advertise_image_md5", "");
  }
  
  public static int getPullAdvertiseCrashGuardLastValue()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("advertise", 0).getInt("push_advertise_crash_guard_last_value", 0);
  }
  
  public static long getPushProcessAliveTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("webpush_push_info", 0).getLong("pushalivetime", 0L);
  }
  
  public static int getRationalTimes()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("permission", 0).getInt("last_rational_result", 0);
  }
  
  public static long getScreenOnSubmitLogTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getLong("screenOnSubmitLog", -1L);
  }
  
  public static boolean getShownWelcomePage()
  {
    return defaultSharePreference.getBoolean("shown_welcome_page", QMSettingManager.sharedInstance().getShownWelcomePages());
  }
  
  public static Set<String> getSyncAccountList()
  {
    Object localObject = QMAppInterface.sharedInstance().getUin();
    localObject = defaultSharePreference.getStringSet((String)localObject + "sync_account_list", new HashSet());
    Log.i(TAG, "read account list " + localObject);
    return localObject;
  }
  
  public static int getSyncSystemCalendarTipCount()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getInt("syncSystemCalendarShowTipCount", 0);
  }
  
  public static boolean getWebviewDebug()
  {
    return defaultSharePreference.getBoolean("webview_debug_mode", false);
  }
  
  public static String getWelcomeSplash()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString("welcomesplash", "");
  }
  
  public static int getWidgetScheduleHash()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getInt("hash", 0);
  }
  
  public static int getX5CoreInitCount()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("qqbrowser", 0).getInt("x5_core_init_count", 0);
  }
  
  public static boolean getX5CoreInitFinished()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("qqbrowser", 0).getBoolean("x5_core_init", false);
  }
  
  public static String getX5CoreInitThreeCrashLog()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("qqbrowser", 0).getString("x5_core_init_three_crash_log", "");
  }
  
  public static long getX5CoreNextInitTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("qqbrowser", 0).getLong("x5_core_init_time", 0L);
  }
  
  public static long getXQQWXShowLastTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getLong("xqqwxlasttime", 0L);
  }
  
  public static boolean hasInitLocalDomainConfig()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getInt("isInitLocalDomainConfig", 0) == 1;
  }
  
  public static boolean hasReportIfBadgeSupport()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).getBoolean("has_Report_If_Badge_Support", false);
  }
  
  public static boolean inNightMode()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).getBoolean("is_in_night_mode", false);
  }
  
  public static boolean isAttachDownloadCountReport()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("attach", 0).getBoolean("is_attach_download_count_report", false);
  }
  
  public static boolean isBadgeIncrement()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).getBoolean("is_Badge_Increment", true);
  }
  
  public static boolean isBadgeOpen()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).getBoolean("has_Badge_Open", true);
  }
  
  public static boolean isBadgeSupport()
  {
    if (!getHasCheckBadgeSupport()) {
      throw new IllegalStateException("You need to use method[setHasCheckBadgeSupport] to save support result first");
    }
    return QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).getBoolean("is_Badge_Support", false);
  }
  
  public static boolean isBlackNameListTipsHasShow()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("namelist", 0).getBoolean("has_black_name_list_tips_show", false);
  }
  
  public static boolean isBottleSpamBlockClose(String paramString, int paramInt)
  {
    Object localObject1 = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString("bottle_spam", "");
    if (((String)localObject1).equals("")) {
      return false;
    }
    localObject1 = ((String)localObject1).split(";");
    int j = localObject1.length;
    int i = 0;
    label48:
    Object localObject2;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if (!"".equals(localObject2)) {
        break label76;
      }
    }
    label76:
    Object localObject3;
    do
    {
      i += 1;
      break label48;
      break;
      localObject2 = ((String)localObject2).split(",");
      localObject3 = localObject2[0];
    } while ((Integer.valueOf(localObject2[1]).intValue() != paramInt) || (!paramString.equals(localObject3)));
    return Boolean.valueOf(localObject2[2]).booleanValue();
  }
  
  public static boolean isDebuglogSendRequestEnd()
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    boolean bool1 = bool2;
    if (localSharedPreferences.getBoolean("sendrequestend_http", false))
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean("sendrequestend_https", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isEnableCalendarWidget()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getBoolean("is_enable_calendar_widget", false);
  }
  
  public static boolean isEnableInboxWidget()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getBoolean("is_enable_inbox_widget", false);
  }
  
  public static boolean isEnableMonthWidget()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getBoolean("is_enable_month_widget", false);
  }
  
  public static boolean isEnableNoteWidget()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getBoolean("is_enable_note_list_widget", false);
  }
  
  public static boolean isEnableRichEditMode()
  {
    return defaultSharePreference.getBoolean("enable_rich_edit_mode", true);
  }
  
  public static boolean isExistedCalendarWidget()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getBoolean("is_exist_calendar_widget", false);
  }
  
  public static boolean isExistedInboxWidget()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getBoolean("is_exist_inbox_widget", false);
  }
  
  public static boolean isExistedMonthWidget()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getBoolean("is_exist_month_widget", false);
  }
  
  public static boolean isExistedNoteWidget()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).getBoolean("is_exist_note_widget", false);
  }
  
  public static boolean isFingerprintOpen()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("fingerprint", 0).getBoolean("is_fingerprint_open", false);
  }
  
  public static boolean isGesturePasswordShowTrack()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("gesturesetting", 0).getBoolean("GesturePasswordShowTrack", true);
  }
  
  public static boolean isGesturePswEnabled()
  {
    boolean bool = QMApplicationContext.sharedInstance().getSharedPreferences("gesturesetting", 0).getBoolean("isGesturePswEnabled", false);
    QMLog.log(4, TAG, "isGesturePswEnabled:" + bool);
    return bool;
  }
  
  public static boolean isMainThreadMonitorTurnedOn()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("default_preference_name", 0).getBoolean("main_looper_monitor", false);
  }
  
  public static boolean isNightModeAllDay()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).getBoolean("is_night_mode_allday", false);
  }
  
  public static boolean isSetLocalHostIP()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString("localHostIp", null) != null;
  }
  
  public static boolean isTranslucentBarEnable()
  {
    return defaultSharePreference.getBoolean("enable_translucent_bar", true);
  }
  
  public static boolean isWhiteNameListTipsHasShow()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("namelist", 0).getBoolean("has_white_name_list_tips_show", false);
  }
  
  public static boolean isWtlogin()
  {
    boolean bool = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getBoolean("wtlogin", true);
    QMLog.log(4, TAG, "iswtlogin:" + bool);
    return bool;
  }
  
  public static boolean needUpgradeAccountFromVersion2()
  {
    SharedPreferences localSharedPreferences;
    try
    {
      String str1 = String.valueOf(AppConfig.getMajorVersion(QMApplicationContext.sharedInstance()));
      localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
      str2 = localSharedPreferences.getString("needCheckUpdateFromOldVersion" + str1, null);
      if ((str2 != null) && (!str2.equals(""))) {
        break label334;
      }
      str2 = localSharedPreferences.getString("needCheckUpdateFromOldVersion" + "3.1.0", null);
      if ((str2 != null) && (!str2.equals("")))
      {
        localSharedPreferences.edit().putString("needCheckUpdateFromOldVersion" + str1, "false").commit();
        return false;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, "getpackgaeinfo err : " + localException.toString());
      return false;
    }
    String str2 = localSharedPreferences.getString("needCheckUpdateFromOldVersion" + "3.0", null);
    if ((str2 != null) && (!str2.equals("")))
    {
      localSharedPreferences.edit().putString("needCheckUpdateFromOldVersion" + localException, "false").commit();
      return false;
    }
    QMLog.log(4, TAG, "need upgrade:" + localException);
    localSharedPreferences.edit().putString("needCheckUpdateFromOldVersion" + localException, "false").commit();
    return true;
    label334:
    return Boolean.valueOf(str2).booleanValue();
  }
  
  public static void removeAppWidgetSize(int paramInt)
  {
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0);
    if (localSharedPreferences.contains("" + paramInt))
    {
      QMLog.log(4, TAG, "removeAppWidgetSize appWidgetId = " + paramInt);
      localSharedPreferences.edit().remove("" + paramInt).commit();
    }
  }
  
  public static void removeGesturePwd()
  {
    SharedPreferences.Editor localEditor = QMApplicationContext.sharedInstance().getSharedPreferences("gesturesetting", 0).edit();
    localEditor.remove("gesturepwd");
    localEditor.commit();
    setGesturePswEnabled(false);
    QMLog.log(4, TAG, "removeGesturePwd");
  }
  
  public static void removeLocalHostIp()
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().remove("localHostIp").commit();
  }
  
  public static void saveAppWidgetSize(int paramInt1, int paramInt2)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putInt("" + paramInt1, paramInt2).commit();
  }
  
  public static void setAccountListChanged(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putBoolean("accountListChanged", paramBoolean).commit();
    QMLog.log(4, TAG, "setAccountListChanged:" + paramBoolean);
  }
  
  public static void setAccountPasswordState(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putInt("accountpwdstate", paramInt).commit();
    QMLog.log(4, TAG, "setAccountPasswordState:" + paramInt);
  }
  
  public static void setActiveSyncAliveTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("time_sum_prefs", 0).edit().putLong("activesyncalivetime", paramLong).commit();
  }
  
  public static void setAttachDownloadCountReport(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("attach", 0).edit().putBoolean("is_attach_download_count_report", paramBoolean).commit();
  }
  
  public static void setAutoSubmitUmaLogTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putLong("autoSubmitUmaLogTime", paramLong).commit();
    QMLog.log(4, TAG, "setAutoSubmitUmaLogTime:" + paramLong);
  }
  
  public static void setBadgeIncrement(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).edit().putBoolean("is_Badge_Increment", paramBoolean).commit();
  }
  
  public static void setBadgeOpen(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).edit().putBoolean("has_Badge_Open", paramBoolean).commit();
  }
  
  public static void setBadgeSupport(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).edit().putBoolean("is_Badge_Support", paramBoolean).commit();
  }
  
  public static void setBlackNameListTipsHasShow(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("namelist", 0).edit().putBoolean("has_black_name_list_tips_show", paramBoolean).commit();
  }
  
  public static void setBottleSpamHashClose(String paramString, int paramInt, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    Object localObject = localSharedPreferences.getString("bottle_spam", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((String)localObject).split(";");
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      String[] arrayOfString = str.split(",");
      if ((arrayOfString[0].equals(paramString)) && (Integer.valueOf(arrayOfString[1]).intValue() == paramInt)) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(str).append(";");
      }
    }
    localStringBuilder.append(paramString).append(",").append(paramInt).append(",").append(paramBoolean).append(";");
    localSharedPreferences.edit().putString("bottle_spam", localStringBuilder.toString()).commit();
  }
  
  public static void setCalendarEnterCount(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putInt("calendarEnterCount", paramInt).commit();
  }
  
  public static void setCalendarWidgetMonth(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putInt("calendar_widget_month", paramInt).commit();
  }
  
  public static void setCalendarWidgetYear(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putInt("calendar_widget_year", paramInt).commit();
  }
  
  public static void setCardSendContactHashMap(ConcurrentHashMap<String, Long> paramConcurrentHashMap)
  {
    if (paramConcurrentHashMap == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      String str = (String)localEntry.getKey();
      long l = ((Long)localEntry.getValue()).longValue();
      localStringBuilder.append(str).append(",").append(l).append(";");
    }
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putString("cardSendContact", localStringBuilder.toString()).commit();
  }
  
  public static void setCrashCountOfCompose(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("compose_crash", 0).edit().putInt("crash_count_of_compose", paramInt).commit();
  }
  
  public static void setCreateContextTime()
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putLong("create_context_time", System.currentTimeMillis()).commit();
  }
  
  public static void setCreditCardBillDetail(String paramString1, String paramString2)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static void setCreditCardBillRemindDate(String paramString, int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).edit().putInt(paramString, paramInt).apply();
  }
  
  public static void setCreditCardBillRemindInnerRedPoint()
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).edit().putBoolean("inner_redpoint", true).commit();
  }
  
  public static void setCreditCardBillRemindOutterRedPoint()
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).edit().putBoolean("outter_redpoint", true).commit();
  }
  
  public static void setCreditCardDialogAccept(int paramInt, boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).edit().putBoolean("credit_accept" + paramInt, paramBoolean).apply();
  }
  
  public static void setCreditCardDialogShown(int paramInt, boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).edit().putBoolean("credit_dialog" + paramInt, paramBoolean).apply();
  }
  
  public static void setDebuglogSendRequestStatus(String paramString)
  {
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    if (paramString.equals("http")) {
      localSharedPreferences.edit().putBoolean("sendrequestend_http", true).commit();
    }
    while (!paramString.equals("https")) {
      return;
    }
    localSharedPreferences.edit().putBoolean("sendrequestend_https", true).commit();
  }
  
  public static void setDeviceLockState(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putInt("devicelock", paramInt).commit();
    QMLog.log(4, TAG, "setDeviceLockState:" + paramInt);
  }
  
  public static void setEnableCalendarWidget(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putBoolean("is_enable_calendar_widget", paramBoolean).commit();
  }
  
  public static void setEnableInboxWidget(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putBoolean("is_enable_inbox_widget", paramBoolean).commit();
  }
  
  public static void setEnableMonthWidget(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putBoolean("is_enable_month_widget", paramBoolean).commit();
  }
  
  public static void setEnableNoteWidget(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putBoolean("is_enable_note_list_widget", paramBoolean).commit();
  }
  
  public static void setEnterFolderCnt(int paramInt1, int paramInt2, int paramInt3)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("foldertop", 0).edit().putInt("enterFolder" + paramInt1 + "_" + paramInt2, paramInt3).commit();
  }
  
  public static void setEnterFolderCntWhenMultiAccount(int paramInt1, int paramInt2, int paramInt3)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("foldertop", 0).edit().putInt("enterFolderWhenMultiAccount" + paramInt1 + "_" + paramInt2, paramInt3).commit();
  }
  
  public static void setExistedCalendarWidget(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putBoolean("is_exist_calendar_widget", paramBoolean).commit();
  }
  
  public static void setExistedInboxWidget(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putBoolean("is_exist_note_widget", paramBoolean).commit();
  }
  
  public static void setExistedMonthWidget(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putBoolean("is_exist_month_widget", paramBoolean).commit();
  }
  
  public static void setExistedNoteWidget(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putBoolean("is_exist_note_widget", paramBoolean).commit();
  }
  
  public static void setFingerprintLastFailTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("fingerprint", 0).edit().putLong("fingerprint_last_fail_mill", paramLong).commit();
  }
  
  public static void setFingerprintOpen(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("fingerprint", 0).edit().putBoolean("is_fingerprint_open", paramBoolean).commit();
  }
  
  public static void setFingerprintRetryTimes(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("fingerprint", 0).edit().putInt("fingerprint_retry", paramInt).commit();
  }
  
  public static void setFingerprintUnlockTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("fingerprint", 0).edit().putLong("fingerprint_unlock_mill", paramLong).commit();
  }
  
  public static void setFolderLongClicTipHasShow(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putBoolean("folderLongClicTipHasShow", paramBoolean).commit();
  }
  
  public static void setFolderShowHomeHaveTip(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("foldertop", 0).edit().putBoolean("folder_show_home_havetip", paramBoolean).commit();
  }
  
  public static void setFolderTopHaveTip(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("foldertop", 0).edit().putBoolean("folder_top_havetip", paramBoolean).commit();
  }
  
  public static void setGesturePasswordShowTrack(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = QMApplicationContext.sharedInstance().getSharedPreferences("gesturesetting", 0).edit();
    localEditor.putBoolean("GesturePasswordShowTrack", paramBoolean);
    localEditor.apply();
  }
  
  public static void setGesturePswEnabled(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = QMApplicationContext.sharedInstance().getSharedPreferences("gesturesetting", 0).edit();
    localEditor.putBoolean("isGesturePswEnabled", paramBoolean);
    localEditor.commit();
    QMLog.log(4, TAG, "setGesturePswEnabled:" + paramBoolean);
  }
  
  public static boolean setGesturePwd(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    SharedPreferences.Editor localEditor = QMApplicationContext.sharedInstance().getSharedPreferences("gesturesetting", 0).edit();
    localEditor.putString("gesturepwd", Aes.encode(paramString, Aes.getIMEIKey()));
    localEditor.commit();
    setGesturePswEnabled(true);
    return true;
  }
  
  public static void setHasCheckBadgeSupport(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).edit().putBoolean("has_check_Badge_Support", paramBoolean).commit();
  }
  
  public static void setHasLastPushAdvertiseImage(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("advertise", 0).edit().putBoolean("last_push_advertise_image", paramBoolean).commit();
  }
  
  public static void setInitLocalDomainConfig()
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putInt("isInitLocalDomainConfig", 1).commit();
  }
  
  public static void setInitUninstallWatchProcessTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putLong("inituninstalltime", paramLong).commit();
  }
  
  public static void setJourneyDialogAccept(int paramInt, boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("journey", 0).edit().putBoolean("journey_accept" + paramInt, paramBoolean).apply();
  }
  
  public static void setJourneyDialogShown(int paramInt, boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).edit().putBoolean("journey_dialog" + paramInt, paramBoolean).apply();
  }
  
  public static void setJourneyRemindDate(String paramString, int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("journey", 0).edit().putInt(paramString, paramInt).apply();
  }
  
  public static void setLastCollectPreviewTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("image_scan", 0).edit().putLong("last_image_collect_time", paramLong).commit();
  }
  
  public static void setLocalHostIp(ConcurrentHashMap<String, List<String>> paramConcurrentHashMap)
  {
    if (paramConcurrentHashMap == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramConcurrentHashMap.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (List)((Map.Entry)localObject2).getValue();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localStringBuilder.append((String)localObject1);
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localStringBuilder.append(",").append((String)localObject2);
        }
        localStringBuilder.append(";");
      }
    }
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putString("localHostIp", localStringBuilder.toString()).commit();
  }
  
  public static void setLocalSyncAliveTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("time_sum_prefs", 0).edit().putLong("localsyncalivetime", paramLong).commit();
  }
  
  public static void setLoginSvrUTC(long paramLong)
  {
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    localSharedPreferences.edit().putLong("loginsvrutc", paramLong).commit();
    long l = new Date().getTime() / 1000L;
    localSharedPreferences.edit().putLong("loginsvrutcsavetime", l).commit();
    QMLog.log(4, TAG, "setLoginSvrUTC:" + paramLong + "," + l);
  }
  
  public static void setMainPid(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putInt("downloadpid", paramInt).commit();
  }
  
  public static void setNightMode(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).edit().putBoolean("is_in_night_mode", paramBoolean).commit();
  }
  
  public static void setNightModeAllDay(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).edit().putBoolean("is_night_mode_allday", paramBoolean).commit();
  }
  
  public static void setNightModeEndTime(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).edit().putInt("night_mode_endtime", paramInt).commit();
  }
  
  public static void setNightModeHaveTip(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).edit().putBoolean("night_mode_havetip", paramBoolean).commit();
  }
  
  public static void setNightModeStartTime(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).edit().putInt("night_mode_starttime", paramInt).commit();
  }
  
  public static void setNightModeTemperature(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("nightmode", 0).edit().putInt("night_mode_temperature", paramInt).commit();
  }
  
  public static void setNormalCreditCardBill(String paramString)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("creditcardbill", 0).edit().putBoolean("normal_credit_card_bill" + paramString, true).commit();
  }
  
  public static void setNoteEnterCount(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putInt("noteEnterCount", paramInt).commit();
  }
  
  public static void setOutOfSightHasNewIdentify(String paramString)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("outOfSightHasNew", 0).edit().putString("outOfSight_Has_New", paramString).commit();
  }
  
  public static void setPullAdvertiseCrashGuardLastValue(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("advertise", 0).edit().putInt("push_advertise_crash_guard_last_value", paramInt).commit();
  }
  
  public static void setPullAdvertiseImageMd5(String paramString)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("advertise", 0).edit().putString("push_advertise_image_md5", paramString).commit();
  }
  
  public static void setPushProcessAliveTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("webpush_push_info", 0).edit().putLong("pushalivetime", paramLong).commit();
  }
  
  public static void setRationalTimes(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("permission", 0).edit().putInt("last_rational_result", paramInt).commit();
  }
  
  public static void setReportIfBadgeSupport(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("badge", 0).edit().putBoolean("has_Report_If_Badge_Support", paramBoolean).commit();
  }
  
  public static void setScreenOnSubmitLogTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putLong("screenOnSubmitLog", paramLong).commit();
  }
  
  public static void setShownWelcomePage(boolean paramBoolean)
  {
    defaultSharePreference.edit().putBoolean("shown_welcome_page", paramBoolean).apply();
  }
  
  public static void setSyncAccountList(Set<String> paramSet)
  {
    Log.i(TAG, "write account list " + paramSet);
    String str = QMAppInterface.sharedInstance().getUin();
    defaultSharePreference.edit().putStringSet(str + "sync_account_list", paramSet).commit();
  }
  
  public static void setSyncSystemCalendarTipCount(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putInt("syncSystemCalendarShowTipCount", paramInt).commit();
  }
  
  public static void setWebviewDebug(boolean paramBoolean)
  {
    defaultSharePreference.edit().putBoolean("webview_debug_mode", paramBoolean).apply();
  }
  
  public static void setWelcomeSplash(String paramString)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putString("welcomesplash", paramString).commit();
    QMLog.log(4, TAG, "set welcomesplash:" + paramString);
  }
  
  public static void setWhiteNameListTipsHasShow(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("namelist", 0).edit().putBoolean("has_white_name_list_tips_show", paramBoolean).commit();
  }
  
  public static void setWidgetScheduleHash(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("widget", 0).edit().putInt("hash", paramInt).commit();
  }
  
  public static void setWtlogin(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putBoolean("wtlogin", paramBoolean).commit();
    QMLog.log(4, TAG, "set wtlogin:" + paramBoolean);
  }
  
  public static void setX5CoreInitCount(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("qqbrowser", 0).edit().putInt("x5_core_init_count", paramInt).commit();
  }
  
  public static void setX5CoreInitFinished(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("qqbrowser", 0).edit().putBoolean("x5_core_init", paramBoolean).commit();
  }
  
  public static void setX5CoreInitThreeCrashLog(String paramString)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("qqbrowser", 0).edit().putString("x5_core_init_three_crash_log", paramString).commit();
  }
  
  public static void setX5CoreNextInitTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("qqbrowser", 0).edit().putLong("x5_core_init_time", paramLong).commit();
  }
  
  public static void setXQQWXShowLastTime(long paramLong)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putLong("xqqwxlasttime", paramLong).commit();
    QMLog.log(4, TAG, "setXQQWXShowLastTime:" + paramLong);
  }
  
  public static void turnOnMainThreadMonitor(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("default_preference_name", 0).edit().putBoolean("main_looper_monitor", paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil
 * JD-Core Version:    0.7.0.1
 */