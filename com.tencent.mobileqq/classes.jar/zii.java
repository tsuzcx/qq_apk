import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.utils.GVideoGrayConfig.GVideoGrayConfigListener;
import com.tencent.av.utils.GVideoGrayConfig.Record;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.groupvideo.GroupVideoWrapper;

public class zii
  implements GVideoGrayConfig.GVideoGrayConfigListener
{
  public zii(QQGAudioMsgHandler paramQQGAudioMsgHandler, long paramLong1, int paramInt, long paramLong2) {}
  
  public void a(int paramInt1, GVideoGrayConfig.Record paramRecord, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(3, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, 20, 1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(this.jdField_a_of_type_Long, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, Long.valueOf(this.jdField_a_of_type_Long).longValue(), 0L);
      }
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, false, Long.toString(this.jdField_a_of_type_Long), Long.toString(this.b), false, null, false, this.jdField_a_of_type_Int, new Object[0]);
      if (this.jdField_a_of_type_Int == 2) {
        new GroupVideoWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(new zij(this));
      }
    }
    else
    {
      return;
    }
    new QavWrapper(BaseApplication.getContext()).a(new zik(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zii
 * JD-Core Version:    0.7.0.1
 */