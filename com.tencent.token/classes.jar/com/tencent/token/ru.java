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

public final class ru
{
  ReentrantLock a = new ReentrantLock();
  public Handler b;
  private ConcurrentHashMap<String, Long> c = new ConcurrentHashMap();
  
  private ru()
  {
    HandlerThread localHandlerThread = new HandlerThread("CoreCGIManager", 5);
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  public static wy a()
  {
    TmsLog.i("CoreCGIManager", "invoke doInitTask()");
    wy localwy = new wy();
    localwy.a = 0;
    return localwy;
  }
  
  /* Error */
  final wy a(final long paramLong, int paramInt)
  {
    // Byte code:
    //   0: new 89	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 91
    //   6: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore 4
    //   11: aload 4
    //   13: invokestatic 100	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 104	java/lang/Thread:getId	()J
    //   19: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: ldc 110
    //   25: aload 4
    //   27: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 78	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 45	com/tencent/token/ru:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   37: ldc 116
    //   39: invokevirtual 120	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   42: ifeq +54 -> 96
    //   45: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   48: aload_0
    //   49: getfield 45	com/tencent/token/ru:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   52: ldc 116
    //   54: invokevirtual 129	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 131	java/lang/Long
    //   60: invokevirtual 134	java/lang/Long:longValue	()J
    //   63: lsub
    //   64: invokestatic 140	java/lang/Math:abs	(J)J
    //   67: ldc2_w 141
    //   70: lcmp
    //   71: ifge +25 -> 96
    //   74: new 80	com/tencent/token/wy
    //   77: dup
    //   78: invokespecial 81	com/tencent/token/wy:<init>	()V
    //   81: astore 4
    //   83: aload 4
    //   85: sipush 10000
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 145	com/tencent/token/wy:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   93: aload 4
    //   95: areturn
    //   96: aload_0
    //   97: getfield 40	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   100: invokevirtual 148	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   103: new 150	java/util/concurrent/CountDownLatch
    //   106: dup
    //   107: iconst_1
    //   108: invokespecial 153	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   111: astore 5
    //   113: new 155	java/util/concurrent/atomic/AtomicReference
    //   116: dup
    //   117: invokespecial 156	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   120: astore 4
    //   122: invokestatic 161	com/tencent/token/qy:a	()Lcom/tencent/token/qy;
    //   125: lload_1
    //   126: iload_3
    //   127: new 10	com/tencent/token/ru$3
    //   130: dup
    //   131: aload_0
    //   132: lload_1
    //   133: iload_3
    //   134: aload 4
    //   136: aload 5
    //   138: invokespecial 164	com/tencent/token/ru$3:<init>	(Lcom/tencent/token/ru;JILjava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/CountDownLatch;)V
    //   141: invokevirtual 168	com/tencent/token/qy:e	(JILcom/tencent/token/qy$a;)V
    //   144: aload 5
    //   146: invokevirtual 171	java/util/concurrent/CountDownLatch:await	()V
    //   149: goto +10 -> 159
    //   152: astore 5
    //   154: aload 5
    //   156: invokevirtual 174	java/lang/Throwable:printStackTrace	()V
    //   159: aload 4
    //   161: invokevirtual 177	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   164: checkcast 80	com/tencent/token/wy
    //   167: astore 4
    //   169: new 89	java/lang/StringBuilder
    //   172: dup
    //   173: ldc 179
    //   175: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: astore 5
    //   180: aload 5
    //   182: aload 4
    //   184: getfield 84	com/tencent/token/wy:a	I
    //   187: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 110
    //   193: aload 5
    //   195: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 78	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: getfield 45	com/tencent/token/ru:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   205: ldc 116
    //   207: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   210: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   213: invokevirtual 190	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   216: pop
    //   217: aload 4
    //   219: astore 5
    //   221: aload_0
    //   222: getfield 40	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   225: invokevirtual 193	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   228: aload 4
    //   230: areturn
    //   231: astore 4
    //   233: ldc 49
    //   235: aload 4
    //   237: invokevirtual 194	java/lang/Throwable:toString	()Ljava/lang/String;
    //   240: invokestatic 197	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 5
    //   245: areturn
    //   246: astore 5
    //   248: goto +13 -> 261
    //   251: astore 4
    //   253: goto +32 -> 285
    //   256: astore 5
    //   258: aconst_null
    //   259: astore 4
    //   261: ldc 49
    //   263: aload 5
    //   265: invokevirtual 194	java/lang/Throwable:toString	()Ljava/lang/String;
    //   268: invokestatic 197	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload 4
    //   273: astore 5
    //   275: aload_0
    //   276: getfield 40	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   279: invokevirtual 193	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   282: aload 4
    //   284: areturn
    //   285: aload_0
    //   286: getfield 40	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   289: invokevirtual 193	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   292: goto +15 -> 307
    //   295: astore 5
    //   297: ldc 49
    //   299: aload 5
    //   301: invokevirtual 194	java/lang/Throwable:toString	()Ljava/lang/String;
    //   304: invokestatic 197	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 4
    //   309: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	ru
    //   0	310	1	paramLong	long
    //   0	310	3	paramInt	int
    //   9	220	4	localObject1	Object
    //   231	5	4	localThrowable1	java.lang.Throwable
    //   251	1	4	localObject2	Object
    //   259	49	4	localwy1	wy
    //   111	34	5	localCountDownLatch	CountDownLatch
    //   152	3	5	localThrowable2	java.lang.Throwable
    //   178	66	5	localObject3	Object
    //   246	1	5	localThrowable3	java.lang.Throwable
    //   256	8	5	localThrowable4	java.lang.Throwable
    //   273	1	5	localwy2	wy
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
        //   1: getfield 22	com/tencent/token/ru$2:d	Lcom/tencent/token/ru;
        //   4: getfield 38	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 22	com/tencent/token/ru$2:d	Lcom/tencent/token/ru;
        //   14: aload_0
        //   15: getfield 24	com/tencent/token/ru$2:a	J
        //   18: aload_0
        //   19: getfield 26	com/tencent/token/ru$2:b	I
        //   22: invokevirtual 46	com/tencent/token/ru:a	(JI)Lcom/tencent/token/wy;
        //   25: astore_1
        //   26: aload_0
        //   27: getfield 28	com/tencent/token/ru$2:c	Landroid/os/Handler;
        //   30: sipush 3071
        //   33: invokevirtual 52	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   36: astore_2
        //   37: aload_2
        //   38: aload_1
        //   39: getfield 56	com/tencent/token/wy:a	I
        //   42: putfield 61	android/os/Message:arg1	I
        //   45: aload_1
        //   46: getfield 56	com/tencent/token/wy:a	I
        //   49: ifne +14 -> 63
        //   52: aload_2
        //   53: aload_1
        //   54: getfield 64	com/tencent/token/wy:d	Ljava/lang/Object;
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
        //   84: getfield 56	com/tencent/token/wy:a	I
        //   87: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   90: pop
        //   91: ldc 83
        //   93: aload_2
        //   94: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   97: invokestatic 93	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   100: aload_0
        //   101: getfield 22	com/tencent/token/ru$2:d	Lcom/tencent/token/ru;
        //   104: getfield 38	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
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
        //   137: getfield 22	com/tencent/token/ru$2:d	Lcom/tencent/token/ru;
        //   140: getfield 38	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   143: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   146: return
        //   147: aload_0
        //   148: getfield 22	com/tencent/token/ru$2:d	Lcom/tencent/token/ru;
        //   151: getfield 38	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
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
        //   25	59	1	localwy	wy
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
        //   1: getfield 18	com/tencent/token/ru$4:b	Lcom/tencent/token/ru;
        //   4: getfield 30	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
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
        //   40: new 70	com/tencent/token/wy
        //   43: dup
        //   44: invokespecial 71	com/tencent/token/wy:<init>	()V
        //   47: astore_1
        //   48: aload_1
        //   49: iconst_0
        //   50: putfield 74	com/tencent/token/wy:a	I
        //   53: aload_0
        //   54: getfield 20	com/tencent/token/ru$4:a	Landroid/os/Handler;
        //   57: sipush 3025
        //   60: invokevirtual 80	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   63: astore_2
        //   64: aload_2
        //   65: aload_1
        //   66: getfield 74	com/tencent/token/wy:a	I
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
        //   93: getfield 74	com/tencent/token/wy:a	I
        //   96: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   99: pop
        //   100: ldc 99
        //   102: aload_2
        //   103: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   106: invokestatic 68	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   109: aload_0
        //   110: getfield 18	com/tencent/token/ru$4:b	Lcom/tencent/token/ru;
        //   113: getfield 30	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
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
        //   146: getfield 18	com/tencent/token/ru$4:b	Lcom/tencent/token/ru;
        //   149: getfield 30	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   152: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   155: return
        //   156: aload_0
        //   157: getfield 18	com/tencent/token/ru$4:b	Lcom/tencent/token/ru;
        //   160: getfield 30	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
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
    if ((this.c.containsKey("mbtoken3_mod_seed")) && (System.currentTimeMillis() - ((Long)this.c.get("mbtoken3_mod_seed")).longValue() < 1000L))
    {
      TmsLog.w("CoreCGIManager", " sendModSeed() has been called in 1s.");
      return;
    }
    TmsLog.i("CoreCGIManager", "invoke sendModSeed()");
    this.b.post(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/tencent/token/ru$5:b	Lcom/tencent/token/ru;
        //   4: getfield 30	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
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
        //   40: new 70	com/tencent/token/wy
        //   43: dup
        //   44: invokespecial 71	com/tencent/token/wy:<init>	()V
        //   47: astore_1
        //   48: aload_1
        //   49: iconst_0
        //   50: putfield 74	com/tencent/token/wy:a	I
        //   53: aload_0
        //   54: getfield 20	com/tencent/token/ru$5:a	Landroid/os/Handler;
        //   57: sipush 4016
        //   60: invokevirtual 80	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   63: astore_2
        //   64: aload_2
        //   65: aload_1
        //   66: getfield 74	com/tencent/token/wy:a	I
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
        //   93: getfield 74	com/tencent/token/wy:a	I
        //   96: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   99: pop
        //   100: ldc 99
        //   102: aload_2
        //   103: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   106: invokestatic 68	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   109: aload_0
        //   110: getfield 18	com/tencent/token/ru$5:b	Lcom/tencent/token/ru;
        //   113: getfield 30	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
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
        //   146: getfield 18	com/tencent/token/ru$5:b	Lcom/tencent/token/ru;
        //   149: getfield 30	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   152: invokevirtual 102	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   155: return
        //   156: aload_0
        //   157: getfield 18	com/tencent/token/ru$5:b	Lcom/tencent/token/ru;
        //   160: getfield 30	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
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
        //   0	181	0	this	5
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
  
  public final wy c()
  {
    final AtomicReference localAtomicReference = new AtomicReference();
    this.b.post(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 21	com/tencent/token/ru$6:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   4: aload_0
        //   5: getfield 19	com/tencent/token/ru$6:b	Lcom/tencent/token/ru;
        //   8: invokevirtual 31	com/tencent/token/ru:d	()Lcom/tencent/token/wy;
        //   11: invokevirtual 37	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
        //   14: aload_0
        //   15: getfield 21	com/tencent/token/ru$6:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   18: astore_1
        //   19: aload_1
        //   20: monitorenter
        //   21: aload_0
        //   22: getfield 21	com/tencent/token/ru$6:a	Ljava/util/concurrent/atomic/AtomicReference;
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
        //   51: getfield 21	com/tencent/token/ru$6:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   54: astore_1
        //   55: aload_1
        //   56: monitorenter
        //   57: aload_0
        //   58: getfield 21	com/tencent/token/ru$6:a	Ljava/util/concurrent/atomic/AtomicReference;
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
        //   73: getfield 21	com/tencent/token/ru$6:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   76: astore_1
        //   77: aload_1
        //   78: monitorenter
        //   79: aload_0
        //   80: getfield 21	com/tencent/token/ru$6:a	Ljava/util/concurrent/atomic/AtomicReference;
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
        //   0	95	0	this	6
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
      wy localwy;
      label80:
      break label41;
    }
    if (localAtomicReference.get() == null)
    {
      localwy = new wy();
      localwy.a(10000, null, null);
      localAtomicReference.set(localwy);
    }
    return (wy)localAtomicReference.get();
    throw localwy;
  }
  
  public final void c(final Handler paramHandler)
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
        //   1: getfield 19	com/tencent/token/ru$7:b	Lcom/tencent/token/ru;
        //   4: getfield 31	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 36	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 19	com/tencent/token/ru$7:b	Lcom/tencent/token/ru;
        //   14: invokevirtual 40	com/tencent/token/ru:d	()Lcom/tencent/token/wy;
        //   17: astore_1
        //   18: aload_0
        //   19: getfield 21	com/tencent/token/ru$7:a	Landroid/os/Handler;
        //   22: sipush 3003
        //   25: invokevirtual 46	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   28: astore_2
        //   29: aload_2
        //   30: aload_1
        //   31: getfield 51	com/tencent/token/wy:a	I
        //   34: putfield 56	android/os/Message:arg1	I
        //   37: aload_2
        //   38: aload_1
        //   39: putfield 60	android/os/Message:obj	Ljava/lang/Object;
        //   42: aload_2
        //   43: invokevirtual 63	android/os/Message:sendToTarget	()V
        //   46: new 65	java/lang/StringBuilder
        //   49: dup
        //   50: ldc 67
        //   52: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   55: astore_2
        //   56: aload_2
        //   57: aload_1
        //   58: getfield 51	com/tencent/token/wy:a	I
        //   61: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   64: pop
        //   65: ldc 76
        //   67: aload_2
        //   68: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   71: invokestatic 86	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   74: aload_0
        //   75: getfield 19	com/tencent/token/ru$7:b	Lcom/tencent/token/ru;
        //   78: getfield 31	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   81: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   84: return
        //   85: astore_1
        //   86: ldc 76
        //   88: aload_1
        //   89: invokevirtual 90	java/lang/Throwable:toString	()Ljava/lang/String;
        //   92: invokestatic 93	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   95: return
        //   96: astore_1
        //   97: goto +24 -> 121
        //   100: astore_1
        //   101: ldc 76
        //   103: aload_1
        //   104: invokevirtual 90	java/lang/Throwable:toString	()Ljava/lang/String;
        //   107: invokestatic 93	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   110: aload_0
        //   111: getfield 19	com/tencent/token/ru$7:b	Lcom/tencent/token/ru;
        //   114: getfield 31	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   117: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   120: return
        //   121: aload_0
        //   122: getfield 19	com/tencent/token/ru$7:b	Lcom/tencent/token/ru;
        //   125: getfield 31	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   128: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   131: goto +13 -> 144
        //   134: astore_2
        //   135: ldc 76
        //   137: aload_2
        //   138: invokevirtual 90	java/lang/Throwable:toString	()Ljava/lang/String;
        //   141: invokestatic 93	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   144: aload_1
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	7
        //   17	41	1	localwy	wy
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
  
  /* Error */
  final wy d()
  {
    // Byte code:
    //   0: new 89	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 256
    //   7: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokestatic 100	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15: invokevirtual 104	java/lang/Thread:getId	()J
    //   18: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: ldc 110
    //   24: aload_2
    //   25: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 78	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 45	com/tencent/token/ru:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: ldc 248
    //   37: invokevirtual 120	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   40: istore_1
    //   41: aconst_null
    //   42: astore_2
    //   43: iload_1
    //   44: ifeq +48 -> 92
    //   47: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   50: aload_0
    //   51: getfield 45	com/tencent/token/ru:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   54: ldc 248
    //   56: invokevirtual 129	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 131	java/lang/Long
    //   62: invokevirtual 134	java/lang/Long:longValue	()J
    //   65: lsub
    //   66: ldc2_w 141
    //   69: lcmp
    //   70: ifge +22 -> 92
    //   73: new 80	com/tencent/token/wy
    //   76: dup
    //   77: invokespecial 81	com/tencent/token/wy:<init>	()V
    //   80: astore_2
    //   81: aload_2
    //   82: sipush 10006
    //   85: aconst_null
    //   86: aconst_null
    //   87: invokevirtual 145	com/tencent/token/wy:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   90: aload_2
    //   91: areturn
    //   92: aload_0
    //   93: getfield 40	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: invokevirtual 148	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   99: new 150	java/util/concurrent/CountDownLatch
    //   102: dup
    //   103: iconst_1
    //   104: invokespecial 153	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   107: astore 4
    //   109: new 155	java/util/concurrent/atomic/AtomicReference
    //   112: dup
    //   113: invokespecial 156	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   116: astore_3
    //   117: invokestatic 161	com/tencent/token/qy:a	()Lcom/tencent/token/qy;
    //   120: new 22	com/tencent/token/ru$9
    //   123: dup
    //   124: aload_0
    //   125: aload_3
    //   126: aload 4
    //   128: invokespecial 259	com/tencent/token/ru$9:<init>	(Lcom/tencent/token/ru;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/CountDownLatch;)V
    //   131: invokevirtual 262	com/tencent/token/qy:a	(Lcom/tencent/token/qy$a;)V
    //   134: aload 4
    //   136: invokevirtual 171	java/util/concurrent/CountDownLatch:await	()V
    //   139: goto +10 -> 149
    //   142: astore 4
    //   144: aload 4
    //   146: invokevirtual 174	java/lang/Throwable:printStackTrace	()V
    //   149: aload_3
    //   150: invokevirtual 177	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   153: checkcast 80	com/tencent/token/wy
    //   156: astore_3
    //   157: new 89	java/lang/StringBuilder
    //   160: dup
    //   161: ldc_w 264
    //   164: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: astore_2
    //   168: aload_2
    //   169: aload_3
    //   170: getfield 84	com/tencent/token/wy:a	I
    //   173: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc 110
    //   179: aload_2
    //   180: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 78	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_0
    //   187: getfield 45	com/tencent/token/ru:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   190: ldc 248
    //   192: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   195: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: invokevirtual 190	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: aload_0
    //   203: getfield 40	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   206: invokevirtual 193	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   209: aload_3
    //   210: areturn
    //   211: astore_2
    //   212: ldc 49
    //   214: aload_2
    //   215: invokevirtual 194	java/lang/Throwable:toString	()Ljava/lang/String;
    //   218: invokestatic 197	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload_3
    //   222: areturn
    //   223: astore 4
    //   225: aload_3
    //   226: astore_2
    //   227: aload 4
    //   229: astore_3
    //   230: goto +8 -> 238
    //   233: astore_2
    //   234: goto +35 -> 269
    //   237: astore_3
    //   238: ldc 49
    //   240: aload_3
    //   241: invokevirtual 194	java/lang/Throwable:toString	()Ljava/lang/String;
    //   244: invokestatic 197	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_0
    //   248: getfield 40	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   251: invokevirtual 193	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   254: goto +13 -> 267
    //   257: astore_3
    //   258: ldc 49
    //   260: aload_3
    //   261: invokevirtual 194	java/lang/Throwable:toString	()Ljava/lang/String;
    //   264: invokestatic 197	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_2
    //   268: areturn
    //   269: aload_0
    //   270: getfield 40	com/tencent/token/ru:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   273: invokevirtual 193	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   276: goto +13 -> 289
    //   279: astore_3
    //   280: ldc 49
    //   282: aload_3
    //   283: invokevirtual 194	java/lang/Throwable:toString	()Ljava/lang/String;
    //   286: invokestatic 197	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload_2
    //   290: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	ru
    //   40	4	1	bool	boolean
    //   10	170	2	localObject1	Object
    //   211	4	2	localThrowable1	java.lang.Throwable
    //   226	1	2	localObject2	Object
    //   233	57	2	localwy	wy
    //   116	114	3	localObject3	Object
    //   237	4	3	localThrowable2	java.lang.Throwable
    //   257	4	3	localThrowable3	java.lang.Throwable
    //   279	4	3	localThrowable4	java.lang.Throwable
    //   107	28	4	localCountDownLatch	CountDownLatch
    //   142	3	4	localThrowable5	java.lang.Throwable
    //   223	5	4	localThrowable6	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   134	139	142	java/lang/Throwable
    //   202	209	211	java/lang/Throwable
    //   157	202	223	java/lang/Throwable
    //   92	134	233	finally
    //   134	139	233	finally
    //   144	149	233	finally
    //   149	157	233	finally
    //   157	202	233	finally
    //   238	247	233	finally
    //   92	134	237	java/lang/Throwable
    //   144	149	237	java/lang/Throwable
    //   149	157	237	java/lang/Throwable
    //   247	254	257	java/lang/Throwable
    //   269	276	279	java/lang/Throwable
  }
  
  public static final class a
  {
    private static ru a = new ru((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ru
 * JD-Core Version:    0.7.0.1
 */