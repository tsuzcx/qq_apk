package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public final class qc
  extends qa
{
  private HttpURLConnection b;
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static void a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramOutputStream == null)) {
      return;
    }
    try
    {
      paramOutputStream.write(paramArrayOfByte);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  /* Error */
  private static byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 40	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 41	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: sipush 4096
    //   19: newarray byte
    //   21: astore 4
    //   23: aload_3
    //   24: astore_2
    //   25: aload_0
    //   26: aload 4
    //   28: iconst_0
    //   29: sipush 4096
    //   32: invokevirtual 47	java/io/InputStream:read	([BII)I
    //   35: istore_1
    //   36: iload_1
    //   37: iconst_m1
    //   38: if_icmpeq +33 -> 71
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 50	java/io/ByteArrayOutputStream:write	([BII)V
    //   51: goto -28 -> 23
    //   54: astore_2
    //   55: aload_3
    //   56: astore_0
    //   57: aload_2
    //   58: astore_3
    //   59: aload_0
    //   60: astore_2
    //   61: aload_3
    //   62: invokevirtual 51	java/lang/Throwable:printStackTrace	()V
    //   65: aload_0
    //   66: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload_3
    //   72: astore_2
    //   73: aload_3
    //   74: invokevirtual 56	java/io/ByteArrayOutputStream:flush	()V
    //   77: aload_3
    //   78: astore_2
    //   79: aload_3
    //   80: invokevirtual 60	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   83: astore_0
    //   84: aload_3
    //   85: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   88: aload_0
    //   89: areturn
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_2
    //   94: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: goto -7 -> 93
    //   103: astore_3
    //   104: aconst_null
    //   105: astore_0
    //   106: goto -47 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramInputStream	java.io.InputStream
    //   35	13	1	i	int
    //   15	28	2	localObject1	Object
    //   54	4	2	localThrowable1	java.lang.Throwable
    //   60	34	2	localObject2	Object
    //   13	72	3	localObject3	Object
    //   103	1	3	localThrowable2	java.lang.Throwable
    //   21	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	23	54	java/lang/Throwable
    //   25	36	54	java/lang/Throwable
    //   43	51	54	java/lang/Throwable
    //   73	77	54	java/lang/Throwable
    //   79	84	54	java/lang/Throwable
    //   6	14	90	finally
    //   16	23	99	finally
    //   25	36	99	finally
    //   43	51	99	finally
    //   61	65	99	finally
    //   73	77	99	finally
    //   79	84	99	finally
    //   6	14	103	java/lang/Throwable
  }
  
  /* Error */
  protected final com.tencent.map.tools.net.NetResponse a(java.lang.String paramString1, java.lang.String paramString2, int paramInt1, int paramInt2, java.util.HashMap<java.lang.String, java.lang.String> paramHashMap, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler)
  {
    // Byte code:
    //   0: new 67	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 70	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore 9
    //   10: aconst_null
    //   11: astore_1
    //   12: new 6	com/tencent/map/sdk/a/qc$a
    //   15: dup
    //   16: aload_0
    //   17: iload_3
    //   18: invokespecial 73	com/tencent/map/sdk/a/qc$a:<init>	(Lcom/tencent/map/sdk/a/qc;I)V
    //   21: astore 10
    //   23: aload 10
    //   25: invokevirtual 76	com/tencent/map/sdk/a/qc$a:a	()Z
    //   28: ifeq +414 -> 442
    //   31: aconst_null
    //   32: astore 7
    //   34: aconst_null
    //   35: astore 8
    //   37: aload 9
    //   39: ifnull +465 -> 504
    //   42: aload 9
    //   44: invokevirtual 80	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   47: checkcast 82	java/net/HttpURLConnection
    //   50: astore 7
    //   52: aload 7
    //   54: ldc 84
    //   56: invokevirtual 87	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   59: iload 4
    //   61: ifle +10 -> 71
    //   64: aload 7
    //   66: iload 4
    //   68: invokevirtual 91	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   71: aload 5
    //   73: ifnull +140 -> 213
    //   76: aload 5
    //   78: invokevirtual 96	java/util/HashMap:isEmpty	()Z
    //   81: ifne +132 -> 213
    //   84: aload 5
    //   86: invokevirtual 100	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   89: invokeinterface 106 1 0
    //   94: astore 8
    //   96: aload 8
    //   98: invokeinterface 111 1 0
    //   103: ifeq +110 -> 213
    //   106: aload 8
    //   108: invokeinterface 115 1 0
    //   113: checkcast 117	java/util/Map$Entry
    //   116: astore 12
    //   118: aload 12
    //   120: invokeinterface 120 1 0
    //   125: checkcast 122	java/lang/String
    //   128: astore 11
    //   130: aload 12
    //   132: invokeinterface 125 1 0
    //   137: checkcast 122	java/lang/String
    //   140: astore 12
    //   142: aload 11
    //   144: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifne -51 -> 96
    //   150: aload 12
    //   152: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne -59 -> 96
    //   158: aload 7
    //   160: aload 11
    //   162: aload 12
    //   164: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: goto -71 -> 96
    //   170: astore 8
    //   172: aload 7
    //   174: astore 8
    //   176: aload 10
    //   178: invokevirtual 136	com/tencent/map/sdk/a/qc$a:b	()V
    //   181: aload_1
    //   182: astore 7
    //   184: aload 8
    //   186: ifnull +250 -> 436
    //   189: aload 8
    //   191: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   194: goto -171 -> 23
    //   197: astore_1
    //   198: new 141	com/tencent/map/tools/net/NetResponse
    //   201: dup
    //   202: aload_1
    //   203: invokespecial 144	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   206: astore_1
    //   207: aconst_null
    //   208: astore 9
    //   210: goto -198 -> 12
    //   213: aload_2
    //   214: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifne +11 -> 228
    //   220: aload 7
    //   222: ldc 146
    //   224: aload_2
    //   225: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 6
    //   230: ifnull +25 -> 255
    //   233: aload 6
    //   235: aload_0
    //   236: new 148	com/tencent/map/sdk/a/qc$1
    //   239: dup
    //   240: aload_0
    //   241: aload 10
    //   243: invokespecial 151	com/tencent/map/sdk/a/qc$1:<init>	(Lcom/tencent/map/sdk/a/qc;Lcom/tencent/map/sdk/a/qc$a;)V
    //   246: invokevirtual 157	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/sdk/a/ft;)V
    //   249: aload_0
    //   250: aload 7
    //   252: putfield 17	com/tencent/map/sdk/a/qc:b	Ljava/net/HttpURLConnection;
    //   255: aload 7
    //   257: invokevirtual 160	java/net/HttpURLConnection:connect	()V
    //   260: aload 7
    //   262: invokevirtual 164	java/net/HttpURLConnection:getResponseCode	()I
    //   265: istore_3
    //   266: new 141	com/tencent/map/tools/net/NetResponse
    //   269: dup
    //   270: invokespecial 165	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   273: astore 8
    //   275: aload 8
    //   277: iload_3
    //   278: putfield 169	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   281: aload 8
    //   283: aload 7
    //   285: invokevirtual 173	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   288: invokestatic 176	com/tencent/map/sdk/a/qc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   291: putfield 180	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   294: iload_3
    //   295: sipush 200
    //   298: if_icmpne +51 -> 349
    //   301: aload 8
    //   303: iconst_0
    //   304: putfield 183	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   307: aload 8
    //   309: aload 7
    //   311: invokevirtual 187	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   314: invokestatic 189	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   317: putfield 193	com/tencent/map/tools/net/NetResponse:data	[B
    //   320: aload 10
    //   322: iconst_0
    //   323: putfield 196	com/tencent/map/sdk/a/qc$a:a	Z
    //   326: aload 8
    //   328: astore_1
    //   329: aload 7
    //   331: astore 8
    //   333: aload_1
    //   334: astore 7
    //   336: aload 8
    //   338: ifnull +98 -> 436
    //   341: aload 8
    //   343: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   346: goto -323 -> 23
    //   349: aload 8
    //   351: aload 7
    //   353: invokevirtual 199	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   356: invokestatic 189	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   359: putfield 202	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   362: aload 10
    //   364: invokevirtual 136	com/tencent/map/sdk/a/qc$a:b	()V
    //   367: aload 8
    //   369: astore_1
    //   370: aload 7
    //   372: astore 8
    //   374: goto -41 -> 333
    //   377: astore 7
    //   379: iconst_0
    //   380: istore_3
    //   381: aconst_null
    //   382: astore_1
    //   383: new 141	com/tencent/map/tools/net/NetResponse
    //   386: dup
    //   387: aload 7
    //   389: invokespecial 144	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   392: astore 8
    //   394: aload 8
    //   396: iload_3
    //   397: putfield 169	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   400: aload 10
    //   402: invokevirtual 136	com/tencent/map/sdk/a/qc$a:b	()V
    //   405: aload 8
    //   407: astore 7
    //   409: aload_1
    //   410: ifnull +26 -> 436
    //   413: aload_1
    //   414: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   417: aload 8
    //   419: astore_1
    //   420: goto -397 -> 23
    //   423: astore_2
    //   424: aconst_null
    //   425: astore_1
    //   426: aload_1
    //   427: ifnull +7 -> 434
    //   430: aload_1
    //   431: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   434: aload_2
    //   435: athrow
    //   436: aload 7
    //   438: astore_1
    //   439: goto -416 -> 23
    //   442: aload_1
    //   443: areturn
    //   444: astore_2
    //   445: aload 7
    //   447: astore_1
    //   448: goto -22 -> 426
    //   451: astore_2
    //   452: aload 8
    //   454: astore_1
    //   455: goto -29 -> 426
    //   458: astore_2
    //   459: goto -33 -> 426
    //   462: astore 8
    //   464: iconst_0
    //   465: istore_3
    //   466: aload 7
    //   468: astore_1
    //   469: aload 8
    //   471: astore 7
    //   473: goto -90 -> 383
    //   476: astore 8
    //   478: aload 7
    //   480: astore_1
    //   481: aload 8
    //   483: astore 7
    //   485: goto -102 -> 383
    //   488: astore 7
    //   490: goto -314 -> 176
    //   493: astore_1
    //   494: aload 8
    //   496: astore_1
    //   497: aload 7
    //   499: astore 8
    //   501: goto -325 -> 176
    //   504: aload 7
    //   506: astore 8
    //   508: goto -175 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	qc
    //   0	511	1	paramString1	java.lang.String
    //   0	511	2	paramString2	java.lang.String
    //   0	511	3	paramInt1	int
    //   0	511	4	paramInt2	int
    //   0	511	5	paramHashMap	java.util.HashMap<java.lang.String, java.lang.String>
    //   0	511	6	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   32	339	7	localObject1	Object
    //   377	11	7	localIOException1	IOException
    //   407	77	7	localObject2	Object
    //   488	17	7	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   35	72	8	localIterator	java.util.Iterator
    //   170	1	8	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   174	279	8	localObject3	Object
    //   462	8	8	localIOException2	IOException
    //   476	19	8	localIOException3	IOException
    //   499	8	8	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   8	201	9	localURL	java.net.URL
    //   21	380	10	locala	a
    //   128	33	11	str	java.lang.String
    //   116	47	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   52	59	170	java/net/SocketTimeoutException
    //   64	71	170	java/net/SocketTimeoutException
    //   76	96	170	java/net/SocketTimeoutException
    //   96	167	170	java/net/SocketTimeoutException
    //   213	228	170	java/net/SocketTimeoutException
    //   233	255	170	java/net/SocketTimeoutException
    //   255	266	170	java/net/SocketTimeoutException
    //   266	275	170	java/net/SocketTimeoutException
    //   0	10	197	java/net/MalformedURLException
    //   42	52	377	java/io/IOException
    //   42	52	423	finally
    //   52	59	444	finally
    //   64	71	444	finally
    //   76	96	444	finally
    //   96	167	444	finally
    //   213	228	444	finally
    //   233	255	444	finally
    //   255	266	444	finally
    //   266	275	444	finally
    //   275	294	444	finally
    //   301	326	444	finally
    //   349	367	444	finally
    //   176	181	451	finally
    //   383	405	458	finally
    //   52	59	462	java/io/IOException
    //   64	71	462	java/io/IOException
    //   76	96	462	java/io/IOException
    //   96	167	462	java/io/IOException
    //   213	228	462	java/io/IOException
    //   233	255	462	java/io/IOException
    //   255	266	462	java/io/IOException
    //   266	275	476	java/io/IOException
    //   275	294	476	java/io/IOException
    //   301	326	476	java/io/IOException
    //   349	367	476	java/io/IOException
    //   42	52	488	java/net/SocketTimeoutException
    //   275	294	493	java/net/SocketTimeoutException
    //   301	326	493	java/net/SocketTimeoutException
    //   349	367	493	java/net/SocketTimeoutException
  }
  
  /* Error */
  protected final com.tencent.map.tools.net.NetResponse a(java.lang.String paramString1, java.lang.String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 8
    //   15: new 67	java/net/URL
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 70	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aconst_null
    //   25: astore 5
    //   27: aload_1
    //   28: ifnull +384 -> 412
    //   31: aload_1
    //   32: invokevirtual 80	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   35: checkcast 82	java/net/HttpURLConnection
    //   38: astore_1
    //   39: aload 9
    //   41: astore 6
    //   43: aload 10
    //   45: astore 7
    //   47: aload_1
    //   48: ldc 207
    //   50: invokevirtual 87	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   53: aload 9
    //   55: astore 6
    //   57: aload 10
    //   59: astore 7
    //   61: aload_1
    //   62: iconst_1
    //   63: invokevirtual 211	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   66: aload 9
    //   68: astore 6
    //   70: aload 10
    //   72: astore 7
    //   74: aload_2
    //   75: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +18 -> 96
    //   81: aload 9
    //   83: astore 6
    //   85: aload 10
    //   87: astore 7
    //   89: aload_1
    //   90: ldc 146
    //   92: aload_2
    //   93: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload 9
    //   98: astore 6
    //   100: aload 10
    //   102: astore 7
    //   104: aload_1
    //   105: invokevirtual 215	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   108: astore_2
    //   109: aload_2
    //   110: astore 6
    //   112: aload_2
    //   113: astore 7
    //   115: aload_3
    //   116: aload_2
    //   117: invokestatic 217	com/tencent/map/sdk/a/qc:a	([BLjava/io/OutputStream;)V
    //   120: aload_2
    //   121: astore 6
    //   123: aload_2
    //   124: astore 7
    //   126: aload_1
    //   127: invokevirtual 160	java/net/HttpURLConnection:connect	()V
    //   130: aload_2
    //   131: astore 6
    //   133: aload_2
    //   134: astore 7
    //   136: aload_1
    //   137: invokevirtual 164	java/net/HttpURLConnection:getResponseCode	()I
    //   140: istore 4
    //   142: aload_2
    //   143: astore 6
    //   145: aload_2
    //   146: astore 7
    //   148: new 141	com/tencent/map/tools/net/NetResponse
    //   151: dup
    //   152: invokespecial 165	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   155: astore_3
    //   156: aload_2
    //   157: astore 6
    //   159: aload_3
    //   160: iload 4
    //   162: putfield 169	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   165: aload_2
    //   166: astore 6
    //   168: aload_3
    //   169: aload_1
    //   170: invokevirtual 173	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   173: invokestatic 176	com/tencent/map/sdk/a/qc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 180	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   179: iload 4
    //   181: sipush 200
    //   184: if_icmpne +63 -> 247
    //   187: aload_2
    //   188: astore 6
    //   190: aload_3
    //   191: iconst_0
    //   192: putfield 183	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   195: aload_2
    //   196: astore 6
    //   198: aload_3
    //   199: aload_1
    //   200: invokevirtual 187	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   203: invokestatic 189	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   206: putfield 193	com/tencent/map/tools/net/NetResponse:data	[B
    //   209: aload_1
    //   210: astore 5
    //   212: aload_3
    //   213: astore_1
    //   214: aload 5
    //   216: astore_3
    //   217: aload_3
    //   218: ifnull +7 -> 225
    //   221: aload_3
    //   222: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   225: aload_2
    //   226: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   229: aload_1
    //   230: areturn
    //   231: astore_1
    //   232: new 141	com/tencent/map/tools/net/NetResponse
    //   235: dup
    //   236: aload_1
    //   237: invokespecial 144	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   240: astore 5
    //   242: aconst_null
    //   243: astore_1
    //   244: goto -217 -> 27
    //   247: aload_2
    //   248: astore 6
    //   250: aload_3
    //   251: aload_1
    //   252: invokevirtual 199	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   255: invokestatic 189	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   258: putfield 202	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   261: aload_1
    //   262: astore 5
    //   264: aload_3
    //   265: astore_1
    //   266: aload 5
    //   268: astore_3
    //   269: goto -52 -> 217
    //   272: astore_1
    //   273: aload 5
    //   275: astore_1
    //   276: aconst_null
    //   277: astore_3
    //   278: aload 6
    //   280: astore_2
    //   281: aload_3
    //   282: ifnull +7 -> 289
    //   285: aload_3
    //   286: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   289: aload_2
    //   290: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   293: aload_1
    //   294: areturn
    //   295: astore_3
    //   296: iconst_0
    //   297: istore 4
    //   299: aconst_null
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_2
    //   303: new 141	com/tencent/map/tools/net/NetResponse
    //   306: dup
    //   307: aload_3
    //   308: invokespecial 144	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   311: astore_3
    //   312: aload_3
    //   313: iload 4
    //   315: putfield 169	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   318: aload_1
    //   319: ifnull +7 -> 326
    //   322: aload_1
    //   323: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   326: aload_2
    //   327: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   330: aload_3
    //   331: areturn
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_1
    //   335: aload 7
    //   337: astore 6
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   347: aload 6
    //   349: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   352: aload_2
    //   353: athrow
    //   354: astore_2
    //   355: goto -16 -> 339
    //   358: astore_3
    //   359: aload_2
    //   360: astore 6
    //   362: aload_3
    //   363: astore_2
    //   364: goto -25 -> 339
    //   367: astore_3
    //   368: aconst_null
    //   369: astore_2
    //   370: iconst_0
    //   371: istore 4
    //   373: goto -70 -> 303
    //   376: astore_3
    //   377: iconst_0
    //   378: istore 4
    //   380: goto -77 -> 303
    //   383: astore_3
    //   384: goto -81 -> 303
    //   387: astore_2
    //   388: aload_1
    //   389: astore_3
    //   390: aload 5
    //   392: astore_1
    //   393: aload 7
    //   395: astore_2
    //   396: goto -115 -> 281
    //   399: astore 5
    //   401: aload_1
    //   402: astore 5
    //   404: aload_3
    //   405: astore_1
    //   406: aload 5
    //   408: astore_3
    //   409: goto -128 -> 281
    //   412: aload 5
    //   414: astore_1
    //   415: aconst_null
    //   416: astore_3
    //   417: aload 8
    //   419: astore_2
    //   420: goto -203 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	qc
    //   0	423	1	paramString1	java.lang.String
    //   0	423	2	paramString2	java.lang.String
    //   0	423	3	paramArrayOfByte	byte[]
    //   140	239	4	i	int
    //   25	366	5	localObject1	Object
    //   399	1	5	localSocketTimeoutException	java.net.SocketTimeoutException
    //   402	11	5	str	java.lang.String
    //   1	360	6	localObject2	Object
    //   4	390	7	localObject3	Object
    //   13	405	8	localObject4	Object
    //   7	90	9	localObject5	Object
    //   10	91	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   15	24	231	java/net/MalformedURLException
    //   31	39	272	java/net/SocketTimeoutException
    //   31	39	295	java/io/IOException
    //   31	39	332	finally
    //   47	53	354	finally
    //   61	66	354	finally
    //   74	81	354	finally
    //   89	96	354	finally
    //   104	109	354	finally
    //   115	120	354	finally
    //   126	130	354	finally
    //   136	142	354	finally
    //   148	156	354	finally
    //   159	165	354	finally
    //   168	179	354	finally
    //   190	195	354	finally
    //   198	209	354	finally
    //   250	261	354	finally
    //   303	318	358	finally
    //   47	53	367	java/io/IOException
    //   61	66	367	java/io/IOException
    //   74	81	367	java/io/IOException
    //   89	96	367	java/io/IOException
    //   104	109	367	java/io/IOException
    //   115	120	376	java/io/IOException
    //   126	130	376	java/io/IOException
    //   136	142	376	java/io/IOException
    //   148	156	383	java/io/IOException
    //   159	165	383	java/io/IOException
    //   168	179	383	java/io/IOException
    //   190	195	383	java/io/IOException
    //   198	209	383	java/io/IOException
    //   250	261	383	java/io/IOException
    //   47	53	387	java/net/SocketTimeoutException
    //   61	66	387	java/net/SocketTimeoutException
    //   74	81	387	java/net/SocketTimeoutException
    //   89	96	387	java/net/SocketTimeoutException
    //   104	109	387	java/net/SocketTimeoutException
    //   115	120	387	java/net/SocketTimeoutException
    //   126	130	387	java/net/SocketTimeoutException
    //   136	142	387	java/net/SocketTimeoutException
    //   148	156	387	java/net/SocketTimeoutException
    //   159	165	399	java/net/SocketTimeoutException
    //   168	179	399	java/net/SocketTimeoutException
    //   190	195	399	java/net/SocketTimeoutException
    //   198	209	399	java/net/SocketTimeoutException
    //   250	261	399	java/net/SocketTimeoutException
  }
  
  /* Error */
  protected final com.tencent.map.tools.net.NetResponse a(java.lang.String paramString1, java.lang.String paramString2, byte[] paramArrayOfByte, int paramInt1, java.util.HashMap<java.lang.String, java.lang.String> paramHashMap, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler, int paramInt2)
  {
    // Byte code:
    //   0: new 67	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 70	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore 11
    //   10: aconst_null
    //   11: astore_1
    //   12: new 6	com/tencent/map/sdk/a/qc$a
    //   15: dup
    //   16: aload_0
    //   17: iload 4
    //   19: invokespecial 73	com/tencent/map/sdk/a/qc$a:<init>	(Lcom/tencent/map/sdk/a/qc;I)V
    //   22: astore 13
    //   24: aload_1
    //   25: astore 8
    //   27: aload 13
    //   29: invokevirtual 76	com/tencent/map/sdk/a/qc$a:a	()Z
    //   32: ifeq +451 -> 483
    //   35: aconst_null
    //   36: astore 10
    //   38: aconst_null
    //   39: astore 9
    //   41: aload 11
    //   43: ifnull +530 -> 573
    //   46: aload 11
    //   48: invokevirtual 80	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   51: checkcast 82	java/net/HttpURLConnection
    //   54: astore_1
    //   55: aload_1
    //   56: ldc 207
    //   58: invokevirtual 87	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: iconst_1
    //   63: invokevirtual 211	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   66: iload 7
    //   68: ifle +9 -> 77
    //   71: aload_1
    //   72: iload 7
    //   74: invokevirtual 91	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   77: aload 5
    //   79: ifnull +157 -> 236
    //   82: aload 5
    //   84: invokevirtual 96	java/util/HashMap:isEmpty	()Z
    //   87: ifne +149 -> 236
    //   90: aload 5
    //   92: invokevirtual 100	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   95: invokeinterface 106 1 0
    //   100: astore 12
    //   102: aload 12
    //   104: invokeinterface 111 1 0
    //   109: ifeq +127 -> 236
    //   112: aload 12
    //   114: invokeinterface 115 1 0
    //   119: checkcast 117	java/util/Map$Entry
    //   122: astore 15
    //   124: aload 15
    //   126: invokeinterface 120 1 0
    //   131: checkcast 122	java/lang/String
    //   134: astore 14
    //   136: aload 15
    //   138: invokeinterface 125 1 0
    //   143: checkcast 122	java/lang/String
    //   146: astore 15
    //   148: aload 14
    //   150: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifne -51 -> 102
    //   156: aload 15
    //   158: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifne -59 -> 102
    //   164: aload_1
    //   165: aload 14
    //   167: aload 15
    //   169: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: goto -70 -> 102
    //   175: astore 9
    //   177: aconst_null
    //   178: astore 10
    //   180: aload_1
    //   181: astore 9
    //   183: aload 8
    //   185: astore_1
    //   186: aload 9
    //   188: astore 8
    //   190: aload 10
    //   192: astore 9
    //   194: aload 13
    //   196: invokevirtual 136	com/tencent/map/sdk/a/qc$a:b	()V
    //   199: aload 8
    //   201: ifnull +8 -> 209
    //   204: aload 8
    //   206: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   209: aload 9
    //   211: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   214: aload_1
    //   215: astore 8
    //   217: goto -190 -> 27
    //   220: astore_1
    //   221: new 141	com/tencent/map/tools/net/NetResponse
    //   224: dup
    //   225: aload_1
    //   226: invokespecial 144	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   229: astore_1
    //   230: aconst_null
    //   231: astore 11
    //   233: goto -221 -> 12
    //   236: aload_2
    //   237: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   240: ifne +10 -> 250
    //   243: aload_1
    //   244: ldc 146
    //   246: aload_2
    //   247: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 6
    //   252: ifnull +24 -> 276
    //   255: aload 6
    //   257: aload_0
    //   258: new 220	com/tencent/map/sdk/a/qc$2
    //   261: dup
    //   262: aload_0
    //   263: aload 13
    //   265: invokespecial 221	com/tencent/map/sdk/a/qc$2:<init>	(Lcom/tencent/map/sdk/a/qc;Lcom/tencent/map/sdk/a/qc$a;)V
    //   268: invokevirtual 157	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/sdk/a/ft;)V
    //   271: aload_0
    //   272: aload_1
    //   273: putfield 17	com/tencent/map/sdk/a/qc:b	Ljava/net/HttpURLConnection;
    //   276: aload_1
    //   277: invokevirtual 215	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   280: astore 12
    //   282: aload 12
    //   284: astore 9
    //   286: aload_3
    //   287: aload 9
    //   289: invokestatic 217	com/tencent/map/sdk/a/qc:a	([BLjava/io/OutputStream;)V
    //   292: aload_1
    //   293: invokevirtual 160	java/net/HttpURLConnection:connect	()V
    //   296: aload_1
    //   297: invokevirtual 164	java/net/HttpURLConnection:getResponseCode	()I
    //   300: istore 4
    //   302: new 141	com/tencent/map/tools/net/NetResponse
    //   305: dup
    //   306: invokespecial 165	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   309: astore 10
    //   311: aload 10
    //   313: iload 4
    //   315: putfield 169	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   318: aload 10
    //   320: aload_1
    //   321: invokevirtual 173	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   324: invokestatic 176	com/tencent/map/sdk/a/qc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   327: putfield 180	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   330: iload 4
    //   332: sipush 200
    //   335: if_icmpne +54 -> 389
    //   338: aload 10
    //   340: iconst_0
    //   341: putfield 183	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   344: aload 10
    //   346: aload_1
    //   347: invokevirtual 187	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   350: invokestatic 189	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   353: putfield 193	com/tencent/map/tools/net/NetResponse:data	[B
    //   356: aload 13
    //   358: iconst_0
    //   359: putfield 196	com/tencent/map/sdk/a/qc$a:a	Z
    //   362: aload_1
    //   363: astore 8
    //   365: aload 10
    //   367: astore_1
    //   368: aload 8
    //   370: ifnull +8 -> 378
    //   373: aload 8
    //   375: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   378: aload 9
    //   380: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   383: aload_1
    //   384: astore 8
    //   386: goto -359 -> 27
    //   389: aload 10
    //   391: aload_1
    //   392: invokevirtual 199	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   395: invokestatic 189	com/tencent/map/sdk/a/qc:a	(Ljava/io/InputStream;)[B
    //   398: putfield 202	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   401: aload 13
    //   403: invokevirtual 136	com/tencent/map/sdk/a/qc$a:b	()V
    //   406: aload_1
    //   407: astore 8
    //   409: aload 10
    //   411: astore_1
    //   412: goto -44 -> 368
    //   415: astore 8
    //   417: iconst_0
    //   418: istore 4
    //   420: aconst_null
    //   421: astore_1
    //   422: new 141	com/tencent/map/tools/net/NetResponse
    //   425: dup
    //   426: aload 8
    //   428: invokespecial 144	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   431: astore 8
    //   433: aload 8
    //   435: iload 4
    //   437: putfield 169	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   440: aload 13
    //   442: invokevirtual 136	com/tencent/map/sdk/a/qc$a:b	()V
    //   445: aload_1
    //   446: ifnull +7 -> 453
    //   449: aload_1
    //   450: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   453: aload 9
    //   455: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   458: goto -431 -> 27
    //   461: astore_2
    //   462: aconst_null
    //   463: astore_1
    //   464: aload 10
    //   466: astore 9
    //   468: aload_1
    //   469: ifnull +7 -> 476
    //   472: aload_1
    //   473: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   476: aload 9
    //   478: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   481: aload_2
    //   482: athrow
    //   483: aload 8
    //   485: areturn
    //   486: astore_2
    //   487: aload 10
    //   489: astore 9
    //   491: goto -23 -> 468
    //   494: astore_2
    //   495: goto -27 -> 468
    //   498: astore_2
    //   499: aload 8
    //   501: astore_1
    //   502: goto -34 -> 468
    //   505: astore_2
    //   506: goto -38 -> 468
    //   509: astore 8
    //   511: iconst_0
    //   512: istore 4
    //   514: goto -92 -> 422
    //   517: astore 8
    //   519: iconst_0
    //   520: istore 4
    //   522: goto -100 -> 422
    //   525: astore 8
    //   527: goto -105 -> 422
    //   530: astore_1
    //   531: aconst_null
    //   532: astore 10
    //   534: aload 8
    //   536: astore_1
    //   537: aconst_null
    //   538: astore 9
    //   540: aload 10
    //   542: astore 8
    //   544: goto -350 -> 194
    //   547: astore 10
    //   549: aload_1
    //   550: astore 10
    //   552: aload 8
    //   554: astore_1
    //   555: aload 10
    //   557: astore 8
    //   559: goto -365 -> 194
    //   562: astore 8
    //   564: aload_1
    //   565: astore 8
    //   567: aload 10
    //   569: astore_1
    //   570: goto -376 -> 194
    //   573: aconst_null
    //   574: astore 10
    //   576: aload 8
    //   578: astore_1
    //   579: aconst_null
    //   580: astore 9
    //   582: aload 10
    //   584: astore 8
    //   586: goto -218 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	qc
    //   0	589	1	paramString1	java.lang.String
    //   0	589	2	paramString2	java.lang.String
    //   0	589	3	paramArrayOfByte	byte[]
    //   0	589	4	paramInt1	int
    //   0	589	5	paramHashMap	java.util.HashMap<java.lang.String, java.lang.String>
    //   0	589	6	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   0	589	7	paramInt2	int
    //   25	383	8	localObject1	Object
    //   415	12	8	localIOException1	IOException
    //   431	69	8	localNetResponse1	com.tencent.map.tools.net.NetResponse
    //   509	1	8	localIOException2	IOException
    //   517	1	8	localIOException3	IOException
    //   525	10	8	localIOException4	IOException
    //   542	16	8	localObject2	Object
    //   562	1	8	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   565	20	8	localObject3	Object
    //   39	1	9	localObject4	Object
    //   175	1	9	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   181	400	9	localObject5	Object
    //   36	505	10	localNetResponse2	com.tencent.map.tools.net.NetResponse
    //   547	1	10	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   550	33	10	str1	java.lang.String
    //   8	224	11	localURL	java.net.URL
    //   100	183	12	localObject6	Object
    //   22	419	13	locala	a
    //   134	32	14	str2	java.lang.String
    //   122	46	15	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   55	66	175	java/net/SocketTimeoutException
    //   71	77	175	java/net/SocketTimeoutException
    //   82	102	175	java/net/SocketTimeoutException
    //   102	172	175	java/net/SocketTimeoutException
    //   236	250	175	java/net/SocketTimeoutException
    //   255	276	175	java/net/SocketTimeoutException
    //   276	282	175	java/net/SocketTimeoutException
    //   0	10	220	java/net/MalformedURLException
    //   46	55	415	java/io/IOException
    //   46	55	461	finally
    //   55	66	486	finally
    //   71	77	486	finally
    //   82	102	486	finally
    //   102	172	486	finally
    //   236	250	486	finally
    //   255	276	486	finally
    //   276	282	486	finally
    //   286	302	494	finally
    //   302	311	494	finally
    //   311	330	494	finally
    //   338	362	494	finally
    //   389	406	494	finally
    //   194	199	498	finally
    //   422	445	505	finally
    //   55	66	509	java/io/IOException
    //   71	77	509	java/io/IOException
    //   82	102	509	java/io/IOException
    //   102	172	509	java/io/IOException
    //   236	250	509	java/io/IOException
    //   255	276	509	java/io/IOException
    //   276	282	509	java/io/IOException
    //   286	302	517	java/io/IOException
    //   302	311	525	java/io/IOException
    //   311	330	525	java/io/IOException
    //   338	362	525	java/io/IOException
    //   389	406	525	java/io/IOException
    //   46	55	530	java/net/SocketTimeoutException
    //   286	302	547	java/net/SocketTimeoutException
    //   302	311	547	java/net/SocketTimeoutException
    //   311	330	562	java/net/SocketTimeoutException
    //   338	362	562	java/net/SocketTimeoutException
    //   389	406	562	java/net/SocketTimeoutException
  }
  
  protected final void a(Context paramContext, Bundle paramBundle)
  {
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  /* Error */
  protected final void a(java.lang.String paramString1, byte[] paramArrayOfByte, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4, java.lang.String paramString5, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 15
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 14
    //   18: aconst_null
    //   19: astore 12
    //   21: new 67	java/net/URL
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 70	java/net/URL:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +437 -> 468
    //   34: aload_1
    //   35: invokevirtual 80	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   38: checkcast 82	java/net/HttpURLConnection
    //   41: astore_1
    //   42: aload 12
    //   44: astore 10
    //   46: aload 13
    //   48: astore 11
    //   50: aload 14
    //   52: astore 9
    //   54: aload_1
    //   55: ldc 207
    //   57: invokevirtual 87	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   60: aload 12
    //   62: astore 10
    //   64: aload 13
    //   66: astore 11
    //   68: aload 14
    //   70: astore 9
    //   72: aload_1
    //   73: iconst_1
    //   74: invokevirtual 211	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   77: aload 12
    //   79: astore 10
    //   81: aload 13
    //   83: astore 11
    //   85: aload 14
    //   87: astore 9
    //   89: aload_1
    //   90: ldc 146
    //   92: ldc 249
    //   94: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload 12
    //   99: astore 10
    //   101: aload 13
    //   103: astore 11
    //   105: aload 14
    //   107: astore 9
    //   109: aload_1
    //   110: ldc 251
    //   112: aload_3
    //   113: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 12
    //   118: astore 10
    //   120: aload 13
    //   122: astore 11
    //   124: aload 14
    //   126: astore 9
    //   128: aload_1
    //   129: ldc 253
    //   131: aload 4
    //   133: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 12
    //   138: astore 10
    //   140: aload 13
    //   142: astore 11
    //   144: aload 14
    //   146: astore 9
    //   148: aload_1
    //   149: ldc 255
    //   151: aload 5
    //   153: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 12
    //   158: astore 10
    //   160: aload 13
    //   162: astore 11
    //   164: aload 14
    //   166: astore 9
    //   168: aload_1
    //   169: ldc_w 257
    //   172: new 259	java/lang/StringBuilder
    //   175: dup
    //   176: ldc_w 261
    //   179: invokespecial 262	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload 6
    //   184: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc_w 268
    //   190: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokevirtual 134	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload 7
    //   201: ifnull +46 -> 247
    //   204: aload 12
    //   206: astore 10
    //   208: aload 13
    //   210: astore 11
    //   212: aload 14
    //   214: astore 9
    //   216: aload 7
    //   218: aload_0
    //   219: new 273	com/tencent/map/sdk/a/qc$3
    //   222: dup
    //   223: aload_0
    //   224: invokespecial 276	com/tencent/map/sdk/a/qc$3:<init>	(Lcom/tencent/map/sdk/a/qc;)V
    //   227: invokevirtual 157	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/sdk/a/ft;)V
    //   230: aload 12
    //   232: astore 10
    //   234: aload 13
    //   236: astore 11
    //   238: aload 14
    //   240: astore 9
    //   242: aload_0
    //   243: aload_1
    //   244: putfield 17	com/tencent/map/sdk/a/qc:b	Ljava/net/HttpURLConnection;
    //   247: aload 12
    //   249: astore 10
    //   251: aload 13
    //   253: astore 11
    //   255: aload 14
    //   257: astore 9
    //   259: aload_1
    //   260: invokevirtual 215	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   263: astore_3
    //   264: aload_3
    //   265: astore 10
    //   267: aload_3
    //   268: astore 11
    //   270: aload_3
    //   271: astore 9
    //   273: aload_2
    //   274: aload_3
    //   275: invokestatic 217	com/tencent/map/sdk/a/qc:a	([BLjava/io/OutputStream;)V
    //   278: aload_3
    //   279: astore 10
    //   281: aload_3
    //   282: astore 11
    //   284: aload_3
    //   285: astore 9
    //   287: aload_1
    //   288: invokevirtual 160	java/net/HttpURLConnection:connect	()V
    //   291: aload_3
    //   292: astore 10
    //   294: aload_3
    //   295: astore 11
    //   297: aload_3
    //   298: astore 9
    //   300: aload_1
    //   301: invokevirtual 164	java/net/HttpURLConnection:getResponseCode	()I
    //   304: istore 8
    //   306: aload_3
    //   307: astore 10
    //   309: aload_3
    //   310: astore 11
    //   312: aload_3
    //   313: astore 9
    //   315: aload_1
    //   316: invokevirtual 173	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   319: invokestatic 176	com/tencent/map/sdk/a/qc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   322: pop
    //   323: aload_1
    //   324: astore 4
    //   326: aload_3
    //   327: astore_2
    //   328: iload 8
    //   330: sipush 200
    //   333: if_icmpne +141 -> 474
    //   336: aload_3
    //   337: astore 10
    //   339: aload_3
    //   340: astore 11
    //   342: aload_3
    //   343: astore 9
    //   345: aload_1
    //   346: ldc_w 278
    //   349: invokevirtual 281	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   352: astore 5
    //   354: aload_3
    //   355: astore 10
    //   357: aload_3
    //   358: astore 11
    //   360: aload_3
    //   361: astore 9
    //   363: aload 5
    //   365: invokestatic 234	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   368: istore 8
    //   370: aload_1
    //   371: astore 4
    //   373: aload_3
    //   374: astore_2
    //   375: iload 8
    //   377: ifeq +97 -> 474
    //   380: iload 8
    //   382: bipush 254
    //   384: if_icmpne +41 -> 425
    //   387: aload_3
    //   388: astore 10
    //   390: aload_3
    //   391: astore 11
    //   393: aload_3
    //   394: astore 9
    //   396: new 283	com/tencent/map/sdk/a/qj
    //   399: dup
    //   400: invokespecial 284	com/tencent/map/sdk/a/qj:<init>	()V
    //   403: athrow
    //   404: astore_2
    //   405: aload_1
    //   406: ifnull +7 -> 413
    //   409: aload_1
    //   410: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   413: aload 10
    //   415: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   418: return
    //   419: astore_1
    //   420: aconst_null
    //   421: astore_1
    //   422: goto -392 -> 30
    //   425: aload_3
    //   426: astore 10
    //   428: aload_3
    //   429: astore 11
    //   431: aload_3
    //   432: astore 9
    //   434: new 247	java/lang/Exception
    //   437: dup
    //   438: ldc_w 286
    //   441: aload 5
    //   443: invokestatic 290	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   446: invokevirtual 293	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   449: invokespecial 294	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   452: athrow
    //   453: astore_2
    //   454: aload_1
    //   455: ifnull +7 -> 462
    //   458: aload_1
    //   459: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   462: aload 11
    //   464: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   467: return
    //   468: aconst_null
    //   469: astore 4
    //   471: aload 15
    //   473: astore_2
    //   474: aload 4
    //   476: ifnull +8 -> 484
    //   479: aload 4
    //   481: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   484: aload_2
    //   485: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   488: return
    //   489: astore_2
    //   490: aconst_null
    //   491: astore_1
    //   492: aload_1
    //   493: ifnull +7 -> 500
    //   496: aload_1
    //   497: invokevirtual 139	java/net/HttpURLConnection:disconnect	()V
    //   500: aload 9
    //   502: invokestatic 53	com/tencent/map/sdk/a/qc:a	(Ljava/io/Closeable;)V
    //   505: aload_2
    //   506: athrow
    //   507: astore_2
    //   508: goto -16 -> 492
    //   511: astore_1
    //   512: aconst_null
    //   513: astore_1
    //   514: goto -60 -> 454
    //   517: astore_1
    //   518: aconst_null
    //   519: astore_1
    //   520: goto -115 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	qc
    //   0	523	1	paramString1	java.lang.String
    //   0	523	2	paramArrayOfByte	byte[]
    //   0	523	3	paramString2	java.lang.String
    //   0	523	4	paramString3	java.lang.String
    //   0	523	5	paramString4	java.lang.String
    //   0	523	6	paramString5	java.lang.String
    //   0	523	7	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   304	81	8	i	int
    //   13	488	9	localObject1	Object
    //   1	426	10	localObject2	Object
    //   7	456	11	localObject3	Object
    //   19	229	12	localObject4	Object
    //   4	248	13	localObject5	Object
    //   16	240	14	localObject6	Object
    //   10	462	15	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   54	60	404	java/net/SocketTimeoutException
    //   72	77	404	java/net/SocketTimeoutException
    //   89	97	404	java/net/SocketTimeoutException
    //   109	116	404	java/net/SocketTimeoutException
    //   128	136	404	java/net/SocketTimeoutException
    //   148	156	404	java/net/SocketTimeoutException
    //   168	199	404	java/net/SocketTimeoutException
    //   216	230	404	java/net/SocketTimeoutException
    //   242	247	404	java/net/SocketTimeoutException
    //   259	264	404	java/net/SocketTimeoutException
    //   273	278	404	java/net/SocketTimeoutException
    //   287	291	404	java/net/SocketTimeoutException
    //   300	306	404	java/net/SocketTimeoutException
    //   315	323	404	java/net/SocketTimeoutException
    //   345	354	404	java/net/SocketTimeoutException
    //   363	370	404	java/net/SocketTimeoutException
    //   396	404	404	java/net/SocketTimeoutException
    //   434	453	404	java/net/SocketTimeoutException
    //   21	30	419	java/net/MalformedURLException
    //   54	60	453	java/io/IOException
    //   72	77	453	java/io/IOException
    //   89	97	453	java/io/IOException
    //   109	116	453	java/io/IOException
    //   128	136	453	java/io/IOException
    //   148	156	453	java/io/IOException
    //   168	199	453	java/io/IOException
    //   216	230	453	java/io/IOException
    //   242	247	453	java/io/IOException
    //   259	264	453	java/io/IOException
    //   273	278	453	java/io/IOException
    //   287	291	453	java/io/IOException
    //   300	306	453	java/io/IOException
    //   315	323	453	java/io/IOException
    //   345	354	453	java/io/IOException
    //   363	370	453	java/io/IOException
    //   396	404	453	java/io/IOException
    //   434	453	453	java/io/IOException
    //   34	42	489	finally
    //   54	60	507	finally
    //   72	77	507	finally
    //   89	97	507	finally
    //   109	116	507	finally
    //   128	136	507	finally
    //   148	156	507	finally
    //   168	199	507	finally
    //   216	230	507	finally
    //   242	247	507	finally
    //   259	264	507	finally
    //   273	278	507	finally
    //   287	291	507	finally
    //   300	306	507	finally
    //   315	323	507	finally
    //   345	354	507	finally
    //   363	370	507	finally
    //   396	404	507	finally
    //   434	453	507	finally
    //   34	42	511	java/io/IOException
    //   34	42	517	java/net/SocketTimeoutException
  }
  
  public final boolean cancel()
  {
    if (this.b != null)
    {
      this.b.disconnect();
      return true;
    }
    return false;
  }
  
  final class a
  {
    boolean a = true;
    private int c;
    
    a(int paramInt)
    {
      this.c = paramInt;
      if (this.c > 3) {
        this.c = 3;
      }
      if (this.c <= 0) {
        this.c = 1;
      }
    }
    
    final boolean a()
    {
      return (this.a) && (this.c > 0);
    }
    
    final void b()
    {
      this.c -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.qc
 * JD-Core Version:    0.7.0.1
 */