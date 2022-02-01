package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.b;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.PushMessageManager;
import com.tencent.android.tpush.message.a;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class XGPushBaseReceiver
  extends BroadcastReceiver
{
  public static final int SUCCESS = 0;
  private long a = 0L;
  
  private void a(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PUSH.CHANNEL", 100);
    if (i == 100)
    {
      localObject = PushMessageManager.getInstance(paramContext, paramIntent);
      if (((PushMessageManager)localObject).getMessageHolder().b() == 2)
      {
        XGPushTextMessage localXGPushTextMessage = new XGPushTextMessage();
        localXGPushTextMessage.a = ((PushMessageManager)localObject).getMsgId();
        localXGPushTextMessage.e = i;
        localXGPushTextMessage.b = ((PushMessageManager)localObject).getMessageHolder().d();
        localXGPushTextMessage.c = ((PushMessageManager)localObject).getMessageHolder().e();
        localXGPushTextMessage.d = ((PushMessageManager)localObject).getMessageHolder().f();
        localXGPushTextMessage.f = ((PushMessageManager)localObject).getTemplateId();
        localXGPushTextMessage.g = ((PushMessageManager)localObject).getTraceId();
        localXGPushTextMessage.a(paramIntent);
        onTextMessage(paramContext, localXGPushTextMessage);
      }
      return;
    }
    Object localObject = new XGPushTextMessage();
    ((XGPushTextMessage)localObject).a = paramIntent.getLongExtra("msgId", -1L);
    ((XGPushTextMessage)localObject).e = i;
    ((XGPushTextMessage)localObject).c = paramIntent.getStringExtra("content");
    ((XGPushTextMessage)localObject).b = paramIntent.getStringExtra("title");
    ((XGPushTextMessage)localObject).d = paramIntent.getStringExtra("custom_content");
    ((XGPushTextMessage)localObject).f = paramIntent.getStringExtra("templateId");
    ((XGPushTextMessage)localObject).g = paramIntent.getStringExtra("traceId");
    paramIntent.putExtra("accId", XGPushConfig.getAccessId(paramContext));
    e(paramContext, paramIntent);
    onTextMessage(paramContext, (XGPushTextMessage)localObject);
  }
  
  private void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    try
    {
      String str = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("queryTagsName");
      onQueryTagsResult(paramContext, paramInt, Rijndael.decrypt(str), paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("XGPushBaseReceiver", "feekbackQueryTags:", paramContext);
    }
  }
  
  private void b(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("TPUSH.FEEDBACK", -1);
    int j = paramIntent.getIntExtra("TPUSH.ERRORCODE", -1);
    TLogger.i("XGPushBaseReceiver", "action - feedbackHandler, feedbackType: " + i);
    switch (i)
    {
    case 9: 
    default: 
      TLogger.e("XGPushBaseReceiver", "未知的feedbackType:" + i);
      return;
    case 1: 
      e(paramContext, paramIntent, j);
      return;
    case 2: 
      new XGPushRegisterResult().parseIntent(paramIntent);
      onUnregisterResult(paramContext, j);
      return;
    case 3: 
      d(paramContext, paramIntent, j);
      return;
    case 4: 
      d(paramContext, paramIntent);
      return;
    case 5: 
      c(paramContext, paramIntent);
      return;
    case 6: 
      c(paramContext, paramIntent, j);
      return;
    case 7: 
      b(paramContext, paramIntent, j);
      return;
    case 8: 
      a(paramContext, paramIntent, j);
      return;
    case 10: 
      g(paramContext, paramIntent);
      return;
    }
    h(paramContext, paramIntent);
  }
  
  private void b(Context paramContext, Intent paramIntent, int paramInt)
  {
    String str1 = Rijndael.decrypt(paramIntent.getStringExtra("attributesName"));
    int i;
    String str2;
    if (!i.b(str1))
    {
      i = paramIntent.getIntExtra("attributesFlag", -1);
      str2 = paramIntent.getStringExtra("attributesOperateName");
      TLogger.i("XGPushBaseReceiver", "attributes, opType:" + i + " ,attributesName:" + str1 + ", operateName:" + str2);
      if ((i == 2) || (i == 1)) {
        onSetAttributeResult(paramContext, paramInt, str2);
      }
    }
    else
    {
      return;
    }
    if ((i == 4) || (i == 3))
    {
      onDeleteAttributeResult(paramContext, paramInt, str2);
      return;
    }
    TLogger.e("XGPushBaseReceiver", "error attributes：" + i + " ,attributesName：" + str1 + ", intent:" + paramIntent.getExtras());
  }
  
  private void c(Context paramContext, Intent paramIntent)
  {
    XGPushShowedResult localXGPushShowedResult = new XGPushShowedResult();
    int i = paramIntent.getIntExtra("PUSH.CHANNEL", 100);
    if ((i == 100) || (i == 101) || (i == 99)) {
      localXGPushShowedResult.parseIntent(paramIntent);
    }
    for (;;)
    {
      onNotificationShowedResult(paramContext, localXGPushShowedResult);
      return;
      localXGPushShowedResult.c = paramIntent.getStringExtra("content");
      localXGPushShowedResult.b = paramIntent.getStringExtra("title");
      localXGPushShowedResult.d = paramIntent.getStringExtra("custom_content");
      localXGPushShowedResult.h = paramIntent.getIntExtra("PUSH.CHANNEL", 0);
      paramIntent.putExtra("accId", XGPushConfig.getAccessId(paramContext));
    }
  }
  
  private void c(Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = Rijndael.decrypt(paramIntent.getStringExtra("accountName"));
    int i = paramIntent.getIntExtra("operateType", -1);
    paramIntent = paramIntent.getStringExtra("accountFeedBack");
    if (i == 1) {
      onDeleteAccountResult(paramContext, paramInt, paramIntent);
    }
    while (i.b(str)) {
      return;
    }
    if ((i == 0) || (i == 2) || (i == 6))
    {
      onSetAccountResult(paramContext, paramInt, paramIntent);
      return;
    }
    if ((i == 3) || (i == 1) || (i == 7))
    {
      onDeleteAccountResult(paramContext, paramInt, paramIntent);
      return;
    }
    TLogger.e("XGPushBaseReceiver", "错误的帐号处理类型：" + i + " ,accountName：" + str);
  }
  
  private void d(Context paramContext, Intent paramIntent)
  {
    XGPushConfig.changeHuaweiBadgeNum(paramContext, -1);
    int i = paramIntent.getIntExtra("PUSH.CHANNEL", 100);
    long l = paramIntent.getLongExtra("accId", 0L);
    Object localObject = XGPushConfig.getAccessidList(paramContext);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if ((((List)localObject).contains(Long.valueOf(l))) && ((i == 100) || (i == 101) || (i == 99)))
      {
        localObject = new XGPushClickedResult();
        ((XGPushClickedResult)localObject).parseIntent(paramIntent);
        onNotificationClickedResult(paramContext, (XGPushClickedResult)localObject);
        return;
      }
      localObject = new XGPushClickedResult();
      ((XGPushClickedResult)localObject).content = paramIntent.getStringExtra("content");
      ((XGPushClickedResult)localObject).title = paramIntent.getStringExtra("title");
      ((XGPushClickedResult)localObject).customContent = paramIntent.getStringExtra("custom_content");
      ((XGPushClickedResult)localObject).pushChannel = paramIntent.getIntExtra("PUSH.CHANNEL", 0);
      ((XGPushClickedResult)localObject).actionType = paramIntent.getIntExtra("action", 0);
      ((XGPushClickedResult)localObject).customContent = paramIntent.getStringExtra("custom_content");
      ((XGPushClickedResult)localObject).msgId = paramIntent.getLongExtra("msgId", 0L);
      ((XGPushClickedResult)localObject).notificationActionType = paramIntent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
      ((XGPushClickedResult)localObject).activityName = paramIntent.getStringExtra("activity");
      ((XGPushClickedResult)localObject).templateId = paramIntent.getStringExtra("templateId");
      ((XGPushClickedResult)localObject).traceId = paramIntent.getStringExtra("traceId");
      onNotificationClickedResult(paramContext, (XGPushClickedResult)localObject);
      return;
    }
    TLogger.e("XGPushBaseReceiver", "accessIdList " + localObject + " local accessid " + l);
    TLogger.e("XGPushBaseReceiver", "give up msg");
  }
  
  private void d(Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = Rijndael.decrypt(paramIntent.getStringExtra("tagName"));
    int i = paramIntent.getIntExtra("tagFlag", -1);
    paramIntent = paramIntent.getStringExtra("tagOperageName");
    if (i == 8) {
      onDeleteTagResult(paramContext, paramInt, paramIntent);
    }
    while (i.b(str)) {
      return;
    }
    if ((i == 1) || (i == 6) || (i == 5))
    {
      onSetTagResult(paramContext, paramInt, paramIntent);
      return;
    }
    if ((i == 2) || (i == 7) || (i == 8))
    {
      onDeleteTagResult(paramContext, paramInt, paramIntent);
      return;
    }
    TLogger.e("XGPushBaseReceiver", "错误的标签处理类型：" + i + " ,标签名：" + str);
  }
  
  private void e(Context paramContext, Intent paramIntent)
  {
    Object localObject = new MessageId();
    ((MessageId)localObject).id = paramIntent.getLongExtra("msgId", 0L);
    ((MessageId)localObject).isAck = 0;
    ((MessageId)localObject).accessId = paramIntent.getLongExtra("accId", 0L);
    ((MessageId)localObject).host = paramIntent.getLongExtra("extra_host", 0L);
    ((MessageId)localObject).port = paramIntent.getIntExtra("extra_port", 0);
    ((MessageId)localObject).pact = paramIntent.getByteExtra("extra_pact", (byte)0);
    ((MessageId)localObject).apn = DeviceInfos.getNetworkType(paramContext);
    ((MessageId)localObject).isp = i.o(paramContext);
    ((MessageId)localObject).serviceHost = paramIntent.getStringExtra("svrPkgName");
    ((MessageId)localObject).receivedTime = System.currentTimeMillis();
    ((MessageId)localObject).pkgName = paramContext.getPackageName();
    ((MessageId)localObject).busiMsgId = paramIntent.getLongExtra("busiMsgId", 0L);
    ((MessageId)localObject).timestamp = paramIntent.getLongExtra("timestamps", 0L);
    ((MessageId)localObject).msgType = paramIntent.getLongExtra("type", 0L);
    ((MessageId)localObject).multiPkg = paramIntent.getLongExtra("multiPkg", 0L);
    ((MessageId)localObject).date = new SimpleDateFormat("yyyyMMdd").format(new Date());
    String str = paramIntent.getStringExtra("group_id");
    if (!i.b(str)) {
      ((MessageId)localObject).groupId = str;
    }
    paramIntent.putExtra("MessageId", (Serializable)localObject);
    localObject = new Intent(paramContext.getPackageName() + "com.tencent.android.xg.vip.action.MSG_ACK.V4");
    ((Intent)localObject).putExtras(paramIntent);
    BroadcastAgent.sendBroadcast(paramContext, (Intent)localObject);
  }
  
  private void e(Context paramContext, Intent paramIntent, int paramInt)
  {
    XGPushRegisterResult localXGPushRegisterResult = new XGPushRegisterResult();
    if (!paramIntent.getBooleanExtra("registerFromCloudControl", false))
    {
      if (paramIntent.getIntExtra("PUSH.CHANNEL", 100) != 100) {
        break label48;
      }
      localXGPushRegisterResult.parseIntent(paramIntent);
    }
    for (;;)
    {
      onRegisterResult(paramContext, paramInt, localXGPushRegisterResult);
      return;
      label48:
      localXGPushRegisterResult.h = paramIntent.getIntExtra("PUSH.CHANNEL", 0);
      localXGPushRegisterResult.g = paramIntent.getStringExtra("other_push_token");
      if ((paramInt == 0) && (!i.b(localXGPushRegisterResult.g))) {
        b.a(paramContext);
      }
    }
  }
  
  private void f(Context paramContext, Intent paramIntent)
  {
    XGPushTextMessage localXGPushTextMessage = new XGPushTextMessage();
    localXGPushTextMessage.a = paramIntent.getLongExtra("msgId", 0L);
    localXGPushTextMessage.e = paramIntent.getIntExtra("PUSH.CHANNEL", 100);
    localXGPushTextMessage.b = Rijndael.decrypt(paramIntent.getStringExtra("title"));
    localXGPushTextMessage.c = Rijndael.decrypt(paramIntent.getStringExtra("content"));
    localXGPushTextMessage.d = Rijndael.decrypt(paramIntent.getStringExtra("custom_content"));
    localXGPushTextMessage.f = paramIntent.getStringExtra("templateId");
    localXGPushTextMessage.g = paramIntent.getStringExtra("traceId");
    localXGPushTextMessage.a(paramIntent);
    onInMsgReceivedResult(paramContext, localXGPushTextMessage);
  }
  
  private void g(Context paramContext, Intent paramIntent)
  {
    XGPushShowedResult localXGPushShowedResult = new XGPushShowedResult();
    localXGPushShowedResult.parseIntent(paramIntent);
    onInMsgShowedResult(paramContext, localXGPushShowedResult);
  }
  
  private void h(Context paramContext, Intent paramIntent)
  {
    XGPushClickedResult localXGPushClickedResult = new XGPushClickedResult();
    localXGPushClickedResult.parseIntent(paramIntent);
    onInMsgClickedResult(paramContext, localXGPushClickedResult);
  }
  
  public abstract void onDeleteAccountResult(Context paramContext, int paramInt, String paramString);
  
  public abstract void onDeleteAttributeResult(Context paramContext, int paramInt, String paramString);
  
  public abstract void onDeleteTagResult(Context paramContext, int paramInt, String paramString);
  
  public void onInMsgClickedResult(Context paramContext, XGPushClickedResult paramXGPushClickedResult) {}
  
  public void onInMsgReceivedResult(Context paramContext, XGPushTextMessage paramXGPushTextMessage) {}
  
  public void onInMsgShowedResult(Context paramContext, XGPushShowedResult paramXGPushShowedResult) {}
  
  public abstract void onNotificationClickedResult(Context paramContext, XGPushClickedResult paramXGPushClickedResult);
  
  public abstract void onNotificationShowedResult(Context paramContext, XGPushShowedResult paramXGPushShowedResult);
  
  public abstract void onQueryTagsResult(Context paramContext, int paramInt, String paramString1, String paramString2);
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null))
    {
      String str;
      try
      {
        if (i.a(paramContext) > 0) {
          return;
        }
        str = paramIntent.getAction();
        if (!"com.tencent.android.xg.vip.action.PUSH_MESSAGE".equals(str)) {
          break label73;
        }
        if (paramIntent.getLongExtra("type", -1L) == 7L)
        {
          f(paramContext, paramIntent);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.e("XGPushBaseReceiver", "onReceive handle error.", paramContext);
        return;
      }
      a(paramContext, paramIntent);
      return;
      label73:
      if ("com.tencent.android.xg.vip.action.FEEDBACK".equals(str))
      {
        CommonWorkingThread.getInstance().execute(new XGPushBaseReceiver.1(this, paramContext, paramIntent));
        return;
      }
      TLogger.e("XGPushBaseReceiver", "未知的action:" + str);
    }
  }
  
  public abstract void onRegisterResult(Context paramContext, int paramInt, XGPushRegisterResult paramXGPushRegisterResult);
  
  public abstract void onSetAccountResult(Context paramContext, int paramInt, String paramString);
  
  public abstract void onSetAttributeResult(Context paramContext, int paramInt, String paramString);
  
  public abstract void onSetTagResult(Context paramContext, int paramInt, String paramString);
  
  public abstract void onTextMessage(Context paramContext, XGPushTextMessage paramXGPushTextMessage);
  
  public abstract void onUnregisterResult(Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushBaseReceiver
 * JD-Core Version:    0.7.0.1
 */