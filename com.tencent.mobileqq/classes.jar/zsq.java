import android.view.View;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class zsq
  implements bhqd
{
  zsq(zsn paramzsn, MessageForDevLittleVideo paramMessageForDevLittleVideo, afwt paramafwt, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    }
    boolean bool;
    label64:
    do
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
      bool = bdee.g(this.jdField_a_of_type_Zsn.a.getApplication().getApplicationContext());
      paramView = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
      if (!bool) {
        break;
      }
      paramInt = 2002;
      paramView.videoFileStatus = paramInt;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress = 0;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.serial();
      this.jdField_a_of_type_Zsn.a.a().a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.frienduin, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.istroop, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.msgData);
    } while (!bool);
    if (!bdcs.b(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.mThumbFilePath)) {
      this.jdField_a_of_type_Zsn.c(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (!bdcs.b(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileName))
      {
        this.jdField_a_of_type_Zsn.b(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
        paramInt = i;
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label235;
        }
        this.jdField_a_of_type_Afwt.a.setFailedIconVisable(false, this.jdField_a_of_type_Zsn);
        zsn.b(this.jdField_a_of_type_Zsn, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo, this.jdField_a_of_type_Afwt, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress, false);
        break;
        paramInt = 2005;
        break label64;
      }
      label235:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zsq
 * JD-Core Version:    0.7.0.1
 */