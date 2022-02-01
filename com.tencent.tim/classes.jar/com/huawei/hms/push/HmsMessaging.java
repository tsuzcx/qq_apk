package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.push.c.f;
import com.huawei.hms.push.c.g;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HmsMessaging
{
  public static final String DEFAULT_TOKEN_SCOPE = "HCM";
  private static final Pattern a = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
  private Context b;
  private HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  private HmsMessaging(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.b = paramContext;
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {}
    for (this.c = new HuaweiApi((Activity)paramContext, localApi, null, new f());; this.c = new HuaweiApi(paramContext, localApi, null, new f()))
    {
      this.c.setKitSdkVersion(40003300);
      return;
    }
  }
  
  private Task<Void> a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (!a.matcher(paramString1).matches()))
    {
      com.huawei.hms.push.c.d.a(this.b, "push.subscribe", paramString3, com.huawei.hms.push.a.a.C);
      HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
      throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    }
    try
    {
      HMSLog.i("HmsMessaging", "EMUI:" + HwBuildEx.VERSION.EMUI_SDK_INT);
      com.huawei.hms.push.a.a locala = g.a(this.b);
      if (locala != com.huawei.hms.push.a.a.a) {
        throw com.huawei.hms.push.a.a.a(locala);
      }
    }
    catch (ApiException paramString1)
    {
      paramString2 = new TaskCompletionSource();
      paramString2.setException(paramString1);
      com.huawei.hms.push.c.d.a(this.b, "push.subscribe", paramString3, paramString1.getStatusCode());
      return paramString2.getTask();
      if (NetWorkUtil.getNetworkType(this.b) == 0)
      {
        HMSLog.e("HmsMessaging", "no network");
        throw com.huawei.hms.push.a.a.a(com.huawei.hms.push.a.a.d);
      }
    }
    catch (Exception paramString1)
    {
      paramString1 = new TaskCompletionSource();
      paramString1.setException(com.huawei.hms.push.a.a.a(com.huawei.hms.push.a.a.D));
      com.huawei.hms.push.c.d.a(this.b, "push.subscribe", paramString3, com.huawei.hms.push.a.a.D);
      return paramString1.getTask();
    }
    paramString1 = new SubscribeReq(this.b.getPackageName(), paramString2, paramString1);
    paramString1.setToken(com.huawei.hms.support.api.push.c.a.b.a(this.b, "push_client_self_info"));
    if (com.huawei.hms.support.api.push.c.a.a()) {
      return this.c.doWrite(new com.huawei.hms.push.b.a("push.subscribe", JsonUtil.createJsonString(paramString1), paramString3));
    }
    paramString1 = this.c.doWrite(new com.huawei.hms.push.b.d("push.subscribe", JsonUtil.createJsonString(paramString1), paramString3));
    return paramString1;
  }
  
  private Task<Void> a(boolean paramBoolean, String paramString)
  {
    if ((!com.huawei.hms.support.api.push.c.a.a(this.b)) || (com.huawei.hms.support.api.push.c.a.a()))
    {
      HMSLog.i("HmsMessaging", "turn on/off with AIDL");
      localObject = new EnableNotifyReq();
      ((EnableNotifyReq)localObject).setPackageName(this.b.getPackageName());
      ((EnableNotifyReq)localObject).setEnable(paramBoolean);
      return this.c.doWrite(new com.huawei.hms.push.b.a("push.setNotifyFlag", JsonUtil.createJsonString((IMessageEntity)localObject), paramString));
    }
    if (HwBuildEx.VERSION.EMUI_SDK_INT < 12)
    {
      HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
      localObject = new TaskCompletionSource();
      ((TaskCompletionSource)localObject).setException(com.huawei.hms.push.a.a.a(com.huawei.hms.push.a.a.U));
      com.huawei.hms.push.c.d.a(this.b, "push.setNotifyFlag", paramString, com.huawei.hms.push.a.a.U);
      return ((TaskCompletionSource)localObject).getTask();
    }
    if (com.huawei.hms.support.api.push.c.a.b(this.b) < 90101310L)
    {
      HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
      localObject = com.huawei.hms.support.api.push.c.b.b.a(this.b, this.b.getPackageName() + "#" + paramBoolean);
      localObject = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", (String)localObject);
      ((Intent)localObject).setPackage("android");
      return Tasks.callInBackground(new com.huawei.hms.push.b.b(this.b, (Intent)localObject, paramString));
    }
    HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
    Object localObject = new com.huawei.hms.support.api.push.c.a.a.c(this.b, "push_notify_flag");
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((com.huawei.hms.support.api.push.c.a.a.c)localObject).a("notify_msg_enable", paramBoolean);
      localObject = Uri.parse("content://" + this.b.getPackageName() + ".huawei.push.provider/" + "push_notify_flag" + ".xml");
      Intent localIntent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
      localIntent.putExtra("type", "enalbeFlag");
      localIntent.putExtra("pkgName", this.b.getPackageName());
      localIntent.putExtra("url", (Parcelable)localObject);
      localIntent.setPackage("android");
      return Tasks.callInBackground(new com.huawei.hms.push.b.b(this.b, localIntent, paramString));
    }
  }
  
  private void a(RemoteMessage paramRemoteMessage, String paramString)
  {
    Object localObject = g.a(this.b);
    if (localObject != com.huawei.hms.push.a.a.a)
    {
      HMSLog.e("HmsMessaging", "Message sent failed:" + ((com.huawei.hms.push.a.a)localObject).b() + ':' + ((com.huawei.hms.push.a.a)localObject).c());
      com.huawei.hms.push.c.d.a(this.b, "push.sendMessage", paramString, (com.huawei.hms.push.a.a)localObject);
      throw new UnsupportedOperationException(((com.huawei.hms.push.a.a)localObject).c());
    }
    if (TextUtils.isEmpty(paramRemoteMessage.getTo()))
    {
      HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
      com.huawei.hms.push.c.d.a(this.b, "push.sendMessage", paramString, com.huawei.hms.push.a.a.C);
      throw new IllegalArgumentException("Mandatory parameter 'to' missing");
    }
    if (TextUtils.isEmpty(paramRemoteMessage.getMessageId()))
    {
      HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
      com.huawei.hms.push.c.d.a(this.b, "push.sendMessage", paramString, com.huawei.hms.push.a.a.C);
      throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
    }
    if (TextUtils.isEmpty(paramRemoteMessage.getData()))
    {
      HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
      com.huawei.hms.push.c.d.a(this.b, "push.sendMessage", paramString, com.huawei.hms.push.a.a.C);
      throw new IllegalArgumentException("Mandatory parameter 'data' missing");
    }
    localObject = new UpSendMsgReq();
    ((UpSendMsgReq)localObject).setPackageName(this.b.getPackageName());
    ((UpSendMsgReq)localObject).setMessageId(paramRemoteMessage.getMessageId());
    ((UpSendMsgReq)localObject).setTo(paramRemoteMessage.getTo());
    ((UpSendMsgReq)localObject).setData(paramRemoteMessage.getData());
    ((UpSendMsgReq)localObject).setMessageType(paramRemoteMessage.getMessageType());
    ((UpSendMsgReq)localObject).setTtl(paramRemoteMessage.getTtl());
    ((UpSendMsgReq)localObject).setCollapseKey(paramRemoteMessage.getCollapseKey());
    if (com.huawei.hms.support.api.push.c.a.a())
    {
      this.c.doWrite(new com.huawei.hms.push.b.a("push.sendMessage", JsonUtil.createJsonString((IMessageEntity)localObject), paramString));
      return;
    }
    a((UpSendMsgReq)localObject, paramString);
  }
  
  private void a(UpSendMsgReq paramUpSendMsgReq, String paramString)
  {
    paramUpSendMsgReq.setToken(com.huawei.hms.support.api.push.c.a.b.a(this.b, "push_client_self_info"));
    try
    {
      this.c.doWrite(new com.huawei.hms.push.b.c("push.sendMessage", JsonUtil.createJsonString(paramUpSendMsgReq), paramString, paramUpSendMsgReq.getPackageName(), paramUpSendMsgReq.getMessageId()));
      return;
    }
    catch (Exception paramUpSendMsgReq)
    {
      if ((paramUpSendMsgReq.getCause() instanceof ApiException))
      {
        paramUpSendMsgReq = (ApiException)paramUpSendMsgReq.getCause();
        com.huawei.hms.push.c.d.a(this.b, "push.sendMessage", paramString, paramUpSendMsgReq.getStatusCode());
        return;
      }
      com.huawei.hms.push.c.d.a(this.b, "push.sendMessage", paramString, com.huawei.hms.push.a.a.D);
    }
  }
  
  public static HmsMessaging getInstance(Context paramContext)
  {
    try
    {
      paramContext = new HmsMessaging(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public boolean isAutoInitEnabled()
  {
    return AutoInitHelper.isAutoInitEnabled(this.b);
  }
  
  public void send(RemoteMessage paramRemoteMessage)
  {
    String str = com.huawei.hms.push.c.d.a(this.b, "push.sendMessage");
    HMSLog.i("HmsMessaging", "send upstream message");
    a(paramRemoteMessage, str);
  }
  
  public void setAutoInitEnabled(boolean paramBoolean)
  {
    AutoInitHelper.setAutoInitEnabled(this.b, paramBoolean);
  }
  
  public Task<Void> subscribe(String paramString)
  {
    String str = com.huawei.hms.push.c.d.a(this.b, "push.subscribe");
    HMSLog.i("HmsMessaging", "invoke subscribe");
    return a(paramString, "Sub", str);
  }
  
  public Task<Void> turnOffPush()
  {
    String str = com.huawei.hms.push.c.d.a(this.b, "push.setNotifyFlag");
    HMSLog.i("HmsMessaging", "invoke turnOffPush");
    return a(false, str);
  }
  
  public Task<Void> turnOnPush()
  {
    String str = com.huawei.hms.push.c.d.a(this.b, "push.setNotifyFlag");
    HMSLog.i("HmsMessaging", "invoke turnOnPush");
    return a(true, str);
  }
  
  public Task<Void> unsubscribe(String paramString)
  {
    String str = com.huawei.hms.push.c.d.a(this.b, "push.subscribe");
    HMSLog.i("HmsMessaging", "invoke unsubscribe");
    return a(paramString, "UnSub", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.HmsMessaging
 * JD-Core Version:    0.7.0.1
 */