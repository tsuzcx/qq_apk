package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionState;
import java.net.URL;

public class QAPMRequestBuilderExtension
  extends Request.Builder
{
  private Request.Builder impl;
  private QAPMTransactionState transactionState;
  
  public QAPMRequestBuilderExtension(Request.Builder paramBuilder)
  {
    this.impl = paramBuilder;
  }
  
  public Request.Builder addHeader(String paramString1, String paramString2)
  {
    return this.impl.addHeader(paramString1, paramString2);
  }
  
  public Request build()
  {
    return this.impl.build();
  }
  
  public Request.Builder cacheControl(CacheControl paramCacheControl)
  {
    return this.impl.cacheControl(paramCacheControl);
  }
  
  public Request.Builder delete()
  {
    return this.impl.delete();
  }
  
  public Request.Builder get()
  {
    return this.impl.get();
  }
  
  public Request.Builder head()
  {
    return this.impl.head();
  }
  
  public Request.Builder header(String paramString1, String paramString2)
  {
    return this.impl.header(paramString1, paramString2);
  }
  
  public Request.Builder headers(Headers paramHeaders)
  {
    return this.impl.headers(paramHeaders);
  }
  
  public Request.Builder method(String paramString, RequestBody paramRequestBody)
  {
    return this.impl.method(paramString, paramRequestBody);
  }
  
  public Request.Builder patch(RequestBody paramRequestBody)
  {
    return this.impl.patch(paramRequestBody);
  }
  
  public Request.Builder post(RequestBody paramRequestBody)
  {
    return this.impl.post(paramRequestBody);
  }
  
  public Request.Builder put(RequestBody paramRequestBody)
  {
    return this.impl.put(paramRequestBody);
  }
  
  public Request.Builder removeHeader(String paramString)
  {
    return this.impl.removeHeader(paramString);
  }
  
  public Request.Builder tag(Object paramObject)
  {
    return this.impl.tag(paramObject);
  }
  
  public Request.Builder url(String paramString)
  {
    return this.impl.url(paramString);
  }
  
  public Request.Builder url(URL paramURL)
  {
    return this.impl.url(paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.QAPMRequestBuilderExtension
 * JD-Core Version:    0.7.0.1
 */