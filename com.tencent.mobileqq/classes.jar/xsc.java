import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.qphone.base.util.QLog;

public class xsc
  implements Runnable
{
  private SVHwEncoder jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  
  public xsc(NewFlowCameraActivity paramNewFlowCameraActivity, SVHwEncoder paramSVHwEncoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = paramSVHwEncoder;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mEncoderCache=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsc
 * JD-Core Version:    0.7.0.1
 */