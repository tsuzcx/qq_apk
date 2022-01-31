package com.tencent.component.network.downloader.strategy;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.protocol.HttpContext;

public class DownloadConnectionReuseStrategy
  extends DefaultConnectionReuseStrategy
{
  public boolean keepAlive(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    Object localObject;
    if (paramHttpContext != null)
    {
      localObject = (HttpRequest)paramHttpContext.getAttribute("http.request");
      if (localObject != null)
      {
        localObject = ((HttpRequest)localObject).headerIterator("Connection");
        if (!((HeaderIterator)localObject).hasNext()) {}
      }
    }
    label63:
    label70:
    do
    {
      try
      {
        localObject = createTokenIterator((HeaderIterator)localObject);
        bool = ((TokenIterator)localObject).hasNext();
        if (bool) {
          break label70;
        }
      }
      catch (ParseException localParseException)
      {
        boolean bool;
        break label63;
      }
      return super.keepAlive(paramHttpResponse, paramHttpContext);
      bool = "Close".equalsIgnoreCase(((TokenIterator)localObject).nextToken());
    } while (!bool);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadConnectionReuseStrategy
 * JD-Core Version:    0.7.0.1
 */