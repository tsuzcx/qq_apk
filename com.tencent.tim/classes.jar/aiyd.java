import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class aiyd
  extends aiyc
{
  public DecoderUtil a;
  public int bqG;
  public int[] colors;
  public int dgJ;
  public int dgK;
  public int dgL;
  public int dgM = -1;
  public int dgN = -1;
  public byte[] eF;
  public byte[] eG;
  public byte[] eH = new byte[51200];
  public byte[] eI;
  public byte[] eJ = new byte[51200];
  public byte[] eK;
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  public aiyd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder begins");
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends");
    }
  }
  
  public int[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = 0;
    if (j < this.colors.length)
    {
      int m = j * 3;
      int k = paramArrayOfByte2[m] & 0xFF;
      int i;
      if (k <= 50) {
        i = 0;
      }
      for (;;)
      {
        this.colors[j] = (i << 24 & 0xFF000000 | paramArrayOfByte1[(m + 2)] << 16 & 0xFF0000 | paramArrayOfByte1[(m + 1)] << 8 & 0xFF00 | paramArrayOfByte1[m] & 0xFF);
        j += 1;
        break;
        i = k;
        if (k >= 235) {
          i = 255;
        }
      }
    }
    return this.colors;
  }
  
  public void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.eH.length < paramInt1)
    {
      this.eH = new byte[paramInt1];
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceFFMepgDecoder", 2, "videoFrame.length = " + this.eH.length + "new framelength = " + paramInt1);
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.eH, 0, paramInt1);
  }
  
  public void c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.eJ.length < paramInt1)
    {
      this.eJ = new byte[paramInt1];
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceFFMepgDecoder", 2, "alphaFrame.length = " + this.eJ.length + " new fillFrameAlpha = " + paramInt1);
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.eJ, 0, paramInt1);
  }
  
  public void dvr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func maigcfaceDecoder begins:,isStartDecodr:" + this.cmH);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
        if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder() == 0) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder() != 0)) {}
        this.eG = this.jdField_a_of_type_Aiyb.eG;
        byte[] arrayOfByte1 = this.eG;
        if (arrayOfByte1 != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicfaceFFMepgDecoder", 2, "===MagicfaceDecoder=Exception==" + localException.getMessage());
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError4) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError4.getMessage());
        return;
        i = 1;
        l2 = 0L;
        if (!this.cmH) {
          continue;
        }
        l1 = System.currentTimeMillis();
        j = h(this.eG, this.bqG);
        this.dgJ = (j - this.bqG);
        k = this.dgJ;
        if (k > 0) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError5) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError5.getMessage());
        return;
        b(this.dgJ, this.bqG, this.eG);
        this.bqG = j;
        l3 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoder(this.eH, this.dgJ, this.eI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicfaceFFMepgDecoder", 2, "decodeVideoDecoder==usetime=" + (System.currentTimeMillis() - l3) + "==videoFrameLength==" + this.dgJ);
        try
        {
          if (this.videoWidth == -1)
          {
            this.videoWidth = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
            this.videoHeight = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
            if ((this.videoWidth > 500) || (this.videoHeight > 500))
            {
              this.videoWidth = -1;
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
                continue;
              }
              try
              {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
                return;
              }
              catch (UnsatisfiedLinkError localUnsatisfiedLinkError6) {}
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError6.getMessage());
              return;
            }
            this.colors = new int[this.videoHeight * this.videoWidth];
          }
          j = h(this.eF, this.dgL);
          this.dgK = (j - this.dgL);
          c(this.dgK, this.dgL, this.eF);
          this.dgL = j;
          l3 = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoder(this.eJ, this.dgK, this.eK);
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "decodeAlphaDecoder==usetime=" + (System.currentTimeMillis() - l3) + "==alphaFrameLength==" + this.dgK);
          }
          l3 = System.currentTimeMillis();
          arrayOfInt = a(this.eI, this.eK);
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "convertByteToColor==usetime=" + (System.currentTimeMillis() - l3));
          }
          if (this.jdField_a_of_type_Aiyc$b != null) {
            this.jdField_a_of_type_Aiyc$b.b(arrayOfInt, this.videoWidth, this.videoHeight);
          }
          l3 = System.currentTimeMillis() - l1;
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "==============frameTime=============" + l3);
          }
          if (l3 >= this.dgI) {
            continue;
          }
          if (l2 <= 0L) {
            continue;
          }
          l1 = this.dgI - l3;
          if (l1 <= l2) {
            continue;
          }
          Thread.sleep(l1 - l2);
          l1 = l2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MagicfaceFFMepgDecoder", 2, "magicfaceffMepgDecoder outofMemoryError");
          }
          this.videoWidth = -1;
          System.gc();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError7) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError7.getMessage());
        return;
        l1 = l2 - l1;
        break label1186;
        Thread.sleep(this.dgI - l3);
        l1 = l2;
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        localOutOfMemoryError3.printStackTrace();
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError8) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError8.getMessage());
        return;
        l1 = l2;
        if (i != 0) {
          break label1186;
        }
        i = this.dgI;
        l1 = l2 + (l3 - i);
      }
      finally
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          break label1161;
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError1.getMessage());
        return;
      }
      this.eF = this.jdField_a_of_type_Aiyb.eF;
      arrayOfByte2 = this.eF;
      if (arrayOfByte2 == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
            return;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2) {}
          if (QLog.isColorLevel()) {
            QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError2.getMessage());
          }
        }
      }
      else {
        try
        {
          this.eI = new byte[480000];
          this.eK = new byte[480000];
          byte[] arrayOfByte3 = this.eI;
          if (arrayOfByte3 == null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
              continue;
            }
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
              return;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError3) {}
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError3.getMessage());
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localOutOfMemoryError1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends, OOM.");
          }
        }
      }
    }
    for (;;)
    {
      long l1;
      try
      {
        int j;
        int k;
        long l3;
        int[] arrayOfInt;
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
        label1161:
        throw localObject;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError9)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError9.getMessage());
        continue;
      }
      label1186:
      int i = 0;
      long l2 = l1;
    }
  }
  
  public int h(byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    if (paramInt == paramArrayOfByte.length) {
      i = -1;
    }
    do
    {
      return i;
      int j = paramInt + 1;
      int k = 0;
      int m = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
      i = k;
      paramInt = j;
      if (m != 7)
      {
        i = k;
        paramInt = j;
        if (m != 8)
        {
          i = 1;
          paramInt = j;
        }
      }
      while (paramInt < paramArrayOfByte.length - 4) {
        if ((paramArrayOfByte[paramInt] == 0) && (paramArrayOfByte[(paramInt + 1)] == 0) && (paramArrayOfByte[(paramInt + 2)] == 0) && (paramArrayOfByte[(paramInt + 3)] == 1))
        {
          j = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
          if ((j != 7) && (j != 8))
          {
            if (i != 0) {
              break;
            }
            paramInt += 1;
            i = 1;
          }
          else
          {
            paramInt += 1;
          }
        }
        else
        {
          paramInt += 1;
        }
      }
      i = paramInt;
    } while (paramInt != paramArrayOfByte.length - 4);
    return paramArrayOfByte.length;
  }
  
  protected void init()
  {
    this.cmH = false;
  }
  
  protected void reSet()
  {
    super.reSet();
    this.bqG = 0;
    this.dgL = 0;
  }
  
  public void release()
  {
    super.release();
    this.eH = null;
    this.eJ = null;
    this.eK = null;
    this.eI = null;
    this.colors = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyd
 * JD-Core Version:    0.7.0.1
 */