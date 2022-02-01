package okhttp3.internal.http2;

import java.io.IOException;

public final class StreamResetException
  extends IOException
{
  public final ErrorCode errorCode;
  
  public StreamResetException(ErrorCode paramErrorCode)
  {
    super(localStringBuilder.toString());
    this.errorCode = paramErrorCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.StreamResetException
 * JD-Core Version:    0.7.0.1
 */