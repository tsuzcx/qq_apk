package retrofit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

final class Utils
{
  private static final int BUFFER_SIZE = 4096;
  
  static Request readBodyToBytesIfNecessary(Request paramRequest)
    throws IOException
  {
    Object localObject = paramRequest.getBody();
    if ((localObject == null) || ((localObject instanceof TypedByteArray))) {
      return paramRequest;
    }
    String str = ((TypedOutput)localObject).mimeType();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ((TypedOutput)localObject).writeTo(localByteArrayOutputStream);
    localObject = new TypedByteArray(str, localByteArrayOutputStream.toByteArray());
    return new Request(paramRequest.getMethod(), paramRequest.getUrl(), paramRequest.getHeaders(), (TypedOutput)localObject);
  }
  
  static Response readBodyToBytesIfNecessary(Response paramResponse)
    throws IOException
  {
    localObject2 = paramResponse.getBody();
    Object localObject1 = paramResponse;
    if (localObject2 != null)
    {
      if (!(localObject2 instanceof TypedByteArray)) {
        break label22;
      }
      localObject1 = paramResponse;
    }
    for (;;)
    {
      return localObject1;
      label22:
      localObject1 = ((TypedInput)localObject2).mimeType();
      localObject2 = ((TypedInput)localObject2).in();
      try
      {
        paramResponse = replaceResponseBody(paramResponse, new TypedByteArray((String)localObject1, streamToBytes((InputStream)localObject2)));
        localObject1 = paramResponse;
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject2).close();
          return paramResponse;
        }
        catch (IOException localIOException1)
        {
          return paramResponse;
        }
        try
        {
          ((InputStream)localObject2).close();
          throw paramResponse;
        }
        catch (IOException localIOException2)
        {
          break label77;
        }
      }
      finally
      {
        if (localObject2 == null) {}
      }
    }
  }
  
  static Response replaceResponseBody(Response paramResponse, TypedInput paramTypedInput)
  {
    return new Response(paramResponse.getUrl(), paramResponse.getStatus(), paramResponse.getReason(), paramResponse.getHeaders(), paramTypedInput);
  }
  
  static byte[] streamToBytes(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (paramInputStream != null)
    {
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  static <T> void validateServiceClass(Class<T> paramClass)
  {
    if (!paramClass.isInterface()) {
      throw new IllegalArgumentException("Only interface endpoint definitions are supported.");
    }
    if (paramClass.getInterfaces().length > 0) {
      throw new IllegalArgumentException("Interface definitions must not extend other interfaces.");
    }
  }
  
  static class SynchronousExecutor
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      paramRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.Utils
 * JD-Core Version:    0.7.0.1
 */