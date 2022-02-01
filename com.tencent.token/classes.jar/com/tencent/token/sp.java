package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tmsdk.common.util.TmsLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public final class sp
{
  ReentrantLock a = new ReentrantLock();
  public Handler b;
  private ConcurrentHashMap<String, Long> c = new ConcurrentHashMap();
  
  private sp()
  {
    HandlerThread localHandlerThread = new HandlerThread("CoreCGIManager", 5);
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  public static xt a()
  {
    TmsLog.i("CoreCGIManager", "invoke doInitTask()");
    xt localxt = new xt();
    localxt.a = 0;
    return localxt;
  }
  
  /* Error */
  final xt a(final long paramLong, int paramInt)
  {
    // Byte code:
    //   0: new 87	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 89
    //   6: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore 4
    //   11: aload 4
    //   13: invokestatic 98	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 102	java/lang/Thread:getId	()J
    //   19: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: ldc 108
    //   25: aload 4
    //   27: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 76	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 43	com/tencent/token/sp:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   37: ldc 114
    //   39: invokevirtual 118	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   42: ifeq +54 -> 96
    //   45: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   48: aload_0
    //   49: getfield 43	com/tencent/token/sp:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   52: ldc 114
    //   54: invokevirtual 127	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 129	java/lang/Long
    //   60: invokevirtual 132	java/lang/Long:longValue	()J
    //   63: lsub
    //   64: invokestatic 138	java/lang/Math:abs	(J)J
    //   67: ldc2_w 139
    //   70: lcmp
    //   71: ifge +25 -> 96
    //   74: new 78	com/tencent/token/xt
    //   77: dup
    //   78: invokespecial 79	com/tencent/token/xt:<init>	()V
    //   81: astore 4
    //   83: aload 4
    //   85: sipush 10000
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 143	com/tencent/token/xt:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   93: aload 4
    //   95: areturn
    //   96: aload_0
    //   97: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   100: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   103: new 148	java/util/concurrent/CountDownLatch
    //   106: dup
    //   107: iconst_1
    //   108: invokespecial 151	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   111: astore 5
    //   113: new 153	java/util/concurrent/atomic/AtomicReference
    //   116: dup
    //   117: invokespecial 154	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   120: astore 4
    //   122: invokestatic 159	com/tencent/token/rt:a	()Lcom/tencent/token/rt;
    //   125: lload_1
    //   126: iload_3
    //   127: new 10	com/tencent/token/sp$3
    //   130: dup
    //   131: aload_0
    //   132: lload_1
    //   133: iload_3
    //   134: aload 4
    //   136: aload 5
    //   138: invokespecial 162	com/tencent/token/sp$3:<init>	(Lcom/tencent/token/sp;JILjava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/CountDownLatch;)V
    //   141: invokevirtual 166	com/tencent/token/rt:e	(JILcom/tencent/token/rt$a;)V
    //   144: aload 5
    //   146: invokevirtual 169	java/util/concurrent/CountDownLatch:await	()V
    //   149: goto +10 -> 159
    //   152: astore 5
    //   154: aload 5
    //   156: invokevirtual 172	java/lang/Throwable:printStackTrace	()V
    //   159: aload 4
    //   161: invokevirtual 175	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   164: checkcast 78	com/tencent/token/xt
    //   167: astore 4
    //   169: new 87	java/lang/StringBuilder
    //   172: dup
    //   173: ldc 177
    //   175: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: astore 5
    //   180: aload 5
    //   182: aload 4
    //   184: getfield 82	com/tencent/token/xt:a	I
    //   187: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 108
    //   193: aload 5
    //   195: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 76	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: getfield 43	com/tencent/token/sp:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   205: ldc 114
    //   207: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   210: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   213: invokevirtual 188	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   216: pop
    //   217: aload 4
    //   219: astore 5
    //   221: aload_0
    //   222: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   225: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   228: aload 4
    //   230: areturn
    //   231: astore 4
    //   233: ldc 47
    //   235: aload 4
    //   237: invokevirtual 192	java/lang/Throwable:toString	()Ljava/lang/String;
    //   240: invokestatic 195	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 5
    //   245: areturn
    //   246: astore 5
    //   248: goto +13 -> 261
    //   251: astore 4
    //   253: goto +32 -> 285
    //   256: astore 5
    //   258: aconst_null
    //   259: astore 4
    //   261: ldc 47
    //   263: aload 5
    //   265: invokevirtual 192	java/lang/Throwable:toString	()Ljava/lang/String;
    //   268: invokestatic 195	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload 4
    //   273: astore 5
    //   275: aload_0
    //   276: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   279: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   282: aload 4
    //   284: areturn
    //   285: aload_0
    //   286: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   289: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   292: goto +15 -> 307
    //   295: astore 5
    //   297: ldc 47
    //   299: aload 5
    //   301: invokevirtual 192	java/lang/Throwable:toString	()Ljava/lang/String;
    //   304: invokestatic 195	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 4
    //   309: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	sp
    //   0	310	1	paramLong	long
    //   0	310	3	paramInt	int
    //   9	220	4	localObject1	Object
    //   231	5	4	localThrowable1	java.lang.Throwable
    //   251	1	4	localObject2	Object
    //   259	49	4	localxt1	xt
    //   111	34	5	localCountDownLatch	CountDownLatch
    //   152	3	5	localThrowable2	java.lang.Throwable
    //   178	66	5	localObject3	Object
    //   246	1	5	localThrowable3	java.lang.Throwable
    //   256	8	5	localThrowable4	java.lang.Throwable
    //   273	1	5	localxt2	xt
    //   295	5	5	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   144	149	152	java/lang/Throwable
    //   221	228	231	java/lang/Throwable
    //   275	282	231	java/lang/Throwable
    //   169	217	246	java/lang/Throwable
    //   96	144	251	finally
    //   144	149	251	finally
    //   154	159	251	finally
    //   159	169	251	finally
    //   169	217	251	finally
    //   261	271	251	finally
    //   96	144	256	java/lang/Throwable
    //   154	159	256	java/lang/Throwable
    //   159	169	256	java/lang/Throwable
    //   285	292	295	java/lang/Throwable
  }
  
  public final void a(final long paramLong, int paramInt, final Handler paramHandler)
  {
    if ((this.c.containsKey("mbtoken3_query_captcha")) && (System.currentTimeMillis() - ((Long)this.c.get("mbtoken3_query_captcha")).longValue() < 1000L))
    {
      TmsLog.w("CoreCGIManager", " sendQueryCaptha() has been called in 1s.");
      return;
    }
    TmsLog.i("CoreCGIManager", "invoke sendQueryCaptha()");
    this.b.post(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 22	com/tencent/token/sp$2:d	Lcom/tencent/token/sp;
        //   4: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 22	com/tencent/token/sp$2:d	Lcom/tencent/token/sp;
        //   14: aload_0
        //   15: getfield 24	com/tencent/token/sp$2:a	J
        //   18: aload_0
        //   19: getfield 26	com/tencent/token/sp$2:b	I
        //   22: invokevirtual 46	com/tencent/token/sp:a	(JI)Lcom/tencent/token/xt;
        //   25: astore_1
        //   26: aload_0
        //   27: getfield 28	com/tencent/token/sp$2:c	Landroid/os/Handler;
        //   30: sipush 3071
        //   33: invokevirtual 52	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   36: astore_2
        //   37: aload_2
        //   38: aload_1
        //   39: getfield 56	com/tencent/token/xt:a	I
        //   42: putfield 61	android/os/Message:arg1	I
        //   45: aload_1
        //   46: getfield 56	com/tencent/token/xt:a	I
        //   49: ifne +14 -> 63
        //   52: aload_2
        //   53: aload_1
        //   54: getfield 64	com/tencent/token/xt:d	Ljava/lang/Object;
        //   57: putfield 67	android/os/Message:obj	Ljava/lang/Object;
        //   60: goto +8 -> 68
        //   63: aload_2
        //   64: aload_1
        //   65: putfield 67	android/os/Message:obj	Ljava/lang/Object;
        //   68: aload_2
        //   69: invokevirtual 70	android/os/Message:sendToTarget	()V
        //   72: new 72	java/lang/StringBuilder
        //   75: dup
        //   76: ldc 74
        //   78: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   81: astore_2
        //   82: aload_2
        //   83: aload_1
        //   84: getfield 56	com/tencent/token/xt:a	I
        //   87: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   90: pop
        //   91: ldc 83
        //   93: aload_2
        //   94: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   97: invokestatic 93	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   100: aload_0
        //   101: getfield 22	com/tencent/token/sp$2:d	Lcom/tencent/token/sp;
        //   104: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   107: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   110: return
        //   111: astore_1
        //   112: ldc 83
        //   114: aload_1
        //   115: invokevirtual 97	java/lang/Throwable:toString	()Ljava/lang/String;
        //   118: invokestatic 100	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   121: return
        //   122: astore_1
        //   123: goto +24 -> 147
        //   126: astore_1
        //   127: ldc 83
        //   129: aload_1
        //   130: invokevirtual 97	java/lang/Throwable:toString	()Ljava/lang/String;
        //   133: invokestatic 100	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   136: aload_0
        //   137: getfield 22	com/tencent/token/sp$2:d	Lcom/tencent/token/sp;
        //   140: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   143: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   146: return
        //   147: aload_0
        //   148: getfield 22	com/tencent/token/sp$2:d	Lcom/tencent/token/sp;
        //   151: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   154: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   157: goto +13 -> 170
        //   160: astore_2
        //   161: ldc 83
        //   163: aload_2
        //   164: invokevirtual 97	java/lang/Throwable:toString	()Ljava/lang/String;
        //   167: invokestatic 100	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   170: aload_1
        //   171: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	172	0	this	2
        //   25	59	1	localxt	xt
        //   111	4	1	localThrowable1	java.lang.Throwable
        //   122	1	1	localObject1	Object
        //   126	45	1	localThrowable2	java.lang.Throwable
        //   36	58	2	localObject2	Object
        //   160	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   100	110	111	java/lang/Throwable
        //   136	146	111	java/lang/Throwable
        //   0	60	122	finally
        //   63	68	122	finally
        //   68	100	122	finally
        //   127	136	122	finally
        //   0	60	126	java/lang/Throwable
        //   63	68	126	java/lang/Throwable
        //   68	100	126	java/lang/Throwable
        //   147	157	160	java/lang/Throwable
      }
    });
  }
  
  public final void a(final Handler paramHandler)
  {
    if ((this.c.containsKey("mbtoken3_activate_token")) && (System.currentTimeMillis() - ((Long)this.c.get("mbtoken3_activate_token")).longValue() < 1000L))
    {
      TmsLog.w("CoreCGIManager", " sendActiveToken() has been called in 1s.");
      return;
    }
    TmsLog.i("CoreCGIManager", "invoke sendActiveToken()");
    this.b.post(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/tencent/token/sp$4:b	Lcom/tencent/token/sp;
        //   4: getfield 30	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: new 37	java/lang/StringBuilder
        //   13: dup
        //   14: ldc 39
        //   16: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   19: astore_1
        //   20: aload_1
        //   21: invokestatic 48	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   24: invokevirtual 52	java/lang/Thread:getId	()J
        //   27: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   30: pop
        //   31: ldc 58
        //   33: aload_1
        //   34: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   37: invokestatic 68	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   40: new 70	com/tencent/token/xt
        //   43: dup
        //   44: invokespecial 71	com/tencent/token/xt:<init>	()V
        //   47: astore_1
        //   48: aload_1
        //   49: iconst_0
        //   50: putfield 74	com/tencent/token/xt:a	I
        //   53: aload_0
        //   54: getfield 20	com/tencent/token/sp$4:a	Landroid/os/Handler;
        //   57: sipush 3025
        //   60: invokevirtual 80	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   63: astore_2
        //   64: aload_2
        //   65: aload_1
        //   66: getfield 74	com/tencent/token/xt:a	I
        //   69: putfield 85	android/os/Message:arg1	I
        //   72: aload_2
        //   73: aload_1
        //   74: putfield 89	android/os/Message:obj	Ljava/lang/Object;
        //   77: aload_2
        //   78: invokevirtual 92	android/os/Message:sendToTarget	()V
        //   81: new 37	java/lang/StringBuilder
        //   84: dup
        //   85: ldc 94
        //   87: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   90: astore_2
        //   91: aload_2
        //   92: aload_1
        //   93: getfield 74	com/tencent/token/xt:a	I
        //   96: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   99: pop
        //   100: ldc 99
        //   102: aload_2
        //   103: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   106: invokestatic 68	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   109: aload_0
        //   110: getfield 18	com/tencent/token/sp$4:b	Lcom/tencent/token/sp;
        //   113: getfield 30	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   116: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   119: return
        //   120: astore_1
        //   121: ldc 99
        //   123: aload_1
        //   124: invokevirtual 103	java/lang/Throwable:toString	()Ljava/lang/String;
        //   127: invokestatic 106	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   130: return
        //   131: astore_1
        //   132: goto +24 -> 156
        //   135: astore_1
        //   136: ldc 99
        //   138: aload_1
        //   139: invokevirtual 103	java/lang/Throwable:toString	()Ljava/lang/String;
        //   142: invokestatic 106	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   145: aload_0
        //   146: getfield 18	com/tencent/token/sp$4:b	Lcom/tencent/token/sp;
        //   149: getfield 30	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   152: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   155: return
        //   156: aload_0
        //   157: getfield 18	com/tencent/token/sp$4:b	Lcom/tencent/token/sp;
        //   160: getfield 30	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   163: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   166: goto +13 -> 179
        //   169: astore_2
        //   170: ldc 99
        //   172: aload_2
        //   173: invokevirtual 103	java/lang/Throwable:toString	()Ljava/lang/String;
        //   176: invokestatic 106	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   179: aload_1
        //   180: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	181	0	this	4
        //   19	74	1	localObject1	Object
        //   120	4	1	localThrowable1	java.lang.Throwable
        //   131	1	1	localObject2	Object
        //   135	45	1	localThrowable2	java.lang.Throwable
        //   63	40	2	localObject3	Object
        //   169	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   109	119	120	java/lang/Throwable
        //   145	155	120	java/lang/Throwable
        //   0	109	131	finally
        //   136	145	131	finally
        //   0	109	135	java/lang/Throwable
        //   156	166	169	java/lang/Throwable
      }
    });
  }
  
  public final void b()
  {
    TmsLog.i("CoreCGIManager", "invoke sendExchangeKey()");
    this.b.post(new Object() {});
  }
  
  public final void b(final Handler paramHandler)
  {
    if ((this.c.containsKey("mbtoken3_get_uin_list_v2")) && (Math.abs(System.currentTimeMillis() - ((Long)this.c.get("mbtoken3_get_uin_list_v2")).longValue()) < 1000L))
    {
      TmsLog.w("CoreCGIManager", " sendGetUinList() has been called in 1s.");
      return;
    }
    TmsLog.i("CoreCGIManager", "invoke sendGetUinList()");
    this.b.post(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/tencent/token/sp$6:b	Lcom/tencent/token/sp;
        //   4: getfield 30	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 18	com/tencent/token/sp$6:b	Lcom/tencent/token/sp;
        //   14: invokevirtual 39	com/tencent/token/sp:d	()Lcom/tencent/token/xt;
        //   17: astore_1
        //   18: aload_0
        //   19: getfield 20	com/tencent/token/sp$6:a	Landroid/os/Handler;
        //   22: sipush 3003
        //   25: invokevirtual 45	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   28: astore_2
        //   29: aload_2
        //   30: aload_1
        //   31: getfield 50	com/tencent/token/xt:a	I
        //   34: putfield 55	android/os/Message:arg1	I
        //   37: aload_2
        //   38: aload_1
        //   39: putfield 59	android/os/Message:obj	Ljava/lang/Object;
        //   42: aload_2
        //   43: invokevirtual 62	android/os/Message:sendToTarget	()V
        //   46: new 64	java/lang/StringBuilder
        //   49: dup
        //   50: ldc 66
        //   52: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   55: astore_2
        //   56: aload_2
        //   57: aload_1
        //   58: getfield 50	com/tencent/token/xt:a	I
        //   61: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   64: pop
        //   65: ldc 75
        //   67: aload_2
        //   68: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   71: invokestatic 85	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   74: aload_0
        //   75: getfield 18	com/tencent/token/sp$6:b	Lcom/tencent/token/sp;
        //   78: getfield 30	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   81: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   84: return
        //   85: astore_1
        //   86: ldc 75
        //   88: aload_1
        //   89: invokevirtual 89	java/lang/Throwable:toString	()Ljava/lang/String;
        //   92: invokestatic 92	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   95: return
        //   96: astore_1
        //   97: goto +24 -> 121
        //   100: astore_1
        //   101: ldc 75
        //   103: aload_1
        //   104: invokevirtual 89	java/lang/Throwable:toString	()Ljava/lang/String;
        //   107: invokestatic 92	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   110: aload_0
        //   111: getfield 18	com/tencent/token/sp$6:b	Lcom/tencent/token/sp;
        //   114: getfield 30	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   117: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   120: return
        //   121: aload_0
        //   122: getfield 18	com/tencent/token/sp$6:b	Lcom/tencent/token/sp;
        //   125: getfield 30	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   128: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   131: goto +13 -> 144
        //   134: astore_2
        //   135: ldc 75
        //   137: aload_2
        //   138: invokevirtual 89	java/lang/Throwable:toString	()Ljava/lang/String;
        //   141: invokestatic 92	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   144: aload_1
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	6
        //   17	41	1	localxt	xt
        //   85	4	1	localThrowable1	java.lang.Throwable
        //   96	1	1	localObject1	Object
        //   100	45	1	localThrowable2	java.lang.Throwable
        //   28	40	2	localObject2	Object
        //   134	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   74	84	85	java/lang/Throwable
        //   110	120	85	java/lang/Throwable
        //   0	74	96	finally
        //   101	110	96	finally
        //   0	74	100	java/lang/Throwable
        //   121	131	134	java/lang/Throwable
      }
    });
  }
  
  public final xt c()
  {
    final AtomicReference localAtomicReference = new AtomicReference();
    this.b.post(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 21	com/tencent/token/sp$5:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   4: aload_0
        //   5: getfield 19	com/tencent/token/sp$5:b	Lcom/tencent/token/sp;
        //   8: invokevirtual 31	com/tencent/token/sp:d	()Lcom/tencent/token/xt;
        //   11: invokevirtual 37	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
        //   14: aload_0
        //   15: getfield 21	com/tencent/token/sp$5:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   18: astore_1
        //   19: aload_1
        //   20: monitorenter
        //   21: aload_0
        //   22: getfield 21	com/tencent/token/sp$5:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   25: invokevirtual 40	java/lang/Object:notify	()V
        //   28: aload_1
        //   29: monitorexit
        //   30: return
        //   31: astore_2
        //   32: aload_1
        //   33: monitorexit
        //   34: aload_2
        //   35: athrow
        //   36: astore_2
        //   37: goto +35 -> 72
        //   40: astore_1
        //   41: ldc 42
        //   43: aload_1
        //   44: invokevirtual 46	java/lang/Throwable:toString	()Ljava/lang/String;
        //   47: invokestatic 52	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   50: aload_0
        //   51: getfield 21	com/tencent/token/sp$5:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   54: astore_1
        //   55: aload_1
        //   56: monitorenter
        //   57: aload_0
        //   58: getfield 21	com/tencent/token/sp$5:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   61: invokevirtual 40	java/lang/Object:notify	()V
        //   64: aload_1
        //   65: monitorexit
        //   66: return
        //   67: astore_2
        //   68: aload_1
        //   69: monitorexit
        //   70: aload_2
        //   71: athrow
        //   72: aload_0
        //   73: getfield 21	com/tencent/token/sp$5:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   76: astore_1
        //   77: aload_1
        //   78: monitorenter
        //   79: aload_0
        //   80: getfield 21	com/tencent/token/sp$5:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   83: invokevirtual 40	java/lang/Object:notify	()V
        //   86: aload_1
        //   87: monitorexit
        //   88: aload_2
        //   89: athrow
        //   90: astore_2
        //   91: aload_1
        //   92: monitorexit
        //   93: aload_2
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	5
        //   18	15	1	localAtomicReference1	AtomicReference
        //   40	4	1	localThrowable	java.lang.Throwable
        //   54	38	1	localAtomicReference2	AtomicReference
        //   31	4	2	localObject1	Object
        //   36	1	2	localObject2	Object
        //   67	22	2	localObject3	Object
        //   90	4	2	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   21	30	31	finally
        //   32	34	31	finally
        //   0	14	36	finally
        //   41	50	36	finally
        //   0	14	40	java/lang/Throwable
        //   57	66	67	finally
        //   68	70	67	finally
        //   79	88	90	finally
        //   91	93	90	finally
      }
    });
    try
    {
      try
      {
        localAtomicReference.wait(90000L);
      }
      finally
      {
        break label80;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label41:
      xt localxt;
      label80:
      break label41;
    }
    if (localAtomicReference.get() == null)
    {
      localxt = new xt();
      localxt.a(10000, null, null);
      localAtomicReference.set(localxt);
    }
    return (xt)localAtomicReference.get();
    throw localxt;
  }
  
  /* Error */
  final xt d()
  {
    // Byte code:
    //   0: new 87	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 247
    //   6: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic 98	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14: invokevirtual 102	java/lang/Thread:getId	()J
    //   17: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: ldc 108
    //   23: aload_1
    //   24: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 76	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 43	com/tencent/token/sp:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   34: ldc 224
    //   36: invokevirtual 118	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   39: ifeq +38 -> 77
    //   42: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   45: aload_0
    //   46: getfield 43	com/tencent/token/sp:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   49: ldc 224
    //   51: invokevirtual 127	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 129	java/lang/Long
    //   57: invokevirtual 132	java/lang/Long:longValue	()J
    //   60: lsub
    //   61: invokestatic 138	java/lang/Math:abs	(J)J
    //   64: ldc2_w 139
    //   67: lcmp
    //   68: ifge +9 -> 77
    //   71: ldc2_w 139
    //   74: invokestatic 250	java/lang/Thread:sleep	(J)V
    //   77: aload_0
    //   78: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   81: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   84: new 148	java/util/concurrent/CountDownLatch
    //   87: dup
    //   88: iconst_1
    //   89: invokespecial 151	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   92: astore_2
    //   93: new 153	java/util/concurrent/atomic/AtomicReference
    //   96: dup
    //   97: invokespecial 154	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   100: astore_1
    //   101: invokestatic 159	com/tencent/token/rt:a	()Lcom/tencent/token/rt;
    //   104: new 20	com/tencent/token/sp$8
    //   107: dup
    //   108: aload_0
    //   109: aload_1
    //   110: aload_2
    //   111: invokespecial 253	com/tencent/token/sp$8:<init>	(Lcom/tencent/token/sp;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/CountDownLatch;)V
    //   114: invokevirtual 256	com/tencent/token/rt:a	(Lcom/tencent/token/rt$a;)V
    //   117: aload_2
    //   118: invokevirtual 169	java/util/concurrent/CountDownLatch:await	()V
    //   121: goto +8 -> 129
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual 172	java/lang/Throwable:printStackTrace	()V
    //   129: aload_1
    //   130: invokevirtual 175	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   133: checkcast 78	com/tencent/token/xt
    //   136: astore_1
    //   137: new 87	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 258
    //   144: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: astore_2
    //   148: aload_2
    //   149: aload_1
    //   150: getfield 82	com/tencent/token/xt:a	I
    //   153: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 108
    //   159: aload_2
    //   160: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 76	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_0
    //   167: getfield 43	com/tencent/token/sp:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   170: ldc 224
    //   172: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   175: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   178: invokevirtual 188	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   181: pop
    //   182: aload_1
    //   183: astore_2
    //   184: aload_0
    //   185: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   188: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   191: aload_1
    //   192: areturn
    //   193: astore_1
    //   194: ldc 47
    //   196: aload_1
    //   197: invokevirtual 192	java/lang/Throwable:toString	()Ljava/lang/String;
    //   200: invokestatic 195	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_2
    //   204: areturn
    //   205: astore_2
    //   206: goto +10 -> 216
    //   209: astore_1
    //   210: goto +26 -> 236
    //   213: astore_2
    //   214: aconst_null
    //   215: astore_1
    //   216: ldc 47
    //   218: aload_2
    //   219: invokevirtual 192	java/lang/Throwable:toString	()Ljava/lang/String;
    //   222: invokestatic 195	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_1
    //   226: astore_2
    //   227: aload_0
    //   228: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   231: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   234: aload_1
    //   235: areturn
    //   236: aload_0
    //   237: getfield 38	com/tencent/token/sp:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   240: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   243: goto +13 -> 256
    //   246: astore_2
    //   247: ldc 47
    //   249: aload_2
    //   250: invokevirtual 192	java/lang/Throwable:toString	()Ljava/lang/String;
    //   253: invokestatic 195	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: goto -182 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	sp
    //   9	183	1	localObject1	Object
    //   193	4	1	localThrowable1	java.lang.Throwable
    //   209	1	1	localObject2	Object
    //   215	42	1	localxt1	xt
    //   258	1	1	localThrowable2	java.lang.Throwable
    //   92	26	2	localCountDownLatch	CountDownLatch
    //   124	2	2	localThrowable3	java.lang.Throwable
    //   147	57	2	localObject3	Object
    //   205	1	2	localThrowable4	java.lang.Throwable
    //   213	6	2	localThrowable5	java.lang.Throwable
    //   226	1	2	localxt2	xt
    //   246	4	2	localThrowable6	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   117	121	124	java/lang/Throwable
    //   184	191	193	java/lang/Throwable
    //   227	234	193	java/lang/Throwable
    //   137	182	205	java/lang/Throwable
    //   77	117	209	finally
    //   117	121	209	finally
    //   125	129	209	finally
    //   129	137	209	finally
    //   137	182	209	finally
    //   216	225	209	finally
    //   77	117	213	java/lang/Throwable
    //   125	129	213	java/lang/Throwable
    //   129	137	213	java/lang/Throwable
    //   236	243	246	java/lang/Throwable
    //   71	77	258	java/lang/Throwable
  }
  
  public static final class a
  {
    private static sp a = new sp((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sp
 * JD-Core Version:    0.7.0.1
 */