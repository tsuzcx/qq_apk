package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import java.io.IOException;

public abstract interface ResponseDelivery
{
  public abstract void postError(Request paramRequest, IOException paramIOException);
  
  public abstract void postResponse(Request paramRequest, Response paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.ResponseDelivery
 * JD-Core Version:    0.7.0.1
 */