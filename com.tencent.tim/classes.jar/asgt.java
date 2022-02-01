import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.qg.video.videodecoder.MediaDecoder.a;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public abstract class asgt
{
  protected asgt.a a;
  protected asgt.b a;
  protected long axb = System.currentTimeMillis();
  protected long axc;
  protected long axd;
  protected MediaDecoder.a b;
  protected boolean deq;
  protected boolean der;
  protected MediaCodec.BufferInfo mBufferInfo;
  protected MediaExtractor mExtractor;
  protected ByteBuffer[] mInputBuffers;
  protected MediaCodec mMediaCodec;
  protected MediaFormat mMediaFormat;
  protected ByteBuffer[] mOutputBuffers;
  
  public asgt(asgt.b paramb, asgt.a parama)
  {
    this.jdField_a_of_type_Asgt$b = paramb;
    this.jdField_a_of_type_Asgt$a = parama;
  }
  
  protected abstract String DQ();
  
  protected abstract void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo);
  
  protected abstract void a(asgt.a parama, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat);
  
  public void a(MediaDecoder.a parama)
  {
    this.b = parama;
  }
  
  public boolean aHO()
  {
    return this.der;
  }
  
  public void decodeFrame()
  {
    if (!this.deq) {
      enp();
    }
    if (!this.der) {
      a(this.mMediaCodec, this.mBufferInfo);
    }
    if (this.der) {}
  }
  
  public void eno()
  {
    this.axb = (System.currentTimeMillis() - this.mBufferInfo.presentationTimeUs / 1000L);
  }
  
  protected void enp()
  {
    int i = this.mMediaCodec.dequeueInputBuffer(10000L);
    int j;
    long l1;
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.mInputBuffers[i];
      j = this.mExtractor.readSampleData(localByteBuffer, 0);
      l1 = this.mExtractor.getSampleTime();
      if (j < 0)
      {
        this.mMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        this.deq = true;
      }
    }
    else
    {
      return;
    }
    long l2 = this.axc;
    this.axc = l1;
    this.axd += l1 - l2;
    this.mMediaCodec.queueInputBuffer(i, 0, j, this.axd, 0);
    this.mExtractor.advance();
  }
  
  public long getStartTime()
  {
    return this.axb;
  }
  
  public long ig()
  {
    if (this.mBufferInfo != null) {
      return this.mBufferInfo.presentationTimeUs;
    }
    return 0L;
  }
  
  public boolean init()
  {
    boolean bool2 = false;
    asgr.aP(this.jdField_a_of_type_Asgt$b.axe, "[" + DQ() + "] init now");
    this.mMediaCodec = null;
    this.mExtractor = new MediaExtractor();
    boolean bool1;
    for (;;)
    {
      int i;
      try
      {
        this.mExtractor.setDataSource(this.jdField_a_of_type_Asgt$a.path);
        asgr.aP(this.jdField_a_of_type_Asgt$b.axe, "[" + DQ() + "] extractor setDataSource");
        i = 0;
        bool1 = bool2;
        if (i < this.mExtractor.getTrackCount())
        {
          this.mMediaFormat = this.mExtractor.getTrackFormat(i);
          str = this.mMediaFormat.getString("mime");
          if (!str.startsWith(this.jdField_a_of_type_Asgt$a.name)) {
            break label353;
          }
          this.mExtractor.selectTrack(i);
          asgr.aP(this.jdField_a_of_type_Asgt$b.axe, "[" + DQ() + "] find and selectTrack");
        }
      }
      catch (IOException localIOException)
      {
        String str;
        ram.w(DQ(), "init set data source error :%s", localIOException);
        return false;
      }
      try
      {
        this.mMediaCodec = MediaCodec.createDecoderByType(str);
        asgr.aP(this.jdField_a_of_type_Asgt$b.axe, "[" + DQ() + "] create codec");
        a(this.jdField_a_of_type_Asgt$a, this.mMediaCodec, this.mMediaFormat);
        asgr.aP(this.jdField_a_of_type_Asgt$b.axe, "[" + DQ() + "] configureCodec");
        bool1 = true;
      }
      catch (Throwable localThrowable)
      {
        ram.w(DQ(), "init createDecoderByType error :%s", localThrowable);
        bool1 = bool2;
        continue;
      }
      if (!bool1) {
        break;
      }
      ram.d(DQ(), "create media decoder success!");
      return bool1;
      label353:
      i += 1;
    }
    ram.w(DQ(), "create media decoder error!");
    return bool1;
  }
  
  public void onRelease()
  {
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.stop();
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      if (this.mExtractor != null)
      {
        this.mExtractor.release();
        this.mExtractor = null;
      }
      return;
    }
    catch (Exception localException)
    {
      ram.e(DQ(), "onRelease error :%s ", localException);
    }
  }
  
  public long seekInLoop(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      this.mMediaCodec.flush();
      this.mExtractor.seekTo(paramLong, 0);
      long l2 = this.mExtractor.getSampleTime();
      if (this.b != null) {
        this.b.onDecodeSeekTo(l2 / 1000L);
      }
      this.deq = false;
      this.der = false;
      this.axc = l2;
      this.axd = l2;
      this.mBufferInfo = new MediaCodec.BufferInfo();
      this.mBufferInfo.presentationTimeUs = l2;
      this.axb = (System.currentTimeMillis() - l2 / 1000L);
      ram.d(DQ(), "end seekTo timecost=" + (System.currentTimeMillis() - l1) + " seekTargetTimeUs:" + paramLong + " realStartTime:" + l2);
      return l2;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        ram.e(DQ(), "decoder flush error %s", localRuntimeException);
      }
    }
  }
  
  public boolean start()
  {
    ram.b(DQ(), "start ! %s", this.jdField_a_of_type_Asgt$a);
    try
    {
      this.mMediaCodec.start();
      return false;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.mInputBuffers = this.mMediaCodec.getInputBuffers();
        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
        this.mBufferInfo = new MediaCodec.BufferInfo();
        this.axb = System.currentTimeMillis();
        return true;
      }
      catch (Exception localException)
      {
        ram.e(DQ(), "decode start error :%s", localException);
      }
      localThrowable = localThrowable;
      ram.e(DQ(), "decode start error", localThrowable);
      return false;
    }
  }
  
  public static class a
  {
    public String name;
    public String path;
    
    public String toString()
    {
      return "[MediaCodecInfo] name : " + this.name + " ;path = " + this.path;
    }
  }
  
  public static class b
  {
    public volatile long axe;
    public volatile boolean mMuteAudio;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgt
 * JD-Core Version:    0.7.0.1
 */