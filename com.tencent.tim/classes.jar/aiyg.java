import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder.1;
import com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder.2;
import com.tencent.qphone.base.util.QLog;

public class aiyg
  extends aiyd
{
  public volatile boolean cmJ = false;
  public Object ec = new Object();
  Runnable gX = new MagicfaceXBigDecoder.1(this);
  Runnable gY = new MagicfaceXBigDecoder.2(this);
  public Object object = new Object();
  
  public aiyg()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder init=");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder() == 0) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder() != 0)) {}
  }
  
  public void dvr()
  {
    try
    {
      this.eG = this.jdField_a_of_type_Aiyb.eG;
      if (this.eG == null) {
        return;
      }
      this.eF = this.jdField_a_of_type_Aiyb.eF;
      if (this.eF != null)
      {
        dvs();
        if ((this.eI != null) && (this.eK != null))
        {
          new Thread(this.gY).start();
          this.gX.run();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceXBigDecoder", 2, "Exception=" + localException.toString());
      }
    }
  }
  
  void dvs()
  {
    try
    {
      this.eI = new byte[921600];
      this.eK = new byte[921600];
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void release()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder release=");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
      label37:
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = null;
      super.release();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyg
 * JD-Core Version:    0.7.0.1
 */