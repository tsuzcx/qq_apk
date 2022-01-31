package com.tencent.component.network.utils.a.a;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public final class a
  extends DefaultHttpClient
{
  public a(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    super(paramClientConnectionManager, paramHttpParams);
  }
  
  protected final AuthSchemeRegistry createAuthSchemeRegistry()
  {
    return super.createAuthSchemeRegistry();
  }
  
  protected final ClientConnectionManager createClientConnectionManager()
  {
    return super.createClientConnectionManager();
  }
  
  protected final RequestDirector createClientRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectHandler paramRedirectHandler, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams)
  {
    return new b(paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectHandler, paramAuthenticationHandler1, paramAuthenticationHandler2, paramUserTokenHandler, paramHttpParams);
  }
  
  protected final ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy()
  {
    return super.createConnectionKeepAliveStrategy();
  }
  
  protected final ConnectionReuseStrategy createConnectionReuseStrategy()
  {
    return super.createConnectionReuseStrategy();
  }
  
  protected final CookieSpecRegistry createCookieSpecRegistry()
  {
    return super.createCookieSpecRegistry();
  }
  
  protected final CookieStore createCookieStore()
  {
    return super.createCookieStore();
  }
  
  protected final CredentialsProvider createCredentialsProvider()
  {
    return super.createCredentialsProvider();
  }
  
  protected final HttpContext createHttpContext()
  {
    return super.createHttpContext();
  }
  
  protected final HttpParams createHttpParams()
  {
    return super.createHttpParams();
  }
  
  protected final BasicHttpProcessor createHttpProcessor()
  {
    return super.createHttpProcessor();
  }
  
  protected final HttpRequestRetryHandler createHttpRequestRetryHandler()
  {
    return super.createHttpRequestRetryHandler();
  }
  
  protected final HttpRoutePlanner createHttpRoutePlanner()
  {
    return super.createHttpRoutePlanner();
  }
  
  protected final AuthenticationHandler createProxyAuthenticationHandler()
  {
    return super.createProxyAuthenticationHandler();
  }
  
  protected final RedirectHandler createRedirectHandler()
  {
    return super.createRedirectHandler();
  }
  
  protected final HttpRequestExecutor createRequestExecutor()
  {
    return super.createRequestExecutor();
  }
  
  protected final AuthenticationHandler createTargetAuthenticationHandler()
  {
    return super.createTargetAuthenticationHandler();
  }
  
  protected final UserTokenHandler createUserTokenHandler()
  {
    return super.createUserTokenHandler();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.a.a
 * JD-Core Version:    0.7.0.1
 */