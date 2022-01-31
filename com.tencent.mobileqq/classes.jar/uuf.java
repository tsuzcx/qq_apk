import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppBabyQNoResultBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

public class uuf
  implements DialogInterface.OnClickListener
{
  public uuf(ArkAppBabyQNoResultBuilder paramArkAppBabyQNoResultBuilder, MessageForArkBabyqReply paramMessageForArkBabyqReply) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (MessageForArkBabyqReply)MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkBabyqReply);
    if (paramDialogInterface.msgData == null) {
      paramDialogInterface.msgData = paramDialogInterface.toBytes();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkBabyqReply.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDialogInterface, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uuf
 * JD-Core Version:    0.7.0.1
 */