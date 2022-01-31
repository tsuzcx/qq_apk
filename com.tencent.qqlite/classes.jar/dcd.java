import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import java.io.File;

public class dcd
  implements Runnable
{
  public dcd(ConfigServlet paramConfigServlet, File paramFile, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   9: invokevirtual 33	java/io/File:getName	()Ljava/lang/String;
    //   12: ldc 35
    //   14: invokevirtual 41	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   17: astore 11
    //   19: aload 11
    //   21: ifnull +421 -> 442
    //   24: aload 11
    //   26: arraylength
    //   27: iconst_3
    //   28: if_icmpne +414 -> 442
    //   31: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +11 -> 45
    //   37: ldc 49
    //   39: iconst_2
    //   40: ldc 51
    //   42: invokestatic 55	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload 11
    //   47: iconst_0
    //   48: aaload
    //   49: astore 9
    //   51: lload 5
    //   53: lstore_3
    //   54: aload 9
    //   56: ifnull +50 -> 106
    //   59: lload 5
    //   61: lstore_3
    //   62: aload 9
    //   64: invokevirtual 58	java/lang/String:trim	()Ljava/lang/String;
    //   67: ldc 60
    //   69: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifne +34 -> 106
    //   75: aload 9
    //   77: ldc 66
    //   79: invokevirtual 70	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   82: istore_1
    //   83: aload 9
    //   85: iconst_0
    //   86: iload_1
    //   87: invokevirtual 74	java/lang/String:substring	(II)Ljava/lang/String;
    //   90: invokestatic 80	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   93: pop2
    //   94: aload 9
    //   96: iload_1
    //   97: iconst_1
    //   98: iadd
    //   99: invokevirtual 83	java/lang/String:substring	(I)Ljava/lang/String;
    //   102: invokestatic 80	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   105: lstore_3
    //   106: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   109: lload_3
    //   110: lcmp
    //   111: ifge +506 -> 617
    //   114: aconst_null
    //   115: astore 9
    //   117: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +11 -> 131
    //   123: ldc 49
    //   125: iconst_2
    //   126: ldc 91
    //   128: invokestatic 55	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: new 93	java/io/FileInputStream
    //   134: dup
    //   135: aload_0
    //   136: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   139: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   142: astore 10
    //   144: aload 10
    //   146: invokevirtual 100	java/io/FileInputStream:available	()I
    //   149: newarray byte
    //   151: astore 9
    //   153: aload 10
    //   155: aload 9
    //   157: invokevirtual 104	java/io/FileInputStream:read	([B)I
    //   160: pop
    //   161: new 37	java/lang/String
    //   164: dup
    //   165: aload 9
    //   167: ldc 106
    //   169: invokespecial 109	java/lang/String:<init>	([BLjava/lang/String;)V
    //   172: astore 12
    //   174: aload 12
    //   176: ifnull +261 -> 437
    //   179: aload 12
    //   181: invokevirtual 112	java/lang/String:length	()I
    //   184: iconst_5
    //   185: if_icmple +252 -> 437
    //   188: new 29	java/io/File
    //   191: dup
    //   192: new 114	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   199: aload_0
    //   200: getfield 18	dcd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   203: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 11
    //   208: iconst_1
    //   209: aaload
    //   210: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   219: astore 9
    //   221: aload 9
    //   223: ifnull +17 -> 240
    //   226: aload 9
    //   228: invokevirtual 128	java/io/File:exists	()Z
    //   231: ifeq +9 -> 240
    //   234: aload 9
    //   236: invokevirtual 131	java/io/File:delete	()Z
    //   239: pop
    //   240: aload_0
    //   241: getfield 14	dcd:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   244: invokevirtual 137	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   247: checkcast 139	com/tencent/common/app/AppInterface
    //   250: aload 12
    //   252: aload 9
    //   254: invokestatic 144	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   257: istore 7
    //   259: iload_2
    //   260: istore_1
    //   261: iload 7
    //   263: ifeq +107 -> 370
    //   266: aload 9
    //   268: invokevirtual 128	java/io/File:exists	()Z
    //   271: istore 8
    //   273: iload_2
    //   274: istore_1
    //   275: iload 8
    //   277: ifeq +93 -> 370
    //   280: aload 9
    //   282: invokestatic 150	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   285: aload 11
    //   287: iconst_1
    //   288: aaload
    //   289: invokevirtual 154	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   292: ifeq +396 -> 688
    //   295: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +11 -> 309
    //   301: ldc 49
    //   303: iconst_2
    //   304: ldc 156
    //   306: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: new 29	java/io/File
    //   312: dup
    //   313: new 114	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   320: aload_0
    //   321: getfield 18	dcd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   324: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 11
    //   329: iconst_0
    //   330: aaload
    //   331: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc 161
    //   336: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 11
    //   341: iconst_1
    //   342: aaload
    //   343: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc 161
    //   348: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 11
    //   353: iconst_2
    //   354: aaload
    //   355: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   364: invokevirtual 164	java/io/File:createNewFile	()Z
    //   367: pop
    //   368: iconst_1
    //   369: istore_1
    //   370: iload 7
    //   372: ifeq +7 -> 379
    //   375: iload_1
    //   376: ifne +61 -> 437
    //   379: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +11 -> 393
    //   385: ldc 49
    //   387: iconst_2
    //   388: ldc 166
    //   390: invokestatic 55	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: aload 9
    //   395: ifnull +17 -> 412
    //   398: aload 9
    //   400: invokevirtual 128	java/io/File:exists	()Z
    //   403: ifeq +9 -> 412
    //   406: aload 9
    //   408: invokevirtual 131	java/io/File:delete	()Z
    //   411: pop
    //   412: aload_0
    //   413: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   416: ifnull +21 -> 437
    //   419: aload_0
    //   420: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   423: invokevirtual 128	java/io/File:exists	()Z
    //   426: ifeq +11 -> 437
    //   429: aload_0
    //   430: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   433: invokevirtual 131	java/io/File:delete	()Z
    //   436: pop
    //   437: aload 10
    //   439: invokevirtual 169	java/io/FileInputStream:close	()V
    //   442: return
    //   443: astore 11
    //   445: aload 11
    //   447: invokevirtual 172	java/io/FileNotFoundException:printStackTrace	()V
    //   450: iload_2
    //   451: istore_1
    //   452: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq -85 -> 370
    //   458: ldc 49
    //   460: iconst_2
    //   461: ldc 174
    //   463: aload 11
    //   465: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   468: iload_2
    //   469: istore_1
    //   470: goto -100 -> 370
    //   473: astore 11
    //   475: aload 10
    //   477: astore 9
    //   479: aload 11
    //   481: astore 10
    //   483: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +13 -> 499
    //   489: ldc 49
    //   491: iconst_2
    //   492: ldc 179
    //   494: aload 10
    //   496: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   499: aload_0
    //   500: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   503: ifnull +21 -> 524
    //   506: aload_0
    //   507: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   510: invokevirtual 128	java/io/File:exists	()Z
    //   513: ifeq +11 -> 524
    //   516: aload_0
    //   517: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   520: invokevirtual 131	java/io/File:delete	()Z
    //   523: pop
    //   524: aload 9
    //   526: invokevirtual 169	java/io/FileInputStream:close	()V
    //   529: return
    //   530: astore 9
    //   532: aload 9
    //   534: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   537: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq -98 -> 442
    //   543: ldc 49
    //   545: iconst_2
    //   546: ldc 182
    //   548: aload 9
    //   550: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   553: return
    //   554: astore 9
    //   556: aload 9
    //   558: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   561: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq -122 -> 442
    //   567: ldc 49
    //   569: iconst_2
    //   570: ldc 182
    //   572: aload 9
    //   574: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   577: return
    //   578: astore 9
    //   580: aconst_null
    //   581: astore 10
    //   583: aload 10
    //   585: invokevirtual 169	java/io/FileInputStream:close	()V
    //   588: aload 9
    //   590: athrow
    //   591: astore 10
    //   593: aload 10
    //   595: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   598: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq -13 -> 588
    //   604: ldc 49
    //   606: iconst_2
    //   607: ldc 182
    //   609: aload 10
    //   611: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   614: goto -26 -> 588
    //   617: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   620: ifeq +11 -> 631
    //   623: ldc 49
    //   625: iconst_2
    //   626: ldc 184
    //   628: invokestatic 55	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: aload_0
    //   632: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   635: ifnull -193 -> 442
    //   638: aload_0
    //   639: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   642: invokevirtual 128	java/io/File:exists	()Z
    //   645: ifeq -203 -> 442
    //   648: aload_0
    //   649: getfield 16	dcd:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   652: invokevirtual 131	java/io/File:delete	()Z
    //   655: pop
    //   656: return
    //   657: astore 9
    //   659: goto -76 -> 583
    //   662: astore 11
    //   664: aload 9
    //   666: astore 10
    //   668: aload 11
    //   670: astore 9
    //   672: goto -89 -> 583
    //   675: astore 10
    //   677: goto -194 -> 483
    //   680: astore 9
    //   682: lload 5
    //   684: lstore_3
    //   685: goto -579 -> 106
    //   688: iconst_0
    //   689: istore_1
    //   690: goto -320 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	693	0	this	dcd
    //   82	608	1	i	int
    //   4	465	2	j	int
    //   53	632	3	l1	long
    //   1	682	5	l2	long
    //   257	114	7	bool1	boolean
    //   271	5	8	bool2	boolean
    //   49	476	9	localObject1	Object
    //   530	19	9	localException1	java.lang.Exception
    //   554	19	9	localException2	java.lang.Exception
    //   578	11	9	localObject2	Object
    //   657	8	9	localObject3	Object
    //   670	1	9	localObject4	Object
    //   680	1	9	localException3	java.lang.Exception
    //   142	442	10	localObject5	Object
    //   591	19	10	localException4	java.lang.Exception
    //   666	1	10	localObject6	Object
    //   675	1	10	localException5	java.lang.Exception
    //   17	335	11	arrayOfString	String[]
    //   443	21	11	localFileNotFoundException	java.io.FileNotFoundException
    //   473	7	11	localException6	java.lang.Exception
    //   662	7	11	localObject7	Object
    //   172	79	12	str	String
    // Exception table:
    //   from	to	target	type
    //   280	309	443	java/io/FileNotFoundException
    //   309	368	443	java/io/FileNotFoundException
    //   144	174	473	java/lang/Exception
    //   179	221	473	java/lang/Exception
    //   226	240	473	java/lang/Exception
    //   240	259	473	java/lang/Exception
    //   266	273	473	java/lang/Exception
    //   280	309	473	java/lang/Exception
    //   309	368	473	java/lang/Exception
    //   379	393	473	java/lang/Exception
    //   398	412	473	java/lang/Exception
    //   412	437	473	java/lang/Exception
    //   445	450	473	java/lang/Exception
    //   452	468	473	java/lang/Exception
    //   524	529	530	java/lang/Exception
    //   437	442	554	java/lang/Exception
    //   117	131	578	finally
    //   131	144	578	finally
    //   583	588	591	java/lang/Exception
    //   144	174	657	finally
    //   179	221	657	finally
    //   226	240	657	finally
    //   240	259	657	finally
    //   266	273	657	finally
    //   280	309	657	finally
    //   309	368	657	finally
    //   379	393	657	finally
    //   398	412	657	finally
    //   412	437	657	finally
    //   445	450	657	finally
    //   452	468	657	finally
    //   483	499	662	finally
    //   499	524	662	finally
    //   117	131	675	java/lang/Exception
    //   131	144	675	java/lang/Exception
    //   75	106	680	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dcd
 * JD-Core Version:    0.7.0.1
 */