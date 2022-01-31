package com.tencent.securemodule;

import android.content.Context;
import android.net.Proxy;
import android.os.Environment;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.methods.HttpGet;

public final class z
  extends y
{
  public String f = null;
  public String g = null;
  public int h = 0;
  private Context i;
  private HttpGet j = null;
  private String k = null;
  private String l = null;
  private boolean m = false;
  private long n = 0L;
  
  public z(Context paramContext)
  {
    this.i = paramContext;
    this.m = "mounted".equals(Environment.getExternalStorageState());
    if (this.m) {
      this.k = "/sdcard/qqsecure";
    }
    for (this.f = "/sdcard/qqsecure";; this.f = paramContext.getFilesDir().getAbsolutePath())
    {
      this.j = new HttpGet();
      if (aa.a(paramContext) == aa.a.b)
      {
        paramContext = Proxy.getDefaultHost();
        int i1 = Proxy.getDefaultPort();
        this.c = paramContext;
        this.d = i1;
        this.b = true;
      }
      return;
      this.k = paramContext.getCacheDir().getAbsolutePath();
    }
  }
  
  /* Error */
  private int a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 11
    //   5: aconst_null
    //   6: astore 12
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 10
    //   17: sipush -7000
    //   20: istore_2
    //   21: new 98	java/io/File
    //   24: dup
    //   25: new 113	java/lang/StringBuilder
    //   28: dup
    //   29: aload_0
    //   30: getfield 28	com/tencent/securemodule/z:k	Ljava/lang/String;
    //   33: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: getstatic 123	java/io/File:separator	Ljava/lang/String;
    //   42: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 32	com/tencent/securemodule/z:l	Ljava/lang/String;
    //   49: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 5
    //   60: aload 5
    //   62: invokevirtual 135	java/io/File:exists	()Z
    //   65: ifeq +366 -> 431
    //   68: aload_0
    //   69: getfield 38	com/tencent/securemodule/z:m	Z
    //   72: ifne +112 -> 184
    //   75: aload_0
    //   76: getfield 36	com/tencent/securemodule/z:h	I
    //   79: iconst_1
    //   80: if_icmpne +104 -> 184
    //   83: aload_0
    //   84: getfield 42	com/tencent/securemodule/z:i	Landroid/content/Context;
    //   87: aload_0
    //   88: getfield 34	com/tencent/securemodule/z:g	Ljava/lang/String;
    //   91: iconst_1
    //   92: invokevirtual 139	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   95: astore 4
    //   97: aload 5
    //   99: astore 8
    //   101: aload 6
    //   103: astore 9
    //   105: aload 4
    //   107: astore 7
    //   109: new 141	java/io/FileInputStream
    //   112: dup
    //   113: aload 5
    //   115: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: astore 6
    //   120: sipush 1024
    //   123: newarray byte
    //   125: astore 7
    //   127: aload 6
    //   129: aload 7
    //   131: invokevirtual 148	java/io/FileInputStream:read	([B)I
    //   134: istore_1
    //   135: iload_1
    //   136: iconst_m1
    //   137: if_icmpne +269 -> 406
    //   140: iload_3
    //   141: istore_1
    //   142: aload 6
    //   144: ifnull +10 -> 154
    //   147: aload 6
    //   149: invokevirtual 151	java/io/FileInputStream:close	()V
    //   152: iload_3
    //   153: istore_1
    //   154: aload 4
    //   156: ifnull +654 -> 810
    //   159: aload 4
    //   161: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   164: iload_1
    //   165: istore_2
    //   166: aload 5
    //   168: invokevirtual 135	java/io/File:exists	()Z
    //   171: ifeq +11 -> 182
    //   174: aload 5
    //   176: invokevirtual 157	java/io/File:delete	()Z
    //   179: pop
    //   180: iload_1
    //   181: istore_2
    //   182: iload_2
    //   183: ireturn
    //   184: new 98	java/io/File
    //   187: dup
    //   188: new 113	java/lang/StringBuilder
    //   191: dup
    //   192: aload_0
    //   193: getfield 30	com/tencent/securemodule/z:f	Ljava/lang/String;
    //   196: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: getstatic 123	java/io/File:separator	Ljava/lang/String;
    //   205: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: getfield 34	com/tencent/securemodule/z:g	Ljava/lang/String;
    //   212: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   221: astore 4
    //   223: aload 4
    //   225: invokevirtual 135	java/io/File:exists	()Z
    //   228: ifeq +81 -> 309
    //   231: aload 4
    //   233: invokevirtual 157	java/io/File:delete	()Z
    //   236: pop
    //   237: new 153	java/io/FileOutputStream
    //   240: dup
    //   241: aload 4
    //   243: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   246: astore 4
    //   248: goto -151 -> 97
    //   251: astore 6
    //   253: aconst_null
    //   254: astore 4
    //   256: aload 10
    //   258: astore 9
    //   260: aload 6
    //   262: invokevirtual 161	java/io/FileNotFoundException:printStackTrace	()V
    //   265: aload 9
    //   267: ifnull +558 -> 825
    //   270: aload 9
    //   272: invokevirtual 151	java/io/FileInputStream:close	()V
    //   275: sipush -7001
    //   278: istore_1
    //   279: iload_1
    //   280: istore_2
    //   281: aload 4
    //   283: ifnull +10 -> 293
    //   286: aload 4
    //   288: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   291: iload_1
    //   292: istore_2
    //   293: aload 5
    //   295: invokevirtual 135	java/io/File:exists	()Z
    //   298: ifeq +525 -> 823
    //   301: aload 5
    //   303: invokevirtual 157	java/io/File:delete	()Z
    //   306: pop
    //   307: iload_2
    //   308: ireturn
    //   309: aload 4
    //   311: invokevirtual 164	java/io/File:getParentFile	()Ljava/io/File;
    //   314: invokevirtual 167	java/io/File:mkdirs	()Z
    //   317: pop
    //   318: aload 4
    //   320: invokevirtual 170	java/io/File:createNewFile	()Z
    //   323: pop
    //   324: new 153	java/io/FileOutputStream
    //   327: dup
    //   328: aload 4
    //   330: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   333: astore 4
    //   335: goto -238 -> 97
    //   338: astore 6
    //   340: aconst_null
    //   341: astore 4
    //   343: aload 11
    //   345: astore 10
    //   347: aload 5
    //   349: astore 8
    //   351: aload 10
    //   353: astore 9
    //   355: aload 4
    //   357: astore 7
    //   359: aload 6
    //   361: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   364: aload 10
    //   366: ifnull +450 -> 816
    //   369: aload 10
    //   371: invokevirtual 151	java/io/FileInputStream:close	()V
    //   374: sipush -7056
    //   377: istore_1
    //   378: aload 4
    //   380: ifnull +433 -> 813
    //   383: aload 4
    //   385: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   388: iload_1
    //   389: istore_2
    //   390: aload 5
    //   392: invokevirtual 135	java/io/File:exists	()Z
    //   395: ifeq -213 -> 182
    //   398: aload 5
    //   400: invokevirtual 157	java/io/File:delete	()Z
    //   403: pop
    //   404: iload_1
    //   405: ireturn
    //   406: aload 4
    //   408: aload 7
    //   410: iconst_0
    //   411: iload_1
    //   412: invokevirtual 175	java/io/FileOutputStream:write	([BII)V
    //   415: goto -288 -> 127
    //   418: astore 7
    //   420: aload 6
    //   422: astore 9
    //   424: aload 7
    //   426: astore 6
    //   428: goto -168 -> 260
    //   431: aconst_null
    //   432: astore 6
    //   434: aconst_null
    //   435: astore 4
    //   437: sipush -7001
    //   440: istore_3
    //   441: goto -301 -> 140
    //   444: astore 6
    //   446: aload 6
    //   448: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   451: sipush -7000
    //   454: istore_1
    //   455: goto -176 -> 279
    //   458: astore 4
    //   460: aload 4
    //   462: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   465: sipush -7000
    //   468: istore_2
    //   469: goto -176 -> 293
    //   472: astore 6
    //   474: aload 6
    //   476: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   479: sipush -7000
    //   482: istore_1
    //   483: goto -105 -> 378
    //   486: astore 4
    //   488: aload 4
    //   490: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   493: iload_2
    //   494: istore_1
    //   495: goto -107 -> 388
    //   498: astore 6
    //   500: aconst_null
    //   501: astore 5
    //   503: aconst_null
    //   504: astore 4
    //   506: aload 12
    //   508: astore 10
    //   510: aload 5
    //   512: astore 8
    //   514: aload 10
    //   516: astore 9
    //   518: aload 4
    //   520: astore 7
    //   522: aload 6
    //   524: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   527: aload 10
    //   529: ifnull +8 -> 537
    //   532: aload 10
    //   534: invokevirtual 151	java/io/FileInputStream:close	()V
    //   537: aload 4
    //   539: ifnull +8 -> 547
    //   542: aload 4
    //   544: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   547: aload 5
    //   549: invokevirtual 135	java/io/File:exists	()Z
    //   552: ifeq -370 -> 182
    //   555: aload 5
    //   557: invokevirtual 157	java/io/File:delete	()Z
    //   560: pop
    //   561: sipush -7000
    //   564: ireturn
    //   565: astore 6
    //   567: aload 6
    //   569: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   572: goto -35 -> 537
    //   575: astore 4
    //   577: aload 4
    //   579: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   582: goto -35 -> 547
    //   585: astore 6
    //   587: aconst_null
    //   588: astore 5
    //   590: aconst_null
    //   591: astore 4
    //   593: aload 9
    //   595: ifnull +8 -> 603
    //   598: aload 9
    //   600: invokevirtual 151	java/io/FileInputStream:close	()V
    //   603: aload 4
    //   605: ifnull +8 -> 613
    //   608: aload 4
    //   610: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   613: aload 5
    //   615: invokevirtual 135	java/io/File:exists	()Z
    //   618: ifeq +9 -> 627
    //   621: aload 5
    //   623: invokevirtual 157	java/io/File:delete	()Z
    //   626: pop
    //   627: aload 6
    //   629: athrow
    //   630: astore 7
    //   632: aload 7
    //   634: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   637: goto -34 -> 603
    //   640: astore 4
    //   642: aload 4
    //   644: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   647: goto -34 -> 613
    //   650: astore 6
    //   652: aload 6
    //   654: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   657: sipush -7000
    //   660: istore_1
    //   661: goto -507 -> 154
    //   664: astore 4
    //   666: aload 4
    //   668: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   671: iload_2
    //   672: istore_1
    //   673: goto -509 -> 164
    //   676: astore 6
    //   678: aconst_null
    //   679: astore 4
    //   681: goto -88 -> 593
    //   684: astore 6
    //   686: aload 8
    //   688: astore 5
    //   690: aload 7
    //   692: astore 4
    //   694: goto -101 -> 593
    //   697: astore 7
    //   699: aload 6
    //   701: astore 9
    //   703: aload 7
    //   705: astore 6
    //   707: goto -114 -> 593
    //   710: astore 6
    //   712: goto -119 -> 593
    //   715: astore 6
    //   717: aconst_null
    //   718: astore 4
    //   720: aload 12
    //   722: astore 10
    //   724: goto -214 -> 510
    //   727: astore 6
    //   729: aload 12
    //   731: astore 10
    //   733: goto -223 -> 510
    //   736: astore 7
    //   738: aload 6
    //   740: astore 10
    //   742: aload 7
    //   744: astore 6
    //   746: goto -236 -> 510
    //   749: astore 6
    //   751: aconst_null
    //   752: astore 5
    //   754: aconst_null
    //   755: astore 4
    //   757: aload 11
    //   759: astore 10
    //   761: goto -414 -> 347
    //   764: astore 6
    //   766: aload 11
    //   768: astore 10
    //   770: goto -423 -> 347
    //   773: astore 7
    //   775: aload 6
    //   777: astore 10
    //   779: aload 7
    //   781: astore 6
    //   783: goto -436 -> 347
    //   786: astore 6
    //   788: aconst_null
    //   789: astore 5
    //   791: aconst_null
    //   792: astore 4
    //   794: aload 10
    //   796: astore 9
    //   798: goto -538 -> 260
    //   801: astore 6
    //   803: aload 10
    //   805: astore 9
    //   807: goto -547 -> 260
    //   810: goto -646 -> 164
    //   813: goto -425 -> 388
    //   816: sipush -7056
    //   819: istore_1
    //   820: goto -442 -> 378
    //   823: iload_2
    //   824: ireturn
    //   825: sipush -7001
    //   828: istore_1
    //   829: goto -550 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	z
    //   134	695	1	i1	int
    //   20	804	2	i2	int
    //   1	440	3	i3	int
    //   95	341	4	localObject1	Object
    //   458	3	4	localIOException1	java.io.IOException
    //   486	3	4	localIOException2	java.io.IOException
    //   504	39	4	localObject2	Object
    //   575	3	4	localIOException3	java.io.IOException
    //   591	18	4	localObject3	Object
    //   640	3	4	localIOException4	java.io.IOException
    //   664	3	4	localIOException5	java.io.IOException
    //   679	114	4	localObject4	Object
    //   58	732	5	localObject5	Object
    //   12	136	6	localFileInputStream	java.io.FileInputStream
    //   251	10	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   338	83	6	localIOException6	java.io.IOException
    //   426	7	6	localObject6	Object
    //   444	3	6	localIOException7	java.io.IOException
    //   472	3	6	localIOException8	java.io.IOException
    //   498	25	6	localException1	java.lang.Exception
    //   565	3	6	localIOException9	java.io.IOException
    //   585	43	6	localObject7	Object
    //   650	3	6	localIOException10	java.io.IOException
    //   676	1	6	localObject8	Object
    //   684	16	6	localObject9	Object
    //   705	1	6	localObject10	Object
    //   710	1	6	localObject11	Object
    //   715	1	6	localException2	java.lang.Exception
    //   727	12	6	localException3	java.lang.Exception
    //   744	1	6	localObject12	Object
    //   749	1	6	localIOException11	java.io.IOException
    //   764	12	6	localIOException12	java.io.IOException
    //   781	1	6	localObject13	Object
    //   786	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   801	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   107	302	7	localObject14	Object
    //   418	7	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   520	1	7	localObject15	Object
    //   630	61	7	localIOException13	java.io.IOException
    //   697	7	7	localObject16	Object
    //   736	7	7	localException4	java.lang.Exception
    //   773	7	7	localIOException14	java.io.IOException
    //   99	588	8	localObject17	Object
    //   9	797	9	localObject18	Object
    //   15	789	10	localObject19	Object
    //   3	764	11	localObject20	Object
    //   6	724	12	localObject21	Object
    // Exception table:
    //   from	to	target	type
    //   60	97	251	java/io/FileNotFoundException
    //   184	248	251	java/io/FileNotFoundException
    //   309	335	251	java/io/FileNotFoundException
    //   60	97	338	java/io/IOException
    //   184	248	338	java/io/IOException
    //   309	335	338	java/io/IOException
    //   120	127	418	java/io/FileNotFoundException
    //   127	135	418	java/io/FileNotFoundException
    //   406	415	418	java/io/FileNotFoundException
    //   270	275	444	java/io/IOException
    //   286	291	458	java/io/IOException
    //   369	374	472	java/io/IOException
    //   383	388	486	java/io/IOException
    //   21	60	498	java/lang/Exception
    //   532	537	565	java/io/IOException
    //   542	547	575	java/io/IOException
    //   21	60	585	finally
    //   598	603	630	java/io/IOException
    //   608	613	640	java/io/IOException
    //   147	152	650	java/io/IOException
    //   159	164	664	java/io/IOException
    //   60	97	676	finally
    //   184	248	676	finally
    //   309	335	676	finally
    //   109	120	684	finally
    //   359	364	684	finally
    //   522	527	684	finally
    //   120	127	697	finally
    //   127	135	697	finally
    //   406	415	697	finally
    //   260	265	710	finally
    //   60	97	715	java/lang/Exception
    //   184	248	715	java/lang/Exception
    //   309	335	715	java/lang/Exception
    //   109	120	727	java/lang/Exception
    //   120	127	736	java/lang/Exception
    //   127	135	736	java/lang/Exception
    //   406	415	736	java/lang/Exception
    //   21	60	749	java/io/IOException
    //   109	120	764	java/io/IOException
    //   120	127	773	java/io/IOException
    //   127	135	773	java/io/IOException
    //   406	415	773	java/io/IOException
    //   21	60	786	java/io/FileNotFoundException
    //   109	120	801	java/io/FileNotFoundException
  }
  
  /* Error */
  private int a(org.apache.http.HttpEntity paramHttpEntity, android.os.Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 26
    //   3: aconst_null
    //   4: astore 27
    //   6: aconst_null
    //   7: astore 28
    //   9: aconst_null
    //   10: astore 29
    //   12: aconst_null
    //   13: astore 15
    //   15: aconst_null
    //   16: astore 16
    //   18: aconst_null
    //   19: astore 17
    //   21: aconst_null
    //   22: astore 21
    //   24: aconst_null
    //   25: astore 22
    //   27: aconst_null
    //   28: astore 23
    //   30: aconst_null
    //   31: astore 24
    //   33: aconst_null
    //   34: astore 32
    //   36: aconst_null
    //   37: astore 30
    //   39: aconst_null
    //   40: astore 25
    //   42: aconst_null
    //   43: astore 18
    //   45: aconst_null
    //   46: astore 19
    //   48: aconst_null
    //   49: astore 20
    //   51: aconst_null
    //   52: astore 31
    //   54: sipush 8192
    //   57: newarray byte
    //   59: astore 33
    //   61: aload 32
    //   63: astore 13
    //   65: aload 15
    //   67: astore 14
    //   69: aload_1
    //   70: invokeinterface 187 1 0
    //   75: lstore 9
    //   77: aload 32
    //   79: astore 13
    //   81: aload 15
    //   83: astore 14
    //   85: aload_0
    //   86: getfield 40	com/tencent/securemodule/z:n	J
    //   89: lload 9
    //   91: ladd
    //   92: lstore 9
    //   94: aload 32
    //   96: astore 13
    //   98: aload 15
    //   100: astore 14
    //   102: aload_0
    //   103: getfield 40	com/tencent/securemodule/z:n	J
    //   106: ldc2_w 188
    //   109: lmul
    //   110: lload 9
    //   112: ldiv
    //   113: l2i
    //   114: istore 4
    //   116: aload 32
    //   118: astore 13
    //   120: aload 15
    //   122: astore 14
    //   124: aload_2
    //   125: ldc 191
    //   127: lload 9
    //   129: invokevirtual 197	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   132: aload 32
    //   134: astore 13
    //   136: aload 15
    //   138: astore 14
    //   140: aload_2
    //   141: ldc 199
    //   143: aload_0
    //   144: getfield 40	com/tencent/securemodule/z:n	J
    //   147: invokevirtual 197	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   150: aload 32
    //   152: astore 13
    //   154: aload 15
    //   156: astore 14
    //   158: aload_2
    //   159: ldc 201
    //   161: iload 4
    //   163: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   166: aload 32
    //   168: astore 13
    //   170: aload 15
    //   172: astore 14
    //   174: new 98	java/io/File
    //   177: dup
    //   178: new 113	java/lang/StringBuilder
    //   181: dup
    //   182: aload_0
    //   183: getfield 28	com/tencent/securemodule/z:k	Ljava/lang/String;
    //   186: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   189: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: getstatic 123	java/io/File:separator	Ljava/lang/String;
    //   195: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: getfield 32	com/tencent/securemodule/z:l	Ljava/lang/String;
    //   202: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   211: astore 34
    //   213: aload 32
    //   215: astore 13
    //   217: aload 15
    //   219: astore 14
    //   221: aload 34
    //   223: invokevirtual 135	java/io/File:exists	()Z
    //   226: ifne +34 -> 260
    //   229: aload 32
    //   231: astore 13
    //   233: aload 15
    //   235: astore 14
    //   237: aload 34
    //   239: invokevirtual 164	java/io/File:getParentFile	()Ljava/io/File;
    //   242: invokevirtual 167	java/io/File:mkdirs	()Z
    //   245: pop
    //   246: aload 32
    //   248: astore 13
    //   250: aload 15
    //   252: astore 14
    //   254: aload 34
    //   256: invokevirtual 170	java/io/File:createNewFile	()Z
    //   259: pop
    //   260: aload 32
    //   262: astore 13
    //   264: aload 15
    //   266: astore 14
    //   268: new 153	java/io/FileOutputStream
    //   271: dup
    //   272: aload 34
    //   274: iconst_1
    //   275: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   278: astore 15
    //   280: aload 31
    //   282: astore 14
    //   284: aload 30
    //   286: astore 16
    //   288: aload 25
    //   290: astore 17
    //   292: aload_1
    //   293: invokeinterface 212 1 0
    //   298: astore 13
    //   300: iconst_0
    //   301: istore 5
    //   303: aload 13
    //   305: astore 14
    //   307: aload 13
    //   309: astore 16
    //   311: aload 13
    //   313: astore 17
    //   315: aload 13
    //   317: astore 18
    //   319: aload 13
    //   321: astore 19
    //   323: aload 13
    //   325: astore 20
    //   327: aload 13
    //   329: aload 33
    //   331: invokevirtual 215	java/io/InputStream:read	([B)I
    //   334: istore 8
    //   336: iload 8
    //   338: iconst_m1
    //   339: if_icmpne +110 -> 449
    //   342: aload 13
    //   344: astore 14
    //   346: aload 13
    //   348: astore 16
    //   350: aload 13
    //   352: astore 17
    //   354: aload 13
    //   356: astore 18
    //   358: aload 13
    //   360: astore 19
    //   362: aload 13
    //   364: astore 20
    //   366: aload 15
    //   368: invokevirtual 218	java/io/FileOutputStream:flush	()V
    //   371: iload 5
    //   373: i2l
    //   374: lstore 9
    //   376: aload 13
    //   378: astore 14
    //   380: aload 13
    //   382: astore 16
    //   384: aload 13
    //   386: astore 17
    //   388: aload 13
    //   390: astore 18
    //   392: aload 13
    //   394: astore 19
    //   396: aload 13
    //   398: astore 20
    //   400: aload_1
    //   401: invokeinterface 187 1 0
    //   406: lstore 11
    //   408: lload 9
    //   410: lload 11
    //   412: lcmp
    //   413: ifne +333 -> 746
    //   416: iconst_0
    //   417: istore 4
    //   419: iload 4
    //   421: istore 5
    //   423: aload 13
    //   425: ifnull +12 -> 437
    //   428: aload 13
    //   430: invokevirtual 219	java/io/InputStream:close	()V
    //   433: iload 4
    //   435: istore 5
    //   437: aload 15
    //   439: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   442: iload 5
    //   444: istore 4
    //   446: iload 4
    //   448: ireturn
    //   449: aload 13
    //   451: astore 14
    //   453: aload 13
    //   455: astore 16
    //   457: aload 13
    //   459: astore 17
    //   461: aload 13
    //   463: astore 18
    //   465: aload 13
    //   467: astore 19
    //   469: aload 13
    //   471: astore 20
    //   473: aload_0
    //   474: aload_0
    //   475: getfield 40	com/tencent/securemodule/z:n	J
    //   478: iload 8
    //   480: i2l
    //   481: ladd
    //   482: putfield 40	com/tencent/securemodule/z:n	J
    //   485: iload 5
    //   487: iload 8
    //   489: iadd
    //   490: istore 6
    //   492: aload 13
    //   494: astore 14
    //   496: aload 13
    //   498: astore 16
    //   500: aload 13
    //   502: astore 17
    //   504: aload 13
    //   506: astore 18
    //   508: aload 13
    //   510: astore 19
    //   512: aload 13
    //   514: astore 20
    //   516: aload_2
    //   517: ldc 199
    //   519: aload_0
    //   520: getfield 40	com/tencent/securemodule/z:n	J
    //   523: invokevirtual 197	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   526: aload 13
    //   528: astore 14
    //   530: aload 13
    //   532: astore 16
    //   534: aload 13
    //   536: astore 17
    //   538: aload 13
    //   540: astore 18
    //   542: aload 13
    //   544: astore 19
    //   546: aload 13
    //   548: astore 20
    //   550: aload_0
    //   551: getfield 40	com/tencent/securemodule/z:n	J
    //   554: ldc2_w 188
    //   557: lmul
    //   558: lload 9
    //   560: ldiv
    //   561: l2i
    //   562: istore 7
    //   564: iload 4
    //   566: istore 5
    //   568: iload 7
    //   570: iload 4
    //   572: if_icmpeq +69 -> 641
    //   575: aload 13
    //   577: astore 14
    //   579: aload 13
    //   581: astore 16
    //   583: aload 13
    //   585: astore 17
    //   587: aload 13
    //   589: astore 18
    //   591: aload 13
    //   593: astore 19
    //   595: aload 13
    //   597: astore 20
    //   599: aload_2
    //   600: ldc 201
    //   602: iload 7
    //   604: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   607: aload 13
    //   609: astore 14
    //   611: aload 13
    //   613: astore 16
    //   615: aload 13
    //   617: astore 17
    //   619: aload 13
    //   621: astore 18
    //   623: aload 13
    //   625: astore 19
    //   627: aload 13
    //   629: astore 20
    //   631: aload_0
    //   632: iconst_2
    //   633: aload_2
    //   634: invokevirtual 222	com/tencent/securemodule/z:a	(ILandroid/os/Bundle;)V
    //   637: iload 7
    //   639: istore 5
    //   641: aload 13
    //   643: astore 14
    //   645: aload 13
    //   647: astore 16
    //   649: aload 13
    //   651: astore 17
    //   653: aload 13
    //   655: astore 18
    //   657: aload 13
    //   659: astore 19
    //   661: aload 13
    //   663: astore 20
    //   665: aload 15
    //   667: aload 33
    //   669: iconst_0
    //   670: iload 8
    //   672: invokevirtual 175	java/io/FileOutputStream:write	([BII)V
    //   675: iload 5
    //   677: istore 4
    //   679: iload 6
    //   681: istore 5
    //   683: goto -380 -> 303
    //   686: astore 13
    //   688: aload 15
    //   690: astore_1
    //   691: aload 14
    //   693: astore_2
    //   694: aload 13
    //   696: astore 15
    //   698: aload_2
    //   699: astore 13
    //   701: aload_1
    //   702: astore 14
    //   704: aload 15
    //   706: invokevirtual 161	java/io/FileNotFoundException:printStackTrace	()V
    //   709: aload_2
    //   710: ifnull +484 -> 1194
    //   713: aload_2
    //   714: invokevirtual 219	java/io/InputStream:close	()V
    //   717: sipush -7001
    //   720: istore 5
    //   722: iload 5
    //   724: istore 4
    //   726: aload_1
    //   727: ifnull -281 -> 446
    //   730: aload_1
    //   731: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   734: iload 5
    //   736: ireturn
    //   737: astore_1
    //   738: aload_1
    //   739: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   742: sipush -7000
    //   745: ireturn
    //   746: bipush 249
    //   748: istore 4
    //   750: goto -331 -> 419
    //   753: astore_2
    //   754: sipush -7000
    //   757: istore 5
    //   759: aload_2
    //   760: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   763: goto -41 -> 722
    //   766: astore_2
    //   767: aload 26
    //   769: astore_1
    //   770: aload 21
    //   772: astore 20
    //   774: aload 20
    //   776: astore 13
    //   778: aload_1
    //   779: astore 14
    //   781: aload_2
    //   782: invokevirtual 223	java/net/SocketException:printStackTrace	()V
    //   785: aload 20
    //   787: ifnull +399 -> 1186
    //   790: aload 20
    //   792: invokevirtual 219	java/io/InputStream:close	()V
    //   795: sipush -5054
    //   798: istore 5
    //   800: iload 5
    //   802: istore 4
    //   804: aload_1
    //   805: ifnull -359 -> 446
    //   808: aload_1
    //   809: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   812: iload 5
    //   814: ireturn
    //   815: astore_1
    //   816: aload_1
    //   817: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   820: sipush -7000
    //   823: ireturn
    //   824: astore_2
    //   825: sipush -7000
    //   828: istore 5
    //   830: aload_2
    //   831: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   834: goto -34 -> 800
    //   837: astore_2
    //   838: aload 27
    //   840: astore_1
    //   841: aload 22
    //   843: astore 19
    //   845: aload 19
    //   847: astore 13
    //   849: aload_1
    //   850: astore 14
    //   852: aload_2
    //   853: invokevirtual 224	java/net/SocketTimeoutException:printStackTrace	()V
    //   856: aload 19
    //   858: ifnull +320 -> 1178
    //   861: aload 19
    //   863: invokevirtual 219	java/io/InputStream:close	()V
    //   866: sipush -5055
    //   869: istore 5
    //   871: iload 5
    //   873: istore 4
    //   875: aload_1
    //   876: ifnull -430 -> 446
    //   879: aload_1
    //   880: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   883: iload 5
    //   885: ireturn
    //   886: astore_1
    //   887: aload_1
    //   888: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   891: sipush -7000
    //   894: ireturn
    //   895: astore_2
    //   896: sipush -7000
    //   899: istore 5
    //   901: aload_2
    //   902: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   905: goto -34 -> 871
    //   908: astore_2
    //   909: aload 28
    //   911: astore_1
    //   912: aload 23
    //   914: astore 18
    //   916: aload 18
    //   918: astore 13
    //   920: aload_1
    //   921: astore 14
    //   923: aload_2
    //   924: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   927: aload 18
    //   929: ifnull +241 -> 1170
    //   932: aload 18
    //   934: invokevirtual 219	java/io/InputStream:close	()V
    //   937: sipush -5056
    //   940: istore 5
    //   942: iload 5
    //   944: istore 4
    //   946: aload_1
    //   947: ifnull -501 -> 446
    //   950: aload_1
    //   951: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   954: iload 5
    //   956: ireturn
    //   957: astore_1
    //   958: aload_1
    //   959: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   962: sipush -7000
    //   965: ireturn
    //   966: astore_2
    //   967: sipush -7000
    //   970: istore 5
    //   972: aload_2
    //   973: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   976: goto -34 -> 942
    //   979: astore_2
    //   980: aload 29
    //   982: astore_1
    //   983: aload 24
    //   985: astore 17
    //   987: aload 17
    //   989: astore 13
    //   991: aload_1
    //   992: astore 14
    //   994: aload_2
    //   995: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   998: aload 17
    //   1000: ifnull +162 -> 1162
    //   1003: aload 17
    //   1005: invokevirtual 219	java/io/InputStream:close	()V
    //   1008: sipush -5000
    //   1011: istore 5
    //   1013: iload 5
    //   1015: istore 4
    //   1017: aload_1
    //   1018: ifnull -572 -> 446
    //   1021: aload_1
    //   1022: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   1025: iload 5
    //   1027: ireturn
    //   1028: astore_1
    //   1029: aload_1
    //   1030: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   1033: sipush -7000
    //   1036: ireturn
    //   1037: astore_2
    //   1038: sipush -7000
    //   1041: istore 5
    //   1043: aload_2
    //   1044: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   1047: goto -34 -> 1013
    //   1050: astore_1
    //   1051: aload 13
    //   1053: ifnull +8 -> 1061
    //   1056: aload 13
    //   1058: invokevirtual 219	java/io/InputStream:close	()V
    //   1061: aload 14
    //   1063: ifnull +8 -> 1071
    //   1066: aload 14
    //   1068: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   1071: aload_1
    //   1072: athrow
    //   1073: astore_2
    //   1074: aload_2
    //   1075: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   1078: goto -17 -> 1061
    //   1081: astore_2
    //   1082: aload_2
    //   1083: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   1086: goto -15 -> 1071
    //   1089: astore_1
    //   1090: sipush -7000
    //   1093: istore 5
    //   1095: aload_1
    //   1096: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   1099: goto -662 -> 437
    //   1102: astore_1
    //   1103: aload_1
    //   1104: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   1107: sipush -7000
    //   1110: ireturn
    //   1111: astore_1
    //   1112: aload 15
    //   1114: astore 14
    //   1116: aload 16
    //   1118: astore 13
    //   1120: goto -69 -> 1051
    //   1123: astore_2
    //   1124: aload 15
    //   1126: astore_1
    //   1127: goto -140 -> 987
    //   1130: astore_2
    //   1131: aload 15
    //   1133: astore_1
    //   1134: goto -218 -> 916
    //   1137: astore_2
    //   1138: aload 15
    //   1140: astore_1
    //   1141: goto -296 -> 845
    //   1144: astore_2
    //   1145: aload 15
    //   1147: astore_1
    //   1148: goto -374 -> 774
    //   1151: astore 15
    //   1153: aload 17
    //   1155: astore_2
    //   1156: aload 16
    //   1158: astore_1
    //   1159: goto -461 -> 698
    //   1162: sipush -5000
    //   1165: istore 5
    //   1167: goto -154 -> 1013
    //   1170: sipush -5056
    //   1173: istore 5
    //   1175: goto -233 -> 942
    //   1178: sipush -5055
    //   1181: istore 5
    //   1183: goto -312 -> 871
    //   1186: sipush -5054
    //   1189: istore 5
    //   1191: goto -391 -> 800
    //   1194: sipush -7001
    //   1197: istore 5
    //   1199: goto -477 -> 722
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1202	0	this	z
    //   0	1202	1	paramHttpEntity	org.apache.http.HttpEntity
    //   0	1202	2	paramBundle	android.os.Bundle
    //   0	1202	3	paramBoolean	boolean
    //   114	902	4	i1	int
    //   301	897	5	i2	int
    //   490	190	6	i3	int
    //   562	76	7	i4	int
    //   334	337	8	i5	int
    //   75	484	9	l1	long
    //   406	5	11	l2	long
    //   63	599	13	localObject1	Object
    //   686	9	13	localFileNotFoundException1	java.io.FileNotFoundException
    //   699	420	13	localObject2	Object
    //   67	1048	14	localObject3	Object
    //   13	1133	15	localObject4	Object
    //   1151	1	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   16	1141	16	localObject5	Object
    //   19	1135	17	localObject6	Object
    //   43	890	18	localObject7	Object
    //   46	816	19	localObject8	Object
    //   49	742	20	localObject9	Object
    //   22	749	21	localObject10	Object
    //   25	817	22	localObject11	Object
    //   28	885	23	localObject12	Object
    //   31	953	24	localObject13	Object
    //   40	249	25	localObject14	Object
    //   1	767	26	localObject15	Object
    //   4	835	27	localObject16	Object
    //   7	903	28	localObject17	Object
    //   10	971	29	localObject18	Object
    //   37	248	30	localObject19	Object
    //   52	229	31	localObject20	Object
    //   34	227	32	localObject21	Object
    //   59	609	33	arrayOfByte	byte[]
    //   211	62	34	localFile	File
    // Exception table:
    //   from	to	target	type
    //   292	300	686	java/io/FileNotFoundException
    //   327	336	686	java/io/FileNotFoundException
    //   366	371	686	java/io/FileNotFoundException
    //   400	408	686	java/io/FileNotFoundException
    //   473	485	686	java/io/FileNotFoundException
    //   516	526	686	java/io/FileNotFoundException
    //   550	564	686	java/io/FileNotFoundException
    //   599	607	686	java/io/FileNotFoundException
    //   631	637	686	java/io/FileNotFoundException
    //   665	675	686	java/io/FileNotFoundException
    //   730	734	737	java/io/IOException
    //   713	717	753	java/io/IOException
    //   69	77	766	java/net/SocketException
    //   85	94	766	java/net/SocketException
    //   102	116	766	java/net/SocketException
    //   124	132	766	java/net/SocketException
    //   140	150	766	java/net/SocketException
    //   158	166	766	java/net/SocketException
    //   174	213	766	java/net/SocketException
    //   221	229	766	java/net/SocketException
    //   237	246	766	java/net/SocketException
    //   254	260	766	java/net/SocketException
    //   268	280	766	java/net/SocketException
    //   808	812	815	java/io/IOException
    //   790	795	824	java/io/IOException
    //   69	77	837	java/net/SocketTimeoutException
    //   85	94	837	java/net/SocketTimeoutException
    //   102	116	837	java/net/SocketTimeoutException
    //   124	132	837	java/net/SocketTimeoutException
    //   140	150	837	java/net/SocketTimeoutException
    //   158	166	837	java/net/SocketTimeoutException
    //   174	213	837	java/net/SocketTimeoutException
    //   221	229	837	java/net/SocketTimeoutException
    //   237	246	837	java/net/SocketTimeoutException
    //   254	260	837	java/net/SocketTimeoutException
    //   268	280	837	java/net/SocketTimeoutException
    //   879	883	886	java/io/IOException
    //   861	866	895	java/io/IOException
    //   69	77	908	java/io/IOException
    //   85	94	908	java/io/IOException
    //   102	116	908	java/io/IOException
    //   124	132	908	java/io/IOException
    //   140	150	908	java/io/IOException
    //   158	166	908	java/io/IOException
    //   174	213	908	java/io/IOException
    //   221	229	908	java/io/IOException
    //   237	246	908	java/io/IOException
    //   254	260	908	java/io/IOException
    //   268	280	908	java/io/IOException
    //   950	954	957	java/io/IOException
    //   932	937	966	java/io/IOException
    //   69	77	979	java/lang/Exception
    //   85	94	979	java/lang/Exception
    //   102	116	979	java/lang/Exception
    //   124	132	979	java/lang/Exception
    //   140	150	979	java/lang/Exception
    //   158	166	979	java/lang/Exception
    //   174	213	979	java/lang/Exception
    //   221	229	979	java/lang/Exception
    //   237	246	979	java/lang/Exception
    //   254	260	979	java/lang/Exception
    //   268	280	979	java/lang/Exception
    //   1021	1025	1028	java/io/IOException
    //   1003	1008	1037	java/io/IOException
    //   69	77	1050	finally
    //   85	94	1050	finally
    //   102	116	1050	finally
    //   124	132	1050	finally
    //   140	150	1050	finally
    //   158	166	1050	finally
    //   174	213	1050	finally
    //   221	229	1050	finally
    //   237	246	1050	finally
    //   254	260	1050	finally
    //   268	280	1050	finally
    //   704	709	1050	finally
    //   781	785	1050	finally
    //   852	856	1050	finally
    //   923	927	1050	finally
    //   994	998	1050	finally
    //   1056	1061	1073	java/io/IOException
    //   1066	1071	1081	java/io/IOException
    //   428	433	1089	java/io/IOException
    //   437	442	1102	java/io/IOException
    //   292	300	1111	finally
    //   327	336	1111	finally
    //   366	371	1111	finally
    //   400	408	1111	finally
    //   473	485	1111	finally
    //   516	526	1111	finally
    //   550	564	1111	finally
    //   599	607	1111	finally
    //   631	637	1111	finally
    //   665	675	1111	finally
    //   292	300	1123	java/lang/Exception
    //   327	336	1123	java/lang/Exception
    //   366	371	1123	java/lang/Exception
    //   400	408	1123	java/lang/Exception
    //   473	485	1123	java/lang/Exception
    //   516	526	1123	java/lang/Exception
    //   550	564	1123	java/lang/Exception
    //   599	607	1123	java/lang/Exception
    //   631	637	1123	java/lang/Exception
    //   665	675	1123	java/lang/Exception
    //   292	300	1130	java/io/IOException
    //   327	336	1130	java/io/IOException
    //   366	371	1130	java/io/IOException
    //   400	408	1130	java/io/IOException
    //   473	485	1130	java/io/IOException
    //   516	526	1130	java/io/IOException
    //   550	564	1130	java/io/IOException
    //   599	607	1130	java/io/IOException
    //   631	637	1130	java/io/IOException
    //   665	675	1130	java/io/IOException
    //   292	300	1137	java/net/SocketTimeoutException
    //   327	336	1137	java/net/SocketTimeoutException
    //   366	371	1137	java/net/SocketTimeoutException
    //   400	408	1137	java/net/SocketTimeoutException
    //   473	485	1137	java/net/SocketTimeoutException
    //   516	526	1137	java/net/SocketTimeoutException
    //   550	564	1137	java/net/SocketTimeoutException
    //   599	607	1137	java/net/SocketTimeoutException
    //   631	637	1137	java/net/SocketTimeoutException
    //   665	675	1137	java/net/SocketTimeoutException
    //   292	300	1144	java/net/SocketException
    //   327	336	1144	java/net/SocketException
    //   366	371	1144	java/net/SocketException
    //   400	408	1144	java/net/SocketException
    //   473	485	1144	java/net/SocketException
    //   516	526	1144	java/net/SocketException
    //   550	564	1144	java/net/SocketException
    //   599	607	1144	java/net/SocketException
    //   631	637	1144	java/net/SocketException
    //   665	675	1144	java/net/SocketException
    //   69	77	1151	java/io/FileNotFoundException
    //   85	94	1151	java/io/FileNotFoundException
    //   102	116	1151	java/io/FileNotFoundException
    //   124	132	1151	java/io/FileNotFoundException
    //   140	150	1151	java/io/FileNotFoundException
    //   158	166	1151	java/io/FileNotFoundException
    //   174	213	1151	java/io/FileNotFoundException
    //   221	229	1151	java/io/FileNotFoundException
    //   237	246	1151	java/io/FileNotFoundException
    //   254	260	1151	java/io/FileNotFoundException
    //   268	280	1151	java/io/FileNotFoundException
  }
  
  private int b(String paramString)
  {
    localObject = null;
    try
    {
      paramString = new URI(paramString);
      i1 = -1000;
    }
    catch (URISyntaxException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int i1 = -1053;
        paramString = localObject;
      }
    }
    if (paramString != null)
    {
      this.j.setURI(paramString);
      i1 = 0;
    }
    return i1;
  }
  
  /* Error */
  public final int a(String paramString)
  {
    // Byte code:
    //   0: sipush -3055
    //   3: istore 4
    //   5: sipush -3000
    //   8: istore 5
    //   10: new 193	android/os/Bundle
    //   13: dup
    //   14: invokespecial 238	android/os/Bundle:<init>	()V
    //   17: astore 11
    //   19: aload_0
    //   20: getfield 241	com/tencent/securemodule/y:a	Lorg/apache/http/params/HttpParams;
    //   23: ifnonnull +14 -> 37
    //   26: aload_0
    //   27: new 243	org/apache/http/params/BasicHttpParams
    //   30: dup
    //   31: invokespecial 244	org/apache/http/params/BasicHttpParams:<init>	()V
    //   34: putfield 241	com/tencent/securemodule/y:a	Lorg/apache/http/params/HttpParams;
    //   37: aload_0
    //   38: getfield 241	com/tencent/securemodule/y:a	Lorg/apache/http/params/HttpParams;
    //   41: sipush 10000
    //   44: invokestatic 250	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   47: aload_0
    //   48: getfield 241	com/tencent/securemodule/y:a	Lorg/apache/http/params/HttpParams;
    //   51: sipush 20000
    //   54: invokestatic 253	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   57: aload_0
    //   58: getfield 241	com/tencent/securemodule/y:a	Lorg/apache/http/params/HttpParams;
    //   61: sipush 4096
    //   64: invokestatic 256	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   67: aload_0
    //   68: getfield 241	com/tencent/securemodule/y:a	Lorg/apache/http/params/HttpParams;
    //   71: iconst_1
    //   72: invokestatic 262	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   75: new 264	org/apache/http/impl/client/DefaultHttpClient
    //   78: dup
    //   79: aload_0
    //   80: getfield 241	com/tencent/securemodule/y:a	Lorg/apache/http/params/HttpParams;
    //   83: invokespecial 267	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   86: astore 7
    //   88: aload_0
    //   89: getfield 90	com/tencent/securemodule/y:b	Z
    //   92: ifeq +38 -> 130
    //   95: new 269	org/apache/http/HttpHost
    //   98: dup
    //   99: aload_0
    //   100: getfield 85	com/tencent/securemodule/y:c	Ljava/lang/String;
    //   103: aload_0
    //   104: getfield 88	com/tencent/securemodule/y:d	I
    //   107: invokespecial 271	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   110: astore 8
    //   112: aload 7
    //   114: invokeinterface 277 1 0
    //   119: ldc_w 279
    //   122: aload 8
    //   124: invokeinterface 285 3 0
    //   129: pop
    //   130: aload 7
    //   132: astore 8
    //   134: aload_0
    //   135: aload_1
    //   136: invokespecial 287	com/tencent/securemodule/z:b	(Ljava/lang/String;)I
    //   139: istore_3
    //   140: iload_3
    //   141: istore_2
    //   142: iload_3
    //   143: ifne +801 -> 944
    //   146: iload_3
    //   147: istore_2
    //   148: aload_0
    //   149: getfield 26	com/tencent/securemodule/z:j	Lorg/apache/http/client/methods/HttpGet;
    //   152: invokevirtual 291	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   155: astore 8
    //   157: aload 8
    //   159: ifnonnull +52 -> 211
    //   162: sipush -3053
    //   165: istore_2
    //   166: aload 7
    //   168: ifnull +15 -> 183
    //   171: aload 7
    //   173: invokeinterface 295 1 0
    //   178: invokeinterface 300 1 0
    //   183: iload_2
    //   184: ifeq +25 -> 209
    //   187: iload_2
    //   188: bipush 249
    //   190: if_icmpeq +19 -> 209
    //   193: aload 11
    //   195: ldc_w 302
    //   198: iload_2
    //   199: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   202: aload_0
    //   203: iconst_1
    //   204: aload 11
    //   206: invokevirtual 222	com/tencent/securemodule/z:a	(ILandroid/os/Bundle;)V
    //   209: iload_2
    //   210: ireturn
    //   211: aconst_null
    //   212: astore 9
    //   214: iload_3
    //   215: istore_2
    //   216: aload_1
    //   217: invokestatic 308	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore 10
    //   222: aload 9
    //   224: astore_1
    //   225: aload 10
    //   227: ifnull +720 -> 947
    //   230: iload_3
    //   231: istore_2
    //   232: aload 10
    //   234: bipush 63
    //   236: invokevirtual 312	java/lang/String:indexOf	(I)I
    //   239: istore 6
    //   241: aload 10
    //   243: astore 8
    //   245: iload 6
    //   247: ifle +15 -> 262
    //   250: iload_3
    //   251: istore_2
    //   252: aload 10
    //   254: iconst_0
    //   255: iload 6
    //   257: invokevirtual 316	java/lang/String:substring	(II)Ljava/lang/String;
    //   260: astore 8
    //   262: iload_3
    //   263: istore_2
    //   264: aload 9
    //   266: astore_1
    //   267: aload 8
    //   269: ldc_w 318
    //   272: invokevirtual 322	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   275: ifne +672 -> 947
    //   278: iload_3
    //   279: istore_2
    //   280: aload 8
    //   282: bipush 47
    //   284: invokevirtual 325	java/lang/String:lastIndexOf	(I)I
    //   287: iconst_1
    //   288: iadd
    //   289: istore 6
    //   291: aload 9
    //   293: astore_1
    //   294: iload 6
    //   296: ifle +651 -> 947
    //   299: iload_3
    //   300: istore_2
    //   301: aload 8
    //   303: iload 6
    //   305: invokevirtual 328	java/lang/String:substring	(I)Ljava/lang/String;
    //   308: astore_1
    //   309: goto +638 -> 947
    //   312: iload_3
    //   313: istore_2
    //   314: aload_0
    //   315: new 113	java/lang/StringBuilder
    //   318: dup
    //   319: aload 8
    //   321: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   324: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   327: ldc_w 330
    //   330: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: putfield 32	com/tencent/securemodule/z:l	Ljava/lang/String;
    //   339: iload_3
    //   340: istore_2
    //   341: aload_0
    //   342: getfield 34	com/tencent/securemodule/z:g	Ljava/lang/String;
    //   345: ifnonnull +11 -> 356
    //   348: iload_3
    //   349: istore_2
    //   350: aload_0
    //   351: aload 8
    //   353: putfield 34	com/tencent/securemodule/z:g	Ljava/lang/String;
    //   356: iload_3
    //   357: istore_2
    //   358: new 98	java/io/File
    //   361: dup
    //   362: new 113	java/lang/StringBuilder
    //   365: dup
    //   366: aload_0
    //   367: getfield 28	com/tencent/securemodule/z:k	Ljava/lang/String;
    //   370: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   373: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: getstatic 123	java/io/File:separator	Ljava/lang/String;
    //   379: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_0
    //   383: getfield 32	com/tencent/securemodule/z:l	Ljava/lang/String;
    //   386: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   395: astore_1
    //   396: iload_3
    //   397: istore_2
    //   398: aload_1
    //   399: invokevirtual 135	java/io/File:exists	()Z
    //   402: ifeq +51 -> 453
    //   405: iload_3
    //   406: istore_2
    //   407: aload_0
    //   408: aload_1
    //   409: invokevirtual 333	java/io/File:length	()J
    //   412: putfield 40	com/tencent/securemodule/z:n	J
    //   415: iload_3
    //   416: istore_2
    //   417: aload_0
    //   418: getfield 26	com/tencent/securemodule/z:j	Lorg/apache/http/client/methods/HttpGet;
    //   421: ldc_w 335
    //   424: new 113	java/lang/StringBuilder
    //   427: dup
    //   428: ldc_w 337
    //   431: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   434: aload_0
    //   435: getfield 40	com/tencent/securemodule/z:n	J
    //   438: invokevirtual 340	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: ldc_w 342
    //   444: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 346	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: iload_3
    //   454: istore_2
    //   455: aload 7
    //   457: aload_0
    //   458: getfield 26	com/tencent/securemodule/z:j	Lorg/apache/http/client/methods/HttpGet;
    //   461: invokeinterface 350 2 0
    //   466: astore_1
    //   467: iload_3
    //   468: istore_2
    //   469: aload_1
    //   470: invokeinterface 356 1 0
    //   475: invokeinterface 361 1 0
    //   480: istore 6
    //   482: iload 6
    //   484: sipush 200
    //   487: if_icmpeq +21 -> 508
    //   490: iload 6
    //   492: sipush 206
    //   495: if_icmpeq +13 -> 508
    //   498: sipush -3000
    //   501: iload 6
    //   503: isub
    //   504: istore_2
    //   505: goto -339 -> 166
    //   508: iload_3
    //   509: istore_2
    //   510: aload_1
    //   511: invokeinterface 365 1 0
    //   516: astore_1
    //   517: aload_1
    //   518: ifnonnull +10 -> 528
    //   521: sipush -4000
    //   524: istore_2
    //   525: goto -359 -> 166
    //   528: iload_3
    //   529: istore_2
    //   530: aload_0
    //   531: aload_1
    //   532: aload 11
    //   534: iconst_0
    //   535: invokespecial 367	com/tencent/securemodule/z:a	(Lorg/apache/http/HttpEntity;Landroid/os/Bundle;Z)I
    //   538: istore_3
    //   539: iload_3
    //   540: istore_2
    //   541: iload_3
    //   542: ifne +402 -> 944
    //   545: iload_3
    //   546: istore_2
    //   547: aload_0
    //   548: invokespecial 369	com/tencent/securemodule/z:a	()I
    //   551: istore_3
    //   552: iload_3
    //   553: istore_2
    //   554: iload_3
    //   555: ifne +389 -> 944
    //   558: iconst_0
    //   559: istore_2
    //   560: goto -394 -> 166
    //   563: astore 7
    //   565: aconst_null
    //   566: astore_1
    //   567: aload 7
    //   569: invokevirtual 370	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   572: aload_1
    //   573: ifnull +14 -> 587
    //   576: aload_1
    //   577: invokeinterface 295 1 0
    //   582: invokeinterface 300 1 0
    //   587: aload 11
    //   589: ldc_w 302
    //   592: sipush -3051
    //   595: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   598: aload_0
    //   599: iconst_1
    //   600: aload 11
    //   602: invokevirtual 222	com/tencent/securemodule/z:a	(ILandroid/os/Bundle;)V
    //   605: sipush -3051
    //   608: ireturn
    //   609: astore 8
    //   611: aconst_null
    //   612: astore_1
    //   613: sipush -3054
    //   616: istore_2
    //   617: aload_1
    //   618: astore 7
    //   620: aload 8
    //   622: invokevirtual 223	java/net/SocketException:printStackTrace	()V
    //   625: aload_1
    //   626: ifnull +14 -> 640
    //   629: aload_1
    //   630: invokeinterface 295 1 0
    //   635: invokeinterface 300 1 0
    //   640: aload 11
    //   642: ldc_w 302
    //   645: sipush -3054
    //   648: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   651: aload_0
    //   652: iconst_1
    //   653: aload 11
    //   655: invokevirtual 222	com/tencent/securemodule/z:a	(ILandroid/os/Bundle;)V
    //   658: sipush -3054
    //   661: ireturn
    //   662: astore 8
    //   664: aconst_null
    //   665: astore_1
    //   666: iload 4
    //   668: istore_2
    //   669: aload_1
    //   670: astore 7
    //   672: aload 8
    //   674: invokevirtual 224	java/net/SocketTimeoutException:printStackTrace	()V
    //   677: aload_1
    //   678: ifnull +14 -> 692
    //   681: aload_1
    //   682: invokeinterface 295 1 0
    //   687: invokeinterface 300 1 0
    //   692: aload 11
    //   694: ldc_w 302
    //   697: sipush -3055
    //   700: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   703: aload_0
    //   704: iconst_1
    //   705: aload 11
    //   707: invokevirtual 222	com/tencent/securemodule/z:a	(ILandroid/os/Bundle;)V
    //   710: sipush -3055
    //   713: ireturn
    //   714: astore_1
    //   715: aconst_null
    //   716: astore 7
    //   718: aload_1
    //   719: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   722: aload 7
    //   724: ifnull +15 -> 739
    //   727: aload 7
    //   729: invokeinterface 295 1 0
    //   734: invokeinterface 300 1 0
    //   739: aload 11
    //   741: ldc_w 302
    //   744: sipush -3056
    //   747: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   750: aload_0
    //   751: iconst_1
    //   752: aload 11
    //   754: invokevirtual 222	com/tencent/securemodule/z:a	(ILandroid/os/Bundle;)V
    //   757: sipush -3056
    //   760: ireturn
    //   761: astore_1
    //   762: aconst_null
    //   763: astore 7
    //   765: aload 7
    //   767: astore 8
    //   769: aload_1
    //   770: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   773: aload 7
    //   775: ifnull +15 -> 790
    //   778: aload 7
    //   780: invokeinterface 295 1 0
    //   785: invokeinterface 300 1 0
    //   790: aload 11
    //   792: ldc_w 302
    //   795: sipush -3000
    //   798: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   801: aload_0
    //   802: iconst_1
    //   803: aload 11
    //   805: invokevirtual 222	com/tencent/securemodule/z:a	(ILandroid/os/Bundle;)V
    //   808: sipush -3000
    //   811: ireturn
    //   812: astore_1
    //   813: aconst_null
    //   814: astore 7
    //   816: iload 5
    //   818: istore_2
    //   819: aload 7
    //   821: ifnull +15 -> 836
    //   824: aload 7
    //   826: invokeinterface 295 1 0
    //   831: invokeinterface 300 1 0
    //   836: iload_2
    //   837: ifeq +25 -> 862
    //   840: iload_2
    //   841: bipush 249
    //   843: if_icmpeq +19 -> 862
    //   846: aload 11
    //   848: ldc_w 302
    //   851: iload_2
    //   852: invokevirtual 205	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   855: aload_0
    //   856: iconst_1
    //   857: aload 11
    //   859: invokevirtual 222	com/tencent/securemodule/z:a	(ILandroid/os/Bundle;)V
    //   862: aload_1
    //   863: athrow
    //   864: astore_1
    //   865: iload 5
    //   867: istore_2
    //   868: aload 8
    //   870: astore 7
    //   872: goto -53 -> 819
    //   875: astore_1
    //   876: goto -57 -> 819
    //   879: astore 8
    //   881: aload_1
    //   882: astore 7
    //   884: sipush -3051
    //   887: istore_2
    //   888: aload 8
    //   890: astore_1
    //   891: goto -72 -> 819
    //   894: astore_1
    //   895: goto -76 -> 819
    //   898: astore_1
    //   899: sipush -3056
    //   902: istore_2
    //   903: goto -84 -> 819
    //   906: astore_1
    //   907: goto -142 -> 765
    //   910: astore_1
    //   911: goto -193 -> 718
    //   914: astore 8
    //   916: aload 7
    //   918: astore_1
    //   919: goto -253 -> 666
    //   922: astore 8
    //   924: aload 7
    //   926: astore_1
    //   927: goto -314 -> 613
    //   930: astore_1
    //   931: aload 7
    //   933: astore 8
    //   935: aload_1
    //   936: astore 7
    //   938: aload 8
    //   940: astore_1
    //   941: goto -374 -> 567
    //   944: goto -778 -> 166
    //   947: aload_1
    //   948: astore 8
    //   950: aload_1
    //   951: ifnonnull -639 -> 312
    //   954: ldc_w 372
    //   957: astore 8
    //   959: goto -647 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	this	z
    //   0	962	1	paramString	String
    //   141	762	2	i1	int
    //   139	416	3	i2	int
    //   3	664	4	i3	int
    //   8	858	5	i4	int
    //   239	265	6	i5	int
    //   86	370	7	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   563	5	7	localClientProtocolException	org.apache.http.client.ClientProtocolException
    //   618	319	7	localObject1	Object
    //   110	242	8	localObject2	Object
    //   609	12	8	localSocketException1	java.net.SocketException
    //   662	11	8	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   767	102	8	localObject3	Object
    //   879	10	8	localObject4	Object
    //   914	1	8	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   922	1	8	localSocketException2	java.net.SocketException
    //   933	25	8	localObject5	Object
    //   212	80	9	localObject6	Object
    //   220	33	10	str	String
    //   17	841	11	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   19	37	563	org/apache/http/client/ClientProtocolException
    //   37	130	563	org/apache/http/client/ClientProtocolException
    //   19	37	609	java/net/SocketException
    //   37	130	609	java/net/SocketException
    //   19	37	662	java/net/SocketTimeoutException
    //   37	130	662	java/net/SocketTimeoutException
    //   19	37	714	java/io/IOException
    //   37	130	714	java/io/IOException
    //   19	37	761	java/lang/Exception
    //   37	130	761	java/lang/Exception
    //   19	37	812	finally
    //   37	130	812	finally
    //   134	140	864	finally
    //   769	773	864	finally
    //   148	157	875	finally
    //   216	222	875	finally
    //   232	241	875	finally
    //   252	262	875	finally
    //   267	278	875	finally
    //   280	291	875	finally
    //   301	309	875	finally
    //   314	339	875	finally
    //   341	348	875	finally
    //   350	356	875	finally
    //   358	396	875	finally
    //   398	405	875	finally
    //   407	415	875	finally
    //   417	453	875	finally
    //   455	467	875	finally
    //   469	482	875	finally
    //   510	517	875	finally
    //   530	539	875	finally
    //   547	552	875	finally
    //   567	572	879	finally
    //   620	625	894	finally
    //   672	677	894	finally
    //   718	722	898	finally
    //   134	140	906	java/lang/Exception
    //   148	157	906	java/lang/Exception
    //   216	222	906	java/lang/Exception
    //   232	241	906	java/lang/Exception
    //   252	262	906	java/lang/Exception
    //   267	278	906	java/lang/Exception
    //   280	291	906	java/lang/Exception
    //   301	309	906	java/lang/Exception
    //   314	339	906	java/lang/Exception
    //   341	348	906	java/lang/Exception
    //   350	356	906	java/lang/Exception
    //   358	396	906	java/lang/Exception
    //   398	405	906	java/lang/Exception
    //   407	415	906	java/lang/Exception
    //   417	453	906	java/lang/Exception
    //   455	467	906	java/lang/Exception
    //   469	482	906	java/lang/Exception
    //   510	517	906	java/lang/Exception
    //   530	539	906	java/lang/Exception
    //   547	552	906	java/lang/Exception
    //   134	140	910	java/io/IOException
    //   148	157	910	java/io/IOException
    //   216	222	910	java/io/IOException
    //   232	241	910	java/io/IOException
    //   252	262	910	java/io/IOException
    //   267	278	910	java/io/IOException
    //   280	291	910	java/io/IOException
    //   301	309	910	java/io/IOException
    //   314	339	910	java/io/IOException
    //   341	348	910	java/io/IOException
    //   350	356	910	java/io/IOException
    //   358	396	910	java/io/IOException
    //   398	405	910	java/io/IOException
    //   407	415	910	java/io/IOException
    //   417	453	910	java/io/IOException
    //   455	467	910	java/io/IOException
    //   469	482	910	java/io/IOException
    //   510	517	910	java/io/IOException
    //   530	539	910	java/io/IOException
    //   547	552	910	java/io/IOException
    //   134	140	914	java/net/SocketTimeoutException
    //   148	157	914	java/net/SocketTimeoutException
    //   216	222	914	java/net/SocketTimeoutException
    //   232	241	914	java/net/SocketTimeoutException
    //   252	262	914	java/net/SocketTimeoutException
    //   267	278	914	java/net/SocketTimeoutException
    //   280	291	914	java/net/SocketTimeoutException
    //   301	309	914	java/net/SocketTimeoutException
    //   314	339	914	java/net/SocketTimeoutException
    //   341	348	914	java/net/SocketTimeoutException
    //   350	356	914	java/net/SocketTimeoutException
    //   358	396	914	java/net/SocketTimeoutException
    //   398	405	914	java/net/SocketTimeoutException
    //   407	415	914	java/net/SocketTimeoutException
    //   417	453	914	java/net/SocketTimeoutException
    //   455	467	914	java/net/SocketTimeoutException
    //   469	482	914	java/net/SocketTimeoutException
    //   510	517	914	java/net/SocketTimeoutException
    //   530	539	914	java/net/SocketTimeoutException
    //   547	552	914	java/net/SocketTimeoutException
    //   134	140	922	java/net/SocketException
    //   148	157	922	java/net/SocketException
    //   216	222	922	java/net/SocketException
    //   232	241	922	java/net/SocketException
    //   252	262	922	java/net/SocketException
    //   267	278	922	java/net/SocketException
    //   280	291	922	java/net/SocketException
    //   301	309	922	java/net/SocketException
    //   314	339	922	java/net/SocketException
    //   341	348	922	java/net/SocketException
    //   350	356	922	java/net/SocketException
    //   358	396	922	java/net/SocketException
    //   398	405	922	java/net/SocketException
    //   407	415	922	java/net/SocketException
    //   417	453	922	java/net/SocketException
    //   455	467	922	java/net/SocketException
    //   469	482	922	java/net/SocketException
    //   510	517	922	java/net/SocketException
    //   530	539	922	java/net/SocketException
    //   547	552	922	java/net/SocketException
    //   134	140	930	org/apache/http/client/ClientProtocolException
    //   148	157	930	org/apache/http/client/ClientProtocolException
    //   216	222	930	org/apache/http/client/ClientProtocolException
    //   232	241	930	org/apache/http/client/ClientProtocolException
    //   252	262	930	org/apache/http/client/ClientProtocolException
    //   267	278	930	org/apache/http/client/ClientProtocolException
    //   280	291	930	org/apache/http/client/ClientProtocolException
    //   301	309	930	org/apache/http/client/ClientProtocolException
    //   314	339	930	org/apache/http/client/ClientProtocolException
    //   341	348	930	org/apache/http/client/ClientProtocolException
    //   350	356	930	org/apache/http/client/ClientProtocolException
    //   358	396	930	org/apache/http/client/ClientProtocolException
    //   398	405	930	org/apache/http/client/ClientProtocolException
    //   407	415	930	org/apache/http/client/ClientProtocolException
    //   417	453	930	org/apache/http/client/ClientProtocolException
    //   455	467	930	org/apache/http/client/ClientProtocolException
    //   469	482	930	org/apache/http/client/ClientProtocolException
    //   510	517	930	org/apache/http/client/ClientProtocolException
    //   530	539	930	org/apache/http/client/ClientProtocolException
    //   547	552	930	org/apache/http/client/ClientProtocolException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.z
 * JD-Core Version:    0.7.0.1
 */