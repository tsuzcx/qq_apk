package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.NamedRunnable;

class Http2Connection$2
  extends NamedRunnable
{
  Http2Connection$2(Http2Connection paramHttp2Connection, String paramString, Object[] paramArrayOfObject, int paramInt, long paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      this.this$0.writer.windowUpdate(this.val$streamId, this.val$unacknowledgedBytesRead);
      return;
    }
    catch (IOException localIOException)
    {
      Http2Connection.access$000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.2
 * JD-Core Version:    0.7.0.1
 */