package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import java.io.IOException;

public abstract interface Network
{
  public abstract Response performRequest(Request paramRequest)
    throws IOException;
  
  public abstract void performRequest(Request paramRequest, IWriteFuncListener paramIWriteFuncListener)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Network
 * JD-Core Version:    0.7.0.1
 */