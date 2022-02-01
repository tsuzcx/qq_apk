import android.view.View;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class szj
  implements ausj.a
{
  szj(szh paramszh, MessageForDevLittleVideo paramMessageForDevLittleVideo, ShortVideoRealItemBuilder.a parama, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      this.val$actionSheet.dismiss();
      return;
    }
    boolean bool = aqiw.isNetworkAvailable(this.this$0.app.getApplication().getApplicationContext());
    paramView = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
    if (bool) {}
    for (paramInt = 1002;; paramInt = 1005)
    {
      paramView.videoFileStatus = paramInt;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress = 0;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.serial();
      this.this$0.app.b().c(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.frienduin, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.istroop, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.msgData);
      if (!bool) {
        break;
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$a.a.setFailedIconVisable(false, this.this$0);
      szh.a(this.this$0, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$a, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szj
 * JD-Core Version:    0.7.0.1
 */