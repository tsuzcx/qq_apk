package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.support.api.push.c.a.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public final class PushReceiver
  extends BroadcastReceiver
{
  private void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.hasExtra("device_token"))
      {
        com.huawei.hms.support.api.push.c.a.c.a().execute(new b(paramContext, paramIntent, null));
        return;
      }
      HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
      return;
    }
    catch (RuntimeException paramContext)
    {
      HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
    }
  }
  
  private void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.hasExtra("msg_data"))
      {
        com.huawei.hms.support.api.push.c.a.c.a().execute(new a(paramContext, paramIntent, null));
        return;
      }
      HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
      return;
    }
    catch (RuntimeException paramContext)
    {
      HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
    }
  }
  
  public void onPushMsg(Context paramContext, byte[] paramArrayOfByte, String paramString) {}
  
  public boolean onPushMsg(Context paramContext, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    String str = "";
    if (paramBundle != null) {
      str = paramBundle.getString("deviceToken");
    }
    onPushMsg(paramContext, paramArrayOfByte, str);
    return true;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      return;
    }
    HMSLog.i("PushReceiver", "push receive broadcast message, Intent:" + paramIntent.getAction() + " pkgName:" + paramContext.getPackageName());
    String str;
    try
    {
      paramIntent.getStringExtra("TestIntent");
      str = paramIntent.getAction();
      if (ResourceLoaderUtil.getmContext() == null) {
        ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
      }
      if ("com.huawei.android.push.intent.REGISTRATION".equals(str))
      {
        a(paramContext, paramIntent);
        return;
      }
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushReceiver", "intent has some error");
      return;
    }
    if ("com.huawei.android.push.intent.RECEIVE".equals(str))
    {
      b(paramContext, paramIntent);
      return;
    }
    HMSLog.i("PushReceiver", "message can't be recognised:" + paramIntent.toUri(0));
  }
  
  public void onToken(Context paramContext, String paramString) {}
  
  public void onToken(Context paramContext, String paramString, Bundle paramBundle)
  {
    onToken(paramContext, paramString);
  }
  
  public static abstract interface BoundKey
  {
    public static final String DEVICE_TOKEN_KEY = "deviceToken";
  }
  
  static class a
    implements Runnable
  {
    private Context a;
    private Intent b;
    
    private a(Context paramContext, Intent paramIntent)
    {
      this.a = paramContext;
      this.b = paramIntent;
    }
    
    public void run()
    {
      Intent localIntent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
      localIntent.setPackage(this.b.getPackage());
      Bundle localBundle = new Bundle();
      localBundle.putString("message_type", "received_message");
      localBundle.putString("message_id", this.b.getStringExtra("msgIdStr"));
      localBundle.putByteArray("message_body", this.b.getByteArrayExtra("msg_data"));
      localBundle.putString("device_token", com.huawei.hms.support.api.push.c.a.a.a.b(this.b.getByteArrayExtra("device_token")));
      localBundle.putInt("inputType", 1);
      if (new com.huawei.hms.support.api.push.a.a().a(this.a, localBundle, localIntent))
      {
        HMSLog.i("PushReceiver", "receive " + this.b.getAction() + " and start service success");
        return;
      }
      HMSLog.e("PushReceiver", "receive " + this.b.getAction() + " and start service failed");
    }
  }
  
  static class b
    implements Runnable
  {
    private Context a;
    private Intent b;
    
    private b(Context paramContext, Intent paramIntent)
    {
      this.a = paramContext;
      this.b = paramIntent;
    }
    
    public void run()
    {
      try
      {
        Object localObject1 = this.b.getByteArrayExtra("device_token");
        if ((localObject1 == null) || (localObject1.length == 0))
        {
          HMSLog.i("PushReceiver", "get a deviceToken, but it is null");
          return;
        }
        HMSLog.i("PushReceiver", "receive a push token: " + this.a.getPackageName());
        Object localObject2 = new com.huawei.hms.support.api.push.c.a.a.c(this.a, "push_client_self_info");
        ((com.huawei.hms.support.api.push.c.a.a.c)localObject2).a("reqTokenTime", Long.valueOf(System.currentTimeMillis()));
        localObject1 = com.huawei.hms.support.api.push.c.a.a.a.b((byte[])localObject1);
        if (!((String)localObject1).equals(b.a(this.a, "push_client_self_info")))
        {
          HMSLog.i("PushReceiver", "receive a token, refresh the local token");
          ((com.huawei.hms.support.api.push.c.a.a.c)localObject2).c("token_info");
          b.a(this.a, "push_client_self_info", (String)localObject1);
        }
        localObject2 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        ((Intent)localObject2).setPackage(this.b.getPackage());
        Bundle localBundle = new Bundle();
        localBundle.putString("message_type", "new_token");
        localBundle.putString("device_token", (String)localObject1);
        localBundle.putString("transaction_id", this.b.getStringExtra("transaction_id"));
        localBundle.putInt("error", this.b.getIntExtra("error", com.huawei.hms.push.a.a.a.a()));
        if (!new com.huawei.hms.support.api.push.a.a().a(this.a, localBundle, (Intent)localObject2))
        {
          HMSLog.e("PushReceiver", "receive " + this.b.getAction() + " and start service failed");
          return;
        }
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        HMSLog.e("PushReceiver", "execute task error");
        return;
      }
      catch (Exception localException)
      {
        HMSLog.e("PushReceiver", "handle push token error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushReceiver
 * JD-Core Version:    0.7.0.1
 */