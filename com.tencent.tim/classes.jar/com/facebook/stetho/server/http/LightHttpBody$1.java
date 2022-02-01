package com.facebook.stetho.server.http;

import java.io.IOException;
import java.io.OutputStream;

final class LightHttpBody$1
  extends LightHttpBody
{
  LightHttpBody$1(String paramString, byte[] paramArrayOfByte) {}
  
  public int contentLength()
  {
    return this.val$body.length;
  }
  
  public String contentType()
  {
    return this.val$contentType;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.val$body);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.http.LightHttpBody.1
 * JD-Core Version:    0.7.0.1
 */