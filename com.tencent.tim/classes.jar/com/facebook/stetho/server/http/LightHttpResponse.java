package com.facebook.stetho.server.http;

public class LightHttpResponse
  extends LightHttpMessage
{
  public LightHttpBody body;
  public int code;
  public String reasonPhrase;
  
  public void prepare()
  {
    if (this.body != null)
    {
      addHeader("Content-Type", this.body.contentType());
      addHeader("Content-Length", String.valueOf(this.body.contentLength()));
    }
  }
  
  public void reset()
  {
    super.reset();
    this.code = -1;
    this.reasonPhrase = null;
    this.body = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.http.LightHttpResponse
 * JD-Core Version:    0.7.0.1
 */