package okhttp3.internal.huc;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

class OkHttpURLConnection$UnexpectedException$1
  implements Interceptor
{
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    try
    {
      paramChain = paramChain.proceed(paramChain.request());
      return paramChain;
    }
    catch (RuntimeException paramChain)
    {
      throw new OkHttpURLConnection.UnexpectedException(paramChain);
    }
    catch (Error paramChain)
    {
      label16:
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.huc.OkHttpURLConnection.UnexpectedException.1
 * JD-Core Version:    0.7.0.1
 */