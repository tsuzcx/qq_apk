import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.QQAppInterface;

public class zcd
  implements Runnable
{
  public zcd(HotChatShare paramHotChatShare, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcd
 * JD-Core Version:    0.7.0.1
 */