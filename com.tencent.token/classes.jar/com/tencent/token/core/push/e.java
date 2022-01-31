package com.tencent.token.core.push;

import android.content.BroadcastReceiver;

final class e
  extends BroadcastReceiver
{
  private boolean b = false;
  
  e(PushService paramPushService) {}
  
  /* Error */
  public final void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 28	android/content/Intent:getAction	()Ljava/lang/String;
    //   4: ldc 30
    //   6: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +141 -> 150
    //   12: aload_0
    //   13: getfield 12	com/tencent/token/core/push/e:a	Lcom/tencent/token/core/push/PushService;
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
    //   36: ifnull +83 -> 119
    //   39: aload_1
    //   40: invokevirtual 56	android/net/NetworkInfo:isConnected	()Z
    //   43: ifeq +76 -> 119
    //   46: invokestatic 61	com/tencent/token/core/push/a:a	()Lcom/tencent/token/core/push/a;
    //   49: iconst_1
    //   50: invokevirtual 64	com/tencent/token/core/push/a:a	(I)V
    //   53: aload_0
    //   54: getfield 17	com/tencent/token/core/push/e:b	Z
    //   57: istore 4
    //   59: iload 4
    //   61: ifeq +237 -> 298
    //   64: aload_0
    //   65: getfield 12	com/tencent/token/core/push/e:a	Lcom/tencent/token/core/push/PushService;
    //   68: invokestatic 66	com/tencent/token/core/push/PushService:a	(Lcom/tencent/token/core/push/PushService;)V
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 17	com/tencent/token/core/push/e:b	Z
    //   76: return
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 69	java/lang/Exception:printStackTrace	()V
    //   82: new 71	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   89: ldc 74
    //   91: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 81	java/lang/Exception:toString	()Ljava/lang/String;
    //   98: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 88	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   107: return
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 91	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   113: invokestatic 94	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   116: goto -45 -> 71
    //   119: aload_0
    //   120: iconst_1
    //   121: putfield 17	com/tencent/token/core/push/e:b	Z
    //   124: invokestatic 61	com/tencent/token/core/push/a:a	()Lcom/tencent/token/core/push/a;
    //   127: bipush 7
    //   129: invokevirtual 64	com/tencent/token/core/push/a:a	(I)V
    //   132: aload_0
    //   133: getfield 12	com/tencent/token/core/push/e:a	Lcom/tencent/token/core/push/PushService;
    //   136: invokestatic 97	com/tencent/token/core/push/PushService:c	(Lcom/tencent/token/core/push/PushService;)Landroid/app/AlarmManager;
    //   139: aload_0
    //   140: getfield 12	com/tencent/token/core/push/e:a	Lcom/tencent/token/core/push/PushService;
    //   143: invokestatic 100	com/tencent/token/core/push/PushService:b	(Lcom/tencent/token/core/push/PushService;)Landroid/app/PendingIntent;
    //   146: invokevirtual 106	android/app/AlarmManager:cancel	(Landroid/app/PendingIntent;)V
    //   149: return
    //   150: aload_2
    //   151: invokevirtual 28	android/content/Intent:getAction	()Ljava/lang/String;
    //   154: ldc 108
    //   156: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   159: ifeq +89 -> 248
    //   162: ldc 110
    //   164: invokestatic 94	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield 12	com/tencent/token/core/push/e:a	Lcom/tencent/token/core/push/PushService;
    //   171: aload_2
    //   172: invokestatic 113	com/tencent/token/core/push/PushService:a	(Lcom/tencent/token/core/push/PushService;Landroid/content/Intent;)Z
    //   175: ifeq +123 -> 298
    //   178: aload_0
    //   179: getfield 12	com/tencent/token/core/push/e:a	Lcom/tencent/token/core/push/PushService;
    //   182: invokestatic 116	com/tencent/token/core/push/PushService:d	(Lcom/tencent/token/core/push/PushService;)Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   185: invokevirtual 122	java/util/concurrent/ConcurrentLinkedQueue:peek	()Ljava/lang/Object;
    //   188: checkcast 124	com/tencent/token/core/bean/b
    //   191: astore_1
    //   192: aload_1
    //   193: ifnull +105 -> 298
    //   196: new 24	android/content/Intent
    //   199: dup
    //   200: aload_0
    //   201: getfield 12	com/tencent/token/core/push/e:a	Lcom/tencent/token/core/push/PushService;
    //   204: ldc 126
    //   206: invokespecial 129	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   209: astore_2
    //   210: aload_2
    //   211: ldc 130
    //   213: invokevirtual 134	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   216: pop
    //   217: aload_2
    //   218: ldc 136
    //   220: aload_1
    //   221: invokevirtual 139	com/tencent/token/core/bean/b:f	()Ljava/lang/String;
    //   224: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   227: pop
    //   228: aload_2
    //   229: ldc 145
    //   231: aload_1
    //   232: invokevirtual 148	com/tencent/token/core/bean/b:g	()Ljava/lang/String;
    //   235: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   238: pop
    //   239: aload_0
    //   240: getfield 12	com/tencent/token/core/push/e:a	Lcom/tencent/token/core/push/PushService;
    //   243: aload_2
    //   244: invokevirtual 152	com/tencent/token/core/push/PushService:startActivity	(Landroid/content/Intent;)V
    //   247: return
    //   248: aload_2
    //   249: invokevirtual 28	android/content/Intent:getAction	()Ljava/lang/String;
    //   252: ldc 154
    //   254: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   257: ifeq +41 -> 298
    //   260: ldc 156
    //   262: invokestatic 94	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   265: aload_2
    //   266: ldc 158
    //   268: iconst_3
    //   269: invokevirtual 162	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   272: istore_3
    //   273: new 164	com/tencent/token/core/push/h
    //   276: dup
    //   277: aload_0
    //   278: getfield 12	com/tencent/token/core/push/e:a	Lcom/tencent/token/core/push/PushService;
    //   281: iload_3
    //   282: invokespecial 167	com/tencent/token/core/push/h:<init>	(Lcom/tencent/token/core/push/PushService;I)V
    //   285: iconst_1
    //   286: anewarray 32	java/lang/String
    //   289: dup
    //   290: iconst_0
    //   291: ldc 169
    //   293: aastore
    //   294: invokevirtual 174	com/tencent/token/utils/UserTask:a	([Ljava/lang/Object;)Lcom/tencent/token/utils/UserTask;
    //   297: pop
    //   298: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	e
    //   0	299	1	paramContext	android.content.Context
    //   0	299	2	paramIntent	android.content.Intent
    //   272	10	3	i	int
    //   57	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	25	77	java/lang/Exception
    //   30	35	77	java/lang/Exception
    //   39	59	77	java/lang/Exception
    //   71	76	77	java/lang/Exception
    //   109	116	77	java/lang/Exception
    //   119	149	77	java/lang/Exception
    //   150	192	77	java/lang/Exception
    //   196	247	77	java/lang/Exception
    //   248	298	77	java/lang/Exception
    //   64	71	108	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.e
 * JD-Core Version:    0.7.0.1
 */