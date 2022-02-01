package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.Executor;

public class ExecutorDelivery
  implements ResponseDelivery
{
  private final Executor mResponsePoster;
  
  public ExecutorDelivery(Handler paramHandler)
  {
    this.mResponsePoster = new ExecutorDelivery.1(this, paramHandler);
  }
  
  public ExecutorDelivery(Executor paramExecutor)
  {
    this.mResponsePoster = paramExecutor;
  }
  
  public void postError(Request paramRequest, IOException paramIOException)
  {
    paramIOException = Response.error(paramIOException);
    this.mResponsePoster.execute(new ResponseDeliveryRunnable(paramRequest, paramIOException));
  }
  
  public void postResponse(Request paramRequest, Response paramResponse)
  {
    this.mResponsePoster.execute(new ResponseDeliveryRunnable(paramRequest, paramResponse));
  }
  
  static class ResponseDeliveryRunnable
    implements Runnable
  {
    private final Request mRequest;
    private final Response mResponse;
    
    public ResponseDeliveryRunnable(Request paramRequest, Response paramResponse)
    {
      this.mRequest = paramRequest;
      this.mResponse = paramResponse;
    }
    
    public void run()
    {
      if (this.mRequest.isCanceled())
      {
        this.mRequest.finish();
        return;
      }
      if (this.mResponse.isSuccess()) {
        this.mRequest.deliverResponse(this.mResponse);
      }
      for (;;)
      {
        this.mRequest.finish();
        return;
        this.mRequest.deliverError(this.mResponse.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.ExecutorDelivery
 * JD-Core Version:    0.7.0.1
 */