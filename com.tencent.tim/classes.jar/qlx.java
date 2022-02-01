import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class qlx
{
  private MediaExtractor a;
  
  public qlx()
  {
    bpc();
  }
  
  public boolean JY()
  {
    return false;
  }
  
  public boolean advance()
  {
    return this.a.advance();
  }
  
  @TargetApi(16)
  protected void bpc()
  {
    if (this.a != null) {
      this.a.release();
    }
    this.a = new MediaExtractor();
  }
  
  public long getCachedDuration()
  {
    return this.a.getCachedDuration();
  }
  
  public long getSampleTime()
  {
    return this.a.getSampleTime();
  }
  
  public int getSampleTrackIndex()
  {
    return this.a.getSampleTrackIndex();
  }
  
  public final int getTrackCount()
  {
    return this.a.getTrackCount();
  }
  
  @TargetApi(16)
  public MediaFormat getTrackFormat(int paramInt)
  {
    MediaFormat localMediaFormat = this.a.getTrackFormat(paramInt);
    if (localMediaFormat.getString("mime").startsWith("video/")) {
      localMediaFormat.setFloat("mpx-dar", localMediaFormat.getInteger("width") / localMediaFormat.getInteger("height"));
    }
    return localMediaFormat;
  }
  
  public boolean hasCacheReachedEndOfStream()
  {
    return this.a.hasCacheReachedEndOfStream();
  }
  
  public int readSampleData(ByteBuffer paramByteBuffer, int paramInt)
  {
    return this.a.readSampleData(paramByteBuffer, paramInt);
  }
  
  public void release()
  {
    this.a.release();
  }
  
  public void seekTo(long paramLong, int paramInt)
    throws IOException
  {
    this.a.seekTo(paramLong, paramInt);
  }
  
  public void selectTrack(int paramInt)
  {
    this.a.selectTrack(paramInt);
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException
  {
    this.a.setDataSource(paramContext, paramUri, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlx
 * JD-Core Version:    0.7.0.1
 */