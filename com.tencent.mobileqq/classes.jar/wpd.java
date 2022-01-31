import com.tencent.mobileqq.activity.contact.newfriend.QIMFollowerAddBuilder;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.QIMFollowMessage;

public class wpd
  implements Runnable
{
  public wpd(QIMFollowerAddBuilder paramQIMFollowerAddBuilder) {}
  
  public void run()
  {
    ((NewFriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(((QIMFollowMessage)this.a.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new wpe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpd
 * JD-Core Version:    0.7.0.1
 */