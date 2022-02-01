package cooperation.qqreader.net;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class OkHttpHelper
{
  private static OkHttpClient a;
  
  private static InputStream a(InputStream paramInputStream)
  {
    paramInputStream = new PushbackInputStream(paramInputStream, 2);
    try
    {
      Object localObject = new byte[2];
      int i = paramInputStream.read((byte[])localObject);
      if (i > 0) {
        paramInputStream.unread((byte[])localObject, 0, i);
      }
      if ((localObject[0] == 31) && (localObject[1] == -117))
      {
        localObject = new GZIPInputStream(paramInputStream);
        return localObject;
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OkHttpHelper", 2, "judge stream format error", localIOException);
      }
    }
    return paramInputStream;
  }
  
  /* Error */
  public static String a(String paramString, HttpMethodType paramHttpMethodType, HashMap<String, String> paramHashMap, MediaType paramMediaType, byte[] paramArrayOfByte)
    throws IOException, HttpResponseException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: aload 4
    //   6: invokestatic 55	cooperation/qqreader/net/OkHttpHelper:a	(Ljava/lang/String;Lcooperation/qqreader/net/OkHttpHelper$HttpMethodType;Ljava/util/HashMap;Lokhttp3/MediaType;[B)Lokhttp3/Request;
    //   9: invokestatic 58	cooperation/qqreader/net/OkHttpHelper:a	(Lokhttp3/Request;)Lokhttp3/Response;
    //   12: astore_1
    //   13: aconst_null
    //   14: astore_0
    //   15: aload_1
    //   16: invokevirtual 64	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   19: invokevirtual 70	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   22: astore_1
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: invokestatic 72	cooperation/qqreader/net/OkHttpHelper:a	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: invokestatic 75	cooperation/qqreader/net/OkHttpHelper:d	(Ljava/io/InputStream;)Ljava/lang/String;
    //   36: astore_2
    //   37: aload_1
    //   38: ifnull +7 -> 45
    //   41: aload_1
    //   42: invokevirtual 80	java/io/InputStream:close	()V
    //   45: aload_2
    //   46: areturn
    //   47: astore_1
    //   48: aload_0
    //   49: ifnull +7 -> 56
    //   52: aload_0
    //   53: invokevirtual 80	java/io/InputStream:close	()V
    //   56: aload_1
    //   57: athrow
    //   58: astore_0
    //   59: aload_2
    //   60: areturn
    //   61: astore_0
    //   62: goto -6 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramString	String
    //   0	65	1	paramHttpMethodType	HttpMethodType
    //   0	65	2	paramHashMap	HashMap<String, String>
    //   0	65	3	paramMediaType	MediaType
    //   0	65	4	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	23	47	finally
    //   25	30	47	finally
    //   32	37	47	finally
    //   41	45	58	java/io/IOException
    //   52	56	61	java/io/IOException
  }
  
  public static OkHttpClient a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new OkHttpClient().newBuilder().protocols(Arrays.asList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 })).build();
      }
      return a;
    }
    finally {}
  }
  
  public static Request a(String paramString, HttpMethodType paramHttpMethodType, HashMap<String, String> paramHashMap, MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    Request.Builder localBuilder = new Request.Builder();
    localBuilder.url(paramString);
    if (paramHashMap != null)
    {
      paramString = paramHashMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (Map.Entry)paramString.next();
        if ((paramHashMap.getKey() != null) && (paramHashMap.getValue() != null)) {
          localBuilder.addHeader((String)paramHashMap.getKey(), (String)paramHashMap.getValue());
        }
      }
    }
    if (paramHttpMethodType == HttpMethodType.GET) {
      localBuilder.get();
    }
    for (;;)
    {
      return localBuilder.build();
      paramString = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramString = new byte[0];
      }
      localBuilder.post(RequestBody.create(paramMediaType, paramString));
    }
  }
  
  private static Response a(Request paramRequest)
    throws IOException, HttpResponseException
  {
    paramRequest = a().newCall(paramRequest).execute();
    if (!paramRequest.isSuccessful()) {
      throw new HttpResponseException(paramRequest.code());
    }
    return paramRequest;
  }
  
  public static String d(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  public static enum HttpMethodType
  {
    GET,  POST;
    
    private HttpMethodType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.net.OkHttpHelper
 * JD-Core Version:    0.7.0.1
 */