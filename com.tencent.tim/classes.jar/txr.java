import com.tencent.common.app.BaseApplicationImpl;

public class txr
{
  public static boolean aQC;
  
  /* Error */
  public static void bES()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 12	txr:aQC	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 18	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   18: iconst_1
    //   19: if_icmpne +9 -> 28
    //   22: getstatic 24	txe:d	[Ljava/lang/Class;
    //   25: invokestatic 30	com/tencent/qapmsdk/QAPM:setAbTypes	([Ljava/lang/Class;)V
    //   28: iconst_1
    //   29: putstatic 12	txr:aQC	Z
    //   32: getstatic 33	com/tencent/qapmsdk/QAPM:LevelInfo	I
    //   35: istore_0
    //   36: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +246 -> 285
    //   42: getstatic 42	com/tencent/qapmsdk/QAPM:LevelDebug	I
    //   45: istore_0
    //   46: iconst_2
    //   47: getstatic 18	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   50: if_icmpeq +238 -> 288
    //   53: bipush 8
    //   55: getstatic 18	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   58: if_icmpne +221 -> 279
    //   61: goto +227 -> 288
    //   64: invokestatic 48	com/tencent/mfsdk/MagnifierSDK:oB	()Ljava/lang/String;
    //   67: astore 4
    //   69: invokestatic 52	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   72: invokevirtual 56	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   75: invokestatic 52	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   78: invokevirtual 59	com/tencent/common/app/BaseApplicationImpl:getPackageName	()Ljava/lang/String;
    //   81: sipush 128
    //   84: invokevirtual 65	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   87: getfield 71	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   90: ldc 73
    //   92: invokevirtual 79	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   95: invokevirtual 82	java/lang/Object:toString	()Ljava/lang/String;
    //   98: astore_3
    //   99: sipush 201
    //   102: getstatic 86	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   105: invokestatic 90	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   108: pop
    //   109: bipush 101
    //   111: aload_2
    //   112: invokestatic 93	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   115: pop
    //   116: bipush 103
    //   118: aload 4
    //   120: invokestatic 93	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   123: pop
    //   124: bipush 104
    //   126: aload_3
    //   127: invokestatic 93	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   130: pop
    //   131: bipush 105
    //   133: iload_0
    //   134: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: invokestatic 90	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   140: pop
    //   141: bipush 106
    //   143: ldc 101
    //   145: invokestatic 93	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   148: pop
    //   149: bipush 111
    //   151: ldc 103
    //   153: invokestatic 93	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/String;)Lcom/tencent/qapmsdk/QAPM;
    //   156: pop
    //   157: sipush 301
    //   160: iconst_0
    //   161: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   164: invokestatic 90	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   167: pop
    //   168: sipush 303
    //   171: iconst_0
    //   172: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   175: invokestatic 90	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   178: pop
    //   179: sipush 302
    //   182: iconst_0
    //   183: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   186: invokestatic 90	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   189: pop
    //   190: sipush 305
    //   193: new 110	tyr
    //   196: dup
    //   197: invokespecial 113	tyr:<init>	()V
    //   200: invokestatic 90	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   203: pop
    //   204: sipush 304
    //   207: iconst_1
    //   208: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   211: invokestatic 90	com/tencent/qapmsdk/QAPM:setProperty	(ILjava/lang/Object;)Lcom/tencent/qapmsdk/QAPM;
    //   214: pop
    //   215: getstatic 119	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   218: new 121	txs
    //   221: dup
    //   222: iload_0
    //   223: invokespecial 124	txs:<init>	(I)V
    //   226: invokevirtual 128	com/tencent/qapmsdk/common/logger/Logger:setLogProxy	(Lcom/tencent/qapmsdk/common/logger/ILogProxy;)V
    //   229: ldc 130
    //   231: iconst_1
    //   232: new 132	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   239: ldc 135
    //   241: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload_0
    //   245: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: goto -243 -> 11
    //   257: astore_2
    //   258: ldc 2
    //   260: monitorexit
    //   261: aload_2
    //   262: athrow
    //   263: astore_3
    //   264: ldc 130
    //   266: iconst_1
    //   267: ldc 149
    //   269: aload_3
    //   270: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: ldc 155
    //   275: astore_3
    //   276: goto -177 -> 99
    //   279: ldc 157
    //   281: astore_2
    //   282: goto -218 -> 64
    //   285: goto -239 -> 46
    //   288: ldc 159
    //   290: astore_2
    //   291: goto -227 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	210	0	i	int
    //   6	2	1	bool	boolean
    //   111	1	2	str1	java.lang.String
    //   257	5	2	localObject	Object
    //   281	10	2	str2	java.lang.String
    //   98	29	3	str3	java.lang.String
    //   263	7	3	localThrowable	java.lang.Throwable
    //   275	1	3	str4	java.lang.String
    //   67	52	4	str5	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   3	7	257	finally
    //   15	28	257	finally
    //   28	46	257	finally
    //   46	61	257	finally
    //   64	69	257	finally
    //   69	99	257	finally
    //   99	254	257	finally
    //   264	273	257	finally
    //   69	99	263	java/lang/Throwable
  }
  
  public static int vh()
  {
    int i = 0;
    if (BaseApplicationImpl.sProcessId == 2) {
      i = 14;
    }
    while (BaseApplicationImpl.sProcessId != 7) {
      return i;
    }
    return 19;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     txr
 * JD-Core Version:    0.7.0.1
 */