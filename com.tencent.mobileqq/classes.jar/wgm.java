import com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.PhoneContactAddMessage;

public class wgm
  implements Runnable
{
  public wgm(PhoneContactAddBuilder paramPhoneContactAddBuilder) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(((PhoneContactAddMessage)this.a.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new wgn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgm
 * JD-Core Version:    0.7.0.1
 */