import com.tencent.mobileqq.app.BaseActivity;

public class yxb
  implements Runnable
{
  public yxb(BaseActivity paramBaseActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 29
    //   2: monitorenter
    //   3: invokestatic 33	com/tencent/mobileqq/app/BaseActivity:access$300	()Lcom/tencent/mobileqq/app/ShakeListener;
    //   6: ifnonnull +60 -> 66
    //   9: new 35	yxf
    //   12: dup
    //   13: aconst_null
    //   14: invokespecial 38	yxf:<init>	(Lyww;)V
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 12	yxb:a	Lcom/tencent/mobileqq/app/BaseActivity;
    //   22: invokevirtual 42	com/tencent/mobileqq/app/BaseActivity:getApplicationContext	()Landroid/content/Context;
    //   25: ldc 44
    //   27: invokevirtual 50	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 52	android/hardware/SensorManager
    //   33: astore_2
    //   34: aload_2
    //   35: iconst_1
    //   36: invokevirtual 56	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   39: astore 4
    //   41: invokestatic 61	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:a	()Lcom/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor;
    //   44: invokevirtual 64	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:a	()Z
    //   47: ifeq +240 -> 287
    //   50: iconst_2
    //   51: istore_1
    //   52: aload_2
    //   53: aload_3
    //   54: aload 4
    //   56: iload_1
    //   57: invokevirtual 68	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   60: pop
    //   61: aload_3
    //   62: invokestatic 72	com/tencent/mobileqq/app/BaseActivity:access$302	(Lcom/tencent/mobileqq/app/ShakeListener;)Lcom/tencent/mobileqq/app/ShakeListener;
    //   65: pop
    //   66: ldc 29
    //   68: monitorexit
    //   69: return
    //   70: astore_3
    //   71: new 74	java/lang/StringBuilder
    //   74: dup
    //   75: ldc 76
    //   77: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: astore 4
    //   82: ldc 81
    //   84: invokestatic 87	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   87: ldc 89
    //   89: invokevirtual 93	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   92: astore 5
    //   94: aload 5
    //   96: iconst_1
    //   97: invokevirtual 99	java/lang/reflect/Field:setAccessible	(Z)V
    //   100: aload 5
    //   102: aload_2
    //   103: invokevirtual 103	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 105	java/util/HashMap
    //   109: invokevirtual 109	java/util/HashMap:keySet	()Ljava/util/Set;
    //   112: invokeinterface 115 1 0
    //   117: astore_2
    //   118: aload_2
    //   119: invokeinterface 120 1 0
    //   124: ifeq +86 -> 210
    //   127: aload 4
    //   129: aload_2
    //   130: invokeinterface 124 1 0
    //   135: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: ldc 130
    //   140: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: goto -26 -> 118
    //   147: astore_2
    //   148: new 74	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   155: ldc 136
    //   157: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_2
    //   161: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore_2
    //   168: aload_2
    //   169: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifne +17 -> 189
    //   175: aload 4
    //   177: aload_2
    //   178: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: ldc 148
    //   184: iconst_1
    //   185: aload_2
    //   186: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload_3
    //   190: ldc 156
    //   192: aload 4
    //   194: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 162	com/tencent/mobileqq/statistics/QQCatchedExceptionReporter:reportQQCatchedException	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   200: ldc 29
    //   202: monitorexit
    //   203: return
    //   204: astore_2
    //   205: ldc 29
    //   207: monitorexit
    //   208: aload_2
    //   209: athrow
    //   210: aconst_null
    //   211: astore_2
    //   212: goto -44 -> 168
    //   215: astore_2
    //   216: new 74	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   223: ldc 164
    //   225: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_2
    //   229: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore_2
    //   236: goto -68 -> 168
    //   239: astore_2
    //   240: new 74	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   247: ldc 166
    //   249: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_2
    //   253: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore_2
    //   260: goto -92 -> 168
    //   263: astore_2
    //   264: new 74	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   271: ldc 168
    //   273: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_2
    //   277: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: astore_2
    //   284: goto -116 -> 168
    //   287: iconst_0
    //   288: istore_1
    //   289: goto -237 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	yxb
    //   51	238	1	i	int
    //   33	97	2	localObject1	Object
    //   147	14	2	localClassNotFoundException	java.lang.ClassNotFoundException
    //   167	19	2	str1	java.lang.String
    //   204	5	2	localObject2	Object
    //   211	1	2	localObject3	Object
    //   215	14	2	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   235	1	2	str2	java.lang.String
    //   239	14	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   259	1	2	str3	java.lang.String
    //   263	14	2	localThrowable	java.lang.Throwable
    //   283	1	2	str4	java.lang.String
    //   17	45	3	localyxf	yxf
    //   70	120	3	localIllegalStateException	java.lang.IllegalStateException
    //   39	154	4	localObject4	Object
    //   92	9	5	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   34	50	70	java/lang/IllegalStateException
    //   52	61	70	java/lang/IllegalStateException
    //   82	118	147	java/lang/ClassNotFoundException
    //   118	144	147	java/lang/ClassNotFoundException
    //   3	34	204	finally
    //   34	50	204	finally
    //   52	61	204	finally
    //   61	66	204	finally
    //   66	69	204	finally
    //   71	82	204	finally
    //   82	118	204	finally
    //   118	144	204	finally
    //   148	168	204	finally
    //   168	189	204	finally
    //   189	203	204	finally
    //   205	208	204	finally
    //   216	236	204	finally
    //   240	260	204	finally
    //   264	284	204	finally
    //   82	118	215	java/lang/NoSuchFieldException
    //   118	144	215	java/lang/NoSuchFieldException
    //   82	118	239	java/lang/IllegalAccessException
    //   118	144	239	java/lang/IllegalAccessException
    //   82	118	263	java/lang/Throwable
    //   118	144	263	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yxb
 * JD-Core Version:    0.7.0.1
 */