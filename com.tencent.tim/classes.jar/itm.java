import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.report.VideoConnRateReport.1;
import com.tencent.av.report.VideoConnRateReport.2;
import com.tencent.av.report.VideoSerializeData;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class itm
{
  static volatile itm a;
  private static String msfReportLogPath = "";
  final int MAX_FILE_SIZE = 10240;
  public boolean Vc;
  ConcurrentHashMap<String, String> aL = new ConcurrentHashMap();
  public boolean isReported;
  ConcurrentHashMap<String, VideoSerializeData> map = new ConcurrentHashMap();
  public Object obj = new Object();
  long oc = 0L;
  public long of;
  
  public static itm a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a = new itm();
        msfReportLogPath = Environment.getExternalStorageDirectory().getPath() + "/tencent/audio/";
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  private void aqD()
  {
    // Byte code:
    //   0: new 61	java/io/File
    //   3: dup
    //   4: getstatic 29	itm:msfReportLogPath	Ljava/lang/String;
    //   7: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 92	java/io/File:listFiles	()[Ljava/io/File;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +8 -> 23
    //   18: aload_2
    //   19: arraylength
    //   20: ifgt +4 -> 24
    //   23: return
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: aload_2
    //   28: arraylength
    //   29: if_icmpge +79 -> 108
    //   32: aload_2
    //   33: iload_1
    //   34: aaload
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +22 -> 59
    //   40: aload_3
    //   41: invokevirtual 96	java/io/File:isFile	()Z
    //   44: ifeq +10 -> 54
    //   47: aload_3
    //   48: invokevirtual 99	java/io/File:exists	()Z
    //   51: ifne +15 -> 66
    //   54: aload_3
    //   55: invokevirtual 102	java/io/File:delete	()Z
    //   58: pop
    //   59: iload_1
    //   60: iconst_1
    //   61: iadd
    //   62: istore_1
    //   63: goto -37 -> 26
    //   66: aload_3
    //   67: invokevirtual 105	java/io/File:getName	()Ljava/lang/String;
    //   70: astore 4
    //   72: aload 4
    //   74: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne -18 -> 59
    //   80: aload 4
    //   82: ldc 113
    //   84: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: ifeq -28 -> 59
    //   90: aload_0
    //   91: aload 4
    //   93: iconst_1
    //   94: invokevirtual 122	itm:l	(Ljava/lang/String;Z)Z
    //   97: ifne -38 -> 59
    //   100: aload_3
    //   101: invokevirtual 102	java/io/File:delete	()Z
    //   104: pop
    //   105: goto -46 -> 59
    //   108: new 124	java/util/ArrayList
    //   111: dup
    //   112: invokespecial 125	java/util/ArrayList:<init>	()V
    //   115: astore_3
    //   116: aload_0
    //   117: getfield 44	itm:map	Ljava/util/concurrent/ConcurrentHashMap;
    //   120: invokevirtual 129	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   123: invokeinterface 135 1 0
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface 140 1 0
    //   135: ifeq +93 -> 228
    //   138: aload_2
    //   139: invokeinterface 144 1 0
    //   144: checkcast 146	java/util/Map$Entry
    //   147: invokeinterface 149 1 0
    //   152: checkcast 115	java/lang/String
    //   155: astore 4
    //   157: aload 4
    //   159: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne -33 -> 129
    //   165: aload 4
    //   167: iconst_0
    //   168: aload 4
    //   170: ldc 151
    //   172: invokevirtual 155	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   175: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull -53 -> 129
    //   185: aload_3
    //   186: aload 4
    //   188: invokevirtual 162	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   191: ifne -62 -> 129
    //   194: aload 4
    //   196: aload_0
    //   197: getfield 37	itm:oc	J
    //   200: invokestatic 166	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   203: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifne -77 -> 129
    //   209: aload_3
    //   210: aload 4
    //   212: invokevirtual 172	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   215: pop
    //   216: goto -87 -> 129
    //   219: astore 4
    //   221: iconst_0
    //   222: ifeq -93 -> 129
    //   225: aload 4
    //   227: athrow
    //   228: iconst_0
    //   229: istore_1
    //   230: iload_1
    //   231: aload_3
    //   232: invokevirtual 176	java/util/ArrayList:size	()I
    //   235: if_icmpge -212 -> 23
    //   238: aload_3
    //   239: iload_1
    //   240: invokevirtual 180	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   243: checkcast 115	java/lang/String
    //   246: astore 4
    //   248: aload 4
    //   250: ifnull +74 -> 324
    //   253: aload_0
    //   254: aload 4
    //   256: invokespecial 184	itm:dt	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore_2
    //   260: aload_0
    //   261: getfield 44	itm:map	Ljava/util/concurrent/ConcurrentHashMap;
    //   264: new 52	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   271: aload 4
    //   273: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc 151
    //   278: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc 186
    //   283: invokestatic 189	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 192	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   295: checkcast 194	com/tencent/av/report/VideoSerializeData
    //   298: astore 6
    //   300: ldc 27
    //   302: aload_2
    //   303: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifne +12 -> 318
    //   309: aload_2
    //   310: ldc 196
    //   312: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   315: ifne +16 -> 331
    //   318: aload_0
    //   319: aload 4
    //   321: invokespecial 199	itm:jA	(Ljava/lang/String;)V
    //   324: iload_1
    //   325: iconst_1
    //   326: iadd
    //   327: istore_1
    //   328: goto -98 -> 230
    //   331: new 201	java/util/HashMap
    //   334: dup
    //   335: invokespecial 202	java/util/HashMap:<init>	()V
    //   338: astore 5
    //   340: aload 5
    //   342: ldc 204
    //   344: aload_2
    //   345: invokevirtual 208	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   348: pop
    //   349: ldc 210
    //   351: astore_2
    //   352: aload 6
    //   354: ifnull +44 -> 398
    //   357: aload 5
    //   359: ldc 212
    //   361: aload 6
    //   363: getfield 215	com/tencent/av/report/VideoSerializeData:toUin	J
    //   366: invokestatic 166	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   369: invokevirtual 208	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   372: pop
    //   373: aload 5
    //   375: ldc 217
    //   377: aload 6
    //   379: getfield 220	com/tencent/av/report/VideoSerializeData:fromUin	J
    //   382: invokestatic 166	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   385: invokevirtual 208	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   388: pop
    //   389: aload 6
    //   391: getfield 220	com/tencent/av/report/VideoSerializeData:fromUin	J
    //   394: invokestatic 166	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   397: astore_2
    //   398: invokestatic 226	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   401: invokestatic 231	anpc:a	(Landroid/content/Context;)Lanpc;
    //   404: aload_2
    //   405: ldc 233
    //   407: iconst_1
    //   408: lconst_0
    //   409: lconst_0
    //   410: aload 5
    //   412: ldc 27
    //   414: iconst_1
    //   415: invokevirtual 237	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   418: aload_0
    //   419: aload 4
    //   421: invokespecial 199	itm:jA	(Ljava/lang/String;)V
    //   424: goto -100 -> 324
    //   427: astore 4
    //   429: goto -300 -> 129
    //   432: astore 4
    //   434: goto -305 -> 129
    //   437: astore 4
    //   439: goto -310 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	itm
    //   25	303	1	i	int
    //   13	392	2	localObject1	Object
    //   35	204	3	localArrayList	java.util.ArrayList
    //   70	141	4	str1	String
    //   219	7	4	localObject2	Object
    //   246	174	4	str2	String
    //   427	1	4	localException	java.lang.Exception
    //   432	1	4	localNullPointerException	java.lang.NullPointerException
    //   437	1	4	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   338	73	5	localHashMap	java.util.HashMap
    //   298	92	6	localVideoSerializeData	VideoSerializeData
    // Exception table:
    //   from	to	target	type
    //   165	180	219	finally
    //   165	180	427	java/lang/Exception
    //   165	180	432	java/lang/NullPointerException
    //   165	180	437	java/lang/IndexOutOfBoundsException
  }
  
  /* Error */
  private void aqE()
  {
    // Byte code:
    //   0: new 61	java/io/File
    //   3: dup
    //   4: getstatic 29	itm:msfReportLogPath	Ljava/lang/String;
    //   7: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 92	java/io/File:listFiles	()[Ljava/io/File;
    //   13: astore 11
    //   15: aload 11
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: iconst_0
    //   22: istore_1
    //   23: iload_1
    //   24: aload 11
    //   26: arraylength
    //   27: if_icmpge -7 -> 20
    //   30: aload 11
    //   32: iload_1
    //   33: aaload
    //   34: astore 12
    //   36: aload 12
    //   38: ifnull +25 -> 63
    //   41: aload 12
    //   43: invokevirtual 96	java/io/File:isFile	()Z
    //   46: ifeq +11 -> 57
    //   49: aload 12
    //   51: invokevirtual 99	java/io/File:exists	()Z
    //   54: ifne +16 -> 70
    //   57: aload 12
    //   59: invokevirtual 102	java/io/File:delete	()Z
    //   62: pop
    //   63: iload_1
    //   64: iconst_1
    //   65: iadd
    //   66: istore_1
    //   67: goto -44 -> 23
    //   70: aload 12
    //   72: invokevirtual 105	java/io/File:getName	()Ljava/lang/String;
    //   75: astore 10
    //   77: aload 10
    //   79: ifnull -16 -> 63
    //   82: aload 10
    //   84: ldc 243
    //   86: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq -26 -> 63
    //   92: aload 12
    //   94: invokevirtual 247	java/io/File:length	()J
    //   97: lstore 4
    //   99: lload 4
    //   101: lconst_0
    //   102: lcmp
    //   103: ifle +12 -> 115
    //   106: lload 4
    //   108: ldc2_w 248
    //   111: lcmp
    //   112: ifle +12 -> 124
    //   115: aload 12
    //   117: invokevirtual 102	java/io/File:delete	()Z
    //   120: pop
    //   121: goto -58 -> 63
    //   124: aload 10
    //   126: ifnull -63 -> 63
    //   129: lload 4
    //   131: l2i
    //   132: newarray byte
    //   134: astore 9
    //   136: aload 9
    //   138: ifnonnull +12 -> 150
    //   141: aload 12
    //   143: invokevirtual 102	java/io/File:delete	()Z
    //   146: pop
    //   147: goto -84 -> 63
    //   150: iconst_1
    //   151: istore_3
    //   152: aconst_null
    //   153: astore 8
    //   155: aconst_null
    //   156: astore 7
    //   158: new 251	java/io/FileInputStream
    //   161: dup
    //   162: aload 12
    //   164: invokespecial 254	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   167: astore 6
    //   169: aload 6
    //   171: aload 9
    //   173: invokevirtual 258	java/io/FileInputStream:read	([B)I
    //   176: pop
    //   177: iload_3
    //   178: istore_2
    //   179: aload 6
    //   181: ifnull +10 -> 191
    //   184: aload 6
    //   186: invokevirtual 261	java/io/FileInputStream:close	()V
    //   189: iload_3
    //   190: istore_2
    //   191: iload_2
    //   192: ifeq +9 -> 201
    //   195: aload 9
    //   197: arraylength
    //   198: ifgt +115 -> 313
    //   201: aload 12
    //   203: invokevirtual 102	java/io/File:delete	()Z
    //   206: pop
    //   207: goto -144 -> 63
    //   210: astore 6
    //   212: iconst_0
    //   213: istore_2
    //   214: goto -23 -> 191
    //   217: astore 6
    //   219: aconst_null
    //   220: astore 6
    //   222: aload 6
    //   224: ifnull +8 -> 232
    //   227: aload 6
    //   229: invokevirtual 261	java/io/FileInputStream:close	()V
    //   232: aload 12
    //   234: invokevirtual 102	java/io/File:delete	()Z
    //   237: pop
    //   238: goto -175 -> 63
    //   241: astore 6
    //   243: aload 7
    //   245: astore 6
    //   247: aload 6
    //   249: ifnull +8 -> 257
    //   252: aload 6
    //   254: invokevirtual 261	java/io/FileInputStream:close	()V
    //   257: aload 12
    //   259: invokevirtual 102	java/io/File:delete	()Z
    //   262: pop
    //   263: goto -200 -> 63
    //   266: astore 6
    //   268: aload 8
    //   270: astore 7
    //   272: aload 7
    //   274: ifnull +8 -> 282
    //   277: aload 7
    //   279: invokevirtual 261	java/io/FileInputStream:close	()V
    //   282: iconst_1
    //   283: istore_2
    //   284: iload_2
    //   285: ifeq +9 -> 294
    //   288: aload 9
    //   290: arraylength
    //   291: ifgt +19 -> 310
    //   294: aload 12
    //   296: invokevirtual 102	java/io/File:delete	()Z
    //   299: pop
    //   300: goto -237 -> 63
    //   303: astore 7
    //   305: iconst_0
    //   306: istore_2
    //   307: goto -23 -> 284
    //   310: aload 6
    //   312: athrow
    //   313: aload 9
    //   315: ldc_w 263
    //   318: new 265	SharpSvrPack/SharpVideoMsg
    //   321: dup
    //   322: invokespecial 266	SharpSvrPack/SharpVideoMsg:<init>	()V
    //   325: invokestatic 272	mqq/app/Packet:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: checkcast 265	SharpSvrPack/SharpVideoMsg
    //   331: astore 7
    //   333: iconst_1
    //   334: istore_2
    //   335: iload_2
    //   336: ifeq +39 -> 375
    //   339: aload 7
    //   341: ifnull +34 -> 375
    //   344: aload 7
    //   346: getfield 275	SharpSvrPack/SharpVideoMsg:msg_type	J
    //   349: ldc2_w 276
    //   352: lcmp
    //   353: ifne +22 -> 375
    //   356: aload 7
    //   358: getfield 281	SharpSvrPack/SharpVideoMsg:to_uin	Ljava/util/ArrayList;
    //   361: ifnull +14 -> 375
    //   364: aload 7
    //   366: getfield 281	SharpSvrPack/SharpVideoMsg:to_uin	Ljava/util/ArrayList;
    //   369: invokevirtual 176	java/util/ArrayList:size	()I
    //   372: ifgt +22 -> 394
    //   375: aload 12
    //   377: invokevirtual 102	java/io/File:delete	()Z
    //   380: pop
    //   381: goto -318 -> 63
    //   384: astore 6
    //   386: iconst_0
    //   387: istore_2
    //   388: aconst_null
    //   389: astore 7
    //   391: goto -56 -> 335
    //   394: aload 10
    //   396: iconst_0
    //   397: aload 10
    //   399: ldc 151
    //   401: invokevirtual 155	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   404: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   407: astore 6
    //   409: aload 10
    //   411: aload 10
    //   413: ldc 151
    //   415: invokevirtual 155	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   418: iconst_1
    //   419: iadd
    //   420: aload 10
    //   422: ldc 151
    //   424: invokevirtual 284	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   427: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   430: astore 9
    //   432: aload 10
    //   434: aload 10
    //   436: ldc 151
    //   438: invokevirtual 284	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   441: iconst_1
    //   442: iadd
    //   443: aload 10
    //   445: ldc_w 286
    //   448: invokevirtual 155	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   451: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   454: astore 8
    //   456: aload 6
    //   458: ifnull +13 -> 471
    //   461: aload 9
    //   463: ifnull +8 -> 471
    //   466: aload 8
    //   468: ifnonnull +68 -> 536
    //   471: aload 12
    //   473: invokevirtual 102	java/io/File:delete	()Z
    //   476: pop
    //   477: goto -414 -> 63
    //   480: astore 6
    //   482: aload 12
    //   484: invokevirtual 102	java/io/File:delete	()Z
    //   487: pop
    //   488: goto -425 -> 63
    //   491: astore 6
    //   493: aload 12
    //   495: invokevirtual 102	java/io/File:delete	()Z
    //   498: pop
    //   499: goto -436 -> 63
    //   502: astore 6
    //   504: aconst_null
    //   505: astore 8
    //   507: aconst_null
    //   508: astore 7
    //   510: aload 8
    //   512: ifnull +12 -> 524
    //   515: aload 7
    //   517: ifnull +7 -> 524
    //   520: iconst_0
    //   521: ifne +12 -> 533
    //   524: aload 12
    //   526: invokevirtual 102	java/io/File:delete	()Z
    //   529: pop
    //   530: goto -467 -> 63
    //   533: aload 6
    //   535: athrow
    //   536: ldc 186
    //   538: aload 6
    //   540: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   543: ifeq +75 -> 618
    //   546: ldc 186
    //   548: astore 6
    //   550: aload 9
    //   552: invokestatic 291	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   555: invokevirtual 294	java/lang/Long:longValue	()J
    //   558: lstore 4
    //   560: aload 8
    //   562: invokestatic 299	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   565: invokevirtual 302	java/lang/Integer:intValue	()I
    //   568: istore_2
    //   569: aload_0
    //   570: aload 6
    //   572: aload 7
    //   574: getfield 275	SharpSvrPack/SharpVideoMsg:msg_type	J
    //   577: aload 7
    //   579: getfield 305	SharpSvrPack/SharpVideoMsg:msg_seq	J
    //   582: lload 4
    //   584: aload 7
    //   586: getfield 281	SharpSvrPack/SharpVideoMsg:to_uin	Ljava/util/ArrayList;
    //   589: iconst_0
    //   590: invokevirtual 180	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   593: checkcast 288	java/lang/Long
    //   596: invokevirtual 294	java/lang/Long:longValue	()J
    //   599: aload 7
    //   601: getfield 308	SharpSvrPack/SharpVideoMsg:from_uin	J
    //   604: iload_2
    //   605: invokevirtual 311	itm:a	(Ljava/lang/String;JJJJJI)Z
    //   608: pop
    //   609: aload 12
    //   611: invokevirtual 102	java/io/File:delete	()Z
    //   614: pop
    //   615: goto -552 -> 63
    //   618: ldc_w 313
    //   621: aload 6
    //   623: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   626: ifeq +11 -> 637
    //   629: ldc_w 313
    //   632: astore 6
    //   634: goto -84 -> 550
    //   637: ldc_w 315
    //   640: aload 6
    //   642: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   645: ifeq +11 -> 656
    //   648: ldc_w 315
    //   651: astore 6
    //   653: goto -103 -> 550
    //   656: ldc_w 317
    //   659: aload 6
    //   661: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifeq +11 -> 675
    //   667: ldc_w 317
    //   670: astore 6
    //   672: goto -122 -> 550
    //   675: ldc_w 319
    //   678: aload 6
    //   680: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   683: ifeq +11 -> 694
    //   686: ldc_w 319
    //   689: astore 6
    //   691: goto -141 -> 550
    //   694: aload 12
    //   696: invokevirtual 102	java/io/File:delete	()Z
    //   699: pop
    //   700: goto -637 -> 63
    //   703: astore 6
    //   705: aload 12
    //   707: invokevirtual 102	java/io/File:delete	()Z
    //   710: pop
    //   711: goto -648 -> 63
    //   714: astore 6
    //   716: aload 6
    //   718: athrow
    //   719: astore 6
    //   721: goto -489 -> 232
    //   724: astore 6
    //   726: goto -469 -> 257
    //   729: astore 9
    //   731: aload 6
    //   733: astore 8
    //   735: aconst_null
    //   736: astore 7
    //   738: aload 9
    //   740: astore 6
    //   742: goto -232 -> 510
    //   745: astore 10
    //   747: aload 6
    //   749: astore 8
    //   751: aload 9
    //   753: astore 7
    //   755: aload 10
    //   757: astore 6
    //   759: goto -249 -> 510
    //   762: astore 6
    //   764: goto -271 -> 493
    //   767: astore 6
    //   769: goto -276 -> 493
    //   772: astore 6
    //   774: goto -292 -> 482
    //   777: astore 6
    //   779: goto -297 -> 482
    //   782: astore 8
    //   784: aload 6
    //   786: astore 7
    //   788: aload 8
    //   790: astore 6
    //   792: goto -520 -> 272
    //   795: astore 7
    //   797: goto -550 -> 247
    //   800: astore 7
    //   802: goto -580 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	805	0	this	itm
    //   22	45	1	i	int
    //   178	427	2	j	int
    //   151	39	3	k	int
    //   97	486	4	l	long
    //   167	18	6	localFileInputStream	java.io.FileInputStream
    //   210	1	6	localIOException1	java.io.IOException
    //   217	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   220	8	6	localObject1	Object
    //   241	1	6	localIOException2	java.io.IOException
    //   245	8	6	localObject2	Object
    //   266	45	6	localObject3	Object
    //   384	1	6	localException1	java.lang.Exception
    //   407	50	6	str1	String
    //   480	1	6	localIndexOutOfBoundsException1	java.lang.IndexOutOfBoundsException
    //   491	1	6	localNullPointerException1	java.lang.NullPointerException
    //   502	37	6	localObject4	Object
    //   548	142	6	str2	String
    //   703	1	6	localException2	java.lang.Exception
    //   714	3	6	localObject5	Object
    //   719	1	6	localIOException3	java.io.IOException
    //   724	8	6	localIOException4	java.io.IOException
    //   740	18	6	localObject6	Object
    //   762	1	6	localNullPointerException2	java.lang.NullPointerException
    //   767	1	6	localNullPointerException3	java.lang.NullPointerException
    //   772	1	6	localIndexOutOfBoundsException2	java.lang.IndexOutOfBoundsException
    //   777	8	6	localIndexOutOfBoundsException3	java.lang.IndexOutOfBoundsException
    //   790	1	6	localObject7	Object
    //   156	122	7	localObject8	Object
    //   303	1	7	localIOException5	java.io.IOException
    //   331	456	7	localObject9	Object
    //   795	1	7	localIOException6	java.io.IOException
    //   800	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   153	597	8	localObject10	Object
    //   782	7	8	localObject11	Object
    //   134	417	9	localObject12	Object
    //   729	23	9	localObject13	Object
    //   75	369	10	str3	String
    //   745	11	10	localObject14	Object
    //   13	18	11	arrayOfFile	File[]
    //   34	672	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   184	189	210	java/io/IOException
    //   158	169	217	java/io/FileNotFoundException
    //   158	169	241	java/io/IOException
    //   158	169	266	finally
    //   277	282	303	java/io/IOException
    //   313	333	384	java/lang/Exception
    //   394	409	480	java/lang/IndexOutOfBoundsException
    //   394	409	491	java/lang/NullPointerException
    //   394	409	502	finally
    //   550	569	703	java/lang/Exception
    //   550	569	714	finally
    //   227	232	719	java/io/IOException
    //   252	257	724	java/io/IOException
    //   409	432	729	finally
    //   432	456	745	finally
    //   409	432	762	java/lang/NullPointerException
    //   432	456	767	java/lang/NullPointerException
    //   409	432	772	java/lang/IndexOutOfBoundsException
    //   432	456	777	java/lang/IndexOutOfBoundsException
    //   169	177	782	finally
    //   169	177	795	java/io/IOException
    //   169	177	800	java/io/FileNotFoundException
  }
  
  private void bd(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
        paramString1 = (String)this.aL.get(paramString1 + "_" + paramString2);
      } while (paramString1 == null);
      paramString1 = new File(msfReportLogPath + paramString1);
    } while ((paramString1 == null) || (!paramString1.exists()));
    paramString1.delete();
  }
  
  private String dt(String paramString)
  {
    long l = 0L;
    VideoSerializeData localVideoSerializeData = (VideoSerializeData)this.map.get(paramString + "_" + "eMSFRecvInviteMsg");
    String str;
    if (localVideoSerializeData != null) {
      if (localVideoSerializeData.errCode == 0)
      {
        str = "" + "|STEP1_1_0_0";
        l = localVideoSerializeData.time;
        label80:
        localVideoSerializeData = (VideoSerializeData)this.map.get(paramString + "_" + "eMSFTransferInviteMsg");
        if (localVideoSerializeData == null) {
          break label749;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label700;
        }
        str = str + "|STEP2_1_0_" + (localVideoSerializeData.time - l);
        label163:
        l = localVideoSerializeData.time;
        label169:
        localVideoSerializeData = (VideoSerializeData)this.map.get(paramString + "_" + "eVideoAddMsg");
        if (localVideoSerializeData == null) {
          break label824;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label775;
        }
        str = str + "|STEP3_1_0_" + (localVideoSerializeData.time - l);
        label252:
        l = localVideoSerializeData.time;
        label258:
        localVideoSerializeData = (VideoSerializeData)this.map.get(paramString + "_" + "eVideoMSFReceiverProcess");
        if (localVideoSerializeData == null) {
          break label899;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label850;
        }
        str = str + "|STEP4_1_0_" + (localVideoSerializeData.time - l);
        label341:
        l = localVideoSerializeData.time;
        label347:
        localVideoSerializeData = (VideoSerializeData)this.map.get(paramString + "_" + "eVideoRecvInviteMsg");
        if (localVideoSerializeData == null) {
          break label974;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label925;
        }
        str = str + "|STEP5_1_0_" + (localVideoSerializeData.time - l);
        label430:
        l = localVideoSerializeData.time;
        label436:
        localVideoSerializeData = (VideoSerializeData)this.map.get(paramString + "_" + "eVideoSendACK");
        if (localVideoSerializeData == null) {
          break label1049;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label1000;
        }
        str = str + "|STEP6_1_0_" + (localVideoSerializeData.time - l);
        label519:
        l = localVideoSerializeData.time;
        label525:
        localVideoSerializeData = (VideoSerializeData)this.map.get(paramString + "_" + "eMSFSendVideoACK");
        if (localVideoSerializeData == null) {
          break label1123;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label1075;
        }
        paramString = str + "|STEP7_1_0_" + (localVideoSerializeData.time - l);
        label607:
        l = localVideoSerializeData.time;
      }
    }
    for (;;)
    {
      return paramString + "|";
      str = "" + "|STEP1_2_" + localVideoSerializeData.errCode + "_0";
      break;
      str = "" + "|STEP1_0_0_0";
      break label80;
      label700:
      str = str + "|STEP2_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label163;
      label749:
      str = str + "|STEP2_1_0_0";
      break label169;
      label775:
      str = str + "|STEP3_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label252;
      label824:
      str = str + "|STEP3_0_0_0";
      break label258;
      label850:
      str = str + "|STEP4_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label341;
      label899:
      str = str + "|STEP4_0_0_0";
      break label347;
      label925:
      str = str + "|STEP5_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label430;
      label974:
      str = str + "|STEP5_0_0_0";
      break label436;
      label1000:
      str = str + "|STEP6_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label519;
      label1049:
      str = str + "|STEP6_0_0_0";
      break label525;
      label1075:
      paramString = str + "|STEP7_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l);
      break label607;
      label1123:
      paramString = str + "|STEP7_0_0_0";
    }
  }
  
  private void jA(String paramString)
  {
    bd(paramString, "eMSFRecvInviteMsg");
    bd(paramString, "eMSFTransferInviteMsg");
    bd(paramString, "eVideoAddMsg");
    bd(paramString, "eVideoMSFReceiverProcess");
    bd(paramString, "eVideoRecvInviteMsg");
    bd(paramString, "eVideoSendACK");
    bd(paramString, "eMSFSendVideoACK");
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      do
      {
        return;
      } while (((!paramString.equals("eVideoRecvInviteMsg")) && (!paramString.equals("eVideoSendACK"))) || (!Environment.getExternalStorageState().equals("mounted")));
      localFile = new File(msfReportLogPath);
    } while ((!localFile.exists()) && (!localFile.mkdirs()));
    a(paramString, paramLong1, paramLong2, SystemClock.elapsedRealtime(), paramLong3, paramLong4, paramInt);
  }
  
  /* Error */
  boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +9 -> 13
    //   7: iconst_0
    //   8: istore 13
    //   10: iload 13
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 19
    //   16: aconst_null
    //   17: astore 18
    //   19: aload_1
    //   20: ldc 186
    //   22: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifne +63 -> 88
    //   28: aload_1
    //   29: ldc_w 313
    //   32: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifne +53 -> 88
    //   38: aload_1
    //   39: ldc_w 315
    //   42: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifne +43 -> 88
    //   48: aload_1
    //   49: ldc_w 317
    //   52: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifne +33 -> 88
    //   58: aload_1
    //   59: ldc_w 343
    //   62: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifne +23 -> 88
    //   68: aload_1
    //   69: ldc_w 347
    //   72: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifne +13 -> 88
    //   78: aload_1
    //   79: ldc_w 319
    //   82: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +812 -> 897
    //   88: new 52	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   95: aload_1
    //   96: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 151
    //   101: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokestatic 402	android/os/SystemClock:elapsedRealtime	()J
    //   107: invokestatic 166	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   110: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload 12
    //   115: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: ldc 113
    //   120: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 17
    //   128: ldc 27
    //   130: aload 17
    //   132: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +5 -> 140
    //   138: iconst_0
    //   139: ireturn
    //   140: new 194	com/tencent/av/report/VideoSerializeData
    //   143: dup
    //   144: aload_1
    //   145: lload_2
    //   146: lload 4
    //   148: lload 6
    //   150: lload 8
    //   152: lload 10
    //   154: iload 12
    //   156: invokespecial 405	com/tencent/av/report/VideoSerializeData:<init>	(Ljava/lang/String;JJJJJI)V
    //   159: astore 24
    //   161: aload 24
    //   163: ifnonnull +5 -> 168
    //   166: iconst_0
    //   167: ireturn
    //   168: aconst_null
    //   169: astore 21
    //   171: aconst_null
    //   172: astore 20
    //   174: aconst_null
    //   175: astore 23
    //   177: aconst_null
    //   178: astore 22
    //   180: new 61	java/io/File
    //   183: dup
    //   184: new 52	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   191: getstatic 29	itm:msfReportLogPath	Ljava/lang/String;
    //   194: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 17
    //   199: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   208: astore 15
    //   210: new 407	java/io/FileOutputStream
    //   213: dup
    //   214: aload 15
    //   216: invokespecial 408	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   219: astore_1
    //   220: aload 15
    //   222: invokevirtual 247	java/io/File:length	()J
    //   225: lstore_2
    //   226: lload_2
    //   227: l2i
    //   228: istore 12
    //   230: iload 12
    //   232: i2l
    //   233: lload_2
    //   234: lcmp
    //   235: ifne +653 -> 888
    //   238: new 410	java/io/ByteArrayOutputStream
    //   241: dup
    //   242: iload 12
    //   244: invokespecial 413	java/io/ByteArrayOutputStream:<init>	(I)V
    //   247: astore 15
    //   249: new 415	java/io/ObjectOutputStream
    //   252: dup
    //   253: aload 15
    //   255: invokespecial 418	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   258: astore 16
    //   260: aload 16
    //   262: aload 24
    //   264: invokevirtual 422	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   267: aload 16
    //   269: invokevirtual 425	java/io/ObjectOutputStream:flush	()V
    //   272: aload 15
    //   274: aload_1
    //   275: invokevirtual 428	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   278: aload 15
    //   280: invokevirtual 429	java/io/ByteArrayOutputStream:flush	()V
    //   283: aload 16
    //   285: ifnull +8 -> 293
    //   288: aload 16
    //   290: invokevirtual 430	java/io/ObjectOutputStream:close	()V
    //   293: iconst_1
    //   294: istore 14
    //   296: iload 14
    //   298: istore 13
    //   300: aload 15
    //   302: ifnull +12 -> 314
    //   305: aload 15
    //   307: invokevirtual 431	java/io/ByteArrayOutputStream:close	()V
    //   310: iload 14
    //   312: istore 13
    //   314: iload 13
    //   316: istore 14
    //   318: aload_1
    //   319: ifnull +11 -> 330
    //   322: aload_1
    //   323: invokevirtual 432	java/io/FileOutputStream:close	()V
    //   326: iload 13
    //   328: istore 14
    //   330: iload 14
    //   332: istore 13
    //   334: iload 14
    //   336: ifne -326 -> 10
    //   339: new 61	java/io/File
    //   342: dup
    //   343: new 52	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   350: getstatic 29	itm:msfReportLogPath	Ljava/lang/String;
    //   353: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 17
    //   358: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   367: astore_1
    //   368: iload 14
    //   370: istore 13
    //   372: aload_1
    //   373: ifnull -363 -> 10
    //   376: iload 14
    //   378: istore 13
    //   380: aload_1
    //   381: invokevirtual 99	java/io/File:exists	()Z
    //   384: ifeq -374 -> 10
    //   387: aload_1
    //   388: invokevirtual 102	java/io/File:delete	()Z
    //   391: pop
    //   392: iload 14
    //   394: ireturn
    //   395: astore 16
    //   397: iconst_0
    //   398: istore 14
    //   400: goto -104 -> 296
    //   403: astore 15
    //   405: iconst_0
    //   406: istore 13
    //   408: goto -94 -> 314
    //   411: astore_1
    //   412: iconst_0
    //   413: istore 14
    //   415: goto -85 -> 330
    //   418: astore_1
    //   419: aconst_null
    //   420: astore_1
    //   421: aconst_null
    //   422: astore 15
    //   424: aconst_null
    //   425: astore 16
    //   427: aload 16
    //   429: ifnull +8 -> 437
    //   432: aload 16
    //   434: invokevirtual 430	java/io/ObjectOutputStream:close	()V
    //   437: aload 15
    //   439: ifnull +443 -> 882
    //   442: aload 15
    //   444: invokevirtual 431	java/io/ByteArrayOutputStream:close	()V
    //   447: iconst_0
    //   448: istore 13
    //   450: aload_1
    //   451: ifnull +424 -> 875
    //   454: aload_1
    //   455: invokevirtual 432	java/io/FileOutputStream:close	()V
    //   458: iload 13
    //   460: istore 14
    //   462: new 61	java/io/File
    //   465: dup
    //   466: new 52	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   473: getstatic 29	itm:msfReportLogPath	Ljava/lang/String;
    //   476: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload 17
    //   481: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   490: astore_1
    //   491: iload 14
    //   493: istore 13
    //   495: aload_1
    //   496: ifnull -486 -> 10
    //   499: iload 14
    //   501: istore 13
    //   503: aload_1
    //   504: invokevirtual 99	java/io/File:exists	()Z
    //   507: ifeq -497 -> 10
    //   510: aload_1
    //   511: invokevirtual 102	java/io/File:delete	()Z
    //   514: pop
    //   515: iload 14
    //   517: ireturn
    //   518: astore 16
    //   520: goto -83 -> 437
    //   523: astore 15
    //   525: iconst_0
    //   526: istore 13
    //   528: goto -78 -> 450
    //   531: astore_1
    //   532: iconst_0
    //   533: istore 14
    //   535: goto -73 -> 462
    //   538: astore_1
    //   539: aload 18
    //   541: astore 16
    //   543: aload 20
    //   545: astore 15
    //   547: aload 22
    //   549: astore_1
    //   550: aload 16
    //   552: ifnull +8 -> 560
    //   555: aload 16
    //   557: invokevirtual 430	java/io/ObjectOutputStream:close	()V
    //   560: aload 15
    //   562: ifnull +8 -> 570
    //   565: aload 15
    //   567: invokevirtual 431	java/io/ByteArrayOutputStream:close	()V
    //   570: aload_1
    //   571: ifnull +7 -> 578
    //   574: aload_1
    //   575: invokevirtual 432	java/io/FileOutputStream:close	()V
    //   578: iconst_0
    //   579: istore 14
    //   581: new 61	java/io/File
    //   584: dup
    //   585: new 52	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   592: getstatic 29	itm:msfReportLogPath	Ljava/lang/String;
    //   595: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload 17
    //   600: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   609: astore_1
    //   610: iload 14
    //   612: istore 13
    //   614: aload_1
    //   615: ifnull -605 -> 10
    //   618: iload 14
    //   620: istore 13
    //   622: aload_1
    //   623: invokevirtual 99	java/io/File:exists	()Z
    //   626: ifeq -616 -> 10
    //   629: aload_1
    //   630: invokevirtual 102	java/io/File:delete	()Z
    //   633: pop
    //   634: iconst_0
    //   635: ireturn
    //   636: astore 16
    //   638: goto -78 -> 560
    //   641: astore 15
    //   643: goto -73 -> 570
    //   646: astore_1
    //   647: goto -69 -> 578
    //   650: astore_1
    //   651: aload 19
    //   653: astore 16
    //   655: aload 21
    //   657: astore 15
    //   659: aload 23
    //   661: astore_1
    //   662: aload 16
    //   664: ifnull +8 -> 672
    //   667: aload 16
    //   669: invokevirtual 430	java/io/ObjectOutputStream:close	()V
    //   672: iconst_1
    //   673: istore 14
    //   675: iload 14
    //   677: istore 13
    //   679: aload 15
    //   681: ifnull +12 -> 693
    //   684: aload 15
    //   686: invokevirtual 431	java/io/ByteArrayOutputStream:close	()V
    //   689: iload 14
    //   691: istore 13
    //   693: iload 13
    //   695: istore 14
    //   697: aload_1
    //   698: ifnull +11 -> 709
    //   701: aload_1
    //   702: invokevirtual 432	java/io/FileOutputStream:close	()V
    //   705: iload 13
    //   707: istore 14
    //   709: iload 14
    //   711: istore 13
    //   713: iload 14
    //   715: ifne -705 -> 10
    //   718: new 61	java/io/File
    //   721: dup
    //   722: new 52	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   729: getstatic 29	itm:msfReportLogPath	Ljava/lang/String;
    //   732: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 17
    //   737: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   746: astore_1
    //   747: iload 14
    //   749: istore 13
    //   751: aload_1
    //   752: ifnull -742 -> 10
    //   755: iload 14
    //   757: istore 13
    //   759: aload_1
    //   760: invokevirtual 99	java/io/File:exists	()Z
    //   763: ifeq -753 -> 10
    //   766: aload_1
    //   767: invokevirtual 102	java/io/File:delete	()Z
    //   770: pop
    //   771: iload 14
    //   773: ireturn
    //   774: astore 16
    //   776: iconst_0
    //   777: istore 14
    //   779: goto -104 -> 675
    //   782: astore 15
    //   784: iconst_0
    //   785: istore 13
    //   787: goto -94 -> 693
    //   790: astore_1
    //   791: iconst_0
    //   792: istore 14
    //   794: goto -85 -> 709
    //   797: astore 15
    //   799: aload 21
    //   801: astore 15
    //   803: aload 19
    //   805: astore 16
    //   807: goto -145 -> 662
    //   810: astore 16
    //   812: aload 19
    //   814: astore 16
    //   816: goto -154 -> 662
    //   819: astore 18
    //   821: goto -159 -> 662
    //   824: astore 15
    //   826: aload 20
    //   828: astore 15
    //   830: aload 18
    //   832: astore 16
    //   834: goto -284 -> 550
    //   837: astore 16
    //   839: aload 18
    //   841: astore 16
    //   843: goto -293 -> 550
    //   846: astore 18
    //   848: goto -298 -> 550
    //   851: astore 15
    //   853: aconst_null
    //   854: astore 16
    //   856: aconst_null
    //   857: astore 15
    //   859: goto -432 -> 427
    //   862: astore 16
    //   864: aconst_null
    //   865: astore 16
    //   867: goto -440 -> 427
    //   870: astore 18
    //   872: goto -445 -> 427
    //   875: iload 13
    //   877: istore 14
    //   879: goto -417 -> 462
    //   882: iconst_0
    //   883: istore 13
    //   885: goto -435 -> 450
    //   888: aconst_null
    //   889: astore 15
    //   891: aconst_null
    //   892: astore 16
    //   894: goto -611 -> 283
    //   897: ldc 27
    //   899: astore 17
    //   901: goto -773 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	904	0	this	itm
    //   0	904	1	paramString	String
    //   0	904	2	paramLong1	long
    //   0	904	4	paramLong2	long
    //   0	904	6	paramLong3	long
    //   0	904	8	paramLong4	long
    //   0	904	10	paramLong5	long
    //   0	904	12	paramInt	int
    //   8	876	13	bool1	boolean
    //   294	584	14	bool2	boolean
    //   208	98	15	localObject1	Object
    //   403	1	15	localIOException1	java.io.IOException
    //   422	21	15	localObject2	Object
    //   523	1	15	localIOException2	java.io.IOException
    //   545	21	15	localObject3	Object
    //   641	1	15	localIOException3	java.io.IOException
    //   657	28	15	localObject4	Object
    //   782	1	15	localIOException4	java.io.IOException
    //   797	1	15	localObject5	Object
    //   801	1	15	localObject6	Object
    //   824	1	15	localIOException5	java.io.IOException
    //   828	1	15	localObject7	Object
    //   851	1	15	localFileNotFoundException1	java.io.FileNotFoundException
    //   857	33	15	localObject8	Object
    //   258	31	16	localObjectOutputStream	java.io.ObjectOutputStream
    //   395	1	16	localException1	java.lang.Exception
    //   425	8	16	localObject9	Object
    //   518	1	16	localException2	java.lang.Exception
    //   541	15	16	localObject10	Object
    //   636	1	16	localException3	java.lang.Exception
    //   653	15	16	localObject11	Object
    //   774	1	16	localException4	java.lang.Exception
    //   805	1	16	localObject12	Object
    //   810	1	16	localObject13	Object
    //   814	19	16	localObject14	Object
    //   837	1	16	localIOException6	java.io.IOException
    //   841	14	16	localObject15	Object
    //   862	1	16	localFileNotFoundException2	java.io.FileNotFoundException
    //   865	28	16	localObject16	Object
    //   126	774	17	str	String
    //   17	523	18	localObject17	Object
    //   819	21	18	localObject18	Object
    //   846	1	18	localIOException7	java.io.IOException
    //   870	1	18	localFileNotFoundException3	java.io.FileNotFoundException
    //   14	799	19	localObject19	Object
    //   172	655	20	localObject20	Object
    //   169	631	21	localObject21	Object
    //   178	370	22	localObject22	Object
    //   175	485	23	localObject23	Object
    //   159	104	24	localVideoSerializeData	VideoSerializeData
    // Exception table:
    //   from	to	target	type
    //   288	293	395	java/lang/Exception
    //   305	310	403	java/io/IOException
    //   322	326	411	java/io/IOException
    //   180	220	418	java/io/FileNotFoundException
    //   432	437	518	java/lang/Exception
    //   442	447	523	java/io/IOException
    //   454	458	531	java/io/IOException
    //   180	220	538	java/io/IOException
    //   555	560	636	java/lang/Exception
    //   565	570	641	java/io/IOException
    //   574	578	646	java/io/IOException
    //   180	220	650	finally
    //   667	672	774	java/lang/Exception
    //   684	689	782	java/io/IOException
    //   701	705	790	java/io/IOException
    //   220	226	797	finally
    //   238	249	797	finally
    //   249	260	810	finally
    //   260	283	819	finally
    //   220	226	824	java/io/IOException
    //   238	249	824	java/io/IOException
    //   249	260	837	java/io/IOException
    //   260	283	846	java/io/IOException
    //   220	226	851	java/io/FileNotFoundException
    //   238	249	851	java/io/FileNotFoundException
    //   249	260	862	java/io/FileNotFoundException
    //   260	283	870	java/io/FileNotFoundException
  }
  
  public void aqB()
  {
    new Thread(new VideoConnRateReport.1(this)).start();
  }
  
  public void aqC()
  {
    if (!this.isReported)
    {
      this.isReported = true;
      new Thread(new VideoConnRateReport.2(this)).start();
    }
  }
  
  public void cx(long paramLong)
  {
    this.oc = paramLong;
  }
  
  /* Error */
  boolean l(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: new 459	java/io/ByteArrayInputStream
    //   15: dup
    //   16: new 61	java/io/File
    //   19: dup
    //   20: new 52	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   27: getstatic 29	itm:msfReportLogPath	Ljava/lang/String;
    //   30: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: invokestatic 465	rox:d	(Ljava/io/File;)[B
    //   46: invokespecial 468	java/io/ByteArrayInputStream:<init>	([B)V
    //   49: astore 5
    //   51: new 470	java/io/ObjectInputStream
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 473	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +13 -> 77
    //   67: aload 6
    //   69: invokevirtual 476	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   72: checkcast 194	com/tencent/av/report/VideoSerializeData
    //   75: astore 7
    //   77: aload 5
    //   79: ifnull +463 -> 542
    //   82: aload 5
    //   84: invokevirtual 477	java/io/ByteArrayInputStream:close	()V
    //   87: iconst_1
    //   88: istore_3
    //   89: aload 6
    //   91: ifnull +8 -> 99
    //   94: aload 6
    //   96: invokevirtual 478	java/io/ObjectInputStream:close	()V
    //   99: aload 7
    //   101: ifnonnull +16 -> 117
    //   104: iconst_0
    //   105: istore 4
    //   107: iload 4
    //   109: ireturn
    //   110: astore 5
    //   112: iconst_0
    //   113: istore_3
    //   114: goto -25 -> 89
    //   117: aload 7
    //   119: getfield 481	com/tencent/av/report/VideoSerializeData:msgType	J
    //   122: ldc2_w 276
    //   125: lcmp
    //   126: ifeq +40 -> 166
    //   129: new 61	java/io/File
    //   132: dup
    //   133: aload_1
    //   134: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore_1
    //   138: iload_3
    //   139: istore 4
    //   141: aload_1
    //   142: ifnull -35 -> 107
    //   145: iload_3
    //   146: istore 4
    //   148: aload_1
    //   149: invokevirtual 99	java/io/File:exists	()Z
    //   152: ifeq -45 -> 107
    //   155: aload_1
    //   156: invokevirtual 102	java/io/File:delete	()Z
    //   159: pop
    //   160: iload_3
    //   161: istore 4
    //   163: goto -56 -> 107
    //   166: iload_3
    //   167: istore 4
    //   169: iload_2
    //   170: ifeq -63 -> 107
    //   173: new 52	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   180: aload 7
    //   182: getfield 484	com/tencent/av/report/VideoSerializeData:msgSeq	J
    //   185: invokestatic 166	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   188: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 151
    //   193: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 7
    //   198: getfield 487	com/tencent/av/report/VideoSerializeData:type	Ljava/lang/String;
    //   201: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore 5
    //   209: aload_0
    //   210: getfield 44	itm:map	Ljava/util/concurrent/ConcurrentHashMap;
    //   213: aload 5
    //   215: aload 7
    //   217: invokevirtual 488	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   220: pop
    //   221: aload_0
    //   222: getfield 46	itm:aL	Ljava/util/concurrent/ConcurrentHashMap;
    //   225: aload 5
    //   227: aload_1
    //   228: invokevirtual 488	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: iload_3
    //   233: istore 4
    //   235: goto -128 -> 107
    //   238: astore_1
    //   239: aconst_null
    //   240: astore_1
    //   241: aconst_null
    //   242: astore 5
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 477	java/io/ByteArrayInputStream:close	()V
    //   252: aload 5
    //   254: ifnull +8 -> 262
    //   257: aload 5
    //   259: invokevirtual 478	java/io/ObjectInputStream:close	()V
    //   262: iconst_0
    //   263: ifeq -253 -> 10
    //   266: new 83	java/lang/NullPointerException
    //   269: dup
    //   270: invokespecial 489	java/lang/NullPointerException:<init>	()V
    //   273: athrow
    //   274: astore_1
    //   275: aconst_null
    //   276: astore 5
    //   278: aconst_null
    //   279: astore 6
    //   281: aload 5
    //   283: ifnull +8 -> 291
    //   286: aload 5
    //   288: invokevirtual 477	java/io/ByteArrayInputStream:close	()V
    //   291: aload 6
    //   293: ifnull +8 -> 301
    //   296: aload 6
    //   298: invokevirtual 478	java/io/ObjectInputStream:close	()V
    //   301: iconst_0
    //   302: ifeq -292 -> 10
    //   305: new 83	java/lang/NullPointerException
    //   308: dup
    //   309: invokespecial 489	java/lang/NullPointerException:<init>	()V
    //   312: athrow
    //   313: astore_1
    //   314: aconst_null
    //   315: astore 5
    //   317: aconst_null
    //   318: astore 6
    //   320: aload 5
    //   322: ifnull +8 -> 330
    //   325: aload 5
    //   327: invokevirtual 477	java/io/ByteArrayInputStream:close	()V
    //   330: aload 6
    //   332: ifnull +8 -> 340
    //   335: aload 6
    //   337: invokevirtual 478	java/io/ObjectInputStream:close	()V
    //   340: iconst_0
    //   341: ifeq -331 -> 10
    //   344: new 83	java/lang/NullPointerException
    //   347: dup
    //   348: invokespecial 489	java/lang/NullPointerException:<init>	()V
    //   351: athrow
    //   352: astore_1
    //   353: aconst_null
    //   354: astore 5
    //   356: aconst_null
    //   357: astore 6
    //   359: aload 5
    //   361: ifnull +8 -> 369
    //   364: aload 5
    //   366: invokevirtual 477	java/io/ByteArrayInputStream:close	()V
    //   369: aload 6
    //   371: ifnull +8 -> 379
    //   374: aload 6
    //   376: invokevirtual 478	java/io/ObjectInputStream:close	()V
    //   379: iconst_0
    //   380: ifeq -370 -> 10
    //   383: new 83	java/lang/NullPointerException
    //   386: dup
    //   387: invokespecial 489	java/lang/NullPointerException:<init>	()V
    //   390: athrow
    //   391: astore_1
    //   392: aconst_null
    //   393: astore 5
    //   395: aconst_null
    //   396: astore 6
    //   398: aload 5
    //   400: ifnull +137 -> 537
    //   403: aload 5
    //   405: invokevirtual 477	java/io/ByteArrayInputStream:close	()V
    //   408: iconst_1
    //   409: istore_2
    //   410: aload 6
    //   412: ifnull +8 -> 420
    //   415: aload 6
    //   417: invokevirtual 478	java/io/ObjectInputStream:close	()V
    //   420: iconst_0
    //   421: ifeq -411 -> 10
    //   424: new 83	java/lang/NullPointerException
    //   427: dup
    //   428: invokespecial 489	java/lang/NullPointerException:<init>	()V
    //   431: athrow
    //   432: astore_1
    //   433: iconst_0
    //   434: istore_2
    //   435: goto -25 -> 410
    //   438: astore_1
    //   439: iconst_0
    //   440: ireturn
    //   441: astore_1
    //   442: goto -190 -> 252
    //   445: astore_1
    //   446: iconst_0
    //   447: ireturn
    //   448: astore_1
    //   449: goto -158 -> 291
    //   452: astore_1
    //   453: iconst_0
    //   454: ireturn
    //   455: astore_1
    //   456: goto -126 -> 330
    //   459: astore_1
    //   460: iconst_0
    //   461: ireturn
    //   462: astore_1
    //   463: goto -94 -> 369
    //   466: astore_1
    //   467: iconst_0
    //   468: ireturn
    //   469: astore_1
    //   470: iconst_0
    //   471: ireturn
    //   472: astore_1
    //   473: aconst_null
    //   474: astore 6
    //   476: goto -78 -> 398
    //   479: astore_1
    //   480: goto -82 -> 398
    //   483: astore_1
    //   484: aconst_null
    //   485: astore 6
    //   487: goto -128 -> 359
    //   490: astore_1
    //   491: goto -132 -> 359
    //   494: astore_1
    //   495: aconst_null
    //   496: astore 6
    //   498: goto -178 -> 320
    //   501: astore_1
    //   502: goto -182 -> 320
    //   505: astore_1
    //   506: aconst_null
    //   507: astore 6
    //   509: goto -228 -> 281
    //   512: astore_1
    //   513: goto -232 -> 281
    //   516: astore_1
    //   517: aload 5
    //   519: astore_1
    //   520: aconst_null
    //   521: astore 5
    //   523: goto -279 -> 244
    //   526: astore_1
    //   527: aload 5
    //   529: astore_1
    //   530: aload 6
    //   532: astore 5
    //   534: goto -290 -> 244
    //   537: iconst_1
    //   538: istore_2
    //   539: goto -129 -> 410
    //   542: iconst_1
    //   543: istore_3
    //   544: goto -455 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	this	itm
    //   0	547	1	paramString	String
    //   0	547	2	paramBoolean	boolean
    //   88	456	3	bool1	boolean
    //   105	129	4	bool2	boolean
    //   49	34	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   110	1	5	localIOException	java.io.IOException
    //   207	326	5	localObject	Object
    //   60	471	6	localObjectInputStream	java.io.ObjectInputStream
    //   1	215	7	localVideoSerializeData	VideoSerializeData
    // Exception table:
    //   from	to	target	type
    //   82	87	110	java/io/IOException
    //   12	51	238	java/io/FileNotFoundException
    //   12	51	274	java/io/OptionalDataException
    //   12	51	313	java/lang/ClassNotFoundException
    //   12	51	352	java/io/IOException
    //   12	51	391	finally
    //   403	408	432	java/io/IOException
    //   94	99	438	java/lang/Exception
    //   248	252	441	java/io/IOException
    //   257	262	445	java/lang/Exception
    //   286	291	448	java/io/IOException
    //   296	301	452	java/lang/Exception
    //   325	330	455	java/io/IOException
    //   335	340	459	java/lang/Exception
    //   364	369	462	java/io/IOException
    //   374	379	466	java/lang/Exception
    //   415	420	469	java/lang/Exception
    //   51	62	472	finally
    //   67	77	479	finally
    //   51	62	483	java/io/IOException
    //   67	77	490	java/io/IOException
    //   51	62	494	java/lang/ClassNotFoundException
    //   67	77	501	java/lang/ClassNotFoundException
    //   51	62	505	java/io/OptionalDataException
    //   67	77	512	java/io/OptionalDataException
    //   51	62	516	java/io/FileNotFoundException
    //   67	77	526	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itm
 * JD-Core Version:    0.7.0.1
 */