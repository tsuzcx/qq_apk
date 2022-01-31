import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;

public class ctp
  implements Runnable
{
  public ctp(MessageHandler paramMessageHandler, long paramLong1, String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    long l1 = 480000L;
    long l2 = 3L - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Long == 0L) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.a().a(this.jdField_a_of_type_JavaLangString, 1001).hasReply) {
        break label105;
      }
    }
    label105:
    for (boolean bool = true;; bool = false)
    {
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Byte, bool, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, l1);
      return;
      l1 = l2 * 480000L / 3L - l2 * 2000L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ctp
 * JD-Core Version:    0.7.0.1
 */