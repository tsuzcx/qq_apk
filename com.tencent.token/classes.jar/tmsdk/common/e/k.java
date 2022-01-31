package tmsdk.common.e;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tmsdk.common.a;
import tmsdk.common.b.b;

public class k
{
  public static String a;
  
  public static String a()
  {
    Object localObject = (WifiManager)a.a().getSystemService("wifi");
    if (localObject != null)
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject != null) {
        return ((WifiInfo)localObject).getSSID();
      }
    }
    return "";
  }
  
  private static String a(InputStream paramInputStream)
  {
    String str2 = b(paramInputStream);
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
      throw new b("0725SSID:" + a() + " page head content: " + str2);
    }
    return paramInputStream;
  }
  
  /* Error */
  private static String a(java.net.HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 117	java/net/URL
    //   7: dup
    //   8: ldc 119
    //   10: invokespecial 120	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 123	java/net/URL:getHost	()Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 129	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   20: invokevirtual 123	java/net/URL:getHost	()Ljava/lang/String;
    //   23: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +293 -> 319
    //   29: aload_0
    //   30: invokevirtual 129	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   33: invokevirtual 136	java/net/URL:toExternalForm	()Ljava/lang/String;
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
    //   53: ldc 138
    //   55: invokevirtual 142	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   58: ifnull +15 -> 73
    //   61: aload_1
    //   62: astore_3
    //   63: aload_1
    //   64: astore 4
    //   66: aload_0
    //   67: ldc 138
    //   69: invokevirtual 142	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
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
    //   87: ldc 144
    //   89: invokevirtual 142	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   92: ifnull +48 -> 140
    //   95: aload_2
    //   96: astore_3
    //   97: aload_2
    //   98: astore 4
    //   100: aload_0
    //   101: ldc 144
    //   103: invokevirtual 142	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   106: ldc 146
    //   108: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   136: invokevirtual 77	java/lang/String:trim	()Ljava/lang/String;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnonnull +171 -> 312
    //   144: aload_1
    //   145: astore_3
    //   146: aload_1
    //   147: astore 4
    //   149: aload_0
    //   150: invokevirtual 154	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull +150 -> 305
    //   158: aload_0
    //   159: invokestatic 156	tmsdk/common/e/k:a	(Ljava/io/InputStream;)Ljava/lang/String;
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
    //   180: invokevirtual 161	java/io/InputStream:close	()V
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
    //   199: invokevirtual 161	java/io/InputStream:close	()V
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
    //   222: invokevirtual 161	java/io/InputStream:close	()V
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
    //   239: invokevirtual 161	java/io/InputStream:close	()V
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
    //   207	4	1	localb1	b
    //   214	20	1	localHttpURLConnection1	java.net.HttpURLConnection
    //   244	1	1	localIOException2	IOException
    //   247	1	1	localIOException3	IOException
    //   250	1	1	localIOException4	IOException
    //   256	24	1	localHttpURLConnection2	java.net.HttpURLConnection
    //   284	29	1	localb2	b
    //   320	1	1	localObject2	Object
    //   36	163	2	localObject3	Object
    //   212	4	2	localObject4	Object
    //   229	10	2	localObject5	Object
    //   260	4	2	localObject6	Object
    //   272	1	2	localObject7	Object
    //   276	1	2	localException	java.lang.Exception
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
    //   4	37	207	tmsdk/common/b/b
    //   52	61	207	tmsdk/common/b/b
    //   66	73	207	tmsdk/common/b/b
    //   86	95	207	tmsdk/common/b/b
    //   100	113	207	tmsdk/common/b/b
    //   120	127	207	tmsdk/common/b/b
    //   132	140	207	tmsdk/common/b/b
    //   149	154	207	tmsdk/common/b/b
    //   210	212	212	finally
    //   4	37	227	java/lang/Exception
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
    //   52	61	268	java/lang/Exception
    //   66	73	268	java/lang/Exception
    //   86	95	268	java/lang/Exception
    //   100	113	268	java/lang/Exception
    //   120	127	268	java/lang/Exception
    //   132	140	268	java/lang/Exception
    //   149	154	268	java/lang/Exception
    //   158	163	276	java/lang/Exception
    //   158	163	284	tmsdk/common/b/b
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
  public static String a(l paraml)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 117	java/net/URL
    //   9: dup
    //   10: ldc 119
    //   12: invokespecial 120	java/net/URL:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 166	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: checkcast 125	java/net/HttpURLConnection
    //   21: astore_3
    //   22: invokestatic 170	tmsdk/common/e/i:a	()I
    //   25: bipush 8
    //   27: if_icmpge +11 -> 38
    //   30: ldc 172
    //   32: ldc 174
    //   34: invokestatic 180	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: pop
    //   38: aload_3
    //   39: iconst_0
    //   40: invokevirtual 184	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   43: aload_3
    //   44: ldc 186
    //   46: ldc 188
    //   48: invokevirtual 192	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_3
    //   52: ldc 194
    //   54: ldc 188
    //   56: invokevirtual 192	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_3
    //   60: iconst_0
    //   61: invokevirtual 197	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   64: aload_3
    //   65: ldc 199
    //   67: invokevirtual 202	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   70: aload_3
    //   71: sipush 5000
    //   74: invokevirtual 206	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   77: aload_3
    //   78: invokevirtual 209	java/net/HttpURLConnection:getResponseCode	()I
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
    //   104: ldc 211
    //   106: invokevirtual 142	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +13 -> 126
    //   116: aload 5
    //   118: ldc 211
    //   120: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +9 -> 132
    //   126: aload_3
    //   127: invokestatic 213	tmsdk/common/e/k:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   130: astore 4
    //   132: iconst_0
    //   133: istore_2
    //   134: aload_3
    //   135: ifnull +7 -> 142
    //   138: aload_3
    //   139: invokevirtual 216	java/net/HttpURLConnection:disconnect	()V
    //   142: aload 4
    //   144: ifnonnull +23 -> 167
    //   147: aload_0
    //   148: iconst_0
    //   149: iload_2
    //   150: invokeinterface 221 3 0
    //   155: aload 4
    //   157: areturn
    //   158: iconst_1
    //   159: istore_2
    //   160: aload 5
    //   162: astore 4
    //   164: goto -30 -> 134
    //   167: aload 4
    //   169: putstatic 223	tmsdk/common/e/k:a	Ljava/lang/String;
    //   172: aload_0
    //   173: iconst_1
    //   174: iload_2
    //   175: invokeinterface 221 3 0
    //   180: aload 4
    //   182: areturn
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_3
    //   186: aload_3
    //   187: ifnull +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 216	java/net/HttpURLConnection:disconnect	()V
    //   194: iconst_0
    //   195: ifne +13 -> 208
    //   198: aload_0
    //   199: iconst_0
    //   200: iconst_0
    //   201: invokeinterface 221 3 0
    //   206: aconst_null
    //   207: areturn
    //   208: aconst_null
    //   209: putstatic 223	tmsdk/common/e/k:a	Ljava/lang/String;
    //   212: aload_0
    //   213: iconst_1
    //   214: iconst_0
    //   215: invokeinterface 221 3 0
    //   220: aconst_null
    //   221: areturn
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_3
    //   226: aload 4
    //   228: athrow
    //   229: astore 5
    //   231: aload_3
    //   232: astore 4
    //   234: aload 5
    //   236: astore_3
    //   237: aload 4
    //   239: ifnull +8 -> 247
    //   242: aload 4
    //   244: invokevirtual 216	java/net/HttpURLConnection:disconnect	()V
    //   247: iconst_0
    //   248: ifne +52 -> 300
    //   251: aload_0
    //   252: iconst_0
    //   253: iconst_0
    //   254: invokeinterface 221 3 0
    //   259: aload_3
    //   260: athrow
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_3
    //   264: aload_3
    //   265: ifnull +7 -> 272
    //   268: aload_3
    //   269: invokevirtual 216	java/net/HttpURLConnection:disconnect	()V
    //   272: iconst_0
    //   273: ifne +13 -> 286
    //   276: aload_0
    //   277: iconst_0
    //   278: iconst_0
    //   279: invokeinterface 221 3 0
    //   284: aconst_null
    //   285: areturn
    //   286: aconst_null
    //   287: putstatic 223	tmsdk/common/e/k:a	Ljava/lang/String;
    //   290: aload_0
    //   291: iconst_1
    //   292: iconst_0
    //   293: invokeinterface 221 3 0
    //   298: aconst_null
    //   299: areturn
    //   300: aconst_null
    //   301: putstatic 223	tmsdk/common/e/k:a	Ljava/lang/String;
    //   304: aload_0
    //   305: iconst_1
    //   306: iconst_0
    //   307: invokeinterface 221 3 0
    //   312: goto -53 -> 259
    //   315: astore_3
    //   316: aconst_null
    //   317: astore 4
    //   319: goto -82 -> 237
    //   322: astore 5
    //   324: aload_3
    //   325: astore 4
    //   327: aload 5
    //   329: astore_3
    //   330: goto -93 -> 237
    //   333: astore 4
    //   335: goto -71 -> 264
    //   338: astore 4
    //   340: goto -114 -> 226
    //   343: astore 4
    //   345: goto -159 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paraml	l
    //   81	20	1	i	int
    //   133	42	2	bool	boolean
    //   21	118	3	localHttpURLConnection	java.net.HttpURLConnection
    //   183	1	3	localIOException1	IOException
    //   185	75	3	localObject1	Object
    //   261	1	3	localException1	java.lang.Exception
    //   263	6	3	localObject2	Object
    //   315	10	3	localObject3	Object
    //   329	1	3	localObject4	Object
    //   4	177	4	str1	String
    //   222	5	4	localb1	b
    //   232	94	4	localObject5	Object
    //   333	1	4	localException2	java.lang.Exception
    //   338	1	4	localb2	b
    //   343	1	4	localIOException2	IOException
    //   1	160	5	str2	String
    //   229	6	5	localObject6	Object
    //   322	6	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   6	22	183	java/io/IOException
    //   6	22	222	tmsdk/common/b/b
    //   226	229	229	finally
    //   6	22	261	java/lang/Exception
    //   6	22	315	finally
    //   22	38	322	finally
    //   38	82	322	finally
    //   103	111	322	finally
    //   116	126	322	finally
    //   126	132	322	finally
    //   22	38	333	java/lang/Exception
    //   38	82	333	java/lang/Exception
    //   103	111	333	java/lang/Exception
    //   116	126	333	java/lang/Exception
    //   126	132	333	java/lang/Exception
    //   22	38	338	tmsdk/common/b/b
    //   38	82	338	tmsdk/common/b/b
    //   103	111	338	tmsdk/common/b/b
    //   116	126	338	tmsdk/common/b/b
    //   126	132	338	tmsdk/common/b/b
    //   22	38	343	java/io/IOException
    //   38	82	343	java/io/IOException
    //   103	111	343	java/io/IOException
    //   116	126	343	java/io/IOException
    //   126	132	343	java/io/IOException
  }
  
  private static String b(InputStream paramInputStream)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.e.k
 * JD-Core Version:    0.7.0.1
 */