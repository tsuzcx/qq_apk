package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BasicNetwork
  implements Network
{
  private static final int MAX_MANUAL_REDIRECTS = 5;
  private final HttpDataSource.Factory mHttpDataSrcFactory;
  
  public BasicNetwork(HttpDataSource.Factory paramFactory)
  {
    this.mHttpDataSrcFactory = paramFactory;
  }
  
  private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException paramInvalidResponseCodeException)
  {
    paramInvalidResponseCodeException = paramInvalidResponseCodeException.headerFields;
    if (paramInvalidResponseCodeException != null)
    {
      paramInvalidResponseCodeException = (List)paramInvalidResponseCodeException.get("Location");
      if ((paramInvalidResponseCodeException != null) && (!paramInvalidResponseCodeException.isEmpty())) {
        return (String)paramInvalidResponseCodeException.get(0);
      }
    }
    return null;
  }
  
  public Response performRequest(Request paramRequest)
    throws IOException
  {
    HttpDataSource localHttpDataSource = this.mHttpDataSrcFactory.createDataSource(paramRequest.getTimeoutMs());
    if (paramRequest.getHeaders() != null)
    {
      localObject1 = paramRequest.getHeaders().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localHttpDataSource.setRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
    }
    Object localObject1 = paramRequest.getUrl();
    int i = 0;
    Object localObject2 = new DataSourceInputStream(localHttpDataSource, new DataSpec(Uri.parse((String)localObject1), paramRequest.getHttpMethod(), paramRequest.getPostBody(), 0L, 0L, -1L, null, 1));
    for (;;)
    {
      try
      {
        localObject1 = Response.success(Util.toByteArray((InputStream)localObject2), localHttpDataSource.getResponseHeaders());
        return localObject1;
      }
      catch (HttpDataSource.InvalidResponseCodeException localInvalidResponseCodeException)
      {
        if (localInvalidResponseCodeException.responseCode != 307)
        {
          j = i;
          if (localInvalidResponseCodeException.responseCode == 308)
          {
            break label242;
            label190:
            if (j == 0) {
              break label228;
            }
            localObject1 = getRedirectUrl(localInvalidResponseCodeException);
            label201:
            if (localObject1 != null) {
              break label234;
            }
            throw localInvalidResponseCodeException;
          }
        }
      }
      finally
      {
        Util.closeQuietly((Closeable)localObject2);
      }
      label228:
      label234:
      label242:
      do
      {
        int k = 0;
        i = j;
        j = k;
        break label190;
        localObject1 = null;
        break label201;
        Util.closeQuietly((Closeable)localObject2);
        break;
        j = i + 1;
      } while (i >= 5);
      i = j;
      int j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.BasicNetwork
 * JD-Core Version:    0.7.0.1
 */