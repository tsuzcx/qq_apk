import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class fcj
  extends Thread
{
  public fcj(FriendListHandler paramFriendListHandler, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  public void run()
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a.getManager(8);
    Friends localFriends = localFriendsManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a.a());
    localFriends.signature = this.jdField_a_of_type_JavaLangString;
    localFriendsManagerImp.a(localFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fcj
 * JD-Core Version:    0.7.0.1
 */