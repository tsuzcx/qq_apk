package com.tencent.beacon.base.net.adapter;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.e;
import com.tencent.beacon.base.util.c;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
  extends AbstractNetAdapter
{
  private BResponse a(String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
    throws IOException
  {
    paramString1 = a(paramString1, paramString2, paramMap);
    paramString1.connect();
    paramString2 = paramString1.getOutputStream();
    if ((paramString2 != null) && (paramArrayOfByte != null))
    {
      paramString2.write(paramArrayOfByte);
      paramString2.close();
    }
    int i = paramString1.getResponseCode();
    paramString2 = paramString1.getResponseMessage();
    paramMap = a(paramString1.getInputStream());
    return new BResponse(paramString1.getHeaderFields(), i, paramString2, paramMap);
  }
  
  private HttpURLConnection a(String paramString1, String paramString2, Map<String, String> paramMap)
    throws IOException
  {
    paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
    paramString1.setConnectTimeout(30000);
    paramString1.setReadTimeout(10000);
    paramString1.setRequestMethod(paramString2);
    paramString1.setDoOutput(true);
    paramString1.setDoInput(true);
    paramString1.setInstanceFollowRedirects(false);
    paramString2 = paramMap.entrySet().iterator();
    while (paramString2.hasNext())
    {
      paramMap = (Map.Entry)paramString2.next();
      paramString1.setRequestProperty((String)paramMap.getKey(), (String)paramMap.getValue());
    }
    return paramString1;
  }
  
  /* Error */
  private byte[] a(java.io.InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 129	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 130	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_3
    //   14: sipush 2048
    //   17: newarray byte
    //   19: astore 4
    //   21: aload_1
    //   22: aload 4
    //   24: invokevirtual 136	java/io/InputStream:read	([B)I
    //   27: istore_2
    //   28: iload_2
    //   29: iconst_m1
    //   30: if_icmpeq +39 -> 69
    //   33: aload_3
    //   34: aload 4
    //   36: iconst_0
    //   37: iload_2
    //   38: invokevirtual 139	java/io/ByteArrayOutputStream:write	([BII)V
    //   41: goto -20 -> 21
    //   44: astore 4
    //   46: aload 4
    //   48: invokestatic 144	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   51: iconst_2
    //   52: anewarray 146	java/io/Closeable
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: aload_3
    //   62: aastore
    //   63: invokestatic 151	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   66: aload 4
    //   68: athrow
    //   69: aload_3
    //   70: invokevirtual 154	java/io/ByteArrayOutputStream:flush	()V
    //   73: aload_3
    //   74: invokevirtual 158	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: astore 4
    //   79: aload_3
    //   80: invokevirtual 159	java/io/ByteArrayOutputStream:close	()V
    //   83: aload_1
    //   84: invokevirtual 160	java/io/InputStream:close	()V
    //   87: iconst_2
    //   88: anewarray 146	java/io/Closeable
    //   91: dup
    //   92: iconst_0
    //   93: aload_1
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_3
    //   98: aastore
    //   99: invokestatic 151	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   102: aload 4
    //   104: areturn
    //   105: astore 4
    //   107: iconst_2
    //   108: anewarray 146	java/io/Closeable
    //   111: dup
    //   112: iconst_0
    //   113: aload_1
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_3
    //   118: aastore
    //   119: invokestatic 151	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   122: aload 4
    //   124: athrow
    //   125: astore 4
    //   127: goto -20 -> 107
    //   130: astore 4
    //   132: aload 5
    //   134: astore_3
    //   135: goto -89 -> 46
    //   138: astore 4
    //   140: aload 6
    //   142: astore_3
    //   143: goto -36 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	b
    //   0	146	1	paramInputStream	java.io.InputStream
    //   27	11	2	i	int
    //   13	130	3	localObject1	Object
    //   19	16	4	arrayOfByte1	byte[]
    //   44	23	4	localIOException1	IOException
    //   77	26	4	arrayOfByte2	byte[]
    //   105	18	4	localObject2	Object
    //   125	1	4	localObject3	Object
    //   130	1	4	localIOException2	IOException
    //   138	1	4	localObject4	Object
    //   4	129	5	localObject5	Object
    //   1	140	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   14	21	44	java/io/IOException
    //   21	28	44	java/io/IOException
    //   33	41	44	java/io/IOException
    //   69	87	44	java/io/IOException
    //   14	21	105	finally
    //   21	28	105	finally
    //   33	41	105	finally
    //   69	87	105	finally
    //   46	51	125	finally
    //   6	14	130	java/io/IOException
    //   6	14	138	finally
  }
  
  private byte[] buildBody(e parame)
    throws UnsupportedEncodingException
  {
    int i = a.a[parame.a().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return parame.f().getBytes("UTF-8");
      }
      return com.tencent.beacon.base.net.b.d.b(parame.d()).getBytes("UTF-8");
    }
    return parame.c();
  }
  
  public void request(JceRequestEntity paramJceRequestEntity, Callback<byte[]> paramCallback)
  {
    String str = paramJceRequestEntity.getType().name();
    try
    {
      Object localObject = paramJceRequestEntity.getUrl();
      paramJceRequestEntity = a((String)localObject, "POST", paramJceRequestEntity.getHeader(), paramJceRequestEntity.getContent());
      int i;
      if (paramJceRequestEntity.code != 200)
      {
        i = paramJceRequestEntity.code;
        localObject = new StringBuilder();
        paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "452", i, "response status code != 2XX. msg: " + paramJceRequestEntity.msg));
        return;
      }
      if (!com.tencent.beacon.base.net.b.d.a(paramJceRequestEntity.headers))
      {
        i = paramJceRequestEntity.code;
        paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "454", i, "server encrypt-status error!"));
        return;
      }
    }
    catch (ConnectException paramJceRequestEntity)
    {
      c.a(paramJceRequestEntity);
      paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "451", -1, "https connect timeout: " + paramJceRequestEntity.getMessage(), paramJceRequestEntity));
      return;
      paramCallback.onResponse(paramJceRequestEntity.body);
      return;
    }
    catch (Throwable paramJceRequestEntity)
    {
      c.a(paramJceRequestEntity);
      paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "499", -1, "https connect error: " + paramJceRequestEntity.getMessage(), paramJceRequestEntity));
    }
  }
  
  public void request(e parame, Callback<BResponse> paramCallback)
  {
    String str = parame.h();
    try
    {
      Object localObject = buildBody(parame);
      parame = a(parame.i(), parame.g().name(), parame.e(), (byte[])localObject);
      if (parame.code != 200)
      {
        int i = parame.code;
        localObject = new StringBuilder();
        paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "452", i, "response status code != 2XX. msg: " + parame.msg));
        return;
      }
      paramCallback.onResponse(parame);
      return;
    }
    catch (ConnectException parame)
    {
      c.a(parame);
      paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "451", -1, "https connect timeout: " + parame.getMessage(), parame));
      return;
    }
    catch (Throwable parame)
    {
      c.a(parame);
      paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "499", -1, "https connect error: " + parame.getMessage(), parame));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.adapter.b
 * JD-Core Version:    0.7.0.1
 */