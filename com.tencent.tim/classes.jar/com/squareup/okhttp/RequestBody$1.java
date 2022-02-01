package com.squareup.okhttp;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

final class RequestBody$1
  extends RequestBody
{
  RequestBody$1(MediaType paramMediaType, ByteString paramByteString) {}
  
  public long contentLength()
    throws IOException
  {
    return this.val$content.size();
  }
  
  public MediaType contentType()
  {
    return this.val$contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    paramBufferedSink.write(this.val$content);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.RequestBody.1
 * JD-Core Version:    0.7.0.1
 */