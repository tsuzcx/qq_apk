package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
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
    //   0: ldc 77
    //   2: new 79	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9: ldc 82
    //   11: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 96	java/lang/Thread:getId	()J
    //   20: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: ldc 111
    //   35: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +49 -> 87
    //   41: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   44: aload_0
    //   45: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   48: ldc 111
    //   50: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: checkcast 126	java/lang/Long
    //   56: invokevirtual 129	java/lang/Long:longValue	()J
    //   59: lsub
    //   60: ldc2_w 130
    //   63: lcmp
    //   64: ifge +23 -> 87
    //   67: new 133	com/tencent/token/global/e
    //   70: dup
    //   71: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   74: astore 4
    //   76: aload 4
    //   78: sipush 10000
    //   81: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   84: aload 4
    //   86: areturn
    //   87: aload_0
    //   88: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   91: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   94: new 142	com/tencent/token/do
    //   97: dup
    //   98: ldc 111
    //   100: iconst_1
    //   101: aconst_null
    //   102: sipush 3071
    //   105: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   108: astore 4
    //   110: ldc 111
    //   112: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   115: checkcast 152	com/tencent/token/core/protocolcenter/protocol/ProtoQueryCaptcha
    //   118: astore 5
    //   120: aload 4
    //   122: lload_1
    //   123: iload_3
    //   124: invokestatic 155	com/tencent/token/core/protocolcenter/protocol/ProtoQueryCaptcha:a	(Lcom/tencent/token/do;JI)V
    //   127: aload 5
    //   129: aload 4
    //   131: invokevirtual 158	com/tencent/token/core/protocolcenter/protocol/ProtoQueryCaptcha:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   134: astore 4
    //   136: aload 4
    //   138: aload 5
    //   140: getfield 162	com/tencent/token/core/protocolcenter/protocol/ProtoQueryCaptcha:d	Lcom/tencent/token/core/bean/QueryCaptchaResult;
    //   143: putfield 165	com/tencent/token/global/e:d	Ljava/lang/Object;
    //   146: ldc 77
    //   148: new 79	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   155: ldc 167
    //   157: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 4
    //   162: getfield 170	com/tencent/token/global/e:a	I
    //   165: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   178: ldc 111
    //   180: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   183: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: pop
    //   190: aload_0
    //   191: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   194: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   197: aload 4
    //   199: areturn
    //   200: astore 5
    //   202: ldc 49
    //   204: aload 5
    //   206: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   209: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload 4
    //   214: areturn
    //   215: astore 5
    //   217: aconst_null
    //   218: astore 4
    //   220: ldc 49
    //   222: aload 5
    //   224: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   227: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_0
    //   231: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   234: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   237: aload 4
    //   239: areturn
    //   240: astore 5
    //   242: ldc 49
    //   244: aload 5
    //   246: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   249: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 4
    //   254: areturn
    //   255: astore 4
    //   257: aload_0
    //   258: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   261: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   264: aload 4
    //   266: athrow
    //   267: astore 5
    //   269: ldc 49
    //   271: aload 5
    //   273: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   276: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: goto -15 -> 264
    //   282: astore 5
    //   284: goto -64 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	bv
    //   0	287	1	paramLong	long
    //   0	287	3	paramInt	int
    //   74	179	4	localObject1	Object
    //   255	10	4	localObject2	Object
    //   118	21	5	localProtoQueryCaptcha	com.tencent.token.core.protocolcenter.protocol.ProtoQueryCaptcha
    //   200	5	5	localThrowable1	Throwable
    //   215	8	5	localThrowable2	Throwable
    //   240	5	5	localThrowable3	Throwable
    //   267	5	5	localThrowable4	Throwable
    //   282	1	5	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   190	197	200	java/lang/Throwable
    //   87	136	215	java/lang/Throwable
    //   230	237	240	java/lang/Throwable
    //   87	136	255	finally
    //   136	190	255	finally
    //   220	230	255	finally
    //   257	264	267	java/lang/Throwable
    //   136	190	282	java/lang/Throwable
  }
  
  /* Error */
  private e a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 77
    //   2: new 79	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9: ldc 197
    //   11: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 96	java/lang/Thread:getId	()J
    //   20: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: iload_1
    //   30: ifne +58 -> 88
    //   33: aload_0
    //   34: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   37: ldc 199
    //   39: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   42: ifeq +46 -> 88
    //   45: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   48: aload_0
    //   49: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   52: ldc 199
    //   54: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 126	java/lang/Long
    //   60: invokevirtual 129	java/lang/Long:longValue	()J
    //   63: lsub
    //   64: ldc2_w 130
    //   67: lcmp
    //   68: ifge +20 -> 88
    //   71: new 133	com/tencent/token/global/e
    //   74: dup
    //   75: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   78: astore_2
    //   79: aload_2
    //   80: sipush 10000
    //   83: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   86: aload_2
    //   87: areturn
    //   88: aload_0
    //   89: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   92: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   95: new 142	com/tencent/token/do
    //   98: dup
    //   99: ldc 199
    //   101: iconst_1
    //   102: aconst_null
    //   103: sipush 4000
    //   106: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   109: astore_2
    //   110: ldc 199
    //   112: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   115: aload_2
    //   116: invokevirtual 202	com/tencent/token/core/protocolcenter/d:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   119: astore_2
    //   120: ldc 77
    //   122: new 79	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   129: ldc 204
    //   131: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_2
    //   135: getfield 170	com/tencent/token/global/e:a	I
    //   138: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_0
    //   148: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   151: ldc 199
    //   153: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   156: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   159: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: aload_0
    //   164: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   167: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   170: aload_2
    //   171: areturn
    //   172: astore_3
    //   173: ldc 49
    //   175: aload_3
    //   176: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   179: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_2
    //   183: areturn
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_2
    //   187: ldc 49
    //   189: aload_3
    //   190: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   193: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_0
    //   197: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   200: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   203: aload_2
    //   204: areturn
    //   205: astore_3
    //   206: ldc 49
    //   208: aload_3
    //   209: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   212: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_2
    //   216: areturn
    //   217: astore_2
    //   218: aload_0
    //   219: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   222: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   225: aload_2
    //   226: athrow
    //   227: astore_3
    //   228: ldc 49
    //   230: aload_3
    //   231: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   234: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -12 -> 225
    //   240: astore_3
    //   241: goto -54 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	bv
    //   0	244	1	paramBoolean	boolean
    //   78	138	2	localObject1	Object
    //   217	9	2	localObject2	Object
    //   172	4	3	localThrowable1	Throwable
    //   184	6	3	localThrowable2	Throwable
    //   205	4	3	localThrowable3	Throwable
    //   227	4	3	localThrowable4	Throwable
    //   240	1	3	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   163	170	172	java/lang/Throwable
    //   88	120	184	java/lang/Throwable
    //   196	203	205	java/lang/Throwable
    //   88	120	217	finally
    //   120	163	217	finally
    //   187	196	217	finally
    //   218	225	227	java/lang/Throwable
    //   120	163	240	java/lang/Throwable
  }
  
  /* Error */
  private e d()
  {
    // Byte code:
    //   0: ldc 77
    //   2: new 79	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9: ldc 214
    //   11: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 96	java/lang/Thread:getId	()J
    //   20: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: ldc 216
    //   35: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +46 -> 84
    //   41: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   44: aload_0
    //   45: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   48: ldc 216
    //   50: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: checkcast 126	java/lang/Long
    //   56: invokevirtual 129	java/lang/Long:longValue	()J
    //   59: lsub
    //   60: ldc2_w 130
    //   63: lcmp
    //   64: ifge +20 -> 84
    //   67: new 133	com/tencent/token/global/e
    //   70: dup
    //   71: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   74: astore_1
    //   75: aload_1
    //   76: sipush 10000
    //   79: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   82: aload_1
    //   83: areturn
    //   84: aload_0
    //   85: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   88: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   91: new 142	com/tencent/token/do
    //   94: dup
    //   95: ldc 216
    //   97: iconst_1
    //   98: aconst_null
    //   99: sipush 3025
    //   102: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   105: astore_1
    //   106: ldc 216
    //   108: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   111: aload_1
    //   112: invokevirtual 202	com/tencent/token/core/protocolcenter/d:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   115: astore_1
    //   116: ldc 77
    //   118: new 79	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   125: ldc 204
    //   127: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: getfield 170	com/tencent/token/global/e:a	I
    //   134: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   147: ldc 216
    //   149: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   152: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload_0
    //   160: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   163: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   166: aload_1
    //   167: areturn
    //   168: astore_2
    //   169: ldc 49
    //   171: aload_2
    //   172: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   175: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_1
    //   179: areturn
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_1
    //   183: ldc 49
    //   185: aload_2
    //   186: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   189: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   199: aload_1
    //   200: areturn
    //   201: astore_2
    //   202: ldc 49
    //   204: aload_2
    //   205: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   208: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_1
    //   212: areturn
    //   213: astore_1
    //   214: aload_0
    //   215: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   218: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore_2
    //   224: ldc 49
    //   226: aload_2
    //   227: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   230: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: goto -12 -> 221
    //   236: astore_2
    //   237: goto -54 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	bv
    //   74	138	1	localObject1	Object
    //   213	9	1	localObject2	Object
    //   168	4	2	localThrowable1	Throwable
    //   180	6	2	localThrowable2	Throwable
    //   201	4	2	localThrowable3	Throwable
    //   223	4	2	localThrowable4	Throwable
    //   236	1	2	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   159	166	168	java/lang/Throwable
    //   84	116	180	java/lang/Throwable
    //   192	199	201	java/lang/Throwable
    //   84	116	213	finally
    //   116	159	213	finally
    //   183	192	213	finally
    //   214	221	223	java/lang/Throwable
    //   116	159	236	java/lang/Throwable
  }
  
  /* Error */
  private e e()
  {
    // Byte code:
    //   0: ldc 77
    //   2: new 79	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9: ldc 221
    //   11: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 96	java/lang/Thread:getId	()J
    //   20: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: ldc 223
    //   35: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +46 -> 84
    //   41: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   44: aload_0
    //   45: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   48: ldc 223
    //   50: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: checkcast 126	java/lang/Long
    //   56: invokevirtual 129	java/lang/Long:longValue	()J
    //   59: lsub
    //   60: ldc2_w 130
    //   63: lcmp
    //   64: ifge +20 -> 84
    //   67: new 133	com/tencent/token/global/e
    //   70: dup
    //   71: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   74: astore_1
    //   75: aload_1
    //   76: sipush 10000
    //   79: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   82: aload_1
    //   83: areturn
    //   84: aload_0
    //   85: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   88: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   91: new 142	com/tencent/token/do
    //   94: dup
    //   95: ldc 223
    //   97: iconst_1
    //   98: aconst_null
    //   99: sipush 4016
    //   102: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   105: astore_1
    //   106: ldc 223
    //   108: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   111: aload_1
    //   112: invokevirtual 202	com/tencent/token/core/protocolcenter/d:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   115: astore_1
    //   116: aload_0
    //   117: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   120: ldc 223
    //   122: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   125: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: pop
    //   132: ldc 77
    //   134: new 79	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   141: ldc 225
    //   143: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_1
    //   147: getfield 170	com/tencent/token/global/e:a	I
    //   150: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_0
    //   160: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   163: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   166: aload_1
    //   167: areturn
    //   168: astore_2
    //   169: ldc 49
    //   171: aload_2
    //   172: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   175: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_1
    //   179: areturn
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_1
    //   183: ldc 49
    //   185: aload_2
    //   186: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   189: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   199: aload_1
    //   200: areturn
    //   201: astore_2
    //   202: ldc 49
    //   204: aload_2
    //   205: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   208: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_1
    //   212: areturn
    //   213: astore_1
    //   214: aload_0
    //   215: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   218: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore_2
    //   224: ldc 49
    //   226: aload_2
    //   227: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   230: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: goto -12 -> 221
    //   236: astore_2
    //   237: goto -54 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	bv
    //   74	138	1	localObject1	Object
    //   213	9	1	localObject2	Object
    //   168	4	2	localThrowable1	Throwable
    //   180	6	2	localThrowable2	Throwable
    //   201	4	2	localThrowable3	Throwable
    //   223	4	2	localThrowable4	Throwable
    //   236	1	2	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   159	166	168	java/lang/Throwable
    //   84	116	180	java/lang/Throwable
    //   192	199	201	java/lang/Throwable
    //   84	116	213	finally
    //   116	159	213	finally
    //   183	192	213	finally
    //   214	221	223	java/lang/Throwable
    //   116	159	236	java/lang/Throwable
  }
  
  /* Error */
  private e f()
  {
    // Byte code:
    //   0: ldc 77
    //   2: new 79	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   9: ldc 227
    //   11: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 96	java/lang/Thread:getId	()J
    //   20: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: ldc 229
    //   35: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +46 -> 84
    //   41: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   44: aload_0
    //   45: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   48: ldc 229
    //   50: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: checkcast 126	java/lang/Long
    //   56: invokevirtual 129	java/lang/Long:longValue	()J
    //   59: lsub
    //   60: ldc2_w 130
    //   63: lcmp
    //   64: ifge +20 -> 84
    //   67: new 133	com/tencent/token/global/e
    //   70: dup
    //   71: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   74: astore_1
    //   75: aload_1
    //   76: sipush 10006
    //   79: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   82: aload_1
    //   83: areturn
    //   84: aload_0
    //   85: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   88: invokevirtual 140	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   91: new 142	com/tencent/token/do
    //   94: dup
    //   95: ldc 229
    //   97: iconst_1
    //   98: aconst_null
    //   99: sipush 3003
    //   102: invokespecial 145	com/tencent/token/do:<init>	(Ljava/lang/String;ILandroid/os/Handler;I)V
    //   105: astore_1
    //   106: ldc 229
    //   108: invokestatic 150	com/tencent/token/core/protocolcenter/b:a	(Ljava/lang/String;)Lcom/tencent/token/core/protocolcenter/d;
    //   111: aload_1
    //   112: invokevirtual 202	com/tencent/token/core/protocolcenter/d:c	(Lcom/tencent/token/do;)Lcom/tencent/token/global/e;
    //   115: astore_1
    //   116: ldc 77
    //   118: new 79	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   125: ldc 231
    //   127: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: getfield 170	com/tencent/token/global/e:a	I
    //   134: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield 45	com/tencent/token/bv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   147: ldc 229
    //   149: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   152: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: invokevirtual 181	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload_0
    //   160: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   163: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   166: aload_1
    //   167: areturn
    //   168: astore_2
    //   169: ldc 49
    //   171: aload_2
    //   172: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   175: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_1
    //   179: areturn
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_1
    //   183: ldc 49
    //   185: aload_2
    //   186: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   189: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   199: aload_1
    //   200: areturn
    //   201: astore_2
    //   202: ldc 49
    //   204: aload_2
    //   205: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   208: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_1
    //   212: areturn
    //   213: astore_1
    //   214: aload_0
    //   215: getfield 40	com/tencent/token/bv:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   218: invokevirtual 184	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore_2
    //   224: ldc 49
    //   226: aload_2
    //   227: invokevirtual 185	java/lang/Throwable:toString	()Ljava/lang/String;
    //   230: invokestatic 188	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: goto -12 -> 221
    //   236: astore_2
    //   237: goto -54 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	bv
    //   74	138	1	localObject1	Object
    //   213	9	1	localObject2	Object
    //   168	4	2	localThrowable1	Throwable
    //   180	6	2	localThrowable2	Throwable
    //   201	4	2	localThrowable3	Throwable
    //   223	4	2	localThrowable4	Throwable
    //   236	1	2	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   159	166	168	java/lang/Throwable
    //   84	116	180	java/lang/Throwable
    //   192	199	201	java/lang/Throwable
    //   84	116	213	finally
    //   116	159	213	finally
    //   183	192	213	finally
    //   214	221	223	java/lang/Throwable
    //   116	159	236	java/lang/Throwable
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
      public void run()
      {
        for (;;)
        {
          try
          {
            bv.a(bv.this).lock();
            locale = bv.a(bv.this, paramLong, paramHandler);
            localMessage = this.c.obtainMessage(3071);
            localMessage.arg1 = locale.a;
            if (locale.a == 0)
            {
              localMessage.obj = locale.d;
              localMessage.sendToTarget();
              TmsLog.i("CoreCGIManager", "callback sendQueryCaptha(), retcode: " + locale.a);
            }
          }
          catch (Throwable localThrowable1)
          {
            e locale;
            Message localMessage;
            localThrowable1 = localThrowable1;
            TmsLog.w("CoreCGIManager", localThrowable1.toString());
            try
            {
              bv.a(bv.this).unlock();
              return;
            }
            catch (Throwable localThrowable2)
            {
              TmsLog.w("CoreCGIManager", localThrowable2.toString());
              return;
            }
          }
          finally {}
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable3)
          {
            TmsLog.w("CoreCGIManager", localThrowable3.toString());
            return;
          }
          localMessage.obj = locale;
        }
        try
        {
          bv.a(bv.this).unlock();
          throw localObject;
        }
        catch (Throwable localThrowable4)
        {
          for (;;)
          {
            TmsLog.w("CoreCGIManager", localThrowable4.toString());
          }
        }
      }
    });
  }
  
  public void a(final Handler paramHandler)
  {
    TmsLog.i("CoreCGIManager", "invoke sendExchangeKey()");
    this.c.post(new Runnable()
    {
      public void run()
      {
        try
        {
          bv.a(bv.this).lock();
          e locale = bv.a(bv.this, true);
          if (paramHandler != null)
          {
            Message localMessage = paramHandler.obtainMessage(4000);
            localMessage.arg1 = locale.a;
            localMessage.obj = locale;
            localMessage.sendToTarget();
          }
          TmsLog.i("CoreCGIManager", "callback sendExchangeKey(), retcode: " + locale.a);
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable1)
          {
            TmsLog.w("CoreCGIManager", localThrowable1.toString());
            return;
          }
          try
          {
            bv.a(bv.this).unlock();
            throw localObject;
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              TmsLog.w("CoreCGIManager", localThrowable4.toString());
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2 = localThrowable2;
          TmsLog.w("CoreCGIManager", localThrowable2.toString());
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable3)
          {
            TmsLog.w("CoreCGIManager", localThrowable3.toString());
            return;
          }
        }
        finally {}
      }
    });
  }
  
  /* Error */
  public e b()
  {
    // Byte code:
    //   0: ldc 49
    //   2: ldc 253
    //   4: invokestatic 109	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: new 255	java/util/concurrent/atomic/AtomicReference
    //   10: dup
    //   11: invokespecial 256	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 66	com/tencent/token/bv:c	Landroid/os/Handler;
    //   19: new 6	com/tencent/token/bv$1
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial 259	com/tencent/token/bv$1:<init>	(Lcom/tencent/token/bv;Ljava/util/concurrent/atomic/AtomicReference;)V
    //   28: invokevirtual 243	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   31: pop
    //   32: aload_1
    //   33: monitorenter
    //   34: aload_1
    //   35: ldc2_w 260
    //   38: invokevirtual 265	java/lang/Object:wait	(J)V
    //   41: aload_1
    //   42: monitorexit
    //   43: aload_1
    //   44: invokevirtual 268	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   47: ifnonnull +23 -> 70
    //   50: new 133	com/tencent/token/global/e
    //   53: dup
    //   54: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: sipush 10000
    //   62: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 272	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   70: aload_1
    //   71: invokevirtual 268	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   74: checkcast 133	com/tencent/token/global/e
    //   77: areturn
    //   78: astore_2
    //   79: aload_1
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    //   83: astore_2
    //   84: goto -43 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	bv
    //   14	66	1	localAtomicReference	AtomicReference
    //   57	10	2	locale	e
    //   78	4	2	localObject	Object
    //   83	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   34	41	78	finally
    //   41	43	78	finally
    //   79	81	78	finally
    //   34	41	83	java/lang/InterruptedException
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
      public void run()
      {
        try
        {
          bv.a(bv.this).lock();
          e locale = bv.a(bv.this, false);
          Message localMessage = paramHandler.obtainMessage(4000);
          localMessage.arg1 = locale.a;
          localMessage.obj = locale;
          localMessage.sendToTarget();
          TmsLog.i("CoreCGIManager", "callback sendExchangeKey(), retcode: " + locale.a);
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable1)
          {
            TmsLog.w("CoreCGIManager", localThrowable1.toString());
            return;
          }
          try
          {
            bv.a(bv.this).unlock();
            throw localObject;
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              TmsLog.w("CoreCGIManager", localThrowable4.toString());
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2 = localThrowable2;
          TmsLog.w("CoreCGIManager", localThrowable2.toString());
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable3)
          {
            TmsLog.w("CoreCGIManager", localThrowable3.toString());
            return;
          }
        }
        finally {}
      }
    });
  }
  
  /* Error */
  public e c()
  {
    // Byte code:
    //   0: new 255	java/util/concurrent/atomic/AtomicReference
    //   3: dup
    //   4: invokespecial 256	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 66	com/tencent/token/bv:c	Landroid/os/Handler;
    //   12: new 18	com/tencent/token/bv$7
    //   15: dup
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial 276	com/tencent/token/bv$7:<init>	(Lcom/tencent/token/bv;Ljava/util/concurrent/atomic/AtomicReference;)V
    //   21: invokevirtual 243	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   24: pop
    //   25: aload_1
    //   26: monitorenter
    //   27: aload_1
    //   28: ldc2_w 277
    //   31: invokevirtual 265	java/lang/Object:wait	(J)V
    //   34: aload_1
    //   35: monitorexit
    //   36: aload_1
    //   37: invokevirtual 268	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   40: ifnonnull +23 -> 63
    //   43: new 133	com/tencent/token/global/e
    //   46: dup
    //   47: invokespecial 134	com/tencent/token/global/e:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: sipush 10000
    //   55: invokevirtual 137	com/tencent/token/global/e:b	(I)V
    //   58: aload_1
    //   59: aload_2
    //   60: invokevirtual 272	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   63: aload_1
    //   64: invokevirtual 268	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   67: checkcast 133	com/tencent/token/global/e
    //   70: areturn
    //   71: astore_2
    //   72: aload_1
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: goto -43 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	bv
    //   7	66	1	localAtomicReference	AtomicReference
    //   50	10	2	locale	e
    //   71	4	2	localObject	Object
    //   76	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   27	34	71	finally
    //   34	36	71	finally
    //   72	74	71	finally
    //   27	34	76	java/lang/InterruptedException
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
      public void run()
      {
        try
        {
          bv.a(bv.this).lock();
          e locale = bv.b(bv.this);
          Message localMessage = paramHandler.obtainMessage(3025);
          localMessage.arg1 = locale.a;
          localMessage.obj = locale;
          localMessage.sendToTarget();
          TmsLog.i("CoreCGIManager", "callback sendActiveToken(), retcode: " + locale.a);
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable1)
          {
            TmsLog.w("CoreCGIManager", localThrowable1.toString());
            return;
          }
          try
          {
            bv.a(bv.this).unlock();
            throw localObject;
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              TmsLog.w("CoreCGIManager", localThrowable4.toString());
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2 = localThrowable2;
          TmsLog.w("CoreCGIManager", localThrowable2.toString());
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable3)
          {
            TmsLog.w("CoreCGIManager", localThrowable3.toString());
            return;
          }
        }
        finally {}
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
      public void run()
      {
        try
        {
          bv.a(bv.this).lock();
          e locale = bv.c(bv.this);
          Message localMessage = paramHandler.obtainMessage(4016);
          localMessage.arg1 = locale.a;
          localMessage.obj = locale;
          localMessage.sendToTarget();
          TmsLog.i("CoreCGIManager", "callback sendModSeed(), retcode: " + locale.a);
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable1)
          {
            TmsLog.w("CoreCGIManager", localThrowable1.toString());
            return;
          }
          try
          {
            bv.a(bv.this).unlock();
            throw localObject;
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              TmsLog.w("CoreCGIManager", localThrowable4.toString());
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2 = localThrowable2;
          TmsLog.w("CoreCGIManager", localThrowable2.toString());
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable3)
          {
            TmsLog.w("CoreCGIManager", localThrowable3.toString());
            return;
          }
        }
        finally {}
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
      public void run()
      {
        try
        {
          bv.a(bv.this).lock();
          e locale = bv.d(bv.this);
          Message localMessage = paramHandler.obtainMessage(3003);
          localMessage.arg1 = locale.a;
          localMessage.obj = locale;
          localMessage.sendToTarget();
          TmsLog.i("CoreCGIManager", "callback sendGetUinList(), retcode: " + locale.a);
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable1)
          {
            TmsLog.w("CoreCGIManager", localThrowable1.toString());
            return;
          }
          try
          {
            bv.a(bv.this).unlock();
            throw localObject;
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              TmsLog.w("CoreCGIManager", localThrowable4.toString());
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2 = localThrowable2;
          TmsLog.w("CoreCGIManager", localThrowable2.toString());
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable3)
          {
            TmsLog.w("CoreCGIManager", localThrowable3.toString());
            return;
          }
        }
        finally {}
      }
    });
  }
  
  public void f(final Handler paramHandler)
  {
    TmsLog.i("CoreCGIManager", "invoke sendGetUinListSticky()");
    this.c.post(new Runnable()
    {
      public void run()
      {
        try
        {
          bv.a(bv.this).lock();
          e locale = bv.d(bv.this);
          Message localMessage = paramHandler.obtainMessage(3003);
          localMessage.arg1 = locale.a;
          localMessage.obj = locale;
          localMessage.sendToTarget();
          TmsLog.i("CoreCGIManager", "callback sendGetUinListSticky(), retcode: " + locale.a);
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable1)
          {
            TmsLog.w("CoreCGIManager", localThrowable1.toString());
            return;
          }
          try
          {
            bv.a(bv.this).unlock();
            throw localObject;
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              TmsLog.w("CoreCGIManager", localThrowable4.toString());
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2 = localThrowable2;
          TmsLog.w("CoreCGIManager", localThrowable2.toString());
          try
          {
            bv.a(bv.this).unlock();
            return;
          }
          catch (Throwable localThrowable3)
          {
            TmsLog.w("CoreCGIManager", localThrowable3.toString());
            return;
          }
        }
        finally {}
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