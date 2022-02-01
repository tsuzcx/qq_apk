package com.tencent.android.tpush;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.b;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.LoggerInterface;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.RECEIVERCHECK, com.jg.EType.INTENTCHECK})
public class XGPushConfig
{
  public static final String TPUSH_ACCESS_CHANNAL = "XG_V4_CHANNEL_ID";
  public static final String TPUSH_ACCESS_ID = "XG_V2_ACCESS_ID";
  public static final String TPUSH_ACCESS_KEY = "XG_V2_ACCESS_KEY";
  public static final String TPUSH_IS_FOREIGINPUSH = "TPUSH_IS_FOREIGINPUSH";
  public static boolean _isHuaweiDebug = false;
  private static String a;
  private static String b;
  private static boolean c;
  private static String d;
  private static long e;
  public static Boolean enableApplist;
  public static boolean enableDebug = false;
  public static Boolean enableLocation = null;
  public static Boolean enableNotification;
  private static Boolean f;
  public static Boolean fcmIsSuccess;
  private static Boolean g;
  private static Boolean h;
  private static SharedPreferences i = null;
  public static Boolean isUsedFcmPush;
  public static Boolean isUsedOtherPush;
  public static String notificationChannelID;
  public static String notificationChannelName;
  
  static
  {
    a = "";
    b = "";
    c = true;
    d = "";
    e = -1L;
    f = null;
    enableApplist = null;
    enableNotification = null;
    isUsedOtherPush = null;
    isUsedFcmPush = null;
    fcmIsSuccess = null;
    h = null;
  }
  
  public static void changeHuaweiBadgeNum(Context paramContext, int paramInt)
  {
    b.a(paramContext, paramInt);
  }
  
