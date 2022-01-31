package com.qzone.utils.http.base;

import android.text.TextUtils;
import com.qzone.common.logging.QDLog;
import java.io.IOException;
import java.net.URI;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.DefaultRequestDirector;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.client.RoutedRequest;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public class QZoneRequestDirector
  extends DefaultRequestDirector
{
  private boolean mDirected = false;
  private String mHost = null;
  
  public QZoneRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectHandler paramRedirectHandler, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams)
  {
    super(paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectHandler, paramAuthenticationHandler1, paramAuthenticationHandler2, paramUserTokenHandler, paramHttpParams);
  }
  
  protected RoutedRequest handleResponse(RoutedRequest paramRoutedRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws HttpException, IOException
  {
    paramRoutedRequest = super.handleResponse(paramRoutedRequest, paramHttpResponse, paramHttpContext);
    if ((paramRoutedRequest != null) && (HttpClientParams.isRedirecting(this.params))) {
      try
      {
        this.mDirected = true;
        paramHttpResponse = paramRoutedRequest.getRequest();
        if (paramHttpResponse != null)
        {
          if (paramHttpResponse.getURI() == null) {
            return paramRoutedRequest;
          }
          paramHttpContext = paramHttpResponse.getURI().getAuthority();
          this.mHost = paramHttpContext;
          Header[] arrayOfHeader = paramHttpResponse.getAllHeaders();
          if (arrayOfHeader != null)
          {
            int j = arrayOfHeader.length;
            int i = 0;
            while (i < j)
            {
              if ("Host".equals(arrayOfHeader[i].getName()))
              {
                paramHttpResponse.removeHeader(arrayOfHeader[i]);
                if (!TextUtils.isEmpty(paramHttpContext)) {
                  paramHttpResponse.addHeader("Host", paramHttpContext);
                }
                QDLog.i("http", "download redirect orig host:" + arrayOfHeader[i].getValue() + " new host:" + paramHttpContext);
              }
              if ("x-online-host".equals(arrayOfHeader[i].getName()))
              {
                paramHttpResponse.removeHeader(arrayOfHeader[i]);
                if (!TextUtils.isEmpty(paramHttpContext)) {
                  paramHttpResponse.addHeader("x-online-host", paramHttpContext);
                }
                QDLog.i("http", "download redirect orig x-online-host:" + arrayOfHeader[i].getValue() + " new x-online-host:" + paramHttpContext);
              }
              i += 1;
            }
          }
        }
        return paramRoutedRequest;
      }
      catch (Throwable paramHttpResponse)
      {
        QDLog.i("http", "handleResponse error", paramHttpResponse);
      }
    }
  }
  
  protected void rewriteRequestURI(RequestWrapper paramRequestWrapper, HttpRoute paramHttpRoute)
    throws ProtocolException
  {
    super.rewriteRequestURI(paramRequestWrapper, paramHttpRoute);
    if ((!this.mDirected) || (paramRequestWrapper == null)) {}
    do
    {
      return;
      paramRequestWrapper.removeHeaders("Host");
      paramRequestWrapper.removeHeaders("x-online-host");
    } while (TextUtils.isEmpty(this.mHost));
    paramRequestWrapper.addHeader("Host", this.mHost);
    paramRequestWrapper.addHeader("x-online-host", this.mHost);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.base.QZoneRequestDirector
 * JD-Core Version:    0.7.0.1
 */