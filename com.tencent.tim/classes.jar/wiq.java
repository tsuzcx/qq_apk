public class wiq
{
  public static wip a;
  public static int bNA;
  public static boolean bcw;
  public static boolean bcx;
  
  /* Error */
  public static void aQ(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +11 -> 19
    //   11: ldc 25
    //   13: iconst_2
    //   14: ldc 27
    //   16: invokestatic 31	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   23: astore_0
    //   24: invokestatic 43	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   27: new 45	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   34: aload_0
    //   35: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 55
    //   40: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 57
    //   45: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: iconst_0
    //   52: invokevirtual 64	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   55: astore_0
    //   56: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +11 -> 70
    //   62: ldc 25
    //   64: iconst_2
    //   65: ldc 66
    //   67: invokestatic 31	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: ldc 68
    //   73: iconst_0
    //   74: invokeinterface 74 3 0
    //   79: iconst_1
    //   80: if_icmpne +275 -> 355
    //   83: iload_1
    //   84: putstatic 76	wiq:bcx	Z
    //   87: aload_0
    //   88: ldc 78
    //   90: bipush 10
    //   92: invokeinterface 74 3 0
    //   97: putstatic 80	wiq:bNA	I
    //   100: aload_0
    //   101: ldc 82
    //   103: ldc 84
    //   105: invokeinterface 88 3 0
    //   110: astore_0
    //   111: aload_0
    //   112: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +15 -> 130
    //   118: aload_0
    //   119: ldc 96
    //   121: invokestatic 102	aiio:convertFromJSONObject	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   124: checkcast 96	wip
    //   127: putstatic 104	wiq:a	Lwip;
    //   130: getstatic 104	wiq:a	Lwip;
    //   133: ifnull +35 -> 168
    //   136: getstatic 108	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   139: ldc 110
    //   141: iconst_4
    //   142: invokevirtual 64	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   145: invokeinterface 114 1 0
    //   150: ldc 116
    //   152: getstatic 104	wiq:a	Lwip;
    //   155: getfield 119	wip:bcv	Z
    //   158: invokeinterface 125 3 0
    //   163: invokeinterface 128 1 0
    //   168: getstatic 130	wiq:bcw	Z
    //   171: ifeq +47 -> 218
    //   174: getstatic 104	wiq:a	Lwip;
    //   177: ifnonnull +13 -> 190
    //   180: new 96	wip
    //   183: dup
    //   184: invokespecial 131	wip:<init>	()V
    //   187: putstatic 104	wiq:a	Lwip;
    //   190: getstatic 104	wiq:a	Lwip;
    //   193: iconst_1
    //   194: putfield 134	wip:bNu	I
    //   197: getstatic 104	wiq:a	Lwip;
    //   200: iconst_1
    //   201: putfield 137	wip:bNy	I
    //   204: getstatic 104	wiq:a	Lwip;
    //   207: iconst_1
    //   208: putfield 140	wip:bNx	I
    //   211: getstatic 104	wiq:a	Lwip;
    //   214: iconst_1
    //   215: putfield 143	wip:bNz	I
    //   218: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +130 -> 351
    //   224: new 45	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   231: astore_2
    //   232: aload_2
    //   233: ldc 145
    //   235: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_2
    //   240: new 45	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   247: ldc 147
    //   249: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: getstatic 76	wiq:bcx	Z
    //   255: invokevirtual 150	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   258: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_2
    //   266: new 45	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   273: ldc 152
    //   275: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: getstatic 80	wiq:bNA	I
    //   281: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_2
    //   292: new 45	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   299: ldc 157
    //   301: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: getstatic 159	com/tencent/common/app/BaseApplicationImpl:httpMonitorBan	Z
    //   307: invokevirtual 150	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   310: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_2
    //   318: new 45	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   325: ldc 161
    //   327: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: ldc 25
    //   343: iconst_2
    //   344: aload_2
    //   345: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 31	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: ldc 2
    //   353: monitorexit
    //   354: return
    //   355: iconst_0
    //   356: istore_1
    //   357: goto -274 -> 83
    //   360: astore_0
    //   361: aload_0
    //   362: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   365: goto -14 -> 351
    //   368: astore_0
    //   369: ldc 2
    //   371: monitorexit
    //   372: aload_0
    //   373: athrow
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 165	java/lang/Error:printStackTrace	()V
    //   379: goto -28 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   1	356	1	bool	boolean
    //   231	114	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	19	360	java/lang/Exception
    //   19	70	360	java/lang/Exception
    //   70	83	360	java/lang/Exception
    //   83	130	360	java/lang/Exception
    //   130	168	360	java/lang/Exception
    //   168	190	360	java/lang/Exception
    //   190	218	360	java/lang/Exception
    //   218	351	360	java/lang/Exception
    //   5	19	368	finally
    //   19	70	368	finally
    //   70	83	368	finally
    //   83	130	368	finally
    //   130	168	368	finally
    //   168	190	368	finally
    //   190	218	368	finally
    //   218	351	368	finally
    //   361	365	368	finally
    //   375	379	368	finally
    //   5	19	374	java/lang/Error
    //   19	70	374	java/lang/Error
    //   70	83	374	java/lang/Error
    //   83	130	374	java/lang/Error
    //   130	168	374	java/lang/Error
    //   168	190	374	java/lang/Error
    //   190	218	374	java/lang/Error
    //   218	351	374	java/lang/Error
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     wiq
 * JD-Core Version:    0.7.0.1
 */