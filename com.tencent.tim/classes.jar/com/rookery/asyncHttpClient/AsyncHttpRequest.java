package com.rookery.asyncHttpClient;

import com.tencent.qphone.base.util.QLog;
import ier;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest
  implements Runnable
{
  private boolean Or;
  private final ier jdField_a_of_type_Ier;
  private final HttpUriRequest jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest;
  private final AbstractHttpClient jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient;
  private int agc;
  private final HttpContext context;
  
  public AsyncHttpRequest(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, ier paramier)
  {
    this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient = paramAbstractHttpClient;
    this.context = paramHttpContext;
    this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest = paramHttpUriRequest;
    this.jdField_a_of_type_Ier = paramier;
  }
  
  private void ahy()
    throws IOException
  {
    if (!Thread.currentThread().isInterrupted()) {}
    try
    {
      HttpResponse localHttpResponse = this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient.execute(this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpUriRequest, this.context);
      if ((!Thread.currentThread().isInterrupted()) && (this.jdField_a_of_type_Ier != null)) {
        this.jdField_a_of_type_Ier.a(localHttpResponse);
      }
      return;
    }
    catch (IOException localIOException)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[makeRequest]IOException:" + localIOException);
        }
      } while (Thread.currentThread().isInterrupted());
      throw localIOException;
    }
  }
  
  private void ahz()
    throws ConnectException
  {
    boolean bool = true;
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_OrgApacheHttpImplClientAbstractHttpClient.getHttpRequestRetryHandler();
    IOException localIOException2;
    while (bool) {
      try
      {
        ahy();
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        while (this.jdField_a_of_type_Ier == null) {}
        this.jdField_a_of_type_Ier.f(localUnknownHostException, "can't resolve host");
        return;
      }
      catch (SocketException localSocketException)
      {
        while (this.jdField_a_of_type_Ier == null) {}
        this.jdField_a_of_type_Ier.f(localSocketException, "can't resolve host");
        return;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        while (this.jdField_a_of_type_Ier == null) {}
        this.jdField_a_of_type_Ier.f(localSocketTimeoutException, "socket time out");
        return;
      }
      catch (IOException localIOException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[makeRequestWithRetries]IOException:" + localIOException1);
        }
        i = this.agc + 1;
        this.agc = i;
        bool = ((HttpRequestRetryHandler)localObject2).retryRequest(localIOException1, i, this.context);
      }
      catch (NullPointerException localNullPointerException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[makeRequestWithRetries]NullPointerException:" + localNullPointerException);
        }
        localIOException2 = new IOException("NPE in HttpClient" + localNullPointerException.getMessage());
        int i = this.agc + 1;
        this.agc = i;
        bool = ((HttpRequestRetryHandler)localObject2).retryRequest(localIOException2, i, this.context);
      }
    }
    localObject2 = new ConnectException();
    ((ConnectException)localObject2).initCause(localIOException2);
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "[makeRequestWithRetries] end function. Execption:" + localObject2);
    }
    throw ((Throwable)localObject2);
  }
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Ier != null) {
        this.jdField_a_of_type_Ier.ahB();
      }
      ahz();
      if (this.jdField_a_of_type_Ier != null) {
        this.jdField_a_of_type_Ier.ahC();
      }
      return;
    }
    catch (IOException localIOException)
    {
      while (this.jdField_a_of_type_Ier == null) {}
      this.jdField_a_of_type_Ier.ahC();
      if (this.Or)
      {
        this.jdField_a_of_type_Ier.a(localIOException, (byte[])null);
        return;
      }
      this.jdField_a_of_type_Ier.f(localIOException, (String)null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.rookery.asyncHttpClient.AsyncHttpRequest
 * JD-Core Version:    0.7.0.1
 */