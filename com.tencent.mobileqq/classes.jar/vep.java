import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.os.MqqHandler;

public final class vep
  implements Runnable
{
  public vep(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, TextView paramTextView, String paramString2) {}
  
  public void run()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "");
    ThreadManager.getUIHandler().post(new veq(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vep
 * JD-Core Version:    0.7.0.1
 */