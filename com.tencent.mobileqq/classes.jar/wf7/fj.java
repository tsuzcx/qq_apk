package wf7;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fj
{
  public static String pY;
  
  /* Error */
  private static String a(java.net.HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 6
    //   18: aconst_null
    //   19: astore 10
    //   21: aload 7
    //   23: astore_2
    //   24: aload 8
    //   26: astore_3
    //   27: new 16	java/net/URL
    //   30: dup
    //   31: ldc 18
    //   33: invokespecial 22	java/net/URL:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 26	java/net/URL:getHost	()Ljava/lang/String;
    //   39: aload_0
    //   40: invokevirtual 32	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   43: invokevirtual 26	java/net/URL:getHost	()Ljava/lang/String;
    //   46: invokevirtual 38	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifne +20 -> 69
    //   52: aload 7
    //   54: astore_2
    //   55: aload 8
    //   57: astore_3
    //   58: aload_0
    //   59: invokevirtual 32	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   62: invokevirtual 41	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   65: astore_1
    //   66: goto +5 -> 71
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: ifnonnull +48 -> 120
    //   75: aload 7
    //   77: astore_2
    //   78: aload 8
    //   80: astore_3
    //   81: aload_0
    //   82: ldc 43
    //   84: invokevirtual 47	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   87: ifnull +33 -> 120
    //   90: aload 7
    //   92: astore_2
    //   93: aload 8
    //   95: astore_3
    //   96: aload_0
    //   97: ldc 43
    //   99: invokevirtual 47	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 11
    //   104: aload 11
    //   106: astore_1
    //   107: goto +13 -> 120
    //   110: aload_1
    //   111: astore_0
    //   112: goto +189 -> 301
    //   115: aload_1
    //   116: astore_0
    //   117: goto +214 -> 331
    //   120: aload_1
    //   121: ifnonnull +81 -> 202
    //   124: aload 7
    //   126: astore_2
    //   127: aload 8
    //   129: astore_3
    //   130: aload_0
    //   131: ldc 49
    //   133: invokevirtual 47	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   136: ifnull +66 -> 202
    //   139: aload 7
    //   141: astore_2
    //   142: aload 8
    //   144: astore_3
    //   145: aload_0
    //   146: ldc 49
    //   148: invokevirtual 47	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   151: ldc 51
    //   153: invokevirtual 55	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   156: astore 11
    //   158: aload 7
    //   160: astore_2
    //   161: aload 8
    //   163: astore_3
    //   164: aload 11
    //   166: arraylength
    //   167: iconst_2
    //   168: if_icmpne +34 -> 202
    //   171: aload 7
    //   173: astore_2
    //   174: aload 8
    //   176: astore_3
    //   177: aload 11
    //   179: iconst_1
    //   180: aaload
    //   181: invokevirtual 58	java/lang/String:trim	()Ljava/lang/String;
    //   184: astore 11
    //   186: aload 11
    //   188: astore_1
    //   189: goto +13 -> 202
    //   192: aload_1
    //   193: astore_0
    //   194: goto +107 -> 301
    //   197: aload_1
    //   198: astore_0
    //   199: goto +132 -> 331
    //   202: aload_1
    //   203: astore_2
    //   204: aload 10
    //   206: astore_3
    //   207: aload_1
    //   208: ifnonnull +73 -> 281
    //   211: aload 7
    //   213: astore_2
    //   214: aload 8
    //   216: astore_3
    //   217: aload 9
    //   219: astore 4
    //   221: aload 6
    //   223: astore 5
    //   225: aload_0
    //   226: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   229: astore_0
    //   230: aload_1
    //   231: astore_2
    //   232: aload_0
    //   233: astore_3
    //   234: aload_0
    //   235: ifnull +46 -> 281
    //   238: aload_0
    //   239: astore_2
    //   240: aload_0
    //   241: astore_3
    //   242: aload_0
    //   243: astore 4
    //   245: aload_0
    //   246: astore 5
    //   248: aload_0
    //   249: invokestatic 66	wf7/fj:b	(Ljava/io/InputStream;)Ljava/lang/String;
    //   252: astore 6
    //   254: aload_1
    //   255: astore_2
    //   256: aload_0
    //   257: astore_3
    //   258: aload 6
    //   260: ifnull +21 -> 281
    //   263: aload 6
    //   265: astore_2
    //   266: aload_0
    //   267: astore_3
    //   268: goto +13 -> 281
    //   271: aload_1
    //   272: astore_0
    //   273: goto +28 -> 301
    //   276: aload_1
    //   277: astore_0
    //   278: goto +53 -> 331
    //   281: aload_2
    //   282: astore_1
    //   283: aload_3
    //   284: ifnull +60 -> 344
    //   287: aload_2
    //   288: astore_0
    //   289: aload_3
    //   290: invokevirtual 72	java/io/InputStream:close	()V
    //   293: aload_0
    //   294: areturn
    //   295: astore_0
    //   296: goto +23 -> 319
    //   299: aconst_null
    //   300: astore_0
    //   301: aload_0
    //   302: astore_1
    //   303: aload 5
    //   305: ifnull +39 -> 344
    //   308: aload 5
    //   310: astore_3
    //   311: goto -22 -> 289
    //   314: astore_0
    //   315: aload_3
    //   316: astore_2
    //   317: aload_0
    //   318: athrow
    //   319: aload_2
    //   320: ifnull +7 -> 327
    //   323: aload_2
    //   324: invokevirtual 72	java/io/InputStream:close	()V
    //   327: aload_0
    //   328: athrow
    //   329: aconst_null
    //   330: astore_0
    //   331: aload_0
    //   332: astore_1
    //   333: aload 4
    //   335: ifnull +9 -> 344
    //   338: aload 4
    //   340: astore_3
    //   341: goto -52 -> 289
    //   344: aload_1
    //   345: areturn
    //   346: astore_0
    //   347: goto -18 -> 329
    //   350: astore_0
    //   351: goto -52 -> 299
    //   354: astore_0
    //   355: goto -240 -> 115
    //   358: astore_0
    //   359: goto -249 -> 110
    //   362: astore_0
    //   363: goto -166 -> 197
    //   366: astore_0
    //   367: goto -175 -> 192
    //   370: astore_0
    //   371: goto -95 -> 276
    //   374: astore_0
    //   375: goto -104 -> 271
    //   378: astore_1
    //   379: aload_0
    //   380: areturn
    //   381: astore_1
    //   382: goto -55 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   65	280	1	localObject1	Object
    //   378	1	1	localIOException1	java.io.IOException
    //   381	1	1	localIOException2	java.io.IOException
    //   23	301	2	localObject2	Object
    //   26	315	3	localObject3	Object
    //   10	329	4	localObject4	Object
    //   4	305	5	localObject5	Object
    //   16	248	6	str	String
    //   1	211	7	localObject6	Object
    //   7	208	8	localObject7	Object
    //   13	205	9	localObject8	Object
    //   19	186	10	localObject9	Object
    //   102	85	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   27	52	295	finally
    //   58	66	295	finally
    //   81	90	295	finally
    //   96	104	295	finally
    //   130	139	295	finally
    //   145	158	295	finally
    //   164	171	295	finally
    //   177	186	295	finally
    //   225	230	295	finally
    //   248	254	295	finally
    //   317	319	295	finally
    //   27	52	314	wf7/ex
    //   58	66	314	wf7/ex
    //   81	90	314	wf7/ex
    //   96	104	314	wf7/ex
    //   130	139	314	wf7/ex
    //   145	158	314	wf7/ex
    //   164	171	314	wf7/ex
    //   177	186	314	wf7/ex
    //   225	230	314	wf7/ex
    //   248	254	314	wf7/ex
    //   27	52	346	java/io/IOException
    //   58	66	346	java/io/IOException
    //   27	52	350	java/lang/Throwable
    //   58	66	350	java/lang/Throwable
    //   81	90	354	java/io/IOException
    //   96	104	354	java/io/IOException
    //   81	90	358	java/lang/Throwable
    //   96	104	358	java/lang/Throwable
    //   130	139	362	java/io/IOException
    //   145	158	362	java/io/IOException
    //   164	171	362	java/io/IOException
    //   177	186	362	java/io/IOException
    //   130	139	366	java/lang/Throwable
    //   145	158	366	java/lang/Throwable
    //   164	171	366	java/lang/Throwable
    //   177	186	366	java/lang/Throwable
    //   225	230	370	java/io/IOException
    //   248	254	370	java/io/IOException
    //   225	230	374	java/lang/Throwable
    //   248	254	374	java/lang/Throwable
    //   289	293	378	java/io/IOException
    //   323	327	381	java/io/IOException
  }
  
  /* Error */
  public static String a(fj.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: iconst_1
    //   10: istore_2
    //   11: new 16	java/net/URL
    //   14: dup
    //   15: ldc 18
    //   17: invokespecial 22	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 78	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 28	java/net/HttpURLConnection
    //   26: astore_3
    //   27: invokestatic 84	wf7/dk:bJ	()I
    //   30: bipush 8
    //   32: if_icmpge +11 -> 43
    //   35: ldc 86
    //   37: ldc 88
    //   39: invokestatic 94	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: pop
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 98	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   48: aload_3
    //   49: ldc 100
    //   51: ldc 102
    //   53: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_3
    //   57: ldc 108
    //   59: ldc 102
    //   61: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_3
    //   65: iconst_0
    //   66: invokevirtual 111	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   69: aload_3
    //   70: ldc 113
    //   72: invokevirtual 116	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   75: aload_3
    //   76: sipush 5000
    //   79: invokevirtual 120	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   82: aload_3
    //   83: invokevirtual 123	java/net/HttpURLConnection:getResponseCode	()I
    //   86: istore_1
    //   87: iload_1
    //   88: sipush 200
    //   91: if_icmpeq +20 -> 111
    //   94: iload_1
    //   95: sipush 301
    //   98: if_icmplt +185 -> 283
    //   101: iload_1
    //   102: sipush 305
    //   105: if_icmpgt +178 -> 283
    //   108: goto +3 -> 111
    //   111: aload_3
    //   112: ldc 125
    //   114: invokevirtual 47	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 5
    //   119: aload 5
    //   121: ifnull +13 -> 134
    //   124: aload 5
    //   126: ldc 125
    //   128: invokevirtual 38	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifne +9 -> 140
    //   134: aload_3
    //   135: invokestatic 127	wf7/fj:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   138: astore 4
    //   140: iconst_0
    //   141: istore_2
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 130	java/net/HttpURLConnection:disconnect	()V
    //   150: aload 4
    //   152: ifnonnull +14 -> 166
    //   155: aload_0
    //   156: iconst_0
    //   157: iload_2
    //   158: invokeinterface 136 3 0
    //   163: aload 4
    //   165: areturn
    //   166: aload 4
    //   168: putstatic 138	wf7/fj:pY	Ljava/lang/String;
    //   171: aload_0
    //   172: iconst_1
    //   173: iload_2
    //   174: invokeinterface 136 3 0
    //   179: aload 4
    //   181: areturn
    //   182: astore 4
    //   184: goto +18 -> 202
    //   187: goto +22 -> 209
    //   190: astore 4
    //   192: goto +29 -> 221
    //   195: goto +52 -> 247
    //   198: astore 4
    //   200: aconst_null
    //   201: astore_3
    //   202: iconst_0
    //   203: istore_2
    //   204: goto +22 -> 226
    //   207: aconst_null
    //   208: astore_3
    //   209: aload_3
    //   210: ifnull +45 -> 255
    //   213: goto +38 -> 251
    //   216: astore 4
    //   218: aload 5
    //   220: astore_3
    //   221: aload 4
    //   223: athrow
    //   224: astore 4
    //   226: aload_3
    //   227: ifnull +7 -> 234
    //   230: aload_3
    //   231: invokevirtual 130	java/net/HttpURLConnection:disconnect	()V
    //   234: aload_0
    //   235: iconst_0
    //   236: iload_2
    //   237: invokeinterface 136 3 0
    //   242: aload 4
    //   244: athrow
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 130	java/net/HttpURLConnection:disconnect	()V
    //   255: aload_0
    //   256: iconst_0
    //   257: iconst_1
    //   258: invokeinterface 136 3 0
    //   263: aconst_null
    //   264: areturn
    //   265: astore_3
    //   266: goto -21 -> 245
    //   269: astore_3
    //   270: goto -63 -> 207
    //   273: astore 4
    //   275: goto -80 -> 195
    //   278: astore 4
    //   280: goto -93 -> 187
    //   283: iconst_1
    //   284: istore_2
    //   285: aload 6
    //   287: astore 4
    //   289: goto -147 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	parama	fj.a
    //   86	20	1	i	int
    //   10	275	2	bool	boolean
    //   26	226	3	localObject1	Object
    //   265	1	3	localIOException1	java.io.IOException
    //   269	1	3	localThrowable1	java.lang.Throwable
    //   7	173	4	str1	String
    //   182	1	4	localObject2	Object
    //   190	1	4	localex1	ex
    //   198	1	4	localObject3	Object
    //   216	6	4	localex2	ex
    //   224	19	4	localObject4	Object
    //   273	1	4	localIOException2	java.io.IOException
    //   278	1	4	localThrowable2	java.lang.Throwable
    //   287	1	4	localObject5	Object
    //   4	215	5	str2	String
    //   1	285	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   27	43	182	finally
    //   43	87	182	finally
    //   111	119	182	finally
    //   124	134	182	finally
    //   134	140	182	finally
    //   27	43	190	wf7/ex
    //   43	87	190	wf7/ex
    //   111	119	190	wf7/ex
    //   124	134	190	wf7/ex
    //   134	140	190	wf7/ex
    //   11	27	198	finally
    //   11	27	216	wf7/ex
    //   221	224	224	finally
    //   11	27	265	java/io/IOException
    //   11	27	269	java/lang/Throwable
    //   27	43	273	java/io/IOException
    //   43	87	273	java/io/IOException
    //   111	119	273	java/io/IOException
    //   124	134	273	java/io/IOException
    //   134	140	273	java/io/IOException
    //   27	43	278	java/lang/Throwable
    //   43	87	278	java/lang/Throwable
    //   111	119	278	java/lang/Throwable
    //   124	134	278	java/lang/Throwable
    //   134	140	278	java/lang/Throwable
  }
  
  private static String b(InputStream paramInputStream)
  {
    String str2 = c(paramInputStream);
    String[] arrayOfString = new String[5];
    int i = 0;
    arrayOfString[0] = "http-equiv\\s*=\\s*[\"']*refresh[\"']*\\s*content\\s*=\\s*[\"']*[^;]*;\\s*url\\s*=\\s*[\"']*([^\"'\\s>]+)";
    arrayOfString[1] = "[^\\w](?:location.href\\s*=|location\\s*=|location.replace\\s*\\()\\s*[\"']*([^\"'>]+)";
    arrayOfString[2] = "<NextURL>([^<]+)";
    arrayOfString[3] = "\\s+action\\s*=\\s*[\"']*([^\"'>]+)[\"'>\\s]*.*submit";
    arrayOfString[4] = "<LoginURL>([^<]+)";
    int j = arrayOfString.length;
    paramInputStream = null;
    while ((i < j) && (paramInputStream == null))
    {
      Matcher localMatcher = Pattern.compile(arrayOfString[i], 2).matcher(str2);
      while ((localMatcher.find()) && (paramInputStream == null))
      {
        String str1 = localMatcher.group(localMatcher.groupCount());
        paramInputStream = str1;
        if (str1 != null)
        {
          paramInputStream = str1;
          if (!str1.trim().toLowerCase().startsWith("http")) {
            paramInputStream = null;
          }
        }
      }
      i += 1;
    }
    if (paramInputStream != null) {
      return paramInputStream;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("0725SSID:");
    paramInputStream.append(getSSID());
    paramInputStream.append(" page head content: ");
    paramInputStream.append(str2);
    paramInputStream = new ex(paramInputStream.toString());
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  /* Error */
  private static String c(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 203	java/io/BufferedReader
    //   3: dup
    //   4: new 205	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 208	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_0
    //   16: new 184	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_0
    //   25: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +12 -> 42
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: goto -15 -> 24
    //   42: aload_0
    //   43: invokevirtual 215	java/io/BufferedReader:close	()V
    //   46: goto +24 -> 70
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 218	java/io/IOException:printStackTrace	()V
    //   54: goto +16 -> 70
    //   57: astore_1
    //   58: goto +17 -> 75
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 218	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: invokevirtual 215	java/io/BufferedReader:close	()V
    //   70: aload_1
    //   71: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: areturn
    //   75: aload_0
    //   76: invokevirtual 215	java/io/BufferedReader:close	()V
    //   79: goto +8 -> 87
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 218	java/io/IOException:printStackTrace	()V
    //   87: goto +5 -> 92
    //   90: aload_1
    //   91: athrow
    //   92: goto -2 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramInputStream	InputStream
    //   23	11	1	localStringBuilder	StringBuilder
    //   57	34	1	localObject	Object
    //   28	7	2	str	String
    //   61	2	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   42	46	49	java/io/IOException
    //   66	70	49	java/io/IOException
    //   24	29	57	finally
    //   33	39	57	finally
    //   62	66	57	finally
    //   24	29	61	java/io/IOException
    //   33	39	61	java/io/IOException
    //   75	79	82	java/io/IOException
  }
  
  public static boolean dJ()
  {
    try
    {
      localNetworkInfo = fi.getActiveNetworkInfo();
    }
    catch (NullPointerException localNullPointerException)
    {
      NetworkInfo localNetworkInfo;
      label7:
      break label7;
    }
    localNetworkInfo = null;
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 1);
  }
  
  public static String getSSID()
  {
    try
    {
      Object localObject = (WifiManager)ea.cr().getSystemService("wifi");
      if (localObject != null)
      {
        localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
        if (localObject != null)
        {
          localObject = ((WifiInfo)localObject).getSSID();
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      label32:
      break label32;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.fj
 * JD-Core Version:    0.7.0.1
 */