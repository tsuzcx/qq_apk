package com.tencent.gamecenter.appointment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import awot;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tba;

public class GameCenterReceiver
  extends BroadcastReceiver
{
  static GameCenterReceiver a;
  public static boolean lm;
  List<tba> listeners = new ArrayList();
  
  public static void a(tba paramtba)
  {
    if (a == null) {}
    while ((paramtba == null) || (a.listeners.contains(paramtba))) {
      return;
    }
    synchronized (a.listeners)
    {
      a.listeners.add(paramtba);
      return;
    }
  }
  
  private void bl(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    ThreadManagerV2.excute(new GameCenterReceiver.2(this, paramIntent), 16, null, true);
  }
  
  private void f(String paramString, Intent paramIntent)
  {
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterReceiver", 2, "receiveSystemInstallAction intentPkgNameString=" + paramIntent);
    }
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.contains(":"))) {}
    do
    {
      return;
      paramIntent = paramIntent.split(":");
    } while (paramIntent.length < 2);
    ThreadManagerV2.excute(new GameCenterReceiver.1(this, paramIntent[1], paramString), 16, null, true);
  }
  
  /* Error */
  public static void registerReceiver()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +41 -> 47
    //   9: ldc 62
    //   11: iconst_2
    //   12: new 64	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   19: ldc 104
    //   21: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 110	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   27: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 115
    //   32: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 117	com/tencent/gamecenter/appointment/GameCenterReceiver:lm	Z
    //   38: invokevirtual 120	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: getstatic 24	com/tencent/gamecenter/appointment/GameCenterReceiver:a	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   50: ifnonnull +13 -> 63
    //   53: new 2	com/tencent/gamecenter/appointment/GameCenterReceiver
    //   56: dup
    //   57: invokespecial 121	com/tencent/gamecenter/appointment/GameCenterReceiver:<init>	()V
    //   60: putstatic 24	com/tencent/gamecenter/appointment/GameCenterReceiver:a	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   63: getstatic 117	com/tencent/gamecenter/appointment/GameCenterReceiver:lm	Z
    //   66: ifne +82 -> 148
    //   69: new 123	android/content/IntentFilter
    //   72: dup
    //   73: invokespecial 124	android/content/IntentFilter:<init>	()V
    //   76: astore_0
    //   77: getstatic 110	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   80: iconst_1
    //   81: if_icmpne +9 -> 90
    //   84: aload_0
    //   85: ldc 126
    //   87: invokevirtual 130	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: ldc 132
    //   93: invokevirtual 130	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   96: new 123	android/content/IntentFilter
    //   99: dup
    //   100: invokespecial 124	android/content/IntentFilter:<init>	()V
    //   103: astore_1
    //   104: aload_1
    //   105: ldc 134
    //   107: invokevirtual 137	android/content/IntentFilter:addDataScheme	(Ljava/lang/String;)V
    //   110: aload_1
    //   111: ldc 139
    //   113: invokevirtual 130	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   116: aload_1
    //   117: ldc 141
    //   119: invokevirtual 130	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   122: invokestatic 145	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   125: getstatic 24	com/tencent/gamecenter/appointment/GameCenterReceiver:a	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   128: aload_1
    //   129: invokevirtual 150	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   132: pop
    //   133: invokestatic 145	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   136: getstatic 24	com/tencent/gamecenter/appointment/GameCenterReceiver:a	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   139: aload_0
    //   140: invokevirtual 150	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   143: pop
    //   144: iconst_1
    //   145: putstatic 117	com/tencent/gamecenter/appointment/GameCenterReceiver:lm	Z
    //   148: ldc 2
    //   150: monitorexit
    //   151: return
    //   152: astore_0
    //   153: ldc 2
    //   155: monitorexit
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: goto -11 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   76	64	0	localIntentFilter1	android.content.IntentFilter
    //   152	5	0	localObject	java.lang.Object
    //   158	1	0	localThrowable	java.lang.Throwable
    //   103	26	1	localIntentFilter2	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   3	47	152	finally
    //   47	63	152	finally
    //   63	90	152	finally
    //   90	122	152	finally
    //   122	148	152	finally
    //   122	148	158	java/lang/Throwable
  }
  
  /* Error */
  public static void unRegisterReceiver()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 62
    //   11: iconst_2
    //   12: ldc 152
    //   14: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: getstatic 24	com/tencent/gamecenter/appointment/GameCenterReceiver:a	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   20: ifnull +24 -> 44
    //   23: getstatic 117	com/tencent/gamecenter/appointment/GameCenterReceiver:lm	Z
    //   26: istore_0
    //   27: iload_0
    //   28: ifeq +12 -> 40
    //   31: invokestatic 145	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   34: getstatic 24	com/tencent/gamecenter/appointment/GameCenterReceiver:a	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   37: invokevirtual 156	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   40: aconst_null
    //   41: putstatic 24	com/tencent/gamecenter/appointment/GameCenterReceiver:a	Lcom/tencent/gamecenter/appointment/GameCenterReceiver;
    //   44: iconst_0
    //   45: putstatic 117	com/tencent/gamecenter/appointment/GameCenterReceiver:lm	Z
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: astore_1
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -19 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	2	0	bool	boolean
    //   52	5	1	localObject	java.lang.Object
    //   58	1	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   3	17	52	finally
    //   17	27	52	finally
    //   31	40	52	finally
    //   40	44	52	finally
    //   44	48	52	finally
    //   31	40	58	java/lang/Throwable
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterReceiver", 2, "onReceive action=" + paramContext);
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        awot.a().S(false, -1L);
        return;
      }
      if (("android.intent.action.PACKAGE_ADDED".equals(paramContext)) || ("android.intent.action.PACKAGE_REMOVED".equals(paramContext)))
      {
        f(paramContext, paramIntent);
        return;
      }
    } while (!"com.tencent.gamecenter.action".equals(paramContext));
    bl(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver
 * JD-Core Version:    0.7.0.1
 */