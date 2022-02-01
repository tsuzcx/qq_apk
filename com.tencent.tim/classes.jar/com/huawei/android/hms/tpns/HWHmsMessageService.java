package com.huawei.android.hms.tpns;

import android.content.Intent;
import android.util.Log;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.huawei.hms.push.RemoteMessage.Notification;

public class HWHmsMessageService
  extends HmsMessageService
{
  public void onMessageReceived(RemoteMessage paramRemoteMessage)
  {
    super.onMessageReceived(paramRemoteMessage);
    Log.w("TPush", "[XG_HWPUSH_V3] On messageReceived: " + paramRemoteMessage.getMessageId() + ", " + paramRemoteMessage.getMessageType());
    Object localObject = "com.tencent.android.tpush.action.PUSH_MESSAGE";
    for (;;)
    {
      try
      {
        Class.forName("com.tencent.android.tpush.service.XGVipPushService");
        localObject = "com.tencent.android.xg.vip.action.PUSH_MESSAGE";
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        continue;
      }
      try
      {
        if (paramRemoteMessage.getData().length() > 0)
        {
          String str = paramRemoteMessage.getData();
          Log.i("TPush", "[XG_HWPUSH_V3] Message data payload: " + str);
          localObject = new Intent((String)localObject);
          ((Intent)localObject).putExtra("PUSH.CHANNEL", 4);
          ((Intent)localObject).putExtra("content", str);
          ((Intent)localObject).putExtra("custom_content", "");
          ((Intent)localObject).putExtra("type", Long.valueOf(2L));
          ((Intent)localObject).setPackage(getPackageName());
          sendBroadcast((Intent)localObject);
        }
        if (paramRemoteMessage.getNotification() != null) {
          Log.d("TPush", "[XG_HWPUSH_V3] Message Notification Body: " + paramRemoteMessage.getNotification().getBody());
        }
        return;
      }
      catch (Throwable paramRemoteMessage)
      {
        paramRemoteMessage.printStackTrace();
        return;
      }
    }
  }
  
  /* Error */
  public void onNewToken(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 138	com/huawei/hms/push/HmsMessageService:onNewToken	(Ljava/lang/String;)V
    //   7: ldc 140
    //   9: new 21	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   16: ldc 142
    //   18: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 148	com/tencent/android/tpush/logging/TLogger:ii	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_1
    //   32: ifnull +43 -> 75
    //   35: aload_1
    //   36: invokevirtual 69	java/lang/String:length	()I
    //   39: ifeq +36 -> 75
    //   42: aload_0
    //   43: invokevirtual 152	com/huawei/android/hms/tpns/HWHmsMessageService:getApplicationContext	()Landroid/content/Context;
    //   46: ldc 154
    //   48: iconst_0
    //   49: invokevirtual 160	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   52: invokeinterface 166 1 0
    //   57: astore_3
    //   58: aload_3
    //   59: ldc 168
    //   61: aload_1
    //   62: invokeinterface 174 3 0
    //   67: pop
    //   68: aload_3
    //   69: invokeinterface 178 1 0
    //   74: pop
    //   75: ldc 180
    //   77: astore_3
    //   78: ldc 52
    //   80: invokestatic 58	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   83: pop
    //   84: ldc 182
    //   86: astore_3
    //   87: new 76	android/content/Intent
    //   90: dup
    //   91: aload_3
    //   92: invokespecial 79	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   95: astore_3
    //   96: aload_1
    //   97: ifnull +56 -> 153
    //   100: aload_3
    //   101: ldc 184
    //   103: iload_2
    //   104: invokevirtual 85	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   107: pop
    //   108: aload_3
    //   109: ldc 186
    //   111: aload_1
    //   112: invokevirtual 90	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   115: pop
    //   116: aload_3
    //   117: ldc 188
    //   119: iconst_1
    //   120: invokevirtual 85	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   123: pop
    //   124: aload_3
    //   125: ldc 81
    //   127: iconst_4
    //   128: invokevirtual 85	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   131: pop
    //   132: aload_3
    //   133: aload_0
    //   134: invokevirtual 152	com/huawei/android/hms/tpns/HWHmsMessageService:getApplicationContext	()Landroid/content/Context;
    //   137: invokevirtual 189	android/content/Context:getPackageName	()Ljava/lang/String;
    //   140: invokevirtual 114	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   143: pop
    //   144: aload_0
    //   145: invokevirtual 152	com/huawei/android/hms/tpns/HWHmsMessageService:getApplicationContext	()Landroid/content/Context;
    //   148: aload_3
    //   149: invokevirtual 190	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   152: return
    //   153: iconst_m1
    //   154: istore_2
    //   155: goto -55 -> 100
    //   158: astore_1
    //   159: return
    //   160: astore 4
    //   162: goto -75 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	HWHmsMessageService
    //   0	165	1	paramString	String
    //   1	154	2	i	int
    //   57	92	3	localObject	Object
    //   160	1	4	localClassNotFoundException	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   87	96	158	java/lang/Throwable
    //   100	152	158	java/lang/Throwable
    //   78	84	160	java/lang/ClassNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.android.hms.tpns.HWHmsMessageService
 * JD-Core Version:    0.7.0.1
 */