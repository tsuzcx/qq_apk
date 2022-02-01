package btmsdkobf;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ef
{
  public static String oe;
  
  /* Error */
  public static String a(a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: new 14	java/net/URL
    //   8: dup
    //   9: ldc 16
    //   11: invokespecial 20	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 24	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 26	java/net/HttpURLConnection
    //   20: astore 4
    //   22: invokestatic 32	com/tmsdk/base/utils/SDKUtil:getSDKVersion	()I
    //   25: bipush 8
    //   27: if_icmpge +11 -> 38
    //   30: ldc 34
    //   32: ldc 36
    //   34: invokestatic 42	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: pop
    //   38: aload 4
    //   40: iconst_0
    //   41: invokevirtual 46	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   44: aload 4
    //   46: ldc 48
    //   48: ldc 50
    //   50: invokevirtual 54	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload 4
    //   55: ldc 56
    //   57: ldc 50
    //   59: invokevirtual 54	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload 4
    //   64: iconst_0
    //   65: invokevirtual 59	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   68: aload 4
    //   70: ldc 61
    //   72: invokevirtual 64	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   75: aload 4
    //   77: sipush 5000
    //   80: invokevirtual 68	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   83: aload 4
    //   85: invokevirtual 71	java/net/HttpURLConnection:getResponseCode	()I
    //   88: istore_1
    //   89: iload_1
    //   90: sipush 200
    //   93: if_icmpeq +20 -> 113
    //   96: iload_1
    //   97: sipush 301
    //   100: if_icmplt +142 -> 242
    //   103: iload_1
    //   104: sipush 305
    //   107: if_icmpgt +135 -> 242
    //   110: goto +3 -> 113
    //   113: aload 4
    //   115: ldc 73
    //   117: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 5
    //   122: aload 5
    //   124: ifnull +13 -> 137
    //   127: aload 5
    //   129: ldc 73
    //   131: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifne +9 -> 143
    //   137: aload 4
    //   139: invokestatic 86	btmsdkobf/ef:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   142: astore_3
    //   143: iconst_0
    //   144: istore_2
    //   145: aload 4
    //   147: ifnull +8 -> 155
    //   150: aload 4
    //   152: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   155: aload_3
    //   156: ifnonnull +13 -> 169
    //   159: aload_0
    //   160: iconst_0
    //   161: iload_2
    //   162: invokeinterface 94 3 0
    //   167: aload_3
    //   168: areturn
    //   169: aload_3
    //   170: putstatic 96	btmsdkobf/ef:oe	Ljava/lang/String;
    //   173: aload_0
    //   174: iconst_1
    //   175: iconst_0
    //   176: invokeinterface 94 3 0
    //   181: aload_3
    //   182: areturn
    //   183: astore_3
    //   184: goto +7 -> 191
    //   187: astore_3
    //   188: aconst_null
    //   189: astore 4
    //   191: aload 4
    //   193: ifnull +8 -> 201
    //   196: aload 4
    //   198: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   201: aload_0
    //   202: iconst_0
    //   203: iconst_0
    //   204: invokeinterface 94 3 0
    //   209: aload_3
    //   210: athrow
    //   211: aconst_null
    //   212: astore 4
    //   214: aload 4
    //   216: ifnull +8 -> 224
    //   219: aload 4
    //   221: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   224: aload_0
    //   225: iconst_0
    //   226: iconst_0
    //   227: invokeinterface 94 3 0
    //   232: aconst_null
    //   233: areturn
    //   234: astore_3
    //   235: goto -24 -> 211
    //   238: astore_3
    //   239: goto -25 -> 214
    //   242: iconst_1
    //   243: istore_2
    //   244: aload 5
    //   246: astore_3
    //   247: goto -102 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	parama	a
    //   88	20	1	i	int
    //   144	100	2	bool	boolean
    //   4	178	3	str1	String
    //   183	1	3	localObject1	Object
    //   187	23	3	localObject2	Object
    //   234	1	3	localThrowable1	java.lang.Throwable
    //   238	1	3	localThrowable2	java.lang.Throwable
    //   246	1	3	str2	String
    //   20	200	4	localHttpURLConnection	java.net.HttpURLConnection
    //   1	244	5	str3	String
    // Exception table:
    //   from	to	target	type
    //   22	38	183	finally
    //   38	89	183	finally
    //   113	122	183	finally
    //   127	137	183	finally
    //   137	143	183	finally
    //   5	22	187	finally
    //   5	22	234	java/lang/Throwable
    //   22	38	238	java/lang/Throwable
    //   38	89	238	java/lang/Throwable
    //   113	122	238	java/lang/Throwable
    //   127	137	238	java/lang/Throwable
    //   137	143	238	java/lang/Throwable
  }
  
  /* Error */
  private static String a(java.net.HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: aload 6
    //   14: astore 5
    //   16: new 14	java/net/URL
    //   19: dup
    //   20: ldc 16
    //   22: invokespecial 20	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 103	java/net/URL:getHost	()Ljava/lang/String;
    //   28: aload_0
    //   29: invokevirtual 107	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   32: invokevirtual 103	java/net/URL:getHost	()Ljava/lang/String;
    //   35: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifne +18 -> 56
    //   41: aload 6
    //   43: astore 5
    //   45: aload_0
    //   46: invokevirtual 107	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   49: invokevirtual 110	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   52: astore_2
    //   53: goto +5 -> 58
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: astore_3
    //   60: aload_2
    //   61: ifnonnull +41 -> 102
    //   64: aload_2
    //   65: astore_3
    //   66: aload 6
    //   68: astore 5
    //   70: aload 7
    //   72: astore 4
    //   74: aload_2
    //   75: astore_1
    //   76: aload_0
    //   77: ldc 112
    //   79: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   82: ifnull +20 -> 102
    //   85: aload 6
    //   87: astore 5
    //   89: aload 7
    //   91: astore 4
    //   93: aload_2
    //   94: astore_1
    //   95: aload_0
    //   96: ldc 112
    //   98: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_3
    //   102: aload_3
    //   103: astore_2
    //   104: aload_3
    //   105: ifnonnull +84 -> 189
    //   108: aload_3
    //   109: astore_2
    //   110: aload 6
    //   112: astore 5
    //   114: aload 7
    //   116: astore 4
    //   118: aload_3
    //   119: astore_1
    //   120: aload_0
    //   121: ldc 114
    //   123: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   126: ifnull +63 -> 189
    //   129: aload 6
    //   131: astore 5
    //   133: aload 7
    //   135: astore 4
    //   137: aload_3
    //   138: astore_1
    //   139: aload_0
    //   140: ldc 114
    //   142: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   145: ldc 116
    //   147: invokevirtual 120	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   150: astore 9
    //   152: aload_3
    //   153: astore_2
    //   154: aload 6
    //   156: astore 5
    //   158: aload 7
    //   160: astore 4
    //   162: aload_3
    //   163: astore_1
    //   164: aload 9
    //   166: arraylength
    //   167: iconst_2
    //   168: if_icmpne +21 -> 189
    //   171: aload 6
    //   173: astore 5
    //   175: aload 7
    //   177: astore 4
    //   179: aload_3
    //   180: astore_1
    //   181: aload 9
    //   183: iconst_1
    //   184: aaload
    //   185: invokevirtual 123	java/lang/String:trim	()Ljava/lang/String;
    //   188: astore_2
    //   189: aload 8
    //   191: astore_3
    //   192: aload_2
    //   193: astore_1
    //   194: aload_2
    //   195: ifnonnull +60 -> 255
    //   198: aload 6
    //   200: astore 5
    //   202: aload 7
    //   204: astore 4
    //   206: aload_2
    //   207: astore_1
    //   208: aload_0
    //   209: invokevirtual 127	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   212: astore_0
    //   213: aload_0
    //   214: astore_3
    //   215: aload_2
    //   216: astore_1
    //   217: aload_0
    //   218: ifnull +37 -> 255
    //   221: aload_0
    //   222: astore 5
    //   224: aload_0
    //   225: astore 4
    //   227: aload_2
    //   228: astore_1
    //   229: aload_0
    //   230: invokestatic 130	btmsdkobf/ef:c	(Ljava/io/InputStream;)Ljava/lang/String;
    //   233: astore 6
    //   235: aload_0
    //   236: astore_3
    //   237: aload_2
    //   238: astore_1
    //   239: aload 6
    //   241: ifnull +14 -> 255
    //   244: aload 6
    //   246: astore_1
    //   247: aload_0
    //   248: astore_3
    //   249: goto +6 -> 255
    //   252: goto +30 -> 282
    //   255: aload_1
    //   256: astore_0
    //   257: aload_3
    //   258: ifnull +37 -> 295
    //   261: aload_3
    //   262: invokevirtual 135	java/io/InputStream:close	()V
    //   265: aload_1
    //   266: areturn
    //   267: astore_0
    //   268: aload 5
    //   270: ifnull +8 -> 278
    //   273: aload 5
    //   275: invokevirtual 135	java/io/InputStream:close	()V
    //   278: aload_0
    //   279: athrow
    //   280: aconst_null
    //   281: astore_1
    //   282: aload_1
    //   283: astore_0
    //   284: aload 4
    //   286: ifnull +9 -> 295
    //   289: aload 4
    //   291: astore_3
    //   292: goto -31 -> 261
    //   295: aload_0
    //   296: areturn
    //   297: astore_0
    //   298: goto -18 -> 280
    //   301: astore_0
    //   302: goto -50 -> 252
    //   305: astore_0
    //   306: aload_1
    //   307: areturn
    //   308: astore_1
    //   309: goto -31 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   75	232	1	localObject1	Object
    //   308	1	1	localIOException	java.io.IOException
    //   52	186	2	localObject2	Object
    //   59	233	3	localObject3	Object
    //   4	286	4	localObject4	Object
    //   14	260	5	localObject5	Object
    //   1	244	6	str	String
    //   7	196	7	localObject6	Object
    //   10	180	8	localObject7	Object
    //   150	32	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   16	41	267	finally
    //   45	53	267	finally
    //   76	85	267	finally
    //   95	102	267	finally
    //   120	129	267	finally
    //   139	152	267	finally
    //   164	171	267	finally
    //   181	189	267	finally
    //   208	213	267	finally
    //   229	235	267	finally
    //   16	41	297	java/lang/Throwable
    //   45	53	297	java/lang/Throwable
    //   76	85	301	java/lang/Throwable
    //   95	102	301	java/lang/Throwable
    //   120	129	301	java/lang/Throwable
    //   139	152	301	java/lang/Throwable
    //   164	171	301	java/lang/Throwable
    //   181	189	301	java/lang/Throwable
    //   208	213	301	java/lang/Throwable
    //   229	235	301	java/lang/Throwable
    //   261	265	305	java/io/IOException
    //   273	278	308	java/io/IOException
  }
  
  private static String c(InputStream paramInputStream)
  {
    String str2 = d(paramInputStream);
    int i = 0;
    paramInputStream = null;
    while ((i < 5) && (paramInputStream == null))
    {
      Matcher localMatcher = Pattern.compile(new String[] { "http-equiv\\s*=\\s*[\"']*refresh[\"']*\\s*content\\s*=\\s*[\"']*[^;]*;\\s*url\\s*=\\s*[\"']*([^\"'\\s>]+)", "[^\\w](?:location.href\\s*=|location\\s*=|location.replace\\s*\\()\\s*[\"']*([^\"'>]+)", "<NextURL>([^<]+)", "\\s+action\\s*=\\s*[\"']*([^\"'>]+)[\"'>\\s]*.*submit", "<LoginURL>([^<]+)" }[i], 2).matcher(str2);
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
    return paramInputStream;
  }
  
  /* Error */
  private static String d(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 182	java/io/BufferedReader
    //   3: dup
    //   4: new 184	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 187	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 190	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_0
    //   16: new 192	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_0
    //   25: invokevirtual 197	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +12 -> 42
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: goto -15 -> 24
    //   42: aload_0
    //   43: invokevirtual 202	java/io/BufferedReader:close	()V
    //   46: goto +10 -> 56
    //   49: astore_1
    //   50: aload_0
    //   51: invokevirtual 202	java/io/BufferedReader:close	()V
    //   54: aload_1
    //   55: athrow
    //   56: aload_1
    //   57: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: areturn
    //   61: astore_2
    //   62: goto -20 -> 42
    //   65: astore_0
    //   66: goto -10 -> 56
    //   69: astore_0
    //   70: goto -16 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramInputStream	InputStream
    //   23	11	1	localStringBuilder	java.lang.StringBuilder
    //   49	8	1	localObject	Object
    //   28	7	2	str	String
    //   61	1	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   24	29	49	finally
    //   33	39	49	finally
    //   24	29	61	java/io/IOException
    //   33	39	61	java/io/IOException
    //   42	46	65	java/io/IOException
    //   50	54	69	java/io/IOException
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ef
 * JD-Core Version:    0.7.0.1
 */