package com.tencent.thumbplayer.core.drm.httpclient;

import java.io.IOException;

public abstract interface Network
{
  public abstract Response performRequest(Request paramRequest)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Network
 * JD-Core Version:    0.7.0.1
 */