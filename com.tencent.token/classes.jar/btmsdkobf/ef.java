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
    //   93: if_icmpeq +17 -> 110
    //   96: iload_1
    //   97: sipush 301
    //   100: if_icmplt +66 -> 166
    //   103: iload_1
    //   104: sipush 305
    //   107: if_icmpgt +59 -> 166
    //   110: aload 4
    //   112: ldc 73
    //   114: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 5
    //   119: aload 5
    //   121: ifnull +13 -> 134
    //   124: aload 5
    //   126: ldc 73
    //   128: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifne +9 -> 140
    //   134: aload 4
    //   136: invokestatic 86	btmsdkobf/ef:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   139: astore_3
    //   140: iconst_0
    //   141: istore_2
    //   142: aload 4
    //   144: ifnull +8 -> 152
    //   147: aload 4
    //   149: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   152: aload_3
    //   153: ifnonnull +21 -> 174
    //   156: aload_0
    //   157: iconst_0
    //   158: iload_2
    //   159: invokeinterface 94 3 0
    //   164: aload_3
    //   165: areturn
    //   166: iconst_1
    //   167: istore_2
    //   168: aload 5
    //   170: astore_3
    //   171: goto -29 -> 142
    //   174: aload_3
    //   175: putstatic 96	btmsdkobf/ef:oe	Ljava/lang/String;
    //   178: aload_0
    //   179: iconst_1
    //   180: iload_2
    //   181: invokeinterface 94 3 0
    //   186: aload_3
    //   187: areturn
    //   188: astore_3
    //   189: aconst_null
    //   190: astore 4
    //   192: aload 4
    //   194: ifnull +8 -> 202
    //   197: aload 4
    //   199: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   202: iconst_0
    //   203: ifne +13 -> 216
    //   206: aload_0
    //   207: iconst_0
    //   208: iconst_0
    //   209: invokeinterface 94 3 0
    //   214: aconst_null
    //   215: areturn
    //   216: aconst_null
    //   217: putstatic 96	btmsdkobf/ef:oe	Ljava/lang/String;
    //   220: aload_0
    //   221: iconst_1
    //   222: iconst_0
    //   223: invokeinterface 94 3 0
    //   228: aconst_null
    //   229: areturn
    //   230: astore_3
    //   231: aconst_null
    //   232: astore 4
    //   234: aload 4
    //   236: ifnull +8 -> 244
    //   239: aload 4
    //   241: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   244: iconst_0
    //   245: ifne +13 -> 258
    //   248: aload_0
    //   249: iconst_0
    //   250: iconst_0
    //   251: invokeinterface 94 3 0
    //   256: aload_3
    //   257: athrow
    //   258: aconst_null
    //   259: putstatic 96	btmsdkobf/ef:oe	Ljava/lang/String;
    //   262: aload_0
    //   263: iconst_1
    //   264: iconst_0
    //   265: invokeinterface 94 3 0
    //   270: goto -14 -> 256
    //   273: astore_3
    //   274: goto -40 -> 234
    //   277: astore_3
    //   278: goto -86 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	parama	a
    //   88	20	1	i	int
    //   141	40	2	bool	boolean
    //   4	183	3	str1	String
    //   188	1	3	localThrowable1	java.lang.Throwable
    //   230	27	3	localObject1	Object
    //   273	1	3	localObject2	Object
    //   277	1	3	localThrowable2	java.lang.Throwable
    //   20	220	4	localHttpURLConnection	java.net.HttpURLConnection
    //   1	168	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	22	188	java/lang/Throwable
    //   5	22	230	finally
    //   22	38	273	finally
    //   38	89	273	finally
    //   110	119	273	finally
    //   124	134	273	finally
    //   134	140	273	finally
    //   22	38	277	java/lang/Throwable
    //   38	89	277	java/lang/Throwable
    //   110	119	277	java/lang/Throwable
    //   124	134	277	java/lang/Throwable
    //   134	140	277	java/lang/Throwable
  }
  
  /* Error */
  private static String a(java.net.HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 14	java/net/URL
    //   5: dup
    //   6: ldc 16
    //   8: invokespecial 20	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 103	java/net/URL:getHost	()Ljava/lang/String;
    //   14: aload_0
    //   15: invokevirtual 107	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   18: invokevirtual 103	java/net/URL:getHost	()Ljava/lang/String;
    //   21: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifne +218 -> 242
    //   27: aload_0
    //   28: invokevirtual 107	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   31: invokevirtual 110	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_3
    //   37: aload_1
    //   38: ifnonnull +25 -> 63
    //   41: aload_1
    //   42: astore_3
    //   43: aload_1
    //   44: astore_2
    //   45: aload_0
    //   46: ldc 112
    //   48: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   51: ifnull +12 -> 63
    //   54: aload_1
    //   55: astore_2
    //   56: aload_0
    //   57: ldc 112
    //   59: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_3
    //   63: aload_3
    //   64: astore_1
    //   65: aload_3
    //   66: ifnonnull +52 -> 118
    //   69: aload_3
    //   70: astore_1
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: ldc 114
    //   76: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   79: ifnull +39 -> 118
    //   82: aload_3
    //   83: astore_2
    //   84: aload_0
    //   85: ldc 114
    //   87: invokevirtual 77	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   90: ldc 116
    //   92: invokevirtual 120	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   95: astore 4
    //   97: aload_3
    //   98: astore_1
    //   99: aload_3
    //   100: astore_2
    //   101: aload 4
    //   103: arraylength
    //   104: iconst_2
    //   105: if_icmpne +13 -> 118
    //   108: aload_3
    //   109: astore_2
    //   110: aload 4
    //   112: iconst_1
    //   113: aaload
    //   114: invokevirtual 123	java/lang/String:trim	()Ljava/lang/String;
    //   117: astore_1
    //   118: aload_1
    //   119: ifnonnull +116 -> 235
    //   122: aload_1
    //   123: astore_2
    //   124: aload_0
    //   125: invokevirtual 127	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   128: astore_0
    //   129: aload_0
    //   130: ifnull +96 -> 226
    //   133: aload_0
    //   134: invokestatic 130	btmsdkobf/ef:c	(Ljava/io/InputStream;)Ljava/lang/String;
    //   137: astore_2
    //   138: aload_2
    //   139: ifnull +87 -> 226
    //   142: aload_0
    //   143: astore_1
    //   144: aload_2
    //   145: astore_0
    //   146: aload_0
    //   147: astore_2
    //   148: aload_1
    //   149: ifnull +9 -> 158
    //   152: aload_1
    //   153: invokevirtual 135	java/io/InputStream:close	()V
    //   156: aload_0
    //   157: astore_2
    //   158: aload_2
    //   159: areturn
    //   160: astore_0
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_2
    //   164: astore_0
    //   165: aload_0
    //   166: astore_2
    //   167: aload_1
    //   168: ifnull -10 -> 158
    //   171: aload_1
    //   172: invokevirtual 135	java/io/InputStream:close	()V
    //   175: aload_0
    //   176: areturn
    //   177: astore_1
    //   178: aload_0
    //   179: areturn
    //   180: astore_0
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 135	java/io/InputStream:close	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: aload_0
    //   195: areturn
    //   196: astore_1
    //   197: goto -6 -> 191
    //   200: astore_2
    //   201: aload_0
    //   202: astore_1
    //   203: aload_2
    //   204: astore_0
    //   205: goto -22 -> 183
    //   208: astore_0
    //   209: aload_2
    //   210: astore_0
    //   211: aconst_null
    //   212: astore_1
    //   213: goto -48 -> 165
    //   216: astore_2
    //   217: aload_0
    //   218: astore_2
    //   219: aload_1
    //   220: astore_0
    //   221: aload_2
    //   222: astore_1
    //   223: goto -58 -> 165
    //   226: aload_0
    //   227: astore_2
    //   228: aload_1
    //   229: astore_0
    //   230: aload_2
    //   231: astore_1
    //   232: goto -86 -> 146
    //   235: aload_1
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_1
    //   239: goto -93 -> 146
    //   242: aconst_null
    //   243: astore_1
    //   244: goto -209 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   34	138	1	localObject1	Object
    //   177	1	1	localIOException1	java.io.IOException
    //   182	6	1	localObject2	Object
    //   193	1	1	localIOException2	java.io.IOException
    //   196	1	1	localIOException3	java.io.IOException
    //   202	42	1	localHttpURLConnection1	java.net.HttpURLConnection
    //   1	166	2	localObject3	Object
    //   200	10	2	localObject4	Object
    //   216	1	2	localThrowable	java.lang.Throwable
    //   218	13	2	localHttpURLConnection2	java.net.HttpURLConnection
    //   36	73	3	localObject5	Object
    //   95	16	4	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   2	35	160	java/lang/Throwable
    //   171	175	177	java/io/IOException
    //   2	35	180	finally
    //   45	54	180	finally
    //   56	63	180	finally
    //   73	82	180	finally
    //   84	97	180	finally
    //   101	108	180	finally
    //   110	118	180	finally
    //   124	129	180	finally
    //   152	156	193	java/io/IOException
    //   187	191	196	java/io/IOException
    //   133	138	200	finally
    //   45	54	208	java/lang/Throwable
    //   56	63	208	java/lang/Throwable
    //   73	82	208	java/lang/Throwable
    //   84	97	208	java/lang/Throwable
    //   101	108	208	java/lang/Throwable
    //   110	118	208	java/lang/Throwable
    //   124	129	208	java/lang/Throwable
    //   133	138	216	java/lang/Throwable
  }
  
  private static String c(InputStream paramInputStream)
  {
    String str2 = d(paramInputStream);
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
    //   15: astore_1
    //   16: new 192	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   23: astore_0
    //   24: aload_1
    //   25: invokevirtual 197	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +22 -> 52
    //   33: aload_0
    //   34: aload_2
    //   35: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: goto -15 -> 24
    //   42: astore_2
    //   43: aload_1
    //   44: invokevirtual 202	java/io/BufferedReader:close	()V
    //   47: aload_0
    //   48: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: areturn
    //   52: aload_1
    //   53: invokevirtual 202	java/io/BufferedReader:close	()V
    //   56: goto -9 -> 47
    //   59: astore_1
    //   60: goto -13 -> 47
    //   63: astore_0
    //   64: aload_1
    //   65: invokevirtual 202	java/io/BufferedReader:close	()V
    //   68: aload_0
    //   69: athrow
    //   70: astore_1
    //   71: goto -24 -> 47
    //   74: astore_1
    //   75: goto -7 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramInputStream	InputStream
    //   15	38	1	localBufferedReader	java.io.BufferedReader
    //   59	6	1	localIOException1	java.io.IOException
    //   70	1	1	localIOException2	java.io.IOException
    //   74	1	1	localIOException3	java.io.IOException
    //   28	7	2	str	String
    //   42	1	2	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   24	29	42	java/io/IOException
    //   33	39	42	java/io/IOException
    //   52	56	59	java/io/IOException
    //   24	29	63	finally
    //   33	39	63	finally
    //   43	47	70	java/io/IOException
    //   64	68	74	java/io/IOException
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