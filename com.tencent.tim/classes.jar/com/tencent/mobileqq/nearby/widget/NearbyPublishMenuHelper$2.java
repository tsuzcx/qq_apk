package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import arhz;

public final class NearbyPublishMenuHelper$2
  implements Runnable
{
  public NearbyPublishMenuHelper$2(arhz paramarhz, String paramString1, Context paramContext, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 34	android/os/Handler
    //   3: dup
    //   4: invokestatic 40	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   7: invokespecial 43	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   10: astore 4
    //   12: invokestatic 49	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: invokevirtual 53	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   18: astore 5
    //   20: aload 4
    //   22: new 55	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$1
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 58	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$1:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   30: invokevirtual 62	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   33: pop
    //   34: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   37: lstore_1
    //   38: aload_0
    //   39: getfield 19	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:rw	Ljava/lang/String;
    //   42: iconst_1
    //   43: iconst_1
    //   44: sipush 1280
    //   47: sipush 1280
    //   50: invokestatic 74	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;IIII)Lorg/json/JSONObject;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnonnull +132 -> 187
    //   58: ldc 76
    //   60: astore_3
    //   61: aload 5
    //   63: invokevirtual 82	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   66: aload_3
    //   67: invokestatic 88	akks:gP	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: new 90	android/content/Intent
    //   73: dup
    //   74: aload_0
    //   75: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:val$context	Landroid/content/Context;
    //   78: ldc 92
    //   80: invokespecial 95	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   83: astore 6
    //   85: aload 6
    //   87: ldc 97
    //   89: aload_0
    //   90: getfield 23	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:val$jumpUrl	Ljava/lang/String;
    //   93: invokevirtual 101	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   96: pop
    //   97: aload 6
    //   99: aload_0
    //   100: getfield 23	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:val$jumpUrl	Ljava/lang/String;
    //   103: invokestatic 107	ocp:f	(Landroid/content/Intent;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:val$context	Landroid/content/Context;
    //   110: instanceof 109
    //   113: ifeq +82 -> 195
    //   116: aload_0
    //   117: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:val$context	Landroid/content/Context;
    //   120: checkcast 109	android/app/Activity
    //   123: aload 6
    //   125: sipush 1002
    //   128: invokevirtual 113	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   131: ldc 115
    //   133: iconst_1
    //   134: new 117	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   141: ldc 120
    //   143: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_3
    //   147: invokevirtual 130	java/lang/String:length	()I
    //   150: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc 135
    //   155: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   161: lload_1
    //   162: lsub
    //   163: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   166: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload 4
    //   174: new 149	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   177: dup
    //   178: aload_0
    //   179: invokespecial 150	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   182: invokevirtual 62	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   185: pop
    //   186: return
    //   187: aload_3
    //   188: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   191: astore_3
    //   192: goto -131 -> 61
    //   195: aload_0
    //   196: getfield 21	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2:val$context	Landroid/content/Context;
    //   199: aload 6
    //   201: invokevirtual 159	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   204: goto -73 -> 131
    //   207: astore_3
    //   208: aload 5
    //   210: invokevirtual 82	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   213: ldc 76
    //   215: invokestatic 88	akks:gP	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: ldc 115
    //   220: iconst_1
    //   221: new 117	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   228: ldc 161
    //   230: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   237: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload 4
    //   248: new 149	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   251: dup
    //   252: aload_0
    //   253: invokespecial 150	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   256: invokevirtual 62	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   259: pop
    //   260: return
    //   261: astore_3
    //   262: aload 5
    //   264: invokevirtual 82	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   267: ldc 76
    //   269: invokestatic 88	akks:gP	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: ldc 115
    //   274: iconst_1
    //   275: new 117	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   282: ldc 167
    //   284: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_3
    //   288: invokevirtual 168	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   291: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload 4
    //   302: new 149	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   305: dup
    //   306: aload_0
    //   307: invokespecial 150	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   310: invokevirtual 62	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   313: pop
    //   314: return
    //   315: astore_3
    //   316: aload 4
    //   318: new 149	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2
    //   321: dup
    //   322: aload_0
    //   323: invokespecial 150	com/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2$2:<init>	(Lcom/tencent/mobileqq/nearby/widget/NearbyPublishMenuHelper$2;)V
    //   326: invokevirtual 62	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   329: pop
    //   330: aload_3
    //   331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	2
    //   37	125	1	l	long
    //   53	139	3	localObject1	Object
    //   207	27	3	localException	java.lang.Exception
    //   261	27	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   315	16	3	localObject2	Object
    //   10	307	4	localHandler	android.os.Handler
    //   18	245	5	localAppRuntime	mqq.app.AppRuntime
    //   83	117	6	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   20	54	207	java/lang/Exception
    //   61	131	207	java/lang/Exception
    //   131	172	207	java/lang/Exception
    //   187	192	207	java/lang/Exception
    //   195	204	207	java/lang/Exception
    //   20	54	261	java/lang/OutOfMemoryError
    //   61	131	261	java/lang/OutOfMemoryError
    //   131	172	261	java/lang/OutOfMemoryError
    //   187	192	261	java/lang/OutOfMemoryError
    //   195	204	261	java/lang/OutOfMemoryError
    //   20	54	315	finally
    //   61	131	315	finally
    //   131	172	315	finally
    //   187	192	315	finally
    //   195	204	315	finally
    //   208	246	315	finally
    //   262	300	315	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper.2
 * JD-Core Version:    0.7.0.1
 */