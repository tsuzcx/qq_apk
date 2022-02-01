import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@TargetApi(18)
public class amak
{
  private amak.a jdField_a_of_type_Amak$a;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig;
  private final amaq b;
  private boolean cBI;
  private volatile boolean cBJ;
  private volatile boolean cBK;
  private ByteBuffer mBuffer;
  private final MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
  private int mBufferSize = 1024;
  private long mEndTime;
  private MediaExtractor mExtractor;
  
  static
  {
    if (!amak.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public amak(DecodeConfig paramDecodeConfig, amaq paramamaq)
  {
    this.b = paramamaq;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = paramDecodeConfig;
    this.mEndTime = (paramDecodeConfig.endTimeMillSecond * 1000L);
    try
    {
      this.mExtractor = new MediaExtractor();
      this.mExtractor.setDataSource(paramDecodeConfig.inputFilePath);
      this.jdField_a_of_type_Amak$a = a(this.mExtractor);
      if (this.jdField_a_of_type_Amak$a.azw >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioRecoder", 1, "audio track normal");
        }
        this.b.a(1, this.jdField_a_of_type_Amak$a.e);
        this.mExtractor.selectTrack(this.jdField_a_of_type_Amak$a.azw);
        if (this.jdField_a_of_type_Amak$a.e.containsKey("max-input-size")) {
          this.mBufferSize = this.jdField_a_of_type_Amak$a.e.getInteger("max-input-size");
        }
        if (this.jdField_a_of_type_Amak$a.dBh >= 0)
        {
          this.b.Uj(2);
          this.b.a(2, this.jdField_a_of_type_Amak$a.f);
          this.mExtractor.selectTrack(this.jdField_a_of_type_Amak$a.dBh);
          if (this.jdField_a_of_type_Amak$a.f.containsKey("max-input-size"))
          {
            int i = this.jdField_a_of_type_Amak$a.f.getInteger("max-input-size");
            if (i > this.mBufferSize) {
              this.mBufferSize = i;
            }
          }
        }
      }
      for (;;)
      {
        this.mBuffer = ByteBuffer.allocateDirect(this.mBufferSize).order(ByteOrder.nativeOrder());
        this.mExtractor.seekTo(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.startTimeMillSecond * 1000L, 0);
        return;
        this.b.Uj(0);
        this.b.a(1, null);
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioRecoder", 1, "no audio track");
        }
      }
      return;
    }
    catch (Exception paramDecodeConfig)
    {
      QLog.e("HWAudioRecoder", 1, "getAudioTrack,", paramDecodeConfig);
    }
  }
  
  public amak.a a(MediaExtractor paramMediaExtractor)
  {
    amak.a locala = new amak.a();
    int j = paramMediaExtractor.getTrackCount();
    long l2 = 0L;
    int i = 0;
    MediaFormat localMediaFormat;
    String str;
    long l1;
    if (i < j)
    {
      localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      str = localMediaFormat.getString("mime");
      l1 = l2;
      if (locala.azw >= 0) {
        break label206;
      }
      l1 = l2;
      if (!str.startsWith("audio/")) {
        break label206;
      }
      l2 += 1L;
      if (l2 == 1L)
      {
        locala.azw = i;
        locala.bZG = str;
        locala.e = localMediaFormat;
        label99:
        l1 = l2;
        if (l2 < 2L) {
          break label206;
        }
      }
    }
    else
    {
      if (locala.azw < 0) {
        break label217;
      }
    }
    label206:
    label217:
    for (boolean bool = true;; bool = false)
    {
      this.cBI = bool;
      QLog.d("HWAudioRecoder", 1, new Object[] { "getAudioTrack, ", Integer.valueOf(locala.azw), " ", Integer.valueOf(locala.dBh) });
      return locala;
      if (l2 != 2L) {
        break label99;
      }
      locala.dBh = i;
      locala.bZH = str;
      locala.f = localMediaFormat;
      break label99;
      i += 1;
      l2 = l1;
      break;
    }
  }
  
  public boolean avd()
  {
    int i = 2;
    if ((!this.cBI) || (isFinished())) {
      return false;
    }
    int j = this.mExtractor.getSampleTrackIndex();
    if (j < 0)
    {
      this.mBuffer.clear();
      this.mBufferInfo.set(0, 0, 0L, 4);
      this.b.writeSampleData(1, this.mBuffer, this.mBufferInfo);
      this.b.writeSampleData(2, this.mBuffer, this.mBufferInfo);
      this.cBJ = true;
      this.cBK = true;
      return true;
    }
    if (j == this.jdField_a_of_type_Amak$a.azw) {
      i = 1;
    }
    int k;
    long l;
    while (j == this.jdField_a_of_type_Amak$a.dBh)
    {
      this.mBuffer.clear();
      k = this.mExtractor.readSampleData(this.mBuffer, 0);
      l = this.mExtractor.getSampleTime();
      if (($assertionsDisabled) || (k <= this.mBufferSize)) {
        break;
      }
      throw new AssertionError();
    }
    return false;
    if ((k < 0) || ((this.mEndTime > 0L) && (l > this.mEndTime)))
    {
      this.mBuffer.clear();
      this.mBufferInfo.set(0, 0, 0L, 4);
      this.b.writeSampleData(i, this.mBuffer, this.mBufferInfo);
      if (j == this.jdField_a_of_type_Amak$a.azw)
      {
        this.cBJ = true;
        return true;
      }
      this.cBK = true;
      return true;
    }
    if ((this.mExtractor.getSampleFlags() & 0x1) != 0)
    {
      j = 1;
      if (j == 0) {
        break label322;
      }
    }
    label322:
    for (j = 1;; j = 0)
    {
      this.mBufferInfo.set(0, k, this.mExtractor.getSampleTime(), j);
      this.b.writeSampleData(i, this.mBuffer, this.mBufferInfo);
      this.mExtractor.advance();
      return true;
      j = 0;
      break;
    }
  }
  
  public boolean isFinished()
  {
    if (!this.cBI) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_Amak$a.dBh < 0) {
        return this.cBJ;
      }
    } while ((this.cBJ) && (this.cBK));
    return false;
  }
  
  public void stopRecording()
  {
    QLog.d("HWAudioRecoder", 1, "stopRecording audio");
    while ((!isFinished()) && (avd())) {}
    QLog.d("HWAudioRecoder", 1, "stopRecording audio, indeed");
    this.b.release();
    if (this.mExtractor != null)
    {
      this.mExtractor.release();
      this.mExtractor = null;
    }
  }
  
  public static class a
  {
    public int azw = -1;
    public String bZG;
    public String bZH;
    public int dBh = -1;
    public MediaFormat e;
    public MediaFormat f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amak
 * JD-Core Version:    0.7.0.1
 */