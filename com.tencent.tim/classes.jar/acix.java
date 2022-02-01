import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.commonsdk.util.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class acix
{
  public static acix.a a;
  private static long baseTotalCpu;
  private static long baseTotalIdle;
  public static int sCpuCoreNum = -1;
  public static long sLastUpdateTime;
  private static final RecyclablePool sPool = new RecyclablePool(acix.a.class, 30);
  private static Map<String, acix.a> sThreadUsageMap;
  public static int sTotalCpuUsage;
  static int[] sWhiteIndexs;
  static int[] sWordIndexs;
  
  static
  {
    a = a();
    sThreadUsageMap = new HashMap(30);
    sWordIndexs = new int[17];
    sWhiteIndexs = new int[17];
  }
  
  public static acix.a a()
  {
    return (acix.a)sPool.obtain(acix.a.class);
  }
  
  public static void a(acix.a parama)
  {
    parama.recycle();
  }
  
  private static void a(String paramString, acix.a parama, boolean paramBoolean)
  {
    try
    {
      Object[] arrayOfObject = collectProcessStats(paramString);
      long l1;
      if (arrayOfObject != null)
      {
        paramString = (String)arrayOfObject[0];
        l1 = ((Long)arrayOfObject[1]).longValue();
      }
      for (long l2 = ((Long)arrayOfObject[2]).longValue();; l2 = -100L)
      {
        if (paramBoolean)
        {
          parama.base_utime = l1;
          parama.base_stime = l2;
          parama.name = paramString;
          return;
        }
        if (parama.base_utime == -100L)
        {
          parama.rel_utime = -100L;
          parama.rel_stime = -100L;
          return;
        }
        parama.rel_utime = (l1 - parama.base_utime);
        parama.rel_stime = (l2 - parama.base_stime);
        return;
        l1 = -100L;
        paramString = null;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static long collectCpuUsage(String paramString)
  {
    paramString = collectProcessStats(paramString);
    if (paramString == null) {
      return -1L;
    }
    long l = ((Long)paramString[1]).longValue();
    return ((Long)paramString[2]).longValue() + l;
  }
  
  /* Error */
  public static Object[] collectProcessStats(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokestatic 101	acix:getReader	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   6: astore 21
    //   8: invokestatic 107	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   11: sipush 1024
    //   14: invokevirtual 111	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   17: astore 22
    //   19: aload 21
    //   21: lconst_0
    //   22: invokevirtual 117	java/io/RandomAccessFile:seek	(J)V
    //   25: aload 21
    //   27: aload 22
    //   29: invokevirtual 121	java/io/RandomAccessFile:read	([B)I
    //   32: istore 4
    //   34: iconst_0
    //   35: istore_3
    //   36: goto +662 -> 698
    //   39: iload_2
    //   40: istore_1
    //   41: iload_2
    //   42: iload 4
    //   44: if_icmpge +690 -> 734
    //   47: getstatic 47	acix:sWordIndexs	[I
    //   50: iload_3
    //   51: iload_2
    //   52: iastore
    //   53: iload_2
    //   54: istore_1
    //   55: goto +679 -> 734
    //   58: iload_1
    //   59: iload 4
    //   61: if_icmpge +695 -> 756
    //   64: getstatic 49	acix:sWhiteIndexs	[I
    //   67: iload_3
    //   68: iload_1
    //   69: iastore
    //   70: goto +686 -> 756
    //   73: iload_3
    //   74: bipush 17
    //   76: if_icmpne +557 -> 633
    //   79: ldc 123
    //   81: aload_0
    //   82: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifne +236 -> 321
    //   88: new 69	java/lang/String
    //   91: dup
    //   92: aload 22
    //   94: getstatic 47	acix:sWordIndexs	[I
    //   97: iconst_1
    //   98: iaload
    //   99: iconst_1
    //   100: iadd
    //   101: getstatic 49	acix:sWhiteIndexs	[I
    //   104: iconst_1
    //   105: iaload
    //   106: getstatic 47	acix:sWordIndexs	[I
    //   109: iconst_1
    //   110: iaload
    //   111: isub
    //   112: iconst_1
    //   113: isub
    //   114: invokespecial 130	java/lang/String:<init>	([BII)V
    //   117: astore 23
    //   119: new 69	java/lang/String
    //   122: dup
    //   123: aload 22
    //   125: getstatic 47	acix:sWordIndexs	[I
    //   128: bipush 13
    //   130: iaload
    //   131: getstatic 49	acix:sWhiteIndexs	[I
    //   134: bipush 13
    //   136: iaload
    //   137: getstatic 47	acix:sWordIndexs	[I
    //   140: bipush 13
    //   142: iaload
    //   143: isub
    //   144: invokespecial 130	java/lang/String:<init>	([BII)V
    //   147: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   150: lstore 5
    //   152: new 69	java/lang/String
    //   155: dup
    //   156: aload 22
    //   158: getstatic 47	acix:sWordIndexs	[I
    //   161: bipush 15
    //   163: iaload
    //   164: getstatic 49	acix:sWhiteIndexs	[I
    //   167: bipush 15
    //   169: iaload
    //   170: getstatic 47	acix:sWordIndexs	[I
    //   173: bipush 15
    //   175: iaload
    //   176: isub
    //   177: invokespecial 130	java/lang/String:<init>	([BII)V
    //   180: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   183: lstore 7
    //   185: new 69	java/lang/String
    //   188: dup
    //   189: aload 22
    //   191: getstatic 47	acix:sWordIndexs	[I
    //   194: bipush 14
    //   196: iaload
    //   197: getstatic 49	acix:sWhiteIndexs	[I
    //   200: bipush 14
    //   202: iaload
    //   203: getstatic 47	acix:sWordIndexs	[I
    //   206: bipush 14
    //   208: iaload
    //   209: isub
    //   210: invokespecial 130	java/lang/String:<init>	([BII)V
    //   213: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   216: lstore 9
    //   218: new 69	java/lang/String
    //   221: dup
    //   222: aload 22
    //   224: getstatic 47	acix:sWordIndexs	[I
    //   227: bipush 16
    //   229: iaload
    //   230: getstatic 49	acix:sWhiteIndexs	[I
    //   233: bipush 16
    //   235: iaload
    //   236: getstatic 47	acix:sWordIndexs	[I
    //   239: bipush 16
    //   241: iaload
    //   242: isub
    //   243: invokespecial 130	java/lang/String:<init>	([BII)V
    //   246: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: lstore 11
    //   251: aload 23
    //   253: ifnull +50 -> 303
    //   256: iconst_3
    //   257: anewarray 4	java/lang/Object
    //   260: astore_0
    //   261: aload_0
    //   262: iconst_0
    //   263: aload 23
    //   265: aastore
    //   266: aload_0
    //   267: iconst_1
    //   268: lload 5
    //   270: lload 7
    //   272: ladd
    //   273: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   276: aastore
    //   277: aload_0
    //   278: iconst_2
    //   279: lload 9
    //   281: lload 11
    //   283: ladd
    //   284: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   287: aastore
    //   288: invokestatic 107	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   291: aload 22
    //   293: invokevirtual 141	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   296: aload 21
    //   298: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   301: aload_0
    //   302: areturn
    //   303: invokestatic 107	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   306: aload 22
    //   308: invokevirtual 141	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   311: aload 21
    //   313: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   316: aconst_null
    //   317: areturn
    //   318: astore_0
    //   319: aconst_null
    //   320: areturn
    //   321: new 69	java/lang/String
    //   324: dup
    //   325: aload 22
    //   327: getstatic 47	acix:sWordIndexs	[I
    //   330: iconst_4
    //   331: iaload
    //   332: getstatic 49	acix:sWhiteIndexs	[I
    //   335: iconst_4
    //   336: iaload
    //   337: getstatic 47	acix:sWordIndexs	[I
    //   340: iconst_4
    //   341: iaload
    //   342: isub
    //   343: invokespecial 130	java/lang/String:<init>	([BII)V
    //   346: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   349: lstore 5
    //   351: new 69	java/lang/String
    //   354: dup
    //   355: aload 22
    //   357: getstatic 47	acix:sWordIndexs	[I
    //   360: iconst_1
    //   361: iaload
    //   362: getstatic 49	acix:sWhiteIndexs	[I
    //   365: iconst_1
    //   366: iaload
    //   367: getstatic 47	acix:sWordIndexs	[I
    //   370: iconst_1
    //   371: iaload
    //   372: isub
    //   373: invokespecial 130	java/lang/String:<init>	([BII)V
    //   376: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   379: lstore 7
    //   381: new 69	java/lang/String
    //   384: dup
    //   385: aload 22
    //   387: getstatic 47	acix:sWordIndexs	[I
    //   390: iconst_2
    //   391: iaload
    //   392: getstatic 49	acix:sWhiteIndexs	[I
    //   395: iconst_2
    //   396: iaload
    //   397: getstatic 47	acix:sWordIndexs	[I
    //   400: iconst_2
    //   401: iaload
    //   402: isub
    //   403: invokespecial 130	java/lang/String:<init>	([BII)V
    //   406: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   409: lstore 9
    //   411: new 69	java/lang/String
    //   414: dup
    //   415: aload 22
    //   417: getstatic 47	acix:sWordIndexs	[I
    //   420: iconst_3
    //   421: iaload
    //   422: getstatic 49	acix:sWhiteIndexs	[I
    //   425: iconst_3
    //   426: iaload
    //   427: getstatic 47	acix:sWordIndexs	[I
    //   430: iconst_3
    //   431: iaload
    //   432: isub
    //   433: invokespecial 130	java/lang/String:<init>	([BII)V
    //   436: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   439: lstore 11
    //   441: new 69	java/lang/String
    //   444: dup
    //   445: aload 22
    //   447: getstatic 47	acix:sWordIndexs	[I
    //   450: iconst_5
    //   451: iaload
    //   452: getstatic 49	acix:sWhiteIndexs	[I
    //   455: iconst_5
    //   456: iaload
    //   457: getstatic 47	acix:sWordIndexs	[I
    //   460: iconst_5
    //   461: iaload
    //   462: isub
    //   463: invokespecial 130	java/lang/String:<init>	([BII)V
    //   466: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   469: lstore 13
    //   471: new 69	java/lang/String
    //   474: dup
    //   475: aload 22
    //   477: getstatic 47	acix:sWordIndexs	[I
    //   480: bipush 6
    //   482: iaload
    //   483: getstatic 49	acix:sWhiteIndexs	[I
    //   486: bipush 6
    //   488: iaload
    //   489: getstatic 47	acix:sWordIndexs	[I
    //   492: bipush 6
    //   494: iaload
    //   495: isub
    //   496: invokespecial 130	java/lang/String:<init>	([BII)V
    //   499: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   502: lstore 15
    //   504: new 69	java/lang/String
    //   507: dup
    //   508: aload 22
    //   510: getstatic 47	acix:sWordIndexs	[I
    //   513: bipush 7
    //   515: iaload
    //   516: getstatic 49	acix:sWhiteIndexs	[I
    //   519: bipush 7
    //   521: iaload
    //   522: getstatic 47	acix:sWordIndexs	[I
    //   525: bipush 7
    //   527: iaload
    //   528: isub
    //   529: invokespecial 130	java/lang/String:<init>	([BII)V
    //   532: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   535: lstore 17
    //   537: new 69	java/lang/String
    //   540: dup
    //   541: aload 22
    //   543: getstatic 47	acix:sWordIndexs	[I
    //   546: bipush 8
    //   548: iaload
    //   549: getstatic 49	acix:sWhiteIndexs	[I
    //   552: bipush 8
    //   554: iaload
    //   555: getstatic 47	acix:sWordIndexs	[I
    //   558: bipush 8
    //   560: iaload
    //   561: isub
    //   562: invokespecial 130	java/lang/String:<init>	([BII)V
    //   565: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   568: lstore 19
    //   570: iconst_3
    //   571: anewarray 4	java/lang/Object
    //   574: astore_0
    //   575: aload_0
    //   576: iconst_0
    //   577: ldc 146
    //   579: aastore
    //   580: aload_0
    //   581: iconst_1
    //   582: lload 5
    //   584: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   587: aastore
    //   588: aload_0
    //   589: iconst_2
    //   590: lload 7
    //   592: lload 9
    //   594: ladd
    //   595: lload 11
    //   597: ladd
    //   598: lload 13
    //   600: ladd
    //   601: lload 15
    //   603: ladd
    //   604: lload 17
    //   606: ladd
    //   607: lload 19
    //   609: ladd
    //   610: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   613: aastore
    //   614: invokestatic 107	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   617: aload 22
    //   619: invokevirtual 141	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   622: aload 21
    //   624: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   627: aload_0
    //   628: areturn
    //   629: astore 21
    //   631: aload_0
    //   632: areturn
    //   633: invokestatic 107	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   636: aload 22
    //   638: invokevirtual 141	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   641: aload 21
    //   643: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   646: aconst_null
    //   647: areturn
    //   648: astore_0
    //   649: invokestatic 107	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   652: aload 22
    //   654: invokevirtual 141	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   657: aload 21
    //   659: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   662: goto -16 -> 646
    //   665: astore_0
    //   666: goto -20 -> 646
    //   669: astore_0
    //   670: invokestatic 107	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   673: aload 22
    //   675: invokevirtual 141	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   678: aload 21
    //   680: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   683: aload_0
    //   684: athrow
    //   685: astore 21
    //   687: aload_0
    //   688: areturn
    //   689: astore_0
    //   690: goto -44 -> 646
    //   693: astore 21
    //   695: goto -12 -> 683
    //   698: iload_1
    //   699: iload 4
    //   701: if_icmpge -628 -> 73
    //   704: iload_3
    //   705: bipush 17
    //   707: if_icmpge -634 -> 73
    //   710: iload_1
    //   711: istore_2
    //   712: iload_2
    //   713: iload 4
    //   715: if_icmpge -676 -> 39
    //   718: aload 22
    //   720: iload_2
    //   721: baload
    //   722: bipush 32
    //   724: if_icmpne -685 -> 39
    //   727: iload_2
    //   728: iconst_1
    //   729: iadd
    //   730: istore_2
    //   731: goto -19 -> 712
    //   734: iload_1
    //   735: iload 4
    //   737: if_icmpge -679 -> 58
    //   740: aload 22
    //   742: iload_1
    //   743: baload
    //   744: bipush 32
    //   746: if_icmpeq -688 -> 58
    //   749: iload_1
    //   750: iconst_1
    //   751: iadd
    //   752: istore_1
    //   753: goto -19 -> 734
    //   756: iload_3
    //   757: iconst_1
    //   758: iadd
    //   759: istore_3
    //   760: goto -62 -> 698
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	paramString	String
    //   1	752	1	i	int
    //   39	692	2	j	int
    //   35	725	3	k	int
    //   32	706	4	m	int
    //   150	433	5	l1	long
    //   183	408	7	l2	long
    //   216	377	9	l3	long
    //   249	347	11	l4	long
    //   469	130	13	l5	long
    //   502	100	15	l6	long
    //   535	70	17	l7	long
    //   568	40	19	l8	long
    //   6	617	21	localRandomAccessFile	RandomAccessFile
    //   629	50	21	localException1	Exception
    //   685	1	21	localException2	Exception
    //   693	1	21	localException3	Exception
    //   17	724	22	arrayOfByte	byte[]
    //   117	147	23	str	String
    // Exception table:
    //   from	to	target	type
    //   311	316	318	java/lang/Exception
    //   622	627	629	java/lang/Exception
    //   19	34	648	java/lang/Exception
    //   47	53	648	java/lang/Exception
    //   64	70	648	java/lang/Exception
    //   79	251	648	java/lang/Exception
    //   256	261	648	java/lang/Exception
    //   266	288	648	java/lang/Exception
    //   321	575	648	java/lang/Exception
    //   580	614	648	java/lang/Exception
    //   657	662	665	java/lang/Exception
    //   19	34	669	finally
    //   47	53	669	finally
    //   64	70	669	finally
    //   79	251	669	finally
    //   256	261	669	finally
    //   266	288	669	finally
    //   321	575	669	finally
    //   580	614	669	finally
    //   296	301	685	java/lang/Exception
    //   641	646	689	java/lang/Exception
    //   678	683	693	java/lang/Exception
  }
  
  /* Error */
  public static final String dumpProcessStats(int paramInt)
  {
    // Byte code:
    //   0: new 150	java/lang/StringBuilder
    //   3: dup
    //   4: iload_0
    //   5: bipush 110
    //   7: imul
    //   8: invokespecial 151	java/lang/StringBuilder:<init>	(I)V
    //   11: astore_1
    //   12: ldc 153
    //   14: getstatic 38	acix:a	Lacix$a;
    //   17: iconst_0
    //   18: invokestatic 155	acix:a	(Ljava/lang/String;Lacix$a;Z)V
    //   21: ldc 157
    //   23: new 150	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   30: ldc 161
    //   32: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 38	acix:a	Lacix$a;
    //   38: getfield 78	acix$a:base_utime	J
    //   41: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: ldc 170
    //   46: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 38	acix:a	Lacix$a;
    //   52: getfield 81	acix$a:base_stime	J
    //   55: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 180	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: new 182	java/io/BufferedReader
    //   68: dup
    //   69: new 184	java/io/InputStreamReader
    //   72: dup
    //   73: invokestatic 190	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   76: new 150	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   83: ldc 192
    //   85: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_0
    //   89: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc 197
    //   94: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 201	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   103: invokevirtual 207	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   106: invokespecial 210	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   109: invokespecial 213	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   112: astore_3
    //   113: aload_3
    //   114: invokevirtual 216	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   117: astore_2
    //   118: aload_2
    //   119: ifnull +46 -> 165
    //   122: aload_1
    //   123: aload_2
    //   124: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 218
    //   129: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: goto -20 -> 113
    //   136: astore_1
    //   137: iconst_0
    //   138: ifeq +11 -> 149
    //   141: new 220	java/lang/NullPointerException
    //   144: dup
    //   145: invokespecial 221	java/lang/NullPointerException:<init>	()V
    //   148: athrow
    //   149: iconst_0
    //   150: ifeq +11 -> 161
    //   153: new 220	java/lang/NullPointerException
    //   156: dup
    //   157: invokespecial 221	java/lang/NullPointerException:<init>	()V
    //   160: athrow
    //   161: aconst_null
    //   162: astore_2
    //   163: aload_2
    //   164: areturn
    //   165: ldc 153
    //   167: getstatic 38	acix:a	Lacix$a;
    //   170: iconst_0
    //   171: invokestatic 155	acix:a	(Ljava/lang/String;Lacix$a;Z)V
    //   174: ldc 157
    //   176: new 150	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   183: ldc 161
    //   185: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: getstatic 38	acix:a	Lacix$a;
    //   191: getfield 78	acix$a:base_utime	J
    //   194: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: ldc 170
    //   199: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: getstatic 38	acix:a	Lacix$a;
    //   205: getfield 81	acix$a:base_stime	J
    //   208: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 180	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload_1
    //   219: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore_1
    //   223: iconst_0
    //   224: ifeq +11 -> 235
    //   227: new 220	java/lang/NullPointerException
    //   230: dup
    //   231: invokespecial 221	java/lang/NullPointerException:<init>	()V
    //   234: athrow
    //   235: aload_1
    //   236: astore_2
    //   237: iconst_0
    //   238: ifeq -75 -> 163
    //   241: new 220	java/lang/NullPointerException
    //   244: dup
    //   245: invokespecial 221	java/lang/NullPointerException:<init>	()V
    //   248: athrow
    //   249: astore_2
    //   250: aload_1
    //   251: areturn
    //   252: astore_1
    //   253: iconst_0
    //   254: ifeq +11 -> 265
    //   257: new 220	java/lang/NullPointerException
    //   260: dup
    //   261: invokespecial 221	java/lang/NullPointerException:<init>	()V
    //   264: athrow
    //   265: iconst_0
    //   266: ifeq +11 -> 277
    //   269: new 220	java/lang/NullPointerException
    //   272: dup
    //   273: invokespecial 221	java/lang/NullPointerException:<init>	()V
    //   276: athrow
    //   277: aload_1
    //   278: athrow
    //   279: astore_2
    //   280: goto -45 -> 235
    //   283: astore_1
    //   284: goto -135 -> 149
    //   287: astore_1
    //   288: goto -127 -> 161
    //   291: astore_2
    //   292: goto -27 -> 265
    //   295: astore_2
    //   296: goto -19 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramInt	int
    //   11	112	1	localStringBuilder	StringBuilder
    //   136	83	1	localException1	Exception
    //   222	29	1	str1	String
    //   252	26	1	localObject	Object
    //   283	1	1	localException2	Exception
    //   287	1	1	localException3	Exception
    //   117	120	2	str2	String
    //   249	1	2	localException4	Exception
    //   279	1	2	localException5	Exception
    //   291	1	2	localException6	Exception
    //   295	1	2	localException7	Exception
    //   112	2	3	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   0	113	136	java/lang/Exception
    //   113	118	136	java/lang/Exception
    //   122	133	136	java/lang/Exception
    //   165	223	136	java/lang/Exception
    //   241	249	249	java/lang/Exception
    //   0	113	252	finally
    //   113	118	252	finally
    //   122	133	252	finally
    //   165	223	252	finally
    //   227	235	279	java/lang/Exception
    //   141	149	283	java/lang/Exception
    //   153	161	287	java/lang/Exception
    //   257	265	291	java/lang/Exception
    //   269	277	295	java/lang/Exception
  }
  
  public static final List<String> dumpThreadStats(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new HashMap();
    Object localObject2;
    int i;
    Object localObject3;
    if (paramBoolean)
    {
      localObject1 = Thread.currentThread().getThreadGroup();
      localObject2 = new Thread[((ThreadGroup)localObject1).activeCount()];
      ((ThreadGroup)localObject1).enumerate((Thread[])localObject2);
      localObject1 = new HashMap(localObject2.length);
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if (localObject3 != null) {
          ((Map)localObject1).put(((Thread)localObject3).getName(), localObject3);
        }
        i += 1;
      }
    }
    for (;;)
    {
      localObject2 = new ArrayList(sThreadUsageMap.size() / 2);
      localObject3 = sThreadUsageMap.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (String)((Iterator)localObject3).next();
        acix.a locala = (acix.a)sThreadUsageMap.get(localObject4);
        if (locala.cpuUsage >= paramInt)
        {
          if (paramBoolean) {}
          StringBuilder localStringBuilder;
          for (i = 300;; i = 50)
          {
            localStringBuilder = new StringBuilder(i);
            localStringBuilder.append(locala.name).append("_").append((String)localObject4).append(":").append(locala.cpuUsage).append("\r\n");
            if (!paramBoolean) {
              break;
            }
            localObject4 = (Thread)((Map)localObject1).get(locala.name);
            if (localObject4 != null) {
              localStringBuilder.append(Arrays.toString(((Thread)localObject4).getStackTrace()));
            }
            localObject4 = StringUtils.getStringValue(localStringBuilder);
            if (localObject4 == null) {
              break label308;
            }
            ((List)localObject2).add(StringUtils.newStringWithData((char[])localObject4));
            break;
          }
          label308:
          ((List)localObject2).add(localStringBuilder.toString());
        }
      }
      if (paramBoolean) {
        ((List)localObject2).add(Arrays.toString(Looper.getMainLooper().getThread().getStackTrace()));
      }
      return localObject2;
    }
  }
  
  private static final int getNumCoresOldPhones()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new aciy()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  @SuppressLint({"NewApi"})
  public static final int getNumberOfCores()
  {
    if (sCpuCoreNum == -1) {
      if (Build.VERSION.SDK_INT < 17) {
        break label28;
      }
    }
    label28:
    for (sCpuCoreNum = Runtime.getRuntime().availableProcessors();; sCpuCoreNum = getNumCoresOldPhones()) {
      return sCpuCoreNum;
    }
  }
  
  private static final RandomAccessFile getReader(String paramString)
  {
    try
    {
      if (paramString.equals("-2")) {
        return new RandomAccessFile("/proc/stat", "r");
      }
      if (paramString.equals("-1"))
      {
        paramString = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
        return paramString;
      }
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return null;
      paramString = new RandomAccessFile("/proc/" + Process.myPid() + "/task/" + paramString + "/stat", "r");
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static final String[] getThreadPids(long paramLong)
  {
    File localFile = new File("/proc/" + paramLong + "/task");
    if ((localFile.exists()) && (localFile.isDirectory())) {
      return localFile.list();
    }
    return null;
  }
  
  public static void traceEnd(boolean paramBoolean)
  {
    byte[] arrayOfByte = ByteArrayPool.getGenericInstance().getBuf(1024);
    for (;;)
    {
      try
      {
        Object localObject1 = collectProcessStats("-2");
        if (localObject1 != null)
        {
          l1 = ((Long)localObject1[1]).longValue();
          l2 = ((Long)localObject1[2]).longValue();
          l1 = l1 + l2 - baseTotalCpu - baseTotalIdle;
          a("-1", a, false);
          if (paramBoolean)
          {
            localObject1 = sThreadUsageMap.keySet().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              String str = (String)((Iterator)localObject1).next();
              acix.a locala = (acix.a)sThreadUsageMap.get(str);
              a(str, locala, false);
              locala.cpuUsage = ((int)(100L * (locala.rel_stime + locala.rel_utime) / l1));
              continue;
            }
          }
        }
        long l1 = -1L;
      }
      catch (Exception localException)
      {
        return;
        sTotalCpuUsage = (int)(100L * (l2 - baseTotalCpu) / l1);
        a.cpuUsage = ((int)(100L * (a.rel_stime + a.rel_utime) / l1));
        sLastUpdateTime = SystemClock.uptimeMillis();
        return;
      }
      finally
      {
        ByteArrayPool.getGenericInstance().returnBuf(arrayOfByte);
      }
      long l2 = -1L;
    }
  }
  
  public static void traceStart(boolean paramBoolean)
  {
    byte[] arrayOfByte = ByteArrayPool.getGenericInstance().getBuf(1024);
    try
    {
      localObject1 = collectProcessStats("-2");
      if (localObject1 == null) {
        break label117;
      }
      baseTotalIdle = ((Long)localObject1[1]).longValue();
      baseTotalCpu = ((Long)localObject1[2]).longValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        localException.printStackTrace();
        return;
        baseTotalIdle = -1L;
        baseTotalCpu = -1L;
      }
    }
    finally
    {
      ByteArrayPool.getGenericInstance().returnBuf(arrayOfByte);
    }
    a("-1", a, true);
    if (paramBoolean)
    {
      localObject1 = sThreadUsageMap.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((acix.a)((Iterator)localObject1).next());
      }
      label117:
      sThreadUsageMap.clear();
      String[] arrayOfString = getThreadPids(Process.myPid());
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          acix.a locala = a();
          a(str, locala, true);
          sThreadUsageMap.put(str, locala);
          i += 1;
        }
      }
    }
    ByteArrayPool.getGenericInstance().returnBuf(arrayOfByte);
  }
  
  public static class a
    extends RecyclablePool.Recyclable
  {
    public long base_stime;
    public long base_utime;
    public int cpuUsage;
    public String name;
    public long rel_stime;
    public long rel_utime;
    
    public void recycle()
    {
      super.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acix
 * JD-Core Version:    0.7.0.1
 */