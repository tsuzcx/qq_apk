package okhttp3.internal.http2;

import java.io.IOException;

class Http2Connection$Listener$1
  extends Http2Connection.Listener
{
  public void onStream(Http2Stream paramHttp2Stream)
    throws IOException
  {
    paramHttp2Stream.close(ErrorCode.REFUSED_STREAM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.Listener.1
 * JD-Core Version:    0.7.0.1
 */