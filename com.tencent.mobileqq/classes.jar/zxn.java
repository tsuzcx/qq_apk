import android.view.View;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

class zxn
  implements bhuk
{
  zxn(zxm paramzxm, MessageForPtt paramMessageForPtt, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Zxm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    paramView = null;
    if (this.jdField_a_of_type_Zxm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      paramView = azaf.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      ((MessageForPtt)paramView).fileSize = -3L;
      this.jdField_a_of_type_Zxm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView, this.jdField_a_of_type_Zxm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if (paramView != null)
    {
      if (!"device_groupchat".equals(paramView.extStr)) {
        break label256;
      }
      if ((!bdin.d(BaseApplication.getContext())) && ((paramView instanceof MessageForDevPtt)))
      {
        paramView = (MessageForDevPtt)paramView;
        paramView.fileSize = -1L;
        paramView.extraflag = 32768;
        paramView.extStr = "device_groupchat";
        paramView.serial();
        this.jdField_a_of_type_Zxm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.istroop, paramView.uniseq, paramView.msgData);
        this.jdField_a_of_type_Zxm.b();
        this.jdField_a_of_type_Bhuf.dismiss();
        return;
      }
      agoz.a(((ztp)this.jdField_a_of_type_Zxm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_Zxm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength), paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Zxm.b();
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
      label256:
      ((zxz)this.jdField_a_of_type_Zxm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(zxz.f, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, Long.parseLong(this.jdField_a_of_type_Zxm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), paramView.uniseq, paramView.istroop, (int)this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime / 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zxn
 * JD-Core Version:    0.7.0.1
 */