import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class vel
  implements Runnable
{
  vel(vek paramvek, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
      for (;;)
      {
        this.jdField_a_of_type_Vek.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.a(this.jdField_a_of_type_Vek.jdField_a_of_type_Ver, this.jdField_a_of_type_Vek.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText, (MessageRecord)localObject);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMixedMsg))
        {
          localMessageRecord = (MessageRecord)((MessageForMixedMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgElemList.get(this.jdField_a_of_type_Vek.jdField_a_of_type_Int);
          localObject = localMessageRecord;
          if ((localMessageRecord instanceof MessageForPic)) {}
        }
        else
        {
          while (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForTroopFile))
          {
            MessageRecord localMessageRecord;
            localObject = null;
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("ChatItemBuilder", 2, "renderingPicCommentUI:source msg has been deleted.");
    }
    this.jdField_a_of_type_Vek.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder.a(this.jdField_a_of_type_Vek.jdField_a_of_type_Ver, this.jdField_a_of_type_Vek.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vel
 * JD-Core Version:    0.7.0.1
 */