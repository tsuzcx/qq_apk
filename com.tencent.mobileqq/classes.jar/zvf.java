import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewPresenter;

public class zvf
  implements Runnable
{
  public zvf(ARVideoRecordUIControllerImpl paramARVideoRecordUIControllerImpl, int paramInt) {}
  
  public void run()
  {
    if (ARVideoRecordUIControllerImpl.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl) != null) {
      ARVideoRecordUIControllerImpl.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl).a(0);
    }
    if (this.jdField_a_of_type_Int == 0) {
      if (ARVideoRecordUIControllerImpl.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl) != -1) {
        switch (ARVideoRecordUIControllerImpl.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl))
        {
        case 5: 
        default: 
          ARVideoRecordUIControllerImpl.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl, -1);
        }
      }
    }
    for (;;)
    {
      ARVideoRecordUIControllerImpl.b(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl, false);
      if (!ARVideoRecordUIControllerImpl.c(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl)) {
        ARVideoRecordUIControllerImpl.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl);
      }
      return;
      ARVideoRecordUIControllerImpl.a("0X8008A56");
      ARRecordUtils.a("AR视频已保存", "录制的AR视频已保存至“相册”，可在手机“相册”中查看。");
      break;
      ARRecordUtils.a("录制的AR视频已保存至“相册”", true);
      break;
      ARVideoRecordUIControllerImpl.a("0X8008A56");
      ARRecordUtils.a("录制的AR视频已保存至“相册”", true);
      break;
      if (ARVideoRecordUIControllerImpl.b(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl) == true)
      {
        ARVideoRecordUIControllerImpl.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordUIControllerImpl, false);
      }
      else
      {
        ARVideoRecordUIControllerImpl.a("0X8008A56");
        ARRecordUtils.a("录制的AR视频已保存至“相册”", true);
        continue;
        ARVideoRecordUIControllerImpl.a("0X8008A56");
        if (this.jdField_a_of_type_Int == 1) {
          ARRecordUtils.a("AR视频已保存", "已达到最大录屏时间，录制的AR视频已存至“相册”，可在手机“相册”中查看。");
        } else {
          ARRecordUtils.a("AR视频已保存", "手机可用存储空间不足，录制的AR视频已存至“相册”，可在手机“相册”中查看。");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zvf
 * JD-Core Version:    0.7.0.1
 */