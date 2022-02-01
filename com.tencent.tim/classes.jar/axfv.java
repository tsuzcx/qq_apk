import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class axfv
{
  private static String TAG = axfv.class.getSimpleName();
  private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
  private int eEP;
  private final long endTime = 2147483647L;
  private boolean eos;
  private String filePath = "";
  private MediaCodec mediaCodec;
  private MediaExtractor mediaExtractor;
  private final long startTime = 0L;
  private long timestamp;
  
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
    }
    try
    {
      this.mediaCodec = MediaCodec.createDecoderByType(str);
      this.mediaCodec.configure(localMediaFormat, paramSurface, null, 0);
      this.mediaCodec.start();
      this.mediaExtractor.selectTrack(this.eEP);
      this.mediaExtractor.seekTo(0L, 0);
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
  
  public void a(String paramString, Surface paramSurface)
  {
    try
    {
      this.filePath = paramString;
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
      Object localObject;
      if (!this.eos)
      {
        i = this.mediaCodec.dequeueInputBuffer(10000L);
        if (i >= 0)
        {
          localObject = this.mediaCodec.getInputBuffers()[i];
          j = this.mediaExtractor.readSampleData((ByteBuffer)localObject, 0);
          if (j >= 0) {
            break label261;
          }
          QLog.e(TAG, 4, "decodeToSurface BUFFER_FLAG_END_OF_STREAM");
          this.mediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
          this.eos = true;
        }
      }
      int j = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 10000L);
      QLog.e(TAG, 4, new Object[] { "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(j) });
      switch (j)
      {
      }
      this.timestamp = this.bufferInfo.presentationTimeUs;
      QLog.e(TAG, 4, new Object[] { "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(j), ", timestamp = ", Long.valueOf(this.timestamp) });
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        i = 1;
        label227:
        localObject = this.mediaCodec;
        if (i != 0) {
          break label304;
        }
      }
      label261:
      label304:
      for (boolean bool = true;; bool = false)
      {
        ((MediaCodec)localObject).releaseOutputBuffer(j, bool);
        if (i == 0) {
          break label309;
        }
        QLog.e(TAG, 4, "decodeToSurface decode complete");
        return false;
        QLog.e(TAG, 4, "decodeToSurface mediaCodec.queueInputBuffer");
        this.mediaCodec.queueInputBuffer(i, 0, j, this.mediaExtractor.getSampleTime(), 0);
        this.mediaExtractor.advance();
        break;
        i = 0;
        break label227;
      }
      label309:
      return true;
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
  
  public void reset()
  {
    if (this.eos)
    {
      this.eos = false;
      this.mediaExtractor.seekTo(0L, 1);
      this.mediaCodec.flush();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfv
 * JD-Core Version:    0.7.0.1
 */