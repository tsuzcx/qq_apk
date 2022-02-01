import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class amag
{
  private String RV;
  private Surface a;
  private amai jdField_b_of_type_Amai;
  private amaq jdField_b_of_type_Amaq;
  private MediaMuxer jdField_b_of_type_AndroidMediaMediaMuxer;
  private MediaCodec d;
  public MediaFormat d;
  private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
  private boolean mMuxerStarted;
  private int mTrackIndex;
  
  private void drainEncoder(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "drainEncoder(" + paramBoolean + ")");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoEncoder", 2, "sending EOS to encoder");
      }
      this.jdField_d_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
    }
    ByteBuffer[] arrayOfByteBuffer = this.jdField_d_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    int i = 0;
    for (;;)
    {
      int j = this.jdField_d_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
      if (j == -1) {
        if (!paramBoolean) {
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "no output available yet");
          }
        }
      }
      for (;;)
      {
        if ((paramBoolean) && (this.jdField_b_of_type_Amai != null)) {
          this.jdField_b_of_type_Amai.dKO();
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoEncoder", 2, "no output available, spinning to await EOS");
        }
        j = i + 1;
        i = j;
        if (j <= 100) {
          break;
        }
        throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
        if (j == -3)
        {
          arrayOfByteBuffer = this.jdField_d_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          break;
        }
        if (j == -2)
        {
          this.jdField_d_of_type_AndroidMediaMediaFormat = this.jdField_d_of_type_AndroidMediaMediaCodec.getOutputFormat();
          f(this.jdField_d_of_type_AndroidMediaMediaFormat);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("HWVideoEncoder", 2, "encoder output format changed: " + this.jdField_d_of_type_AndroidMediaMediaFormat);
          break;
        }
        if (j < 0)
        {
          QLog.w("HWVideoEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + j);
          break;
        }
        ByteBuffer localByteBuffer = arrayOfByteBuffer[j];
        if (localByteBuffer == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
        }
        if ((this.mBufferInfo.flags & 0x2) != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
          }
          this.mBufferInfo.size = 0;
        }
        if (this.mBufferInfo.size != 0)
        {
          a(localByteBuffer, this.mBufferInfo);
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "sent " + this.mBufferInfo.size + " bytes to muxer, ts=" + this.mBufferInfo.presentationTimeUs * 1000L);
          }
        }
        this.jdField_d_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
        if ((this.mBufferInfo.flags & 0x4) == 0) {
          break label485;
        }
        if (!paramBoolean) {
          QLog.w("HWVideoEncoder", 2, "reached end of stream unexpectedly");
        } else if (QLog.isColorLevel()) {
          QLog.d("HWVideoEncoder", 2, "end of stream reached");
        }
      }
      label485:
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
    if (paramamae.dzA != -1) {
      ((MediaFormat)localObject).setInteger("bitrate-mode", paramamae.dzA);
    }
    if (paramamae.dzB != -1)
    {
      ((MediaFormat)localObject).setInteger("profile", 8);
      ((MediaFormat)localObject).setInteger("level", 32768);
    }
    if (paramamae.cBB)
    {
      ((MediaFormat)localObject).setInteger("profile", 1);
      ((MediaFormat)localObject).setInteger("level", 512);
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "start : encodeConfig = + " + paramamae.toString() + " ; format: " + localObject);
    }
    this.jdField_d_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_d_of_type_AndroidMediaMediaCodec.configure((MediaFormat)localObject, null, null, 1);
    this.a = this.jdField_d_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_d_of_type_AndroidMediaMediaCodec.start();
    localObject = new File(paramamae.outputFilePath);
    if (!((File)localObject).exists()) {
      aqhq.UD(((File)localObject).getAbsolutePath());
    }
    if (paramamae.jdField_a_of_type_Amaq == null)
    {
      this.jdField_b_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramamae.outputFilePath, 0);
      this.jdField_b_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramamae.orientation);
    }
    for (;;)
    {
      if (paramamae.jdField_a_of_type_Amai != null) {
        this.jdField_b_of_type_Amai = paramamae.jdField_a_of_type_Amai;
      }
      this.mTrackIndex = -1;
      this.mMuxerStarted = false;
      return;
      this.jdField_b_of_type_Amaq = paramamae.jdField_a_of_type_Amaq;
      this.jdField_b_of_type_Amaq.jdField_b_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramamae.orientation);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.jdField_b_of_type_Amaq == null)
    {
      if (!this.mMuxerStarted) {
        throw new RuntimeException("muxer hasn't started");
      }
      paramByteBuffer.position(this.mBufferInfo.offset);
      paramByteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
      if (this.jdField_b_of_type_Amai != null)
      {
        paramBufferInfo = new amag.a();
        paramBufferInfo.dBf = this.mTrackIndex;
        Object localObject = ByteBuffer.allocate(this.mBufferInfo.size);
        ((ByteBuffer)localObject).put(paramByteBuffer);
        ((ByteBuffer)localObject).flip();
        paramBufferInfo.u = ((ByteBuffer)localObject);
        localObject = new MediaCodec.BufferInfo();
        ((MediaCodec.BufferInfo)localObject).flags = this.mBufferInfo.flags;
        ((MediaCodec.BufferInfo)localObject).offset = 0;
        ((MediaCodec.BufferInfo)localObject).presentationTimeUs = this.mBufferInfo.presentationTimeUs;
        ((MediaCodec.BufferInfo)localObject).size = this.mBufferInfo.size;
        paramBufferInfo.d = ((MediaCodec.BufferInfo)localObject);
        this.jdField_b_of_type_Amai.a(paramBufferInfo);
        paramByteBuffer.rewind();
        paramByteBuffer.position(this.mBufferInfo.offset);
        paramByteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
      }
      this.jdField_b_of_type_AndroidMediaMediaMuxer.writeSampleData(this.mTrackIndex, paramByteBuffer, this.mBufferInfo);
      return;
    }
    this.jdField_b_of_type_Amaq.writeSampleData(0, paramByteBuffer, paramBufferInfo);
  }
  
  public void dLU()
  {
    drainEncoder(false);
  }
  
  public void f(MediaFormat paramMediaFormat)
  {
    if (QLog.isColorLevel()) {
      if (this.jdField_b_of_type_Amaq != null) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("HWVideoEncoder", 2, new Object[] { "setOutputFormat, ", Boolean.valueOf(bool) });
      if (this.jdField_b_of_type_Amaq != null) {
        break label116;
      }
      if (!this.mMuxerStarted) {
        break;
      }
      throw new RuntimeException("format changed twice");
    }
    this.mTrackIndex = this.jdField_b_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_d_of_type_AndroidMediaMediaFormat);
    this.jdField_b_of_type_AndroidMediaMediaMuxer.start();
    this.mMuxerStarted = true;
    if (this.jdField_b_of_type_Amai != null) {
      this.jdField_b_of_type_Amai.e(this.jdField_d_of_type_AndroidMediaMediaFormat);
    }
    return;
    label116:
    this.jdField_b_of_type_Amaq.a(0, paramMediaFormat);
  }
  
  public Surface getInputSurface()
  {
    return this.a;
  }
  
  public void release()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "HWVideoEncoder release.");
    }
    if (this.jdField_d_of_type_AndroidMediaMediaCodec != null) {}
    try
    {
      this.jdField_d_of_type_AndroidMediaMediaCodec.stop();
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoEncoder", 2, "MediaCodec stop.");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_d_of_type_AndroidMediaMediaCodec.release();
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "MediaCodec release.");
          }
          this.jdField_d_of_type_AndroidMediaMediaCodec = null;
          if ((this.jdField_b_of_type_Amaq != null) || (this.jdField_b_of_type_AndroidMediaMediaMuxer == null)) {
            break label237;
          }
          try
          {
            if (this.mMuxerStarted)
            {
              this.mMuxerStarted = false;
              this.jdField_b_of_type_AndroidMediaMediaMuxer.stop();
              if (QLog.isColorLevel()) {
                QLog.d("HWVideoEncoder", 2, "MediaMuxer stop.");
              }
            }
            this.jdField_b_of_type_AndroidMediaMediaMuxer.release();
            if (QLog.isColorLevel()) {
              QLog.d("HWVideoEncoder", 2, "MediaMuxer release.");
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              QLog.w("HWVideoEncoder", 2, "Muxer stop exception:" + localException3);
            }
          }
          this.jdField_b_of_type_AndroidMediaMediaMuxer = null;
          return;
          localException1 = localException1;
          QLog.w("HWVideoEncoder", 2, "mEncoder stop exception:" + localException1);
        }
      }
      catch (Exception localException2)
      {
        label237:
        do
        {
          for (;;)
          {
            QLog.w("HWVideoEncoder", 2, "mEncoder release exception:" + localException2);
          }
        } while (this.jdField_b_of_type_Amaq == null);
        QLog.d("HWVideoEncoder", 1, "HWVideoEncoder release");
        this.jdField_b_of_type_Amaq.release();
      }
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "HWVideoEncoder stop.");
    }
    drainEncoder(true);
    release();
  }
  
  public class a
  {
    public MediaCodec.BufferInfo d;
    public int dBf;
    public ByteBuffer u;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amag
 * JD-Core Version:    0.7.0.1
 */