package okhttp3.internal.huc;

import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;
import okio.Source;

final class StreamedRequestBody
  extends OutputStreamRequestBody
  implements UnrepeatableRequestBody
{
  private final Pipe pipe = new Pipe(8192L);
  
  StreamedRequestBody(long paramLong)
  {
    initOutputStream(Okio.buffer(this.pipe.sink()), paramLong);
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    while (this.pipe.source().read(localBuffer, 8192L) != -1L) {
      paramBufferedSink.write(localBuffer, localBuffer.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.huc.StreamedRequestBody
 * JD-Core Version:    0.7.0.1
 */