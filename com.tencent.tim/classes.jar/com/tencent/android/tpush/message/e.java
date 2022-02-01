package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class e
{
  static ArrayList<Long> a;
  private static volatile e b = null;
  private static long c = 0L;
  private Context d = null;
  
  public static e a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null)
      {
        b = new e();
        b.d = paramContext.getApplicationContext();
        b.b(b.d);
      }
      return b;
    }
    finally {}
  }
  
  protected static boolean a(Long paramLong)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (a == null) {
          a = new ArrayList();
        }
        boolean bool2 = a.contains(paramLong);
        if (bool2) {
          return bool1;
        }
        a.add(paramLong);
        if (a.size() > 200) {
          a.remove(0);
        }
      }
      catch (Throwable localThrowable)
      {
        TLogger.e("PushMessageHandler", "addCachedmsgID " + paramLong, localThrowable);
        continue;
      }
      finally {}
      bool1 = true;
    }
  }
  
  private void c(Intent paramIntent)
  {
    CommonWorkingThread.getInstance().execute(new e.1(this, paramIntent));
  }
  
  public void a(Intent paramIntent)
  {
    CommonWorkingThread.getInstance().execute(new a(this.d, paramIntent, null));
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   5: lstore_2
    //   6: getstatic 21	com/tencent/android/tpush/message/e:c	J
    //   9: lstore 4
    //   11: lload_2
    //   12: lload 4
    //   14: lsub
    //   15: ldc2_w 117
    //   18: lcmp
    //   19: ifgt +10 -> 29
    //   22: iload_1
    //   23: ifne +6 -> 29
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: lload_2
    //   30: putstatic 21	com/tencent/android/tpush/message/e:c	J
    //   33: invokestatic 98	com/tencent/tpns/baseapi/base/util/CommonWorkingThread:getInstance	()Lcom/tencent/tpns/baseapi/base/util/CommonWorkingThread;
    //   36: new 120	com/tencent/android/tpush/message/e$3
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 123	com/tencent/android/tpush/message/e$3:<init>	(Lcom/tencent/android/tpush/message/e;)V
    //   44: invokevirtual 106	com/tencent/tpns/baseapi/base/util/CommonWorkingThread:execute	(Ljava/lang/Runnable;)Z
    //   47: pop
    //   48: goto -22 -> 26
    //   51: astore 6
    //   53: aload_0
    //   54: monitorexit
    //   55: aload 6
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	e
    //   0	58	1	paramBoolean	boolean
    //   5	25	2	l1	long
    //   9	4	4	l2	long
    //   51	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	51	finally
    //   29	48	51	finally
  }
  
  public void b(Intent paramIntent)
  {
    CommonWorkingThread.getInstance().execute(new e.2(this, paramIntent));
  }
  
  class a
    implements Runnable
  {
    private Context b;
    private Intent c;
    private XGIOperateCallback d;
    
    a(Context paramContext, Intent paramIntent, XGIOperateCallback paramXGIOperateCallback)
    {
      this.b = paramContext;
      this.c = paramIntent;
      this.d = paramXGIOperateCallback;
    }
    
    private void a()
    {
      Object localObject1 = new Intent("com.tencent.android.xg.vip.action.PUSH_MESSAGE");
      ((Intent)localObject1).putExtras(this.c);
      Object localObject2;
      if (com.tencent.android.tpush.f.a.a(this.b))
      {
        localObject2 = this.c.getStringExtra("third_app_pkgname");
        if (!i.b((String)localObject2))
        {
          TLogger.ii("PushMessageRunnable", "ACTION_PUSH_MESSAGE otherApp -> " + (String)localObject2);
          ((Intent)localObject1).setPackage((String)localObject2);
          this.b.sendBroadcast((Intent)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = this.c.getStringExtra("svrPkgName");
        if (!i.b((String)localObject1))
        {
          localObject2 = new Intent(this.b.getPackageName() + "com.tencent.android.xg.vip.action.ack.sdk2srv.V4");
          ((Intent)localObject2).setPackage((String)localObject1);
          ((Intent)localObject2).putExtras(this.c);
          BroadcastAgent.sendBroadcast(this.b, (Intent)localObject2);
        }
        return;
        ((Intent)localObject1).setPackage(this.b.getPackageName());
        BroadcastAgent.sendBroadcast(this.b, (Intent)localObject1);
        continue;
        ((Intent)localObject1).setPackage(this.b.getPackageName());
        BroadcastAgent.sendBroadcast(this.b, (Intent)localObject1);
      }
    }
    
    public void run()
    {
      synchronized (e.this)
      {
        if (XGPushConfig.enableDebug) {
          TLogger.d("PushMessageRunnable", "Action -> handlerPushMessage");
        }
        for (;;)
        {
          try
          {
            l3 = this.c.getLongExtra("expire_time", 0L);
            l1 = l3;
            if (l3 <= 0L)
            {
              l2 = this.c.getLongExtra("server_time", -1L);
              l1 = l3;
              if (l2 > 0L)
              {
                i = this.c.getIntExtra("ttl", 0);
                if (i > 0) {
                  continue;
                }
                i = 259200;
              }
            }
          }
          catch (JSONException localJSONException)
          {
            long l3;
            long l2;
            int i;
            int j;
            int k;
            String str1;
            PushMessageManager localPushMessageManager;
            String str3;
            TLogger.e("PushMessageRunnable", "push parse error", localJSONException);
            if (this.d == null) {
              continue;
            }
            if (localJSONException == null) {
              continue;
            }
            this.d.onFail("", -1, localJSONException.toString());
            return;
            str2 = finally;
            throw str2;
            if ((l1 <= 0L) || (l4 <= l1)) {
              continue;
            }
            TLogger.e("PushMessageHandler", "msg is expired, currentTimeMillis=" + l4 + ", expire_time=" + l1 + ". msgid = " + l2);
            XGPushManager.msgAck(this.b, localPushMessageManager);
            return;
            if (e.a(Long.valueOf(l2))) {
              continue;
            }
            XGPushManager.msgAck(this.b, localPushMessageManager);
            return;
            long l1 = this.c.getLongExtra("busiMsgId", 0L);
            long l4 = this.c.getLongExtra("timestamps", 0L);
            List localList = XGPushConfig.getAccessidList(this.b);
            if ((com.tencent.android.tpush.f.a.a(this.b)) || (localList == null) || (localList.size() <= 0) || (localList.contains(Long.valueOf(l3)))) {
              continue;
            }
            TLogger.ee("PushMessageRunnable", "PushMessageRunnable match accessId failed, message droped cause accessId:" + l3 + " not in " + localList + " msgId = " + str2);
            MessageManager.getInstance().deleteCachedMsgIntent(this.b, l2);
            XGPushManager.msgAck(this.b, localPushMessageManager);
            return;
            if (str3.contains(str2)) {
              continue;
            }
            boolean bool = MessageManager.setNotifiedMsgIds(this.b, l3, str2, str3);
            if (bool) {
              continue;
            }
            return;
            TLogger.i("PushMessageRunnable", "Receiver msg from server :" + localPushMessageManager.toString());
            XGPushManager.msgAck(this.b, localPushMessageManager);
            Object localObject1 = this.c.getStringExtra("svrPkgName");
            if (this.b.getPackageName().equals(localObject1)) {
              continue;
            }
            TLogger.ii("PushMessageRunnable", "Receiver msg from other app :" + (String)localObject1);
            ServiceStat.appReportPullupAck(this.b, this.c);
            localObject1 = localPushMessageManager.getMessageHolder();
            if (localObject1 == null) {
              continue;
            }
            bool = i.b(localPushMessageManager.getContent());
            if (bool) {
              continue;
            }
            try
            {
              if (new c(this.b, this.c).a(localPushMessageManager, l4, l1, l2))
              {
                a();
                MessageManager.getInstance().updateCachedMsgIntentToShowed(this.b, localPushMessageManager.getMsgId());
                if (((a)localObject1).b() == 1) {
                  localPushMessageManager.showNotifacition();
                }
              }
              else
              {
                MessageManager.getInstance().updateCachedMsgIntentToVerifyErr(this.b, localPushMessageManager.getMsgId());
              }
            }
            catch (Throwable localThrowable2)
            {
              TLogger.e("PushMessageRunnable", "unknown error", localThrowable2);
              MessageManager.getInstance().updateCachedMsgIntentToVerifyErr(this.b, localPushMessageManager.getMsgId());
            }
            continue;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            TLogger.e("PushMessageRunnable", "push msg type error", localIllegalArgumentException);
            continue;
            this.d = null;
            Object localObject2 = null;
            continue;
          }
          catch (Throwable localThrowable3)
          {
            TLogger.e("PushMessageRunnable", "unknown error", localThrowable3);
            continue;
            this.d.onSuccess("", 0);
            continue;
            continue;
            Object localObject3 = null;
            continue;
          }
          try
          {
            j = String.valueOf(System.currentTimeMillis()).length();
            k = String.valueOf(l2).length();
            l1 = l2;
            if (j - k == 3) {
              l1 = l2 * 1000L;
            }
          }
          catch (Throwable localThrowable1)
          {
            TLogger.e("PushMessageHandler", "", localThrowable1);
            l1 = l2;
          }
        }
        l1 += i * 1000;
        str1 = this.c.getPackage();
        l4 = System.currentTimeMillis();
        l2 = this.c.getLongExtra("msgId", -1L);
        localPushMessageManager = PushMessageManager.getInstance(this.b, this.c);
        str1 = "@" + l2 + str1 + "@";
        l3 = this.c.getLongExtra("accId", -1L);
        str3 = MessageManager.getNotifiedMsgIds(this.b, l3);
        if (localPushMessageManager.getType() == 7L)
        {
          if ((!str3.contains(str1)) && (!i.b(localPushMessageManager.getInMsg()))) {
            com.tencent.android.tpush.b.a.a(this.b, localPushMessageManager);
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.e
 * JD-Core Version:    0.7.0.1
 */