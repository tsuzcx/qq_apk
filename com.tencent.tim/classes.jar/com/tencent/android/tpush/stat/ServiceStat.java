package com.tencent.android.tpush.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.f.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.PushStatClientReport;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.android.tpush.stat.event.MQTTEvent;
import com.tencent.android.tpush.stat.event.g;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ServiceStat
{
  public static final String ACCOUNT_EVENT_ID = "SdkAccount";
  public static final String ACK_EVENT_ID = "Ack";
  public static final String APP_LIST_EVENT_ID = "app_list";
  public static final int EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED = 129;
  public static final int EnumPushAction_PUSH_ACTION_MOBILE_APP_RECEIVED = 8;
  public static final int EnumPushAction_PUSH_ACTION_MOBILE_CLEAN_UP = 64;
  public static final int EnumPushAction_PUSH_ACTION_MOBILE_REVOKE_MESSAGE_SERVICE_RECEIVED = 2048;
  public static final int EnumPushAction_PUSH_ACTION_MOBILE_SERVICE_RECEIVED = 4;
  public static final int EnumPushAction_PUSH_ACTION_MOBILE_SHOW = 128;
  public static final int EnumPushAction_PUSH_ACTION_MOBILE_USER_CLICK = 16;
  public static final int EnumPushChannel = 0;
  public static final int EnumPushChannel_CHANNEL_FCM = 101;
  public static final int EnumPushChannel_CHANNEL_HUAWEI = 102;
  public static final int EnumPushChannel_CHANNEL_LOCAL = 99;
  public static final int EnumPushChannel_CHANNEL_MEIZU = 106;
  public static final int EnumPushChannel_CHANNEL_OPPO = 105;
  public static final int EnumPushChannel_CHANNEL_VIVO = 104;
  public static final int EnumPushChannel_CHANNEL_XG = 100;
  public static final int EnumPushChannel_CHANNEL_XIAOMI = 103;
  public static final String FAILED_CNT = "failed_cnt";
  public static final String HEARTBEAT_EVENT_ID = "SdkHeartbeat";
  public static final String IS_CUSTOMDATA_VERSION_EVENT_ID = "IsCustomDataVersion";
  public static final String LAST_REPORT_APPLIST = "last_reportAppList_time";
  public static final String LAST_REPORT_NOTIFICATION = "last_reportNotification_time";
  public static final String NETWORKTYOE = "np";
  public static final String NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID = "Action";
  public static final String NOTIFICATION_STATUS_EVENT_ID = "notification_st";
  public static final String REGISTER_EVENT_ID = "SdkRegister";
  public static final String SDK_ACK_EVENT_ID = "SdkAck";
  public static final String SDK_OTHER_PULLUP_ID = "OtherPull";
  public static final String SERVICE_EVENT_ID = "SdkService";
  public static final String SHOW_EVENT_ID = "SHOW";
  public static final String SRV_ACK_EVENT_ID = "SrvAck";
  public static final String STRATTIME = "failed_cnt";
  public static final String SUCC_CNT = "suc_cnt";
  public static final String UNREGISTER_EVENT_ID = "SdkUnRegister";
  public static final String VERIFY_EVENT_ID = "Verify";
  public static AtomicBoolean _isInited = new AtomicBoolean(false);
  private static Context a = null;
  private static boolean b = false;
  private static volatile a c = null;
  
  private static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    if ((paramIntent == null) || (paramInt < 0))
    {
      TLogger.e("ServiceStat", "intent = null or evendId < 0 ");
      return;
    }
    init(paramContext);
    for (;;)
    {
      try
      {
        long l4 = paramIntent.getLongExtra("msgId", 0L);
        long l5 = paramIntent.getLongExtra("type", 1L);
        long l3 = paramIntent.getLongExtra("busiMsgId", 0L);
        long l2 = paramIntent.getLongExtra("accId", 0L);
        Object localObject2 = paramIntent.getStringExtra("groupId");
        Object localObject1 = localObject2;
        if (i.b((String)localObject2)) {
          localObject1 = paramIntent.getStringExtra("group_id");
        }
        l1 = l2;
        if (l2 == 0L) {
          l1 = XGApiConfig.getAccessId(a);
        }
        localObject2 = new MQTTEvent(paramContext.getApplicationContext(), l1);
        ((MQTTEvent)localObject2).msgId = l4;
        ((MQTTEvent)localObject2).msgType = l5;
        ((MQTTEvent)localObject2).timestamp = (System.currentTimeMillis() / 1000L);
        if (!i.b((String)localObject1)) {
          ((MQTTEvent)localObject2).nGroupId = ((String)localObject1);
        }
        ((MQTTEvent)localObject2).pushChannel = paramIntent.getIntExtra("pushChannel", -1);
        if ((((MQTTEvent)localObject2).pushChannel == 100) || ((a.a(paramContext)) && (((MQTTEvent)localObject2).pushChannel == a.a())))
        {
          l1 = paramIntent.getLongExtra("timestamps", 0L);
          ((MQTTEvent)localObject2).pushAction = paramInt;
          ((MQTTEvent)localObject2).msgBusiId = l3;
          ((MQTTEvent)localObject2).pushtime = (l1 / 1000L);
          ((MQTTEvent)localObject2).token = GuidInfoManager.getToken(paramContext.getApplicationContext());
          ((MQTTEvent)localObject2).sdkVersion = "1.2.7.3";
          ((MQTTEvent)localObject2).appVersion = com.tencent.android.tpush.stat.b.b.c(paramContext);
          ((MQTTEvent)localObject2).targetType = paramIntent.getLongExtra("targetType", 0L);
          ((MQTTEvent)localObject2).source = paramIntent.getLongExtra("source", 0L);
          ((MQTTEvent)localObject2).templateId = paramIntent.getStringExtra("templateId");
          ((MQTTEvent)localObject2).traceId = paramIntent.getStringExtra("traceId");
          localObject1 = paramIntent.getStringExtra("inapp_custom_event_id");
          if (!i.b((String)localObject1))
          {
            ((MQTTEvent)localObject2).eventId = ((String)localObject1);
            paramInt = paramIntent.getIntExtra("inapp_button_event_id", 0);
            paramIntent = new Properties();
            paramIntent.put("BUTTON_ID", String.valueOf(paramInt));
            ((MQTTEvent)localObject2).prop = new JSONObject(paramIntent);
          }
          StatServiceImpl.reportXGEvent(paramContext.getApplicationContext(), (Event)localObject2);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.e("ServiceStat", "reportSDKAck", paramContext);
        return;
      }
      long l1 = paramIntent.getLongExtra("pushTime", 0L);
    }
  }
  
  public static void appReportInMsgUserDisabled(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, 129);
  }
  
  public static void appReportNotificationCleared(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, 64);
  }
  
  public static void appReportNotificationClicked(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, 16);
  }
  
  public static void appReportNotificationShowed(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, 128);
  }
  
  public static void appReportPullupAck(Context paramContext, Intent paramIntent) {}
  
  public static void appReportRevokeMessageServiceReceived(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, 2048);
  }
  
  public static void appReportSDKReceived(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, 8);
  }
  
  public static void appReportServiceReceived(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, 4);
  }
  
  public static void commit()
  {
    StatServiceImpl.commitEvents(a, -1);
  }
  
  public static void debug(boolean paramBoolean)
  {
    d.a(paramBoolean);
  }
  
  /* Error */
  public static void init(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 125	com/tencent/android/tpush/stat/ServiceStat:_isInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +7 -> 18
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: iconst_1
    //   19: invokestatic 344	com/tencent/android/tpush/stat/d:c	(Z)V
    //   22: getstatic 350	com/tencent/android/tpush/stat/StatReportStrategy:INSTANT	Lcom/tencent/android/tpush/stat/StatReportStrategy;
    //   25: invokestatic 353	com/tencent/android/tpush/stat/d:a	(Lcom/tencent/android/tpush/stat/StatReportStrategy;)V
    //   28: aload_0
    //   29: invokestatic 356	com/tencent/android/tpush/stat/StatServiceImpl:setContext	(Landroid/content/Context;)V
    //   32: aload_0
    //   33: invokestatic 360	com/tencent/android/tpush/stat/StatServiceImpl:getHandler	(Landroid/content/Context;)Landroid/os/Handler;
    //   36: pop
    //   37: aload_0
    //   38: invokevirtual 186	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   41: putstatic 113	com/tencent/android/tpush/stat/ServiceStat:a	Landroid/content/Context;
    //   44: getstatic 117	com/tencent/android/tpush/stat/ServiceStat:c	Lcom/tencent/android/tpush/stat/ServiceStat$a;
    //   47: ifnonnull +51 -> 98
    //   50: ldc 133
    //   52: ldc_w 362
    //   55: invokestatic 365	com/tencent/android/tpush/logging/TLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: new 6	com/tencent/android/tpush/stat/ServiceStat$a
    //   61: dup
    //   62: aconst_null
    //   63: invokespecial 368	com/tencent/android/tpush/stat/ServiceStat$a:<init>	(Lcom/tencent/android/tpush/stat/ServiceStat$1;)V
    //   66: putstatic 117	com/tencent/android/tpush/stat/ServiceStat:c	Lcom/tencent/android/tpush/stat/ServiceStat$a;
    //   69: new 370	android/content/IntentFilter
    //   72: dup
    //   73: invokespecial 371	android/content/IntentFilter:<init>	()V
    //   76: astore_0
    //   77: aload_0
    //   78: ldc_w 373
    //   81: invokevirtual 377	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   84: getstatic 113	com/tencent/android/tpush/stat/ServiceStat:a	Landroid/content/Context;
    //   87: invokevirtual 186	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   90: getstatic 117	com/tencent/android/tpush/stat/ServiceStat:c	Lcom/tencent/android/tpush/stat/ServiceStat$a;
    //   93: aload_0
    //   94: invokevirtual 381	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   97: pop
    //   98: getstatic 125	com/tencent/android/tpush/stat/ServiceStat:_isInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   101: iconst_1
    //   102: invokevirtual 384	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   105: goto -91 -> 14
    //   108: astore_0
    //   109: ldc 2
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: ldc 133
    //   117: ldc_w 385
    //   120: aload_0
    //   121: invokestatic 315	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: goto -26 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramContext	Context
    //   9	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	10	108	finally
    //   18	44	108	finally
    //   44	98	108	finally
    //   98	105	108	finally
    //   115	124	108	finally
    //   44	98	114	java/lang/Throwable
  }
  
  public static void reportAck(ArrayList<PushStatClientReport> paramArrayList) {}
  
  public static void reportCloudControl(Context paramContext, long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    try
    {
      com.tencent.android.tpush.stat.event.b localb = new com.tencent.android.tpush.stat.event.b(paramContext, paramLong1, paramInt);
      if (paramLong2 != 0L) {
        localb.b = paramLong2;
      }
      if (!TextUtils.isEmpty(paramString)) {
        localb.a = paramString;
      }
      StatServiceImpl.reportXGEvent(paramContext.getApplicationContext(), localb);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.w("ServiceStat", "unexpected for reportCloudControl", paramContext);
    }
  }
  
  public static void reportCustomData(Context paramContext, String paramString, Properties paramProperties)
  {
    StatServiceImpl.trackCustomKVEvent(paramContext, paramString, paramProperties);
  }
  
  public static void reportCustomData4FirstLaunch(Context paramContext)
  {
    StatServiceImpl.trackCustomKVEvent(paramContext, "FIRST_OPEN", null);
  }
  
  public static void reportErrCode(Context paramContext, int paramInt, String paramString1, long paramLong, String paramString2)
  {
    try
    {
      if (CloudManager.getInstance(paramContext).disableReptErrCode())
      {
        TLogger.d("ServiceStat", "disable reportErrCode");
        return;
      }
      init(paramContext);
      paramString2 = new g(paramContext, paramInt, paramString2);
      if (!TextUtils.isEmpty(paramString1)) {
        paramString2.m = paramString1;
      }
      if (paramLong != 0L) {
        paramString2.n = paramLong;
      }
      StatServiceImpl.reportXGEvent(paramContext.getApplicationContext(), paramString2);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.w("ServiceStat", "unexpected for reportErrCode", paramContext);
    }
  }
  
  public static void reportIsCustomDataAcquisitionVersion(Context paramContext) {}
  
  public static void reportLaunchEvent(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    StatServiceImpl.trackLaunchEvent(paramContext, paramInt1, paramInt2, paramLong);
  }
  
  public static void reportNotifactionClickedOrClear(ArrayList<PushStatClientReport> paramArrayList) {}
  
  public static void reportPullYYB() {}
  
  public static void reportSrvAck(ArrayList<j> paramArrayList) {}
  
  public static void reportTokenFailed(Context paramContext)
  {
    for (;;)
    {
      String str1;
      int j;
      int i;
      try
      {
        if (b) {
          return;
        }
        str1 = com.tencent.android.tpush.d.d.g();
        String str2 = com.tencent.android.tpush.d.d.h();
        j = 0;
        if ((h.a(paramContext).c()) && (XGPushConfig.isNotTryFcm(paramContext)))
        {
          i = -1057;
          if (i == 0) {
            break;
          }
          b = true;
          reportErrCode(paramContext, i, str1 + ":" + str2 + ":" + XGPushConfig.getOtherPushErrCode(paramContext), 0L, "inner");
          return;
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.w("ServiceStat", "unexpected for reportTokenFailed", paramContext);
        return;
      }
      if (!com.tencent.android.tpush.d.d.a(paramContext).j()) {
        break;
      }
      if (a.b(paramContext))
      {
        i = -1051;
      }
      else if (((ChannelUtils.isBrandXiaoMi()) || (ChannelUtils.isBrandBlackShark())) && (!i.b(com.tencent.android.tpush.d.d.a)))
      {
        i = -1056;
      }
      else if (((ChannelUtils.isBrandHuaWei()) || (ChannelUtils.isBrandHonor())) && (!i.b(i.l(paramContext))))
      {
        i = -1055;
      }
      else if ((ChannelUtils.isBrandMeiZu()) && (!i.b(com.tencent.android.tpush.d.d.c)))
      {
        i = -1054;
      }
      else if ((("oppo".equals(str1)) || ("oneplus".equals(str1)) || ("realme".equals(str1))) && (!i.b(com.tencent.android.tpush.d.d.e)))
      {
        i = -1053;
      }
      else
      {
        i = j;
        if ("vivo".equals(str1))
        {
          boolean bool = i.b(i.m(paramContext));
          i = j;
          if (!bool) {
            i = -1052;
          }
        }
      }
    }
  }
  
  public static void reportXGLBS(Context paramContext, String paramString, JSONObject paramJSONObject) {}
  
  public static void reportXGStat(Context paramContext, long paramLong, String paramString, JSONObject paramJSONObject) {}
  
  public static void reportXGStat2(Context paramContext, String paramString, JSONObject paramJSONObject) {}
  
  public static void sendLocalMsg(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      init(paramContext);
    } while (!StatServiceImpl.storedList);
    if (!StatServiceImpl.sendLocalMsg(paramContext, -1)) {}
    for (boolean bool = true;; bool = false)
    {
      StatServiceImpl.storedList = bool;
      return;
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      NetworkInfo localNetworkInfo;
      if ((paramIntent != null) && (paramContext != null) && ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())))
      {
        localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
        if (localNetworkInfo != null) {}
      }
      else
      {
        return;
      }
      TLogger.v("ServiceStat", "NetworkReceiver - Connection state changed to - " + localNetworkInfo.toString());
      if (paramIntent.getBooleanExtra("noConnectivity", false))
      {
        TLogger.v("ServiceStat", "stat network is disConnected");
        return;
      }
      if (NetworkInfo.State.CONNECTED == localNetworkInfo.getState())
      {
        TLogger.v("ServiceStat", "stat network connected and sendLocalMsg on 5s later");
        CommonWorkingThread.getInstance().execute(new ServiceStat.a.1(this, paramContext), 5000L);
        return;
      }
      if (NetworkInfo.State.DISCONNECTED == localNetworkInfo.getState())
      {
        TLogger.v("ServiceStat", "Network is disconnected.");
        return;
      }
      TLogger.v("ServiceStat", "other network state - " + localNetworkInfo.getState() + ". Do nothing.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.ServiceStat
 * JD-Core Version:    0.7.0.1
 */