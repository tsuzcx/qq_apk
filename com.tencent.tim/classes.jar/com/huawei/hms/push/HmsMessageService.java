package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.push.a.a;
import com.huawei.hms.push.c.d;
import com.huawei.hms.support.api.push.c.a.a.c;
import com.huawei.hms.support.api.push.c.a.b;
import com.huawei.hms.support.log.HMSLog;

public class HmsMessageService
  extends Service
{
  private final Messenger a = new Messenger(new a(null));
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      HMSLog.e("HmsMessageService", "receive message is null");
      return;
    }
    String str1 = paramIntent.getStringExtra("message_id");
    String str2 = paramIntent.getStringExtra("message_type");
    String str3 = paramIntent.getStringExtra("transaction_id");
    if ("new_token".equals(str2))
    {
      HMSLog.i("HmsMessageService", "onNewToken");
      a(paramIntent, str3);
      return;
    }
    if ("received_message".equals(str2))
    {
      HMSLog.i("HmsMessageService", "onMessageReceived, message id:" + str1);
      a("push.receiveMessage", str1, a.a.a());
      onMessageReceived(new RemoteMessage(b(paramIntent)));
      return;
    }
    if ("sent_message".equals(str2))
    {
      HMSLog.i("HmsMessageService", "onMessageSent, message id:" + str1 + ", transactionId: " + str3);
      a("push.sendMessageRet", str3, a.a.a());
      onMessageSent(str1);
      return;
    }
    if ("send_error".equals(str2))
    {
      int i = paramIntent.getIntExtra("error", a.g.a());
      HMSLog.i("HmsMessageService", "onSendError, message id:" + str1 + " error:" + i + ", transactionId: " + str3);
      a("push.sendMessageRet", str3, i);
      onSendError(str1, new SendException(i));
      return;
    }
    if ("server_deleted_message".equals(str2))
    {
      HMSLog.i("HmsMessageService", "delete message, message id:" + str1);
      onDeletedMessages();
      return;
    }
    HMSLog.e("HmsMessageService", "Receive unknown message: " + str2);
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    int i = paramIntent.getIntExtra("error", a.a.a());
    HMSLog.i("HmsMessageService", "doOnNewToken:transactionId = " + paramString + " , internalCode = " + i);
    a("push.onNewToken", paramString, i);
    if (i == a.a.a())
    {
      a(paramIntent.getStringExtra("device_token"));
      onNewToken(paramIntent.getStringExtra("device_token"));
      return;
    }
    onTokenError(new BaseException(i));
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Context localContext = getApplicationContext();
    new c(localContext, "push_client_self_info").a("reqTokenTime", Long.valueOf(System.currentTimeMillis()));
    b.a(localContext, "push_client_self_info", paramString);
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "null";
    }
    d.a(getApplicationContext(), paramString1, str, paramInt);
  }
  
  private Bundle b(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("message_id", paramIntent.getStringExtra("message_id"));
    localBundle.putByteArray("message_body", paramIntent.getByteArrayExtra("message_body"));
    localBundle.putString("device_token", paramIntent.getStringExtra("device_token"));
    if (1 == paramIntent.getIntExtra("inputType", -1)) {
      localBundle.putInt("inputType", 1);
    }
    return localBundle;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    HMSLog.i("HmsMessageService", "start to bind");
    return this.a.getBinder();
  }
  
  public void onDeletedMessages() {}
  
  public void onDestroy()
  {
    HMSLog.i("HmsMessageService", "start to destroy");
    super.onDestroy();
  }
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onNewToken(String paramString) {}
  
  public void onSendError(String paramString, Exception paramException) {}
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    HMSLog.i("HmsMessageService", "start to command , startId = " + paramInt2);
    a(paramIntent);
    return 2;
  }
  
  public void onTokenError(Exception paramException) {}
  
  @SuppressLint({"HandlerLeak"})
  class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage == null)
      {
        HMSLog.e("HmsMessageService", "receive message is null");
        return;
      }
      HMSLog.i("HmsMessageService", "handle message start ");
      Bundle localBundle = paramMessage.getData();
      if (localBundle != null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("message_id", localBundle.getString("message_id"));
        localIntent.putExtra("message_type", localBundle.getString("message_type"));
        localIntent.putExtra("message_body", localBundle.getByteArray("message_body"));
        localIntent.putExtra("device_token", localBundle.getString("device_token"));
        localIntent.putExtra("error", localBundle.getInt("error"));
        localIntent.putExtra("transaction_id", localBundle.getString("transaction_id"));
        localIntent.putExtra("inputType", localBundle.getInt("inputType", -1));
        HmsMessageService.a(HmsMessageService.this, localIntent);
      }
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.HmsMessageService
 * JD-Core Version:    0.7.0.1
 */