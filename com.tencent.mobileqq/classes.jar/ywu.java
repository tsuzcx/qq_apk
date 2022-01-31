import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForApollo;

public final class ywu
  implements Runnable
{
  public ywu(MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.hasPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage.isPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.msgData = MessagePkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.msgData);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywu
 * JD-Core Version:    0.7.0.1
 */