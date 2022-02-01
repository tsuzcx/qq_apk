package com.tencent.qapmsdk.impl.instrumentation.httpclient;

import com.tencent.qapmsdk.impl.instrumentation.QAPMHttpClientUtil;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionState;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

public class QAPMResponseHandlerImpl<T>
  implements ResponseHandler<T>
{
  private final ResponseHandler<T> impl;
  private final QAPMTransactionState transactionState;
  
  private QAPMResponseHandlerImpl(ResponseHandler<T> paramResponseHandler, QAPMTransactionState paramQAPMTransactionState)
  {
    this.impl = paramResponseHandler;
    this.transactionState = paramQAPMTransactionState;
  }
  
  public static <T> ResponseHandler<? extends T> wrap(ResponseHandler<? extends T> paramResponseHandler, QAPMTransactionState paramQAPMTransactionState)
  {
    return new QAPMResponseHandlerImpl(paramResponseHandler, paramQAPMTransactionState);
  }
  
  public T handleResponse(HttpResponse paramHttpResponse)
    throws ClientProtocolException, IOException
  {
    QAPMHttpClientUtil.inspectAndInstrument(this.transactionState, paramHttpResponse);
    return this.impl.handleResponse(paramHttpResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.httpclient.QAPMResponseHandlerImpl
 * JD-Core Version:    0.7.0.1
 */