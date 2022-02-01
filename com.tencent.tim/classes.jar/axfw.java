import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class axfw
{
  private static String TAG = axfw.class.getSimpleName();
  private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
  private ByteBuffer byteBuffer;
  private long duration;
  private int eEP;
  private long endTime;
  private boolean eos;
  private String filePath = "";
  private int height;
  private int maxInputSize;
  private MediaCodec mediaCodec;
  private MediaExtractor mediaExtractor;
  private long startTime;
  private long timestamp;
  private int width;
  
  private void d(Surface paramSurface)
  {
    this.mediaExtractor = new MediaExtractor();
    label121:
    MediaFormat localMediaFormat;
    String str;
    try
    {
      this.mediaExtractor.setDataSource(this.filePath);
      int j = this.mediaExtractor.getTrackCount();
      i = 0;
      if (i < j)
      {
        if (this.mediaExtractor.getTrackFormat(i).getString("mime").contains("video")) {
          this.eEP = i;
        }
      }
      else
      {
        if (this.eEP != -1) {
          break label121;
        }
        this.mediaExtractor.release();
        return;
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        int i;
        QLog.e(TAG, 4, "video decoder media extractor setDataSource() exception, msg = " + localIOException1.getMessage());
        continue;
        i += 1;
      }
      localMediaFormat = this.mediaExtractor.getTrackFormat(this.eEP);
      str = localMediaFormat.getString("mime");
      this.maxInputSize = localMediaFormat.getInteger("max-input-size");
      this.byteBuffer = ByteBuffer.allocate(this.maxInputSize);
    }
    try
    {
      this.mediaCodec = MediaCodec.createDecoderByType(str);
      this.mediaCodec.configure(localMediaFormat, paramSurface, null, 0);
      this.mediaCodec.start();
      this.mediaExtractor.selectTrack(this.eEP);
      this.mediaExtractor.seekTo(this.startTime, 0);
      return;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        QLog.e(TAG, 4, "video decoder media codec create exception, msg = " + localIOException2.getMessage());
      }
    }
  }
  
  private void z(String paramString, long paramLong1, long paramLong2)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      this.filePath = paramString;
      this.startTime = paramLong1;
      this.endTime = paramLong2;
      localMediaMetadataRetriever.setDataSource(paramString);
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(24));
      this.width = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
      this.height = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
      if ((i == 90) || (i == 270))
      {
        i = this.width;
        this.width = this.height;
        this.height = i;
      }
      this.duration = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 4, "video decoder init parameters exception, msg = " + paramString.getMessage());
      return;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, Surface paramSurface)
  {
    try
    {
      z(paramString, paramLong1, paramLong2);
      d(paramSurface);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 4, "video decoder init exception, msg = " + paramString.getMessage());
    }
  }
  
  public boolean aOw()
  {
    QLog.e(TAG, 4, "decodeToSurface start");
    if (!Thread.interrupted())
    {
      QLog.e(TAG, 4, "decodeToSurface loop");
      int i;
      int j;
      if (!this.eos)
      {
        i = this.mediaCodec.dequeueInputBuffer(10000L);
        if (i >= 0)
        {
          localObject = this.mediaCodec.getInputBuffers()[i];
          j = this.mediaExtractor.readSampleData((ByteBuffer)localObject, 0);
          if (j >= 0) {
            break label159;
          }
          QLog.e(TAG, 4, "decodeToSurface BUFFER_FLAG_END_OF_STREAM");
          this.mediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
          this.eos = true;
        }
      }
      for (;;)
      {
        i = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 10000L);
        QLog.e(TAG, 4, new Object[] { "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(i) });
        if ((this.bufferInfo.flags & 0x4) == 0) {
          break;
        }
        QLog.e(TAG, 4, "decodeToSurface decode complete");
        return false;
        label159:
        QLog.e(TAG, 4, "decodeToSurface mediaCodec.queueInputBuffer");
        this.mediaCodec.queueInputBuffer(i, 0, j, this.mediaExtractor.getSampleTime(), 0);
        this.mediaExtractor.advance();
      }
      switch (i)
      {
      }
      this.timestamp = this.bufferInfo.presentationTimeUs;
      QLog.e(TAG, 4, new Object[] { "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(i), ", timestamp = ", Long.valueOf(this.timestamp) });
      Object localObject = this.mediaCodec;
      if (this.timestamp < this.endTime) {}
      for (boolean bool = true;; bool = false)
      {
        ((MediaCodec)localObject).releaseOutputBuffer(i, bool);
        if (this.timestamp >= this.endTime) {
          break;
        }
        return true;
      }
      return false;
    }
    return false;
  }
  
  public void release()
  {
    try
    {
      this.mediaExtractor.unselectTrack(this.eEP);
      this.mediaExtractor.release();
      this.mediaCodec.stop();
      this.mediaCodec.release();
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 4, "video decoder exception, msg = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfw
 * JD-Core Version:    0.7.0.1
 */