import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

final class xme
  extends angu.a
{
  xme(MessageForShortVideo paramMessageForShortVideo, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView) {}
  
  public void a(int paramInt, angq paramangq)
  {
    if (paramangq.mResult == 0)
    {
      paramangq = (akxb.a)paramangq.en;
      this.jdField_b_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath = paramangq.bUF;
      ((MessageForReplyText)this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord).setSourceMessageRecord(this.jdField_b_of_type_ComTencentMobileqqDataMessageForShortVideo);
      ((MessageForReplyText)this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord).serial();
      this.val$app.b().c(this.jdField_b_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_b_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_b_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_b_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      xmb.b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbWidth, this.jdField_b_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbHeight, this.jdField_b_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath, this.jdField_b_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
      return;
    }
    QLog.d("ReplyTextItemBuilder", 2, "reply render get thumbPath Fail");
  }
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xme
 * JD-Core Version:    0.7.0.1
 */