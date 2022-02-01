package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.NamedRunnable;

class Http2Connection$1
  extends NamedRunnable
{
  Http2Connection$1(Http2Connection paramHttp2Connection, String paramString, Object[] paramArrayOfObject, int paramInt, ErrorCode paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      this.this$0.writeSynReset(this.val$streamId, this.val$errorCode);
      return;
    }
    catch (IOException localIOException)
    {
      Http2Connection.access$000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.1
 * JD-Core Version:    0.7.0.1
 */