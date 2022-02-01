import java.util.ArrayList;

public class sfc
{
  sfc.a a;
  boolean mIsRunning;
  ArrayList<sfc.b> mTaskList;
  
  /* Error */
  public static String an(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 24	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: aload 7
    //   15: invokevirtual 32	java/io/File:exists	()Z
    //   18: ifne +191 -> 209
    //   21: aload 7
    //   23: invokevirtual 36	java/io/File:getParentFile	()Ljava/io/File;
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 32	java/io/File:exists	()Z
    //   31: ifne +8 -> 39
    //   34: aload_3
    //   35: invokevirtual 39	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: aload 7
    //   41: invokevirtual 42	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 44	java/net/URL
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 45	java/net/URL:<init>	(Ljava/lang/String;)V
    //   53: invokevirtual 49	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   56: checkcast 51	java/net/HttpURLConnection
    //   59: astore_3
    //   60: aload_3
    //   61: sipush 5000
    //   64: invokevirtual 55	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   67: aload_3
    //   68: sipush 30000
    //   71: invokevirtual 58	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   74: aload_3
    //   75: ldc 60
    //   77: invokevirtual 63	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   80: aload_3
    //   81: ldc 65
    //   83: ldc 67
    //   85: invokevirtual 71	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_3
    //   89: invokevirtual 75	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   92: astore 4
    //   94: new 77	java/io/FileOutputStream
    //   97: dup
    //   98: aload 7
    //   100: iconst_1
    //   101: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   104: astore 5
    //   106: sipush 1024
    //   109: newarray byte
    //   111: astore 6
    //   113: aload 4
    //   115: aload 6
    //   117: invokevirtual 86	java/io/InputStream:read	([B)I
    //   120: istore_2
    //   121: iload_2
    //   122: iconst_m1
    //   123: if_icmpeq +102 -> 225
    //   126: aload 5
    //   128: aload 6
    //   130: iconst_0
    //   131: iload_2
    //   132: invokevirtual 90	java/io/FileOutputStream:write	([BII)V
    //   135: goto -22 -> 113
    //   138: astore_1
    //   139: aload 4
    //   141: astore_1
    //   142: aload_3
    //   143: astore 4
    //   145: aload 5
    //   147: astore_3
    //   148: ldc 92
    //   150: iconst_2
    //   151: new 94	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   158: ldc 99
    //   160: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload 7
    //   175: invokevirtual 116	java/io/File:delete	()Z
    //   178: pop
    //   179: aload 4
    //   181: ifnull +8 -> 189
    //   184: aload 4
    //   186: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 122	java/io/InputStream:close	()V
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   205: aconst_null
    //   206: astore_0
    //   207: aload_0
    //   208: areturn
    //   209: aload 7
    //   211: invokevirtual 116	java/io/File:delete	()Z
    //   214: pop
    //   215: goto -176 -> 39
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   223: aconst_null
    //   224: areturn
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   233: aload 4
    //   235: ifnull +8 -> 243
    //   238: aload 4
    //   240: invokevirtual 122	java/io/InputStream:close	()V
    //   243: aload_1
    //   244: astore_0
    //   245: aload 5
    //   247: ifnull -40 -> 207
    //   250: aload 5
    //   252: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   255: aload_1
    //   256: areturn
    //   257: astore_0
    //   258: ldc 92
    //   260: iconst_2
    //   261: ldc 128
    //   263: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload_1
    //   267: areturn
    //   268: astore_0
    //   269: ldc 92
    //   271: iconst_2
    //   272: ldc 128
    //   274: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: goto -72 -> 205
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_1
    //   283: aconst_null
    //   284: astore 4
    //   286: aload 6
    //   288: astore_3
    //   289: aload 4
    //   291: ifnull +8 -> 299
    //   294: aload 4
    //   296: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   299: aload_1
    //   300: ifnull +7 -> 307
    //   303: aload_1
    //   304: invokevirtual 122	java/io/InputStream:close	()V
    //   307: aload_3
    //   308: ifnull +7 -> 315
    //   311: aload_3
    //   312: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   315: aload_0
    //   316: athrow
    //   317: astore_1
    //   318: ldc 92
    //   320: iconst_2
    //   321: ldc 128
    //   323: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: goto -11 -> 315
    //   329: astore_0
    //   330: goto -87 -> 243
    //   333: astore_0
    //   334: goto -137 -> 197
    //   337: astore_1
    //   338: goto -31 -> 307
    //   341: astore_0
    //   342: aload_3
    //   343: astore 4
    //   345: aconst_null
    //   346: astore_1
    //   347: aload 6
    //   349: astore_3
    //   350: goto -61 -> 289
    //   353: astore_0
    //   354: aload 4
    //   356: astore_1
    //   357: aload_3
    //   358: astore 4
    //   360: aload 6
    //   362: astore_3
    //   363: goto -74 -> 289
    //   366: astore_0
    //   367: aload 4
    //   369: astore_1
    //   370: aload_3
    //   371: astore 4
    //   373: aload 5
    //   375: astore_3
    //   376: goto -87 -> 289
    //   379: astore_0
    //   380: goto -91 -> 289
    //   383: astore_1
    //   384: aconst_null
    //   385: astore_3
    //   386: aconst_null
    //   387: astore_1
    //   388: aconst_null
    //   389: astore 4
    //   391: goto -243 -> 148
    //   394: astore_1
    //   395: aconst_null
    //   396: astore_1
    //   397: aload_3
    //   398: astore 4
    //   400: aconst_null
    //   401: astore_3
    //   402: goto -254 -> 148
    //   405: astore_1
    //   406: aload 4
    //   408: astore_1
    //   409: aload_3
    //   410: astore 4
    //   412: aconst_null
    //   413: astore_3
    //   414: goto -266 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	paramString1	String
    //   0	417	1	paramString2	String
    //   120	12	2	i	int
    //   26	388	3	localObject1	Object
    //   92	319	4	localObject2	Object
    //   104	270	5	localFileOutputStream	java.io.FileOutputStream
    //   1	360	6	arrayOfByte	byte[]
    //   11	199	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   106	113	138	java/lang/Exception
    //   113	121	138	java/lang/Exception
    //   126	135	138	java/lang/Exception
    //   39	45	218	java/io/IOException
    //   250	255	257	java/io/IOException
    //   201	205	268	java/io/IOException
    //   45	60	280	finally
    //   311	315	317	java/io/IOException
    //   238	243	329	java/io/IOException
    //   193	197	333	java/io/IOException
    //   303	307	337	java/io/IOException
    //   60	94	341	finally
    //   94	106	353	finally
    //   106	113	366	finally
    //   113	121	366	finally
    //   126	135	366	finally
    //   148	179	379	finally
    //   45	60	383	java/lang/Exception
    //   60	94	394	java/lang/Exception
    //   94	106	405	java/lang/Exception
  }
  
  public void doDownload()
  {
    if (this.mIsRunning) {
      return;
    }
    while (this.mTaskList.size() > 0)
    {
      this.mIsRunning = true;
      sfc.b localb = (sfc.b)this.mTaskList.remove(0);
      String str = an(localb.mUrl, localb.dQ);
      if (this.a != null) {
        if (str != null) {
          this.a.a(true, localb.mCallbackId, localb.mUrl, localb.dQ);
        } else {
          this.a.a(false, localb.mCallbackId, localb.mUrl, localb.dQ);
        }
      }
    }
    this.mIsRunning = false;
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2);
  }
  
  public static class b
  {
    public String dQ;
    public int mCallbackId;
    public String mUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfc
 * JD-Core Version:    0.7.0.1
 */