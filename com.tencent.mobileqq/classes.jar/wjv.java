import com.tencent.mobileqq.activity.contact.newfriend.QIMNotifyAddFriendBuilder;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.QIMNotifyAddFriendMsg;

public class wjv
  implements Runnable
{
  public wjv(QIMNotifyAddFriendBuilder paramQIMNotifyAddFriendBuilder) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.b(((QIMNotifyAddFriendMsg)this.a.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new wjw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjv
 * JD-Core Version:    0.7.0.1
 */