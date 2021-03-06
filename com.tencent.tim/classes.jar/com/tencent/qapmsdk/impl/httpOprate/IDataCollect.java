package com.tencent.qapmsdk.impl.httpOprate;

import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionState;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

public abstract interface IDataCollect
{
  public abstract boolean canCollect();
  
  public abstract void collectException(QAPMTransactionState paramQAPMTransactionState, IOException paramIOException)
    throws Exception;
  
  public abstract void collectRequest(Request paramRequest, QAPMTransactionState paramQAPMTransactionState)
    throws Exception;
  
  public abstract void collectResponse(Response paramResponse, QAPMTransactionState paramQAPMTransactionState)
    throws Exception;
  
  public abstract boolean isCanCollect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.httpOprate.IDataCollect
 * JD-Core Version:    0.7.0.1
 */