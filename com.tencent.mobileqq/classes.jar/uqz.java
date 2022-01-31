import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppBabyQItemBubbleBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import java.util.ArrayList;

public class uqz
  implements DialogInterface.OnClickListener
{
  public uqz(ArkAppBabyQItemBubbleBuilder paramArkAppBabyQItemBubbleBuilder, MessageForArkBabyqReply paramMessageForArkBabyqReply) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (MessageForArkBabyqReply)MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkBabyqReply);
    if (paramDialogInterface.msgData == null) {
      if ((paramDialogInterface.mArkBabyqReplyCardList == null) || (paramDialogInterface.mArkBabyqReplyCardList.size() <= 0)) {
        ArkAppCenter.b("ArkApp", String.format("resendMessage, msgData and mArkBabyqReplyCardList are null", new Object[0]));
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQItemBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)
    {
      return;
      paramDialogInterface.msgData = paramDialogInterface.toBytes();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQItemBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQItemBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQItemBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkBabyqReply.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQItemBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDialogInterface, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uqz
 * JD-Core Version:    0.7.0.1
 */