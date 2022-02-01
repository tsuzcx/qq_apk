package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody
  extends ResponseBody
{
  private final long contentLength;
  @Nullable
  private final String contentTypeString;
  private final BufferedSource source;
  
  public RealResponseBody(@Nullable String paramString, long paramLong, BufferedSource paramBufferedSource)
  {
    this.contentTypeString = paramString;
    this.contentLength = paramLong;
    this.source = paramBufferedSource;
  }
  
  public long contentLength()
  {
    return this.contentLength;
  }
  
  public MediaType contentType()
  {
    if (this.contentTypeString != null) {
      return MediaType.parse(this.contentTypeString);
    }
    return null;
  }
  
  public BufferedSource source()
  {
    return this.source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http.RealResponseBody
 * JD-Core Version:    0.7.0.1
 */