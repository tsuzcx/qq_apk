import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class jgv
{
  private String RV;
  public volatile boolean Zi;
  public volatile boolean Zj;
  private boolean Zk;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private int azv;
  private int azw;
  private MediaCodec jdField_b_of_type_AndroidMediaMediaCodec;
  private jha jdField_b_of_type_Jha;
  private ByteBuffer h;
  private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
  private MediaMuxer mMediaMuxer;
  public volatile boolean mMuxerStarted;
  private long pk;
  private long pl;
  private long pm;
  private long pn;
  
  public jgv(jha paramjha)
  {
    this.jdField_b_of_type_Jha = paramjha;
  }
  
  private void kN(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "handleVideoFrame(" + paramBoolean + ")");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavRecordEncoder", 2, "sending EOS to encoder");
      }
      this.jdField_b_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
    }
    ByteBuffer[] arrayOfByteBuffer = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    int i = 0;
    for (;;)
    {
      int j = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
      if (j == -1) {
        if (!paramBoolean) {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "no output available yet");
          }
        }
      }
      label616:
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
        }
        j = i + 1;
        i = j;
        if (j <= 100) {
          break;
        }
        throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
        if (j == -3)
        {
          arrayOfByteBuffer = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          break;
        }
        if (j == -2)
        {
          if (this.Zi) {
            throw new RuntimeException("format changed twice");
          }
          localObject = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputFormat();
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "encoder output format changed: " + localObject);
          }
          this.azv = this.mMediaMuxer.addTrack((MediaFormat)localObject);
          if ((!this.mMuxerStarted) && ((this.Zj) || (this.Zk)))
          {
            this.mMediaMuxer.start();
            this.mMuxerStarted = true;
            if (this.jdField_b_of_type_Jha.a != null) {
              this.jdField_b_of_type_Jha.a.auy();
            }
          }
          this.Zi = true;
          this.pn = System.currentTimeMillis();
          break;
        }
        if (j < 0)
        {
          QLog.w("QavRecordEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + j);
          break;
        }
        Object localObject = arrayOfByteBuffer[j];
        if (localObject == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
        }
        if ((this.mBufferInfo.flags & 0x2) != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
          }
          this.mBufferInfo.size = 0;
        }
        if ((this.mBufferInfo.size != 0) && (this.mMuxerStarted))
        {
          ((ByteBuffer)localObject).position(this.mBufferInfo.offset);
          ((ByteBuffer)localObject).limit(this.mBufferInfo.offset + this.mBufferInfo.size);
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "before writeSampleData video" + this.mBufferInfo.size + ", offset=" + this.mBufferInfo.offset + " bytes to muxer, ts=" + this.mBufferInfo.presentationTimeUs);
          }
          if (this.mBufferInfo.presentationTimeUs < this.pm) {
            break label616;
          }
          this.pm = this.mBufferInfo.presentationTimeUs;
          this.mMediaMuxer.writeSampleData(this.azv, (ByteBuffer)localObject, this.mBufferInfo);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
          if ((this.mBufferInfo.flags & 0x4) == 0) {
            break label642;
          }
          if (paramBoolean) {
            break;
          }
          QLog.w("QavRecordEncoder", 2, "reached end of stream unexpectedly");
          return;
          QLog.e("QavRecordEncoder", 1, "handleVideoFrame, find older frame");
        }
      } while (!QLog.isColorLevel());
      QLog.d("QavRecordEncoder", 2, "end of stream reached");
      return;
      label642:
      i = 0;
    }
  }
  
  public void a(amae paramamae)
    throws IOException
  {
    this.RV = paramamae.outputFilePath;
    Object localObject = MediaFormat.createVideoFormat("video/avc", paramamae.width, paramamae.height);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", paramamae.bitRate);
    ((MediaFormat)localObject).setInteger("frame-rate", paramamae.frameRate);
    ((MediaFormat)localObject).setInteger("i-frame-interval", paramamae.agP);
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "VideoFormat: " + localObject);
    }
    if (this.h == null) {
      this.h = ByteBuffer.allocateDirect(32768);
    }
    this.jdField_b_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_b_of_type_AndroidMediaMediaCodec.configure((MediaFormat)localObject, null, null, 1);
    this.jdField_a_of_type_AndroidViewSurface = this.jdField_b_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_b_of_type_AndroidMediaMediaCodec.start();
    this.pk = 0L;
    this.jdField_a_of_type_AndroidMediaMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", 2);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-mask", 12);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("bitrate", 128000);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-count", 1);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("sample-rate", 48000);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", 32768);
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "AudioFormat: " + this.jdField_a_of_type_AndroidMediaMediaFormat);
    }
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, 1);
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    }
    localObject = new File(paramamae.outputFilePath);
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordEncoder", 2, "start, before check file, exits[" + ((File)localObject).exists() + "]");
    }
    if (!((File)localObject).exists()) {
      aqhq.UD(((File)localObject).getAbsolutePath());
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordEncoder", 2, "start, end of check file, exits[" + ((File)localObject).exists() + "]");
    }
    this.mMediaMuxer = new MediaMuxer(paramamae.outputFilePath, 0);
    this.mMediaMuxer.setOrientationHint(paramamae.orientation);
    this.azv = -1;
    this.azw = -1;
    this.Zi = false;
    this.Zj = false;
    this.mMuxerStarted = false;
    this.pn = (System.currentTimeMillis() + 99999999L);
    this.Zk = false;
    this.pm = 0L;
    this.pl = 0L;
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
      this.Zk = true;
    }
  }
  
  protected void a(jgp paramjgp, boolean paramBoolean)
  {
    if (AudioHelper.aCz()) {
      QLog.w("QavRecordEncoder", 1, "handleAudioFrame, frame[" + paramjgp + "], endOfStream[" + paramBoolean + "], mNoAudio[" + this.Zk + "]");
    }
    if (this.Zk) {
      return;
    }
    this.h.clear();
    this.h.put(paramjgp.data);
    this.h.position(paramjgp.data.length);
    this.h.flip();
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
    int i = 0;
    label121:
    int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (QLog.isColorLevel()) {
      QLog.w("QavRecordEncoder", 1, "往编码器写, dequeueInputBuffer[" + j + "], inputBuffers[" + localObject + "], mAudioTrackIndex[" + this.azw + "]");
    }
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      ((ByteBuffer)localObject).put(this.h);
      this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(j, 0, paramjgp.data.length, paramjgp.pj, 0);
      if (QLog.isColorLevel()) {
        QLog.d("QavRecordEncoder", 2, "encode, write to codec, size=" + paramjgp.data.length);
      }
      label280:
      paramjgp = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      i = 0;
    }
    for (;;)
    {
      j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
      if (QLog.isColorLevel()) {
        QLog.w("QavRecordEncoder", 1, "往合成器写, dequeueOutputBuffer[" + j + "]");
      }
      if (j == -1)
      {
        if (!paramBoolean)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QavRecordEncoder", 2, "no output available yet");
          return;
          if (j != -1) {
            break label121;
          }
          if (!paramBoolean)
          {
            if (!QLog.isColorLevel()) {
              break label280;
            }
            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available yet");
            break label280;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available, spinning to await EOS");
          }
          j = i + 1;
          i = j;
          if (j <= 10) {
            break label121;
          }
          break label280;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
        }
        j = i + 1;
        i = j;
        if (j <= 10) {
          continue;
        }
        return;
      }
      if (j == -3)
      {
        paramjgp = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      }
      else if (j == -2)
      {
        if (this.Zj) {
          throw new RuntimeException("format changed twice");
        }
        localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
        this.azw = this.mMediaMuxer.addTrack((MediaFormat)localObject);
        if (QLog.isColorLevel()) {
          QLog.w("QavRecordEncoder", 1, "encoder output format changed, newFormat[" + localObject + "], mAudioTrackIndex[" + this.azw + "]");
        }
        if ((!this.mMuxerStarted) && (this.Zi))
        {
          this.mMuxerStarted = true;
          this.mMediaMuxer.start();
          if (this.jdField_b_of_type_Jha.a != null) {
            this.jdField_b_of_type_Jha.a.auy();
          }
        }
        this.Zj = true;
      }
      else if (j < 0)
      {
        QLog.w("QavRecordEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + j);
      }
      else
      {
        localObject = paramjgp[j];
        if (localObject == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
        }
        if ((this.mBufferInfo.flags & 0x2) != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
          }
          this.mBufferInfo.size = 0;
        }
        if ((this.mBufferInfo.size != 0) && (this.mMuxerStarted))
        {
          ((ByteBuffer)localObject).position(this.mBufferInfo.offset);
          ((ByteBuffer)localObject).limit(this.mBufferInfo.offset + this.mBufferInfo.size);
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "before writeSampleData audio " + this.mBufferInfo.size + ", offset=" + this.mBufferInfo.offset + " to muxer, ts=" + this.mBufferInfo.presentationTimeUs);
          }
          if (this.mBufferInfo.presentationTimeUs < this.pl) {
            break label952;
          }
          this.pl = this.mBufferInfo.presentationTimeUs;
          this.mMediaMuxer.writeSampleData(this.azw, (ByteBuffer)localObject, this.mBufferInfo);
          QLog.d("QavRecordEncoder", 2, "end writeSampleData");
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
          if ((this.mBufferInfo.flags & 0x4) == 0) {
            break label979;
          }
          if (paramBoolean) {
            break;
          }
          QLog.w("QavRecordEncoder", 2, "reached end of stream unexpectedly");
          return;
          label952:
          QLog.e("QavRecordEncoder", 1, "handleAudioFrame, find older frame");
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QavRecordEncoder", 2, "end of stream reached");
        return;
        label979:
        i = 0;
      }
    }
  }
  
  public void awh()
  {
    kN(false);
  }
  
  public void d(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavRecordEncoder", 1, "audioFrameAvailable, audioData[" + paramArrayOfByte.length + "], pts[" + paramLong + "], mAudioFrameIdx[" + this.pk + "]");
    }
    long l = this.pk;
    this.pk = (1L + l);
    paramArrayOfByte = new jgp(paramArrayOfByte, l);
    paramArrayOfByte.pj = paramLong;
    a(paramArrayOfByte, false);
  }
  
  public Surface getInputSurface()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
    }
    catch (Exception localException3)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        this.jdField_a_of_type_AndroidMediaMediaCodec = null;
        if (this.jdField_b_of_type_AndroidMediaMediaCodec == null) {}
      }
      catch (Exception localException3)
      {
        try
        {
          this.jdField_b_of_type_AndroidMediaMediaCodec.stop();
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              this.jdField_b_of_type_AndroidMediaMediaCodec.release();
              this.jdField_b_of_type_AndroidMediaMediaCodec = null;
              if (this.mMediaMuxer != null) {}
              try
              {
                if (this.mMuxerStarted)
                {
                  this.mMuxerStarted = false;
                  this.mMediaMuxer.stop();
                }
                this.mMediaMuxer.release();
              }
              catch (Exception localException5)
              {
                for (;;)
                {
                  QLog.e("QavRecordEncoder", 2, "Muxer stop exception:" + localException5, localException5);
                }
              }
              this.mMediaMuxer = null;
              return;
              localException1 = localException1;
              QLog.w("QavRecordEncoder", 2, "mAudioCodec stop exception:" + localException1);
              continue;
              localException2 = localException2;
              QLog.w("QavRecordEncoder", 2, "mAudioCodec release exception:" + localException2);
              continue;
              localException3 = localException3;
              QLog.w("QavRecordEncoder", 2, "mVideoCodec stop exception:" + localException3);
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              QLog.w("QavRecordEncoder", 2, "mVideoCodec release exception:" + localException4);
            }
          }
        }
      }
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "QavRecordEncoder stop.");
    }
    long l = this.pk;
    this.pk = (1L + l);
    jgp localjgp = new jgp(new byte[0], l);
    localjgp.pj = this.pl;
    a(localjgp, true);
    kN(true);
    release();
    if (this.h != null)
    {
      this.h.clear();
      this.h = null;
    }
  }
  
  public boolean xk()
  {
    if ((this.Zj) || (this.mMuxerStarted)) {
      return false;
    }
    long l = System.currentTimeMillis();
    if (l - this.pn > 2000L)
    {
      QLog.d("QavRecordEncoder", 1, "onAudioTrackTimeout has timeout, ready=" + this.pn + ", now=" + l);
      this.Zk = true;
      if (this.mMediaMuxer != null)
      {
        this.mMediaMuxer.start();
        this.mMuxerStarted = true;
        if (this.jdField_b_of_type_Jha.a != null) {
          this.jdField_b_of_type_Jha.a.auy();
        }
      }
      jgx.awl();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgv
 * JD-Core Version:    0.7.0.1
 */