package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.File;
import java.io.IOException;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

final class RequestBody$3
  extends RequestBody
{
  RequestBody$3(MediaType paramMediaType, File paramFile) {}
  
  public long contentLength()
  {
    return this.val$file.length();
  }
  
  public MediaType contentType()
  {
    return this.val$contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    Object localObject = null;
    try
    {
      Source localSource = Okio.source(this.val$file);
      localObject = localSource;
      paramBufferedSink.writeAll(localSource);
      return;
    }
    finally
    {
      Util.closeQuietly(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.RequestBody.3
 * JD-Core Version:    0.7.0.1
 */