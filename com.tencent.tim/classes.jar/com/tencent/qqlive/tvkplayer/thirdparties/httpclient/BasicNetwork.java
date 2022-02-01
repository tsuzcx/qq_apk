package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

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
  
  public void performRequest(Request paramRequest, IWriteFuncListener paramIWriteFuncListener)
    throws IOException
  {
    HttpDataSource localHttpDataSource = this.mHttpDataSrcFactory.createDataSource(paramRequest.getTimeoutMs());
    Object localObject2;
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
    int n = 0;
    for (;;)
    {
      localObject2 = new DataSourceInputStream(localHttpDataSource, new DataSpec(Uri.parse((String)localObject1), paramRequest.getHttpMethod(), paramRequest.getPostBody(), 0L, 0L, -1L, null, 1));
      int i = 0;
      int j = 0;
      int k = 0;
      try
      {
        localObject1 = new byte[4096];
        for (;;)
        {
          i = k;
          j = k;
          int i1 = ((DataSourceInputStream)localObject2).read((byte[])localObject1);
          if (i1 == -1) {
            break;
          }
          m = k;
          if (k == 0)
          {
            if (paramIWriteFuncListener == null) {
              break label407;
            }
            i = k;
            j = k;
            paramIWriteFuncListener.onWriteHeaders(localHttpDataSource.getResponseHeaders());
            break label407;
          }
          k = m;
          if (paramIWriteFuncListener != null)
          {
            i = m;
            j = m;
            paramIWriteFuncListener.onWriteBody((byte[])localObject1, i1);
            k = m;
          }
        }
      }
      catch (HttpDataSource.InvalidResponseCodeException localInvalidResponseCodeException)
      {
        label273:
        label285:
        try
        {
          if (localInvalidResponseCodeException.responseCode == 307) {
            break label413;
          }
          j = n;
          if (localInvalidResponseCodeException.responseCode != 308) {
            break label344;
          }
          break label413;
        }
        finally {}
        if (k != 0)
        {
          localObject1 = getRedirectUrl(localInvalidResponseCodeException);
          if (localObject1 != null) {
            break label356;
          }
          throw localInvalidResponseCodeException;
          if ((paramIWriteFuncListener == null) || (i == 0)) {}
        }
        try
        {
          paramIWriteFuncListener.onWriteBodyEnd();
          Util.closeQuietly((Closeable)localObject2);
          throw paramRequest;
          if ((paramIWriteFuncListener != null) && (k != 0)) {}
          try
          {
            paramIWriteFuncListener.onWriteBodyEnd();
            Util.closeQuietly((Closeable)localObject2);
            return;
          }
          catch (Exception paramRequest)
          {
            for (;;)
            {
              paramRequest.printStackTrace();
            }
          }
          label344:
          k = 0;
          break label273;
          localObject1 = null;
          break label285;
          label356:
          if ((paramIWriteFuncListener != null) && (i != 0)) {}
          try
          {
            paramIWriteFuncListener.onWriteBodyEnd();
            Util.closeQuietly((Closeable)localObject2);
            n = j;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
        catch (Exception paramIWriteFuncListener)
        {
          for (;;)
          {
            paramIWriteFuncListener.printStackTrace();
          }
        }
      }
      finally
      {
        for (;;)
        {
          i = j;
          continue;
          label407:
          int m = 1;
          continue;
          label413:
          j = n + 1;
          if (n < 5) {
            k = 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.BasicNetwork
 * JD-Core Version:    0.7.0.1
 */