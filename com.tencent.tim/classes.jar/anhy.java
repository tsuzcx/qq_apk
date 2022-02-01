import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.a;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.qphone.base.util.QLog;

public class anhy
  implements anic, anid
{
  private final String TAG = "HwEncodeHelper";
  private SVHwEncoder.a jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a = new SVHwEncoder.a();
  private VideoSourceHelper jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper;
  private byte[] audioBuffer;
  private long[] aw = new long[1];
  private SVHwEncoder.a b = new SVHwEncoder.a();
  private boolean cGh;
  private boolean cGi;
  private String cdY;
  private String cdZ;
  private int dGk = 0;
  private byte[] fx;
  
  public anhy(String paramString1, String paramString2, String paramString3)
  {
    this.cdY = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper = new VideoSourceHelper(paramString1, paramString2);
  }
  
  private boolean initMediaBuffer()
  {
    boolean bool = true;
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getBufferSize();
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initMediaBuffer videosize=" + arrayOfInt[0] + ", audiosize=" + arrayOfInt[1]);
      }
      try
      {
        if (this.fx == null) {
          this.fx = new byte[arrayOfInt[0]];
        }
        if (this.audioBuffer == null)
        {
          this.audioBuffer = new byte[arrayOfInt[1]];
          return true;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    return false;
  }
  
  public void E(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEncodeHelper", 4, "svMergeOK() path=" + paramString + ", totalTime=" + paramInt + " mergetime=" + paramLong + " us");
    }
    this.cdZ = paramString;
  }
  
  public int Ju()
  {
    int j = 2;
    if (!anhz.axf()) {
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.initHelperParam() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initHelperParam error");
      }
      return -1;
    }
    if (!initMediaBuffer())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initMediaBuffer error");
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.closeHelper();
      return -1;
    }
    SVHwEncoder localSVHwEncoder = new SVHwEncoder();
    int i;
    if (aniq.ckG == 16)
    {
      i = 1;
      if (aniq.mAudioFormat != 2) {
        break label233;
      }
    }
    for (;;)
    {
      int k = aniq.bth;
      localSVHwEncoder.S(aniq.bth, i, k * i * j * 8, j);
      int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getSourceVideoParam();
      localSVHwEncoder.aF(this.cdY, arrayOfInt[0], arrayOfInt[1]);
      boolean bool = localSVHwEncoder.o(aniq.dHk, aniq.bQi, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.mOrientationDegree);
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "startHwEncode mRecordFrames=" + aniq.dHk + ", mRecordTime=" + aniq.bQi + " successCode=" + bool);
      }
      if (bool) {
        break label238;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.closeHelper();
      return -1;
      i = 2;
      break;
      label233:
      j = 1;
    }
    label238:
    localSVHwEncoder.b(this, this, true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.closeHelper();
    return this.dGk;
  }
  
  public void Tt(int paramInt) {}
  
  public SVHwEncoder.a a()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper != null) && (!this.cGh))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getNextAudioFrame(this.audioBuffer);
      this.b.data = this.audioBuffer;
      this.b.offset = 0;
      this.b.size = i;
      this.b.isVideo = false;
      SVHwEncoder.a locala = this.b;
      if (i > 0) {}
      for (;;)
      {
        locala.finish = bool;
        locala = this.b;
        this.b.bitrate = -1;
        locala.time = -1;
        this.b.zI = -1.0F;
        if (QLog.isColorLevel()) {
          QLog.d("HwEncodeHelper", 4, "getAudioFrame() bufferSize=" + this.audioBuffer.length + ", readSize=" + i);
        }
        this.cGh = this.b.finish;
        return this.b;
        bool = true;
      }
    }
    return null;
  }
  
  public SVHwEncoder.a a(int paramInt)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper != null) && (!this.cGi))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getNextVideoFrame(this.fx, this.aw, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a.data = this.fx;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a.offset = 0;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a.size = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a.isVideo = true;
      SVHwEncoder.a locala = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a;
      if (paramInt > 0) {
        bool = false;
      }
      locala.finish = bool;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a.time = this.aw[0];
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a.bitrate = -1;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a.zI = -1.0F;
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "getVideoFrame() bufferSize=" + this.fx.length + ", readSize=" + paramInt + ", frametime=" + this.aw[0]);
      }
      this.cGi = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a.finish;
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$a;
    }
    return null;
  }
  
  public void dJV() {}
  
  public void dJW() {}
  
  public void js(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEncodeHelper", 4, "svErrorOcured() code=" + paramInt1 + ", subcode=" + paramInt2);
    }
    this.dGk = -1;
  }
  
  public void m(String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void n(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public String zS()
  {
    return this.cdZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhy
 * JD-Core Version:    0.7.0.1
 */