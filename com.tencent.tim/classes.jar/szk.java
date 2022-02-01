import android.view.View;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class szk
  implements ausj.a
{
  szk(szh paramszh, MessageForDevLittleVideo paramMessageForDevLittleVideo, ShortVideoRealItemBuilder.a parama, ausj paramausj) {}
  
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
      this.val$actionSheet.dismiss();
      return;
      bool = aqiw.isNetworkAvailable(this.this$0.app.getApplication().getApplicationContext());
      paramView = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
      if (!bool) {
        break;
      }
      paramInt = 2002;
      paramView.videoFileStatus = paramInt;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress = 0;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.serial();
      this.this$0.app.b().c(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.frienduin, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.istroop, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.msgData);
    } while (!bool);
    if (!aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.mThumbFilePath)) {
      this.this$0.c(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (!aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileName))
      {
        this.this$0.b(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
        paramInt = i;
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label235;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$a.a.setFailedIconVisable(false, this.this$0);
        szh.b(this.this$0, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$a, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress, false);
        break;
        paramInt = 2005;
        break label64;
      }
      label235:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szk
 * JD-Core Version:    0.7.0.1
 */