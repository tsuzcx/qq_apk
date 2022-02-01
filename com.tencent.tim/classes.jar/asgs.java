import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.a;
import com.tencent.util.Pair;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class asgs
  extends asgt
{
  private asgs.a a;
  public AudioDecoder.a a;
  private HandlerThread ae;
  private AudioTrack mAudioTrack;
  
  public asgs(asgt.b paramb, asgt.a parama, AudioDecoder.a parama1)
  {
    super(paramb, parama);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a = new AudioDecoder.a();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.b(parama1);
  }
  
  private AudioTrack a()
  {
    int j = 3;
    AudioTrack localAudioTrack;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.a.dII == 1)
        {
          i = 4;
          if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.a.dIH == 16) {
            j = 2;
          }
          int k = AudioTrack.getMinBufferSize(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.a.sample_rate, i, j);
          localAudioTrack = new AudioTrack(3, this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.a.sample_rate, i, j, k, 1);
        }
      }
      catch (Throwable localThrowable1)
      {
        int i;
        localAudioTrack = null;
      }
      try
      {
        localAudioTrack.play();
        return localAudioTrack;
      }
      catch (Throwable localThrowable2)
      {
        break label94;
      }
      i = 12;
    }
    label94:
    ram.e("Q.qqstory.mediadecoderMediaCodecAudioRender", "AudioTrack init fail :%s", localThrowable1);
    return localAudioTrack;
  }
  
  private void a(AudioTrack paramAudioTrack, byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    switch (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.speedType)
    {
    default: 
      if (!this.jdField_a_of_type_Asgt$b.mMuteAudio) {
        paramAudioTrack.write(paramArrayOfByte, 0, paramInt);
      }
      paramInt = 1;
      paramArrayOfByte = null;
      i = 0;
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Asgt$b.mMuteAudio) && (paramInt == 0) && (paramArrayOfByte != null)) {
        paramAudioTrack.write(paramArrayOfByte, 0, i);
      }
      return;
      i = paramArrayOfByte.length / 2;
      byte[] arrayOfByte = new byte[i];
      ayzb.b(paramArrayOfByte, 0, arrayOfByte, i);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 2;
      arrayOfByte = new byte[i];
      ayzb.a(paramArrayOfByte, 0, arrayOfByte, i, 2);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 2 / 3;
      arrayOfByte = new byte[i];
      ayzb.e(paramArrayOfByte, 0, arrayOfByte, i);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 4;
      arrayOfByte = new byte[i];
      ayzb.a(paramArrayOfByte, 0, arrayOfByte, i, 4);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
    }
  }
  
  protected String DQ()
  {
    return "Q.qqstory.mediadecoderMediaCodecAudioRender";
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((paramBufferInfo.flags & 0x4) != 0)
      {
        ram.d("Q.qqstory.mediadecoderMediaCodecAudioRender", "output EOS");
        this.der = true;
      }
      break;
    }
    for (;;)
    {
      paramMediaCodec.releaseOutputBuffer(i, false);
      return;
      ram.d("Q.qqstory.mediadecoderMediaCodecAudioRender", "INFO_OUTPUT_BUFFERS_CHANGED");
      this.mOutputBuffers = paramMediaCodec.getOutputBuffers();
      return;
      ram.d("Q.qqstory.mediadecoderMediaCodecAudioRender", "New format " + paramMediaCodec.getOutputFormat());
      return;
      ram.d("Q.qqstory.mediadecoderMediaCodecAudioRender", "dequeueOutputBuffer timed out!");
      return;
      try
      {
        localObject = this.mOutputBuffers[i];
        if (localObject == null)
        {
          ram.e("Q.qqstory.mediadecoderMediaCodecAudioRender", "find no data");
          return;
        }
      }
      catch (Exception paramMediaCodec)
      {
        ram.e("Q.qqstory.mediadecoderMediaCodecAudioRender", "handle data error :%s", paramMediaCodec);
        return;
      }
      if (paramBufferInfo.size != 0)
      {
        ((ByteBuffer)localObject).position(paramBufferInfo.offset);
        ((ByteBuffer)localObject).limit(paramBufferInfo.offset + paramBufferInfo.size);
      }
      int j = ((ByteBuffer)localObject).remaining();
      paramBufferInfo = new byte[j];
      ((ByteBuffer)localObject).get(paramBufferInfo, 0, j);
      Object localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = new Pair(paramBufferInfo, Integer.valueOf(j));
      this.jdField_a_of_type_Asgs$a.sendMessage((Message)localObject);
    }
  }
  
  protected void a(asgt.a parama, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    try
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.a.dII = paramMediaFormat.getInteger("channel-count");
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.a.sample_rate = ron.a(paramMediaFormat);
      ram.d("Q.qqstory.mediadecoderMediaCodecAudioRender", "config after b=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.a.bitrate + " c=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.a.dII + " sc=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.a.sample_rate);
      paramMediaCodec.configure(paramMediaFormat, null, null, 0);
      this.mAudioTrack = a();
      this.ae = new HandlerThread("mc_audio_thread");
      this.ae.start();
      this.jdField_a_of_type_Asgs$a = new asgs.a(this.ae.getLooper());
      return;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        parama.printStackTrace();
      }
    }
  }
  
  public void eno()
  {
    super.eno();
    this.mAudioTrack.play();
  }
  
  public void onRelease()
  {
    super.onRelease();
    if (this.mAudioTrack != null)
    {
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
    if (this.ae != null)
    {
      this.ae.getLooper().quit();
      this.ae = null;
      this.jdField_a_of_type_Asgs$a = null;
    }
  }
  
  public long seekInLoop(long paramLong)
  {
    this.mAudioTrack.flush();
    return super.seekInLoop(paramLong);
  }
  
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      paramMessage = (Pair)paramMessage.obj;
      asgs.a(asgs.this, asgs.a(asgs.this), (byte[])paramMessage.first, ((Integer)paramMessage.second).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgs
 * JD-Core Version:    0.7.0.1
 */