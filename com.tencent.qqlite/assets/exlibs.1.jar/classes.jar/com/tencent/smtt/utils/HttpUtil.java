package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpUtil
{
  public static final String DEFAULT_ENCODE_NAME = "utf-8";
  private static final int DEFAULT_TIME_OUT = 20000;
  
  private static void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  /* Error */
  private static String httpPost(HttpURLConnection paramHttpURLConnection, HttpResponseListener paramHttpResponseListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 7
    //   18: aconst_null
    //   19: astore 8
    //   21: aload 9
    //   23: astore 4
    //   25: aload 7
    //   27: astore 5
    //   29: aload 10
    //   31: astore 6
    //   33: aload_0
    //   34: invokevirtual 38	java/net/HttpURLConnection:getResponseCode	()I
    //   37: istore_3
    //   38: aload_1
    //   39: ifnull +22 -> 61
    //   42: aload 9
    //   44: astore 4
    //   46: aload 7
    //   48: astore 5
    //   50: aload 10
    //   52: astore 6
    //   54: aload_1
    //   55: iload_3
    //   56: invokeinterface 42 2 0
    //   61: aload 13
    //   63: astore 5
    //   65: aload 12
    //   67: astore_1
    //   68: aload 11
    //   70: astore 4
    //   72: iload_3
    //   73: sipush 200
    //   76: if_icmpne +244 -> 320
    //   79: aload 9
    //   81: astore 4
    //   83: aload 7
    //   85: astore 5
    //   87: aload 10
    //   89: astore 6
    //   91: aload_0
    //   92: invokevirtual 46	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   95: astore_1
    //   96: aload 9
    //   98: astore 4
    //   100: aload 7
    //   102: astore 5
    //   104: aload 10
    //   106: astore 6
    //   108: aload_0
    //   109: invokevirtual 50	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   112: astore_0
    //   113: aload_0
    //   114: ifnull +116 -> 230
    //   117: aload 9
    //   119: astore 4
    //   121: aload 7
    //   123: astore 5
    //   125: aload 10
    //   127: astore 6
    //   129: aload_0
    //   130: ldc 52
    //   132: invokevirtual 58	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   135: ifeq +95 -> 230
    //   138: aload 9
    //   140: astore 4
    //   142: aload 7
    //   144: astore 5
    //   146: aload 10
    //   148: astore 6
    //   150: new 60	java/util/zip/GZIPInputStream
    //   153: dup
    //   154: aload_1
    //   155: invokespecial 63	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   158: astore_0
    //   159: aload_0
    //   160: astore 4
    //   162: aload 7
    //   164: astore 5
    //   166: aload_0
    //   167: astore 6
    //   169: new 65	java/io/ByteArrayOutputStream
    //   172: dup
    //   173: invokespecial 66	java/io/ByteArrayOutputStream:<init>	()V
    //   176: astore_1
    //   177: sipush 128
    //   180: newarray byte
    //   182: astore 4
    //   184: aload_0
    //   185: aload 4
    //   187: invokevirtual 72	java/io/InputStream:read	([B)I
    //   190: istore_3
    //   191: iload_3
    //   192: iconst_m1
    //   193: if_icmpeq +99 -> 292
    //   196: aload_1
    //   197: aload 4
    //   199: iconst_0
    //   200: iload_3
    //   201: invokevirtual 76	java/io/ByteArrayOutputStream:write	([BII)V
    //   204: goto -20 -> 184
    //   207: astore 7
    //   209: aload_0
    //   210: astore 4
    //   212: aload_1
    //   213: astore 5
    //   215: aload 7
    //   217: invokevirtual 79	java/lang/Throwable:printStackTrace	()V
    //   220: aload_0
    //   221: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   224: aload_1
    //   225: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   228: aconst_null
    //   229: areturn
    //   230: aload_0
    //   231: ifnull +56 -> 287
    //   234: aload 9
    //   236: astore 4
    //   238: aload 7
    //   240: astore 5
    //   242: aload 10
    //   244: astore 6
    //   246: aload_0
    //   247: ldc 83
    //   249: invokevirtual 58	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   252: ifeq +35 -> 287
    //   255: aload 9
    //   257: astore 4
    //   259: aload 7
    //   261: astore 5
    //   263: aload 10
    //   265: astore 6
    //   267: new 85	java/util/zip/InflaterInputStream
    //   270: dup
    //   271: aload_1
    //   272: new 87	java/util/zip/Inflater
    //   275: dup
    //   276: iconst_1
    //   277: invokespecial 90	java/util/zip/Inflater:<init>	(Z)V
    //   280: invokespecial 93	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   283: astore_0
    //   284: goto -125 -> 159
    //   287: aload_1
    //   288: astore_0
    //   289: goto -130 -> 159
    //   292: iload_2
    //   293: ifeq +39 -> 332
    //   296: new 54	java/lang/String
    //   299: dup
    //   300: invokestatic 99	com/tencent/smtt/utils/PostEncryption:getInstance	()Lcom/tencent/smtt/utils/PostEncryption;
    //   303: aload_1
    //   304: invokevirtual 103	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   307: invokevirtual 107	com/tencent/smtt/utils/PostEncryption:DESDecrypt	([B)[B
    //   310: ldc 11
    //   312: invokespecial 110	java/lang/String:<init>	([BLjava/lang/String;)V
    //   315: astore 4
    //   317: aload_0
    //   318: astore 5
    //   320: aload 5
    //   322: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   325: aload_1
    //   326: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   329: aload 4
    //   331: areturn
    //   332: new 54	java/lang/String
    //   335: dup
    //   336: invokestatic 115	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   339: aload_1
    //   340: invokevirtual 103	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   343: invokevirtual 118	com/tencent/smtt/utils/Post3DESEncryption:DesDecrypt	([B)[B
    //   346: invokespecial 121	java/lang/String:<init>	([B)V
    //   349: astore 4
    //   351: aload_0
    //   352: astore 5
    //   354: goto -34 -> 320
    //   357: astore_1
    //   358: aload 4
    //   360: astore_0
    //   361: aload_0
    //   362: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   365: aload 5
    //   367: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   370: aload_1
    //   371: athrow
    //   372: astore 4
    //   374: aload_1
    //   375: astore 5
    //   377: aload 4
    //   379: astore_1
    //   380: goto -19 -> 361
    //   383: astore 7
    //   385: aload 6
    //   387: astore_0
    //   388: aload 8
    //   390: astore_1
    //   391: goto -182 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	paramHttpURLConnection	HttpURLConnection
    //   0	394	1	paramHttpResponseListener	HttpResponseListener
    //   0	394	2	paramBoolean	boolean
    //   37	164	3	i	int
    //   23	336	4	localObject1	Object
    //   372	6	4	localObject2	Object
    //   27	349	5	localObject3	Object
    //   31	355	6	localObject4	Object
    //   16	147	7	localObject5	Object
    //   207	53	7	localThrowable1	java.lang.Throwable
    //   383	1	7	localThrowable2	java.lang.Throwable
    //   19	370	8	localObject6	Object
    //   4	252	9	localObject7	Object
    //   7	257	10	localObject8	Object
    //   1	68	11	localObject9	Object
    //   13	53	12	localObject10	Object
    //   10	52	13	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   177	184	207	java/lang/Throwable
    //   184	191	207	java/lang/Throwable
    //   196	204	207	java/lang/Throwable
    //   296	317	207	java/lang/Throwable
    //   332	351	207	java/lang/Throwable
    //   33	38	357	finally
    //   54	61	357	finally
    //   91	96	357	finally
    //   108	113	357	finally
    //   129	138	357	finally
    //   150	159	357	finally
    //   169	177	357	finally
    //   215	220	357	finally
    //   246	255	357	finally
    //   267	284	357	finally
    //   177	184	372	finally
    //   184	191	372	finally
    //   196	204	372	finally
    //   296	317	372	finally
    //   332	351	372	finally
    //   33	38	383	java/lang/Throwable
    //   54	61	383	java/lang/Throwable
    //   91	96	383	java/lang/Throwable
    //   108	113	383	java/lang/Throwable
    //   129	138	383	java/lang/Throwable
    //   150	159	383	java/lang/Throwable
    //   169	177	383	java/lang/Throwable
    //   246	255	383	java/lang/Throwable
    //   267	284	383	java/lang/Throwable
  }
  
  private static HttpURLConnection initHttpPostURLConnection(String paramString, Map<String, String> paramMap)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        paramString = (HttpURLConnection)new URL(paramString).openConnection();
        localObject = paramString;
        paramString.setRequestMethod("POST");
        paramString.setDoOutput(true);
        paramString.setDoInput(true);
        paramString.setUseCaches(false);
        paramString.setConnectTimeout(20000);
        if (Build.VERSION.SDK_INT > 13)
        {
          paramString.setRequestProperty("Connection", "close");
          paramMap = paramMap.entrySet().iterator();
          if (!paramMap.hasNext()) {
            break;
          }
          localObject = (Map.Entry)paramMap.next();
          paramString.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
          continue;
        }
        paramString.setRequestProperty("http.keepAlive", "false");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return localObject;
      }
    }
    return paramString;
  }
  
  public static String postData(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, HttpResponseListener paramHttpResponseListener, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    paramMap = initHttpPostURLConnection(paramString, paramMap);
    paramString = localObject;
    if (paramMap != null)
    {
      if (!paramBoolean) {
        break label41;
      }
      writeZipPostData(paramMap, paramArrayOfByte);
    }
    for (;;)
    {
      paramString = httpPost(paramMap, paramHttpResponseListener, false);
      return paramString;
      label41:
      writePostData(paramMap, paramArrayOfByte);
    }
  }
  
  public static String postData(String paramString, byte[] paramArrayOfByte, HttpResponseListener paramHttpResponseListener, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramBoolean) {}
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = PostEncryption.getInstance().initRSAKey();
        localObject1 = paramString + (String)localObject1;
        if (!paramBoolean) {}
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      try
      {
        paramString = PostEncryption.getInstance().DESEncrypt(paramArrayOfByte);
        paramArrayOfByte = paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        continue;
        paramString = new HashMap();
        paramString.put("Content-Type", "application/x-www-form-urlencoded");
        paramString.put("Content-Length", String.valueOf(paramArrayOfByte.length));
        localObject1 = initHttpPostURLConnection((String)localObject1, paramString);
        paramString = localObject2;
        if (localObject1 == null) {
          return paramString;
        }
        writePostData((HttpURLConnection)localObject1, paramArrayOfByte);
        paramString = httpPost((HttpURLConnection)localObject1, paramHttpResponseListener, paramBoolean);
      }
      if (paramArrayOfByte != null) {
        break;
      }
      return null;
      localObject1 = Post3DESEncryption.getInstance().getRSAKeyValue();
      continue;
      paramString = Post3DESEncryption.getInstance().DESEncrypt(paramArrayOfByte);
      paramArrayOfByte = paramString;
    }
    return paramString;
  }
  
  private static void writePostData(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
      paramHttpURLConnection.write(paramArrayOfByte);
      paramHttpURLConnection.flush();
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      paramHttpURLConnection.printStackTrace();
    }
  }
  
  /* Error */
  private static void writeZipPostData(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 263	java/util/zip/GZIPOutputStream
    //   7: dup
    //   8: new 265	java/io/BufferedOutputStream
    //   11: dup
    //   12: aload_0
    //   13: invokevirtual 254	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   16: ldc_w 266
    //   19: invokespecial 269	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   22: invokespecial 272	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_0
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 258	java/io/OutputStream:write	([B)V
    //   31: aload_0
    //   32: invokevirtual 261	java/io/OutputStream:flush	()V
    //   35: aconst_null
    //   36: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   39: aload_0
    //   40: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   43: return
    //   44: astore_1
    //   45: aload_3
    //   46: astore_0
    //   47: aload_0
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual 192	java/lang/Exception:printStackTrace	()V
    //   53: aconst_null
    //   54: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   57: aload_0
    //   58: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   61: return
    //   62: astore_0
    //   63: aconst_null
    //   64: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   67: aload_2
    //   68: invokestatic 81	com/tencent/smtt/utils/HttpUtil:closeStream	(Ljava/io/Closeable;)V
    //   71: aload_0
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: astore_2
    //   76: aload_1
    //   77: astore_0
    //   78: goto -15 -> 63
    //   81: astore_1
    //   82: goto -35 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramHttpURLConnection	HttpURLConnection
    //   0	85	1	paramArrayOfByte	byte[]
    //   1	75	2	localHttpURLConnection	HttpURLConnection
    //   3	43	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	44	java/lang/Exception
    //   4	26	62	finally
    //   49	53	62	finally
    //   26	35	73	finally
    //   26	35	81	java/lang/Exception
  }
  
  public static abstract interface HttpResponseListener
  {
    public abstract void onHttpResponseCode(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.HttpUtil
 * JD-Core Version:    0.7.0.1
 */