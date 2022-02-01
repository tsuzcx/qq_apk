package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

class PushObserver$1
  implements PushObserver
{
  public boolean onData(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    paramBufferedSource.skip(paramInt2);
    return true;
  }
  
  public boolean onHeaders(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    return true;
  }
  
  public boolean onRequest(int paramInt, List<Header> paramList)
  {
    return true;
  }
  
  public void onReset(int paramInt, ErrorCode paramErrorCode) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.PushObserver.1
 * JD-Core Version:    0.7.0.1
 */