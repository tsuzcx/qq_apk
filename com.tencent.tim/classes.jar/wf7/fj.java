package wf7;

import alkz;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fj
{
  public static String pY;
  
  /* Error */
  private static String a(java.net.HttpURLConnection paramHttpURLConnection)
    throws ex
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 18	java/net/URL
    //   7: dup
    //   8: ldc 20
    //   10: invokespecial 24	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 28	java/net/URL:getHost	()Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 34	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   20: invokevirtual 28	java/net/URL:getHost	()Ljava/lang/String;
    //   23: invokevirtual 40	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +293 -> 319
    //   29: aload_0
    //   30: invokevirtual 34	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   33: invokevirtual 43	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_1
    //   40: astore_2
    //   41: aload_1
    //   42: ifnonnull +31 -> 73
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: astore_3
    //   49: aload_1
    //   50: astore 4
    //   52: aload_0
    //   53: ldc 45
    //   55: invokevirtual 49	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   58: ifnull +15 -> 73
    //   61: aload_1
    //   62: astore_3
    //   63: aload_1
    //   64: astore 4
    //   66: aload_0
    //   67: ldc 45
    //   69: invokevirtual 49	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_2
    //   76: ifnonnull +64 -> 140
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: astore_3
    //   83: aload_2
    //   84: astore 4
    //   86: aload_0
    //   87: ldc 51
    //   89: invokevirtual 49	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   92: ifnull +48 -> 140
    //   95: aload_2
    //   96: astore_3
    //   97: aload_2
    //   98: astore 4
    //   100: aload_0
    //   101: ldc 51
    //   103: invokevirtual 49	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   106: ldc 53
    //   108: invokevirtual 57	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   111: astore 5
    //   113: aload_2
    //   114: astore_1
    //   115: aload_2
    //   116: astore_3
    //   117: aload_2
    //   118: astore 4
    //   120: aload 5
    //   122: arraylength
    //   123: iconst_2
    //   124: if_icmpne +16 -> 140
    //   127: aload_2
    //   128: astore_3
    //   129: aload_2
    //   130: astore 4
    //   132: aload 5
    //   134: iconst_1
    //   135: aaload
    //   136: invokevirtual 60	java/lang/String:trim	()Ljava/lang/String;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnonnull +171 -> 312
    //   144: aload_1
    //   145: astore_3
    //   146: aload_1
    //   147: astore 4
    //   149: aload_0
    //   150: invokevirtual 64	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull +150 -> 305
    //   158: aload_0
    //   159: invokestatic 68	wf7/fj:b	(Ljava/io/InputStream;)Ljava/lang/String;
    //   162: astore_2
    //   163: aload_2
    //   164: ifnull +141 -> 305
    //   167: aload_2
    //   168: astore_1
    //   169: aload_0
    //   170: astore_2
    //   171: aload_1
    //   172: astore_0
    //   173: aload_0
    //   174: astore_1
    //   175: aload_2
    //   176: ifnull +9 -> 185
    //   179: aload_2
    //   180: invokevirtual 74	java/io/InputStream:close	()V
    //   183: aload_0
    //   184: astore_1
    //   185: aload_1
    //   186: areturn
    //   187: astore_0
    //   188: aconst_null
    //   189: astore_2
    //   190: aload_1
    //   191: astore_0
    //   192: aload_0
    //   193: astore_1
    //   194: aload_2
    //   195: ifnull -10 -> 185
    //   198: aload_2
    //   199: invokevirtual 74	java/io/InputStream:close	()V
    //   202: aload_0
    //   203: areturn
    //   204: astore_1
    //   205: aload_0
    //   206: areturn
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_0
    //   210: aload_1
    //   211: athrow
    //   212: astore_2
    //   213: aload_0
    //   214: astore_1
    //   215: aload_2
    //   216: astore_0
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 74	java/io/InputStream:close	()V
    //   225: aload_0
    //   226: athrow
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_2
    //   230: aload_3
    //   231: astore_0
    //   232: aload_0
    //   233: astore_1
    //   234: aload_2
    //   235: ifnull -50 -> 185
    //   238: aload_2
    //   239: invokevirtual 74	java/io/InputStream:close	()V
    //   242: aload_0
    //   243: areturn
    //   244: astore_1
    //   245: aload_0
    //   246: areturn
    //   247: astore_1
    //   248: aload_0
    //   249: areturn
    //   250: astore_1
    //   251: goto -26 -> 225
    //   254: astore_0
    //   255: aconst_null
    //   256: astore_1
    //   257: goto -40 -> 217
    //   260: astore_2
    //   261: aload_0
    //   262: astore_1
    //   263: aload_2
    //   264: astore_0
    //   265: goto -48 -> 217
    //   268: astore_0
    //   269: aload_3
    //   270: astore_0
    //   271: aconst_null
    //   272: astore_2
    //   273: goto -41 -> 232
    //   276: astore_2
    //   277: aload_0
    //   278: astore_2
    //   279: aload_1
    //   280: astore_0
    //   281: goto -49 -> 232
    //   284: astore_1
    //   285: goto -75 -> 210
    //   288: astore_0
    //   289: aload 4
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_2
    //   294: goto -102 -> 192
    //   297: astore_2
    //   298: aload_0
    //   299: astore_2
    //   300: aload_1
    //   301: astore_0
    //   302: goto -110 -> 192
    //   305: aload_0
    //   306: astore_2
    //   307: aload_1
    //   308: astore_0
    //   309: goto -136 -> 173
    //   312: aload_1
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_2
    //   316: goto -143 -> 173
    //   319: aconst_null
    //   320: astore_1
    //   321: goto -282 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   3	191	1	localObject1	Object
    //   204	1	1	localIOException1	IOException
    //   207	4	1	localex1	ex
    //   214	20	1	localHttpURLConnection1	java.net.HttpURLConnection
    //   244	1	1	localIOException2	IOException
    //   247	1	1	localIOException3	IOException
    //   250	1	1	localIOException4	IOException
    //   256	24	1	localHttpURLConnection2	java.net.HttpURLConnection
    //   284	29	1	localex2	ex
    //   320	1	1	localObject2	Object
    //   36	163	2	localObject3	Object
    //   212	4	2	localObject4	Object
    //   229	10	2	localObject5	Object
    //   260	4	2	localObject6	Object
    //   272	1	2	localObject7	Object
    //   276	1	2	localThrowable	java.lang.Throwable
    //   278	16	2	localHttpURLConnection3	java.net.HttpURLConnection
    //   297	1	2	localIOException5	IOException
    //   299	17	2	localHttpURLConnection4	java.net.HttpURLConnection
    //   1	269	3	localObject8	Object
    //   50	240	4	localObject9	Object
    //   111	22	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   4	37	187	java/io/IOException
    //   198	202	204	java/io/IOException
    //   4	37	207	wf7/ex
    //   52	61	207	wf7/ex
    //   66	73	207	wf7/ex
    //   86	95	207	wf7/ex
    //   100	113	207	wf7/ex
    //   120	127	207	wf7/ex
    //   132	140	207	wf7/ex
    //   149	154	207	wf7/ex
    //   210	212	212	finally
    //   4	37	227	java/lang/Throwable
    //   238	242	244	java/io/IOException
    //   179	183	247	java/io/IOException
    //   221	225	250	java/io/IOException
    //   4	37	254	finally
    //   52	61	254	finally
    //   66	73	254	finally
    //   86	95	254	finally
    //   100	113	254	finally
    //   120	127	254	finally
    //   132	140	254	finally
    //   149	154	254	finally
    //   158	163	260	finally
    //   52	61	268	java/lang/Throwable
    //   66	73	268	java/lang/Throwable
    //   86	95	268	java/lang/Throwable
    //   100	113	268	java/lang/Throwable
    //   120	127	268	java/lang/Throwable
    //   132	140	268	java/lang/Throwable
    //   149	154	268	java/lang/Throwable
    //   158	163	276	java/lang/Throwable
    //   158	163	284	wf7/ex
    //   52	61	288	java/io/IOException
    //   66	73	288	java/io/IOException
    //   86	95	288	java/io/IOException
    //   100	113	288	java/io/IOException
    //   120	127	288	java/io/IOException
    //   132	140	288	java/io/IOException
    //   149	154	288	java/io/IOException
    //   158	163	297	java/io/IOException
  }
  
  /* Error */
  public static String a(a parama)
    throws ex
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 18	java/net/URL
    //   9: dup
    //   10: ldc 20
    //   12: invokespecial 24	java/net/URL:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 81	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: checkcast 30	java/net/HttpURLConnection
    //   21: astore_3
    //   22: invokestatic 87	wf7/dk:bJ	()I
    //   25: bipush 8
    //   27: if_icmpge +11 -> 38
    //   30: ldc 89
    //   32: ldc 91
    //   34: invokestatic 97	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: pop
    //   38: aload_3
    //   39: iconst_0
    //   40: invokevirtual 101	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   43: aload_3
    //   44: ldc 103
    //   46: ldc 105
    //   48: invokevirtual 109	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_3
    //   52: ldc 111
    //   54: ldc 105
    //   56: invokevirtual 109	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_3
    //   60: iconst_0
    //   61: invokevirtual 114	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   64: aload_3
    //   65: ldc 116
    //   67: invokevirtual 119	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   70: aload_3
    //   71: sipush 5000
    //   74: invokevirtual 123	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   77: aload_3
    //   78: invokevirtual 126	java/net/HttpURLConnection:getResponseCode	()I
    //   81: istore_1
    //   82: iload_1
    //   83: sipush 200
    //   86: if_icmpeq +17 -> 103
    //   89: iload_1
    //   90: sipush 301
    //   93: if_icmplt +65 -> 158
    //   96: iload_1
    //   97: sipush 305
    //   100: if_icmpgt +58 -> 158
    //   103: aload_3
    //   104: ldc 128
    //   106: invokevirtual 49	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +13 -> 126
    //   116: aload 5
    //   118: ldc 128
    //   120: invokevirtual 40	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +9 -> 132
    //   126: aload_3
    //   127: invokestatic 130	wf7/fj:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   130: astore 4
    //   132: iconst_0
    //   133: istore_2
    //   134: aload_3
    //   135: ifnull +7 -> 142
    //   138: aload_3
    //   139: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   142: aload 4
    //   144: ifnonnull +23 -> 167
    //   147: aload_0
    //   148: iconst_0
    //   149: iload_2
    //   150: invokeinterface 137 3 0
    //   155: aload 4
    //   157: areturn
    //   158: iconst_1
    //   159: istore_2
    //   160: aload 5
    //   162: astore 4
    //   164: goto -30 -> 134
    //   167: aload 4
    //   169: putstatic 139	wf7/fj:pY	Ljava/lang/String;
    //   172: aload_0
    //   173: iconst_1
    //   174: iload_2
    //   175: invokeinterface 137 3 0
    //   180: aload 4
    //   182: areturn
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_3
    //   186: aload_3
    //   187: ifnull +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   194: iconst_0
    //   195: ifne +13 -> 208
    //   198: aload_0
    //   199: iconst_0
    //   200: iconst_1
    //   201: invokeinterface 137 3 0
    //   206: aconst_null
    //   207: areturn
    //   208: aconst_null
    //   209: putstatic 139	wf7/fj:pY	Ljava/lang/String;
    //   212: aload_0
    //   213: iconst_1
    //   214: iconst_1
    //   215: invokeinterface 137 3 0
    //   220: aconst_null
    //   221: areturn
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_3
    //   226: aload 4
    //   228: athrow
    //   229: astore 5
    //   231: iconst_1
    //   232: istore_2
    //   233: aload_3
    //   234: astore 4
    //   236: aload 5
    //   238: astore_3
    //   239: aload 4
    //   241: ifnull +8 -> 249
    //   244: aload 4
    //   246: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   249: iconst_0
    //   250: ifne +52 -> 302
    //   253: aload_0
    //   254: iconst_0
    //   255: iload_2
    //   256: invokeinterface 137 3 0
    //   261: aload_3
    //   262: athrow
    //   263: astore_3
    //   264: aconst_null
    //   265: astore_3
    //   266: aload_3
    //   267: ifnull +7 -> 274
    //   270: aload_3
    //   271: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   274: iconst_0
    //   275: ifne +13 -> 288
    //   278: aload_0
    //   279: iconst_0
    //   280: iconst_1
    //   281: invokeinterface 137 3 0
    //   286: aconst_null
    //   287: areturn
    //   288: aconst_null
    //   289: putstatic 139	wf7/fj:pY	Ljava/lang/String;
    //   292: aload_0
    //   293: iconst_1
    //   294: iconst_1
    //   295: invokeinterface 137 3 0
    //   300: aconst_null
    //   301: areturn
    //   302: aconst_null
    //   303: putstatic 139	wf7/fj:pY	Ljava/lang/String;
    //   306: aload_0
    //   307: iconst_1
    //   308: iload_2
    //   309: invokeinterface 137 3 0
    //   314: goto -53 -> 261
    //   317: astore_3
    //   318: aconst_null
    //   319: astore 4
    //   321: iconst_0
    //   322: istore_2
    //   323: goto -84 -> 239
    //   326: astore 4
    //   328: iconst_0
    //   329: istore_2
    //   330: aload_3
    //   331: astore 5
    //   333: aload 4
    //   335: astore_3
    //   336: aload 5
    //   338: astore 4
    //   340: goto -101 -> 239
    //   343: astore 4
    //   345: goto -79 -> 266
    //   348: astore 4
    //   350: goto -124 -> 226
    //   353: astore 4
    //   355: goto -169 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	parama	a
    //   81	20	1	i	int
    //   133	197	2	bool	boolean
    //   21	118	3	localHttpURLConnection	java.net.HttpURLConnection
    //   183	1	3	localIOException1	IOException
    //   185	77	3	localObject1	Object
    //   263	1	3	localThrowable1	java.lang.Throwable
    //   265	6	3	localObject2	Object
    //   317	14	3	localObject3	Object
    //   335	1	3	localObject4	Object
    //   4	177	4	str1	String
    //   222	5	4	localex1	ex
    //   234	86	4	localObject5	Object
    //   326	8	4	localObject6	Object
    //   338	1	4	localObject7	Object
    //   343	1	4	localThrowable2	java.lang.Throwable
    //   348	1	4	localex2	ex
    //   353	1	4	localIOException2	IOException
    //   1	160	5	str2	String
    //   229	8	5	localObject8	Object
    //   331	6	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   6	22	183	java/io/IOException
    //   6	22	222	wf7/ex
    //   226	229	229	finally
    //   6	22	263	java/lang/Throwable
    //   6	22	317	finally
    //   22	38	326	finally
    //   38	82	326	finally
    //   103	111	326	finally
    //   116	126	326	finally
    //   126	132	326	finally
    //   22	38	343	java/lang/Throwable
    //   38	82	343	java/lang/Throwable
    //   103	111	343	java/lang/Throwable
    //   116	126	343	java/lang/Throwable
    //   126	132	343	java/lang/Throwable
    //   22	38	348	wf7/ex
    //   38	82	348	wf7/ex
    //   103	111	348	wf7/ex
    //   116	126	348	wf7/ex
    //   126	132	348	wf7/ex
    //   22	38	353	java/io/IOException
    //   38	82	353	java/io/IOException
    //   103	111	353	java/io/IOException
    //   116	126	353	java/io/IOException
    //   126	132	353	java/io/IOException
  }
  
  private static String b(InputStream paramInputStream)
    throws ex
  {
    String str2 = c(paramInputStream);
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "http-equiv\\s*=\\s*[\"']*refresh[\"']*\\s*content\\s*=\\s*[\"']*[^;]*;\\s*url\\s*=\\s*[\"']*([^\"'\\s>]+)";
    arrayOfString[1] = "[^\\w](?:location.href\\s*=|location\\s*=|location.replace\\s*\\()\\s*[\"']*([^\"'>]+)";
    arrayOfString[2] = "<NextURL>([^<]+)";
    arrayOfString[3] = "\\s+action\\s*=\\s*[\"']*([^\"'>]+)[\"'>\\s]*.*submit";
    arrayOfString[4] = "<LoginURL>([^<]+)";
    int j = arrayOfString.length;
    int i = 0;
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
    if (paramInputStream == null) {
      throw new ex("0725SSID:" + getSSID() + " page head content: " + str2);
    }
    return paramInputStream;
  }
  
  private static String c(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    paramInputStream = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        paramInputStream.append(str);
      }
      try
      {
        localIOException2.close();
        throw paramInputStream;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (IOException localIOException4)
    {
      localIOException4 = localIOException4;
      localIOException4.printStackTrace();
      try
      {
        localBufferedReader.close();
        for (;;)
        {
          return paramInputStream.toString();
          try
          {
            localBufferedReader.close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public static boolean dJ()
  {
    boolean bool = true;
    Object localObject = null;
    try
    {
      NetworkInfo localNetworkInfo = fi.getActiveNetworkInfo();
      localObject = localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException)
    {
      label10:
      break label10;
    }
    if ((localObject == null) || (localObject.getType() != 1)) {
      bool = false;
    }
    return bool;
  }
  
  public static String getSSID()
  {
    try
    {
      Object localObject = (WifiManager)ea.cr().getSystemService("wifi");
      if (localObject != null)
      {
        localObject = alkz.a((WifiManager)localObject);
        if (localObject != null)
        {
          localObject = ((WifiInfo)localObject).getSSID();
          return localObject;
        }
      }
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.fj
 * JD-Core Version:    0.7.0.1
 */