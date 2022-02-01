import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.1;
import com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.2;
import com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class sqr
{
  private long Dh = -1L;
  private volatile SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private sqv jdField_a_of_type_Sqv;
  private sqw jdField_a_of_type_Sqw;
  private String aFY;
  private float[] aI = new float[16];
  private boolean aMB;
  private final Object bB = new Object();
  private final AtomicBoolean bg = new AtomicBoolean(false);
  private int byF;
  private int byG;
  private MediaFormat jdField_c_of_type_AndroidMediaMediaFormat;
  private ByteBuffer[] jdField_c_of_type_ArrayOfJavaNioByteBuffer;
  private volatile Bitmap de;
  private MediaCodec mDecoder;
  private long mDuration = -1L;
  private MediaExtractor mExtractor;
  private int mHeight;
  private int mReqHeight;
  private int mReqWidth;
  private int mWidth;
  private boolean released;
  private Surface surface;
  
  public sqr(long paramLong1, long paramLong2)
  {
    this.mReqWidth = ((int)paramLong1);
    this.mReqHeight = ((int)paramLong2);
  }
  
  @TargetApi(16)
  private boolean Nj()
  {
    if (this.jdField_c_of_type_AndroidMediaMediaFormat == null) {
      return false;
    }
    this.mWidth = this.jdField_c_of_type_AndroidMediaMediaFormat.getInteger("width");
    this.mHeight = this.jdField_c_of_type_AndroidMediaMediaFormat.getInteger("height");
    float f = this.mHeight / this.mWidth;
    if (this.mReqHeight / this.mReqWidth != f)
    {
      f = Math.max(this.mReqWidth / this.mWidth, this.mReqHeight / this.mHeight);
      this.mReqWidth = ((int)(this.mWidth * f));
      this.mReqHeight = ((int)(f * this.mHeight));
    }
    if ((this.byF == 270) || (this.byF == 90))
    {
      this.mReqWidth ^= this.mReqHeight;
      this.mReqHeight = (this.mReqWidth ^ this.mReqHeight);
      this.mReqWidth ^= this.mReqHeight;
    }
    return true;
  }
  
  @TargetApi(16)
  private boolean bk(long paramLong)
  {
    if (this.aMB) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        i = this.mDecoder.dequeueInputBuffer(0L);
        if (i >= 0)
        {
          ByteBuffer localByteBuffer = this.jdField_c_of_type_ArrayOfJavaNioByteBuffer[i];
          int j = this.mExtractor.readSampleData(localByteBuffer, 0);
          long l = this.mExtractor.getSampleTime();
          if (j > 0)
          {
            this.mExtractor.advance();
            this.mDecoder.queueInputBuffer(i, 0, j, l, 0);
          }
        }
        else
        {
          i = this.mDecoder.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 0L);
          if (i == -3) {
            continue;
          }
          if (i != -2) {
            break label153;
          }
          this.jdField_c_of_type_AndroidMediaMediaFormat = this.mDecoder.getOutputFormat();
          continue;
        }
        QLog.i("MediaCodecGLFrameFetcher", 3, "decodeGOP: end of extractor");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.aMB = true;
        return false;
      }
      this.mExtractor.release();
      this.aMB = true;
      return false;
      label153:
      if (i >= 0)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs >= paramLong)
        {
          this.mDecoder.releaseOutputBuffer(i, true);
          return true;
        }
        this.mDecoder.releaseOutputBuffer(i, false);
      }
    }
  }
  
  private void bzS()
  {
    QLog.i("MediaCodecGLFrameFetcher", 3, "finitRender: " + hashCode());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
    sqq.yM(this.byG);
  }
  
  private void bzT()
  {
    synchronized (this.bg)
    {
      QLog.i("MediaCodecGLFrameFetcher", 3, "notifyFrame");
      this.bg.set(true);
      this.bg.notifyAll();
      return;
    }
  }
  
  private void bzU()
  {
    synchronized (this.bg)
    {
      boolean bool = this.bg.get();
      if (!bool) {}
      try
      {
        this.bg.wait();
        QLog.i("MediaCodecGLFrameFetcher", 3, "waitFrame: done");
        this.bg.set(false);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  @TargetApi(16)
  private void bzV()
    throws IOException
  {
    this.surface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(new sqs(this));
    this.mDecoder = MediaCodec.createDecoderByType(this.jdField_c_of_type_AndroidMediaMediaFormat.getString("mime"));
    this.mDecoder.configure(this.jdField_c_of_type_AndroidMediaMediaFormat, this.surface, null, 0);
    this.mDecoder.start();
    this.jdField_c_of_type_ArrayOfJavaNioByteBuffer = this.mDecoder.getInputBuffers();
  }
  
  @TargetApi(16)
  private void cleanUp()
  {
    QLog.i("MediaCodecGLFrameFetcher", 3, "cleanUp");
    this.jdField_c_of_type_ArrayOfJavaNioByteBuffer = null;
    this.mDuration = -1L;
    if ((this.de != null) && (!this.de.isRecycled()))
    {
      this.de.recycle();
      this.de = null;
    }
    try
    {
      if (this.mExtractor != null) {
        this.mExtractor.release();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (this.mDecoder != null) {
            this.mDecoder.release();
          }
          return;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          return;
        }
        finally {}
        localException1 = localException1;
        localException1.printStackTrace();
        this.mExtractor = null;
      }
    }
    finally
    {
      this.mExtractor = null;
    }
    if (this.surface == null) {}
  }
  
  @TargetApi(16)
  private MediaFormat getMediaFormat()
  {
    int i = 0;
    while (i < this.mExtractor.getTrackCount())
    {
      MediaFormat localMediaFormat = this.mExtractor.getTrackFormat(i);
      if (localMediaFormat.getString("mime").startsWith("video/"))
      {
        this.mExtractor.selectTrack(i);
        return localMediaFormat;
      }
      i += 1;
    }
    return null;
  }
  
  private void initRender()
  {
    QLog.i("MediaCodecGLFrameFetcher", 3, "initRender: " + hashCode());
    this.jdField_a_of_type_Sqv = new sqv();
    this.jdField_a_of_type_Sqv.flipY(true);
    this.jdField_a_of_type_Sqv.surfaceCreated();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Sqv.getTextureId());
    this.byG = sqq.ac(this.mWidth, this.mHeight);
  }
  
  @TargetApi(16)
  private boolean prepare()
  {
    try
    {
      this.mExtractor = new MediaExtractor();
      this.mExtractor.setDataSource(this.aFY);
      this.jdField_c_of_type_AndroidMediaMediaFormat = getMediaFormat();
      try
      {
        if (this.jdField_c_of_type_AndroidMediaMediaFormat != null) {
          this.byF = this.jdField_c_of_type_AndroidMediaMediaFormat.getInteger("rotation-degrees");
        }
        if (!Nj())
        {
          cleanUp();
          return false;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          this.byF = 0;
        }
      }
      this.jdField_a_of_type_Sqw = new sqw(null, "MediaCodecGLFrameFetcher");
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      cleanUp();
      return false;
    }
    this.jdField_a_of_type_Sqw.P(new MediaCodecGLFrameFetcher.2(this));
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null)
    {
      QLog.i("MediaCodecGLFrameFetcher", 3, "prepare: surface texture is null");
      return false;
    }
    bzV();
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
    return true;
  }
  
  private void render()
  {
    bzU();
    this.jdField_a_of_type_Sqw.P(new MediaCodecGLFrameFetcher.3(this));
  }
  
  @TargetApi(16)
  public Bitmap a(long paramLong, Bitmap.Config paramConfig)
  {
    long l = 1000L * paramLong;
    if (this.mDuration == -1L) {
      this.mDuration = this.jdField_c_of_type_AndroidMediaMediaFormat.getLong("durationUs");
    }
    paramLong = l;
    if (l > this.mDuration)
    {
      QLog.w("MediaCodecGLFrameFetcher", 3, "prepareSeek: pos=" + l + ", du=" + this.mDuration);
      paramLong = this.mDuration;
    }
    this.mExtractor.seekTo(paramLong, 2);
    paramLong = this.mExtractor.getSampleTime();
    if (!bk(paramLong))
    {
      QLog.e("MediaCodecGLFrameFetcher", 1, "getFrame: decode error, ts " + paramLong);
      return null;
    }
    render();
    this.Dh = paramLong;
    if (this.de != null) {}
    for (paramConfig = this.de.copy(paramConfig, true);; paramConfig = null) {
      return paramConfig;
    }
  }
  
  public Bitmap d(long paramLong)
  {
    return a(paramLong, Bitmap.Config.ARGB_8888);
  }
  
  public boolean gd(String paramString)
  {
    if (this.released) {
      throw new RuntimeException("should not reuse!");
    }
    this.aFY = paramString;
    return prepare();
  }
  
  public void release()
  {
    QLog.d("MediaCodecGLFrameFetcher", 3, "release: " + hashCode());
    if (this.jdField_a_of_type_Sqw != null)
    {
      this.jdField_a_of_type_Sqw.P(new MediaCodecGLFrameFetcher.1(this));
      this.jdField_a_of_type_Sqw.destroy();
      this.jdField_a_of_type_Sqw = null;
    }
    cleanUp();
    this.released = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqr
 * JD-Core Version:    0.7.0.1
 */