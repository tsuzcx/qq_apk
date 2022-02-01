package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.token.global.e;
import com.tmsdk.common.util.TmsLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class bv
{
  private ReentrantLock a = new ReentrantLock();
  private ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  private Handler c;
  
  private bv()
  {
    HandlerThread localHandlerThread = new HandlerThread("CoreCGIManager", 5);
    localHandlerThread.start();
    this.c = new Handler(localHandlerThread.getLooper());
  }
  
  public static bv a()
  {
    return a.a();
  }
  
  /* Error */
  private e a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: new 77	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 80
    //   13: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 4
    //   19: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   22: invokevirtual 94	java/lang/Thread:getId	()J
    //   25: invokevirtual 97	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 99
    //   31: aload 4
    //   33: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: ldc 111
    //   45: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   48: ifeq +49 -> 97
    //   51: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   54: aload_0
    //   55: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: ldc 111
    //   60: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 126	java/lang/Long
    //   66: invokevirtual 129	java/lang/Long:longValue	()J
    //   69: lsub
    //   70: ldc2_w 130
    //   73: lcmp
    //   74: ifge +23 -> 97
    //   77: new 133	com/tencent/token/global/e
    //   80: dup
    //   81: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   84: astore 4
    //   86: aload 4
    //   88: sipush 10000
    //   91: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   94: aload 4
    //   96: areturn
    //   97: aconst_null
    //   98: astore 5
    //   100: aload 5
    //   102: astore 4
    //   104: aload_0
    //   105: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   108: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   111: aload 5
    //   113: astore 4
    //   115: new 142	com/tencent/token/do
    //   118: dup
    //   119: ldc 111
    //   121: iconst_1
    //   122: aconst_null
    //   123: sipush 3071
    //   126: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   129: astore 7
    //   131: aload 5
    //   133: astore 4
    //   135: ldc 111
    //   137: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   140: checkcast 152	com/tencent/token/core/protocolcenter/protocol/ProtoQueryCaptcha
    //   143: astore 6
    //   145: aload 5
    //   147: astore 4
    //   149: aload 7
    //   151: lload_1
    //   152: iload_3
    //   153: invokestatic 155	com/tencent/token/core/protocolcenter/protocol/ProtoQueryCaptcha:a	(Lcom/tencent/token/do;JI)V
    //   156: aload 5
    //   158: astore 4
    //   160: aload 6
    //   162: aload 7
    //   164: invokevirtual 158	com/tencent/token/core/protocolcenter/protocol/ProtoQueryCaptcha:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   167: astore 5
    //   169: aload 5
    //   171: astore 4
    //   173: aload 5
    //   175: aload 6
    //   177: getfield 162	com/tencent/token/core/protocolcenter/protocol/ProtoQueryCaptcha:d	Lcom/tencent/token/core/bean/QueryCaptchaResult;
    //   180: putfield 165	com/tencent/token/global/e:d	Ljava/lang/Object;
    //   183: aload 5
    //   185: astore 4
    //   187: new 77	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   194: astore 6
    //   196: aload 5
    //   198: astore 4
    //   200: aload 6
    //   202: ldc 167
    //   204: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 5
    //   210: astore 4
    //   212: aload 6
    //   214: aload 5
    //   216: getfield 170	com/tencent/token/global/e:a	I
    //   219: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 5
    //   225: astore 4
    //   227: ldc 99
    //   229: aload 6
    //   231: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload 5
    //   239: astore 4
    //   241: aload_0
    //   242: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   245: ldc 111
    //   247: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   250: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   253: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: aload 5
    //   259: astore 6
    //   261: aload_0
    //   262: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   265: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   268: aload 5
    //   270: areturn
    //   271: astore 4
    //   273: ldc 49
    //   275: aload 4
    //   277: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   280: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 6
    //   285: areturn
    //   286: astore 4
    //   288: goto +29 -> 317
    //   291: astore 5
    //   293: ldc 49
    //   295: aload 5
    //   297: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   300: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload 4
    //   305: astore 6
    //   307: aload_0
    //   308: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   311: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   314: aload 4
    //   316: areturn
    //   317: aload_0
    //   318: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   321: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   324: goto +15 -> 339
    //   327: astore 5
    //   329: ldc 49
    //   331: aload 5
    //   333: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   336: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload 4
    //   341: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	bv
    //   0	342	1	paramLong	long
    //   0	342	3	paramInt	int
    //   7	233	4	localObject1	Object
    //   271	5	4	localThrowable1	java.lang.Throwable
    //   286	54	4	locale1	e
    //   98	171	5	locale2	e
    //   291	5	5	localThrowable2	java.lang.Throwable
    //   327	5	5	localThrowable3	java.lang.Throwable
    //   143	163	6	localObject2	Object
    //   129	34	7	localdo	do
    // Exception table:
    //   from	to	target	type
    //   261	268	271	java/lang/Throwable
    //   307	314	271	java/lang/Throwable
    //   104	111	286	finally
    //   115	131	286	finally
    //   135	145	286	finally
    //   149	156	286	finally
    //   160	169	286	finally
    //   173	183	286	finally
    //   187	196	286	finally
    //   200	208	286	finally
    //   212	223	286	finally
    //   227	237	286	finally
    //   241	257	286	finally
    //   293	303	286	finally
    //   104	111	291	java/lang/Throwable
    //   115	131	291	java/lang/Throwable
    //   135	145	291	java/lang/Throwable
    //   149	156	291	java/lang/Throwable
    //   160	169	291	java/lang/Throwable
    //   173	183	291	java/lang/Throwable
    //   187	196	291	java/lang/Throwable
    //   200	208	291	java/lang/Throwable
    //   212	223	291	java/lang/Throwable
    //   227	237	291	java/lang/Throwable
    //   241	257	291	java/lang/Throwable
    //   317	324	327	java/lang/Throwable
  }
  
  /* Error */
  private e a(boolean paramBoolean)
  {
    // Byte code:
    //   0: new 77	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 197
    //   11: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_2
    //   16: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   19: invokevirtual 94	java/lang/Thread:getId	()J
    //   22: invokevirtual 97	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: ldc 99
    //   28: aload_2
    //   29: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: iload_1
    //   36: ifne +58 -> 94
    //   39: aload_0
    //   40: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: ldc 199
    //   45: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   48: ifeq +46 -> 94
    //   51: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   54: aload_0
    //   55: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: ldc 199
    //   60: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 126	java/lang/Long
    //   66: invokevirtual 129	java/lang/Long:longValue	()J
    //   69: lsub
    //   70: ldc2_w 130
    //   73: lcmp
    //   74: ifge +20 -> 94
    //   77: new 133	com/tencent/token/global/e
    //   80: dup
    //   81: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   84: astore_2
    //   85: aload_2
    //   86: sipush 10000
    //   89: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   92: aload_2
    //   93: areturn
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: astore_2
    //   98: aload_0
    //   99: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   102: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   105: aload_3
    //   106: astore_2
    //   107: new 142	com/tencent/token/do
    //   110: dup
    //   111: ldc 199
    //   113: iconst_1
    //   114: aconst_null
    //   115: sipush 4000
    //   118: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   121: astore 4
    //   123: aload_3
    //   124: astore_2
    //   125: ldc 199
    //   127: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   130: aload 4
    //   132: invokevirtual 202	com/tencent/token/core/protocolcenter/d:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   135: astore_3
    //   136: aload_3
    //   137: astore_2
    //   138: new 77	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   145: astore 4
    //   147: aload_3
    //   148: astore_2
    //   149: aload 4
    //   151: ldc 204
    //   153: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: astore_2
    //   159: aload 4
    //   161: aload_3
    //   162: getfield 170	com/tencent/token/global/e:a	I
    //   165: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_3
    //   170: astore_2
    //   171: ldc 99
    //   173: aload 4
    //   175: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_3
    //   182: astore_2
    //   183: aload_0
    //   184: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   187: ldc 199
    //   189: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   192: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   195: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: aload_3
    //   200: astore 4
    //   202: aload_0
    //   203: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   206: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   209: aload_3
    //   210: areturn
    //   211: astore_2
    //   212: ldc 49
    //   214: aload_2
    //   215: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   218: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload 4
    //   223: areturn
    //   224: astore_2
    //   225: goto +25 -> 250
    //   228: astore_3
    //   229: ldc 49
    //   231: aload_3
    //   232: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   235: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_2
    //   239: astore 4
    //   241: aload_0
    //   242: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   245: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   248: aload_2
    //   249: areturn
    //   250: aload_0
    //   251: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   254: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   257: goto +13 -> 270
    //   260: astore_3
    //   261: ldc 49
    //   263: aload_3
    //   264: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   267: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_2
    //   271: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	bv
    //   0	272	1	paramBoolean	boolean
    //   7	176	2	localObject1	Object
    //   211	4	2	localThrowable1	java.lang.Throwable
    //   224	47	2	locale1	e
    //   95	115	3	locale2	e
    //   228	4	3	localThrowable2	java.lang.Throwable
    //   260	4	3	localThrowable3	java.lang.Throwable
    //   121	119	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   202	209	211	java/lang/Throwable
    //   241	248	211	java/lang/Throwable
    //   98	105	224	finally
    //   107	123	224	finally
    //   125	136	224	finally
    //   138	147	224	finally
    //   149	157	224	finally
    //   159	169	224	finally
    //   171	181	224	finally
    //   183	199	224	finally
    //   229	238	224	finally
    //   98	105	228	java/lang/Throwable
    //   107	123	228	java/lang/Throwable
    //   125	136	228	java/lang/Throwable
    //   138	147	228	java/lang/Throwable
    //   149	157	228	java/lang/Throwable
    //   159	169	228	java/lang/Throwable
    //   171	181	228	java/lang/Throwable
    //   183	199	228	java/lang/Throwable
    //   250	257	260	java/lang/Throwable
  }
  
  /* Error */
  private e d()
  {
    // Byte code:
    //   0: new 77	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 214
    //   11: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   19: invokevirtual 94	java/lang/Thread:getId	()J
    //   22: invokevirtual 97	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: ldc 99
    //   28: aload_1
    //   29: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: ldc 216
    //   41: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   44: ifeq +46 -> 90
    //   47: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   50: aload_0
    //   51: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   54: ldc 216
    //   56: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 126	java/lang/Long
    //   62: invokevirtual 129	java/lang/Long:longValue	()J
    //   65: lsub
    //   66: ldc2_w 130
    //   69: lcmp
    //   70: ifge +20 -> 90
    //   73: new 133	com/tencent/token/global/e
    //   76: dup
    //   77: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   80: astore_1
    //   81: aload_1
    //   82: sipush 10000
    //   85: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   88: aload_1
    //   89: areturn
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_0
    //   95: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   98: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   101: aload_2
    //   102: astore_1
    //   103: new 142	com/tencent/token/do
    //   106: dup
    //   107: ldc 216
    //   109: iconst_1
    //   110: aconst_null
    //   111: sipush 3025
    //   114: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   117: astore_3
    //   118: aload_2
    //   119: astore_1
    //   120: ldc 216
    //   122: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   125: aload_3
    //   126: invokevirtual 202	com/tencent/token/core/protocolcenter/d:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   129: astore_2
    //   130: aload_2
    //   131: astore_1
    //   132: new 77	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   139: astore_3
    //   140: aload_2
    //   141: astore_1
    //   142: aload_3
    //   143: ldc 204
    //   145: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: astore_1
    //   151: aload_3
    //   152: aload_2
    //   153: getfield 170	com/tencent/token/global/e:a	I
    //   156: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_2
    //   161: astore_1
    //   162: ldc 99
    //   164: aload_3
    //   165: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_2
    //   172: astore_1
    //   173: aload_0
    //   174: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   177: ldc 216
    //   179: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   182: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload_2
    //   190: astore_3
    //   191: aload_0
    //   192: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   195: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   198: aload_2
    //   199: areturn
    //   200: astore_1
    //   201: ldc 49
    //   203: aload_1
    //   204: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   207: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_3
    //   211: areturn
    //   212: astore_1
    //   213: goto +24 -> 237
    //   216: astore_2
    //   217: ldc 49
    //   219: aload_2
    //   220: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   223: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_1
    //   227: astore_3
    //   228: aload_0
    //   229: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   232: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   235: aload_1
    //   236: areturn
    //   237: aload_0
    //   238: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   241: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   244: goto +13 -> 257
    //   247: astore_2
    //   248: ldc 49
    //   250: aload_2
    //   251: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   254: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_1
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	bv
    //   7	166	1	localObject1	Object
    //   200	4	1	localThrowable1	java.lang.Throwable
    //   212	46	1	locale1	e
    //   91	108	2	locale2	e
    //   216	4	2	localThrowable2	java.lang.Throwable
    //   247	4	2	localThrowable3	java.lang.Throwable
    //   117	111	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   191	198	200	java/lang/Throwable
    //   228	235	200	java/lang/Throwable
    //   94	101	212	finally
    //   103	118	212	finally
    //   120	130	212	finally
    //   132	140	212	finally
    //   142	149	212	finally
    //   151	160	212	finally
    //   162	171	212	finally
    //   173	189	212	finally
    //   217	226	212	finally
    //   94	101	216	java/lang/Throwable
    //   103	118	216	java/lang/Throwable
    //   120	130	216	java/lang/Throwable
    //   132	140	216	java/lang/Throwable
    //   142	149	216	java/lang/Throwable
    //   151	160	216	java/lang/Throwable
    //   162	171	216	java/lang/Throwable
    //   173	189	216	java/lang/Throwable
    //   237	244	247	java/lang/Throwable
  }
  
  /* Error */
  private e e()
  {
    // Byte code:
    //   0: new 77	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 221
    //   11: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   19: invokevirtual 94	java/lang/Thread:getId	()J
    //   22: invokevirtual 97	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: ldc 99
    //   28: aload_1
    //   29: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: ldc 223
    //   41: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   44: ifeq +46 -> 90
    //   47: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   50: aload_0
    //   51: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   54: ldc 223
    //   56: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 126	java/lang/Long
    //   62: invokevirtual 129	java/lang/Long:longValue	()J
    //   65: lsub
    //   66: ldc2_w 130
    //   69: lcmp
    //   70: ifge +20 -> 90
    //   73: new 133	com/tencent/token/global/e
    //   76: dup
    //   77: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   80: astore_1
    //   81: aload_1
    //   82: sipush 10000
    //   85: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   88: aload_1
    //   89: areturn
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_0
    //   95: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   98: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   101: aload_2
    //   102: astore_1
    //   103: new 142	com/tencent/token/do
    //   106: dup
    //   107: ldc 223
    //   109: iconst_1
    //   110: aconst_null
    //   111: sipush 4016
    //   114: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   117: astore_3
    //   118: aload_2
    //   119: astore_1
    //   120: ldc 223
    //   122: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   125: aload_3
    //   126: invokevirtual 202	com/tencent/token/core/protocolcenter/d:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   129: astore_2
    //   130: aload_2
    //   131: astore_1
    //   132: aload_0
    //   133: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   136: ldc 223
    //   138: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   141: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   144: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: aload_2
    //   149: astore_1
    //   150: new 77	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   157: astore_3
    //   158: aload_2
    //   159: astore_1
    //   160: aload_3
    //   161: ldc 225
    //   163: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_2
    //   168: astore_1
    //   169: aload_3
    //   170: aload_2
    //   171: getfield 170	com/tencent/token/global/e:a	I
    //   174: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_2
    //   179: astore_1
    //   180: ldc 99
    //   182: aload_3
    //   183: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_2
    //   190: astore_3
    //   191: aload_0
    //   192: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   195: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   198: aload_2
    //   199: areturn
    //   200: astore_1
    //   201: ldc 49
    //   203: aload_1
    //   204: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   207: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_3
    //   211: areturn
    //   212: astore_1
    //   213: goto +24 -> 237
    //   216: astore_2
    //   217: ldc 49
    //   219: aload_2
    //   220: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   223: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_1
    //   227: astore_3
    //   228: aload_0
    //   229: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   232: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   235: aload_1
    //   236: areturn
    //   237: aload_0
    //   238: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   241: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   244: goto +13 -> 257
    //   247: astore_2
    //   248: ldc 49
    //   250: aload_2
    //   251: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   254: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_1
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	bv
    //   7	173	1	localObject1	Object
    //   200	4	1	localThrowable1	java.lang.Throwable
    //   212	46	1	locale1	e
    //   91	108	2	locale2	e
    //   216	4	2	localThrowable2	java.lang.Throwable
    //   247	4	2	localThrowable3	java.lang.Throwable
    //   117	111	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   191	198	200	java/lang/Throwable
    //   228	235	200	java/lang/Throwable
    //   94	101	212	finally
    //   103	118	212	finally
    //   120	130	212	finally
    //   132	148	212	finally
    //   150	158	212	finally
    //   160	167	212	finally
    //   169	178	212	finally
    //   180	189	212	finally
    //   217	226	212	finally
    //   94	101	216	java/lang/Throwable
    //   103	118	216	java/lang/Throwable
    //   120	130	216	java/lang/Throwable
    //   132	148	216	java/lang/Throwable
    //   150	158	216	java/lang/Throwable
    //   160	167	216	java/lang/Throwable
    //   169	178	216	java/lang/Throwable
    //   180	189	216	java/lang/Throwable
    //   237	244	247	java/lang/Throwable
  }
  
  /* Error */
  private e f()
  {
    // Byte code:
    //   0: new 77	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 227
    //   11: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   19: invokevirtual 94	java/lang/Thread:getId	()J
    //   22: invokevirtual 97	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: ldc 99
    //   28: aload_1
    //   29: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: ldc 229
    //   41: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   44: ifeq +46 -> 90
    //   47: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   50: aload_0
    //   51: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   54: ldc 229
    //   56: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 126	java/lang/Long
    //   62: invokevirtual 129	java/lang/Long:longValue	()J
    //   65: lsub
    //   66: ldc2_w 130
    //   69: lcmp
    //   70: ifge +20 -> 90
    //   73: new 133	com/tencent/token/global/e
    //   76: dup
    //   77: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   80: astore_1
    //   81: aload_1
    //   82: sipush 10006
    //   85: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   88: aload_1
    //   89: areturn
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_0
    //   95: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   98: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   101: aload_2
    //   102: astore_1
    //   103: new 142	com/tencent/token/do
    //   106: dup
    //   107: ldc 229
    //   109: iconst_1
    //   110: aconst_null
    //   111: sipush 3003
    //   114: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   117: astore_3
    //   118: aload_2
    //   119: astore_1
    //   120: ldc 229
    //   122: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   125: aload_3
    //   126: invokevirtual 202	com/tencent/token/core/protocolcenter/d:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   129: astore_2
    //   130: aload_2
    //   131: astore_1
    //   132: new 77	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   139: astore_3
    //   140: aload_2
    //   141: astore_1
    //   142: aload_3
    //   143: ldc 231
    //   145: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: astore_1
    //   151: aload_3
    //   152: aload_2
    //   153: getfield 170	com/tencent/token/global/e:a	I
    //   156: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_2
    //   161: astore_1
    //   162: ldc 99
    //   164: aload_3
    //   165: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_2
    //   172: astore_1
    //   173: aload_0
    //   174: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   177: ldc 229
    //   179: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   182: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload_2
    //   190: astore_3
    //   191: aload_0
    //   192: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   195: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   198: aload_2
    //   199: areturn
    //   200: astore_1
    //   201: ldc 49
    //   203: aload_1
    //   204: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   207: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_3
    //   211: areturn
    //   212: astore_1
    //   213: goto +24 -> 237
    //   216: astore_2
    //   217: ldc 49
    //   219: aload_2
    //   220: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   223: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_1
    //   227: astore_3
    //   228: aload_0
    //   229: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   232: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   235: aload_1
    //   236: areturn
    //   237: aload_0
    //   238: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   241: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   244: goto +13 -> 257
    //   247: astore_2
    //   248: ldc 49
    //   250: aload_2
    //   251: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   254: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_1
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	bv
    //   7	166	1	localObject1	Object
    //   200	4	1	localThrowable1	java.lang.Throwable
    //   212	46	1	locale1	e
    //   91	108	2	locale2	e
    //   216	4	2	localThrowable2	java.lang.Throwable
    //   247	4	2	localThrowable3	java.lang.Throwable
    //   117	111	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   191	198	200	java/lang/Throwable
    //   228	235	200	java/lang/Throwable
    //   94	101	212	finally
    //   103	118	212	finally
    //   120	130	212	finally
    //   132	140	212	finally
    //   142	149	212	finally
    //   151	160	212	finally
    //   162	171	212	finally
    //   173	189	212	finally
    //   217	226	212	finally
    //   94	101	216	java/lang/Throwable
    //   103	118	216	java/lang/Throwable
    //   120	130	216	java/lang/Throwable
    //   132	140	216	java/lang/Throwable
    //   142	149	216	java/lang/Throwable
    //   151	160	216	java/lang/Throwable
    //   162	171	216	java/lang/Throwable
    //   173	189	216	java/lang/Throwable
    //   237	244	247	java/lang/Throwable
  }
  
  public void a(final long paramLong, int paramInt, final Handler paramHandler)
  {
    if ((this.b.containsKey("mbtoken3_query_captcha")) && (System.currentTimeMillis() - ((Long)this.b.get("mbtoken3_query_captcha")).longValue() < 1000L))
    {
      TmsLog.w("CoreCGIManager", " sendQueryCaptha() has been called in 1s.");
      return;
    }
    TmsLog.i("CoreCGIManager", "invoke sendQueryCaptha()");
    this.c.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 22	com/tencent/token/bv$4:d	Lcom/tencent/token/bv;
        //   4: invokestatic 38	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 22	com/tencent/token/bv$4:d	Lcom/tencent/token/bv;
        //   14: aload_0
        //   15: getfield 24	com/tencent/token/bv$4:a	J
        //   18: aload_0
        //   19: getfield 26	com/tencent/token/bv$4:b	I
        //   22: invokestatic 46	com/tencent/token/bv:a	(Lcom/tencent/token/bv;JI)Lcom/tencent/token/global/e;
        //   25: astore_1
        //   26: aload_0
        //   27: getfield 28	com/tencent/token/bv$4:c	Landroid/os/Handler;
        //   30: sipush 3071
        //   33: invokevirtual 52	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   36: astore_2
        //   37: aload_2
        //   38: aload_1
        //   39: getfield 56	com/tencent/token/global/e:a	I
        //   42: putfield 61	android/os/Message:arg1	I
        //   45: aload_1
        //   46: getfield 56	com/tencent/token/global/e:a	I
        //   49: ifne +14 -> 63
        //   52: aload_2
        //   53: aload_1
        //   54: getfield 64	com/tencent/token/global/e:d	Ljava/lang/Object;
        //   57: putfield 67	android/os/Message:obj	Ljava/lang/Object;
        //   60: goto +8 -> 68
        //   63: aload_2
        //   64: aload_1
        //   65: putfield 67	android/os/Message:obj	Ljava/lang/Object;
        //   68: aload_2
        //   69: invokevirtual 70	android/os/Message:sendToTarget	()V
        //   72: new 72	java/lang/StringBuilder
        //   75: dup
        //   76: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   79: astore_2
        //   80: aload_2
        //   81: ldc 75
        //   83: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   86: pop
        //   87: aload_2
        //   88: aload_1
        //   89: getfield 56	com/tencent/token/global/e:a	I
        //   92: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   95: pop
        //   96: ldc 84
        //   98: aload_2
        //   99: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   102: invokestatic 94	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   105: aload_0
        //   106: getfield 22	com/tencent/token/bv$4:d	Lcom/tencent/token/bv;
        //   109: invokestatic 38	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   112: invokevirtual 97	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   115: return
        //   116: astore_1
        //   117: goto +35 -> 152
        //   120: astore_1
        //   121: ldc 84
        //   123: aload_1
        //   124: invokevirtual 98	java/lang/Throwable:toString	()Ljava/lang/String;
        //   127: invokestatic 101	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   130: aload_0
        //   131: getfield 22	com/tencent/token/bv$4:d	Lcom/tencent/token/bv;
        //   134: invokestatic 38	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   137: invokevirtual 97	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   140: return
        //   141: astore_1
        //   142: ldc 84
        //   144: aload_1
        //   145: invokevirtual 98	java/lang/Throwable:toString	()Ljava/lang/String;
        //   148: invokestatic 101	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   151: return
        //   152: aload_0
        //   153: getfield 22	com/tencent/token/bv$4:d	Lcom/tencent/token/bv;
        //   156: invokestatic 38	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   159: invokevirtual 97	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   162: goto +13 -> 175
        //   165: astore_2
        //   166: ldc 84
        //   168: aload_2
        //   169: invokevirtual 98	java/lang/Throwable:toString	()Ljava/lang/String;
        //   172: invokestatic 101	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   175: aload_1
        //   176: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	177	0	this	4
        //   25	64	1	locale	e
        //   116	1	1	localObject1	Object
        //   120	4	1	localThrowable1	java.lang.Throwable
        //   141	35	1	localThrowable2	java.lang.Throwable
        //   36	63	2	localObject2	Object
        //   165	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   0	60	116	finally
        //   63	68	116	finally
        //   68	105	116	finally
        //   121	130	116	finally
        //   0	60	120	java/lang/Throwable
        //   63	68	120	java/lang/Throwable
        //   68	105	120	java/lang/Throwable
        //   105	115	141	java/lang/Throwable
        //   130	140	141	java/lang/Throwable
        //   152	162	165	java/lang/Throwable
      }
    });
  }
  
  public void a(final Handler paramHandler)
  {
    TmsLog.i("CoreCGIManager", "invoke sendExchangeKey()");
    this.c.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/tencent/token/bv$2:b	Lcom/tencent/token/bv;
        //   4: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 18	com/tencent/token/bv$2:b	Lcom/tencent/token/bv;
        //   14: iconst_1
        //   15: invokestatic 38	com/tencent/token/bv:a	(Lcom/tencent/token/bv;Z)Lcom/tencent/token/global/e;
        //   18: astore_1
        //   19: aload_0
        //   20: getfield 20	com/tencent/token/bv$2:a	Landroid/os/Handler;
        //   23: ifnull +31 -> 54
        //   26: aload_0
        //   27: getfield 20	com/tencent/token/bv$2:a	Landroid/os/Handler;
        //   30: sipush 4000
        //   33: invokevirtual 44	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   36: astore_2
        //   37: aload_2
        //   38: aload_1
        //   39: getfield 49	com/tencent/token/global/e:a	I
        //   42: putfield 54	android/os/Message:arg1	I
        //   45: aload_2
        //   46: aload_1
        //   47: putfield 58	android/os/Message:obj	Ljava/lang/Object;
        //   50: aload_2
        //   51: invokevirtual 61	android/os/Message:sendToTarget	()V
        //   54: new 63	java/lang/StringBuilder
        //   57: dup
        //   58: invokespecial 64	java/lang/StringBuilder:<init>	()V
        //   61: astore_2
        //   62: aload_2
        //   63: ldc 66
        //   65: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   68: pop
        //   69: aload_2
        //   70: aload_1
        //   71: getfield 49	com/tencent/token/global/e:a	I
        //   74: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   77: pop
        //   78: ldc 75
        //   80: aload_2
        //   81: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   84: invokestatic 85	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   87: aload_0
        //   88: getfield 18	com/tencent/token/bv$2:b	Lcom/tencent/token/bv;
        //   91: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   94: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   97: return
        //   98: astore_1
        //   99: goto +35 -> 134
        //   102: astore_1
        //   103: ldc 75
        //   105: aload_1
        //   106: invokevirtual 89	java/lang/Throwable:toString	()Ljava/lang/String;
        //   109: invokestatic 92	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   112: aload_0
        //   113: getfield 18	com/tencent/token/bv$2:b	Lcom/tencent/token/bv;
        //   116: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   119: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   122: return
        //   123: astore_1
        //   124: ldc 75
        //   126: aload_1
        //   127: invokevirtual 89	java/lang/Throwable:toString	()Ljava/lang/String;
        //   130: invokestatic 92	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   133: return
        //   134: aload_0
        //   135: getfield 18	com/tencent/token/bv$2:b	Lcom/tencent/token/bv;
        //   138: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   141: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   144: goto +13 -> 157
        //   147: astore_2
        //   148: ldc 75
        //   150: aload_2
        //   151: invokevirtual 89	java/lang/Throwable:toString	()Ljava/lang/String;
        //   154: invokestatic 92	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   157: aload_1
        //   158: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	159	0	this	2
        //   18	53	1	locale	e
        //   98	1	1	localObject1	Object
        //   102	4	1	localThrowable1	java.lang.Throwable
        //   123	35	1	localThrowable2	java.lang.Throwable
        //   36	45	2	localObject2	Object
        //   147	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   0	54	98	finally
        //   54	87	98	finally
        //   103	112	98	finally
        //   0	54	102	java/lang/Throwable
        //   54	87	102	java/lang/Throwable
        //   87	97	123	java/lang/Throwable
        //   112	122	123	java/lang/Throwable
        //   134	144	147	java/lang/Throwable
      }
    });
  }
  
  public e b()
  {
    TmsLog.i("CoreCGIManager", "invoke doInitTask()");
    final AtomicReference localAtomicReference = new AtomicReference();
    this.c.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/tencent/token/bv$1:b	Lcom/tencent/token/bv;
        //   4: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 18	com/tencent/token/bv$1:b	Lcom/tencent/token/bv;
        //   14: iconst_1
        //   15: invokestatic 38	com/tencent/token/bv:a	(Lcom/tencent/token/bv;Z)Lcom/tencent/token/global/e;
        //   18: astore_2
        //   19: new 40	java/lang/StringBuilder
        //   22: dup
        //   23: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   26: astore_3
        //   27: aload_3
        //   28: ldc 43
        //   30: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   33: pop
        //   34: aload_2
        //   35: ifnonnull +513 -> 548
        //   38: ldc 49
        //   40: astore_1
        //   41: goto +3 -> 44
        //   44: aload_3
        //   45: aload_1
        //   46: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   49: pop
        //   50: ldc 51
        //   52: aload_3
        //   53: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   56: invokestatic 61	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   59: aload_2
        //   60: astore_1
        //   61: aload_2
        //   62: ifnull +284 -> 346
        //   65: aload_2
        //   66: invokevirtual 66	com/tencent/token/global/e:b	()Z
        //   69: ifne +8 -> 77
        //   72: aload_2
        //   73: astore_1
        //   74: goto +272 -> 346
        //   77: aload_2
        //   78: astore_1
        //   79: invokestatic 71	com/tencent/token/core/protocolcenter/protocol/ProtoModSeed:e	()Z
        //   82: ifeq +139 -> 221
        //   85: aload_0
        //   86: getfield 18	com/tencent/token/bv$1:b	Lcom/tencent/token/bv;
        //   89: lconst_0
        //   90: iconst_3
        //   91: invokestatic 74	com/tencent/token/bv:a	(Lcom/tencent/token/bv;JI)Lcom/tencent/token/global/e;
        //   94: astore_2
        //   95: new 40	java/lang/StringBuilder
        //   98: dup
        //   99: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   102: astore_3
        //   103: aload_3
        //   104: ldc 76
        //   106: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   109: pop
        //   110: aload_2
        //   111: ifnonnull +443 -> 554
        //   114: ldc 49
        //   116: astore_1
        //   117: goto +3 -> 120
        //   120: aload_3
        //   121: aload_1
        //   122: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   125: pop
        //   126: ldc 51
        //   128: aload_3
        //   129: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   132: invokestatic 61	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   135: aload_2
        //   136: astore_1
        //   137: aload_2
        //   138: ifnull +208 -> 346
        //   141: aload_2
        //   142: invokevirtual 66	com/tencent/token/global/e:b	()Z
        //   145: ifne +8 -> 153
        //   148: aload_2
        //   149: astore_1
        //   150: goto +196 -> 346
        //   153: aload_0
        //   154: getfield 18	com/tencent/token/bv$1:b	Lcom/tencent/token/bv;
        //   157: invokestatic 79	com/tencent/token/bv:b	(Lcom/tencent/token/bv;)Lcom/tencent/token/global/e;
        //   160: astore_2
        //   161: new 40	java/lang/StringBuilder
        //   164: dup
        //   165: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   168: astore_3
        //   169: aload_3
        //   170: ldc 81
        //   172: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   175: pop
        //   176: aload_2
        //   177: ifnonnull +383 -> 560
        //   180: ldc 49
        //   182: astore_1
        //   183: goto +3 -> 186
        //   186: aload_3
        //   187: aload_1
        //   188: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   191: pop
        //   192: ldc 51
        //   194: aload_3
        //   195: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   198: invokestatic 61	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   201: aload_2
        //   202: astore_1
        //   203: aload_2
        //   204: ifnull +142 -> 346
        //   207: aload_2
        //   208: astore_1
        //   209: aload_2
        //   210: invokevirtual 66	com/tencent/token/global/e:b	()Z
        //   213: ifne +8 -> 221
        //   216: aload_2
        //   217: astore_1
        //   218: goto +128 -> 346
        //   221: invokestatic 87	com/tencent/token/cc:c	()Lcom/tencent/token/cc;
        //   224: invokevirtual 90	com/tencent/token/cc:t	()Z
        //   227: ifeq +71 -> 298
        //   230: aload_0
        //   231: getfield 18	com/tencent/token/bv$1:b	Lcom/tencent/token/bv;
        //   234: invokestatic 92	com/tencent/token/bv:c	(Lcom/tencent/token/bv;)Lcom/tencent/token/global/e;
        //   237: astore_2
        //   238: new 40	java/lang/StringBuilder
        //   241: dup
        //   242: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   245: astore_3
        //   246: aload_3
        //   247: ldc 94
        //   249: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   252: pop
        //   253: aload_2
        //   254: ifnonnull +312 -> 566
        //   257: ldc 49
        //   259: astore_1
        //   260: goto +3 -> 263
        //   263: aload_3
        //   264: aload_1
        //   265: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   268: pop
        //   269: ldc 51
        //   271: aload_3
        //   272: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   275: invokestatic 61	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   278: aload_2
        //   279: astore_1
        //   280: aload_2
        //   281: ifnull +65 -> 346
        //   284: aload_2
        //   285: astore_1
        //   286: aload_2
        //   287: invokevirtual 66	com/tencent/token/global/e:b	()Z
        //   290: ifeq +8 -> 298
        //   293: aload_2
        //   294: astore_1
        //   295: goto +51 -> 346
        //   298: aload_0
        //   299: getfield 18	com/tencent/token/bv$1:b	Lcom/tencent/token/bv;
        //   302: invokestatic 97	com/tencent/token/bv:d	(Lcom/tencent/token/bv;)Lcom/tencent/token/global/e;
        //   305: astore_2
        //   306: new 40	java/lang/StringBuilder
        //   309: dup
        //   310: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   313: astore_3
        //   314: aload_3
        //   315: ldc 99
        //   317: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   320: pop
        //   321: aload_2
        //   322: ifnonnull +250 -> 572
        //   325: ldc 49
        //   327: astore_2
        //   328: goto +3 -> 331
        //   331: aload_3
        //   332: aload_2
        //   333: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   336: pop
        //   337: ldc 51
        //   339: aload_3
        //   340: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   343: invokestatic 61	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   346: aload_1
        //   347: ifnull +11 -> 358
        //   350: aload_0
        //   351: getfield 20	com/tencent/token/bv$1:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   354: aload_1
        //   355: invokevirtual 105	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
        //   358: new 40	java/lang/StringBuilder
        //   361: dup
        //   362: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   365: astore_2
        //   366: aload_2
        //   367: ldc 107
        //   369: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   372: pop
        //   373: aload_1
        //   374: ifnonnull +204 -> 578
        //   377: ldc 49
        //   379: astore_1
        //   380: goto +3 -> 383
        //   383: aload_2
        //   384: aload_1
        //   385: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   388: pop
        //   389: ldc 51
        //   391: aload_2
        //   392: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   395: invokestatic 61	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   398: aload_0
        //   399: getfield 18	com/tencent/token/bv$1:b	Lcom/tencent/token/bv;
        //   402: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   405: invokevirtual 110	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   408: goto +13 -> 421
        //   411: astore_1
        //   412: ldc 51
        //   414: aload_1
        //   415: invokevirtual 111	java/lang/Throwable:toString	()Ljava/lang/String;
        //   418: invokestatic 114	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   421: aload_0
        //   422: getfield 20	com/tencent/token/bv$1:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   425: astore_1
        //   426: aload_1
        //   427: monitorenter
        //   428: aload_0
        //   429: getfield 20	com/tencent/token/bv$1:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   432: invokevirtual 117	java/lang/Object:notify	()V
        //   435: aload_1
        //   436: monitorexit
        //   437: return
        //   438: astore_2
        //   439: aload_1
        //   440: monitorexit
        //   441: aload_2
        //   442: athrow
        //   443: astore_1
        //   444: goto +58 -> 502
        //   447: astore_1
        //   448: ldc 51
        //   450: aload_1
        //   451: invokevirtual 111	java/lang/Throwable:toString	()Ljava/lang/String;
        //   454: invokestatic 114	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   457: aload_0
        //   458: getfield 18	com/tencent/token/bv$1:b	Lcom/tencent/token/bv;
        //   461: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   464: invokevirtual 110	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   467: goto +13 -> 480
        //   470: astore_1
        //   471: ldc 51
        //   473: aload_1
        //   474: invokevirtual 111	java/lang/Throwable:toString	()Ljava/lang/String;
        //   477: invokestatic 114	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   480: aload_0
        //   481: getfield 20	com/tencent/token/bv$1:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   484: astore_1
        //   485: aload_1
        //   486: monitorenter
        //   487: aload_0
        //   488: getfield 20	com/tencent/token/bv$1:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   491: invokevirtual 117	java/lang/Object:notify	()V
        //   494: aload_1
        //   495: monitorexit
        //   496: return
        //   497: astore_2
        //   498: aload_1
        //   499: monitorexit
        //   500: aload_2
        //   501: athrow
        //   502: aload_0
        //   503: getfield 18	com/tencent/token/bv$1:b	Lcom/tencent/token/bv;
        //   506: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   509: invokevirtual 110	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   512: goto +13 -> 525
        //   515: astore_2
        //   516: ldc 51
        //   518: aload_2
        //   519: invokevirtual 111	java/lang/Throwable:toString	()Ljava/lang/String;
        //   522: invokestatic 114	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   525: aload_0
        //   526: getfield 20	com/tencent/token/bv$1:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   529: astore_2
        //   530: aload_2
        //   531: monitorenter
        //   532: aload_0
        //   533: getfield 20	com/tencent/token/bv$1:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   536: invokevirtual 117	java/lang/Object:notify	()V
        //   539: aload_2
        //   540: monitorexit
        //   541: aload_1
        //   542: athrow
        //   543: astore_1
        //   544: aload_2
        //   545: monitorexit
        //   546: aload_1
        //   547: athrow
        //   548: ldc 119
        //   550: astore_1
        //   551: goto -507 -> 44
        //   554: ldc 119
        //   556: astore_1
        //   557: goto -437 -> 120
        //   560: ldc 119
        //   562: astore_1
        //   563: goto -377 -> 186
        //   566: ldc 119
        //   568: astore_1
        //   569: goto -306 -> 263
        //   572: ldc 119
        //   574: astore_2
        //   575: goto -244 -> 331
        //   578: ldc 119
        //   580: astore_1
        //   581: goto -198 -> 383
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	584	0	this	1
        //   40	345	1	localObject1	Object
        //   411	4	1	localThrowable1	java.lang.Throwable
        //   425	15	1	localAtomicReference1	AtomicReference
        //   443	1	1	localObject2	Object
        //   447	4	1	localThrowable2	java.lang.Throwable
        //   470	4	1	localThrowable3	java.lang.Throwable
        //   484	58	1	localAtomicReference2	AtomicReference
        //   543	4	1	localObject3	Object
        //   550	31	1	str	String
        //   18	374	2	localObject4	Object
        //   438	4	2	localObject5	Object
        //   497	4	2	localObject6	Object
        //   515	4	2	localThrowable4	java.lang.Throwable
        //   529	46	2	localObject7	Object
        //   26	314	3	localStringBuilder	java.lang.StringBuilder
        // Exception table:
        //   from	to	target	type
        //   398	408	411	java/lang/Throwable
        //   428	437	438	finally
        //   439	441	438	finally
        //   0	34	443	finally
        //   44	59	443	finally
        //   65	72	443	finally
        //   79	110	443	finally
        //   120	135	443	finally
        //   141	148	443	finally
        //   153	176	443	finally
        //   186	201	443	finally
        //   209	216	443	finally
        //   221	253	443	finally
        //   263	278	443	finally
        //   286	293	443	finally
        //   298	321	443	finally
        //   331	346	443	finally
        //   350	358	443	finally
        //   358	373	443	finally
        //   383	398	443	finally
        //   448	457	443	finally
        //   0	34	447	java/lang/Throwable
        //   44	59	447	java/lang/Throwable
        //   65	72	447	java/lang/Throwable
        //   79	110	447	java/lang/Throwable
        //   120	135	447	java/lang/Throwable
        //   141	148	447	java/lang/Throwable
        //   153	176	447	java/lang/Throwable
        //   186	201	447	java/lang/Throwable
        //   209	216	447	java/lang/Throwable
        //   221	253	447	java/lang/Throwable
        //   263	278	447	java/lang/Throwable
        //   286	293	447	java/lang/Throwable
        //   298	321	447	java/lang/Throwable
        //   331	346	447	java/lang/Throwable
        //   350	358	447	java/lang/Throwable
        //   358	373	447	java/lang/Throwable
        //   383	398	447	java/lang/Throwable
        //   457	467	470	java/lang/Throwable
        //   487	496	497	finally
        //   498	500	497	finally
        //   502	512	515	java/lang/Throwable
        //   532	541	543	finally
        //   544	546	543	finally
      }
    });
    try
    {
      try
      {
        localAtomicReference.wait(270000L);
      }
      finally
      {
        break label85;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label48:
      e locale;
      label85:
      break label48;
    }
    if (localAtomicReference.get() == null)
    {
      locale = new e();
      locale.b(10000);
      localAtomicReference.set(locale);
    }
    return (e)localAtomicReference.get();
    throw locale;
  }
  
  public void b(final Handler paramHandler)
  {
    if ((this.b.containsKey("mbtoken3_exchange_key_v3")) && (System.currentTimeMillis() - ((Long)this.b.get("mbtoken3_exchange_key_v3")).longValue() < 1000L))
    {
      TmsLog.w("CoreCGIManager", " sendExchangeKey() has been called in 1s.");
      return;
    }
    TmsLog.i("CoreCGIManager", "invoke sendExchangeKey()");
    this.c.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/tencent/token/bv$3:b	Lcom/tencent/token/bv;
        //   4: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 18	com/tencent/token/bv$3:b	Lcom/tencent/token/bv;
        //   14: iconst_0
        //   15: invokestatic 38	com/tencent/token/bv:a	(Lcom/tencent/token/bv;Z)Lcom/tencent/token/global/e;
        //   18: astore_1
        //   19: aload_0
        //   20: getfield 20	com/tencent/token/bv$3:a	Landroid/os/Handler;
        //   23: sipush 4000
        //   26: invokevirtual 44	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   29: astore_2
        //   30: aload_2
        //   31: aload_1
        //   32: getfield 49	com/tencent/token/global/e:a	I
        //   35: putfield 54	android/os/Message:arg1	I
        //   38: aload_2
        //   39: aload_1
        //   40: putfield 58	android/os/Message:obj	Ljava/lang/Object;
        //   43: aload_2
        //   44: invokevirtual 61	android/os/Message:sendToTarget	()V
        //   47: new 63	java/lang/StringBuilder
        //   50: dup
        //   51: invokespecial 64	java/lang/StringBuilder:<init>	()V
        //   54: astore_2
        //   55: aload_2
        //   56: ldc 66
        //   58: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   61: pop
        //   62: aload_2
        //   63: aload_1
        //   64: getfield 49	com/tencent/token/global/e:a	I
        //   67: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   70: pop
        //   71: ldc 75
        //   73: aload_2
        //   74: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   77: invokestatic 85	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   80: aload_0
        //   81: getfield 18	com/tencent/token/bv$3:b	Lcom/tencent/token/bv;
        //   84: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   87: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   90: return
        //   91: astore_1
        //   92: goto +35 -> 127
        //   95: astore_1
        //   96: ldc 75
        //   98: aload_1
        //   99: invokevirtual 89	java/lang/Throwable:toString	()Ljava/lang/String;
        //   102: invokestatic 92	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   105: aload_0
        //   106: getfield 18	com/tencent/token/bv$3:b	Lcom/tencent/token/bv;
        //   109: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   112: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   115: return
        //   116: astore_1
        //   117: ldc 75
        //   119: aload_1
        //   120: invokevirtual 89	java/lang/Throwable:toString	()Ljava/lang/String;
        //   123: invokestatic 92	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   126: return
        //   127: aload_0
        //   128: getfield 18	com/tencent/token/bv$3:b	Lcom/tencent/token/bv;
        //   131: invokestatic 30	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   134: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   137: goto +13 -> 150
        //   140: astore_2
        //   141: ldc 75
        //   143: aload_2
        //   144: invokevirtual 89	java/lang/Throwable:toString	()Ljava/lang/String;
        //   147: invokestatic 92	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   150: aload_1
        //   151: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	152	0	this	3
        //   18	46	1	locale	e
        //   91	1	1	localObject1	Object
        //   95	4	1	localThrowable1	java.lang.Throwable
        //   116	35	1	localThrowable2	java.lang.Throwable
        //   29	45	2	localObject2	Object
        //   140	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   0	80	91	finally
        //   96	105	91	finally
        //   0	80	95	java/lang/Throwable
        //   80	90	116	java/lang/Throwable
        //   105	115	116	java/lang/Throwable
        //   127	137	140	java/lang/Throwable
      }
    });
  }
  
  public e c()
  {
    final AtomicReference localAtomicReference = new AtomicReference();
    this.c.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 21	com/tencent/token/bv$7:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   4: aload_0
        //   5: getfield 19	com/tencent/token/bv$7:b	Lcom/tencent/token/bv;
        //   8: invokestatic 32	com/tencent/token/bv:d	(Lcom/tencent/token/bv;)Lcom/tencent/token/global/e;
        //   11: invokevirtual 38	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
        //   14: aload_0
        //   15: getfield 21	com/tencent/token/bv$7:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   18: astore_1
        //   19: aload_1
        //   20: monitorenter
        //   21: aload_0
        //   22: getfield 21	com/tencent/token/bv$7:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   25: invokevirtual 41	java/lang/Object:notify	()V
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
        //   41: ldc 43
        //   43: aload_1
        //   44: invokevirtual 47	java/lang/Throwable:toString	()Ljava/lang/String;
        //   47: invokestatic 53	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   50: aload_0
        //   51: getfield 21	com/tencent/token/bv$7:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   54: astore_1
        //   55: aload_1
        //   56: monitorenter
        //   57: aload_0
        //   58: getfield 21	com/tencent/token/bv$7:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   61: invokevirtual 41	java/lang/Object:notify	()V
        //   64: aload_1
        //   65: monitorexit
        //   66: return
        //   67: astore_2
        //   68: aload_1
        //   69: monitorexit
        //   70: aload_2
        //   71: athrow
        //   72: aload_0
        //   73: getfield 21	com/tencent/token/bv$7:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   76: astore_1
        //   77: aload_1
        //   78: monitorenter
        //   79: aload_0
        //   80: getfield 21	com/tencent/token/bv$7:a	Ljava/util/concurrent/atomic/AtomicReference;
        //   83: invokevirtual 41	java/lang/Object:notify	()V
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
        //   0	95	0	this	7
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
        break label78;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label41:
      e locale;
      label78:
      break label41;
    }
    if (localAtomicReference.get() == null)
    {
      locale = new e();
      locale.b(10000);
      localAtomicReference.set(locale);
    }
    return (e)localAtomicReference.get();
    throw locale;
  }
  
  public void c(final Handler paramHandler)
  {
    if ((this.b.containsKey("mbtoken3_activate_token")) && (System.currentTimeMillis() - ((Long)this.b.get("mbtoken3_activate_token")).longValue() < 1000L))
    {
      TmsLog.w("CoreCGIManager", " sendActiveToken() has been called in 1s.");
      return;
    }
    TmsLog.i("CoreCGIManager", "invoke sendActiveToken()");
    this.c.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	com/tencent/token/bv$5:b	Lcom/tencent/token/bv;
        //   4: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 36	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 19	com/tencent/token/bv$5:b	Lcom/tencent/token/bv;
        //   14: invokestatic 39	com/tencent/token/bv:b	(Lcom/tencent/token/bv;)Lcom/tencent/token/global/e;
        //   17: astore_1
        //   18: aload_0
        //   19: getfield 21	com/tencent/token/bv$5:a	Landroid/os/Handler;
        //   22: sipush 3025
        //   25: invokevirtual 45	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   28: astore_2
        //   29: aload_2
        //   30: aload_1
        //   31: getfield 50	com/tencent/token/global/e:a	I
        //   34: putfield 55	android/os/Message:arg1	I
        //   37: aload_2
        //   38: aload_1
        //   39: putfield 59	android/os/Message:obj	Ljava/lang/Object;
        //   42: aload_2
        //   43: invokevirtual 62	android/os/Message:sendToTarget	()V
        //   46: new 64	java/lang/StringBuilder
        //   49: dup
        //   50: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   53: astore_2
        //   54: aload_2
        //   55: ldc 67
        //   57: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   60: pop
        //   61: aload_2
        //   62: aload_1
        //   63: getfield 50	com/tencent/token/global/e:a	I
        //   66: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   69: pop
        //   70: ldc 76
        //   72: aload_2
        //   73: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   76: invokestatic 86	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   79: aload_0
        //   80: getfield 19	com/tencent/token/bv$5:b	Lcom/tencent/token/bv;
        //   83: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   86: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   89: return
        //   90: astore_1
        //   91: goto +35 -> 126
        //   94: astore_1
        //   95: ldc 76
        //   97: aload_1
        //   98: invokevirtual 90	java/lang/Throwable:toString	()Ljava/lang/String;
        //   101: invokestatic 93	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   104: aload_0
        //   105: getfield 19	com/tencent/token/bv$5:b	Lcom/tencent/token/bv;
        //   108: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   111: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   114: return
        //   115: astore_1
        //   116: ldc 76
        //   118: aload_1
        //   119: invokevirtual 90	java/lang/Throwable:toString	()Ljava/lang/String;
        //   122: invokestatic 93	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   125: return
        //   126: aload_0
        //   127: getfield 19	com/tencent/token/bv$5:b	Lcom/tencent/token/bv;
        //   130: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   133: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   136: goto +13 -> 149
        //   139: astore_2
        //   140: ldc 76
        //   142: aload_2
        //   143: invokevirtual 90	java/lang/Throwable:toString	()Ljava/lang/String;
        //   146: invokestatic 93	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   149: aload_1
        //   150: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	151	0	this	5
        //   17	46	1	locale	e
        //   90	1	1	localObject1	Object
        //   94	4	1	localThrowable1	java.lang.Throwable
        //   115	35	1	localThrowable2	java.lang.Throwable
        //   28	45	2	localObject2	Object
        //   139	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   0	79	90	finally
        //   95	104	90	finally
        //   0	79	94	java/lang/Throwable
        //   79	89	115	java/lang/Throwable
        //   104	114	115	java/lang/Throwable
        //   126	136	139	java/lang/Throwable
      }
    });
  }
  
  public void d(final Handler paramHandler)
  {
    if ((this.b.containsKey("mbtoken3_mod_seed")) && (System.currentTimeMillis() - ((Long)this.b.get("mbtoken3_mod_seed")).longValue() < 1000L))
    {
      TmsLog.w("CoreCGIManager", " sendModSeed() has been called in 1s.");
      return;
    }
    TmsLog.i("CoreCGIManager", "invoke sendModSeed()");
    this.c.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	com/tencent/token/bv$6:b	Lcom/tencent/token/bv;
        //   4: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 36	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 19	com/tencent/token/bv$6:b	Lcom/tencent/token/bv;
        //   14: invokestatic 40	com/tencent/token/bv:c	(Lcom/tencent/token/bv;)Lcom/tencent/token/global/e;
        //   17: astore_1
        //   18: aload_0
        //   19: getfield 21	com/tencent/token/bv$6:a	Landroid/os/Handler;
        //   22: sipush 4016
        //   25: invokevirtual 46	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   28: astore_2
        //   29: aload_2
        //   30: aload_1
        //   31: getfield 51	com/tencent/token/global/e:a	I
        //   34: putfield 56	android/os/Message:arg1	I
        //   37: aload_2
        //   38: aload_1
        //   39: putfield 60	android/os/Message:obj	Ljava/lang/Object;
        //   42: aload_2
        //   43: invokevirtual 63	android/os/Message:sendToTarget	()V
        //   46: new 65	java/lang/StringBuilder
        //   49: dup
        //   50: invokespecial 66	java/lang/StringBuilder:<init>	()V
        //   53: astore_2
        //   54: aload_2
        //   55: ldc 68
        //   57: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   60: pop
        //   61: aload_2
        //   62: aload_1
        //   63: getfield 51	com/tencent/token/global/e:a	I
        //   66: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   69: pop
        //   70: ldc 77
        //   72: aload_2
        //   73: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   76: invokestatic 87	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   79: aload_0
        //   80: getfield 19	com/tencent/token/bv$6:b	Lcom/tencent/token/bv;
        //   83: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   86: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   89: return
        //   90: astore_1
        //   91: goto +35 -> 126
        //   94: astore_1
        //   95: ldc 77
        //   97: aload_1
        //   98: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
        //   101: invokestatic 94	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   104: aload_0
        //   105: getfield 19	com/tencent/token/bv$6:b	Lcom/tencent/token/bv;
        //   108: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   111: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   114: return
        //   115: astore_1
        //   116: ldc 77
        //   118: aload_1
        //   119: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
        //   122: invokestatic 94	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   125: return
        //   126: aload_0
        //   127: getfield 19	com/tencent/token/bv$6:b	Lcom/tencent/token/bv;
        //   130: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   133: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   136: goto +13 -> 149
        //   139: astore_2
        //   140: ldc 77
        //   142: aload_2
        //   143: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
        //   146: invokestatic 94	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   149: aload_1
        //   150: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	151	0	this	6
        //   17	46	1	locale	e
        //   90	1	1	localObject1	Object
        //   94	4	1	localThrowable1	java.lang.Throwable
        //   115	35	1	localThrowable2	java.lang.Throwable
        //   28	45	2	localObject2	Object
        //   139	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   0	79	90	finally
        //   95	104	90	finally
        //   0	79	94	java/lang/Throwable
        //   79	89	115	java/lang/Throwable
        //   104	114	115	java/lang/Throwable
        //   126	136	139	java/lang/Throwable
      }
    });
  }
  
  public void e(final Handler paramHandler)
  {
    if ((this.b.containsKey("mbtoken3_get_uin_list_v2")) && (System.currentTimeMillis() - ((Long)this.b.get("mbtoken3_get_uin_list_v2")).longValue() < 1000L))
    {
      TmsLog.w("CoreCGIManager", " sendGetUinList() has been called in 1s.");
      return;
    }
    TmsLog.i("CoreCGIManager", "invoke sendGetUinList()");
    this.c.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	com/tencent/token/bv$8:b	Lcom/tencent/token/bv;
        //   4: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 36	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 19	com/tencent/token/bv$8:b	Lcom/tencent/token/bv;
        //   14: invokestatic 40	com/tencent/token/bv:d	(Lcom/tencent/token/bv;)Lcom/tencent/token/global/e;
        //   17: astore_1
        //   18: aload_0
        //   19: getfield 21	com/tencent/token/bv$8:a	Landroid/os/Handler;
        //   22: sipush 3003
        //   25: invokevirtual 46	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   28: astore_2
        //   29: aload_2
        //   30: aload_1
        //   31: getfield 51	com/tencent/token/global/e:a	I
        //   34: putfield 56	android/os/Message:arg1	I
        //   37: aload_2
        //   38: aload_1
        //   39: putfield 60	android/os/Message:obj	Ljava/lang/Object;
        //   42: aload_2
        //   43: invokevirtual 63	android/os/Message:sendToTarget	()V
        //   46: new 65	java/lang/StringBuilder
        //   49: dup
        //   50: invokespecial 66	java/lang/StringBuilder:<init>	()V
        //   53: astore_2
        //   54: aload_2
        //   55: ldc 68
        //   57: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   60: pop
        //   61: aload_2
        //   62: aload_1
        //   63: getfield 51	com/tencent/token/global/e:a	I
        //   66: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   69: pop
        //   70: ldc 77
        //   72: aload_2
        //   73: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   76: invokestatic 87	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   79: aload_0
        //   80: getfield 19	com/tencent/token/bv$8:b	Lcom/tencent/token/bv;
        //   83: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   86: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   89: return
        //   90: astore_1
        //   91: goto +35 -> 126
        //   94: astore_1
        //   95: ldc 77
        //   97: aload_1
        //   98: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
        //   101: invokestatic 94	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   104: aload_0
        //   105: getfield 19	com/tencent/token/bv$8:b	Lcom/tencent/token/bv;
        //   108: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   111: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   114: return
        //   115: astore_1
        //   116: ldc 77
        //   118: aload_1
        //   119: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
        //   122: invokestatic 94	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   125: return
        //   126: aload_0
        //   127: getfield 19	com/tencent/token/bv$8:b	Lcom/tencent/token/bv;
        //   130: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   133: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   136: goto +13 -> 149
        //   139: astore_2
        //   140: ldc 77
        //   142: aload_2
        //   143: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
        //   146: invokestatic 94	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   149: aload_1
        //   150: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	151	0	this	8
        //   17	46	1	locale	e
        //   90	1	1	localObject1	Object
        //   94	4	1	localThrowable1	java.lang.Throwable
        //   115	35	1	localThrowable2	java.lang.Throwable
        //   28	45	2	localObject2	Object
        //   139	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   0	79	90	finally
        //   95	104	90	finally
        //   0	79	94	java/lang/Throwable
        //   79	89	115	java/lang/Throwable
        //   104	114	115	java/lang/Throwable
        //   126	136	139	java/lang/Throwable
      }
    });
  }
  
  public void f(final Handler paramHandler)
  {
    TmsLog.i("CoreCGIManager", "invoke sendGetUinListSticky()");
    this.c.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	com/tencent/token/bv$9:b	Lcom/tencent/token/bv;
        //   4: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 36	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 19	com/tencent/token/bv$9:b	Lcom/tencent/token/bv;
        //   14: invokestatic 40	com/tencent/token/bv:d	(Lcom/tencent/token/bv;)Lcom/tencent/token/global/e;
        //   17: astore_1
        //   18: aload_0
        //   19: getfield 21	com/tencent/token/bv$9:a	Landroid/os/Handler;
        //   22: sipush 3003
        //   25: invokevirtual 46	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
        //   28: astore_2
        //   29: aload_2
        //   30: aload_1
        //   31: getfield 51	com/tencent/token/global/e:a	I
        //   34: putfield 56	android/os/Message:arg1	I
        //   37: aload_2
        //   38: aload_1
        //   39: putfield 60	android/os/Message:obj	Ljava/lang/Object;
        //   42: aload_2
        //   43: invokevirtual 63	android/os/Message:sendToTarget	()V
        //   46: new 65	java/lang/StringBuilder
        //   49: dup
        //   50: invokespecial 66	java/lang/StringBuilder:<init>	()V
        //   53: astore_2
        //   54: aload_2
        //   55: ldc 68
        //   57: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   60: pop
        //   61: aload_2
        //   62: aload_1
        //   63: getfield 51	com/tencent/token/global/e:a	I
        //   66: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   69: pop
        //   70: ldc 77
        //   72: aload_2
        //   73: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   76: invokestatic 87	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   79: aload_0
        //   80: getfield 19	com/tencent/token/bv$9:b	Lcom/tencent/token/bv;
        //   83: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   86: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   89: return
        //   90: astore_1
        //   91: goto +35 -> 126
        //   94: astore_1
        //   95: ldc 77
        //   97: aload_1
        //   98: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
        //   101: invokestatic 94	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   104: aload_0
        //   105: getfield 19	com/tencent/token/bv$9:b	Lcom/tencent/token/bv;
        //   108: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   111: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   114: return
        //   115: astore_1
        //   116: ldc 77
        //   118: aload_1
        //   119: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
        //   122: invokestatic 94	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   125: return
        //   126: aload_0
        //   127: getfield 19	com/tencent/token/bv$9:b	Lcom/tencent/token/bv;
        //   130: invokestatic 31	com/tencent/token/bv:a	(Lcom/tencent/token/bv;)Ljava/util/concurrent/locks/ReentrantLock;
        //   133: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   136: goto +13 -> 149
        //   139: astore_2
        //   140: ldc 77
        //   142: aload_2
        //   143: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
        //   146: invokestatic 94	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   149: aload_1
        //   150: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	151	0	this	9
        //   17	46	1	locale	e
        //   90	1	1	localObject1	Object
        //   94	4	1	localThrowable1	java.lang.Throwable
        //   115	35	1	localThrowable2	java.lang.Throwable
        //   28	45	2	localObject2	Object
        //   139	4	2	localThrowable3	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   0	79	90	finally
        //   95	104	90	finally
        //   0	79	94	java/lang/Throwable
        //   79	89	115	java/lang/Throwable
        //   104	114	115	java/lang/Throwable
        //   126	136	139	java/lang/Throwable
      }
    });
  }
  
  private static class a
  {
    private static bv a = new bv(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bv
 * JD-Core Version:    0.7.0.1
 */