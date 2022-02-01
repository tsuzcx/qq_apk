package moai.rx;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import javax.net.ssl.SSLException;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.RetryError;
import retrofit.client.Response;

public abstract class RxNetworkErrorHandler
  implements ErrorHandler
{
  /* Error */
  private static JSONObject convertJson(RetrofitError paramRetrofitError)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 21	retrofit/RetrofitError:getResponse	()Lretrofit/client/Response;
    //   4: invokevirtual 27	retrofit/client/Response:getBody	()Lretrofit/mime/TypedInput;
    //   7: invokeinterface 33 1 0
    //   12: astore_0
    //   13: aload_0
    //   14: invokestatic 39	moai/io/Caches:toString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   17: invokestatic 45	com/alibaba/fastjson/JSON:parseObject	(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;
    //   20: astore_1
    //   21: aload_0
    //   22: invokestatic 51	com/google/common/io/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   25: aload_1
    //   26: areturn
    //   27: astore_0
    //   28: aconst_null
    //   29: astore_0
    //   30: aload_0
    //   31: invokestatic 51	com/google/common/io/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   34: aconst_null
    //   35: areturn
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_2
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: invokestatic 51	com/google/common/io/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: astore_2
    //   50: goto -9 -> 41
    //   53: astore_1
    //   54: goto -24 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramRetrofitError	RetrofitError
    //   20	26	1	localObject1	Object
    //   47	1	1	localObject2	Object
    //   53	1	1	localIOException	java.io.IOException
    //   38	12	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	13	27	java/io/IOException
    //   0	13	36	finally
    //   13	21	47	finally
    //   13	21	53	java/io/IOException
  }
  
  private RetryError throwRetryError(RetrofitError paramRetrofitError)
  {
    return new RetryError(paramRetrofitError);
  }
  
  public Throwable handleError(RetrofitError paramRetrofitError)
  {
    try
    {
      Object localObject;
      if (paramRetrofitError.getResponse() != null)
      {
        localObject = convertJson(paramRetrofitError);
        logResponseError(paramRetrofitError, paramRetrofitError.getResponse(), (JSONObject)localObject);
        if (localObject == null) {
          return paramRetrofitError;
        }
        if (whetherNeedToRetry(paramRetrofitError, (JSONObject)localObject)) {
          return throwRetryError(paramRetrofitError);
        }
        return throwError(paramRetrofitError, (JSONObject)localObject);
      }
      logResponseError(paramRetrofitError, null, null);
      if ((paramRetrofitError.getCause() instanceof SSLException))
      {
        localObject = throwRetryError(paramRetrofitError);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramRetrofitError;
  }
  
  protected void logResponseError(@NonNull RetrofitError paramRetrofitError, Response paramResponse, @Nullable JSONObject paramJSONObject) {}
  
  public abstract Throwable throwError(RetrofitError paramRetrofitError, JSONObject paramJSONObject);
  
  public abstract boolean whetherNeedToRetry(RetrofitError paramRetrofitError, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.RxNetworkErrorHandler
 * JD-Core Version:    0.7.0.1
 */