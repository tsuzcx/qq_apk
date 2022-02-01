package com.tencent.mobileqq.intervideo.now.dynamic;

import aigg;
import android.content.Context;
import android.os.Bundle;
import com.tencent.shadow.dynamic.host.EnterCallback;

public class NowShadowImpl$1
  implements Runnable
{
  public NowShadowImpl$1(aigg paramaigg, Context paramContext, String paramString1, String paramString2, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 48
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 23	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:this$0	Laigg;
    //   7: invokestatic 51	aigg:a	(Laigg;)Laibz;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +38 -> 50
    //   15: ldc 53
    //   17: iconst_1
    //   18: ldc 55
    //   20: invokestatic 61	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: getfield 23	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:this$0	Laigg;
    //   27: aload_0
    //   28: getfield 23	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:this$0	Laigg;
    //   31: aload_0
    //   32: getfield 25	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:val$context	Landroid/content/Context;
    //   35: aload_0
    //   36: getfield 27	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:val$uin	Ljava/lang/String;
    //   39: aload_0
    //   40: getfield 29	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:val$appid	Ljava/lang/String;
    //   43: invokevirtual 65	aigg:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Laibz;
    //   46: invokestatic 68	aigg:a	(Laigg;Laibz;)Laibz;
    //   49: pop
    //   50: ldc 53
    //   52: iconst_1
    //   53: ldc 70
    //   55: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_0
    //   59: getfield 23	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:this$0	Laigg;
    //   62: invokestatic 51	aigg:a	(Laigg;)Laibz;
    //   65: ifnull +31 -> 96
    //   68: aload_0
    //   69: getfield 23	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:this$0	Laigg;
    //   72: invokestatic 51	aigg:a	(Laigg;)Laibz;
    //   75: aload_0
    //   76: getfield 25	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:val$context	Landroid/content/Context;
    //   79: aload_0
    //   80: getfield 31	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:abx	J
    //   83: aload_0
    //   84: getfield 33	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:val$bundle	Landroid/os/Bundle;
    //   87: aload_0
    //   88: getfield 35	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:a	Lcom/tencent/shadow/dynamic/host/EnterCallback;
    //   91: invokeinterface 79 6 0
    //   96: ldc 48
    //   98: monitorexit
    //   99: return
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 82	java/lang/InterruptedException:printStackTrace	()V
    //   105: aload_0
    //   106: getfield 23	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:this$0	Laigg;
    //   109: aload_1
    //   110: invokevirtual 86	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   113: invokestatic 89	aigg:a	(Laigg;Ljava/lang/String;)V
    //   116: ldc 91
    //   118: iconst_1
    //   119: new 93	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   126: ldc 96
    //   128: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_1
    //   132: invokevirtual 103	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   135: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: goto -94 -> 50
    //   147: astore_1
    //   148: ldc 48
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 108	java/util/concurrent/TimeoutException:printStackTrace	()V
    //   158: aload_0
    //   159: getfield 23	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:this$0	Laigg;
    //   162: aload_1
    //   163: invokevirtual 109	java/util/concurrent/TimeoutException:getMessage	()Ljava/lang/String;
    //   166: invokestatic 89	aigg:a	(Laigg;Ljava/lang/String;)V
    //   169: ldc 91
    //   171: iconst_1
    //   172: new 93	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   179: ldc 96
    //   181: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 110	java/util/concurrent/TimeoutException:toString	()Ljava/lang/String;
    //   188: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: goto -147 -> 50
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 111	java/util/concurrent/ExecutionException:printStackTrace	()V
    //   205: aload_0
    //   206: getfield 23	com/tencent/mobileqq/intervideo/now/dynamic/NowShadowImpl$1:this$0	Laigg;
    //   209: aload_1
    //   210: invokevirtual 112	java/util/concurrent/ExecutionException:getMessage	()Ljava/lang/String;
    //   213: invokestatic 89	aigg:a	(Laigg;Ljava/lang/String;)V
    //   216: ldc 91
    //   218: iconst_1
    //   219: new 93	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   226: ldc 96
    //   228: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: invokevirtual 113	java/util/concurrent/ExecutionException:toString	()Ljava/lang/String;
    //   235: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto -194 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	1
    //   10	2	1	localaibz	aibz
    //   100	32	1	localInterruptedException	java.lang.InterruptedException
    //   147	5	1	localObject	Object
    //   153	32	1	localTimeoutException	java.util.concurrent.TimeoutException
    //   200	32	1	localExecutionException	java.util.concurrent.ExecutionException
    // Exception table:
    //   from	to	target	type
    //   15	50	100	java/lang/InterruptedException
    //   3	11	147	finally
    //   15	50	147	finally
    //   50	96	147	finally
    //   96	99	147	finally
    //   101	144	147	finally
    //   148	151	147	finally
    //   154	197	147	finally
    //   201	244	147	finally
    //   15	50	153	java/util/concurrent/TimeoutException
    //   15	50	200	java/util/concurrent/ExecutionException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowShadowImpl.1
 * JD-Core Version:    0.7.0.1
 */