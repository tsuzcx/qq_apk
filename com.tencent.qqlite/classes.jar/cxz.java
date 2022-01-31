import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.Map;

class cxz
  implements Runnable
{
  cxz(cxy paramcxy) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager.a.b.containsKey(MsgProxyUtils.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager.a.b.remove(MsgProxyUtils.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cxz
 * JD-Core Version:    0.7.0.1
 */