  public static void enableDebug(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      enableDebug = paramBoolean;
      CommonWorkingThread.getInstance().execute(new XGPushConfig.1(paramContext, paramBoolean));
    }
  }
  
  public static void enableFcmPush(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {}
    while ((isUsedFcmPush != null) && (isUsedFcmPush.booleanValue() == paramBoolean)) {
      return;
    }
    isUsedFcmPush = Boolean.valueOf(paramBoolean);
    String str = "com.tencent.android.tpush.fcm," + paramContext.getPackageName();
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      PushPreferences.putInt(paramContext, str, j);
      setNotTryFcm(paramContext, paramBoolean);
      return;
    }
  }
  
  public static void enableHuaweiV3Update(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    while (paramContext == null) {
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      TLogger.i("XGPushConfig", "enableHuaweiV3Update context not instanceof Activity, would not update");
      return;
    }
    if ((ChannelUtils.isBrandHuaWei()) || (ChannelUtils.isBrandHonor())) {
      try
      {
        Class localClass = Class.forName("com.huawei.hms.aaid.HmsInstanceId");
        localClass.getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(localClass, new Object[] { paramContext });
        return;
      }
      catch (Throwable paramContext)
      {
        TLogger.e("XGPushConfig", "enableHuaweiV3Update error, not find Hms V3 Sdk", paramContext);
        return;
      }
    }
    TLogger.i("XGPushConfig", "enableHuaweiV3Update not Huawei device");
  }
  
  public static void enableOppoNotification(Context paramContext, boolean paramBoolean)
  {
    d.a(paramContext, paramBoolean);
  }
  
  public static void enableOtherPush(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {}
    while ((isUsedOtherPush != null) && (isUsedOtherPush.booleanValue() == paramBoolean)) {
      return;
    }
    isUsedOtherPush = Boolean.valueOf(paramBoolean);
    String str = "com.tencent.android.tpush.other.push," + paramContext.getPackageName();
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      PushPreferences.putInt(paramContext, str, j);
      setNotTryFcm(paramContext, paramBoolean);
      return;
    }
  }
  
  public static void enablePullUpOtherApp(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      TLogger.ww("XGPushConfig", "context is null");
    }
    while ((f != null) && (paramBoolean == f.booleanValue())) {
      return;
    }
    f = Boolean.valueOf(paramBoolean);
    TLogger.d("XGPushConfig", "action - enablePullUpOtherApp:" + paramBoolean);
    PushPreferences.putBoolean(paramContext, "pull.up.other.app", paramBoolean);
  }
  
  public static void enableShowInMsg(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {}
    while ((g != null) && (g.booleanValue() == paramBoolean)) {
      return;
    }
    g = Boolean.valueOf(paramBoolean);
    SharePrefsUtil.setBoolean(paramContext, "com.tencent.android.tpush.inmsg.enable", paramBoolean);
  }
  
  public static long getAccessId(Context paramContext)
  {
    try
    {
      long l = XGApiConfig.getAccessId(paramContext);
      return l;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String getAccessKey(Context paramContext)
  {
    try
    {
      paramContext = XGApiConfig.getAccessKey(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static List<Long> getAccessidList(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList(2);
    if (paramContext == null) {}
    for (;;)
    {
      return localArrayList;
      long l = getAccessId(paramContext);
      if (l > 0L) {
        localArrayList.add(Long.valueOf(l));
      }
      l = XGPush4Msdk.getQQAccessId(paramContext);
      if (l > 0L) {
        localArrayList.add(Long.valueOf(l));
      }
      paramContext = CommonHelper.getMetaData(paramContext, "XG_V2_ACCESS_ID", null);
      if (paramContext != null) {
        try
        {
          l = Long.valueOf(paramContext.toString()).longValue();
          if (!localArrayList.contains(Long.valueOf(l)))
          {
            localArrayList.add(Long.valueOf(l));
            return localArrayList;
          }
        }
        catch (Throwable paramContext)
        {
          TLogger.w("XGPushConfig", "get accessId from getMetaData failed: ", paramContext);
        }
      }
    }
    return localArrayList;
  }
  
  public static long getChannelId(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      long l;
      try
      {
        l = e;
        return l;
      }
      finally {}
      if (e != -1L)
      {
        l = e;
        continue;
      }
      if (!Security.checkTpnsSecurityLibSo(paramContext))
      {
        l = e;
        continue;
      }
      if (e == -1L)
      {
        paramContext = CommonHelper.getMetaData(paramContext, "XG_V4_CHANNEL_ID", null);
        if (paramContext == null) {}
      }
      try
      {
        e = Long.valueOf(paramContext.toString()).longValue();
        if (e == -1L) {
          TLogger.d("XGPushConfig", "channelId is not empty");
        }
        l = e;
      }
      catch (Throwable paramContext)
      {
        TLogger.w("XGPushConfig", "get channelId from getMetaData failed: ", paramContext);
        e = -1L;
      }
    }
  }
  
  public static String getFacilityImei(Context paramContext)
  {
    return d;
  }
  
  public static String getGameServer(Context paramContext)
  {
    return b;
  }
  
  public static String getInstallChannel(Context paramContext)
  {
    return a;
  }
  
  public static String getNotificationChannelID(Context paramContext)
  {
    if (paramContext != null)
    {
      if ((notificationChannelID != null) && (!TextUtils.isEmpty(notificationChannelID))) {
        return notificationChannelID;
      }
      paramContext = PushPreferences.getString(paramContext, paramContext.getPackageName() + ".notification.channelID", "");
      notificationChannelID = paramContext;
      return paramContext;
    }
    return null;
  }
  
  public static String getNotificationChannelName(Context paramContext)
  {
    if (paramContext != null)
    {
      if ((notificationChannelName != null) && (!TextUtils.isEmpty(notificationChannelName))) {
        return notificationChannelName;
      }
      paramContext = PushPreferences.getString(paramContext, paramContext.getPackageName() + ".notification.channelName", "");
      notificationChannelName = paramContext;
      return paramContext;
    }
    return null;
  }
  
  public static String getOtherPushErrCode(Context paramContext)
  {
    if (paramContext == null) {
      return "errCode : -102 , errMsg : context == null";
    }
    try
    {
      isUsedOtherPush = Boolean.valueOf(isUsedOtherPush(paramContext));
      if (!isUsedOtherPush.booleanValue()) {
        return "errCode : -101 , errMsg : Manufacturer channel is not opened";
      }
      paramContext = SharePrefsUtil.getString(paramContext, "other_push_error_code", "errCode : -100 , errMsg : unknown");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      TLogger.dd("XGPushConfig", "getOtherPushErrCode error: " + paramContext.getMessage());
    }
    return "";
  }
  
  public static String getOtherPushToken(Context paramContext)
  {
    try
    {
      paramContext = d.a(paramContext).f();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("XGPushConfig", "getOtherPushToken", paramContext);
    }
    return null;
  }
  
  public static String getOtherPushType(Context paramContext)
  {
    try
    {
      paramContext = d.a(paramContext).i();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("XGPushConfig", "getOtherPushToken", paramContext);
    }
    return null;
  }
  
  public static boolean getReportDebugMode(Context paramContext)
  {
    boolean bool = false;
    if (PushPreferences.getInt(paramContext, paramContext.getPackageName() + ".report.mode", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static XGServerInfo getServerIpList(Context paramContext)
  {
    XGServerInfo localXGServerInfo = null;
    if (paramContext != null) {
      localXGServerInfo = new XGServerInfo(PushPreferences.getString(paramContext, "com.tencent.android.xg.vip.action.custom.iplist.local", null));
    }
    return localXGServerInfo;
  }
  
  public static boolean getStatAutoPage(Context paramContext)
  {
    return c;
  }
  
  public static String getToken(Context paramContext)
  {
    if (paramContext == null)
    {
      TLogger.e("XGPushConfig", "null context");
      return null;
    }
    return CacheManager.getToken(paramContext);
  }
  
  public static Build init(Context paramContext)
  {
    if (paramContext == null)
    {
      TLogger.ee("XGPushConfig", "context is null");
      return null;
    }
    return new Build(paramContext);
  }
  
  public static boolean isEnableDebug(Context paramContext)
  {
    boolean bool = false;
    if (PushPreferences.getInt(paramContext, "com.tencent.android.tpush.debug," + paramContext.getPackageName(), 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isEnableShowInMsg(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (g == null) {
      g = Boolean.valueOf(SharePrefsUtil.getBoolean(paramContext, "com.tencent.android.tpush.inmsg.enable", false));
    }
    return g.booleanValue();
  }
  
  public static boolean isForeiginPush(Context paramContext)
  {
    if (h == null) {}
    for (;;)
    {
      try
      {
        paramContext = CommonHelper.getMetaData(paramContext, "TPUSH_IS_FOREIGINPUSH", null);
        if (paramContext == null)
        {
          h = Boolean.valueOf(false);
          return h.booleanValue();
        }
        if (!"true".equals(paramContext.toString())) {
          continue;
        }
        h = Boolean.valueOf(true);
      }
      catch (Throwable paramContext)
      {
        h = Boolean.valueOf(false);
        continue;
      }
      return h.booleanValue();
      h = Boolean.valueOf(false);
    }
  }
  
  public static boolean isHuaweiDebug()
  {
    return _isHuaweiDebug;
  }
  
  public static boolean isLocationEnable(Context paramContext)
  {
    boolean bool = true;
    if (enableLocation == null) {
      if (PushPreferences.getInt(paramContext, "com.tencent.android.tpush.enable_location," + paramContext.getPackageName(), 1) == 0) {
        break label53;
      }
    }
    for (;;)
    {
      enableLocation = Boolean.valueOf(bool);
      return enableLocation.booleanValue();
      label53:
      bool = false;
    }
  }
  
  public static boolean isNotTryFcm(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    if (fcmIsSuccess == null)
    {
      if (PushPreferences.getInt(paramContext, "com.tencent.android.tpush.fcm.success," + paramContext.getPackageName(), 0) != 0) {
        bool = true;
      }
      fcmIsSuccess = Boolean.valueOf(bool);
    }
    return fcmIsSuccess.booleanValue();
  }
  
  public static boolean isNotificationShowEnable(Context paramContext)
  {
    boolean bool = true;
    if (paramContext != null) {}
    try
    {
      if (i == null) {
        i = paramContext.getSharedPreferences("xg.vip.app.shareprefs", 0);
      }
      bool = i.getBoolean(Util.getKey("com.tencent.android.tpush.enable_SHOW_NOTIFICATION"), true);
      return bool;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("XGPushConfig", "isNotificationShowEnable", paramContext);
    }
    return true;
  }
  
  public static boolean isReportApplistEnable(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1;
    if (enableApplist == null)
    {
      if (PushPreferences.getInt(paramContext, "com.tencent.android.tpush.enable_applist," + paramContext.getPackageName(), 1) != 0)
      {
        bool1 = true;
        enableApplist = Boolean.valueOf(bool1);
      }
    }
    else
    {
      if (com.tencent.android.tpush.service.a.a.a(paramContext).F != -1) {
        break label73;
      }
      bool1 = enableApplist.booleanValue();
    }
    label73:
    do
    {
      return bool1;
      bool1 = false;
      break;
      bool1 = bool2;
    } while (com.tencent.android.tpush.service.a.a.a(paramContext).F == 1);
    return false;
  }
  
  public static boolean isReportNotificationStatusEnable(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1;
    if (enableNotification == null)
    {
      if (PushPreferences.getInt(paramContext, "com.tencent.android.tpush.enable_NOTIICATION," + paramContext.getPackageName(), 1) != 0)
      {
        bool1 = true;
        enableNotification = Boolean.valueOf(bool1);
      }
    }
    else
    {
      if (com.tencent.android.tpush.service.a.a.a(paramContext).G != -1) {
        break label73;
      }
      bool1 = enableNotification.booleanValue();
    }
    label73:
    do
    {
      return bool1;
      bool1 = false;
      break;
      bool1 = bool2;
    } while (com.tencent.android.tpush.service.a.a.a(paramContext).G == 1);
    return false;
  }
  
  public static boolean isUsedFcmPush(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    if (isUsedFcmPush == null)
    {
      if (PushPreferences.getInt(paramContext, "com.tencent.android.tpush.fcm," + paramContext.getPackageName(), 0) != 0) {
        bool = true;
      }
      isUsedFcmPush = Boolean.valueOf(bool);
    }
    return isUsedFcmPush.booleanValue();
  }
  
  public static boolean isUsedOtherPush(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    if (isUsedOtherPush == null)
    {
      if (PushPreferences.getInt(paramContext, "com.tencent.android.tpush.other.push," + paramContext.getPackageName(), 0) != 0) {
        bool = true;
      }
      isUsedOtherPush = Boolean.valueOf(bool);
      if (!isUsedOtherPush.booleanValue()) {
        isUsedOtherPush = Boolean.valueOf(d.a(paramContext).b());
      }
      if (!isUsedOtherPush.booleanValue()) {
        isUsedOtherPush = Boolean.valueOf(i.n(paramContext));
      }
    }
    TLogger.v("XGPushConfig", "isUsedOtherPush:" + isUsedOtherPush);
    return isUsedOtherPush.booleanValue();
  }
  
  public static void resetBadgeNum(Context paramContext)
  {
    b.b(paramContext);
  }
  
  public static void resetHuaweiBadgeNum(Context paramContext)
  {
    b.a(paramContext);
  }
  
  public static void setAccessId(Context paramContext, long paramLong)
  {
    XGApiConfig.setAccessId(paramContext, paramLong);
  }
  
  public static void setAccessKey(Context paramContext, String paramString)
  {
    XGApiConfig.setAccessKey(paramContext, paramString);
  }
  
  public static void setBadgeNum(Context paramContext, int paramInt)
  {
    b.c(paramContext, paramInt);
  }
  
  public static void setForeiginPushEnable(Context paramContext, boolean paramBoolean) {}
  
  public static void setForeignWeakAlarmMode(Context paramContext, boolean paramBoolean)
  {
    MqttConfig.setForeignWeakAlarmMode(paramContext, paramBoolean);
  }
  
  public static void setGameServer(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() == 0)) {
      return;
    }
    b = paramString;
  }
  
  public static void setHeartbeatInterval(Context paramContext, int paramInt)
  {
    if ((paramContext != null) && (paramInt >= 10) && (paramInt < 36000)) {}
    try
    {
      MqttConfig.setKeepAliveInterval(paramContext, paramInt);
      CommonWorkingThread.getInstance().execute(new XGPushConfig.2(paramContext, paramInt));
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("XGPushConfig", "setHeartbeatInterval", paramContext);
    }
  }
  
  public static void setHeartbeatIntervalMs(Context paramContext, int paramInt)
  {
    setHeartbeatInterval(paramContext, paramInt / 1000);
  }
  
  public static void setHuaweiBadgeNum(Context paramContext, int paramInt)
  {
    b.b(paramContext, paramInt);
  }
  
  public static void setHuaweiDebug(boolean paramBoolean)
  {
    _isHuaweiDebug = paramBoolean;
  }
  
  public static void setImei(Context paramContext, String paramString)
  {
    d = paramString;
  }
  
  public static void setInstallChannel(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() == 0)) {
      return;
    }
    a = paramString;
  }
  
  public static void setLocationEnable(Context paramContext, boolean paramBoolean)
  {
    String str;
    if ((enableLocation == null) || (enableLocation.booleanValue() != paramBoolean))
    {
      enableLocation = Boolean.valueOf(paramBoolean);
      str = "com.tencent.android.tpush.enable_location," + paramContext.getPackageName();
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (int j = 1;; j = 0)
    {
      PushPreferences.putInt(paramContext, str, j);
      return;
    }
  }
  
  public static void setMiPushAppId(Context paramContext, String paramString)
  {
    d.a(paramContext, paramString);
  }
  
  public static void setMiPushAppKey(Context paramContext, String paramString)
  {
    d.b(paramContext, paramString);
  }
  
  public static void setMzPushAppId(Context paramContext, String paramString)
  {
    d.c(paramContext, paramString);
  }
  
  public static void setMzPushAppKey(Context paramContext, String paramString)
  {
    d.d(paramContext, paramString);
  }
  
  public static void setNotTryFcm(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {}
    while ((fcmIsSuccess != null) && (fcmIsSuccess.booleanValue() == paramBoolean)) {
      return;
    }
    fcmIsSuccess = Boolean.valueOf(paramBoolean);
    String str = "com.tencent.android.tpush.fcm.success," + paramContext.getPackageName();
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      PushPreferences.putInt(paramContext, str, j);
      return;
    }
  }
  
  public static void setNotificationChannelID(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      notificationChannelID = paramString;
      PushPreferences.putString(paramContext, paramContext.getPackageName() + ".notification.channelID", paramString);
    }
  }
  
  public static void setNotificationChannelName(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      notificationChannelName = paramString;
      PushPreferences.putString(paramContext, paramContext.getPackageName() + ".notification.channelName", paramString);
    }
  }
  
  public static void setNotificationShowEnable(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {}
    try
    {
      if (i == null) {
        i = paramContext.getSharedPreferences("xg.vip.app.shareprefs", 0);
      }
      paramContext = i.edit();
      paramContext.putBoolean(Util.getKey("com.tencent.android.tpush.enable_SHOW_NOTIFICATION"), paramBoolean);
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("XGPushConfig", "setNotificationShowEnable", paramContext);
    }
  }
  
  public static void setOPPOBadgeNum(Context paramContext, int paramInt)
  {
    b.d(paramContext, paramInt);
  }
  
  public static void setOppoPushAppId(Context paramContext, String paramString)
  {
    d.e(paramContext, paramString);
  }
  
  public static void setOppoPushAppKey(Context paramContext, String paramString)
  {
    d.f(paramContext, paramString);
  }
  
  public static void setPowerSaveMode(Context paramContext, boolean paramBoolean)
  {
    XGApiConfig.setPowerSaveMode(paramContext, paramBoolean);
  }
  
  public static void setReportApplistEnable(Context paramContext, boolean paramBoolean)
  {
    String str;
    if ((enableApplist == null) || (enableApplist.booleanValue() != paramBoolean))
    {
      enableApplist = Boolean.valueOf(paramBoolean);
      str = "com.tencent.android.tpush.enable_applist," + paramContext.getPackageName();
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (int j = 1;; j = 0)
    {
      PushPreferences.putInt(paramContext, str, j);
      return;
    }
  }
  
  public static void setReportDebugMode(Context paramContext, boolean paramBoolean)
  {
    String str;
    if (paramContext != null)
    {
      str = paramContext.getPackageName() + ".report.mode";
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (int j = 1;; j = 0)
    {
      PushPreferences.putInt(paramContext, str, j);
      return;
    }
  }
  
  public static void setReportNotificationStatusEnable(Context paramContext, boolean paramBoolean)
  {
    String str;
    if ((enableNotification == null) || (enableNotification.booleanValue() != paramBoolean))
    {
      enableNotification = Boolean.valueOf(paramBoolean);
      str = "com.tencent.android.tpush.enable_NOTIICATION," + paramContext.getPackageName();
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (int j = 1;; j = 0)
    {
      PushPreferences.putInt(paramContext, str, j);
      return;
    }
  }
  
  public static void setServerIpList(Context paramContext, XGServerInfo paramXGServerInfo)
  {
    if ((paramContext != null) && (paramXGServerInfo != null)) {
      PushPreferences.putString(paramContext, "com.tencent.android.xg.vip.action.custom.iplist.local", paramXGServerInfo.getIpArray().toString());
    }
  }
  
  public static void setStatAutoPage(Context paramContext, boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static void setTPushLogger(LoggerInterface paramLoggerInterface)
  {
    TBaseLogger.setLogger(paramLoggerInterface);
  }
  
  public static void setVivoBadgeNum(Context paramContext, int paramInt)
  {
    b.e(paramContext, paramInt);
  }
  
  public static void setfcmSenderId(Context paramContext, String paramString)
  {
    com.tencent.android.tpush.d.a.b(paramContext, paramString);
  }
  
  public static class Build
  {
    private Context context;
    
    public Build(Context paramContext)
    {
      this.context = paramContext.getApplicationContext();
    }
    
    public Build enableDebug(boolean paramBoolean)
    {
      XGPushConfig.enableDebug(this.context, paramBoolean);
      return this;
    }
    
    public Build enableFcmPush(boolean paramBoolean)
    {
      XGPushConfig.enableOtherPush(this.context, paramBoolean);
      return this;
    }
    
    public Build enableOtherPush(boolean paramBoolean)
    {
      XGPushConfig.enableOtherPush(this.context, paramBoolean);
      return this;
    }
    
    public Build setHuaweiDebug(boolean paramBoolean)
    {
      XGPushConfig.setHuaweiDebug(paramBoolean);
      return this;
    }
    
    public Build setLogLevel(int paramInt)
    {
      TBaseLogger.setDebugLevel(paramInt);
      CommonWorkingThread.getInstance().execute(new XGPushConfig.Build.1(this, paramInt));
      return this;
    }
    
    public Build setMiPushAppId(String paramString)
    {
      XGPushConfig.setMiPushAppId(this.context, paramString);
      return this;
    }
    
    public Build setMiPushAppKey(String paramString)
    {
      XGPushConfig.setMiPushAppKey(this.context, paramString);
      return this;
    }
    
    public Build setMzPushAppId(String paramString)
    {
      XGPushConfig.setMzPushAppId(this.context, paramString);
      return this;
    }
    
    public Build setMzPushAppKey(String paramString)
    {
      XGPushConfig.setMzPushAppKey(this.context, paramString);
      return this;
    }
    
    public Build setOppoPushAppId(String paramString)
    {
      XGPushConfig.setOppoPushAppId(this.context, paramString);
      return this;
    }
    
    public Build setOppoPushAppKey(String paramString)
    {
      XGPushConfig.setOppoPushAppKey(this.context, paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushConfig
 * JD-Core Version:    0.7.0.1
 */