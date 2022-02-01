import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

@TargetApi(18)
public class amaj
{
  private HandlerThread G = ThreadManagerV2.newFreeHandlerThread("HWAudioEncoder", 0);
  private String JV;
  private long Sf;
  amaj.b jdField_a_of_type_Amaj$b;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private long aio;
  private int azw;
  private int bth;
  private MediaCodec.BufferInfo c = new MediaCodec.BufferInfo();
  private Handler cD;
  private double cR;
  private MediaMuxer mMediaMuxer;
  private boolean mMuxerStarted;
  
  public amaj()
  {
    this.G.start();
    this.cD = new amaj.a(this.G.getLooper(), this);
  }
  
  private void Pu(String paramString)
    throws IOException
  {
    this.JV = paramString;
    this.jdField_a_of_type_AndroidMediaMediaFormat = new MediaFormat();
    this.jdField_a_of_type_AndroidMediaMediaFormat.setString("mime", "audio/mp4a-latm");
    int i;
    if (aniq.ckG == 16)
    {
      i = 1;
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-count", i);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("sample-rate", this.bth);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", 2);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("bitrate", aniq.dHj);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", AudioCapture.BUF_SIZE);
      this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, 1);
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      paramString = new File(this.JV);
      if (!paramString.exists()) {
        aqhq.UD(paramString.getAbsolutePath());
      }
      this.mMediaMuxer = new MediaMuxer(this.JV, 0);
      this.azw = 0;
      this.mMuxerStarted = false;
      this.Sf = 0L;
      this.c = new MediaCodec.BufferInfo();
      this.aio = 0L;
      if (aniq.mAudioFormat != 2) {
        break label239;
      }
    }
    label239:
    for (int j = 16;; j = 8)
    {
      this.cR = (i * (j * this.bth) / 8 / Math.pow(10.0D, 6.0D));
      return;
      i = 2;
      break;
    }
  }
  
  private void dLV() {}
  
  public void Ui(int paramInt)
  {
    this.bth = paramInt;
  }
  
  public void a(amaj.b paramb)
  {
    this.jdField_a_of_type_Amaj$b = paramb;
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int i = (int)(paramArrayOfByte.length / this.cR);
    this.aio += i;
    if (QLog.isColorLevel()) {
      QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame audioData=%s mAudioDataSize=%s frameTime=%s mLastAudioFrameTime=%s timestampNanos=%s endOfStream=&s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Double.valueOf(this.cR), Integer.valueOf(i), Long.valueOf(this.aio), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    }
    i = 0;
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
    int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (QLog.isColorLevel()) {
      QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame inputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
    }
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      ((ByteBuffer)localObject).put(paramArrayOfByte);
      this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(j, 0, paramArrayOfByte.length, this.aio, 0);
      label204:
      i = 0;
      paramArrayOfByte = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    }
    label215:
    do
    {
      for (;;)
      {
        j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.c, 10000L);
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
        }
        if (j == -1)
        {
          if (!paramBoolean) {}
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
            }
            return;
            if (j != -1) {
              break;
            }
            if (!paramBoolean) {
              break label204;
            }
            j = i + 1;
            i = j;
            if (j <= 10) {
              break;
            }
            break label204;
            j = i + 1;
            i = j;
            if (j <= 10) {
              break label215;
            }
          }
        }
        if (j == -2)
        {
          localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          this.azw = this.mMediaMuxer.addTrack((MediaFormat)localObject);
          if (!this.mMuxerStarted)
          {
            this.mMediaMuxer.start();
            this.mMuxerStarted = true;
          }
        }
        else
        {
          if (j != -3) {
            break label435;
          }
          paramArrayOfByte = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        }
      }
    } while (j < 0);
    label280:
    label435:
    i = 0;
    localObject = paramArrayOfByte[j];
    if ((this.c.flags & 0x2) != 0) {
      this.c.size = 0;
    }
    if ((this.c.size != 0) && (this.mMuxerStarted))
    {
      ((ByteBuffer)localObject).position(this.c.offset);
      ((ByteBuffer)localObject).limit(this.c.offset + this.c.size);
      if (QLog.isColorLevel()) {
        QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame presentationTimeUs=%s", new Object[] { Long.valueOf(this.c.presentationTimeUs) }));
      }
      if (this.c.presentationTimeUs < this.Sf) {
        break label623;
      }
      this.mMediaMuxer.writeSampleData(this.azw, (ByteBuffer)localObject, this.c);
      this.Sf = this.c.presentationTimeUs;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
      if ((this.c.flags & 0x4) == 0) {
        break;
      }
      break label280;
      label623:
      QLog.e("HWAudioEncoder", 1, "handleAudioFrame audio timestamp revert? throw this frame.");
    }
  }
  
  void handleStop()
  {
    if (this.cD != null) {
      this.cD.removeCallbacksAndMessages(null);
    }
    long l = SystemClock.elapsedRealtimeNanos();
    b(new byte[0], l, true);
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if ((this.mMediaMuxer != null) && (this.mMuxerStarted)) {
      this.mMuxerStarted = false;
    }
    try
    {
      this.mMediaMuxer.release();
      if (QLog.isColorLevel()) {
        QLog.d("HWAudioEncoder", 2, "MediaMuxer stop.");
      }
      if (this.jdField_a_of_type_Amaj$b != null) {
        this.jdField_a_of_type_Amaj$b.dKc();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (this.jdField_a_of_type_Amaj$b != null) {
        this.jdField_a_of_type_Amaj$b.dKd();
      }
      return;
    }
    finally
    {
      this.mMediaMuxer = null;
    }
  }
  
  public void j(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.cD != null)
    {
      paramLong = SystemClock.elapsedRealtimeNanos();
      this.cD.obtainMessage(1, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
  
  public void onStart(String paramString)
  {
    if (this.cD != null) {
      this.cD.obtainMessage(3, paramString).sendToTarget();
    }
  }
  
  public void onStop()
  {
    if (this.cD != null) {
      this.cD.obtainMessage(2).sendToTarget();
    }
  }
  
  public void release()
  {
    if (this.cD != null)
    {
      this.cD.removeCallbacksAndMessages(null);
      this.cD = null;
    }
    if (this.G != null)
    {
      this.G.quit();
      this.G = null;
      this.cD = null;
    }
  }
  
  class a
    extends Handler
  {
    protected WeakReference<amaj> hI;
    
    public a(Looper paramLooper, amaj paramamaj)
    {
      super();
      this.hI = new WeakReference(paramamaj);
    }
    
    public void handleMessage(Message paramMessage)
    {
      amaj localamaj = (amaj)this.hI.get();
      if (localamaj == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("HWAudioEncoder", 2, "AudioEncodeHandler.handleMessage: encoder is null");
        }
        return;
      }
      int i = paramMessage.what;
      switch (i)
      {
      default: 
        throw new RuntimeException("Unhandled msg what=" + i);
      case 1: 
        paramMessage = (Object[])paramMessage.obj;
        try
        {
          localamaj.b((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
          return;
        }
        catch (Exception paramMessage)
        {
          QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
          amaj.a(amaj.this);
          return;
        }
      case 2: 
        amaj.this.handleStop();
        return;
      case 3: 
        paramMessage = (String)paramMessage.obj;
        try
        {
          amaj.a(amaj.this, paramMessage);
          return;
        }
        catch (Exception paramMessage)
        {
          QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
          amaj.a(amaj.this);
          return;
        }
      }
      amaj.this.release();
    }
  }
  
  public static abstract interface b
  {
    public abstract void dKc();
    
    public abstract void dKd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amaj
 * JD-Core Version:    0.7.0.1
 */