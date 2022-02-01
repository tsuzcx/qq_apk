package com.tencent.android.tpush;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.Set;

public class XGPush4Msdk
{
  private static long a = 0L;
  private static long b = 0L;
  private static String c = "";
  
  private static boolean a(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 >= paramLong2) && (paramLong1 < paramLong3);
  }
  
  public static long addLocalNotification(Context paramContext, XGLocalMessage paramXGLocalMessage)
  {
    if (XGPushConfig.enableDebug) {
      TLogger.i("XGPush4Msdk", "addLocalNotification:msg=" + paramXGLocalMessage.toString() + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(paramContext));
    }
    return XGPushManager.a(paramContext, paramXGLocalMessage, getQQAccessId(paramContext));
  }
  
  public static void addTags(Context paramContext, String paramString, Set<String> paramSet)
  {
    if (XGPushConfig.enableDebug) {
      TLogger.d("XGPush4Msdk", "addTags: operateName=" + paramString + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(paramContext));
    }
    if ((paramContext == null) || (paramSet == null) || (paramSet.isEmpty()))
    {
      TLogger.ee("XGPush4Msdk", "the parameter context or tags of addTags is invalid.");
      return;
    }
    paramSet = XGPushManager.a(paramSet, "addTags");
    if (paramSet == null)
    {
      TLogger.ee("XGPush4Msdk", "addTags -> getTagsFromSet return null!!!");
      return;
    }
    if (XGPushConfig.enableDebug) {
      TLogger.ii("XGPush4Msdk", "addTags -> setTags with all tags = " + paramSet);
    }
    XGPushManager.a(paramContext, paramSet, 5, getQQAccessId(paramContext), getQQAppKey(paramContext), paramString);
  }
  
  private static String b(Context paramContext)
  {
    return paramContext.getPackageName() + ":" + "XG_DEBUG_SERVER_INFO";
  }
  
  public static void cleanTags(Context paramContext, String paramString)
  {
    if (XGPushConfig.enableDebug) {
      TLogger.d("XGPush4Msdk", "cleanTags: operateName=" + paramString + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(paramContext));
    }
    if (paramContext == null)
    {
      TLogger.ee("XGPush4Msdk", "the parameter context of cleanTags is invalid");
      return;
    }
    if (XGPushConfig.enableDebug) {
      TLogger.ii("XGPush4Msdk", "Action -> cleanTags");
    }
    XGPushManager.a(paramContext, "*", 8, getQQAccessId(paramContext), getQQAppKey(paramContext), paramString);
  }
  
  public static void deleteTag(Context paramContext, String paramString)
  {
    if (XGPushConfig.enableDebug) {
      TLogger.d("XGPush4Msdk", "deleteTag: tagName=" + paramString + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(paramContext));
    }
    XGPushManager.a(paramContext, paramString, 2, getQQAccessId(paramContext), getQQAppKey(paramContext), paramString);
  }
  
  public static void deleteTags(Context paramContext, String paramString, Set<String> paramSet)
  {
    if (XGPushConfig.enableDebug) {
      TLogger.d("XGPush4Msdk", "deleteTags: operateName=" + paramString + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(paramContext));
    }
    if ((paramContext == null) || (paramSet == null) || (paramSet.isEmpty()))
    {
      TLogger.ee("XGPush4Msdk", "the parameter context or tags of deleteTags is invalid.");
      return;
    }
    paramSet = XGPushManager.a(paramSet, "deleteTags");
    if (paramSet == null)
    {
      TLogger.ee("XGPush4Msdk", "deleteTags -> getTagsFromSet return null!!!");
      return;
    }
    if (XGPushConfig.enableDebug) {
      TLogger.ii("XGPush4Msdk", "deleteTags -> setTags with all tags = " + paramSet);
    }
    XGPushManager.a(paramContext, paramSet, 7, getQQAccessId(paramContext), getQQAppKey(paramContext), paramString);
  }
  
  public static String getDebugServerInfo(Context paramContext)
  {
    return PushPreferences.getString(paramContext, b(paramContext), null);
  }
  
  public static long getQQAccessId(Context paramContext)
  {
    if (b <= 0L) {
      b = PushPreferences.getLong(paramContext, "TPUSH_QQ_ACCESS_ID", b);
    }
    return b;
  }
  
  public static String getQQAppKey(Context paramContext)
  {
    if (!TextUtils.isEmpty(c)) {
      return c;
    }
    String str = PushPreferences.getString(paramContext, "__en__TPUSH_QQ_ACCESS_KEY", c);
    if (!TextUtils.isEmpty(str)) {
      c = Rijndael.decrypt(str);
    }
    for (;;)
    {
      return c;
      c = PushPreferences.getString(paramContext, "TPUSH_QQ_ACCESS_KEY", "");
      PushPreferences.putString(paramContext, "TPUSH_QQ_ACCESS_KEY", "");
    }
  }
  
  public static boolean isDebugServerInfoStrategyItem(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = getDebugServerInfo(com.tencent.android.tpush.service.b.e());
      boolean bool1 = bool2;
      if (!i.b(paramContext))
      {
        paramContext = paramContext.split(",");
        bool1 = bool2;
        if (paramContext.length == 2)
        {
          int i = paramContext[0].length();
          bool1 = bool2;
          if (i > 4) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("XGPush4Msdk", " .isDebugServerInfoStrategyItem", paramContext);
    }
    return false;
  }
  
  public static void registerPush(Context paramContext, XGIOperateCallback paramXGIOperateCallback)
  {
    if (XGPushConfig.enableDebug) {
      TLogger.i("XGPush4Msdk", "registerPush=,qqAppid=" + a + ",xg_accessid=" + getQQAccessId(paramContext));
    }
    if (paramXGIOperateCallback == null) {
      paramXGIOperateCallback = new XGPush4Msdk.2();
    }
    for (;;)
    {
      XGPushManager.a(paramContext, null, -1, null, paramXGIOperateCallback, getQQAccessId(paramContext), getQQAppKey(paramContext), null, null, null);
      return;
    }
  }
  
  public static void setDebugServerInfo(Context paramContext, String paramString, int paramInt)
  {
    if (!i.b(paramString))
    {
      PushPreferences.putString(paramContext, b(paramContext), paramString + "," + paramInt);
      return;
    }
    CommonWorkingThread.getInstance().execute(new XGPush4Msdk.1(paramContext));
  }
  
  public static void setDefaultNotificationBuilder(Context paramContext, XGPushNotificationBuilder paramXGPushNotificationBuilder)
  {
    XGPushManager.setDefaultNotificationBuilder(paramContext, paramXGPushNotificationBuilder);
  }
  
  public static void setPushNotificationBuilder(Context paramContext, int paramInt, XGPushNotificationBuilder paramXGPushNotificationBuilder)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context is null.");
    }
    if ((paramInt < 5000) || (paramInt > 6000)) {
      throw new IllegalArgumentException("notificationBulderId超过范围[5000, 6000].");
    }
    if (paramXGPushNotificationBuilder == null) {
      return;
    }
    com.tencent.android.tpush.message.b.a(paramContext, paramInt, paramXGPushNotificationBuilder);
  }
  
  public static void setQQAppId(Context paramContext, long paramLong)
  {
    long l;
    if (a(paramLong, 0L, 200000L)) {
      l = 90000000L;
    }
    for (;;)
    {
      a = paramLong;
      b = l + 2100000000L + paramLong;
      PushPreferences.putLong(paramContext, "TPUSH_QQ_ACCESS_ID", b);
      PushPreferences.remove(paramContext, "TPUSH_QQ_APP_ID");
      c = "MSDK_" + paramLong;
      PushPreferences.putString(paramContext, "__en__TPUSH_QQ_ACCESS_KEY", Rijndael.encrypt(c));
      PushPreferences.remove(paramContext, "TPUSH_QQ_ACCESS_KEY");
      return;
      if (a(paramLong, 99000000L, 100000000L))
      {
        l = 0L;
      }
      else if (a(paramLong, 100200000L, 100600000L))
      {
        l = -10000000L;
      }
      else if (a(paramLong, 101000000L, 101400000L))
      {
        l = -10400000L;
      }
      else if (a(paramLong, 900000000L, 900100000L))
      {
        l = -809000000L;
      }
      else if (a(paramLong, 1000000000L, 1000100000L))
      {
        l = -908900000L;
      }
      else if (a(paramLong, 1101000000L, 1104500000L))
      {
        l = -1009800000L;
      }
      else if (a(paramLong, 1150000000L, 1150100000L))
      {
        l = -1055300000L;
      }
      else if (a(paramLong, 100600000L, 101000000L))
      {
        l = -5800000L;
      }
      else if (a(paramLong, 1104500000L, 1109300000L))
      {
        l = -1009300000L;
      }
      else if (a(paramLong, 1109300000L, 1119300000L))
      {
        l = -1029300000L;
      }
      else if (a(paramLong, 1119300000L, 1120000000L))
      {
        l = -1049300000L;
      }
      else
      {
        TLogger.e("XGPush4Msdk", "手Q的appid：" + paramLong + " 不在固定的范围，请联系msdk和信鸽的同事解决之。");
        l = 0L;
      }
    }
  }
  
  public static void setQQAppKey(Context paramContext, String paramString) {}
  
  public static void setTag(Context paramContext, String paramString)
  {
    TLogger.d("XGPush4Msdk", "setTag: tagName=" + paramString + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(paramContext));
    XGPushManager.a(paramContext, paramString, 1, getQQAccessId(paramContext), getQQAppKey(paramContext), paramString);
  }
  
  public static void setTags(Context paramContext, String paramString, Set<String> paramSet)
  {
    if (XGPushConfig.enableDebug) {
      TLogger.d("XGPush4Msdk", "setTags: operateName=" + paramString + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(paramContext));
    }
    if ((paramContext == null) || (paramSet == null) || (paramSet.isEmpty()))
    {
      TLogger.ee("XGPush4Msdk", "the parameter context or tags of setTags is invalid.");
      return;
    }
    paramSet = XGPushManager.a(paramSet, "setTags");
    if (paramSet == null)
    {
      TLogger.ee("XGPush4Msdk", "setTags -> getTagsFromSet return null!!!");
      return;
    }
    TLogger.ii("XGPush4Msdk", "Action -> setTags with all tags = " + paramSet);
    XGPushManager.a(paramContext, paramSet, 6, getQQAccessId(paramContext), getQQAppKey(paramContext), paramString);
  }
  
  public static void unregisterPush(Context paramContext, XGIOperateCallback paramXGIOperateCallback)
  {
    if (XGPushConfig.enableDebug) {
      TLogger.i("XGPush4Msdk", "unregisterPush,qqAppid=" + a + ",xg_accessid=" + getQQAccessId(paramContext));
    }
    if (paramXGIOperateCallback == null) {
      paramXGIOperateCallback = new XGPush4Msdk.3();
    }
    for (;;)
    {
      XGPushManager.a(paramContext, paramXGIOperateCallback, getQQAccessId(paramContext), getQQAppKey(paramContext), null, null, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPush4Msdk
 * JD-Core Version:    0.7.0.1
 */