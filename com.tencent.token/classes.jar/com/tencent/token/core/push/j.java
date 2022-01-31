package com.tencent.token.core.push;

import android.content.BroadcastReceiver;

class j
  extends BroadcastReceiver
{
  private boolean b = false;
  
  j(PushService paramPushService) {}
  
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 28	android/content/Intent:getAction	()Ljava/lang/String;
    //   4: ldc 30
    //   6: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +138 -> 147
    //   12: aload_0
    //   13: getfield 12	com/tencent/token/core/push/j:a	Lcom/tencent/token/core/push/PushService;
    //   16: ldc 38
    //   18: invokevirtual 44	com/tencent/token/core/push/PushService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   21: checkcast 46	android/net/ConnectivityManager
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +4 -> 30
    //   29: return
    //   30: aload_1
    //   31: invokevirtual 50	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +81 -> 117
    //   39: aload_1
    //   40: invokevirtual 56	android/net/NetworkInfo:isConnected	()Z
    //   43: ifeq +74 -> 117
    //   46: invokestatic 61	com/tencent/token/core/push/b:a	()Lcom/tencent/token/core/push/b;
    //   49: iconst_1
    //   50: invokevirtual 64	com/tencent/token/core/push/b:a	(I)V
    //   53: aload_0
    //   54: getfield 17	com/tencent/token/core/push/j:b	Z
    //   57: istore_3
    //   58: iload_3
    //   59: ifeq +88 -> 147
    //   62: aload_0
    //   63: getfield 12	com/tencent/token/core/push/j:a	Lcom/tencent/token/core/push/PushService;
    //   66: invokestatic 66	com/tencent/token/core/push/PushService:a	(Lcom/tencent/token/core/push/PushService;)V
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 17	com/tencent/token/core/push/j:b	Z
    //   74: return
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 69	java/lang/Exception:printStackTrace	()V
    //   80: new 71	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   87: ldc 74
    //   89: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_1
    //   93: invokevirtual 81	java/lang/Exception:toString	()Ljava/lang/String;
    //   96: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 88	com/tencent/token/global/h:d	(Ljava/lang/String;)V
    //   105: return
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 91	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: invokestatic 94	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   114: goto -45 -> 69
    //   117: aload_0
    //   118: iconst_1
    //   119: putfield 17	com/tencent/token/core/push/j:b	Z
    //   122: invokestatic 61	com/tencent/token/core/push/b:a	()Lcom/tencent/token/core/push/b;
    //   125: bipush 7
    //   127: invokevirtual 64	com/tencent/token/core/push/b:a	(I)V
    //   130: aload_0
    //   131: getfield 12	com/tencent/token/core/push/j:a	Lcom/tencent/token/core/push/PushService;
    //   134: invokestatic 97	com/tencent/token/core/push/PushService:c	(Lcom/tencent/token/core/push/PushService;)Landroid/app/AlarmManager;
    //   137: aload_0
    //   138: getfield 12	com/tencent/token/core/push/j:a	Lcom/tencent/token/core/push/PushService;
    //   141: invokestatic 100	com/tencent/token/core/push/PushService:b	(Lcom/tencent/token/core/push/PushService;)Landroid/app/PendingIntent;
    //   144: invokevirtual 106	android/app/AlarmManager:cancel	(Landroid/app/PendingIntent;)V
    //   147: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	j
    //   0	148	1	paramContext	android.content.Context
    //   0	148	2	paramIntent	android.content.Intent
    //   57	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	25	75	java/lang/Exception
    //   30	35	75	java/lang/Exception
    //   39	58	75	java/lang/Exception
    //   69	74	75	java/lang/Exception
    //   107	114	75	java/lang/Exception
    //   117	147	75	java/lang/Exception
    //   62	69	106	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.j
 * JD-Core Version:    0.7.0.1
 */