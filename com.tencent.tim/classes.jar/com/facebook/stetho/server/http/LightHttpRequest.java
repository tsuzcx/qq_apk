package com.facebook.stetho.server.http;

import android.net.Uri;

public class LightHttpRequest
  extends LightHttpMessage
{
  public String method;
  public String protocol;
  public Uri uri;
  
  public void reset()
  {
    super.reset();
    this.method = null;
    this.uri = null;
    this.protocol = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.http.LightHttpRequest
 * JD-Core Version:    0.7.0.1
 */