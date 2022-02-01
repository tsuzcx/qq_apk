package com.tencent.moai.downloader.interceptor;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.tencent.moai.downloader.util.StringUtil;
import java.io.IOException;
import okio.Buffer;

public class HttpUserAgentInterceptor
  implements Interceptor
{
  public static String toHumanReadableAscii(String paramString)
  {
    int m = paramString.length();
    int i = 0;
    for (;;)
    {
      Object localObject = paramString;
      int j;
      if (i < m)
      {
        j = paramString.codePointAt(i);
        if ((j <= 31) || (j >= 127))
        {
          localObject = new Buffer();
          ((Buffer)localObject).writeUtf8(paramString, 0, i);
          if (i < m)
          {
            int k = paramString.codePointAt(i);
            if ((k > 31) && (k < 127)) {}
            for (j = k;; j = 63)
            {
              ((Buffer)localObject).writeUtf8CodePoint(j);
              i = Character.charCount(k) + i;
              break;
            }
          }
          localObject = ((Buffer)localObject).readUtf8();
        }
      }
      else
      {
        return localObject;
      }
      i += Character.charCount(j);
    }
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest2 = paramChain.request();
    String str = toHumanReadableAscii(System.getProperty("http.agent"));
    Request localRequest1 = localRequest2;
    if (!StringUtil.isNullOrEmpty(str)) {
      localRequest1 = localRequest2.newBuilder().removeHeader("User-Agent").addHeader("User-Agent", str).build();
    }
    return paramChain.proceed(localRequest1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.interceptor.HttpUserAgentInterceptor
 * JD-Core Version:    0.7.0.1
 */