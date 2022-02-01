package retrofit.client;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import okio.BufferedSink;
import retrofit.mime.TypedOutput;

final class OkClient$1
  extends RequestBody
{
  OkClient$1(MediaType paramMediaType, TypedOutput paramTypedOutput) {}
  
  public long contentLength()
  {
    return this.val$body.length();
  }
  
  public MediaType contentType()
  {
    return this.val$mediaType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    this.val$body.writeTo(paramBufferedSink.outputStream());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.client.OkClient.1
 * JD-Core Version:    0.7.0.1
 */