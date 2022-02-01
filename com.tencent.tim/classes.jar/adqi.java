import com.tencent.mobileqq.ark.ArkAppCGI.9;
import java.io.File;

public class adqi
  extends aquy
{
  public adqi(ArkAppCGI.9 param9, File paramFile) {}
  
  /* Error */
  public void onDone(aquz paramaquz)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 26	aquy:onDone	(Laquz;)V
    //   5: aload_1
    //   6: getfield 32	aquz:errCode	I
    //   9: ifne +79 -> 88
    //   12: aload_0
    //   13: getfield 14	adqi:val$file	Ljava/io/File;
    //   16: invokevirtual 38	java/io/File:length	()J
    //   19: l2i
    //   20: istore_2
    //   21: iload_2
    //   22: ifne +123 -> 145
    //   25: new 22	java/lang/Exception
    //   28: dup
    //   29: ldc 40
    //   31: invokespecial 43	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: astore 5
    //   37: aconst_null
    //   38: astore 4
    //   40: aload 4
    //   42: astore_3
    //   43: ldc 45
    //   45: ldc 47
    //   47: iconst_2
    //   48: anewarray 49	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_0
    //   54: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   57: getfield 54	com/tencent/mobileqq/ark/ArkAppCGI$9:a	Ladqb$e;
    //   60: getfield 60	adqb$e:url	Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload 5
    //   68: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   71: aastore
    //   72: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   75: invokestatic 76	com/tencent/mobileqq/ark/ArkAppCenter:r	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 4
    //   80: ifnull +8 -> 88
    //   83: aload 4
    //   85: invokevirtual 81	java/io/FileInputStream:close	()V
    //   88: ldc 45
    //   90: ldc 83
    //   92: iconst_2
    //   93: anewarray 49	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_0
    //   99: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   102: getfield 54	com/tencent/mobileqq/ark/ArkAppCGI$9:a	Ladqb$e;
    //   105: getfield 60	adqb$e:url	Ljava/lang/String;
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload_1
    //   112: getfield 32	aquz:errCode	I
    //   115: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   122: invokestatic 76	com/tencent/mobileqq/ark/ArkAppCenter:r	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   129: getfield 93	com/tencent/mobileqq/ark/ArkAppCGI$9:this$0	Ladqb;
    //   132: aload_0
    //   133: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   136: getfield 54	com/tencent/mobileqq/ark/ArkAppCGI$9:a	Ladqb$e;
    //   139: iconst_0
    //   140: aconst_null
    //   141: invokestatic 98	adqb:a	(Ladqb;Ladqb$e;Z[B)V
    //   144: return
    //   145: new 78	java/io/FileInputStream
    //   148: dup
    //   149: aload_0
    //   150: getfield 14	adqi:val$file	Ljava/io/File;
    //   153: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   156: astore 4
    //   158: aload 4
    //   160: astore_3
    //   161: iload_2
    //   162: newarray byte
    //   164: astore 5
    //   166: aload 4
    //   168: astore_3
    //   169: aload 4
    //   171: aload 5
    //   173: invokevirtual 105	java/io/FileInputStream:read	([B)I
    //   176: pop
    //   177: aload 4
    //   179: astore_3
    //   180: aload 4
    //   182: invokevirtual 81	java/io/FileInputStream:close	()V
    //   185: aload 4
    //   187: astore_3
    //   188: aload_0
    //   189: getfield 14	adqi:val$file	Ljava/io/File;
    //   192: invokevirtual 109	java/io/File:delete	()Z
    //   195: pop
    //   196: aload 4
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   203: getfield 93	com/tencent/mobileqq/ark/ArkAppCGI$9:this$0	Ladqb;
    //   206: aload_0
    //   207: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   210: getfield 54	com/tencent/mobileqq/ark/ArkAppCGI$9:a	Ladqb$e;
    //   213: iconst_1
    //   214: aload 5
    //   216: invokestatic 98	adqb:a	(Ladqb;Ladqb$e;Z[B)V
    //   219: aload 4
    //   221: ifnull -77 -> 144
    //   224: aload 4
    //   226: invokevirtual 81	java/io/FileInputStream:close	()V
    //   229: return
    //   230: astore_1
    //   231: ldc 45
    //   233: ldc 111
    //   235: iconst_2
    //   236: anewarray 49	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_0
    //   242: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   245: getfield 54	com/tencent/mobileqq/ark/ArkAppCGI$9:a	Ladqb$e;
    //   248: getfield 60	adqb$e:url	Ljava/lang/String;
    //   251: aastore
    //   252: dup
    //   253: iconst_1
    //   254: aload_1
    //   255: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   262: invokestatic 76	com/tencent/mobileqq/ark/ArkAppCenter:r	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: return
    //   266: astore_3
    //   267: ldc 45
    //   269: ldc 111
    //   271: iconst_2
    //   272: anewarray 49	java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: aload_0
    //   278: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   281: getfield 54	com/tencent/mobileqq/ark/ArkAppCGI$9:a	Ladqb$e;
    //   284: getfield 60	adqb$e:url	Ljava/lang/String;
    //   287: aastore
    //   288: dup
    //   289: iconst_1
    //   290: aload_3
    //   291: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: aastore
    //   295: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   298: invokestatic 76	com/tencent/mobileqq/ark/ArkAppCenter:r	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: goto -213 -> 88
    //   304: astore 5
    //   306: aconst_null
    //   307: astore 4
    //   309: aload 4
    //   311: astore_3
    //   312: ldc 45
    //   314: ldc 113
    //   316: iconst_2
    //   317: anewarray 49	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload_0
    //   323: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   326: getfield 54	com/tencent/mobileqq/ark/ArkAppCGI$9:a	Ladqb$e;
    //   329: getfield 60	adqb$e:url	Ljava/lang/String;
    //   332: aastore
    //   333: dup
    //   334: iconst_1
    //   335: aload 5
    //   337: invokevirtual 114	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   340: aastore
    //   341: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   344: invokestatic 76	com/tencent/mobileqq/ark/ArkAppCenter:r	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload 4
    //   349: ifnull -261 -> 88
    //   352: aload 4
    //   354: invokevirtual 81	java/io/FileInputStream:close	()V
    //   357: goto -269 -> 88
    //   360: astore_3
    //   361: ldc 45
    //   363: ldc 111
    //   365: iconst_2
    //   366: anewarray 49	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload_0
    //   372: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   375: getfield 54	com/tencent/mobileqq/ark/ArkAppCGI$9:a	Ladqb$e;
    //   378: getfield 60	adqb$e:url	Ljava/lang/String;
    //   381: aastore
    //   382: dup
    //   383: iconst_1
    //   384: aload_3
    //   385: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   388: aastore
    //   389: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   392: invokestatic 76	com/tencent/mobileqq/ark/ArkAppCenter:r	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: goto -307 -> 88
    //   398: astore_1
    //   399: aconst_null
    //   400: astore_3
    //   401: aload_3
    //   402: ifnull +7 -> 409
    //   405: aload_3
    //   406: invokevirtual 81	java/io/FileInputStream:close	()V
    //   409: aload_1
    //   410: athrow
    //   411: astore_3
    //   412: ldc 45
    //   414: ldc 111
    //   416: iconst_2
    //   417: anewarray 49	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload_0
    //   423: getfield 12	adqi:a	Lcom/tencent/mobileqq/ark/ArkAppCGI$9;
    //   426: getfield 54	com/tencent/mobileqq/ark/ArkAppCGI$9:a	Ladqb$e;
    //   429: getfield 60	adqb$e:url	Ljava/lang/String;
    //   432: aastore
    //   433: dup
    //   434: iconst_1
    //   435: aload_3
    //   436: invokevirtual 64	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   439: aastore
    //   440: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   443: invokestatic 76	com/tencent/mobileqq/ark/ArkAppCenter:r	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: goto -37 -> 409
    //   449: astore_1
    //   450: goto -49 -> 401
    //   453: astore 5
    //   455: goto -146 -> 309
    //   458: astore 5
    //   460: goto -420 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	adqi
    //   0	463	1	paramaquz	aquz
    //   20	142	2	i	int
    //   42	157	3	localFileInputStream1	java.io.FileInputStream
    //   266	25	3	localException1	java.lang.Exception
    //   311	1	3	localFileInputStream2	java.io.FileInputStream
    //   360	25	3	localException2	java.lang.Exception
    //   400	6	3	localObject	java.lang.Object
    //   411	25	3	localException3	java.lang.Exception
    //   38	315	4	localFileInputStream3	java.io.FileInputStream
    //   35	32	5	localException4	java.lang.Exception
    //   164	51	5	arrayOfByte	byte[]
    //   304	32	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   453	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   458	1	5	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	21	35	java/lang/Exception
    //   25	35	35	java/lang/Exception
    //   145	158	35	java/lang/Exception
    //   224	229	230	java/lang/Exception
    //   83	88	266	java/lang/Exception
    //   12	21	304	java/lang/OutOfMemoryError
    //   25	35	304	java/lang/OutOfMemoryError
    //   145	158	304	java/lang/OutOfMemoryError
    //   352	357	360	java/lang/Exception
    //   12	21	398	finally
    //   25	35	398	finally
    //   145	158	398	finally
    //   405	409	411	java/lang/Exception
    //   43	78	449	finally
    //   161	166	449	finally
    //   169	177	449	finally
    //   180	185	449	finally
    //   188	196	449	finally
    //   199	219	449	finally
    //   312	347	449	finally
    //   161	166	453	java/lang/OutOfMemoryError
    //   169	177	453	java/lang/OutOfMemoryError
    //   180	185	453	java/lang/OutOfMemoryError
    //   188	196	453	java/lang/OutOfMemoryError
    //   199	219	453	java/lang/OutOfMemoryError
    //   161	166	458	java/lang/Exception
    //   169	177	458	java/lang/Exception
    //   180	185	458	java/lang/Exception
    //   188	196	458	java/lang/Exception
    //   199	219	458	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqi
 * JD-Core Version:    0.7.0.1
 */