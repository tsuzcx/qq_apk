import com.tencent.mobileqq.activity.aio.MessageShareActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

public class ulx
  implements Runnable
{
  public ulx(MessageShareActivity paramMessageShareActivity, AbsStructMsg paramAbsStructMsg, String paramString, int paramInt) {}
  
  public void run()
  {
    StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageShareActivity.app, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ulx
 * JD-Core Version:    0.7.0.1
 */