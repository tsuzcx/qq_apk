import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.secspy.SecSpyFileManager.1;
import com.tencent.mobileqq.secspy.SecSpyFileManager.2;
import com.tencent.mobileqq.unifiedebug.SnapshotResultReceiver;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;

public class amzn
  implements Manager
{
  private static final String ccA = acfp.m(2131714163);
  private static final String ccz = acfp.m(2131714164);
  public apzu a;
  public aqaa a;
  public String ccB = "https://logic.content.qq.com/public/file_upload2?";
  public String ccC = "https://qprostat.imtt.qq.com/";
  public String ccD = ".mgz";
  public Handler jdField_do;
  private Runnable hw;
  public QQAppInterface mApp;
  
  public amzn(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.hw = new SecSpyFileManager.1(this);
    if (paramQQAppInterface.getApplication().getSharedPreferences("x5_proxy_setting", 4).getBoolean("is_in_proxy", false)) {
      ThreadManager.getFileThreadHandler().post(this.hw);
    }
  }
  
  /* Error */
  private void c(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 109	amzn:jdField_a_of_type_Apzu	Lapzu;
    //   5: aload_1
    //   6: invokevirtual 115	apzu:oW	(Ljava/lang/String;)Ljava/lang/String;
    //   9: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   12: astore 9
    //   14: aload 9
    //   16: ifnull +652 -> 668
    //   19: aload 9
    //   21: invokevirtual 125	java/io/File:exists	()Z
    //   24: ifeq +644 -> 668
    //   27: aload 9
    //   29: invokevirtual 128	java/io/File:isFile	()Z
    //   32: ifeq +636 -> 668
    //   35: aload_0
    //   36: lload_3
    //   37: iconst_2
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload 9
    //   46: invokevirtual 132	java/io/File:length	()J
    //   49: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: aastore
    //   53: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: lload_3
    //   58: iconst_3
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: bipush 100
    //   67: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   74: new 148	java/util/HashMap
    //   77: dup
    //   78: invokespecial 149	java/util/HashMap:<init>	()V
    //   81: astore 7
    //   83: aload 7
    //   85: ldc 151
    //   87: aload_2
    //   88: invokeinterface 157 3 0
    //   93: pop
    //   94: aload 7
    //   96: ldc 159
    //   98: ldc 161
    //   100: invokeinterface 157 3 0
    //   105: pop
    //   106: aload 7
    //   108: ldc 163
    //   110: ldc 165
    //   112: invokeinterface 157 3 0
    //   117: pop
    //   118: aload 7
    //   120: ldc 167
    //   122: new 169	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   129: ldc 172
    //   131: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_2
    //   135: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 178
    //   140: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokeinterface 157 3 0
    //   151: pop
    //   152: aconst_null
    //   153: astore 5
    //   155: new 184	java/net/URL
    //   158: dup
    //   159: aload_0
    //   160: getfield 50	amzn:ccC	Ljava/lang/String;
    //   163: invokespecial 187	java/net/URL:<init>	(Ljava/lang/String;)V
    //   166: invokevirtual 191	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   169: checkcast 193	java/net/HttpURLConnection
    //   172: astore_1
    //   173: aload_1
    //   174: iconst_1
    //   175: invokevirtual 197	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   178: aload_1
    //   179: iconst_1
    //   180: invokevirtual 200	java/net/HttpURLConnection:setDoInput	(Z)V
    //   183: aload_1
    //   184: iconst_0
    //   185: invokevirtual 203	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   188: aload_1
    //   189: ldc 205
    //   191: invokevirtual 208	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   194: aload_1
    //   195: ldc 210
    //   197: new 169	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   204: ldc 212
    //   206: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 9
    //   211: invokevirtual 132	java/io/File:length	()J
    //   214: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   217: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokevirtual 219	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_1
    //   224: ldc 221
    //   226: ldc 223
    //   228: invokevirtual 219	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_1
    //   232: ldc 225
    //   234: ldc 227
    //   236: invokevirtual 219	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 7
    //   241: invokeinterface 231 1 0
    //   246: invokeinterface 237 1 0
    //   251: astore_2
    //   252: aload_2
    //   253: invokeinterface 242 1 0
    //   258: ifeq +91 -> 349
    //   261: aload_2
    //   262: invokeinterface 246 1 0
    //   267: checkcast 248	java/lang/String
    //   270: astore 8
    //   272: aload_1
    //   273: aload 8
    //   275: aload 7
    //   277: aload 8
    //   279: invokeinterface 252 2 0
    //   284: checkcast 248	java/lang/String
    //   287: invokevirtual 219	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: goto -38 -> 252
    //   293: astore 5
    //   295: aconst_null
    //   296: astore_2
    //   297: ldc 254
    //   299: iconst_1
    //   300: ldc_w 256
    //   303: aload 5
    //   305: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload_0
    //   309: lload_3
    //   310: iconst_m1
    //   311: iconst_1
    //   312: anewarray 4	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: aload 5
    //   319: invokevirtual 265	java/io/IOException:getMessage	()Ljava/lang/String;
    //   322: aastore
    //   323: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   326: aload_2
    //   327: ifnull +7 -> 334
    //   330: aload_2
    //   331: invokevirtual 270	java/io/OutputStream:close	()V
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   342: aload 9
    //   344: invokevirtual 276	java/io/File:delete	()Z
    //   347: pop
    //   348: return
    //   349: aload_1
    //   350: invokevirtual 280	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   353: astore 7
    //   355: sipush 10240
    //   358: newarray byte
    //   360: astore 8
    //   362: new 282	java/io/FileInputStream
    //   365: dup
    //   366: aload 9
    //   368: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   371: astore 5
    //   373: aload 5
    //   375: astore_2
    //   376: aload 5
    //   378: aload 8
    //   380: iconst_0
    //   381: sipush 10240
    //   384: invokevirtual 289	java/io/FileInputStream:read	([BII)I
    //   387: istore 6
    //   389: iload 6
    //   391: iconst_m1
    //   392: if_icmpeq +96 -> 488
    //   395: aload 5
    //   397: astore_2
    //   398: aload 7
    //   400: aload 8
    //   402: iconst_0
    //   403: iload 6
    //   405: invokevirtual 293	java/io/OutputStream:write	([BII)V
    //   408: goto -35 -> 373
    //   411: astore 8
    //   413: aload 5
    //   415: astore_2
    //   416: aload_0
    //   417: lload_3
    //   418: iconst_m1
    //   419: iconst_1
    //   420: anewarray 4	java/lang/Object
    //   423: dup
    //   424: iconst_0
    //   425: new 169	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 295
    //   435: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 8
    //   440: invokevirtual 296	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   443: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: aastore
    //   450: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   453: aload 5
    //   455: ifnull +8 -> 463
    //   458: aload 5
    //   460: invokevirtual 297	java/io/FileInputStream:close	()V
    //   463: aload 7
    //   465: ifnull +8 -> 473
    //   468: aload 7
    //   470: invokevirtual 270	java/io/OutputStream:close	()V
    //   473: aload_1
    //   474: ifnull -126 -> 348
    //   477: aload_1
    //   478: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   481: return
    //   482: astore_1
    //   483: aload_1
    //   484: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   487: return
    //   488: aload 5
    //   490: ifnull +8 -> 498
    //   493: aload 5
    //   495: invokevirtual 297	java/io/FileInputStream:close	()V
    //   498: aload_1
    //   499: invokevirtual 304	java/net/HttpURLConnection:getResponseCode	()I
    //   502: istore 6
    //   504: iload 6
    //   506: sipush 200
    //   509: if_icmpne +106 -> 615
    //   512: aload_0
    //   513: lload_3
    //   514: iconst_0
    //   515: iconst_0
    //   516: anewarray 4	java/lang/Object
    //   519: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   522: aload 7
    //   524: ifnull +8 -> 532
    //   527: aload 7
    //   529: invokevirtual 270	java/io/OutputStream:close	()V
    //   532: aload_1
    //   533: ifnull -191 -> 342
    //   536: aload_1
    //   537: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   540: goto -198 -> 342
    //   543: astore_1
    //   544: aload_1
    //   545: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   548: goto -206 -> 342
    //   551: astore_2
    //   552: aload_2
    //   553: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   556: goto -58 -> 498
    //   559: astore_2
    //   560: aload_2
    //   561: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   564: goto -101 -> 463
    //   567: astore_2
    //   568: aload 7
    //   570: astore 5
    //   572: aload 5
    //   574: ifnull +8 -> 582
    //   577: aload 5
    //   579: invokevirtual 270	java/io/OutputStream:close	()V
    //   582: aload_1
    //   583: ifnull +7 -> 590
    //   586: aload_1
    //   587: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   590: aload_2
    //   591: athrow
    //   592: astore 5
    //   594: aconst_null
    //   595: astore_2
    //   596: aload_2
    //   597: ifnull +7 -> 604
    //   600: aload_2
    //   601: invokevirtual 297	java/io/FileInputStream:close	()V
    //   604: aload 5
    //   606: athrow
    //   607: astore_2
    //   608: aload_2
    //   609: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   612: goto -8 -> 604
    //   615: aload_0
    //   616: lload_3
    //   617: iconst_m1
    //   618: iconst_1
    //   619: anewarray 4	java/lang/Object
    //   622: dup
    //   623: iconst_0
    //   624: new 169	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 306
    //   634: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: iload 6
    //   639: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   642: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: aastore
    //   646: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   649: goto -127 -> 522
    //   652: astore_1
    //   653: aload_1
    //   654: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   657: goto -315 -> 342
    //   660: astore_1
    //   661: aload_1
    //   662: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   665: goto -75 -> 590
    //   668: aload_0
    //   669: lload_3
    //   670: iconst_m1
    //   671: iconst_1
    //   672: anewarray 4	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: ldc_w 311
    //   680: aastore
    //   681: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   684: return
    //   685: astore_2
    //   686: aconst_null
    //   687: astore_1
    //   688: goto -116 -> 572
    //   691: astore_2
    //   692: goto -120 -> 572
    //   695: astore 7
    //   697: aload_2
    //   698: astore 5
    //   700: aload 7
    //   702: astore_2
    //   703: goto -131 -> 572
    //   706: astore 5
    //   708: aconst_null
    //   709: astore_1
    //   710: aconst_null
    //   711: astore_2
    //   712: goto -415 -> 297
    //   715: astore 5
    //   717: goto -121 -> 596
    //   720: astore 8
    //   722: aconst_null
    //   723: astore 5
    //   725: goto -312 -> 413
    //   728: astore 5
    //   730: aload 7
    //   732: astore_2
    //   733: goto -436 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	736	0	this	amzn
    //   0	736	1	paramString1	String
    //   0	736	2	paramString2	String
    //   0	736	3	paramLong	long
    //   0	736	5	paramString3	String
    //   387	251	6	i	int
    //   81	488	7	localObject1	Object
    //   695	36	7	localObject2	Object
    //   270	131	8	localObject3	Object
    //   411	28	8	localException1	Exception
    //   720	1	8	localException2	Exception
    //   12	355	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   173	252	293	java/io/IOException
    //   252	290	293	java/io/IOException
    //   349	355	293	java/io/IOException
    //   376	389	411	java/lang/Exception
    //   398	408	411	java/lang/Exception
    //   468	473	482	java/io/IOException
    //   477	481	482	java/io/IOException
    //   527	532	543	java/io/IOException
    //   536	540	543	java/io/IOException
    //   493	498	551	java/io/IOException
    //   458	463	559	java/io/IOException
    //   355	362	567	finally
    //   458	463	567	finally
    //   493	498	567	finally
    //   498	504	567	finally
    //   512	522	567	finally
    //   552	556	567	finally
    //   560	564	567	finally
    //   600	604	567	finally
    //   604	607	567	finally
    //   608	612	567	finally
    //   615	649	567	finally
    //   362	373	592	finally
    //   600	604	607	java/io/IOException
    //   330	334	652	java/io/IOException
    //   338	342	652	java/io/IOException
    //   577	582	660	java/io/IOException
    //   586	590	660	java/io/IOException
    //   155	173	685	finally
    //   173	252	691	finally
    //   252	290	691	finally
    //   349	355	691	finally
    //   297	326	695	finally
    //   155	173	706	java/io/IOException
    //   376	389	715	finally
    //   398	408	715	finally
    //   416	453	715	finally
    //   362	373	720	java/lang/Exception
    //   355	362	728	java/io/IOException
    //   498	504	728	java/io/IOException
    //   512	522	728	java/io/IOException
    //   552	556	728	java/io/IOException
    //   560	564	728	java/io/IOException
    //   604	607	728	java/io/IOException
    //   608	612	728	java/io/IOException
    //   615	649	728	java/io/IOException
  }
  
  /* Error */
  public boolean B(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 4
    //   11: iconst_0
    //   12: istore 5
    //   14: new 282	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 6
    //   24: aload_0
    //   25: new 169	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 54	amzn:ccD	Ljava/lang/String;
    //   43: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnonnull +158 -> 212
    //   57: aload 6
    //   59: ifnull +8 -> 67
    //   62: aload 6
    //   64: invokevirtual 297	java/io/FileInputStream:close	()V
    //   67: aload 6
    //   69: ifnull +8 -> 77
    //   72: aload 6
    //   74: invokevirtual 297	java/io/FileInputStream:close	()V
    //   77: iload 5
    //   79: istore_3
    //   80: iconst_0
    //   81: ifeq +11 -> 92
    //   84: new 318	java/lang/NullPointerException
    //   87: dup
    //   88: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   91: athrow
    //   92: iload_3
    //   93: ireturn
    //   94: astore_1
    //   95: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq -31 -> 67
    //   101: ldc 254
    //   103: iconst_2
    //   104: ldc_w 324
    //   107: aload_1
    //   108: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: goto -44 -> 67
    //   114: astore 7
    //   116: aload 6
    //   118: astore_1
    //   119: aload 8
    //   121: astore 6
    //   123: iload_3
    //   124: istore 4
    //   126: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +14 -> 143
    //   132: ldc 254
    //   134: iconst_2
    //   135: ldc_w 324
    //   138: aload 7
    //   140: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 297	java/io/FileInputStream:close	()V
    //   151: iload 4
    //   153: istore_3
    //   154: aload 6
    //   156: ifnull -64 -> 92
    //   159: aload 6
    //   161: invokevirtual 327	java/util/zip/GZIPOutputStream:close	()V
    //   164: iload 4
    //   166: ireturn
    //   167: astore_1
    //   168: iload 4
    //   170: istore_3
    //   171: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -82 -> 92
    //   177: ldc 254
    //   179: iconst_2
    //   180: ldc_w 324
    //   183: aload_1
    //   184: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: iload 4
    //   189: ireturn
    //   190: astore_1
    //   191: iload 5
    //   193: istore_3
    //   194: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq -105 -> 92
    //   200: ldc 254
    //   202: iconst_2
    //   203: ldc_w 324
    //   206: aload_1
    //   207: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: iconst_0
    //   211: ireturn
    //   212: new 326	java/util/zip/GZIPOutputStream
    //   215: dup
    //   216: new 329	java/io/FileOutputStream
    //   219: dup
    //   220: aload_1
    //   221: invokespecial 330	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   224: invokespecial 333	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   227: astore_1
    //   228: iload 4
    //   230: istore_3
    //   231: sipush 10240
    //   234: newarray byte
    //   236: astore 7
    //   238: iload 4
    //   240: istore_3
    //   241: aload 6
    //   243: aload 7
    //   245: iconst_0
    //   246: sipush 10240
    //   249: invokevirtual 289	java/io/FileInputStream:read	([BII)I
    //   252: istore_2
    //   253: iload_2
    //   254: iconst_m1
    //   255: if_icmpeq +17 -> 272
    //   258: iload 4
    //   260: istore_3
    //   261: aload_1
    //   262: aload 7
    //   264: iconst_0
    //   265: iload_2
    //   266: invokevirtual 334	java/util/zip/GZIPOutputStream:write	([BII)V
    //   269: goto -31 -> 238
    //   272: iconst_1
    //   273: istore_3
    //   274: iconst_1
    //   275: istore 4
    //   277: aload_1
    //   278: invokevirtual 337	java/util/zip/GZIPOutputStream:flush	()V
    //   281: aload 6
    //   283: ifnull +8 -> 291
    //   286: aload 6
    //   288: invokevirtual 297	java/io/FileInputStream:close	()V
    //   291: iload 4
    //   293: istore_3
    //   294: aload_1
    //   295: ifnull -203 -> 92
    //   298: aload_1
    //   299: invokevirtual 327	java/util/zip/GZIPOutputStream:close	()V
    //   302: iconst_1
    //   303: ireturn
    //   304: astore_1
    //   305: iload 4
    //   307: istore_3
    //   308: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq -219 -> 92
    //   314: ldc 254
    //   316: iconst_2
    //   317: ldc_w 324
    //   320: aload_1
    //   321: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: iconst_1
    //   325: ireturn
    //   326: astore_1
    //   327: aconst_null
    //   328: astore 6
    //   330: aload 6
    //   332: ifnull +8 -> 340
    //   335: aload 6
    //   337: invokevirtual 297	java/io/FileInputStream:close	()V
    //   340: aload 7
    //   342: ifnull +8 -> 350
    //   345: aload 7
    //   347: invokevirtual 327	java/util/zip/GZIPOutputStream:close	()V
    //   350: aload_1
    //   351: athrow
    //   352: astore 6
    //   354: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq -7 -> 350
    //   360: ldc 254
    //   362: iconst_2
    //   363: ldc_w 324
    //   366: aload 6
    //   368: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: goto -21 -> 350
    //   374: astore_1
    //   375: goto -45 -> 330
    //   378: astore 8
    //   380: aload_1
    //   381: astore 7
    //   383: aload 8
    //   385: astore_1
    //   386: goto -56 -> 330
    //   389: astore 7
    //   391: aload_1
    //   392: astore 8
    //   394: aload 7
    //   396: astore_1
    //   397: aload 6
    //   399: astore 7
    //   401: aload 8
    //   403: astore 6
    //   405: goto -75 -> 330
    //   408: astore 7
    //   410: aconst_null
    //   411: astore_1
    //   412: iload_3
    //   413: istore 4
    //   415: aload 8
    //   417: astore 6
    //   419: goto -293 -> 126
    //   422: astore 7
    //   424: aload_1
    //   425: astore 8
    //   427: aload 6
    //   429: astore_1
    //   430: iload_3
    //   431: istore 4
    //   433: aload 8
    //   435: astore 6
    //   437: goto -311 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	amzn
    //   0	440	1	paramFile	File
    //   252	14	2	i	int
    //   7	424	3	bool1	boolean
    //   9	423	4	bool2	boolean
    //   12	180	5	bool3	boolean
    //   22	314	6	localObject1	Object
    //   352	46	6	localException	Exception
    //   403	33	6	localFile1	File
    //   1	1	7	localObject2	Object
    //   114	25	7	localIOException1	java.io.IOException
    //   236	146	7	localObject3	Object
    //   389	6	7	localObject4	Object
    //   399	1	7	localObject5	Object
    //   408	1	7	localIOException2	java.io.IOException
    //   422	1	7	localIOException3	java.io.IOException
    //   4	116	8	localObject6	Object
    //   378	6	8	localObject7	Object
    //   392	42	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   62	67	94	java/lang/Exception
    //   24	53	114	java/io/IOException
    //   62	67	114	java/io/IOException
    //   95	111	114	java/io/IOException
    //   212	228	114	java/io/IOException
    //   147	151	167	java/lang/Exception
    //   159	164	167	java/lang/Exception
    //   72	77	190	java/lang/Exception
    //   84	92	190	java/lang/Exception
    //   286	291	304	java/lang/Exception
    //   298	302	304	java/lang/Exception
    //   14	24	326	finally
    //   335	340	352	java/lang/Exception
    //   345	350	352	java/lang/Exception
    //   24	53	374	finally
    //   62	67	374	finally
    //   95	111	374	finally
    //   212	228	374	finally
    //   231	238	378	finally
    //   241	253	378	finally
    //   261	269	378	finally
    //   277	281	378	finally
    //   126	143	389	finally
    //   14	24	408	java/io/IOException
    //   231	238	422	java/io/IOException
    //   241	253	422	java/io/IOException
    //   261	269	422	java/io/IOException
    //   277	281	422	java/io/IOException
  }
  
  public String a(TreeMap<String, Object> paramTreeMap, String paramString)
  {
    Iterator localIterator = paramTreeMap.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + paramTreeMap.get(str2)) {
      str2 = (String)localIterator.next();
    }
    return MD5.toMD5(str1 + paramString);
  }
  
  public JSONArray a(Collection paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localJSONArray.put(paramCollection.next());
    }
    return localJSONArray;
  }
  
  public void a(long paramLong, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 1: 
      try
      {
        this.jdField_a_of_type_Aqaa.a(paramLong, paramInt, null);
        return;
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
    case 2: 
      localJSONObject = new JSONObject();
      if (paramVarArgs.length > 0) {
        localJSONObject.put("sizes", paramVarArgs[0]);
      }
      this.jdField_a_of_type_Aqaa.a(paramLong, paramInt, localJSONObject);
      return;
    case 3: 
      localJSONObject = new JSONObject();
      if (paramVarArgs.length > 0) {
        localJSONObject.put("percent", paramVarArgs[0]);
      }
      this.jdField_a_of_type_Aqaa.a(paramLong, paramInt, localJSONObject);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (paramVarArgs.length > 0) {
      localJSONObject.put("msg", paramVarArgs[0]);
    }
    this.jdField_a_of_type_Aqaa.a(paramLong, paramInt, localJSONObject);
  }
  
  public void a(long paramLong, String paramString, Map<String, Object> paramMap, List<aqad.a> paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramList.size())
    {
      localJSONArray.put(((aqad.a)paramList.get(i)).k());
      i += 1;
    }
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramMap.get(str));
        continue;
        paramList.clear();
      }
    }
    catch (Exception paramString)
    {
      a(paramLong, -1, new Object[] { paramString.getMessage() });
    }
    for (;;)
    {
      return;
      localJSONObject.put("dns", this.jdField_a_of_type_Apzu.BF());
      localJSONObject.put("ip", this.jdField_a_of_type_Apzu.oY(paramString));
      localJSONObject.put("traceRoute", localJSONArray);
      if (QLog.isColorLevel()) {
        QLog.d("SecSpyFileManager", 2, localJSONObject.toString());
      }
      c(paramLong, localJSONObject);
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    File localFile = new File(paramString1);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      a(paramLong, 2, new Object[] { Long.valueOf(localFile.length()) });
      if (!a(paramString1, paramLong, paramString2, false)) {
        break label103;
      }
      if (paramBoolean)
      {
        localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("SecSpyFileManager", 2, paramString1 + " delete success");
        }
      }
    }
    return;
    label103:
    a(paramLong, -1, new Object[] { "file upload failed" });
  }
  
  public void a(List<String> paramList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Apzu.j(this.mApp.getApplication(), paramLong)) {
      b(paramList, paramLong, paramString);
    }
  }
  
  public void a(submsgtype0x7c.MsgBody paramMsgBody, int paramInt)
  {
    if (paramInt < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecSpyFileManager", 2, "retry to max retry number ");
      }
      return;
    }
    if (this.jdField_do == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("SecSpyFile", 0);
      localHandlerThread.start();
      this.jdField_do = new Handler(localHandlerThread.getLooper());
      this.jdField_a_of_type_Apzu = new apzu(new SnapshotResultReceiver(this.mApp, this.jdField_do));
    }
    if (this.jdField_a_of_type_Aqaa == null) {
      this.jdField_a_of_type_Aqaa = new aqaa(this.mApp);
    }
    this.jdField_do.post(new SecSpyFileManager.2(this, paramMsgBody, paramInt));
  }
  
  /* Error */
  public boolean a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 488	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 16
    //   15: aconst_null
    //   16: astore 15
    //   18: new 8	amzn$a
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 489	amzn$a:<init>	(Lamzn;)V
    //   26: astore 19
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 17
    //   35: aload 17
    //   37: ifnull +19 -> 56
    //   40: aload 17
    //   42: invokevirtual 125	java/io/File:exists	()Z
    //   45: ifeq +11 -> 56
    //   48: aload 17
    //   50: invokevirtual 128	java/io/File:isFile	()Z
    //   53: ifne +166 -> 219
    //   56: aload_0
    //   57: lload_2
    //   58: iconst_m1
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: getstatic 37	amzn:ccA	Ljava/lang/String;
    //   68: aastore
    //   69: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   72: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +29 -> 104
    //   78: ldc 254
    //   80: iconst_2
    //   81: new 169	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 491
    //   91: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 419	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iconst_0
    //   105: ifeq +11 -> 116
    //   108: new 318	java/lang/NullPointerException
    //   111: dup
    //   112: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   115: athrow
    //   116: iconst_0
    //   117: ifeq +11 -> 128
    //   120: new 318	java/lang/NullPointerException
    //   123: dup
    //   124: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   127: athrow
    //   128: iconst_0
    //   129: ifeq +11 -> 140
    //   132: new 318	java/lang/NullPointerException
    //   135: dup
    //   136: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   139: athrow
    //   140: iload 5
    //   142: ifeq +45 -> 187
    //   145: aload_0
    //   146: new 169	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   153: aload_1
    //   154: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: getfield 54	amzn:ccD	Ljava/lang/String;
    //   161: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +15 -> 187
    //   175: aload_1
    //   176: invokevirtual 125	java/io/File:exists	()Z
    //   179: ifeq +8 -> 187
    //   182: aload_1
    //   183: invokevirtual 276	java/io/File:delete	()Z
    //   186: pop
    //   187: aload 19
    //   189: iconst_1
    //   190: invokestatic 494	amzn$a:a	(Lamzn$a;Z)Z
    //   193: pop
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_1
    //   197: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc 254
    //   205: iconst_2
    //   206: ldc_w 496
    //   209: aload_1
    //   210: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_1
    //   214: invokevirtual 497	java/lang/Exception:printStackTrace	()V
    //   217: iconst_0
    //   218: ireturn
    //   219: invokestatic 502	jqc:getNetWorkType	()I
    //   222: iconst_1
    //   223: if_icmpne +186 -> 409
    //   226: ldc2_w 503
    //   229: lstore 10
    //   231: aload 17
    //   233: invokevirtual 132	java/io/File:length	()J
    //   236: lload 10
    //   238: lcmp
    //   239: ifle +178 -> 417
    //   242: aload_0
    //   243: lload_2
    //   244: iconst_m1
    //   245: iconst_1
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: getstatic 34	amzn:ccz	Ljava/lang/String;
    //   254: aastore
    //   255: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   258: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +33 -> 294
    //   264: ldc 254
    //   266: iconst_2
    //   267: new 169	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 506
    //   277: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 17
    //   282: invokevirtual 132	java/io/File:length	()J
    //   285: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   288: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 419	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: iconst_0
    //   295: ifeq +11 -> 306
    //   298: new 318	java/lang/NullPointerException
    //   301: dup
    //   302: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   305: athrow
    //   306: iconst_0
    //   307: ifeq +11 -> 318
    //   310: new 318	java/lang/NullPointerException
    //   313: dup
    //   314: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   317: athrow
    //   318: iconst_0
    //   319: ifeq +11 -> 330
    //   322: new 318	java/lang/NullPointerException
    //   325: dup
    //   326: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   329: athrow
    //   330: iload 5
    //   332: ifeq +45 -> 377
    //   335: aload_0
    //   336: new 169	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   343: aload_1
    //   344: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_0
    //   348: getfield 54	amzn:ccD	Ljava/lang/String;
    //   351: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   360: astore_1
    //   361: aload_1
    //   362: ifnull +15 -> 377
    //   365: aload_1
    //   366: invokevirtual 125	java/io/File:exists	()Z
    //   369: ifeq +8 -> 377
    //   372: aload_1
    //   373: invokevirtual 276	java/io/File:delete	()Z
    //   376: pop
    //   377: aload 19
    //   379: iconst_1
    //   380: invokestatic 494	amzn$a:a	(Lamzn$a;Z)Z
    //   383: pop
    //   384: iconst_0
    //   385: ireturn
    //   386: astore_1
    //   387: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +13 -> 403
    //   393: ldc 254
    //   395: iconst_2
    //   396: ldc_w 496
    //   399: aload_1
    //   400: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   403: aload_1
    //   404: invokevirtual 497	java/lang/Exception:printStackTrace	()V
    //   407: iconst_0
    //   408: ireturn
    //   409: ldc2_w 507
    //   412: lstore 10
    //   414: goto -183 -> 231
    //   417: aload_1
    //   418: aload_1
    //   419: bipush 47
    //   421: invokevirtual 512	java/lang/String:lastIndexOf	(I)I
    //   424: iconst_1
    //   425: iadd
    //   426: invokevirtual 515	java/lang/String:substring	(I)Ljava/lang/String;
    //   429: astore 18
    //   431: aload 18
    //   433: astore 13
    //   435: aload 17
    //   437: astore 14
    //   439: iload 5
    //   441: ifeq +356 -> 797
    //   444: new 169	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   451: aload 18
    //   453: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc_w 517
    //   459: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: astore 13
    //   467: aload_0
    //   468: aload 17
    //   470: invokevirtual 519	amzn:B	(Ljava/io/File;)Z
    //   473: ifeq +209 -> 682
    //   476: aload_0
    //   477: new 169	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   484: aload_1
    //   485: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_0
    //   489: getfield 54	amzn:ccD	Ljava/lang/String;
    //   492: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   501: astore 17
    //   503: aload 17
    //   505: ifnull +23 -> 528
    //   508: aload 17
    //   510: invokevirtual 125	java/io/File:exists	()Z
    //   513: ifeq +15 -> 528
    //   516: aload 17
    //   518: astore 14
    //   520: aload 17
    //   522: invokevirtual 128	java/io/File:isFile	()Z
    //   525: ifne +272 -> 797
    //   528: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq +36 -> 567
    //   534: ldc 254
    //   536: iconst_2
    //   537: new 169	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 521
    //   547: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload_1
    //   551: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload_0
    //   555: getfield 54	amzn:ccD	Ljava/lang/String;
    //   558: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 419	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: iconst_0
    //   568: ifeq +11 -> 579
    //   571: new 318	java/lang/NullPointerException
    //   574: dup
    //   575: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   578: athrow
    //   579: iconst_0
    //   580: ifeq +11 -> 591
    //   583: new 318	java/lang/NullPointerException
    //   586: dup
    //   587: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   590: athrow
    //   591: iconst_0
    //   592: ifeq +11 -> 603
    //   595: new 318	java/lang/NullPointerException
    //   598: dup
    //   599: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   602: athrow
    //   603: iload 5
    //   605: ifeq +45 -> 650
    //   608: aload_0
    //   609: new 169	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   616: aload_1
    //   617: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload_0
    //   621: getfield 54	amzn:ccD	Ljava/lang/String;
    //   624: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   633: astore_1
    //   634: aload_1
    //   635: ifnull +15 -> 650
    //   638: aload_1
    //   639: invokevirtual 125	java/io/File:exists	()Z
    //   642: ifeq +8 -> 650
    //   645: aload_1
    //   646: invokevirtual 276	java/io/File:delete	()Z
    //   649: pop
    //   650: aload 19
    //   652: iconst_1
    //   653: invokestatic 494	amzn$a:a	(Lamzn$a;Z)Z
    //   656: pop
    //   657: iconst_0
    //   658: ireturn
    //   659: astore_1
    //   660: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq +13 -> 676
    //   666: ldc 254
    //   668: iconst_2
    //   669: ldc_w 496
    //   672: aload_1
    //   673: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   676: aload_1
    //   677: invokevirtual 497	java/lang/Exception:printStackTrace	()V
    //   680: iconst_0
    //   681: ireturn
    //   682: iconst_0
    //   683: ifeq +11 -> 694
    //   686: new 318	java/lang/NullPointerException
    //   689: dup
    //   690: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   693: athrow
    //   694: iconst_0
    //   695: ifeq +11 -> 706
    //   698: new 318	java/lang/NullPointerException
    //   701: dup
    //   702: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   705: athrow
    //   706: iconst_0
    //   707: ifeq +11 -> 718
    //   710: new 318	java/lang/NullPointerException
    //   713: dup
    //   714: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   717: athrow
    //   718: iload 5
    //   720: ifeq +45 -> 765
    //   723: aload_0
    //   724: new 169	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   731: aload_1
    //   732: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_0
    //   736: getfield 54	amzn:ccD	Ljava/lang/String;
    //   739: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   748: astore_1
    //   749: aload_1
    //   750: ifnull +15 -> 765
    //   753: aload_1
    //   754: invokevirtual 125	java/io/File:exists	()Z
    //   757: ifeq +8 -> 765
    //   760: aload_1
    //   761: invokevirtual 276	java/io/File:delete	()Z
    //   764: pop
    //   765: aload 19
    //   767: iconst_1
    //   768: invokestatic 494	amzn$a:a	(Lamzn$a;Z)Z
    //   771: pop
    //   772: iconst_0
    //   773: ireturn
    //   774: astore_1
    //   775: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   778: ifeq +13 -> 791
    //   781: ldc 254
    //   783: iconst_2
    //   784: ldc_w 496
    //   787: aload_1
    //   788: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   791: aload_1
    //   792: invokevirtual 497	java/lang/Exception:printStackTrace	()V
    //   795: iconst_0
    //   796: ireturn
    //   797: new 340	java/util/TreeMap
    //   800: dup
    //   801: invokespecial 522	java/util/TreeMap:<init>	()V
    //   804: astore 17
    //   806: aload 17
    //   808: ldc_w 524
    //   811: lload_2
    //   812: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   815: invokevirtual 525	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   818: pop
    //   819: aload 17
    //   821: ldc_w 527
    //   824: ldc_w 529
    //   827: invokevirtual 525	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   830: pop
    //   831: aload 17
    //   833: ldc_w 531
    //   836: aload 13
    //   838: invokevirtual 525	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   841: pop
    //   842: aload 17
    //   844: ldc_w 533
    //   847: aload 14
    //   849: invokevirtual 132	java/io/File:length	()J
    //   852: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   855: invokevirtual 525	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   858: pop
    //   859: aload 17
    //   861: ldc_w 535
    //   864: iconst_0
    //   865: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: invokevirtual 525	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   871: pop
    //   872: aload 17
    //   874: ldc_w 537
    //   877: aload_0
    //   878: aload 17
    //   880: aload 4
    //   882: invokevirtual 539	amzn:a	(Ljava/util/TreeMap;Ljava/lang/String;)Ljava/lang/String;
    //   885: invokevirtual 525	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   888: pop
    //   889: aload_0
    //   890: getfield 46	amzn:ccB	Ljava/lang/String;
    //   893: astore 4
    //   895: aload 17
    //   897: invokevirtual 341	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   900: invokeinterface 237 1 0
    //   905: astore 18
    //   907: aload 18
    //   909: invokeinterface 242 1 0
    //   914: ifeq +62 -> 976
    //   917: aload 18
    //   919: invokeinterface 246 1 0
    //   924: checkcast 248	java/lang/String
    //   927: astore 20
    //   929: new 169	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   936: aload 4
    //   938: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: aload 20
    //   943: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: ldc_w 541
    //   949: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: aload 17
    //   954: aload 20
    //   956: invokevirtual 342	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   959: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   962: ldc_w 543
    //   965: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   971: astore 4
    //   973: goto -66 -> 907
    //   976: aload 4
    //   978: ldc_w 543
    //   981: invokevirtual 547	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   984: ifeq +1110 -> 2094
    //   987: aload 4
    //   989: iconst_0
    //   990: aload 4
    //   992: invokevirtual 549	java/lang/String:length	()I
    //   995: iconst_1
    //   996: isub
    //   997: invokevirtual 552	java/lang/String:substring	(II)Ljava/lang/String;
    //   1000: astore 4
    //   1002: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1005: ifeq +30 -> 1035
    //   1008: ldc 254
    //   1010: iconst_2
    //   1011: new 169	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1018: ldc_w 554
    //   1021: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: aload 4
    //   1026: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: invokestatic 419	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: new 184	java/net/URL
    //   1038: dup
    //   1039: aload 4
    //   1041: invokespecial 187	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1044: invokevirtual 191	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1047: checkcast 193	java/net/HttpURLConnection
    //   1050: astore 4
    //   1052: aload 4
    //   1054: iconst_0
    //   1055: invokevirtual 203	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1058: aload 4
    //   1060: iconst_1
    //   1061: invokevirtual 197	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1064: aload_0
    //   1065: getfield 56	amzn:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1068: iconst_2
    //   1069: invokevirtual 558	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1072: checkcast 560	mqq/app/TicketManagerImpl
    //   1075: astore 12
    //   1077: aload 4
    //   1079: ldc_w 562
    //   1082: new 169	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1089: ldc_w 564
    //   1092: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload_0
    //   1096: getfield 56	amzn:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1099: invokevirtual 567	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1102: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: ldc_w 569
    //   1108: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload 12
    //   1113: aload_0
    //   1114: getfield 56	amzn:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1117: invokevirtual 567	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1120: invokevirtual 572	mqq/app/TicketManagerImpl:getSkey	(Ljava/lang/String;)Ljava/lang/String;
    //   1123: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1129: invokevirtual 219	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1132: aload 4
    //   1134: ldc 205
    //   1136: invokevirtual 208	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1139: aload 4
    //   1141: ldc_w 574
    //   1144: ldc_w 576
    //   1147: invokevirtual 219	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1150: aload 4
    //   1152: ldc_w 578
    //   1155: ldc_w 580
    //   1158: invokevirtual 219	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1161: aload 4
    //   1163: ldc 221
    //   1165: new 169	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1172: ldc_w 582
    //   1175: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: ldc_w 584
    //   1181: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1187: invokevirtual 219	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1190: new 586	java/io/DataOutputStream
    //   1193: dup
    //   1194: aload 4
    //   1196: invokevirtual 280	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1199: invokespecial 587	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1202: astore 12
    //   1204: aload 12
    //   1206: new 169	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1213: ldc_w 589
    //   1216: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: ldc_w 584
    //   1222: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: ldc_w 591
    //   1228: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokevirtual 594	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1237: aload 12
    //   1239: new 169	java/lang/StringBuilder
    //   1242: dup
    //   1243: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1246: ldc_w 596
    //   1249: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: aload 13
    //   1254: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: ldc_w 598
    //   1260: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: ldc_w 591
    //   1266: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: invokevirtual 594	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1275: aload 12
    //   1277: ldc_w 591
    //   1280: invokevirtual 594	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1283: new 282	java/io/FileInputStream
    //   1286: dup
    //   1287: aload 14
    //   1289: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1292: astore 13
    //   1294: aload 13
    //   1296: invokevirtual 601	java/io/FileInputStream:available	()I
    //   1299: istore 8
    //   1301: iload 8
    //   1303: ldc_w 602
    //   1306: invokestatic 608	java/lang/Math:min	(II)I
    //   1309: istore 7
    //   1311: iload 7
    //   1313: newarray byte
    //   1315: astore 14
    //   1317: aload 19
    //   1319: iload 8
    //   1321: i2f
    //   1322: invokestatic 611	amzn$a:a	(Lamzn$a;F)F
    //   1325: pop
    //   1326: aload_0
    //   1327: getfield 109	amzn:jdField_a_of_type_Apzu	Lapzu;
    //   1330: invokevirtual 615	apzu:z	()Landroid/os/Handler;
    //   1333: new 617	com/tencent/mobileqq/secspy/SecSpyFileManager$3
    //   1336: dup
    //   1337: aload_0
    //   1338: aload 19
    //   1340: lload_2
    //   1341: invokespecial 620	com/tencent/mobileqq/secspy/SecSpyFileManager$3:<init>	(Lamzn;Lamzn$a;J)V
    //   1344: ldc2_w 621
    //   1347: invokevirtual 626	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1350: pop
    //   1351: aload 13
    //   1353: aload 14
    //   1355: iconst_0
    //   1356: iload 7
    //   1358: invokevirtual 289	java/io/FileInputStream:read	([BII)I
    //   1361: istore 8
    //   1363: iload 8
    //   1365: ifle +60 -> 1425
    //   1368: aload 12
    //   1370: aload 14
    //   1372: iconst_0
    //   1373: iload 7
    //   1375: invokevirtual 627	java/io/DataOutputStream:write	([BII)V
    //   1378: aload 19
    //   1380: invokestatic 630	amzn$a:a	(Lamzn$a;)F
    //   1383: fstore 6
    //   1385: aload 19
    //   1387: iload 8
    //   1389: i2f
    //   1390: fload 6
    //   1392: fadd
    //   1393: invokestatic 632	amzn$a:b	(Lamzn$a;F)F
    //   1396: pop
    //   1397: aload 13
    //   1399: invokevirtual 601	java/io/FileInputStream:available	()I
    //   1402: ldc_w 602
    //   1405: invokestatic 608	java/lang/Math:min	(II)I
    //   1408: istore 7
    //   1410: aload 13
    //   1412: aload 14
    //   1414: iconst_0
    //   1415: iload 7
    //   1417: invokevirtual 289	java/io/FileInputStream:read	([BII)I
    //   1420: istore 8
    //   1422: goto -59 -> 1363
    //   1425: aload 12
    //   1427: ldc_w 591
    //   1430: invokevirtual 594	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1433: aload 12
    //   1435: new 169	java/lang/StringBuilder
    //   1438: dup
    //   1439: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1442: ldc_w 589
    //   1445: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: ldc_w 584
    //   1451: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: ldc_w 589
    //   1457: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: ldc_w 591
    //   1463: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: invokevirtual 594	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1472: aload 4
    //   1474: invokevirtual 304	java/net/HttpURLConnection:getResponseCode	()I
    //   1477: istore 7
    //   1479: aload 4
    //   1481: invokevirtual 635	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   1484: astore 14
    //   1486: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1489: ifeq +40 -> 1529
    //   1492: ldc 254
    //   1494: iconst_2
    //   1495: new 169	java/lang/StringBuilder
    //   1498: dup
    //   1499: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1502: ldc 212
    //   1504: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: iload 7
    //   1509: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1512: ldc_w 637
    //   1515: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: aload 14
    //   1520: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1526: invokestatic 419	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1529: aload 12
    //   1531: invokevirtual 638	java/io/DataOutputStream:flush	()V
    //   1534: aload 12
    //   1536: invokevirtual 639	java/io/DataOutputStream:close	()V
    //   1539: aload 13
    //   1541: invokevirtual 297	java/io/FileInputStream:close	()V
    //   1544: iload 7
    //   1546: sipush 200
    //   1549: if_icmpne +539 -> 2088
    //   1552: iconst_1
    //   1553: istore 9
    //   1555: aload 12
    //   1557: ifnull +8 -> 1565
    //   1560: aload 12
    //   1562: invokevirtual 639	java/io/DataOutputStream:close	()V
    //   1565: iconst_0
    //   1566: ifeq +11 -> 1577
    //   1569: new 318	java/lang/NullPointerException
    //   1572: dup
    //   1573: invokespecial 319	java/lang/NullPointerException:<init>	()V
    //   1576: athrow
    //   1577: aload 4
    //   1579: ifnull +8 -> 1587
    //   1582: aload 4
    //   1584: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   1587: iload 5
    //   1589: ifeq +45 -> 1634
    //   1592: aload_0
    //   1593: new 169	java/lang/StringBuilder
    //   1596: dup
    //   1597: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1600: aload_1
    //   1601: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: aload_0
    //   1605: getfield 54	amzn:ccD	Ljava/lang/String;
    //   1608: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1614: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   1617: astore_1
    //   1618: aload_1
    //   1619: ifnull +15 -> 1634
    //   1622: aload_1
    //   1623: invokevirtual 125	java/io/File:exists	()Z
    //   1626: ifeq +8 -> 1634
    //   1629: aload_1
    //   1630: invokevirtual 276	java/io/File:delete	()Z
    //   1633: pop
    //   1634: aload 19
    //   1636: iconst_1
    //   1637: invokestatic 494	amzn$a:a	(Lamzn$a;Z)Z
    //   1640: pop
    //   1641: iload 9
    //   1643: ireturn
    //   1644: astore_1
    //   1645: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1648: ifeq +13 -> 1661
    //   1651: ldc 254
    //   1653: iconst_2
    //   1654: ldc_w 496
    //   1657: aload_1
    //   1658: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1661: aload_1
    //   1662: invokevirtual 497	java/lang/Exception:printStackTrace	()V
    //   1665: iload 9
    //   1667: ireturn
    //   1668: astore 14
    //   1670: aconst_null
    //   1671: astore 12
    //   1673: aconst_null
    //   1674: astore 13
    //   1676: aconst_null
    //   1677: astore 4
    //   1679: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1682: ifeq +14 -> 1696
    //   1685: ldc 254
    //   1687: iconst_2
    //   1688: ldc_w 641
    //   1691: aload 14
    //   1693: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1696: aload_0
    //   1697: lload_2
    //   1698: iconst_m1
    //   1699: iconst_1
    //   1700: anewarray 4	java/lang/Object
    //   1703: dup
    //   1704: iconst_0
    //   1705: aload 14
    //   1707: invokevirtual 296	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1710: aastore
    //   1711: invokevirtual 141	amzn:a	(JI[Ljava/lang/Object;)V
    //   1714: aload 12
    //   1716: ifnull +8 -> 1724
    //   1719: aload 12
    //   1721: invokevirtual 639	java/io/DataOutputStream:close	()V
    //   1724: aload 4
    //   1726: ifnull +8 -> 1734
    //   1729: aload 4
    //   1731: invokevirtual 297	java/io/FileInputStream:close	()V
    //   1734: aload 13
    //   1736: ifnull +8 -> 1744
    //   1739: aload 13
    //   1741: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   1744: iload 5
    //   1746: ifeq +45 -> 1791
    //   1749: aload_0
    //   1750: new 169	java/lang/StringBuilder
    //   1753: dup
    //   1754: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1757: aload_1
    //   1758: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: aload_0
    //   1762: getfield 54	amzn:ccD	Ljava/lang/String;
    //   1765: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1768: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1771: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   1774: astore_1
    //   1775: aload_1
    //   1776: ifnull +15 -> 1791
    //   1779: aload_1
    //   1780: invokevirtual 125	java/io/File:exists	()Z
    //   1783: ifeq +8 -> 1791
    //   1786: aload_1
    //   1787: invokevirtual 276	java/io/File:delete	()Z
    //   1790: pop
    //   1791: aload 19
    //   1793: iconst_1
    //   1794: invokestatic 494	amzn$a:a	(Lamzn$a;Z)Z
    //   1797: pop
    //   1798: iconst_0
    //   1799: ireturn
    //   1800: astore_1
    //   1801: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1804: ifeq +13 -> 1817
    //   1807: ldc 254
    //   1809: iconst_2
    //   1810: ldc_w 496
    //   1813: aload_1
    //   1814: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1817: aload_1
    //   1818: invokevirtual 497	java/lang/Exception:printStackTrace	()V
    //   1821: iconst_0
    //   1822: ireturn
    //   1823: astore 4
    //   1825: aload 16
    //   1827: astore 13
    //   1829: aload 15
    //   1831: astore 14
    //   1833: aload 13
    //   1835: ifnull +8 -> 1843
    //   1838: aload 13
    //   1840: invokevirtual 639	java/io/DataOutputStream:close	()V
    //   1843: aload 14
    //   1845: ifnull +8 -> 1853
    //   1848: aload 14
    //   1850: invokevirtual 297	java/io/FileInputStream:close	()V
    //   1853: aload 12
    //   1855: ifnull +8 -> 1863
    //   1858: aload 12
    //   1860: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   1863: iload 5
    //   1865: ifeq +45 -> 1910
    //   1868: aload_0
    //   1869: new 169	java/lang/StringBuilder
    //   1872: dup
    //   1873: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1876: aload_1
    //   1877: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: aload_0
    //   1881: getfield 54	amzn:ccD	Ljava/lang/String;
    //   1884: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1887: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1890: invokevirtual 119	amzn:i	(Ljava/lang/String;)Ljava/io/File;
    //   1893: astore_1
    //   1894: aload_1
    //   1895: ifnull +15 -> 1910
    //   1898: aload_1
    //   1899: invokevirtual 125	java/io/File:exists	()Z
    //   1902: ifeq +8 -> 1910
    //   1905: aload_1
    //   1906: invokevirtual 276	java/io/File:delete	()Z
    //   1909: pop
    //   1910: aload 19
    //   1912: iconst_1
    //   1913: invokestatic 494	amzn$a:a	(Lamzn$a;Z)Z
    //   1916: pop
    //   1917: aload 4
    //   1919: athrow
    //   1920: astore_1
    //   1921: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1924: ifeq +13 -> 1937
    //   1927: ldc 254
    //   1929: iconst_2
    //   1930: ldc_w 496
    //   1933: aload_1
    //   1934: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1937: aload_1
    //   1938: invokevirtual 497	java/lang/Exception:printStackTrace	()V
    //   1941: goto -24 -> 1917
    //   1944: astore 13
    //   1946: aload 4
    //   1948: astore 12
    //   1950: aload 13
    //   1952: astore 4
    //   1954: aload 15
    //   1956: astore 14
    //   1958: aload 16
    //   1960: astore 13
    //   1962: goto -129 -> 1833
    //   1965: astore 14
    //   1967: aload 12
    //   1969: astore 13
    //   1971: aload 4
    //   1973: astore 12
    //   1975: aload 14
    //   1977: astore 4
    //   1979: aload 15
    //   1981: astore 14
    //   1983: goto -150 -> 1833
    //   1986: astore 14
    //   1988: aload 12
    //   1990: astore 15
    //   1992: aload 4
    //   1994: astore 12
    //   1996: aload 14
    //   1998: astore 4
    //   2000: aload 13
    //   2002: astore 14
    //   2004: aload 15
    //   2006: astore 13
    //   2008: goto -175 -> 1833
    //   2011: astore 16
    //   2013: aload 13
    //   2015: astore 14
    //   2017: aload 12
    //   2019: astore 13
    //   2021: aload 4
    //   2023: astore 15
    //   2025: aload 16
    //   2027: astore 4
    //   2029: aload 14
    //   2031: astore 12
    //   2033: aload 15
    //   2035: astore 14
    //   2037: goto -204 -> 1833
    //   2040: astore 14
    //   2042: aconst_null
    //   2043: astore 15
    //   2045: aconst_null
    //   2046: astore 12
    //   2048: aload 4
    //   2050: astore 13
    //   2052: aload 15
    //   2054: astore 4
    //   2056: goto -377 -> 1679
    //   2059: astore 14
    //   2061: aload 4
    //   2063: astore 13
    //   2065: aconst_null
    //   2066: astore 4
    //   2068: goto -389 -> 1679
    //   2071: astore 14
    //   2073: aload 4
    //   2075: astore 15
    //   2077: aload 13
    //   2079: astore 4
    //   2081: aload 15
    //   2083: astore 13
    //   2085: goto -406 -> 1679
    //   2088: iconst_0
    //   2089: istore 9
    //   2091: goto -536 -> 1555
    //   2094: goto -1092 -> 1002
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2097	0	this	amzn
    //   0	2097	1	paramString1	String
    //   0	2097	2	paramLong	long
    //   0	2097	4	paramString2	String
    //   0	2097	5	paramBoolean	boolean
    //   1383	8	6	f	float
    //   1309	241	7	i	int
    //   1299	122	8	j	int
    //   1553	537	9	bool	boolean
    //   229	184	10	l	long
    //   10	2037	12	localObject1	Object
    //   433	1406	13	localObject2	Object
    //   1944	7	13	localObject3	Object
    //   1960	124	13	localObject4	Object
    //   437	1082	14	localObject5	Object
    //   1668	38	14	localException1	Exception
    //   1831	126	14	localObject6	Object
    //   1965	11	14	localObject7	Object
    //   1981	1	14	localObject8	Object
    //   1986	11	14	localObject9	Object
    //   2002	34	14	localObject10	Object
    //   2040	1	14	localException2	Exception
    //   2059	1	14	localException3	Exception
    //   2071	1	14	localException4	Exception
    //   16	2066	15	localObject11	Object
    //   13	1946	16	localObject12	Object
    //   2011	15	16	localObject13	Object
    //   33	920	17	localObject14	Object
    //   429	489	18	localObject15	Object
    //   26	1885	19	locala	amzn.a
    //   927	28	20	str	String
    // Exception table:
    //   from	to	target	type
    //   108	116	196	java/lang/Exception
    //   120	128	196	java/lang/Exception
    //   132	140	196	java/lang/Exception
    //   145	171	196	java/lang/Exception
    //   175	187	196	java/lang/Exception
    //   187	194	196	java/lang/Exception
    //   298	306	386	java/lang/Exception
    //   310	318	386	java/lang/Exception
    //   322	330	386	java/lang/Exception
    //   335	361	386	java/lang/Exception
    //   365	377	386	java/lang/Exception
    //   377	384	386	java/lang/Exception
    //   571	579	659	java/lang/Exception
    //   583	591	659	java/lang/Exception
    //   595	603	659	java/lang/Exception
    //   608	634	659	java/lang/Exception
    //   638	650	659	java/lang/Exception
    //   650	657	659	java/lang/Exception
    //   686	694	774	java/lang/Exception
    //   698	706	774	java/lang/Exception
    //   710	718	774	java/lang/Exception
    //   723	749	774	java/lang/Exception
    //   753	765	774	java/lang/Exception
    //   765	772	774	java/lang/Exception
    //   1560	1565	1644	java/lang/Exception
    //   1569	1577	1644	java/lang/Exception
    //   1582	1587	1644	java/lang/Exception
    //   1592	1618	1644	java/lang/Exception
    //   1622	1634	1644	java/lang/Exception
    //   1634	1641	1644	java/lang/Exception
    //   28	35	1668	java/lang/Exception
    //   40	56	1668	java/lang/Exception
    //   56	104	1668	java/lang/Exception
    //   219	226	1668	java/lang/Exception
    //   231	294	1668	java/lang/Exception
    //   417	431	1668	java/lang/Exception
    //   444	503	1668	java/lang/Exception
    //   508	516	1668	java/lang/Exception
    //   520	528	1668	java/lang/Exception
    //   528	567	1668	java/lang/Exception
    //   797	907	1668	java/lang/Exception
    //   907	973	1668	java/lang/Exception
    //   976	1002	1668	java/lang/Exception
    //   1002	1035	1668	java/lang/Exception
    //   1035	1052	1668	java/lang/Exception
    //   1719	1724	1800	java/lang/Exception
    //   1729	1734	1800	java/lang/Exception
    //   1739	1744	1800	java/lang/Exception
    //   1749	1775	1800	java/lang/Exception
    //   1779	1791	1800	java/lang/Exception
    //   1791	1798	1800	java/lang/Exception
    //   28	35	1823	finally
    //   40	56	1823	finally
    //   56	104	1823	finally
    //   219	226	1823	finally
    //   231	294	1823	finally
    //   417	431	1823	finally
    //   444	503	1823	finally
    //   508	516	1823	finally
    //   520	528	1823	finally
    //   528	567	1823	finally
    //   797	907	1823	finally
    //   907	973	1823	finally
    //   976	1002	1823	finally
    //   1002	1035	1823	finally
    //   1035	1052	1823	finally
    //   1838	1843	1920	java/lang/Exception
    //   1848	1853	1920	java/lang/Exception
    //   1858	1863	1920	java/lang/Exception
    //   1868	1894	1920	java/lang/Exception
    //   1898	1910	1920	java/lang/Exception
    //   1910	1917	1920	java/lang/Exception
    //   1052	1204	1944	finally
    //   1204	1294	1965	finally
    //   1294	1363	1986	finally
    //   1368	1422	1986	finally
    //   1425	1529	1986	finally
    //   1529	1544	1986	finally
    //   1679	1696	2011	finally
    //   1696	1714	2011	finally
    //   1052	1204	2040	java/lang/Exception
    //   1204	1294	2059	java/lang/Exception
    //   1294	1363	2071	java/lang/Exception
    //   1368	1422	2071	java/lang/Exception
    //   1425	1529	2071	java/lang/Exception
    //   1529	1544	2071	java/lang/Exception
  }
  
  public void aH(long paramLong, String paramString)
  {
    a(paramLong, -1, new Object[] { paramString });
  }
  
  public void b(List<String> paramList, long paramLong, String paramString)
  {
    a(this.jdField_a_of_type_Apzu.V(paramList), paramLong, paramString, false);
    aqac.deleteFiles(paramList);
    paramList.clear();
  }
  
  public void c(long paramLong, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Aqaa.a(paramLong, 0, paramJSONObject);
  }
  
  public void d(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    this.jdField_a_of_type_Apzu.c(this.mApp.getApp(), paramString1, paramInt, paramLong1, paramLong2, paramString2);
  }
  
  public File i(String paramString)
  {
    Object localObject = paramString;
    String str1;
    String str2;
    try
    {
      if (!paramString.startsWith("/data/data/com.tencent.mobileqq/")) {
        break label305;
      }
      str1 = paramString;
      localObject = paramString;
      if (!paramString.endsWith("/"))
      {
        localObject = paramString;
        str1 = paramString + "/";
      }
      localObject = str1;
      int i = str1.indexOf("/data/data/com.tencent.mobileqq/");
      localObject = str1;
      str2 = str1.substring("/data/data/com.tencent.mobileqq/".length() + i);
      localObject = str1;
      paramString = str2.substring(0, str2.indexOf("/"));
      localObject = str1;
      str2 = str2.substring(str2.indexOf("/") + 1);
      localObject = str1;
      Context localContext = this.mApp.getApplication().getApplicationContext();
      localObject = str1;
      if (paramString.equals("files"))
      {
        localObject = str1;
        return new File(localContext.getFilesDir(), str2);
      }
      localObject = str1;
      if (paramString.equals("cache"))
      {
        localObject = str1;
        paramString = new File(localContext.getCacheDir(), str2);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SecSpyFileManager", 2, "wrong to parse file from path :" + (String)localObject, paramString);
      }
      paramString.printStackTrace();
      return null;
    }
    localObject = str1;
    if (paramString.startsWith("app_"))
    {
      localObject = str1;
      paramString = paramString.substring("app_".length());
      localObject = str1;
      return new File(this.mApp.getApplication().getApplicationContext().getDir(paramString, 0), str2);
    }
    localObject = str1;
    return new File(str1);
    label305:
    localObject = paramString;
    if (paramString.startsWith("sdcard/"))
    {
      localObject = paramString;
      str1 = paramString.replace("sdcard/", "");
      localObject = paramString;
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        localObject = paramString;
        if (Environment.getExternalStorageDirectory().canWrite())
        {
          localObject = paramString;
          return new File(Environment.getExternalStorageDirectory().getPath() + "/" + str1);
        }
      }
    }
    else
    {
      localObject = paramString;
      paramString = new File(paramString);
      return paramString;
    }
    return null;
  }
  
  public List<String> jsonArrayToList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void lh(long paramLong)
  {
    this.jdField_a_of_type_Apzu.j(this.mApp.getApplication(), paramLong);
  }
  
  public void onDestroy() {}
  
  public class a
  {
    private boolean finished;
    private float zF;
    private float zG;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzn
 * JD-Core Version:    0.7.0.1
 */