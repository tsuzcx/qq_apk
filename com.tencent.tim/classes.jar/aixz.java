import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder.1;
import com.tencent.qphone.base.util.QLog;

public class aixz
  extends aiyd
{
  private Runnable gW = new MagicFaceSuperBigDecoder.1(this);
  
  public aixz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func MagicFaceSuperBigDecoder [Constructor] begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
    int i = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder();
    int j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder();
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func MagicFaceSuperBigDecoder [Constructor] ends, videoRet:" + i + ",alphaRet:" + j);
    }
  }
  
  public void dvr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder begins");
    }
    this.eG = this.jdField_a_of_type_Aiyb.eG;
    if (this.eG == null) {}
    do
    {
      do
      {
        return;
        this.eF = this.jdField_a_of_type_Aiyb.eF;
      } while (this.eF == null);
      dvs();
      this.gW.run();
    } while (!QLog.isColorLevel());
    QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder ends");
  }
  
  protected void dvs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig begins");
    }
    try
    {
      this.eI = new byte[817920];
      this.eK = new byte[817920];
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig ends");
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  public void release()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func release begins.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
      label37:
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = null;
      super.release();
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceSuperBigDecoder", 2, "func release ends.");
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixz
 * JD-Core Version:    0.7.0.1
 */