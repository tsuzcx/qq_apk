import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.1;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.2;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.3;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.4;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awjs
{
  /* Error */
  public static int a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_0
    //   13: ldc 22
    //   15: invokevirtual 28	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   18: astore 9
    //   20: aload 9
    //   22: ldc 30
    //   24: invokevirtual 34	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_0
    //   28: aload 9
    //   30: ldc 36
    //   32: invokevirtual 34	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 8
    //   37: aload 9
    //   39: ldc 38
    //   41: invokevirtual 34	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 9
    //   46: new 40	java/net/URL
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 44	java/net/URL:<init>	(Ljava/lang/String;)V
    //   54: invokevirtual 48	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   57: checkcast 50	java/net/HttpURLConnection
    //   60: astore_0
    //   61: aload_0
    //   62: sipush 30000
    //   65: invokevirtual 54	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   68: aload_0
    //   69: sipush 30000
    //   72: invokevirtual 57	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   75: aload_0
    //   76: iconst_1
    //   77: invokevirtual 61	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   80: aload_0
    //   81: iconst_1
    //   82: invokevirtual 64	java/net/HttpURLConnection:setDoInput	(Z)V
    //   85: aload_0
    //   86: iconst_0
    //   87: invokevirtual 67	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   90: aload_0
    //   91: ldc 69
    //   93: invokevirtual 72	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: ldc 74
    //   99: ldc 76
    //   101: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: ldc 82
    //   107: aload 8
    //   109: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: ldc 84
    //   115: aload 9
    //   117: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: ldc 86
    //   123: ldc 88
    //   125: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: ldc 90
    //   131: aload_2
    //   132: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: new 92	java/io/DataOutputStream
    //   138: dup
    //   139: aload_0
    //   140: invokevirtual 96	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   143: invokespecial 99	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   146: astore_2
    //   147: new 101	java/io/File
    //   150: dup
    //   151: aload_1
    //   152: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore 4
    //   157: new 104	java/io/BufferedInputStream
    //   160: dup
    //   161: new 104	java/io/BufferedInputStream
    //   164: dup
    //   165: new 106	java/io/FileInputStream
    //   168: dup
    //   169: aload 4
    //   171: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   174: invokespecial 112	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   177: invokespecial 112	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   180: astore_1
    //   181: sipush 3072
    //   184: newarray byte
    //   186: astore 8
    //   188: aload_1
    //   189: aload 8
    //   191: invokevirtual 116	java/io/BufferedInputStream:read	([B)I
    //   194: istore_3
    //   195: iload_3
    //   196: iconst_m1
    //   197: if_icmpeq +99 -> 296
    //   200: aload_2
    //   201: aload 8
    //   203: iconst_0
    //   204: iload_3
    //   205: invokevirtual 120	java/io/DataOutputStream:write	([BII)V
    //   208: goto -20 -> 188
    //   211: astore 8
    //   213: ldc 122
    //   215: iconst_2
    //   216: new 124	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   223: ldc 129
    //   225: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 4
    //   230: invokevirtual 137	java/io/File:length	()J
    //   233: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   236: ldc 142
    //   238: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 4
    //   243: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   246: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_2
    //   256: invokevirtual 158	java/io/DataOutputStream:flush	()V
    //   259: aload_2
    //   260: invokevirtual 161	java/io/DataOutputStream:close	()V
    //   263: aload_0
    //   264: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   267: aload_2
    //   268: astore 4
    //   270: aload_1
    //   271: invokevirtual 165	java/io/BufferedInputStream:close	()V
    //   274: iconst_0
    //   275: ifeq +11 -> 286
    //   278: new 167	java/lang/NullPointerException
    //   281: dup
    //   282: invokespecial 168	java/lang/NullPointerException:<init>	()V
    //   285: athrow
    //   286: aload_2
    //   287: ifnull +7 -> 294
    //   290: aload_2
    //   291: invokevirtual 161	java/io/DataOutputStream:close	()V
    //   294: iconst_m1
    //   295: ireturn
    //   296: aload_1
    //   297: invokevirtual 165	java/io/BufferedInputStream:close	()V
    //   300: new 170	java/lang/StringBuffer
    //   303: dup
    //   304: invokespecial 171	java/lang/StringBuffer:<init>	()V
    //   307: astore_1
    //   308: new 173	java/io/BufferedReader
    //   311: dup
    //   312: new 175	java/io/InputStreamReader
    //   315: dup
    //   316: aload_0
    //   317: invokevirtual 179	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   320: invokespecial 180	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   323: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   326: astore 5
    //   328: aload 5
    //   330: invokevirtual 186	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   333: astore 4
    //   335: aload 4
    //   337: ifnull +126 -> 463
    //   340: aload_1
    //   341: aload 4
    //   343: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   346: ldc 191
    //   348: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   351: pop
    //   352: goto -24 -> 328
    //   355: astore 4
    //   357: aload_0
    //   358: astore_1
    //   359: aload_2
    //   360: astore_0
    //   361: aload 4
    //   363: astore_2
    //   364: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +12 -> 379
    //   370: ldc 122
    //   372: iconst_2
    //   373: ldc 197
    //   375: aload_2
    //   376: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   379: aload_1
    //   380: ifnull +7 -> 387
    //   383: aload_1
    //   384: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   387: aload_0
    //   388: ifnull +257 -> 645
    //   391: aload_0
    //   392: invokevirtual 161	java/io/DataOutputStream:close	()V
    //   395: iconst_m1
    //   396: istore_3
    //   397: iload_3
    //   398: ireturn
    //   399: astore 4
    //   401: aload_1
    //   402: invokevirtual 165	java/io/BufferedInputStream:close	()V
    //   405: aload 4
    //   407: athrow
    //   408: astore 4
    //   410: aload_0
    //   411: astore_1
    //   412: aload 4
    //   414: astore_0
    //   415: aload_2
    //   416: astore 4
    //   418: aload_1
    //   419: astore 5
    //   421: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +18 -> 442
    //   427: aload_2
    //   428: astore 4
    //   430: aload_1
    //   431: astore 5
    //   433: ldc 122
    //   435: iconst_2
    //   436: ldc 197
    //   438: aload_0
    //   439: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: aload_1
    //   443: ifnull +7 -> 450
    //   446: aload_1
    //   447: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   450: aload_2
    //   451: ifnull +194 -> 645
    //   454: aload_2
    //   455: invokevirtual 161	java/io/DataOutputStream:close	()V
    //   458: iconst_m1
    //   459: istore_3
    //   460: goto -63 -> 397
    //   463: aload_1
    //   464: invokevirtual 201	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   467: pop
    //   468: aload 5
    //   470: invokevirtual 202	java/io/BufferedReader:close	()V
    //   473: aload_0
    //   474: ifnull +7 -> 481
    //   477: aload_0
    //   478: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   481: aload_2
    //   482: ifnull +168 -> 650
    //   485: aload_2
    //   486: invokevirtual 161	java/io/DataOutputStream:close	()V
    //   489: iconst_0
    //   490: istore_3
    //   491: goto -94 -> 397
    //   494: astore_0
    //   495: iconst_0
    //   496: istore_3
    //   497: goto -100 -> 397
    //   500: astore_0
    //   501: iconst_m1
    //   502: istore_3
    //   503: goto -106 -> 397
    //   506: astore_0
    //   507: iconst_m1
    //   508: istore_3
    //   509: goto -112 -> 397
    //   512: astore_0
    //   513: aconst_null
    //   514: astore_2
    //   515: aload 4
    //   517: astore_1
    //   518: aload_1
    //   519: ifnull +7 -> 526
    //   522: aload_1
    //   523: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   526: aload_2
    //   527: ifnull +7 -> 534
    //   530: aload_2
    //   531: invokevirtual 161	java/io/DataOutputStream:close	()V
    //   534: aload_0
    //   535: athrow
    //   536: astore_0
    //   537: iconst_m1
    //   538: ireturn
    //   539: astore_1
    //   540: goto -6 -> 534
    //   543: astore 4
    //   545: aconst_null
    //   546: astore_2
    //   547: aload_0
    //   548: astore_1
    //   549: aload 4
    //   551: astore_0
    //   552: goto -34 -> 518
    //   555: astore 4
    //   557: aload_0
    //   558: astore_1
    //   559: aload 4
    //   561: astore_0
    //   562: goto -44 -> 518
    //   565: astore_0
    //   566: aload 4
    //   568: astore_2
    //   569: aload 5
    //   571: astore_1
    //   572: goto -54 -> 518
    //   575: astore 4
    //   577: aload_0
    //   578: astore_2
    //   579: aload 4
    //   581: astore_0
    //   582: goto -64 -> 518
    //   585: astore_0
    //   586: aconst_null
    //   587: astore_2
    //   588: aload 7
    //   590: astore_1
    //   591: goto -176 -> 415
    //   594: astore 4
    //   596: aconst_null
    //   597: astore_2
    //   598: aload_0
    //   599: astore_1
    //   600: aload 4
    //   602: astore_0
    //   603: goto -188 -> 415
    //   606: astore_0
    //   607: aload 7
    //   609: astore_1
    //   610: goto -195 -> 415
    //   613: astore_2
    //   614: aconst_null
    //   615: astore_0
    //   616: aload 6
    //   618: astore_1
    //   619: goto -255 -> 364
    //   622: astore_2
    //   623: aconst_null
    //   624: astore 4
    //   626: aload_0
    //   627: astore_1
    //   628: aload 4
    //   630: astore_0
    //   631: goto -267 -> 364
    //   634: astore_1
    //   635: aload_2
    //   636: astore_0
    //   637: aload_1
    //   638: astore_2
    //   639: aload 6
    //   641: astore_1
    //   642: goto -278 -> 364
    //   645: iconst_m1
    //   646: istore_3
    //   647: goto -250 -> 397
    //   650: iconst_0
    //   651: istore_3
    //   652: goto -255 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	paramJSONObject	JSONObject
    //   0	655	1	paramString1	String
    //   0	655	2	paramString2	String
    //   194	458	3	i	int
    //   4	338	4	localObject1	Object
    //   355	7	4	localException	Exception
    //   399	7	4	localObject2	Object
    //   408	5	4	localOutOfMemoryError1	OutOfMemoryError
    //   416	100	4	str	String
    //   543	7	4	localObject3	Object
    //   555	12	4	localObject4	Object
    //   575	5	4	localObject5	Object
    //   594	7	4	localOutOfMemoryError2	OutOfMemoryError
    //   624	5	4	localObject6	Object
    //   7	563	5	localObject7	Object
    //   10	630	6	localObject8	Object
    //   1	607	7	localObject9	Object
    //   35	167	8	localObject10	Object
    //   211	1	8	localOutOfMemoryError3	OutOfMemoryError
    //   18	98	9	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   188	195	211	java/lang/OutOfMemoryError
    //   200	208	211	java/lang/OutOfMemoryError
    //   147	188	355	java/lang/Exception
    //   296	328	355	java/lang/Exception
    //   328	335	355	java/lang/Exception
    //   340	352	355	java/lang/Exception
    //   401	408	355	java/lang/Exception
    //   463	473	355	java/lang/Exception
    //   188	195	399	finally
    //   200	208	399	finally
    //   213	267	399	finally
    //   147	188	408	java/lang/OutOfMemoryError
    //   296	328	408	java/lang/OutOfMemoryError
    //   328	335	408	java/lang/OutOfMemoryError
    //   340	352	408	java/lang/OutOfMemoryError
    //   401	408	408	java/lang/OutOfMemoryError
    //   463	473	408	java/lang/OutOfMemoryError
    //   485	489	494	java/io/IOException
    //   391	395	500	java/io/IOException
    //   454	458	506	java/io/IOException
    //   46	61	512	finally
    //   290	294	536	java/io/IOException
    //   530	534	539	java/io/IOException
    //   61	147	543	finally
    //   147	188	555	finally
    //   296	328	555	finally
    //   328	335	555	finally
    //   340	352	555	finally
    //   401	408	555	finally
    //   463	473	555	finally
    //   270	274	565	finally
    //   421	427	565	finally
    //   433	442	565	finally
    //   364	379	575	finally
    //   46	61	585	java/lang/OutOfMemoryError
    //   61	147	594	java/lang/OutOfMemoryError
    //   270	274	606	java/lang/OutOfMemoryError
    //   46	61	613	java/lang/Exception
    //   61	147	622	java/lang/Exception
    //   270	274	634	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: new 40	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 44	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 48	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 50	java/net/HttpURLConnection
    //   20: astore 7
    //   22: aload 7
    //   24: sipush 5000
    //   27: invokevirtual 54	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   30: aload 7
    //   32: sipush 30000
    //   35: invokevirtual 57	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   38: aload 7
    //   40: iconst_1
    //   41: invokevirtual 61	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   44: aload 7
    //   46: iconst_1
    //   47: invokevirtual 64	java/net/HttpURLConnection:setDoInput	(Z)V
    //   50: aload 7
    //   52: iconst_0
    //   53: invokevirtual 67	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   56: aload 7
    //   58: ldc 206
    //   60: invokevirtual 72	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   63: aload 7
    //   65: ldc 74
    //   67: ldc 76
    //   69: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 7
    //   74: ldc 86
    //   76: new 124	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   83: ldc 208
    //   85: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 210
    //   90: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 7
    //   101: ldc 212
    //   103: new 124	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   110: ldc 214
    //   112: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_2
    //   116: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 216
    //   121: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_3
    //   125: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: new 92	java/io/DataOutputStream
    //   137: dup
    //   138: aload 7
    //   140: invokevirtual 96	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   143: invokespecial 99	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   146: astore_2
    //   147: new 170	java/lang/StringBuffer
    //   150: dup
    //   151: invokespecial 171	java/lang/StringBuffer:<init>	()V
    //   154: astore 11
    //   156: aload 11
    //   158: ldc 218
    //   160: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   163: ldc 220
    //   165: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   168: ldc 210
    //   170: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   173: ldc 218
    //   175: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   178: pop
    //   179: aload 11
    //   181: ldc 222
    //   183: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   186: pop
    //   187: aload 11
    //   189: new 124	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   196: ldc 224
    //   198: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: lload 4
    //   203: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc 224
    //   208: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   217: pop
    //   218: aload_2
    //   219: aload 11
    //   221: invokevirtual 201	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   224: invokevirtual 230	java/lang/String:getBytes	()[B
    //   227: invokevirtual 235	java/io/OutputStream:write	([B)V
    //   230: aload 11
    //   232: iconst_0
    //   233: invokevirtual 238	java/lang/StringBuffer:setLength	(I)V
    //   236: aload 11
    //   238: ldc 218
    //   240: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   243: ldc 220
    //   245: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   248: ldc 210
    //   250: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   253: ldc 218
    //   255: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   258: pop
    //   259: aload 11
    //   261: new 124	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   268: ldc 240
    //   270: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_1
    //   274: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc 242
    //   279: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   288: pop
    //   289: aconst_null
    //   290: astore_3
    //   291: aload_1
    //   292: ldc 244
    //   294: invokevirtual 248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   297: ifeq +6 -> 303
    //   300: ldc 250
    //   302: astore_3
    //   303: aload_3
    //   304: ifnull +530 -> 834
    //   307: aload_3
    //   308: astore 8
    //   310: aload_3
    //   311: ldc 252
    //   313: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   316: ifeq +6 -> 322
    //   319: goto +515 -> 834
    //   322: aload 11
    //   324: new 124	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 258
    //   334: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 8
    //   339: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc_w 260
    //   345: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   354: pop
    //   355: aload_2
    //   356: aload 11
    //   358: invokevirtual 201	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   361: invokevirtual 230	java/lang/String:getBytes	()[B
    //   364: invokevirtual 235	java/io/OutputStream:write	([B)V
    //   367: new 262	java/io/DataInputStream
    //   370: dup
    //   371: new 106	java/io/FileInputStream
    //   374: dup
    //   375: aload_1
    //   376: invokespecial 263	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   379: invokespecial 264	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   382: astore_1
    //   383: sipush 1024
    //   386: newarray byte
    //   388: astore_3
    //   389: aload_1
    //   390: aload_3
    //   391: invokevirtual 265	java/io/DataInputStream:read	([B)I
    //   394: istore 6
    //   396: iload 6
    //   398: iconst_m1
    //   399: if_icmpeq +92 -> 491
    //   402: aload_2
    //   403: aload_3
    //   404: iconst_0
    //   405: iload 6
    //   407: invokevirtual 266	java/io/OutputStream:write	([BII)V
    //   410: goto -21 -> 389
    //   413: astore_3
    //   414: aload 7
    //   416: astore_3
    //   417: aconst_null
    //   418: astore 8
    //   420: aload_2
    //   421: astore 7
    //   423: aload_1
    //   424: astore_2
    //   425: aload 8
    //   427: astore_1
    //   428: ldc_w 268
    //   431: iconst_2
    //   432: new 124	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 270
    //   442: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_0
    //   446: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: aload_3
    //   456: ifnull +7 -> 463
    //   459: aload_3
    //   460: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   463: aload_2
    //   464: ifnull +7 -> 471
    //   467: aload_2
    //   468: invokevirtual 274	java/io/DataInputStream:close	()V
    //   471: aload 7
    //   473: ifnull +8 -> 481
    //   476: aload 7
    //   478: invokevirtual 275	java/io/OutputStream:close	()V
    //   481: aload_1
    //   482: ifnull +347 -> 829
    //   485: aload_1
    //   486: invokevirtual 202	java/io/BufferedReader:close	()V
    //   489: aconst_null
    //   490: areturn
    //   491: aload_2
    //   492: new 124	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 277
    //   502: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc 210
    //   507: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: ldc_w 279
    //   513: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokevirtual 230	java/lang/String:getBytes	()[B
    //   522: invokevirtual 235	java/io/OutputStream:write	([B)V
    //   525: aload_2
    //   526: invokevirtual 280	java/io/OutputStream:flush	()V
    //   529: aload 11
    //   531: iconst_0
    //   532: invokevirtual 238	java/lang/StringBuffer:setLength	(I)V
    //   535: new 173	java/io/BufferedReader
    //   538: dup
    //   539: new 175	java/io/InputStreamReader
    //   542: dup
    //   543: aload 7
    //   545: invokevirtual 179	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   548: invokespecial 180	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   551: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   554: astore_3
    //   555: aload_3
    //   556: invokevirtual 186	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   559: astore 8
    //   561: aload 8
    //   563: ifnull +19 -> 582
    //   566: aload 11
    //   568: aload 8
    //   570: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   573: ldc 191
    //   575: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   578: pop
    //   579: goto -24 -> 555
    //   582: aload 11
    //   584: invokevirtual 201	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   587: astore 8
    //   589: aload 7
    //   591: ifnull +8 -> 599
    //   594: aload 7
    //   596: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   599: aload_1
    //   600: ifnull +7 -> 607
    //   603: aload_1
    //   604: invokevirtual 274	java/io/DataInputStream:close	()V
    //   607: aload_2
    //   608: ifnull +7 -> 615
    //   611: aload_2
    //   612: invokevirtual 275	java/io/OutputStream:close	()V
    //   615: aload_3
    //   616: ifnull +215 -> 831
    //   619: aload_3
    //   620: invokevirtual 202	java/io/BufferedReader:close	()V
    //   623: aload 8
    //   625: areturn
    //   626: astore_0
    //   627: aload 8
    //   629: areturn
    //   630: astore_0
    //   631: aconst_null
    //   632: areturn
    //   633: astore_0
    //   634: aconst_null
    //   635: astore_3
    //   636: aconst_null
    //   637: astore_2
    //   638: aload 10
    //   640: astore_1
    //   641: aload 9
    //   643: astore 7
    //   645: aload_3
    //   646: ifnull +7 -> 653
    //   649: aload_3
    //   650: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   653: aload_1
    //   654: ifnull +7 -> 661
    //   657: aload_1
    //   658: invokevirtual 274	java/io/DataInputStream:close	()V
    //   661: aload_2
    //   662: ifnull +7 -> 669
    //   665: aload_2
    //   666: invokevirtual 275	java/io/OutputStream:close	()V
    //   669: aload 7
    //   671: ifnull +8 -> 679
    //   674: aload 7
    //   676: invokevirtual 202	java/io/BufferedReader:close	()V
    //   679: aload_0
    //   680: athrow
    //   681: astore_0
    //   682: goto -75 -> 607
    //   685: astore_0
    //   686: goto -71 -> 615
    //   689: astore_0
    //   690: goto -219 -> 471
    //   693: astore_0
    //   694: goto -213 -> 481
    //   697: astore_1
    //   698: goto -37 -> 661
    //   701: astore_1
    //   702: goto -33 -> 669
    //   705: astore_1
    //   706: goto -27 -> 679
    //   709: astore_0
    //   710: aconst_null
    //   711: astore_2
    //   712: aload 7
    //   714: astore_3
    //   715: aload 9
    //   717: astore 7
    //   719: aload 10
    //   721: astore_1
    //   722: goto -77 -> 645
    //   725: astore_0
    //   726: aload 7
    //   728: astore_3
    //   729: aload 9
    //   731: astore 7
    //   733: aload 10
    //   735: astore_1
    //   736: goto -91 -> 645
    //   739: astore_0
    //   740: aload 7
    //   742: astore_3
    //   743: aload 9
    //   745: astore 7
    //   747: goto -102 -> 645
    //   750: astore_0
    //   751: aload 7
    //   753: astore 8
    //   755: aload_3
    //   756: astore 7
    //   758: aload 8
    //   760: astore_3
    //   761: goto -116 -> 645
    //   764: astore_0
    //   765: aload 7
    //   767: astore 8
    //   769: aload_1
    //   770: astore 7
    //   772: aload_2
    //   773: astore_1
    //   774: aload 8
    //   776: astore_2
    //   777: goto -132 -> 645
    //   780: astore_1
    //   781: aconst_null
    //   782: astore_1
    //   783: aconst_null
    //   784: astore_2
    //   785: aconst_null
    //   786: astore 7
    //   788: aconst_null
    //   789: astore_3
    //   790: goto -362 -> 428
    //   793: astore_1
    //   794: aconst_null
    //   795: astore_2
    //   796: aconst_null
    //   797: astore 8
    //   799: aload 7
    //   801: astore_3
    //   802: aconst_null
    //   803: astore_1
    //   804: aload 8
    //   806: astore 7
    //   808: goto -380 -> 428
    //   811: astore_1
    //   812: aload 7
    //   814: astore_3
    //   815: aconst_null
    //   816: astore_1
    //   817: aconst_null
    //   818: astore 8
    //   820: aload_2
    //   821: astore 7
    //   823: aload 8
    //   825: astore_2
    //   826: goto -398 -> 428
    //   829: aconst_null
    //   830: areturn
    //   831: aload 8
    //   833: areturn
    //   834: ldc 88
    //   836: astore 8
    //   838: goto -516 -> 322
    //   841: astore 8
    //   843: aload_1
    //   844: astore 9
    //   846: aload 7
    //   848: astore 8
    //   850: aload_3
    //   851: astore_1
    //   852: aload_2
    //   853: astore 7
    //   855: aload 9
    //   857: astore_2
    //   858: aload 8
    //   860: astore_3
    //   861: goto -433 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	864	0	paramString1	String
    //   0	864	1	paramString2	String
    //   0	864	2	paramString3	String
    //   0	864	3	paramString4	String
    //   0	864	4	paramLong	long
    //   394	12	6	i	int
    //   20	834	7	localObject1	Object
    //   308	529	8	localObject2	Object
    //   841	1	8	localException	Exception
    //   848	11	8	localObject3	Object
    //   4	852	9	str	String
    //   1	733	10	localObject4	Object
    //   154	429	11	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   383	389	413	java/lang/Exception
    //   389	396	413	java/lang/Exception
    //   402	410	413	java/lang/Exception
    //   491	555	413	java/lang/Exception
    //   619	623	626	java/io/IOException
    //   485	489	630	java/io/IOException
    //   6	22	633	finally
    //   603	607	681	java/io/IOException
    //   611	615	685	java/io/IOException
    //   467	471	689	java/io/IOException
    //   476	481	693	java/io/IOException
    //   657	661	697	java/io/IOException
    //   665	669	701	java/io/IOException
    //   674	679	705	java/io/IOException
    //   22	147	709	finally
    //   147	289	725	finally
    //   291	300	725	finally
    //   310	319	725	finally
    //   322	383	725	finally
    //   383	389	739	finally
    //   389	396	739	finally
    //   402	410	739	finally
    //   491	555	739	finally
    //   555	561	750	finally
    //   566	579	750	finally
    //   582	589	750	finally
    //   428	455	764	finally
    //   6	22	780	java/lang/Exception
    //   22	147	793	java/lang/Exception
    //   147	289	811	java/lang/Exception
    //   291	300	811	java/lang/Exception
    //   310	319	811	java/lang/Exception
    //   322	383	811	java/lang/Exception
    //   555	561	841	java/lang/Exception
    //   566	579	841	java/lang/Exception
    //   582	589	841	java/lang/Exception
  }
  
  private static JSONObject a(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    try
    {
      paramString = jqa.a(paramAppRuntime.getApplication().getApplicationContext(), paramString, paramBundle1, paramBundle2);
      paramAppRuntime = paramString;
      if (paramString == null) {
        paramAppRuntime = "";
      }
      paramAppRuntime = new JSONObject(paramAppRuntime);
      return paramAppRuntime;
    }
    catch (IOException paramAppRuntime)
    {
      QLog.w("TroopHomeworkHelper", 2, paramAppRuntime.getMessage(), paramAppRuntime);
      return null;
    }
    catch (JSONException paramAppRuntime)
    {
      QLog.w("TroopHomeworkHelper", 2, paramAppRuntime.getMessage(), paramAppRuntime);
      return null;
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      QLog.w("TroopHomeworkHelper", 2, paramAppRuntime.getMessage(), paramAppRuntime);
    }
    return null;
  }
  
  public static JSONObject a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    String str = paramAppRuntime.getAccount();
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(paramAppRuntime.getAccount());; localObject = null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("filename", paramString1);
      localBundle.putString("gc", paramString2);
      localBundle.putString("file_sha1", paramString3);
      localBundle.putString("bkn", String.valueOf(apuh.eU((String)localObject)));
      paramString1 = new Bundle();
      paramString1.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      if (awjq.a().aNc()) {
        return a(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_auth/put", localBundle, paramString1);
      }
      return b(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_auth/put", localBundle, paramString1);
    }
  }
  
  private static JSONObject b(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    int i;
    try
    {
      String str = jqc.a(paramAppRuntime.getApplication().getApplicationContext(), paramString, "GET", paramBundle1, paramBundle2);
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = new JSONObject((String)localObject1);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      i = 1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException = localJSONException;
      QLog.w("TroopHomeworkHelper", 2, localJSONException.getMessage(), localJSONException);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.w("TroopHomeworkHelper", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
    }
    finally
    {
      i = 0;
    }
    if (i != 0)
    {
      QLog.e("TroopHomeworkHelper", 2, "getCosUploadByHttpClient io error, use getCosUploadByHttpURLConnection again");
      a(paramAppRuntime, paramString, paramBundle1, paramBundle2);
    }
    throw localObject2;
    return null;
  }
  
  public static JSONObject b(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    String str = paramAppRuntime.getAccount();
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(paramAppRuntime.getAccount());; localObject = null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("filename", paramString1);
      localBundle.putString("gc", paramString2);
      localBundle.putString("positions", paramString3);
      localBundle.putString("bkn", String.valueOf(apuh.eU((String)localObject)));
      paramString1 = new Bundle();
      paramString1.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      if (awjq.a().aNc()) {
        return a(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_append", localBundle, paramString1);
      }
      return b(paramAppRuntime, "https://qun.qq.com/cgi-bin/grouphw/upload_append", localBundle, paramString1);
    }
  }
  
  public static int f(Context paramContext, String paramString1, String paramString2)
  {
    int j = 1;
    long l1 = System.currentTimeMillis();
    int i;
    boolean bool;
    if (ShortVideoTrimmer.b(paramContext, 0, 0))
    {
      Object localObject = ShortVideoTrimmer.a(paramString1);
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((ShortVideoTrimmer.a)localObject).cHR)
        {
          if (Build.VERSION.SDK_INT < 18) {
            break label357;
          }
          i = anig.az(paramContext);
          if (((i & 0x1) <= 0) || ((i & 0x2) <= 0)) {
            break label342;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: isHWCodecSupported = " + bool);
          }
          if (!bool) {
            break label357;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: Try to compress using MediaCodec");
          }
          File localFile = new File(paramString1);
          localObject = new awjs.a(paramString2, (int)(((ShortVideoTrimmer.a)localObject).alX * 1024L), (int)((ShortVideoTrimmer.a)localObject).alW);
          if ((!new anli().a(localFile, (anli.a)localObject, true)) || (((awjs.a)localObject).e != null)) {
            break label348;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: compress completed using MediaCodec");
          }
          i = 0;
          label202:
          if (i == 0) {
            break label431;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
          }
          i = ShortVideoTrimmer.f(paramContext, paramString1, paramString2);
          if (i != 0) {
            break label362;
          }
          QLog.d("TroopHomeworkHelper", 1, "CompressTask, step:compress completed using ShortVideoTrimmer.compressVideo");
        }
      }
    }
    label431:
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      long l3 = new File(paramString1).length();
      long l4 = new File(paramString2).length();
      if (QLog.isColorLevel()) {
        QLog.d("TroopHomeworkHelper", 2, "CompressTask，step: ShortVideoTrimmer compress ret = " + i + ", cost:" + (l2 - l1) + "ms, fileSourceSize=" + l3 + ", fileTargetSize=" + l4);
      }
      return i;
      label342:
      bool = false;
      break;
      label348:
      QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: compress failed using MediaCodecr");
      label357:
      i = -1;
      break label202;
      try
      {
        label362:
        paramContext = new File(paramString2);
        if (paramContext.exists()) {
          paramContext.delete();
        }
        QLog.d("TroopHomeworkHelper", 1, "CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = " + i);
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      QLog.e("TroopHomeworkHelper", 2, "CompressTask，step: ShortVideoTrimmer init failure, ignore compress");
      return -1;
    }
  }
  
  public static String gt(String paramString)
  {
    Object localObject = acbn.bmm;
    long l = System.currentTimeMillis();
    String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l));
    localObject = new StringBuilder((String)localObject).append("stream").append(str);
    if (paramString.toLowerCase().endsWith(".slk")) {
      ((StringBuilder)localObject).append(".slk");
    }
    for (;;)
    {
      return aqul.getSDKPrivatePath(((StringBuilder)localObject).toString());
      ((StringBuilder)localObject).append(".amr");
    }
  }
  
  /* Error */
  public static String so(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokestatic 511	awjs:gt	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 6
    //   9: new 101	java/io/File
    //   12: dup
    //   13: aload 6
    //   15: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 4
    //   20: aload 4
    //   22: invokevirtual 462	java/io/File:exists	()Z
    //   25: ifne +27 -> 52
    //   28: aload 4
    //   30: invokevirtual 515	java/io/File:getParentFile	()Ljava/io/File;
    //   33: astore_2
    //   34: aload_2
    //   35: invokevirtual 462	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: aload_2
    //   42: invokevirtual 518	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: aload 4
    //   48: invokevirtual 521	java/io/File:createNewFile	()Z
    //   51: pop
    //   52: new 40	java/net/URL
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 44	java/net/URL:<init>	(Ljava/lang/String;)V
    //   60: invokevirtual 48	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   63: checkcast 50	java/net/HttpURLConnection
    //   66: astore_2
    //   67: aload_2
    //   68: sipush 5000
    //   71: invokevirtual 54	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   74: aload_2
    //   75: sipush 30000
    //   78: invokevirtual 57	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   81: aload_2
    //   82: ldc_w 366
    //   85: invokevirtual 72	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: ldc 74
    //   91: ldc 76
    //   93: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_2
    //   97: invokevirtual 179	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   100: astore_3
    //   101: new 523	java/io/FileOutputStream
    //   104: dup
    //   105: aload 4
    //   107: iconst_1
    //   108: invokespecial 526	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   111: astore 4
    //   113: sipush 1024
    //   116: newarray byte
    //   118: astore 5
    //   120: aload_3
    //   121: aload 5
    //   123: invokevirtual 529	java/io/InputStream:read	([B)I
    //   126: istore_1
    //   127: iload_1
    //   128: iconst_m1
    //   129: if_icmpeq +91 -> 220
    //   132: aload 4
    //   134: aload 5
    //   136: iconst_0
    //   137: iload_1
    //   138: invokevirtual 530	java/io/FileOutputStream:write	([BII)V
    //   141: goto -21 -> 120
    //   144: astore 5
    //   146: aload 4
    //   148: astore 5
    //   150: aload_2
    //   151: astore 4
    //   153: aload_3
    //   154: astore_2
    //   155: aload 5
    //   157: astore_3
    //   158: ldc_w 268
    //   161: iconst_2
    //   162: new 124	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 532
    //   172: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   195: aload_2
    //   196: ifnull +7 -> 203
    //   199: aload_2
    //   200: invokevirtual 533	java/io/InputStream:close	()V
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: aload_0
    //   215: invokevirtual 535	java/io/IOException:printStackTrace	()V
    //   218: aconst_null
    //   219: areturn
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 533	java/io/InputStream:close	()V
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   246: aload 6
    //   248: areturn
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_2
    //   252: aconst_null
    //   253: astore 4
    //   255: aload 5
    //   257: astore_3
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 533	java/io/InputStream:close	()V
    //   276: aload_3
    //   277: ifnull +7 -> 284
    //   280: aload_3
    //   281: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   284: aload_0
    //   285: athrow
    //   286: astore_0
    //   287: goto -51 -> 236
    //   290: astore_0
    //   291: goto -45 -> 246
    //   294: astore_0
    //   295: goto -92 -> 203
    //   298: astore_0
    //   299: goto -88 -> 211
    //   302: astore_2
    //   303: goto -27 -> 276
    //   306: astore_2
    //   307: goto -23 -> 284
    //   310: astore_0
    //   311: aload_2
    //   312: astore 4
    //   314: aconst_null
    //   315: astore_2
    //   316: aload 5
    //   318: astore_3
    //   319: goto -61 -> 258
    //   322: astore_0
    //   323: aload_2
    //   324: astore 4
    //   326: aload_3
    //   327: astore_2
    //   328: aload 5
    //   330: astore_3
    //   331: goto -73 -> 258
    //   334: astore_0
    //   335: aload_3
    //   336: astore 5
    //   338: aload_2
    //   339: astore 6
    //   341: aload 4
    //   343: astore_3
    //   344: aload 5
    //   346: astore_2
    //   347: aload 6
    //   349: astore 4
    //   351: goto -93 -> 258
    //   354: astore_0
    //   355: goto -97 -> 258
    //   358: astore_2
    //   359: aconst_null
    //   360: astore_3
    //   361: aconst_null
    //   362: astore_2
    //   363: aconst_null
    //   364: astore 4
    //   366: goto -208 -> 158
    //   369: astore_3
    //   370: aconst_null
    //   371: astore 5
    //   373: aload_2
    //   374: astore 4
    //   376: aconst_null
    //   377: astore_3
    //   378: aload 5
    //   380: astore_2
    //   381: goto -223 -> 158
    //   384: astore 4
    //   386: aload_3
    //   387: astore 4
    //   389: aload_2
    //   390: astore 5
    //   392: aconst_null
    //   393: astore_3
    //   394: aload 4
    //   396: astore_2
    //   397: aload 5
    //   399: astore 4
    //   401: goto -243 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramString	String
    //   126	12	1	i	int
    //   33	240	2	localObject1	Object
    //   302	1	2	localIOException1	IOException
    //   306	6	2	localIOException2	IOException
    //   315	32	2	localObject2	Object
    //   358	1	2	localException1	Exception
    //   362	35	2	localObject3	Object
    //   100	261	3	localObject4	Object
    //   369	1	3	localException2	Exception
    //   377	17	3	localObject5	Object
    //   18	357	4	localObject6	Object
    //   384	1	4	localException3	Exception
    //   387	13	4	localObject7	Object
    //   1	134	5	arrayOfByte	byte[]
    //   144	1	5	localException4	Exception
    //   148	250	5	localObject8	Object
    //   7	341	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   113	120	144	java/lang/Exception
    //   120	127	144	java/lang/Exception
    //   132	141	144	java/lang/Exception
    //   46	52	213	java/io/IOException
    //   52	67	249	finally
    //   232	236	286	java/io/IOException
    //   241	246	290	java/io/IOException
    //   199	203	294	java/io/IOException
    //   207	211	298	java/io/IOException
    //   272	276	302	java/io/IOException
    //   280	284	306	java/io/IOException
    //   67	101	310	finally
    //   101	113	322	finally
    //   113	120	334	finally
    //   120	127	334	finally
    //   132	141	334	finally
    //   158	185	354	finally
    //   52	67	358	java/lang/Exception
    //   67	101	369	java/lang/Exception
    //   101	113	384	java/lang/Exception
  }
  
  public static String sp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l2;
    do
    {
      do
      {
        return null;
        paramString = new File(paramString);
      } while (!paramString.exists());
      l2 = paramString.length();
    } while (l2 == 0L);
    paramString = new StringBuilder();
    for (long l1 = 0L; l1 < l2; l1 += 1048576L)
    {
      paramString.append(l1 + ",");
      if (l2 - l1 <= 4096L) {
        break;
      }
    }
    paramString.deleteCharAt(paramString.length() - 1);
    return paramString.toString();
  }
  
  public static class a
    implements anli.a
  {
    final String JV;
    final int agS;
    final int agT;
    Throwable e;
    
    a(String paramString, int paramInt1, int paramInt2)
    {
      this.JV = paramString;
      this.agS = paramInt1;
      if (paramInt2 > 0) {}
      for (this.agT = paramInt2;; this.agT = 30)
      {
        this.e = null;
        if (paramString != null) {
          break;
        }
        throw new IllegalArgumentException("null == outputFilePath");
      }
    }
    
    public anli.b a(int paramInt1, int paramInt2)
    {
      int i = 0;
      anli.b localb = new anli.b();
      int k;
      Object localObject;
      if (paramInt1 <= paramInt2)
      {
        k = paramInt2;
        localObject = new File(this.JV);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        localb.as = ((File)localObject);
        localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.lvcc.name(), "640|640|384|768|30");
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label431;
        }
        localObject = ((String)localObject).split("\\|");
        if ((localObject == null) || (localObject.length <= 4)) {
          break label431;
        }
      }
      label431:
      for (;;)
      {
        try
        {
          i = Integer.valueOf(localObject[1]).intValue();
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          paramInt1 = 0;
          paramInt2 = 0;
          i = 0;
        }
        try
        {
          paramInt2 = Integer.valueOf(localObject[2]).intValue();
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            label344:
            int n;
            paramInt1 = 0;
            paramInt2 = 0;
          }
        }
        try
        {
          paramInt1 = Integer.valueOf(localObject[3]).intValue();
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          paramInt1 = 0;
          break label344;
        }
        try
        {
          m = Integer.valueOf(localObject[4]).intValue();
          j = i;
          i = paramInt2;
          paramInt2 = m;
          m = j;
          if (j <= 0) {
            m = 640;
          }
          j = i;
          if (i <= 0) {
            j = 384;
          }
          i = paramInt1;
          if (paramInt1 <= 0) {
            i = 768;
          }
          paramInt1 = paramInt2;
          if (paramInt2 <= 0) {
            paramInt1 = 30;
          }
          localb.scaleRate = (m / k);
          localb.videoBitRate = ((int)(this.agS * localb.scaleRate * localb.scaleRate + 0.5F));
          if (localb.videoBitRate <= i * 1024) {
            break label382;
          }
          localb.videoBitRate = (i * 1024);
          paramInt2 = paramInt1;
          if (this.agT <= paramInt1) {
            paramInt2 = this.agT;
          }
          localb.videoFrameRate = paramInt2;
          localb.cHX = rk();
          if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localb.cHX);
          }
          return localb;
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          break label344;
        }
        k = paramInt1;
        break;
        if (QLog.isColorLevel()) {
          QLog.e("TroopHomeworkHelper", 2, "getEncodeConfig -> get DpcConfig Erro", localNumberFormatException1);
        }
        n = 0;
        int j = paramInt2;
        int m = i;
        paramInt2 = n;
        i = j;
        j = m;
        continue;
        label382:
        if (localb.videoBitRate < j * 1024)
        {
          localb.videoBitRate = (j * 1024);
          continue;
          paramInt2 = 0;
          paramInt1 = 0;
          j = 0;
        }
      }
    }
    
    public void ahK()
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onSuccessed");
      }
    }
    
    public void f(Throwable paramThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onFailed");
      }
      this.e = paramThrowable;
    }
    
    public void onCanceled() {}
    
    public void onProgress(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
      }
    }
    
    public boolean rk()
    {
      boolean bool = false;
      if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
        bool = true;
      }
      while (Build.VERSION.SDK_INT <= 19) {
        return bool;
      }
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onComplete(String paramString);
    
    public abstract void onError(int paramInt);
    
    public abstract void onProgress(int paramInt);
  }
  
  public static class c
  {
    awjs.b a;
    OkHttpClient b;
    String cQT;
    JSONObject co;
    boolean dqA = true;
    long fB;
    String mFileName;
    String mHost;
    boolean mIsStop = false;
    int mRetryTimes;
    AppRuntime mRuntime;
    String mTroopUin;
    
    public c(AppRuntime paramAppRuntime, String paramString1, String paramString2)
    {
      this.mFileName = paramString1;
      this.mRuntime = paramAppRuntime;
      this.mTroopUin = paramString2;
      this.fB = 0L;
    }
    
    private String a(int paramInt, JSONArray paramJSONArray)
      throws InvalidParameterException
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject.optInt("position") == paramInt) {
          return localJSONObject.optString("authorization");
        }
        i += 1;
      }
      throw new InvalidParameterException("not found auth data");
    }
    
    /* Error */
    private void appendFile()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 85	awjs$c:b	Lokhttp3/OkHttpClient;
      //   4: ifnonnull +47 -> 51
      //   7: aload_0
      //   8: new 87	okhttp3/OkHttpClient
      //   11: dup
      //   12: invokespecial 88	okhttp3/OkHttpClient:<init>	()V
      //   15: invokevirtual 92	okhttp3/OkHttpClient:newBuilder	()Lokhttp3/OkHttpClient$Builder;
      //   18: ldc2_w 93
      //   21: getstatic 100	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   24: invokevirtual 106	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
      //   27: ldc2_w 93
      //   30: getstatic 100	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   33: invokevirtual 109	okhttp3/OkHttpClient$Builder:writeTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
      //   36: ldc2_w 93
      //   39: getstatic 100	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   42: invokevirtual 112	okhttp3/OkHttpClient$Builder:readTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
      //   45: invokevirtual 116	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
      //   48: putfield 85	awjs$c:b	Lokhttp3/OkHttpClient;
      //   51: invokestatic 122	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   54: invokestatic 128	aqiw:getNetworkType	(Landroid/content/Context;)I
      //   57: istore_3
      //   58: aload_0
      //   59: aload_0
      //   60: getfield 130	awjs$c:co	Lorg/json/JSONObject;
      //   63: ldc 132
      //   65: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   68: putfield 134	awjs$c:mHost	Ljava/lang/String;
      //   71: aload_0
      //   72: aload_0
      //   73: getfield 130	awjs$c:co	Lorg/json/JSONObject;
      //   76: ldc 136
      //   78: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   81: putfield 138	awjs$c:cQT	Ljava/lang/String;
      //   84: aload_0
      //   85: getfield 130	awjs$c:co	Lorg/json/JSONObject;
      //   88: ldc 140
      //   90: invokevirtual 144	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   93: astore 14
      //   95: aload_0
      //   96: iconst_3
      //   97: putfield 146	awjs$c:mRetryTimes	I
      //   100: new 148	java/io/RandomAccessFile
      //   103: dup
      //   104: aload_0
      //   105: getfield 38	awjs$c:mFileName	Ljava/lang/String;
      //   108: ldc 150
      //   110: invokespecial 153	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   113: astore 13
      //   115: aload 13
      //   117: astore 12
      //   119: aload 13
      //   121: invokevirtual 156	java/io/RandomAccessFile:length	()J
      //   124: lstore 9
      //   126: aload 13
      //   128: astore 12
      //   130: aload_0
      //   131: getfield 44	awjs$c:fB	J
      //   134: lstore 5
      //   136: aload 13
      //   138: astore 12
      //   140: aload_0
      //   141: getfield 44	awjs$c:fB	J
      //   144: lload 9
      //   146: lcmp
      //   147: ifge +701 -> 848
      //   150: aload 13
      //   152: astore 12
      //   154: aload_0
      //   155: getfield 34	awjs$c:mIsStop	Z
      //   158: istore 11
      //   160: iload 11
      //   162: ifeq +22 -> 184
      //   165: aload 13
      //   167: ifnull +8 -> 175
      //   170: aload 13
      //   172: invokevirtual 159	java/io/RandomAccessFile:close	()V
      //   175: return
      //   176: astore 12
      //   178: aload 12
      //   180: invokevirtual 162	java/io/IOException:printStackTrace	()V
      //   183: return
      //   184: aload 13
      //   186: astore 12
      //   188: lload 9
      //   190: aload_0
      //   191: getfield 44	awjs$c:fB	J
      //   194: lsub
      //   195: ldc2_w 163
      //   198: lcmp
      //   199: ifle +121 -> 320
      //   202: aload 13
      //   204: astore 12
      //   206: aload_0
      //   207: aload_0
      //   208: getfield 44	awjs$c:fB	J
      //   211: ldc2_w 165
      //   214: ladd
      //   215: putfield 44	awjs$c:fB	J
      //   218: aload 13
      //   220: astore 12
      //   222: aload_0
      //   223: getfield 44	awjs$c:fB	J
      //   226: lload 5
      //   228: lsub
      //   229: lstore 7
      //   231: aload 13
      //   233: astore 12
      //   235: lload 7
      //   237: l2i
      //   238: newarray byte
      //   240: astore 15
      //   242: iconst_0
      //   243: istore_1
      //   244: aload 13
      //   246: astore 12
      //   248: aload 13
      //   250: lload 5
      //   252: invokevirtual 170	java/io/RandomAccessFile:seek	(J)V
      //   255: aload 13
      //   257: astore 12
      //   259: sipush 4096
      //   262: newarray byte
      //   264: astore 16
      //   266: aload 13
      //   268: astore 12
      //   270: aload 13
      //   272: aload 16
      //   274: invokevirtual 174	java/io/RandomAccessFile:read	([B)I
      //   277: istore 4
      //   279: iload_1
      //   280: istore_2
      //   281: iload 4
      //   283: ifle +190 -> 473
      //   286: iload_1
      //   287: iload 4
      //   289: iadd
      //   290: i2l
      //   291: lload 7
      //   293: lcmp
      //   294: ifgt +154 -> 448
      //   297: aload 13
      //   299: astore 12
      //   301: aload 16
      //   303: iconst_0
      //   304: aload 15
      //   306: iload_1
      //   307: iload 4
      //   309: invokestatic 180	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   312: iload_1
      //   313: iload 4
      //   315: iadd
      //   316: istore_1
      //   317: goto -51 -> 266
      //   320: aload 13
      //   322: astore 12
      //   324: aload_0
      //   325: lload 9
      //   327: putfield 44	awjs$c:fB	J
      //   330: goto -112 -> 218
      //   333: astore 14
      //   335: aload 13
      //   337: astore 12
      //   339: aload 14
      //   341: astore 13
      //   343: ldc 182
      //   345: iconst_2
      //   346: new 184	java/lang/StringBuilder
      //   349: dup
      //   350: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   353: ldc 187
      //   355: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   358: aload 13
      //   360: invokevirtual 195	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
      //   363: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   366: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   369: aload 13
      //   371: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   374: aload_0
      //   375: getfield 206	awjs$c:a	Lawjs$b;
      //   378: ifnull +14 -> 392
      //   381: aload_0
      //   382: getfield 206	awjs$c:a	Lawjs$b;
      //   385: bipush 6
      //   387: invokeinterface 212 2 0
      //   392: ldc 214
      //   394: ldc 216
      //   396: ldc 218
      //   398: ldc 220
      //   400: new 184	java/lang/StringBuilder
      //   403: dup
      //   404: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   407: iload_3
      //   408: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   411: ldc 220
      //   413: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   416: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   419: ldc 220
      //   421: invokestatic 229	apue:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   424: aload_0
      //   425: lconst_0
      //   426: putfield 44	awjs$c:fB	J
      //   429: aload 12
      //   431: ifnull -256 -> 175
      //   434: aload 12
      //   436: invokevirtual 159	java/io/RandomAccessFile:close	()V
      //   439: return
      //   440: astore 12
      //   442: aload 12
      //   444: invokevirtual 162	java/io/IOException:printStackTrace	()V
      //   447: return
      //   448: lload 7
      //   450: iload_1
      //   451: i2l
      //   452: lsub
      //   453: l2i
      //   454: istore_2
      //   455: aload 13
      //   457: astore 12
      //   459: aload 16
      //   461: iconst_0
      //   462: aload 15
      //   464: iload_1
      //   465: iload_2
      //   466: invokestatic 180	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   469: lload 7
      //   471: l2i
      //   472: istore_2
      //   473: aload 13
      //   475: astore 12
      //   477: ldc 231
      //   479: invokestatic 237	okhttp3/MediaType:parse	(Ljava/lang/String;)Lokhttp3/MediaType;
      //   482: aload 15
      //   484: iconst_0
      //   485: iload_2
      //   486: invokestatic 243	okhttp3/RequestBody:create	(Lokhttp3/MediaType;[BII)Lokhttp3/RequestBody;
      //   489: astore 15
      //   491: aload 13
      //   493: astore 12
      //   495: new 245	okhttp3/Request$Builder
      //   498: dup
      //   499: invokespecial 246	okhttp3/Request$Builder:<init>	()V
      //   502: new 184	java/lang/StringBuilder
      //   505: dup
      //   506: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   509: aload_0
      //   510: getfield 138	awjs$c:cQT	Ljava/lang/String;
      //   513: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   516: ldc 248
      //   518: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   521: lload 5
      //   523: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   526: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   529: invokevirtual 255	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
      //   532: ldc_w 257
      //   535: aload_0
      //   536: getfield 134	awjs$c:mHost	Ljava/lang/String;
      //   539: invokevirtual 261	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
      //   542: ldc_w 263
      //   545: ldc_w 265
      //   548: invokevirtual 261	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
      //   551: ldc_w 267
      //   554: ldc 231
      //   556: invokevirtual 261	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
      //   559: ldc_w 269
      //   562: aload_0
      //   563: lload 5
      //   565: l2i
      //   566: aload 14
      //   568: invokespecial 271	awjs$c:a	(ILorg/json/JSONArray;)Ljava/lang/String;
      //   571: invokevirtual 261	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
      //   574: aload 15
      //   576: invokevirtual 275	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
      //   579: invokevirtual 278	okhttp3/Request$Builder:build	()Lokhttp3/Request;
      //   582: astore 15
      //   584: aload 13
      //   586: astore 12
      //   588: aload_0
      //   589: getfield 85	awjs$c:b	Lokhttp3/OkHttpClient;
      //   592: aload 15
      //   594: invokevirtual 282	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
      //   597: invokeinterface 288 1 0
      //   602: astore 15
      //   604: aload 13
      //   606: astore 12
      //   608: aload 15
      //   610: invokevirtual 294	okhttp3/Response:isSuccessful	()Z
      //   613: ifeq +135 -> 748
      //   616: aload 13
      //   618: astore 12
      //   620: aload_0
      //   621: getfield 206	awjs$c:a	Lawjs$b;
      //   624: ifnull +98 -> 722
      //   627: aload 13
      //   629: astore 12
      //   631: aload_0
      //   632: getfield 206	awjs$c:a	Lawjs$b;
      //   635: iload_2
      //   636: i2l
      //   637: lload 5
      //   639: ladd
      //   640: ldc2_w 295
      //   643: lmul
      //   644: lload 9
      //   646: ldiv
      //   647: l2i
      //   648: invokeinterface 299 2 0
      //   653: aload 13
      //   655: astore 12
      //   657: aload_0
      //   658: getfield 44	awjs$c:fB	J
      //   661: lload 9
      //   663: lcmp
      //   664: iflt +58 -> 722
      //   667: aload 13
      //   669: astore 12
      //   671: ldc 214
      //   673: ldc 216
      //   675: ldc_w 301
      //   678: ldc_w 303
      //   681: new 184	java/lang/StringBuilder
      //   684: dup
      //   685: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   688: iload_3
      //   689: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   692: ldc 220
      //   694: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   697: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   700: ldc 220
      //   702: invokestatic 229	apue:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   705: aload 13
      //   707: astore 12
      //   709: aload_0
      //   710: getfield 206	awjs$c:a	Lawjs$b;
      //   713: aload_0
      //   714: getfield 138	awjs$c:cQT	Ljava/lang/String;
      //   717: invokeinterface 306 2 0
      //   722: aload 13
      //   724: astore 12
      //   726: aload_0
      //   727: iconst_3
      //   728: putfield 146	awjs$c:mRetryTimes	I
      //   731: aload 13
      //   733: astore 12
      //   735: aload_0
      //   736: getfield 44	awjs$c:fB	J
      //   739: lstore 7
      //   741: lload 7
      //   743: lstore 5
      //   745: goto +603 -> 1348
      //   748: aload 13
      //   750: astore 12
      //   752: aload_0
      //   753: getfield 146	awjs$c:mRetryTimes	I
      //   756: iconst_1
      //   757: isub
      //   758: istore_1
      //   759: aload 13
      //   761: astore 12
      //   763: aload_0
      //   764: iload_1
      //   765: putfield 146	awjs$c:mRetryTimes	I
      //   768: iload_1
      //   769: ifgt +98 -> 867
      //   772: aload 13
      //   774: astore 12
      //   776: ldc 214
      //   778: ldc 216
      //   780: ldc_w 308
      //   783: ldc 220
      //   785: new 184	java/lang/StringBuilder
      //   788: dup
      //   789: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   792: iload_3
      //   793: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   796: ldc 220
      //   798: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   801: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   804: ldc 220
      //   806: invokestatic 229	apue:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   809: aload 13
      //   811: astore 12
      //   813: aload_0
      //   814: getfield 206	awjs$c:a	Lawjs$b;
      //   817: ifnull +531 -> 1348
      //   820: aload 13
      //   822: astore 12
      //   824: aload_0
      //   825: getfield 206	awjs$c:a	Lawjs$b;
      //   828: aload 15
      //   830: invokevirtual 311	okhttp3/Response:code	()I
      //   833: invokeinterface 212 2 0
      //   838: aload 13
      //   840: astore 12
      //   842: aload_0
      //   843: lload 5
      //   845: putfield 44	awjs$c:fB	J
      //   848: aload 13
      //   850: ifnull -675 -> 175
      //   853: aload 13
      //   855: invokevirtual 159	java/io/RandomAccessFile:close	()V
      //   858: return
      //   859: astore 12
      //   861: aload 12
      //   863: invokevirtual 162	java/io/IOException:printStackTrace	()V
      //   866: return
      //   867: aload 13
      //   869: astore 12
      //   871: aload_0
      //   872: lload 5
      //   874: putfield 44	awjs$c:fB	J
      //   877: goto -741 -> 136
      //   880: astore 15
      //   882: aload 13
      //   884: astore 12
      //   886: ldc 182
      //   888: iconst_2
      //   889: new 184	java/lang/StringBuilder
      //   892: dup
      //   893: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   896: ldc 187
      //   898: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   901: aload 15
      //   903: invokevirtual 312	java/io/IOException:getMessage	()Ljava/lang/String;
      //   906: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   909: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   912: aload 15
      //   914: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   917: aload 13
      //   919: astore 12
      //   921: aload_0
      //   922: getfield 146	awjs$c:mRetryTimes	I
      //   925: iconst_1
      //   926: isub
      //   927: istore_1
      //   928: aload 13
      //   930: astore 12
      //   932: aload_0
      //   933: iload_1
      //   934: putfield 146	awjs$c:mRetryTimes	I
      //   937: iload_1
      //   938: ifgt +207 -> 1145
      //   941: aload 13
      //   943: astore 12
      //   945: ldc 214
      //   947: ldc 216
      //   949: ldc_w 314
      //   952: ldc 220
      //   954: new 184	java/lang/StringBuilder
      //   957: dup
      //   958: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   961: iload_3
      //   962: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   965: ldc 220
      //   967: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   970: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   973: ldc 220
      //   975: invokestatic 229	apue:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   978: aload 13
      //   980: astore 12
      //   982: aload_0
      //   983: getfield 206	awjs$c:a	Lawjs$b;
      //   986: ifnull +362 -> 1348
      //   989: aload 13
      //   991: astore 12
      //   993: aload_0
      //   994: getfield 206	awjs$c:a	Lawjs$b;
      //   997: bipush 6
      //   999: invokeinterface 212 2 0
      //   1004: aload 13
      //   1006: astore 12
      //   1008: aload_0
      //   1009: lload 5
      //   1011: putfield 44	awjs$c:fB	J
      //   1014: goto -166 -> 848
      //   1017: astore 14
      //   1019: aload 13
      //   1021: astore 12
      //   1023: ldc 182
      //   1025: iconst_2
      //   1026: new 184	java/lang/StringBuilder
      //   1029: dup
      //   1030: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   1033: ldc 187
      //   1035: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1038: aload 14
      //   1040: invokevirtual 312	java/io/IOException:getMessage	()Ljava/lang/String;
      //   1043: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1046: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1049: aload 14
      //   1051: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1054: aload 13
      //   1056: astore 12
      //   1058: aload_0
      //   1059: getfield 206	awjs$c:a	Lawjs$b;
      //   1062: ifnull +18 -> 1080
      //   1065: aload 13
      //   1067: astore 12
      //   1069: aload_0
      //   1070: getfield 206	awjs$c:a	Lawjs$b;
      //   1073: bipush 6
      //   1075: invokeinterface 212 2 0
      //   1080: aload 13
      //   1082: astore 12
      //   1084: ldc 214
      //   1086: ldc 216
      //   1088: ldc_w 316
      //   1091: ldc 220
      //   1093: new 184	java/lang/StringBuilder
      //   1096: dup
      //   1097: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   1100: iload_3
      //   1101: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1104: ldc 220
      //   1106: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1109: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1112: ldc 220
      //   1114: invokestatic 229	apue:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   1117: aload 13
      //   1119: astore 12
      //   1121: aload_0
      //   1122: lconst_0
      //   1123: putfield 44	awjs$c:fB	J
      //   1126: aload 13
      //   1128: ifnull -953 -> 175
      //   1131: aload 13
      //   1133: invokevirtual 159	java/io/RandomAccessFile:close	()V
      //   1136: return
      //   1137: astore 12
      //   1139: aload 12
      //   1141: invokevirtual 162	java/io/IOException:printStackTrace	()V
      //   1144: return
      //   1145: aload 13
      //   1147: astore 12
      //   1149: aload_0
      //   1150: lload 5
      //   1152: putfield 44	awjs$c:fB	J
      //   1155: goto -1019 -> 136
      //   1158: astore 14
      //   1160: aload 13
      //   1162: astore 12
      //   1164: ldc 182
      //   1166: iconst_2
      //   1167: new 184	java/lang/StringBuilder
      //   1170: dup
      //   1171: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   1174: ldc 187
      //   1176: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1179: aload 14
      //   1181: invokevirtual 317	java/security/InvalidParameterException:getMessage	()Ljava/lang/String;
      //   1184: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1187: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1190: aload 14
      //   1192: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1195: aload 13
      //   1197: astore 12
      //   1199: aload_0
      //   1200: getfield 206	awjs$c:a	Lawjs$b;
      //   1203: ifnull +18 -> 1221
      //   1206: aload 13
      //   1208: astore 12
      //   1210: aload_0
      //   1211: getfield 206	awjs$c:a	Lawjs$b;
      //   1214: bipush 6
      //   1216: invokeinterface 212 2 0
      //   1221: aload 13
      //   1223: astore 12
      //   1225: ldc 214
      //   1227: ldc 216
      //   1229: ldc_w 319
      //   1232: ldc 220
      //   1234: new 184	java/lang/StringBuilder
      //   1237: dup
      //   1238: invokespecial 185	java/lang/StringBuilder:<init>	()V
      //   1241: iload_3
      //   1242: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1245: ldc 220
      //   1247: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1250: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1253: ldc 220
      //   1255: invokestatic 229	apue:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   1258: aload 13
      //   1260: astore 12
      //   1262: aload_0
      //   1263: lconst_0
      //   1264: putfield 44	awjs$c:fB	J
      //   1267: aload 13
      //   1269: ifnull -1094 -> 175
      //   1272: aload 13
      //   1274: invokevirtual 159	java/io/RandomAccessFile:close	()V
      //   1277: return
      //   1278: astore 12
      //   1280: aload 12
      //   1282: invokevirtual 162	java/io/IOException:printStackTrace	()V
      //   1285: return
      //   1286: astore 13
      //   1288: aconst_null
      //   1289: astore 12
      //   1291: aload 12
      //   1293: ifnull +8 -> 1301
      //   1296: aload 12
      //   1298: invokevirtual 159	java/io/RandomAccessFile:close	()V
      //   1301: aload 13
      //   1303: athrow
      //   1304: astore 12
      //   1306: aload 12
      //   1308: invokevirtual 162	java/io/IOException:printStackTrace	()V
      //   1311: goto -10 -> 1301
      //   1314: astore 13
      //   1316: goto -25 -> 1291
      //   1319: astore 13
      //   1321: goto -30 -> 1291
      //   1324: astore 14
      //   1326: aconst_null
      //   1327: astore 13
      //   1329: goto -169 -> 1160
      //   1332: astore 14
      //   1334: aconst_null
      //   1335: astore 13
      //   1337: goto -318 -> 1019
      //   1340: astore 13
      //   1342: aconst_null
      //   1343: astore 12
      //   1345: goto -1002 -> 343
      //   1348: goto -1212 -> 136
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1351	0	this	c
      //   243	695	1	i	int
      //   280	356	2	j	int
      //   57	1185	3	k	int
      //   277	39	4	m	int
      //   134	1017	5	l1	long
      //   229	513	7	l2	long
      //   124	538	9	l3	long
      //   158	3	11	bool	boolean
      //   117	36	12	localObject1	Object
      //   176	3	12	localIOException1	IOException
      //   186	249	12	localObject2	Object
      //   440	3	12	localIOException2	IOException
      //   457	384	12	localObject3	Object
      //   859	3	12	localIOException3	IOException
      //   869	251	12	localObject4	Object
      //   1137	3	12	localIOException4	IOException
      //   1147	114	12	localObject5	Object
      //   1278	3	12	localIOException5	IOException
      //   1289	8	12	localObject6	Object
      //   1304	3	12	localIOException6	IOException
      //   1343	1	12	localObject7	Object
      //   113	1160	13	localObject8	Object
      //   1286	16	13	localObject9	Object
      //   1314	1	13	localObject10	Object
      //   1319	1	13	localObject11	Object
      //   1327	9	13	localObject12	Object
      //   1340	1	13	localFileNotFoundException1	java.io.FileNotFoundException
      //   93	1	14	localJSONArray	JSONArray
      //   333	234	14	localFileNotFoundException2	java.io.FileNotFoundException
      //   1017	33	14	localIOException7	IOException
      //   1158	33	14	localInvalidParameterException1	InvalidParameterException
      //   1324	1	14	localInvalidParameterException2	InvalidParameterException
      //   1332	1	14	localIOException8	IOException
      //   240	589	15	localObject13	Object
      //   880	33	15	localIOException9	IOException
      //   264	196	16	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   170	175	176	java/io/IOException
      //   119	126	333	java/io/FileNotFoundException
      //   130	136	333	java/io/FileNotFoundException
      //   140	150	333	java/io/FileNotFoundException
      //   154	160	333	java/io/FileNotFoundException
      //   188	202	333	java/io/FileNotFoundException
      //   206	218	333	java/io/FileNotFoundException
      //   222	231	333	java/io/FileNotFoundException
      //   235	242	333	java/io/FileNotFoundException
      //   248	255	333	java/io/FileNotFoundException
      //   259	266	333	java/io/FileNotFoundException
      //   270	279	333	java/io/FileNotFoundException
      //   301	312	333	java/io/FileNotFoundException
      //   324	330	333	java/io/FileNotFoundException
      //   459	469	333	java/io/FileNotFoundException
      //   477	491	333	java/io/FileNotFoundException
      //   495	584	333	java/io/FileNotFoundException
      //   588	604	333	java/io/FileNotFoundException
      //   608	616	333	java/io/FileNotFoundException
      //   620	627	333	java/io/FileNotFoundException
      //   631	653	333	java/io/FileNotFoundException
      //   657	667	333	java/io/FileNotFoundException
      //   671	705	333	java/io/FileNotFoundException
      //   709	722	333	java/io/FileNotFoundException
      //   726	731	333	java/io/FileNotFoundException
      //   735	741	333	java/io/FileNotFoundException
      //   752	759	333	java/io/FileNotFoundException
      //   763	768	333	java/io/FileNotFoundException
      //   776	809	333	java/io/FileNotFoundException
      //   813	820	333	java/io/FileNotFoundException
      //   824	838	333	java/io/FileNotFoundException
      //   842	848	333	java/io/FileNotFoundException
      //   871	877	333	java/io/FileNotFoundException
      //   886	917	333	java/io/FileNotFoundException
      //   921	928	333	java/io/FileNotFoundException
      //   932	937	333	java/io/FileNotFoundException
      //   945	978	333	java/io/FileNotFoundException
      //   982	989	333	java/io/FileNotFoundException
      //   993	1004	333	java/io/FileNotFoundException
      //   1008	1014	333	java/io/FileNotFoundException
      //   1149	1155	333	java/io/FileNotFoundException
      //   434	439	440	java/io/IOException
      //   853	858	859	java/io/IOException
      //   588	604	880	java/io/IOException
      //   608	616	880	java/io/IOException
      //   620	627	880	java/io/IOException
      //   631	653	880	java/io/IOException
      //   657	667	880	java/io/IOException
      //   671	705	880	java/io/IOException
      //   709	722	880	java/io/IOException
      //   726	731	880	java/io/IOException
      //   735	741	880	java/io/IOException
      //   752	759	880	java/io/IOException
      //   763	768	880	java/io/IOException
      //   776	809	880	java/io/IOException
      //   813	820	880	java/io/IOException
      //   824	838	880	java/io/IOException
      //   842	848	880	java/io/IOException
      //   871	877	880	java/io/IOException
      //   119	126	1017	java/io/IOException
      //   130	136	1017	java/io/IOException
      //   140	150	1017	java/io/IOException
      //   154	160	1017	java/io/IOException
      //   188	202	1017	java/io/IOException
      //   206	218	1017	java/io/IOException
      //   222	231	1017	java/io/IOException
      //   235	242	1017	java/io/IOException
      //   248	255	1017	java/io/IOException
      //   259	266	1017	java/io/IOException
      //   270	279	1017	java/io/IOException
      //   301	312	1017	java/io/IOException
      //   324	330	1017	java/io/IOException
      //   459	469	1017	java/io/IOException
      //   477	491	1017	java/io/IOException
      //   495	584	1017	java/io/IOException
      //   886	917	1017	java/io/IOException
      //   921	928	1017	java/io/IOException
      //   932	937	1017	java/io/IOException
      //   945	978	1017	java/io/IOException
      //   982	989	1017	java/io/IOException
      //   993	1004	1017	java/io/IOException
      //   1008	1014	1017	java/io/IOException
      //   1149	1155	1017	java/io/IOException
      //   1131	1136	1137	java/io/IOException
      //   119	126	1158	java/security/InvalidParameterException
      //   130	136	1158	java/security/InvalidParameterException
      //   140	150	1158	java/security/InvalidParameterException
      //   154	160	1158	java/security/InvalidParameterException
      //   188	202	1158	java/security/InvalidParameterException
      //   206	218	1158	java/security/InvalidParameterException
      //   222	231	1158	java/security/InvalidParameterException
      //   235	242	1158	java/security/InvalidParameterException
      //   248	255	1158	java/security/InvalidParameterException
      //   259	266	1158	java/security/InvalidParameterException
      //   270	279	1158	java/security/InvalidParameterException
      //   301	312	1158	java/security/InvalidParameterException
      //   324	330	1158	java/security/InvalidParameterException
      //   459	469	1158	java/security/InvalidParameterException
      //   477	491	1158	java/security/InvalidParameterException
      //   495	584	1158	java/security/InvalidParameterException
      //   588	604	1158	java/security/InvalidParameterException
      //   608	616	1158	java/security/InvalidParameterException
      //   620	627	1158	java/security/InvalidParameterException
      //   631	653	1158	java/security/InvalidParameterException
      //   657	667	1158	java/security/InvalidParameterException
      //   671	705	1158	java/security/InvalidParameterException
      //   709	722	1158	java/security/InvalidParameterException
      //   726	731	1158	java/security/InvalidParameterException
      //   735	741	1158	java/security/InvalidParameterException
      //   752	759	1158	java/security/InvalidParameterException
      //   763	768	1158	java/security/InvalidParameterException
      //   776	809	1158	java/security/InvalidParameterException
      //   813	820	1158	java/security/InvalidParameterException
      //   824	838	1158	java/security/InvalidParameterException
      //   842	848	1158	java/security/InvalidParameterException
      //   871	877	1158	java/security/InvalidParameterException
      //   886	917	1158	java/security/InvalidParameterException
      //   921	928	1158	java/security/InvalidParameterException
      //   932	937	1158	java/security/InvalidParameterException
      //   945	978	1158	java/security/InvalidParameterException
      //   982	989	1158	java/security/InvalidParameterException
      //   993	1004	1158	java/security/InvalidParameterException
      //   1008	1014	1158	java/security/InvalidParameterException
      //   1149	1155	1158	java/security/InvalidParameterException
      //   1272	1277	1278	java/io/IOException
      //   100	115	1286	finally
      //   1296	1301	1304	java/io/IOException
      //   119	126	1314	finally
      //   130	136	1314	finally
      //   140	150	1314	finally
      //   154	160	1314	finally
      //   188	202	1314	finally
      //   206	218	1314	finally
      //   222	231	1314	finally
      //   235	242	1314	finally
      //   248	255	1314	finally
      //   259	266	1314	finally
      //   270	279	1314	finally
      //   301	312	1314	finally
      //   324	330	1314	finally
      //   459	469	1314	finally
      //   477	491	1314	finally
      //   495	584	1314	finally
      //   588	604	1314	finally
      //   608	616	1314	finally
      //   620	627	1314	finally
      //   631	653	1314	finally
      //   657	667	1314	finally
      //   671	705	1314	finally
      //   709	722	1314	finally
      //   726	731	1314	finally
      //   735	741	1314	finally
      //   752	759	1314	finally
      //   763	768	1314	finally
      //   776	809	1314	finally
      //   813	820	1314	finally
      //   824	838	1314	finally
      //   842	848	1314	finally
      //   871	877	1314	finally
      //   886	917	1314	finally
      //   921	928	1314	finally
      //   932	937	1314	finally
      //   945	978	1314	finally
      //   982	989	1314	finally
      //   993	1004	1314	finally
      //   1008	1014	1314	finally
      //   1023	1054	1314	finally
      //   1058	1065	1314	finally
      //   1069	1080	1314	finally
      //   1084	1117	1314	finally
      //   1121	1126	1314	finally
      //   1149	1155	1314	finally
      //   1164	1195	1314	finally
      //   1199	1206	1314	finally
      //   1210	1221	1314	finally
      //   1225	1258	1314	finally
      //   1262	1267	1314	finally
      //   343	392	1319	finally
      //   392	429	1319	finally
      //   100	115	1324	java/security/InvalidParameterException
      //   100	115	1332	java/io/IOException
      //   100	115	1340	java/io/FileNotFoundException
    }
    
    private void eDV()
    {
      String str1 = agoy.t(ahav.x(new String(this.mFileName))).toLowerCase();
      int i = aqiw.getNetworkType(BaseApplicationImpl.getContext());
      File localFile = new File(this.mFileName);
      JSONObject localJSONObject = awjs.a(this.mRuntime, localFile.getName(), this.mTroopUin, str1);
      Object localObject;
      if ((localJSONObject != null) && (localJSONObject.optInt("retcode") == 0))
      {
        localObject = localJSONObject.optJSONObject("data");
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, dataObject == null");
          }
          apue.m("grp_hw", "upload_video", "-1", "", i + "", "");
          if (this.a != null) {
            this.a.onError(2);
          }
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              String str2;
              int j;
              do
              {
                for (;;)
                {
                  return;
                  str2 = ((JSONObject)localObject).optString("file_url");
                  if (TextUtils.isEmpty(str2))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, TextUtils.isEmpty(putUrl)");
                    }
                    apue.m("grp_hw", "upload_video", "-2", "", i + "", "");
                    if (this.a != null) {
                      this.a.onError(2);
                    }
                  }
                  else
                  {
                    localObject = ((JSONObject)localObject).optString("max_size", "0");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      try
                      {
                        long l = Long.parseLong((String)localObject);
                        if ((l != 0L) && (localFile.length() > l))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:" + l + ", filesize:" + localFile.length());
                          }
                          apue.m("grp_hw", "upload_video", "-3", "", i + "", "");
                          if (this.a == null) {
                            continue;
                          }
                          this.a.onError(3);
                        }
                      }
                      catch (NumberFormatException localNumberFormatException)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.w("TroopHomeworkHelper", 2, "UploadVideoJob, get MaxSize exception:" + localNumberFormatException.getMessage());
                        }
                      }
                    }
                  }
                }
                j = awjs.a(localJSONObject, this.mFileName, str1);
                if (j != 0) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.i("TroopHomeworkHelper", 2, "doPutCOSData success");
                }
                apue.m("grp_hw", "upload_video", "0", "1", i + "", "");
              } while (this.a == null);
              this.a.onComplete(str2);
              return;
              if (QLog.isColorLevel()) {
                QLog.w("TroopHomeworkHelper", 2, "doPutCOSData failed, putResult =" + j);
              }
              apue.m("grp_hw", "upload_video", "-4", "", i + "", "");
            } while (this.a == null);
            this.a.onError(5);
            return;
            if (localJSONObject == null) {
              break;
            }
            switch (localJSONObject.optInt("retcode"))
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, ret:" + localJSONObject.toString());
              }
              apue.m("grp_hw", "upload_video", "-6", "", i + "", "");
            }
          } while (this.a == null);
          this.a.onError(2);
          return;
          if (QLog.isColorLevel()) {
            QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, 达到当日上传次数限制, ret:" + localJSONObject.toString());
          }
          apue.m("grp_hw", "upload_video", "-5", "", i + "", "");
          if (this.dqA) {
            ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.2(this));
          }
        } while (this.a == null);
        this.a.onError(4);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
        }
        apue.m("grp_hw", "upload_video", "-7", "", i + "", "");
      } while (this.a == null);
      this.a.onError(2);
    }
    
    private void eDW()
    {
      this.mIsStop = false;
      int i = aqiw.getNetworkType(BaseApplicationImpl.getContext());
      File localFile = new File(this.mFileName);
      Object localObject = awjs.sp(this.mFileName);
      localObject = awjs.b(this.mRuntime, localFile.getName(), this.mTroopUin, (String)localObject);
      if ((localObject != null) && (((JSONObject)localObject).optInt("retcode") == 0))
      {
        localObject = ((JSONObject)localObject).optJSONObject("data");
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, dataObject == null");
          }
          apue.m("grp_hw", "upload_video", "-1", "", i + "", "");
          if (this.a != null) {
            this.a.onError(2);
          }
        }
      }
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              this.cQT = ((JSONObject)localObject).optString("file_url");
              if (TextUtils.isEmpty(this.cQT))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, TextUtils.isEmpty(appendUrl)");
                }
                apue.m("grp_hw", "upload_video", "-2", "", i + "", "");
                if (this.a != null) {
                  this.a.onError(2);
                }
              }
              else
              {
                String str = ((JSONObject)localObject).optString("max_size", "0");
                if (!TextUtils.isEmpty(str)) {
                  try
                  {
                    long l = Long.parseLong(str);
                    if ((l != 0L) && (localFile.length() > l))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:" + l + ", filesize:" + localFile.length());
                      }
                      apue.m("grp_hw", "upload_video", "-3", "", i + "", "");
                      if (this.a == null) {
                        continue;
                      }
                      this.a.onError(3);
                    }
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.w("TroopHomeworkHelper", 2, "UploadVideoJob, get MaxSize exception:" + localNumberFormatException.getMessage());
                    }
                  }
                }
              }
            }
            this.co = ((JSONObject)localObject);
            appendFile();
            return;
            if (localObject == null) {
              break;
            }
            switch (((JSONObject)localObject).optInt("retcode"))
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, ret:" + ((JSONObject)localObject).toString());
              }
              apue.m("grp_hw", "upload_video", "-6", "", i + "", "");
            }
          } while (this.a == null);
          this.a.onError(2);
          return;
          if (QLog.isColorLevel()) {
            QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, 达到当日上传次数限制, ret:" + ((JSONObject)localObject).toString());
          }
          apue.m("grp_hw", "upload_video", "-5", "", i + "", "");
          if (this.dqA) {
            ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.3(this));
          }
        } while (this.a == null);
        this.a.onError(4);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
        }
        apue.m("grp_hw", "upload_video", "-7", "", i + "", "");
      } while (this.a == null);
      this.a.onError(2);
    }
    
    public void a(awjs.b paramb)
    {
      this.a = paramb;
    }
    
    public void cancel()
    {
      this.mIsStop = true;
    }
    
    public void dIP()
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.post(new TroopHomeworkHelper.UploadFileTask.4(this), 8, null, true);
      }
      do
      {
        return;
        File localFile = new File(this.mFileName);
        if (((!localFile.exists()) || (localFile.length() == 0L)) && (this.a != null))
        {
          this.a.onError(-1);
          int i = aqiw.getNetworkType(BaseApplicationImpl.getContext());
          apue.m("grp_hw", "upload_video", "-13", "", i + "", "");
          return;
        }
        if (localFile.length() <= 4096L) {
          break label172;
        }
        if (this.co == null) {
          break label167;
        }
        if (this.fB < localFile.length()) {
          break;
        }
      } while (this.a == null);
      this.a.onComplete(this.cQT);
      return;
      appendFile();
      return;
      label167:
      eDW();
      return;
      label172:
      eDV();
    }
    
    public void start()
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        ThreadManager.post(new TroopHomeworkHelper.UploadFileTask.1(this), 8, null, true);
        return;
      }
      File localFile = new File(this.mFileName);
      if (((!localFile.exists()) || (localFile.length() == 0L)) && (this.a != null))
      {
        this.a.onError(-1);
        int i = aqiw.getNetworkType(BaseApplicationImpl.getContext());
        apue.m("grp_hw", "upload_video", "-13", "", i + "", "");
        return;
      }
      if (localFile.length() > 4096L)
      {
        eDW();
        return;
      }
      eDV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjs
 * JD-Core Version:    0.7.0.1
 */