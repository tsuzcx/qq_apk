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
    //   100: if_icmplt +145 -> 245
    //   103: iload_1
    //   104: sipush 305
    //   107: if_icmpgt +138 -> 245
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
    //   175: iload_2
    //   176: invokeinterface 94 3 0
    //   181: aload_3
    //   182: areturn
    //   183: astore_3
    //   184: goto +10 -> 194
    //   187: goto +30 -> 217
    //   190: astore_3
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 4
    //   196: ifnull +8 -> 204
    //   199: aload 4
    //   201: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   204: aload_0
    //   205: iconst_0
    //   206: iconst_0
    //   207: invokeinterface 94 3 0
    //   212: aload_3
    //   213: athrow
    //   214: aconst_null
    //   215: astore 4
    //   217: aload 4
    //   219: ifnull +8 -> 227
    //   222: aload 4
    //   224: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   227: aload_0
    //   228: iconst_0
    //   229: iconst_0
    //   230: invokeinterface 94 3 0
    //   235: aconst_null
    //   236: areturn
    //   237: astore_3
    //   238: goto -24 -> 214
    //   241: astore_3
    //   242: goto -55 -> 187
    //   245: iconst_1
    //   246: istore_2
    //   247: aload 5
    //   249: astore_3
    //   250: goto -105 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	parama	a
    //   88	20	1	i	int
    //   144	103	2	bool	boolean
    //   4	178	3	str1	String
    //   183	1	3	localObject1	Object
    //   190	23	3	localObject2	Object
    //   237	1	3	localThrowable1	java.lang.Throwable
    //   241	1	3	localThrowable2	java.lang.Throwable
    //   249	1	3	str2	String
    //   20	203	4	localHttpURLConnection	java.net.HttpURLConnection
    //   1	247	5	str3	String
    // Exception table:
    //   from	to	target	type
    //   22	38	183	finally
    //   38	89	183	finally
    //   113	122	183	finally
    //   127	137	183	finally
    //   137	143	183	finally
    //   5	22	190	finally
    //   5	22	237	java/lang/Throwable
    //   22	38	241	java/lang/Throwable
    //   38	89	241	java/lang/Throwable
    //   113	122	241	java/lang/Throwable
    //   127	137	241	java/lang/Throwable
    //   137	143	241	java/lang/Throwable
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
    //   61: ifnonnull +44 -> 105
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
    //   82: ifnull +23 -> 105
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
    //   102: goto +3 -> 105
    //   105: aload_3
    //   106: astore_2
    //   107: aload_3
    //   108: ifnonnull +84 -> 192
    //   111: aload_3
    //   112: astore_2
    //   113: aload 6
    //   115: astore 5
    //   117: aload 7
    //   119: astore 4
    //   121: aload_3
    //   122: astore_1
    //   123: aload_0
    //   124: ldc 114
    //   126: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   129: ifnull +63 -> 192
    //   132: aload 6
    //   134: astore 5
    //   136: aload 7
    //   138: astore 4
    //   140: aload_3
    //   141: astore_1
    //   142: aload_0
    //   143: ldc 114
    //   145: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   148: ldc 116
    //   150: invokevirtual 120	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: astore 9
    //   155: aload_3
    //   156: astore_2
    //   157: aload 6
    //   159: astore 5
    //   161: aload 7
    //   163: astore 4
    //   165: aload_3
    //   166: astore_1
    //   167: aload 9
    //   169: arraylength
    //   170: iconst_2
    //   171: if_icmpne +21 -> 192
    //   174: aload 6
    //   176: astore 5
    //   178: aload 7
    //   180: astore 4
    //   182: aload_3
    //   183: astore_1
    //   184: aload 9
    //   186: iconst_1
    //   187: aaload
    //   188: invokevirtual 123	java/lang/String:trim	()Ljava/lang/String;
    //   191: astore_2
    //   192: aload 8
    //   194: astore_3
    //   195: aload_2
    //   196: astore_1
    //   197: aload_2
    //   198: ifnonnull +54 -> 252
    //   201: aload 6
    //   203: astore 5
    //   205: aload 7
    //   207: astore 4
    //   209: aload_2
    //   210: astore_1
    //   211: aload_0
    //   212: invokevirtual 127	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   215: astore_0
    //   216: aload_0
    //   217: astore_3
    //   218: aload_2
    //   219: astore_1
    //   220: aload_0
    //   221: ifnull +31 -> 252
    //   224: aload_0
    //   225: astore 5
    //   227: aload_0
    //   228: astore 4
    //   230: aload_2
    //   231: astore_1
    //   232: aload_0
    //   233: invokestatic 130	btmsdkobf/ef:c	(Ljava/io/InputStream;)Ljava/lang/String;
    //   236: astore 6
    //   238: aload_0
    //   239: astore_3
    //   240: aload_2
    //   241: astore_1
    //   242: aload 6
    //   244: ifnull +8 -> 252
    //   247: aload 6
    //   249: astore_1
    //   250: aload_0
    //   251: astore_3
    //   252: aload_1
    //   253: astore_0
    //   254: aload_3
    //   255: ifnull +37 -> 292
    //   258: aload_3
    //   259: invokevirtual 135	java/io/InputStream:close	()V
    //   262: aload_1
    //   263: areturn
    //   264: astore_0
    //   265: aload 5
    //   267: ifnull +8 -> 275
    //   270: aload 5
    //   272: invokevirtual 135	java/io/InputStream:close	()V
    //   275: aload_0
    //   276: athrow
    //   277: aconst_null
    //   278: astore_1
    //   279: aload_1
    //   280: astore_0
    //   281: aload 4
    //   283: ifnull +9 -> 292
    //   286: aload 4
    //   288: astore_3
    //   289: goto -31 -> 258
    //   292: aload_0
    //   293: areturn
    //   294: astore_0
    //   295: goto -18 -> 277
    //   298: astore_0
    //   299: goto +10 -> 309
    //   302: astore_0
    //   303: aload_1
    //   304: areturn
    //   305: astore_1
    //   306: goto -31 -> 275
    //   309: goto -30 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   75	229	1	localObject1	Object
    //   305	1	1	localIOException	java.io.IOException
    //   52	189	2	localObject2	Object
    //   59	230	3	localObject3	Object
    //   4	283	4	localObject4	Object
    //   14	257	5	localObject5	Object
    //   1	247	6	str	String
    //   7	199	7	localObject6	Object
    //   10	183	8	localObject7	Object
    //   153	32	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   16	41	264	finally
    //   45	53	264	finally
    //   76	85	264	finally
    //   95	102	264	finally
    //   123	132	264	finally
    //   142	155	264	finally
    //   167	174	264	finally
    //   184	192	264	finally
    //   211	216	264	finally
    //   232	238	264	finally
    //   16	41	294	java/lang/Throwable
    //   45	53	294	java/lang/Throwable
    //   76	85	298	java/lang/Throwable
    //   95	102	298	java/lang/Throwable
    //   123	132	298	java/lang/Throwable
    //   142	155	298	java/lang/Throwable
    //   167	174	298	java/lang/Throwable
    //   184	192	298	java/lang/Throwable
    //   211	216	298	java/lang/Throwable
    //   232	238	298	java/lang/Throwable
    //   258	262	302	java/io/IOException
    //   270	275	305	java/io/IOException
  }
  
  private static String c(InputStream paramInputStream)
  {
    String str2 = d(paramInputStream);
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